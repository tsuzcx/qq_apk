package com.tencent.luggage.wxa.fj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/report/KVReport_CALL_JSAPI_13542;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/report/AbstractReportStruct;", "scene", "", "sceneNote", "", "wxaAppid", "appVersion", "appState", "pagePath", "networkType", "functionName", "keyParam", "result", "permissionValue", "errorCode", "costTime", "", "errorMsg", "errorMsgStr", "usedState", "prescene", "presceneNote", "appType", "keyResult", "keyRequest", "instanceId", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIJILjava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppState", "()I", "setAppState", "(I)V", "getAppType", "setAppType", "getAppVersion", "setAppVersion", "getCostTime", "()J", "setCostTime", "(J)V", "getErrorCode", "setErrorCode", "getErrorMsg", "setErrorMsg", "getErrorMsgStr", "()Ljava/lang/String;", "setErrorMsgStr", "(Ljava/lang/String;)V", "getFunctionName", "setFunctionName", "getInstanceId", "setInstanceId", "getKeyParam", "setKeyParam", "getKeyRequest", "setKeyRequest", "getKeyResult", "setKeyResult", "getNetworkType", "setNetworkType", "getPagePath", "setPagePath", "getPermissionValue", "setPermissionValue", "getPrescene", "setPrescene", "getPresceneNote", "setPresceneNote", "getResult", "setResult", "getScene", "setScene", "getSceneNote", "setSceneNote", "getUsedState", "setUsedState", "getWxaAppid", "setWxaAppid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "getId", "hashCode", "toRptValue", "toString", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
  extends a
{
  private int a;
  @Nullable
  private String b;
  @Nullable
  private String c;
  private int d;
  private int e;
  @Nullable
  private String f;
  @Nullable
  private String g;
  @Nullable
  private String h;
  @Nullable
  private String i;
  private int j;
  private int k;
  private int l;
  private long m;
  private int n;
  @Nullable
  private String o;
  private int p;
  private int q;
  @Nullable
  private String r;
  private int s;
  @Nullable
  private String t;
  @Nullable
  private String u;
  @Nullable
  private String v;
  
  public d()
  {
    this(0, null, null, 0, 0, null, null, null, null, 0, 0, 0, 0L, 0, null, 0, 0, null, 0, null, null, null, 4194303, null);
  }
  
  public d(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, int paramInt2, int paramInt3, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, @Nullable String paramString7, int paramInt8, int paramInt9, @Nullable String paramString8, int paramInt10, @Nullable String paramString9, @Nullable String paramString10, @Nullable String paramString11)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramString6;
    this.j = paramInt4;
    this.k = paramInt5;
    this.l = paramInt6;
    this.m = paramLong;
    this.n = paramInt7;
    this.o = paramString7;
    this.p = paramInt8;
    this.q = paramInt9;
    this.r = paramString8;
    this.s = paramInt10;
    this.t = paramString9;
    this.u = paramString10;
    this.v = paramString11;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.m = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  @NotNull
  public String b()
  {
    String str = StringUtils.join(new String[] { String.valueOf(this.a), this.b, this.c, String.valueOf(this.d), String.valueOf(this.e), this.f, this.g, this.h, this.i, String.valueOf(this.j), String.valueOf(this.k), String.valueOf(this.l), String.valueOf(this.m), String.valueOf(this.n), this.o, String.valueOf(this.p), String.valueOf(this.q), String.valueOf(this.r), String.valueOf(this.s), this.t, this.u, this.v }, ",");
    Intrinsics.checkExpressionValueIsNotNull(str, "StringUtils.join(arrayOf…nstanceId\n        ), \",\")");
    return str;
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    return 13542;
  }
  
  public final void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.f = paramString;
  }
  
  public final void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.g = paramString;
  }
  
  public final void e(int paramInt)
  {
    this.k = paramInt;
  }
  
  public final void e(@Nullable String paramString)
  {
    this.h = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h)) && (Intrinsics.areEqual(this.i, paramObject.i)) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l) && (this.m == paramObject.m) && (this.n == paramObject.n) && (Intrinsics.areEqual(this.o, paramObject.o)) && (this.p == paramObject.p) && (this.q == paramObject.q) && (Intrinsics.areEqual(this.r, paramObject.r)) && (this.s == paramObject.s) && (Intrinsics.areEqual(this.t, paramObject.t)) && (Intrinsics.areEqual(this.u, paramObject.u)) && (Intrinsics.areEqual(this.v, paramObject.v))) {}
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
    this.l = paramInt;
  }
  
  public final void f(@Nullable String paramString)
  {
    this.i = paramString;
  }
  
  public final void g(int paramInt)
  {
    this.n = paramInt;
  }
  
  public final void g(@Nullable String paramString)
  {
    this.o = paramString;
  }
  
  public final void h(int paramInt)
  {
    this.p = paramInt;
  }
  
  public final void h(@Nullable String paramString)
  {
    this.r = paramString;
  }
  
  public int hashCode()
  {
    int i12 = this.a;
    String str = this.b;
    int i11 = 0;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.c;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    int i13 = this.d;
    int i14 = this.e;
    str = this.f;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    str = this.g;
    int i4;
    if (str != null) {
      i4 = str.hashCode();
    } else {
      i4 = 0;
    }
    str = this.h;
    int i5;
    if (str != null) {
      i5 = str.hashCode();
    } else {
      i5 = 0;
    }
    str = this.i;
    int i6;
    if (str != null) {
      i6 = str.hashCode();
    } else {
      i6 = 0;
    }
    int i15 = this.j;
    int i16 = this.k;
    int i17 = this.l;
    long l1 = this.m;
    int i18 = (int)(l1 ^ l1 >>> 32);
    int i19 = this.n;
    str = this.o;
    int i7;
    if (str != null) {
      i7 = str.hashCode();
    } else {
      i7 = 0;
    }
    int i20 = this.p;
    int i21 = this.q;
    str = this.r;
    int i8;
    if (str != null) {
      i8 = str.hashCode();
    } else {
      i8 = 0;
    }
    int i22 = this.s;
    str = this.t;
    int i9;
    if (str != null) {
      i9 = str.hashCode();
    } else {
      i9 = 0;
    }
    str = this.u;
    int i10;
    if (str != null) {
      i10 = str.hashCode();
    } else {
      i10 = 0;
    }
    str = this.v;
    if (str != null) {
      i11 = str.hashCode();
    }
    return ((((((((((((((((((((i12 * 31 + i1) * 31 + i2) * 31 + i13) * 31 + i14) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i7) * 31 + i20) * 31 + i21) * 31 + i8) * 31 + i22) * 31 + i9) * 31 + i10) * 31 + i11;
  }
  
  public final void i(int paramInt)
  {
    this.q = paramInt;
  }
  
  public final void i(@Nullable String paramString)
  {
    this.t = paramString;
  }
  
  public final void j(int paramInt)
  {
    this.s = paramInt;
  }
  
  public final void j(@Nullable String paramString)
  {
    this.u = paramString;
  }
  
  public final void k(@Nullable String paramString)
  {
    this.v = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KVReport_CALL_JSAPI_13542(scene=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", sceneNote=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", wxaAppid=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", pagePath=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", networkType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", functionName=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", keyParam=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", result=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", permissionValue=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", costTime=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", errorMsg=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", errorMsgStr=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", usedState=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", prescene=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", presceneNote=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", appType=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", keyResult=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", keyRequest=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", instanceId=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.d
 * JD-Core Version:    0.7.0.1
 */