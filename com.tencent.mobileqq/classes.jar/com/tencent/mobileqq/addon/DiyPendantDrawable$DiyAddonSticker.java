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
  double a;
  String b;
  int c;
  int d;
  int e;
  int f;
  Rect g = new Rect();
  Rect h = new Rect();
  
  DiyPendantDrawable$DiyAddonSticker(DiyPendantDrawable paramDiyPendantDrawable, int paramInt1, double paramDouble, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = (paramDouble * 0.0174532925199433D);
    this.f = paramInt1;
    this.b = paramString;
    this.e = paramInt4;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    Object localObject = this.i.l.a(this.i, this.f);
    if (localObject != null)
    {
      Rect localRect1 = this.i.getBounds();
      int j = localRect1.width();
      int k = localRect1.height();
      double d1 = j / 2;
      double d2 = Math.sin(this.a);
      double d3 = this.i.j;
      Double.isNaN(d3);
      Double.isNaN(d1);
      j = (int)(d1 + d2 * d3);
      d1 = k / 2;
      d2 = Math.cos(this.a);
      d3 = this.i.j;
      Double.isNaN(d3);
      Double.isNaN(d1);
      k = (int)(d1 - d2 * d3);
      d1 = ((Bitmap)localObject).getWidth();
      d2 = this.i.k;
      Double.isNaN(d1);
      int m = (int)(d1 * d2);
      d1 = ((Bitmap)localObject).getHeight();
      d2 = this.i.k;
      Double.isNaN(d1);
      int n = (int)(d1 * d2);
      Rect localRect2 = this.g;
      int i1 = m / 2;
      int i2 = n / 2;
      localRect2.set(j - i1, k - i2 + this.i.i / 2, i1 + j, i2 + k + this.i.i / 2);
      if (this.g.left < localRect1.left)
      {
        localRect2 = this.g;
        localRect2.right += localRect1.left - this.g.left;
        this.g.left = localRect1.left;
      }
      if (this.g.top < localRect1.top)
      {
        localRect2 = this.g;
        localRect2.bottom += localRect1.top - this.g.top;
        this.g.top = localRect1.top;
      }
      if (this.g.right > localRect1.right)
      {
        localRect2 = this.g;
        localRect2.left += localRect1.right - this.g.right;
        this.g.right = localRect1.right;
      }
      if (this.g.bottom > localRect1.bottom)
      {
        localRect2 = this.g;
        localRect2.top += localRect1.bottom - this.g.bottom;
        this.g.bottom = localRect1.bottom;
      }
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.g, paramPaint);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("draw sticker index = ");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append("scaleFactor=");
        ((StringBuilder)localObject).append(this.i.k);
        ((StringBuilder)localObject).append(", x=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", y=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(", w=");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(", h=");
        ((StringBuilder)localObject).append(n);
        QLog.d("DiyPendantDrawable", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(this.b))
      {
        j = (int)(this.i.k * 10.0D);
        this.h.set(this.g.left + j, this.g.top + j, this.g.right - j, this.g.bottom - j);
        float f1 = AvatarPendantUtil.a(this.i.n, this.h, this.b);
        boolean bool;
        if (this.d == 1)
        {
          localObject = new Paint();
          ((Paint)localObject).setTextSize(f1);
          j = (int)((Paint)localObject).measureText(this.b);
          d1 = f1;
          d2 = this.i.k;
          Double.isNaN(d1);
          k = (int)Math.min(d1 + d2 * 10.0D, this.h.height());
          localObject = this.i.l.a(this.i, this.b, this.c, this.d, f1, this.e, j, k, paramPaint);
          if (localObject != null)
          {
            j = this.g.centerX();
            k = this.g.centerY();
            this.h.set(j - ((Bitmap)localObject).getWidth() / 2, k - ((Bitmap)localObject).getHeight() / 2, j + ((Bitmap)localObject).getWidth() / 2, k + ((Bitmap)localObject).getHeight() / 2);
            paramCanvas.drawBitmap((Bitmap)localObject, null, this.h, paramPaint);
          }
          if (QLog.isColorLevel())
          {
            bool = true;
            paramCanvas = new StringBuilder();
            paramCanvas.append("draw textInfo text = ");
            paramCanvas.append(this.b);
            paramCanvas.append(" fontId = ");
            paramCanvas.append(this.c);
            paramCanvas.append(" fontType = ");
            paramCanvas.append(1);
            paramCanvas.append(" color = ");
            paramCanvas.append(this.e);
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
          paramPaint = this.i.l.a(this.i, this.c, this.d);
          if (paramPaint != null) {
            this.i.n.setTypeface(paramPaint);
          }
          this.i.n.setColor(this.e);
          this.i.n.setTextAlign(Paint.Align.CENTER);
          this.i.n.setTextSize(f1);
          localObject = this.i.n.getFontMetrics();
          f1 = (this.h.bottom + this.h.top - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F;
          paramCanvas.drawText(this.b, this.h.centerX(), f1, this.i.n);
          if (QLog.isColorLevel())
          {
            paramCanvas = new StringBuilder();
            paramCanvas.append("draw textInfo text = ");
            paramCanvas.append(this.b);
            paramCanvas.append(" fontId = ");
            paramCanvas.append(this.c);
            paramCanvas.append(" fontType = ");
            paramCanvas.append(this.d);
            paramCanvas.append(" color = ");
            paramCanvas.append(this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantDrawable.DiyAddonSticker
 * JD-Core Version:    0.7.0.1
 */