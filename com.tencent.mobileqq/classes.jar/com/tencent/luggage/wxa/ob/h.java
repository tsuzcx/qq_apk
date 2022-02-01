package com.tencent.luggage.wxa.ob;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.hw.b;
import com.tencent.luggage.wxa.iu.d;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public class h
  implements b, e
{
  @NotNull
  private final d a;
  @TargetApi(21)
  private final ConcurrentLinkedDeque<f> b;
  
  public h(@NotNull d paramd)
  {
    this.a = paramd;
    this.b = new ConcurrentLinkedDeque();
  }
  
  @NotNull
  protected final d a()
  {
    return this.a;
  }
  
  public void a(@Nullable f paramf)
  {
    if (paramf != null) {
      this.b.add(paramf);
    }
  }
  
  public final void b()
  {
    Object localObject = this.a.ae();
    if ((localObject != null) && (((com.tencent.luggage.wxa.iu.h)localObject).d() == true))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).c();
      }
    }
  }
  
  public void c()
  {
    a((f)new h.a(this));
  }
  
  public void d()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ob.h
 * JD-Core Version:    0.7.0.1
 */