package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class VirtualViewUtils
{
  private static RectF oval = new RectF();
  private static Path sPath = new Path();
  
  public static void clipCanvas(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    clipCanvas(paramCanvas, paramInt1, paramInt2, paramInt3, paramInt4, paramInt4, paramInt4, paramInt4);
  }
  
  public static void clipCanvas(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramCanvas == null) {
      return;
    }
    if (!isRounded(paramInt4, paramInt5, paramInt6, paramInt7)) {
      return;
    }
    float f2 = paramInt3;
    float f1 = f2 / 2.0F;
    sPath.reset();
    Object localObject = sPath;
    int j = 0;
    if (paramInt4 > 0) {
      i = paramInt4;
    } else {
      i = 0;
    }
    ((Path)localObject).moveTo(i + paramInt3, f2);
    localObject = sPath;
    int k = paramInt1 - paramInt3;
    if (paramInt5 > 0) {
      i = paramInt5;
    } else {
      i = 0;
    }
    ((Path)localObject).lineTo(k - i, f2);
    if (paramInt5 > 0)
    {
      localObject = oval;
      paramInt5 *= 2;
      ((RectF)localObject).set(paramInt1 - paramInt5, 0.0F, paramInt1, paramInt5);
      oval.offset(-f1, f1);
      sPath.arcTo(oval, 270.0F, 90.0F);
    }
    localObject = sPath;
    float f3 = k;
    int i = paramInt2 - paramInt3;
    if (paramInt7 > 0) {
      paramInt5 = paramInt7;
    } else {
      paramInt5 = 0;
    }
    ((Path)localObject).lineTo(f3, i - paramInt5);
    if (paramInt7 > 0)
    {
      localObject = oval;
      paramInt5 = paramInt7 * 2;
      ((RectF)localObject).set(paramInt1 - paramInt5, paramInt2 - paramInt5, paramInt1, paramInt2);
      localObject = oval;
      f3 = -f1;
      ((RectF)localObject).offset(f3, f3);
      sPath.arcTo(oval, 0.0F, 90.0F);
    }
    localObject = sPath;
    if (paramInt6 > 0) {
      paramInt1 = paramInt6;
    } else {
      paramInt1 = 0;
    }
    ((Path)localObject).lineTo(paramInt1 + paramInt3, i);
    if (paramInt6 > 0)
    {
      localObject = oval;
      paramInt1 = paramInt6 * 2;
      ((RectF)localObject).set(0.0F, paramInt2 - paramInt1, paramInt1, paramInt2);
      oval.offset(f1, -f1);
      sPath.arcTo(oval, 90.0F, 90.0F);
    }
    localObject = sPath;
    paramInt1 = j;
    if (paramInt4 > 0) {
      paramInt1 = paramInt4;
    }
    ((Path)localObject).lineTo(f2, paramInt3 + paramInt1);
    if (paramInt4 > 0)
    {
      localObject = oval;
      f2 = paramInt4 * 2;
      ((RectF)localObject).set(0.0F, 0.0F, f2, f2);
      oval.offset(f1, f1);
      sPath.arcTo(oval, 180.0F, 90.0F);
    }
    paramCanvas.clipPath(sPath);
  }
  
  public static void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramCanvas != null)
    {
      if (paramPaint == null) {
        return;
      }
      float f2 = paramInt3;
      float f1 = f2 / 2.0F;
      sPath.reset();
      Object localObject = sPath;
      int j = 0;
      if (paramInt4 > 0) {
        i = paramInt4;
      } else {
        i = 0;
      }
      ((Path)localObject).moveTo(i + paramInt3, f2);
      localObject = sPath;
      int k = paramInt1 - paramInt3;
      if (paramInt5 > 0) {
        i = paramInt5;
      } else {
        i = 0;
      }
      ((Path)localObject).lineTo(k - i, f2);
      if (paramInt5 > 0)
      {
        localObject = oval;
        paramInt5 *= 2;
        ((RectF)localObject).set(paramInt1 - paramInt5, 0.0F, paramInt1, paramInt5);
        oval.offset(-f1, f1);
        sPath.arcTo(oval, 270.0F, 90.0F);
      }
      localObject = sPath;
      float f3 = k;
      int i = paramInt2 - paramInt3;
      if (paramInt7 > 0) {
        paramInt5 = paramInt7;
      } else {
        paramInt5 = 0;
      }
      ((Path)localObject).lineTo(f3, i - paramInt5);
      if (paramInt7 > 0)
      {
        localObject = oval;
        paramInt5 = paramInt7 * 2;
        ((RectF)localObject).set(paramInt1 - paramInt5, paramInt2 - paramInt5, paramInt1, paramInt2);
        localObject = oval;
        f3 = -f1;
        ((RectF)localObject).offset(f3, f3);
        sPath.arcTo(oval, 0.0F, 90.0F);
      }
      localObject = sPath;
      if (paramInt6 > 0) {
        paramInt1 = paramInt6;
      } else {
        paramInt1 = 0;
      }
      ((Path)localObject).lineTo(paramInt1 + paramInt3, i);
      if (paramInt6 > 0)
      {
        localObject = oval;
        paramInt1 = paramInt6 * 2;
        ((RectF)localObject).set(0.0F, paramInt2 - paramInt1, paramInt1, paramInt2);
        oval.offset(f1, -f1);
        sPath.arcTo(oval, 90.0F, 90.0F);
      }
      localObject = sPath;
      paramInt1 = j;
      if (paramInt4 > 0) {
        paramInt1 = paramInt4;
      }
      ((Path)localObject).lineTo(f2, paramInt3 + paramInt1);
      if (paramInt4 > 0)
      {
        localObject = oval;
        f2 = paramInt4 * 2;
        ((RectF)localObject).set(0.0F, 0.0F, f2, f2);
        oval.offset(f1, f1);
        sPath.arcTo(oval, 180.0F, 90.0F);
      }
      paramCanvas.drawPath(sPath, paramPaint);
    }
  }
  
  public static void drawBorder(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramCanvas != null)
    {
      if (paramPaint == null) {
        return;
      }
      float f4 = paramInt3 / 2.0F;
      float f1;
      if (paramInt4 > 0) {
        f1 = paramInt4;
      } else {
        f1 = 0.0F;
      }
      float f2;
      if (paramInt6 > 0) {
        f2 = paramInt2 - paramInt6;
      } else {
        f2 = paramInt2;
      }
      paramCanvas.drawLine(f4, f1, f4, f2, paramPaint);
      if (paramInt4 > 0) {
        f1 = paramInt4;
      } else {
        f1 = 0.0F;
      }
      if (paramInt5 > 0) {
        f2 = paramInt1 - paramInt5;
      } else {
        f2 = paramInt1;
      }
      paramCanvas.drawLine(f1, f4, f2, f4, paramPaint);
      float f3 = paramInt1;
      float f5 = f3 - f4;
      if (paramInt5 > 0) {
        f1 = paramInt5;
      } else {
        f1 = 0.0F;
      }
      if (paramInt7 > 0) {
        f2 = paramInt2 - paramInt7;
      } else {
        f2 = paramInt2;
      }
      paramCanvas.drawLine(f5, f1, f5, f2, paramPaint);
      if (paramInt6 > 0) {
        f1 = paramInt6;
      } else {
        f1 = 0.0F;
      }
      f5 = paramInt2;
      float f6 = f5 - f4;
      if (paramInt7 > 0) {
        f2 = paramInt1 - paramInt7;
      } else {
        f2 = f3;
      }
      paramCanvas.drawLine(f1, f6, f2, f6, paramPaint);
      RectF localRectF;
      if (paramInt4 > 0)
      {
        localRectF = oval;
        f1 = paramInt4 * 2;
        localRectF.set(0.0F, 0.0F, f1, f1);
        oval.offset(f4, f4);
        paramCanvas.drawArc(oval, 180.0F, 90.0F, false, paramPaint);
      }
      if (paramInt5 > 0)
      {
        localRectF = oval;
        paramInt3 = paramInt5 * 2;
        localRectF.set(paramInt1 - paramInt3, 0.0F, f3, paramInt3);
        oval.offset(-f4, f4);
        paramCanvas.drawArc(oval, 270.0F, 90.0F, false, paramPaint);
      }
      if (paramInt7 > 0)
      {
        localRectF = oval;
        paramInt3 = paramInt7 * 2;
        localRectF.set(paramInt1 - paramInt3, paramInt2 - paramInt3, f3, f5);
        localRectF = oval;
        f1 = -f4;
        localRectF.offset(f1, f1);
        paramCanvas.drawArc(oval, 0.0F, 90.0F, false, paramPaint);
      }
      if (paramInt6 > 0)
      {
        localRectF = oval;
        paramInt1 = paramInt6 * 2;
        localRectF.set(0.0F, paramInt2 - paramInt1, paramInt1, f5);
        oval.offset(f4, -f4);
        paramCanvas.drawArc(oval, 90.0F, 90.0F, false, paramPaint);
      }
    }
  }
  
  private static boolean isRounded(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 > 0) || (paramInt2 > 0) || (paramInt3 > 0) || (paramInt4 > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils
 * JD-Core Version:    0.7.0.1
 */