package com.huawei.hms.common.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiManager
  implements Handler.Callback
{
  private static final Object a = new Object();
  private static HuaweiApiManager b;
  private final Handler c = new Handler(paramLooper, this);
  private final AtomicInteger d = new AtomicInteger(0);
  private final Map<ConnectionManagerKey<?>, HuaweiApiManager.ConnectionManager<?>> e = new ConcurrentHashMap(5, 0.75F, 1);
  
  private HuaweiApiManager(Context paramContext, Looper paramLooper, HuaweiApiAvailability paramHuaweiApiAvailability) {}
  
  private void a(HuaweiApi<?> paramHuaweiApi, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    paramHuaweiApi = (HuaweiApiManager.ConnectionManager)this.e.get(paramHuaweiApi.getConnectionManagerKey());
    if (paramHuaweiApi == null)
    {
      paramTaskCompletionSource.setResult(Boolean.valueOf(false));
      return;
    }
    paramTaskCompletionSource.setResult(Boolean.valueOf(paramHuaweiApi.a()));
  }
  
  private void a(b paramb)
  {
    HuaweiApi localHuaweiApi = paramb.b;
    HuaweiApiManager.ConnectionManager localConnectionManager = (HuaweiApiManager.ConnectionManager)this.e.get(localHuaweiApi.getConnectionManagerKey());
    if (localConnectionManager == null)
    {
      localConnectionManager = new HuaweiApiManager.ConnectionManager(this, localHuaweiApi);
      this.e.put(localHuaweiApi.getConnectionManagerKey(), localConnectionManager);
    }
    for (;;)
    {
      localConnectionManager.a((TaskApiCallWrapper)paramb.a);
      return;
    }
  }
  
  public static HuaweiApiManager getInstance(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("HuaweiApiManager");
        localHandlerThread.start();
        b = new HuaweiApiManager(paramContext.getApplicationContext(), localHandlerThread.getLooper(), HuaweiApiAvailability.getInstance());
      }
      return b;
    }
  }
  
  public void disconnectService(HuaweiApi<?> paramHuaweiApi, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    if (Looper.myLooper() == this.c.getLooper())
    {
      a(paramHuaweiApi, paramTaskCompletionSource);
      return;
    }
    this.c.post(new HuaweiApiManager.1(this, paramHuaweiApi, paramTaskCompletionSource));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      HMSLog.w("HuaweiApiManager", "Unknown message id: " + paramMessage.what);
      return false;
    }
    a((b)paramMessage.obj);
    return true;
  }
  
  public final <TOption extends Api.ApiOptions, TResult> void sendRequest(HuaweiApi<TOption> paramHuaweiApi, TaskApiCall<? extends AnyClient, TResult> paramTaskApiCall, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    paramTaskApiCall = new TaskApiCallWrapper(paramTaskApiCall, paramTaskCompletionSource);
    this.c.sendMessage(this.c.obtainMessage(4, new b(paramTaskApiCall, this.d.getAndIncrement(), paramHuaweiApi)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager
 * JD-Core Version:    0.7.0.1
 */