package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.DisplayMetrics;

@TargetApi(14)
public class TakeVideoUtils
{
  private static int a;
  private static int b;
  private static float c;
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static int a(Resources paramResources)
  {
    if (a == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      a = paramResources.widthPixels;
      b = paramResources.heightPixels;
      c = b * 1.0F / a;
    }
    return a;
  }
  
  public static float b(Resources paramResources)
  {
    if ((b == 0) || (a == 0))
    {
      paramResources = paramResources.getDisplayMetrics();
      a = paramResources.widthPixels;
      b = paramResources.heightPixels;
      c = b * 1.0F / a;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.TakeVideoUtils
 * JD-Core Version:    0.7.0.1
 */