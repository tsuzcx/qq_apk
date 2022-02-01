package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ILeftAppShortBarDataUI;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.IAppShortcutBarDataUI;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;

class TroopAppShortcutBarHelper$1
  implements AppShortcutBarScrollView.OnScrollChangedListener
{
  TroopAppShortcutBarHelper$1(TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper) {}
  
  public void a()
  {
    if ((TroopAppShortcutBarHelper.a(this.a) != null) && (TroopAppShortcutBarHelper.a(this.a).f()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init  mAppShortcutBarView.setOnScrollChangedListener mAppPanel.reportAppShortcutBarItem()");
      }
      TroopAppShortcutBarHelper.a(this.a).e();
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init  mAppShortcutBarView.setOnScrollChangedListener mAppPanel is null");
    }
    if ((TroopAppShortcutBarHelper.b(this.a) != null) && (TroopAppShortcutBarHelper.b(this.a).e())) {
      TroopAppShortcutBarHelper.b(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper.1
 * JD-Core Version:    0.7.0.1
 */