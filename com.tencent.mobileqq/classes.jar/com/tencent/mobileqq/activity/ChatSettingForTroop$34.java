package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Map;

class ChatSettingForTroop$34
  extends FriendListObserver
{
  ChatSettingForTroop$34(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    super.onSetGenralSettingsTroopFilter(paramBoolean, paramMap);
    if ((paramMap == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)) {
      return;
    }
    if (!paramBoolean) {
      if (paramMap.get(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin) != null) {
        QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131720242), 0).b(this.a.getTitleBarHeight());
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      return;
      paramMap = (Integer)paramMap.get(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      if (paramMap != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask = paramMap.intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.34
 * JD-Core Version:    0.7.0.1
 */