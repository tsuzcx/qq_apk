package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.utils.FeedbackSheetHelper.ClickItemListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class RelativeFeedsAdapter$RelativeFeedVH$2$2
  implements FeedbackSheetHelper.ClickItemListener
{
  RelativeFeedsAdapter$RelativeFeedVH$2$2(RelativeFeedsAdapter.RelativeFeedVH.2 param2) {}
  
  public void a(boolean paramBoolean)
  {
    String str2 = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    String str1;
    if (paramBoolean) {
      str1 = "cancel";
    } else {
      str1 = "dislike";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeFeedVH.getAdapterPosition());
    localStringBuilder.append("");
    VSReporter.a(str2, "auth_feeds", str1, 0, 0, new String[] { "", localStringBuilder.toString(), this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeFeedVH.2.2
 * JD-Core Version:    0.7.0.1
 */