package com.tencent.mobileqq.activity.aio.helper;

import android.view.MotionEvent;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.qphone.base.util.QLog;

class ShortcutBarAIOHelper$3
  implements DrawerFrame.TouchEventConsumer
{
  ShortcutBarAIOHelper$3(ShortcutBarAIOHelper paramShortcutBarAIOHelper) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortcutBarAIOHelper", 2, "ShortcutBarAioHelper.DrawerFrame.TouchEventConsumer");
    }
    return this.a.a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper.3
 * JD-Core Version:    0.7.0.1
 */