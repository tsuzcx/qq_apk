package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.vas.troopkeyword.EntryStatus;
import com.tencent.mobileqq.widget.FormSimpleItem;

class ChatSettingForTroop$11
  implements QueryCallback<EntryStatus>
{
  ChatSettingForTroop$11(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(EntryStatus paramEntryStatus)
  {
    if (this.a.g) {
      return;
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[40];
    localFormSimpleItem.setRightText(paramEntryStatus.a);
    localFormSimpleItem.setTag(2131375424, paramEntryStatus);
    ReportController.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F7", paramEntryStatus.c, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.11
 * JD-Core Version:    0.7.0.1
 */