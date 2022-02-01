package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView;

class WSFollowFeedHolder$11
  implements Runnable
{
  WSFollowFeedHolder$11(WSFollowFeedHolder paramWSFollowFeedHolder) {}
  
  public void run()
  {
    boolean bool1;
    if (WSFollowFeedHolder.l(this.this$0).getVisibility() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((WSFollowFeedHolder.m(this.this$0) != null) && (WSFollowFeedHolder.n(this.this$0))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i = WSFollowFeedHolder.d(this.this$0);
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (WSFollowFeedHolder.e(this.this$0) != null) {
      localstSimpleMetaFeed = WSFollowFeedHolder.e(this.this$0).feed;
    } else {
      localstSimpleMetaFeed = null;
    }
    WSFollowBeaconReport.a(i, localstSimpleMetaFeed, bool1, WSFollowFeedHolder.o(this.this$0), WSFollowFeedHolder.p(this.this$0), WSFollowFeedHolder.q(this.this$0), bool2, WSFollowFeedHolder.r(this.this$0).getUserList(), WSFollowFeedHolder.r(this.this$0).getTopicList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.11
 * JD-Core Version:    0.7.0.1
 */