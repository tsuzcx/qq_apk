package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class LimitChatPie$9
  implements IExpandCmdCallback
{
  LimitChatPie$9(LimitChatPie paramLimitChatPie) {}
  
  public void a(@Nullable ExpandReqInfo paramExpandReqInfo, @NotNull ExpandResponse paramExpandResponse)
  {
    if ((paramExpandResponse.a() == 0) && (paramExpandResponse.a() != null))
    {
      ThreadManager.getUIHandler().post(new LimitChatPie.9.1(this, paramExpandResponse));
      return;
    }
    paramExpandReqInfo = new StringBuilder();
    paramExpandReqInfo.append(this.a.b);
    paramExpandReqInfo.append("expand.chat.");
    paramExpandReqInfo = paramExpandReqInfo.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAbleToGreet. error ");
    localStringBuilder.append(paramExpandResponse.a());
    QLog.w(paramExpandReqInfo, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.9
 * JD-Core Version:    0.7.0.1
 */