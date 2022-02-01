package com.huawei.hms.common.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HuaweiApiManager$ConnectionManager<OptionsT extends Api.ApiOptions>
  implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener
{
  private final Queue<HuaweiApiManager.TaskApiCallbackWrapper> callbackQueue = new LinkedList();
  private final HuaweiApi<OptionsT> mApi;
  private final AnyClient mClient;
  private final ConnectionManagerKey mConnectionManagerKey;
  private ConnectionResult mConnectionResult;
  private ResolveClientBean mResolveClientBean;
  
  HuaweiApiManager$ConnectionManager(HuaweiApi<OptionsT> paramHuaweiApi)
  {
    Object localObject;
    this.mApi = localObject;
    this.mClient = localObject.getClient(HuaweiApiManager.access$100(paramHuaweiApi).getLooper(), this);
    this.mConnectionResult = null;
    this.mConnectionManagerKey = localObject.getConnectionManagerKey();
  }
  
  private String errorReason(ConnectionResult paramConnectionResult)
  {
    int i;
    if (Util.isAvailableLibExist(this.mApi.getContext()))
    {
      i = paramConnectionResult.getErrorCode();
      if (i == -1) {
        break label132;
      }
      if (i != 3)
      {
        if (i == 8) {
          break label129;
        }
        if (i == 10) {
          break label126;
        }
        if (i != 13)
        {
          if (i != 21) {
            switch (i)
            {
            default: 
              break;
            case 27: 
              return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
            case 26: 
              return "update failed, because no activity incoming, can't pop update page";
            case 25: 
              return "failed to get update result";
            }
          } else {
            return "device is too old to be support";
          }
        }
        else {
          return "update cancelled";
        }
      }
      else
      {
        return "HuaWei Mobile Service is disabled";
      }
    }
    else
    {
      i = paramConnectionResult.getErrorCode();
      if (i == -1) {
        break label132;
      }
      if (i == 8) {
        break label129;
      }
      if (i == 10) {
        break label126;
      }
    }
    return "unknown errorReason";
    label126:
    return "application configuration error, please developer check configuration";
    label129:
    return "internal error";
    label132:
    return "get update result, but has other error codes";
  }
  
