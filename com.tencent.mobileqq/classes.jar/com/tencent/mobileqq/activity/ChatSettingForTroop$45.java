package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$45
  implements Runnable
{
  ChatSettingForTroop$45(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = DBUtils.a(this.this$0.app.getCurrentAccountUin(), "troop_photo_message", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "从群空间返回，更新群空间未读计数， troopuin = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ", unreadmsgnum = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum + ", newphotonum = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.45
 * JD-Core Version:    0.7.0.1
 */