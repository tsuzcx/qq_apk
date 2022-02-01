package com.tencent.mm.ui.widget.progress;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class MMProgressWheel
  extends View
{
  private static final String a = "MMProgressWheel";
  private final int b = 16;
  private final int c = 270;
  private final long d = 200L;
  private int e = 28;
  private int f = 4;
  private int g = 4;
  private boolean h = false;
  private double i = 0.0D;
  private double j = 460.0D;
  private float k = 0.0F;
  private boolean l = true;
  private long m = 0L;
  private int n = -1442840576;
  private int o = 16777215;
  private Paint p = new Paint();
  private Paint q = new Paint();
  private RectF r = new RectF();
  private float s = 230.0F;
  private long t = 0L;
  private boolean u;
  private float v = 0.0F;
  private float w = 0.0F;
  private boolean x = false;
  private MMProgressWheel.ProgressCallback y;
  private boolean z;
  
  public MMProgressWheel(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MMProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MMProgressWheel));
    a();
  }
  
  @TargetApi(17)
  private void a()
  {
    float f1;
    if (Build.VERSION.SDK_INT >= 17) {
      f1 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
    } else {
      f1 = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
    }
    boolean bool;
    if (f1 != 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    this.z = bool;
  }
  
  private void a(float paramFloat)
  {
    MMProgressWheel.ProgressCallback localProgressCallback = this.y;
    if (localProgressCallback != null) {
      localProgressCallback.onProgressUpdate(paramFloat);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = getPaddingLeft();
    int i4 = getPaddingRight();
    if (!this.h)
    {
      i4 = paramInt1 - i3 - i4;
      paramInt1 = Math.min(Math.min(i4, paramInt2 - i2 - i1), this.e * 2 - this.f * 2);
      i3 = (i4 - paramInt1) / 2 + i3;
      paramInt2 = (paramInt2 - i1 - i2 - paramInt1) / 2 + i1;
      i1 = this.f;
      this.r = new RectF(i3 + i1, paramInt2 + i1, i3 + paramInt1 - i1, paramInt2 + paramInt1 - i1);
      return;
    }
    int i5 = this.f;
    this.r = new RectF(i3 + i5, i1 + i5, paramInt1 - i4 - i5, paramInt2 - i2 - i5);
  }
  
  private void a(long paramLong)
  {
    long l1 = this.m;
    if (l1 >= 200L)
    {
      double d1 = this.i;
      double d2 = paramLong;
      Double.isNaN(d2);
      this.i = (d1 + d2);
      d1 = this.i;
      d2 = this.j;
      if (d1 > d2)
      {
        this.i = (d1 - d2);
        this.m = 0L;
        this.l ^= true;
      }
      float f1 = (float)Math.cos((this.i / this.j + 1.0D) * 3.141592653589793D) / 2.0F + 0.5F;
      if (this.l)
      {
        this.k = (f1 * 254.0F);
        return;
      }
      f1 = (1.0F - f1) * 254.0F;
      this.v += this.k - f1;
      this.k = f1;
      return;
    }
    this.m = (l1 + paramLong);
  }
  
  private void a(TypedArray paramTypedArray)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    this.e = ((int)TypedValue.applyDimension(1, this.e, localDisplayMetrics));
    this.e = ((int)paramTypedArray.getDimension(R.styleable.MMProgressWheel_matProg_circleRadius, this.e));
    this.h = paramTypedArray.getBoolean(R.styleable.MMProgressWheel_matProg_fillRadius, false);
    this.f = ((int)paramTypedArray.getDimension(R.styleable.MMProgressWheel_matProg_barWidth, this.f));
    this.g = ((int)paramTypedArray.getDimension(R.styleable.MMProgressWheel_matProg_rimWidth, this.g));
    this.s = (paramTypedArray.getFloat(R.styleable.MMProgressWheel_matProg_spinSpeed, this.s / 360.0F) * 360.0F);
    this.j = paramTypedArray.getInt(R.styleable.MMProgressWheel_matProg_barSpinCycleTime, (int)this.j);
    this.n = paramTypedArray.getColor(R.styleable.MMProgressWheel_matProg_barColor, this.n);
    this.o = paramTypedArray.getColor(R.styleable.MMProgressWheel_matProg_rimColor, this.o);
    this.u = paramTypedArray.getBoolean(R.styleable.MMProgressWheel_matProg_linearProgress, false);
    if (paramTypedArray.getBoolean(R.styleable.MMProgressWheel_matProg_progressIndeterminate, false)) {
      spin();
    }
    paramTypedArray.recycle();
  }
  
  private void b()
  {
    this.p.setColor(this.n);
    this.p.setAntiAlias(true);
    this.p.setStyle(Paint.Style.STROKE);
    this.p.setStrokeWidth(this.f);
    this.q.setColor(this.o);
    this.q.setAntiAlias(true);
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setStrokeWidth(this.g);
  }
  
  private void c()
  {
    if (this.y != null)
    {
      float f1 = Math.round(this.v * 100.0F / 360.0F) / 100.0F;
      this.y.onProgressUpdate(f1);
    }
  }
  
  public int getBarColor()
  {
    return this.n;
  }
  
  public int getBarWidth()
  {
    return this.f;
  }
  
  public int getCircleRadius()
  {
    return this.e;
  }
  
  public float getProgress()
  {
    if (this.x) {
      return -1.0F;
    }
    return this.v / 360.0F;
  }
  
  public int getRimColor()
  {
    return this.o;
  }
  
  public int getRimWidth()
  {
    return this.g;
  }
  
  public float getSpinSpeed()
  {
    return this.s / 360.0F;
  }
  
  public boolean isSpinning()
  {
    return this.x;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.r, 360.0F, 360.0F, false, this.q);
    if (!this.z) {
      return;
    }
    boolean bool = this.x;
    int i2 = 1;
    int i1 = 1;
    float f1;
    float f2;
    if (bool)
    {
      long l1 = SystemClock.uptimeMillis() - this.t;
      f1 = (float)l1 * this.s / 1000.0F;
      a(l1);
      this.v += f1;
      f1 = this.v;
      if (f1 > 360.0F)
      {
        this.v = (f1 - 360.0F);
        a(-1.0F);
      }
      this.t = SystemClock.uptimeMillis();
      f1 = this.v;
      f2 = this.k;
      if (isInEditMode())
      {
        f1 = 0.0F;
        f2 = 135.0F;
      }
      else
      {
        f1 -= 90.0F;
        f2 += 16.0F;
      }
      paramCanvas.drawArc(this.r, f1, f2, false, this.p);
      i1 = i2;
    }
    else
    {
      f1 = this.v;
      if (f1 != this.w)
      {
        f2 = (float)(SystemClock.uptimeMillis() - this.t) / 1000.0F;
        float f3 = this.s;
        this.v = Math.min(this.v + f2 * f3, this.w);
        this.t = SystemClock.uptimeMillis();
      }
      else
      {
        i1 = 0;
      }
      if (f1 != this.v) {
        c();
      }
      f1 = this.v;
      if (!this.u)
      {
        f2 = (float)(1.0D - Math.pow(1.0F - f1 / 360.0F, 4.0F)) * 360.0F;
        f1 = (float)(1.0D - Math.pow(1.0F - this.v / 360.0F, 2.0F)) * 360.0F;
      }
      else
      {
        f2 = 0.0F;
      }
      if (isInEditMode()) {
        f1 = 360.0F;
      }
      paramCanvas.drawArc(this.r, f2 - 90.0F, f1, false, this.p);
    }
    if (i1 != 0) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i3 = this.e + getPaddingLeft() + getPaddingRight();
    int i1 = this.e + getPaddingTop() + getPaddingBottom();
    int i5 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    if (i5 == 1073741824)
    {
      paramInt1 = i4;
    }
    else
    {
      paramInt1 = i3;
      if (i5 == -2147483648) {
        paramInt1 = Math.min(i3, i4);
      }
    }
    if ((i6 != 1073741824) && (i5 != 1073741824))
    {
      paramInt2 = i1;
      if (i6 == -2147483648) {
        paramInt2 = Math.min(i1, i2);
      }
    }
    else
    {
      paramInt2 = i2;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof MMProgressWheel.WheelSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (MMProgressWheel.WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.v = paramParcelable.a;
    this.w = paramParcelable.b;
    this.x = paramParcelable.c;
    this.s = paramParcelable.d;
    this.f = paramParcelable.e;
    this.n = paramParcelable.f;
    this.g = paramParcelable.g;
    this.o = paramParcelable.h;
    this.e = paramParcelable.i;
    this.u = paramParcelable.j;
    this.h = paramParcelable.k;
    this.t = SystemClock.uptimeMillis();
  }
  
  public Parcelable onSaveInstanceState()
  {
    MMProgressWheel.WheelSavedState localWheelSavedState = new MMProgressWheel.WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.a = this.v;
    localWheelSavedState.b = this.w;
    localWheelSavedState.c = this.x;
    localWheelSavedState.d = this.s;
    localWheelSavedState.e = this.f;
    localWheelSavedState.f = this.n;
    localWheelSavedState.g = this.g;
    localWheelSavedState.h = this.o;
    localWheelSavedState.i = this.e;
    localWheelSavedState.j = this.u;
    localWheelSavedState.k = this.h;
    return localWheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
    b();
    invalidate();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      this.t = SystemClock.uptimeMillis();
    }
  }
  
  public void resetCount()
  {
    this.v = 0.0F;
    this.w = 0.0F;
    invalidate();
  }
  
  public void setBarColor(int paramInt)
  {
    this.n = paramInt;
    b();
    if (!this.x) {
      invalidate();
    }
  }
  
  public void setBarWidth(int paramInt)
  {
    this.f = paramInt;
    if (!this.x) {
      invalidate();
    }
  }
  
  public void setCallback(MMProgressWheel.ProgressCallback paramProgressCallback)
  {
    this.y = paramProgressCallback;
    if (!this.x) {
      c();
    }
  }
  
  public void setCircleRadius(int paramInt)
  {
    this.e = paramInt;
    if (!this.x) {
      invalidate();
    }
  }
  
  public void setInstantProgress(float paramFloat)
  {
    if (this.x)
    {
      this.v = 0.0F;
      this.x = false;
    }
    float f1;
    if (paramFloat > 1.0F)
    {
      f1 = paramFloat - 1.0F;
    }
    else
    {
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
    }
    if (Math.abs(f1 - this.w) <= 0.0F) {
      return;
    }
    this.w = Math.min(f1 * 360.0F, 360.0F);
    this.v = this.w;
    this.t = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void setLinearProgress(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if (!this.x) {
      invalidate();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.x)
    {
      this.v = 0.0F;
      this.x = false;
      c();
    }
    float f1;
    if (paramFloat > 1.0F)
    {
      f1 = paramFloat - 1.0F;
    }
    else
    {
      f1 = paramFloat;
      if (paramFloat < 0.0F) {
        f1 = 0.0F;
      }
    }
    if (Math.abs(f1 - this.w) <= 0.0F) {
      return;
    }
    if (this.v == this.w) {
      this.t = SystemClock.uptimeMillis();
    }
    this.w = Math.min(f1 * 360.0F, 360.0F);
    invalidate();
  }
  
  public void setRimColor(int paramInt)
  {
    this.o = paramInt;
    b();
    if (!this.x) {
      invalidate();
    }
  }
  
  public void setRimWidth(int paramInt)
  {
    this.g = paramInt;
    if (!this.x) {
      invalidate();
    }
  }
  
  public void setSpinSpeed(float paramFloat)
  {
    this.s = (paramFloat * 360.0F);
  }
  
  public void spin()
  {
    this.t = SystemClock.uptimeMillis();
    this.x = true;
    invalidate();
  }
  
  public void stopSpinning()
  {
    this.x = false;
    this.v = 0.0F;
    this.w = 0.0F;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel
 * JD-Core Version:    0.7.0.1
 */