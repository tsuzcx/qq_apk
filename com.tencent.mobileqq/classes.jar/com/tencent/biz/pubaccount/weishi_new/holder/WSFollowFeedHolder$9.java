package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import uou;
import uvm;

public class WSFollowFeedHolder$9
  implements Runnable
{
  public WSFollowFeedHolder$9(uou paramuou) {}
  
  public void run()
  {
    if (uou.c(this.this$0).getVisibility() == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((uou.a(this.this$0) != null) && (uou.a(this.this$0))) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        int i = uou.a(this.this$0);
        if (uou.a(this.this$0) != null) {}
        for (stSimpleMetaFeed localstSimpleMetaFeed = uou.a(this.this$0).feed;; localstSimpleMetaFeed = null)
        {
          uvm.a(i, localstSimpleMetaFeed, bool1, uou.b(this.this$0), uou.c(this.this$0), uou.d(this.this$0), bool2, uou.a(this.this$0).a(), uou.a(this.this$0).b());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.9
 * JD-Core Version:    0.7.0.1
 */