package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

public class AEDoodlePenWidthSeekBar
  extends View
{
  private float a = 0.5F;
  private Bitmap b;
  private Bitmap c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  private int i;
  private RectF j = new RectF();
  private RectF k = new RectF();
  private Paint l;
  private float m;
  private float n;
  private boolean o;
  private AEDoodlePenWidthSeekBar.OnSeekBarChangeListener p;
  private Runnable q = new AEDoodlePenWidthSeekBar.1(this);
  
  public AEDoodlePenWidthSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AEDoodlePenWidthSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public static float a(Context paramContext)
  {
    if (paramContext == null) {
      return 0.0F;
    }
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * a(paramContext) + 0.5F);
  }
  
  private void a()
  {
    Resources localResources = getResources();
    this.b = BitmapFactory.decodeResource(localResources, 2130837905);
    this.c = BitmapFactory.decodeResource(localResources, 2130837906);
    this.d = a(getContext(), 21.25F);
    this.e = a(getContext(), 15.5F);
    this.f = a(getContext(), 270.0F);
    this.g = a(getContext(), 3.0F);
    this.i = (-a(getContext(), 18.0F));
    this.h = this.i;
    this.l = new Paint();
    this.l.setAntiAlias(true);
  }
  
  private void b()
  {
    getHandler().postDelayed(this.q, 3000L);
  }
  
  private void c()
  {
    getHandler().removeCallbacks(this.q);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.h, 0.0F);
    int i1 = getMeasuredHeight();
    float f1 = getMeasuredWidth() / 2;
    int i2 = this.e / 2;
    RectF localRectF = this.j;
    float f2 = i2;
    i2 = this.d;
    int i3 = this.g;
    localRectF.set(f1 - f2, i2 - i3, f1 + f2, i1 - i2 + i3);
    paramCanvas.drawBitmap(this.b, null, this.j, this.l);
    i2 = this.d;
    f1 = (i1 - i2 - i2) * (1.0F - this.a);
    localRectF = this.k;
    f2 = i2;
    float f3 = i2;
    float f4 = getMeasuredWidth();
    i1 = this.d;
    localRectF.set(0.0F, f2 + f1 - f3, f4, i1 + f1 + i1);
    paramCanvas.drawBitmap(this.c, null, this.k, this.l);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.d;
    paramInt1 += paramInt1;
    paramInt2 = this.f;
    int i1 = this.g;
    setMeasuredDimension(paramInt1, paramInt2 - i1 - i1 + paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return true;
        }
        if (this.o)
        {
          float f1 = paramMotionEvent.getY() - this.n;
          float f2 = this.k.centerY();
          i1 = getMeasuredHeight();
          float f3 = f2 + f1;
          int i2 = this.d;
          if (f3 < i2) {}
          for (f1 = i2;; f1 = i1 - i2)
          {
            f1 -= f2;
            break;
            if (f3 <= i1 - i2) {
              break;
            }
          }
          if (f1 != 0.0F)
          {
            Object localObject = this.k;
            ((RectF)localObject).top += f1;
            localObject = this.k;
            ((RectF)localObject).bottom += f1;
            f1 = this.k.centerY();
            i2 = this.d;
            this.a = (1.0F - (f1 - i2) / (i1 - i2 - i2));
            localObject = this.p;
            if (localObject != null) {
              ((AEDoodlePenWidthSeekBar.OnSeekBarChangeListener)localObject).a(this.a);
            }
            invalidate();
          }
        }
        this.n = paramMotionEvent.getY();
        return true;
      }
      this.o = false;
      b();
      return true;
    }
    this.m = paramMotionEvent.getX();
    this.n = paramMotionEvent.getY();
    if (this.k.contains(this.m, this.n)) {
      this.o = true;
    }
    c();
    if (this.h != 0)
    {
      this.h = 0;
      invalidate();
    }
    return true;
  }
  
  public void setOnSeekBarChangeListener(AEDoodlePenWidthSeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.p = paramOnSeekBarChangeListener;
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      if (paramFloat > 1.0F) {
        return;
      }
      this.a = paramFloat;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        invalidate();
        return;
      }
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar
 * JD-Core Version:    0.7.0.1
 */