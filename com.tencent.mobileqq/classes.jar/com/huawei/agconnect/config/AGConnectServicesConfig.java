package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class AGConnectServicesConfig
{
  private static final Map<String, AGConnectServicesConfig> INSTANCES = new HashMap();
  private static final Object INSTANCES_LOCK = new Object();
  
  public static AGConnectServicesConfig fromContext(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      paramContext = localContext;
    }
    return fromContext(paramContext, paramContext.getPackageName());
  }
  
  public static AGConnectServicesConfig fromContext(Context paramContext, String paramString)
  {
    synchronized (INSTANCES_LOCK)
    {
      AGConnectServicesConfig localAGConnectServicesConfig = (AGConnectServicesConfig)INSTANCES.get(paramString);
      Object localObject1 = localAGConnectServicesConfig;
      if (localAGConnectServicesConfig == null)
      {
        localObject1 = new c(paramContext, paramString);
        INSTANCES.put(paramString, localObject1);
      }
      return localObject1;
    }
  }
  
  public abstract boolean getBoolean(String paramString);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract int getInt(String paramString);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract String getString(String paramString);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract void overlayWith(LazyInputStream paramLazyInputStream);
  
  public abstract void overlayWith(InputStream paramInputStream);
  
  public abstract void setParam(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.AGConnectServicesConfig
 * JD-Core Version:    0.7.0.1
 */