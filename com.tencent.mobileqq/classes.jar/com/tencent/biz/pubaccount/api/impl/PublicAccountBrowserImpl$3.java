package com.tencent.biz.pubaccount.api.impl;

import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskArticleTimer;

class PublicAccountBrowserImpl$3
  implements TouchWebView.OnScrollChangedListener
{
  PublicAccountBrowserImpl$3(PublicAccountBrowserImpl paramPublicAccountBrowserImpl) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    PublicAccountBrowserImpl.access$000(this.a).resetStationaryTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.3
 * JD-Core Version:    0.7.0.1
 */