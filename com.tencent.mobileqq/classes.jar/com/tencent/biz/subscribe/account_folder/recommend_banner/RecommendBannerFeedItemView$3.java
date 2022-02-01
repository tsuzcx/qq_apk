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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recom_");
    if (paramBoolean) {
      str1 = "cancel";
    } else {
      str1 = "dislike";
    }
    localStringBuilder.append(str1);
    String str1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(RecommendBannerFeedItemView.b(this.a));
    localStringBuilder.append("");
    VSReporter.a(str2, "auth_page", str1, 0, 0, new String[] { "", localStringBuilder.toString(), RecommendBannerFeedItemView.a(this.a).poster.nick.get(), RecommendBannerFeedItemView.a(this.a).title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView.3
 * JD-Core Version:    0.7.0.1
 */