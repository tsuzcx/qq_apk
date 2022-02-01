package com.tencent.ad.tangram.loader;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp;

@Keep
public final class AdLoader$Session
{
  public int httpResponseCode = -2147483648;
  public qq_ad_get.QQAdGet request;
  public qq_ad_get.QQAdGetRsp response;
  
  boolean canSend()
  {
    return this.request != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoader.Session
 * JD-Core Version:    0.7.0.1
 */