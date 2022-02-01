package com.tencent.biz.subscribe.account_folder.recommend_banner;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper.ResultListener;
import com.tencent.mobileqq.widget.QQToast;

class RecommendBannerFeedItemView$2
  implements FeedbackSheetHelper.ResultListener
{
  RecommendBannerFeedItemView$2(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      SimpleEventBus.getInstance().dispatchEvent(new RecommendFeedbackEvent(RecommendBannerFeedItemView.a(this.a)));
      return;
    }
    QQToast.a(this.a.getContext(), 2131719379, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView.2
 * JD-Core Version:    0.7.0.1
 */