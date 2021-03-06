package com.tencent.TMG.channel;

public class KSAppChannel$ReportCallbackImpl
  implements AVAppChannel.CsCmdCallback
{
  private AVAppChannel.CsCmdCallback mCallback;
  
  public KSAppChannel$ReportCallbackImpl(KSAppChannel paramKSAppChannel, AVAppChannel.CsCmdCallback paramCsCmdCallback)
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
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    AVAppChannel.CsCmdCallback localCsCmdCallback = this.mCallback;
    if (localCsCmdCallback != null)
    {
      localCsCmdCallback.onSuccess(paramArrayOfByte);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.channel.KSAppChannel.ReportCallbackImpl
 * JD-Core Version:    0.7.0.1
 */