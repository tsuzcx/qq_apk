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
      if (paramInt1 == 0)
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
        paramString1.jdField_b_of_type_Int = 2;
        paramString1.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasQuickUpdateService.removeCallBacker(this);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 0;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5, paramInt1, 0);
      paramString1.obj = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString1);
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (VipProfileCardDiyActivity.a(paramLong1, paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int))
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(4);
      double d1 = paramLong2;
      double d2 = paramLong3;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      d2 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.getHeight();
      Double.isNaN(d2);
      paramString1.arg1 = ((int)(d2 * d1));
      paramString1.obj = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.HiBoomTemplateView.1
 * JD-Core Version:    0.7.0.1
 */