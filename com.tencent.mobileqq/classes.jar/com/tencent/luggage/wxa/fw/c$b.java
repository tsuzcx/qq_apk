package com.tencent.luggage.wxa.fw;

import android.content.Context;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.n;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$b
  implements Runnable
{
  c$b(n paramn, int paramInt1, int paramInt2, b paramb, String paramString) {}
  
  public final void run()
  {
    Object localObject = ac.a().a(this.a.toString(), this.b, this.c, new String[] { "versionMd5", "NewMd5" });
    if (localObject == null)
    {
      localObject = this.d;
      if (localObject != null) {
        ((b)localObject).a((Throwable)new Error(r.a().getString(2131886879)));
      }
    }
    else
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)new c.b.a((CoroutineContext.Key)CoroutineExceptionHandler.Key, this);
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)localCoroutineExceptionHandler, null, (Function2)new c.b.1(this, (ab)localObject, null), 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.c.b
 * JD-Core Version:    0.7.0.1
 */