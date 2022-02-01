package com.tencent.biz.subscribe.account_folder.recommend_banner;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper.ResultListener;

class RecommendBannerItemView$1$1
  implements FeedbackSheetHelper.ResultListener
{
  RecommendBannerItemView$1$1(RecommendBannerItemView.1 param1) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      SimpleEventBus.getInstance().dispatchEvent(new RecommendFeedbackEvent(RecommendBannerItemView.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView.1.1
 * JD-Core Version:    0.7.0.1
 */