package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelativeFeedsAdapter$RelativeFeedVH$1
  implements View.OnClickListener
{
  RelativeFeedsAdapter$RelativeFeedVH$1(RelativeFeedsAdapter.RelativeFeedVH paramRelativeFeedVH, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if (((this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.itemView instanceof RelativeFeedItemView)) && (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.a) != null)) {
      RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.a).a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.itemView, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeFeedVH.1
 * JD-Core Version:    0.7.0.1
 */