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
    String str2 = this.a.b.poster.id.get();
    String str1;
    if (paramBoolean) {
      str1 = "cancel";
    } else {
      str1 = "dislike";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.c.getAdapterPosition());
    localStringBuilder.append("");
    VSReporter.a(str2, "auth_feeds", str1, 0, 0, new String[] { "", localStringBuilder.toString(), this.a.b.poster.nick.get(), this.a.b.title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeFeedVH.2.2
 * JD-Core Version:    0.7.0.1
 */