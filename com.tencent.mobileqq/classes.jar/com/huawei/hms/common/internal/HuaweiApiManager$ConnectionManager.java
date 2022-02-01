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
  private final Queue<HuaweiApiManager.a> b = new LinkedList();
  private final AnyClient c;
  private ConnectionResult d;
  private final ConnectionManagerKey e;
  private final HuaweiApi<OptionsT> f;
  
  HuaweiApiManager$ConnectionManager(HuaweiApi<OptionsT> paramHuaweiApi)
  {
    Object localObject;
    this.f = localObject;
    this.c = localObject.getClient(HuaweiApiManager.a(paramHuaweiApi).getLooper(), this);
    this.d = null;
    this.e = localObject.getConnectionManagerKey();
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = TransactionIdCreater.getId(this.f.getAppID(), paramString2);
    }
    return str;
  }
  
  private void a(ConnectionResult paramConnectionResult)
  {
    Checker.assertHandlerThread(HuaweiApiManager.a(this.a));
    this.d = paramConnectionResult;
    Iterator localIterator = this.b.iterator();
    int i = 1;
    TaskApiCallWrapper localTaskApiCallWrapper;
    ResponseHeader localResponseHeader;
    if (localIterator.hasNext())
    {
      localTaskApiCallWrapper = ((HuaweiApiManager.a)localIterator.next()).a();
      localResponseHeader = new ResponseHeader(1, 907135003, "Connection Failed:" + b(paramConnectionResult) + "(" + paramConnectionResult.getErrorCode() + ")");
      localResponseHeader.setTransactionId(localTaskApiCallWrapper.getTaskApiCall().getTransactionId());
      b.a(this.f.getContext(), localResponseHeader, String.valueOf(this.f.getKitSdkVersion()));
      if ((this.d.getResolution() == null) || (i == 0)) {
        break label229;
      }
      localResponseHeader.setParcelable(this.d.getResolution());
      i = 0;
    }
    label229:
    for (;;)
    {
      localTaskApiCallWrapper.getTaskApiCall().onResponse(this.c, localResponseHeader, null, localTaskApiCallWrapper.getTaskCompletionSource());
      break;
      this.b.clear();
      this.d = null;
      this.c.disconnect();
      HuaweiApiManager.b(this.a).remove(this.e);
      return;
    }
  }
  
  private void a(HuaweiApiManager.a parama)
  {
    String str = parama.a().getTaskApiCall().getUri();
    RequestHeader localRequestHeader = new RequestHeader();
    localRequestHeader.setSrvName(str.split("\\.")[0]);
    localRequestHeader.setApiName(str);
    localRequestHeader.setAppID(this.f.getAppID() + "|" + this.f.getSubAppID());
    localRequestHeader.setPkgName(this.f.getContext().getPackageName());
    localRequestHeader.setSessionId(this.c.getSessionId());
    TaskApiCall localTaskApiCall = parama.a().getTaskApiCall();
    localRequestHeader.setTransactionId(a(localTaskApiCall.getTransactionId(), str));
    localRequestHeader.setParcelable(localTaskApiCall.getParcelable());
    localRequestHeader.setKitSdkVersion(this.f.getKitSdkVersion());
    if (this.f.getApiLevel() > localTaskApiCall.getApiLevel()) {}
    for (int i = this.f.getApiLevel();; i = localTaskApiCall.getApiLevel())
    {
      localRequestHeader.setApiLevel(i);
      this.c.post(localRequestHeader, localTaskApiCall.getRequestJson(), parama.b());
      return;
    }
  }
  
  private HuaweiApiManager.a b(TaskApiCallWrapper paramTaskApiCallWrapper)
  {
    return new HuaweiApiManager.a(paramTaskApiCallWrapper, new HuaweiApiManager.ConnectionManager.1(this, paramTaskApiCallWrapper));
  }
  
  private String b(ConnectionResult paramConnectionResult)
  {
    if (Util.isAvailableLibExist(this.f.getContext()))
    {
      switch (paramConnectionResult.getErrorCode())
      {
      default: 
        return "unknown errorReason";
      case 10: 
        return "application configuration error, please developer check configuration";
      case 26: 
        return "update failed, because no activity incoming, can't pop update page";
      case 21: 
        return "device is too old to be support";
      case 3: 
        return "HuaWei Mobile Service is disabled";
      case 27: 
        return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
      case 13: 
        return "update cancelled";
      case 8: 
        return "internal error";
      case 25: 
        return "failed to get update result";
      }
      return "get update result, but has other error codes";
    }
    switch (paramConnectionResult.getErrorCode())
    {
    default: 
      return "unknown errorReason";
    case 10: 
      return "application configuration error, please developer check configuration";
    case 8: 
      return "internal error";
    }
    return "get update result, but has other error codes";
  }
  
  private void b()
  {
    Checker.assertHandlerThread(HuaweiApiManager.a(this.a));
    this.d = null;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      a((HuaweiApiManager.a)localIterator.next());
    }
    this.b.clear();
  }
  
  private void b(int paramInt)
  {
    Checker.assertHandlerThread(HuaweiApiManager.a(this.a));
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      TaskApiCallWrapper localTaskApiCallWrapper = ((HuaweiApiManager.a)localIterator.next()).a();
      ResponseHeader localResponseHeader = new ResponseHeader(1, 907135003, "Connection Suspended");
      localResponseHeader.setTransactionId(localTaskApiCallWrapper.getTaskApiCall().getTransactionId());
      localTaskApiCallWrapper.getTaskApiCall().onResponse(this.c, localResponseHeader, null, localTaskApiCallWrapper.getTaskCompletionSource());
    }
    this.b.clear();
    this.d = null;
    this.c.disconnect();
    HuaweiApiManager.b(this.a).remove(this.e);
  }
  
  void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Checker.assertHandlerThread(HuaweiApiManager.a(this.a));
        if (this.c.isConnected())
        {
          HMSLog.d("HuaweiApiManager", "client is connected");
          return;
        }
        if (this.c.isConnecting()) {
          HMSLog.d("HuaweiApiManager", "client is isConnecting");
        } else {
          this.c.connect(paramInt);
        }
      }
      finally {}
    }
  }
  
  void a(TaskApiCallWrapper paramTaskApiCallWrapper)
  {
    HMSLog.i("HuaweiApiManager", "sendRequest");
    Checker.assertHandlerThread(HuaweiApiManager.a(this.a));
    HuaweiApiManager.a locala = b(paramTaskApiCallWrapper);
    int i = paramTaskApiCallWrapper.getTaskApiCall().getMinApkVersion();
    if (this.c.isConnected())
    {
      if (HMSPackageManager.getInstance(this.f.getContext()).hmsVerHigherThan(i))
      {
        a(locala);
        return;
      }
      a();
      this.b.add(locala);
      a(i);
      return;
    }
    this.b.add(locala);
    if ((this.d != null) && (this.d.getErrorCode() != 0))
    {
      onConnectionFailed(this.d);
      return;
    }
    a(i);
  }
  
  boolean a()
  {
    Checker.assertHandlerThread(HuaweiApiManager.a(this.a));
    this.c.disconnect();
    return true;
  }
  
  public void onConnected()
  {
    HMSLog.d("HuaweiApiManager", "onConnected");
    if (Looper.myLooper() == HuaweiApiManager.a(this.a).getLooper())
    {
      b();
      return;
    }
    HuaweiApiManager.a(this.a).post(new HuaweiApiManager.ConnectionManager.3(this));
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    HMSLog.i("HuaweiApiManager", "onConnectionFailed");
    if (Looper.myLooper() == HuaweiApiManager.a(this.a).getLooper())
    {
      a(paramConnectionResult);
      return;
    }
    HuaweiApiManager.a(this.a).post(new HuaweiApiManager.ConnectionManager.2(this, paramConnectionResult));
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    HMSLog.i("HuaweiApiManager", "onConnectionSuspended");
    if (Looper.myLooper() == HuaweiApiManager.a(this.a).getLooper())
    {
      b(paramInt);
      return;
    }
    HuaweiApiManager.a(this.a).post(new HuaweiApiManager.ConnectionManager.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager
 * JD-Core Version:    0.7.0.1
 */