package com.tencent.luggage.wxa.nl;

import android.util.Log;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$e
  extends Lambda
  implements Function2<j.a, String, Unit>
{
  b$e(j.d paramd, AtomicBoolean paramAtomicBoolean, Function2 paramFunction2, b.a parama)
  {
    super(2);
  }
  
  public final void a(@NotNull j.a parama, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(parama, "err");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("waitForPkg ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" onError(");
    localStringBuilder.append(parama);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    localStringBuilder.append("), stack=");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    o.b("MicroMsg.AppBrand.BatchGetCodePkgExecutor", localStringBuilder.toString());
    if (!this.b.getAndSet(true))
    {
      this.c.invoke(Integer.valueOf(parama.a()), paramString);
      this.b.set(true);
    }
    parama = this.d;
    if (parama != null)
    {
      paramString = this.a;
      Intrinsics.checkExpressionValueIsNotNull(paramString, "request");
      parama.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.e
 * JD-Core Version:    0.7.0.1
 */