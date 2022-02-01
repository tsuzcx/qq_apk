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
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.c)))
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c();
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.j == 2)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "Clk_topay", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.j == 6)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_topay", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.j == 7)
      {
        ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_topay", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a());
        ((StringBuilder)localObject).append("");
        NearbyFlowerManager.a("gift_store", "pay_tip", paramDialogInterface, ((StringBuilder)localObject).toString(), "", "");
        return;
      }
      paramInt = this.jdField_a_of_type_Int;
      paramDialogInterface = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
      Object localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_topay", paramInt, 0, paramDialogInterface, "", (String)localObject, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.19
 * JD-Core Version:    0.7.0.1
 */