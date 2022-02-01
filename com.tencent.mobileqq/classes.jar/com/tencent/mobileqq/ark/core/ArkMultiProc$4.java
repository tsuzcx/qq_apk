package com.tencent.mobileqq.ark.core;

import com.tencent.ark.open.delegate.IArkDelegateSSO;
import com.tencent.ark.open.delegate.IArkDelegateSSOCallback;
import com.tencent.qphone.base.util.QLog;

final class ArkMultiProc$4
  implements IArkDelegateSSO
{
  public void send(String paramString1, String paramString2, int paramInt, IArkDelegateSSOCallback paramIArkDelegateSSOCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArkMultiProc.sendAppMsg, cmd=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", timeout=");
    localStringBuilder.append(paramInt);
    QLog.i("ArkApp.MultiProc", 1, localStringBuilder.toString());
    ArkAppSSOIPCHandler.a(paramString1, paramString2, paramInt, 0, new ArkMultiProc.4.1(this, paramIArkDelegateSSOCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.4
 * JD-Core Version:    0.7.0.1
 */