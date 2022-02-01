package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandUnzipLogic;", "", "()V", "APP_BRAND_CACHE_DIRECTORY_NAME", "", "APP_BRAND_UNZIP_CACHE_DIRECTORY_NAME", "PATH_PREFIX_NETWORK", "PATH_PREFIX_TEMP", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "generateUnzipPathName", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "zipPath", "getUnzipDir", "isUnzipDirValid", "", "unzipDir", "unzip", "zipInputStream", "Ljava/util/zip/ZipInputStream;", "unzipIfNeed", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f a = new f();
  private static final Lazy b = LazyKt.lazy((Function0)f.a.a);
  
  private final i a()
  {
    return (i)b.getValue();
  }
  
  private final String b(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    Object localObject = paramString;
    if (!StringsKt.startsWith(paramString, "wxfile://", true)) {
      if (StringsKt.startsWith(paramString, "http", true))
      {
        localObject = paramString;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramc.getAppId());
        ((StringBuilder)localObject).append('_');
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramc = new StringBuilder();
    paramc.append("generateUnzipPath, rawUnzipPath: ");
    paramc.append((String)localObject);
    o.e("MicroMsg.AppBrand.AppBrandUnzipLogic", paramc.toString());
    paramc = Charsets.UTF_8;
    if (localObject != null)
    {
      paramc = ((String)localObject).getBytes(paramc);
      Intrinsics.checkExpressionValueIsNotNull(paramc, "(this as java.lang.String).getBytes(charset)");
      return com.tencent.luggage.wxa.gl.c.a(paramc);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @Nullable
  public final i a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    Intrinsics.checkParameterIsNotNull(paramString, "zipPath");
    paramc = b(paramc, paramString);
    paramString = (CharSequence)paramc;
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      o.c("MicroMsg.AppBrand.AppBrandUnzipLogic", "getUnzipDir, unzipPathName is empty");
      return null;
    }
    return new i(a(), paramc);
  }
  
  @Nullable
  public final i a(@NotNull ZipInputStream paramZipInputStream, @NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(paramZipInputStream, "zipInputStream");
    Intrinsics.checkParameterIsNotNull(parami, "unzipDir");
    int i = k.a(paramZipInputStream, parami.l());
    paramZipInputStream = new StringBuilder();
    paramZipInputStream.append("unzip, unzipRet: ");
    paramZipInputStream.append(i);
    o.d("MicroMsg.AppBrand.AppBrandUnzipLogic", paramZipInputStream.toString());
    if (i != 0) {
      return null;
    }
    if (!d.a.a(parami))
    {
      o.c("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, record fail");
      return null;
    }
    return parami;
  }
  
  public final boolean a(@NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "unzipDir");
    return d.a.b(parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.f
 * JD-Core Version:    0.7.0.1
 */