package com.huawei.updatesdk.a.b.c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public final class b
{
  private Intent a;
  
  private b(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public static b a(Intent paramIntent)
  {
    return new b(paramIntent);
  }
  
  public long a(String paramString, int paramInt)
  {
    if (d()) {
      try
      {
        long l = this.a.getLongExtra(paramString, paramInt);
        return l;
      }
      catch (Exception paramString)
      {
        Log.e("SecureIntent", "getIntExtra exception!");
      }
    }
    return paramInt;
  }
  
  public Bundle a()
  {
    if (d()) {
      return this.a.getExtras();
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (d()) {
      try
      {
        paramString = this.a.getStringExtra(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("SecureIntent", "getStringExtra exception!");
      }
    }
    return "";
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (d()) {}
    try
    {
      bool = this.a.getBooleanExtra(paramString, paramBoolean);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("SecureIntent", "getBooleanExtra exception!");
    }
    return paramBoolean;
  }
  
  public int b(String paramString, int paramInt)
  {
    int i = paramInt;
    if (d()) {}
    try
    {
      i = this.a.getIntExtra(paramString, paramInt);
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("SecureIntent", "getIntExtra exception!");
    }
    return paramInt;
  }
  
  public String b()
  {
    Object localObject = "";
    if (d())
    {
      String str = this.a.getAction();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    return localObject;
  }
  
  public Intent c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.c.b
 * JD-Core Version:    0.7.0.1
 */