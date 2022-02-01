package com.tencent.luggage.wxa.fr;

import android.os.Process;
import com.tencent.luggage.wxa.qz.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/crash/WxaCrashLogItem;", "", "type", "Lcom/tencent/luggage/wxaapi/internal/crash/WxaCrashType;", "stack", "", "(Lcom/tencent/luggage/wxaapi/internal/crash/WxaCrashType;Ljava/lang/String;)V", "build_time", "getBuild_time", "()Ljava/lang/String;", "setBuild_time", "(Ljava/lang/String;)V", "is_released", "", "()Z", "set_released", "(Z)V", "pid", "", "getPid", "()I", "setPid", "(I)V", "process", "getProcess", "setProcess", "rev", "getRev", "setRev", "sdk_version", "getSdk_version", "setSdk_version", "signal", "getSignal", "setSignal", "getStack", "thread", "getThread", "setThread", "thread_id", "", "getThread_id", "()J", "setThread_id", "(J)V", "time", "getTime", "setTime", "timestamp", "getTimestamp", "setTimestamp", "toString", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
{
  @NotNull
  private String a;
  private long b;
  @NotNull
  private String c;
  private boolean d;
  @NotNull
  private String e;
  @NotNull
  private String f;
  @NotNull
  private String g;
  private int h;
  @NotNull
  private String i;
  private long j;
  private int k;
  private final d l;
  @NotNull
  private final String m;
  
  public c(@NotNull d paramd, @NotNull String paramString)
  {
    this.l = paramd;
    this.m = paramString;
    paramd = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.ENGLISH).format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(paramd, "SimpleDateFormat(\"yyyy-M…e.ENGLISH).format(Date())");
    this.a = paramd;
    this.b = System.currentTimeMillis();
    this.c = "1.5.1";
    this.d = true;
    this.e = "2021-06-22 15:37:22";
    this.f = "897a5c67ab7684eb5b9d8eba155ed3fc26c6dded";
    paramd = r.c();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "MMApplicationContext.getProcessName()");
    this.g = paramd;
    this.h = Process.myPid();
    paramd = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "Thread.currentThread()");
    paramd = paramd.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "Thread.currentThread().name");
    this.i = paramd;
    paramd = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "Thread.currentThread()");
    this.j = paramd.getId();
  }
  
  public final long a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  @NotNull
  public final String b()
  {
    return this.m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|type='");
    localStringBuilder.append(this.l.name());
    localStringBuilder.append("',\n|time='");
    localStringBuilder.append(this.a);
    localStringBuilder.append("',\n|timestamp='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("',\n|sdk_version='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("',\n|is_released=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",\n|build_time='");
    localStringBuilder.append(this.e);
    localStringBuilder.append("',\n|rev='");
    localStringBuilder.append(this.f);
    localStringBuilder.append("',\n|process='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('(');
    localStringBuilder.append(this.h);
    localStringBuilder.append(")',\n|thread='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('(');
    localStringBuilder.append(this.j);
    localStringBuilder.append(")',\n|signal=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",\n|stack='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fr.c
 * JD-Core Version:    0.7.0.1
 */