  private String getTransactionId(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = TransactionIdCreater.getId(this.mApi.getAppID(), paramString2);
    }
    return str;
  }
  
  private void innerConnected()
  {
    Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
    this.mConnectionResult = null;
    Iterator localIterator = this.callbackQueue.iterator();
    while (localIterator.hasNext()) {
      postMessage((HuaweiApiManager.TaskApiCallbackWrapper)localIterator.next());
    }
    this.callbackQueue.clear();
  }
  
  private void innerConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
    this.mConnectionResult = paramConnectionResult;
    Iterator localIterator = this.callbackQueue.iterator();
    int i;
    for (int j = 1; localIterator.hasNext(); j = i)
    {
      TaskApiCallWrapper localTaskApiCallWrapper = ((HuaweiApiManager.TaskApiCallbackWrapper)localIterator.next()).getApiCallWrapper();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Connection Failed:");
      ((StringBuilder)localObject).append(errorReason(paramConnectionResult));
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramConnectionResult.getErrorCode());
      ((StringBuilder)localObject).append(")");
      localObject = new ResponseHeader(1, 907135003, ((StringBuilder)localObject).toString());
      ((ResponseHeader)localObject).setTransactionId(localTaskApiCallWrapper.getTaskApiCall().getTransactionId());
      b.a(this.mApi.getContext(), (ResponseHeader)localObject, String.valueOf(this.mApi.getKitSdkVersion()));
      i = j;
      if (this.mConnectionResult.getResolution() != null)
      {
        i = j;
        if (j != 0)
        {
          ((ResponseHeader)localObject).setParcelable(this.mConnectionResult.getResolution());
          j = 0;
          i = j;
          if (Util.isAvailableLibExist(this.mApi.getContext()))
          {
            i = j;
            if (this.mConnectionResult.getErrorCode() == 26)
            {
              ((ResponseHeader)localObject).setResolution("hasContextResolution");
              i = j;
            }
          }
        }
      }
      localTaskApiCallWrapper.getTaskApiCall().onResponse(this.mClient, (ResponseErrorCode)localObject, null, localTaskApiCallWrapper.getTaskCompletionSource());
    }
    this.callbackQueue.clear();
    this.mConnectionResult = null;
    this.mClient.disconnect();
    HuaweiApiManager.access$400(this.this$0).remove(this.mConnectionManagerKey);
  }
  
  private void innerConnectionSuspended(int paramInt)
  {
    Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
    Iterator localIterator = this.callbackQueue.iterator();
    while (localIterator.hasNext())
    {
      TaskApiCallWrapper localTaskApiCallWrapper = ((HuaweiApiManager.TaskApiCallbackWrapper)localIterator.next()).getApiCallWrapper();
      ResponseHeader localResponseHeader = new ResponseHeader(1, 907135003, "Connection Suspended");
      localResponseHeader.setTransactionId(localTaskApiCallWrapper.getTaskApiCall().getTransactionId());
      localTaskApiCallWrapper.getTaskApiCall().onResponse(this.mClient, localResponseHeader, null, localTaskApiCallWrapper.getTaskCompletionSource());
    }
    this.callbackQueue.clear();
    this.mConnectionResult = null;
    this.mClient.disconnect();
    HuaweiApiManager.access$400(this.this$0).remove(this.mConnectionManagerKey);
  }
  
  private void postMessage(HuaweiApiManager.TaskApiCallbackWrapper paramTaskApiCallbackWrapper)
  {
    String str = paramTaskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getUri();
    RequestHeader localRequestHeader = new RequestHeader();
    localRequestHeader.setSrvName(str.split("\\.")[0]);
    localRequestHeader.setApiName(str);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mApi.getAppID());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.mApi.getSubAppID());
    localRequestHeader.setAppID(((StringBuilder)localObject).toString());
    localRequestHeader.setPkgName(this.mApi.getContext().getPackageName());
    localRequestHeader.setSessionId(this.mClient.getSessionId());
    localObject = paramTaskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall();
    localRequestHeader.setTransactionId(getTransactionId(((TaskApiCall)localObject).getTransactionId(), str));
    localRequestHeader.setParcelable(((TaskApiCall)localObject).getParcelable());
    localRequestHeader.setKitSdkVersion(this.mApi.getKitSdkVersion());
    localRequestHeader.setApiLevel(Math.max(this.mApi.getApiLevel(), ((TaskApiCall)localObject).getApiLevel()));
    this.mClient.post(localRequestHeader, ((TaskApiCall)localObject).getRequestJson(), paramTaskApiCallbackWrapper.getCallBack());
  }
  
  private HuaweiApiManager.TaskApiCallbackWrapper wrapperRequest(TaskApiCallWrapper paramTaskApiCallWrapper)
  {
    return new HuaweiApiManager.TaskApiCallbackWrapper(paramTaskApiCallWrapper, new HuaweiApiManager.ConnectionManager.1(this, paramTaskApiCallWrapper));
  }
  
  void connect(int paramInt)
  {
    try
    {
      Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
      if (this.mClient.isConnected())
      {
        HMSLog.d("HuaweiApiManager", "client is connected");
        return;
      }
      if (this.mClient.isConnecting())
      {
        HMSLog.d("HuaweiApiManager", "client is isConnecting");
        return;
      }
      if (this.mApi.getActivity() != null)
      {
        if (this.mResolveClientBean == null) {
          this.mResolveClientBean = new ResolveClientBean(this.mClient, paramInt);
        }
        if (BindResolveClients.getInstance().isClientRegistered(this.mResolveClientBean))
        {
          HMSLog.i("HuaweiApiManager", "mResolveClientBean has already register, return!");
          return;
        }
        BindResolveClients.getInstance().register(this.mResolveClientBean);
      }
      this.mClient.connect(paramInt);
      return;
    }
    finally {}
  }
  
  boolean disconnect()
  {
    Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
    this.mClient.disconnect();
    return true;
  }
  
  public void onConnected()
  {
    HMSLog.d("HuaweiApiManager", "onConnected");
    BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
    this.mResolveClientBean = null;
    if (Looper.myLooper() == HuaweiApiManager.access$100(this.this$0).getLooper())
    {
      innerConnected();
      return;
    }
    HuaweiApiManager.access$100(this.this$0).post(new HuaweiApiManager.ConnectionManager.3(this));
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    HMSLog.i("HuaweiApiManager", "onConnectionFailed");
    BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
    this.mResolveClientBean = null;
    if (Looper.myLooper() == HuaweiApiManager.access$100(this.this$0).getLooper())
    {
      innerConnectionFailed(paramConnectionResult);
      return;
    }
    HuaweiApiManager.access$100(this.this$0).post(new HuaweiApiManager.ConnectionManager.2(this, paramConnectionResult));
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    HMSLog.i("HuaweiApiManager", "onConnectionSuspended");
    BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
    this.mResolveClientBean = null;
    if (Looper.myLooper() == HuaweiApiManager.access$100(this.this$0).getLooper())
    {
      innerConnectionSuspended(paramInt);
      return;
    }
    HuaweiApiManager.access$100(this.this$0).post(new HuaweiApiManager.ConnectionManager.4(this, paramInt));
  }
  
  void sendRequest(TaskApiCallWrapper paramTaskApiCallWrapper)
  {
    HMSLog.i("HuaweiApiManager", "sendRequest");
    Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
    HuaweiApiManager.TaskApiCallbackWrapper localTaskApiCallbackWrapper = wrapperRequest(paramTaskApiCallWrapper);
    int i = paramTaskApiCallWrapper.getTaskApiCall().getMinApkVersion();
    if (this.mClient.isConnected())
    {
      if (HMSPackageManager.getInstance(this.mApi.getContext()).hmsVerHigherThan(i))
      {
        postMessage(localTaskApiCallbackWrapper);
        return;
      }
      disconnect();
      this.callbackQueue.add(localTaskApiCallbackWrapper);
      connect(i);
      return;
    }
    this.callbackQueue.add(localTaskApiCallbackWrapper);
    paramTaskApiCallWrapper = this.mConnectionResult;
    if ((paramTaskApiCallWrapper != null) && (paramTaskApiCallWrapper.getErrorCode() != 0))
    {
      onConnectionFailed(this.mConnectionResult);
      return;
    }
    connect(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager
 * JD-Core Version:    0.7.0.1
 */