package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import java.io.File;

public final class ARPromotionConstant
{
  public static String a = "_model.zip";
  
  public static String a()
  {
    String str = ARResouceDir.a() + "ar_cloud_marker_model/" + 8 + File.separator;
    ARResouceDir.a(str + ".nomedia");
    return str;
  }
  
  public static String b()
  {
    String str = ARResouceDir.a() + "ar_cloud_transfer/";
    ARResouceDir.a(str + ".nomedia");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionConstant
 * JD-Core Version:    0.7.0.1
 */