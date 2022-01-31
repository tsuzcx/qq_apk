package com.tencent.mobileqq.activity.recent;

import ahbn;
import ajed;
import ascz;
import awrb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;

public class RecentLiveTipItemBuilder$1
  implements Runnable
{
  public RecentLiveTipItemBuilder$1(ahbn paramahbn, QQAppInterface paramQQAppInterface, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, ascz paramascz) {}
  
  public void run()
  {
    awrb localawrb = new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("msg_box");
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving)
    {
      str = "exp_livepush";
      localawrb = localawrb.d(str).e(String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.senderuin).longValue() - ajed.l));
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.isLiving) {
        break label125;
      }
    }
    label125:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.startLiveWordingType);; str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyLiveTip.endLiveWordingType))
    {
      localawrb.a(new String[] { str, String.valueOf(this.jdField_a_of_type_Ascz.b()) }).a();
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