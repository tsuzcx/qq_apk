package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import bdaq;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import nmk;

public class DragFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private nmk jdField_a_of_type_Nmk;
  protected boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  protected boolean b;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 0;
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    ViewHelper.setPivotX(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewHelper.setPivotY(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewHelper.setScaleX(this.jdField_a_of_type_AndroidViewView, f);
    ViewHelper.setScaleY(this.jdField_a_of_type_AndroidViewView, f);
    ViewHelper.setX(this.jdField_a_of_type_AndroidViewView, paramInt1);
    ViewHelper.setY(this.jdField_a_of_type_AndroidViewView, paramInt2);
    if (this.jdField_a_of_type_Nmk != null) {
      this.jdField_a_of_type_Nmk.a(paramInt1, paramInt2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, (int)(this.jdField_b_of_type_Int * f), (int)(this.jdField_c_of_type_Int * f));
    }
  }
  
  public void a()
  {
    float f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
    float f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0, ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), 0, 0.0F, 0, ViewHelper.getY(this.jdField_a_of_type_AndroidViewView), 0, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Animation.AnimationListener paramAnimationListener)
  {
    float f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
    float f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0, ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), 0, paramInt1, 0, ViewHelper.getY(this.jdField_a_of_type_AndroidViewView), 0, paramInt2);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(paramInt5);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(paramAnimationListener);
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.cancel();
    }
    float f3 = paramInt3 / super.getWidth();
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, f3, f2, f3, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(paramInt5);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidViewView).reset();
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = null;
    }
    super.removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    this.jdField_c_of_type_Float = paramMotionEvent.getX();
    this.jdField_d_of_type_Float = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
      this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_b_of_type_Int = super.getWidth();
        this.jdField_c_of_type_Int = super.getHeight();
      }
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      float f1 = Math.abs(this.jdField_c_of_type_Float - this.jdField_a_of_type_Float);
      float f2 = Math.abs(this.jdField_d_of_type_Float - this.jdField_b_of_type_Float);
      if ((this.jdField_d_of_type_Int == 0) && (f1 + f2 < bdaq.a(getContext(), 10.0F))) {
        return false;
      }
      f1 = this.jdField_c_of_type_Float - this.jdField_a_of_type_Float;
      f2 = this.jdField_d_of_type_Float - this.jdField_b_of_type_Float;
      if ((f2 < 0.0F) && (Math.abs(f2) > Math.abs(f1)) && (this.jdField_d_of_type_Int == 0))
      {
        this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
        this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
        return false;
      }
      if (Math.abs(f2) > 1.2D * Math.abs(f1))
      {
        if (this.jdField_d_of_type_Int == 0)
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Nmk.a()))
          {
            this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
            this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
            f1 = this.jdField_c_of_type_Float;
            f1 = this.jdField_a_of_type_Float;
            f1 = this.jdField_d_of_type_Float;
            f1 = this.jdField_b_of_type_Float;
            this.jdField_d_of_type_Int = 1;
            return true;
          }
          this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
          this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
          return false;
        }
      }
      else if (f1 < 0.0F)
      {
        if (this.jdField_d_of_type_Int == 0)
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Nmk.b()))
          {
            this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
            this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
            f1 = this.jdField_c_of_type_Float;
            f1 = this.jdField_a_of_type_Float;
            f1 = this.jdField_d_of_type_Float;
            f1 = this.jdField_b_of_type_Float;
            this.jdField_d_of_type_Int = 2;
            return true;
          }
          this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
          this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
          return false;
        }
      }
      else if (f1 > 0.0F)
      {
        if (this.jdField_d_of_type_Int == 0)
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Nmk.c()))
          {
            this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
            this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
            f1 = this.jdField_c_of_type_Float;
            f1 = this.jdField_a_of_type_Float;
            f1 = this.jdField_d_of_type_Float;
            f1 = this.jdField_b_of_type_Float;
            this.jdField_d_of_type_Int = 4;
            return true;
          }
          this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
          this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
        this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
        return false;
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    this.jdField_c_of_type_Float = paramMotionEvent.getX();
    this.jdField_d_of_type_Float = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
      this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
      return true;
    }
    float f3;
    float f5;
    float f1;
    float f4;
    float f2;
    if (i == 2)
    {
      f3 = this.jdField_c_of_type_Float - this.jdField_a_of_type_Float;
      f5 = this.jdField_d_of_type_Float - this.jdField_b_of_type_Float;
      if (this.jdField_d_of_type_Int == 1) {
        if (f5 > 0.0F)
        {
          f1 = (int)(this.jdField_c_of_type_Int - f5 * 1.1D);
          f4 = this.jdField_b_of_type_Int * f1 / this.jdField_c_of_type_Int;
          f2 = f1;
          f1 = f4;
        }
      }
    }
    for (;;)
    {
      f4 = f1;
      if (f1 <= this.jdField_a_of_type_Int)
      {
        f4 = this.jdField_a_of_type_Int;
        f2 = this.jdField_c_of_type_Int * f4 / this.jdField_b_of_type_Int;
      }
      if (this.jdField_d_of_type_Int == 1)
      {
        f2 = f4 / this.jdField_b_of_type_Int;
        i = (int)(f3 + this.jdField_a_of_type_Float - f4 * this.jdField_a_of_type_Float / this.jdField_b_of_type_Int);
        if (f5 > 0.0F) {}
        for (f1 = f5;; f1 = f5 / 2.0F)
        {
          a(f2, i, (int)f1);
          return true;
          f1 = this.jdField_c_of_type_Int;
          break;
          if (this.jdField_d_of_type_Int == 2)
          {
            if (f3 < 0.0F) {}
            for (f1 = (int)(this.jdField_b_of_type_Int + f3 * 1.1D);; f1 = this.jdField_b_of_type_Int)
            {
              f2 = this.jdField_c_of_type_Int * f1 / this.jdField_b_of_type_Int;
              break;
            }
          }
          if (this.jdField_d_of_type_Int != 4) {
            break label621;
          }
          if (f3 > 0.0F) {}
          for (f1 = (int)(this.jdField_b_of_type_Int - f3 * 1.1D);; f1 = this.jdField_b_of_type_Int)
          {
            f2 = this.jdField_c_of_type_Int * f1 / this.jdField_b_of_type_Int;
            break;
          }
        }
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        f1 = f4 / this.jdField_b_of_type_Int;
        float f6 = this.jdField_b_of_type_Int;
        if (f3 < 0.0F) {}
        for (;;)
        {
          a(f1, (int)(f3 + (f6 - f4)), (int)(this.jdField_b_of_type_Float + f5 - f2 * this.jdField_b_of_type_Float / this.jdField_c_of_type_Int));
          return true;
          f3 /= 2.0F;
        }
      }
      if (this.jdField_d_of_type_Int != 4) {
        break;
      }
      f1 = f4 / this.jdField_b_of_type_Int;
      if (f3 > 0.0F) {}
      for (;;)
      {
        a(f1, (int)f3, (int)(f5 + this.jdField_b_of_type_Float - f2 * this.jdField_b_of_type_Float / this.jdField_c_of_type_Int));
        return true;
        f3 /= 2.0F;
      }
      if ((i != 1) && (i != 3)) {
        break;
      }
      if (this.jdField_d_of_type_Int != 0)
      {
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Nmk != null)
        {
          f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
          f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
          if ((f1 > 0.0F) && (f2 > 0.0F)) {
            this.jdField_a_of_type_Nmk.a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, (int)(f1 * this.jdField_b_of_type_Int), (int)(f2 * this.jdField_c_of_type_Int), (int)ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), (int)ViewHelper.getY(this.jdField_a_of_type_AndroidViewView));
          }
        }
      }
      this.jdField_d_of_type_Int = 0;
      return true;
      label621:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void setDraggableView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnDraggingListener(nmk paramnmk)
  {
    this.jdField_a_of_type_Nmk = paramnmk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */