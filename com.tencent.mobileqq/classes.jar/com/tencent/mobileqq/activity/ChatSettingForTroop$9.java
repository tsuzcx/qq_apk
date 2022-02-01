package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

class ChatSettingForTroop$9
  implements TroopPluginManager.TroopPluginCallback
{
  ChatSettingForTroop$9(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onInstallFinish(int paramInt)
  {
    boolean bool;
    View localView;
    if (paramInt == 0)
    {
      this.a.b = true;
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
      localView = this.a.jdField_a_of_type_ArrayOfAndroidViewView[5];
      if (localView != null) {
        if (!bool) {
          break label81;
        }
      }
    }
    label81:
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      if (bool) {
        TroopReportor.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.9
 * JD-Core Version:    0.7.0.1
 */