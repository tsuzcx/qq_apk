package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.wxa.iu.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class aj$a
{
  private final String a(@NotNull WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    Object localObject = (CharSequence)paramWxaPluginPkgInfo.prefixPath;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramWxaPluginPkgInfo = paramWxaPluginPkgInfo.prefixPath;
      Intrinsics.checkExpressionValueIsNotNull(paramWxaPluginPkgInfo, "this.prefixPath");
      return paramWxaPluginPkgInfo;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("__extended__/");
    ((StringBuilder)localObject).append(paramWxaPluginPkgInfo.provider);
    return ((StringBuilder)localObject).toString();
  }
  
  @JvmStatic
  @Nullable
  public final aj a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "$this$getMergeDirReader");
    Object localObject = ad.b(paramd);
    paramd = (d)localObject;
    if (!(localObject instanceof ad)) {
      paramd = null;
    }
    paramd = (ad)paramd;
    if (paramd != null) {
      paramd = paramd.d();
    } else {
      paramd = null;
    }
    localObject = paramd;
    if (!(paramd instanceof aj)) {
      localObject = null;
    }
    return (aj)localObject;
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull String paramString, @NotNull WxaPluginPkgInfo paramWxaPluginPkgInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostModule");
    Intrinsics.checkParameterIsNotNull(paramWxaPluginPkgInfo, "plugin");
    if (Intrinsics.areEqual(paramString, "__APP__")) {
      return ((a)this).a(paramWxaPluginPkgInfo);
    }
    if (StringsKt.endsWith$default((CharSequence)paramString, '/', false, 2, null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(((a)this).a(paramWxaPluginPkgInfo));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('/');
    localStringBuilder.append(((a)this).a(paramWxaPluginPkgInfo));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.a
 * JD-Core Version:    0.7.0.1
 */