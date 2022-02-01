package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class TroopRequestActivity$15
  extends ProfileCardObserver
{
  TroopRequestActivity$15(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, "onCardDownload() isSuccess = " + paramBoolean + "  data:" + paramObject);
    }
    if (paramObject == null) {}
    Card localCard;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!(paramObject instanceof Card)));
      localCard = (Card)paramObject;
    } while ((localCard.uin == null) || (!localCard.uin.equals(this.a.b)));
    TroopRequestActivity.a(this.a, (Card)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.15
 * JD-Core Version:    0.7.0.1
 */