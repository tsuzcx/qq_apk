package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;

class WSFollowFeedHolder$9
  implements Runnable
{
  WSFollowFeedHolder$9(WSFollowFeedHolder paramWSFollowFeedHolder) {}
  
  public void run()
  {
    boolean bool1;
    if (WSFollowFeedHolder.c(this.this$0).getVisibility() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((WSFollowFeedHolder.a(this.this$0) != null) && (WSFollowFeedHolder.a(this.this$0))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i = WSFollowFeedHolder.a(this.this$0);
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (WSFollowFeedHolder.a(this.this$0) != null) {
      localstSimpleMetaFeed = WSFollowFeedHolder.a(this.this$0).feed;
    } else {
      localstSimpleMetaFeed = null;
    }
    WSFollowBeaconReport.a(i, localstSimpleMetaFeed, bool1, WSFollowFeedHolder.b(this.this$0), WSFollowFeedHolder.c(this.this$0), WSFollowFeedHolder.d(this.this$0), bool2, WSFollowFeedHolder.a(this.this$0).a(), WSFollowFeedHolder.a(this.this$0).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.9
 * JD-Core Version:    0.7.0.1
 */