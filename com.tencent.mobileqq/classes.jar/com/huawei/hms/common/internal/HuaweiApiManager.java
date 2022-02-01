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
  private static final String HANDLER_NAME = "HuaweiApiHandler";
  private static final Object LOCK_OBJECT = new Object();
  private static final int MSG_RECEIVE_SEND_REQ = 4;
  private static final String TAG = "HuaweiApiManager";
  private static HuaweiApiManager mInstance;
  private final Map<ConnectionManagerKey<?>, HuaweiApiManager.ConnectionManager<?>> mConnectionCache = new ConcurrentHashMap(5, 0.75F, 1);
  private final Handler mHandler = new Handler(paramLooper, this);
  private final AtomicInteger mSerial = new AtomicInteger(0);
  
  private HuaweiApiManager(Context paramContext, Looper paramLooper, HuaweiApiAvailability paramHuaweiApiAvailability) {}
  
  private void connectAndSendRequest(HandlerMessageWrapper paramHandlerMessageWrapper)
  {
    HuaweiApi localHuaweiApi = paramHandlerMessageWrapper.mApi;
    HuaweiApiManager.ConnectionManager localConnectionManager2 = (HuaweiApiManager.ConnectionManager)this.mConnectionCache.get(localHuaweiApi.getConnectionManagerKey());
    HuaweiApiManager.ConnectionManager localConnectionManager1 = localConnectionManager2;
    if (localConnectionManager2 == null)
    {
      localConnectionManager1 = new HuaweiApiManager.ConnectionManager(this, localHuaweiApi);
      this.mConnectionCache.put(localHuaweiApi.getConnectionManagerKey(), localConnectionManager1);
    }
    localConnectionManager1.sendRequest((TaskApiCallWrapper)paramHandlerMessageWrapper.mContentWrapper);
  }
  
  public static HuaweiApiManager getInstance(Context paramContext)
  {
    synchronized (LOCK_OBJECT)
    {
      if (mInstance == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("HuaweiApiManager");
        localHandlerThread.start();
        mInstance = new HuaweiApiManager(paramContext.getApplicationContext(), localHandlerThread.getLooper(), HuaweiApiAvailability.getInstance());
      }
      return mInstance;
    }
  }
  
  private void innerDisconnect(HuaweiApi<?> paramHuaweiApi, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    paramHuaweiApi = (HuaweiApiManager.ConnectionManager)this.mConnectionCache.get(paramHuaweiApi.getConnectionManagerKey());
    if (paramHuaweiApi == null)
    {
      paramTaskCompletionSource.setResult(Boolean.valueOf(false));
      return;
    }
    paramTaskCompletionSource.setResult(Boolean.valueOf(paramHuaweiApi.disconnect()));
  }
  
  public void disconnectService(HuaweiApi<?> paramHuaweiApi, TaskCompletionSource<Boolean> paramTaskCompletionSource)
  {
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      innerDisconnect(paramHuaweiApi, paramTaskCompletionSource);
      return;
    }
    this.mHandler.post(new HuaweiApiManager.1(this, paramHuaweiApi, paramTaskCompletionSource));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 4)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown message id: ");
      localStringBuilder.append(paramMessage.what);
      HMSLog.w("HuaweiApiManager", localStringBuilder.toString());
      return false;
    }
    connectAndSendRequest((HandlerMessageWrapper)paramMessage.obj);
    return true;
  }
  
  public final <TOption extends Api.ApiOptions, TResult> void sendRequest(HuaweiApi<TOption> paramHuaweiApi, TaskApiCall<? extends AnyClient, TResult> paramTaskApiCall, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    paramTaskApiCall = new TaskApiCallWrapper(paramTaskApiCall, paramTaskCompletionSource);
    paramTaskCompletionSource = this.mHandler;
    paramTaskCompletionSource.sendMessage(paramTaskCompletionSource.obtainMessage(4, new HandlerMessageWrapper(paramTaskApiCall, this.mSerial.getAndIncrement(), paramHuaweiApi)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager
 * JD-Core Version:    0.7.0.1
 */