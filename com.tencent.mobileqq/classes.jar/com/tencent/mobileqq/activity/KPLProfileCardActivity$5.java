package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.qphone.base.util.QLog;

class KPLProfileCardActivity$5
  extends CardObserver
{
  KPLProfileCardActivity$5(KPLProfileCardActivity paramKPLProfileCardActivity) {}
  
  protected void onGetKplCard(boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetKplCard, isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("KPLProfileCardActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof KplCard)))
    {
      localObject = this.a;
      paramObject = (KplCard)paramObject;
      KPLProfileCardActivity.a((KPLProfileCardActivity)localObject, paramObject);
      this.a.a = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity.5
 * JD-Core Version:    0.7.0.1
 */