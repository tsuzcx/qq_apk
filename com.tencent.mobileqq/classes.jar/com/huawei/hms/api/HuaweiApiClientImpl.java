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
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
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
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
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
  private static final Object B = new Object();
  private static final Object C = new Object();
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private CheckUpdateCallBack A;
  private int a = -1;
  private final Context b;
  private final String c;
  private String d;
  private String e;
  private volatile d f;
  private String g;
  private WeakReference<Activity> h;
  private WeakReference<Activity> i;
  private boolean j = false;
  private AtomicInteger k = new AtomicInteger(1);
  private List<Scope> l;
  private List<PermissionInfo> m;
  private Map<Api<?>, Api.ApiOptions> n;
  private SubAppInfo o;
  private long p = 0L;
  private int q = 0;
  private final Object r = new Object();
  private final ReentrantLock s = new ReentrantLock();
  private final Condition t = this.s.newCondition();
  private ConnectionResult u;
  private HuaweiApiClient.ConnectionCallbacks v;
  private HuaweiApiClient.OnConnectionFailedListener w;
  private Handler x = null;
  private Handler y = null;
  private CheckUpdatelistener z = null;
  
  public HuaweiApiClientImpl(Context paramContext)
  {
    this.b = paramContext;
    this.c = Util.getAppId(paramContext);
    this.d = this.c;
    this.e = Util.getCpId(paramContext);
  }
  
  private void a()
  {
    Intent localIntent = new Intent("com.huawei.hms.core.aidlservice");
    HMSPackageManager.getInstance(this.b).refresh();
    localIntent.setPackage(HMSPackageManager.getInstance(this.b).getHMSPackageName());
    synchronized (B)
    {
      if (this.b.bindService(localIntent, this, 1))
      {
        i();
        return;
      }
      c(1);
      HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
      b();
      return;
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 2) {
      synchronized (B)
      {
        if (this.x != null)
        {
          this.x.removeMessages(paramInt);
          this.x = null;
        }
      }
    }
    if (paramInt == 3) {
      synchronized (C)
      {
        if (this.y != null)
        {
          this.y.removeMessages(paramInt);
          this.y = null;
        }
      }
    }
    synchronized (B)
    {
      if (this.x != null)
      {
        this.x.removeMessages(2);
        this.x = null;
      }
      return;
    }
  }
  
  private void a(ResolveResult<ConnectResp> paramResolveResult)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
    if ((this.f != null) && (this.k.get() == 2))
    {
      a(3);
      Object localObject = (ConnectResp)paramResolveResult.getValue();
      if (localObject != null) {
        this.g = ((ConnectResp)localObject).sessionId;
      }
      localObject = this.o;
      ConnectionPostProcessor localConnectionPostProcessor = null;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((SubAppInfo)localObject).getSubAppID();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.d = ((String)localObject);
      }
      int i1 = paramResolveResult.getStatus().getStatusCode();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Enter onConnectionResult, connect to server result: ");
      ((StringBuilder)localObject).append(i1);
      HMSLog.i("HuaweiApiClientImpl", ((StringBuilder)localObject).toString());
      if (Status.SUCCESS.equals(paramResolveResult.getStatus()))
      {
        if (paramResolveResult.getValue() != null) {
          ProtocolNegotiate.getInstance().negotiate(((ConnectResp)paramResolveResult.getValue()).protocolVersion);
        }
        c(3);
        this.u = null;
        paramResolveResult = this.v;
        if (paramResolveResult != null) {
          paramResolveResult.onConnected();
        }
        if (this.h != null) {
          n();
        }
        paramResolveResult = getApiMap().entrySet().iterator();
        while (paramResolveResult.hasNext())
        {
          localObject = (Map.Entry)paramResolveResult.next();
          if ((((Api)((Map.Entry)localObject).getKey()).getmConnetctPostList() != null) && (!((Api)((Map.Entry)localObject).getKey()).getmConnetctPostList().isEmpty()))
          {
            HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
            localObject = ((Api)((Map.Entry)localObject).getKey()).getmConnetctPostList().iterator();
            while (((Iterator)localObject).hasNext())
            {
              localConnectionPostProcessor = (ConnectionPostProcessor)((Iterator)localObject).next();
              HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
              localConnectionPostProcessor.run(this, this.h);
            }
          }
        }
      }
      if ((paramResolveResult.getStatus() != null) && (paramResolveResult.getStatus().getStatusCode() == 1001))
      {
        o();
        c(1);
        paramResolveResult = this.v;
        if (paramResolveResult != null) {
          paramResolveResult.onConnectionSuspended(3);
        }
      }
      else
      {
        o();
        c(1);
        if (this.w != null)
        {
          localObject = this.h;
          paramResolveResult = localConnectionPostProcessor;
          if (localObject != null)
          {
            paramResolveResult = localConnectionPostProcessor;
            if (((WeakReference)localObject).get() != null) {
              paramResolveResult = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.h.get(), i1);
            }
          }
          paramResolveResult = new ConnectionResult(i1, paramResolveResult);
          this.w.onConnectionFailed(paramResolveResult);
          this.u = paramResolveResult;
        }
      }
      return;
    }
    HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
  }
  
  private void b()
  {
    o();
    if (this.w != null)
    {
      int i1;
      if (UIUtil.isBackground(this.b)) {
        i1 = 7;
      } else {
        i1 = 6;
      }
      Object localObject2 = null;
      WeakReference localWeakReference = this.h;
      Object localObject1 = localObject2;
      if (localWeakReference != null)
      {
        localObject1 = localObject2;
        if (localWeakReference.get() != null) {
          localObject1 = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.h.get(), i1);
        }
      }
      localObject1 = new ConnectionResult(i1, (PendingIntent)localObject1);
      this.w.onConnectionFailed((ConnectionResult)localObject1);
      this.u = ((ConnectionResult)localObject1);
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.h;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.h.get(), paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("connect 2.0 fail: ");
      localStringBuilder.append(paramInt);
      HMSLog.i("HuaweiApiClientImpl", localStringBuilder.toString());
    }
    else
    {
      localObject = null;
    }
    localObject = new ConnectionResult(paramInt, (PendingIntent)localObject);
    this.w.onConnectionFailed((ConnectionResult)localObject);
    this.u = ((ConnectionResult)localObject);
  }
  
  private void b(ResolveResult<DisconnectResp> paramResolveResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter onDisconnectionResult, disconnect from server result: ");
    localStringBuilder.append(paramResolveResult.getStatus().getStatusCode());
    HMSLog.i("HuaweiApiClientImpl", localStringBuilder.toString());
    o();
    c(1);
  }
  
  private ConnectInfo c()
  {
    Object localObject2 = new PackageManagerHelper(this.b).getPackageSignature(this.b.getPackageName());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = this.o;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((SubAppInfo)localObject2).getSubAppID();
    }
    return new ConnectInfo(getApiNameList(), this.l, (String)localObject1, (String)localObject2);
  }
  
  private void c(int paramInt)
  {
    this.k.set(paramInt);
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)) {
      this.s.lock();
    }
    try
    {
      this.t.signalAll();
      return;
    }
    finally
    {
      this.s.unlock();
    }
  }
  
  private DisconnectInfo d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((Api)((Iterator)localObject).next()).getApiName());
      }
    }
    return new DisconnectInfo(this.l, localArrayList);
  }
  
  private int e()
  {
    int i1 = Util.getHmsVersion(this.b);
    if ((i1 != 0) && (i1 >= 20503000)) {
      return i1;
    }
    i1 = f();
    if (h())
    {
      i2 = i1;
      if (i1 < 20503000) {
        i2 = 20503000;
      }
      return i2;
    }
    int i2 = i1;
    if (i1 < 20600000) {
      i2 = 20600000;
    }
    return i2;
  }
  
  private int f()
  {
    Object localObject1 = getApiMap();
    int i1 = 0;
    if (localObject1 == null) {
      return 0;
    }
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Api)((Iterator)localObject1).next()).getApiName();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = (Integer)HuaweiApiAvailability.getApiMap().get(localObject2);
        if (localObject2 != null)
        {
          int i2 = ((Integer)localObject2).intValue();
          if (i2 > i1) {
            i1 = i2;
          }
        }
      }
    }
    return i1;
  }
  
  private void g()
  {
    this.A = new HuaweiApiClientImpl.a(this);
  }
  
  private boolean h()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if ("HuaweiGame.API".equals(((Api)((Iterator)localObject).next()).getApiName())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void i()
  {
    Handler localHandler = this.x;
    if (localHandler != null) {
      localHandler.removeMessages(2);
    } else {
      this.x = new Handler(Looper.getMainLooper(), new HuaweiApiClientImpl.b(this));
    }
    this.x.sendEmptyMessageDelayed(2, 5000L);
  }
  
  private void j()
  {
    synchronized (C)
    {
      if (this.y != null) {
        this.y.removeMessages(3);
      } else {
        this.y = new Handler(Looper.getMainLooper(), new HuaweiApiClientImpl.c(this));
      }
      boolean bool = this.y.sendEmptyMessageDelayed(3, 3000L);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : ");
      localStringBuilder.append(bool);
      HMSLog.d("HuaweiApiClientImpl", localStringBuilder.toString());
      return;
    }
  }
  
  private void k()
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
    ConnectService.connect(this, c()).setResultCallback(new HuaweiApiClientImpl.f(this, null));
  }
  
  private void l()
  {
    ConnectService.disconnect(this, d()).setResultCallback(new HuaweiApiClientImpl.g(this, null));
  }
  
  private void m()
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
    ConnectService.forceConnect(this, c()).setResultCallback(new HuaweiApiClientImpl.f(this, null));
  }
  
  private void n()
  {
    if (this.j)
    {
      HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
      return;
    }
    if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.b) == 0) {
      ConnectService.getNotice(this, 0, "5.2.0.300").setResultCallback(new HuaweiApiClientImpl.h(this, null));
    }
  }
  
  private void o()
  {
    Util.unBindServiceCatchException(this.b, this);
    this.f = null;
  }
  
  public int asyncRequest(Bundle paramBundle, String paramString, int paramInt, ResultCallback<BundleResult> paramResultCallback)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
    if ((paramResultCallback != null) && (paramString != null) && (paramBundle != null))
    {
      if (!innerIsConnected())
      {
        HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
        return 907135003;
      }
      paramString = new b(paramString, paramInt);
      e locale = a.a(paramString.c());
      paramString.a(paramBundle);
      paramBundle = new RequestHeader(getAppID(), getPackageName(), 50200300, getSessionId());
      paramBundle.setApiNameList(getApiNameList());
      paramString.b = locale.a(paramBundle, new Bundle());
      try
      {
        getService().a(paramString, new HuaweiApiClientImpl.d(this, paramResultCallback));
        return 0;
      }
      catch (RemoteException paramBundle)
      {
        paramString = new StringBuilder();
        paramString.append("remote exception:");
        paramString.append(paramBundle.getMessage());
        HMSLog.e("HuaweiApiClientImpl", paramString.toString());
        return 907135001;
      }
    }
    HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
    return 907135000;
  }
  
  public void checkUpdate(Activity paramActivity, CheckUpdatelistener paramCheckUpdatelistener)
  {
    if (Util.isAvailableLibExist(this.b))
    {
      HMSLog.i("HuaweiApiClientImpl", "Enter checkUpdate");
      if (paramCheckUpdatelistener == null)
      {
        HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        return;
      }
      if ((paramActivity != null) && (!paramActivity.isFinishing()))
      {
        this.z = paramCheckUpdatelistener;
        if (this.A == null) {
          g();
        }
        UpdateSdkAPI.checkClientOTAUpdate(paramActivity, this.A, true, 0, true);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpdate, activity is illegal: ");
      localStringBuilder.append(paramActivity);
      HMSLog.e("HuaweiApiClientImpl", localStringBuilder.toString());
      paramCheckUpdatelistener.onResult(-1);
      return;
    }
    HMSLog.i("HuaweiApiClientImpl", "available lib does not exist.");
  }
  
  public void connect(int paramInt)
  {
    connect(null);
  }
  
  public void connect(Activity paramActivity)
  {
    HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50200300 ======");
    int i1 = this.k.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter connect, Connection Status: ");
    localStringBuilder.append(i1);
    HMSLog.i("HuaweiApiClientImpl", localStringBuilder.toString());
    if ((i1 != 3) && (i1 != 5) && (i1 != 2))
    {
      if (i1 == 4) {
        return;
      }
      if (paramActivity != null)
      {
        this.h = new WeakReference(paramActivity);
        this.i = new WeakReference(paramActivity);
      }
      if (TextUtils.isEmpty(this.c)) {
        paramActivity = Util.getAppId(this.b);
      } else {
        paramActivity = this.c;
      }
      this.d = paramActivity;
      i1 = e();
      paramActivity = new StringBuilder();
      paramActivity.append("connect minVersion:");
      paramActivity.append(i1);
      HMSLog.i("HuaweiApiClientImpl", paramActivity.toString());
      HuaweiApiAvailability.setServicesVersionCode(i1);
      i1 = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.b, i1);
      paramActivity = new StringBuilder();
      paramActivity.append("In connect, isHuaweiMobileServicesAvailable result: ");
      paramActivity.append(i1);
      HMSLog.i("HuaweiApiClientImpl", paramActivity.toString());
      this.q = HMSPackageManager.getInstance(this.b).getHmsVersionCode();
      if (i1 == 0)
      {
        c(5);
        if (this.f == null)
        {
          a();
          return;
        }
        c(2);
        k();
        j();
        return;
      }
      if (this.w != null) {
        b(i1);
      }
    }
  }
  
  public void connectForeground()
  {
    HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50200300 ======");
    int i1 = this.k.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter forceConnect, Connection Status: ");
    ((StringBuilder)localObject).append(i1);
    HMSLog.i("HuaweiApiClientImpl", ((StringBuilder)localObject).toString());
    if ((i1 != 3) && (i1 != 5) && (i1 != 2))
    {
      if (i1 == 4) {
        return;
      }
      if (TextUtils.isEmpty(this.c)) {
        localObject = Util.getAppId(this.b);
      } else {
        localObject = this.c;
      }
      this.d = ((String)localObject);
      m();
    }
  }
  
  public void disableLifeCycleManagement(Activity paramActivity)
  {
    if (this.a >= 0)
    {
      paramActivity = AutoLifecycleFragment.getInstance(paramActivity);
      if (paramActivity == null) {
        return;
      }
      paramActivity.stopAutoManage(this.a);
      return;
    }
    throw new IllegalStateException("disableLifeCycleManagement failed");
  }
  
  public PendingResult<Status> discardAndReconnect()
  {
    return new HuaweiApiClientImpl.e(this, null, null);
  }
  
  public void disconnect()
  {
    int i1 = this.k.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter disconnect, Connection Status: ");
    localStringBuilder.append(i1);
    HMSLog.i("HuaweiApiClientImpl", localStringBuilder.toString());
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return;
            }
            a(2);
            c(4);
          }
        }
        else
        {
          c(4);
          l();
        }
      }
      else {
        c(4);
      }
    }
  }
  
  public Map<Api<?>, Api.ApiOptions> getApiMap()
  {
    return this.n;
  }
  
  public List<String> getApiNameList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((Api)((Iterator)localObject).next()).getApiName());
      }
    }
    return localArrayList;
  }
  
  public String getAppID()
  {
    return this.d;
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    if (isConnected())
    {
      this.u = null;
      return new ConnectionResult(0, null);
    }
    paramApi = this.u;
    if (paramApi != null) {
      return paramApi;
    }
    return new ConnectionResult(13, null);
  }
  
  public Context getContext()
  {
    return this.b;
  }
  
  public String getCpID()
  {
    return this.e;
  }
  
  public String getPackageName()
  {
    return this.b.getPackageName();
  }
  
  public List<PermissionInfo> getPermissionInfos()
  {
    return this.m;
  }
  
  public List<Scope> getScopes()
  {
    return this.l;
  }
  
  public d getService()
  {
    return this.f;
  }
  
  public String getSessionId()
  {
    return this.g;
  }
  
  public final SubAppInfo getSubAppInfo()
  {
    return this.o;
  }
  
  public Activity getTopActivity()
  {
    WeakReference localWeakReference = this.i;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
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
    synchronized (this.r)
    {
      return this.w == paramOnConnectionFailedListener;
    }
  }
  
  public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Checker.checkNonNull(paramConnectionCallbacks, "connectionCallbacksListener should not be null");
    synchronized (this.r)
    {
      return this.v == paramConnectionCallbacks;
    }
  }
  
  public ConnectionResult holdUpConnect()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.s.lock();
    }
    for (;;)
    {
      try
      {
        connect(null);
        boolean bool = isConnecting();
        if (!bool) {}
      }
      finally
      {
        ConnectionResult localConnectionResult;
        this.s.unlock();
      }
      try
      {
        this.t.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        IllegalStateException localIllegalStateException;
      }
    }
    Thread.currentThread().interrupt();
    localConnectionResult = new ConnectionResult(15, null);
    this.s.unlock();
    return localConnectionResult;
    if (isConnected())
    {
      this.u = null;
      localConnectionResult = new ConnectionResult(0, null);
      this.s.unlock();
      return localConnectionResult;
    }
    if (this.u != null)
    {
      localConnectionResult = this.u;
      this.s.unlock();
      return localConnectionResult;
    }
    localConnectionResult = new ConnectionResult(13, null);
    this.s.unlock();
    return localConnectionResult;
    localIllegalStateException = new IllegalStateException("blockingConnect must not be called on the UI thread");
    for (;;)
    {
      throw localIllegalStateException;
    }
  }
  
  public ConnectionResult holdUpConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.s.lock();
    }
    for (;;)
    {
      try
      {
        connect(null);
        paramLong = paramTimeUnit.toNanos(paramLong);
        if (isConnecting()) {
          if (paramLong <= 0L)
          {
            disconnect();
            paramTimeUnit = new ConnectionResult(14, null);
            return paramTimeUnit;
          }
        }
      }
      finally
      {
        this.s.unlock();
      }
      try
      {
        paramLong = this.t.awaitNanos(paramLong);
      }
      catch (InterruptedException paramTimeUnit) {}
    }
    Thread.currentThread().interrupt();
    paramTimeUnit = new ConnectionResult(15, null);
    this.s.unlock();
    return paramTimeUnit;
    if (isConnected())
    {
      this.u = null;
      paramTimeUnit = new ConnectionResult(0, null);
      this.s.unlock();
      return paramTimeUnit;
    }
    if (this.u != null)
    {
      paramTimeUnit = this.u;
      this.s.unlock();
      return paramTimeUnit;
    }
    paramTimeUnit = new ConnectionResult(13, null);
    this.s.unlock();
    return paramTimeUnit;
    paramTimeUnit = new IllegalStateException("blockingConnect must not be called on the UI thread");
    for (;;)
    {
      throw paramTimeUnit;
    }
  }
  
  public boolean innerIsConnected()
  {
    return (this.k.get() == 3) || (this.k.get() == 4);
  }
  
  public boolean isConnected()
  {
    if (this.q == 0) {
      this.q = HMSPackageManager.getInstance(this.b).getHmsVersionCode();
    }
    if (this.q < 20504000)
    {
      long l1 = System.currentTimeMillis() - this.p;
      if ((l1 > 0L) && (l1 < 300000L)) {
        return innerIsConnected();
      }
      if (innerIsConnected())
      {
        Object localObject = ((ResolveResult)ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS)).getStatus();
        if (((Status)localObject).isSuccess())
        {
          this.p = System.currentTimeMillis();
          return true;
        }
        int i1 = ((Status)localObject).getStatusCode();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isConnected is false, statuscode:");
        ((StringBuilder)localObject).append(i1);
        HMSLog.i("HuaweiApiClientImpl", ((StringBuilder)localObject).toString());
        if (i1 != 907135004)
        {
          o();
          c(1);
          this.p = System.currentTimeMillis();
        }
      }
      return false;
    }
    return innerIsConnected();
  }
  
  public boolean isConnecting()
  {
    int i1 = this.k.get();
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
      this.i = new WeakReference(paramActivity);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter onServiceConnected.");
    a(2);
    this.f = d.a.a(paramIBinder);
    if (this.f == null)
    {
      HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
      o();
      c(1);
      if (this.w != null)
      {
        paramIBinder = null;
        WeakReference localWeakReference = this.h;
        paramComponentName = paramIBinder;
        if (localWeakReference != null)
        {
          paramComponentName = paramIBinder;
          if (localWeakReference.get() != null) {
            paramComponentName = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity)this.h.get(), 10);
          }
        }
        paramComponentName = new ConnectionResult(10, paramComponentName);
        this.w.onConnectionFailed(paramComponentName);
        this.u = paramComponentName;
      }
      return;
    }
    if (this.k.get() == 5)
    {
      c(2);
      k();
      j();
      return;
    }
    if (this.k.get() != 3) {
      o();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
    this.f = null;
    c(1);
    paramComponentName = this.v;
    if (paramComponentName != null) {
      paramComponentName.onConnectionSuspended(1);
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
    synchronized (this.r)
    {
      if (this.w != paramOnConnectionFailedListener) {
        HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
      } else {
        this.w = null;
      }
      return;
    }
  }
  
  public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Checker.checkNonNull(paramConnectionCallbacks, "connectionCallbacksListener should not be null");
    synchronized (this.r)
    {
      if (this.v != paramConnectionCallbacks) {
        HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
      } else {
        this.v = null;
      }
      return;
    }
  }
  
  public void setApiMap(Map<Api<?>, Api.ApiOptions> paramMap)
  {
    this.n = paramMap;
  }
  
  protected void setAutoLifecycleClientId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.v = paramConnectionCallbacks;
  }
  
  public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.w = paramOnConnectionFailedListener;
  }
  
  public void setHasShowNotice(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setPermissionInfos(List<PermissionInfo> paramList)
  {
    this.m = paramList;
  }
  
  public void setScopes(List<Scope> paramList)
  {
    this.l = paramList;
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
    String str1;
    if (TextUtils.isEmpty(this.c)) {
      str1 = Util.getAppId(this.b);
    } else {
      str1 = this.c;
    }
    if (str2.equals(str1))
    {
      HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
      return false;
    }
    this.o = new SubAppInfo(paramSubAppInfo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl
 * JD-Core Version:    0.7.0.1
 */