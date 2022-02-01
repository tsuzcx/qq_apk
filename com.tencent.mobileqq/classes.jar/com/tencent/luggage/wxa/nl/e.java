package com.tencent.luggage.wxa.nl;

import android.util.Pair;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.qw.bz;
import com.tencent.luggage.wxa.qw.gs;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "compareTo", "", "Lcom/tencent/mm/protocal/protobuf/RequestPackageInfo;", "other", "", "component1", "L", "R", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "K", "V", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "", "component3", "fillDevUinIfNeed", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlReqItem;", "pollResponseItemsByRequest", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;)[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "toPkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo;", "toPkgList", "", "toRequestInfo", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "verboseInfo", "luggage-standalone-mode-ext_release"}, k=2, mv={1, 1, 16})
@JvmName(name="CommonPkgFetcherUtils")
public final class e
{
  private static final int a(@NotNull gs paramgs, Object paramObject)
  {
    String str;
    if ((paramObject instanceof gs))
    {
      str = paramgs.a;
      paramObject = (gs)paramObject;
      if ((Intrinsics.areEqual(str, paramObject.a)) && (Intrinsics.areEqual(af.b(paramgs.c), af.b(paramObject.c))) && (paramgs.d == paramObject.d) && (paramgs.e == paramObject.e)) {
        return 0;
      }
    }
    int i;
    do
    {
      do
      {
        return 1;
        if (!(paramObject instanceof k.b)) {
          break;
        }
        str = paramgs.a;
        paramObject = (k.b)paramObject;
      } while ((!Intrinsics.areEqual(str, paramObject.a())) || (paramgs.d != paramObject.c()) || (paramgs.e != paramObject.d()));
      if (Intrinsics.areEqual(af.b(paramgs.c), af.b(paramObject.b()))) {
        return 0;
      }
      paramgs = (CharSequence)paramgs.c;
      if ((paramgs != null) && (paramgs.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
    } while ((i == 0) || (!Intrinsics.areEqual("__APP__", paramObject.b())));
    return 0;
    return -1;
  }
  
  @Nullable
  public static final <L, R> L a(@NotNull Pair<L, R> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "$this$component1");
    return paramPair.first;
  }
  
  public static final <K, V> K a(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "$this$component1");
    return paramEntry.getKey();
  }
  
  public static final void a(@NotNull bz parambz)
  {
    Intrinsics.checkParameterIsNotNull(parambz, "$this$fillDevUinIfNeed");
    if (d.a.b(parambz.a.e)) {}
    for (;;)
    {
      try
      {
        String str1 = g.a().a(parambz.a.a, parambz.a.e);
        if (str1 == null) {
          break label148;
        }
        parambz.g = new h(new JSONObject(str1).optLong("dev_key")).intValue();
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetDownloadUrlReqItem.fillDevUin(");
        localStringBuilder.append(parambz.a.a);
        localStringBuilder.append(", ");
        localStringBuilder.append(parambz.a.e);
        localStringBuilder.append("), throwable=");
        localStringBuilder.append(localThrowable);
        o.b("MicroMsg.AppBrand.CommonPkgFetcherUtils", localStringBuilder.toString());
      }
      return;
      label148:
      String str2 = "";
    }
  }
  
  @Nullable
  public static final <L, R> R b(@NotNull Pair<L, R> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "$this$component2");
    return paramPair.second;
  }
  
  public static final <K, V> V b(@NotNull Map.Entry<? extends K, ? extends V> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "$this$component2");
    return paramEntry.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.e
 * JD-Core Version:    0.7.0.1
 */