package com.tencent.mobileqq.ar.arengine;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ArCloudNativeSoLoader;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class ARCloudControl
{
  private static final Object F = new Object();
  private static boolean W = false;
  private static boolean X = false;
  int A = -1;
  long B = 0L;
  SosoInterfaceOnLocationListener C = new ARCloudControl.7(this, 0, true, true, 3000L, true, false, "QQARScan");
  ArLBSActivity D;
  private HandlerThread E = null;
  private Handler G = null;
  private boolean H = true;
  private volatile boolean I = false;
  private boolean J = false;
  private boolean K = true;
  private ARCloudControl.ARCloudControlCallback L = null;
  private boolean M = true;
  private boolean N;
  private boolean O;
  private boolean P;
  private long Q;
  private long R;
  private ArrayList<String> S;
  private boolean T;
  private boolean U = true;
  private ARCloudRecogResult V = null;
  private byte[] Y;
  private boolean Z;
  ARCloudImageSelect a;
  private long aa;
  ARCloudPretreatmentManager b;
  ARCloudFileUpload c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j = 10000;
  long k;
  AppInterface l;
  Activity m;
  ARCommonConfigInfo n;
  long o;
  long p;
  long q;
  long r;
  long s;
  int t;
  long u;
  long v;
  long w;
  String x;
  int y;
  long z;
  
  private void a(int paramInt, ARCloudRecogResult paramARCloudRecogResult)
  {
    QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation.");
    this.V = paramARCloudRecogResult;
    Object localObject = this.G;
    if (localObject != null)
    {
      if (((Handler)localObject).hasMessages(2)) {
        this.G.removeMessages(2);
      }
      localObject = Message.obtain(this.G, new ARCloudControl.8(this));
      ((Message)localObject).what = 2;
      this.G.sendMessageDelayed((Message)localObject, this.j);
    }
    this.D = ARCloudRecogResult.c(this.n.recognitions, paramARCloudRecogResult);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (((BaseActivity)this.m).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. not grant");
        ((BaseActivity)this.m).requestPermissions(new ARCloudControl.9(this), 1, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. grant");
      grant();
      return;
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.C);
  }
  
  private void a(ARCloudReqInfo paramARCloudReqInfo)
  {
    QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] requestToUploadImg. : ");
    long l1 = System.currentTimeMillis();
    if (this.c != null)
    {
      this.K = true;
      this.t += 1;
      synchronized (F)
      {
        if (this.G != null)
        {
          if (this.G.hasMessages(1)) {
            this.G.removeMessages(1);
          }
          Message localMessage = Message.obtain(this.G, new ARCloudControl.5(this));
          localMessage.what = 1;
          this.G.sendMessageDelayed(localMessage, this.j);
        }
        this.c.a(paramARCloudReqInfo, new ARCloudControl.6(this, l1, paramARCloudReqInfo));
        return;
      }
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }
  
  private void a(Runnable paramRunnable, long paramLong)
  {
    synchronized (F)
    {
      if (this.G != null) {
        this.G.postDelayed(paramRunnable, paramLong);
      }
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocationInternal.");
    System.currentTimeMillis();
    if (this.c != null)
    {
      this.U = true;
      Object localObject = this.G;
      if (localObject != null)
      {
        if (((Handler)localObject).hasMessages(2)) {
          this.G.removeMessages(2);
        }
        localObject = Message.obtain(this.G, new ARCloudControl.10(this));
        ((Message)localObject).what = 2;
        this.G.sendMessageDelayed((Message)localObject, this.j);
      }
      this.c.a(paramString, paramInt1, paramInt2, new ARCloudControl.11(this));
    }
  }
  
  private void a(byte[] paramArrayOfByte, ArrayList<ARRecognition> paramArrayList)
  {
    if (this.b != null)
    {
      ARCloudReqInfo localARCloudReqInfo = new ARCloudReqInfo();
      this.b.a(paramArrayOfByte, paramArrayList, new ARCloudControl.4(this, localARCloudReqInfo), this.e, this.f, this.d);
    }
  }
  
  public static boolean a()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("loadNativeLibrary");
          localStringBuilder1.append(X);
          localStringBuilder1.append(", loadSoSuccess=");
          localStringBuilder1.append(W);
          QLog.d("AREngine_ARCloudControl", 2, localStringBuilder1.toString());
        }
        if (X)
        {
          bool = W;
          return bool;
        }
        if (ArCloudNativeSoLoader.a(ArCloudNativeSoLoader.a()))
        {
          X = true;
          try
          {
            if (ArCloudNativeSoLoader.b(ArCloudNativeSoLoader.a()) != 0) {
              break label190;
            }
            bool = true;
            W = bool;
          }
          catch (Throwable localThrowable)
          {
            W = false;
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("load ARCloud so failed. err msg = ");
            localStringBuilder2.append(localThrowable.getMessage());
            QLog.i("AREngine_ARCloudControl", 1, localStringBuilder2.toString());
          }
          QLog.d("AREngine_ARCloudControl", 1, "loadArNativeSo");
          bool = W;
          return bool;
        }
        else
        {
          QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. ARCloud so is not exist!");
          bool = W;
          return bool;
        }
      }
      finally {}
      label190:
      boolean bool = false;
    }
  }
  
  public static void b()
  {
    Object localObject2 = BaseApplicationImpl.sApplication;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject2).getApplicationInfo().nativeLibraryDir);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject2).getApplicationInfo().dataDir);
      ((StringBuilder)localObject1).append("/lib/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("libARCloud.so");
    Object localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject2).getFilesDir());
    localStringBuilder.append("libARCloud.so");
    localObject2 = localStringBuilder.toString();
    if (!new File((String)localObject1).exists()) {
      if (new File((String)localObject2).exists()) {
        localObject1 = localObject2;
      } else {
        localObject1 = "";
      }
    }
    if (!((String)localObject1).equals("")) {
      try
      {
        System.load((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("load ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" successfully!");
        QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject2).toString());
        W = true;
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" failed! ");
        localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
        QLog.i("AREngine_ARCloudControl", 1, localStringBuilder.toString());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("AREngine_ARCloudControl", 2, "loadSo suc");
    }
    W = false;
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    QLog.i("AREngine_ARCloudControl", 1, "saveTmpPreviewData should nerver be called ");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      byte[] arrayOfByte = this.Y;
      if ((arrayOfByte == null) || (arrayOfByte.length != paramArrayOfByte.length)) {
        this.Y = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.Y, 0, paramArrayOfByte.length);
      this.Z = true;
      if (this.aa <= 0L) {
        this.aa = System.currentTimeMillis();
      }
    }
  }
  
  private void k()
  {
    QLog.i("AREngine_ARCloudControl", 1, "startUploadThread.");
    synchronized (F)
    {
      if (this.E == null)
      {
        this.E = ThreadManager.newFreeHandlerThread("ARCloudEnginePreprocessThread", 0);
        this.E.start();
        this.G = new Handler(this.E.getLooper());
      }
      return;
    }
  }
  
  private void l()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stopUploadThread.");
    synchronized (F)
    {
      if (this.G != null) {
        this.G.removeCallbacksAndMessages(null);
      }
      this.G = null;
      if (this.E != null)
      {
        this.E.quit();
        this.E.interrupt();
      }
      this.E = null;
      return;
    }
  }
  
  private void m()
  {
    this.Y = null;
    this.Z = false;
    this.aa = 0L;
  }
  
  private void n()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stopUploadingImg.");
    ARCloudFileUpload localARCloudFileUpload = this.c;
    if (localARCloudFileUpload != null) {
      localARCloudFileUpload.c();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.d = paramInt3;
  }
  
  public void a(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.B == 0L) {
      this.B = System.currentTimeMillis();
    }
    long l1;
    boolean bool1;
    Object localObject;
    if ((this.I) && (this.a != null))
    {
      l1 = System.currentTimeMillis();
      bool1 = this.a.a(paramArrayOfByte);
      this.I = false;
      this.L.c(bool1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSameSceneWithBestImg = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" cost time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      ((StringBuilder)localObject).append("ms");
      QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject).toString());
    }
    if (this.H)
    {
      if (this.a == null) {
        return;
      }
      if (this.M)
      {
        QLog.i("AREngine_ARCloudControl", 1, "selectImage start");
        QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "firstTimeStart" }));
        this.M = false;
        if (this.Q == 0L) {
          this.Q = System.currentTimeMillis();
        }
        if (this.T) {
          ThreadManager.getUIHandler().post(new ARCloudControl.1(this));
        }
      }
      localObject = this.L;
      if (localObject != null) {
        ((ARCloudControl.ARCloudControlCallback)localObject).b();
      }
      this.p = System.currentTimeMillis();
      boolean bool2 = this.a.a(paramArrayOfByte, this.e, this.f);
      if ((bool2) && (this.R == 0L)) {
        this.R = System.currentTimeMillis();
      }
      localObject = this.L;
      int i1;
      if (localObject != null)
      {
        bool1 = ((ARCloudControl.ARCloudControlCallback)localObject).d();
        l1 = this.L.e();
        if ((bool2) && (!this.Z) && (bool1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudControl", 2, "selectImage save tmp preview data");
          }
          b(paramArrayOfByte);
        }
        for (;;)
        {
          bool1 = false;
          break label476;
          if ((!bool2) || (!this.Z) || (System.currentTimeMillis() >= this.aa + l1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudControl", 2, "selectImage update tmp preview data");
          }
          b(paramArrayOfByte);
        }
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (this.Z)
          {
            bool1 = bool2;
            if (System.currentTimeMillis() >= this.aa + l1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARCloudControl", 2, "selectImage use tmp preview data");
              }
              paramArrayOfByte = this.Y;
              m();
              bool1 = true;
              i1 = 1;
              break label478;
            }
          }
        }
        label476:
        i1 = 0;
        label478:
        this.L.a(bool1);
      }
      else
      {
        i1 = 0;
        bool1 = bool2;
      }
      if (!bool1)
      {
        this.H = true;
        return;
      }
      this.q = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format("selectImage total time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.o) }));
      ((StringBuilder)localObject).append(":select result is ");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject).toString());
      this.s = (System.currentTimeMillis() - this.B);
      this.H = false;
      if (this.T) {
        ThreadManager.getUIHandler().post(new ARCloudControl.2(this));
      }
      if (i1 == 0) {
        paramArrayOfByte = this.a.a();
      }
      localObject = this.L;
      if (localObject != null) {
        ((ARCloudControl.ARCloudControlCallback)localObject).b(true);
      }
      if (!this.N)
      {
        localObject = this.L;
        if (localObject != null)
        {
          l1 = ((ARCloudControl.ARCloudControlCallback)localObject).f();
          ScanEntranceReport.a().a(l1, this.Q, this.R, this.a.d);
          ARDebugReport.a().a(l1, this.R);
          this.N = true;
        }
      }
      a(new ARCloudControl.3(this, paramArrayOfByte));
    }
  }
  
  public boolean a(ARCloudControl.ARCloudControlCallback paramARCloudControlCallback, AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, ARCommonConfigInfo paramARCommonConfigInfo)
  {
    long l2 = System.currentTimeMillis();
    W = a();
    ARReport.a().b(System.currentTimeMillis() - l2, W);
    if (!W) {
      return false;
    }
    this.a = new ARCloudImageSelect(ARCloudImageSelect.b);
    this.b = new ARCloudPretreatmentManager();
    this.a.a(BaseApplicationImpl.getContext().getApplicationContext());
    this.b.a();
    this.l = paramAppInterface;
    this.m = paramActivity;
    this.h = paramInt1;
    this.g = paramInt2;
    this.i = paramInt3;
    this.L = paramARCloudControlCallback;
    this.c = new ARCloudFileUpload(paramAppInterface, true);
    this.c.b();
    this.n = paramARCommonConfigInfo;
    paramARCloudControlCallback = this.n;
    long l1;
    if (paramARCloudControlCallback != null) {
      l1 = ARRecognition.a(paramARCloudControlCallback.recognitions);
    } else {
      l1 = 0L;
    }
    this.k = l1;
    this.M = true;
    if (this.S == null) {
      this.S = new ArrayList();
    }
    this.S.clear();
    ARReport.a().c(System.currentTimeMillis() - l2, W);
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void c()
  {
    this.H = true;
    this.M = true;
    this.J = false;
    this.o = System.currentTimeMillis();
    k();
    m();
  }
  
  public void d()
  {
    if (!this.J) {
      return;
    }
    h();
    this.o = System.currentTimeMillis();
    this.H = true;
    QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "resume" }));
    this.M = true;
    this.J = false;
    k();
    m();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user denied = ");
    this.V = null;
  }
  
  public void e()
  {
    if (this.J) {
      return;
    }
    this.r = System.currentTimeMillis();
    i();
    this.J = true;
    this.H = false;
    l();
    n();
  }
  
  public void f()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stop.");
    this.J = true;
    this.H = false;
    l();
    n();
  }
  
  public void g()
  {
    QLog.i("AREngine_ARCloudControl", 1, "uninit");
    Object localObject = this.a;
    if (localObject != null)
    {
      ((ARCloudImageSelect)localObject).b();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((ARCloudPretreatmentManager)localObject).b();
      this.b = null;
    }
    this.L = null;
    localObject = this.S;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.S.clear();
    }
    this.S = null;
    this.V = null;
    localObject = this.c;
    if (localObject != null) {
      ((ARCloudFileUpload)localObject).d();
    }
    this.m = null;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user grant = ");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.C);
  }
  
  public void h()
  {
    this.o = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0;
    this.u = 0L;
    this.v = 0L;
    this.w = 0L;
    this.x = null;
    this.y = 0;
    this.A = -1;
    this.p = 0L;
    this.q = 0L;
    this.B = 0L;
  }
  
  public void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arCloudReport mResult:");
    localStringBuilder.append(this.A);
    QLog.d("AREngine_ARCloudControl", 2, localStringBuilder.toString());
    ARReport.a().a(this.s, this.u, this.v, this.t, this.x, this.y, this.w, this.z, this.r - this.o, this.A);
  }
  
  public ArrayList<String> j()
  {
    return this.S;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl
 * JD-Core Version:    0.7.0.1
 */