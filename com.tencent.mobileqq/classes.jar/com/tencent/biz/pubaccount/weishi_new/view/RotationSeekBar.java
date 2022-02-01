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
import uuw;

public class RotationSeekBar
  extends SeekBar
{
  private static float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private uuw jdField_a_of_type_Uuw;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
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
  
  private float a()
  {
    if (jdField_a_of_type_Float == -1.0F) {
      jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_a_of_type_Float;
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent)
  {
    int i;
    int m;
    int k;
    int n;
    int j;
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 2))
    {
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      i = arrayOfInt[0];
      m = arrayOfInt[1];
      k = (int)paramMotionEvent.getRawX();
      n = (int)paramMotionEvent.getRawY();
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        j = (int)paramMotionEvent.getX();
        i = (int)paramMotionEvent.getY();
      }
    }
    for (;;)
    {
      paramMotionEvent.setLocation(j, i);
      return paramMotionEvent;
      j = n - m;
      i -= k;
      continue;
      j = i - k;
      i = m - n;
      continue;
      j = m - n;
      i = k - i;
    }
  }
  
  protected int a(float paramFloat)
  {
    a();
    return Math.round(jdField_a_of_type_Float * paramFloat);
  }
  
  void a() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Uuw != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Uuw.a();
    }
    MotionEvent localMotionEvent;
    if (this.jdField_a_of_type_Int == 0)
    {
      localMotionEvent = paramMotionEvent;
      if (this.jdField_a_of_type_Int == 360) {}
    }
    else
    {
      localMotionEvent = a(paramMotionEvent);
    }
    return super.dispatchTouchEvent(localMotionEvent);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ArrayOfFloat != null)
    {
      int j = getMeasuredWidth();
      int i = getMeasuredHeight();
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-3355444);
      }
      int k = a(2.0F);
      int m = i / 2;
      float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      int n = arrayOfFloat.length;
      i = 0;
      while (i < n)
      {
        float f = arrayOfFloat[i];
        if ((f > 0.0F) && (f < 1.0F))
        {
          paramCanvas.save();
          paramCanvas.translate(f * j, m);
          paramCanvas.drawCircle(0.0F, 0.0F, k, this.jdField_a_of_type_AndroidGraphicsPaint);
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
  
  public void setOnRotationChangeListener(uuw paramuuw)
  {
    this.jdField_a_of_type_Uuw = paramuuw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RotationSeekBar
 * JD-Core Version:    0.7.0.1
 */