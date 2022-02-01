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
    QLog.d("TroopGiftPanel.time", 1, "setGiftData, reqTime=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.12
 * JD-Core Version:    0.7.0.1
 */