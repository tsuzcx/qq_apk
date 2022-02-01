package com.tencent.common.wormhole;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mtt.hippy.utils.ContextHolder;

public class PixelUtil
{
  static DisplayMetrics a;
  
  public static float a(float paramFloat)
  {
    return paramFloat / a().density + 0.5F;
  }
  
  private static DisplayMetrics a()
  {
    if (a == null) {
      a = ContextHolder.getAppContext().getResources().getDisplayMetrics();
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.PixelUtil
 * JD-Core Version:    0.7.0.1
 */