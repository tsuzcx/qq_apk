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
      long l = paramLong1;
      if (paramLong2 - paramLong1 > 200L) {
        l = paramLong2 - 200L;
      }
      paramAIOContext.a().a().a(paramLong2, l, true);
      paramAIOContext.a().a().a(0, -1, paramRunnable, 6, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.UnreadHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */