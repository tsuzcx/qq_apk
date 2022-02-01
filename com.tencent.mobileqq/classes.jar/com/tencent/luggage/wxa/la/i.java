package com.tencent.luggage.wxa.la;

import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.b;
import com.tencent.luggage.wxa.hj.k;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUtils;", "", "()V", "killRuntimeForClientProcess", "", "appId", "", "versionType", "", "RuntimeInfo", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class i
{
  public static final i a = new i();
  
  @JvmStatic
  public static final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    String str = r.i();
    Intrinsics.checkExpressionValueIsNotNull(str, "MMApplicationContext.getMainProcessName()");
    b.a(str, (Parcelable)new i.a(paramString, paramInt), (k)i.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.i
 * JD-Core Version:    0.7.0.1
 */