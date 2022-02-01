package com.tencent.aelight.camera.ae;

import android.os.Build;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;

public class AEPath
  extends AEPathBase
{
  private static final String f;
  private static final String g;
  private static final String h;
  private static final String i;
  private static final String j;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/DCIM/Video/");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append(HardCodeUtil.a(2131700831));
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append(HardCodeUtil.a(2131700832));
    h = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Camera/Video/");
    i = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/DCIM/Camera/");
    j = localStringBuilder.toString();
  }
  
  public static String a()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      return g;
    }
    if ((!str.contains("MX4")) && (!str.contains("MX6")) && (!str.contains("MX5")) && (!str.contains("M355")) && (!str.contains("M571C")))
    {
      if (str.contains("M040")) {
        return i;
      }
      if ((!str.contains("VIVO X7")) && (!str.contains("VIVO X6A")) && (!str.contains("VIVO XPLAY6")) && (!str.contains("VIVO X5PRO")) && (!str.contains("VIVO X9 PLUS")) && (!str.contains("VIVO Y51A")) && (!str.contains("VIVO X9I")) && (!str.contains("VIVO X9")) && (!str.contains("VIVO X6D"))) {
        return j;
      }
      return h;
    }
    return f;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    File localFile = new File(localStringBuilder.toString());
    paramString = localStringBuilder;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (paramString = localStringBuilder;; paramString = new StringBuilder(paramString))
    {
      paramString.append(VidUtil.generateVid());
      paramString.append(".mp4");
      if (!new File(paramString.toString()).exists()) {
        return paramString.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPath
 * JD-Core Version:    0.7.0.1
 */