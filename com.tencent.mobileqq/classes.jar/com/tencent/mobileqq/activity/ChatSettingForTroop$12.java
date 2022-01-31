package com.tencent.mobileqq.activity;

import android.os.Handler;
import babl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$12
  implements Runnable
{
  ChatSettingForTroop$12(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mInitRunnable and init cardInfo");
      }
      this.this$0.t();
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = babl.a(this.this$0.app.getCurrentAccountUin(), "troop_photo_message", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = babl.a(this.this$0.app.getCurrentAccountUin(), "troop_photo_new", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "初始化，群空间未读计数， troopuin = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ", unreadmsgnum = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum + ", newphotonum = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = babl.a(this.this$0.app.getCurrentAccountUin(), "troop_file_new", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 0;
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = babl.a(this.this$0.app.getCurrentAccountUin(), "troop_notification_new", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isGameTroop()) {
        this.this$0.j = babl.a(this.this$0.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      this.this$0.b();
      this.this$0.r();
      ChatSettingForTroop.a(this.this$0, 0, false);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      this.this$0.app.d(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localNumberFormatException.toString());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localIllegalArgumentException.toString());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localException.toString());
      return;
    }
    catch (Error localError)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localError.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.12
 * JD-Core Version:    0.7.0.1
 */