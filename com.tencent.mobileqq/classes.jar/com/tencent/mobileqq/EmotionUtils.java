package com.tencent.mobileqq;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class EmotionUtils
{
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.EmotionUtils
 * JD-Core Version:    0.7.0.1
 */