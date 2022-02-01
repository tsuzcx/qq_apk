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
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.mobileqq.util.DisplayUtil;

public class DragFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 0.0F;
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private DragFrameLayout.OnDraggingListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener;
  protected boolean a;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  protected boolean b;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  private float jdField_d_of_type_Float = 0.0F;
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
    DragFrameLayout.OnDraggingListener localOnDraggingListener = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener;
    if (localOnDraggingListener != null)
    {
      int i = this.jdField_b_of_type_Int;
      int j = this.jdField_c_of_type_Int;
      localOnDraggingListener.a(paramInt1, paramInt2, i, j, (int)(i * f), (int)(j * f));
    }
  }
  
  public void a()
  {
    float f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
    float f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
    Object localObject = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (localObject != null) {
      ((TranslateAnimation)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0, ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), 0, 0.0F, 0, ViewHelper.getY(this.jdField_a_of_type_AndroidViewView), 0, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    localObject = this.jdField_a_of_type_AndroidViewAnimationScaleAnimation;
    if (localObject != null) {
      ((ScaleAnimation)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    localObject = this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
    if (localObject != null) {
      ((AnimationSet)localObject).cancel();
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
    TranslateAnimation localTranslateAnimation = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (localTranslateAnimation != null) {
      localTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0, ViewHelper.getX(this.jdField_a_of_type_AndroidViewView), 0, paramInt1, 0, ViewHelper.getY(this.jdField_a_of_type_AndroidViewView), 0, paramInt2);
    localTranslateAnimation = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    long l = paramInt5;
    localTranslateAnimation.setDuration(l);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(paramAnimationListener);
    paramAnimationListener = this.jdField_a_of_type_AndroidViewAnimationScaleAnimation;
    if (paramAnimationListener != null) {
      paramAnimationListener.cancel();
    }
    float f3 = paramInt3 / super.getWidth();
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(f1, f3, f2, f3, 0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(l);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
    paramAnimationListener = this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
    if (paramAnimationListener != null) {
      paramAnimationListener.cancel();
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
    Object localObject = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    localObject = this.jdField_a_of_type_AndroidViewAnimationScaleAnimation;
    if (localObject != null)
    {
      ((ScaleAnimation)localObject).cancel();
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = null;
    }
    localObject = this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
    if (localObject != null)
    {
      ((AnimationSet)localObject).cancel();
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
      if ((this.jdField_d_of_type_Int == 0) && (f1 + f2 < DisplayUtil.a(getContext(), 10.0F))) {
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
      double d1 = Math.abs(f2);
      double d2 = Math.abs(f1);
      Double.isNaN(d2);
      if (d1 > d2 * 1.2D)
      {
        if (this.jdField_d_of_type_Int == 0)
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener.a()))
          {
            this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
            this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
            f1 = this.jdField_a_of_type_Float;
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
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener.b()))
          {
            this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
            this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
            f1 = this.jdField_a_of_type_Float;
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
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener.c()))
          {
            this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
            this.jdField_b_of_type_Float = this.jdField_d_of_type_Float;
            f1 = this.jdField_a_of_type_Float;
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
    float f2;
    float f1;
    if (i == 2)
    {
      float f3 = this.jdField_c_of_type_Float - this.jdField_a_of_type_Float;
      float f5 = this.jdField_d_of_type_Float - this.jdField_b_of_type_Float;
      i = this.jdField_d_of_type_Int;
      double d1;
      double d2;
      if (i == 1)
      {
        if (f5 > 0.0F)
        {
          d1 = this.jdField_c_of_type_Int;
          d2 = f5;
          Double.isNaN(d2);
          Double.isNaN(d1);
          i = (int)(d1 - d2 * 1.1D);
        }
        else
        {
          i = this.jdField_c_of_type_Int;
        }
        f2 = i;
        f1 = this.jdField_b_of_type_Int * f2 / this.jdField_c_of_type_Int;
      }
      else
      {
        if (i == 2)
        {
          if (f3 < 0.0F)
          {
            d1 = this.jdField_b_of_type_Int;
            d2 = f3;
            Double.isNaN(d2);
            Double.isNaN(d1);
            i = (int)(d1 + d2 * 1.1D);
          }
          else
          {
            i = this.jdField_b_of_type_Int;
          }
          f1 = i;
          f2 = this.jdField_c_of_type_Int * f1;
        }
        for (i = this.jdField_b_of_type_Int;; i = this.jdField_b_of_type_Int)
        {
          f2 /= i;
          break label339;
          if (i != 4) {
            break;
          }
          if (f3 > 0.0F)
          {
            d1 = this.jdField_b_of_type_Int;
            d2 = f3;
            Double.isNaN(d2);
            Double.isNaN(d1);
            i = (int)(d1 - d2 * 1.1D);
          }
          else
          {
            i = this.jdField_b_of_type_Int;
          }
          f1 = i;
          f2 = this.jdField_c_of_type_Int * f1;
        }
        f1 = 0.0F;
        f2 = 0.0F;
      }
      label339:
      i = this.jdField_a_of_type_Int;
      float f4 = f1;
      if (f1 <= i)
      {
        f4 = i;
        f2 = this.jdField_c_of_type_Int * f4 / this.jdField_b_of_type_Int;
      }
      i = this.jdField_d_of_type_Int;
      if (i == 1)
      {
        i = this.jdField_b_of_type_Int;
        f2 = f4 / i;
        f1 = this.jdField_a_of_type_Float;
        i = (int)(f3 + f1 - f4 * f1 / i);
        if (f5 > 0.0F) {
          f1 = f5;
        } else {
          f1 = f5 / 2.0F;
        }
        a(f2, i, (int)f1);
        return true;
      }
      if (i == 2)
      {
        i = this.jdField_b_of_type_Int;
        f1 = f4 / i;
        float f6 = i;
        if (f3 >= 0.0F) {
          f3 /= 2.0F;
        }
        i = (int)(f6 - f4 + f3);
        f3 = this.jdField_b_of_type_Float;
        a(f1, i, (int)(f5 + f3 - f2 * f3 / this.jdField_c_of_type_Int));
        return true;
      }
      if (i == 4)
      {
        f1 = f4 / this.jdField_b_of_type_Int;
        if (f3 <= 0.0F) {
          f3 /= 2.0F;
        }
        i = (int)f3;
        f3 = this.jdField_b_of_type_Float;
        a(f1, i, (int)(f5 + f3 - f2 * f3 / this.jdField_c_of_type_Int));
      }
      return true;
    }
    if ((i == 1) || (i == 3))
    {
      if (this.jdField_d_of_type_Int != 0)
      {
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener != null)
        {
          f1 = ViewHelper.getScaleX(this.jdField_a_of_type_AndroidViewView);
          f2 = ViewHelper.getScaleY(this.jdField_a_of_type_AndroidViewView);
          if ((f1 > 0.0F) && (f2 > 0.0F))
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener;
            View localView = this.jdField_a_of_type_AndroidViewView;
            i = this.jdField_b_of_type_Int;
            int j = this.jdField_c_of_type_Int;
            paramMotionEvent.a(localView, i, j, (int)(i * f1), (int)(j * f2), (int)ViewHelper.getX(localView), (int)ViewHelper.getY(this.jdField_a_of_type_AndroidViewView));
          }
        }
      }
      this.jdField_d_of_type_Int = 0;
    }
    return true;
  }
  
  public void setDraggableView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnDraggingListener(DragFrameLayout.OnDraggingListener paramOnDraggingListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$OnDraggingListener = paramOnDraggingListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */