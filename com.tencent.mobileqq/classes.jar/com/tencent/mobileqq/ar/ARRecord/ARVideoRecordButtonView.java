package com.tencent.mobileqq.ar.ARRecord;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ARVideoRecordButtonView
  extends View
{
  private Paint a = null;
  private Paint b = null;
  private RectF c = null;
  private Rect d = null;
  private int e = 2;
  private float f = 0.0F;
  private float g = 0.0F;
  private Bitmap h = null;
  private Bitmap i = null;
  private Bitmap j = null;
  
  public ARVideoRecordButtonView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ARVideoRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ARVideoRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Bitmap a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setColor(-48606);
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(-1);
    this.c = new RectF();
    this.d = new Rect();
    this.i = a(2130838729);
    this.j = a(2130838730);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new ARVideoRecordButtonView.3(this));
    localValueAnimator.start();
  }
  
  private void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = getWidth();
    int m = getHeight();
    int n = this.e;
    Object localObject;
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3) {
          return;
        }
        localObject = this.j;
        if (localObject != null)
        {
          this.d.set(0, 0, ((Bitmap)localObject).getWidth(), this.j.getHeight());
          this.c.set(0.0F, 0.0F, k, m);
          paramCanvas.drawBitmap(this.j, this.d, this.c, this.a);
        }
        float f2 = k;
        float f1 = 0.08571429F * f2;
        f2 = Math.min(k, m) / 2 - f1 - f2 * 0.002857143F;
        localObject = this.c;
        float f3 = k / 2;
        float f4 = m / 2;
        ((RectF)localObject).set(f3 - f2, f4 - f2, f3 + f2, f4 + f2);
        this.b.setStrokeWidth(f1);
        this.a.setStrokeWidth(f1);
        paramCanvas.drawArc(this.c, -90.0F, 360.0F, false, this.b);
        f1 = this.f;
        paramCanvas.drawArc(this.c, -90.0F, 360.0F - (1.0F - f1) * 360.0F, false, this.a);
        return;
      }
      localObject = this.i;
      if (localObject != null)
      {
        this.d.set(0, 0, ((Bitmap)localObject).getWidth(), this.i.getHeight());
        this.c.set(0.0F, 0.0F, k, m);
        paramCanvas.drawBitmap(this.i, this.d, this.c, this.a);
      }
    }
    else
    {
      localObject = this.h;
      if (localObject != null)
      {
        this.d.set(0, 0, ((Bitmap)localObject).getWidth(), this.h.getHeight());
        this.c.set(0.0F, 0.0F, k, m);
        paramCanvas.drawBitmap(this.h, this.d, this.c, this.a);
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
  
  public int getShowState()
  {
    return this.e;
  }
  
  public void setProgress(long paramLong1, long paramLong2)
  {
    float f1 = Math.min(1.0F, Math.max((float)paramLong1 * 1.0F / (float)paramLong2, 0.0F));
    if (this.e == 3) {
      ThreadManager.getUIHandler().post(new ARVideoRecordButtonView.1(this, f1));
    }
  }
  
  public void setShowState(int paramInt)
  {
    this.e = paramInt;
    paramInt = this.e;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          this.f = 0.0F;
        }
      }
      else
      {
        this.g = 0.0F;
        this.f = 0.0F;
        ThreadManager.getUIHandler().post(new ARVideoRecordButtonView.2(this));
      }
    }
    else {
      super.setAlpha(1.0F);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView
 * JD-Core Version:    0.7.0.1
 */