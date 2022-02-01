package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class RotationSeekBar
  extends SeekBar
{
  private static float d = -1.0F;
  private RotationSeekBar.OnRotationChangeListener a;
  private float[] b = null;
  private Paint c = null;
  private int e;
  
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
  
  private MotionEvent a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 2))
    {
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[0];
      int i = arrayOfInt[1];
      int m = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      int n = this.e;
      if (n != 90)
      {
        if (n != 180)
        {
          if (n != 270)
          {
            i = (int)paramMotionEvent.getX();
            j = (int)paramMotionEvent.getY();
          }
          else
          {
            i -= j;
            j = m - k;
          }
        }
        else
        {
          j = i - j;
          i = k - m;
        }
      }
      else
      {
        i = j - i;
        j = k - m;
      }
      paramMotionEvent.setLocation(i, j);
    }
    return paramMotionEvent;
  }
  
  private float getDensity()
  {
    if (d == -1.0F) {
      d = getContext().getResources().getDisplayMetrics().density;
    }
    return d;
  }
  
  protected int a(float paramFloat)
  {
    getDensity();
    return Math.round(paramFloat * d);
  }
  
  void a() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      RotationSeekBar.OnRotationChangeListener localOnRotationChangeListener = this.a;
      if (localOnRotationChangeListener != null) {
        this.e = localOnRotationChangeListener.a();
      }
    }
    return super.dispatchTouchEvent(a(paramMotionEvent));
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
        this.c.setColor(-3355444);
      }
      int k = a(2.0F);
      int m = i / 2;
      float[] arrayOfFloat = this.b;
      int n = arrayOfFloat.length;
      i = 0;
      while (i < n)
      {
        float f = arrayOfFloat[i];
        if ((f > 0.0F) && (f < 1.0F))
        {
          paramCanvas.save();
          paramCanvas.translate(f * j, m);
          paramCanvas.drawCircle(0.0F, 0.0F, k, this.c);
          paramCanvas.restore();
        }
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnRotationChangeListener(RotationSeekBar.OnRotationChangeListener paramOnRotationChangeListener)
  {
    this.a = paramOnRotationChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RotationSeekBar
 * JD-Core Version:    0.7.0.1
 */