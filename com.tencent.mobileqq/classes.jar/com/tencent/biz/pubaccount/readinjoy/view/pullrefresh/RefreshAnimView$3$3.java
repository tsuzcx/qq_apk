package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class RefreshAnimView$3$3
  implements OnCompositionLoadedListener
{
  RefreshAnimView$3$3(RefreshAnimView.3 param3, Runnable paramRunnable) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    RefreshAnimView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView$3.a, paramLottieComposition);
    if (paramLottieComposition != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3.3
 * JD-Core Version:    0.7.0.1
 */