package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.ru.a;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.z;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class d$c
{
  public static final c a = new c();
  
  @Nullable
  public final j.e a(@NotNull j.d paramd, @NotNull ab paramab)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    Intrinsics.checkParameterIsNotNull(paramab, "record");
    paramd.a();
    return null;
  }
  
  @NotNull
  public final j.e a(@NotNull j.d paramd, @NotNull String paramString1, @Nullable String paramString2, int paramInt, @NotNull j.f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "request");
    Intrinsics.checkParameterIsNotNull(paramString1, "wxaPkgFilePath");
    Intrinsics.checkParameterIsNotNull(paramf, "source");
    Object localObject = a.d;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
    boolean bool = ArraysKt.contains((int[])localObject, paramd.d());
    int j = 0;
    int i = 0;
    if (bool)
    {
      localObject = new WxaPluginPkgInfo();
      ((WxaPluginPkgInfo)localObject).pkgPath = paramString1;
      ((WxaPluginPkgInfo)localObject).provider = paramd.b();
      ((WxaPluginPkgInfo)localObject).version = paramInt;
      paramd = (CharSequence)paramString2;
      if (paramd != null)
      {
        paramInt = i;
        if (paramd.length() != 0) {}
      }
      else
      {
        paramInt = 1;
      }
      if (paramInt != 0) {
        paramString2 = z.a.a(paramString1);
      }
      ((WxaPluginPkgInfo)localObject).md5 = paramString2;
      ((WxaPluginPkgInfo)localObject).stringVersion = ac.a().a(((WxaPluginPkgInfo)localObject).provider, ((WxaPluginPkgInfo)localObject).version);
      paramd = (e)localObject;
    }
    else
    {
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString1;
      ((ModulePkgInfo)localObject).name = paramd.c();
      paramd = (CharSequence)paramString2;
      if (paramd != null)
      {
        i = j;
        if (paramd.length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        paramString2 = z.a.a(paramString1);
      }
      ((ModulePkgInfo)localObject).md5 = paramString2;
      ((ModulePkgInfo)localObject).pkgVersion = paramInt;
      paramd = (e)localObject;
    }
    return new j.e(paramd, paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.c
 * JD-Core Version:    0.7.0.1
 */