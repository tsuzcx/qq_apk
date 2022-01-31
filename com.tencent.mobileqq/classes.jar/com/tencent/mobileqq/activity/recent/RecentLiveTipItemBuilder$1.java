package com.tencent.mobileqq.activity.recent;

import ahoa;
import ajsd;
import aszf;
import axrc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;

public class RecentLiveTipItemBuilder$1
  implements Runnable
{
  public RecentLiveTipItemBuilder$1(ahoa paramahoa, QQAppInterface paramQQAppInterface, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("msg_box");
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving)
    {
      str = "exp_livepush";
      localaxrc = localaxrc.d(str).e(String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin).longValue() - ajsd.l));
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving) {
        break label125;
      }
    }
    label125:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.startLiveWordingType);; str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.endLiveWordingType))
    {
      localaxrc.a(new String[] { str, String.valueOf(this.jdField_a_of_type_Aszf.b()) }).a();
      return;
      str = "exp_relivepush";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */