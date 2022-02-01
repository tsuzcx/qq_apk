package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.hotpic.HotPicManager;

public class SelfPlusPanelAppLoader
  extends C2CPlusPanelAppLoader
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    d(paramBaseChatPie.ah.a);
    a(paramBaseChatPie.ah.a, 203);
    if (HotPicManager.a(paramBaseChatPie.d).j()) {
      a(paramBaseChatPie.ah.a, 204);
    }
    a(paramBaseChatPie.ah.a, 219);
    a(paramBaseChatPie.ah.a, 205);
    a(paramBaseChatPie.ah.a, 206);
    a(paramBaseChatPie.ah.a, 208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.SelfPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */