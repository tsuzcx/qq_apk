package com.tencent.mobileqq.armap;

import abem;
import aben;
import abeo;
import abep;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

public class ShopScanDragView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private float c;
  private float d;
  private float e;
  
  public ShopScanDragView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ShopScanDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ShopScanDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.e = (1.5F * ViewConfiguration.get(getContext()).getScaledPagingTouchSlop());
    float f = getResources().getDisplayMetrics().density;
    this.c = ((int)(300.0F * f));
    this.d = ((int)(f * 80.0F));
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      f();
      return;
    }
    e();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { getTranslationY(), 0.0F });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.addListener(new abem(this));
    g();
    localObjectAnimator.start();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[] { getTranslationY(), getHeight() - this.d });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.addListener(new aben(this));
    h();
    localObjectAnimator.start();
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null)) {}
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(100L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator2.setDuration(100L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.addListener(new abeo(this));
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.start();
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null)) {}
    while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator1.setDuration(100L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(100L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.addListener(new abep(this));
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.start();
  }
  
  public void a()
  {
    f();
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      f();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    float f3 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      this.jdField_a_of_type_Float = f3;
      this.jdField_b_of_type_Float = f2;
      return true;
    case 2: 
      f2 = f2 - this.jdField_b_of_type_Float + super.getTranslationY();
      if (f2 > getHeight() - this.d) {
        f1 = getHeight() - this.d;
      }
      for (;;)
      {
        super.setTranslationY(f1);
        return true;
        if (f2 >= 0.0F) {
          f1 = f2;
        }
      }
    }
    f1 = f3 - this.jdField_a_of_type_Float;
    f2 -= this.jdField_b_of_type_Float;
    if (f1 * f1 + f2 * f2 < this.e)
    {
      d();
      return true;
    }
    if (getTranslationY() < (getHeight() - this.d) / 2.0F)
    {
      e();
      return true;
    }
    f();
    return true;
  }
  
  public void setAnimHeight(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setAnimView(View paramView1, View paramView2)
  {
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    if ((paramView1 == null) || (paramView2 == null)) {
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ShopScanDragView
 * JD-Core Version:    0.7.0.1
 */