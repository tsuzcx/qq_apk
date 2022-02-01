package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatSettingForTroop$51
  implements View.OnClickListener
{
  ChatSettingForTroop$51(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (TroopAppMgr)this.a.app.getManager(QQManagerFactory.TROOP_APP_MGR);
      if (localObject != null) {
        ((TroopAppMgr)localObject).a(true, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      TroopAppShortcutUtils.a(2, Long.parseLong((String)localObject), this.a.app, this.a.getApplicationContext(), (BaseActivity)this.a.getActivity());
      long l = Long.parseLong((String)localObject);
      localObject = ((TroopShortcutBarManager)this.a.app.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(l));
      if (localObject != null) {
        ((TroopShortcutBarInfo)localObject).c(0);
      }
      ReportController.b(null, "dc00898", "", "", "0X800AFC5", "0X800AFC5", 0, 0, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51
 * JD-Core Version:    0.7.0.1
 */