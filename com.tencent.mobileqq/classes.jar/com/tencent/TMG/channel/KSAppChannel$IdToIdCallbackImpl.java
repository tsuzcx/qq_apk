package com.tencent.TMG.channel;

public class KSAppChannel$IdToIdCallbackImpl
  implements AVAppChannel.IdToIdCallback
{
  private AVAppChannel.IdToIdCallback mCallback;
  
  public KSAppChannel$IdToIdCallbackImpl(KSAppChannel paramKSAppChannel, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    this.mCallback = paramIdToIdCallback;
  }
  
  public void onError(int paramInt, String paramString)
  {
    AVAppChannel.IdToIdCallback localIdToIdCallback = this.mCallback;
    if (localIdToIdCallback != null)
    {
      localIdToIdCallback.onError(paramInt, paramString);
      this.mCallback = null;
    }
  }
  
  public void onSuccess(String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    AVAppChannel.IdToIdCallback localIdToIdCallback = this.mCallback;
    if (localIdToIdCallback != null)
    {
      localIdToIdCallback.onSuccess(paramArrayOfString, paramArrayOfLong);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.channel.KSAppChannel.IdToIdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */