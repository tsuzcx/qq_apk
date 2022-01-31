package com.tencent.mobileqq.activity;

import avod;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

class LikeRankingListActivity$3
  implements Runnable
{
  LikeRankingListActivity$3(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    avod localavod = (avod)this.this$0.app.getManager(160);
    RedTouchItem localRedTouchItem1 = localavod.a(100601);
    if (localavod.a(localRedTouchItem1, false))
    {
      RedTouchItem localRedTouchItem2 = localavod.a(-7);
      if ((localavod.a(localRedTouchItem2, true)) && (localRedTouchItem2.receiveTime == localRedTouchItem1.receiveTime)) {
        localRedTouchItem2.unReadFlag = false;
      }
      localavod.a(100601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.3
 * JD-Core Version:    0.7.0.1
 */