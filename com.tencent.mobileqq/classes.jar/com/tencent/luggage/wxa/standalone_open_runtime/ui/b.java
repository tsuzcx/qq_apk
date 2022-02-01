package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import com.tencent.luggage.opensdk.a.a;
import com.tencent.luggage.opensdk.a.c;
import com.tencent.luggage.opensdk.i;
import com.tencent.luggage.wxa.fh.a;
import com.tencent.luggage.wxa.fj.e;
import com.tencent.luggage.wxa.fj.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaEnterWechatInvokeManager;", "", "()V", "callbackIdGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "invoke", "", "wxaAppID", "", "context", "Landroid/content/Context;", "api", "args", "Lkotlin/Function0;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static final AtomicInteger b = new AtomicInteger(1);
  
  static
  {
    e.a.a();
  }
  
  public final void a(@NotNull String paramString1, @Nullable Context paramContext, @NotNull String paramString2, @NotNull Function0<String> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "wxaAppID");
    Intrinsics.checkParameterIsNotNull(paramString2, "api");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "args");
    if (!com.tencent.luggage.opensdk.d.a())
    {
      a.a.a(null, 2131889046);
      return;
    }
    if (!i.a.a())
    {
      a.a.a(null, 2131889045);
      return;
    }
    paramString1 = new WxaEnterWechatInvokeManager.invoke.invokeContext.1(paramString1, paramContext);
    paramContext = i.a;
    a.c localc = new a.c();
    localc.a = ((a.a)paramString1);
    localc.b = paramString2;
    localc.c = ((String)paramFunction0.invoke());
    localc.d = b.getAndIncrement();
    localc.e = 1;
    paramContext.a(localc).a((e.c)new b.a(paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.b
 * JD-Core Version:    0.7.0.1
 */