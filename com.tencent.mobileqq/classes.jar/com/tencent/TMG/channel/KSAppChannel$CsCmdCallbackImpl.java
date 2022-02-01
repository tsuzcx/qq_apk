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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("code :");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" info: ");
    ((StringBuilder)localObject).append(paramString);
    Log.e("shixu", ((StringBuilder)localObject).toString());
    localObject = this.mCallback;
    if (localObject != null)
    {
      ((AVAppChannel.CsCmdCallback)localObject).onError(paramInt, paramString);
      this.mCallback = null;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    Log.e("shixu", "success");
    AVAppChannel.CsCmdCallback localCsCmdCallback = this.mCallback;
    if (localCsCmdCallback != null)
    {
      localCsCmdCallback.onSuccess(paramArrayOfByte);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.channel.KSAppChannel.CsCmdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */