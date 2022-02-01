package com.tencent.mobileqq.activity.richmedia.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SeekBar;

public class RotationSeekBar
  extends SeekBar
{
  private static float a = -1.0F;
  private static final Interpolator d = new AccelerateDecelerateInterpolator();
  private float[] b = null;
  private Paint c = null;
  private boolean e = false;
  private ValueAnimator f;
  private ValueAnimator g;
  
  public RotationSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat)
  {
    getDensity();
    return Math.round(paramFloat * a);
  }
  
  private float getDensity()
  {
    if (a == -1.0F) {
      a = getContext().getResources().getDisplayMetrics().density;
    }
    return a;
  }
  
  void a() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.f;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.g;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b != null)
    {
      int j = getMeasuredWidth();
      int i = getMeasuredHeight();
      if (this.c == null)
      {
        this.c = new Paint();
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(getResources().getColor(2131168464));
      }
      int k = a(2.0F);
      int m = i / 2;
      float[] arrayOfFloat = this.b;
      int n = arrayOfFloat.length;
      i = 0;
      while (i < n)
      {
        float f1 = arrayOfFloat[i];
        if ((f1 > 0.0F) && (f1 < 1.0F))
        {
          paramCanvas.save();
          paramCanvas.translate(f1 * j, m);
          paramCanvas.drawCircle(0.0F, 0.0F, k, this.c);
          paramCanvas.restore();
        }
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setAnimateEnable(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      if (!this.e)
      {
        super.setProgress(paramInt);
        return;
      }
      if (this.f != null) {
        this.f.cancel();
      }
      if (this.f == null)
      {
        this.f = ValueAnimator.ofInt(new int[] { getProgress(), paramInt });
        this.f.setInterpolator(d);
        this.f.addUpdateListener(new RotationSeekBar.1(this));
      }
      else
      {
        this.f.setIntValues(new int[] { getProgress(), paramInt });
      }
      this.f.start();
      return;
    }
    finally {}
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    try
    {
      if (!this.e)
      {
        super.setSecondaryProgress(paramInt);
        return;
      }
      if (this.g != null) {
        this.g.cancel();
      }
      if (this.g == null)
      {
        this.g = ValueAnimator.ofInt(new int[] { getProgress(), paramInt });
        this.g.setInterpolator(d);
        this.g.addUpdateListener(new RotationSeekBar.2(this));
      }
      else
      {
        this.g.setIntValues(new int[] { getProgress(), paramInt });
      }
      this.g.start();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar
 * JD-Core Version:    0.7.0.1
 */