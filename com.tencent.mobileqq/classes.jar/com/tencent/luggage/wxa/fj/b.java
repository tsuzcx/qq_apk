package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.dc.m;
import com.tencent.luggage.wxa.dc.m.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/KVReport_CALL_API_10055;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/report/AbstractReportStruct;", "hostAppId", "", "wxaAppId", "appState", "", "apiName", "isSuccess", "pkgName", "iLinkUIN", "", "sdkVersion", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JI)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getAppState", "()I", "setAppState", "(I)V", "getHostAppId", "setHostAppId", "getILinkUIN", "()J", "setILinkUIN", "(J)V", "setSuccess", "getPkgName", "setPkgName", "getSdkVersion", "setSdkVersion", "getWxaAppId", "setWxaAppId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getId", "hashCode", "toRptValue", "toString", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  extends a
{
  @Nullable
  private String a;
  @Nullable
  private String b;
  private int c;
  @Nullable
  private String d;
  private int e;
  @Nullable
  private String f;
  private long g;
  private int h;
  
  public b()
  {
    this(null, null, 0, null, 0, null, 0L, 0, 255, null);
  }
  
  public b(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, @Nullable String paramString3, int paramInt2, @Nullable String paramString4, long paramLong, int paramInt3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramString3;
    this.e = paramInt2;
    this.f = paramString4;
    this.g = paramLong;
    this.h = paramInt3;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  @NotNull
  public String b()
  {
    String str = StringUtils.join(new String[] { this.a, this.b, String.valueOf(this.c), this.d, String.valueOf(this.e), this.f, m.a.b(this.g), String.valueOf(this.h) }, ",");
    Intrinsics.checkExpressionValueIsNotNull(str, "StringUtils.join(arrayOf…oString()\n        ), \",\")");
    return str;
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public int c()
  {
    return 10055;
  }
  
  public final void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.d = paramString;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.f = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f)) && (this.g == paramObject.g) && (this.h == paramObject.h)) {}
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
    String str = this.a;
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    int n = this.c;
    str = this.d;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    int i1 = this.e;
    str = this.f;
    if (str != null) {
      m = str.hashCode();
    }
    long l = this.g;
    return ((((((i * 31 + j) * 31 + n) * 31 + k) * 31 + i1) * 31 + m) * 31 + (int)(l ^ l >>> 32)) * 31 + this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KVReport_CALL_API_10055(hostAppId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", wxaAppId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", apiName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isSuccess=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", pkgName=");
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
 * Qualified Name:     com.tencent.luggage.wxa.fj.b
 * JD-Core Version:    0.7.0.1
 */