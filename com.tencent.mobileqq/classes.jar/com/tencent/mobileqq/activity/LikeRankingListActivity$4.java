package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

class LikeRankingListActivity$4
  implements Runnable
{
  LikeRankingListActivity$4(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)this.this$0.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem1 = localLocalRedTouchManager.a(100601);
    if (localLocalRedTouchManager.a(localRedTouchItem1, false))
    {
      RedTouchItem localRedTouchItem2 = localLocalRedTouchManager.a(-7);
      if ((localLocalRedTouchManager.a(localRedTouchItem2, true)) && (localRedTouchItem2.receiveTime == localRedTouchItem1.receiveTime)) {
        localRedTouchItem2.unReadFlag = false;
      }
      localLocalRedTouchManager.b(100601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.4
 * JD-Core Version:    0.7.0.1
 */