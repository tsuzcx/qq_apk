package com.tencent.TMG.channel;

import com.tencent.TIMCallBack;

public class IMAppChannel$ReportCallbackImpl
  implements TIMCallBack
{
  private AVAppChannel.CsCmdCallback mCallback;
  
  public IMAppChannel$ReportCallbackImpl(IMAppChannel paramIMAppChannel, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    this.mCallback = paramCsCmdCallback;
  }
  
  public void onError(int paramInt, String paramString)
  {
    AVAppChannel.CsCmdCallback localCsCmdCallback = this.mCallback;
    if (localCsCmdCallback != null)
    {
      localCsCmdCallback.onError(paramInt, paramString);
      this.mCallback = null;
    }
  }
  
  public void onSuccess()
  {
    AVAppChannel.CsCmdCallback localCsCmdCallback = this.mCallback;
    if (localCsCmdCallback != null)
    {
      localCsCmdCallback.onSuccess(null);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.channel.IMAppChannel.ReportCallbackImpl
 * JD-Core Version:    0.7.0.1
 */