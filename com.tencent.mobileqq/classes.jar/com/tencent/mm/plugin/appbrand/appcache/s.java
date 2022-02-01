package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.storage.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibProvider;", "", "()V", "TAG", "", "checkUsableReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "checkUsableReaderByStorage", "out_record", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "reason", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class s
{
  public static final s a = new s();
  
  @NotNull
  public final n a()
  {
    if (r.h())
    {
      Object localObject1 = null;
      try
      {
        n localn = a(this, null, "checkUsableReader", 1, null);
        localObject1 = localn;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        o.a("Luggage.WxaCommLibProvider", (Throwable)localIllegalStateException, "checkUsableReader", new Object[0]);
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((n)localObject1).c() > c.a.c()) {}
      }
      else
      {
        localObject1 = c.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "AssetReader.INSTANCE");
        localObject2 = (n)localObject1;
      }
      return localObject2;
    }
    throw ((Throwable)new IllegalStateException("Should be accessed in main process".toString()));
  }
  
  @Nullable
  public final n a(@Nullable com.tencent.luggage.wxa.pc.i<ab> parami, @Nullable String paramString)
  {
    Object localObject1 = (ae)b.a(ae.class);
    if (localObject1 == null)
    {
      parami = new StringBuilder();
      parami.append("checkUsableReaderByStorage(");
      parami.append(paramString);
      parami.append(") NULL storage, return NULL");
      o.b("Luggage.WxaCommLibProvider", parami.toString());
      return null;
    }
    int j = 0;
    localObject1 = ((ae)localObject1).a("@LibraryAppId", 0, new String[] { "pkgPath", "versionMd5", "version", "downloadURL" });
    if (localObject1 == null)
    {
      parami = new StringBuilder();
      parami.append("checkUsableReaderByStorage(");
      parami.append(paramString);
      parami.append(") NULL record, return NULL");
      o.b("Luggage.WxaCommLibProvider", parami.toString());
      return null;
    }
    if (parami != null) {
      parami.a = localObject1;
    }
    parami = (CharSequence)((ab)localObject1).f;
    int i;
    if ((parami != null) && (parami.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (k.h(((ab)localObject1).f)))
    {
      parami = af.a(new com.tencent.luggage.wxa.rt.i(((ab)localObject1).f));
      Object localObject2 = (CharSequence)parami;
      if (localObject2 != null)
      {
        i = j;
        if (((CharSequence)localObject2).length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if ((i == 0) && (Intrinsics.areEqual(parami, ((ab)localObject1).d)))
      {
        paramString = ((ab)localObject1).f;
        Intrinsics.checkExpressionValueIsNotNull(paramString, "record.field_pkgPath");
        return (n)new q(paramString, ((ab)localObject1).c, parami);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkUsableReaderByStorage(");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(") fileMd5(");
      ((StringBuilder)localObject2).append(parami);
      ((StringBuilder)localObject2).append(") != recordMd5(");
      ((StringBuilder)localObject2).append(((ab)localObject1).d);
      ((StringBuilder)localObject2).append(") , return NULL");
      o.b("Luggage.WxaCommLibProvider", ((StringBuilder)localObject2).toString());
      return null;
    }
    parami = new StringBuilder();
    parami.append("checkUsableReaderByStorage(");
    parami.append(paramString);
    parami.append(") pkgPath(");
    parami.append(((ab)localObject1).f);
    parami.append(") not valid, return NULL");
    o.b("Luggage.WxaCommLibProvider", parami.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */