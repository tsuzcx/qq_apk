package com.tencent.mobileqq.activity;

import alto;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import mqq.os.MqqHandler;

class BaseChatPie$88
  implements Runnable
{
  BaseChatPie$88(BaseChatPie paramBaseChatPie, alto paramalto) {}
  
  public void run()
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = this.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(40, localNoC2CExtensionInfo.audioPanelType, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.88
 * JD-Core Version:    0.7.0.1
 */