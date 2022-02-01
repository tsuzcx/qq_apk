package com.tencent.mm.websocket.libwcwss;

import androidx.annotation.Keep;

@Keep
public abstract interface WcwssNative$IWcWssReportListener
{
  @Keep
  public abstract int getNetworkType();
  
  @Keep
  public abstract void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  @Keep
  public abstract void onKvStat(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
 * JD-Core Version:    0.7.0.1
 */