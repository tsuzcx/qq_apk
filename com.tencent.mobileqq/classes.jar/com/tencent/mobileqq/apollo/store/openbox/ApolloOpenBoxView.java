package com.tencent.mobileqq.apollo.store.openbox;

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
  private int a = 0;
  private int b;
  private int c;
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
  private long r;
  private Drawable s;
  private Drawable t;
  private Drawable u;
  private Rect v;
  private IApolloOpenBoxListener w;
  
  public ApolloOpenBoxView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ApolloOpenBoxView(Context paramContext, IApolloOpenBoxListener paramIApolloOpenBoxListener)
  {
    super(paramContext);
    c();
    this.w = paramIApolloOpenBoxListener;
  }
  
  private void c()
  {
    this.s = getResources().getDrawable(2130838469);
    this.t = getResources().getDrawable(2130838468);
    this.u = getResources().getDrawable(2130838467);
    int i1 = this.u.getIntrinsicWidth() >> 1;
    int i2 = this.u.getIntrinsicHeight() >> 1;
    this.u.setBounds(-i1, -i2, i1, i2);
    this.v = new Rect();
    i1 = this.s.getIntrinsicWidth();
    int i5 = this.s.getIntrinsicHeight();
    i2 = this.t.getIntrinsicWidth();
    int i3 = this.t.getIntrinsicHeight();
    int i4 = -(i5 + i3) >> 1;
    i5 += i4;
    this.s.setBounds(-i1 >> 1, i4, i1 >> 1, i5);
    this.t.setBounds(-i2 >> 1, i5, i2 >> 1, i3 + i5);
  }
  
  public void a()
  {
    this.a = 4;
    this.r = System.currentTimeMillis();
    super.invalidate();
    IApolloOpenBoxListener localIApolloOpenBoxListener = this.w;
    if (localIApolloOpenBoxListener != null) {
      localIApolloOpenBoxListener.a(this.a, this.j, this.k);
    }
  }
  
  public void b()
  {
    this.w = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    long l1 = System.currentTimeMillis();
    int i2 = this.a;
    int i1 = 255;
    float f2;
    float f1;
    if (i2 == 1)
    {
      f2 = (float)(l1 - this.r) / 200.0F;
      f1 = f2;
      if (f2 > 1.0F)
      {
        this.r = l1;
        this.a = 2;
        f1 = 1.0F;
      }
      i1 = this.b;
      i1 = (int)(i1 + (this.d - i1) * f1);
      i2 = this.c;
      i2 = (int)(i2 + (this.e - i2) * f1);
      this.v.set(i1 - this.u.getIntrinsicWidth() / 10, i2 - this.u.getIntrinsicHeight() / 10, this.u.getIntrinsicWidth() / 10 + i1, this.u.getIntrinsicHeight() / 10 + i2);
      paramCanvas.clipRect(this.v);
      paramCanvas.translate(i1, i2);
      paramCanvas.scale(0.2F, 0.2F);
      this.u.setAlpha(255);
      this.u.draw(paramCanvas);
      super.invalidate();
    }
    else
    {
      Object localObject;
      if (i2 == 2)
      {
        f2 = (float)(l1 - this.r) / 100.0F;
        f1 = f2;
        if (f2 > 1.0F)
        {
          this.a = 3;
          this.r = l1;
          f1 = 1.0F;
        }
        i1 = this.d;
        i1 = (int)(i1 + (this.f - i1) * f1);
        i2 = this.e;
        i2 = (int)(i2 + (this.g - i2) * f1);
        f1 = f1 * 0.8F + 0.2F;
        localObject = this.v;
        f2 = i1;
        i1 = (int)(f2 - this.u.getIntrinsicWidth() / 2 * f1);
        float f3 = i2;
        ((Rect)localObject).set(i1, (int)(f3 - this.u.getIntrinsicHeight() / 2 * f1), (int)(this.u.getIntrinsicWidth() / 2 * f1 + f2), (int)(this.u.getIntrinsicHeight() / 2 * f1 + f3));
        paramCanvas.clipRect(this.v);
        paramCanvas.translate(f2, f3);
        paramCanvas.scale(f1, f1);
        this.u.setAlpha(255);
        this.u.draw(paramCanvas);
        super.invalidate();
      }
      else
      {
        long l2;
        int i3;
        if (i2 == 3)
        {
          l2 = this.r;
          if ((float)(l1 - l2) > 400.0F)
          {
            f2 = ((float)(l1 - l2) - 400.0F) / 100.0F;
            f1 = f2;
            if (f2 > 1.0F)
            {
              this.a = 4;
              this.r = l1;
              localObject = this.w;
              if (localObject != null) {
                ((IApolloOpenBoxListener)localObject).a(this.a, this.j, this.k);
              }
              f1 = 1.0F;
            }
            i1 = this.h;
            i1 = (int)(i1 + (this.j - i1) * f1);
            i2 = this.i;
            f2 = i2;
            i3 = this.k;
          }
          else
          {
            f1 = (float)(l1 - l2) / 400.0F;
            i1 = this.f;
            i1 = (int)(i1 + (this.h - i1) * f1);
            i2 = this.g;
            f2 = i2;
            i3 = this.i;
          }
          i2 = (int)(f2 + (i3 - i2) * f1);
          this.v.set(i1 - this.u.getIntrinsicWidth() / 2, i2 - this.u.getIntrinsicHeight() / 2, this.u.getIntrinsicWidth() / 2 + i1, this.u.getIntrinsicHeight() / 2 + i2);
          paramCanvas.clipRect(this.v);
          paramCanvas.translate(i1, i2);
          this.u.setAlpha(255);
          this.u.draw(paramCanvas);
          super.invalidate();
        }
        else if (i2 == 4)
        {
          int i5 = this.j;
          l2 = this.r;
          if ((float)(l1 - l2) > 450.0F)
          {
            f2 = ((float)(l1 - l2) - 150.0F - 300.0F) / 150.0F;
            f1 = f2;
            if (f2 > 1.0F)
            {
              this.a = 0;
              this.r = l1;
              f1 = 1.0F;
            }
            i1 = (int)((1.0F - f1) * 255.0F);
            i3 = this.k;
            i2 = (int)(this.l + i3 + this.n * f1);
            f1 = i3 + this.m + f1 * this.o;
          }
          else
          {
            if ((float)(l1 - l2) > 150.0F)
            {
              postInvalidateDelayed(300L);
              i2 = this.k;
              i3 = i2 + this.l;
              i2 += this.m;
              break label960;
            }
            f1 = (float)(l1 - l2) / 150.0F;
            i3 = this.k;
            i2 = (int)(i3 + this.l * f1);
            f1 = i3 + this.m * f1;
          }
          int i4 = (int)f1;
          i3 = i2;
          i2 = i4;
          label960:
          this.v.set(i5 - this.s.getIntrinsicWidth() / 2, i3 - this.s.getIntrinsicHeight(), this.s.getIntrinsicWidth() / 2 + i5, this.s.getIntrinsicHeight() + i2);
          paramCanvas.clipRect(this.v);
          paramCanvas.translate(i5, i3);
          this.s.setAlpha(i1);
          this.s.draw(paramCanvas);
          paramCanvas.translate(this.j - i5, i2 - i3);
          this.t.setAlpha(i1);
          this.t.draw(paramCanvas);
          super.invalidate();
        }
      }
    }
    paramCanvas.restore();
    if (QLog.isColorLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("onDaw use");
      paramCanvas.append(System.currentTimeMillis() - l1);
      QLog.e("[cmshow]ApolloBoxView", 2, paramCanvas.toString());
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
      paramInt1 = this.p;
      this.b = ((int)(paramInt1 * 0.5F));
      paramInt2 = this.q;
      this.c = ((int)(paramInt2 * 0.57F));
      this.d = ((int)(paramInt1 * 0.5F));
      this.e = ((int)(paramInt2 * 0.4F));
      this.f = ((int)(paramInt1 * 0.5F));
      this.g = ((int)(paramInt2 * 0.494F));
      this.h = ((int)(paramInt1 * 0.5F));
      this.i = ((int)(paramInt2 * 0.464F));
      this.j = ((int)(paramInt1 * 0.5F));
      this.k = ((int)(paramInt2 * 0.521F));
      this.l = ((int)(paramInt2 * -0.138F));
      this.m = ((int)(paramInt2 * 0.066F));
      this.n = ((int)(paramInt2 * -0.092F));
      this.o = ((int)(paramInt2 * 0.052F));
    }
  }
  
  public void setDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    if (paramDrawable1 != null) {
      this.s = paramDrawable1;
    }
    if (paramDrawable2 != null) {
      this.t = paramDrawable2;
    }
    if (paramDrawable3 != null) {
      this.u = paramDrawable3;
    }
    int i1 = this.s.getIntrinsicWidth();
    int i5 = this.s.getIntrinsicHeight();
    int i2 = this.t.getIntrinsicWidth();
    int i3 = this.t.getIntrinsicHeight();
    int i4 = -(i5 + i3) >> 1;
    i5 += i4;
    this.s.setBounds(-i1 >> 1, i4, i1 >> 1, i5);
    this.t.setBounds(-i2 >> 1, i5, i2 >> 1, i3 + i5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloOpenBoxView
 * JD-Core Version:    0.7.0.1
 */