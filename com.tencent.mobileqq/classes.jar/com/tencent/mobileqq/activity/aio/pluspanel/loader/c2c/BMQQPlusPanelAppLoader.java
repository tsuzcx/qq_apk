package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.hotpic.HotPicManager;

public class BMQQPlusPanelAppLoader
  extends C2CPlusPanelAppLoader
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie.ah.a, 201);
    a(paramBaseChatPie.ah.a, 202);
    if (HotPicManager.a(paramBaseChatPie.d).j()) {
      a(paramBaseChatPie.ah.a, 204);
    }
    a(paramBaseChatPie.ah.a, 206);
    a(paramBaseChatPie.ah.a, 208);
    a(paramBaseChatPie.ah.a, 205);
    a(paramBaseChatPie.ah.a, 212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.BMQQPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */