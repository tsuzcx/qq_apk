package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.jj.s.g;
import com.tencent.luggage.wxa.jj.s.h;
import com.tencent.luggage.wxa.jj.v;
import com.tencent.luggage.wxa.nl.l;
import com.tencent.luggage.wxa.nn.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rr.c;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/SubProcessGetCodePkgNew;", "Lcom/tencent/mm/vending/functional/Functional;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/luggage/standalone_ext/Runtime;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "()V", "call", "var", "showDevPkgNoRecordPrompt", "", "versionType", "", "fillReadyPkgList", "", "pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class i
  implements com.tencent.luggage.wxa.rl.b<com.tencent.mm.plugin.appbrand.appcache.af, c<com.tencent.luggage.wxa.em.d, s>>
{
  @Deprecated
  public static final i.a a = new i.a(null);
  
  private final String a(int paramInt)
  {
    String str;
    if (paramInt != 1) {
      str = com.tencent.luggage.wxa.pd.d.a(2131886879, new Object[] { com.tencent.mm.plugin.appbrand.appcache.b.a(paramInt) });
    } else {
      str = com.tencent.luggage.wxa.pd.d.a(2131886831, new Object[0]);
    }
    t.a((Runnable)new i.c(str));
    Intrinsics.checkExpressionValueIsNotNull(str, "promptText");
    return str;
  }
  
  private final void a(@NotNull com.tencent.mm.plugin.appbrand.appcache.af paramaf, List<? extends com.tencent.mm.plugin.appbrand.appcache.e> paramList)
  {
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.appbrand.appcache.e)localIterator1.next();
      if ((localObject instanceof ModulePkgInfo))
      {
        Iterator localIterator2 = ((Iterable)paramaf).iterator();
        while (localIterator2.hasNext())
        {
          paramList = localIterator2.next();
          if (Intrinsics.areEqual(((ModulePkgInfo)paramList).name, ((ModulePkgInfo)localObject).name)) {
            break label93;
          }
        }
        paramList = null;
        label93:
        if (paramList == null) {
          Intrinsics.throwNpe();
        }
        paramList = (ModulePkgInfo)paramList;
        localObject = (ModulePkgInfo)localObject;
        paramList.pkgPath = ((ModulePkgInfo)localObject).pkgPath;
        paramList.md5 = ((ModulePkgInfo)localObject).md5;
      }
      else if ((localObject instanceof WxaPluginPkgInfo))
      {
        paramList = paramaf.f;
        if (paramList == null) {
          Intrinsics.throwNpe();
        }
        paramList.a((WxaPluginPkgInfo)localObject);
      }
    }
  }
  
  @Nullable
  public com.tencent.mm.plugin.appbrand.appcache.af a(@NotNull c<com.tencent.luggage.wxa.em.d, s> paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "var");
    Object localObject1 = (com.tencent.luggage.wxa.em.d)paramc.b();
    paramc = (s)paramc.c();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtime");
    int j = ((com.tencent.luggage.wxa.em.d)localObject1).ab();
    Object localObject2 = new Ref.ObjectRef();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "wxaAttributes");
    paramc = paramc.e();
    Intrinsics.checkExpressionValueIsNotNull(paramc, "wxaAttributes.versionInfo");
    ((Ref.ObjectRef)localObject2).element = paramc;
    String str = ((com.tencent.luggage.wxa.em.d)localObject1).aa();
    boolean bool1 = ((com.tencent.luggage.wxa.em.d)localObject1).t();
    n localn = ((com.tencent.luggage.wxa.em.d)localObject1).K();
    if (localn != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localn, "runtime.libReaderNullabl…    return null\n        }");
      Object localObject3 = ((com.tencent.luggage.wxa.em.d)localObject1).as();
      boolean bool2 = ((com.tencent.luggage.wxa.em.d)localObject1).u();
      long l = com.tencent.luggage.wxa.qz.af.d();
      if (d.a.b(j))
      {
        paramc = com.tencent.luggage.wxa.nl.g.a().a(str, j);
        if (paramc != null)
        {
          paramc = v.a(paramc);
          if (paramc != null)
          {
            ((Ref.ObjectRef)localObject2).element = paramc;
            break label244;
          }
        }
        paramc = ((i)this).a(j);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("call() parse extInfoJson failed with appId[");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("] versionType[");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(']');
        o.b("Luggage.SubProcessGetCodePkgNew", ((StringBuilder)localObject1).toString());
        com.tencent.luggage.wxa.ro.h.b().a(new Error(paramc));
        return null;
      }
      label244:
      if (d.a.a(j)) {
        ac.a().a(str, (s.f)((Ref.ObjectRef)localObject2).element, j);
      }
      com.tencent.mm.plugin.appbrand.appcache.af localaf = new com.tencent.mm.plugin.appbrand.appcache.af();
      localaf.pkgVersion = ((s.f)((Ref.ObjectRef)localObject2).element).a;
      localaf.b = j;
      localaf.md5 = ((s.f)((Ref.ObjectRef)localObject2).element).c;
      localaf.f = new ai();
      paramc = l.a;
      localObject1 = (s.f)((Ref.ObjectRef)localObject2).element;
      Intrinsics.checkExpressionValueIsNotNull(str, "appId");
      Map localMap = paramc.a((s.f)localObject1, str, l.a.a(str, j, ((s.f)((Ref.ObjectRef)localObject2).element).a, bool1, localn));
      paramc = localMap.entrySet().iterator();
      label547:
      int i;
      while (paramc.hasNext())
      {
        localObject1 = (Map.Entry)paramc.next();
        localObject4 = (String)((Map.Entry)localObject1).getKey();
        s.h localh = (s.h)((Map.Entry)localObject1).getValue();
        if ((Intrinsics.areEqual("__APP__", localObject4) ^ true))
        {
          LinkedList localLinkedList = localaf.e;
          ModulePkgInfo localModulePkgInfo = new ModulePkgInfo();
          localObject1 = ((s.f)((Ref.ObjectRef)localObject2).element).h;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "versionInfo.moduleList");
          Iterator localIterator = ((Iterable)localObject1).iterator();
          while (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (Intrinsics.areEqual(localObject4, ((s.g)localObject1).a)) {
              break label547;
            }
          }
          localObject1 = null;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = (s.g)localObject1;
          localModulePkgInfo.name = ((String)localObject4);
          localModulePkgInfo.md5 = localh.b;
          localModulePkgInfo.independent = ((s.g)localObject1).c;
          localModulePkgInfo.aliases = ((s.g)localObject1).e;
          localModulePkgInfo.pkgVersion = ((s.f)((Ref.ObjectRef)localObject2).element).a;
          localObject1 = Unit.INSTANCE;
          localLinkedList.add(localModulePkgInfo);
        }
        localObject1 = (Collection)localh.c;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          localObject1 = localaf.f;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((ai)localObject1).a((String)localObject4, com.tencent.luggage.wxa.nl.e.a(localh.c));
        }
      }
      paramc = localaf.f;
      if (paramc != null)
      {
        paramc.c();
        paramc = Unit.INSTANCE;
      }
      if ((((s.f)((Ref.ObjectRef)localObject2).element).i) && (!com.tencent.luggage.wxa.qz.af.a(((s.f)((Ref.ObjectRef)localObject2).element).h)))
      {
        localObject1 = new LinkedList();
        paramc = m.b(a.a((String)localObject3));
        localObject3 = (CharSequence)paramc;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          paramc = (CharSequence)((s.f)((Ref.ObjectRef)localObject2).element).j;
          if ((paramc != null) && (paramc.length() != 0)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0) {}
          do
          {
            while (!((Iterator)localObject3).hasNext())
            {
              paramc = null;
              break;
              localObject3 = ((s.f)((Ref.ObjectRef)localObject2).element).h.iterator();
            }
            paramc = (s.g)((Iterator)localObject3).next();
          } while (!Intrinsics.areEqual(((s.f)((Ref.ObjectRef)localObject2).element).j, paramc.a));
        }
        else
        {
          localObject3 = ((s.f)((Ref.ObjectRef)localObject2).element).h;
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "versionInfo.moduleList");
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("LaunchCheckPkgHandlerSeparatedPluginsCompatible  appId:");
          ((StringBuilder)localObject4).append(str);
          ((StringBuilder)localObject4).append(" versionType:");
          ((StringBuilder)localObject4).append(j);
          paramc = (s.g)com.tencent.luggage.wxa.ny.h.a((List)localObject3, paramc, ((StringBuilder)localObject4).toString(), false, 4, null);
        }
        if (paramc != null) {
          ((LinkedList)localObject1).add(paramc.a);
        }
        if ((paramc == null) || ((!paramc.c) && ((Intrinsics.areEqual("__APP__", paramc.a) ^ true)))) {
          ((LinkedList)localObject1).add("__APP__");
        }
        paramc = Unit.INSTANCE;
        paramc = (List)localObject1;
      }
      else
      {
        paramc = (List)CollectionsKt.arrayListOf(new String[] { "__APP__" });
      }
      localObject3 = com.tencent.luggage.wxa.ro.h.b();
      ((com.tencent.luggage.wxa.ro.b)localObject3).a();
      localObject1 = Unit.INSTANCE;
      Object localObject4 = new AtomicBoolean(false);
      localObject1 = f.a;
      paramc = (Runnable)new i.b(this, str, (Ref.ObjectRef)localObject2, j, paramc, localMap, localaf, (AtomicBoolean)localObject4, l, (com.tencent.luggage.wxa.ro.b)localObject3, bool2, localn, bool1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Luggage.SubProcessGetCodePkgNew[");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append('|');
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(']');
      ((com.tencent.luggage.wxa.rz.g)localObject1).c(paramc, ((StringBuilder)localObject2).toString());
      return null;
    }
    paramc = (i)this;
    com.tencent.luggage.wxa.ro.h.b().a("LibReader is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.i
 * JD-Core Version:    0.7.0.1
 */