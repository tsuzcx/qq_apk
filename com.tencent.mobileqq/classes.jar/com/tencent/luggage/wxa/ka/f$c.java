package com.tencent.luggage.wxa.ka;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.oo.c;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qw.md;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class f$c
{
  @NotNull
  public static Context a(f paramf, @NotNull com.tencent.luggage.wxa.jx.h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$notNullContext");
    paramf = paramh.getContext();
    if (paramf != null) {
      return paramf;
    }
    paramf = ((Function0)new f.c.c(paramh)).invoke();
    Intrinsics.checkExpressionValueIsNotNull(paramf, "{\n            this.runtime.appContext\n        }()");
    return (Context)paramf;
  }
  
  @NotNull
  public static com.tencent.luggage.wxa.qu.b a(f paramf, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toByteString");
    paramf = paramString.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(paramf, "(this as java.lang.String).getBytes(charset)");
    return new com.tencent.luggage.wxa.qu.b(paramf);
  }
  
  @NotNull
  public static md a(f paramf, @NotNull md parammd, @NotNull com.tencent.luggage.wxa.jx.h paramh)
  {
    Intrinsics.checkParameterIsNotNull(parammd, "$this$fill");
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    com.tencent.luggage.wxa.iu.d locald = paramh.q();
    paramf = locald;
    if (!(locald instanceof com.tencent.luggage.wxa.ed.d)) {
      paramf = null;
    }
    paramf = (com.tencent.luggage.wxa.ed.d)paramf;
    int j = 0;
    if (paramf != null)
    {
      paramf = paramf.l();
      if (paramf != null)
      {
        i = paramf.c;
        break label64;
      }
    }
    int i = 0;
    label64:
    parammd.b = i;
    if ((paramh instanceof com.tencent.luggage.wxa.iu.h))
    {
      i = 1;
    }
    else
    {
      i = j;
      if ((paramh instanceof u)) {
        i = 2;
      }
    }
    parammd.c = i;
    return parammd;
  }
  
  @NotNull
  public static <R extends gu> com.tencent.luggage.wxa.ro.d<R> a(f paramf, @NotNull com.tencent.luggage.wxa.jx.h paramh, @NotNull String paramString, @NotNull a parama, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$runCgi");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(parama, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    paramf = paramh.a(com.tencent.luggage.wxa.ob.b.class);
    if (paramf == null) {
      Intrinsics.throwNpe();
    }
    paramf = ((com.tencent.luggage.wxa.ob.b)paramf).b(paramString, paramh.getAppId(), parama, paramClass);
    Intrinsics.checkExpressionValueIsNotNull(paramf, "this.customize(ICgiServi…is.appId, request, clazz)");
    return paramf;
  }
  
  public static void a(f paramf, @NotNull Context paramContext, @Nullable Bitmap paramBitmap, @Nullable String paramString1, @Nullable String paramString2, @NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "dialog");
    t.a((Runnable)new f.c.d(paramString1, paramContext, paramString2, paramBitmap, paramc));
  }
  
  public static void a(f paramf, @NotNull com.tencent.luggage.wxa.jx.h paramh, @NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$showAuthorizeDialog");
    Intrinsics.checkParameterIsNotNull(parami, "dialog");
    paramf = paramh.q();
    if (paramf != null) {
      paramf.d((Runnable)new f.c.e(paramh, parami));
    }
  }
  
  public static <_Var> void a(f paramf, @NotNull com.tencent.luggage.wxa.ro.b paramb, @NotNull com.tencent.luggage.wxa.ro.d<_Var> paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$bridge");
    Intrinsics.checkParameterIsNotNull(paramd, "pipeable");
    paramd.a((e.c)new f.c.a(paramb)).a((e.a)new f.c.b(paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.f.c
 * JD-Core Version:    0.7.0.1
 */