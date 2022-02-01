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
  private static final String TAG = "PendingResultImpl";
  private WeakReference<ApiClient> api;
  private CountDownLatch countLatch;
  private boolean isNeedReport = true;
  private R result = null;
  private String transId = null;
  protected DatagramTransport transport = null;
  private String url = null;
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    init(paramApiClient, paramString, paramIMessageEntity, getResponseType(), 0);
  }
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, int paramInt)
  {
    init(paramApiClient, paramString, paramIMessageEntity, getResponseType(), paramInt);
  }
  
  public PendingResultImpl(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass)
  {
    init(paramApiClient, paramString, paramIMessageEntity, paramClass, 0);
  }
  
  private void biReportEvent(int paramInt1, int paramInt2)
  {
    HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
    ApiClient localApiClient = (ApiClient)this.api.get();
    if ((localApiClient != null) && (this.url != null))
    {
      if (HiAnalyticsUtil.getInstance().hasError(localApiClient.getContext())) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("package", localApiClient.getPackageName());
      localHashMap.put("baseVersion", "5.2.0.300");
      if (paramInt2 == 1)
      {
        localHashMap.put("direction", "req");
      }
      else
      {
        localHashMap.put("direction", "rsp");
        localHashMap.put("result", String.valueOf(paramInt1));
        localObject = this.result;
        if ((localObject != null) && (((Result)localObject).getStatus() != null)) {
          localHashMap.put("statusCode", String.valueOf(this.result.getStatus().getStatusCode()));
        }
      }
      localHashMap.put("version", "0");
      String str = Util.getAppId(localApiClient.getContext());
      Object localObject = str;
      if (TextUtils.isEmpty(str))
      {
        SubAppInfo localSubAppInfo = localApiClient.getSubAppInfo();
        localObject = str;
        if (localSubAppInfo != null) {
          localObject = localSubAppInfo.getSubAppID();
        }
      }
      localHashMap.put("appid", localObject);
      if (TextUtils.isEmpty(this.transId))
      {
        this.transId = TransactionIdCreater.getId((String)localObject, this.url);
        localHashMap.put("transId", this.transId);
      }
      else
      {
        localHashMap.put("transId", this.transId);
        this.transId = null;
      }
      localObject = this.url.split("\\.");
      if (localObject.length >= 2)
      {
        localHashMap.put("service", localObject[0]);
        localHashMap.put("apiName", localObject[1]);
      }
      localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
      HiAnalyticsUtil.getInstance().onEvent(localApiClient.getContext(), "HMS_SDK_BASE_CALL_AIDL", localHashMap);
    }
  }
  
  private void init(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init uri:");
    localStringBuilder.append(paramString);
    HMSLog.i("PendingResultImpl", localStringBuilder.toString());
    this.url = paramString;
    if (paramApiClient == null)
    {
      HMSLog.e("PendingResultImpl", "client is null");
      return;
    }
    this.api = new WeakReference(paramApiClient);
    this.countLatch = new CountDownLatch(1);
    try
    {
      this.transport = ((DatagramTransport)Class.forName(paramApiClient.getTransportName()).getConstructor(new Class[] { String.class, IMessageEntity.class, Class.class, Integer.TYPE }).newInstance(new Object[] { paramString, paramIMessageEntity, paramClass, Integer.valueOf(paramInt) }));
      return;
    }
    catch (ClassNotFoundException paramApiClient) {}catch (NoSuchMethodException paramApiClient) {}catch (InvocationTargetException paramApiClient) {}catch (IllegalArgumentException paramApiClient) {}catch (IllegalAccessException paramApiClient) {}catch (InstantiationException paramApiClient) {}
    paramString = new StringBuilder();
    paramString.append("gen transport error:");
    paramString.append(paramApiClient.getMessage());
    HMSLog.e("PendingResultImpl", paramString.toString());
    paramString = new StringBuilder();
    paramString.append("Instancing transport exception, ");
    paramString.append(paramApiClient.getMessage());
    throw new IllegalStateException(paramString.toString(), paramApiClient);
  }
  
  private void setResult(int paramInt, IMessageEntity paramIMessageEntity)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setResult:");
    ((StringBuilder)localObject1).append(paramInt);
    HMSLog.i("PendingResultImpl", ((StringBuilder)localObject1).toString());
    if ((paramIMessageEntity instanceof AbstractMessageEntity)) {
      localObject1 = ((AbstractMessageEntity)paramIMessageEntity).getCommonStatus();
    } else {
      localObject1 = null;
    }
    if (paramInt == 0) {
      this.result = onComplete(paramIMessageEntity);
    } else {
      this.result = onError(paramInt);
    }
    if (this.isNeedReport) {
      biReportEvent(paramInt, 2);
    }
    paramIMessageEntity = this.result;
    if (paramIMessageEntity != null)
    {
      Object localObject2 = paramIMessageEntity.getStatus();
      if ((localObject2 != null) && (localObject1 != null))
      {
        paramInt = ((Status)localObject2).getStatusCode();
        paramIMessageEntity = ((Status)localObject2).getStatusMessage();
        int i = ((Status)localObject1).getStatusCode();
        localObject1 = ((Status)localObject1).getStatusMessage();
        if (paramInt != i)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("rstStatus code (");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(") is not equal commonStatus code (");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(")");
          HMSLog.e("PendingResultImpl", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("rstStatus msg (");
          ((StringBuilder)localObject2).append(paramIMessageEntity);
          ((StringBuilder)localObject2).append(") is not equal commonStatus msg (");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(")");
          HMSLog.e("PendingResultImpl", ((StringBuilder)localObject2).toString());
          return;
        }
        if ((TextUtils.isEmpty(paramIMessageEntity)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("rstStatus msg (");
          localStringBuilder.append(paramIMessageEntity);
          localStringBuilder.append(") is not equal commonStatus msg (");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(")");
          HMSLog.i("PendingResultImpl", localStringBuilder.toString());
          this.result.setStatus(new Status(paramInt, (String)localObject1, ((Status)localObject2).getResolution()));
        }
      }
    }
  }
  
  public final R await()
  {
    HMSLog.i("PendingResultImpl", "await");
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return awaitOnAnyThread();
    }
    HMSLog.e("PendingResultImpl", "await in main thread");
    throw new IllegalStateException("await must not be called on the UI thread");
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("await timeout:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" unit:");
    localStringBuilder.append(paramTimeUnit.toString());
    HMSLog.i("PendingResultImpl", localStringBuilder.toString());
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return awaitOnAnyThread(paramLong, paramTimeUnit);
    }
    HMSLog.i("PendingResultImpl", "await in main thread");
    throw new IllegalStateException("await must not be called on the UI thread");
  }
  
  public final R awaitOnAnyThread()
  {
    HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
    Object localObject = this.api;
    if (localObject == null)
    {
      HMSLog.e("PendingResultImpl", "api is null");
      setResult(907135003, null);
      return this.result;
    }
    localObject = (ApiClient)((WeakReference)localObject).get();
    if (!checkApiClient((ApiClient)localObject))
    {
      HMSLog.e("PendingResultImpl", "client invalid");
      setResult(907135003, null);
      return this.result;
    }
    if (this.isNeedReport) {
      biReportEvent(0, 1);
    }
    this.transport.send((ApiClient)localObject, new PendingResultImpl.a(this));
    try
    {
      this.countLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      label116:
      break label116;
    }
    HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
    setResult(907135001, null);
    return this.result;
  }
  
  public final R awaitOnAnyThread(long paramLong, TimeUnit paramTimeUnit)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("awaitOnAnyThread timeout:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" unit:");
    ((StringBuilder)localObject).append(paramTimeUnit.toString());
    HMSLog.i("PendingResultImpl", ((StringBuilder)localObject).toString());
    localObject = this.api;
    if (localObject == null)
    {
      HMSLog.e("PendingResultImpl", "api is null");
      setResult(907135003, null);
      return this.result;
    }
    localObject = (ApiClient)((WeakReference)localObject).get();
    if (!checkApiClient((ApiClient)localObject))
    {
      HMSLog.e("PendingResultImpl", "client invalid");
      setResult(907135003, null);
      return this.result;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    if (this.isNeedReport) {
      biReportEvent(0, 1);
    }
    this.transport.post((ApiClient)localObject, new PendingResultImpl.b(this, localAtomicBoolean));
    try
    {
      if (this.countLatch.await(paramLong, paramTimeUnit)) {
        break label214;
      }
      localAtomicBoolean.set(true);
      setResult(907135004, null);
    }
    catch (InterruptedException paramTimeUnit)
    {
      label198:
      break label198;
    }
    HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
    setResult(907135001, null);
    label214:
    return this.result;
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
    Object localObject = getClass().getGenericSuperclass();
    if (localObject != null) {
      localObject = ((java.lang.reflect.ParameterizedType)localObject).getActualTypeArguments()[0];
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = GenericTypeReflector.getType((Type)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      try
      {
        this.result = ((Result)((Class)localObject).newInstance());
        this.result.setStatus(new Status(paramInt));
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("on Error:");
        localStringBuilder.append(localException.getMessage());
        HMSLog.e("PendingResultImpl", localStringBuilder.toString());
        return null;
      }
    }
    return this.result;
  }
  
  public final void setResultCallback(Looper paramLooper, ResultCallback<R> paramResultCallback)
  {
    HMSLog.i("PendingResultImpl", "setResultCallback");
    Object localObject = paramLooper;
    if (paramLooper == null) {
      localObject = Looper.myLooper();
    }
    paramLooper = new PendingResultImpl.d((Looper)localObject);
    localObject = this.api;
    if (localObject == null)
    {
      HMSLog.e("PendingResultImpl", "api is null");
      setResult(907135003, null);
      return;
    }
    localObject = (ApiClient)((WeakReference)localObject).get();
    if (!checkApiClient((ApiClient)localObject))
    {
      HMSLog.e("PendingResultImpl", "client is invalid");
      setResult(907135003, null);
      paramLooper.a(paramResultCallback, this.result);
      return;
    }
    if (this.isNeedReport) {
      biReportEvent(0, 1);
    }
    this.transport.post((ApiClient)localObject, new PendingResultImpl.c(this, paramLooper, paramResultCallback));
  }
  
  public void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    this.isNeedReport = (paramResultCallback instanceof BaseAdapter.BaseRequestResultCallback ^ true);
    setResultCallback(Looper.getMainLooper(), paramResultCallback);
  }
  
  @Deprecated
  public void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    setResultCallback(paramResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl
 * JD-Core Version:    0.7.0.1
 */