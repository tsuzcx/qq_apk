package com.tencent.mm.websocket.libwcwss;

import androidx.annotation.Keep;

@Keep
public abstract interface WcwssNative$IWcWssWebSocketListener
{
  @Keep
  public abstract int doCertificateVerify(String paramString1, long paramLong, String paramString2, byte[][] paramArrayOfByte);
  
  @Keep
  public abstract void onStateChange(String paramString, long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
 * JD-Core Version:    0.7.0.1
 */