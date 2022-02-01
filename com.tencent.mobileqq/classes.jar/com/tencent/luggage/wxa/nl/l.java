package com.tencent.luggage.wxa.nl;

import android.util.ArrayMap;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class l
{
  public static final l a = new l();
  private static final int b = 1004;
  
  private final <K, V> Map<K, V> a(K paramK, V paramV)
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put(paramK, paramV);
    return (Map)localArrayMap;
  }
  
  private final boolean a(@NotNull n paramn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return true;
    }
    paramn = paramn.b("injectAppSeparatedPlugin");
    return (paramn != null) && (Boolean.parseBoolean(paramn) == true);
  }
  
  public final boolean a(@NotNull String paramString, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable n paramn)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    boolean bool1 = d.a.b(paramInt1);
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
      if (paramn == null) {
        break label76;
      }
      bool1 = bool2;
      if (a(paramn, paramBoolean) != true) {
        break label76;
      }
    }
    else
    {
      bool1 = bool2;
      if (paramn == null) {
        break label76;
      }
      bool1 = bool2;
      if (a(paramn, paramBoolean) != true) {
        break label76;
      }
    }
    bool1 = true;
    label76:
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.l
 * JD-Core Version:    0.7.0.1
 */