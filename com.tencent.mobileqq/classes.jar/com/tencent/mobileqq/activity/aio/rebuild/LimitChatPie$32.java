package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class LimitChatPie$32
  implements IExpandCmdCallback
{
  LimitChatPie$32(LimitChatPie paramLimitChatPie) {}
  
  public void a(@Nullable ExpandReqInfo paramExpandReqInfo, @NotNull ExpandResponse paramExpandResponse)
  {
    if (paramExpandResponse.a() != 0)
    {
      paramExpandReqInfo = new StringBuilder();
      paramExpandReqInfo.append(this.a.b);
      paramExpandReqInfo.append("expand.chat.");
      paramExpandReqInfo = paramExpandReqInfo.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportGreet. error ");
      localStringBuilder.append(paramExpandResponse.a());
      QLog.w(paramExpandReqInfo, 1, localStringBuilder.toString());
      return;
    }
    paramExpandReqInfo = new StringBuilder();
    paramExpandReqInfo.append(this.a.b);
    paramExpandReqInfo.append("expand.chat.");
    QLog.d(paramExpandReqInfo.toString(), 1, "reportGreet. succ ");
    LimitChatPie.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.32
 * JD-Core Version:    0.7.0.1
 */