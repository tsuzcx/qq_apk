package com.tencent.mobileqq.addon;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;

public class DiyPendantDrawable$DiyAddonSticker
  implements DiyPendantDrawable.Sticker
{
  double jdField_a_of_type_Double;
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  int c;
  int d;
  
  DiyPendantDrawable$DiyAddonSticker(DiyPendantDrawable paramDiyPendantDrawable, int paramInt1, double paramDouble, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Double = (0.0174532925199433D * paramDouble);
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt4;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable, this.d);
    if (localBitmap != null)
    {
      Rect localRect1 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.getBounds();
      int i = localRect1.width();
      int j = localRect1.height();
      i = (int)(i / 2 + Math.sin(this.jdField_a_of_type_Double) * this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.e);
      j = (int)(j / 2 - Math.cos(this.jdField_a_of_type_Double) * this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.e);
      int k = (int)(localBitmap.getWidth() * this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double);
      int m = (int)(localBitmap.getHeight() * this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double);
      this.jdField_a_of_type_AndroidGraphicsRect.set(i - k / 2, j - m / 2 + this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.c / 2, k / 2 + i, m / 2 + j + this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.c / 2);
      Rect localRect2;
      if (this.jdField_a_of_type_AndroidGraphicsRect.left < localRect1.left)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.right += localRect1.left - this.jdField_a_of_type_AndroidGraphicsRect.left;
        this.jdField_a_of_type_AndroidGraphicsRect.left = localRect1.left;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.top < localRect1.top)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.bottom += localRect1.top - this.jdField_a_of_type_AndroidGraphicsRect.top;
        this.jdField_a_of_type_AndroidGraphicsRect.top = localRect1.top;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.right > localRect1.right)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.left += localRect1.right - this.jdField_a_of_type_AndroidGraphicsRect.right;
        this.jdField_a_of_type_AndroidGraphicsRect.right = localRect1.right;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.bottom > localRect1.bottom)
      {
        localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect2.top += localRect1.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        this.jdField_a_of_type_AndroidGraphicsRect.bottom = localRect1.bottom;
      }
      paramCanvas.drawBitmap(localBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, paramPaint);
      if (QLog.isColorLevel()) {
        QLog.d("DiyPendantDrawable", 2, "draw sticker index = " + this.d + "scaleFactor=" + this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double + ", x=" + i + ", y=" + j + ", w=" + k + ", h=" + m);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left + 5, this.jdField_a_of_type_AndroidGraphicsRect.top + 5, this.jdField_a_of_type_AndroidGraphicsRect.right - 5, this.jdField_a_of_type_AndroidGraphicsRect.bottom - 5);
        f = AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaLangString);
        if (this.jdField_b_of_type_Int != 1) {
          break label662;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, f, this.c, this.jdField_b_of_type_AndroidGraphicsRect.width(), this.jdField_b_of_type_AndroidGraphicsRect.height(), paramPaint);
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, null, this.jdField_b_of_type_AndroidGraphicsRect, paramPaint);
        }
      }
    }
    return;
    label662:
    paramPaint = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (paramPaint != null) {
      this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setTypeface(paramPaint);
    }
    this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setColor(this.c);
    this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setTextSize(f);
    paramPaint = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.getFontMetrics();
    float f = (this.jdField_b_of_type_AndroidGraphicsRect.bottom + this.jdField_b_of_type_AndroidGraphicsRect.top - paramPaint.bottom - paramPaint.top) / 2.0F;
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidGraphicsRect.centerX(), f, this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantDrawable.DiyAddonSticker
 * JD-Core Version:    0.7.0.1
 */