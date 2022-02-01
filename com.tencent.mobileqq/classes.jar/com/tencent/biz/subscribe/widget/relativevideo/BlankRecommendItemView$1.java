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
    if (paramBoolean) {}
    for (paramStFeed = "blank_content_follow";; paramStFeed = "blank_content_unfollow")
    {
      VSReporter.b(str, "auth_follow", paramStFeed, 0, 0, new String[] { "", BlankRecommendItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoBlankRecommendItemView) + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.get(), "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.1
 * JD-Core Version:    0.7.0.1
 */