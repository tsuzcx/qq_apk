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
      paramAIOContext.C().setEnable(8, true);
      paramAIOContext.D();
      return;
    }
    if (paramInt == 2) {
      paramAIOContext.C().setAllEnable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.PanelInputStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */