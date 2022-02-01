package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ILeftAppShortBarDataUI;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.IAppShortcutBarDataUI;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;

class ShortcutBarAIOHelper$2
  implements AppShortcutBarScrollView.OnScrollChangedListener
{
  ShortcutBarAIOHelper$2(ShortcutBarAIOHelper paramShortcutBarAIOHelper) {}
  
  public void a()
  {
    if ((ShortcutBarAIOHelper.a(this.a) != null) && (ShortcutBarAIOHelper.a(this.a).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init  mAppShortcutBarView.setOnScrollChangedListener mAppPanel.reportAppShortcutBarItem()");
      }
      ShortcutBarAIOHelper.a(this.a).e();
    }
    for (;;)
    {
      if ((ShortcutBarAIOHelper.a(this.a) != null) && (ShortcutBarAIOHelper.a(this.a).a())) {
        ShortcutBarAIOHelper.a(this.a).e();
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.init  mAppShortcutBarView.setOnScrollChangedListener mAppPanel is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper.2
 * JD-Core Version:    0.7.0.1
 */