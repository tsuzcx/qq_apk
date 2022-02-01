package com.tencent.luggage.wxa.eu;

import com.tencent.luggage.wxa.en.d;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/page/MPPageScriptProviderXWebCodeCacheImpl$Companion;", "", "()V", "MAIN_MODULE_APP_SCRIPTS", "", "", "[Ljava/lang/String;", "TAG", "codeCacheDir", "getCodeCacheDir", "()Ljava/lang/String;", "generateAppScriptSerializeNamePrefix", "appId", "version", "", "generateSdkScriptSerializeNamePrefix", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "versionCode", "mkdirs", "path", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$a
{
  private final String a()
  {
    Object localObject = b.a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(d.a.a());
    ((StringBuilder)localObject).append("/page_scripts");
    localObject = ((StringBuilder)localObject).toString();
    k.g((String)localObject);
    return localObject;
  }
  
  @JvmStatic
  @NotNull
  public final String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LIB-v");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull n paramn)
  {
    Intrinsics.checkParameterIsNotNull(paramn, "reader");
    return ((a)this).a(paramn.c());
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-v");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eu.b.a
 * JD-Core Version:    0.7.0.1
 */