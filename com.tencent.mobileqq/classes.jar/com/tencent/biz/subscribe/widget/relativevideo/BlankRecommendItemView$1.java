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
    String str = this.a.id.get();
    if (paramBoolean) {
      paramStFeed = "blank_content_follow";
    } else {
      paramStFeed = "blank_content_unfollow";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BlankRecommendItemView.a(this.b));
    localStringBuilder.append("");
    VSReporter.b(str, "auth_follow", paramStFeed, 0, 0, new String[] { "", localStringBuilder.toString(), this.a.nick.get(), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView.1
 * JD-Core Version:    0.7.0.1
 */