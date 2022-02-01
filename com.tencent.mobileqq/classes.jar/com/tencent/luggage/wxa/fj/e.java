package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.dc.m;
import com.tencent.luggage.wxa.dc.m.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/KVReport_CALL_TRANSFER_API_10054;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/report/AbstractReportStruct;", "hostAppId", "", "appId", "appState", "", "functionName", "errorCode", "iLinkUIN", "", "sdkVersion", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IJI)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAppState", "()I", "setAppState", "(I)V", "getErrorCode", "setErrorCode", "getFunctionName", "setFunctionName", "getHostAppId", "setHostAppId", "getILinkUIN", "()J", "setILinkUIN", "(J)V", "getSdkVersion", "setSdkVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getId", "hashCode", "toRptValue", "toString", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
  extends a
{
  public static final e.a a = new e.a(null);
  private static final AtomicBoolean i = new AtomicBoolean(false);
  @Nullable
  private String b;
  @Nullable
  private String c;
  private int d;
  @Nullable
  private String e;
  private int f;
  private long g;
  private int h;
  
  public e()
  {
    this(null, null, 0, null, 0, 0L, 0, 127, null);
  }
  
  public e(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, @Nullable String paramString3, int paramInt2, long paramLong, int paramInt3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt1;
    this.e = paramString3;
    this.f = paramInt2;
    this.g = paramLong;
    this.h = paramInt3;
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  @ExperimentalUnsignedTypes
  @NotNull
  public String b()
  {
    String str = StringUtils.join(new String[] { this.b, this.c, String.valueOf(this.d), this.e, String.valueOf(this.f), m.a.b(this.g), String.valueOf(this.h) }, ",");
    Intrinsics.checkExpressionValueIsNotNull(str, "StringUtils.join(arrayOf…oString()\n        ), \",\")");
    return str;
  }
  
  public final void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    return 10054;
  }
  
  public final void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.e = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e)) && (this.f == paramObject.f) && (this.g == paramObject.g) && (this.h == paramObject.h)) {}
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
    String str = this.b;
    int m = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.c;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    int n = this.d;
    str = this.e;
    if (str != null) {
      m = str.hashCode();
    }
    int i1 = this.f;
    long l = this.g;
    return (((((j * 31 + k) * 31 + n) * 31 + m) * 31 + i1) * 31 + (int)(l ^ l >>> 32)) * 31 + this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KVReport_CALL_TRANSFER_API_10054(hostAppId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", functionName=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", iLinkUIN=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", sdkVersion=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.e
 * JD-Core Version:    0.7.0.1
 */