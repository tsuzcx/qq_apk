package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import ahzz;
import aiaa;
import aiad;
import aiaf;
import aiag;
import aiah;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import bbkx;

public class VideoFrameSelectBar
  extends View
  implements ahzz, aiad, aiag
{
  private static final int jdField_a_of_type_Int = bbkx.a(13.0F);
  private float jdField_a_of_type_Float;
  private aiaa jdField_a_of_type_Aiaa;
  private aiaf jdField_a_of_type_Aiaf;
  private aiah jdField_a_of_type_Aiah;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 3000;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  private float e;
  private float f;
  private float g;
  private float h;
  
  public VideoFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / this.jdField_d_of_type_Float * this.jdField_c_of_type_Int;
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aiaf.a(paramMotionEvent);
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aiaa.a(paramMotionEvent);
  }
  
  private void e()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaLangString = String.format("%.1f''", new Object[] { Float.valueOf(this.g / 1000.0F) });
    this.h = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Aiah != null) {
      this.jdField_a_of_type_Aiah.a(this.g);
    }
  }
  
  public float a()
  {
    return this.e + this.f;
  }
  
  void a()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.f = a((int)(paramFloat1 - this.jdField_a_of_type_Aiaf.b()));
    this.g = a(paramFloat2 - paramFloat1);
    f();
    this.jdField_a_of_type_Aiaa.a((int)paramFloat1);
    this.jdField_a_of_type_Aiaa.b((int)paramFloat2);
    invalidate();
    if (this.jdField_a_of_type_Aiah != null) {
      this.jdField_a_of_type_Aiah.a((int)a(), (int)b());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.e = a(paramFloat1);
    f();
    if (this.jdField_a_of_type_Aiaf != null) {
      this.jdField_a_of_type_Aiaf.a(paramFloat2, paramFloat3);
    }
    if (this.jdField_a_of_type_Aiah != null) {
      this.jdField_a_of_type_Aiah.a((int)a(), (int)b());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt < 12000) {
      this.jdField_c_of_type_Int = 2000;
    }
    for (int i = (int)Math.ceil(1.0F * paramInt / 2000.0F);; i = 6)
    {
      int j = getResources().getDisplayMetrics().widthPixels;
      float f1 = j * 0.925F / 6.0F;
      this.jdField_d_of_type_Float = f1;
      this.jdField_c_of_type_Float = f1;
      this.jdField_a_of_type_Aiaf = new aiaf(this, this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, i, this.jdField_c_of_type_Int, j, paramInt);
      this.jdField_a_of_type_Aiaf.a(this);
      this.g = a(this.jdField_a_of_type_Aiaf.c());
      f();
      this.jdField_a_of_type_Aiaa = new aiaa(this, paramString, paramInt, i, this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, j, this.jdField_a_of_type_Aiaf.b(), this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Aiaa.a(this);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_d_of_type_Boolean = true;
      return;
      this.jdField_c_of_type_Int = (paramInt / 6);
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public float b()
  {
    return this.e + this.f + this.g;
  }
  
  void b()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aiaf != null) {
      this.jdField_a_of_type_Aiaf.a();
    }
    if (this.jdField_a_of_type_Aiaa != null) {
      this.jdField_a_of_type_Aiaa.b();
    }
    this.jdField_d_of_type_Boolean = false;
    this.e = 0.0F;
    this.f = 0.0F;
    this.g = 0.0F;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Aiaa == null) || (this.jdField_a_of_type_Aiaf == null)) {}
    while ((!this.jdField_a_of_type_Aiaa.a()) && (!this.jdField_a_of_type_Aiaf.a())) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aiaf != null) {
      this.jdField_a_of_type_Aiaf.b();
    }
    if (this.jdField_a_of_type_Aiaa != null) {
      this.jdField_a_of_type_Aiaa.b();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = false;
    this.e = 0.0F;
    this.f = 0.0F;
    this.g = 0.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Aiaf == null) || (this.jdField_a_of_type_Aiaa == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(40.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.translate(0.0F, jdField_a_of_type_Int + 50);
    if (this.jdField_a_of_type_Aiaa != null) {
      this.jdField_a_of_type_Aiaa.a(paramCanvas);
    }
    if (this.jdField_a_of_type_Aiaf != null) {
      this.jdField_a_of_type_Aiaf.a(paramCanvas);
    }
    paramCanvas.translate(0.0F, -jdField_a_of_type_Int - 50);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aiaf == null) || (this.jdField_a_of_type_Aiaa == null))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)(50.0F + this.jdField_a_of_type_Aiaf.a() + jdField_a_of_type_Int));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Aiaf != null) && (this.jdField_a_of_type_Aiaa != null))
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        }
        while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
        {
          return true;
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.jdField_b_of_type_Float = paramMotionEvent.getY();
          this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aiaf.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float - 50.0F);
          this.jdField_b_of_type_Boolean = false;
          if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
            return super.onTouchEvent(paramMotionEvent);
          }
          setPressed(true);
          invalidate();
          a();
          a(paramMotionEvent);
          e();
          continue;
          if (b())
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)
          {
            setPressed(true);
            invalidate();
            a();
            a(paramMotionEvent);
            e();
            continue;
            if (b())
            {
              a(paramMotionEvent);
              b();
              setPressed(false);
            }
            for (;;)
            {
              invalidate();
              break;
              a();
              a(paramMotionEvent);
              b();
            }
            if (b())
            {
              b();
              a(paramMotionEvent);
              setPressed(false);
            }
            invalidate();
          }
        }
      }
    }
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
  }
  
  public void setOnFramesClipChangeListener(aiah paramaiah)
  {
    this.jdField_a_of_type_Aiah = paramaiah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */