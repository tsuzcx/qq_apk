package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;

public final class PressScaleAnimDelegate
{
  private static final Interpolator a = new LinearInterpolator();
  private final View b;
  private ValueAnimator c = null;
  private final PressScaleAnimDelegate.ScaleAnimUpdateListener d;
  
  PressScaleAnimDelegate(View paramView)
  {
    this.b = paramView;
    this.d = new PressScaleAnimDelegate.ScaleAnimUpdateListener(paramView);
  }
  
  public static void a(View paramView, long paramLong, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    paramView = new PressScaleAnimDelegate.ScaleAnimAloneUpdateListener(paramView, paramOnClickListener);
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.setInterpolator(a);
    localValueAnimator.addUpdateListener(paramView);
    localValueAnimator.addListener(paramView);
    localValueAnimator.start();
  }
  
  void a(Canvas paramCanvas)
  {
    int i = this.b.getPaddingLeft();
    int j = this.b.getRight() - this.b.getLeft() - this.b.getPaddingRight();
    int m = this.b.getPaddingTop();
    int n = this.b.getBottom();
    int i1 = this.b.getTop();
    int i2 = this.b.getPaddingBottom();
    int k = (i + j) / 2;
    m = (m + (n - i1 - i2)) / 2;
    paramCanvas.scale(this.d.b, this.d.b, k, m);
    if (QLog.isColorLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("draw, left=");
      paramCanvas.append(i);
      paramCanvas.append(",right=");
      paramCanvas.append(j);
      paramCanvas.append(",centerX=");
      paramCanvas.append(k);
      paramCanvas.append(",centerY=");
      paramCanvas.append(m);
      paramCanvas.append(",scale=");
      paramCanvas.append(this.d.b);
      QLog.d("PressScaleAnimDelegate ", 2, paramCanvas.toString());
    }
  }
  
  boolean a()
  {
    return this.d.b != 1.0F;
  }
  
  void b()
  {
    ValueAnimator localValueAnimator = this.c;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.c.removeUpdateListener(this.d);
    }
    this.c = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    this.c.setDuration(200L);
    this.c.setInterpolator(a);
    this.c.addUpdateListener(this.d);
    this.c.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate
 * JD-Core Version:    0.7.0.1
 */