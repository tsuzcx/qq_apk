package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.troopgift.TroopGiftPanel.OnShowOrHideListerner;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;

class NearByGiftPanelHelper$1
  implements TroopGiftPanel.OnShowOrHideListerner
{
  NearByGiftPanelHelper$1(NearByGiftPanelHelper paramNearByGiftPanelHelper) {}
  
  public void a()
  {
    INearbyGiftPanelDialog localINearbyGiftPanelDialog = this.a.jdField_a_of_type_ComTencentMobileqqNearbyGiftINearbyGiftPanelDialog;
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a == 10002) {
      i = 8;
    } else {
      i = 6;
    }
    localINearbyGiftPanelDialog.a(false, true, i);
  }
  
  public void b()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyGiftINearbyGiftPanelDialog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearByGiftPanelHelper.1
 * JD-Core Version:    0.7.0.1
 */