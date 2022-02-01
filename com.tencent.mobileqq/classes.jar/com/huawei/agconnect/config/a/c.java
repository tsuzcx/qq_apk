package com.huawei.agconnect.config.a;

import android.content.Context;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class c
  extends AGConnectServicesConfig
{
  private final Context a;
  private final String b;
  private LazyInputStream c;
  private volatile d d;
  private final Object e = new Object();
  private Map<String, String> f = new HashMap();
  
  public c(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private static LazyInputStream a(Context paramContext, InputStream paramInputStream)
  {
    return new b(paramContext, paramInputStream);
  }
  
  private static String a(String paramString)
  {
    int k = paramString.length();
    int j = 0;
    int i = 0;
    if (k > 0) {
      for (;;)
      {
        j = i;
        if (paramString.charAt(i) != '/') {
          break;
        }
        i += 1;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('/');
    localStringBuilder.append(paramString.substring(j));
    return localStringBuilder.toString();
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return Boolean.parseBoolean(getString(paramString, String.valueOf(paramBoolean)));
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(getString(paramString, String.valueOf(paramInt)));
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public String getString(String paramString)
  {
    return getString(paramString, null);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (this.d == null) {
        synchronized (this.e)
        {
          if (this.d == null) {
            if (this.c != null)
            {
              this.d = new f(this.c.loadInputStream());
              this.c.close();
              this.c = null;
            }
            else
            {
              this.d = new i(this.a, this.b);
            }
          }
        }
      }
      paramString1 = a(paramString1);
      if (this.f.containsKey(paramString1))
      {
        if (this.f.get(paramString1) != null) {
          paramString2 = (String)this.f.get(paramString1);
        }
        return paramString2;
      }
      return this.d.getString(paramString1, paramString2);
    }
    throw new NullPointerException("path must not be null.");
  }
  
  public void overlayWith(LazyInputStream paramLazyInputStream)
  {
    this.c = paramLazyInputStream;
  }
  
  public void overlayWith(InputStream paramInputStream)
  {
    overlayWith(a(this.a, paramInputStream));
  }
  
  public void setParam(String paramString1, String paramString2)
  {
    this.f.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.c
 * JD-Core Version:    0.7.0.1
 */