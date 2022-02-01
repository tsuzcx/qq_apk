package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class LikeRankingListActivity$3
  extends ProfileCardObserver
{
  LikeRankingListActivity$3(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "onCardDownload isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      if (paramObject.uin.equals(this.a.b)) {
        this.a.app.execute(new LikeRankingListActivity.3.1(this, paramObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.3
 * JD-Core Version:    0.7.0.1
 */