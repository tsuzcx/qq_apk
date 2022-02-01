package com.tencent.mobileqq.ark.core;

import com.tencent.ark.open.delegate.IArkDelegateSSOCallback;
import com.tencent.qphone.base.util.QLog;

class ArkMultiProc$4$1
  implements ArkAppSSOIPCHandler.OnSendMsgComplete
{
  ArkMultiProc$4$1(ArkMultiProc.4 param4, IArkDelegateSSOCallback paramIArkDelegateSSOCallback) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArkMultiProc.sendAppMsg, success=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data=");
    localStringBuilder.append(paramString);
    QLog.i("ArkApp.MultiProc", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateSSOCallback.onComplete(paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.4.1
 * JD-Core Version:    0.7.0.1
 */