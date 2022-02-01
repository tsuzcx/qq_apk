package com.tencent.mobileqq.activity.richmedia.p2veffect.utils;

import android.content.Context;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class P2VEffectLoader
{
  private static P2VEffectLoader b;
  private boolean a = false;
  
  public static void a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qzone_dynamic_video");
    localStringBuilder.append(File.separator);
    P2VGlobalConfig.P2V_VIDEO_ROOT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("dynamic_video_cache");
    localStringBuilder.append(File.separator);
    P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT = localStringBuilder.toString();
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT);
    paramContext.append("no_audio.mp4");
    P2VGlobalConfig.NO_AUDIO_MP4 = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT);
    paramContext.append("concat_final.m4a");
    P2VGlobalConfig.CONCAT_FINAL_M4A = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT);
    paramContext.append("concat_final.mp3");
    P2VGlobalConfig.CONCAT_FINAL_MP3 = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT);
    paramContext.append("p2v_material");
    paramContext.append(File.separator);
    P2VGlobalConfig.P2V_MATERIAL_ROOT = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_MATERIAL_ROOT);
    paramContext.append("qzone_p2v_watermark.png");
    P2VGlobalConfig.P2V_MATERIAL_WATER_MARKER_PNG_NAME = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_MATERIAL_ROOT);
    paramContext.append("resizeddummy.mp4");
    P2VGlobalConfig.P2V_MATERIAL_DUMMY_VIDEO_NAME = paramContext.toString();
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
      QLog.d("P2VEffectLoader", 2, "initP2VCacheRootSpace exception", paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_VIDEO_CACHE_ROOT);
    paramContext.append(".nomedia");
    FileUtils.createFileIfNotExits(paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append(P2VGlobalConfig.P2V_MATERIAL_ROOT);
    paramContext.append(".nomedia");
    FileUtils.createFileIfNotExits(paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.utils.P2VEffectLoader
 * JD-Core Version:    0.7.0.1
 */