package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.util.WeakReferenceHandler;

class VipProfileCardDiyActivity$HiBoomTemplateView$1
  extends CallBacker
{
  VipProfileCardDiyActivity$HiBoomTemplateView$1(VipProfileCardDiyActivity.HiBoomTemplateView paramHiBoomTemplateView, VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (VipProfileCardDiyActivity.a(paramLong, paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int))
    {
      if (paramInt1 != 0) {
        break label89;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasQuickUpdateService.removeCallBacker(this);
    }
    for (;;)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5, paramInt1, 0);
      paramString1.obj = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString1);
      return;
      label89:
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 0;
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (VipProfileCardDiyActivity.a(paramLong1, paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int))
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(4);
      paramString1.arg1 = ((int)(paramLong2 / paramLong3 * this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.getHeight()));
      paramString1.obj = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.HiBoomTemplateView.1
 * JD-Core Version:    0.7.0.1
 */