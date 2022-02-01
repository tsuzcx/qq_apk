package com.tencent.mobileqq.activity.aio.helper;

import android.view.MotionEvent;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.qphone.base.util.QLog;

class TroopAppShortcutBarHelper$2
  implements DrawerFrame.TouchEventConsumer
{
  TroopAppShortcutBarHelper$2(TroopAppShortcutBarHelper paramTroopAppShortcutBarHelper) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.DrawerFrame.TouchEventConsumer");
    }
    return this.a.a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper.2
 * JD-Core Version:    0.7.0.1
 */