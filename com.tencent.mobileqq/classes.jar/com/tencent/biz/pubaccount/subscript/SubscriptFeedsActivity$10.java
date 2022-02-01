package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import java.util.Iterator;
import java.util.List;

class SubscriptFeedsActivity$10
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SubscriptionFeed localSubscriptionFeed = (SubscriptionFeed)localIterator.next();
      if (localSubscriptionFeed.b > 0) {
        localSubscriptionFeed.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.10
 * JD-Core Version:    0.7.0.1
 */