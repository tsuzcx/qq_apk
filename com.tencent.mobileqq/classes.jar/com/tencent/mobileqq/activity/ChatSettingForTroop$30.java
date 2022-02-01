package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.List;

class ChatSettingForTroop$30
  extends TroopBusinessObserver
{
  ChatSettingForTroop$30(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onUpdateTroopUnreadMsg(boolean paramBoolean1, boolean paramBoolean2, List<TroopUnreadMsgInfo> paramList, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean1) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    label31:
    TroopUnreadMsgInfo localTroopUnreadMsgInfo;
    if (paramInt < paramList.size())
    {
      localTroopUnreadMsgInfo = (TroopUnreadMsgInfo)paramList.get(paramInt);
      if ((localTroopUnreadMsgInfo != null) && (Utils.a(localTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if (localTroopUnreadMsgInfo.jdField_a_of_type_Long != 2L) {
          break label206;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewPhotoNum = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum = localTroopUnreadMsgInfo.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        if (paramBoolean2) {
          QZoneHelper.sendBroadcastQunMsgUnreadCount(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadMsgNum);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onUpdateTroopUnreadMsg| isPush = " + paramBoolean2 + ", " + localTroopUnreadMsgInfo);
      }
      paramInt += 1;
      break label31;
      break;
      label206:
      if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = localTroopUnreadMsgInfo.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      else if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1101236949L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mNewTroopNotificationNum = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      }
      else if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1106664488L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.30
 * JD-Core Version:    0.7.0.1
 */