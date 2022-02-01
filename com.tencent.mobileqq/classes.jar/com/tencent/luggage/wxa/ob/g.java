package com.tencent.luggage.wxa.ob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver;", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "TAG", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "mNetworkStateChangedReceiver", "com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1;", "onRegister", "", "onUnregister", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class g
  extends h
{
  private final String a = "Luggage.WXA.NetworkServiceBySystemReceiver";
  private final g.a b = new g.a(this);
  
  public g(@NotNull d paramd)
  {
    super(paramd);
  }
  
  private final Context e()
  {
    Context localContext = r.a();
    if (localContext == null) {
      Intrinsics.throwNpe();
    }
    return localContext;
  }
  
  public void c()
  {
    super.c();
    try
    {
      Context localContext = e();
      localObject1 = (BroadcastReceiver)this.b;
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localContext.registerReceiver((BroadcastReceiver)localObject1, (IntentFilter)localObject2);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject1 = this.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("register network receiver, t=");
      ((StringBuilder)localObject2).append(localThrowable);
      o.b((String)localObject1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void d()
  {
    super.d();
    try
    {
      e().unregisterReceiver((BroadcastReceiver)this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregister network receiver, t=");
      localStringBuilder.append(localThrowable);
      o.b(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ob.g
 * JD-Core Version:    0.7.0.1
 */