package com.tencent.TMG.channel;

import com.tencent.TIMValueCallBack;

public class IMAppChannel$CsCmdCallbackImpl
  implements TIMValueCallBack<byte[]>
{
  private AVAppChannel.CsCmdCallback mCallback;
  
  public IMAppChannel$CsCmdCallbackImpl(IMAppChannel paramIMAppChannel, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    this.mCallback = paramCsCmdCallback;
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (this.mCallback != null)
    {
      this.mCallback.onError(paramInt, paramString);
      this.mCallback = null;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    if (this.mCallback != null)
    {
      this.mCallback.onSuccess(paramArrayOfByte);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.channel.IMAppChannel.CsCmdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */