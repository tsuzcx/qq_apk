package com.tencent.mobileqq.activity;

import aymd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

class LikeRankingListActivity$3
  implements Runnable
{
  LikeRankingListActivity$3(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    aymd localaymd = (aymd)this.this$0.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem1 = localaymd.a(100601);
    if (localaymd.a(localRedTouchItem1, false))
    {
      RedTouchItem localRedTouchItem2 = localaymd.a(-7);
      if ((localaymd.a(localRedTouchItem2, true)) && (localRedTouchItem2.receiveTime == localRedTouchItem1.receiveTime)) {
        localRedTouchItem2.unReadFlag = false;
      }
      localaymd.a(100601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.3
 * JD-Core Version:    0.7.0.1
 */