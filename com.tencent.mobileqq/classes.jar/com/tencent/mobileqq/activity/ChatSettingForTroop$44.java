package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class ChatSettingForTroop$44
  implements Runnable
{
  ChatSettingForTroop$44(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.app.getCurrentAccountUin());
    if (localTroopMemberInfo != null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = localTroopMemberInfo.troopColorNick;
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = localTroopMemberInfo.troopnick;
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.44
 * JD-Core Version:    0.7.0.1
 */