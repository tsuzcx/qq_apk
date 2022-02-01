package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.d;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class b$a
{
  @JvmStatic
  @NotNull
  public final c a(@Nullable d paramd)
  {
    if (paramd != null) {
      synchronized (b.b())
      {
        b.c();
        b localb = (b)b.b().get(paramd.aa());
        if (localb != null) {
          paramd = (c)localb;
        } else {
          paramd = (c)((Function0)new b.a.a(paramd)).invoke();
        }
        return paramd;
      }
    }
    return b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.b.a
 * JD-Core Version:    0.7.0.1
 */