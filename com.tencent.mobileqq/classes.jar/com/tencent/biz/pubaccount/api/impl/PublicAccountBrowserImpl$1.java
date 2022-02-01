package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskArticleTimer;

class PublicAccountBrowserImpl$1
  implements Runnable
{
  PublicAccountBrowserImpl$1(PublicAccountBrowserImpl paramPublicAccountBrowserImpl, String paramString) {}
  
  public void run()
  {
    PublicAccountBrowserImpl.access$000(this.this$0).resetStationaryTime();
    PublicAccountBrowserImpl localPublicAccountBrowserImpl = this.this$0;
    PublicAccountBrowserImpl.access$100(localPublicAccountBrowserImpl, localPublicAccountBrowserImpl.getIntent().getStringExtra("url"));
    PublicAccountBrowserImpl.access$200(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.1
 * JD-Core Version:    0.7.0.1
 */