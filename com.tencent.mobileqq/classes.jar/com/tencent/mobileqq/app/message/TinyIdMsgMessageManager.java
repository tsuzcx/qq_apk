package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TinyIdMsgMessageManager
  extends C2CMessageManager
{
  public TinyIdMsgMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TinyIdMsgMessageManager() called with: app = [");
      localStringBuilder.append(paramAppRuntime);
      localStringBuilder.append("], msgPool = [");
      localStringBuilder.append(paramMsgPool);
      localStringBuilder.append("]");
      QLog.d("TinyIdMsgMessageManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.TinyIdMsgMessageManager
 * JD-Core Version:    0.7.0.1
 */