package com.tencent.av.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SparkDot
  extends LinearLayout
{
  Bitmap a = null;
  Bitmap b = null;
  int c = 400;
  int d = 40;
  int e = 0;
  int f = 0;
  float g = 0.0F;
  int h = 6;
  public int i = -849386130;
  public int j = 1281320302;
  public boolean k = true;
  ImageView[] l = null;
  Handler m = new Handler();
  Runnable n = new SparkDot.1(this);
  private boolean o = false;
  
  public SparkDot(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SparkDot(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
  }
  
  @SuppressLint({"NewApi"})
  void a()
  {
    this.g = getResources().getDisplayMetrics().scaledDensity;
    this.d = ((int)(this.g * 13.0F));
    this.a = b(this.j);
    this.b = b(this.i);
    int i2;
    for (int i1 = 0; i1 < this.h; i1 = i2)
    {
      ImageView localImageView = new ImageView(getContext());
      localImageView.setImageBitmap(this.a);
      int i3 = this.d;
      i2 = i1 + 1;
      localImageView.layout(i3 * i1, 0, i3 * i2, i3);
      this.l[i1] = localImageView;
      super.addViewInLayout(localImageView, getChildCount(), generateDefaultLayoutParams());
    }
  }
  
  void a(int paramInt)
  {
    this.f = paramInt;
    this.l[paramInt].setImageBitmap(this.b);
    if (paramInt > 0)
    {
      this.l[(paramInt - 1)].setImageBitmap(this.a);
      return;
    }
    this.l[(this.h - 1)].setImageBitmap(this.a);
  }
  
  Bitmap b(int paramInt)
  {
    int i1 = this.d;
    Bitmap localBitmap = Bitmap.createBitmap(i1, i1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setColor(paramInt);
    localPaint.setStyle(Paint.Style.FILL);
    if (this.k) {
      localPaint.setMaskFilter(new BlurMaskFilter(this.g * 3.0F, BlurMaskFilter.Blur.SOLID));
    }
    float f1 = this.g;
    localCanvas.drawOval(new RectF(f1 * 3.0F, 3.0F * f1, f1 * 10.0F, f1 * 10.0F), localPaint);
    return localBitmap;
  }
  
  public void b()
  {
    this.o = false;
    Runnable localRunnable = this.n;
    if (localRunnable != null)
    {
      this.m.removeCallbacks(localRunnable);
      this.l[this.f].setImageBitmap(this.a);
      this.f = 0;
      this.e = 0;
    }
  }
  
  public void c()
  {
    if (this.o) {
      return;
    }
    this.o = true;
    Runnable localRunnable = this.n;
    if (localRunnable != null)
    {
      this.m.removeCallbacks(localRunnable);
      this.m.postDelayed(this.n, this.c);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = (this.d * this.h);
    setLayoutParams(localLayoutParams);
  }
  
  public void setDotCount(int paramInt)
  {
    this.h = paramInt;
    this.l = new ImageView[this.h];
    a();
    this.m.postDelayed(this.n, this.c);
  }
  
  public void setDuration(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SparkDot
 * JD-Core Version:    0.7.0.1
 */