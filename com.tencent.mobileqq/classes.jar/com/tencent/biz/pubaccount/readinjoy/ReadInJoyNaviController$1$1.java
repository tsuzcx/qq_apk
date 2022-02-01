package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class ReadInJoyNaviController$1$1
  extends AnimateUtils.AnimationAdapter
{
  ReadInJoyNaviController$1$1(ReadInJoyNaviController.1 param1, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(0.0F, 0.0F, ReadInJoyNaviController.e, 0.0F);
    paramAnimation.setDuration(30L);
    paramAnimation.setAnimationListener(new ReadInJoyNaviController.1.1.1(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController$1.this$0).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.1.1
 * JD-Core Version:    0.7.0.1
 */