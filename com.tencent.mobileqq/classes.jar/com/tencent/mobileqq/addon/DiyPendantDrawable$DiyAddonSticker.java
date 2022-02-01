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
    this.jdField_a_of_type_Double = (paramDouble * 0.0174532925199433D);
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt4;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable, this.d);
    if (localObject != null)
    {
      Rect localRect1 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.getBounds();
      int i = localRect1.width();
      int j = localRect1.height();
      double d1 = i / 2;
      double d2 = Math.sin(this.jdField_a_of_type_Double);
      double d3 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.d;
      Double.isNaN(d3);
      Double.isNaN(d1);
      i = (int)(d1 + d2 * d3);
      d1 = j / 2;
      d2 = Math.cos(this.jdField_a_of_type_Double);
      d3 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.d;
      Double.isNaN(d3);
      Double.isNaN(d1);
      j = (int)(d1 - d2 * d3);
      d1 = ((Bitmap)localObject).getWidth();
      d2 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double;
      Double.isNaN(d1);
      int k = (int)(d1 * d2);
      d1 = ((Bitmap)localObject).getHeight();
      d2 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double;
      Double.isNaN(d1);
      int m = (int)(d1 * d2);
      Rect localRect2 = this.jdField_a_of_type_AndroidGraphicsRect;
      int n = k / 2;
      int i1 = m / 2;
      localRect2.set(i - n, j - i1 + this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.c / 2, n + i, i1 + j + this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.c / 2);
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
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_a_of_type_AndroidGraphicsRect, paramPaint);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("draw sticker index = ");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append("scaleFactor=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double);
        ((StringBuilder)localObject).append(", x=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", y=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", w=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(", h=");
        ((StringBuilder)localObject).append(m);
        QLog.d("DiyPendantDrawable", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        i = (int)(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double * 10.0D);
        this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left + i, this.jdField_a_of_type_AndroidGraphicsRect.top + i, this.jdField_a_of_type_AndroidGraphicsRect.right - i, this.jdField_a_of_type_AndroidGraphicsRect.bottom - i);
        float f = AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaLangString);
        boolean bool;
        if (this.jdField_b_of_type_Int == 1)
        {
          localObject = new Paint();
          ((Paint)localObject).setTextSize(f);
          i = (int)((Paint)localObject).measureText(this.jdField_a_of_type_JavaLangString);
          d1 = f;
          d2 = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_Double;
          Double.isNaN(d1);
          j = (int)Math.min(d1 + d2 * 10.0D, this.jdField_b_of_type_AndroidGraphicsRect.height());
          localObject = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, f, this.c, i, j, paramPaint);
          if (localObject != null)
          {
            i = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
            j = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
            this.jdField_b_of_type_AndroidGraphicsRect.set(i - ((Bitmap)localObject).getWidth() / 2, j - ((Bitmap)localObject).getHeight() / 2, i + ((Bitmap)localObject).getWidth() / 2, j + ((Bitmap)localObject).getHeight() / 2);
            paramCanvas.drawBitmap((Bitmap)localObject, null, this.jdField_b_of_type_AndroidGraphicsRect, paramPaint);
          }
          if (QLog.isColorLevel())
          {
            bool = true;
            paramCanvas = new StringBuilder();
            paramCanvas.append("draw textInfo text = ");
            paramCanvas.append(this.jdField_a_of_type_JavaLangString);
            paramCanvas.append(" fontId = ");
            paramCanvas.append(this.jdField_a_of_type_Int);
            paramCanvas.append(" fontType = ");
            paramCanvas.append(1);
            paramCanvas.append(" color = ");
            paramCanvas.append(this.c);
            paramCanvas.append(" fontBitmap Existed = ");
            paramCanvas.append(localObject);
            if (paramCanvas.toString() == null) {
              bool = false;
            }
            QLog.d("DiyPendantDrawable", 2, new Object[] { Boolean.valueOf(bool) });
          }
        }
        else
        {
          bool = true;
          paramPaint = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          if (paramPaint != null) {
            this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setTypeface(paramPaint);
          }
          this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setColor(this.c);
          this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setTextAlign(Paint.Align.CENTER);
          this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.setTextSize(f);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b.getFontMetrics();
          f = (this.jdField_b_of_type_AndroidGraphicsRect.bottom + this.jdField_b_of_type_AndroidGraphicsRect.top - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F;
          paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidGraphicsRect.centerX(), f, this.jdField_a_of_type_ComTencentMobileqqAddonDiyPendantDrawable.b);
          if (QLog.isColorLevel())
          {
            paramCanvas = new StringBuilder();
            paramCanvas.append("draw textInfo text = ");
            paramCanvas.append(this.jdField_a_of_type_JavaLangString);
            paramCanvas.append(" fontId = ");
            paramCanvas.append(this.jdField_a_of_type_Int);
            paramCanvas.append(" fontType = ");
            paramCanvas.append(this.jdField_b_of_type_Int);
            paramCanvas.append(" color = ");
            paramCanvas.append(this.c);
            paramCanvas.append(" localTypeFace Existed = ");
            paramCanvas.append(paramPaint);
            if (paramCanvas.toString() == null) {
              bool = false;
            }
            QLog.d("DiyPendantDrawable", 2, new Object[] { Boolean.valueOf(bool) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantDrawable.DiyAddonSticker
 * JD-Core Version:    0.7.0.1
 */