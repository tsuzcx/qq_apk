package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class LogcatSendMessageCallback
  implements ISendMessageCallback
{
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    LogcatUtil.a(paramSendLogicParam.a());
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.LogcatSendMessageCallback
 * JD-Core Version:    0.7.0.1
 */