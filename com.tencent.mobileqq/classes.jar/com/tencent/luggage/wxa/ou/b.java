package com.tencent.luggage.wxa.ou;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.wxa.qw.gl;
import com.tencent.luggage.wxa.qw.ll;
import com.tencent.luggage.wxa.qw.lm;
import com.tencent.luggage.wxa.qw.lr;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew;", "Lcom/tencent/mm/plugin/appbrand/report/WxaCgiIDKeyBatchReportProtocol;", "()V", "BATCH_RECORD_COUNT_MAX", "", "BATCH_REPORT_INTERVAL_MS", "", "CGI_URL", "", "TAG", "batchReportBufferQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/WxaAppRecord;", "batchReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerGuard", "", "reportNow", "", "reason", "stopTimer", "startTimer", "", "appId", "runtimeEnterScene", "writeIDKeyData", "data", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements l
{
  public static final b a = new b();
  private static final String b = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
  private static final int c = 50;
  private static final long d = TimeUnit.SECONDS.toMillis(30L);
  private static final LinkedList<lr> e = new LinkedList();
  private static v f;
  private static final Object g = new Object();
  
  private final void a()
  {
    synchronized (g)
    {
      if (f != null)
      {
        localObject2 = f;
        if ((localObject2 == null) || (((v)localObject2).d() != true)) {}
      }
      else
      {
        localObject2 = new v("Luggage.AppBrandIDKeyBatchReportNew", (v.a)new b.c(), true);
        ((v)localObject2).a(d, d);
        f = (v)localObject2;
      }
      Object localObject2 = Unit.INSTANCE;
      return;
    }
  }
  
  private final void b()
  {
    synchronized (g)
    {
      Object localObject2 = f;
      if (localObject2 != null) {
        ((v)localObject2).c();
      }
      f = (v)null;
      localObject2 = Unit.INSTANCE;
      return;
    }
  }
  
  public void a(@Nullable lr paramlr)
  {
    if (paramlr != null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("writeIDKeyData type:");
      ((StringBuilder)???).append(paramlr.a);
      o.d("Luggage.AppBrandIDKeyBatchReportNew", ((StringBuilder)???).toString());
      synchronized (e)
      {
        e.addLast(paramlr);
        int i = e.size();
        if (i >= c)
        {
          a("writeIDKeyData", true);
          return;
        }
        a();
        return;
      }
    }
  }
  
  public void a(@Nullable String paramString, int paramInt) {}
  
  public final boolean a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
    if (paramBoolean) {
      b();
    }
    synchronized (e)
    {
      LinkedList localLinkedList = new LinkedList((Collection)e);
      e.clear();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("reportNow, reason=");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(", reportList.size=");
      ((StringBuilder)???).append(localLinkedList.size());
      o.d("Luggage.AppBrandIDKeyBatchReportNew", ((StringBuilder)???).toString());
      ??? = (Collection)localLinkedList;
      if (((Collection)???).isEmpty()) {
        return false;
      }
      ll localll = new ll();
      gl localgl = new gl();
      localgl.a = Build.MANUFACTURER;
      localgl.b = 2;
      localgl.c = com.tencent.luggage.wxa.qv.a.c;
      localgl.d = com.tencent.luggage.wxa.qv.a.b;
      Object localObject2 = r.d();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MMApplicationContext.getResources()");
      localgl.e = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      localObject2 = r.d();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MMApplicationContext.getResources()");
      localgl.f = ((Resources)localObject2).getDisplayMetrics().heightPixels;
      localgl.g = com.tencent.luggage.wxa.qv.a.e;
      localgl.h = com.tencent.luggage.wxa.qv.a.f;
      localObject2 = r.d();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MMApplicationContext.getResources()");
      localObject2 = ((Resources)localObject2).getConfiguration().locale;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MMApplicationContext.get…es().configuration.locale");
      localgl.i = ((Locale)localObject2).getLanguage();
      localll.b = localgl;
      localll.a.addAll((Collection)???);
      ((com.tencent.luggage.wxa.ob.b)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ob.b.class)).b(b, null, (com.tencent.luggage.wxa.qu.a)localll, lm.class).a((e.c)new b.a(paramString, localLinkedList)).a((e.a)new b.b(paramString, localLinkedList));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.b
 * JD-Core Version:    0.7.0.1
 */