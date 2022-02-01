package com.tencent.aelight.camera.ae.cmshow.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.cmshow.AECMShowResourceManager;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.ttpic.util.GsonUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AECMShowConfigManager
{
  public static final Type a = new AECMShowConfigManager.1().getType();
  public static final Type b = new AECMShowConfigManager.2().getType();
  
  @Nullable
  public static AECMShowConfig a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (AECMShowConfig)GsonUtils.json2Obj(paramString, a);
  }
  
  public static AECMShowConfigManager a()
  {
    return AECMShowConfigManager.InstanceHolder.a;
  }
  
  public int a()
  {
    return AECameraPrefsUtil.a().a("KEY_CMSHOW_IMG_MAX_LENGTH", 763, 0);
  }
  
  @NonNull
  public HashMap<String, AEEditorDownloadResBean> a()
  {
    Object localObject = AECameraPrefsUtil.a().a("KEY_CMSHOW_PRE_DOWNLOAD_RES_INFO", "", 0);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return AECMShowConfig.DEFAULT_RES_INFO_MAP;
    }
    localObject = (HashMap)GsonUtils.json2Obj((String)localObject, b);
    if ((localObject != null) && (((HashMap)localObject).size() >= 2)) {
      return localObject;
    }
    return AECMShowConfig.DEFAULT_RES_INFO_MAP;
  }
  
  public void a(@Nullable AECMShowConfig paramAECMShowConfig)
  {
    if (paramAECMShowConfig == null) {
      return;
    }
    Object localObject = AECMShowConfig.convert2DownloadBeanMap(paramAECMShowConfig);
    if (localObject != null)
    {
      AECameraPrefsUtil.a().a("KEY_CMSHOW_PRE_DOWNLOAD_RES_INFO", GsonUtils.obj2Json(localObject, b), 0);
      localObject = new LinkedList();
      ((List)localObject).add("video_limishow_base");
      AECMShowResourceManager.a().a((List)localObject, null);
    }
    if (paramAECMShowConfig.requestConfig != null)
    {
      if (paramAECMShowConfig.requestConfig.imgMaxLength > 0) {
        AECameraPrefsUtil.a().a("KEY_CMSHOW_IMG_MAX_LENGTH", paramAECMShowConfig.requestConfig.imgMaxLength, 0);
      }
      if ((paramAECMShowConfig.requestConfig.imgQuality > 0.0F) && (paramAECMShowConfig.requestConfig.imgQuality <= 1.0F)) {
        AECameraPrefsUtil.a().a("KEY_CMSHOW_IMG_QUALITY", paramAECMShowConfig.requestConfig.imgQuality, 0);
      }
    }
  }
  
  public int b()
  {
    float f2 = AECameraPrefsUtil.a().a("KEY_CMSHOW_IMG_QUALITY", 0.9F, 0);
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = 0.9F;
    }
    return (int)(f1 * 100.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.config.AECMShowConfigManager
 * JD-Core Version:    0.7.0.1
 */