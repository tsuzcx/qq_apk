package com.tencent.luggage.wxa.fu;

import android.app.Application;
import android.content.Context;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.e;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/process/ProcessStartupFactory;", "Lcom/tencent/luggage/wxaapi/internal/process/ProcessStartup;", "()V", "TAG", "", "initialize", "", "context", "Landroid/content/Context;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g
  implements f
{
  public static final g a = new g();
  
  public void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramContext instanceof Application))
    {
      localObject1 = (Application)paramContext;
    }
    else
    {
      localObject1 = paramContext.getApplicationContext();
      if (localObject1 == null) {
        break label378;
      }
      localObject1 = (Application)localObject1;
    }
    Object localObject2 = (Context)localObject1;
    r.a((Context)localObject2);
    com.tencent.luggage.wxa.fo.c.b();
    r.a(((Application)localObject1).getResources());
    com.tencent.luggage.wxa.qz.c.a = false;
    e.a((Context)localObject2);
    boolean bool = r.h();
    int i = 1;
    e.a(bool ^ true);
    localObject2 = r.b(paramContext);
    o.d("Luggage.WXA.ProcessStartupFactory", "initialize: context.packageName = [%s], processName = [%s]", new Object[] { paramContext.getPackageName(), localObject2 });
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "processName");
    Object localObject1 = (CharSequence)localObject2;
    if (((CharSequence)localObject1).length() != 0) {
      i = 0;
    }
    if ((i == 0) && (!Intrinsics.areEqual(localObject2, paramContext.getPackageName())))
    {
      if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)":wxa_container", false, 2, null)) {
        localObject1 = (f)h.a;
      } else if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"com.tencent.ilink", false, 2, null)) {
        localObject1 = (f)c.a;
      } else {
        localObject1 = (f)b.a;
      }
    }
    else {
      localObject1 = (f)d.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initialize --START-- processName:");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", startup:");
    localStringBuilder.append(localObject1);
    o.d("Luggage.WXA.ProcessStartupFactory", localStringBuilder.toString());
    long l = af.b();
    ((f)localObject1).a(paramContext);
    l = af.c(l);
    paramContext = new StringBuilder();
    paramContext.append("initialize --END-- processName:");
    paramContext.append((String)localObject2);
    paramContext.append(", startup:");
    paramContext.append(localObject1.getClass().getSimpleName());
    paramContext.append(", cost:");
    paramContext.append(l);
    paramContext.append("ms");
    o.d("Luggage.WXA.ProcessStartupFactory", paramContext.toString());
    return;
    label378:
    throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.g
 * JD-Core Version:    0.7.0.1
 */