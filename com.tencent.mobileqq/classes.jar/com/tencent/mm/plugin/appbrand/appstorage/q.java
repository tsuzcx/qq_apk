package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"KV_STORAGE_ACTION_GET", "", "KV_STORAGE_ACTION_INFO", "KV_STORAGE_ACTION_SET", "KV_STORAGE_SCHEME_DB", "KV_STORAGE_SCHEME_MMKV", "MM_KVSTAT_APPBRAND_WxaKVStoragePerformance", "TAG", "", "report", "", "scheme", "action", "dataSize", "count", "cost", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "luggage-wechat-full-sdk_release"}, k=2, mv={1, 1, 16})
@JvmName(name="KVStoragePerformanceReport")
public final class q
{
  public static final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, @NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    paramh = paramh.q();
    if (paramh != null) {
      paramh = paramh.A();
    } else {
      paramh = null;
    }
    if (paramh == null)
    {
      o.d("KVStoragePerformanceReport", "sysConfig is null");
      return;
    }
    if (!paramh.U)
    {
      o.d("KVStoragePerformanceReport", "performance report off");
      return;
    }
    paramh = new StringBuilder();
    paramh.append("report scheme=");
    paramh.append(paramInt1);
    paramh.append("  action=");
    paramh.append(paramInt2);
    paramh.append("  dataSize=");
    paramh.append(paramInt3);
    paramh.append("  count=");
    paramh.append(paramInt4);
    paramh.append("  cost=");
    paramh.append(paramLong);
    o.d("KVStoragePerformanceReport", paramh.toString());
    ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(16336, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q
 * JD-Core Version:    0.7.0.1
 */