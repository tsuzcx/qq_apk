package com.tencent.luggage.wxa.fj;

import com.tencent.luggage.wxa.dc.m;
import com.tencent.luggage.wxa.dc.m.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/KVReport_CALL_JSAPI_10053;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/report/AbstractReportStruct;", "hostAppId", "", "wxaAppId", "pagePath", "scene", "", "sceneNote", "appState", "appVersion", "functionName", "result", "permissionValue", "errorCode", "errMsg", "iLinkUIN", "", "sdkVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;IIILjava/lang/String;JI)V", "getAppState", "()I", "setAppState", "(I)V", "getAppVersion", "setAppVersion", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getErrorCode", "setErrorCode", "getFunctionName", "setFunctionName", "getHostAppId", "setHostAppId", "getILinkUIN", "()J", "setILinkUIN", "(J)V", "getPagePath", "setPagePath", "getPermissionValue", "setPermissionValue", "getResult", "setResult", "getScene", "setScene", "getSceneNote", "setSceneNote", "getSdkVersion", "setSdkVersion", "getWxaAppId", "setWxaAppId", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "getId", "hashCode", "toRptValue", "toString", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
  extends a
{
  @Nullable
  private String a;
  @Nullable
  private String b;
  @Nullable
  private String c;
  private int d;
  @Nullable
  private String e;
  private int f;
  private int g;
  @Nullable
  private String h;
  private int i;
  private int j;
  private int k;
  @Nullable
  private String l;
  private long m;
  private int n;
  
  public c()
  {
    this(null, null, null, 0, null, 0, 0, null, 0, 0, 0, null, 0L, 0, 16383, null);
  }
  
  public c(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt1, @Nullable String paramString4, int paramInt2, int paramInt3, @Nullable String paramString5, int paramInt4, int paramInt5, int paramInt6, @Nullable String paramString6, long paramLong, int paramInt7)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    this.e = paramString4;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramString5;
    this.i = paramInt4;
    this.j = paramInt5;
    this.k = paramInt6;
    this.l = paramString6;
    this.m = paramLong;
    this.n = paramInt7;
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.m = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  @NotNull
  public String b()
  {
    String str = StringUtils.join(new String[] { this.a, this.b, this.c, String.valueOf(this.d), this.e, String.valueOf(this.f), String.valueOf(this.g), this.h, String.valueOf(this.i), String.valueOf(this.j), String.valueOf(this.k), this.l, m.a.b(this.m), String.valueOf(this.n) }, ",");
    Intrinsics.checkExpressionValueIsNotNull(str, "StringUtils.join(arrayOf…oString()\n        ), \",\")");
    return str;
  }
  
  public final void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public int c()
  {
    return 10053;
  }
  
  public final void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public final void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.e = paramString;
  }
  
  public final void e(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void e(@Nullable String paramString)
  {
    this.h = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e)) && (this.f == paramObject.f) && (this.g == paramObject.g) && (Intrinsics.areEqual(this.h, paramObject.h)) && (this.i == paramObject.i) && (this.j == paramObject.j) && (this.k == paramObject.k) && (Intrinsics.areEqual(this.l, paramObject.l)) && (this.m == paramObject.m) && (this.n == paramObject.n)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final void f(int paramInt)
  {
    this.k = paramInt;
  }
  
  public final void f(@Nullable String paramString)
  {
    this.l = paramString;
  }
  
  public final void g(int paramInt)
  {
    this.n = paramInt;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int i6 = 0;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.b;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.c;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    int i7 = this.d;
    str = this.e;
    int i4;
    if (str != null) {
      i4 = str.hashCode();
    } else {
      i4 = 0;
    }
    int i8 = this.f;
    int i9 = this.g;
    str = this.h;
    int i5;
    if (str != null) {
      i5 = str.hashCode();
    } else {
      i5 = 0;
    }
    int i10 = this.i;
    int i11 = this.j;
    int i12 = this.k;
    str = this.l;
    if (str != null) {
      i6 = str.hashCode();
    }
    long l1 = this.m;
    return ((((((((((((i1 * 31 + i2) * 31 + i3) * 31 + i7) * 31 + i4) * 31 + i8) * 31 + i9) * 31 + i5) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i6) * 31 + (int)(l1 ^ l1 >>> 32)) * 31 + this.n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KVReport_CALL_JSAPI_10053(hostAppId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", wxaAppId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pagePath=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", scene=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", sceneNote=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", functionName=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", result=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", permissionValue=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", iLinkUIN=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", sdkVersion=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.c
 * JD-Core Version:    0.7.0.1
 */