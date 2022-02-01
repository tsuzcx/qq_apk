package com.tencent.mobileqq.activity.recent;

import alhh;
import axny;
import bdlf;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;

public class RecentLiveTipItemBuilder$1
  implements Runnable
{
  public RecentLiveTipItemBuilder$1(alhh paramalhh, QQAppInterface paramQQAppInterface, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, axny paramaxny) {}
  
  public void run()
  {
    bdlf localbdlf = new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("msg_box");
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving)
    {
      str = "exp_livepush";
      localbdlf = localbdlf.d(str).e(String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin).longValue() - AppConstants.NOW_LIVE_TIP_UIN_BASE));
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving) {
        break label125;
      }
    }
    label125:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.startLiveWordingType);; str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.endLiveWordingType))
    {
      localbdlf.a(new String[] { str, String.valueOf(this.jdField_a_of_type_Axny.b()) }).a();
      return;
      str = "exp_relivepush";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */