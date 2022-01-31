package com.tencent.mobileqq.apollo.tmg_opensdk;

import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.qphone.base.util.QLog;

public class SSOChannel$CsCmdCallbackImpl
  implements AVAppChannel.CsCmdCallback
{
  private AVAppChannel.CsCmdCallback a;
  
  public void onError(int paramInt, String paramString)
  {
    QLog.e(SSOChannel.a, 1, "onFailed code :" + paramInt + " info: " + paramString);
    if (this.a != null)
    {
      this.a.onError(paramInt, paramString);
      this.a = null;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    QLog.e(SSOChannel.a, 1, "onSuccess");
    if (this.a != null)
    {
      this.a.onSuccess(paramArrayOfByte);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.SSOChannel.CsCmdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */