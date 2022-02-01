package com.tencent.luggage.wxa.jj;

import android.webkit.WebSettings;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.w;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class k
{
  public static final k a = new k();
  private static final AtomicReference<String> b = new AtomicReference();
  
  @JvmStatic
  @NotNull
  public static final String a()
  {
    String str = (String)b.get();
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      o.d("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
      return str;
    }
    str = k.a.a.a();
    b.set(str);
    return str;
  }
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final String a(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramString = a.d();
    }
    localObject = (String)b.getAndSet(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("warmUpMemoryCache updated value = [ ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ]");
    o.d("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", localStringBuilder.toString());
    if ((Intrinsics.areEqual(paramString, localObject) ^ true)) {
      a.b(paramString);
    }
    return paramString;
  }
  
  private final w b()
  {
    return w.a("AppBrandNetworkConfigUserAgentHelper", 2);
  }
  
  private final boolean b(String paramString)
  {
    return b().b("UserAgent", paramString);
  }
  
  private final String c()
  {
    return b().c("UserAgent");
  }
  
  private final String d()
  {
    try
    {
      str = WebSettings.getDefaultUserAgent(r.a());
      Intrinsics.checkExpressionValueIsNotNull(str, "WebSettings.getDefaultUs…tionContext.getContext())");
      return str;
    }
    catch (Throwable localThrowable)
    {
      String str;
      label15:
      break label15;
    }
    str = System.getProperty("http.agent");
    if (str != null) {
      return str;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.k
 * JD-Core Version:    0.7.0.1
 */