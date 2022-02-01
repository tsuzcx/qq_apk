package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class RelativeFeedsAdapter$RelativeFeedVH$2
  implements View.OnLongClickListener
{
  RelativeFeedsAdapter$RelativeFeedVH$2(RelativeFeedsAdapter.RelativeFeedVH paramRelativeFeedVH, ExtraTypeInfo paramExtraTypeInfo, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
    if (paramView != null)
    {
      if (paramView.pageType == 7003)
      {
        RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.a, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7002) {
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.itemView instanceof RelativeFeedItemView))
    {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
        return false;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.a.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new RelativeFeedsAdapter.RelativeFeedVH.2.1(this), new RelativeFeedsAdapter.RelativeFeedVH.2.2(this));
      paramView = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.getAdapterPosition());
      localStringBuilder.append("");
      VSReporter.a(paramView, "auth_feeds", "press", 0, 0, new String[] { "", localStringBuilder.toString(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeFeedVH.2
 * JD-Core Version:    0.7.0.1
 */