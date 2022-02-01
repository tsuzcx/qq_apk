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
    if (WSFollowFeedHolder.c(this.this$0).getVisibility() == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((WSFollowFeedHolder.a(this.this$0) != null) && (WSFollowFeedHolder.a(this.this$0))) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        int i = WSFollowFeedHolder.a(this.this$0);
        if (WSFollowFeedHolder.a(this.this$0) != null) {}
        for (stSimpleMetaFeed localstSimpleMetaFeed = WSFollowFeedHolder.a(this.this$0).feed;; localstSimpleMetaFeed = null)
        {
          WSFollowBeaconReport.a(i, localstSimpleMetaFeed, bool1, WSFollowFeedHolder.b(this.this$0), WSFollowFeedHolder.c(this.this$0), WSFollowFeedHolder.d(this.this$0), bool2, WSFollowFeedHolder.a(this.this$0).a(), WSFollowFeedHolder.a(this.this$0).b());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.9
 * JD-Core Version:    0.7.0.1
 */