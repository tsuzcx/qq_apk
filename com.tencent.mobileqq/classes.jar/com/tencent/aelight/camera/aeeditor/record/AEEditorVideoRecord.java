package com.tencent.aelight.camera.aeeditor.record;

import android.os.Bundle;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightMediaTemplateModel;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class AEEditorVideoRecord
  extends AEEditorBaseRecord
{
  private static AEEditorVideoRecord jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorVideoRecord;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  public static final String b = "AEEditorVideoRecord";
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static AEEditorVideoRecord a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorVideoRecord == null) {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorVideoRecord == null) {
          jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorVideoRecord = new AEEditorVideoRecord();
        }
      }
    }
    return jdField_a_of_type_ComTencentAelightCameraAeeditorRecordAEEditorVideoRecord;
  }
  
  public void a()
  {
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record", "", 0);
  }
  
  public void a(IVideoOnRestore paramIVideoOnRestore)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_record", "", 0);
    }
    else
    {
      if (AEEditorRecordDataManager.a().a() != 2) {
        return;
      }
      localObject1 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_ae_editor_record_mid", "", 0);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).optJSONObject("crop");
        if (localObject2 != null) {
          a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, (JSONObject)localObject2, paramIVideoOnRestore);
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("filter");
        if (localObject2 != null) {
          b(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, (JSONObject)localObject2, paramIVideoOnRestore);
        }
        localObject2 = ((JSONObject)localObject1).optJSONArray("sticker");
        if (localObject2 != null) {
          a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, (JSONArray)localObject2);
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("template");
        if (localObject1 != null)
        {
          c(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, (JSONObject)localObject1, paramIVideoOnRestore);
          return;
        }
      }
      catch (Exception paramIVideoOnRestore)
      {
        AEQLog.a(b, paramIVideoOnRestore);
      }
    }
  }
  
  public void a(TAVCutVideoSession paramTAVCutVideoSession, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = paramTAVCutVideoSession;
    if (paramBundle != null) {
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_qcircle_publish_back_edit", false);
    }
  }
  
  public void a(TAVCutVideoSession paramTAVCutVideoSession, JSONArray paramJSONArray)
  {
    try
    {
      paramJSONArray = a(paramJSONArray).iterator();
      while (paramJSONArray.hasNext())
      {
        StickerModel localStickerModel = (StickerModel)paramJSONArray.next();
        if (localStickerModel != null) {
          paramTAVCutVideoSession.addSticker(localStickerModel);
        }
      }
      return;
    }
    catch (Exception paramTAVCutVideoSession)
    {
      AEQLog.a(b, paramTAVCutVideoSession);
    }
  }
  
  public void a(TAVCutVideoSession paramTAVCutVideoSession, JSONObject paramJSONObject, IVideoOnRestore paramIVideoOnRestore)
  {
    try
    {
      paramJSONObject = (MediaResourceModel)a(paramJSONObject, "mediaresource", MediaResourceModel.class);
      if (paramJSONObject != null)
      {
        paramTAVCutVideoSession.getMediaModel().setMediaResourceModel(paramJSONObject);
        paramTAVCutVideoSession.updateTemplateComposition(true);
        return;
      }
    }
    catch (Exception paramTAVCutVideoSession)
    {
      AEQLog.a(b, paramTAVCutVideoSession);
    }
  }
  
  public void a(List<?> paramList, HashMap<String, LocalMediaInfo> paramHashMap, String paramString1, String paramString2, int paramInt)
  {
    if (paramList != null)
    {
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
        return;
      }
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        MediaModel localMediaModel = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel();
        Object localObject1 = localMediaModel.getMediaEffectModel();
        Object localObject2 = ((MediaEffectModel)localObject1).getAeKitModel();
        if (localObject2 != null)
        {
          float f1 = ((AEKitModel)localObject2).getEffectStrength();
          String str1 = ((AEKitModel)localObject2).getLutPath();
          float f2 = ((AEKitModel)localObject2).getGlowAlpha();
          ((AEKitModel)localObject2).getAdjustParams();
          String str2 = ((AEKitModel)localObject2).getMaterial();
          localObject2 = ((AEKitModel)localObject2).getOverlayImgPath();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("effectStrength", f1);
          localJSONObject2.put("lutPath", str1);
          localJSONObject2.put("glowStrength", f2);
          localJSONObject2.put("materialPath", str2);
          localJSONObject2.put("overlayImgPath", localObject2);
          localJSONObject2.put("filter_id", paramString2);
          localJSONObject1.put("filter", localJSONObject2);
        }
        paramString2 = a(((MediaEffectModel)localObject1).getStickerModelList());
        if (paramString2.length() > 0) {
          localJSONObject1.put("sticker", paramString2);
        }
        paramString2 = localMediaModel.getMediaTemplateModel();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getLightMediaTemplateModel();
          if (paramString2 != null)
          {
            paramString2 = new File(paramString2.getFilePath());
            if (paramString2.exists())
            {
              paramString2 = paramString2.getParent();
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("dir", paramString2);
              ((JSONObject)localObject1).put("template_id", paramString1);
              localJSONObject1.put("template", localObject1);
            }
          }
        }
        paramString1 = localMediaModel.getMediaResourceModel();
        if (paramString1 != null)
        {
          paramString2 = new JSONObject();
          a(paramString2, "mediaresource", paramString1);
          localJSONObject1.put("crop", paramString2);
        }
        if (paramInt == 2)
        {
          ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record", localJSONObject1.toString(), 0);
          LocalMultiProcConfig.putInt4Uin("_qq_circle_publish_draft_from", 1, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        }
        else
        {
          ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_mid", localJSONObject1.toString(), 0);
          LocalMultiProcConfig.putInt4Uin("_qq_circle_publish_draft_from", 2, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        }
        paramString1 = new JSONObject();
        a(paramString1, "mediaList", paramList);
        a(paramString1, "mediaInfoMap", paramHashMap);
        ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putLong("key_ae_editor_record_type", 2L, 0);
        ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_files", paramString1.toString(), 0);
        return;
      }
      catch (Exception paramList)
      {
        AEQLog.a(b, paramList);
      }
    }
  }
  
  public void b()
  {
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_ae_editor_record_mid", "", 0);
  }
  
  public void b(TAVCutVideoSession paramTAVCutVideoSession, JSONObject paramJSONObject, IVideoOnRestore paramIVideoOnRestore)
  {
    try
    {
      paramTAVCutVideoSession.resetAEKitModel((float)paramJSONObject.optDouble("effectStrength"), paramJSONObject.optString("lutPath"), (float)paramJSONObject.optDouble("glowStrength"), null, paramJSONObject.optString("materialPath"));
      paramIVideoOnRestore.a(paramJSONObject.optString("filter_id"));
      return;
    }
    catch (Exception paramTAVCutVideoSession)
    {
      AEQLog.a(b, paramTAVCutVideoSession);
    }
  }
  
  public void c(TAVCutVideoSession paramTAVCutVideoSession, JSONObject paramJSONObject, IVideoOnRestore paramIVideoOnRestore)
  {
    try
    {
      paramTAVCutVideoSession = paramJSONObject.optString("dir");
      if (!TextUtils.isEmpty(paramTAVCutVideoSession))
      {
        MetaMaterial localMetaMaterial = new MetaMaterial();
        localMetaMaterial.id = paramJSONObject.optString("template_id");
        localMetaMaterial.additionalFields = new HashMap();
        localMetaMaterial.additionalFields.put("packagePath", paramTAVCutVideoSession);
        paramIVideoOnRestore.b(localMetaMaterial);
        return;
      }
    }
    catch (Exception paramTAVCutVideoSession)
    {
      AEQLog.a(b, paramTAVCutVideoSession);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorVideoRecord
 * JD-Core Version:    0.7.0.1
 */