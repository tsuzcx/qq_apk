package com.tencent.featuretoggle.mmkv;

import android.content.Context;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.mmkv.MMKV;

public class MMKVPersitence
  implements IPersistenceProxy
{
  private MMKV a = null;
  
  public MMKV a()
  {
    return this.a;
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      this.a = MMKV.a(paramString, 2, ToggleSetting.s());
      return;
    }
    catch (Throwable paramContext)
    {
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.a.remove(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      this.a.a(paramString, paramLong);
      return;
    }
    catch (Throwable paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.a.a(paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      if (!LogUtils.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
  }
  
  public long b(String paramString, long paramLong)
  {
    try
    {
      long l = this.a.b(paramString, paramLong);
      return l;
    }
    catch (Throwable paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
    return paramLong;
  }
  
  public String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.a.b(paramString1, paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      if (!LogUtils.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return paramString2;
  }
  
  public void b()
  {
    try
    {
      this.a.clearAll();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      boolean bool = this.a.c(paramString);
      return bool;
    }
    catch (Throwable paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public String[] c()
  {
    try
    {
      String[] arrayOfString = this.a.allKeys();
      return arrayOfString;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.mmkv.MMKVPersitence
 * JD-Core Version:    0.7.0.1
 */