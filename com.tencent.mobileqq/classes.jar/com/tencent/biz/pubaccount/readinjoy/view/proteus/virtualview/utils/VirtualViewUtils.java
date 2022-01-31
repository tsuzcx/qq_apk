package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class VirtualViewUtils
{
  private static Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private static RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  
  public static void a(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if ((paramCanvas == null) || (paramPaint == null)) {
      return;
    }
    float f3 = paramInt3 / 2.0F;
    float f1;
    label26:
    label38:
    label61:
    label73:
    float f4;
    if (paramInt4 > 0)
    {
      f1 = paramInt4;
      if (paramInt6 <= 0) {
        break label386;
      }
      f2 = paramInt2 - paramInt6;
      paramCanvas.drawLine(f3, f1, f3, f2, paramPaint);
      if (paramInt4 <= 0) {
        break label393;
      }
      f1 = paramInt4;
      if (paramInt5 <= 0) {
        break label399;
      }
      f2 = paramInt1 - paramInt5;
      paramCanvas.drawLine(f1, f3, f2, f3, paramPaint);
      f4 = paramInt1;
      if (paramInt5 <= 0) {
        break label406;
      }
      f1 = paramInt5;
      label100:
      float f5 = paramInt1;
      if (paramInt7 <= 0) {
        break label412;
      }
      f2 = paramInt2 - paramInt7;
      label116:
      paramCanvas.drawLine(f4 - f3, f1, f5 - f3, f2, paramPaint);
      if (paramInt6 <= 0) {
        break label419;
      }
      f1 = paramInt6;
      label145:
      f4 = paramInt2;
      if (paramInt7 <= 0) {
        break label425;
      }
    }
    label386:
    label393:
    label399:
    label406:
    label412:
    label419:
    label425:
    for (float f2 = paramInt1 - paramInt7;; f2 = paramInt1)
    {
      paramCanvas.drawLine(f1, f4 - f3, f2, paramInt2 - f3, paramPaint);
      if (paramInt4 > 0)
      {
        jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt4 * 2, paramInt4 * 2);
        jdField_a_of_type_AndroidGraphicsRectF.offset(f3, f3);
        paramCanvas.drawArc(jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 90.0F, false, paramPaint);
      }
      if (paramInt5 > 0)
      {
        jdField_a_of_type_AndroidGraphicsRectF.set(paramInt1 - paramInt5 * 2, 0.0F, paramInt1, paramInt5 * 2);
        jdField_a_of_type_AndroidGraphicsRectF.offset(-f3, f3);
        paramCanvas.drawArc(jdField_a_of_type_AndroidGraphicsRectF, 270.0F, 90.0F, false, paramPaint);
      }
      if (paramInt7 > 0)
      {
        jdField_a_of_type_AndroidGraphicsRectF.set(paramInt1 - paramInt7 * 2, paramInt2 - paramInt7 * 2, paramInt1, paramInt2);
        jdField_a_of_type_AndroidGraphicsRectF.offset(-f3, -f3);
        paramCanvas.drawArc(jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 90.0F, false, paramPaint);
      }
      if (paramInt6 <= 0) {
        break;
      }
      jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, paramInt2 - paramInt6 * 2, paramInt6 * 2, paramInt2);
      jdField_a_of_type_AndroidGraphicsRectF.offset(f3, -f3);
      paramCanvas.drawArc(jdField_a_of_type_AndroidGraphicsRectF, 90.0F, 90.0F, false, paramPaint);
      return;
      f1 = 0.0F;
      break label26;
      f2 = paramInt2;
      break label38;
      f1 = 0.0F;
      break label61;
      f2 = paramInt1;
      break label73;
      f1 = 0.0F;
      break label100;
      f2 = paramInt2;
      break label116;
      f1 = 0.0F;
      break label145;
    }
  }
  
  public static void b(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if ((paramCanvas == null) || (paramPaint == null)) {
      return;
    }
    float f1 = paramInt3 / 2.0F;
    jdField_a_of_type_AndroidGraphicsPath.reset();
    Path localPath = jdField_a_of_type_AndroidGraphicsPath;
    int i;
    label64:
    float f2;
    if (paramInt4 > 0)
    {
      i = paramInt4;
      localPath.moveTo(i + paramInt3, paramInt3);
      localPath = jdField_a_of_type_AndroidGraphicsPath;
      if (paramInt5 <= 0) {
        break label388;
      }
      i = paramInt5;
      localPath.lineTo(paramInt1 - paramInt3 - i, paramInt3);
      if (paramInt5 > 0)
      {
        jdField_a_of_type_AndroidGraphicsRectF.set(paramInt1 - paramInt5 * 2, 0.0F, paramInt1, paramInt5 * 2);
        jdField_a_of_type_AndroidGraphicsRectF.offset(-f1, f1);
        jdField_a_of_type_AndroidGraphicsPath.arcTo(jdField_a_of_type_AndroidGraphicsRectF, 270.0F, 90.0F);
      }
      localPath = jdField_a_of_type_AndroidGraphicsPath;
      f2 = paramInt1 - paramInt3;
      if (paramInt7 <= 0) {
        break label394;
      }
      paramInt5 = paramInt7;
      label151:
      localPath.lineTo(f2, paramInt2 - paramInt3 - paramInt5);
      if (paramInt7 > 0)
      {
        jdField_a_of_type_AndroidGraphicsRectF.set(paramInt1 - paramInt7 * 2, paramInt2 - paramInt7 * 2, paramInt1, paramInt2);
        jdField_a_of_type_AndroidGraphicsRectF.offset(-f1, -f1);
        jdField_a_of_type_AndroidGraphicsPath.arcTo(jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 90.0F);
      }
      localPath = jdField_a_of_type_AndroidGraphicsPath;
      if (paramInt6 <= 0) {
        break label400;
      }
      paramInt1 = paramInt6;
      label232:
      localPath.lineTo(paramInt1 + paramInt3, paramInt2 - paramInt3);
      if (paramInt6 > 0)
      {
        jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, paramInt2 - paramInt6 * 2, paramInt6 * 2, paramInt2);
        jdField_a_of_type_AndroidGraphicsRectF.offset(f1, -f1);
        jdField_a_of_type_AndroidGraphicsPath.arcTo(jdField_a_of_type_AndroidGraphicsRectF, 90.0F, 90.0F);
      }
      localPath = jdField_a_of_type_AndroidGraphicsPath;
      f2 = paramInt3;
      if (paramInt4 <= 0) {
        break label405;
      }
    }
    label388:
    label394:
    label400:
    label405:
    for (paramInt1 = paramInt4;; paramInt1 = 0)
    {
      localPath.lineTo(f2, paramInt1 + paramInt3);
      if (paramInt4 > 0)
      {
        jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt4 * 2, paramInt4 * 2);
        jdField_a_of_type_AndroidGraphicsRectF.offset(f1, f1);
        jdField_a_of_type_AndroidGraphicsPath.arcTo(jdField_a_of_type_AndroidGraphicsRectF, 180.0F, 90.0F);
      }
      paramCanvas.drawPath(jdField_a_of_type_AndroidGraphicsPath, paramPaint);
      return;
      i = 0;
      break;
      i = 0;
      break label64;
      paramInt5 = 0;
      break label151;
      paramInt1 = 0;
      break label232;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils
 * JD-Core Version:    0.7.0.1
 */