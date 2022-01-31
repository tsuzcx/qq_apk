package com.tencent.feedback.eup;

import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import java.util.Locale;

public class CrashStrategyBean
  implements Cloneable
{
  public static final String FORMAT = "[MSNum:%d ,Wifi:%d,GPRS:%d,ODay:%d,isMerged:%b,AfQ:%b,Silent:%b,mLog:%d,tag:%s,assert:%s, interval:%s, limit:%s]";
  private int a = 10;
  private int b = 10;
  private int c = 3;
  private int d = 10;
  private boolean e = true;
  private boolean f = false;
  private boolean g = true;
  private int h = 100;
  private int i = c.e;
  private String j = null;
  private boolean k = false;
  private String l = null;
  private int m = c.k;
  private int n = 1;
  private int o = c.f;
  private boolean p = false;
  private int q = 60;
  private int r = 50;
  private boolean s = true;
  private boolean t = true;
  
  public CrashStrategyBean clone()
    throws CloneNotSupportedException
  {
    try
    {
      CrashStrategyBean localCrashStrategyBean = new CrashStrategyBean();
      localCrashStrategyBean.setEnableAfterQuery(this.f);
      localCrashStrategyBean.setMaxStoredNum(this.a);
      localCrashStrategyBean.setMaxUploadNumGprs(this.c);
      localCrashStrategyBean.setMaxUploadNumWifi(this.b);
      localCrashStrategyBean.setMerged(this.e);
      localCrashStrategyBean.setRecordOverDays(this.d);
      localCrashStrategyBean.setSilentUpload(this.g);
      localCrashStrategyBean.setMaxLogRow(this.h);
      localCrashStrategyBean.setOnlyLogTag(this.j);
      localCrashStrategyBean.setAssertEnable(this.p);
      localCrashStrategyBean.setAssertTaskInterval(this.q);
      localCrashStrategyBean.setAssertLimitCount(this.r);
      return localCrashStrategyBean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getAssertLimitCount()
  {
    try
    {
      int i1 = this.r;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getAssertTaskInterval()
  {
    try
    {
      int i1 = this.q;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getCrashSdcardMaxSize()
  {
    try
    {
      int i1 = this.m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxLogLength()
  {
    return this.i;
  }
  
  public int getMaxLogRow()
  {
    try
    {
      int i1 = this.h;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxStackFrame()
  {
    try
    {
      int i1 = this.n;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxStackLength()
  {
    try
    {
      int i1 = this.o;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxStoredNum()
  {
    try
    {
      int i1 = this.a;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxUploadNumGprs()
  {
    try
    {
      int i1 = this.c;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getMaxUploadNumWifi()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getOnlyLogTag()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getRecordOverDays()
  {
    try
    {
      int i1 = this.d;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getStoreDirectoryPath()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAssertOn()
  {
    try
    {
      boolean bool = this.p;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableAfterQuery()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isMerged()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isOpenAnr()
  {
    try
    {
      boolean bool = this.s;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isSilentUpload()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isStoreCrashSdcard()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isUploadSpotCrash()
  {
    try
    {
      boolean bool = this.t;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAssertEnable(boolean paramBoolean)
  {
    try
    {
      this.p = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAssertLimitCount(int paramInt)
  {
    if (paramInt < 50) {}
    for (;;)
    {
      try
      {
        x.a("rqdp{The trigger count of the assert store is smaller than the default count.} [%s]", new Object[] { Integer.valueOf(paramInt) });
      }
      finally {}
      this.r = paramInt;
      return;
      paramInt = 50;
      continue;
      if (paramInt <= 0) {}
    }
  }
  
  public void setAssertTaskInterval(int paramInt)
  {
    if (paramInt < 60) {}
    for (;;)
    {
      try
      {
        x.a("rqdp{The interval of assert check task is smaller than the default time.} [%s s]", new Object[] { Integer.valueOf(paramInt) });
      }
      finally {}
      this.q = paramInt;
      return;
      paramInt = 60;
      continue;
      if (paramInt <= 0) {}
    }
  }
  
  public void setCrashSdcardMaxSize(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.m = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setEnableAfterQuery(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxLogLength(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setMaxLogRow(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.h = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxStackFrame(int paramInt)
  {
    try
    {
      this.n = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxStackLength(int paramInt)
  {
    try
    {
      this.o = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxStoredNum(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 20)) {}
    try
    {
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxUploadNumGprs(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMaxUploadNumWifi(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setMerged(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setOnlyLogTag(String paramString)
  {
    try
    {
      this.j = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setOpenAnr(boolean paramBoolean)
  {
    try
    {
      this.s = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setRecordOverDays(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSilentUpload(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setStoreCrashSdcard(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setStoreDirectoryPath(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setUploadSpotCrash(boolean paramBoolean)
  {
    try
    {
      this.t = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    try
    {
      String str1 = String.format(Locale.US, "[MSNum:%d ,Wifi:%d,GPRS:%d,ODay:%d,isMerged:%b,AfQ:%b,Silent:%b,mLog:%d,tag:%s,assert:%s, interval:%s, limit:%s]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g), Integer.valueOf(this.h), this.j, Boolean.valueOf(this.p), Integer.valueOf(this.r), Integer.valueOf(this.q) });
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (!x.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        String str2 = "error";
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashStrategyBean
 * JD-Core Version:    0.7.0.1
 */