package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper.ClickItemListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class RecommendBannerFeedItemView$3
  implements FeedbackSheetHelper.ClickItemListener
{
  RecommendBannerFeedItemView$3(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void a(boolean paramBoolean)
  {
    String str2 = RecommendBannerFeedItemView.a(this.a).poster.id.get();
    StringBuilder localStringBuilder = new StringBuilder().append("recom_");
    if (paramBoolean) {}
    for (String str1 = "cancel";; str1 = "dislike")
    {
      VSReporter.a(str2, "auth_page", str1, 0, 0, new String[] { "", RecommendBannerFeedItemView.a(this.a) + "", RecommendBannerFeedItemView.a(this.a).poster.nick.get(), RecommendBannerFeedItemView.a(this.a).title.get() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView.3
 * JD-Core Version:    0.7.0.1
 */