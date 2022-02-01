package com.tencent.mobileqq.activity.aio.rebuild.input.inputstate;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;

public class PanelInputStateChangeCallback
  implements IInputStateChangeCallback
{
  public void a(int paramInt, AIOContext paramAIOContext)
  {
    if (paramInt == 0)
    {
      paramAIOContext.a().setEnable(8, true);
      paramAIOContext.d();
      return;
    }
    if (paramInt == 2) {
      paramAIOContext.a().setAllEnable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.PanelInputStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */