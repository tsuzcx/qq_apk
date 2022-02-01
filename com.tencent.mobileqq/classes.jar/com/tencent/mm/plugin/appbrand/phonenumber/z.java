package com.tencent.mm.plugin.appbrand.phonenumber;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "", "jsonStr", "", "(Ljava/lang/String;)V", "isBindPhone", "", "bindSuccess", "getPhoneNumberCount", "clickConfirmCount", "clickDenyCount", "clickCancelCount", "confirmBindedPhoneCount", "confirmUnBindPhoneCount", "clickInfoCount", "clickUseOtherPhoneCount", "clickManagePhoneCount", "clickGetVerifyCodeCount", "getVerifyCodeSuccessCount", "getVerifyCodeFailedCount", "clickAddPhoneDoneCount", "addPhoneSuccessCount", "addPhoneFailedCount", "addPhoneAndSaveCount", "addPhoneNotSaveCount", "clickAddPhoneOnManagePageCount", "deletePhoneCount", "deletePhoneSuccessCount", "deletePhoneFailedCount", "verifyCodeCount", "verifyCodeSuccessCount", "verifyCodeFailedCount", "(JJJJJJJJJJJJJJJJJJJJJJJJJJ)V", "getAddPhoneAndSaveCount", "()J", "setAddPhoneAndSaveCount", "(J)V", "getAddPhoneFailedCount", "setAddPhoneFailedCount", "getAddPhoneNotSaveCount", "setAddPhoneNotSaveCount", "getAddPhoneSuccessCount", "setAddPhoneSuccessCount", "getBindSuccess", "setBindSuccess", "getClickAddPhoneDoneCount", "setClickAddPhoneDoneCount", "getClickAddPhoneOnManagePageCount", "setClickAddPhoneOnManagePageCount", "getClickCancelCount", "setClickCancelCount", "getClickConfirmCount", "setClickConfirmCount", "getClickDenyCount", "setClickDenyCount", "getClickGetVerifyCodeCount", "setClickGetVerifyCodeCount", "getClickInfoCount", "setClickInfoCount", "getClickManagePhoneCount", "setClickManagePhoneCount", "getClickUseOtherPhoneCount", "setClickUseOtherPhoneCount", "getConfirmBindedPhoneCount", "setConfirmBindedPhoneCount", "getConfirmUnBindPhoneCount", "setConfirmUnBindPhoneCount", "getDeletePhoneCount", "setDeletePhoneCount", "getDeletePhoneFailedCount", "setDeletePhoneFailedCount", "getDeletePhoneSuccessCount", "setDeletePhoneSuccessCount", "getGetPhoneNumberCount", "setGetPhoneNumberCount", "getGetVerifyCodeFailedCount", "setGetVerifyCodeFailedCount", "getGetVerifyCodeSuccessCount", "setGetVerifyCodeSuccessCount", "setBindPhone", "getVerifyCodeCount", "setVerifyCodeCount", "setVerifyCodeFailedCount", "setVerifyCodeSuccessCount", "report", "", "toString", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class z
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private long v;
  private long w;
  private long x;
  private long y;
  private long z;
  
  public z()
  {
    this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 67108863, null);
  }
  
  public z(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, long paramLong15, long paramLong16, long paramLong17, long paramLong18, long paramLong19, long paramLong20, long paramLong21, long paramLong22, long paramLong23, long paramLong24, long paramLong25, long paramLong26)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
    this.f = paramLong6;
    this.g = paramLong7;
    this.h = paramLong8;
    this.i = paramLong9;
    this.j = paramLong10;
    this.k = paramLong11;
    this.l = paramLong12;
    this.m = paramLong13;
    this.n = paramLong14;
    this.o = paramLong15;
    this.p = paramLong16;
    this.q = paramLong17;
    this.r = paramLong18;
    this.s = paramLong19;
    this.t = paramLong20;
    this.u = paramLong21;
    this.v = paramLong22;
    this.w = paramLong23;
    this.x = paramLong24;
    this.y = paramLong25;
    this.z = paramLong26;
  }
  
  public z(@NotNull String paramString)
  {
    this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 67108863, null);
    try
    {
      paramString = new JSONObject(paramString);
      l1 = paramString.optLong("isBindPhone", 0L);
    }
    catch (Exception paramString)
    {
      long l1;
      label337:
      break label337;
    }
    try
    {
      this.a = l1;
      this.b = paramString.optLong("bindSuccess", 0L);
      this.c = paramString.optLong("getPhoneNumberCount", 0L);
      this.d = paramString.optLong("clickConfirmCount", 0L);
      this.e = paramString.optLong("clickDenyCount", 0L);
      this.f = paramString.optLong("clickCancelCount", 0L);
      this.g = paramString.optLong("confirmBindedPhoneCount", 0L);
      this.h = paramString.optLong("confirmUnBindPhoneCount", 0L);
      this.i = paramString.optLong("clickInfoCount", 0L);
      this.j = paramString.optLong("clickUseOtherPhoneCount", 0L);
      this.k = paramString.optLong("clickManagePhoneCount", 0L);
      this.l = paramString.optLong("clickGetVerifyCodeCount", 0L);
      this.m = paramString.optLong("getVerifyCodeSuccessCount", 0L);
      this.n = paramString.optLong("getVerifyCodeFailedCount", 0L);
      this.o = paramString.optLong("clickAddPhoneDoneCount", 0L);
      this.p = paramString.optLong("addPhoneSuccessCount", 0L);
      this.q = paramString.optLong("addPhoneFailedCount", 0L);
      this.r = paramString.optLong("addPhoneAndSaveCount", 0L);
      this.s = paramString.optLong("addPhoneNotSaveCount", 0L);
      this.t = paramString.optLong("clickAddPhoneOnManagePageCount", 0L);
      this.u = paramString.optLong("deletePhoneCount", 0L);
      this.v = paramString.optLong("deletePhoneSuccessCount", 0L);
      this.w = paramString.optLong("deletePhoneFailedCount", 0L);
      this.x = paramString.optLong("verifyCodeCount", 0L);
      this.y = paramString.optLong("verifyCodeSuccessCount", 0L);
      this.z = paramString.optLong("verifyCodeFailedCount", 0L);
      return;
    }
    catch (Exception paramString) {}
    return;
  }
  
  public final void a()
  {
    v.a.a().a(this);
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final long b()
  {
    return this.c;
  }
  
  public final void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final long c()
  {
    return this.d;
  }
  
  public final void c(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final long d()
  {
    return this.e;
  }
  
  public final void d(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final long e()
  {
    return this.f;
  }
  
  public final void e(long paramLong)
  {
    this.e = paramLong;
  }
  
  public final long f()
  {
    return this.g;
  }
  
  public final void f(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final long g()
  {
    return this.h;
  }
  
  public final void g(long paramLong)
  {
    this.g = paramLong;
  }
  
  public final long h()
  {
    return this.i;
  }
  
  public final void h(long paramLong)
  {
    this.h = paramLong;
  }
  
  public final long i()
  {
    return this.j;
  }
  
  public final void i(long paramLong)
  {
    this.i = paramLong;
  }
  
  public final long j()
  {
    return this.k;
  }
  
  public final void j(long paramLong)
  {
    this.j = paramLong;
  }
  
  public final long k()
  {
    return this.l;
  }
  
  public final void k(long paramLong)
  {
    this.k = paramLong;
  }
  
  public final long l()
  {
    return this.m;
  }
  
  public final void l(long paramLong)
  {
    this.l = paramLong;
  }
  
  public final long m()
  {
    return this.n;
  }
  
  public final void m(long paramLong)
  {
    this.m = paramLong;
  }
  
  public final long n()
  {
    return this.o;
  }
  
  public final void n(long paramLong)
  {
    this.n = paramLong;
  }
  
  public final long o()
  {
    return this.p;
  }
  
  public final void o(long paramLong)
  {
    this.o = paramLong;
  }
  
  public final long p()
  {
    return this.q;
  }
  
  public final void p(long paramLong)
  {
    this.p = paramLong;
  }
  
  public final long q()
  {
    return this.r;
  }
  
  public final void q(long paramLong)
  {
    this.q = paramLong;
  }
  
  public final long r()
  {
    return this.s;
  }
  
  public final void r(long paramLong)
  {
    this.r = paramLong;
  }
  
  public final long s()
  {
    return this.t;
  }
  
  public final void s(long paramLong)
  {
    this.s = paramLong;
  }
  
  public final long t()
  {
    return this.u;
  }
  
  public final void t(long paramLong)
  {
    this.t = paramLong;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("isBindPhone", this.a);
    ((JSONObject)localObject).put("bindSuccess", this.b);
    ((JSONObject)localObject).put("getPhoneNumberCount", this.c);
    ((JSONObject)localObject).put("clickConfirmCount", this.d);
    ((JSONObject)localObject).put("clickDenyCount", this.e);
    ((JSONObject)localObject).put("clickCancelCount", this.f);
    ((JSONObject)localObject).put("confirmBindedPhoneCount", this.g);
    ((JSONObject)localObject).put("confirmUnBindPhoneCount", this.h);
    ((JSONObject)localObject).put("clickInfoCount", this.i);
    ((JSONObject)localObject).put("clickUseOtherPhoneCount", this.j);
    ((JSONObject)localObject).put("clickManagePhoneCount", this.k);
    ((JSONObject)localObject).put("clickGetVerifyCodeCount", this.l);
    ((JSONObject)localObject).put("getVerifyCodeSuccessCount", this.m);
    ((JSONObject)localObject).put("getVerifyCodeFailedCount", this.n);
    ((JSONObject)localObject).put("clickAddPhoneDoneCount", this.o);
    ((JSONObject)localObject).put("addPhoneSuccessCount", this.p);
    ((JSONObject)localObject).put("addPhoneFailedCount", this.q);
    ((JSONObject)localObject).put("addPhoneAndSaveCount", this.r);
    ((JSONObject)localObject).put("addPhoneNotSaveCount", this.s);
    ((JSONObject)localObject).put("clickAddPhoneOnManagePageCount", this.t);
    ((JSONObject)localObject).put("deletePhoneCount", this.u);
    ((JSONObject)localObject).put("deletePhoneSuccessCount", this.v);
    ((JSONObject)localObject).put("deletePhoneFailedCount", this.w);
    ((JSONObject)localObject).put("verifyCodeCount", this.x);
    ((JSONObject)localObject).put("verifyCodeSuccessCount", this.y);
    ((JSONObject)localObject).put("verifyCodeFailedCount", this.z);
    localObject = ((JSONObject)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "jsonObject.toString()");
    return localObject;
  }
  
  public final long u()
  {
    return this.v;
  }
  
  public final void u(long paramLong)
  {
    this.u = paramLong;
  }
  
  public final long v()
  {
    return this.w;
  }
  
  public final void v(long paramLong)
  {
    this.v = paramLong;
  }
  
  public final long w()
  {
    return this.x;
  }
  
  public final void w(long paramLong)
  {
    this.w = paramLong;
  }
  
  public final long x()
  {
    return this.y;
  }
  
  public final void x(long paramLong)
  {
    this.x = paramLong;
  }
  
  public final long y()
  {
    return this.z;
  }
  
  public final void y(long paramLong)
  {
    this.y = paramLong;
  }
  
  public final void z(long paramLong)
  {
    this.z = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.z
 * JD-Core Version:    0.7.0.1
 */