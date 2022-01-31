package c.t.m.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentDistanceAnalysis;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentPedestrianData;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import org.eclipse.jdt.annotation.Nullable;

public final class do
{
  private static SparseArray<String> a;
  private double A = 0.0D;
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private TencentLocation E;
  private TencentDistanceListener F;
  private boolean G = false;
  private final Object H = new Object();
  private final TencentLocationRequest I = TencentLocationRequest.create();
  private em J;
  private double K;
  private double L;
  private em M;
  private int N = 404;
  private final boolean O;
  private boolean P;
  private long Q;
  private long R;
  private long S;
  private String T;
  private boolean U;
  private int b = 1;
  private a c;
  private final f d;
  private final dr e;
  private final boolean f;
  private final dn g;
  private final dw h;
  private final dl i;
  private final dp j;
  private final dq k;
  private final du l;
  private ci m;
  private volatile boolean n = false;
  private HandlerThread o;
  private int p = 0;
  private dv q;
  private final dc r;
  private ea s;
  private ee t;
  private eb u;
  private ec v;
  private final da w;
  private TencentLocationListener x;
  private String y = "stop";
  private boolean z = false;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    a = localSparseArray;
    localSparseArray.put(0, "OK");
    a.put(1, "ERROR_NETWORK");
    a.put(2, "BAD_JSON");
    a.put(4, "DEFLECT_FAILED");
    a.put(5, "VERIFYKEY_ERROR_NETWORK");
    cx.a(f.a.d());
  }
  
  public do(da paramda)
  {
    this.w = paramda;
    paramda.i();
    this.r = dd.b();
    this.k = new dq(this.w);
    this.l = new du(this.w);
    this.q = new dv();
    this.i = dl.a(paramda.a);
    this.j = dp.b();
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      if (this.f)
      {
        this.d = null;
        this.h = m();
        if (!this.w.f()) {
          f.a.b("TxLocationManagerImpl", "createNewCellProvider: failed");
        }
        for (paramda = null;; paramda = new dr(this.w))
        {
          this.e = paramda;
          localdn = l();
          this.g = localdn;
          this.O = f.a.a(paramda, new Object[] { localdn });
          this.w.a(this);
          try
          {
            cx.a(this.w.a, "txsdk", this.w.i().d());
            cx.a().a((cw)this.w.m());
            return;
          }
          catch (Throwable paramda)
          {
            return;
          }
        }
      }
      else
      {
        this.e = null;
        this.h = m();
        if (!this.w.f()) {
          f.a.b("TxLocationManagerImpl", "createCellProvider: failed");
        }
        for (paramda = localdn;; paramda = new f(this.w))
        {
          this.d = paramda;
          localdn = l();
          this.g = localdn;
          this.O = f.a.a(paramda, new Object[] { localdn });
          break;
        }
      }
    }
  }
  
  private static String a(String paramString)
  {
    int i1 = 1;
    if (paramString.contains(",")) {}
    try
    {
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length <= 1) || (paramString[0] == null) || (paramString[1] == null) || (e.w(paramString[0], paramString[1]) <= 0)) {
        break label86;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return null;
    }
    i1 = e.v(paramString);
    if (i1 >= 0) {
      return Integer.toString(i1);
    }
    return "";
    while (i1 != 0)
    {
      return paramString[0];
      label86:
      i1 = 0;
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str1 = null;
    switch (paramInt1)
    {
    }
    for (Object localObject3 = null;; localObject3 = ???)
    {
      for (;;)
      {
        f.a.a("TxLocationManagerImpl", "onStatusChanged: " + str1);
        synchronized (this.H)
        {
          if (this.x != null) {
            this.x.onStatusUpdate((String)localObject3, paramInt2, str1);
          }
          return;
          localObject3 = "gps";
          switch (paramInt2)
          {
          default: 
            str1 = "unknown";
            break;
          case 1: 
            str1 = "gps enabled";
            break;
          case 0: 
            str1 = "gps disabled";
            continue;
            localObject3 = "gps";
            switch (paramInt2)
            {
            default: 
              str1 = "unknown";
              break;
            case 3: 
              str1 = "gps available";
              break;
            case 4: 
              str1 = "gps unavailable";
              continue;
              ??? = "cell";
              if (paramInt2 == 1) {
                str1 = "cell enabled";
              }
              for (;;)
              {
                localObject3 = str1;
                if (!en.a) {
                  break label358;
                }
                str1 = "location permission denied";
                paramInt2 = 2;
                localObject3 = "cell";
                break;
                if (paramInt2 == 0) {
                  str1 = "cell disabled";
                } else {
                  str1 = "unknown";
                }
              }
              String str2 = "wifi";
              switch (paramInt2)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                str1 = "unknown";
              case 0: 
              case 1: 
                for (;;)
                {
                  localObject3 = str1;
                  ??? = str2;
                  if (paramInt2 == 5) {
                    break label358;
                  }
                  localObject3 = str1;
                  ??? = str2;
                  if (!es.a) {
                    break label358;
                  }
                  str1 = "location permission denied";
                  paramInt2 = 2;
                  localObject3 = "wifi";
                  break;
                  str1 = "wifi disabled";
                  continue;
                  str1 = "wifi enabled";
                }
              }
              str1 = "location service switch is off";
            }
            break;
          }
        }
      }
      label358:
      Object localObject2 = localObject3;
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.c != null)
    {
      this.c.removeMessages(paramInt);
      this.c.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, em paramem)
  {
    int i2 = 0;
    if (paramem == null) {
      return;
    }
    if ((paramInt == 0) && (paramem.getLatitude() != 0.0D) && (paramem.getLongitude() != 0.0D)) {
      if ((this.b != 1) || (!eo.a(paramem.getLatitude(), paramem.getLongitude()))) {
        break label755;
      }
    }
    label749:
    label755:
    for (int i1 = 1;; i1 = 0)
    {
      em.a(paramem, i1);
      if (q()) {
        if ((this.N == 0) || (paramInt != 0)) {
          break label749;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        this.N = paramInt;
        this.J = paramem;
        if ((paramem.getAccuracy() < 500.0F) && (paramem.getAccuracy() > 0.0F))
        {
          this.q.a(paramem);
          if (this.z) {
            this.E = paramem;
          }
        }
        this.K = paramem.getLatitude();
        this.L = paramem.getLongitude();
        if ((f.a.b(this.x)) && (this.I.getInterval() > 0L) && (!this.I.getExtras().getBoolean("daemon")))
        {
          a(11999, this.I.getInterval());
          if (this.I.getCheckInterval() != -1L) {
            a(3998, this.I.getCheckInterval());
          }
        }
        if (i1 != 0) {
          b(11998);
        }
        for (;;)
        {
          i1 = i2;
          if (this.N != 0)
          {
            i1 = i2;
            if (paramInt == 0) {
              i1 = 1;
            }
          }
          i2 = i1;
          if (this.N == 0)
          {
            i2 = i1;
            if (this.J != null)
            {
              i2 = i1;
              if (this.J.getProvider().equals("network"))
              {
                i2 = i1;
                if (paramInt == 0)
                {
                  i2 = i1;
                  if (paramem != null)
                  {
                    i2 = i1;
                    if (paramem.getProvider().equals("gps")) {
                      i2 = 1;
                    }
                  }
                }
              }
            }
          }
          this.N = paramInt;
          this.J = paramem;
          f.a.b("TxLocationManagerImpl", "updateLast" + paramem.getLatitude() + "," + paramem.getLongitude());
          if ((this.I.getInterval() == 0L) && (f.a.b(this.x))) {
            b(11998);
          }
          if ((i2 == 0) || (!f.a.b(this.x))) {
            break;
          }
          b(11998);
          return;
          if ((paramInt == 0) && (paramem.getLatitude() != 0.0D) && (paramem.getLongitude() != 0.0D) && (Math.abs(paramem.getLatitude() - this.K) >= 1.0E-007D) && (Math.abs(paramem.getLongitude() - this.L) >= 1.0E-007D))
          {
            if (!this.q.a(paramem, this.w))
            {
              f.a.a("TxLocationManagerImpl", "discard " + paramem);
              return;
            }
            this.K = paramem.getLatitude();
            this.L = paramem.getLongitude();
            if ((paramem.getAccuracy() < 500.0F) && (paramem.getAccuracy() > 0.0F))
            {
              this.q.a(paramem);
              this.q.a(paramem);
              if (this.z) {
                if (this.E != null)
                {
                  double d1 = f.a.a(this.E.getLatitude(), this.E.getLongitude(), paramem.getLatitude(), paramem.getLongitude());
                  if (((paramem.getProvider().equalsIgnoreCase("network")) && (d1 > 10.0D)) || ((paramem.getProvider().equalsIgnoreCase("gps")) && (d1 > 3.0D)))
                  {
                    this.A = (d1 + this.A);
                    if (paramem.getProvider().equalsIgnoreCase("network")) {
                      this.C += 1;
                    }
                    for (;;)
                    {
                      this.D += 1;
                      this.E = paramem;
                      break;
                      this.B += 1;
                    }
                  }
                }
                else
                {
                  this.E = paramem;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private final void a(em paramem)
  {
    if (paramem != null) {}
    try
    {
      if (this.I.isAllowDirection()) {
        paramem.getExtra().putDouble("direction", this.i.d());
      }
      paramem.getExtra().putString("motion", this.j.e());
      paramem.getExtra().putAll(this.I.getExtras());
      return;
    }
    catch (Throwable paramem) {}
  }
  
  private void b(int paramInt)
  {
    if (this.c != null)
    {
      this.c.sendEmptyMessage(paramInt);
      return;
    }
    f.a.b("TxLocationManagerImpl", "mHandler is null");
  }
  
  @Nullable
  private dn l()
  {
    if (!this.w.h())
    {
      f.a.b("TxLocationManagerImpl", "createGpsProvider: failed");
      return null;
    }
    return new dn(this.w);
  }
  
  @Nullable
  private dw m()
  {
    if (!this.w.g())
    {
      f.a.b("TxLocationManagerImpl", "createWifiProvider: failed");
      return null;
    }
    return new dw(this.w);
  }
  
  private cj n()
  {
    try
    {
      Object localObject = this.w.i();
      localObject = new cj(((db)localObject).j, ((db)localObject).d(), ((db)localObject).f());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      f.a.a("TxLocationManagerImpl", "getAppInfo error.", localThrowable);
    }
    return new cj("unknown", "unknown", "unknown");
  }
  
  private void o()
  {
    en.a = false;
    this.k.a();
    du localdu = this.l;
    if (localdu.g)
    {
      localdu.g = false;
      localdu.a.clear();
      localdu.a.offer(du.a.d);
      if (localdu.f != 0L)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = localdu.f;
        f.a.a("TxRequestSender", String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[] { Long.valueOf((l1 - l2) / 1000L), Long.valueOf(localdu.d), Long.valueOf(localdu.e), Long.valueOf(localdu.c) }));
      }
      localdu.c = 0L;
      localdu.d = 0L;
      localdu.e = 0L;
      localdu.f = 0L;
    }
    this.q.a();
    if (f.a.b(this.h)) {
      this.h.a();
    }
    if (this.f) {
      if (f.a.b(this.e)) {
        this.e.a();
      }
    }
    for (;;)
    {
      if (f.a.b(this.g)) {
        this.g.a();
      }
      if ((this.I.isAllowDirection()) && (!this.i.a())) {
        this.i.c();
      }
      if ((!this.I.getExtras().getBoolean("daemon")) && (f.a.b(this.j))) {
        this.j.c();
      }
      if (this.n)
      {
        cx.a().c();
        this.n = false;
      }
      if (this.m != null) {
        this.m.a();
      }
      return;
      if (f.a.b(this.d)) {
        this.d.b();
      }
    }
  }
  
  private void p()
  {
    this.J = null;
    this.N = 404;
    this.t = null;
    this.s = null;
    this.u = null;
    this.G = false;
    this.U = false;
    ec.a = 0;
    this.w.a("cell").a();
  }
  
  private boolean q()
  {
    return this.N == 404;
  }
  
  private boolean r()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.g != null)
    {
      bool1 = bool2;
      if (this.g.c())
      {
        bool1 = bool2;
        if (this.g.b()) {
          bool1 = true;
        }
      }
    }
    if (!bool1) {
      f.a.b("TxLocationManagerImpl", "isGpsValid: provider=false");
    }
    return bool1;
  }
  
  public final int a(TencentDirectionListener paramTencentDirectionListener, Looper paramLooper)
  {
    int i1;
    if ((paramTencentDirectionListener == null) || (paramLooper == null)) {
      i1 = -1;
    }
    int i2;
    do
    {
      return i1;
      if (this.i == null) {
        return -2;
      }
      this.i.c();
      paramLooper = new Handler(paramLooper);
      i2 = this.i.a(paramLooper, paramTencentDirectionListener);
      i1 = i2;
    } while (i2 != 0);
    this.i.b();
    return i2;
  }
  
  public final int a(TencentDistanceListener paramTencentDistanceListener)
  {
    if (this.x == null) {
      return 1;
    }
    if (this.z) {
      return 2;
    }
    this.z = true;
    this.F = paramTencentDistanceListener;
    return 0;
  }
  
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (this.p == 1)
    {
      h();
      if (this.o != null)
      {
        this.o.quit();
        this.o = null;
      }
      this.p = 0;
    }
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {}
    Object localObject1;
    try
    {
      System.loadLibrary("tencentloc");
      ??? = this.w;
      localObject1 = ((da)???).i();
      if ((localObject1 != null) && ("0123456789ABCDEF".equals(((db)localObject1).a())) && ("0123456789ABCDEF".equals(((db)localObject1).b()))) {
        ((da)???).a();
      }
      ??? = f.a.c(((db)localObject1).h);
      this.T = a((String)???);
      if (TextUtils.isEmpty(this.T))
      {
        f.a.b("TxLocationManagerImpl", "requestLocationUpdates: illegal key [" + (String)??? + "]");
        return 2;
      }
    }
    catch (Error paramTencentLocationRequest)
    {
      f.a.a("TencentLocationSDK", "load library", paramTencentLocationRequest);
      return 3;
    }
    if (this.O) {
      return 1;
    }
    p();
    for (;;)
    {
      synchronized (this.H)
      {
        this.x = paramTencentLocationListener;
        TencentLocationRequest.copy(this.I, paramTencentLocationRequest);
        ((db)localObject1).g = paramTencentLocationRequest.getQQ();
        if (TextUtils.isEmpty(f.a.c(((db)localObject1).e))) {
          ((db)localObject1).e = paramTencentLocationRequest.getPhoneNumber();
        }
        boolean bool2;
        if (paramTencentLocationRequest.getInterval() == 0L)
        {
          l1 = 8000L;
          ((db)localObject1).m = Math.max(cy.a().c("min_wifi_scan_interval"), l1);
          if (Looper.myLooper() == null) {
            Looper.prepare();
          }
          if (!f.a.a(this.c)) {
            break label985;
          }
          this.c = new a(paramLooper);
          o();
          l1 = System.currentTimeMillis();
          f.a.a("TxLocationManagerImpl", "registercost:" + (System.currentTimeMillis() - l1));
          bool1 = this.I.getExtras().getBoolean("use_network", true);
          bool2 = this.I.getExtras().getBoolean("daemon");
          paramTencentLocationRequest = this.c;
          this.k.a(paramTencentLocationRequest);
          paramTencentLocationListener = this.l;
          if (!paramTencentLocationListener.g)
          {
            paramTencentLocationListener.g = true;
            paramTencentLocationListener.b.k().execute(new du.1(paramTencentLocationListener, paramTencentLocationRequest));
            paramTencentLocationListener.f = SystemClock.elapsedRealtime();
          }
          f.a.a("TxLocationManagerImpl", "sendercost:" + (System.currentTimeMillis() - l1));
          if (bool2)
          {
            paramTencentLocationListener = this.l;
            paramLooper = this.w.l();
          }
        }
        try
        {
          boolean bool3 = TextUtils.isEmpty(paramLooper);
          if (!bool3) {
            break label1020;
          }
        }
        catch (Exception paramTencentLocationListener)
        {
          int i1;
          f.a.a("TxRequestSender", "", paramTencentLocationListener);
          continue;
        }
        catch (Error paramTencentLocationListener)
        {
          f.a.a("TxRequestSender", "", paramTencentLocationListener);
          continue;
          if ((!bool1) || (!f.a.b(this.d))) {
            continue;
          }
          this.d.a();
          continue;
          bool1 = false;
          continue;
        }
        f.a.a("TxLocationManagerImpl", "postlistcost:" + (System.currentTimeMillis() - l1));
        if (!this.f) {
          break;
        }
        if ((bool1) && (f.a.b(this.e))) {
          this.e.a(paramTencentLocationRequest, bool2);
        }
        f.a.a("TxLocationManagerImpl", "cellcost:" + (System.currentTimeMillis() - l1));
        if ((bool1) && (f.a.b(this.h))) {
          this.h.a(paramTencentLocationRequest, bool2);
        }
        f.a.a("TxLocationManagerImpl", "wificost:" + (System.currentTimeMillis() - l1));
        if (!bool2) {
          this.P = true;
        }
        if ((f.a.b(this.g)) && (this.I.isAllowGPS()))
        {
          paramTencentLocationListener = this.g;
          if (this.b != 1) {
            break label1135;
          }
          bool1 = true;
          paramTencentLocationListener.b(bool1);
          paramTencentLocationListener = this.g;
          this.I.getInterval();
          paramTencentLocationListener.a(bool2);
        }
        f.a.a("TxLocationManagerImpl", "gpscost:" + (System.currentTimeMillis() - l1));
        if ((this.I.isAllowDirection()) && (!this.i.a())) {
          this.i.a(paramTencentLocationRequest, null);
        }
        if ((!bool2) && (this.I.isAllowPedometer())) {
          this.j.a(this.w.a);
        }
        i1 = cy.a().b("f_coll_item");
        if (((i1 == 1) || (i1 == 2)) && (this.m == null)) {
          this.m = new ci(this.w.a);
        }
        if ((this.m != null) && (paramTencentLocationRequest != null))
        {
          paramTencentLocationListener = new StringBuilder("fc,set:").append(i1).append(",daemon:").append(bool2).append(",version:");
          paramLooper = this.m;
          f.a.a("TxLocationManagerImpl", ci.b());
          if ((i1 == 2) || ((i1 == 1) && (!bool2)))
          {
            this.m.a(n());
            this.m.a("D_UP_NET", cy.a().e("f_coll_up_net"));
            this.m.a(paramTencentLocationRequest.getLooper());
          }
        }
        this.y = "start";
        cx.a(this.T);
        return 0;
      }
      long l1 = paramTencentLocationRequest.getInterval();
      continue;
      label985:
      this.c.removeCallbacksAndMessages(null);
      if (this.c.getLooper() != paramLooper)
      {
        this.c = new a(paramLooper);
        continue;
        label1020:
        localObject1 = du.a(paramLooper.getBytes("UTF-8"));
        e.o((byte[])localObject1, 2);
        localObject1 = new du.a(2, (byte[])localObject1, "http://ue.indoorloc.map.qq.com/", null);
        ((du.a)localObject1).b = paramLooper;
        if (du.a.a((du.a)localObject1) != null) {
          paramTencentLocationListener.a.offer(localObject1);
        }
      }
    }
  }
  
  public final void a()
  {
    if (this.i != null) {
      this.i.c();
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.b == paramInt) {
      return;
    }
    this.b = paramInt;
  }
  
  public final TencentLocation b()
  {
    if (this.N == 0)
    {
      a(this.J);
      return this.J;
    }
    return null;
  }
  
  @TargetApi(19)
  public final boolean c()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        Sensor localSensor = ((SensorManager)this.w.a.getSystemService("sensor")).getDefaultSensor(19);
        return localSensor != null;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return false;
  }
  
  public final int d()
  {
    if (this.j != null) {
      return this.j.d();
    }
    return -1;
  }
  
  public final int e()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.w.b();
      Object localObject = localSharedPreferences.getString("stepStr", "");
      float f1 = 0.0F;
      long l1 = 0L;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        f1 = Float.valueOf(localObject[0]).floatValue();
        l1 = Long.valueOf(localObject[1]).longValue();
      }
      localSharedPreferences.edit().putString("stepStr", f1 + "," + l1 + ",0").apply();
      return 0;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  public final TencentPedestrianData f()
  {
    float f1 = 0.0F;
    Object localObject1 = this.w.b();
    if (localObject1 == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = ((SharedPreferences)localObject1).getString("stepStr", "");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        localObject3 = ((String)localObject3).split(",");
        f1 = Float.valueOf(localObject3[0]).floatValue();
        l1 = Long.valueOf(localObject3[1]).longValue();
        f2 = Float.valueOf(localObject3[2]).floatValue();
        ((SharedPreferences)localObject1).edit().putString("stepStr", f1 + "," + l1 + "," + f2).apply();
        localObject1 = new TencentPedestrianData()
        {
          public final long getLastUpdateTimeStamp()
          {
            return l1;
          }
          
          public final float getPedestrianCount()
          {
            return this.a;
          }
        };
      }
      catch (Throwable localThrowable)
      {
        final long l1;
        float f2;
        Object localObject2 = null;
        continue;
      }
      return localObject1;
      l1 = 0L;
      f2 = 0.0F;
    }
  }
  
  public final TencentDistanceAnalysis g()
  {
    this.F = null;
    this.A = 0.0D;
    this.z = false;
    this.E = null;
    eh localeh = new eh();
    localeh.a(f.a.a((this.B + 1) / (this.D + 1), 4) * 100.0D);
    localeh.a(this.B);
    localeh.b(this.C);
    this.B = 0;
    this.C = 0;
    this.D = 0;
    return localeh;
  }
  
  public final void h()
  {
    o();
    if (f.a.b(this.c)) {
      this.c.a();
    }
    for (;;)
    {
      synchronized (this.H)
      {
        this.x = null;
        this.r.a();
        p();
        this.y = "stop";
        if (this.p == 0)
        {
          if (!cy.a().d("start_daemon")) {
            f.a.b("TxLocationManagerImpl", "cloud daemon is false");
          }
        }
        else {
          return;
        }
      }
      this.Q = cy.a().c("up_daemon_delay");
      if (this.Q < 120000L) {
        this.Q = 120000L;
      }
      try
      {
        if (es.c(this.w).equalsIgnoreCase("{}"))
        {
          ??? = TencentLocationRequest.create().setInterval(this.Q).setRequestLevel(0);
          ((TencentLocationRequest)???).getExtras().putBoolean("daemon", true);
          TencentLocationListener local2 = new TencentLocationListener()
          {
            public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString) {}
            
            public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2) {}
          };
          this.o = new HandlerThread("daemonthread");
          this.o.start();
          a((TencentLocationRequest)???, local2, this.o.getLooper());
          this.p = 1;
          this.R = System.currentTimeMillis();
          return;
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public final int i()
  {
    return this.b;
  }
  
  public final void onCellInfoEvent(ea paramea)
  {
    f.a.b("TxLocationManagerImpl", "cellCallback:" + System.currentTimeMillis());
    int i4 = paramea.e;
    int i5 = paramea.f;
    Object localObject = this.s;
    int i1;
    if (localObject != null) {
      i1 = ((ea)localObject).f;
    }
    for (int i2 = ((ea)localObject).e;; i2 = 0)
    {
      this.s = paramea;
      if (this.h != null) {}
      for (int i3 = this.h.b();; i3 = 1)
      {
        if (i3 != 0) {
          this.t = null;
        }
        if ((i3 == 0) && ((this.t == null) || (this.t.a(System.currentTimeMillis(), 30000L))))
        {
          if (this.c != null)
          {
            localObject = this.c.obtainMessage(3999, "wifi_not_received");
            this.c.sendMessageDelayed((Message)localObject, 2000L);
          }
          if (i3 != 0) {
            break label296;
          }
        }
        label296:
        for (localObject = "scan wifi";; localObject = "prepare json. wifi is not scannable?")
        {
          f.a.a("TxLocationManagerImpl", String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), localObject }));
          if (this.m != null)
          {
            paramea = new ck(paramea.b, paramea.c, paramea.d, paramea.e, paramea.f);
            localObject = new ArrayList();
            ((List)localObject).add(paramea);
            this.m.a(paramea, (List)localObject);
          }
          return;
          b(3999);
          break;
        }
      }
      i1 = 0;
    }
  }
  
  public final void onGpsInfoEvent(eb parameb)
  {
    int i4;
    Location localLocation;
    double d2;
    double d1;
    int i2;
    if (parameb.a != dk.a)
    {
      this.u = parameb;
      if (!this.I.getExtras().getBoolean("daemon"))
      {
        int i5 = dm.a().a(parameb);
        int i3 = this.b;
        i4 = this.I.getRequestLevel();
        localObject1 = this.M;
        localLocation = new Location(parameb.a);
        localObject2 = localLocation.getExtras();
        d2 = 0.0D;
        d1 = 0.0D;
        i2 = 0;
        int i1 = 0;
        if (localObject2 != null)
        {
          d2 = ((Bundle)localObject2).getDouble("lat");
          d1 = ((Bundle)localObject2).getDouble("lng");
          i2 = ((Bundle)localObject2).getInt("fakeCode");
        }
        if (i2 != 0)
        {
          this.U = true;
          i1 = (int)(Math.pow(2.0D, i2 + 3) + 4.0D);
        }
        i2 = i1;
        if (i5 == -1)
        {
          this.U = true;
          i2 = i1 + 2;
        }
        if (!f.a.a(i3)) {
          break label337;
        }
        localObject2 = new em.a();
        ((em.a)localObject2).b = ((em)localObject1);
        ((em.a)localObject2).d = "gps";
        if (!this.U) {
          break label329;
        }
      }
    }
    label329:
    for (Object localObject1 = "fake";; localObject1 = "gps")
    {
      ((em.a)localObject2).e = ((String)localObject1);
      ((em.a)localObject2).c = i4;
      localObject1 = ((em.a)localObject2).a(new Location(parameb.a)).a();
      localLocation.setLatitude(d2);
      localLocation.setLongitude(d1);
      ((em)localObject1).a(localLocation);
      ((em)localObject1).a(i2);
      a(0, (em)localObject1);
      if (this.g != null) {
        this.g.b();
      }
      localObject1 = this.r;
      if (this.m != null) {
        this.m.a(parameb.a);
      }
      return;
    }
    label337:
    if (q()) {
      b(3999);
    }
    Object localObject2 = new em.a();
    ((em.a)localObject2).b = ((em)localObject1);
    ((em.a)localObject2).d = "gps";
    if (this.U) {}
    for (localObject1 = "fake";; localObject1 = "gps")
    {
      ((em.a)localObject2).e = ((String)localObject1);
      ((em.a)localObject2).c = i4;
      localObject1 = ((em.a)localObject2).a(new Location(parameb.a)).a();
      localLocation.setLatitude(d2);
      localLocation.setLongitude(d1);
      ((em)localObject1).a(localLocation);
      f.a.b("TxLocationManagerImpl", "updateLastLocation");
      ((em)localObject1).a(i2);
      a(0, (em)localObject1);
      a(12004, 3);
      break;
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    String str = f.a.d(this.w.a);
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case -1: 
      f.a.a("TxLocationManagerImpl", "onNetworkEvent: networks not found");
      return;
    case 0: 
      f.a.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " disconnected");
      return;
    }
    f.a.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " connected");
    a(7999, 1000L);
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(ee paramee)
  {
    f.a.b("TxLocationManagerImpl", "wifiCallback:" + System.currentTimeMillis());
    if (this.c != null) {
      this.c.removeMessages(3999, "wifi_not_received");
    }
    if (paramee == ee.a)
    {
      f.a.a("TxLocationManagerImpl", "onWifiChanged --> clear wifi if needed");
      a(555, 1500L);
    }
    for (;;)
    {
      if (this.m != null) {
        this.m.a(paramee.a());
      }
      return;
      if ((this.t == null) || (!this.G) || (paramee.a().size() < 3) || (!this.t.a(paramee)))
      {
        f.a.a("TxLocationManagerImpl", "onWifiChanged: --> prepare json");
        b(3999);
      }
      this.t = paramee;
    }
  }
  
  final class a
    extends Handler
  {
    private int a = 0;
    private int b = 0;
    private boolean c = true;
    
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void a()
    {
      removeCallbacksAndMessages(null);
      this.c = true;
      this.a = 0;
      this.b = 0;
    }
    
    /* Error */
    public final void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   4: invokestatic 45	c/t/m/g/do:a	(Lc/t/m/g/do;)Ljava/lang/Object;
      //   7: astore 12
      //   9: aload 12
      //   11: monitorenter
      //   12: aload_0
      //   13: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   16: invokestatic 48	c/t/m/g/do:b	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentLocationListener;
      //   19: ifnonnull +7 -> 26
      //   22: aload 12
      //   24: monitorexit
      //   25: return
      //   26: aload_0
      //   27: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   30: invokestatic 48	c/t/m/g/do:b	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentLocationListener;
      //   33: astore 11
      //   35: aload 12
      //   37: monitorexit
      //   38: aload_0
      //   39: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   42: invokestatic 51	c/t/m/g/do:c	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   45: astore 13
      //   47: aload 13
      //   49: invokevirtual 57	com/tencent/map/geolocation/TencentLocationRequest:getRequestLevel	()I
      //   52: istore 4
      //   54: aload 13
      //   56: invokevirtual 61	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
      //   59: lstore 5
      //   61: aload 13
      //   63: invokevirtual 65	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   66: ldc 67
      //   68: invokevirtual 73	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
      //   71: istore 10
      //   73: aload_1
      //   74: getfield 78	android/os/Message:what	I
      //   77: lookupswitch	default:+91->168, 555:+92->169, 3998:+1311->1388, 3999:+564->641, 4996:+2798->2875, 4997:+2319->2396, 4998:+2767->2844, 4999:+1528->1605, 7999:+547->624, 11998:+408->485, 11999:+115->192
      //   169: aload_0
      //   170: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   173: invokestatic 82	c/t/m/g/do:D	(Lc/t/m/g/do;)Lc/t/m/g/ee;
      //   176: pop
      //   177: aload_0
      //   178: sipush 3999
      //   181: invokevirtual 86	c/t/m/g/do$a:sendEmptyMessage	(I)Z
      //   184: pop
      //   185: return
      //   186: astore_1
      //   187: aload 12
      //   189: monitorexit
      //   190: aload_1
      //   191: athrow
      //   192: aload_0
      //   193: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   196: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   199: ifnull +214 -> 413
      //   202: aload 13
      //   204: invokevirtual 61	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
      //   207: lconst_0
      //   208: lcmp
      //   209: ifle +204 -> 413
      //   212: aload_0
      //   213: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   216: invokestatic 93	c/t/m/g/do:e	(Lc/t/m/g/do;)Ljava/lang/String;
      //   219: ifnull +194 -> 413
      //   222: aload_0
      //   223: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   226: invokestatic 93	c/t/m/g/do:e	(Lc/t/m/g/do;)Ljava/lang/String;
      //   229: ldc 95
      //   231: invokevirtual 100	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   234: ifeq +179 -> 413
      //   237: aload_0
      //   238: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   241: aload_0
      //   242: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   245: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   248: invokestatic 103	c/t/m/g/do:a	(Lc/t/m/g/do;Lc/t/m/g/em;)V
      //   251: ldc 105
      //   253: new 107	java/lang/StringBuilder
      //   256: dup
      //   257: ldc 109
      //   259: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   262: aload_0
      //   263: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   266: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   269: invokevirtual 118	c/t/m/g/em:getLatitude	()D
      //   272: invokevirtual 122	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   275: ldc 124
      //   277: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   280: aload_0
      //   281: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   284: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   287: invokevirtual 130	c/t/m/g/em:getLongitude	()D
      //   290: invokevirtual 122	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   293: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   296: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   299: aload 11
      //   301: aload_0
      //   302: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   305: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   308: aload_0
      //   309: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   312: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   315: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   318: aload_0
      //   319: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   322: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   325: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   328: checkcast 97	java/lang/String
      //   331: invokeinterface 159 4 0
      //   336: aload_0
      //   337: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   340: invokestatic 163	c/t/m/g/do:g	(Lc/t/m/g/do;)Z
      //   343: ifeq +70 -> 413
      //   346: aload_0
      //   347: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   350: invokestatic 167	c/t/m/g/do:h	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   353: ifnull +60 -> 413
      //   356: aload_0
      //   357: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   360: invokestatic 167	c/t/m/g/do:h	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   363: aload_0
      //   364: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   367: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   370: aload_0
      //   371: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   374: invokestatic 171	c/t/m/g/do:i	(Lc/t/m/g/do;)D
      //   377: ldc2_w 172
      //   380: ddiv
      //   381: iconst_2
      //   382: invokestatic 176	c/t/m/g/f$a:a	(DI)D
      //   385: aload_0
      //   386: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   389: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   392: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   395: aload_0
      //   396: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   399: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   402: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   405: checkcast 97	java/lang/String
      //   408: invokeinterface 182 6 0
      //   413: lload 5
      //   415: lconst_0
      //   416: lcmp
      //   417: ifle +18 -> 435
      //   420: iload 10
      //   422: ifne +13 -> 435
      //   425: aload_0
      //   426: sipush 11999
      //   429: lload 5
      //   431: invokevirtual 186	c/t/m/g/do$a:sendEmptyMessageDelayed	(IJ)Z
      //   434: pop
      //   435: aload_0
      //   436: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   439: invokestatic 188	c/t/m/g/do:j	(Lc/t/m/g/do;)Z
      //   442: istore 9
      //   444: aload_0
      //   445: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   448: invokestatic 192	c/t/m/g/do:k	(Lc/t/m/g/do;)Lc/t/m/g/dw;
      //   451: iload 9
      //   453: invokevirtual 197	c/t/m/g/dw:a	(Z)V
      //   456: iload 9
      //   458: ifeq +2474 -> 2932
      //   461: lload 5
      //   463: ldc2_w 198
      //   466: lcmp
      //   467: ifle +2465 -> 2932
      //   470: aload_0
      //   471: sipush 3999
      //   474: lload 5
      //   476: ldc2_w 200
      //   479: lsub
      //   480: invokevirtual 186	c/t/m/g/do$a:sendEmptyMessageDelayed	(IJ)Z
      //   483: pop
      //   484: return
      //   485: aload_0
      //   486: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   489: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   492: ifnull +2440 -> 2932
      //   495: aload_0
      //   496: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   499: aload_0
      //   500: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   503: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   506: invokestatic 103	c/t/m/g/do:a	(Lc/t/m/g/do;Lc/t/m/g/em;)V
      //   509: aload 11
      //   511: aload_0
      //   512: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   515: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   518: aload_0
      //   519: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   522: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   525: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   528: aload_0
      //   529: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   532: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   535: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   538: checkcast 97	java/lang/String
      //   541: invokeinterface 159 4 0
      //   546: aload_0
      //   547: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   550: invokestatic 163	c/t/m/g/do:g	(Lc/t/m/g/do;)Z
      //   553: ifeq +2379 -> 2932
      //   556: aload_0
      //   557: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   560: invokestatic 167	c/t/m/g/do:h	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   563: ifnull +2369 -> 2932
      //   566: aload_0
      //   567: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   570: invokestatic 167	c/t/m/g/do:h	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   573: aload_0
      //   574: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   577: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   580: aload_0
      //   581: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   584: invokestatic 171	c/t/m/g/do:i	(Lc/t/m/g/do;)D
      //   587: ldc2_w 172
      //   590: ddiv
      //   591: iconst_2
      //   592: invokestatic 176	c/t/m/g/f$a:a	(DI)D
      //   595: aload_0
      //   596: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   599: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   602: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   605: aload_0
      //   606: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   609: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   612: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   615: checkcast 97	java/lang/String
      //   618: invokeinterface 182 6 0
      //   623: return
      //   624: aload_0
      //   625: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   628: invokestatic 204	c/t/m/g/do:l	(Lc/t/m/g/do;)Z
      //   631: ifne +2301 -> 2932
      //   634: ldc 105
      //   636: ldc 206
      //   638: invokestatic 208	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   641: new 107	java/lang/StringBuilder
      //   644: dup
      //   645: ldc 210
      //   647: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   650: astore 12
      //   652: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   655: lstore 7
      //   657: aload_0
      //   658: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   661: astore 14
      //   663: ldc 105
      //   665: aload 12
      //   667: lload 7
      //   669: invokestatic 217	c/t/m/g/do:k	()J
      //   672: lsub
      //   673: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   676: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   679: invokestatic 208	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   682: iload 10
      //   684: ifeq +153 -> 837
      //   687: ldc 105
      //   689: new 107	java/lang/StringBuilder
      //   692: dup
      //   693: ldc 222
      //   695: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   698: aload_0
      //   699: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   702: invokestatic 226	c/t/m/g/do:m	(Lc/t/m/g/do;)J
      //   705: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   708: ldc 124
      //   710: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   713: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   716: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   719: ldc 124
      //   721: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   724: aload_0
      //   725: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   728: invokestatic 229	c/t/m/g/do:n	(Lc/t/m/g/do;)J
      //   731: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   734: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   737: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   740: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   743: aload_0
      //   744: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   747: invokestatic 229	c/t/m/g/do:n	(Lc/t/m/g/do;)J
      //   750: lsub
      //   751: aload_0
      //   752: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   755: invokestatic 226	c/t/m/g/do:m	(Lc/t/m/g/do;)J
      //   758: lcmp
      //   759: iflt +2173 -> 2932
      //   762: aload_0
      //   763: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   766: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   769: invokestatic 232	c/t/m/g/do:a	(Lc/t/m/g/do;J)J
      //   772: pop2
      //   773: aload_1
      //   774: getfield 236	android/os/Message:obj	Ljava/lang/Object;
      //   777: ifnull +30 -> 807
      //   780: ldc 105
      //   782: new 107	java/lang/StringBuilder
      //   785: dup
      //   786: ldc 238
      //   788: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   791: aload_1
      //   792: getfield 236	android/os/Message:obj	Ljava/lang/Object;
      //   795: invokevirtual 241	java/lang/Object:toString	()Ljava/lang/String;
      //   798: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   801: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   804: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   807: aload_0
      //   808: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   811: invokestatic 244	c/t/m/g/do:p	(Lc/t/m/g/do;)I
      //   814: istore_3
      //   815: aload_0
      //   816: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   819: invokestatic 248	c/t/m/g/do:q	(Lc/t/m/g/do;)Lc/t/m/g/ec;
      //   822: astore 12
      //   824: aload 12
      //   826: ifnonnull +93 -> 919
      //   829: ldc 105
      //   831: ldc 250
      //   833: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   836: return
      //   837: aload_0
      //   838: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   841: invokestatic 188	c/t/m/g/do:j	(Lc/t/m/g/do;)Z
      //   844: istore 9
      //   846: aload_0
      //   847: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   850: invokestatic 192	c/t/m/g/do:k	(Lc/t/m/g/do;)Lc/t/m/g/dw;
      //   853: iload 9
      //   855: invokevirtual 197	c/t/m/g/dw:a	(Z)V
      //   858: iload 9
      //   860: ifeq -87 -> 773
      //   863: lload 5
      //   865: ldc2_w 198
      //   868: lcmp
      //   869: ifle -96 -> 773
      //   872: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   875: lstore 7
      //   877: lload 7
      //   879: aload_0
      //   880: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   883: invokestatic 253	c/t/m/g/do:o	(Lc/t/m/g/do;)J
      //   886: lsub
      //   887: lload 5
      //   889: ldc2_w 200
      //   892: lsub
      //   893: lcmp
      //   894: iflt +16 -> 910
      //   897: aload_0
      //   898: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   901: lload 7
      //   903: invokestatic 255	c/t/m/g/do:b	(Lc/t/m/g/do;J)J
      //   906: pop2
      //   907: goto -134 -> 773
      //   910: ldc 105
      //   912: ldc_w 257
      //   915: invokestatic 208	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   918: return
      //   919: aload_0
      //   920: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   923: invokestatic 260	c/t/m/g/do:r	(Lc/t/m/g/do;)Ljava/lang/String;
      //   926: astore_1
      //   927: aload_0
      //   928: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   931: invokestatic 264	c/t/m/g/do:s	(Lc/t/m/g/do;)Lc/t/m/g/da;
      //   934: astore 14
      //   936: aload_0
      //   937: getfield 26	c/t/m/g/do$a:c	Z
      //   940: ifeq +139 -> 1079
      //   943: iload 10
      //   945: ifne +134 -> 1079
      //   948: iconst_1
      //   949: istore 9
      //   951: aload 12
      //   953: iload 4
      //   955: aload_1
      //   956: aload 14
      //   958: iload 9
      //   960: aload_0
      //   961: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   964: invokestatic 267	c/t/m/g/do:t	(Lc/t/m/g/do;)Z
      //   967: iload 10
      //   969: invokevirtual 272	c/t/m/g/ec:a	(ILjava/lang/String;Lc/t/m/g/da;ZZZ)Ljava/lang/String;
      //   972: astore_1
      //   973: aload_1
      //   974: invokestatic 274	c/t/m/g/f$a:d	(Ljava/lang/String;)Z
      //   977: ifne +108 -> 1085
      //   980: iconst_1
      //   981: istore_2
      //   982: iload_2
      //   983: ifeq +25 -> 1008
      //   986: ldc 105
      //   988: new 107	java/lang/StringBuilder
      //   991: dup
      //   992: ldc_w 276
      //   995: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   998: aload_1
      //   999: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1002: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1005: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1008: iload_2
      //   1009: ifeq +81 -> 1090
      //   1012: aload_0
      //   1013: aload_0
      //   1014: getfield 22	c/t/m/g/do$a:a	I
      //   1017: iconst_1
      //   1018: iadd
      //   1019: putfield 22	c/t/m/g/do$a:a	I
      //   1022: aload_0
      //   1023: getfield 22	c/t/m/g/do$a:a	I
      //   1026: iconst_2
      //   1027: if_icmplt +1905 -> 2932
      //   1030: aload_0
      //   1031: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1034: invokestatic 188	c/t/m/g/do:j	(Lc/t/m/g/do;)Z
      //   1037: ifne +1895 -> 2932
      //   1040: ldc 105
      //   1042: new 107	java/lang/StringBuilder
      //   1045: dup
      //   1046: ldc_w 276
      //   1049: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1052: aload_1
      //   1053: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1056: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1059: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1062: aload_0
      //   1063: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1066: iconst_2
      //   1067: getstatic 279	c/t/m/g/em:a	Lc/t/m/g/em;
      //   1070: invokestatic 282	c/t/m/g/do:a	(Lc/t/m/g/do;ILc/t/m/g/em;)V
      //   1073: aload_0
      //   1074: iconst_0
      //   1075: putfield 22	c/t/m/g/do$a:a	I
      //   1078: return
      //   1079: iconst_0
      //   1080: istore 9
      //   1082: goto -131 -> 951
      //   1085: iconst_0
      //   1086: istore_2
      //   1087: goto -105 -> 982
      //   1090: aload_0
      //   1091: iconst_0
      //   1092: putfield 22	c/t/m/g/do$a:a	I
      //   1095: iload 10
      //   1097: ifne +80 -> 1177
      //   1100: aload 13
      //   1102: invokestatic 288	com/tencent/map/geolocation/internal/TencentExtraKeys:isRequestRawData	(Lcom/tencent/map/geolocation/TencentLocationRequest;)Z
      //   1105: ifeq +72 -> 1177
      //   1108: new 290	c/t/m/g/em$a
      //   1111: dup
      //   1112: invokespecial 292	c/t/m/g/em$a:<init>	()V
      //   1115: astore 12
      //   1117: aload 12
      //   1119: aconst_null
      //   1120: putfield 294	c/t/m/g/em$a:b	Lc/t/m/g/em;
      //   1123: aload 12
      //   1125: iload 4
      //   1127: putfield 296	c/t/m/g/em$a:c	I
      //   1130: aload 12
      //   1132: invokevirtual 299	c/t/m/g/em$a:a	()Lc/t/m/g/em;
      //   1135: astore 12
      //   1137: aload 12
      //   1139: aload_1
      //   1140: invokevirtual 303	java/lang/String:getBytes	()[B
      //   1143: invokestatic 307	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawData	(Lcom/tencent/map/geolocation/TencentLocation;[B)Lcom/tencent/map/geolocation/TencentLocation;
      //   1146: pop
      //   1147: aload_0
      //   1148: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1151: aload 12
      //   1153: invokestatic 103	c/t/m/g/do:a	(Lc/t/m/g/do;Lc/t/m/g/em;)V
      //   1156: aload 11
      //   1158: aload 12
      //   1160: iconst_0
      //   1161: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   1164: iconst_0
      //   1165: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   1168: checkcast 97	java/lang/String
      //   1171: invokeinterface 159 4 0
      //   1176: return
      //   1177: new 107	java/lang/StringBuilder
      //   1180: dup
      //   1181: ldc_w 309
      //   1184: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1187: astore 11
      //   1189: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   1192: lstore 5
      //   1194: aload_0
      //   1195: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1198: astore 13
      //   1200: ldc 105
      //   1202: aload 11
      //   1204: lload 5
      //   1206: invokestatic 217	c/t/m/g/do:k	()J
      //   1209: lsub
      //   1210: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1213: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1216: invokestatic 208	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1219: aload 12
      //   1221: aload_0
      //   1222: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1225: invokestatic 312	c/t/m/g/do:u	(Lc/t/m/g/do;)Lc/t/m/g/ec;
      //   1228: invokevirtual 315	c/t/m/g/ec:a	(Lc/t/m/g/ec;)I
      //   1231: istore_2
      //   1232: aload_0
      //   1233: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1236: invokestatic 143	c/t/m/g/do:f	(Lc/t/m/g/do;)I
      //   1239: ifne +56 -> 1295
      //   1242: aload_0
      //   1243: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1246: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   1249: ifnull +46 -> 1295
      //   1252: iload_2
      //   1253: iconst_1
      //   1254: if_icmpeq +25 -> 1279
      //   1257: iload_2
      //   1258: iconst_2
      //   1259: if_icmplt +36 -> 1295
      //   1262: aload_0
      //   1263: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1266: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   1269: invokevirtual 319	c/t/m/g/em:getAccuracy	()F
      //   1272: ldc_w 320
      //   1275: fcmpg
      //   1276: ifge +19 -> 1295
      //   1279: aload_0
      //   1280: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1283: iconst_0
      //   1284: aload_0
      //   1285: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1288: invokestatic 89	c/t/m/g/do:d	(Lc/t/m/g/do;)Lc/t/m/g/em;
      //   1291: invokestatic 282	c/t/m/g/do:a	(Lc/t/m/g/do;ILc/t/m/g/em;)V
      //   1294: return
      //   1295: aload_0
      //   1296: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1299: invokestatic 324	c/t/m/g/do:v	(Lc/t/m/g/do;)Lc/t/m/g/du;
      //   1302: astore 11
      //   1304: aload_1
      //   1305: ldc_w 326
      //   1308: invokevirtual 329	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   1311: invokestatic 332	c/t/m/g/f$a:c	([B)[B
      //   1314: astore 13
      //   1316: new 334	c/t/m/g/du$a
      //   1319: dup
      //   1320: iconst_1
      //   1321: aload 13
      //   1323: aload 13
      //   1325: iload_3
      //   1326: invokestatic 339	c/t/m/g/du:a	([BI)Ljava/lang/String;
      //   1329: aload 12
      //   1331: invokespecial 342	c/t/m/g/du$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
      //   1334: astore 12
      //   1336: aload 12
      //   1338: aload_1
      //   1339: putfield 345	c/t/m/g/du$a:b	Ljava/lang/String;
      //   1342: aload 12
      //   1344: invokestatic 348	c/t/m/g/du$a:a	(Lc/t/m/g/du$a;)[B
      //   1347: ifnull +14 -> 1361
      //   1350: aload 11
      //   1352: getfield 351	c/t/m/g/du:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1355: aload 12
      //   1357: invokevirtual 357	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
      //   1360: pop
      //   1361: aload_0
      //   1362: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1365: invokestatic 361	c/t/m/g/do:w	(Lc/t/m/g/do;)Lc/t/m/g/dc;
      //   1368: pop
      //   1369: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   1372: pop2
      //   1373: return
      //   1374: astore_1
      //   1375: ldc_w 363
      //   1378: ldc_w 365
      //   1381: aload_1
      //   1382: invokestatic 368	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1385: goto -24 -> 1361
      //   1388: aload_0
      //   1389: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1392: invokestatic 248	c/t/m/g/do:q	(Lc/t/m/g/do;)Lc/t/m/g/ec;
      //   1395: astore 12
      //   1397: aload 12
      //   1399: ifnonnull +12 -> 1411
      //   1402: ldc 105
      //   1404: ldc_w 370
      //   1407: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1410: return
      //   1411: aload 12
      //   1413: iload 4
      //   1415: aload_0
      //   1416: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1419: invokestatic 260	c/t/m/g/do:r	(Lc/t/m/g/do;)Ljava/lang/String;
      //   1422: aload_0
      //   1423: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1426: invokestatic 264	c/t/m/g/do:s	(Lc/t/m/g/do;)Lc/t/m/g/da;
      //   1429: iconst_1
      //   1430: iconst_0
      //   1431: iconst_0
      //   1432: invokevirtual 272	c/t/m/g/ec:a	(ILjava/lang/String;Lc/t/m/g/da;ZZZ)Ljava/lang/String;
      //   1435: astore_1
      //   1436: aload_1
      //   1437: invokestatic 274	c/t/m/g/f$a:d	(Ljava/lang/String;)Z
      //   1440: ifne +32 -> 1472
      //   1443: iconst_1
      //   1444: istore_2
      //   1445: iload_2
      //   1446: ifeq +31 -> 1477
      //   1449: ldc 105
      //   1451: new 107	java/lang/StringBuilder
      //   1454: dup
      //   1455: ldc_w 372
      //   1458: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1461: aload_1
      //   1462: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1465: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1468: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1471: return
      //   1472: iconst_0
      //   1473: istore_2
      //   1474: goto -29 -> 1445
      //   1477: aload_0
      //   1478: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1481: invokestatic 324	c/t/m/g/do:v	(Lc/t/m/g/do;)Lc/t/m/g/du;
      //   1484: astore 11
      //   1486: aload_0
      //   1487: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1490: invokestatic 244	c/t/m/g/do:p	(Lc/t/m/g/do;)I
      //   1493: istore_2
      //   1494: invokestatic 377	android/os/SystemClock:elapsedRealtime	()J
      //   1497: pop2
      //   1498: aload_1
      //   1499: ldc_w 326
      //   1502: invokevirtual 329	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   1505: invokestatic 332	c/t/m/g/f$a:c	([B)[B
      //   1508: astore 13
      //   1510: new 334	c/t/m/g/du$a
      //   1513: dup
      //   1514: iconst_3
      //   1515: aload 13
      //   1517: aload 13
      //   1519: iload_2
      //   1520: invokestatic 339	c/t/m/g/du:a	([BI)Ljava/lang/String;
      //   1523: aload 12
      //   1525: invokespecial 342	c/t/m/g/du$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
      //   1528: astore 12
      //   1530: aload 12
      //   1532: aload_1
      //   1533: putfield 345	c/t/m/g/du$a:b	Ljava/lang/String;
      //   1536: aload 12
      //   1538: invokestatic 348	c/t/m/g/du$a:a	(Lc/t/m/g/du$a;)[B
      //   1541: ifnull +31 -> 1572
      //   1544: aload 11
      //   1546: getfield 351	c/t/m/g/du:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1549: invokevirtual 380	java/util/concurrent/LinkedBlockingQueue:clear	()V
      //   1552: aload 11
      //   1554: getfield 351	c/t/m/g/du:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1557: aload 12
      //   1559: invokevirtual 357	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
      //   1562: pop
      //   1563: ldc_w 363
      //   1566: ldc_w 382
      //   1569: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1572: aload_0
      //   1573: sipush 3998
      //   1576: aload_0
      //   1577: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1580: invokestatic 51	c/t/m/g/do:c	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   1583: invokevirtual 385	com/tencent/map/geolocation/TencentLocationRequest:getCheckInterval	()J
      //   1586: invokevirtual 186	c/t/m/g/do$a:sendEmptyMessageDelayed	(IJ)Z
      //   1589: pop
      //   1590: return
      //   1591: astore_1
      //   1592: ldc_w 363
      //   1595: ldc_w 365
      //   1598: aload_1
      //   1599: invokestatic 368	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1602: goto -30 -> 1572
      //   1605: aload_0
      //   1606: sipush 4998
      //   1609: invokevirtual 389	c/t/m/g/do$a:removeMessages	(I)V
      //   1612: aload_0
      //   1613: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1616: invokestatic 51	c/t/m/g/do:c	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   1619: invokevirtual 65	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   1622: ldc 67
      //   1624: invokevirtual 73	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
      //   1627: ifeq +13 -> 1640
      //   1630: aload_0
      //   1631: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1634: iconst_1
      //   1635: invokestatic 392	c/t/m/g/do:a	(Lc/t/m/g/do;Z)Z
      //   1638: pop
      //   1639: return
      //   1640: new 107	java/lang/StringBuilder
      //   1643: dup
      //   1644: ldc_w 394
      //   1647: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1650: astore 12
      //   1652: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   1655: lstore 5
      //   1657: aload_0
      //   1658: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1661: astore 13
      //   1663: ldc 105
      //   1665: aload 12
      //   1667: lload 5
      //   1669: invokestatic 217	c/t/m/g/do:k	()J
      //   1672: lsub
      //   1673: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1676: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1679: invokestatic 208	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1682: aload_1
      //   1683: getfield 236	android/os/Message:obj	Ljava/lang/Object;
      //   1686: checkcast 396	android/util/Pair
      //   1689: astore 12
      //   1691: aload 12
      //   1693: getfield 399	android/util/Pair:first	Ljava/lang/Object;
      //   1696: invokevirtual 241	java/lang/Object:toString	()Ljava/lang/String;
      //   1699: astore 13
      //   1701: aload 12
      //   1703: getfield 402	android/util/Pair:second	Ljava/lang/Object;
      //   1706: checkcast 334	c/t/m/g/du$a
      //   1709: astore 12
      //   1711: aload 12
      //   1713: getfield 404	c/t/m/g/du$a:a	Ljava/lang/Object;
      //   1716: checkcast 269	c/t/m/g/ec
      //   1719: astore 14
      //   1721: aload_0
      //   1722: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1725: aload 14
      //   1727: invokestatic 407	c/t/m/g/do:a	(Lc/t/m/g/do;Lc/t/m/g/ec;)Lc/t/m/g/ec;
      //   1730: pop
      //   1731: aload 12
      //   1733: getfield 345	c/t/m/g/du$a:b	Ljava/lang/String;
      //   1736: astore 15
      //   1738: new 290	c/t/m/g/em$a
      //   1741: dup
      //   1742: invokespecial 292	c/t/m/g/em$a:<init>	()V
      //   1745: astore 12
      //   1747: aload 12
      //   1749: aload 13
      //   1751: putfield 409	c/t/m/g/em$a:a	Ljava/lang/String;
      //   1754: aload 12
      //   1756: iload 4
      //   1758: putfield 296	c/t/m/g/em$a:c	I
      //   1761: aload 12
      //   1763: invokevirtual 299	c/t/m/g/em$a:a	()Lc/t/m/g/em;
      //   1766: astore 12
      //   1768: aload 12
      //   1770: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   1773: ldc_w 414
      //   1776: aload 13
      //   1778: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   1781: aload 12
      //   1783: invokestatic 420	c/t/m/g/em:a	(Lc/t/m/g/em;)V
      //   1786: aload 12
      //   1788: aload_0
      //   1789: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   1792: invokestatic 424	c/t/m/g/do:x	(Lc/t/m/g/do;)Lc/t/m/g/ea;
      //   1795: iconst_0
      //   1796: invokestatic 427	c/t/m/g/em:a	(Lc/t/m/g/em;Lc/t/m/g/ea;Z)Lc/t/m/g/em;
      //   1799: pop
      //   1800: aload 12
      //   1802: aload 15
      //   1804: invokestatic 431	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
      //   1807: aload 14
      //   1809: invokevirtual 434	c/t/m/g/ec:a	()Lc/t/m/g/eb;
      //   1812: ifnull +12 -> 1824
      //   1815: aload 14
      //   1817: invokevirtual 434	c/t/m/g/ec:a	()Lc/t/m/g/eb;
      //   1820: getfield 437	c/t/m/g/eb:c	I
      //   1823: istore_2
      //   1824: aload 12
      //   1826: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   1829: ldc_w 439
      //   1832: aload_1
      //   1833: getfield 442	android/os/Message:arg1	I
      //   1836: i2l
      //   1837: invokevirtual 446	android/os/Bundle:putLong	(Ljava/lang/String;J)V
      //   1840: getstatic 449	com/tencent/map/geolocation/internal/TencentExtraKeys:COMPHTTPIO	Z
      //   1843: ifeq +19 -> 1862
      //   1846: aload 12
      //   1848: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   1851: ldc_w 451
      //   1854: aload_1
      //   1855: getfield 454	android/os/Message:arg2	I
      //   1858: i2l
      //   1859: invokevirtual 446	android/os/Bundle:putLong	(Ljava/lang/String;J)V
      //   1862: aload_0
      //   1863: iconst_0
      //   1864: putfield 26	c/t/m/g/do$a:c	Z
      //   1867: aload 12
      //   1869: invokevirtual 457	c/t/m/g/em:getVerifyKey	()Ljava/lang/String;
      //   1872: ifnull +235 -> 2107
      //   1875: aload 12
      //   1877: invokevirtual 457	c/t/m/g/em:getVerifyKey	()Ljava/lang/String;
      //   1880: ldc_w 459
      //   1883: invokevirtual 100	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   1886: ifne +221 -> 2107
      //   1889: aload 15
      //   1891: ifnull +116 -> 2007
      //   1894: new 461	org/json/JSONObject
      //   1897: dup
      //   1898: aload 15
      //   1900: invokespecial 462	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   1903: astore_1
      //   1904: aload_1
      //   1905: ldc_w 464
      //   1908: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1911: pop
      //   1912: aload_1
      //   1913: ldc_w 470
      //   1916: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1919: pop
      //   1920: aload_1
      //   1921: ldc_w 472
      //   1924: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1927: pop
      //   1928: aload_1
      //   1929: ldc_w 474
      //   1932: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1935: pop
      //   1936: aload_1
      //   1937: ldc_w 476
      //   1940: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1943: pop
      //   1944: aload_1
      //   1945: ldc_w 478
      //   1948: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1951: pop
      //   1952: aload_1
      //   1953: ldc_w 480
      //   1956: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1959: pop
      //   1960: aload_1
      //   1961: ldc_w 482
      //   1964: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1967: pop
      //   1968: aload_1
      //   1969: ldc_w 484
      //   1972: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1975: pop
      //   1976: aload_1
      //   1977: ldc_w 486
      //   1980: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1983: pop
      //   1984: aload_1
      //   1985: ldc_w 488
      //   1988: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1991: pop
      //   1992: aload 12
      //   1994: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   1997: ldc_w 490
      //   2000: aload_1
      //   2001: invokevirtual 491	org/json/JSONObject:toString	()Ljava/lang/String;
      //   2004: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2007: aload 12
      //   2009: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2012: ldc_w 493
      //   2015: aload_0
      //   2016: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2019: invokestatic 497	c/t/m/g/do:y	(Lc/t/m/g/do;)Lc/t/m/g/dp;
      //   2022: invokevirtual 501	c/t/m/g/dp:e	()Ljava/lang/String;
      //   2025: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2028: aload 12
      //   2030: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2033: aload_0
      //   2034: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2037: invokestatic 51	c/t/m/g/do:c	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   2040: invokevirtual 65	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   2043: invokevirtual 505	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
      //   2046: aload 12
      //   2048: invokevirtual 319	c/t/m/g/em:getAccuracy	()F
      //   2051: f2d
      //   2052: ldc2_w 506
      //   2055: dcmpl
      //   2056: ifne +308 -> 2364
      //   2059: aload_0
      //   2060: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2063: invokestatic 510	c/t/m/g/do:z	(Lc/t/m/g/do;)Z
      //   2066: ifeq +298 -> 2364
      //   2069: iconst_1
      //   2070: istore 9
      //   2072: aload 12
      //   2074: aload_0
      //   2075: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2078: invokestatic 424	c/t/m/g/do:x	(Lc/t/m/g/do;)Lc/t/m/g/ea;
      //   2081: iload 9
      //   2083: invokestatic 427	c/t/m/g/em:a	(Lc/t/m/g/em;Lc/t/m/g/ea;Z)Lc/t/m/g/em;
      //   2086: pop
      //   2087: aload 11
      //   2089: aload 12
      //   2091: iconst_0
      //   2092: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   2095: iconst_0
      //   2096: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2099: checkcast 97	java/lang/String
      //   2102: invokeinterface 159 4 0
      //   2107: aload_0
      //   2108: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2111: iconst_1
      //   2112: invokestatic 392	c/t/m/g/do:a	(Lc/t/m/g/do;Z)Z
      //   2115: pop
      //   2116: aload_0
      //   2117: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2120: invokestatic 188	c/t/m/g/do:j	(Lc/t/m/g/do;)Z
      //   2123: ifne +72 -> 2195
      //   2126: aload 12
      //   2128: invokevirtual 512	c/t/m/g/em:a	()V
      //   2131: aload 12
      //   2133: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2136: ldc_w 490
      //   2139: ldc_w 365
      //   2142: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2145: aload_0
      //   2146: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2149: iconst_0
      //   2150: aload 12
      //   2152: invokestatic 282	c/t/m/g/do:a	(Lc/t/m/g/do;ILc/t/m/g/em;)V
      //   2155: new 107	java/lang/StringBuilder
      //   2158: dup
      //   2159: ldc_w 394
      //   2162: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2165: astore_1
      //   2166: invokestatic 215	java/lang/System:currentTimeMillis	()J
      //   2169: lstore 5
      //   2171: aload_0
      //   2172: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2175: astore 11
      //   2177: ldc 105
      //   2179: aload_1
      //   2180: lload 5
      //   2182: invokestatic 217	c/t/m/g/do:k	()J
      //   2185: lsub
      //   2186: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2189: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2192: invokestatic 208	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   2195: aload_0
      //   2196: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2199: invokestatic 267	c/t/m/g/do:t	(Lc/t/m/g/do;)Z
      //   2202: ifeq +83 -> 2285
      //   2205: aload 12
      //   2207: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2210: astore_1
      //   2211: aload_1
      //   2212: ifnull +65 -> 2277
      //   2215: aload_1
      //   2216: ldc_w 514
      //   2219: iconst_m1
      //   2220: invokevirtual 518	android/os/Bundle:getInt	(Ljava/lang/String;I)I
      //   2223: istore_2
      //   2224: aload_0
      //   2225: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2228: invokestatic 264	c/t/m/g/do:s	(Lc/t/m/g/do;)Lc/t/m/g/da;
      //   2231: invokevirtual 523	c/t/m/g/da:b	()Landroid/content/SharedPreferences;
      //   2234: astore_1
      //   2235: ldc 105
      //   2237: new 107	java/lang/StringBuilder
      //   2240: dup
      //   2241: ldc_w 525
      //   2244: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2247: iload_2
      //   2248: invokevirtual 528	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2251: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2254: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2257: aload_1
      //   2258: invokeinterface 534 1 0
      //   2263: ldc_w 476
      //   2266: iload_2
      //   2267: invokeinterface 540 3 0
      //   2272: invokeinterface 543 1 0
      //   2277: aload_0
      //   2278: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2281: invokestatic 546	c/t/m/g/do:A	(Lc/t/m/g/do;)Z
      //   2284: pop
      //   2285: aload_0
      //   2286: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2289: aload 12
      //   2291: invokestatic 549	c/t/m/g/do:b	(Lc/t/m/g/do;Lc/t/m/g/em;)Lc/t/m/g/em;
      //   2294: pop
      //   2295: aload_0
      //   2296: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2299: invokestatic 552	c/t/m/g/do:B	(Lc/t/m/g/do;)Z
      //   2302: ifne +630 -> 2932
      //   2305: invokestatic 557	c/t/m/g/cx:a	()Lc/t/m/g/cx;
      //   2308: invokevirtual 559	c/t/m/g/cx:b	()V
      //   2311: aload_0
      //   2312: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2315: invokestatic 562	c/t/m/g/do:C	(Lc/t/m/g/do;)Z
      //   2318: pop
      //   2319: return
      //   2320: astore_1
      //   2321: ldc 105
      //   2323: ldc_w 564
      //   2326: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2329: aload_0
      //   2330: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2333: invokestatic 204	c/t/m/g/do:l	(Lc/t/m/g/do;)Z
      //   2336: ifeq +596 -> 2932
      //   2339: aload_0
      //   2340: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2343: iconst_2
      //   2344: getstatic 279	c/t/m/g/em:a	Lc/t/m/g/em;
      //   2347: invokestatic 282	c/t/m/g/do:a	(Lc/t/m/g/do;ILc/t/m/g/em;)V
      //   2350: return
      //   2351: astore_1
      //   2352: ldc 105
      //   2354: aload_1
      //   2355: invokevirtual 565	java/lang/Exception:toString	()Ljava/lang/String;
      //   2358: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2361: goto -354 -> 2007
      //   2364: iconst_0
      //   2365: istore 9
      //   2367: goto -295 -> 2072
      //   2370: astore_1
      //   2371: ldc 105
      //   2373: new 107	java/lang/StringBuilder
      //   2376: dup
      //   2377: ldc_w 567
      //   2380: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2383: aload_1
      //   2384: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   2387: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2390: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2393: goto -116 -> 2277
      //   2396: aload_1
      //   2397: getfield 236	android/os/Message:obj	Ljava/lang/Object;
      //   2400: checkcast 396	android/util/Pair
      //   2403: astore 12
      //   2405: aload 12
      //   2407: getfield 399	android/util/Pair:first	Ljava/lang/Object;
      //   2410: invokevirtual 241	java/lang/Object:toString	()Ljava/lang/String;
      //   2413: astore_1
      //   2414: aload 12
      //   2416: getfield 402	android/util/Pair:second	Ljava/lang/Object;
      //   2419: checkcast 334	c/t/m/g/du$a
      //   2422: astore 12
      //   2424: aload 12
      //   2426: getfield 404	c/t/m/g/du$a:a	Ljava/lang/Object;
      //   2429: checkcast 269	c/t/m/g/ec
      //   2432: astore 13
      //   2434: aload 12
      //   2436: getfield 345	c/t/m/g/du$a:b	Ljava/lang/String;
      //   2439: astore 14
      //   2441: aload_0
      //   2442: iconst_0
      //   2443: putfield 24	c/t/m/g/do$a:b	I
      //   2446: new 290	c/t/m/g/em$a
      //   2449: dup
      //   2450: invokespecial 292	c/t/m/g/em$a:<init>	()V
      //   2453: astore 12
      //   2455: aload 12
      //   2457: aload_1
      //   2458: putfield 409	c/t/m/g/em$a:a	Ljava/lang/String;
      //   2461: aload 12
      //   2463: iload 4
      //   2465: putfield 296	c/t/m/g/em$a:c	I
      //   2468: aload 12
      //   2470: invokevirtual 299	c/t/m/g/em$a:a	()Lc/t/m/g/em;
      //   2473: astore 12
      //   2475: aload 12
      //   2477: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2480: ldc_w 414
      //   2483: aload_1
      //   2484: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2487: aload 12
      //   2489: invokestatic 420	c/t/m/g/em:a	(Lc/t/m/g/em;)V
      //   2492: aload 12
      //   2494: invokevirtual 319	c/t/m/g/em:getAccuracy	()F
      //   2497: f2d
      //   2498: ldc2_w 506
      //   2501: dcmpl
      //   2502: ifne +328 -> 2830
      //   2505: aload_0
      //   2506: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2509: invokestatic 510	c/t/m/g/do:z	(Lc/t/m/g/do;)Z
      //   2512: ifeq +318 -> 2830
      //   2515: iconst_1
      //   2516: istore 9
      //   2518: aload 12
      //   2520: aload_0
      //   2521: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2524: invokestatic 424	c/t/m/g/do:x	(Lc/t/m/g/do;)Lc/t/m/g/ea;
      //   2527: iload 9
      //   2529: invokestatic 427	c/t/m/g/em:a	(Lc/t/m/g/em;Lc/t/m/g/ea;Z)Lc/t/m/g/em;
      //   2532: pop
      //   2533: aload 12
      //   2535: aload 14
      //   2537: invokestatic 431	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
      //   2540: iconst_0
      //   2541: istore_2
      //   2542: aload 13
      //   2544: invokevirtual 434	c/t/m/g/ec:a	()Lc/t/m/g/eb;
      //   2547: ifnull +12 -> 2559
      //   2550: aload 13
      //   2552: invokevirtual 434	c/t/m/g/ec:a	()Lc/t/m/g/eb;
      //   2555: getfield 437	c/t/m/g/eb:c	I
      //   2558: istore_2
      //   2559: aload 12
      //   2561: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2564: ldc_w 572
      //   2567: iload_2
      //   2568: invokevirtual 575	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   2571: aload 12
      //   2573: invokevirtual 457	c/t/m/g/em:getVerifyKey	()Ljava/lang/String;
      //   2576: ifnull +356 -> 2932
      //   2579: aload 12
      //   2581: invokevirtual 457	c/t/m/g/em:getVerifyKey	()Ljava/lang/String;
      //   2584: ldc_w 459
      //   2587: invokevirtual 100	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   2590: ifne +342 -> 2932
      //   2593: aload 14
      //   2595: ifnull +134 -> 2729
      //   2598: new 461	org/json/JSONObject
      //   2601: dup
      //   2602: aload 14
      //   2604: invokespecial 462	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   2607: astore_1
      //   2608: aload_1
      //   2609: ldc_w 464
      //   2612: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2615: pop
      //   2616: aload_1
      //   2617: ldc_w 470
      //   2620: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2623: pop
      //   2624: aload_1
      //   2625: ldc_w 472
      //   2628: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2631: pop
      //   2632: aload_1
      //   2633: ldc_w 474
      //   2636: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2639: pop
      //   2640: aload_1
      //   2641: ldc_w 476
      //   2644: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2647: pop
      //   2648: aload_1
      //   2649: ldc_w 478
      //   2652: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2655: pop
      //   2656: aload_1
      //   2657: ldc_w 480
      //   2660: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2663: pop
      //   2664: aload_1
      //   2665: ldc_w 482
      //   2668: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2671: pop
      //   2672: aload_1
      //   2673: ldc_w 484
      //   2676: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2679: pop
      //   2680: aload_1
      //   2681: ldc_w 486
      //   2684: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2687: pop
      //   2688: aload_1
      //   2689: ldc_w 488
      //   2692: invokevirtual 468	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2695: pop
      //   2696: aload_1
      //   2697: ldc_w 493
      //   2700: aload_0
      //   2701: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2704: invokestatic 497	c/t/m/g/do:y	(Lc/t/m/g/do;)Lc/t/m/g/dp;
      //   2707: invokevirtual 501	c/t/m/g/dp:e	()Ljava/lang/String;
      //   2710: invokevirtual 579	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   2713: pop
      //   2714: aload 12
      //   2716: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2719: ldc_w 490
      //   2722: aload_1
      //   2723: invokevirtual 491	org/json/JSONObject:toString	()Ljava/lang/String;
      //   2726: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2729: aload 12
      //   2731: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2734: ldc_w 493
      //   2737: aload_0
      //   2738: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2741: invokestatic 497	c/t/m/g/do:y	(Lc/t/m/g/do;)Lc/t/m/g/dp;
      //   2744: invokevirtual 501	c/t/m/g/dp:e	()Ljava/lang/String;
      //   2747: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2750: aload 12
      //   2752: invokevirtual 412	c/t/m/g/em:getExtra	()Landroid/os/Bundle;
      //   2755: aload_0
      //   2756: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2759: invokestatic 51	c/t/m/g/do:c	(Lc/t/m/g/do;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   2762: invokevirtual 65	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   2765: invokevirtual 505	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
      //   2768: aload_0
      //   2769: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2772: aload 12
      //   2774: invokestatic 549	c/t/m/g/do:b	(Lc/t/m/g/do;Lc/t/m/g/em;)Lc/t/m/g/em;
      //   2777: pop
      //   2778: aload 11
      //   2780: aload 12
      //   2782: iconst_0
      //   2783: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   2786: iconst_0
      //   2787: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2790: checkcast 97	java/lang/String
      //   2793: invokeinterface 159 4 0
      //   2798: return
      //   2799: astore_1
      //   2800: ldc 105
      //   2802: ldc_w 564
      //   2805: invokestatic 139	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2808: aload_0
      //   2809: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2812: invokestatic 204	c/t/m/g/do:l	(Lc/t/m/g/do;)Z
      //   2815: ifeq +117 -> 2932
      //   2818: aload_0
      //   2819: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2822: iconst_2
      //   2823: getstatic 279	c/t/m/g/em:a	Lc/t/m/g/em;
      //   2826: invokestatic 282	c/t/m/g/do:a	(Lc/t/m/g/do;ILc/t/m/g/em;)V
      //   2829: return
      //   2830: iconst_0
      //   2831: istore 9
      //   2833: goto -315 -> 2518
      //   2836: astore_1
      //   2837: aload_1
      //   2838: invokevirtual 582	java/lang/Exception:printStackTrace	()V
      //   2841: goto -112 -> 2729
      //   2844: aload_0
      //   2845: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2848: iconst_0
      //   2849: invokestatic 392	c/t/m/g/do:a	(Lc/t/m/g/do;Z)Z
      //   2852: pop
      //   2853: aload_0
      //   2854: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2857: invokestatic 188	c/t/m/g/do:j	(Lc/t/m/g/do;)Z
      //   2860: ifne +72 -> 2932
      //   2863: aload_0
      //   2864: getfield 17	c/t/m/g/do$a:d	Lc/t/m/g/do;
      //   2867: iconst_1
      //   2868: getstatic 279	c/t/m/g/em:a	Lc/t/m/g/em;
      //   2871: invokestatic 282	c/t/m/g/do:a	(Lc/t/m/g/do;ILc/t/m/g/em;)V
      //   2874: return
      //   2875: aload_0
      //   2876: aload_0
      //   2877: getfield 24	c/t/m/g/do$a:b	I
      //   2880: iconst_1
      //   2881: iadd
      //   2882: putfield 24	c/t/m/g/do$a:b	I
      //   2885: aload_0
      //   2886: getfield 24	c/t/m/g/do$a:b	I
      //   2889: iconst_3
      //   2890: if_icmpne +42 -> 2932
      //   2893: aload 11
      //   2895: getstatic 279	c/t/m/g/em:a	Lc/t/m/g/em;
      //   2898: iconst_5
      //   2899: invokestatic 147	c/t/m/g/do:j	()Landroid/util/SparseArray;
      //   2902: iconst_5
      //   2903: invokevirtual 153	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2906: checkcast 97	java/lang/String
      //   2909: invokeinterface 159 4 0
      //   2914: aload_0
      //   2915: iconst_0
      //   2916: putfield 24	c/t/m/g/do$a:b	I
      //   2919: return
      //   2920: astore_1
      //   2921: goto -153 -> 2768
      //   2924: astore_1
      //   2925: goto -648 -> 2277
      //   2928: astore_1
      //   2929: goto -883 -> 2046
      //   2932: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2933	0	this	a
      //   0	2933	1	paramMessage	Message
      //   981	1587	2	i	int
      //   814	512	3	j	int
      //   52	2412	4	k	int
      //   59	2122	5	l1	long
      //   655	247	7	l2	long
      //   442	2390	9	bool1	boolean
      //   71	1025	10	bool2	boolean
      //   33	2861	11	localObject1	Object
      //   7	2774	12	localObject2	Object
      //   45	2506	13	localObject3	Object
      //   661	1942	14	localObject4	Object
      //   1736	163	15	str	String
      // Exception table:
      //   from	to	target	type
      //   12	25	186	finally
      //   26	38	186	finally
      //   1304	1361	1374	java/io/UnsupportedEncodingException
      //   1498	1572	1591	java/io/UnsupportedEncodingException
      //   1738	1786	2320	org/json/JSONException
      //   1894	2007	2351	java/lang/Exception
      //   2205	2211	2370	java/lang/Exception
      //   2215	2277	2370	java/lang/Exception
      //   2446	2492	2799	org/json/JSONException
      //   2598	2729	2836	java/lang/Exception
      //   2729	2768	2920	java/lang/Exception
      //   2205	2211	2924	java/lang/Error
      //   2215	2277	2924	java/lang/Error
      //   2007	2046	2928	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.do
 * JD-Core Version:    0.7.0.1
 */