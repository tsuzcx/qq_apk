package com.tencent.common;

import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;

public class GifUtil
{
  static
  {
    try
    {
      ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
      System.load(new File(FeatureManager.getSoDir(), "libgiflossy.so").getPath());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load libgiflossy.so fail, msg = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GifUtil", 4, localStringBuilder.toString());
    }
  }
  
  public static native int compressGif(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.GifUtil
 * JD-Core Version:    0.7.0.1
 */