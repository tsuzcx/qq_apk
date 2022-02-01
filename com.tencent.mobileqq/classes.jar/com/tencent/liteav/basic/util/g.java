package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteav.basic.log.TXCLog;

public class g
{
  protected static volatile g a;
  private final String b = "TXCSpUtil";
  private SharedPreferences c;
  private final Object d = new Object();
  private Context e;
  
  public static g a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new g();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }
  
  public void a(String paramString, int paramInt)
  {
    Context localContext = this.e;
    try
    {
      synchronized (this.d)
      {
        if ((this.c == null) && (localContext != null)) {
          this.c = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        if (this.c != null) {
          this.c.edit().putInt(paramString, paramInt).commit();
        }
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLastEncodeType: error: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" , ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ; ");
      localStringBuilder.append(localException);
      TXCLog.e("TXCSpUtil", localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Context localContext = this.e;
    try
    {
      synchronized (this.d)
      {
        if ((this.c == null) && (localContext != null)) {
          this.c = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        if (this.c != null) {
          this.c.edit().putBoolean(paramString, paramBoolean).commit();
        }
        return;
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveConfigInfo: error: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ; ");
      localStringBuilder.append(localException);
      TXCLog.e("TXCSpUtil", localStringBuilder.toString());
    }
  }
  
  public int b(String paramString, int paramInt)
  {
    Context localContext = this.e;
    try
    {
      synchronized (this.d)
      {
        if ((this.c == null) && (localContext != null)) {
          this.c = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        if (this.c != null)
        {
          int i = this.c.getInt(paramString, paramInt);
          return i;
        }
        return paramInt;
      }
      return paramInt;
    }
    catch (Exception paramString)
    {
      TXCLog.e("TXCSpUtil", "getLastEncodeType: error.", paramString);
    }
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    Context localContext = this.e;
    try
    {
      synchronized (this.d)
      {
        if ((this.c == null) && (localContext != null)) {
          this.c = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        if (this.c != null)
        {
          boolean bool = this.c.getBoolean(paramString, paramBoolean);
          return bool;
        }
        return paramBoolean;
      }
      StringBuilder localStringBuilder;
      return paramBoolean;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveConfigInfo: error: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ; ");
      localStringBuilder.append(localException);
      TXCLog.e("TXCSpUtil", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.g
 * JD-Core Version:    0.7.0.1
 */