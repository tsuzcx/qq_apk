package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ru.a;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.g;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgResolver;", "start", "waitForDownload", "Companion", "Downloader", "ResponseAssembler", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d
  implements j
{
  @Deprecated
  public static final d.a a = new d.a(null);
  private static final aa k = new aa(0, 0L, 0L);
  private final Function1<j.e, Unit> c;
  private final n d;
  private g e;
  private final j.d f;
  private final Function2<j.a, String, Unit> g;
  private final Function1<aa, Unit> h;
  private final k i;
  private final j.c j;
  
  public d(@NotNull j.d paramd, @NotNull Function1<? super j.e, Unit> paramFunction1, @NotNull Function2<? super j.a, ? super String, Unit> paramFunction2, @NotNull Function1<? super aa, Unit> paramFunction11, @NotNull k paramk, @Nullable j.c paramc)
  {
    this.f = paramd;
    this.g = paramFunction2;
    this.h = paramFunction11;
    this.i = paramk;
    this.j = paramc;
    this.c = ((Function1)new d.d(this, paramFunction1));
    this.d = this.f.a();
  }
  
  private final void d()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((j.c)localObject).a(this.f);
    }
    k.b localb = new k.b();
    localb.a(this.f.b());
    int m = this.f.d();
    localObject = a.e;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    boolean bool = ArraysKt.contains((int[])localObject, m);
    localObject = null;
    if (!bool)
    {
      int[] arrayOfInt = a.d;
      Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (!ArraysKt.contains(arrayOfInt, m)) {
        localObject = this.f.c();
      }
    }
    localb.b((String)localObject);
    localb.a(this.f.d());
    localb.b(this.f.e());
    if (com.tencent.mm.plugin.appbrand.appcache.d.a.a(this.f.e()))
    {
      localObject = a.d;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if ((ArraysKt.contains((int[])localObject, this.f.d())) && (!localb.i()) && ((this.f.f() instanceof j.g.b))) {
        ((j.g.b)this.f.f()).a();
      }
    }
    localb.d(this.f.g() ^ true);
    localObject = this.f.f();
    if ((localObject instanceof j.g.b))
    {
      localb.c(((j.g.b)localObject).a());
    }
    else if ((localObject instanceof j.g.a))
    {
      localb.c(((j.g.a)localObject).a());
      localb.a(true);
    }
    k.a.a(this.i, localb, (Function1)new d.e(this, localb), (Function3)new d.f(this), 0, 8, null);
  }
  
  public final void a()
  {
    Object localObject1 = ac.a();
    if (localObject1 != null)
    {
      this.e = ((g)localObject1);
      if (((this.f.f() instanceof j.g.b)) && (com.tencent.mm.plugin.appbrand.appcache.d.a.a(this.f.e())))
      {
        localObject1 = this.e;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("storage");
        }
        localObject1 = ((g)localObject1).a(this.d.toString(), ((j.g.b)this.f.f()).a(), this.f.e(), new String[0]);
        if (localObject1 != null) {
          break label195;
        }
      }
      else
      {
        localObject1 = this.e;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("storage");
        }
        localObject1 = ((g)localObject1).a(this.d.toString(), this.f.e(), new String[0]);
        if (localObject1 != null) {
          break label195;
        }
      }
      localObject1 = a.d;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (ArraysKt.contains((int[])localObject1, this.f.d()))
      {
        localObject1 = new ab();
        ((ab)localObject1).b = this.d.toString();
      }
      else
      {
        localObject1 = null;
      }
      label195:
      if (localObject1 != null)
      {
        Object localObject2 = (CharSequence)((ab)localObject1).d;
        int n = 1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          m = 0;
        } else {
          m = 1;
        }
        if (m != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("record.md5 is EMPTY, will download with request ");
          ((StringBuilder)localObject2).append(this.f);
          o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
        }
        for (;;)
        {
          m = 1;
          break label548;
          localObject2 = (CharSequence)((ab)localObject1).f;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            m = 0;
          } else {
            m = 1;
          }
          if (m != 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("record.path is EMPTY, will download with request ");
            ((StringBuilder)localObject2).append(this.f);
            o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
          }
          else if (((this.f.f() instanceof j.g.a)) && (((j.g.a)this.f.f()).b()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("LATEST(forceUpdate) requested, will download with request ");
            ((StringBuilder)localObject2).append(this.f);
            o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
          }
          else
          {
            if ((!(this.f.f() instanceof j.g.a)) || (((j.g.a)this.f.f()).a() <= ((ab)localObject1).c)) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("LATEST(version:");
            ((StringBuilder)localObject2).append(((j.g.a)this.f.f()).a());
            ((StringBuilder)localObject2).append(" requested, > record.version(");
            ((StringBuilder)localObject2).append(((ab)localObject1).c);
            ((StringBuilder)localObject2).append("))");
            o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
          }
        }
        int m = 0;
        if (m != 0)
        {
          d();
          return;
        }
        localObject2 = af.c(((ab)localObject1).f);
        Object localObject3;
        j.d locald;
        String str;
        if (Intrinsics.areEqual(((ab)localObject1).d, localObject2))
        {
          localObject3 = (CharSequence)localObject2;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            m = 0;
          } else {
            m = 1;
          }
          if (m == 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("start(), pkg cached with LegacyMd5, invoke onSuccess, request=");
            ((StringBuilder)localObject2).append(this.f);
            o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
            localObject2 = this.c;
            localObject3 = d.c.a;
            locald = this.f;
            str = ((ab)localObject1).f;
            Intrinsics.checkExpressionValueIsNotNull(str, "record.field_pkgPath");
            ((Function1)localObject2).invoke(((d.c)localObject3).a(locald, str, ((ab)localObject1).d, ((ab)localObject1).c, j.f.a));
            return;
          }
        }
        if (Intrinsics.areEqual(((ab)localObject1).e, localObject2))
        {
          localObject3 = (CharSequence)localObject2;
          m = n;
          if (localObject3 != null) {
            if (((CharSequence)localObject3).length() == 0) {
              m = n;
            } else {
              m = 0;
            }
          }
          if (m == 0)
          {
            if ((this.f.g()) && (v.a(((ab)localObject1).f) > 0))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=");
              ((StringBuilder)localObject1).append(this.f);
              o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject1).toString());
              d();
              return;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("start(), pkg cached with NewMd5, invoke onSuccess, request=");
            ((StringBuilder)localObject2).append(this.f);
            o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
            localObject2 = this.c;
            localObject3 = d.c.a;
            locald = this.f;
            str = ((ab)localObject1).f;
            Intrinsics.checkExpressionValueIsNotNull(str, "record.field_pkgPath");
            localObject1 = (Unit)((Function1)localObject2).invoke(((d.c)localObject3).a(locald, str, ((ab)localObject1).e, ((ab)localObject1).c, j.f.a));
            return;
          }
        }
        if (com.tencent.luggage.wxa.rt.k.h(((ab)localObject1).f))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("start(), check existed pkg fileMd5(");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(")!=recordMd5(");
          ((StringBuilder)localObject3).append(((ab)localObject1).d);
          ((StringBuilder)localObject3).append('|');
          ((StringBuilder)localObject3).append(((ab)localObject1).e);
          ((StringBuilder)localObject3).append("), request=");
          ((StringBuilder)localObject3).append(this.f);
          o.b("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject3).toString());
        }
        localObject1 = d.c.a.a(this.f, (ab)localObject1);
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("start(), pkg cached by reuse logic, request=");
          ((StringBuilder)localObject2).append(this.f);
          o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
          this.c.invoke(localObject1);
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start(), no cached pkg, will download with request ");
        ((StringBuilder)localObject1).append(this.f);
        o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject1).toString());
        d();
        return;
      }
      label548:
      this.g.invoke(j.a.h, null);
      return;
    }
    ((d)this).g.invoke(j.a.j, "get NULL storage");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d
 * JD-Core Version:    0.7.0.1
 */