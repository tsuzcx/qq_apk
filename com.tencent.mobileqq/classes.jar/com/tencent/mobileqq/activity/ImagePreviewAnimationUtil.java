package com.tencent.mobileqq.activity;

import android.graphics.Rect;

public class ImagePreviewAnimationUtil
{
  public static float a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 641.0F) || (paramInt2 > 641.0F)) {
      return Math.min(641.0F / paramInt1, 641.0F / paramInt2);
    }
    return 1.0F;
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
    }
    while (paramInt1 < paramInt2) {
      return localRect;
    }
    localRect.bottom = paramInt4;
    localRect.right = ((int)(f * paramInt4));
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
    paramRect.bottom = ((int)(paramRect.bottom * paramFloat));
  }
  
  public static Rect b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 * paramInt3 / paramInt1;
    if (paramInt1 >= paramInt3) {
      if (paramInt4 >= i)
      {
        i = 17;
        paramInt3 = 0;
        paramInt4 = 0;
      }
    }
    for (;;)
    {
      if (i == 17) {}
      for (;;)
      {
        return new Rect(0, 0, paramInt1, paramInt2);
        if ((paramInt4 * 1.5F >= i) && (i > paramInt4))
        {
          i = 17;
          paramInt3 = 0;
          paramInt4 = 0;
          break;
        }
        if (i <= 1.5D * paramInt4) {
          break label190;
        }
        float f = paramInt3 / paramInt1;
        paramInt3 = (int)(paramInt4 / f);
        i = 48;
        paramInt4 = paramInt1;
        break;
        if (paramInt2 < paramInt4)
        {
          i = 17;
          paramInt3 = 0;
          paramInt4 = 0;
          break;
        }
        if ((paramInt2 > paramInt4) && (paramInt2 < paramInt4 * 1.5F))
        {
          i = 17;
          paramInt3 = 0;
          paramInt4 = 0;
          break;
        }
        if (paramInt2 <= paramInt4 * 1.5F) {
          break label190;
        }
        int j = 48;
        i = paramInt1;
        paramInt3 = paramInt4;
        paramInt4 = i;
        i = j;
        break;
        paramInt1 = paramInt4;
        paramInt2 = paramInt3;
      }
      label190:
      i = 17;
      paramInt3 = 0;
      paramInt4 = 0;
    }
  }
  
  public static Rect c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 1.0F;
    int i = paramInt2 * paramInt3 / paramInt1;
    int j;
    if (paramInt1 >= paramInt3) {
      if (paramInt4 >= i)
      {
        f = paramInt3 / paramInt1;
        paramInt2 = (int)(paramInt2 * f);
        j = 17;
        paramInt1 = paramInt3;
        i = 0;
      }
    }
    for (;;)
    {
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      if (j == 17) {
        localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
      }
      while ((j != 48) || (i == 0))
      {
        return localRect;
        if ((paramInt4 * 1.5F >= i) && (i > paramInt4))
        {
          f = paramInt4 / paramInt2;
          paramInt1 = (int)(paramInt1 * f);
          j = 17;
          paramInt2 = paramInt4;
          i = 0;
          break;
        }
        if (i <= 1.5D * paramInt4) {
          break label272;
        }
        f = paramInt3 / paramInt1;
        j = 48;
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        i = 0;
        break;
        if (paramInt2 < paramInt4)
        {
          i = 0;
          j = 17;
          break;
        }
        if ((paramInt2 > paramInt4) && (paramInt2 < paramInt4 * 1.5F))
        {
          f = paramInt4 / paramInt2;
          paramInt1 = (int)(paramInt1 * f);
          j = 17;
          paramInt2 = paramInt4;
          i = 0;
          break;
        }
        if (paramInt2 <= paramInt4 * 1.5F) {
          break label272;
        }
        i = 1;
        j = 48;
        paramInt2 = paramInt4;
        break;
      }
      localRect.offset((int)(paramInt3 - f * paramInt1) / 2, 0);
      return localRect;
      label272:
      i = 0;
      j = 17;
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ImagePreviewAnimationUtil
 * JD-Core Version:    0.7.0.1
 */