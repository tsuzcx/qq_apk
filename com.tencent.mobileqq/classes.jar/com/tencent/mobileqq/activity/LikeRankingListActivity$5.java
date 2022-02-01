package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class LikeRankingListActivity$5
  implements Runnable
{
  LikeRankingListActivity$5(LikeRankingListActivity paramLikeRankingListActivity, String paramString) {}
  
  public void run()
  {
    Card localCard = this.this$0.a.a(this.a);
    if (localCard != null) {
      this.this$0.a(localCard);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "update cover card = null");
    }
    LikeRankingListActivity.a(this.this$0.app, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.5
 * JD-Core Version:    0.7.0.1
 */