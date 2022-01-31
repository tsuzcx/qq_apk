package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import sgw;

public class RefreshAnimView$3$1
  implements Runnable
{
  public RefreshAnimView$3$1(sgw paramsgw) {}
  
  public void run()
  {
    RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).setText(this.a.jdField_a_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_Boolean) {
      RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).setCompoundDrawablesWithIntrinsicBounds(2130848870, 0, 0, 0);
    }
    for (;;)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setFillAfter(true);
      RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).startAnimation(localAlphaAnimation);
      return;
      RefreshAnimView.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).setCompoundDrawablesWithIntrinsicBounds(2130848871, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.1
 * JD-Core Version:    0.7.0.1
 */