package com.tencent.luggage.wxa.fv;

import android.app.Application;
import com.tencent.luggage.wxa.dd.b;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/tdi/TdiAccountManagerInstaller;", "", "()V", "install", "", "application", "Landroid/app/Application;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class i
{
  public static final i a = new i();
  
  public final void a(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    if (r.h())
    {
      com.tencent.luggage.wxa.dd.i.a.a((b)new k());
      return;
    }
    com.tencent.luggage.wxa.dd.i.a.a((b)new j());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.i
 * JD-Core Version:    0.7.0.1
 */