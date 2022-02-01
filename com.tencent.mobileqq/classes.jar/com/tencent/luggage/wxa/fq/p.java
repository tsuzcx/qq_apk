package com.tencent.luggage.wxa.fq;

import android.os.Parcelable;
import com.tencent.luggage.wxa.ea.c;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.ea.g;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hj.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaProcessPreloaderService;", "", "()V", "TAG", "", "asyncPreload", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResult;", "preloader", "Lcom/tencent/luggage/standalone_ext/boost/IRuntimePreloader;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "(Lcom/tencent/luggage/standalone_ext/boost/IRuntimePreloader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadNextProcess", "", "iType", "", "listener", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResultListener;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class p
{
  public static final p a = new p();
  
  public final void a(int paramInt, @Nullable PreloadWxaProcessEnvResultListener paramPreloadWxaProcessEnvResultListener)
  {
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      localg = g.b;
    }
    else
    {
      localg = g.a;
    }
    com.tencent.luggage.wxa.ea.b localb = c.c.b().a(localg);
    if (localb != null)
    {
      String str = localb.c();
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preloadNextProcess(main) process:");
        localStringBuilder.append(str);
        localStringBuilder.append(" type:");
        localStringBuilder.append(localg.name());
        o.d("WxaProcessPreloaderService", localStringBuilder.toString());
        localb.a(localg);
        h.a(str, (Parcelable)new com.tencent.luggage.wxa.hu.b(localg.ordinal()), p.b.a.getClass(), (e)new p.c(str, localg, paramPreloadWxaProcessEnvResultListener));
        return;
      }
    }
    paramPreloadWxaProcessEnvResultListener = (p)this;
    o.b("WxaProcessPreloaderService", "preloadNextProcess(main) get invalid process name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.p
 * JD-Core Version:    0.7.0.1
 */