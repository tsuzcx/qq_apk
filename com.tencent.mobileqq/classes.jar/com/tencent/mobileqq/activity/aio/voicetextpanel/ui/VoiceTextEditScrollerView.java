package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import ahse;
import ahsm;
import ahsn;
import ahtf;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.XPanelContainer;

public class VoiceTextEditScrollerView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ahse jdField_a_of_type_Ahse;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = -1;
  private float f;
  private float g;
  
  public VoiceTextEditScrollerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoiceTextEditScrollerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoiceTextEditScrollerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.jdField_a_of_type_Float = (paramContext.getScaledTouchSlop() * 2);
    this.jdField_b_of_type_Float = (3.0F * this.jdField_a_of_type_Float);
    paramContext = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
  }
  
  private float a(float paramFloat)
  {
    return paramFloat - this.jdField_e_of_type_Float;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_a_of_type_Int);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
  }
  
  private void a(int paramInt)
  {
    int i = XPanelContainer.jdField_a_of_type_Int;
    int j = getHeight();
    int k = getHeight();
    if (this.jdField_a_of_type_Ahse != null) {
      this.jdField_a_of_type_Ahse.a(this.jdField_b_of_type_Int - i - paramInt, j - i, k);
    }
    b();
  }
  
  private void a(ValueAnimator paramValueAnimator, int paramInt1, int paramInt2, View paramView)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = paramValueAnimator.getAnimatedFraction();
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec((int)(paramInt1 - paramInt2 * f2), 1073741824));
    paramView.layout(getLeft(), (int)f1, getRight(), (int)f1 + (int)(paramInt1 - f2 * paramInt2));
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Float = paramMotionEvent.getRawX();
    float f1 = paramMotionEvent.getRawY();
    this.jdField_e_of_type_Float = f1;
    this.g = f1;
    this.f = -1.0F;
    this.jdField_b_of_type_Boolean = false;
    d(paramMotionEvent);
    if (this.jdField_a_of_type_Ahse != null) {
      this.jdField_a_of_type_Ahse.a(this.jdField_b_of_type_Int);
    }
  }
  
  private boolean a(float paramFloat)
  {
    paramFloat = a(paramFloat);
    return (this.f > 2000.0F) || (paramFloat > ScreenUtil.dip2px(150.0F)) || (!this.jdField_b_of_type_Boolean);
  }
  
  private void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        ahtf.a("0X800A8A0", 3, 0);
        return;
      }
      ahtf.a("0X800A8A0", 2, 0);
      return;
    }
    ahtf.a("0X800A8A0", 1, 0);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = Math.abs(paramMotionEvent.getRawX() - this.jdField_d_of_type_Float);
    float f2 = Math.abs(paramMotionEvent.getRawY() - this.jdField_e_of_type_Float);
    int i;
    int j;
    int k;
    if ((f1 > this.jdField_a_of_type_Float) || (f2 > this.jdField_a_of_type_Float))
    {
      this.jdField_b_of_type_Boolean = true;
      if (f2 > this.jdField_b_of_type_Float) {
        c();
      }
      i = (int)(paramMotionEvent.getRawY() - this.g);
      j = getTop() + i;
      k = getBottom();
      if (j >= this.jdField_e_of_type_Int) {
        break label99;
      }
    }
    label99:
    while (j >= this.jdField_b_of_type_Int - XPanelContainer.jdField_a_of_type_Int - this.jdField_c_of_type_Int) {
      return;
    }
    setTop(j);
    setBottom(i + k);
    this.f = this.jdField_c_of_type_Float;
    this.g = paramMotionEvent.getRawY();
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Ahse != null) {
        this.jdField_a_of_type_Ahse.a();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Ahse != null)
    {
      c();
      if (a(paramMotionEvent.getRawY())) {
        a(this.jdField_c_of_type_Int);
      }
    }
    else
    {
      return;
    }
    int i = this.jdField_d_of_type_Int;
    int j = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Ahse.a(i - j, this.jdField_c_of_type_Int);
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View paramView)
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { paramInt1, paramInt2 }).setDuration(paramInt6);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new ahsm(this, paramInt4, paramInt3, paramView));
    localValueAnimator.start();
    localValueAnimator.addListener(new ahsn(this, paramInt5));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      a(paramMotionEvent);
      continue;
      d(paramMotionEvent);
      a();
      b(paramMotionEvent);
      continue;
      c(paramMotionEvent);
    }
  }
  
  public void setListener(ahse paramahse)
  {
    this.jdField_a_of_type_Ahse = paramahse;
  }
  
  public void setMaskClick(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setPanelActionDownPos(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = getTop();
  }
  
  public void setSlideEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextEditScrollerView
 * JD-Core Version:    0.7.0.1
 */