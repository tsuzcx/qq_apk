package com.tencent.mobileqq.activity;

import atxb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

class LikeRankingListActivity$3
  implements Runnable
{
  LikeRankingListActivity$3(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    atxb localatxb = (atxb)this.this$0.app.getManager(160);
    RedTouchItem localRedTouchItem1 = localatxb.a(100601);
    if (localatxb.a(localRedTouchItem1, false))
    {
      RedTouchItem localRedTouchItem2 = localatxb.a(-7);
      if ((localatxb.a(localRedTouchItem2, true)) && (localRedTouchItem2.receiveTime == localRedTouchItem1.receiveTime)) {
        localRedTouchItem2.unReadFlag = false;
      }
      localatxb.a(100601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.3
 * JD-Core Version:    0.7.0.1
 */