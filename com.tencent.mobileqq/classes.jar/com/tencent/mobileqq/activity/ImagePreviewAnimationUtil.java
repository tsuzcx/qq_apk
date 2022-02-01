package com.tencent.mobileqq.activity;

import android.graphics.Rect;

public class ImagePreviewAnimationUtil
{
  public static float a(int paramInt1, int paramInt2)
  {
    float f = paramInt1;
    if ((f <= 641.0F) && (paramInt2 <= 641.0F)) {
      return 1.0F;
    }
    return Math.min(641.0F / f, 641.0F / paramInt2);
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.left = 0;
    localRect.top = 0;
    float f = paramInt1 * 1.0F / paramInt2;
    if (paramInt1 < paramInt2)
    {
      localRect.right = paramInt3;
      localRect.bottom = ((int)(paramInt3 * 1.0F / f));
      return localRect;
    }
    if (paramInt1 >= paramInt2)
    {
      localRect.bottom = paramInt4;
      localRect.right = ((int)(paramInt4 * f));
    }
    return localRect;
  }
  
  public static Rect a(Rect paramRect1, Rect paramRect2)
  {
    return new Rect(Math.min(paramRect1.left, paramRect2.left), Math.min(paramRect1.top, paramRect2.top), Math.max(paramRect1.right, paramRect2.right), Math.max(paramRect1.bottom, paramRect2.bottom));
  }
  
  public static void a(Rect paramRect, float paramFloat)
  {
    paramRect.left = ((int)(paramRect.left * paramFloat));
    paramRect.right = ((int)(paramRect.right * paramFloat));
    paramRect.top = ((int)(paramRect.top * paramFloat));
    paramRect.bottom = ((int)(paramFloat * paramRect.bottom));
  }
  
  public static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt2 * paramInt3 / paramInt1;
    int i = 48;
    if (paramInt1 >= paramInt3)
    {
      if (paramInt4 < j)
      {
        float f = paramInt4;
        if ((1.5F * f < j) || (j <= paramInt4))
        {
          double d1 = j;
          double d2 = paramInt4;
          Double.isNaN(d2);
          if (d1 > d2 * 1.5D)
          {
            paramInt4 = (int)(f / (paramInt3 / paramInt1));
            break label136;
          }
        }
      }
    }
    else {
      if (paramInt2 >= paramInt4) {
        break label106;
      }
    }
    label106:
    while (((paramInt2 > paramInt4) && (paramInt2 < paramInt4 * 1.5F)) || (paramInt2 <= paramInt4 * 1.5F))
    {
      paramInt4 = 0;
      paramInt3 = 0;
      i = 17;
      break;
    }
    label136:
    paramInt3 = paramInt1;
    if (i != 17)
    {
      paramInt2 = paramInt4;
      paramInt1 = paramInt3;
    }
    return new Rect(0, 0, paramInt1, paramInt2);
  }
  
  public static Rect c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 * paramInt3 / paramInt1;
    float f1;
    int k;
    int j;
    if (paramInt1 >= paramInt3)
    {
      if (paramInt4 >= i)
      {
        f1 = paramInt3 / paramInt1;
        paramInt1 = (int)(paramInt2 * f1);
        paramInt2 = paramInt3;
      }
      for (i = 17;; i = 48)
      {
        k = 0;
        j = i;
        i = k;
        break label239;
        f1 = paramInt4;
        if ((1.5F * f1 >= i) && (i > paramInt4))
        {
          f1 /= paramInt2;
          break;
        }
        double d1 = i;
        double d2 = paramInt4;
        Double.isNaN(d2);
        if (d1 <= d2 * 1.5D) {
          break label231;
        }
        f1 = paramInt3 / paramInt1;
        paramInt2 = paramInt3;
        paramInt1 = paramInt4;
      }
    }
    if (paramInt2 < paramInt4)
    {
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      j = 17;
      k = 0;
      paramInt1 = i;
      i = k;
      for (;;)
      {
        f1 = 1.0F;
        break label239;
        if (paramInt2 > paramInt4)
        {
          f1 = paramInt2;
          float f2 = paramInt4;
          if (f1 < f2 * 1.5F)
          {
            f1 = f2 / f1;
            paramInt2 = (int)(paramInt1 * f1);
            paramInt1 = paramInt4;
            break;
          }
        }
        if (paramInt2 <= paramInt4 * 1.5F) {
          break label231;
        }
        k = paramInt4;
        j = 48;
        i = 1;
        paramInt2 = paramInt1;
        paramInt1 = k;
      }
      label231:
      paramInt2 = 0;
      i = 0;
    }
    label239:
    Rect localRect = new Rect(0, 0, paramInt2, paramInt1);
    if (j == 17)
    {
      localRect.offset((paramInt3 - paramInt2) / 2, (paramInt4 - paramInt1) / 2);
      return localRect;
    }
    if ((j == 48) && (i != 0)) {
      localRect.offset((int)(paramInt3 - paramInt2 * f1) / 2, 0);
    }
    return localRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ImagePreviewAnimationUtil
 * JD-Core Version:    0.7.0.1
 */