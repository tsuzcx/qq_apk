package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;

public class UnreadHeadMsgRefresher
  implements IHeadMsgRefresher
{
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    if ((int)paramLong2 >= 1L + paramLong1)
    {
      if (paramLong2 - paramLong1 <= 200L) {
        break label60;
      }
      paramLong1 = paramLong2 - 200L;
    }
    label60:
    for (;;)
    {
      paramAIOContext.a().a().a(paramLong2, paramLong1, true);
      paramAIOContext.a().a().a(0, -1, paramRunnable, 6);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.UnreadHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */