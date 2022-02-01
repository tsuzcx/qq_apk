package com.tencent.luggage.wxa.ea;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "", "appId", "", "debugType", "", "status", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;", "isPersistentApp", "", "(Ljava/lang/String;ILcom/tencent/luggage/sdk/processes/LuggageMiniProgramStatus;Z)V", "getAppId", "()Ljava/lang/String;", "getDebugType", "()I", "setDebugType", "(I)V", "instanceId", "getInstanceId", "setInstanceId", "(Ljava/lang/String;)V", "()Z", "setPersistentApp", "(Z)V", "preRendered", "getPreRendered", "setPreRendered", "startingTimestamp", "", "getStartingTimestamp", "()J", "toString", "writeStatus", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class d
{
  @Deprecated
  public static final d.a a = new d.a(null);
  private boolean b;
  private final long c;
  @NotNull
  private String d;
  @NotNull
  private final String e;
  private int f;
  private e g;
  private boolean h;
  
  public d(@NotNull String paramString, int paramInt, @NotNull e parame, boolean paramBoolean)
  {
    this.e = paramString;
    this.f = paramInt;
    this.g = parame;
    this.h = paramBoolean;
    if ((this.g != e.b) && (this.g != e.c)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    this.b = paramBoolean;
    this.c = System.currentTimeMillis();
    this.d = "";
  }
  
  public final long a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "status");
    this.g = parame;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.e;
  }
  
  public final int c()
  {
    return this.f;
  }
  
  public final boolean d()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LuggageMiniProgramRecord(appId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append("', debugType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append("status=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isPersistent=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", preRendered=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("startingTimestamp=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.d
 * JD-Core Version:    0.7.0.1
 */