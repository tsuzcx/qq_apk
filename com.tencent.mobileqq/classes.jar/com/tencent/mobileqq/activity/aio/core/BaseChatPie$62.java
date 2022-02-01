package com.tencent.mobileqq.activity.aio.core;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class BaseChatPie$62
  implements Runnable
{
  BaseChatPie$62(BaseChatPie paramBaseChatPie, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(40, localExtensionInfo.audioPanelType, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.62
 * JD-Core Version:    0.7.0.1
 */