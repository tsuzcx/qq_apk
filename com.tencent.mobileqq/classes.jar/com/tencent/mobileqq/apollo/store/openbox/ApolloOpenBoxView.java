package com.tencent.mobileqq.apollo.store.openbox;

import amyg;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ApolloOpenBoxView
  extends View
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private amyg jdField_a_of_type_Amyg;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_c_of_type_Int;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public ApolloOpenBoxView(Context paramContext, amyg paramamyg)
  {
    super(paramContext);
    c();
    this.jdField_a_of_type_Amyg = paramamyg;
  }
  
  public ApolloOpenBoxView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838441);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838440);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838439);
    int i1 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() >> 1;
    int i2 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() >> 1;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(-i1, -i2, i1, i2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int i5 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    i2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int i3 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    int i4 = -(i5 + i3) >> 1;
    i5 += i4;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(-i1 >> 1, i4, i1 >> 1, i5);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(-i2 >> 1, i5, i2 >> 1, i3 + i5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    super.invalidate();
    if (this.jdField_a_of_type_Amyg != null) {
      this.jdField_a_of_type_Amyg.a(this.jdField_a_of_type_Int, this.j, this.k);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Amyg = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    super.onDraw(paramCanvas);
    paramCanvas.save();
    long l1 = System.currentTimeMillis();
    int i3 = 255;
    float f2;
    if (this.jdField_a_of_type_Int == 1)
    {
      f2 = (float)(l1 - this.jdField_a_of_type_Long) / 200.0F;
      if (f2 <= 1.0F) {
        break label1110;
      }
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 2;
    }
    for (;;)
    {
      int i1 = (int)(this.jdField_b_of_type_Int + (this.d - this.jdField_b_of_type_Int) * f1);
      f2 = this.jdField_c_of_type_Int;
      int i2 = (int)(f1 * (this.e - this.jdField_c_of_type_Int) + f2);
      this.jdField_a_of_type_AndroidGraphicsRect.set(i1 - this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 10, i2 - this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 10, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 10 + i1, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 10 + i2);
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
      paramCanvas.translate(i1, i2);
      paramCanvas.scale(0.2F, 0.2F);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(255);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      super.invalidate();
      paramCanvas.restore();
      if (QLog.isColorLevel()) {
        QLog.e("ApolloBoxView", 2, "onDaw use" + (System.currentTimeMillis() - l1));
      }
      return;
      if (this.jdField_a_of_type_Int == 2)
      {
        f2 = (float)(l1 - this.jdField_a_of_type_Long) / 100.0F;
        if (f2 <= 1.0F) {
          break label1105;
        }
        this.jdField_a_of_type_Int = 3;
        this.jdField_a_of_type_Long = l1;
      }
      for (;;)
      {
        i1 = (int)(this.d + (this.f - this.d) * f1);
        i2 = (int)(this.e + (this.g - this.e) * f1);
        f1 = f1 * 0.8F + 0.2F;
        this.jdField_a_of_type_AndroidGraphicsRect.set((int)(i1 - this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2 * f1), (int)(i2 - this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2 * f1), (int)(i1 + this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2 * f1), (int)(i2 + this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2 * f1));
        paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
        paramCanvas.translate(i1, i2);
        paramCanvas.scale(f1, f1);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(255);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        super.invalidate();
        break;
        if (this.jdField_a_of_type_Int == 3) {
          if ((float)(l1 - this.jdField_a_of_type_Long) > 400.0F)
          {
            f2 = ((float)(l1 - this.jdField_a_of_type_Long) - 400.0F) / 100.0F;
            if (f2 <= 1.0F) {
              break label1102;
            }
            this.jdField_a_of_type_Int = 4;
            this.jdField_a_of_type_Long = l1;
            f2 = f1;
            if (this.jdField_a_of_type_Amyg != null)
            {
              this.jdField_a_of_type_Amyg.a(this.jdField_a_of_type_Int, this.j, this.k);
              f2 = f1;
            }
          }
        }
        label1102:
        for (;;)
        {
          i2 = (int)(this.h + (this.j - this.h) * f2);
          f1 = this.i;
          for (i1 = (int)(f2 * (this.k - this.i) + f1);; i1 = (int)(f1 * (this.i - this.g) + f2))
          {
            this.jdField_a_of_type_AndroidGraphicsRect.set(i2 - this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2, i1 - this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2 + i2, this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2 + i1);
            paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
            paramCanvas.translate(i2, i1);
            this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(255);
            this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            super.invalidate();
            break;
            f1 = (float)(l1 - this.jdField_a_of_type_Long) / 400.0F;
            i2 = (int)(this.f + (this.h - this.f) * f1);
            f2 = this.g;
          }
          if (this.jdField_a_of_type_Int != 4) {
            break;
          }
          int i4 = this.j;
          int i5 = this.j;
          if ((float)(l1 - this.jdField_a_of_type_Long) > 450.0F)
          {
            f2 = ((float)(l1 - this.jdField_a_of_type_Long) - 150.0F - 300.0F) / 150.0F;
            f1 = f2;
            if (f2 > 1.0F)
            {
              this.jdField_a_of_type_Int = 0;
              this.jdField_a_of_type_Long = l1;
              f1 = 1.0F;
            }
            i3 = (int)((1.0F - f1) * 255.0F);
            i2 = (int)(this.k + this.l + this.n * f1);
            i1 = (int)(this.k + this.m + f1 * this.o);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidGraphicsRect.set(i4 - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2, i2 - this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2 + i4, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + i1);
            paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
            paramCanvas.translate(i4, i2);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(i3);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            paramCanvas.translate(i5 - i4, i1 - i2);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(i3);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            super.invalidate();
            break;
            if ((float)(l1 - this.jdField_a_of_type_Long) > 150.0F)
            {
              postInvalidateDelayed(300L);
              i1 = this.k;
              i2 = this.l + i1;
              i1 = this.k + this.m;
            }
            else
            {
              f1 = (float)(l1 - this.jdField_a_of_type_Long) / 150.0F;
              i2 = (int)(this.k + this.l * f1);
              f2 = this.k;
              i1 = (int)(f1 * this.m + f2);
            }
          }
        }
        label1105:
        f1 = f2;
      }
      label1110:
      f1 = f2;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.p) || (paramInt2 != this.q))
    {
      this.p = paramInt1;
      this.q = paramInt2;
      this.jdField_b_of_type_Int = ((int)(this.p * 0.5F));
      this.jdField_c_of_type_Int = ((int)(0.57F * this.q));
      this.d = ((int)(this.p * 0.5F));
      this.e = ((int)(0.4F * this.q));
      this.f = ((int)(this.p * 0.5F));
      this.g = ((int)(0.494F * this.q));
      this.h = ((int)(this.p * 0.5F));
      this.i = ((int)(0.464F * this.q));
      this.j = ((int)(this.p * 0.5F));
      this.k = ((int)(0.521F * this.q));
      this.l = ((int)(-0.138F * this.q));
      this.m = ((int)(0.066F * this.q));
      this.n = ((int)(-0.092F * this.q));
      this.o = ((int)(0.052F * this.q));
    }
  }
  
  public void setDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    if (paramDrawable1 != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
    }
    if (paramDrawable2 != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
    }
    if (paramDrawable3 != null) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable3;
    }
    int i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int i5 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    int i2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int i3 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    int i4 = -(i5 + i3) >> 1;
    i5 += i4;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(-i1 >> 1, i4, i1 >> 1, i5);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(-i2 >> 1, i5, i2 >> 1, i3 + i5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloOpenBoxView
 * JD-Core Version:    0.7.0.1
 */