package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;

class ReadInJoyChannelPanelFragment$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyChannelPanelFragment$2(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, ReadInJoyStaticGridView paramReadInJoyStaticGridView, View paramView) {}
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getHeight() > 0) {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(400L);
    localAlphaAnimation.setAnimationListener(new ReadInJoyChannelPanelFragment.2.1(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.2
 * JD-Core Version:    0.7.0.1
 */