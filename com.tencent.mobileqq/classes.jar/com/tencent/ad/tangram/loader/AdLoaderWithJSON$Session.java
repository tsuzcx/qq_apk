package com.tencent.ad.tangram.loader;

import android.support.annotation.Keep;
import org.json.JSONObject;

@Keep
public final class AdLoaderWithJSON$Session
{
  public int httpResponseCode = -2147483648;
  public JSONObject request;
  public JSONObject response;
  public long timeMillis = -2147483648L;
  
  public boolean canSend()
  {
    return (this.request != null) && (this.request != JSONObject.NULL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoaderWithJSON.Session
 * JD-Core Version:    0.7.0.1
 */