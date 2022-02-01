package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.config.business.TroopUrlConfProcessor;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import cooperation.qzone.QZoneHelper;

class ChatSettingForTroop$3
  implements Runnable
{
  ChatSettingForTroop$3(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqConfigBusinessTroopUrlConfBean = TroopUrlConfProcessor.a();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
      QZoneHelper.preloadQunAlbum(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.3
 * JD-Core Version:    0.7.0.1
 */