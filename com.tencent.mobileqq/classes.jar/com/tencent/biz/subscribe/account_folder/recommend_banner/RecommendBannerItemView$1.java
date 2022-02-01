package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class RecommendBannerItemView$1
  implements View.OnLongClickListener
{
  RecommendBannerItemView$1(RecommendBannerItemView paramRecommendBannerItemView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (RecommendBannerItemView.a(this.a) == null) {
      return false;
    }
    FeedbackSheetHelper.a(this.a.getContext(), RecommendBannerItemView.a(this.a), new RecommendBannerItemView.1.1(this), new RecommendBannerItemView.1.2(this));
    if (RecommendBannerItemView.a(this.a)) {
      VSReporter.a(RecommendBannerItemView.a(this.a).id.get(), "auth_discover", "reco_press", 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.a)), RecommendBannerItemView.a(this.a).nick.get(), RecommendBannerItemView.a(this.a).desc.get() });
    }
    for (;;)
    {
      return true;
      VSReporter.a(RecommendBannerItemView.a(this.a).id.get(), "auth_page", "recom_remove", 0, 0, new String[] { "", RecommendBannerItemView.a(this.a) + "", RecommendBannerItemView.a(this.a).nick.get() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView.1
 * JD-Core Version:    0.7.0.1
 */