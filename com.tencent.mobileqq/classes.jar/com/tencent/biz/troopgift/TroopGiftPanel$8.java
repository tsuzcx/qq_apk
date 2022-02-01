package com.tencent.biz.troopgift;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class TroopGiftPanel$8
  implements Runnable
{
  TroopGiftPanel$8(TroopGiftPanel paramTroopGiftPanel, AppInterface paramAppInterface, String paramString1, String paramString2, Handler paramHandler) {}
  
  public void run()
  {
    Object localObject;
    if (((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.b, this.c) != null)
    {
      localObject = ContactUtils.b((QQAppInterface)this.a, this.b, this.c);
      this.d.post(new TroopGiftPanel.8.1(this, (String)localObject));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last receiver is not in troop, troopUin=");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", memberUin=");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("TroopGiftPanel", 2, ((StringBuilder)localObject).toString());
    }
    TroopGiftAioPanelData.b(this.b, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.8
 * JD-Core Version:    0.7.0.1
 */