package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import uhk;
import umu;

public class WSFollowFeedHolder$9
  implements Runnable
{
  public WSFollowFeedHolder$9(uhk paramuhk) {}
  
  public void run()
  {
    if (uhk.c(this.this$0).getVisibility() == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (uhk.d(this.this$0).getVisibility() == 0) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        int i = uhk.a(this.this$0);
        if (uhk.a(this.this$0) != null) {}
        for (stSimpleMetaFeed localstSimpleMetaFeed = uhk.a(this.this$0).feed;; localstSimpleMetaFeed = null)
        {
          umu.a(i, localstSimpleMetaFeed, bool1, bool2, uhk.a(this.this$0).a(), uhk.a(this.this$0).b());
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