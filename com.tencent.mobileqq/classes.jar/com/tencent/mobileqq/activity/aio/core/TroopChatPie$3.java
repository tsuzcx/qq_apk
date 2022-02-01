package com.tencent.mobileqq.activity.aio.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

class TroopChatPie$3
  extends BroadcastReceiver
{
  TroopChatPie$3(TroopChatPie paramTroopChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "Confess action! ");
      }
      if (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(35);
        TroopConfessUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.3
 * JD-Core Version:    0.7.0.1
 */