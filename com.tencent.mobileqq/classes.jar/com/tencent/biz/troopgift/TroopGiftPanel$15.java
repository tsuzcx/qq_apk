package com.tencent.biz.troopgift;

import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TroopGiftPanel$15
  extends TroopGiftCallback
{
  TroopGiftPanel$15(TroopGiftPanel paramTroopGiftPanel, TroopGiftAioItemData paramTroopGiftAioItemData) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetThrowGiftResult() onError errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", errorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b.V >= 4)
    {
      paramString = this.b.getTroopUin();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.getComeFrom());
      ((StringBuilder)localObject).append("");
      NearbyFlowerManager.a("gift_store", "fail_all", paramString, ((StringBuilder)localObject).toString(), "", "");
      return;
    }
    paramString = this.b.getTroopUin();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.a.i);
    localObject = ((StringBuilder)localObject).toString();
    String str = this.b.H;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.b.l.get(), ((AppInterface)this.b.l.get()).getCurrentAccountUin(), this.b.getTroopUin()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_fail", 0, 0, paramString, (String)localObject, str, localStringBuilder.toString());
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetThrowGiftResult productId = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.b.V >= 4)
    {
      localObject1 = this.b.getTroopUin();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.b.getComeFrom());
      ((StringBuilder)localObject2).append("");
      NearbyFlowerManager.a("gift_store", "suc_all", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      return;
    }
    Object localObject1 = this.b.getTroopUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.a.i);
    localObject2 = ((StringBuilder)localObject2).toString();
    String str = this.b.H;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.b.l.get(), ((AppInterface)this.b.l.get()).getCurrentAccountUin(), this.b.getTroopUin()));
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_suc", 0, 0, (String)localObject1, (String)localObject2, str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.15
 * JD-Core Version:    0.7.0.1
 */