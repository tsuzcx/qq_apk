package c.t.m.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentPedestrianData;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class ek
{
  private static SparseArray<String> n;
  private eq A;
  private et B;
  private ex C;
  private eu D;
  private ev E;
  private final ea F;
  private String G = "stop";
  private boolean H = false;
  private final Object I = new Object();
  private final TencentLocationRequest J = TencentLocationRequest.create();
  private double K;
  private double L;
  private fi M;
  private final boolean N;
  private boolean O;
  private long P;
  private long Q;
  private long R;
  private String S;
  private boolean T;
  public int a = 1;
  public final eh b;
  public final el c;
  public TencentLocationListener d;
  public boolean e = false;
  public double f = 0.0D;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public TencentLocation j;
  public TencentDistanceListener k;
  public fi l;
  public int m = 404;
  private ek.a o;
  private final ef p;
  private final en q;
  private final boolean r;
  private final ej s;
  private final er t;
  private final em u;
  private final ep v;
  private co w;
  private volatile boolean x = false;
  private HandlerThread y;
  private int z = 0;
  
  static
  {
    Object localObject = new SparseArray();
    n = (SparseArray)localObject;
    ((SparseArray)localObject).put(0, "OK");
    n.put(1, "ERROR_NETWORK");
    n.put(2, "BAD_JSON");
    n.put(4, "DEFLECT_FAILED");
    n.put(5, "VERIFYKEY_ERROR_NETWORK");
    localObject = new HashMap();
    ((HashMap)localObject).put("https", "true");
    ((HashMap)localObject).put("up_apps", "true");
    ((HashMap)localObject).put("start_daemon", "false");
    ((HashMap)localObject).put("up_daemon_delay", "600000");
    ((HashMap)localObject).put("gps_kalman", "false");
    ((HashMap)localObject).put("min_wifi_scan_interval", "8000");
    ((HashMap)localObject).put("f_coll_item", "2");
    ((HashMap)localObject).put("f_coll_up_net", "w");
    cz.a((HashMap)localObject);
  }
  
  public ek(ea paramea)
  {
    this.F = paramea;
    this.u = new em(this.F);
    this.v = new ep(this.F);
    this.A = new eq();
    this.b = eh.a(paramea.a);
    this.c = el.b();
    if (Build.VERSION.SDK_INT >= 18) {
      bool = true;
    } else {
      bool = false;
    }
    this.r = bool;
    boolean bool = this.r;
    Object localObject = null;
    paramea = null;
    if (bool)
    {
      this.p = null;
      this.t = h();
      if (this.F.b()) {
        paramea = new en(this.F);
      }
      this.q = paramea;
      this.s = g();
      this.N = false;
    }
    else
    {
      this.q = null;
      this.t = h();
      if (!this.F.b()) {
        paramea = localObject;
      } else {
        paramea = new ef(this.F);
      }
      this.p = paramea;
      this.s = g();
      this.N = false;
    }
    this.F.a(this);
    try
    {
      cz.a(this.F.a, "txsdk", this.F.b.d());
      return;
    }
    catch (Throwable paramea) {}
  }
  
  private static String a(String paramString)
  {
    if (paramString.contains(",")) {}
    try
    {
      paramString = paramString.split(",");
      i1 = 1;
      if ((paramString == null) || (paramString.length <= 1) || (paramString[0] == null) || (paramString[1] == null) || (e.w(paramString[0], paramString[1]) <= 0)) {
        break label83;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      break label77;
      int i1 = 0;
      if (i1 == 0) {
        break label93;
      }
      return paramString[0];
    }
    i1 = e.v(paramString);
    if (i1 >= 0)
    {
      paramString = Integer.toString(i1);
      return paramString;
    }
    return "";
    label77:
    return null;
    label83:
    label93:
    return "";
  }
  
  private void a(int paramInt)
  {
    ek.a locala = this.o;
    if (locala != null) {
      locala.sendEmptyMessage(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str1 = null;
    String str2 = "gps";
    switch (paramInt1)
    {
    default: 
      str2 = null;
      break;
    case 12004: 
      if (paramInt2 != 3) {
        if (paramInt2 != 4) {
          str1 = "unknown";
        }
      }
      for (;;)
      {
        str2 = "gps";
        break;
        str1 = "gps unavailable";
        continue;
        str1 = "gps available";
      }
    case 12003: 
      if (paramInt2 == 1) {
        str1 = "cell enabled";
      }
      for (;;)
      {
        break;
        if (paramInt2 == 0) {
          str1 = "cell disabled";
        } else {
          str1 = "unknown";
        }
      }
      if (fj.a) {
        a(3999);
      }
      break;
    }
    for (str2 = "cell";; str2 = "wifi")
    {
      str1 = "location permission denied";
      paramInt2 = 2;
      break label269;
      str2 = "cell";
      break label269;
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 5)
          {
            str1 = "unknown";
            break label269;
          }
          a(3999);
          str1 = "location permission denied";
          break label269;
        }
        str1 = "gps enabled";
        break label269;
      }
      str1 = "gps disabled";
      break label269;
      if (paramInt2 != 0) {
        if (paramInt2 != 1) {
          if (paramInt2 != 5) {
            str1 = "unknown";
          }
        }
      }
      for (;;)
      {
        break;
        a(3999);
        str1 = "location service switch is off";
        continue;
        str1 = "wifi enabled";
        continue;
        str1 = "wifi disabled";
      }
      if ((paramInt2 == 5) || (!fq.a)) {
        break;
      }
    }
    str2 = "wifi";
    label269:
    synchronized (this.I)
    {
      if (this.d != null) {
        this.d.onStatusUpdate(str2, paramInt2, str1);
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    ek.a locala = this.o;
    if (locala != null)
    {
      locala.removeMessages(paramInt);
      this.o.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, fi paramfi)
  {
    if (paramfi == null) {
      return;
    }
    int i1;
    if ((paramInt == 0) && (paramfi.getLatitude() != 0.0D) && (paramfi.getLongitude() != 0.0D))
    {
      if ((this.a == 1) && (fk.a(paramfi.getLatitude(), paramfi.getLongitude()))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      fi.a(paramfi, i1);
    }
    if (m())
    {
      if ((this.m != 0) && (paramInt == 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.m = paramInt;
      this.l = paramfi;
      if ((paramfi.getAccuracy() < 500.0F) && (paramfi.getAccuracy() > 0.0F))
      {
        this.A.a(paramfi);
        if (this.e) {
          this.j = paramfi;
        }
      }
      this.K = paramfi.getLatitude();
      this.L = paramfi.getLongitude();
      if (this.d != null) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if ((i2 != 0) && (this.J.getInterval() > 0L) && (!this.J.getExtras().getBoolean("daemon")))
      {
        a(11999, this.J.getInterval());
        if (this.J.getCheckInterval() != -1L) {
          a(3998, this.J.getCheckInterval());
        }
      }
      if (i1 != 0) {
        a(11998);
      }
    }
    else if ((paramInt == 0) && (paramfi.getLatitude() != 0.0D) && (paramfi.getLongitude() != 0.0D) && (Math.abs(paramfi.getLatitude() - this.K) >= 1.0E-007D) && (Math.abs(paramfi.getLongitude() - this.L) >= 1.0E-007D))
    {
      if (!this.A.a(paramfi, this.F))
      {
        new StringBuilder("discard ").append(paramfi);
        return;
      }
      this.K = paramfi.getLatitude();
      this.L = paramfi.getLongitude();
      if ((paramfi.getAccuracy() < 500.0F) && (paramfi.getAccuracy() > 0.0F))
      {
        this.A.a(paramfi);
        this.A.a(paramfi);
        if (this.e)
        {
          localObject = this.j;
          if (localObject != null)
          {
            double d1 = fp.a(((TencentLocation)localObject).getLatitude(), this.j.getLongitude(), paramfi.getLatitude(), paramfi.getLongitude());
            if (((paramfi.getProvider().equalsIgnoreCase("network")) && (d1 > 10.0D)) || ((paramfi.getProvider().equalsIgnoreCase("gps")) && (d1 > 3.0D)))
            {
              this.f += d1;
              if (paramfi.getProvider().equalsIgnoreCase("network")) {
                this.h += 1;
              } else {
                this.g += 1;
              }
              this.i += 1;
              this.j = paramfi;
            }
          }
          else
          {
            this.j = paramfi;
          }
        }
      }
    }
    int i3 = 1;
    if ((this.m != 0) && (paramInt == 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (this.m == 0)
    {
      localObject = this.l;
      i2 = i1;
      if (localObject != null)
      {
        i2 = i1;
        if (((fi)localObject).getProvider().equals("network"))
        {
          i2 = i1;
          if (paramInt == 0)
          {
            i2 = i1;
            if (paramfi != null)
            {
              i2 = i1;
              if (paramfi.getProvider().equals("gps")) {
                i2 = 1;
              }
            }
          }
        }
      }
    }
    this.m = paramInt;
    this.l = paramfi;
    Object localObject = new StringBuilder("updateLast");
    ((StringBuilder)localObject).append(paramfi.getLatitude());
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramfi.getLongitude());
    if (this.J.getInterval() == 0L)
    {
      if (this.d != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        a(11998);
      }
    }
    if (i2 != 0)
    {
      if (this.d != null) {
        paramInt = i3;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        a(11998);
      }
    }
  }
  
  @Nullable
  private ej g()
  {
    if (!this.F.d()) {
      return null;
    }
    return new ej(this.F);
  }
  
  @Nullable
  private er h()
  {
    if (!this.F.c()) {
      return null;
    }
    return new er(this.F);
  }
  
  private dt i()
  {
    try
    {
      Object localObject = this.F.b;
      localObject = new dt(((du)localObject).j, ((du)localObject).d(), ((du)localObject).f());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label30:
      break label30;
    }
    return new dt("unknown", "unknown", "unknown");
  }
  
  private void j()
  {
    if (this.z == 0)
    {
      if (!da.a().d("start_daemon")) {
        return;
      }
      this.P = da.a().c("up_daemon_delay");
      if (this.P < 120000L) {
        this.P = 120000L;
      }
    }
    try
    {
      if (fq.c(this.F).equalsIgnoreCase("{}"))
      {
        TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create().setInterval(this.P).setRequestLevel(0);
        localTencentLocationRequest.getExtras().putBoolean("daemon", true);
        ek.2 local2 = new ek.2(this);
        this.y = new HandlerThread("daemonthread");
        this.y.start();
        a(localTencentLocationRequest, local2, this.y.getLooper());
        this.z = 1;
        this.Q = System.currentTimeMillis();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void k()
  {
    fj.a = false;
    this.u.a();
    this.v.a();
    this.A.a();
    Object localObject = this.t;
    int i2 = 1;
    int i1;
    if (localObject != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      this.t.a();
    }
    if (this.r)
    {
      if (this.q != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        this.q.a();
      }
    }
    else
    {
      if (this.p != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        this.p.a();
      }
    }
    if (this.s != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      this.s.a();
    }
    if ((this.J.isAllowDirection()) && (!this.b.a)) {
      this.b.a();
    }
    if (!this.J.getExtras().getBoolean("daemon"))
    {
      if (this.c != null) {
        i1 = i2;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        this.c.c();
      }
    }
    if (this.x)
    {
      cz.a().c();
      this.x = false;
    }
    localObject = this.w;
    if (localObject != null) {
      ((co)localObject).a();
    }
  }
  
  private void l()
  {
    this.l = null;
    this.m = 404;
    this.C = null;
    this.B = null;
    this.D = null;
    this.H = false;
    this.T = false;
    ev.a = 0;
    this.F.a("cell").a();
  }
  
  private boolean m()
  {
    return this.m == 404;
  }
  
  private boolean n()
  {
    ej localej = this.s;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localej != null)
    {
      bool1 = bool2;
      if (localej.b())
      {
        localej = this.s;
        int i1;
        if (((localej.c & 0x2) == 2) && (System.currentTimeMillis() - localej.a < ei.a().b())) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        bool1 = bool2;
        if (i1 != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper arg3)
  {
    if (this.z == 1)
    {
      d();
      ??? = this.y;
      if (??? != null)
      {
        ((HandlerThread)???).quit();
        this.y = null;
      }
      this.z = 0;
    }
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {}
    try
    {
      System.loadLibrary("c++_shared");
    }
    catch (Error ???)
    {
      try
      {
        System.loadLibrary("tencentloc");
        break label62;
        return 3;
        label62:
        ??? = this.F;
        ??? = ((ea)???).b;
        if (("0123456789ABCDEF".equals(((du)???).a())) && ("0123456789ABCDEF".equals(((du)???).b()))) {
          ((ea)???).a();
        }
        ??? = co.e(((du)???).g);
        this.S = a((String)???);
        if (TextUtils.isEmpty(this.S))
        {
          paramTencentLocationRequest = new StringBuilder("requestLocationUpdates: illegal key [");
          paramTencentLocationRequest.append((String)???);
          paramTencentLocationRequest.append("]");
          return 2;
        }
        l();
        synchronized (this.I)
        {
          this.d = paramTencentLocationListener;
          TencentLocationRequest.copy(this.J, paramTencentLocationRequest);
          ((du)???).f = paramTencentLocationRequest.getQQ();
          if (TextUtils.isEmpty(co.e(((du)???).d))) {
            ((du)???).d = paramTencentLocationRequest.getPhoneNumber();
          }
          if (paramTencentLocationRequest.getInterval() == 0L) {
            l1 = 8000L;
          } else {
            l1 = paramTencentLocationRequest.getInterval();
          }
          ((du)???).k = Math.max(da.a().c("min_wifi_scan_interval"), l1);
          if (Looper.myLooper() == null) {
            Looper.prepare();
          }
          if (this.o == null) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 != 0)
          {
            this.o = new ek.a(this, ???);
          }
          else
          {
            this.o.removeCallbacksAndMessages(null);
            if (this.o.getLooper() != ???) {
              this.o = new ek.a(this, ???);
            }
          }
          k();
          l1 = System.currentTimeMillis();
          new StringBuilder("registercost:").append(System.currentTimeMillis() - l1);
          bool1 = this.J.getExtras().getBoolean("use_network", true);
          bool2 = this.J.getExtras().getBoolean("daemon");
          paramTencentLocationRequest = this.o;
          paramTencentLocationListener = this.u;
          if (!paramTencentLocationListener.b) {
            paramTencentLocationListener.b = true;
          }
        }
      }
      catch (Error ???)
      {
        try
        {
          ??? = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
          paramTencentLocationListener.a.a.registerReceiver(paramTencentLocationListener, ???, null, paramTencentLocationRequest);
          paramTencentLocationListener = this.v;
          if (!paramTencentLocationListener.g)
          {
            paramTencentLocationListener.g = true;
            paramTencentLocationListener.b.d.execute(new ep.1(paramTencentLocationListener, paramTencentLocationRequest));
            paramTencentLocationListener.f = SystemClock.elapsedRealtime();
          }
          new StringBuilder("sendercost:").append(System.currentTimeMillis() - l1);
          if (bool2) {
            this.v.a(this.F.a(true));
          }
          new StringBuilder("postlistcost:").append(System.currentTimeMillis() - l1);
          if (this.r)
          {
            if (!bool1) {
              break label880;
            }
            if (this.q != null) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i1 == 0) {
              break label880;
            }
            paramTencentLocationListener = this.q;
            if (paramTencentLocationListener.a) {
              break label880;
            }
            paramTencentLocationListener.i = paramTencentLocationRequest;
            paramTencentLocationListener.f = new HandlerThread("new_cell_provider");
            if ((paramTencentLocationListener.f == null) || (paramTencentLocationListener.i == null)) {
              break label880;
            }
          }
        }
        catch (Exception ???)
        {
          try
          {
            paramTencentLocationListener.f.start();
            paramTencentLocationListener.g = new en.a(paramTencentLocationListener, paramTencentLocationListener.f.getLooper(), (byte)0);
            break label689;
            paramTencentLocationListener.g = new en.a(paramTencentLocationListener, paramTencentLocationListener.i.getLooper(), (byte)0);
            label689:
            paramTencentLocationListener.a = true;
            if (!bool2) {
              co.a(paramTencentLocationListener.g, 0, 0L);
            }
            paramTencentLocationListener.g.postDelayed(new en.1(paramTencentLocationListener), 1000L);
            break label880;
            if (bool1)
            {
              if (this.p != null) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (i1 != 0)
              {
                paramTencentLocationListener = this.p;
                if (!paramTencentLocationListener.a)
                {
                  paramTencentLocationListener.a = true;
                  paramTencentLocationListener.d = new HandlerThread("CellProvider");
                  paramTencentLocationListener.d.start();
                  paramTencentLocationListener.e = new ef.a(paramTencentLocationListener, paramTencentLocationListener.d.getLooper(), (byte)0);
                  paramTencentLocationListener.e.sendEmptyMessageDelayed(0, 3000L);
                  ??? = fj.a(paramTencentLocationListener.b);
                  if (paramTencentLocationListener.a(???))
                  {
                    ??? = et.a(paramTencentLocationListener.b, ???, null);
                    if (??? != null)
                    {
                      paramTencentLocationListener.c = ???;
                      paramTencentLocationListener.b.b(???);
                    }
                  }
                  paramTencentLocationListener.a(273);
                }
              }
            }
            label880:
            new StringBuilder("cellcost:").append(System.currentTimeMillis() - l1);
            if (bool1)
            {
              if (this.t != null) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (i1 != 0)
              {
                paramTencentLocationListener = this.t;
                if (!paramTencentLocationListener.a)
                {
                  paramTencentLocationListener.a = true;
                  paramTencentLocationListener.d = false;
                  paramTencentLocationListener.c = bool2;
                  er.e = paramTencentLocationRequest;
                  ??? = new IntentFilter();
                  ???.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                  ???.addAction("android.net.wifi.SCAN_RESULTS");
                }
              }
            }
          }
          catch (Throwable ???)
          {
            try
            {
              boolean bool1;
              paramTencentLocationListener.b.a.registerReceiver(paramTencentLocationListener, ???, null, paramTencentLocationRequest);
              if (!paramTencentLocationListener.c) {
                paramTencentLocationListener.a(0L);
              }
              new StringBuilder("wificost:").append(System.currentTimeMillis() - l1);
              if (!bool2) {
                this.O = true;
              }
              if (this.s != null) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if ((i1 != 0) && (this.J.isAllowGPS()))
              {
                paramTencentLocationListener = this.s;
                if (this.a == 1) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                paramTencentLocationListener.f = bool1;
                paramTencentLocationListener = this.s;
                this.J.getInterval();
                if (!paramTencentLocationListener.d)
                {
                  paramTencentLocationListener.d = true;
                  paramTencentLocationListener.g = new HandlerThread("gps_provider");
                  ??? = paramTencentLocationListener.b.h;
                  paramTencentLocationListener.g.start();
                  paramTencentLocationListener.i = new Handler(paramTencentLocationListener.g.getLooper());
                  if (bool2) {}
                }
              }
            }
            catch (Exception ???)
            {
              try
              {
                for (;;)
                {
                  long l1;
                  boolean bool2;
                  paramTencentLocationListener.b.h.requestLocationUpdates("gps", 1000L, 0.0F, paramTencentLocationListener.j, paramTencentLocationListener.g.getLooper());
                  label1201:
                  paramTencentLocationListener.i.post(paramTencentLocationListener.h);
                  paramTencentLocationListener.e = System.currentTimeMillis();
                  break label1249;
                  ???.requestLocationUpdates("passive", 5000L, 0.0F, paramTencentLocationListener, paramTencentLocationListener.g.getLooper());
                  break label1249;
                  label1245:
                  fj.a = true;
                  label1249:
                  if (paramTencentLocationListener.b())
                  {
                    paramTencentLocationListener.c = 4;
                    paramTencentLocationListener.c();
                  }
                  new StringBuilder("gpscost:").append(System.currentTimeMillis() - l1);
                  if ((this.J.isAllowDirection()) && (!this.b.a)) {
                    this.b.a(paramTencentLocationRequest, null);
                  }
                  if ((!bool2) && (this.J.isAllowPedometer()))
                  {
                    paramTencentLocationListener = this.c;
                    el.f = this.F.a;
                    el.i = dy.a("LocationSDK");
                    paramTencentLocationListener.g = new HandlerThread("Sensor");
                    paramTencentLocationListener.g.start();
                    paramTencentLocationListener.a.i = paramTencentLocationListener;
                    if (Build.VERSION.SDK_INT != 23) {
                      paramTencentLocationListener.b = ((SensorManager)el.f.getSystemService("sensor"));
                    }
                    if (paramTencentLocationListener.b != null)
                    {
                      paramTencentLocationListener.c = paramTencentLocationListener.b.getDefaultSensor(1);
                      paramTencentLocationListener.d = paramTencentLocationListener.b.getDefaultSensor(10);
                      if (Build.VERSION.SDK_INT >= 19) {
                        paramTencentLocationListener.e = paramTencentLocationListener.b.getDefaultSensor(19);
                      }
                    }
                    paramTencentLocationListener.d();
                  }
                  int i1 = da.a().b("f_coll_item");
                  if (((i1 == 1) || (i1 == 2)) && (this.w == null)) {
                    this.w = new co(this.F.a);
                  }
                  if ((this.w != null) && (paramTencentLocationRequest != null))
                  {
                    paramTencentLocationListener = new StringBuilder("fc,set:");
                    paramTencentLocationListener.append(i1);
                    paramTencentLocationListener.append(",daemon:");
                    paramTencentLocationListener.append(bool2);
                    paramTencentLocationListener.append(",version:1.5.4_200103");
                    if ((i1 == 2) || ((i1 == 1) && (!bool2)))
                    {
                      ??? = this.w;
                      paramTencentLocationListener = i();
                      synchronized (???.a)
                      {
                        cu.i = paramTencentLocationListener;
                        if (co.e())
                        {
                          ??? = new StringBuilder("appInfo:1.5.4,");
                          ((StringBuilder)???).append(dt.a(paramTencentLocationListener.b));
                          ((StringBuilder)???).append("_");
                          ((StringBuilder)???).append(dt.a(paramTencentLocationListener.a));
                          ((StringBuilder)???).append(",");
                          ((StringBuilder)???).append(dt.a(Build.MANUFACTURER));
                          ((StringBuilder)???).append(",");
                          ((StringBuilder)???).append(dt.a(Build.MODEL));
                          co.a(((StringBuilder)???).toString());
                        }
                        this.w.a("D_UP_NET", da.a().e("f_coll_up_net"));
                        this.w.a("D_WRITE_MAC", "false");
                        ??? = this.w;
                        paramTencentLocationListener = paramTencentLocationRequest.getLooper();
                        synchronized (???.a)
                        {
                          co.a("startup");
                          ???.d();
                          if (???.b != null)
                          {
                            paramTencentLocationRequest = paramTencentLocationListener;
                            if (paramTencentLocationListener == null)
                            {
                              ???.c = ds.a("th_loc_extra");
                              paramTencentLocationRequest = ???.c.getLooper();
                            }
                            ???.b.b(paramTencentLocationRequest);
                          }
                        }
                      }
                    }
                  }
                  this.G = "start";
                  cz.a(this.S);
                  return 0;
                  paramTencentLocationRequest = finally;
                  throw paramTencentLocationRequest;
                  localError = localError;
                  continue;
                  paramTencentLocationRequest = paramTencentLocationRequest;
                  continue;
                  paramTencentLocationListener = paramTencentLocationListener;
                  continue;
                  ??? = ???;
                }
                ??? = ???;
              }
              catch (Throwable ???)
              {
                break label1201;
              }
              catch (Exception ???)
              {
                break label1245;
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(fi paramfi)
  {
    if (paramfi != null) {}
    try
    {
      if (this.J.isAllowDirection()) {
        paramfi.getExtra().putDouble("direction", this.b.b());
      }
      paramfi.getExtra().putString("motion", this.c.e());
      paramfi.getExtra().putAll(this.J.getExtras());
      return;
    }
    catch (Throwable paramfi) {}
  }
  
  @TargetApi(19)
  public final boolean a()
  {
    if ((Build.VERSION.SDK_INT < 19) && (Build.VERSION.SDK_INT == 23)) {
      return false;
    }
    try
    {
      Sensor localSensor = ((SensorManager)this.F.a.getSystemService("sensor")).getDefaultSensor(19);
      return localSensor != null;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final int b()
  {
    try
    {
      Object localObject1 = this.F.c;
      Object localObject2 = ((SharedPreferences)localObject1).getString("stepStr", "");
      float f1 = 0.0F;
      long l1 = 0L;
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      if (!bool)
      {
        localObject2 = ((String)localObject2).split(",");
        f1 = Float.valueOf(localObject2[0]).floatValue();
        l1 = Long.valueOf(localObject2[1]).longValue();
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(f1);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(",0");
      ((SharedPreferences.Editor)localObject1).putString("stepStr", ((StringBuilder)localObject2).toString()).apply();
      return 0;
    }
    catch (Throwable localThrowable)
    {
      label144:
      break label144;
    }
    return -1;
  }
  
  public final TencentPedestrianData c()
  {
    Object localObject1 = this.F.c;
    if (localObject1 == null) {
      return null;
    }
    try
    {
      localObject2 = ((SharedPreferences)localObject1).getString("stepStr", "");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      f2 = 0.0F;
      if (bool) {
        break label191;
      }
      localObject2 = ((String)localObject2).split(",");
      f2 = Float.valueOf(localObject2[0]).floatValue();
      l1 = Long.valueOf(localObject2[1]).longValue();
      f1 = Float.valueOf(localObject2[2]).floatValue();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        float f2;
        continue;
        long l1 = 0L;
        float f1 = 0.0F;
      }
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(f2);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(f1);
    ((SharedPreferences.Editor)localObject1).putString("stepStr", ((StringBuilder)localObject2).toString()).apply();
    localObject1 = new ek.1(this, f1, l1);
    return localObject1;
    return null;
  }
  
  public final void d()
  {
    k();
    int i1;
    if (this.o != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      this.o.a();
    }
    synchronized (this.I)
    {
      this.d = null;
      l();
      this.G = "stop";
      j();
      return;
    }
  }
  
  public final void onCellInfoEvent(et paramet)
  {
    new StringBuilder("cellCallback:").append(System.currentTimeMillis());
    int i4 = paramet.e;
    int i5 = paramet.f;
    Object localObject = this.B;
    int i2;
    int i1;
    if (localObject != null)
    {
      i2 = ((et)localObject).f;
      i1 = ((et)localObject).e;
    }
    else
    {
      i1 = 0;
      i2 = 0;
    }
    this.B = paramet;
    localObject = this.t;
    int i3;
    if (localObject != null) {
      i3 = ((er)localObject).b() ^ true;
    } else {
      i3 = 1;
    }
    if (i3 != 0) {
      this.C = null;
    }
    if (i3 == 0)
    {
      localObject = this.C;
      if ((localObject == null) || (((ex)localObject).a(System.currentTimeMillis(), 30000L)))
      {
        localObject = this.o;
        if (localObject == null) {
          break label177;
        }
        localObject = ((ek.a)localObject).obtainMessage(3999, "wifi_not_received");
        this.o.sendMessageDelayed((Message)localObject, 2000L);
        break label177;
      }
    }
    a(3999);
    label177:
    if (i3 == 0) {
      localObject = "scan wifi";
    } else {
      localObject = "prepare json. wifi is not scannable?";
    }
    String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), localObject });
    if (this.w != null)
    {
      localObject = new cp(paramet.b, paramet.c, paramet.d, paramet.e, paramet.f, paramet.a.ordinal());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      paramet = paramet.b().iterator();
      while (paramet.hasNext())
      {
        et localet = (et)paramet.next();
        localArrayList.add(new cp(localet.b, localet.c, localet.d, localet.e, localet.f, localet.a.ordinal()));
      }
      this.w.a((cp)localObject, localArrayList);
    }
  }
  
  public final void onGpsInfoEvent(eu arg1)
  {
    Location localLocation;
    Object localObject3;
    if (???.a != eg.a)
    {
      this.D = ???;
      if (!this.J.getExtras().getBoolean("daemon"))
      {
        int i6 = ei.a().a(???);
        int i5 = this.a;
        int i2 = this.J.getRequestLevel();
        localObject1 = this.M;
        localLocation = new Location(???.a);
        localObject3 = localLocation.getExtras();
        double d1;
        double d2;
        int i1;
        if (localObject3 != null)
        {
          d1 = ((Bundle)localObject3).getDouble("lat");
          d2 = ((Bundle)localObject3).getDouble("lng");
          i1 = ((Bundle)localObject3).getInt("fakeCode");
        }
        else
        {
          i1 = 0;
          d1 = 0.0D;
          d2 = 0.0D;
        }
        int i3 = 1;
        if (i1 != 0)
        {
          this.T = true;
          i1 = (int)(Math.pow(2.0D, i1 + 3) + 4.0D);
        }
        else
        {
          i1 = 0;
        }
        int i4 = i2;
        i2 = i1;
        if (i6 == -1)
        {
          this.T = true;
          i2 = i1 + 2;
        }
        if (i5 == 0) {
          i1 = i3;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          localObject3 = new fi.a();
          ((fi.a)localObject3).b = ((fi)localObject1);
          ((fi.a)localObject3).d = "gps";
          if (this.T) {
            localObject1 = "fake";
          } else {
            localObject1 = "gps";
          }
          ((fi.a)localObject3).e = ((String)localObject1);
          ((fi.a)localObject3).c = i4;
          localObject1 = ((fi.a)localObject3).a(new Location(???.a)).a();
          localLocation.setLatitude(d1);
          localLocation.setLongitude(d2);
          ((fi)localObject1).a(localLocation);
          ((fi)localObject1).a(i2);
          a(0, (fi)localObject1);
        }
        else
        {
          if (m()) {
            a(3999);
          }
          localObject3 = new fi.a();
          ((fi.a)localObject3).b = ((fi)localObject1);
          ((fi.a)localObject3).d = "gps";
          if (this.T) {
            localObject1 = "fake";
          } else {
            localObject1 = "gps";
          }
          ((fi.a)localObject3).e = ((String)localObject1);
          ((fi.a)localObject3).c = i4;
          localObject1 = ((fi.a)localObject3).a(new Location(???.a)).a();
          localLocation.setLatitude(d1);
          localLocation.setLongitude(d2);
          ((fi)localObject1).a(localLocation);
          ((fi)localObject1).a(i2);
          a(0, (fi)localObject1);
          a(12004, 3);
        }
      }
    }
    Object localObject1 = this.w;
    if (localObject1 != null)
    {
      localLocation = ???.a;
      synchronized (((co)localObject1).a)
      {
        if (!((co)localObject1).c()) {
          return;
        }
        co.a("setGpsLocation");
        if (((co)localObject1).b != null)
        {
          localObject3 = ((co)localObject1).b;
          if (((cq)localObject3).l != null) {
            ((cq)localObject3).l.a(localLocation);
          }
        }
        if ((localLocation != null) && ("gps".equals(localLocation.getProvider())) && (localLocation.getAltitude() != 0.0D))
        {
          boolean bool = cu.h;
          if ((Build.VERSION.SDK_INT >= 18) && (localLocation.isFromMockProvider())) {
            return;
          }
          ((co)localObject1).d = co.a(((co)localObject1).d, localLocation);
          if ((((co)localObject1).e == null) || ((((co)localObject1).d != null) && (((co)localObject1).d.distanceTo(((co)localObject1).e) >= 50.0F) && (System.currentTimeMillis() - ((co)localObject1).k >= 5000L))) {
            ((co)localObject1).b();
          }
        }
        return;
      }
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    int i1 = fn.a(this.F.a);
    if (i1 != -1)
    {
      if (i1 == 0)
      {
        str = "mobile";
        break label43;
      }
      if (i1 == 1)
      {
        str = "wifi";
        break label43;
      }
    }
    String str = "none";
    label43:
    i1 = paramInteger.intValue();
    if (i1 != -1)
    {
      if (i1 != 0)
      {
        if (i1 != 1) {
          return;
        }
        paramInteger = new StringBuilder("onNetworkEvent: ");
        paramInteger.append(str);
        paramInteger.append(" connected");
        a(7999, 1000L);
        return;
      }
      paramInteger = new StringBuilder("onNetworkEvent: ");
      paramInteger.append(str);
      paramInteger.append(" disconnected");
    }
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(ex paramex)
  {
    new StringBuilder("wifiCallback:").append(System.currentTimeMillis());
    ??? = this.o;
    if (??? != null) {
      ((ek.a)???).removeMessages(3999, "wifi_not_received");
    }
    if (paramex == ex.a)
    {
      a(555, 1500L);
    }
    else
    {
      if ((this.C == null) || (!this.H) || (Collections.unmodifiableList(paramex.b).size() < 3) || (!this.C.a(paramex))) {
        a(3999);
      }
      this.C = paramex;
    }
    co localco = this.w;
    List localList;
    if (localco != null) {
      localList = Collections.unmodifiableList(paramex.b);
    }
    for (;;)
    {
      synchronized (localco.a)
      {
        if (!localco.c()) {
          return;
        }
        try
        {
          long l1 = System.currentTimeMillis();
          boolean bool1 = cy.a(localco.g, localList);
          co.a("setWifiResults, same pre:".concat(String.valueOf(bool1)));
          long l2;
          if (bool1)
          {
            l2 = localco.j;
            if (l1 - l2 > 30000L) {
              return;
            }
          }
          if (localco.b != null)
          {
            paramex = localco.b;
            if (paramex.k != null)
            {
              paramex = paramex.k;
              if ((paramex.f()) && (!co.a(localList)))
              {
                Message localMessage = paramex.e().obtainMessage(102);
                localMessage.obj = localList;
                paramex.b(localMessage);
              }
            }
          }
          if ((localco.b != null) && (localco.d != null) && (!co.a(localList)))
          {
            boolean bool2;
            if (localList.size() == 1)
            {
              bool2 = "123456789abc".equals(((ScanResult)localList.get(0)).BSSID.toLowerCase());
              if (!bool2) {}
            }
            else if (localList.size() > 1)
            {
              bool2 = cy.a(localList);
              if (bool2) {
                return;
              }
            }
            if (cu.f)
            {
              l2 = localco.j;
              if (l1 - l2 < 5000L) {
                return;
              }
            }
            if (!bool1)
            {
              localco.j = l1;
              localco.g = localList;
            }
            if (l1 - localco.i >= localco.h) {
              break label485;
            }
            paramex = localco.f;
            localco.b.a(localco.d, localList, paramex);
          }
        }
        catch (Throwable paramex)
        {
          co.a("setWifiResults error.", paramex);
        }
        return;
      }
      return;
      label485:
      paramex = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ek
 * JD-Core Version:    0.7.0.1
 */