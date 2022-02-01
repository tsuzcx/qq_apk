package com.tencent.biz.pubaccount.readinjoy.view.ucrop.util;

import android.graphics.RectF;

public class RectUtils
{
  public static RectF a(float[] paramArrayOfFloat)
  {
    RectF localRectF = new RectF((1.0F / 1.0F), (1.0F / 1.0F), (1.0F / -1.0F), (1.0F / -1.0F));
    int i = 1;
    if (i < paramArrayOfFloat.length)
    {
      float f2 = Math.round(paramArrayOfFloat[(i - 1)] * 10.0F) / 10.0F;
      float f1 = Math.round(paramArrayOfFloat[i] * 10.0F) / 10.0F;
      float f3;
      if (f2 < localRectF.left)
      {
        f3 = f2;
        label71:
        localRectF.left = f3;
        if (f1 >= localRectF.top) {
          break label145;
        }
        f3 = f1;
        label89:
        localRectF.top = f3;
        if (f2 <= localRectF.right) {
          break label154;
        }
        label105:
        localRectF.right = f2;
        if (f1 <= localRectF.bottom) {
          break label163;
        }
      }
      for (;;)
      {
        localRectF.bottom = f1;
        i += 2;
        break;
        f3 = localRectF.left;
        break label71;
        label145:
        f3 = localRectF.top;
        break label89;
        label154:
        f2 = localRectF.right;
        break label105;
        label163:
        f1 = localRectF.bottom;
      }
    }
    localRectF.sort();
    return localRectF;
  }
  
  public static float[] a(RectF paramRectF)
  {
    return new float[] { paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.top, paramRectF.right, paramRectF.bottom, paramRectF.left, paramRectF.bottom };
  }
  
  public static float[] a(float[] paramArrayOfFloat)
  {
    return new float[] { (float)Math.sqrt(Math.pow(paramArrayOfFloat[0] - paramArrayOfFloat[2], 2.0D) + Math.pow(paramArrayOfFloat[1] - paramArrayOfFloat[3], 2.0D)), (float)Math.sqrt(Math.pow(paramArrayOfFloat[2] - paramArrayOfFloat[4], 2.0D) + Math.pow(paramArrayOfFloat[3] - paramArrayOfFloat[5], 2.0D)) };
  }
  
  public static float[] b(RectF paramRectF)
  {
    return new float[] { paramRectF.centerX(), paramRectF.centerY() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.util.RectUtils
 * JD-Core Version:    0.7.0.1
 */