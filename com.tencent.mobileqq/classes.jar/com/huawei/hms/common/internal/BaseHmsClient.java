package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseHmsClient
  implements AidlApiClient
{
  private static final Object a = new Object();
  private int b = 0;
  private final Context c;
  private String d;
  private final ClientSettings e;
  private volatile d f;
  private final AtomicInteger g = new AtomicInteger(1);
  private final BaseHmsClient.ConnectionCallbacks h;
  private final BaseHmsClient.OnConnectionFailedListener i;
  private Handler j = null;
  private BinderAdapter k;
  protected String sessionId;
  
  public BaseHmsClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.c = paramContext;
    this.e = paramClientSettings;
    this.d = this.e.getAppID();
    this.i = paramOnConnectionFailedListener;
    this.h = paramConnectionCallbacks;
  }
  
  private void a()
  {
    HMSLog.i("BaseHmsClient", "enter bindCoreService");
    String str = HMSPackageManager.getInstance(this.c).getHMSPackageName();
    this.k = new BinderAdapter(this.c, getServiceAction(), str);
    this.k.binder(new BaseHmsClient.1(this));
  }
  
  private void a(int paramInt)
  {
    this.g.set(paramInt);
  }
  
  private void a(AvailableAdapter paramAvailableAdapter)
  {
    HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
    if (!getClientSettings().isHasActivity())
    {
      b(26);
      return;
    }
    Activity localActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
    if (localActivity != null)
    {
      paramAvailableAdapter.startResolution(localActivity, new BaseHmsClient.2(this));
      return;
    }
    b(26);
  }
  
  private void a(ConnectionResult paramConnectionResult)
  {
    HMSLog.i("BaseHmsClient", "notifyFailed result: " + paramConnectionResult.getErrorCode());
    if (this.i != null) {
      this.i.onConnectionFailed(paramConnectionResult);
    }
  }
  
  private void b()
  {
    synchronized (a)
    {
      if (this.j != null)
      {
        this.j.removeMessages(2);
        this.j = null;
      }
      return;
    }
  }
  
  private void b(int paramInt)
  {
    HMSLog.i("BaseHmsClient", "notifyFailed result: " + paramInt);
    if (this.i != null) {
      this.i.onConnectionFailed(new ConnectionResult(paramInt));
    }
  }
  
  public void checkAvailabilityAndConnect(int paramInt)
  {
    HMSLog.i("BaseHmsClient", "====== HMSSDK version: 50000301 ======");
    int m = this.g.get();
    HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + m);
    if ((m == 3) || (m == 5) || (m == 4)) {
      return;
    }
    a(5);
    m = paramInt;
    if (getMinApkVersion() > paramInt) {
      m = getMinApkVersion();
    }
    HMSLog.i("BaseHmsClient", "connect minVersion:" + m);
    if (Util.isAvailableLibExist(this.c))
    {
      AvailableAdapter localAvailableAdapter = new AvailableAdapter(m);
      paramInt = localAvailableAdapter.isHuaweiMobileServicesAvailable(this.c);
      HMSLog.i("BaseHmsClient", "check available result: " + paramInt);
      if (paramInt == 0)
      {
        a();
        return;
      }
      if (localAvailableAdapter.isUserResolvableError(paramInt))
      {
        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
        a(localAvailableAdapter);
        return;
      }
      HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + paramInt + " is not resolvable.");
      b(paramInt);
      return;
    }
    paramInt = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.c, m);
    HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + paramInt);
    if (paramInt == 0)
    {
      a();
      return;
    }
    b(paramInt);
  }
  
  protected final void checkConnected()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void connect(int paramInt)
  {
    checkAvailabilityAndConnect(paramInt);
  }
  
  protected final void connectionConnected()
  {
    a(3);
    if (this.h != null) {
      this.h.onConnected();
    }
  }
  
  public void disconnect()
  {
    int m = this.g.get();
    HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + m);
    switch (m)
    {
    case 1: 
    case 2: 
    case 4: 
    default: 
      return;
    case 5: 
      b();
      a(4);
      return;
    }
    if (this.k != null) {
      this.k.unBind();
    }
    a(1);
  }
  
  public List<String> getApiNameList()
  {
    return this.e.getApiName();
  }
  
  public String getAppID()
  {
    return this.d;
  }
  
  protected ClientSettings getClientSettings()
  {
    return this.e;
  }
  
  public Context getContext()
  {
    return this.c;
  }
  
  public String getCpID()
  {
    return this.e.getCpID();
  }
  
  @Deprecated
  public int getMinApkVersion()
  {
    return 30000000;
  }
  
  public String getPackageName()
  {
    return this.e.getClientPackageName();
  }
  
  public d getService()
  {
    return this.f;
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
    return this.e.getSubAppID();
  }
  
  public String getTransportName()
  {
    return IPCTransport.class.getName();
  }
  
  public boolean isConnected()
  {
    return (this.g.get() == 3) || (this.g.get() == 4);
  }
  
  public boolean isConnecting()
  {
    return this.g.get() == 5;
  }
  
  public void onConnecting()
  {
    connectionConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.internal.BaseHmsClient
 * JD-Core Version:    0.7.0.1
 */