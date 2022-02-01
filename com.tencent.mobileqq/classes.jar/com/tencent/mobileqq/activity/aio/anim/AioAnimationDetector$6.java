package com.tencent.mobileqq.activity.aio.anim;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService.IGetTroopHonorListCallback;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AioAnimationDetector$6
  implements ITroopHonorService.IGetTroopHonorListCallback
{
  AioAnimationDetector$6(AioAnimationDetector paramAioAnimationDetector, String paramString, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AioAnimationRule paramAioAnimationRule, AioAnimationRule.JumpImage paramJumpImage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt) {}
  
  public void a(List<TroopHonor> paramList)
  {
    int i;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (((TroopHonor)paramList.get(i)).jdField_a_of_type_Int != 1) {}
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "bIsDragonKing : " + bool + " curTroopUin : " + this.jdField_a_of_type_JavaLangString);
      }
      String str;
      if (bool)
      {
        paramList = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        str = "";
        if (paramList == null) {
          break label296;
        }
      }
      label296:
      for (paramList = paramList.b(this.jdField_a_of_type_JavaLangString);; paramList = null)
      {
        if (paramList != null) {
          str = "" + paramList.dwGroupClassExt;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "report 0X800AF7C curTroopUin : " + this.jdField_a_of_type_JavaLangString);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "0X800AF7C", "0X800AF7C", this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule.b, 0, this.jdField_a_of_type_JavaLangString, str, "", "");
        }
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$JumpImage.jdField_a_of_type_JavaLangString;
        paramList = new LottieAnimationInfo(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramList);
        AioAnimationDetector.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector).postDelayed(new AioAnimationDetector.6.1(this, str, paramList), this.jdField_a_of_type_Int);
        return;
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.6
 * JD-Core Version:    0.7.0.1
 */