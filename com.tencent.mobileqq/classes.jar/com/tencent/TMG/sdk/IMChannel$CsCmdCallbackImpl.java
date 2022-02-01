package com.tencent.TMG.sdk;

import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;

public class IMChannel$CsCmdCallbackImpl
  implements AVAppChannel.CsCmdCallback
{
  private int mNativeCallback;
  
  public IMChannel$CsCmdCallbackImpl(IMChannel paramIMChannel, int paramInt)
  {
    this.mNativeCallback = paramInt;
  }
  
  public void onError(int paramInt, String paramString)
  {
    IMChannel.MultiVideoResult localMultiVideoResult = new IMChannel.MultiVideoResult(this.this$0);
    localMultiVideoResult.result = paramInt;
    localMultiVideoResult.errorInfo = paramString;
    this.this$0.nativeMultiVideoCallback(this.mNativeCallback, localMultiVideoResult);
    this.mNativeCallback = 0;
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    IMChannel.MultiVideoResult localMultiVideoResult = new IMChannel.MultiVideoResult(this.this$0);
    localMultiVideoResult.result = 0;
    localMultiVideoResult.response = paramArrayOfByte;
    this.this$0.nativeMultiVideoCallback(this.mNativeCallback, localMultiVideoResult);
    this.mNativeCallback = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.IMChannel.CsCmdCallbackImpl
 * JD-Core Version:    0.7.0.1
 */