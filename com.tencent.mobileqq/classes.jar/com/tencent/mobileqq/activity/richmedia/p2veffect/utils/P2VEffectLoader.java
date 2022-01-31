package com.tencent.mobileqq.activity.richmedia.p2veffect.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import xuq;
import xur;
import xus;

public class P2VEffectLoader
{
  private static P2VEffectLoader jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader;
  private static String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vEffectUrl", "http://d3g.qq.com/sngapp/app/update/20180319162123_1828/p2v_effect.jar");
  private static String b = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vEffectJarMD5", "f46b795a00826a0ae12250591da7b9d9");
  private static String c = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vMaterialUrl", "http://d3g.qq.com/sngapp/app/update/20180124144756_2643/p2v_material.zip");
  private static String d = QzoneConfig.getInstance().getConfig("QZoneSetting", "p2vMaterialMD5", "f61e9058b09761852fda262a13c353fc");
  private boolean jdField_a_of_type_Boolean;
  
  public static P2VEffectLoader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader = new P2VEffectLoader();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectUtilsP2VEffectLoader;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      P2VGlobalConfig.P2V_VIDEO_ROOT = Environment.getExternalStorageDirectory().toString() + File.separator + "qzone_dynamic_video" + File.separator;
    }
    for (P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "dynamic_video_cache" + File.separator;; P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT = paramContext.getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator + "dynamic_video_cache" + File.separator)
    {
      P2VGlobalConfig.NO_AUDIO_MP4 = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "no_audio.mp4";
      P2VGlobalConfig.CONCAT_FINAL_MP3 = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "concat_final.mp3";
      P2VGlobalConfig.P2V_MATERIAL_ROOT = P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + "p2v_material" + File.separator;
      P2VGlobalConfig.P2V_MATERIAL_WATER_MARKER_PNG_NAME = P2VGlobalConfig.P2V_MATERIAL_ROOT + "qzone_p2v_watermark.png";
      P2VGlobalConfig.P2V_MATERIAL_DUMMY_VIDEO_NAME = P2VGlobalConfig.P2V_MATERIAL_ROOT + "resizeddummy.mp4";
      try
      {
        paramContext = new File(P2VGlobalConfig.P2V_VIDEO_ROOT);
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        paramContext = new File(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT);
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          QLog.d("P2VEffectLoader", 2, "initP2VCacheRootSpace exception", paramContext);
        }
      }
      com.tencent.mobileqq.utils.FileUtils.c(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT + ".nomedia");
      com.tencent.mobileqq.utils.FileUtils.c(P2VGlobalConfig.P2V_MATERIAL_ROOT + ".nomedia");
      return;
      P2VGlobalConfig.P2V_VIDEO_ROOT = paramContext.getFilesDir().getAbsolutePath() + File.separator + "qzone_dynamic_video" + File.separator;
    }
  }
  
  private boolean a()
  {
    String str = LocalMultiProcConfig.getString("p2v_effect_jar_md5", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(b)) {
      return true;
    }
    return false;
  }
  
  private boolean b()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("p2v_effect.jar");
    QZLog.i("P2VEffectLoader", 4, new Object[] { "isP2VJarExit p2vJarDownload path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  private boolean c()
  {
    String str = LocalMultiProcConfig.getString("p2v_effect_material_md5", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(d)) {
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("p2v_material.zip");
    QZLog.i("P2VEffectLoader", 4, new Object[] { "isP2VMaterialExit p2vMaterialDownload path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  public void a(P2VEffectLoader.P2VEffectDownloadListener paramP2VEffectDownloadListener)
  {
    b(new xuq(this, paramP2VEffectDownloadListener));
  }
  
  public void a(ClassLoader paramClassLoader)
  {
    QZLog.i("P2VEffectLoader", "loadP2VModule");
    if (b())
    {
      QZLog.i("P2VEffectLoader", 4, new Object[] { "p2vModulePath=", QzoneModuleManager.getInstance().getModuleFilePath("p2v_effect.jar") });
      this.jdField_a_of_type_Boolean = QzoneModuleManager.getInstance().loadModule("p2v_effect.jar", paramClassLoader, false, false);
      if (this.jdField_a_of_type_Boolean) {
        QZLog.i("P2VEffectLoader", "loadP2VModule success");
      }
    }
    else
    {
      return;
    }
    QZLog.i("P2VEffectLoader", "loadP2VModule fail");
  }
  
  public boolean a(String paramString)
  {
    QZLog.i("P2VEffectLoader", "unzipP2VMaterialModule");
    if (TextUtils.isEmpty(paramString)) {
      QZLog.e("P2VEffectLoader", "unzipP2VMaterialModule - unzipPath is empty !");
    }
    do
    {
      return false;
      paramString = new File(paramString);
      if (paramString.exists())
      {
        if (!paramString.isDirectory())
        {
          QZLog.e("P2VEffectLoader", "unzip folder path is not a directory");
          return false;
        }
        if (!cooperation.qzone.util.FileUtils.a(paramString)) {
          QZLog.e("P2VEffectLoader", "Failed to remove existed unzip root folder");
        }
      }
      boolean bool = paramString.mkdirs();
      com.tencent.mobileqq.utils.FileUtils.c(paramString + File.separator + ".nomedia");
      if (!bool)
      {
        QZLog.e("P2VEffectLoader", "Failed to make the unzip root folder");
        return false;
      }
    } while (!d());
    String str = QzoneModuleManager.getInstance().getModuleFilePath("p2v_material.zip");
    QZLog.i("P2VEffectLoader", 4, new Object[] { "p2vMaterialPath=", str });
    if (cooperation.qzone.util.FileUtils.b(new File(str), paramString))
    {
      QZLog.i("P2VEffectLoader", "unzipP2VMaterialModule success");
      return true;
    }
    QZLog.i("P2VEffectLoader", "unzipP2VMaterialModule fail");
    return false;
  }
  
  public void b(P2VEffectLoader.P2VEffectDownloadListener paramP2VEffectDownloadListener)
  {
    if (paramP2VEffectDownloadListener == null) {
      return;
    }
    if ((a()) || (!b())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramP2VEffectDownloadListener.a(true);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("p2v_effect.jar", new xur(this, paramP2VEffectDownloadListener));
  }
  
  public void c(P2VEffectLoader.P2VEffectDownloadListener paramP2VEffectDownloadListener)
  {
    if (paramP2VEffectDownloadListener == null) {
      return;
    }
    if ((c()) || (!d())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramP2VEffectDownloadListener.a(true);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("p2v_material.zip", new xus(this, paramP2VEffectDownloadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader
 * JD-Core Version:    0.7.0.1
 */