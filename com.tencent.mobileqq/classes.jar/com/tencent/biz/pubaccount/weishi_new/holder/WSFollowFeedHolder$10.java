package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import vcu;
import vka;

public class WSFollowFeedHolder$10
  implements Runnable
{
  public WSFollowFeedHolder$10(vcu paramvcu) {}
  
  public void run()
  {
    if (vcu.c(this.this$0).getVisibility() == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((vcu.a(this.this$0) != null) && (vcu.a(this.this$0))) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        int i = vcu.a(this.this$0);
        if (vcu.a(this.this$0) != null) {}
        for (stSimpleMetaFeed localstSimpleMetaFeed = vcu.a(this.this$0).feed;; localstSimpleMetaFeed = null)
        {
          vka.a(i, localstSimpleMetaFeed, bool1, vcu.b(this.this$0), vcu.c(this.this$0), vcu.d(this.this$0), bool2, vcu.a(this.this$0).a(), vcu.a(this.this$0).b());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.10
 * JD-Core Version:    0.7.0.1
 */