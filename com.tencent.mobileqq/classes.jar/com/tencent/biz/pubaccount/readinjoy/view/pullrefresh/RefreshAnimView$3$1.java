package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;

class RefreshAnimView$3$1
  implements Runnable
{
  RefreshAnimView$3$1(RefreshAnimView.3 param3) {}
  
  public void run()
  {
    RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).setText(this.a.jdField_a_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_Boolean) {
      RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).setCompoundDrawablesWithIntrinsicBounds(2130849837, 0, 0, 0);
    }
    for (;;)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setFillAfter(true);
      RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).startAnimation(localAlphaAnimation);
      return;
      RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).setCompoundDrawablesWithIntrinsicBounds(2130849838, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.1
 * JD-Core Version:    0.7.0.1
 */