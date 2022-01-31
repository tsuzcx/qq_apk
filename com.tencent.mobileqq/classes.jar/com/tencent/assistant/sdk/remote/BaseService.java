package com.tencent.assistant.sdk.remote;

import android.os.IInterface;

public abstract interface BaseService
  extends IInterface
{
  public abstract int registerActionCallback(String paramString1, String paramString2, SDKActionCallback paramSDKActionCallback);
  
  public abstract void sendAsyncData(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] sendSyncData(String paramString, byte[] paramArrayOfByte);
  
  public abstract int unregisterActionCallback(SDKActionCallback paramSDKActionCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.assistant.sdk.remote.BaseService
 * JD-Core Version:    0.7.0.1
 */