package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import actj;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import ruy;
import ruz;

public class ReadInJoyColorBandEntranceButton
  extends ColorBandVideoEntranceButton
{
  private int a;
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int == 0) {
      super.c();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        i = getResources().getInteger(2131427364);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(getResources().getDrawable(2130848393));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(0);
        localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "translationX", new float[] { 0.0F, -actj.a(58.0F, getResources()) }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "translationY", new float[] { 0.0F, actj.a(54.0F, getResources()) }) });
        localAnimatorSet.setDuration(i);
        localAnimatorSet.addListener(new ruy(this));
        localAnimatorSet.start();
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    int i = getResources().getInteger(2131427365);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.b, "rotation", new float[] { 0.0F, 360.0F }) });
    setClickable(false);
    localAnimatorSet.addListener(new ruz(this));
    localAnimatorSet.setDuration(i);
    localAnimatorSet.start();
  }
  
  public void setClickAnimMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton
 * JD-Core Version:    0.7.0.1
 */