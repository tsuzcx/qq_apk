package com.tencent.luggage.wxa.fq;

import android.os.Parcelable;
import com.tencent.ilink.tdi.b.z;
import com.tencent.ilinkservice.ad;
import com.tencent.ilinkservice.ag.c;
import com.tencent.ilinkservice.ag.e;
import com.tencent.ilinkservice.ag.e.a;
import com.tencent.ilinkservice.aq;
import com.tencent.ilinkservice.w;
import com.tencent.ilinkservice.y;
import com.tencent.luggage.wxa.da.f;
import com.tencent.luggage.wxa.da.f.a;
import com.tencent.luggage.wxa.fv.a;
import com.tencent.luggage.wxa.hj.h;
import com.tencent.luggage.wxa.hu.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.n;
import com.tencent.mars.ilink.comm.NetStatusUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/XLogUploadLogic;", "", "()V", "CODE_ERR_NETWORK_TYPE", "", "getCODE_ERR_NETWORK_TYPE", "()I", "CODE_OK", "getCODE_OK", "TAG", "", "mDevice", "Lcom/tencent/ilinkservice/IlinkDeviceInterface;", "kotlin.jvm.PlatformType", "mIlinkDeviceCallback", "com/tencent/luggage/wxaapi/internal/XLogUploadLogic$mIlinkDeviceCallback$2$1", "getMIlinkDeviceCallback", "()Lcom/tencent/luggage/wxaapi/internal/XLogUploadLogic$mIlinkDeviceCallback$2$1;", "mIlinkDeviceCallback$delegate", "Lkotlin/Lazy;", "onUploadLogComplete", "Lkotlin/Function1;", "", "getOnUploadLogComplete", "()Lkotlin/jvm/functions/Function1;", "setOnUploadLogComplete", "(Lkotlin/jvm/functions/Function1;)V", "getFormatDateList", "", "startTime", "endTime", "getLogFileList", "uploadXLogFile", "ilinkPullLogCmd", "Lcom/tencent/ilinkservice/IlinkServiceProto$IlinkPullLogCmd;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class t
{
  public static final t a = new t();
  private static y b = ad.a().c();
  private static final Lazy c = LazyKt.lazy((Function0)t.b.a);
  private static final int d = 0;
  private static final int e = -101;
  @Nullable
  private static Function1<? super Integer, Unit> f;
  
  private final List<String> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    i[] arrayOfi = new i(s.b).a((n)new t.a(".xlog", b(paramInt1, paramInt2)));
    paramInt2 = arrayOfi.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      i locali = arrayOfi[paramInt1];
      if ((locali != null) && (locali.j())) {
        localArrayList.add(locali.l());
      }
      paramInt1 += 1;
    }
    return (List)localArrayList;
  }
  
  private final List<String> b(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = paramInt1;
    long l2 = 1000;
    l1 *= l2;
    long l3 = paramInt2;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    while (l1 < l3 * l2 + 86400000L)
    {
      localArrayList.add(localSimpleDateFormat.format(Long.valueOf(l1)));
      l1 += 86400000L;
    }
    return (List)localArrayList;
  }
  
  private final t.b.1 d()
  {
    return (t.b.1)c.getValue();
  }
  
  public final int a()
  {
    return d;
  }
  
  public final void a(@Nullable ag.c paramc)
  {
    o.d("XLogUploadLogic", "pre uploadXLogFile");
    if (paramc != null)
    {
      int i = NetStatusUtil.getNetWorkType(r.a());
      if ((paramc.i() == 0) && (i != -1) && (i != 1) && (i != 9))
      {
        paramc = new StringBuilder();
        paramc.append("OnLocalRequestUploadLogfiles nettype not match:");
        paramc.append(i);
        o.e("XLogUploadLogic", paramc.toString());
        paramc = f;
        if (paramc != null) {
          paramc = (Unit)paramc.invoke(Integer.valueOf(e));
        }
        return;
      }
      Object localObject = f.a.a().a();
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        h.a(localObject[i], (Parcelable)d.a, t.c.a.getClass());
        i += 1;
      }
      localObject = ag.e.w();
      ((ag.e.a)localObject).a(paramc.g());
      ((ag.e.a)localObject).a((Iterable)a.a(paramc.c(), paramc.e()));
      ((ag.e.a)localObject).a(paramc.m());
      ((ag.e.a)localObject).b(paramc.o());
      ((ag.e.a)localObject).c(paramc.q());
      try
      {
        paramc = a.c.f();
      }
      catch (Exception paramc)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uploadXLogFile, get tdiSession, exception=");
        localStringBuilder.append(paramc);
        o.b("XLogUploadLogic", localStringBuilder.toString());
        paramc = null;
      }
      if (paramc != null)
      {
        paramc = paramc.b();
        if (paramc != null)
        {
          ((ag.e.a)localObject).a(paramc.g());
          ((ag.e.a)localObject).d(paramc.i());
        }
      }
      paramc = b;
      if (paramc != null) {
        paramc.a((w)d());
      }
      paramc = b;
      if (paramc != null) {
        paramc.a(((ag.e.a)localObject).c());
      }
    }
  }
  
  public final void a(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    f = paramFunction1;
  }
  
  public final int b()
  {
    return e;
  }
  
  @Nullable
  public final Function1<Integer, Unit> c()
  {
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.t
 * JD-Core Version:    0.7.0.1
 */