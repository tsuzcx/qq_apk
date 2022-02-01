package com.tencent.ilivesdk.liveconfigservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import org.json.JSONObject;

public abstract interface LiveConfigServiceInterface
  extends ServiceBaseInterface
{
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract JSONObject getJson(String paramString);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract void handleEnterRoomSuccess();
  
  public abstract void handleLoginSuccess(String paramString);
  
  public abstract void init(LiveConfigServiceAdapter paramLiveConfigServiceAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface
 * JD-Core Version:    0.7.0.1
 */