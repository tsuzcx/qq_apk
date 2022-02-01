package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper.ClickItemListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class RecommendBannerItemView$1$2
  implements FeedbackSheetHelper.ClickItemListener
{
  RecommendBannerItemView$1$2(RecommendBannerItemView.1 param1) {}
  
  public void a(boolean paramBoolean)
  {
    String str3 = RecommendBannerItemView.a(this.a.a).id.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recom_");
    String str2 = "cancel";
    if (paramBoolean) {
      str1 = "cancel";
    } else {
      str1 = "dislike";
    }
    localStringBuilder.append(str1);
    String str1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(RecommendBannerItemView.a(this.a.a));
    localStringBuilder.append("");
    VSReporter.a(str3, "auth_page", str1, 0, 0, new String[] { "", localStringBuilder.toString(), RecommendBannerItemView.a(this.a.a).nick.get() });
    if (RecommendBannerItemView.a(this.a.a))
    {
      str3 = RecommendBannerItemView.a(this.a.a).id.get();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reco_");
      if (paramBoolean) {
        str1 = str2;
      } else {
        str1 = "dislike";
      }
      localStringBuilder.append(str1);
      VSReporter.a(str3, "auth_discover", localStringBuilder.toString(), 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.a.a)), RecommendBannerItemView.a(this.a.a).nick.get(), RecommendBannerItemView.a(this.a.a).desc.get() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView.1.2
 * JD-Core Version:    0.7.0.1
 */