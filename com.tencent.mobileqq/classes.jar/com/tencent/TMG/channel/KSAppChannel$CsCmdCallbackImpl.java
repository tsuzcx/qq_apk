package com.tencent.TMG.channel;

import android.util.Log;

public class KSAppChannel$CsCmdCallbackImpl
  implements AVAppChannel.CsCmdCallback
{
  private AVAppChannel.CsCmdCallback mCallback;
  
  public KSAppChannel$CsCmdCallbackImpl(KSAppChannel paramKSAppChannel, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    this.mCallback = paramCsCmdCallback;
  }
  
  public void onError(int paramInt, String paramString)
  {
    Log.e("shixu", "code :" + paramInt + " info: " + paramString);
    if (this.mCallback != null)
    {
      this.mCallback.onError(paramInt, paramString);
      this.mCallback = null;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    Log.e("shixu", "success");
    if (this.mCallback != null)
    {
      this.mCallback.onSuccess(paramArrayOfByte);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.channel.KSAppChannel.CsCmdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */