package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.FollowChangeListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class BlankRecommendItemView$1
  implements FollowTextView.FollowChangeListener
{
  BlankRecommendItemView$1(BlankRecommendItemView paramBlankRecommendItemView, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.get();
    if (paramBoolean) {
      paramStFeed = "blank_content_follow";
    } else {
      paramStFeed = "blank_content_unfollow";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BlankRecommendItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoBlankRecommendItemView));
    localStringBuilder.append("");
    VSReporter.b(str, "auth_follow", paramStFeed, 0, 0, new String[] { "", localStringBuilder.toString(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get(), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.1
 * JD-Core Version:    0.7.0.1
 */