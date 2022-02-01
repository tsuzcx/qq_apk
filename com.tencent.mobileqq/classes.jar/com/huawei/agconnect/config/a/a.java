package com.huawei.agconnect.config.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectApp;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import java.util.HashMap;
import java.util.Map;

public class a
  extends AGConnectApp
{
  private static final Map<String, AGConnectApp> a = new HashMap();
  private static final Object b = new Object();
  private static String c;
  private AGConnectServicesConfig d;
  
  private a(Context paramContext, String paramString)
  {
    this.d = AGConnectServicesConfig.fromContext(paramContext, paramString);
  }
  
  public static AGConnectApp getInstance()
  {
    return getInstance(c);
  }
  
  public static AGConnectApp getInstance(String paramString)
  {
    synchronized (b)
    {
      paramString = (AGConnectApp)a.get(paramString);
      if (paramString != null) {
        return paramString;
      }
      throw new IllegalStateException("you should call AGConnectApp.initialize first");
    }
  }
  
  public static AGConnectApp initialize(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      paramContext = localContext;
    }
    c = paramContext.getPackageName();
    return initialize(paramContext, c);
  }
  
  public static AGConnectApp initialize(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (b)
      {
        AGConnectApp localAGConnectApp = (AGConnectApp)a.get(paramString);
        if (localAGConnectApp == null)
        {
          paramContext = new a(paramContext, paramString);
          a.put(paramString, paramContext);
        }
        return localAGConnectApp;
      }
    }
    throw new IllegalArgumentException("packageName can not be empty");
  }
  
  public void setApiKey(String paramString)
  {
    this.d.setParam("/client/api_key", paramString);
  }
  
  public void setClientId(String paramString)
  {
    this.d.setParam("/client/client_id", paramString);
  }
  
  public void setClientSecret(String paramString)
  {
    this.d.setParam("/client/client_secret", paramString);
  }
  
  public void setCustomAuthProvider(CustomAuthProvider paramCustomAuthProvider)
  {
    ((com.huawei.agconnect.core.a.a)AGConnectInstance.getInstance()).a(paramCustomAuthProvider);
  }
  
  public void setCustomCredentialsProvider(CustomCredentialsProvider paramCustomCredentialsProvider)
  {
    ((com.huawei.agconnect.core.a.a)AGConnectInstance.getInstance()).a(paramCustomCredentialsProvider);
  }
  
  public void setParam(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.d.setParam(paramString1, paramString2);
      return;
    }
    throw new IllegalArgumentException("path can not be empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.a
 * JD-Core Version:    0.7.0.1
 */