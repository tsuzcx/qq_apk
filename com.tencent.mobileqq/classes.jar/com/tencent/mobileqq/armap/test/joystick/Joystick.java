package com.tencent.mobileqq.armap.test.joystick;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class Joystick
  extends FrameLayout
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private JoystickListener jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f;
  
  public Joystick(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public Joystick(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public Joystick(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  @TargetApi(11)
  private void a(float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    float f1 = this.jdField_d_of_type_Float + paramFloat1 - this.jdField_a_of_type_Float;
    paramFloat1 = this.jdField_e_of_type_Float + paramFloat2 - this.jdField_b_of_type_Float;
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      paramFloat2 = f1;
      f1 = (float)Math.sqrt(paramFloat2 * paramFloat2 + paramFloat1 * paramFloat1);
      if (paramFloat2 * paramFloat2 + paramFloat1 * paramFloat1 > this.jdField_c_of_type_Float * this.jdField_c_of_type_Float)
      {
        paramFloat2 = paramFloat2 * this.jdField_c_of_type_Float / f1;
        paramFloat1 = paramFloat1 * this.jdField_c_of_type_Float / f1;
        f1 = this.jdField_c_of_type_Float;
      }
      break;
    }
    for (;;)
    {
      float f3 = (float)(Math.atan2(-paramFloat1, paramFloat2) * 180.0D / 3.141592653589793D);
      JoystickListener localJoystickListener;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener != null)
      {
        localJoystickListener = this.jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener;
        if (0.0F != this.jdField_c_of_type_Float) {
          break label193;
        }
      }
      label193:
      for (f1 = f2;; f1 /= this.jdField_c_of_type_Float)
      {
        localJoystickListener.a(f3, f1);
        this.jdField_a_of_type_AndroidViewView.setTranslationX(paramFloat2);
        this.jdField_a_of_type_AndroidViewView.setTranslationY(paramFloat1);
        return;
        paramFloat1 = 0.0F;
        paramFloat2 = f1;
        break;
        paramFloat2 = 0.0F;
        break;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    float f2;
    if (a())
    {
      View localView = getChildAt(0);
      f2 = localView.getWidth() / 2.0F;
      f1 = localView.getHeight() / 2.0F;
    }
    for (;;)
    {
      switch (this.jdField_c_of_type_Int)
      {
      default: 
        return;
      case 1: 
        this.jdField_c_of_type_Float = (Math.min(paramInt1, paramInt2) / 2.0F - Math.max(f2, f1));
        return;
      case 2: 
        this.jdField_c_of_type_Float = (paramInt1 / 2.0F - f2);
        return;
      }
      this.jdField_c_of_type_Float = (paramInt2 / 2.0F - f1);
      return;
      f2 = 0.0F;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    if (paramAttributeSet != null)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_Int = 1;
    }
  }
  
  private boolean a()
  {
    return getChildCount() > 0;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.findPointerIndex(this.jdField_b_of_type_Int);
    float f2 = paramMotionEvent.getX(i);
    float f1 = paramMotionEvent.getY(i);
    f2 = Math.abs(f2 - this.jdField_d_of_type_Float);
    f1 = Math.abs(f1 - this.jdField_e_of_type_Float);
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while (f1 * f1 + f2 * f2 > this.jdField_a_of_type_Int * this.jdField_a_of_type_Int);
        return false;
      } while (f2 > this.jdField_a_of_type_Int);
      return false;
    } while (f1 > this.jdField_a_of_type_Int);
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener.a();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener.b();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  @TargetApi(14)
  private void d()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    this.jdField_a_of_type_AndroidViewView.animate().cancel();
    a(0.0F, 0.0F);
  }
  
  @TargetApi(14)
  private void e()
  {
    this.jdField_b_of_type_Boolean = false;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.animate().translationX(0.0F).translationY(0.0F).setDuration(100L).setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator).start();
    }
    c();
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void addView(@NonNull View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("Joystick can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FrameLayout.LayoutParams;
  }
  
  public FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new FrameLayout.LayoutParams(-2, -2, 17);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(@NonNull ViewGroup.LayoutParams paramLayoutParams)
  {
    paramLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
    paramLayoutParams.gravity = 17;
    return paramLayoutParams;
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = new FrameLayout.LayoutParams(getContext(), paramAttributeSet);
    paramAttributeSet.gravity = 17;
    return paramAttributeSet;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    do
    {
      do
      {
        do
        {
          return false;
          switch (paramMotionEvent.getActionMasked())
          {
          case 4: 
          case 5: 
          default: 
            return false;
          }
        } while ((this.jdField_a_of_type_Boolean) || (!a()));
        this.jdField_d_of_type_Float = paramMotionEvent.getX(0);
        this.jdField_e_of_type_Float = paramMotionEvent.getY(0);
        this.jdField_b_of_type_Int = paramMotionEvent.getPointerId(0);
        b();
        return false;
      } while ((-1 == this.jdField_b_of_type_Int) || (!this.jdField_a_of_type_Boolean) || (!a(paramMotionEvent)));
      d();
      return true;
    } while (paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()) != this.jdField_b_of_type_Int);
    a();
    c();
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.f)) {
      a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((j == 1073741824) && (i > 0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      super.onMeasure(paramInt1, paramInt1);
      return;
      if ((paramInt1 == 1073741824) && (paramInt2 > 0))
      {
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = i;
        if (i >= paramInt2) {
          paramInt1 = paramInt2;
        }
      }
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = (paramInt1 / 2.0F);
    this.jdField_b_of_type_Float = (paramInt2 / 2.0F);
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            switch (paramMotionEvent.getActionMasked())
            {
            case 4: 
            case 5: 
            default: 
              return false;
            }
          } while (!this.jdField_a_of_type_Boolean);
          if (this.jdField_d_of_type_Boolean) {
            d();
          }
          return true;
        } while (-1 == this.jdField_b_of_type_Int);
        if (this.jdField_b_of_type_Boolean)
        {
          int i = paramMotionEvent.findPointerIndex(this.jdField_b_of_type_Int);
          float f1 = paramMotionEvent.getX(i);
          float f2 = paramMotionEvent.getY(i);
          a(f1 - this.jdField_d_of_type_Float, f2 - this.jdField_e_of_type_Float);
          return true;
        }
      } while ((!this.jdField_a_of_type_Boolean) || (!a(paramMotionEvent)));
      d();
      return true;
    } while (paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()) != this.jdField_b_of_type_Int);
    a();
    if (this.jdField_b_of_type_Boolean) {
      e();
    }
    for (;;)
    {
      return true;
      c();
    }
  }
  
  public void setJoystickListener(JoystickListener paramJoystickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapTestJoystickJoystickListener = paramJoystickListener;
    if (!a()) {
      Log.w("Joystick", "Joystick has no draggable stick, and is therefore not functional. Consider adding a child view to act as the stick.");
    }
  }
  
  public void setMotionConstraint(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (!this.f) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void setStartOnFirstTouch(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setTouchSlop(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.test.joystick.Joystick
 * JD-Core Version:    0.7.0.1
 */