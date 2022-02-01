package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import java.io.File;

public final class ARPromotionConstant
{
  public static String a = "_model.zip";
  
  public static String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ARResouceDir.a());
    ((StringBuilder)localObject).append("ar_cloud_marker_model/");
    ((StringBuilder)localObject).append(8);
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".nomedia");
    ARResouceDir.a(localStringBuilder.toString());
    return localObject;
  }
  
  public static String b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ARResouceDir.a());
    ((StringBuilder)localObject).append("ar_cloud_transfer/");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".nomedia");
    ARResouceDir.a(localStringBuilder.toString());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionConstant
 * JD-Core Version:    0.7.0.1
 */