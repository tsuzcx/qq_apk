package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class DefaultHeadMsgRefresher
  implements IHeadMsgRefresher
{
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshHeadMessage, type: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", unreadMsgCount: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", fistseq: ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", reportType");
      localStringBuilder.append(paramInt3);
      QLog.d("DefaultHeadMsgRefresher", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new DefaultHeadMsgRefresher.1(this, paramAIOContext, paramLong1, paramInt2, paramLong2, paramInt1, paramRunnable), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DefaultHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */