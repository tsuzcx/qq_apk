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
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7003)
      {
        RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.a, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        bool1 = true;
      }
    }
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7002) {
          return true;
        }
        bool1 = bool2;
      } while (!(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.itemView instanceof RelativeFeedItemView));
      bool1 = bool2;
    } while (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.a.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new RelativeFeedsAdapter.RelativeFeedVH.2.1(this), new RelativeFeedsAdapter.RelativeFeedVH.2.2(this));
    VSReporter.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_feeds", "press", 0, 0, new String[] { "", this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.getAdapterPosition() + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeFeedVH.2
 * JD-Core Version:    0.7.0.1
 */