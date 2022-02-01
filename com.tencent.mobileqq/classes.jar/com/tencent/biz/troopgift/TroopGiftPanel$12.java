package com.tencent.biz.troopgift;

import com.tencent.mobileqq.troop.utils.TroopGiftManager.GiveGift;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopGiftPanel$12
  implements TroopGiftPanel.OnGetGiveGiftCallback
{
  TroopGiftPanel$12(TroopGiftPanel paramTroopGiftPanel, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt) {}
  
  public void a(List<TroopGiftManager.GiveGift> paramList)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.a(paramList);
    long l = System.currentTimeMillis();
    paramList = new StringBuilder();
    paramList.append("setGiftData, reqTime=");
    paramList.append(l - this.jdField_a_of_type_Long);
    paramList.append(", total=");
    paramList.append(l - this.b);
    QLog.d("TroopGiftPanel.time", 1, paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.12
 * JD-Core Version:    0.7.0.1
 */