package com.tencent.TMG.sdk;

import com.tencent.TMG.channel.AVAppChannel.IdToIdCallback;

public class IMChannel$IdToIdCallbackImpl
  implements AVAppChannel.IdToIdCallback
{
  private int mNativeCallback;
  
  public IMChannel$IdToIdCallbackImpl(IMChannel paramIMChannel, int paramInt)
  {
    this.mNativeCallback = paramInt;
  }
  
  public void onError(int paramInt, String paramString)
  {
    IMChannel.IdToIdResult localIdToIdResult = new IMChannel.IdToIdResult(this.this$0);
    localIdToIdResult.result = paramInt;
    localIdToIdResult.errorInfo = paramString;
    this.this$0.nativeIdToIdCallback(this.mNativeCallback, localIdToIdResult);
    this.mNativeCallback = 0;
  }
  
  public void onSuccess(String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    IMChannel.IdToIdResult localIdToIdResult = new IMChannel.IdToIdResult(this.this$0);
    localIdToIdResult.result = 0;
    localIdToIdResult.identifierList = paramArrayOfString;
    localIdToIdResult.tinyIdList = paramArrayOfLong;
    this.this$0.nativeIdToIdCallback(this.mNativeCallback, localIdToIdResult);
    this.mNativeCallback = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.sdk.IMChannel.IdToIdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */