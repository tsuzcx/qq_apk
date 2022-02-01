package com.tencent.mobileqq.activity.aio.rebuild.input.inputstate;

import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;

public class FullScreenStateChangeCallback
  implements IInputStateChangeCallback
{
  public void a(int paramInt, AIOContext paramAIOContext)
  {
    if (paramInt == 2)
    {
      paramAIOContext = (FullScreenInputHelper)paramAIOContext.a(24);
      if (paramAIOContext.c())
      {
        paramAIOContext.a(false);
        paramAIOContext.a.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.FullScreenStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */