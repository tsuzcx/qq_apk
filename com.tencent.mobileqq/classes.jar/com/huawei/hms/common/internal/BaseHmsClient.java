package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseHmsClient
  implements AidlApiClient
{
  private static final int BINDING = 5;
  private static final int CONNECTED = 3;
  private static final int DISCONNECTED = 1;
  private static final int DISCONNECTING = 4;
  private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
  private static final int MSG_CONN_TIMEOUT = 2;
  private static final String TAG = "BaseHmsClient";
  private String mAppID;
  private BinderAdapter mBinderAdapter;
  private final ClientSettings mClientSettings;
  private final AtomicInteger mConnStatus = new AtomicInteger(1);
  private Handler mConnectTimeoutHandler = null;
  private final BaseHmsClient.ConnectionCallbacks mConnectionCallbacks;
  private final BaseHmsClient.OnConnectionFailedListener mConnectionFailedListener;
  private final Context mContext;
  private volatile d mService;
  protected String sessionId;
  
  public BaseHmsClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.mContext = paramContext;
    this.mClientSettings = paramClientSettings;
    this.mAppID = this.mClientSettings.getAppID();
    this.mConnectionFailedListener = paramOnConnectionFailedListener;
    this.mConnectionCallbacks = paramConnectionCallbacks;
  }
  
  private void bindCoreService()
  {
    String str2 = this.mClientSettings.getInnerHmsPkg();
    Object localObject2 = getServiceAction();
    Object localObject1 = localObject2;
    if (str2.equalsIgnoreCase(this.mContext.getPackageName()))
    {
      String str1 = Util.getServiceActionMetadata(this.mContext);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str1)) {
        localObject1 = str1;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enter bindCoreService, packageName is ");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(", serviceAction is ");
    ((StringBuilder)localObject2).append(localObject1);
    HMSLog.i("BaseHmsClient", ((StringBuilder)localObject2).toString());
    this.mBinderAdapter = new BinderAdapter(this.mContext, localObject1, str2);
    this.mBinderAdapter.binder(new BaseHmsClient.1(this));
  }
  
  private void cancelConnDelayHandle()
  {
    synchronized (LOCK_CONNECT_TIMEOUT_HANDLER)
    {
      if (this.mConnectTimeoutHandler != null)
      {
        this.mConnectTimeoutHandler.removeMessages(2);
        this.mConnectTimeoutHandler = null;
      }
      return;
    }
  }
  
  private void checkAvailabilityAndConnect(int paramInt, boolean paramBoolean)
  {
    HMSLog.i("BaseHmsClient", "====== HMSSDK version: 50200300 ======");
    int i = this.mConnStatus.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter connect, Connection Status: ");
    ((StringBuilder)localObject).append(i);
    HMSLog.i("BaseHmsClient", ((StringBuilder)localObject).toString());
    if ((!paramBoolean) && ((i == 3) || (i == 5) || (i == 4))) {
      return;
    }
    setConnectStatus(5);
    i = paramInt;
    if (getMinApkVersion() > paramInt) {
      i = getMinApkVersion();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("connect minVersion:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" packageName:");
    ((StringBuilder)localObject).append(this.mClientSettings.getInnerHmsPkg());
    HMSLog.i("BaseHmsClient", ((StringBuilder)localObject).toString());
    if (this.mContext.getPackageName().equals(this.mClientSettings.getInnerHmsPkg()))
    {
      HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
      bindCoreService();
      return;
    }
    if (Util.isAvailableLibExist(this.mContext))
    {
      localObject = new AvailableAdapter(i);
      paramInt = ((AvailableAdapter)localObject).isHuaweiMobileServicesAvailable(this.mContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check available result: ");
      localStringBuilder.append(paramInt);
      HMSLog.i("BaseHmsClient", localStringBuilder.toString());
      if (paramInt == 0)
      {
        bindCoreService();
        return;
      }
      if (((AvailableAdapter)localObject).isUserResolvableError(paramInt))
      {
        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
        resolution((AvailableAdapter)localObject, paramInt);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindCoreService3.0 fail: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" is not resolvable.");
      HMSLog.i("BaseHmsClient", ((StringBuilder)localObject).toString());
      notifyFailed(paramInt);
      return;
    }
    paramInt = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.mContext, i);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HuaweiApiAvailability check available result: ");
    ((StringBuilder)localObject).append(paramInt);
    HMSLog.i("BaseHmsClient", ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      bindCoreService();
      return;
    }
    notifyFailed(paramInt);
  }
  
  private void notifyFailed(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyFailed result: ");
    ((StringBuilder)localObject).append(paramInt);
    HMSLog.i("BaseHmsClient", ((StringBuilder)localObject).toString());
    localObject = this.mConnectionFailedListener;
    if (localObject != null) {
      ((BaseHmsClient.OnConnectionFailedListener)localObject).onConnectionFailed(new ConnectionResult(paramInt));
    }
  }
  
  private void notifyFailed(ConnectionResult paramConnectionResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyFailed result: ");
    ((StringBuilder)localObject).append(paramConnectionResult.getErrorCode());
    HMSLog.i("BaseHmsClient", ((StringBuilder)localObject).toString());
    localObject = this.mConnectionFailedListener;
    if (localObject != null) {
      ((BaseHmsClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
    }
  }
  
  private void resolution(AvailableAdapter paramAvailableAdapter, int paramInt)
  {
    HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
    if (!getClientSettings().isHasActivity())
    {
      notifyFailed(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.mContext, paramInt, 0)));
      return;
    }
    Activity localActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
    if (localActivity != null)
    {
      paramAvailableAdapter.startResolution(localActivity, new BaseHmsClient.2(this));
      return;
    }
    notifyFailed(26);
  }
  
  private void setConnectStatus(int paramInt)
  {
    this.mConnStatus.set(paramInt);
  }
  
  protected final void checkConnected()
  {
    if (isConnected()) {
      return;
    }
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public void connect(int paramInt)
  {
    checkAvailabilityAndConnect(paramInt, false);
  }
  
  public void connect(int paramInt, boolean paramBoolean)
  {
    checkAvailabilityAndConnect(paramInt, paramBoolean);
  }
  
  protected final void connectionConnected()
  {
    setConnectStatus(3);
    BaseHmsClient.ConnectionCallbacks localConnectionCallbacks = this.mConnectionCallbacks;
    if (localConnectionCallbacks != null) {
      localConnectionCallbacks.onConnected();
    }
  }
  
  public void disconnect()
  {
    int i = this.mConnStatus.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter disconnect, Connection Status: ");
    ((StringBuilder)localObject).append(i);
    HMSLog.i("BaseHmsClient", ((StringBuilder)localObject).toString());
    if (i != 1) {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5) {
            return;
          }
          cancelConnDelayHandle();
          setConnectStatus(4);
        }
      }
      else
      {
        localObject = this.mBinderAdapter;
        if (localObject != null) {
          ((BinderAdapter)localObject).unBind();
        }
        setConnectStatus(1);
      }
    }
  }
  
  public List<String> getApiNameList()
  {
    return this.mClientSettings.getApiName();
  }
  
  public String getAppID()
  {
    return this.mAppID;
  }
  
  protected ClientSettings getClientSettings()
  {
    return this.mClientSettings;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getCpID()
  {
    return this.mClientSettings.getCpID();
  }
  
  @Deprecated
  public int getMinApkVersion()
  {
    return 30000000;
  }
  
  public String getPackageName()
  {
    return this.mClientSettings.getClientPackageName();
  }
  
  public d getService()
  {
    return this.mService;
  }
  
  public String getServiceAction()
  {
    return "com.huawei.hms.core.aidlservice";
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public SubAppInfo getSubAppInfo()
  {
    return this.mClientSettings.getSubAppID();
  }
  
  public String getTransportName()
  {
    return IPCTransport.class.getName();
  }
  
  public boolean isConnected()
  {
    return (this.mConnStatus.get() == 3) || (this.mConnStatus.get() == 4);
  }
  
  public boolean isConnecting()
  {
    return this.mConnStatus.get() == 5;
  }
  
  public void onConnecting()
  {
    connectionConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.BaseHmsClient
 * JD-Core Version:    0.7.0.1
 */