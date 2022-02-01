package com.tencent.luggage.wxa.ft;

import android.util.LongSparseArray;
import com.tencent.luggage.wxa.cx.t.c;
import com.tencent.luggage.wxa.cx.t.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListenerEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchListenersStore;", "", "()V", "TAG", "", "mapTimestamp2Listener", "Landroid/util/LongSparseArray;", "Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchListenersStore$Request;", "invokeCallback", "", "timestampNs", "", "result", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResult;", "pollRequest", "publishColdLaunchInitReady", "", "publishExtraEvent", "reason", "eventIsSuccess", "publishMiniGameUnsupported", "publishResourcePrepareCompleted", "publishTraceEvent", "eventGroup", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;", "event", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;", "message", "publishWarmLaunchCompleted", "pushRequest", "wxaAppID", "versionType", "", "listener", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "Request", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  private static final LongSparseArray<a.a> b = new LongSparseArray();
  
  private final a.a d(long paramLong)
  {
    synchronized (b)
    {
      a.a locala = (a.a)b.get(paramLong);
      b.remove(paramLong);
      Unit localUnit = Unit.INSTANCE;
      return locala;
    }
  }
  
  private final void e(long paramLong)
  {
    synchronized (b)
    {
      Object localObject2 = (a.a)b.get(paramLong);
      if (localObject2 != null)
      {
        String str = ((a.a)localObject2).b();
        int i = ((a.a)localObject2).c();
        localObject2 = ((a.a)localObject2).d();
        ??? = localObject2;
        if (!(localObject2 instanceof LaunchWxaAppResultListenerEx)) {
          ??? = null;
        }
        ??? = (LaunchWxaAppResultListenerEx)???;
        if (??? != null) {
          ((LaunchWxaAppResultListenerEx)???).onLaunchResourcePrepareCompleted(str, i, paramLong);
        }
      }
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("publishColdLaunchInitReady timestampNs:");
    localStringBuilder.append(paramLong);
    o.d("Luggage.WxaAppLaunchListenersStore", localStringBuilder.toString());
    a(paramLong, LaunchWxaAppResult.OK);
  }
  
  public final void a(long paramLong, @NotNull t.d paramd, @NotNull t.c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "eventGroup");
    Intrinsics.checkParameterIsNotNull(paramc, "event");
    Object localObject = t.d.g;
    boolean bool = false;
    if ((paramd == localObject) && (paramc == t.c.c))
    {
      e(paramLong);
    }
    else
    {
      if (paramc == t.c.d) {
        a(paramLong, LaunchWxaAppResult.Fail);
      }
      for (;;)
      {
        bool = true;
        break;
        if (paramc != t.c.e) {
          break;
        }
        a(paramLong, LaunchWxaAppResult.Cancel);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishTraceEvent timestampNs:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", group:");
    ((StringBuilder)localObject).append(paramd);
    ((StringBuilder)localObject).append(", event:");
    ((StringBuilder)localObject).append(paramc);
    ((StringBuilder)localObject).append(", message:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", hasCallback:");
    ((StringBuilder)localObject).append(bool);
    o.d("Luggage.WxaAppLaunchListenersStore", ((StringBuilder)localObject).toString());
  }
  
  public final void a(long paramLong, @Nullable String paramString, int paramInt, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    for (;;)
    {
      synchronized (b)
      {
        a.a locala = (a.a)b.get(paramLong);
        LongSparseArray localLongSparseArray2 = b;
        if (paramLaunchWxaAppResultListener == null)
        {
          if (locala == null) {
            break label80;
          }
          paramLaunchWxaAppResultListener = locala.a();
        }
        localLongSparseArray2.put(paramLong, new a.a(paramString, paramInt, paramLaunchWxaAppResultListener));
        paramString = Unit.INSTANCE;
        return;
      }
      label80:
      paramLaunchWxaAppResultListener = null;
    }
  }
  
  public final boolean a(long paramLong, @NotNull LaunchWxaAppResult paramLaunchWxaAppResult)
  {
    Intrinsics.checkParameterIsNotNull(paramLaunchWxaAppResult, "result");
    Object localObject = d(paramLong);
    if (localObject != null)
    {
      String str = ((a.a)localObject).b();
      int i = ((a.a)localObject).c();
      localObject = ((a.a)localObject).d();
      if (localObject != null) {
        ((LaunchWxaAppResultListener)localObject).onLaunchResult(str, i, paramLong, paramLaunchWxaAppResult);
      }
      return true;
    }
    return false;
  }
  
  public final void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("publishWarmLaunchCompleted timestampNs:");
    localStringBuilder.append(paramLong);
    o.d("Luggage.WxaAppLaunchListenersStore", localStringBuilder.toString());
    e(paramLong);
    a(paramLong, LaunchWxaAppResult.OK);
  }
  
  public final void c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("publishMiniGameUnsupported timestampNs:");
    localStringBuilder.append(paramLong);
    o.d("Luggage.WxaAppLaunchListenersStore", localStringBuilder.toString());
    a(paramLong, LaunchWxaAppResult.FailMiniGameNotSupported);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ft.a
 * JD-Core Version:    0.7.0.1
 */