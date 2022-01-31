package com.tencent.mobileqq.activity;

import atax;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

class LikeRankingListActivity$3
  implements Runnable
{
  LikeRankingListActivity$3(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    atax localatax = (atax)this.this$0.app.getManager(160);
    RedTouchItem localRedTouchItem1 = localatax.a(100601);
    if (localatax.a(localRedTouchItem1, false))
    {
      RedTouchItem localRedTouchItem2 = localatax.a(-7);
      if ((localatax.a(localRedTouchItem2, true)) && (localRedTouchItem2.receiveTime == localRedTouchItem1.receiveTime)) {
        localRedTouchItem2.unReadFlag = false;
      }
      localatax.a(100601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.3
 * JD-Core Version:    0.7.0.1
 */