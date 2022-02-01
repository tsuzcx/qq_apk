package com.tencent.mobileqq.activity;

import axzw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

class LikeRankingListActivity$3
  implements Runnable
{
  LikeRankingListActivity$3(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    axzw localaxzw = (axzw)this.this$0.app.getManager(160);
    RedTouchItem localRedTouchItem1 = localaxzw.a(100601);
    if (localaxzw.a(localRedTouchItem1, false))
    {
      RedTouchItem localRedTouchItem2 = localaxzw.a(-7);
      if ((localaxzw.a(localRedTouchItem2, true)) && (localRedTouchItem2.receiveTime == localRedTouchItem1.receiveTime)) {
        localRedTouchItem2.unReadFlag = false;
      }
      localaxzw.a(100601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.3
 * JD-Core Version:    0.7.0.1
 */