package com.tencent.feedback.eup;

import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;

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
  private int u = 31;
  private boolean v = true;
  
  public CrashStrategyBean clone()
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
  
  public int getCallBackType()
  {
    try
    {
      int i1 = this.u;
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
      boolean bool = this.v;
      return bool;
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
      finally
      {
        Object localObject1;
        continue;
      }
      this.r = paramInt;
      return;
      throw localObject1;
      if (paramInt <= 0) {
        paramInt = 50;
      }
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
      finally
      {
        Object localObject1;
        continue;
      }
      this.q = paramInt;
      return;
      throw localObject1;
      if (paramInt <= 0) {
        paramInt = 60;
      }
    }
  }
  
  public void setCallBackType(int paramInt)
  {
    try
    {
      this.u = paramInt;
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
      this.v = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCrashSdcardMaxSize(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.m = paramInt;
    }
    finally {}
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
    }
    finally {}
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
    }
    finally {}
  }
  
  public void setMaxUploadNumGprs(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.c = paramInt;
    }
    finally {}
  }
  
  public void setMaxUploadNumWifi(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.b = paramInt;
    }
    finally {}
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
    }
    finally {}
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
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 195	java/util/Locale:US	Ljava/util/Locale;
    //   5: ldc 10
    //   7: bipush 12
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_0
    //   15: getfield 40	com/tencent/feedback/eup/CrashStrategyBean:a	I
    //   18: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_0
    //   25: getfield 42	com/tencent/feedback/eup/CrashStrategyBean:b	I
    //   28: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: aload_0
    //   35: getfield 44	com/tencent/feedback/eup/CrashStrategyBean:c	I
    //   38: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: dup
    //   43: iconst_3
    //   44: aload_0
    //   45: getfield 46	com/tencent/feedback/eup/CrashStrategyBean:d	I
    //   48: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_4
    //   54: aload_0
    //   55: getfield 48	com/tencent/feedback/eup/CrashStrategyBean:e	Z
    //   58: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   61: aastore
    //   62: dup
    //   63: iconst_5
    //   64: aload_0
    //   65: getfield 50	com/tencent/feedback/eup/CrashStrategyBean:f	Z
    //   68: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   71: aastore
    //   72: dup
    //   73: bipush 6
    //   75: aload_0
    //   76: getfield 52	com/tencent/feedback/eup/CrashStrategyBean:g	Z
    //   79: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   82: aastore
    //   83: dup
    //   84: bipush 7
    //   86: aload_0
    //   87: getfield 54	com/tencent/feedback/eup/CrashStrategyBean:h	I
    //   90: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: dup
    //   95: bipush 8
    //   97: aload_0
    //   98: getfield 62	com/tencent/feedback/eup/CrashStrategyBean:j	Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: bipush 9
    //   105: aload_0
    //   106: getfield 78	com/tencent/feedback/eup/CrashStrategyBean:p	Z
    //   109: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   112: aastore
    //   113: dup
    //   114: bipush 10
    //   116: aload_0
    //   117: getfield 82	com/tencent/feedback/eup/CrashStrategyBean:r	I
    //   120: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: dup
    //   125: bipush 11
    //   127: aload_0
    //   128: getfield 80	com/tencent/feedback/eup/CrashStrategyBean:q	I
    //   131: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: aastore
    //   135: invokestatic 206	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: areturn
    //   143: astore_1
    //   144: goto +20 -> 164
    //   147: astore_1
    //   148: aload_1
    //   149: invokestatic 209	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   152: ifne +7 -> 159
    //   155: aload_1
    //   156: invokevirtual 212	java/lang/Throwable:printStackTrace	()V
    //   159: aload_0
    //   160: monitorexit
    //   161: ldc 214
    //   163: areturn
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	CrashStrategyBean
    //   138	4	1	str	String
    //   143	1	1	localObject	Object
    //   147	20	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	139	143	finally
    //   148	159	143	finally
    //   2	139	147	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashStrategyBean
 * JD-Core Version:    0.7.0.1
 */