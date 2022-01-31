package com.tencent.mobileqq.activity.aio.anim.goldmsg;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.qphone.base.util.QLog;
import uty;

public class GoldMsgLayAnim
  extends BaseGoldMsgAnimator
{
  ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new uty(this);
  public ValueAnimator a;
  View jdField_a_of_type_AndroidViewView;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  public int b;
  public ValueAnimator b;
  RotateAnimation b;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private int d = 300;
  private int e;
  
  public GoldMsgLayAnim(int paramInt, GoldMsgAnimatorCtr paramGoldMsgAnimatorCtr, RelativeLayout paramRelativeLayout)
  {
    super(paramInt, paramGoldMsgAnimatorCtr, paramRelativeLayout);
    this.jdField_a_of_type_AndroidViewView = paramRelativeLayout.findViewById(2131362401);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramRelativeLayout.findViewById(2131372525));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramRelativeLayout.findViewById(2131372523));
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 }).setDuration(this.d);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 }).setDuration(this.d);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(360.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(this.d);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(this.d);
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 10.0F + 0.5F));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.cancel();
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.cancel();
  }
  
  public void a()
  {
    super.a();
    c();
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.a(2, null);
    } while (!QLog.isDevelopLevel());
    QLog.d("GoldMsgLayAnim", 4, "end...");
  }
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("animType", -1);
    if ((this.e == i) && (this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      super.a(paramBundle);
      this.e = i;
      this.jdField_c_of_type_Boolean = paramBundle.getBoolean("fromClick", false);
      if (this.e == 1)
      {
        if (!this.jdField_c_of_type_Boolean) {}
        for (double d1 = (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.b - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.a) / 100.0D;; d1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.b / 100.0D)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(NumAnim.formatNumber(d1, true));
          i = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.measure(i, i);
          this.jdField_b_of_type_Int = (this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() + this.jdField_c_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
          this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width = 0;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
          c();
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
          return;
        }
      }
    } while (this.e != 0);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationRotateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgLayAnim
 * JD-Core Version:    0.7.0.1
 */