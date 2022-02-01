package com.tencent.logger.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/LogConfig;", "", "isDebug", "", "logRootDir", "", "logLevel", "Lcom/tencent/logger/log/LogLevel;", "isOpenConsoleLog", "maxAliveDuration", "", "maxFileSize", "curProcessName", "logWriterQueueCapacity", "", "(ZLjava/lang/String;Lcom/tencent/logger/log/LogLevel;ZJJLjava/lang/String;I)V", "getCurProcessName", "()Ljava/lang/String;", "()Z", "getLogLevel", "()Lcom/tencent/logger/log/LogLevel;", "getLogRootDir", "getLogWriterQueueCapacity", "()I", "getMaxAliveDuration", "()J", "getMaxFileSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LogConfig
{
  private final boolean a;
  @NotNull
  private final String b;
  @NotNull
  private final LogLevel c;
  private final boolean d;
  private final long e;
  private final long f;
  @NotNull
  private final String g;
  private final int h;
  
  public LogConfig()
  {
    this(false, null, null, false, 0L, 0L, null, 0, 255, null);
  }
  
  public LogConfig(boolean paramBoolean1, @NotNull String paramString1, @NotNull LogLevel paramLogLevel, boolean paramBoolean2, long paramLong1, long paramLong2, @NotNull String paramString2, int paramInt)
  {
    this.a = paramBoolean1;
    this.b = paramString1;
    this.c = paramLogLevel;
    this.d = paramBoolean2;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramString2;
    this.h = paramInt;
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  @NotNull
  public final LogLevel b()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LogConfig))
      {
        paramObject = (LogConfig)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (Intrinsics.areEqual(this.g, paramObject.g)) && (this.h == paramObject.h)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogConfig(isDebug=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", logRootDir=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", logLevel=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isOpenConsoleLog=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", maxAliveDuration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", maxFileSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", curProcessName=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", logWriterQueueCapacity=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.LogConfig
 * JD-Core Version:    0.7.0.1
 */