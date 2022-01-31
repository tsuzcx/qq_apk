package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.util.HashMap;
import java.util.Map;

final class TraceFileHelper$2
  implements TraceFileHelper.b
{
  TraceFileHelper$2(TraceFileHelper.a parama, boolean paramBoolean) {}
  
  public final boolean a(long paramLong)
  {
    x.c("process end %d", new Object[] { Long.valueOf(paramLong) });
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, String paramString)
  {
    x.c("new process %s", new Object[] { paramString });
    this.a.a = paramLong1;
    this.a.b = paramString;
    this.a.c = paramLong2;
    return this.b;
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    x.c("new thread %s", new Object[] { paramString1 });
    if (this.a.d == null) {
      this.a.d = new HashMap();
    }
    this.a.d.put(paramString1, new String[] { paramString2, paramString3, paramInt });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
 * JD-Core Version:    0.7.0.1
 */