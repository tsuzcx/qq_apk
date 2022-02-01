package com.tencent.mobileqq.ark.env;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ArkAppEnvConfig
{
  private static final ArkAppEnvConfig a = new ArkAppEnvConfig(1);
  private static final ArkAppEnvConfig b = new ArkAppEnvConfig(2);
  private static ArkAppEnvConfig c = b;
  private static boolean d = false;
  private final int e;
  private final String f;
  private final String g;
  private final String h;
  private final SharedPreferences i;
  private final SharedPreferences j;
  
  private ArkAppEnvConfig(int paramInt)
  {
    this.e = paramInt;
    this.f = a(paramInt);
    this.h = b(paramInt);
    this.i = c(paramInt);
    this.j = d(paramInt);
    if (paramInt == 1)
    {
      this.g = "test.ark.qq.com";
      return;
    }
    this.g = "cgi.ark.qq.com";
  }
  
  public static ArkAppEnvConfig a()
  {
    if (!d)
    {
      d = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkTemp.getCurrent sso env isTestEnv=");
      localStringBuilder.append(false);
      QLog.i("ArkApp", 1, localStringBuilder.toString());
    }
    c = b;
    return c;
  }
  
  private static String a(int paramInt)
  {
    String str = g();
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/ArkAppTest");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/ArkApp");
    return localStringBuilder.toString();
  }
  
  private static String b(int paramInt)
  {
    String str = g();
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/pddata/prd/arkapp/test");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/pddata/prd/arkapp");
    return localStringBuilder.toString();
  }
  
  private static SharedPreferences c(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfigDebug", 0);
  }
  
  private static SharedPreferences d(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfigDebug", 0);
  }
  
  private static String g()
  {
    return BaseApplication.getContext().getFilesDir().getAbsolutePath();
  }
  
  public int b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("/Dict");
    return localStringBuilder.toString();
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("/Debug");
    return localStringBuilder.toString();
  }
  
  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("/Crash");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.env.ArkAppEnvConfig
 * JD-Core Version:    0.7.0.1
 */