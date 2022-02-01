package com.tencent.aelight.camera.aeeditor.record;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterInfoCache;
import com.tencent.aelight.camera.aeeditor.module.imagetemplate.ImageTemplateControlListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AEEditorImageRecord
  extends AEEditorBaseRecord
{
  protected static AEEditorImageRecord a;
  protected static byte[] a;
  public static final String b = "AEEditorImageRecord";
  private SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AEEditorRecordDataManager jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  public static AEEditorImageRecord a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorImageRecord == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorImageRecord == null) {
          jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorImageRecord = new AEEditorImageRecord();
        }
      }
    }
    return jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorImageRecord;
  }
  
  public void a()
  {
    AEEditorRecordDataManager localAEEditorRecordDataManager = this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager;
    if ((localAEEditorRecordDataManager != null) && (localAEEditorRecordDataManager.b())) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.b();
    }
  }
  
  public void a(Intent paramIntent, ArrayList<String> paramArrayList)
  {
    paramIntent.putExtra("key_qcircle_publish_back_edit", this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.b());
    if (paramArrayList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.b())
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (!((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.get(i, Boolean.valueOf(false))).booleanValue()) {
          paramArrayList.set(i, this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public void a(ImageTemplateControlListener paramImageTemplateControlListener, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.a() != 2) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.a() != 1)) {
      return;
    }
    if (((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, Boolean.valueOf(false))).booleanValue()) {
      return;
    }
    JSONObject localJSONObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.a(paramInt);
    if (localJSONObject != null) {
      try
      {
        Object localObject = localJSONObject.optJSONObject("crop");
        if (localObject != null) {
          a(paramImageTemplateControlListener, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONObject("filter");
        if (localObject != null) {
          b(paramImageTemplateControlListener, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONObject("preseg");
        if (localObject != null) {
          c(paramImageTemplateControlListener, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONObject("frame");
        if (localObject != null) {
          a(paramImageTemplateControlListener, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, (JSONObject)localObject, paramInt);
        }
        localObject = localJSONObject.optJSONArray("sticker");
        if (localObject != null) {
          a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, (JSONArray)localObject, paramInt);
        }
        localJSONObject = localJSONObject.optJSONObject("template");
        if (localJSONObject != null) {
          b(paramImageTemplateControlListener, localJSONObject, paramInt);
        }
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.updateAndRenderTemplate(paramInt, false, new AEEditorImageRecord.1(this, paramInt));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Boolean.valueOf(true));
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
      paramJSONObject = new CropConfig((float)paramJSONObject.optDouble("crop_x"), (float)paramJSONObject.optDouble("crop_y"), (float)paramJSONObject.optDouble("crop_w"), (float)paramJSONObject.optDouble("crop_h"));
      if (paramImageTemplateControlListener != null)
      {
        paramImageTemplateControlListener.a(paramJSONObject, paramInt);
        return;
      }
    }
    catch (Exception paramImageTemplateControlListener)
    {
      AEQLog.a(b, paramImageTemplateControlListener);
    }
  }
  
  public void a(TAVCutImageSession paramTAVCutImageSession, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = paramTAVCutImageSession;
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("key_qcircle_publish_out_imagepath");
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager = AEEditorRecordDataManager.a();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.a.size() == 0) {
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.a(paramArrayList, this.jdField_a_of_type_JavaUtilArrayList);
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
        List localList = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels();
        if (localList != null) {}
        try
        {
          if (localList.size() > 0)
          {
            i = 0;
            Object localObject2 = paramList;
            Object localObject1 = paramImageFilterInfoCache;
            if (i < localList.size())
            {
              Object localObject3 = (MediaModel)localList.get(i);
              if (localObject3 == null) {
                break label715;
              }
              JSONObject localJSONObject1 = new JSONObject();
              if ((localObject2 != null) && (paramList.size() > i))
              {
                j = ((AEEditorImageInfo)((List)localObject2).get(i)).c;
                f1 = ((AEEditorImageInfo)((List)localObject2).get(i)).a.getX();
                f2 = ((AEEditorImageInfo)((List)localObject2).get(i)).a.getY();
                float f3 = ((AEEditorImageInfo)((List)localObject2).get(i)).a.getWidth();
                float f4 = ((AEEditorImageInfo)((List)localObject2).get(i)).a.getHeight();
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("crop_type", j);
                ((JSONObject)localObject2).put("crop_x", f1);
                ((JSONObject)localObject2).put("crop_y", f2);
                ((JSONObject)localObject2).put("crop_w", f3);
                ((JSONObject)localObject2).put("crop_h", f4);
                localJSONObject1.put("crop", localObject2);
              }
              Object localObject4 = ((MediaModel)localObject3).getMediaTemplateModel().getAutomaticMediaTemplateModel();
              if (localObject4 != null)
              {
                localObject2 = ((AutomaticMediaTemplateModel)localObject4).getTemplateDir();
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localObject4 = ((AutomaticMediaTemplateModel)localObject4).getAEFrameModel().getId();
                  localObject5 = new JSONObject();
                  ((JSONObject)localObject5).put("id", localObject4);
                  ((JSONObject)localObject5).put("dir", localObject2);
                  localJSONObject1.put("frame", localObject5);
                }
              }
              localObject2 = ((MediaModel)localObject3).getMediaEffectModel();
              localObject3 = a(((MediaEffectModel)localObject2).getStickerModelList());
              int j = ((JSONArray)localObject3).length();
              if (j > 0) {
                localJSONObject1.put("sticker", localObject3);
              }
              Object localObject5 = ((MediaEffectModel)localObject2).getAeKitModel();
              if (localObject5 == null) {
                break label712;
              }
              float f1 = ((AEKitModel)localObject5).getEffectStrength();
              localObject3 = ((AEKitModel)localObject5).getLutPath();
              float f2 = ((AEKitModel)localObject5).getGlowAlpha();
              ((AEKitModel)localObject5).getAdjustParams();
              localObject4 = ((AEKitModel)localObject5).getMaterial();
              localObject5 = ((AEKitModel)localObject5).getOverlayImgPath();
              JSONObject localJSONObject2 = new JSONObject();
              if (localObject1 != null) {
                localJSONObject2.putOpt("filter_id", ((ImageFilterInfoCache)localObject1).b(i));
              }
              localJSONObject2.put("effectStrength", f1);
              localJSONObject2.put("lutPath", localObject3);
              localJSONObject2.put("glowStrength", f2);
              localJSONObject2.put("materialPath", localObject4);
              localJSONObject2.put("overlayImgPath", localObject5);
              localJSONObject1.put("filter", localJSONObject2);
              localObject1 = ((MediaEffectModel)localObject2).getPreSegModel();
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
              break label715;
            }
          }
          ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putLong("key_ae_editor_record_type", 1L, 0);
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager.a(paramArrayList1, paramArrayList2, localJSONArray, this.jdField_a_of_type_AndroidUtilSparseArray, paramInt);
          return;
        }
        catch (Exception paramArrayList1) {}
        AEQLog.a(b, paramArrayList1);
      }
      catch (Exception paramArrayList1) {}
      return;
      label712:
      continue;
      label715:
      i += 1;
    }
  }
  
  public void b()
  {
    AEEditorRecordDataManager localAEEditorRecordDataManager = this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager;
    if (localAEEditorRecordDataManager != null) {
      localAEEditorRecordDataManager.c();
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
      float f = (float)paramJSONObject.optDouble("effectStrength");
      String str2 = paramJSONObject.optString("lutPath");
      paramTAVCutImageSession.updateTemplateAEKitModel(paramInt, f, str2, (float)paramJSONObject.optDouble("glowStrength"), null, paramJSONObject.optString("materialPath"));
      if (paramImageTemplateControlListener != null)
      {
        paramImageTemplateControlListener.a(str1, str2, f);
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
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorRecordDataManager != null)
    {
      AEEditorRecordDataManager.e();
      jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorImageRecord = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorImageRecord
 * JD-Core Version:    0.7.0.1
 */