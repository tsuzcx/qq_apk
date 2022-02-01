package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.qphone.base.util.QLog;

class KPLProfileCardActivity$5
  extends CardObserver
{
  KPLProfileCardActivity$5(KPLProfileCardActivity paramKPLProfileCardActivity) {}
  
  public void onGetKplCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KPLProfileCardActivity", 2, "onGetKplCard, isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof KplCard)))
    {
      KPLProfileCardActivity.a(this.a, (KplCard)paramObject);
      this.a.a = ((KplCard)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity.5
 * JD-Core Version:    0.7.0.1
 */