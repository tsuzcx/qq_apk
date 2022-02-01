package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class GetNearbyRecommender$MyCardObserver
  extends ProfileCardObserver
{
  GetNearbyRecommender$MyCardObserver(GetNearbyRecommender paramGetNearbyRecommender) {}
  
  protected void onGetProfileDetail(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      paramCard = new StringBuilder();
      paramCard.append("GetNearbyRecommender onGetDetailInfo|uin=");
      paramCard.append(paramString);
      QLog.d("QQInitHandler", 2, paramCard.toString());
    }
    if (!this.a.mAutomator.k.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.setResult(7);
      return;
    }
    this.a.setResult(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetNearbyRecommender.MyCardObserver
 * JD-Core Version:    0.7.0.1
 */