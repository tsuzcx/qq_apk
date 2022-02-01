package com.tencent.bugly;

public class BuglyStrategy
{
  private String a;
  private String b;
  private String c;
  private long d;
  private String e;
  private String f;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  private Class<?> j = null;
  private boolean k = true;
  private boolean l = true;
  private boolean m = true;
  private boolean n = false;
  private com.tencent.bugly.proguard.a o;
  private int p = 31;
  private boolean q = false;
  
  public String getAppChannel()
  {
    try
    {
      if (this.b == null)
      {
        str = com.tencent.bugly.crashreport.common.info.a.b().o;
        return str;
      }
      String str = this.b;
      return str;
    }
    finally {}
  }
  
  public String getAppPackageName()
  {
    try
    {
      if (this.c == null)
      {
        str = com.tencent.bugly.crashreport.common.info.a.b().c;
        return str;
      }
      String str = this.c;
      return str;
    }
    finally {}
  }
  
  public long getAppReportDelay()
  {
    try
    {
      long l1 = this.d;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getAppVersion()
  {
    try
    {
      if (this.a == null)
      {
        str = com.tencent.bugly.crashreport.common.info.a.b().m;
        return str;
      }
      String str = this.a;
      return str;
    }
    finally {}
  }
  
  public int getCallBackType()
  {
    try
    {
      int i1 = this.p;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean getCloseErrorCallback()
  {
    try
    {
      boolean bool = this.q;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public com.tencent.bugly.proguard.a getCrashHandleCallback$49db9608()
  {
    try
    {
      com.tencent.bugly.proguard.a locala = this.o;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getDeviceID()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getLibBuglySOFilePath()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Class<?> getUserInfoActivity()
  {
    try
    {
      Class localClass = this.j;
      return localClass;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isBuglyLogUpload()
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
  
  public boolean isEnableANRCrashMonitor()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isEnableNativeCrashMonitor()
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
  
  public boolean isEnableUserInfo()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isReplaceOldChannel()
  {
    return this.l;
  }
  
  public boolean isUploadProcess()
  {
    try
    {
      boolean bool = this.m;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean recordUserInfoOnceADay()
  {
    try
    {
      boolean bool = this.n;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setAppChannel(String paramString)
  {
    try
    {
      this.b = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppPackageName(String paramString)
  {
    try
    {
      this.c = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppReportDelay(long paramLong)
  {
    try
    {
      this.d = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setAppVersion(String paramString)
  {
    try
    {
      this.a = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setBuglyLogUpload(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCallBackType(int paramInt)
  {
    try
    {
      this.p = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCloseErrorCallback(boolean paramBoolean)
  {
    try
    {
      this.q = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setCrashHandleCallback$59ec52b1(com.tencent.bugly.proguard.a parama)
  {
    try
    {
      this.o = parama;
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public BuglyStrategy setDeviceID(String paramString)
  {
    try
    {
      this.f = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setEnableANRCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setEnableNativeCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setEnableUserInfo(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setLibBuglySOFilePath(String paramString)
  {
    try
    {
      this.e = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setRecordUserInfoOnceADay(boolean paramBoolean)
  {
    try
    {
      this.n = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setReplaceOldChannel(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public BuglyStrategy setUploadProcess(boolean paramBoolean)
  {
    try
    {
      this.m = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public BuglyStrategy setUserInfoActivity(Class<?> paramClass)
  {
    try
    {
      this.j = paramClass;
      return this;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.BuglyStrategy
 * JD-Core Version:    0.7.0.1
 */