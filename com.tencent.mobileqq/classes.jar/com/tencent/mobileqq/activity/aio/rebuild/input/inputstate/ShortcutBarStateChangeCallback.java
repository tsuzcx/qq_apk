package com.tencent.mobileqq.activity.aio.rebuild.input.inputstate;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;

public class ShortcutBarStateChangeCallback
  implements IInputStateChangeCallback
{
  public void a(int paramInt, AIOContext paramAIOContext)
  {
    if (paramInt == 0) {
      paramAIOContext = (AIOShortcutBarHelper)paramAIOContext.a(52);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.ShortcutBarStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */