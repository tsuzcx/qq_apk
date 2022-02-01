package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.a.a;

public abstract class AGConnectApp
{
  public static AGConnectApp getInstance()
  {
    return a.getInstance();
  }
  
  private static AGConnectApp getInstance(String paramString)
  {
    return a.getInstance(paramString);
  }
  
  public static AGConnectApp initialize(Context paramContext)
  {
    return a.initialize(paramContext);
  }
  
  private static AGConnectApp initialize(Context paramContext, String paramString)
  {
    return a.initialize(paramContext, paramString);
  }
  
  public abstract void setApiKey(String paramString);
  
  public abstract void setClientId(String paramString);
  
  public abstract void setClientSecret(String paramString);
  
  public abstract void setCustomAuthProvider(CustomAuthProvider paramCustomAuthProvider);
  
  public abstract void setCustomCredentialsProvider(CustomCredentialsProvider paramCustomCredentialsProvider);
  
  public abstract void setParam(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.AGConnectApp
 * JD-Core Version:    0.7.0.1
 */