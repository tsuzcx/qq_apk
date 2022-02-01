package com.tencent.biz.troopgift;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.utils.TroopGiftManager.PackGift;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopGiftPanel$13
  implements TroopGiftPanel.OnGetPackGiftCallback
{
  TroopGiftPanel$13(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt) {}
  
  public void a(List<TroopGiftManager.PackGift> paramList, TroopGiftAioPanelData.EmptyPackagePage paramEmptyPackagePage)
  {
    if (this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.b(paramList);
    this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(paramEmptyPackagePage);
    if ((this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.size() > 0) && (this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.b.size() > 0) && (this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int != -1))
    {
      this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_e_of_type_Int));
      TroopGiftPanel.a(this.a, this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData);
    }
    if (this.a.d())
    {
      paramList = this.a;
      if ((!TextUtils.isEmpty(this.a.f)) && (TroopGiftPanel.a(this.a))) {}
      for (boolean bool = true;; bool = false)
      {
        paramList.setSendGiftBtnEnabled(bool);
        return;
      }
    }
    this.a.setSendGiftBtnEnabled(TroopGiftPanel.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.13
 * JD-Core Version:    0.7.0.1
 */