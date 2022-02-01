package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatSettingForTroop$8
  implements CompoundButton.OnCheckedChangeListener
{
  ChatSettingForTroop$8(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((Boolean)paramCompoundButton.getTag()).booleanValue()) {
      paramCompoundButton.setTag(Boolean.FALSE);
    }
    int i;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
        i = this.a.app.getTroopMask(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      } while (i == -1);
      if (!paramBoolean) {
        break;
      }
    } while (i != 1);
    ChatSettingForTroop.a(this.a, 4);
    label82:
    if (ChatSettingForTroop.a(this.a) != null) {
      ChatSettingForTroop.e(this.a);
    }
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean)
    {
      str = "msg_open";
      label116:
      ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "Grp_data", str, 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label224;
      }
    }
    label224:
    for (String str = "msg_open";; str = "msg_close")
    {
      TroopReportor.a("Grp_msg", "grpData_admin", str, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      if (i == 1) {
        break;
      }
      ChatSettingForTroop.a(this.a, 1);
      break label82;
      str = "msg_close";
      break label116;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.8
 * JD-Core Version:    0.7.0.1
 */