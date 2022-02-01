package com.tencent.mobileqq.activity.aio.rebuild.input.inputstate;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;

public class ApollInputStateChangeCallback
  implements IInputStateChangeCallback
{
  public void a(int paramInt, AIOContext paramAIOContext)
  {
    paramAIOContext = (IApolloAIOHelper)paramAIOContext.a(8);
    if (paramInt == 0)
    {
      if (paramAIOContext != null) {
        paramAIOContext.showApolloView(true);
      }
    }
    else if ((paramInt == 2) && (paramAIOContext != null)) {
      paramAIOContext.showApolloView(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.ApollInputStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */