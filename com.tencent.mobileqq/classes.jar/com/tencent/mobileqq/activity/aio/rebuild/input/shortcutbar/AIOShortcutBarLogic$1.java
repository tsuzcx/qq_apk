package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import java.util.Iterator;
import java.util.List;

class AIOShortcutBarLogic$1
  implements Runnable
{
  AIOShortcutBarLogic$1(AIOShortcutBarLogic paramAIOShortcutBarLogic, List paramList, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AIOShortcutBarHelper.OnVisibilityChangedListener)localIterator.next()).a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarLogic.1
 * JD-Core Version:    0.7.0.1
 */