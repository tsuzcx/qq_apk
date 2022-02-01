package com.tencent.luggage.wxa.fv;

import android.os.Parcelable;
import android.util.Log;
import com.tencent.luggage.wxa.de.f;
import com.tencent.luggage.wxa.hj.b;
import com.tencent.luggage.wxa.hj.c;
import com.tencent.luggage.wxa.hu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/tdi/TdiClientAccountManager;", "Lcom/tencent/luggage/login/account/tdi/TdiAccountManager;", "()V", "logout", "", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class j
  extends f
{
  @Deprecated
  public static final j.a b = new j.a(null);
  
  public void b()
  {
    super.b();
    String str = i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("logout stack=");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    o.d(str, localStringBuilder.toString());
    str = r.i();
    Intrinsics.checkExpressionValueIsNotNull(str, "MMApplicationContext.getMainProcessName()");
    b.a(str, (Parcelable)d.a, (c)j.b.a, (Function1)new j.c(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.j
 * JD-Core Version:    0.7.0.1
 */