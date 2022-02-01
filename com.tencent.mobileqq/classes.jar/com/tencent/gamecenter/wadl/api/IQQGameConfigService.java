package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

@QAPI(process={"all"})
public abstract interface IQQGameConfigService
  extends QRouteApi
{
  public static final String KEY_CONF_COMM = "comminfo";
  
  public abstract void checkConfigUpdate(boolean paramBoolean, long paramLong);
  
  public abstract <T> T getConfig(String paramString);
  
  public abstract File getConfigFile();
  
  public abstract void loadConfig();
  
  public abstract void requestConfig(long paramLong);
  
  public abstract void writeConfig(boolean paramBoolean, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameConfigService
 * JD-Core Version:    0.7.0.1
 */