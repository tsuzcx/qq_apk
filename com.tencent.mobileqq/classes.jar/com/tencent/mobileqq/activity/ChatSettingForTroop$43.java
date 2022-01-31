package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ChatSettingForTroop$43
  implements Runnable
{
  ChatSettingForTroop$43(ChatSettingForTroop paramChatSettingForTroop, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      ArrayList localArrayList = this.a.getExtras().getStringArrayList("param_admins");
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.coverAdministrators(this.this$0.app, localArrayList);
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new ChatSettingForTroop.43.1(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, localException, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.43
 * JD-Core Version:    0.7.0.1
 */