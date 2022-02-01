package com.tencent.mobileqq.activity.aio.rebuild.input.inputstate;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;

public class SimpleUIInputStateChangeCallback
  implements IInputStateChangeCallback
{
  public void a(int paramInt, AIOContext paramAIOContext)
  {
    paramAIOContext = (SimpleUIAIOHelper)paramAIOContext.a(29);
    if (paramInt == 0)
    {
      if (paramAIOContext != null) {
        paramAIOContext.e(true);
      }
    }
    else if ((paramInt == 2) && (paramAIOContext != null)) {
      paramAIOContext.e(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.SimpleUIInputStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */