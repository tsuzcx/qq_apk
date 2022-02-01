package com.huawei.agconnect.config.a;

import android.content.Context;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;

public class a
  extends AGConnectServicesConfig
{
  private final Context a;
  private final String b;
  private LazyInputStream c;
  private volatile b d;
  private final Object e = new Object();
  
  public a(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private static LazyInputStream a(Context paramContext, InputStream paramInputStream)
  {
    return new a.1(paramContext, paramInputStream);
  }
  
  private static String a(String paramString)
  {
    int j = 0;
    int i = 0;
    if (paramString.length() > 0) {
      for (;;)
      {
        j = i;
        if (paramString.charAt(i) != '/') {
          break;
        }
        i += 1;
      }
    }
    return '/' + paramString.substring(j);
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
    if (paramString1 == null) {
      throw new NullPointerException("path must not be null.");
    }
    if (this.d == null) {}
    synchronized (this.e)
    {
      if (this.d == null)
      {
        if (this.c != null)
        {
          this.d = new d(this.c.loadInputStream());
          this.c.close();
          this.c = null;
        }
      }
      else
      {
        paramString1 = a(paramString1);
        return this.d.a(paramString1, paramString2);
      }
      this.d = new g(this.a, this.b);
    }
  }
  
  public void overlayWith(LazyInputStream paramLazyInputStream)
  {
    this.c = paramLazyInputStream;
  }
  
  public void overlayWith(InputStream paramInputStream)
  {
    overlayWith(a(this.a, paramInputStream));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.a
 * JD-Core Version:    0.7.0.1
 */