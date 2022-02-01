package com.tencent.mobileqq.activity;

import anvk;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class LikeRankingListActivity$4
  implements Runnable
{
  LikeRankingListActivity$4(LikeRankingListActivity paramLikeRankingListActivity, String paramString) {}
  
  public void run()
  {
    Card localCard = this.this$0.a.b(this.a);
    if (localCard != null) {
      this.this$0.a(localCard);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "update cover card = null");
    }
    LikeRankingListActivity.a(this.this$0.app, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.4
 * JD-Core Version:    0.7.0.1
 */