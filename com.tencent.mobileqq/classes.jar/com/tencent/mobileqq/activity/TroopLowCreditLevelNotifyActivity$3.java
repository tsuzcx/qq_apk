package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class TroopLowCreditLevelNotifyActivity$3
  extends TroopObserver
{
  TroopLowCreditLevelNotifyActivity$3(TroopLowCreditLevelNotifyActivity paramTroopLowCreditLevelNotifyActivity) {}
  
  protected void onGetTroopCreditLevelInfo(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetTroopCreditLevelInfo:");
      ((StringBuilder)localObject).append(this.a.k);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    if (!((String)localObject).equals(localStringBuilder.toString())) {
      return;
    }
    this.a.f();
    if (paramBoolean)
    {
      localObject = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).f(this.a.k);
        if (localObject != null)
        {
          paramLong = ((TroopInfo)localObject).troopCreditLevel;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onGetTroopCreditLevelInfo:");
            ((StringBuilder)localObject).append(this.a.k);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(paramLong);
            QLog.i("troop.credit.act", 2, ((StringBuilder)localObject).toString());
          }
          if (paramLong == 2L) {
            return;
          }
          if (paramLong == 1L)
          {
            localObject = DialogUtil.a(this.a.c, 230).setTitle(this.a.getString(2131917233)).setMessage(HardCodeUtil.a(2131912740));
            ((QQCustomDialog)localObject).setPositiveButton(2131895331, new TroopLowCreditLevelNotifyActivity.3.1(this));
            ((QQCustomDialog)localObject).setNegativeButton("", null);
            ((QQCustomDialog)localObject).setCancelable(false);
            ((QQCustomDialog)localObject).show();
            return;
          }
          localObject = DialogUtil.a(this.a.c, 230).setTitle(this.a.getString(2131917233)).setMessage(HardCodeUtil.a(2131912741));
          ((QQCustomDialog)localObject).setPositiveButton(2131895331, new TroopLowCreditLevelNotifyActivity.3.2(this));
          ((QQCustomDialog)localObject).setNegativeButton("", null);
          ((QQCustomDialog)localObject).setCancelable(false);
          ((QQCustomDialog)localObject).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity.3
 * JD-Core Version:    0.7.0.1
 */