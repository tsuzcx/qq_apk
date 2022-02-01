package com.tencent.assistant.sdk.remote;

import android.os.IInterface;

public abstract interface SDKActionCallback
  extends IInterface
{
  public abstract void onActionResult(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.assistant.sdk.remote.SDKActionCallback
 * JD-Core Version:    0.7.0.1
 */