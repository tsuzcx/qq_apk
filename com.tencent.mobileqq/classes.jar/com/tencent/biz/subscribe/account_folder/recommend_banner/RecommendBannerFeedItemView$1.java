package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.ItemPreClickListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class RecommendBannerFeedItemView$1
  implements BaseWidgetView.ItemPreClickListener
{
  RecommendBannerFeedItemView$1(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void a()
  {
    if (RecommendBannerFeedItemView.a(this.a) == null) {
      return;
    }
    String str = RecommendBannerFeedItemView.a(this.a).poster.id.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(RecommendBannerFeedItemView.b(this.a));
    localStringBuilder.append("");
    VSReporter.a(str, "auth_page", "recom_follow_b", 0, 0, new String[] { "", localStringBuilder.toString(), RecommendBannerFeedItemView.a(this.a).poster.nick.get(), RecommendBannerFeedItemView.a(this.a).title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView.1
 * JD-Core Version:    0.7.0.1
 */