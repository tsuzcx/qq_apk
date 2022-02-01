package com.tencent.biz.troopgift;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

class TroopGiftPanel$19
  implements DialogInterface.OnClickListener
{
  TroopGiftPanel$19(TroopGiftPanel paramTroopGiftPanel, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.b.B != null) && (this.b.B.m != null) && (!TextUtils.isEmpty(this.b.B.m.c)))
    {
      this.b.d();
      if (this.b.J == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_topay", 0, 0, "", "", "", "");
        return;
      }
      if (this.b.J == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_topay", 0, 0, "", "", "", "");
        return;
      }
      if (this.b.J == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_topay", 0, 0, "", "", "", "");
        return;
      }
      if (this.b.V >= 4)
      {
        paramDialogInterface = this.b.getTroopUin();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b.getComeFrom());
        ((StringBuilder)localObject).append("");
        NearbyFlowerManager.a("gift_store", "pay_tip", paramDialogInterface, ((StringBuilder)localObject).toString(), "", "");
        return;
      }
      paramInt = this.a;
      paramDialogInterface = this.b.getTroopUin();
      Object localObject = this.b.H;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.b.l.get(), ((AppInterface)this.b.l.get()).getCurrentAccountUin(), this.b.getTroopUin()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_topay", paramInt, 0, paramDialogInterface, "", (String)localObject, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.19
 * JD-Core Version:    0.7.0.1
 */