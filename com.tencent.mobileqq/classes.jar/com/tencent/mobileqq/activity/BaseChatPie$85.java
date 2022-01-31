package com.tencent.mobileqq.activity;

import ajxn;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class BaseChatPie$85
  implements Runnable
{
  BaseChatPie$85(BaseChatPie paramBaseChatPie, ajxn paramajxn) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(40, localExtensionInfo.audioPanelType, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.85
 * JD-Core Version:    0.7.0.1
 */