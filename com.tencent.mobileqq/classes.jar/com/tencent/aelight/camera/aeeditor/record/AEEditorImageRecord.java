package com.tencent.aelight.camera.aeeditor.record;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache;
import com.tencent.aelight.camera.aeeditor.module.imagetemplate.ImageTemplateControlListener;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AEEditorImageRecord
  extends AEEditorBaseRecord
{
  public static final String b = "AEEditorImageRecord";
  protected static byte[] c = new byte[1];
  protected static AEEditorImageRecord d;
  private TAVCutImageSession e;
  private SparseArray<Boolean> f = new SparseArray();
  private ArrayList<String> g;
  private AEEditorRecordDataManager h;
  
  private Matrix a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length == 9))
      {
        Matrix localMatrix = new Matrix();
        float[] arrayOfFloat = new float[9];
        int i = 0;
        while (i < 9)
        {
          arrayOfFloat[i] = Float.parseFloat(paramString[i]);
          i += 1;
        }
        localMatrix.setValues(arrayOfFloat);
        return localMatrix;
      }
    }
    catch (Exception paramString)
    {
      AEQLog.a(b, paramString);
    }
    return null;
  }
  
  public static AEEditorImageRecord a()
  {
    if (d == null) {
      synchronized (c)
      {
        if (d == null) {
          d = new AEEditorImageRecord();
        }
      }
    }
    return d;
  }
  
  private String a(Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      return "";
    }
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = new StringBuffer();
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      if (i > 0) {
        paramMatrix.append(",");
      }
      paramMatrix.append(arrayOfFloat[i]);
      i += 1;
    }
    return paramMatrix.toString();
  }
  
  public void a(Intent paramIntent, ArrayList<String> paramArrayList)
  {
    AEEditorRecordDataManager localAEEditorRecordDataManager = this.h;
    if (localAEEditorRecordDataManager == null) {
      return;
    }
    paramIntent.putExtra("key_qcircle_publish_back_edit", localAEEditorRecordDataManager.k());
    if (paramArrayList == null) {
      return;
    }
    if (this.g == null) {
      return;
    }
    if (this.h.k())
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (!((Boolean)this.f.get(i, Boolean.valueOf(false))).booleanValue()) {
          paramArrayList.set(i, this.g.get(i));
        }
        i += 1;
      }
    }
  }
  
  public void a(ImageTemplateControlListener paramImageTemplateControlListener, int paramInt)
  {
    if (this.e == null) {
      return;
    }
    if ((this.h.d() != 2) && (this.h.d() != 1)) {
      return;
    }
    if (((Boolean)this.f.get(paramInt, Boolean.valueOf(false))).booleanValue()) {
      return;
    }
    JSONObject localJSONObject = this.h.b(paramInt);
    if (localJSONObject != null) {
      try
      {
        Object localObject = localJSONObject.optJSONObject("crop");
        if (localObject != null) {
          a(paramImageTemplateControlListener, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONObject("filter");
        if (localObject != null) {
          b(paramImageTemplateControlListener, this.e, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONObject("preseg");
        if (localObject != null) {
          c(paramImageTemplateControlListener, this.e, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONObject("frame");
        if (localObject != null) {
          a(paramImageTemplateControlListener, this.e, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONArray("sticker");
        if (localObject != null) {
          a(this.e, (JSONArray)localObject, paramInt);
        }
        localJSONObject = localJSONObject.optJSONObject("template");
        if (localJSONObject != null) {
          b(paramImageTemplateControlListener, localJSONObject, paramInt);
        }
        this.e.updateAndRenderTemplate(paramInt, false, new AEEditorImageRecord.1(this, paramInt));
        this.f.put(paramInt, Boolean.valueOf(true));
        return;
      }
      catch (Exception paramImageTemplateControlListener)
      {
        AEQLog.a(b, paramImageTemplateControlListener);
      }
    }
  }
  
  public void a(ImageTemplateControlListener paramImageTemplateControlListener, TAVCutImageSession paramTAVCutImageSession, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      String str1 = paramJSONObject.optString("id");
      String str2 = paramJSONObject.optString("frameColor");
      paramJSONObject = paramJSONObject.optString("dir");
      if ((!TextUtils.isEmpty(str1)) && (new File(paramJSONObject).exists()))
      {
        if (TextUtils.isEmpty(str2)) {
          paramTAVCutImageSession.updateTemplateFrame(paramInt, paramJSONObject);
        } else {
          paramTAVCutImageSession.updateTemplateFrame(paramInt, paramJSONObject, String.valueOf(Color.parseColor(str2)));
        }
        if (paramImageTemplateControlListener != null)
        {
          paramImageTemplateControlListener.b(str1, str2);
          return;
        }
      }
    }
    catch (Exception paramImageTemplateControlListener)
    {
      AEQLog.a(b, paramImageTemplateControlListener);
    }
  }
  
  public void a(ImageTemplateControlListener paramImageTemplateControlListener, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      paramInt = paramJSONObject.optInt("crop_type");
      float f1 = (float)paramJSONObject.optDouble("crop_x");
      float f2 = (float)paramJSONObject.optDouble("crop_y");
      float f3 = (float)paramJSONObject.optDouble("crop_w");
      float f4 = (float)paramJSONObject.optDouble("crop_h");
      paramJSONObject = a(paramJSONObject.optString("crop_matrix"));
      CropConfig localCropConfig = new CropConfig(f1, f2, f3, f4);
      if (paramImageTemplateControlListener != null)
      {
        paramImageTemplateControlListener.a(localCropConfig, paramInt, paramJSONObject);
        return;
      }
    }
    catch (Exception paramImageTemplateControlListener)
    {
      AEQLog.a(b, paramImageTemplateControlListener);
    }
  }
  
  public void a(TAVCutImageSession paramTAVCutImageSession, Bundle paramBundle, ArrayList<String> paramArrayList, AEEditorTextViewModel paramAEEditorTextViewModel, AEEditorStickerViewModel paramAEEditorStickerViewModel)
  {
    super.a(paramAEEditorTextViewModel, paramAEEditorStickerViewModel);
    this.e = paramTAVCutImageSession;
    this.g = paramBundle.getStringArrayList("key_qcircle_publish_out_imagepath");
    this.h = AEEditorRecordDataManager.a();
    if (this.h.b.size() == 0) {
      this.g = null;
    }
    this.h.a(paramArrayList, this.g);
  }
  
  public void a(TAVCutImageSession paramTAVCutImageSession, JSONArray paramJSONArray, int paramInt)
  {
    try
    {
      paramJSONArray = a(paramJSONArray);
      if (paramJSONArray.size() > 0)
      {
        paramTAVCutImageSession.addSticker(paramInt, paramJSONArray, false);
        return;
      }
    }
    catch (Exception paramTAVCutImageSession)
    {
      AEQLog.a(b, paramTAVCutImageSession);
    }
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ImageFilterInfoCache paramImageFilterInfoCache, SparseArray<String> paramSparseArray, List<AEEditorImageInfo> paramList, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        List localList = this.e.getMediaModels();
        if (localList != null) {}
        try
        {
          if (localList.size() > 0)
          {
            i = 0;
            Object localObject3 = paramList;
            Object localObject2 = this;
            Object localObject1 = paramImageFilterInfoCache;
            if (i < localList.size())
            {
              Object localObject4 = (MediaModel)localList.get(i);
              if (localObject4 == null) {
                break label751;
              }
              JSONObject localJSONObject1 = new JSONObject();
              if ((localObject3 != null) && (paramList.size() > i))
              {
                j = ((AEEditorImageInfo)((List)localObject3).get(i)).e;
                f1 = ((AEEditorImageInfo)((List)localObject3).get(i)).d.getX();
                f2 = ((AEEditorImageInfo)((List)localObject3).get(i)).d.getY();
                float f3 = ((AEEditorImageInfo)((List)localObject3).get(i)).d.getWidth();
                float f4 = ((AEEditorImageInfo)((List)localObject3).get(i)).d.getHeight();
                localObject5 = new JSONObject();
                ((JSONObject)localObject5).put("crop_type", j);
                ((JSONObject)localObject5).put("crop_x", f1);
                ((JSONObject)localObject5).put("crop_y", f2);
                ((JSONObject)localObject5).put("crop_w", f3);
                ((JSONObject)localObject5).put("crop_h", f4);
                ((JSONObject)localObject5).put("crop_matrix", ((AEEditorImageRecord)localObject2).a(((AEEditorImageInfo)((List)localObject3).get(i)).a()));
                localJSONObject1.put("crop", localObject5);
              }
              Object localObject5 = ((MediaModel)localObject4).getMediaTemplateModel().getAutomaticMediaTemplateModel();
              if (localObject5 != null)
              {
                localObject3 = ((AutomaticMediaTemplateModel)localObject5).getTemplateDir();
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject5 = ((AutomaticMediaTemplateModel)localObject5).getAEFrameModel().getId();
                  localJSONObject2 = new JSONObject();
                  localJSONObject2.put("id", localObject5);
                  localJSONObject2.put("dir", localObject3);
                  localJSONObject1.put("frame", localJSONObject2);
                }
              }
              localObject3 = ((MediaModel)localObject4).getMediaEffectModel();
              localObject2 = ((AEEditorImageRecord)localObject2).a(((MediaEffectModel)localObject3).getStickerModelList());
              int j = ((JSONArray)localObject2).length();
              if (j > 0) {
                localJSONObject1.put("sticker", localObject2);
              }
              localObject5 = ((MediaEffectModel)localObject3).getAeKitModel();
              if (localObject5 == null) {
                break label748;
              }
              float f1 = ((AEKitModel)localObject5).getEffectStrength();
              localObject2 = ((AEKitModel)localObject5).getLutPath();
              float f2 = ((AEKitModel)localObject5).getGlowAlpha();
              ((AEKitModel)localObject5).getAdjustParams();
              localObject4 = ((AEKitModel)localObject5).getMaterial();
              localObject5 = ((AEKitModel)localObject5).getOverlayImgPath();
              JSONObject localJSONObject2 = new JSONObject();
              if (localObject1 != null) {
                localJSONObject2.putOpt("filter_id", ((ImageFilterInfoCache)localObject1).j(i));
              }
              localJSONObject2.put("effectStrength", f1);
              localJSONObject2.put("lutPath", localObject2);
              localJSONObject2.put("glowStrength", f2);
              localJSONObject2.put("materialPath", localObject4);
              localJSONObject2.put("overlayImgPath", localObject5);
              localJSONObject1.put("filter", localJSONObject2);
              localObject1 = ((MediaEffectModel)localObject3).getPreSegModel();
              if ((localObject1 != null) && (!TextUtils.isEmpty(((PreSegModel)localObject1).getSegMaterial())))
              {
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("dir", ((PreSegModel)localObject1).getSegMaterial());
                localJSONObject1.put("preseg", localObject2);
              }
              if (!TextUtils.isEmpty((CharSequence)paramSparseArray.get(i)))
              {
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).putOpt("template_id", paramSparseArray.get(i));
                localJSONObject1.put("template", localObject1);
              }
              localJSONArray.put(localJSONObject1);
              break label751;
            }
          }
          ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putLong("key_ae_editor_record_type", 1L, 0);
          this.h.a(paramArrayList1, paramArrayList2, localJSONArray, this.f, paramInt);
          return;
        }
        catch (Exception paramArrayList1) {}
        AEQLog.a(b, paramArrayList1);
      }
      catch (Exception paramArrayList1) {}
      return;
      label748:
      continue;
      label751:
      i += 1;
    }
  }
  
  public void b()
  {
    AEEditorRecordDataManager localAEEditorRecordDataManager = this.h;
    if ((localAEEditorRecordDataManager != null) && (localAEEditorRecordDataManager.k())) {
      this.h.g();
    }
  }
  
  public void b(ImageTemplateControlListener paramImageTemplateControlListener, TAVCutImageSession paramTAVCutImageSession, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      String str1 = paramJSONObject.optString("overlayImgPath");
      if (!TextUtils.isEmpty(str1))
      {
        paramTAVCutImageSession.setOverlayImage(paramInt, str1);
        return;
      }
      str1 = paramJSONObject.optString("filter_id");
      float f1 = (float)paramJSONObject.optDouble("effectStrength");
      String str2 = paramJSONObject.optString("lutPath");
      paramTAVCutImageSession.updateTemplateAEKitModel(paramInt, f1, str2, (float)paramJSONObject.optDouble("glowStrength"), null, paramJSONObject.optString("materialPath"));
      if (paramImageTemplateControlListener != null)
      {
        paramImageTemplateControlListener.a(str1, str2, f1);
        return;
      }
    }
    catch (Exception paramImageTemplateControlListener)
    {
      AEQLog.a(b, paramImageTemplateControlListener);
    }
  }
  
  public void b(ImageTemplateControlListener paramImageTemplateControlListener, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString("template_id");
      if ((!TextUtils.isEmpty(paramJSONObject)) && (paramImageTemplateControlListener != null))
      {
        paramImageTemplateControlListener.a(paramJSONObject);
        return;
      }
    }
    catch (Exception paramImageTemplateControlListener)
    {
      AEQLog.a(b, paramImageTemplateControlListener);
    }
  }
  
  public void c()
  {
    AEEditorRecordDataManager localAEEditorRecordDataManager = this.h;
    if (localAEEditorRecordDataManager != null) {
      localAEEditorRecordDataManager.h();
    }
  }
  
  public void c(ImageTemplateControlListener paramImageTemplateControlListener, TAVCutImageSession paramTAVCutImageSession, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      paramImageTemplateControlListener = paramJSONObject.optString("dir");
      if ((!TextUtils.isEmpty(paramImageTemplateControlListener)) && (new File(paramImageTemplateControlListener).exists()))
      {
        paramTAVCutImageSession.applyPreSeg(paramInt, paramImageTemplateControlListener);
        return;
      }
    }
    catch (Exception paramImageTemplateControlListener)
    {
      AEQLog.a(b, paramImageTemplateControlListener);
    }
  }
  
  public void d()
  {
    if (this.h != null)
    {
      AEEditorRecordDataManager.j();
      d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorImageRecord
 * JD-Core Version:    0.7.0.1
 */