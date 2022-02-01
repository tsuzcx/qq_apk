package com.tencent.biz.troopgift;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;

class TroopGiftPanel$17
  implements DialogInterface.OnClickListener
{
  TroopGiftPanel$17(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1)
    {
      VasH5PayUtil.a(this.a.m, "mvip.n.a.qlw_forsvip", "CJCLUBT", 3, false, true);
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_sure_click", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 0) {
      ReportController.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_cancel_click", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.17
 * JD-Core Version:    0.7.0.1
 */