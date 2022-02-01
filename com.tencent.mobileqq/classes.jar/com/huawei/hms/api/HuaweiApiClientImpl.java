package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.core.aidl.d.a;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HuaweiApiClientImpl
  extends HuaweiApiClient
  implements ServiceConnection, InnerApiClient
{
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Object a = new Object();
  private static final Object b = new Object();
  private Handler A = null;
  private CheckUpdatelistener B = null;
  private CheckUpdateCallBack C;
  private int c = -1;
  private final Context d;
  private final String e;
  private String f;
  private String g;
  private volatile d h;
  private String i;
  private WeakReference<Activity> j;
  private WeakReference<Activity> k;
  private boolean l = false;
  private AtomicInteger m = new AtomicInteger(1);
  private List<Scope> n;
  private List<PermissionInfo> o;
  private Map<Api<?>, Api.ApiOptions> p;
  private SubAppInfo q;
  private long r = 0L;
  private int s = 0;
  private final Object t = new Object();
  private final ReentrantLock u = new ReentrantLock();
  private final Condition v = this.u.newCondition();
  private ConnectionResult w;
  private HuaweiApiClient.ConnectionCallbacks x;
  private HuaweiApiClient.OnConnectionFailedListener y;
  private Handler z = null;
  
  public HuaweiApiClientImpl(Context paramContext)
  {
    this.d = paramContext;
    this.e = Util.getAppId(paramContext);
    this.f = this.e;
    this.g = Util.getCpId(paramContext);
  }
  
  private void a()
  {
    this.C = new HuaweiApiClientImpl.1(this);
  }
  
  private void a(int paramInt)
  {
    Activity localActivity = (Activity)this.j.get();
    if (!Util.isAvailableLibExist(localActivity.getApplicationContext())) {
      b(paramInt);
    }
    UpdateSdkAPI.checkTargetAppUpdate(localActivity, "com.huawei.hms", new HuaweiApiClientImpl.2(this, paramInt));
  }
  
  private void a(ResolveResult<DisconnectResp> paramResolveResult)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + paramResolveResult.getStatus().getStatusCode());
    n();
    c(1);
  }
  
  private void b()
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
    ConnectService.forceConnect(this, m()).setResultCallback(new HuaweiApiClientImpl.a(this, null));
  }
  
  private void b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.j != null)
    {
      localObject1 = localObject2;
      if (this.j.get() != null)
      {
        localObject1 = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.j.get(), paramInt);
        HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + paramInt);
      }
    }
    localObject1 = new ConnectionResult(paramInt, (PendingIntent)localObject1);
    this.y.onConnectionFailed((ConnectionResult)localObject1);
    this.w = ((ConnectionResult)localObject1);
  }
  
  private void b(ResolveResult<ConnectResp> paramResolveResult)
  {
    ConnectionPostProcessor localConnectionPostProcessor = null;
    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
    if ((this.h == null) || (this.m.get() != 2))
    {
      HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
      return;
    }
    label37:
    int i1;
    label340:
    do
    {
      do
      {
        d(3);
        Object localObject = (ConnectResp)paramResolveResult.getValue();
        if (localObject != null) {
          this.i = ((ConnectResp)localObject).sessionId;
        }
        if (this.q == null) {}
        for (localObject = null;; localObject = this.q.getSubAppID())
        {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.f = ((String)localObject);
          }
          i1 = paramResolveResult.getStatus().getStatusCode();
          HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + i1);
          if (!Status.SUCCESS.equals(paramResolveResult.getStatus())) {
            break label340;
          }
          if (paramResolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(((ConnectResp)paramResolveResult.getValue()).protocolVersion);
          }
          c(3);
          this.w = null;
          if (this.x != null) {
            this.x.onConnected();
          }
          if (this.j != null) {
            o();
          }
          paramResolveResult = getApiMap().entrySet().iterator();
          for (;;)
          {
            if (!paramResolveResult.hasNext()) {
              break label37;
            }
            localObject = (Map.Entry)paramResolveResult.next();
            if ((((Api)((Map.Entry)localObject).getKey()).getmConnetctPostList() == null) || (((Api)((Map.Entry)localObject).getKey()).getmConnetctPostList().isEmpty())) {
              break;
            }
            HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
            localObject = ((Api)((Map.Entry)localObject).getKey()).getmConnetctPostList().iterator();
            while (((Iterator)localObject).hasNext())
            {
              localConnectionPostProcessor = (ConnectionPostProcessor)((Iterator)localObject).next();
              HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
              localConnectionPostProcessor.run(this, this.j);
            }
          }
        }
        if ((paramResolveResult.getStatus() == null) || (paramResolveResult.getStatus().getStatusCode() != 1001)) {
          break label387;
        }
        n();
        c(1);
      } while (this.x == null);
      this.x.onConnectionSuspended(3);
      return;
      n();
      c(1);
    } while (this.y == null);
    label387:
    paramResolveResult = localConnectionPostProcessor;
    if (this.j != null)
    {
      paramResolveResult = localConnectionPostProcessor;
      if (this.j.get() != null) {
        paramResolveResult = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.j.get(), i1);
      }
    }
    paramResolveResult = new ConnectionResult(i1, paramResolveResult);
    this.y.onConnectionFailed(paramResolveResult);
    this.w = paramResolveResult;
  }
  
  private void c()
  {
    if (this.y != null) {
      if (!Util.isBackground(this.d)) {
        break label87;
      }
    }
    label87:
    for (int i1 = 7;; i1 = 6)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.j != null)
      {
        localObject1 = localObject2;
        if (this.j.get() != null) {
          localObject1 = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.j.get(), i1);
        }
      }
      localObject1 = new ConnectionResult(i1, (PendingIntent)localObject1);
      this.y.onConnectionFailed((ConnectionResult)localObject1);
      this.w = ((ConnectionResult)localObject1);
      return;
    }
  }
  
  private void c(int paramInt)
  {
    this.m.set(paramInt);
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)) {
      this.u.lock();
    }
    try
    {
      this.v.signalAll();
      return;
    }
    finally
    {
      this.u.unlock();
    }
  }
  
  private int d()
  {
    int i1 = Util.getHmsVersion(this.d);
    int i2;
    if ((i1 == 0) || (i1 < 20503000))
    {
      i2 = e();
      if (f())
      {
        if (i2 < 20503000) {
          return 20503000;
        }
      }
      else
      {
        i1 = i2;
        if (i2 < 20600000) {
          i1 = 20600000;
        }
        return i1;
      }
    }
    else
    {
      return i1;
    }
    return i2;
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 2) {}
    synchronized (a)
    {
      if (this.z != null)
      {
        this.z.removeMessages(paramInt);
        this.z = null;
      }
      if (paramInt == 3) {
        synchronized (b)
        {
          if (this.A != null)
          {
            this.A.removeMessages(paramInt);
            this.A = null;
          }
        }
      }
    }
    synchronized (a)
    {
      if (this.z != null)
      {
        this.z.removeMessages(2);
        this.z = null;
      }
      return;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  private int e()
  {
    Object localObject1 = getApiMap();
    if (localObject1 == null) {
      return 0;
    }
    localObject1 = ((Map)localObject1).keySet().iterator();
    int i1 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Api)((Iterator)localObject1).next()).getApiName();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label94;
      }
      localObject2 = (Integer)HuaweiApiAvailability.getApiMap().get(localObject2);
      if (localObject2 == null) {
        break label94;
      }
      int i2 = ((Integer)localObject2).intValue();
      if (i2 <= i1) {
        break label94;
      }
      i1 = i2;
    }
    label94:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  private boolean f()
  {
    if (this.p != null)
    {
      Iterator localIterator = this.p.keySet().iterator();
      while (localIterator.hasNext()) {
        if ("HuaweiGame.API".equals(((Api)localIterator.next()).getApiName())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void g()
  {
    Intent localIntent = new Intent("com.huawei.hms.core.aidlservice");
    localIntent.setPackage(HMSPackageManager.getInstance(this.d).getHMSPackageName());
    synchronized (a)
    {
      if (this.d.bindService(localIntent, this, 1))
      {
        h();
        return;
      }
      c(1);
      HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
      c();
      return;
    }
  }
  
  private void h()
  {
    if (this.z != null) {
      this.z.removeMessages(2);
    }
    for (;;)
    {
      this.z.sendEmptyMessageDelayed(2, 5000L);
      return;
      this.z = new Handler(Looper.getMainLooper(), new HuaweiApiClientImpl.3(this));
    }
  }
  
  private void i()
  {
    synchronized (b)
    {
      if (this.A != null)
      {
        this.A.removeMessages(3);
        boolean bool = this.A.sendEmptyMessageDelayed(3, 3000L);
        HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + bool);
        return;
      }
      this.A = new Handler(Looper.getMainLooper(), new HuaweiApiClientImpl.4(this));
    }
  }
  
  private void j()
  {
    ConnectService.disconnect(this, k()).setResultCallback(new HuaweiApiClientImpl.b(this, null));
  }
  
  private DisconnectInfo k()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.p != null)
    {
      Iterator localIterator = this.p.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Api)localIterator.next()).getApiName());
      }
    }
    return new DisconnectInfo(this.n, localArrayList);
  }
  
  private void l()
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
    ConnectService.connect(this, m()).setResultCallback(new HuaweiApiClientImpl.a(this, null));
  }
  
  private ConnectInfo m()
  {
    String str2 = new PackageManagerHelper(this.d).getPackageSignature(this.d.getPackageName());
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (this.q == null) {}
    for (str2 = null;; str2 = this.q.getSubAppID()) {
      return new ConnectInfo(getApiNameList(), this.n, str1, str2);
    }
  }
  
  private void n()
  {
    Util.unBindServiceCatchException(this.d, this);
    this.h = null;
  }
  
  private void o()
  {
    if (this.l) {
      HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
    }
    while (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.d) != 0) {
      return;
    }
    ConnectService.getNotice(this, 0, "5.0.0.301").setResultCallback(new HuaweiApiClientImpl.c(this, null));
  }
  
  public int asyncRequest(Bundle paramBundle, String paramString, int paramInt, ResultCallback<BundleResult> paramResultCallback)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
    if ((paramResultCallback == null) || (paramString == null) || (paramBundle == null))
    {
      HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
      return 907135000;
    }
    if (!innerIsConnected())
    {
      HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
      return 907135003;
    }
    paramString = new b(paramString, paramInt);
    e locale = a.a(paramString.c());
    paramString.a(paramBundle);
    paramBundle = new RequestHeader(getAppID(), getPackageName(), 50000301, getSessionId());
    paramBundle.setApiNameList(getApiNameList());
    paramString.b = locale.a(paramBundle, new Bundle());
    try
    {
      getService().a(paramString, new HuaweiApiClientImpl.5(this, paramResultCallback));
      return 0;
    }
    catch (RemoteException paramBundle)
    {
      HMSLog.e("HuaweiApiClientImpl", "remote exception:" + paramBundle.getMessage());
    }
    return 907135001;
  }
  
  public void checkUpdate(Activity paramActivity, CheckUpdatelistener paramCheckUpdatelistener)
  {
    if (Util.isAvailableLibExist(this.d))
    {
      HMSLog.i("HuaweiApiClientImpl", "Enter checkUpdate");
      if (paramCheckUpdatelistener == null)
      {
        HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        return;
      }
      if ((paramActivity == null) || (paramActivity.isFinishing()))
      {
        HMSLog.e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + paramActivity);
        paramCheckUpdatelistener.onResult(-1);
        return;
      }
      this.B = paramCheckUpdatelistener;
      if (this.C == null) {
        a();
      }
      UpdateSdkAPI.checkClientOTAUpdate(paramActivity, this.C, true, 0, true);
      return;
    }
    HMSLog.e("HuaweiApiClientImpl", "available lib does not exist.");
  }
  
  public void connect(int paramInt)
  {
    connect(null);
  }
  
  public void connect(Activity paramActivity)
  {
    HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50000301 ======");
    int i1 = this.m.get();
    HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i1);
    if ((i1 == 3) || (i1 == 5) || (i1 == 2) || (i1 == 4)) {}
    label238:
    do
    {
      return;
      if (paramActivity != null)
      {
        this.j = new WeakReference(paramActivity);
        this.k = new WeakReference(paramActivity);
      }
      if (TextUtils.isEmpty(this.e)) {}
      for (paramActivity = Util.getAppId(this.d);; paramActivity = this.e)
      {
        this.f = paramActivity;
        i1 = d();
        HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + i1);
        HuaweiApiAvailability.setServicesVersionCode(i1);
        i1 = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.d, i1);
        HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + i1);
        this.s = HMSPackageManager.getInstance(this.d).getHmsVersionCode();
        if (i1 != 0) {
          break label238;
        }
        c(5);
        if (this.h != null) {
          break;
        }
        g();
        return;
      }
      c(2);
      l();
      i();
      return;
    } while (this.y == null);
    if ((i1 == 1) && (HMSPublishStateHolder.getPublishState() == 0))
    {
      a(i1);
      return;
    }
    b(i1);
  }
  
  public void connectForeground()
  {
    HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50000301 ======");
    int i1 = this.m.get();
    HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i1);
    if ((i1 == 3) || (i1 == 5) || (i1 == 2) || (i1 == 4)) {
      return;
    }
    if (TextUtils.isEmpty(this.e)) {}
    for (String str = Util.getAppId(this.d);; str = this.e)
    {
      this.f = str;
      b();
      return;
    }
  }
  
  public void disableLifeCycleManagement(Activity paramActivity)
  {
    if (this.c >= 0)
    {
      paramActivity = AutoLifecycleFragment.getInstance(paramActivity);
      if (paramActivity == null) {
        return;
      }
      paramActivity.stopAutoManage(this.c);
      return;
    }
    throw new IllegalStateException("disableLifeCycleManagement failed");
  }
  
  public PendingResult<Status> discardAndReconnect()
  {
    return new HuaweiApiClientImpl.d(this, null, null);
  }
  
  public void disconnect()
  {
    int i1 = this.m.get();
    HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i1);
    switch (i1)
    {
    case 1: 
    case 4: 
    default: 
      return;
    case 5: 
      d(2);
      c(4);
      return;
    case 2: 
      c(4);
      return;
    }
    c(4);
    j();
  }
  
  public Map<Api<?>, Api.ApiOptions> getApiMap()
  {
    return this.p;
  }
  
  public List<String> getApiNameList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.p != null)
    {
      Iterator localIterator = this.p.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Api)localIterator.next()).getApiName());
      }
    }
    return localArrayList;
  }
  
  public String getAppID()
  {
    return this.f;
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    if (isConnected())
    {
      this.w = null;
      return new ConnectionResult(0, null);
    }
    if (this.w != null) {
      return this.w;
    }
    return new ConnectionResult(13, null);
  }
  
  public Context getContext()
  {
    return this.d;
  }
  
  public String getCpID()
  {
    return this.g;
  }
  
  public String getPackageName()
  {
    return this.d.getPackageName();
  }
  
  public List<PermissionInfo> getPermissionInfos()
  {
    return this.o;
  }
  
  public List<Scope> getScopes()
  {
    return this.n;
  }
  
  public d getService()
  {
    return this.h;
  }
  
  public String getSessionId()
  {
    return this.i;
  }
  
  public final SubAppInfo getSubAppInfo()
  {
    return this.q;
  }
  
  public Activity getTopActivity()
  {
    if (this.k == null) {
      return null;
    }
    return (Activity)this.k.get();
  }
  
  public String getTransportName()
  {
    return IPCTransport.class.getName();
  }
  
  public boolean hasConnectedApi(Api<?> paramApi)
  {
    return isConnected();
  }
  
  public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Checker.checkNonNull(paramOnConnectionFailedListener, "onConnectionFailedListener should not be null");
    synchronized (this.t)
    {
      return this.y == paramOnConnectionFailedListener;
    }
  }
  
  public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Checker.checkNonNull(paramConnectionCallbacks, "connectionCallbacksListener should not be null");
    synchronized (this.t)
    {
      return this.x == paramConnectionCallbacks;
    }
  }
  
  public ConnectionResult holdUpConnect()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }
    this.u.lock();
    try
    {
      connect(null);
      for (;;)
      {
        boolean bool = isConnecting();
        if (bool) {
          try
          {
            this.v.await();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            localConnectionResult = new ConnectionResult(15, null);
            return localConnectionResult;
          }
        }
      }
      if (isConnected())
      {
        this.w = null;
        localConnectionResult = new ConnectionResult(0, null);
        return localConnectionResult;
      }
      if (this.w != null)
      {
        localConnectionResult = this.w;
        return localConnectionResult;
      }
      ConnectionResult localConnectionResult = new ConnectionResult(13, null);
      return localConnectionResult;
    }
    finally
    {
      this.u.unlock();
    }
  }
  
  public ConnectionResult holdUpConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }
    this.u.lock();
    try
    {
      connect(null);
      paramLong = paramTimeUnit.toNanos(paramLong);
      while (isConnecting())
      {
        if (paramLong <= 0L)
        {
          disconnect();
          paramTimeUnit = new ConnectionResult(14, null);
          return paramTimeUnit;
        }
        try
        {
          paramLong = this.v.awaitNanos(paramLong);
        }
        catch (InterruptedException paramTimeUnit)
        {
          Thread.currentThread().interrupt();
          paramTimeUnit = new ConnectionResult(15, null);
          return paramTimeUnit;
        }
      }
      if (isConnected())
      {
        this.w = null;
        paramTimeUnit = new ConnectionResult(0, null);
        return paramTimeUnit;
      }
      if (this.w != null)
      {
        paramTimeUnit = this.w;
        return paramTimeUnit;
      }
      paramTimeUnit = new ConnectionResult(13, null);
      return paramTimeUnit;
    }
    finally
    {
      this.u.unlock();
    }
  }
  
  public boolean innerIsConnected()
  {
    return (this.m.get() == 3) || (this.m.get() == 4);
  }
  
  public boolean isConnected()
  {
    if (this.s == 0) {
      this.s = HMSPackageManager.getInstance(this.d).getHmsVersionCode();
    }
    if (this.s < 20504000)
    {
      long l1 = System.currentTimeMillis() - this.r;
      if ((l1 > 0L) && (l1 < 300000L)) {
        return innerIsConnected();
      }
      if (innerIsConnected())
      {
        Status localStatus = ((ResolveResult)ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS)).getStatus();
        if (localStatus.isSuccess())
        {
          this.r = System.currentTimeMillis();
          return true;
        }
        int i1 = localStatus.getStatusCode();
        HMSLog.e("HuaweiApiClientImpl", "isConnected is false, statuscode:" + i1);
        if (i1 != 907135004)
        {
          n();
          c(1);
          this.r = System.currentTimeMillis();
        }
      }
      return false;
    }
    return innerIsConnected();
  }
  
  public boolean isConnecting()
  {
    int i1 = this.m.get();
    return (i1 == 2) || (i1 == 5);
  }
  
  public void onPause(Activity paramActivity)
  {
    HMSLog.i("HuaweiApiClientImpl", "onPause");
  }
  
  public void onResume(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      HMSLog.i("HuaweiApiClientImpl", "onResume");
      this.k = new WeakReference(paramActivity);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter onServiceConnected.");
    d(2);
    this.h = d.a.a(paramIBinder);
    if (this.h == null)
    {
      HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
      n();
      c(1);
      if (this.y != null)
      {
        paramIBinder = null;
        paramComponentName = paramIBinder;
        if (this.j != null)
        {
          paramComponentName = paramIBinder;
          if (this.j.get() != null) {
            paramComponentName = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.j.get(), 10);
          }
        }
        paramComponentName = new ConnectionResult(10, paramComponentName);
        this.y.onConnectionFailed(paramComponentName);
        this.w = paramComponentName;
      }
    }
    do
    {
      return;
      if (this.m.get() == 5)
      {
        c(2);
        l();
        i();
        return;
      }
    } while (this.m.get() == 3);
    n();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
    this.h = null;
    c(1);
    if (this.x != null) {
      this.x.onConnectionSuspended(1);
    }
  }
  
  public void print(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public void reconnect()
  {
    disconnect();
    connect(null);
  }
  
  public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Checker.checkNonNull(paramOnConnectionFailedListener, "onConnectionFailedListener should not be null");
    synchronized (this.t)
    {
      if (this.y != paramOnConnectionFailedListener)
      {
        HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
        return;
      }
      this.y = null;
    }
  }
  
  public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Checker.checkNonNull(paramConnectionCallbacks, "connectionCallbacksListener should not be null");
    synchronized (this.t)
    {
      if (this.x != paramConnectionCallbacks)
      {
        HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
        return;
      }
      this.x = null;
    }
  }
  
  public void setApiMap(Map<Api<?>, Api.ApiOptions> paramMap)
  {
    this.p = paramMap;
  }
  
  protected void setAutoLifecycleClientId(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.x = paramConnectionCallbacks;
  }
  
  public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.y = paramOnConnectionFailedListener;
  }
  
  public void setHasShowNotice(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setPermissionInfos(List<PermissionInfo> paramList)
  {
    this.o = paramList;
  }
  
  public void setScopes(List<Scope> paramList)
  {
    this.n = paramList;
  }
  
  public boolean setSubAppInfo(SubAppInfo paramSubAppInfo)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
    if (paramSubAppInfo == null)
    {
      HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
      return false;
    }
    String str2 = paramSubAppInfo.getSubAppID();
    if (TextUtils.isEmpty(str2))
    {
      HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
      return false;
    }
    if (TextUtils.isEmpty(this.e)) {}
    for (String str1 = Util.getAppId(this.d); str2.equals(str1); str1 = this.e)
    {
      HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
      return false;
    }
    this.q = new SubAppInfo(paramSubAppInfo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl
 * JD-Core Version:    0.7.0.1
 */