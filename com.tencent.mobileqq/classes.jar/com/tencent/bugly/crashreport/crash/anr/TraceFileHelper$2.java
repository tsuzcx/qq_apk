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
    TraceFileHelper.a locala = this.a;
    locala.a = paramLong1;
    locala.b = paramString;
    locala.c = paramLong2;
    return this.b;
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    x.c("new thread %s", new Object[] { paramString1 });
    if (this.a.d == null) {
      this.a.d = new HashMap();
    }
    Map localMap = this.a.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localMap.put(paramString1, new String[] { paramString2, paramString3, localStringBuilder.toString() });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
 * JD-Core Version:    0.7.0.1
 */