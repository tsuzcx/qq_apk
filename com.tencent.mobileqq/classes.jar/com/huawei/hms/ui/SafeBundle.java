package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.a;

public class SafeBundle
{
  public final Bundle a;
  
  public SafeBundle()
  {
    this(new Bundle());
  }
  
  public SafeBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    this.a = paramBundle;
  }
  
  public boolean containsKey(String paramString)
  {
    try
    {
      boolean bool = this.a.containsKey(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      label11:
      break label11;
    }
    a.a("SafeBundle", "containsKey exception. key:");
    return false;
  }
  
  public Object get(String paramString)
  {
    try
    {
      paramString = this.a.get(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get exception: ");
      localStringBuilder.append(paramString.getMessage());
      a.a("SafeBundle", localStringBuilder.toString(), true);
    }
    return null;
  }
  
  public Bundle getBundle()
  {
    return this.a;
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    try
    {
      int i = this.a.getInt(paramString, paramInt);
      return i;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInt exception: ");
      localStringBuilder.append(paramString.getMessage());
      a.a("SafeBundle", localStringBuilder.toString(), true);
    }
    return paramInt;
  }
  
  public String getString(String paramString)
  {
    try
    {
      paramString = this.a.getString(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getString exception: ");
      localStringBuilder.append(paramString.getMessage());
      a.a("SafeBundle", localStringBuilder.toString(), true);
    }
    return "";
  }
  
  public String getString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.a.getString(paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getString exception: ");
      localStringBuilder.append(paramString1.getMessage());
      a.a("SafeBundle", localStringBuilder.toString(), true);
    }
    return paramString2;
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = this.a.isEmpty();
      return bool;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    a.a("SafeBundle", "isEmpty exception");
    return true;
  }
  
  public int size()
  {
    try
    {
      int i = this.a.size();
      return i;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    a.a("SafeBundle", "size exception");
    return 0;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.ui.SafeBundle
 * JD-Core Version:    0.7.0.1
 */