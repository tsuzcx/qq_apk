package com.huawei.hms.support.api;

import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity>
  extends InnerPendingResult<R>
{
  private CountDownLatch a;
  private R b = null;
  private WeakReference<ApiClient> c;
  private String d = null;
  private String e = null;
  private boolean f = true;
  protected DatagramTransport transport = null;
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    a(paramApiClient, paramString, paramIMessageEntity, getResponseType(), 0);
  }
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, int paramInt)
  {
    a(paramApiClient, paramString, paramIMessageEntity, getResponseType(), paramInt);
  }
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass)
  {
    a(paramApiClient, paramString, paramIMessageEntity, paramClass, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
    ApiClient localApiClient = (ApiClient)this.c.get();
    if ((localApiClient == null) || (this.d == null) || (HiAnalyticsUtil.getInstance().hasError(localApiClient.getContext()))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("package", localApiClient.getPackageName());
    localHashMap.put("baseVersion", "5.0.0.301");
    Object localObject;
    if (paramInt2 == 1)
    {
      localHashMap.put("direction", "req");
      localHashMap.put("version", "0");
      String str = Util.getAppId(localApiClient.getContext());
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        SubAppInfo localSubAppInfo = localApiClient.getSubAppInfo();
        localObject = str;
        if (localSubAppInfo != null) {
          localObject = localSubAppInfo.getSubAppID();
        }
      }
      localHashMap.put("appid", localObject);
      if (!TextUtils.isEmpty(this.e)) {
        break label353;
      }
      this.e = TransactionIdCreater.getId((String)localObject, this.d);
      localHashMap.put("transId", this.e);
    }
    for (;;)
    {
      localObject = this.d.split("\\.");
      if (localObject.length >= 2)
      {
        localHashMap.put("service", localObject[0]);
        localHashMap.put("apiName", localObject[1]);
      }
      localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
      HiAnalyticsUtil.getInstance().onEvent(localApiClient.getContext(), "HMS_SDK_BASE_CALL_AIDL", localHashMap);
      return;
      localHashMap.put("direction", "rsp");
      localHashMap.put("result", String.valueOf(paramInt1));
      if ((this.b == null) || (this.b.getStatus() == null)) {
        break;
      }
      localHashMap.put("statusCode", String.valueOf(this.b.getStatus().getStatusCode()));
      break;
      label353:
      localHashMap.put("transId", this.e);
      this.e = null;
    }
  }
  
  private void a(int paramInt, IMessageEntity paramIMessageEntity)
  {
    HMSLog.i("PendingResultImpl", "setResult:" + paramInt);
    Object localObject = null;
    if ((paramIMessageEntity instanceof AbstractMessageEntity)) {
      localObject = ((AbstractMessageEntity)paramIMessageEntity).getCommonStatus();
    }
    String str;
    if (paramInt == 0)
    {
      this.b = onComplete(paramIMessageEntity);
      if (this.f) {
        a(paramInt, 2);
      }
      if (this.b != null)
      {
        paramIMessageEntity = this.b.getStatus();
        if ((paramIMessageEntity != null) && (localObject != null))
        {
          paramInt = paramIMessageEntity.getStatusCode();
          str = paramIMessageEntity.getStatusMessage();
          int i = ((Status)localObject).getStatusCode();
          localObject = ((Status)localObject).getStatusMessage();
          if (paramInt == i) {
            break label213;
          }
          HMSLog.e("PendingResultImpl", "rstStatus code (" + paramInt + ") is not equal commonStatus code (" + i + ")");
          HMSLog.e("PendingResultImpl", "rstStatus msg (" + str + ") is not equal commonStatus msg (" + (String)localObject + ")");
        }
      }
    }
    label213:
    while ((!TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      return;
      this.b = onError(paramInt);
      break;
    }
    HMSLog.i("PendingResultImpl", "rstStatus msg (" + str + ") is not equal commonStatus msg (" + (String)localObject + ")");
    this.b.setStatus(new Status(paramInt, (String)localObject, paramIMessageEntity.getResolution()));
  }
  
  private void a(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass, int paramInt)
  {
    HMSLog.i("PendingResultImpl", "init uri:" + paramString);
    this.d = paramString;
    if (paramApiClient == null)
    {
      HMSLog.e("PendingResultImpl", "client is null");
      return;
    }
    this.c = new WeakReference(paramApiClient);
    this.a = new CountDownLatch(1);
    try
    {
      this.transport = ((DatagramTransport)Class.forName(paramApiClient.getTransportName()).getConstructor(new Class[] { String.class, IMessageEntity.class, Class.class, Integer.TYPE }).newInstance(new Object[] { paramString, paramIMessageEntity, paramClass, Integer.valueOf(paramInt) }));
      return;
    }
    catch (InstantiationException paramApiClient)
    {
      HMSLog.e("PendingResultImpl", "gen transport error:" + paramApiClient.getMessage());
      throw new IllegalStateException("Instancing transport exception, " + paramApiClient.getMessage(), paramApiClient);
    }
    catch (ClassNotFoundException paramApiClient)
    {
      break label143;
    }
    catch (IllegalAccessException paramApiClient)
    {
      break label143;
    }
    catch (IllegalArgumentException paramApiClient)
    {
      break label143;
    }
    catch (NoSuchMethodException paramApiClient)
    {
      break label143;
    }
    catch (InvocationTargetException paramApiClient)
    {
      label143:
      break label143;
    }
  }
  
  public final R await()
  {
    HMSLog.i("PendingResultImpl", "await");
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      HMSLog.e("PendingResultImpl", "await in main thread");
      throw new IllegalStateException("await must not be called on the UI thread");
    }
    return awaitOnAnyThread();
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit)
  {
    HMSLog.i("PendingResultImpl", "await timeout:" + paramLong + " unit:" + paramTimeUnit.toString());
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      HMSLog.i("PendingResultImpl", "await in main thread");
      throw new IllegalStateException("await must not be called on the UI thread");
    }
    return awaitOnAnyThread(paramLong, paramTimeUnit);
  }
  
  public final R awaitOnAnyThread()
  {
    HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
    if (this.c == null)
    {
      HMSLog.e("PendingResultImpl", "api is null");
      a(907135003, null);
      return this.b;
    }
    ApiClient localApiClient = (ApiClient)this.c.get();
    if (!checkApiClient(localApiClient))
    {
      HMSLog.e("PendingResultImpl", "client invalid");
      a(907135003, null);
      return this.b;
    }
    if (this.f) {
      a(0, 1);
    }
    this.transport.send(localApiClient, new PendingResultImpl.1(this));
    try
    {
      this.a.await();
      return this.b;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
        a(907135001, null);
      }
    }
  }
  
  public final R awaitOnAnyThread(long paramLong, TimeUnit paramTimeUnit)
  {
    HMSLog.i("PendingResultImpl", "awaitOnAnyThread timeout:" + paramLong + " unit:" + paramTimeUnit.toString());
    if (this.c == null)
    {
      HMSLog.e("PendingResultImpl", "api is null");
      a(907135003, null);
      return this.b;
    }
    ApiClient localApiClient = (ApiClient)this.c.get();
    if (!checkApiClient(localApiClient))
    {
      HMSLog.e("PendingResultImpl", "client invalid");
      a(907135003, null);
      return this.b;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    if (this.f) {
      a(0, 1);
    }
    this.transport.post(localApiClient, new PendingResultImpl.2(this, localAtomicBoolean));
    try
    {
      if (!this.a.await(paramLong, paramTimeUnit))
      {
        localAtomicBoolean.set(true);
        a(907135004, null);
      }
      return this.b;
    }
    catch (InterruptedException paramTimeUnit)
    {
      for (;;)
      {
        HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
        a(907135001, null);
      }
    }
  }
  
  @Deprecated
  public void cancel() {}
  
  protected boolean checkApiClient(ApiClient paramApiClient)
  {
    return true;
  }
  
  protected Class<T> getResponseType()
  {
    Type localType = getClass().getGenericSuperclass();
    if (localType != null)
    {
      localType = ((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[1];
      if (localType != null) {
        return (Class)localType;
      }
    }
    return null;
  }
  
  @Deprecated
  public boolean isCanceled()
  {
    return false;
  }
  
  public abstract R onComplete(T paramT);
  
  protected R onError(int paramInt)
  {
    Object localObject1 = getClass().getGenericSuperclass();
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((java.lang.reflect.ParameterizedType)localObject1).getActualTypeArguments()[0];; localObject2 = null)
    {
      if (localObject1 != null) {}
      for (localObject1 = GenericTypeReflector.getType((Type)localObject1);; localObject2 = null)
      {
        if (localObject1 != null) {}
        try
        {
          this.b = ((Result)((Class)localObject1).newInstance());
          this.b.setStatus(new Status(paramInt));
          return this.b;
        }
        catch (Exception localException)
        {
          HMSLog.e("PendingResultImpl", "on Error:" + localException.getMessage());
          return null;
        }
      }
    }
  }
  
  public final void setResultCallback(Looper paramLooper, ResultCallback<R> paramResultCallback)
  {
    HMSLog.i("PendingResultImpl", "setResultCallback");
    Object localObject = paramLooper;
    if (paramLooper == null) {
      localObject = Looper.myLooper();
    }
    paramLooper = new PendingResultImpl.a((Looper)localObject);
    if (this.c == null)
    {
      HMSLog.e("PendingResultImpl", "api is null");
      a(907135003, null);
      return;
    }
    localObject = (ApiClient)this.c.get();
    if (!checkApiClient((ApiClient)localObject))
    {
      HMSLog.e("PendingResultImpl", "client is invalid");
      a(907135003, null);
      paramLooper.a(paramResultCallback, this.b);
      return;
    }
    if (this.f) {
      a(0, 1);
    }
    this.transport.post((ApiClient)localObject, new PendingResultImpl.3(this, paramLooper, paramResultCallback));
  }
  
  public void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    if (!(paramResultCallback instanceof BaseAdapter.BaseRequestResultCallback)) {}
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      setResultCallback(Looper.getMainLooper(), paramResultCallback);
      return;
    }
  }
  
  @Deprecated
  public void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    setResultCallback(paramResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl
 * JD-Core Version:    0.7.0.1
 */