package com.tencent.mobileqq.bubble;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

class BubbleDiyFetcher$4
  implements Runnable
{
  BubbleDiyFetcher$4(BubbleDiyFetcher paramBubbleDiyFetcher, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!this.this$0.h.isEmpty())
    {
      localObject1 = this.this$0;
      BubbleDiyFetcher.a((BubbleDiyFetcher)localObject1, TextUtils.join(",", ((BubbleDiyFetcher)localObject1).h), "now query mUnCacheDiyId: ");
      this.this$0.c(this.a);
      if (!this.this$0.h.isEmpty())
      {
        ((BubbleDiyHandler)this.a.getBusinessHandler(BusinessHandlerFactory.BUBBLE_DIYTEXT_HANDLER)).a(new ArrayList(this.this$0.h), null);
        this.this$0.h.clear();
      }
    }
    if (!this.this$0.i.isEmpty()) {
      this.this$0.c();
    }
    Object localObject2;
    if (!this.this$0.j.isEmpty())
    {
      localObject1 = this.this$0.j.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.this$0.d((String)localObject2);
        }
      }
    }
    Object localObject1 = this.this$0.g.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VipBubbleDrawable)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((VipBubbleDrawable)localObject2).getCallback() == null)) {
        this.this$0.g.remove(localObject2);
      }
    }
    BubbleDiyFetcher.l = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.4
 * JD-Core Version:    0.7.0.1
 */