package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.troop.utils.RobotUtils;

public class DefaultPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    if (RobotUtils.a(paramBaseChatPie.d, paramBaseChatPie.ah.b))
    {
      a(paramBaseChatPie.ah.a, 217);
      a(paramBaseChatPie.ah.a, 218);
      return;
    }
    a(paramBaseChatPie.ah.a, 205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.DefaultPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */