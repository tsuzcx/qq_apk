package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import uhz;
import uns;

public class WSFollowFeedHolder$9
  implements Runnable
{
  public WSFollowFeedHolder$9(uhz paramuhz) {}
  
  public void run()
  {
    if (uhz.c(this.this$0).getVisibility() == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((uhz.a(this.this$0) != null) && (uhz.a(this.this$0))) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        int i = uhz.a(this.this$0);
        if (uhz.a(this.this$0) != null) {}
        for (stSimpleMetaFeed localstSimpleMetaFeed = uhz.a(this.this$0).feed;; localstSimpleMetaFeed = null)
        {
          uns.a(i, localstSimpleMetaFeed, bool1, uhz.b(this.this$0), uhz.c(this.this$0), uhz.d(this.this$0), bool2, uhz.a(this.this$0).a(), uhz.a(this.this$0).b());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.9
 * JD-Core Version:    0.7.0.1
 */