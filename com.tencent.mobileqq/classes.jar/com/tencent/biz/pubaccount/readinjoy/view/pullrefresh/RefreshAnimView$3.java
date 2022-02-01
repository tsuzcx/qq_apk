package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

class RefreshAnimView$3
  implements Animation.AnimationListener
{
  RefreshAnimView$3(RefreshAnimView paramRefreshAnimView, String paramString, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    long l = Aladdin.getConfig(222).getIntegerFromString("refresh_bar_text_delay_time", 100);
    RefreshAnimView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView).postDelayed(new RefreshAnimView.3.1(this), l);
    paramAnimation = new RefreshAnimView.3.2(this);
    if (RefreshAnimView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView) != null)
    {
      paramAnimation.run();
      return;
    }
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.getContext(), "readinjoy_refresh_animation.json", new RefreshAnimView.3.3(this, paramAnimation));
      return;
    }
    catch (Exception paramAnimation)
    {
      QLog.e("RefreshAnimView", 2, "fromAssetFileName", paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView.3
 * JD-Core Version:    0.7.0.1
 */