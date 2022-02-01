package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;

public class ContainerDrawable
  extends Drawable
  implements Animatable
{
  Property<ContainerDrawable, Integer> a = new ContainerDrawable.1(this, Integer.class, "backAlpha");
  private int b = 127;
  private boolean c = false;
  private Paint d;
  private RectF e = new RectF();
  private int f = 0;
  private ValueAnimator g;
  private boolean h = false;
  
  private void a(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.g.removeAllUpdateListeners();
      this.g = null;
    }
    if (paramInt1 == 1)
    {
      this.g = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.a, new int[] { 0, 127 }) });
      this.g.setDuration(paramInt2);
    }
    else if (paramInt1 == 2)
    {
      this.g = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.a, new int[] { 127, 0 }) });
      this.g.setDuration(paramInt2);
    }
    localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.setRepeatMode(1);
      this.g.setRepeatCount(0);
      this.g.setStartDelay(0L);
      this.g.addUpdateListener(new ContainerDrawable.2(this));
      this.g.addListener(new ContainerDrawable.3(this));
      this.g.start();
    }
  }
  
  private int b()
  {
    return this.b;
  }
  
  private void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a()
  {
    this.c = false;
    this.d = null;
    ValueAnimator localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.g.removeAllUpdateListeners();
      this.g = null;
    }
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (this.d == null)
    {
      this.d = new Paint();
      this.d.setAntiAlias(true);
    }
    this.d.setColor(0);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.f == 0) {
      return;
    }
    this.d.setAlpha(this.b);
    paramCanvas.drawRect(this.e, this.d);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.c;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.e.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Paint localPaint = this.d;
    if (localPaint != null) {
      localPaint.setColorFilter(paramColorFilter);
    }
  }
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.c = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start :");
      localStringBuilder.append(this.f);
      QLog.d("HintDrawable", 2, localStringBuilder.toString());
    }
    int j = this.f;
    if (j == 1)
    {
      int i;
      if (this.h) {
        i = 150;
      } else {
        i = 300;
      }
      a(j, i);
      return;
    }
    if (j == 2) {
      a(j, 200);
    }
  }
  
  public void stop()
  {
    if (!this.c) {
      return;
    }
    this.c = false;
    ValueAnimator localValueAnimator = this.g;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.g.removeAllUpdateListeners();
      this.g = null;
    }
    this.f = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.ContainerDrawable
 * JD-Core Version:    0.7.0.1
 */