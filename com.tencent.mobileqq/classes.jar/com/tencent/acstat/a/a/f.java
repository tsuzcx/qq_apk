package com.tencent.acstat.a.a;

import android.content.Context;
import android.provider.Settings.System;

public class f
  extends g
{
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(String paramString)
  {
    try
    {
      i.a("write mid to Settings.System");
      try
      {
        Settings.System.putString(this.a.getContentResolver(), f(), paramString);
      }
      catch (Throwable paramString)
      {
        i.a(paramString);
      }
      return;
    }
    finally {}
  }
  
  protected boolean a()
  {
    return i.a(this.a, "android.permission.WRITE_SETTINGS");
  }
  
  protected String b()
  {
    try
    {
      i.a("read mid from Settings.System");
      String str = Settings.System.getString(this.a.getContentResolver(), f());
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.a.a.f
 * JD-Core Version:    0.7.0.1
 */