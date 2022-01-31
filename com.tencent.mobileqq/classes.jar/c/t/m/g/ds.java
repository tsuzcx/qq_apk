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
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentPedestrianData;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jdt.annotation.Nullable;

public final class ds
{
  private static SparseArray<String> n;
  private dz A;
  private final df B;
  private ee C;
  private ei D;
  private ef E;
  private eg F;
  private final de G;
  private String H = "stop";
  private boolean I = false;
  private final Object J = new Object();
  private final TencentLocationRequest K = TencentLocationRequest.create();
  private double L;
  private double M;
  private eq N;
  private final boolean O;
  private boolean P;
  private long Q;
  private long R;
  private long S;
  private String T;
  private boolean U;
  public int a = 1;
  public final dp b;
  public final dt c;
  public TencentLocationListener d;
  public boolean e = false;
  public double f = 0.0D;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public TencentLocation j;
  public TencentDistanceListener k;
  public eq l;
  public int m = 404;
  private a o;
  private final dn p;
  private final dv q;
  private final boolean r;
  private final dr s;
  private final ea t;
  private final du u;
  private final dy v;
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
    ((HashMap)localObject).put("start_daemon", "true");
    ((HashMap)localObject).put("up_daemon_delay", "600000");
    ((HashMap)localObject).put("gps_kalman", "false");
    ((HashMap)localObject).put("min_wifi_scan_interval", "8000");
    ((HashMap)localObject).put("f_coll_item", "0");
    ((HashMap)localObject).put("f_coll_up_net", "w");
    db.a((HashMap)localObject);
  }
  
  public ds(de paramde)
  {
    this.G = paramde;
    this.B = dg.b();
    this.u = new du(this.G);
    this.v = new dy(this.G);
    this.A = new dz();
    this.b = dp.a(paramde.a);
    this.c = dt.b();
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      this.r = bool;
      if (this.r)
      {
        this.p = null;
        this.t = h();
        if (!this.G.b()) {
          ev.b("TxLocationManagerImpl", "createNewCellProvider: failed");
        }
        for (paramde = null;; paramde = new dv(this.G))
        {
          this.q = paramde;
          this.s = g();
          this.O = false;
          this.G.a(this);
          try
          {
            db.a(this.G.a, "txsdk", this.G.b.d());
            db.a().a((da)this.G.i);
            return;
          }
          catch (Throwable paramde)
          {
            return;
          }
        }
      }
      else
      {
        this.q = null;
        this.t = h();
        if (!this.G.b()) {
          ev.b("TxLocationManagerImpl", "createCellProvider: failed");
        }
        for (paramde = localObject;; paramde = new dn(this.G))
        {
          this.p = paramde;
          this.s = g();
          this.O = false;
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
  
  private void a(int paramInt)
  {
    if (this.o != null)
    {
      this.o.sendEmptyMessage(paramInt);
      return;
    }
    ev.a("TxLocationManagerImpl", 6, "mHandler is null");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject3;
    switch (paramInt1)
    {
    default: 
      localObject3 = null;
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      ev.a("TxLocationManagerImpl", 4, "onStatusChanged: ".concat(String.valueOf(localObject1)));
      synchronized (this.J)
      {
        if (this.d != null) {
          this.d.onStatusUpdate((String)localObject3, paramInt1, (String)localObject1);
        }
        return;
        localObject3 = "gps";
        switch (paramInt2)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          localObject1 = "unknown";
          paramInt1 = paramInt2;
          break;
        case 1: 
          localObject1 = "gps enabled";
          paramInt1 = paramInt2;
          break;
        case 0: 
          localObject1 = "gps disabled";
          paramInt1 = paramInt2;
          break;
        case 5: 
          localObject1 = "location permission denied";
          a(3999);
          paramInt1 = paramInt2;
          continue;
          localObject3 = "gps";
          switch (paramInt2)
          {
          default: 
            localObject1 = "unknown";
            paramInt1 = paramInt2;
            break;
          case 3: 
            localObject1 = "gps available";
            paramInt1 = paramInt2;
            break;
          case 4: 
            localObject1 = "gps unavailable";
            paramInt1 = paramInt2;
            continue;
            ??? = "cell";
            if (paramInt2 == 1) {
              localObject1 = "cell enabled";
            }
            for (;;)
            {
              localObject3 = ???;
              paramInt1 = paramInt2;
              if (!er.a) {
                break;
              }
              localObject1 = "location permission denied";
              a(3999);
              paramInt1 = 2;
              localObject3 = ???;
              break;
              if (paramInt2 == 0) {
                localObject1 = "cell disabled";
              } else {
                localObject1 = "unknown";
              }
            }
            String str = "wifi";
            switch (paramInt2)
            {
            case 2: 
            case 3: 
            case 4: 
            default: 
              ??? = "unknown";
            case 0: 
            case 1: 
              for (;;)
              {
                localObject1 = ???;
                localObject3 = str;
                paramInt1 = paramInt2;
                if (paramInt2 == 5) {
                  break;
                }
                localObject1 = ???;
                localObject3 = str;
                paramInt1 = paramInt2;
                if (!ex.a) {
                  break;
                }
                localObject1 = "location permission denied";
                paramInt1 = 2;
                localObject3 = str;
                break;
                ??? = "wifi disabled";
                continue;
                ??? = "wifi enabled";
              }
            }
            ??? = "location service switch is off";
            a(3999);
          }
          break;
        }
      }
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.o != null)
    {
      this.o.removeMessages(paramInt);
      this.o.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, eq parameq)
  {
    int i3 = 1;
    if (parameq == null) {
      return;
    }
    if ((paramInt == 0) && (parameq.getLatitude() != 0.0D) && (parameq.getLongitude() != 0.0D)) {
      if ((this.a != 1) || (!es.a(parameq.getLatitude(), parameq.getLongitude()))) {
        break label775;
      }
    }
    label769:
    label775:
    for (int i1 = 1;; i1 = 0)
    {
      eq.a(parameq, i1);
      if (m()) {
        if ((this.m == 0) || (paramInt != 0)) {
          break label769;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        this.m = paramInt;
        this.l = parameq;
        if ((parameq.getAccuracy() < 500.0F) && (parameq.getAccuracy() > 0.0F))
        {
          this.A.a(parameq);
          if (this.e) {
            this.j = parameq;
          }
        }
        this.L = parameq.getLatitude();
        this.M = parameq.getLongitude();
        int i2;
        if (this.d != null)
        {
          i2 = 1;
          if ((i2 != 0) && (this.K.getInterval() > 0L) && (!this.K.getExtras().getBoolean("daemon")))
          {
            a(11999, this.K.getInterval());
            if (this.K.getCheckInterval() != -1L) {
              a(3998, this.K.getCheckInterval());
            }
          }
          if (i1 != 0) {
            a(11998);
          }
          label246:
          if ((this.m == 0) || (paramInt != 0)) {
            break label763;
          }
        }
        label407:
        label753:
        label761:
        label763:
        for (i1 = 1;; i1 = 0)
        {
          i2 = i1;
          if (this.m == 0)
          {
            i2 = i1;
            if (this.l != null)
            {
              i2 = i1;
              if (this.l.getProvider().equals("network"))
              {
                i2 = i1;
                if (paramInt == 0)
                {
                  i2 = i1;
                  if (parameq != null)
                  {
                    i2 = i1;
                    if (parameq.getProvider().equals("gps")) {
                      i2 = 1;
                    }
                  }
                }
              }
            }
          }
          this.m = paramInt;
          this.l = parameq;
          ev.b("TxLocationManagerImpl", "updateLast" + parameq.getLatitude() + "," + parameq.getLongitude());
          if (this.K.getInterval() == 0L)
          {
            if (this.d == null) {
              break label753;
            }
            paramInt = 1;
            if (paramInt != 0) {
              a(11998);
            }
          }
          if (i2 == 0) {
            break;
          }
          if (this.d != null) {}
          for (paramInt = i3;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label761;
            }
            a(11998);
            return;
            i2 = 0;
            break;
            if ((paramInt != 0) || (parameq.getLatitude() == 0.0D) || (parameq.getLongitude() == 0.0D) || (Math.abs(parameq.getLatitude() - this.L) < 1.0E-007D) || (Math.abs(parameq.getLongitude() - this.M) < 1.0E-007D)) {
              break label246;
            }
            if (!this.A.a(parameq, this.G))
            {
              ev.a("TxLocationManagerImpl", 4, "discard ".concat(String.valueOf(parameq)));
              return;
            }
            this.L = parameq.getLatitude();
            this.M = parameq.getLongitude();
            if ((parameq.getAccuracy() >= 500.0F) || (parameq.getAccuracy() <= 0.0F)) {
              break label246;
            }
            this.A.a(parameq);
            this.A.a(parameq);
            if (!this.e) {
              break label246;
            }
            if (this.j != null)
            {
              double d1 = ev.a(this.j.getLatitude(), this.j.getLongitude(), parameq.getLatitude(), parameq.getLongitude());
              if (((!parameq.getProvider().equalsIgnoreCase("network")) || (d1 <= 10.0D)) && ((!parameq.getProvider().equalsIgnoreCase("gps")) || (d1 <= 3.0D))) {
                break label246;
              }
              this.f = (d1 + this.f);
              if (parameq.getProvider().equalsIgnoreCase("network")) {
                this.h += 1;
              }
              for (;;)
              {
                this.i += 1;
                this.j = parameq;
                break;
                this.g += 1;
              }
            }
            this.j = parameq;
            break label246;
            paramInt = 0;
            break label407;
          }
          break;
        }
      }
    }
  }
  
  @Nullable
  private dr g()
  {
    if (!this.G.d())
    {
      ev.a("TxLocationManagerImpl", 6, "createGpsProvider: failed");
      return null;
    }
    return new dr(this.G);
  }
  
  @Nullable
  private ea h()
  {
    if (!this.G.c())
    {
      ev.a("TxLocationManagerImpl", 6, "createWifiProvider: failed");
      return null;
    }
    return new ea(this.G);
  }
  
  private cv i()
  {
    try
    {
      Object localObject = this.G.b;
      localObject = new cv(((ev)localObject).j, ((ev)localObject).d(), ((ev)localObject).f());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      ev.a("TxLocationManagerImpl", "getAppInfo error.", localThrowable);
    }
    return new cv("unknown", "unknown", "unknown");
  }
  
  private void j()
  {
    if (this.z == 0)
    {
      if (dc.a().d("start_daemon")) {
        break label29;
      }
      ev.a("TxLocationManagerImpl", 6, "cloud daemon is false");
    }
    for (;;)
    {
      return;
      label29:
      this.Q = dc.a().c("up_daemon_delay");
      if (this.Q < 120000L) {
        this.Q = 120000L;
      }
      try
      {
        if (ex.c(this.G).equalsIgnoreCase("{}"))
        {
          TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create().setInterval(this.Q).setRequestLevel(0);
          localTencentLocationRequest.getExtras().putBoolean("daemon", true);
          TencentLocationListener local2 = new TencentLocationListener()
          {
            public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString) {}
            
            public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2) {}
          };
          this.y = new HandlerThread("daemonthread");
          this.y.start();
          a(localTencentLocationRequest, local2, this.y.getLooper());
          this.z = 1;
          this.R = System.currentTimeMillis();
          return;
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private void k()
  {
    int i2 = 1;
    er.a = false;
    this.u.a();
    this.v.a();
    this.A.a();
    if (this.t != null)
    {
      i1 = 1;
      if (i1 != 0) {
        this.t.a();
      }
      if (!this.r) {
        break label200;
      }
      if (this.q == null) {
        break label195;
      }
      i1 = 1;
      label63:
      if (i1 != 0) {
        this.q.a();
      }
      label74:
      if (this.s == null) {
        break label228;
      }
      i1 = 1;
      label83:
      if (i1 != 0) {
        this.s.a();
      }
      if ((this.K.isAllowDirection()) && (!this.b.a)) {
        this.b.a();
      }
      if (!this.K.getExtras().getBoolean("daemon")) {
        if (this.c == null) {
          break label233;
        }
      }
    }
    label195:
    label200:
    label226:
    label228:
    label233:
    for (int i1 = i2;; i1 = 0)
    {
      if (i1 != 0) {
        this.c.c();
      }
      if (this.x)
      {
        db.a().c();
        this.x = false;
      }
      if (this.w != null) {
        this.w.a();
      }
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label63;
      if (this.p != null) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label226;
        }
        this.p.a();
        break;
      }
      break label74;
      i1 = 0;
      break label83;
    }
  }
  
  private void l()
  {
    this.l = null;
    this.m = 404;
    this.D = null;
    this.C = null;
    this.E = null;
    this.I = false;
    this.U = false;
    eg.a = 0;
    this.G.a("cell").a();
  }
  
  private boolean m()
  {
    return this.m == 404;
  }
  
  private boolean n()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.s != null)
    {
      bool1 = bool2;
      if (this.s.c())
      {
        bool1 = bool2;
        if (this.s.b()) {
          bool1 = true;
        }
      }
    }
    if (!bool1) {
      ev.a("TxLocationManagerImpl", 6, "isGpsValid: provider=false");
    }
    return bool1;
  }
  
  /* Error */
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 157	c/t/m/g/ds:z	I
    //   4: iconst_1
    //   5: if_icmpne +32 -> 37
    //   8: aload_0
    //   9: invokevirtual 754	c/t/m/g/ds:d	()V
    //   12: aload_0
    //   13: getfield 624	c/t/m/g/ds:y	Landroid/os/HandlerThread;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: getfield 624	c/t/m/g/ds:y	Landroid/os/HandlerThread;
    //   23: invokevirtual 757	android/os/HandlerThread:quit	()Z
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 624	c/t/m/g/ds:y	Landroid/os/HandlerThread;
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 157	c/t/m/g/ds:z	I
    //   37: invokestatic 762	com/tencent/map/geolocation/TencentLocationManagerOptions:isLoadLibraryEnabled	()Z
    //   40: ifeq +9 -> 49
    //   43: ldc_w 764
    //   46: invokestatic 767	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 187	c/t/m/g/ds:G	Lc/t/m/g/de;
    //   53: astore 11
    //   55: aload 11
    //   57: getfield 272	c/t/m/g/de:b	Lc/t/m/g/ev;
    //   60: astore 10
    //   62: ldc_w 769
    //   65: aload 10
    //   67: invokevirtual 771	c/t/m/g/ev:a	()Ljava/lang/String;
    //   70: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +22 -> 95
    //   76: ldc_w 769
    //   79: aload 10
    //   81: invokevirtual 773	c/t/m/g/ev:b	()Ljava/lang/String;
    //   84: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +8 -> 95
    //   90: aload 11
    //   92: invokevirtual 774	c/t/m/g/de:a	()V
    //   95: aload 10
    //   97: getfield 776	c/t/m/g/ev:g	Ljava/lang/String;
    //   100: invokestatic 778	c/t/m/g/ev:c	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 11
    //   105: aload_0
    //   106: aload 11
    //   108: invokestatic 780	c/t/m/g/ds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 743	c/t/m/g/ds:T	Ljava/lang/String;
    //   114: aload_0
    //   115: getfield 743	c/t/m/g/ds:T	Ljava/lang/String;
    //   118: invokestatic 785	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifeq +47 -> 168
    //   124: ldc 248
    //   126: new 485	java/lang/StringBuilder
    //   129: dup
    //   130: ldc_w 787
    //   133: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload 11
    //   138: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 789
    //   144: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 255	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: iconst_2
    //   154: ireturn
    //   155: astore_1
    //   156: ldc_w 791
    //   159: ldc_w 793
    //   162: aload_1
    //   163: invokestatic 581	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: iconst_3
    //   167: ireturn
    //   168: aload_0
    //   169: invokespecial 795	c/t/m/g/ds:l	()V
    //   172: aload_0
    //   173: getfield 175	c/t/m/g/ds:J	Ljava/lang/Object;
    //   176: astore 11
    //   178: aload 11
    //   180: monitorenter
    //   181: aload_0
    //   182: aload_2
    //   183: putfield 365	c/t/m/g/ds:d	Lcom/tencent/map/geolocation/TencentLocationListener;
    //   186: aload 11
    //   188: monitorexit
    //   189: aload_0
    //   190: getfield 183	c/t/m/g/ds:K	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   193: aload_1
    //   194: invokestatic 799	com/tencent/map/geolocation/TencentLocationRequest:copy	(Lcom/tencent/map/geolocation/TencentLocationRequest;Lcom/tencent/map/geolocation/TencentLocationRequest;)V
    //   197: aload 10
    //   199: aload_1
    //   200: invokevirtual 802	com/tencent/map/geolocation/TencentLocationRequest:getQQ	()Ljava/lang/String;
    //   203: putfield 804	c/t/m/g/ev:f	Ljava/lang/String;
    //   206: aload 10
    //   208: getfield 806	c/t/m/g/ev:d	Ljava/lang/String;
    //   211: invokestatic 778	c/t/m/g/ev:c	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokestatic 785	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifeq +12 -> 229
    //   220: aload 10
    //   222: aload_1
    //   223: invokevirtual 809	com/tencent/map/geolocation/TencentLocationRequest:getPhoneNumber	()Ljava/lang/String;
    //   226: putfield 806	c/t/m/g/ev:d	Ljava/lang/String;
    //   229: aload_1
    //   230: invokevirtual 455	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   233: lconst_0
    //   234: lcmp
    //   235: ifne +1169 -> 1404
    //   238: ldc2_w 810
    //   241: lstore 5
    //   243: aload 10
    //   245: invokestatic 586	c/t/m/g/dc:a	()Lc/t/m/g/dc;
    //   248: ldc 132
    //   250: invokevirtual 593	c/t/m/g/dc:c	(Ljava/lang/String;)J
    //   253: lload 5
    //   255: invokestatic 815	java/lang/Math:max	(JJ)J
    //   258: putfield 817	c/t/m/g/ev:m	J
    //   261: invokestatic 822	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   264: ifnonnull +6 -> 270
    //   267: invokestatic 825	android/os/Looper:prepare	()V
    //   270: aload_0
    //   271: getfield 344	c/t/m/g/ds:o	Lc/t/m/g/ds$a;
    //   274: ifnonnull +1139 -> 1413
    //   277: iconst_1
    //   278: istore 4
    //   280: iload 4
    //   282: ifeq +1137 -> 1419
    //   285: aload_0
    //   286: new 10	c/t/m/g/ds$a
    //   289: dup
    //   290: aload_0
    //   291: aload_3
    //   292: invokespecial 828	c/t/m/g/ds$a:<init>	(Lc/t/m/g/ds;Landroid/os/Looper;)V
    //   295: putfield 344	c/t/m/g/ds:o	Lc/t/m/g/ds$a;
    //   298: aload_0
    //   299: invokespecial 830	c/t/m/g/ds:k	()V
    //   302: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   305: lstore 5
    //   307: ldc 248
    //   309: new 485	java/lang/StringBuilder
    //   312: dup
    //   313: ldc_w 832
    //   316: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   322: lload 5
    //   324: lsub
    //   325: invokevirtual 835	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   328: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_0
    //   335: getfield 183	c/t/m/g/ds:K	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   338: invokevirtual 459	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   341: ldc_w 837
    //   344: iconst_1
    //   345: invokevirtual 840	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   348: istore 7
    //   350: aload_0
    //   351: getfield 183	c/t/m/g/ds:K	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   354: invokevirtual 459	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   357: ldc_w 461
    //   360: invokevirtual 467	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   363: istore 8
    //   365: aload_0
    //   366: getfield 344	c/t/m/g/ds:o	Lc/t/m/g/ds$a;
    //   369: astore_1
    //   370: aload_0
    //   371: getfield 200	c/t/m/g/ds:u	Lc/t/m/g/du;
    //   374: astore_2
    //   375: aload_2
    //   376: getfield 842	c/t/m/g/du:b	Z
    //   379: ifne +34 -> 413
    //   382: aload_2
    //   383: iconst_1
    //   384: putfield 842	c/t/m/g/du:b	Z
    //   387: new 844	android/content/IntentFilter
    //   390: dup
    //   391: ldc_w 846
    //   394: invokespecial 847	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   397: astore_3
    //   398: aload_2
    //   399: getfield 849	c/t/m/g/du:a	Lc/t/m/g/de;
    //   402: getfield 215	c/t/m/g/de:a	Landroid/content/Context;
    //   405: aload_2
    //   406: aload_3
    //   407: aconst_null
    //   408: aload_1
    //   409: invokevirtual 855	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   412: pop
    //   413: aload_0
    //   414: getfield 205	c/t/m/g/ds:v	Lc/t/m/g/dy;
    //   417: astore_2
    //   418: aload_2
    //   419: getfield 857	c/t/m/g/dy:g	Z
    //   422: ifne +36 -> 458
    //   425: aload_2
    //   426: iconst_1
    //   427: putfield 857	c/t/m/g/dy:g	Z
    //   430: aload_2
    //   431: getfield 859	c/t/m/g/dy:b	Lc/t/m/g/de;
    //   434: getfield 862	c/t/m/g/de:d	Ljava/util/concurrent/ExecutorService;
    //   437: new 864	c/t/m/g/dy$1
    //   440: dup
    //   441: aload_2
    //   442: aload_1
    //   443: invokespecial 867	c/t/m/g/dy$1:<init>	(Lc/t/m/g/dy;Landroid/os/Handler;)V
    //   446: invokeinterface 873 2 0
    //   451: aload_2
    //   452: invokestatic 878	android/os/SystemClock:elapsedRealtime	()J
    //   455: putfield 880	c/t/m/g/dy:f	J
    //   458: ldc 248
    //   460: new 485	java/lang/StringBuilder
    //   463: dup
    //   464: ldc_w 882
    //   467: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   473: lload 5
    //   475: lsub
    //   476: invokevirtual 835	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   479: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: iload 8
    //   487: ifeq +27 -> 514
    //   490: aload_0
    //   491: getfield 205	c/t/m/g/ds:v	Lc/t/m/g/dy;
    //   494: astore_2
    //   495: aload_0
    //   496: getfield 187	c/t/m/g/ds:G	Lc/t/m/g/de;
    //   499: invokevirtual 883	c/t/m/g/de:f	()Ljava/lang/String;
    //   502: astore_3
    //   503: aload_3
    //   504: invokestatic 785	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   507: istore 9
    //   509: iload 9
    //   511: ifeq +957 -> 1468
    //   514: ldc 248
    //   516: new 485	java/lang/StringBuilder
    //   519: dup
    //   520: ldc_w 885
    //   523: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   526: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   529: lload 5
    //   531: lsub
    //   532: invokevirtual 835	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: aload_0
    //   542: getfield 236	c/t/m/g/ds:r	Z
    //   545: ifeq +1043 -> 1588
    //   548: iload 7
    //   550: ifeq +127 -> 677
    //   553: aload_0
    //   554: getfield 257	c/t/m/g/ds:q	Lc/t/m/g/dv;
    //   557: ifnull +1001 -> 1558
    //   560: iconst_1
    //   561: istore 4
    //   563: iload 4
    //   565: ifeq +112 -> 677
    //   568: aload_0
    //   569: getfield 257	c/t/m/g/ds:q	Lc/t/m/g/dv;
    //   572: astore_2
    //   573: aload_2
    //   574: getfield 886	c/t/m/g/dv:a	Z
    //   577: ifne +100 -> 677
    //   580: aload_2
    //   581: aload_1
    //   582: putfield 889	c/t/m/g/dv:e	Landroid/os/Handler;
    //   585: aload_2
    //   586: getfield 892	c/t/m/g/dv:f	Ljava/util/List;
    //   589: ifnonnull +14 -> 603
    //   592: aload_2
    //   593: new 894	java/util/ArrayList
    //   596: dup
    //   597: invokespecial 895	java/util/ArrayList:<init>	()V
    //   600: putfield 892	c/t/m/g/dv:f	Ljava/util/List;
    //   603: aload_2
    //   604: new 619	android/os/HandlerThread
    //   607: dup
    //   608: ldc_w 897
    //   611: invokespecial 622	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   614: putfield 899	c/t/m/g/dv:b	Landroid/os/HandlerThread;
    //   617: aload_2
    //   618: getfield 899	c/t/m/g/dv:b	Landroid/os/HandlerThread;
    //   621: ifnull +56 -> 677
    //   624: aload_2
    //   625: getfield 899	c/t/m/g/dv:b	Landroid/os/HandlerThread;
    //   628: invokevirtual 627	android/os/HandlerThread:start	()V
    //   631: aload_2
    //   632: new 901	c/t/m/g/dv$a
    //   635: dup
    //   636: aload_2
    //   637: aload_2
    //   638: getfield 899	c/t/m/g/dv:b	Landroid/os/HandlerThread;
    //   641: invokevirtual 631	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   644: iconst_0
    //   645: invokespecial 904	c/t/m/g/dv$a:<init>	(Lc/t/m/g/dv;Landroid/os/Looper;B)V
    //   648: putfield 906	c/t/m/g/dv:c	Landroid/os/Handler;
    //   651: aload_2
    //   652: getfield 906	c/t/m/g/dv:c	Landroid/os/Handler;
    //   655: aload_2
    //   656: getfield 909	c/t/m/g/dv:d	Ljava/lang/Runnable;
    //   659: invokevirtual 915	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   662: pop
    //   663: iload 8
    //   665: ifne +12 -> 677
    //   668: aload_2
    //   669: getfield 906	c/t/m/g/dv:c	Landroid/os/Handler;
    //   672: iconst_0
    //   673: invokevirtual 916	android/os/Handler:sendEmptyMessage	(I)Z
    //   676: pop
    //   677: ldc 248
    //   679: new 485	java/lang/StringBuilder
    //   682: dup
    //   683: ldc_w 918
    //   686: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   689: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   692: lload 5
    //   694: lsub
    //   695: invokevirtual 835	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   698: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: iload 7
    //   706: ifeq +108 -> 814
    //   709: aload_0
    //   710: getfield 243	c/t/m/g/ds:t	Lc/t/m/g/ea;
    //   713: ifnull +1036 -> 1749
    //   716: iconst_1
    //   717: istore 4
    //   719: iload 4
    //   721: ifeq +93 -> 814
    //   724: aload_0
    //   725: getfield 243	c/t/m/g/ds:t	Lc/t/m/g/ea;
    //   728: astore_2
    //   729: aload_2
    //   730: getfield 919	c/t/m/g/ea:a	Z
    //   733: ifne +81 -> 814
    //   736: aload_2
    //   737: iconst_1
    //   738: putfield 919	c/t/m/g/ea:a	Z
    //   741: aload_2
    //   742: iconst_0
    //   743: putfield 921	c/t/m/g/ea:d	Z
    //   746: aload_2
    //   747: iload 8
    //   749: putfield 923	c/t/m/g/ea:c	Z
    //   752: aload_1
    //   753: putstatic 924	c/t/m/g/ea:e	Landroid/os/Handler;
    //   756: new 844	android/content/IntentFilter
    //   759: dup
    //   760: invokespecial 925	android/content/IntentFilter:<init>	()V
    //   763: astore_3
    //   764: aload_3
    //   765: ldc_w 927
    //   768: invokevirtual 930	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   771: aload_3
    //   772: ldc_w 932
    //   775: invokevirtual 930	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   778: aload_2
    //   779: getfield 933	c/t/m/g/ea:b	Lc/t/m/g/de;
    //   782: getfield 215	c/t/m/g/de:a	Landroid/content/Context;
    //   785: aload_2
    //   786: aload_3
    //   787: aconst_null
    //   788: aload_1
    //   789: invokevirtual 855	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   792: pop
    //   793: aload_2
    //   794: getfield 923	c/t/m/g/ea:c	Z
    //   797: ifne +8 -> 805
    //   800: aload_2
    //   801: lconst_0
    //   802: invokevirtual 936	c/t/m/g/ea:a	(J)V
    //   805: ldc_w 938
    //   808: ldc_w 940
    //   811: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: ldc 248
    //   816: new 485	java/lang/StringBuilder
    //   819: dup
    //   820: ldc_w 942
    //   823: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   826: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   829: lload 5
    //   831: lsub
    //   832: invokevirtual 835	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   835: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   841: iload 8
    //   843: ifne +8 -> 851
    //   846: aload_0
    //   847: iconst_1
    //   848: putfield 300	c/t/m/g/ds:P	Z
    //   851: aload_0
    //   852: getfield 262	c/t/m/g/ds:s	Lc/t/m/g/dr;
    //   855: ifnull +914 -> 1769
    //   858: iconst_1
    //   859: istore 4
    //   861: iload 4
    //   863: ifeq +156 -> 1019
    //   866: aload_0
    //   867: getfield 183	c/t/m/g/ds:K	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   870: invokevirtual 945	com/tencent/map/geolocation/TencentLocationRequest:isAllowGPS	()Z
    //   873: ifeq +146 -> 1019
    //   876: aload_0
    //   877: getfield 262	c/t/m/g/ds:s	Lc/t/m/g/dr;
    //   880: astore_2
    //   881: aload_0
    //   882: getfield 153	c/t/m/g/ds:a	I
    //   885: iconst_1
    //   886: if_icmpne +889 -> 1775
    //   889: iconst_1
    //   890: istore 7
    //   892: aload_2
    //   893: iload 7
    //   895: putfield 946	c/t/m/g/dr:e	Z
    //   898: aload_0
    //   899: getfield 262	c/t/m/g/ds:s	Lc/t/m/g/dr;
    //   902: astore_2
    //   903: aload_0
    //   904: getfield 183	c/t/m/g/ds:K	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   907: invokevirtual 455	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   910: pop2
    //   911: aload_2
    //   912: getfield 947	c/t/m/g/dr:c	Z
    //   915: ifne +104 -> 1019
    //   918: aload_2
    //   919: iconst_1
    //   920: putfield 947	c/t/m/g/dr:c	Z
    //   923: aload_2
    //   924: new 619	android/os/HandlerThread
    //   927: dup
    //   928: ldc_w 949
    //   931: invokespecial 622	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   934: putfield 951	c/t/m/g/dr:f	Landroid/os/HandlerThread;
    //   937: aload_2
    //   938: getfield 952	c/t/m/g/dr:a	Lc/t/m/g/de;
    //   941: getfield 955	c/t/m/g/de:h	Landroid/location/LocationManager;
    //   944: astore_3
    //   945: aload_2
    //   946: getfield 951	c/t/m/g/dr:f	Landroid/os/HandlerThread;
    //   949: invokevirtual 627	android/os/HandlerThread:start	()V
    //   952: aload_2
    //   953: new 911	android/os/Handler
    //   956: dup
    //   957: aload_2
    //   958: getfield 951	c/t/m/g/dr:f	Landroid/os/HandlerThread;
    //   961: invokevirtual 631	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   964: invokespecial 958	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   967: putfield 960	c/t/m/g/dr:h	Landroid/os/Handler;
    //   970: iload 8
    //   972: ifne +809 -> 1781
    //   975: aload_2
    //   976: getfield 960	c/t/m/g/dr:h	Landroid/os/Handler;
    //   979: aload_2
    //   980: getfield 962	c/t/m/g/dr:g	Ljava/lang/Runnable;
    //   983: invokevirtual 915	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   986: pop
    //   987: aload_2
    //   988: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   991: putfield 964	c/t/m/g/dr:d	J
    //   994: aload_2
    //   995: invokevirtual 680	c/t/m/g/dr:c	()Z
    //   998: ifeq +12 -> 1010
    //   1001: aload_2
    //   1002: iconst_4
    //   1003: putfield 966	c/t/m/g/dr:b	I
    //   1006: aload_2
    //   1007: invokevirtual 967	c/t/m/g/dr:d	()V
    //   1010: ldc_w 969
    //   1013: ldc_w 940
    //   1016: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1019: ldc 248
    //   1021: new 485	java/lang/StringBuilder
    //   1024: dup
    //   1025: ldc_w 971
    //   1028: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1031: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   1034: lload 5
    //   1036: lsub
    //   1037: invokevirtual 835	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1040: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1043: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1046: aload_0
    //   1047: getfield 183	c/t/m/g/ds:K	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1050: invokevirtual 652	com/tencent/map/geolocation/TencentLocationRequest:isAllowDirection	()Z
    //   1053: ifeq +23 -> 1076
    //   1056: aload_0
    //   1057: getfield 222	c/t/m/g/ds:b	Lc/t/m/g/dp;
    //   1060: getfield 653	c/t/m/g/dp:a	Z
    //   1063: ifne +13 -> 1076
    //   1066: aload_0
    //   1067: getfield 222	c/t/m/g/ds:b	Lc/t/m/g/dp;
    //   1070: aload_1
    //   1071: aconst_null
    //   1072: invokevirtual 974	c/t/m/g/dp:a	(Landroid/os/Handler;Lcom/tencent/map/geolocation/TencentDirectionListener;)I
    //   1075: pop
    //   1076: iload 8
    //   1078: ifne +143 -> 1221
    //   1081: aload_0
    //   1082: getfield 183	c/t/m/g/ds:K	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1085: invokevirtual 977	com/tencent/map/geolocation/TencentLocationRequest:isAllowPedometer	()Z
    //   1088: ifeq +133 -> 1221
    //   1091: aload_0
    //   1092: getfield 229	c/t/m/g/ds:c	Lc/t/m/g/dt;
    //   1095: astore_2
    //   1096: aload_0
    //   1097: getfield 187	c/t/m/g/ds:G	Lc/t/m/g/de;
    //   1100: getfield 215	c/t/m/g/de:a	Landroid/content/Context;
    //   1103: astore_3
    //   1104: aload_3
    //   1105: putstatic 979	c/t/m/g/dt:f	Landroid/content/Context;
    //   1108: aload_3
    //   1109: ldc_w 981
    //   1112: iconst_0
    //   1113: invokevirtual 985	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1116: putstatic 988	c/t/m/g/dt:i	Landroid/content/SharedPreferences;
    //   1119: aload_2
    //   1120: new 619	android/os/HandlerThread
    //   1123: dup
    //   1124: ldc_w 990
    //   1127: invokespecial 622	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1130: putfield 992	c/t/m/g/dt:g	Landroid/os/HandlerThread;
    //   1133: aload_2
    //   1134: getfield 992	c/t/m/g/dt:g	Landroid/os/HandlerThread;
    //   1137: invokevirtual 627	android/os/HandlerThread:start	()V
    //   1140: aload_2
    //   1141: getfield 995	c/t/m/g/dt:a	Lc/t/m/g/dk;
    //   1144: aload_2
    //   1145: putfield 1000	c/t/m/g/dk:i	Lc/t/m/g/dl;
    //   1148: aload_2
    //   1149: getstatic 979	c/t/m/g/dt:f	Landroid/content/Context;
    //   1152: ldc_w 1002
    //   1155: invokevirtual 1006	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1158: checkcast 1008	android/hardware/SensorManager
    //   1161: putfield 1011	c/t/m/g/dt:b	Landroid/hardware/SensorManager;
    //   1164: aload_2
    //   1165: getfield 1011	c/t/m/g/dt:b	Landroid/hardware/SensorManager;
    //   1168: ifnull +49 -> 1217
    //   1171: aload_2
    //   1172: aload_2
    //   1173: getfield 1011	c/t/m/g/dt:b	Landroid/hardware/SensorManager;
    //   1176: iconst_1
    //   1177: invokevirtual 1015	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1180: putfield 1018	c/t/m/g/dt:c	Landroid/hardware/Sensor;
    //   1183: aload_2
    //   1184: aload_2
    //   1185: getfield 1011	c/t/m/g/dt:b	Landroid/hardware/SensorManager;
    //   1188: bipush 10
    //   1190: invokevirtual 1015	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1193: putfield 1020	c/t/m/g/dt:d	Landroid/hardware/Sensor;
    //   1196: getstatic 234	android/os/Build$VERSION:SDK_INT	I
    //   1199: bipush 19
    //   1201: if_icmplt +16 -> 1217
    //   1204: aload_2
    //   1205: aload_2
    //   1206: getfield 1011	c/t/m/g/dt:b	Landroid/hardware/SensorManager;
    //   1209: bipush 19
    //   1211: invokevirtual 1015	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1214: putfield 1022	c/t/m/g/dt:e	Landroid/hardware/Sensor;
    //   1217: aload_2
    //   1218: invokevirtual 1023	c/t/m/g/dt:d	()V
    //   1221: invokestatic 586	c/t/m/g/dc:a	()Lc/t/m/g/dc;
    //   1224: ldc 136
    //   1226: invokevirtual 1025	c/t/m/g/dc:b	(Ljava/lang/String;)I
    //   1229: istore 4
    //   1231: iload 4
    //   1233: iconst_1
    //   1234: if_icmpeq +9 -> 1243
    //   1237: iload 4
    //   1239: iconst_2
    //   1240: if_icmpne +28 -> 1268
    //   1243: aload_0
    //   1244: getfield 659	c/t/m/g/ds:w	Lc/t/m/g/co;
    //   1247: ifnonnull +21 -> 1268
    //   1250: aload_0
    //   1251: new 661	c/t/m/g/co
    //   1254: dup
    //   1255: aload_0
    //   1256: getfield 187	c/t/m/g/ds:G	Lc/t/m/g/de;
    //   1259: getfield 215	c/t/m/g/de:a	Landroid/content/Context;
    //   1262: invokespecial 1028	c/t/m/g/co:<init>	(Landroid/content/Context;)V
    //   1265: putfield 659	c/t/m/g/ds:w	Lc/t/m/g/co;
    //   1268: aload_0
    //   1269: getfield 659	c/t/m/g/ds:w	Lc/t/m/g/co;
    //   1272: ifnull +110 -> 1382
    //   1275: aload_1
    //   1276: ifnull +106 -> 1382
    //   1279: ldc 248
    //   1281: new 485	java/lang/StringBuilder
    //   1284: dup
    //   1285: ldc_w 1030
    //   1288: invokespecial 490	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1291: iload 4
    //   1293: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: ldc_w 1032
    //   1299: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: iload 8
    //   1304: invokevirtual 1035	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1307: ldc_w 1037
    //   1310: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: invokestatic 1038	c/t/m/g/co:b	()Ljava/lang/String;
    //   1316: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1322: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1325: iload 4
    //   1327: iconst_2
    //   1328: if_icmpeq +14 -> 1342
    //   1331: iload 4
    //   1333: iconst_1
    //   1334: if_icmpne +48 -> 1382
    //   1337: iload 8
    //   1339: ifne +43 -> 1382
    //   1342: aload_0
    //   1343: getfield 659	c/t/m/g/ds:w	Lc/t/m/g/co;
    //   1346: aload_0
    //   1347: invokespecial 1040	c/t/m/g/ds:i	()Lc/t/m/g/cv;
    //   1350: invokevirtual 1043	c/t/m/g/co:a	(Lc/t/m/g/cv;)V
    //   1353: aload_0
    //   1354: getfield 659	c/t/m/g/ds:w	Lc/t/m/g/co;
    //   1357: ldc_w 1045
    //   1360: invokestatic 586	c/t/m/g/dc:a	()Lc/t/m/g/dc;
    //   1363: ldc 140
    //   1365: invokevirtual 1047	c/t/m/g/dc:e	(Ljava/lang/String;)Ljava/lang/String;
    //   1368: invokevirtual 1048	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1371: aload_0
    //   1372: getfield 659	c/t/m/g/ds:w	Lc/t/m/g/co;
    //   1375: aload_1
    //   1376: invokevirtual 1049	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1379: invokevirtual 1051	c/t/m/g/co:a	(Landroid/os/Looper;)V
    //   1382: aload_0
    //   1383: ldc_w 1052
    //   1386: putfield 161	c/t/m/g/ds:H	Ljava/lang/String;
    //   1389: aload_0
    //   1390: getfield 743	c/t/m/g/ds:T	Ljava/lang/String;
    //   1393: invokestatic 1054	c/t/m/g/db:a	(Ljava/lang/String;)V
    //   1396: iconst_0
    //   1397: ireturn
    //   1398: astore_1
    //   1399: aload 11
    //   1401: monitorexit
    //   1402: aload_1
    //   1403: athrow
    //   1404: aload_1
    //   1405: invokevirtual 455	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   1408: lstore 5
    //   1410: goto -1167 -> 243
    //   1413: iconst_0
    //   1414: istore 4
    //   1416: goto -1136 -> 280
    //   1419: aload_0
    //   1420: getfield 344	c/t/m/g/ds:o	Lc/t/m/g/ds$a;
    //   1423: aconst_null
    //   1424: invokevirtual 1057	c/t/m/g/ds$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1427: aload_0
    //   1428: getfield 344	c/t/m/g/ds:o	Lc/t/m/g/ds$a;
    //   1431: invokevirtual 1058	c/t/m/g/ds$a:getLooper	()Landroid/os/Looper;
    //   1434: aload_3
    //   1435: if_acmpeq -1137 -> 298
    //   1438: aload_0
    //   1439: new 10	c/t/m/g/ds$a
    //   1442: dup
    //   1443: aload_0
    //   1444: aload_3
    //   1445: invokespecial 828	c/t/m/g/ds$a:<init>	(Lc/t/m/g/ds;Landroid/os/Looper;)V
    //   1448: putfield 344	c/t/m/g/ds:o	Lc/t/m/g/ds$a;
    //   1451: goto -1153 -> 298
    //   1454: astore_2
    //   1455: ldc_w 1060
    //   1458: ldc_w 1062
    //   1461: aload_2
    //   1462: invokestatic 581	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1465: goto -1052 -> 413
    //   1468: aload_3
    //   1469: ldc_w 1064
    //   1472: invokevirtual 1068	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1475: invokestatic 1071	c/t/m/g/dy:a	([B)[B
    //   1478: astore 10
    //   1480: aload 10
    //   1482: iconst_2
    //   1483: invokestatic 1074	com/tencent/tencentmap/lbssdk/service/e:o	([BI)I
    //   1486: pop
    //   1487: new 1076	c/t/m/g/dy$a
    //   1490: dup
    //   1491: iconst_2
    //   1492: aload 10
    //   1494: ldc_w 1078
    //   1497: aconst_null
    //   1498: invokespecial 1081	c/t/m/g/dy$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
    //   1501: astore 10
    //   1503: aload 10
    //   1505: aload_3
    //   1506: putfield 1083	c/t/m/g/dy$a:b	Ljava/lang/String;
    //   1509: aload 10
    //   1511: invokestatic 1086	c/t/m/g/dy$a:a	(Lc/t/m/g/dy$a;)[B
    //   1514: ifnull -1000 -> 514
    //   1517: aload_2
    //   1518: getfield 1089	c/t/m/g/dy:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   1521: aload 10
    //   1523: invokevirtual 1094	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   1526: pop
    //   1527: goto -1013 -> 514
    //   1530: astore_2
    //   1531: ldc_w 1096
    //   1534: ldc_w 341
    //   1537: aload_2
    //   1538: invokestatic 581	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1541: goto -1027 -> 514
    //   1544: astore_2
    //   1545: ldc_w 1096
    //   1548: ldc_w 341
    //   1551: aload_2
    //   1552: invokestatic 581	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1555: goto -1041 -> 514
    //   1558: iconst_0
    //   1559: istore 4
    //   1561: goto -998 -> 563
    //   1564: astore_3
    //   1565: aload_2
    //   1566: new 901	c/t/m/g/dv$a
    //   1569: dup
    //   1570: aload_2
    //   1571: aload_2
    //   1572: getfield 889	c/t/m/g/dv:e	Landroid/os/Handler;
    //   1575: invokevirtual 1049	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1578: iconst_0
    //   1579: invokespecial 904	c/t/m/g/dv$a:<init>	(Lc/t/m/g/dv;Landroid/os/Looper;B)V
    //   1582: putfield 906	c/t/m/g/dv:c	Landroid/os/Handler;
    //   1585: goto -934 -> 651
    //   1588: iload 7
    //   1590: ifeq -913 -> 677
    //   1593: aload_0
    //   1594: getfield 238	c/t/m/g/ds:p	Lc/t/m/g/dn;
    //   1597: ifnull +146 -> 1743
    //   1600: iconst_1
    //   1601: istore 4
    //   1603: iload 4
    //   1605: ifeq -928 -> 677
    //   1608: aload_0
    //   1609: getfield 238	c/t/m/g/ds:p	Lc/t/m/g/dn;
    //   1612: astore_2
    //   1613: aload_2
    //   1614: getfield 1097	c/t/m/g/dn:a	Z
    //   1617: ifne -940 -> 677
    //   1620: aload_2
    //   1621: iconst_1
    //   1622: putfield 1097	c/t/m/g/dn:a	Z
    //   1625: aload_2
    //   1626: new 619	android/os/HandlerThread
    //   1629: dup
    //   1630: ldc_w 1099
    //   1633: invokespecial 622	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1636: putfield 1101	c/t/m/g/dn:d	Landroid/os/HandlerThread;
    //   1639: aload_2
    //   1640: getfield 1101	c/t/m/g/dn:d	Landroid/os/HandlerThread;
    //   1643: invokevirtual 627	android/os/HandlerThread:start	()V
    //   1646: aload_2
    //   1647: new 1103	c/t/m/g/dn$a
    //   1650: dup
    //   1651: aload_2
    //   1652: aload_2
    //   1653: getfield 1101	c/t/m/g/dn:d	Landroid/os/HandlerThread;
    //   1656: invokevirtual 631	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1659: iconst_0
    //   1660: invokespecial 1106	c/t/m/g/dn$a:<init>	(Lc/t/m/g/dn;Landroid/os/Looper;B)V
    //   1663: putfield 1107	c/t/m/g/dn:e	Landroid/os/Handler;
    //   1666: aload_2
    //   1667: getfield 1107	c/t/m/g/dn:e	Landroid/os/Handler;
    //   1670: iconst_0
    //   1671: ldc2_w 1108
    //   1674: invokevirtual 1110	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   1677: pop
    //   1678: aload_2
    //   1679: getfield 1111	c/t/m/g/dn:b	Lc/t/m/g/de;
    //   1682: invokestatic 687	c/t/m/g/er:a	(Lc/t/m/g/de;)Landroid/telephony/CellLocation;
    //   1685: astore_3
    //   1686: aload_2
    //   1687: aload_3
    //   1688: invokevirtual 1114	c/t/m/g/dn:a	(Landroid/telephony/CellLocation;)Z
    //   1691: ifeq +33 -> 1724
    //   1694: aload_2
    //   1695: getfield 1111	c/t/m/g/dn:b	Lc/t/m/g/de;
    //   1698: aload_3
    //   1699: aconst_null
    //   1700: invokestatic 692	c/t/m/g/ee:a	(Lc/t/m/g/de;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/m/g/ee;
    //   1703: astore 10
    //   1705: aload 10
    //   1707: ifnull +17 -> 1724
    //   1710: aload_2
    //   1711: aload_3
    //   1712: putfield 1117	c/t/m/g/dn:c	Landroid/telephony/CellLocation;
    //   1715: aload_2
    //   1716: getfield 1111	c/t/m/g/dn:b	Lc/t/m/g/de;
    //   1719: aload 10
    //   1721: invokevirtual 1119	c/t/m/g/de:b	(Ljava/lang/Object;)V
    //   1724: aload_2
    //   1725: sipush 273
    //   1728: invokevirtual 1120	c/t/m/g/dn:a	(I)V
    //   1731: ldc_w 1122
    //   1734: ldc_w 940
    //   1737: invokestatic 738	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1740: goto -1063 -> 677
    //   1743: iconst_0
    //   1744: istore 4
    //   1746: goto -143 -> 1603
    //   1749: iconst_0
    //   1750: istore 4
    //   1752: goto -1033 -> 719
    //   1755: astore_3
    //   1756: ldc_w 938
    //   1759: ldc_w 1124
    //   1762: aload_3
    //   1763: invokestatic 581	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1766: goto -973 -> 793
    //   1769: iconst_0
    //   1770: istore 4
    //   1772: goto -911 -> 861
    //   1775: iconst_0
    //   1776: istore 7
    //   1778: goto -886 -> 892
    //   1781: aload_3
    //   1782: ldc_w 1126
    //   1785: ldc2_w 1127
    //   1788: fconst_0
    //   1789: aload_2
    //   1790: aload_2
    //   1791: getfield 951	c/t/m/g/dr:f	Landroid/os/HandlerThread;
    //   1794: invokevirtual 631	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1797: invokevirtual 1134	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   1800: goto -806 -> 994
    //   1803: astore_3
    //   1804: iconst_1
    //   1805: putstatic 394	c/t/m/g/er:a	Z
    //   1808: ldc_w 969
    //   1811: ldc_w 1136
    //   1814: aload_3
    //   1815: invokestatic 581	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1818: goto -824 -> 994
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1821	0	this	ds
    //   0	1821	1	paramTencentLocationRequest	TencentLocationRequest
    //   0	1821	2	paramTencentLocationListener	TencentLocationListener
    //   0	1821	3	paramLooper	Looper
    //   278	1493	4	i1	int
    //   241	1168	5	l1	long
    //   348	1429	7	bool1	boolean
    //   363	975	8	bool2	boolean
    //   507	3	9	bool3	boolean
    //   60	1660	10	localObject1	Object
    //   53	1347	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   43	49	155	java/lang/Error
    //   181	189	1398	finally
    //   1399	1402	1398	finally
    //   387	413	1454	java/lang/Exception
    //   503	509	1530	java/lang/Exception
    //   1468	1527	1530	java/lang/Exception
    //   503	509	1544	java/lang/Error
    //   1468	1527	1544	java/lang/Error
    //   624	651	1564	java/lang/Throwable
    //   778	793	1755	java/lang/Exception
    //   975	994	1803	java/lang/Exception
    //   1781	1800	1803	java/lang/Exception
  }
  
  public final void a(eq parameq)
  {
    if (parameq != null) {}
    try
    {
      if (this.K.isAllowDirection()) {
        parameq.getExtra().putDouble("direction", this.b.b());
      }
      parameq.getExtra().putString("motion", this.c.e());
      parameq.getExtra().putAll(this.K.getExtras());
      return;
    }
    catch (Throwable parameq) {}
  }
  
  @TargetApi(19)
  public final boolean a()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        Sensor localSensor = ((SensorManager)this.G.a.getSystemService("sensor")).getDefaultSensor(19);
        return localSensor != null;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return false;
  }
  
  public final int b()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.G.c;
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
  
  public final TencentPedestrianData c()
  {
    float f1 = 0.0F;
    Object localObject1 = this.G.c;
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
            return f2;
          }
        };
      }
      catch (Throwable localThrowable)
      {
        final long l1;
        final float f2;
        Object localObject2 = null;
        continue;
      }
      return localObject1;
      l1 = 0L;
      f2 = 0.0F;
    }
  }
  
  public final void d()
  {
    ev.a("TxLocationManagerImpl", 6, "shutdown");
    k();
    int i1;
    if (this.o != null) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        this.o.a();
      }
      synchronized (this.J)
      {
        this.d = null;
        this.B.a();
        l();
        this.H = "stop";
        j();
        return;
        i1 = 0;
      }
    }
  }
  
  public final void onCellInfoEvent(ee paramee)
  {
    ev.b("TxLocationManagerImpl", "cellCallback:" + System.currentTimeMillis());
    int i4 = paramee.e;
    int i5 = paramee.f;
    Object localObject = this.C;
    int i2;
    if (localObject != null) {
      i2 = ((ee)localObject).f;
    }
    for (int i3 = ((ee)localObject).e;; i3 = 0)
    {
      this.C = paramee;
      int i1;
      if (this.t != null) {
        if (this.t.b()) {
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 != 0) {
          this.D = null;
        }
        if ((i1 == 0) && ((this.D == null) || (this.D.a(System.currentTimeMillis(), 30000L))))
        {
          if (this.o != null)
          {
            localObject = this.o.obtainMessage(3999, "wifi_not_received");
            this.o.sendMessageDelayed((Message)localObject, 2000L);
          }
          label155:
          if (i1 != 0) {
            break label302;
          }
        }
        label302:
        for (localObject = "scan wifi";; localObject = "prepare json. wifi is not scannable?")
        {
          ev.a("TxLocationManagerImpl", String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i1), localObject }));
          if (this.w != null)
          {
            paramee = new cw(paramee.b, paramee.c, paramee.d, paramee.e, paramee.f);
            localObject = new ArrayList();
            ((List)localObject).add(paramee);
            this.w.a(paramee, (List)localObject);
          }
          return;
          i1 = 1;
          break;
          a(3999);
          break label155;
        }
        i1 = 1;
      }
      i2 = 0;
    }
  }
  
  public final void onGpsInfoEvent(ef paramef)
  {
    int i4;
    int i3;
    Object localObject1;
    Location localLocation;
    Object localObject2;
    double d2;
    double d1;
    int i2;
    int i1;
    if (paramef.a != do.a)
    {
      this.E = paramef;
      if (!this.K.getExtras().getBoolean("daemon"))
      {
        int i5 = dq.a().a(paramef);
        i4 = this.a;
        i3 = this.K.getRequestLevel();
        localObject1 = this.N;
        localLocation = new Location(paramef.a);
        localObject2 = localLocation.getExtras();
        d2 = 0.0D;
        d1 = 0.0D;
        i2 = 0;
        i1 = 0;
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
        if (i5 != -1) {
          break label485;
        }
        this.U = true;
        i1 += 2;
      }
    }
    label330:
    label338:
    label485:
    for (;;)
    {
      if (i4 == 0)
      {
        i2 = 1;
        if (i2 == 0) {
          break label338;
        }
        localObject2 = new eq.a();
        ((eq.a)localObject2).b = ((eq)localObject1);
        ((eq.a)localObject2).d = "gps";
        if (!this.U) {
          break label330;
        }
      }
      for (localObject1 = "fake";; localObject1 = "gps")
      {
        ((eq.a)localObject2).e = ((String)localObject1);
        ((eq.a)localObject2).c = i3;
        localObject1 = ((eq.a)localObject2).a(new Location(paramef.a)).a();
        localLocation.setLatitude(d2);
        localLocation.setLongitude(d1);
        ((eq)localObject1).a(localLocation);
        ((eq)localObject1).a(i1);
        a(0, (eq)localObject1);
        if (this.s != null) {
          this.s.b();
        }
        if (this.w != null) {
          this.w.a(paramef.a);
        }
        return;
        i2 = 0;
        break;
      }
      if (m()) {
        a(3999);
      }
      localObject2 = new eq.a();
      ((eq.a)localObject2).b = ((eq)localObject1);
      ((eq.a)localObject2).d = "gps";
      if (this.U) {}
      for (localObject1 = "fake";; localObject1 = "gps")
      {
        ((eq.a)localObject2).e = ((String)localObject1);
        ((eq.a)localObject2).c = i3;
        localObject1 = ((eq.a)localObject2).a(new Location(paramef.a)).a();
        localLocation.setLatitude(d2);
        localLocation.setLongitude(d1);
        ((eq)localObject1).a(localLocation);
        ev.b("TxLocationManagerImpl", "updateLastLocation");
        ((eq)localObject1).a(i1);
        a(0, (eq)localObject1);
        a(12004, 3);
        break;
      }
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    int i1 = ev.a(this.G.a);
    String str;
    if (i1 != -1) {
      if (i1 == 0) {
        str = "mobile";
      }
    }
    for (;;)
    {
      switch (paramInteger.intValue())
      {
      default: 
        return;
        if (i1 == 1) {
          str = "wifi";
        } else {
          str = "none";
        }
        break;
      }
    }
    ev.a("TxLocationManagerImpl", 4, "onNetworkEvent: networks not found");
    return;
    ev.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " disconnected");
    return;
    ev.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " connected");
    a(7999, 1000L);
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(ei paramei)
  {
    ev.b("TxLocationManagerImpl", "wifiCallback:" + System.currentTimeMillis());
    if (this.o != null) {
      this.o.removeMessages(3999, "wifi_not_received");
    }
    if (paramei == ei.a)
    {
      ev.a("TxLocationManagerImpl", "onWifiChanged --> clear wifi if needed");
      a(555, 1500L);
    }
    for (;;)
    {
      if (this.w != null) {
        this.w.a(Collections.unmodifiableList(paramei.b));
      }
      return;
      if ((this.D == null) || (!this.I) || (Collections.unmodifiableList(paramei.b).size() < 3) || (!this.D.a(paramei)))
      {
        ev.a("TxLocationManagerImpl", "onWifiChanged: --> prepare json");
        a(3999);
      }
      this.D = paramei;
    }
  }
  
  final class a
    extends Handler
  {
    private int a = 0;
    private boolean b = true;
    
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void a()
    {
      removeCallbacksAndMessages(null);
      this.b = true;
      this.a = 0;
    }
    
    /* Error */
    public final void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   4: invokestatic 42	c/t/m/g/ds:a	(Lc/t/m/g/ds;)Ljava/lang/Object;
      //   7: astore 12
      //   9: aload 12
      //   11: monitorenter
      //   12: aload_0
      //   13: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   16: invokestatic 45	c/t/m/g/ds:b	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentLocationListener;
      //   19: ifnonnull +7 -> 26
      //   22: aload 12
      //   24: monitorexit
      //   25: return
      //   26: aload_0
      //   27: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   30: invokestatic 45	c/t/m/g/ds:b	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentLocationListener;
      //   33: astore 11
      //   35: aload 12
      //   37: monitorexit
      //   38: aload_0
      //   39: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   42: invokestatic 48	c/t/m/g/ds:c	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   45: astore 13
      //   47: aload 13
      //   49: invokevirtual 54	com/tencent/map/geolocation/TencentLocationRequest:getRequestLevel	()I
      //   52: istore 4
      //   54: aload 13
      //   56: invokevirtual 58	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
      //   59: lstore 5
      //   61: aload 13
      //   63: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   66: ldc 64
      //   68: invokevirtual 70	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
      //   71: istore 10
      //   73: aload_1
      //   74: getfield 75	android/os/Message:what	I
      //   77: lookupswitch	default:+91->168, 555:+92->169, 3998:+1330->1407, 3999:+564->641, 4996:+2757->2834, 4997:+2278->2355, 4998:+2726->2803, 4999:+1543->1620, 7999:+547->624, 11998:+408->485, 11999:+115->192
      //   169: aload_0
      //   170: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   173: invokestatic 79	c/t/m/g/ds:D	(Lc/t/m/g/ds;)Lc/t/m/g/ei;
      //   176: pop
      //   177: aload_0
      //   178: sipush 3999
      //   181: invokevirtual 83	c/t/m/g/ds$a:sendEmptyMessage	(I)Z
      //   184: pop
      //   185: return
      //   186: astore_1
      //   187: aload 12
      //   189: monitorexit
      //   190: aload_1
      //   191: athrow
      //   192: aload_0
      //   193: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   196: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   199: ifnull +214 -> 413
      //   202: aload 13
      //   204: invokevirtual 58	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
      //   207: lconst_0
      //   208: lcmp
      //   209: ifle +204 -> 413
      //   212: aload_0
      //   213: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   216: invokestatic 91	c/t/m/g/ds:e	(Lc/t/m/g/ds;)Ljava/lang/String;
      //   219: ifnull +194 -> 413
      //   222: aload_0
      //   223: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   226: invokestatic 91	c/t/m/g/ds:e	(Lc/t/m/g/ds;)Ljava/lang/String;
      //   229: ldc 93
      //   231: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   234: ifeq +179 -> 413
      //   237: aload_0
      //   238: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   241: aload_0
      //   242: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   245: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   248: invokestatic 101	c/t/m/g/ds:a	(Lc/t/m/g/ds;Lc/t/m/g/eq;)V
      //   251: ldc 103
      //   253: new 105	java/lang/StringBuilder
      //   256: dup
      //   257: ldc 107
      //   259: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   262: aload_0
      //   263: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   266: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   269: invokevirtual 116	c/t/m/g/eq:getLatitude	()D
      //   272: invokevirtual 120	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   275: ldc 122
      //   277: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   280: aload_0
      //   281: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   284: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   287: invokevirtual 128	c/t/m/g/eq:getLongitude	()D
      //   290: invokevirtual 120	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   293: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   296: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   299: aload 11
      //   301: aload_0
      //   302: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   305: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   308: aload_0
      //   309: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   312: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   315: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   318: aload_0
      //   319: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   322: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   325: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   328: checkcast 95	java/lang/String
      //   331: invokeinterface 156 4 0
      //   336: aload_0
      //   337: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   340: invokestatic 160	c/t/m/g/ds:g	(Lc/t/m/g/ds;)Z
      //   343: ifeq +70 -> 413
      //   346: aload_0
      //   347: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   350: invokestatic 164	c/t/m/g/ds:h	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   353: ifnull +60 -> 413
      //   356: aload_0
      //   357: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   360: invokestatic 164	c/t/m/g/ds:h	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   363: aload_0
      //   364: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   367: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   370: aload_0
      //   371: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   374: invokestatic 168	c/t/m/g/ds:i	(Lc/t/m/g/ds;)D
      //   377: ldc2_w 169
      //   380: ddiv
      //   381: iconst_2
      //   382: invokestatic 173	c/t/m/g/ev:a	(DI)D
      //   385: aload_0
      //   386: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   389: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   392: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   395: aload_0
      //   396: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   399: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   402: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   405: checkcast 95	java/lang/String
      //   408: invokeinterface 179 6 0
      //   413: lload 5
      //   415: lconst_0
      //   416: lcmp
      //   417: ifle +18 -> 435
      //   420: iload 10
      //   422: ifne +13 -> 435
      //   425: aload_0
      //   426: sipush 11999
      //   429: lload 5
      //   431: invokevirtual 183	c/t/m/g/ds$a:sendEmptyMessageDelayed	(IJ)Z
      //   434: pop
      //   435: aload_0
      //   436: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   439: invokestatic 186	c/t/m/g/ds:j	(Lc/t/m/g/ds;)Z
      //   442: istore 9
      //   444: aload_0
      //   445: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   448: invokestatic 190	c/t/m/g/ds:k	(Lc/t/m/g/ds;)Lc/t/m/g/ea;
      //   451: iload 9
      //   453: putfield 194	c/t/m/g/ea:d	Z
      //   456: iload 9
      //   458: ifeq +2433 -> 2891
      //   461: lload 5
      //   463: ldc2_w 195
      //   466: lcmp
      //   467: ifle +2424 -> 2891
      //   470: aload_0
      //   471: sipush 3999
      //   474: lload 5
      //   476: ldc2_w 197
      //   479: lsub
      //   480: invokevirtual 183	c/t/m/g/ds$a:sendEmptyMessageDelayed	(IJ)Z
      //   483: pop
      //   484: return
      //   485: aload_0
      //   486: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   489: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   492: ifnull +2399 -> 2891
      //   495: aload_0
      //   496: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   499: aload_0
      //   500: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   503: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   506: invokestatic 101	c/t/m/g/ds:a	(Lc/t/m/g/ds;Lc/t/m/g/eq;)V
      //   509: aload 11
      //   511: aload_0
      //   512: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   515: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   518: aload_0
      //   519: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   522: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   525: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   528: aload_0
      //   529: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   532: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   535: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   538: checkcast 95	java/lang/String
      //   541: invokeinterface 156 4 0
      //   546: aload_0
      //   547: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   550: invokestatic 160	c/t/m/g/ds:g	(Lc/t/m/g/ds;)Z
      //   553: ifeq +2338 -> 2891
      //   556: aload_0
      //   557: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   560: invokestatic 164	c/t/m/g/ds:h	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   563: ifnull +2328 -> 2891
      //   566: aload_0
      //   567: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   570: invokestatic 164	c/t/m/g/ds:h	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   573: aload_0
      //   574: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   577: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   580: aload_0
      //   581: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   584: invokestatic 168	c/t/m/g/ds:i	(Lc/t/m/g/ds;)D
      //   587: ldc2_w 169
      //   590: ddiv
      //   591: iconst_2
      //   592: invokestatic 173	c/t/m/g/ev:a	(DI)D
      //   595: aload_0
      //   596: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   599: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   602: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   605: aload_0
      //   606: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   609: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   612: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   615: checkcast 95	java/lang/String
      //   618: invokeinterface 179 6 0
      //   623: return
      //   624: aload_0
      //   625: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   628: invokestatic 201	c/t/m/g/ds:l	(Lc/t/m/g/ds;)Z
      //   631: ifne +2260 -> 2891
      //   634: ldc 103
      //   636: ldc 203
      //   638: invokestatic 205	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   641: ldc 103
      //   643: new 105	java/lang/StringBuilder
      //   646: dup
      //   647: ldc 207
      //   649: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   652: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   655: invokestatic 214	c/t/m/g/ds:f	()J
      //   658: lsub
      //   659: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   662: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   665: invokestatic 205	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   668: iload 10
      //   670: ifeq +266 -> 936
      //   673: ldc 103
      //   675: new 105	java/lang/StringBuilder
      //   678: dup
      //   679: ldc 219
      //   681: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   684: aload_0
      //   685: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   688: invokestatic 223	c/t/m/g/ds:m	(Lc/t/m/g/ds;)J
      //   691: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   694: ldc 122
      //   696: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   699: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   702: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   705: ldc 122
      //   707: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   710: aload_0
      //   711: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   714: invokestatic 226	c/t/m/g/ds:n	(Lc/t/m/g/ds;)J
      //   717: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   720: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   723: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   726: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   729: aload_0
      //   730: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   733: invokestatic 226	c/t/m/g/ds:n	(Lc/t/m/g/ds;)J
      //   736: lsub
      //   737: aload_0
      //   738: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   741: invokestatic 223	c/t/m/g/ds:m	(Lc/t/m/g/ds;)J
      //   744: lcmp
      //   745: iflt +2146 -> 2891
      //   748: aload_0
      //   749: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   752: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   755: invokestatic 229	c/t/m/g/ds:a	(Lc/t/m/g/ds;J)J
      //   758: pop2
      //   759: aload_1
      //   760: getfield 233	android/os/Message:obj	Ljava/lang/Object;
      //   763: ifnull +30 -> 793
      //   766: ldc 103
      //   768: new 105	java/lang/StringBuilder
      //   771: dup
      //   772: ldc 235
      //   774: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   777: aload_1
      //   778: getfield 233	android/os/Message:obj	Ljava/lang/Object;
      //   781: invokevirtual 238	java/lang/Object:toString	()Ljava/lang/String;
      //   784: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   787: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   790: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   793: aload_0
      //   794: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   797: invokestatic 241	c/t/m/g/ds:p	(Lc/t/m/g/ds;)I
      //   800: istore_3
      //   801: aload_0
      //   802: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   805: invokestatic 245	c/t/m/g/ds:q	(Lc/t/m/g/ds;)Lc/t/m/g/eg;
      //   808: astore 12
      //   810: aload_0
      //   811: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   814: invokestatic 248	c/t/m/g/ds:r	(Lc/t/m/g/ds;)Ljava/lang/String;
      //   817: astore_1
      //   818: aload_0
      //   819: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   822: invokestatic 252	c/t/m/g/ds:s	(Lc/t/m/g/ds;)Lc/t/m/g/de;
      //   825: astore 14
      //   827: aload_0
      //   828: getfield 23	c/t/m/g/ds$a:b	Z
      //   831: ifeq +187 -> 1018
      //   834: iload 10
      //   836: ifne +182 -> 1018
      //   839: iconst_1
      //   840: istore 9
      //   842: aload 12
      //   844: iload 4
      //   846: aload_1
      //   847: aload 14
      //   849: iload 9
      //   851: aload_0
      //   852: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   855: invokestatic 255	c/t/m/g/ds:t	(Lc/t/m/g/ds;)Z
      //   858: iload 10
      //   860: invokevirtual 260	c/t/m/g/eg:a	(ILjava/lang/String;Lc/t/m/g/de;ZZZ)Ljava/lang/String;
      //   863: astore_1
      //   864: aload_1
      //   865: invokestatic 262	c/t/m/g/ev:b	(Ljava/lang/String;)Z
      //   868: ifne +156 -> 1024
      //   871: iconst_1
      //   872: istore_2
      //   873: iload_2
      //   874: ifeq +155 -> 1029
      //   877: aload_0
      //   878: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   881: invokestatic 186	c/t/m/g/ds:j	(Lc/t/m/g/ds;)Z
      //   884: istore 9
      //   886: ldc 103
      //   888: new 105	java/lang/StringBuilder
      //   891: dup
      //   892: ldc_w 264
      //   895: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   898: iload 9
      //   900: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   903: ldc_w 269
      //   906: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   909: aload_1
      //   910: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   913: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   916: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   919: iload 9
      //   921: ifne +1970 -> 2891
      //   924: aload_0
      //   925: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   928: iconst_2
      //   929: getstatic 272	c/t/m/g/eq:a	Lc/t/m/g/eq;
      //   932: invokestatic 275	c/t/m/g/ds:a	(Lc/t/m/g/ds;ILc/t/m/g/eq;)V
      //   935: return
      //   936: aload_0
      //   937: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   940: invokestatic 186	c/t/m/g/ds:j	(Lc/t/m/g/ds;)Z
      //   943: istore 9
      //   945: aload_0
      //   946: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   949: invokestatic 190	c/t/m/g/ds:k	(Lc/t/m/g/ds;)Lc/t/m/g/ea;
      //   952: iload 9
      //   954: putfield 194	c/t/m/g/ea:d	Z
      //   957: iload 9
      //   959: ifeq -200 -> 759
      //   962: lload 5
      //   964: ldc2_w 195
      //   967: lcmp
      //   968: ifle -209 -> 759
      //   971: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   974: lstore 7
      //   976: lload 7
      //   978: aload_0
      //   979: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   982: invokestatic 278	c/t/m/g/ds:o	(Lc/t/m/g/ds;)J
      //   985: lsub
      //   986: lload 5
      //   988: ldc2_w 197
      //   991: lsub
      //   992: lcmp
      //   993: iflt +16 -> 1009
      //   996: aload_0
      //   997: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1000: lload 7
      //   1002: invokestatic 280	c/t/m/g/ds:b	(Lc/t/m/g/ds;J)J
      //   1005: pop2
      //   1006: goto -247 -> 759
      //   1009: ldc 103
      //   1011: ldc_w 282
      //   1014: invokestatic 205	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1017: return
      //   1018: iconst_0
      //   1019: istore 9
      //   1021: goto -179 -> 842
      //   1024: iconst_0
      //   1025: istore_2
      //   1026: goto -153 -> 873
      //   1029: iload 10
      //   1031: ifne +80 -> 1111
      //   1034: aload 13
      //   1036: invokestatic 288	com/tencent/map/geolocation/internal/TencentExtraKeys:isRequestRawData	(Lcom/tencent/map/geolocation/TencentLocationRequest;)Z
      //   1039: ifeq +72 -> 1111
      //   1042: new 290	c/t/m/g/eq$a
      //   1045: dup
      //   1046: invokespecial 292	c/t/m/g/eq$a:<init>	()V
      //   1049: astore 12
      //   1051: aload 12
      //   1053: aconst_null
      //   1054: putfield 294	c/t/m/g/eq$a:b	Lc/t/m/g/eq;
      //   1057: aload 12
      //   1059: iload 4
      //   1061: putfield 296	c/t/m/g/eq$a:c	I
      //   1064: aload 12
      //   1066: invokevirtual 299	c/t/m/g/eq$a:a	()Lc/t/m/g/eq;
      //   1069: astore 12
      //   1071: aload 12
      //   1073: aload_1
      //   1074: invokevirtual 303	java/lang/String:getBytes	()[B
      //   1077: invokestatic 307	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawData	(Lcom/tencent/map/geolocation/TencentLocation;[B)Lcom/tencent/map/geolocation/TencentLocation;
      //   1080: pop
      //   1081: aload_0
      //   1082: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1085: aload 12
      //   1087: invokestatic 101	c/t/m/g/ds:a	(Lc/t/m/g/ds;Lc/t/m/g/eq;)V
      //   1090: aload 11
      //   1092: aload 12
      //   1094: iconst_0
      //   1095: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   1098: iconst_0
      //   1099: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   1102: checkcast 95	java/lang/String
      //   1105: invokeinterface 156 4 0
      //   1110: return
      //   1111: ldc 103
      //   1113: new 105	java/lang/StringBuilder
      //   1116: dup
      //   1117: ldc_w 309
      //   1120: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1123: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   1126: invokestatic 214	c/t/m/g/ds:f	()J
      //   1129: lsub
      //   1130: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1133: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1136: invokestatic 205	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1139: aload_0
      //   1140: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1143: invokestatic 312	c/t/m/g/ds:u	(Lc/t/m/g/ds;)Lc/t/m/g/eg;
      //   1146: astore 11
      //   1148: aload 11
      //   1150: ifnull +159 -> 1309
      //   1153: aload 11
      //   1155: invokevirtual 315	c/t/m/g/eg:b	()Z
      //   1158: ifeq +92 -> 1250
      //   1161: aload 12
      //   1163: invokevirtual 315	c/t/m/g/eg:b	()Z
      //   1166: ifeq +84 -> 1250
      //   1169: aload 12
      //   1171: getfield 318	c/t/m/g/eg:b	Lc/t/m/g/ei;
      //   1174: aload 11
      //   1176: getfield 318	c/t/m/g/eg:b	Lc/t/m/g/ei;
      //   1179: invokevirtual 323	c/t/m/g/ei:a	(Lc/t/m/g/ei;)Z
      //   1182: ifeq +68 -> 1250
      //   1185: iconst_2
      //   1186: istore_2
      //   1187: aload_0
      //   1188: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1191: invokestatic 141	c/t/m/g/ds:f	(Lc/t/m/g/ds;)I
      //   1194: ifne +120 -> 1314
      //   1197: aload_0
      //   1198: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1201: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   1204: ifnull +110 -> 1314
      //   1207: iload_2
      //   1208: iconst_1
      //   1209: if_icmpeq +25 -> 1234
      //   1212: iload_2
      //   1213: iconst_2
      //   1214: if_icmplt +100 -> 1314
      //   1217: aload_0
      //   1218: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1221: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   1224: invokevirtual 327	c/t/m/g/eq:getAccuracy	()F
      //   1227: ldc_w 328
      //   1230: fcmpg
      //   1231: ifge +83 -> 1314
      //   1234: aload_0
      //   1235: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1238: iconst_0
      //   1239: aload_0
      //   1240: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1243: invokestatic 87	c/t/m/g/ds:d	(Lc/t/m/g/ds;)Lc/t/m/g/eq;
      //   1246: invokestatic 275	c/t/m/g/ds:a	(Lc/t/m/g/ds;ILc/t/m/g/eq;)V
      //   1249: return
      //   1250: aload 11
      //   1252: invokevirtual 315	c/t/m/g/eg:b	()Z
      //   1255: ifne +54 -> 1309
      //   1258: aload 12
      //   1260: invokevirtual 315	c/t/m/g/eg:b	()Z
      //   1263: ifne +46 -> 1309
      //   1266: aload 11
      //   1268: invokevirtual 330	c/t/m/g/eg:a	()Z
      //   1271: ifeq +38 -> 1309
      //   1274: aload 12
      //   1276: invokevirtual 330	c/t/m/g/eg:a	()Z
      //   1279: ifeq +30 -> 1309
      //   1282: aload 12
      //   1284: getfield 333	c/t/m/g/eg:c	Lc/t/m/g/ee;
      //   1287: invokevirtual 337	c/t/m/g/ee:b	()Ljava/lang/String;
      //   1290: aload 11
      //   1292: getfield 333	c/t/m/g/eg:c	Lc/t/m/g/ee;
      //   1295: invokevirtual 337	c/t/m/g/ee:b	()Ljava/lang/String;
      //   1298: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   1301: ifeq +8 -> 1309
      //   1304: iconst_1
      //   1305: istore_2
      //   1306: goto -119 -> 1187
      //   1309: iconst_0
      //   1310: istore_2
      //   1311: goto -124 -> 1187
      //   1314: aload_0
      //   1315: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1318: invokestatic 341	c/t/m/g/ds:v	(Lc/t/m/g/ds;)Lc/t/m/g/dy;
      //   1321: astore 11
      //   1323: aload_1
      //   1324: ldc_w 343
      //   1327: invokevirtual 346	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   1330: invokestatic 351	c/t/m/g/dk:a	([B)[B
      //   1333: astore 13
      //   1335: new 353	c/t/m/g/dy$a
      //   1338: dup
      //   1339: iconst_1
      //   1340: aload 13
      //   1342: aload 13
      //   1344: iload_3
      //   1345: invokestatic 358	c/t/m/g/dy:a	([BI)Ljava/lang/String;
      //   1348: aload 12
      //   1350: invokespecial 361	c/t/m/g/dy$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
      //   1353: astore 12
      //   1355: aload 12
      //   1357: aload_1
      //   1358: putfield 364	c/t/m/g/dy$a:b	Ljava/lang/String;
      //   1361: aload 12
      //   1363: invokestatic 367	c/t/m/g/dy$a:a	(Lc/t/m/g/dy$a;)[B
      //   1366: ifnull +14 -> 1380
      //   1369: aload 11
      //   1371: getfield 370	c/t/m/g/dy:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1374: aload 12
      //   1376: invokevirtual 376	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
      //   1379: pop
      //   1380: aload_0
      //   1381: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1384: invokestatic 380	c/t/m/g/ds:w	(Lc/t/m/g/ds;)Lc/t/m/g/df;
      //   1387: pop
      //   1388: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   1391: pop2
      //   1392: return
      //   1393: astore_1
      //   1394: ldc_w 382
      //   1397: ldc_w 384
      //   1400: aload_1
      //   1401: invokestatic 387	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1404: goto -24 -> 1380
      //   1407: aload_0
      //   1408: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1411: invokestatic 245	c/t/m/g/ds:q	(Lc/t/m/g/ds;)Lc/t/m/g/eg;
      //   1414: astore 12
      //   1416: aload 12
      //   1418: iload 4
      //   1420: aload_0
      //   1421: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1424: invokestatic 248	c/t/m/g/ds:r	(Lc/t/m/g/ds;)Ljava/lang/String;
      //   1427: aload_0
      //   1428: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1431: invokestatic 252	c/t/m/g/ds:s	(Lc/t/m/g/ds;)Lc/t/m/g/de;
      //   1434: iconst_1
      //   1435: iconst_0
      //   1436: iconst_0
      //   1437: invokevirtual 260	c/t/m/g/eg:a	(ILjava/lang/String;Lc/t/m/g/de;ZZZ)Ljava/lang/String;
      //   1440: astore_1
      //   1441: aload_1
      //   1442: invokestatic 262	c/t/m/g/ev:b	(Ljava/lang/String;)Z
      //   1445: ifne +25 -> 1470
      //   1448: iconst_1
      //   1449: istore_2
      //   1450: iload_2
      //   1451: ifeq +24 -> 1475
      //   1454: ldc 103
      //   1456: ldc_w 389
      //   1459: aload_1
      //   1460: invokestatic 393	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   1463: invokevirtual 397	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1466: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1469: return
      //   1470: iconst_0
      //   1471: istore_2
      //   1472: goto -22 -> 1450
      //   1475: aload_0
      //   1476: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1479: invokestatic 341	c/t/m/g/ds:v	(Lc/t/m/g/ds;)Lc/t/m/g/dy;
      //   1482: astore 11
      //   1484: aload_0
      //   1485: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1488: invokestatic 241	c/t/m/g/ds:p	(Lc/t/m/g/ds;)I
      //   1491: istore_2
      //   1492: invokestatic 402	android/os/SystemClock:elapsedRealtime	()J
      //   1495: lstore 5
      //   1497: aload_1
      //   1498: ldc_w 343
      //   1501: invokevirtual 346	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   1504: invokestatic 351	c/t/m/g/dk:a	([B)[B
      //   1507: astore 13
      //   1509: new 353	c/t/m/g/dy$a
      //   1512: dup
      //   1513: iconst_3
      //   1514: aload 13
      //   1516: aload 13
      //   1518: iload_2
      //   1519: invokestatic 358	c/t/m/g/dy:a	([BI)Ljava/lang/String;
      //   1522: aload 12
      //   1524: invokespecial 361	c/t/m/g/dy$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
      //   1527: astore 12
      //   1529: aload 12
      //   1531: aload_1
      //   1532: putfield 364	c/t/m/g/dy$a:b	Ljava/lang/String;
      //   1535: iconst_0
      //   1536: istore 9
      //   1538: aload 12
      //   1540: invokestatic 367	c/t/m/g/dy$a:a	(Lc/t/m/g/dy$a;)[B
      //   1543: ifnull +32 -> 1575
      //   1546: aload 11
      //   1548: getfield 370	c/t/m/g/dy:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1551: invokevirtual 405	java/util/concurrent/LinkedBlockingQueue:clear	()V
      //   1554: aload 11
      //   1556: getfield 370	c/t/m/g/dy:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1559: aload 12
      //   1561: invokevirtual 376	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
      //   1564: istore 9
      //   1566: ldc_w 382
      //   1569: ldc_w 407
      //   1572: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1575: iload 9
      //   1577: ifeq +10 -> 1587
      //   1580: aload 11
      //   1582: lload 5
      //   1584: putfield 410	c/t/m/g/dy:h	J
      //   1587: aload_0
      //   1588: sipush 3998
      //   1591: aload_0
      //   1592: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1595: invokestatic 48	c/t/m/g/ds:c	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   1598: invokevirtual 413	com/tencent/map/geolocation/TencentLocationRequest:getCheckInterval	()J
      //   1601: invokevirtual 183	c/t/m/g/ds$a:sendEmptyMessageDelayed	(IJ)Z
      //   1604: pop
      //   1605: return
      //   1606: astore_1
      //   1607: ldc_w 382
      //   1610: ldc_w 384
      //   1613: aload_1
      //   1614: invokestatic 387	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1617: goto -30 -> 1587
      //   1620: aload_0
      //   1621: sipush 4998
      //   1624: invokevirtual 417	c/t/m/g/ds$a:removeMessages	(I)V
      //   1627: aload_0
      //   1628: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1631: invokestatic 48	c/t/m/g/ds:c	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   1634: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   1637: ldc 64
      //   1639: invokevirtual 70	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
      //   1642: ifeq +13 -> 1655
      //   1645: aload_0
      //   1646: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1649: iconst_1
      //   1650: invokestatic 420	c/t/m/g/ds:a	(Lc/t/m/g/ds;Z)Z
      //   1653: pop
      //   1654: return
      //   1655: ldc 103
      //   1657: new 105	java/lang/StringBuilder
      //   1660: dup
      //   1661: ldc_w 422
      //   1664: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1667: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   1670: invokestatic 214	c/t/m/g/ds:f	()J
      //   1673: lsub
      //   1674: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1677: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1680: invokestatic 205	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1683: aload_1
      //   1684: getfield 233	android/os/Message:obj	Ljava/lang/Object;
      //   1687: checkcast 424	android/util/Pair
      //   1690: astore 12
      //   1692: aload 12
      //   1694: getfield 427	android/util/Pair:first	Ljava/lang/Object;
      //   1697: invokevirtual 238	java/lang/Object:toString	()Ljava/lang/String;
      //   1700: astore 13
      //   1702: aload 12
      //   1704: getfield 430	android/util/Pair:second	Ljava/lang/Object;
      //   1707: checkcast 353	c/t/m/g/dy$a
      //   1710: astore 12
      //   1712: aload 12
      //   1714: getfield 432	c/t/m/g/dy$a:a	Ljava/lang/Object;
      //   1717: checkcast 257	c/t/m/g/eg
      //   1720: astore 14
      //   1722: aload_0
      //   1723: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1726: aload 14
      //   1728: invokestatic 435	c/t/m/g/ds:a	(Lc/t/m/g/ds;Lc/t/m/g/eg;)Lc/t/m/g/eg;
      //   1731: pop
      //   1732: aload 12
      //   1734: getfield 364	c/t/m/g/dy$a:b	Ljava/lang/String;
      //   1737: astore 14
      //   1739: new 290	c/t/m/g/eq$a
      //   1742: dup
      //   1743: invokespecial 292	c/t/m/g/eq$a:<init>	()V
      //   1746: astore 12
      //   1748: aload 12
      //   1750: aload 13
      //   1752: putfield 437	c/t/m/g/eq$a:a	Ljava/lang/String;
      //   1755: aload 12
      //   1757: iload 4
      //   1759: putfield 296	c/t/m/g/eq$a:c	I
      //   1762: aload 12
      //   1764: invokevirtual 299	c/t/m/g/eq$a:a	()Lc/t/m/g/eq;
      //   1767: astore 12
      //   1769: aload 12
      //   1771: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   1774: ldc_w 442
      //   1777: aload 13
      //   1779: invokevirtual 445	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   1782: aload 12
      //   1784: invokestatic 448	c/t/m/g/eq:a	(Lc/t/m/g/eq;)V
      //   1787: aload 12
      //   1789: aload_0
      //   1790: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   1793: invokestatic 452	c/t/m/g/ds:x	(Lc/t/m/g/ds;)Lc/t/m/g/ee;
      //   1796: iconst_0
      //   1797: invokestatic 455	c/t/m/g/eq:a	(Lc/t/m/g/eq;Lc/t/m/g/ee;Z)Lc/t/m/g/eq;
      //   1800: pop
      //   1801: aload 12
      //   1803: aload 14
      //   1805: invokestatic 459	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
      //   1808: aload 12
      //   1810: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   1813: ldc_w 461
      //   1816: aload_1
      //   1817: getfield 464	android/os/Message:arg1	I
      //   1820: i2l
      //   1821: invokevirtual 468	android/os/Bundle:putLong	(Ljava/lang/String;J)V
      //   1824: getstatic 471	com/tencent/map/geolocation/internal/TencentExtraKeys:COMPHTTPIO	Z
      //   1827: ifeq +19 -> 1846
      //   1830: aload 12
      //   1832: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   1835: ldc_w 473
      //   1838: aload_1
      //   1839: getfield 476	android/os/Message:arg2	I
      //   1842: i2l
      //   1843: invokevirtual 468	android/os/Bundle:putLong	(Ljava/lang/String;J)V
      //   1846: aload_0
      //   1847: iconst_0
      //   1848: putfield 23	c/t/m/g/ds$a:b	Z
      //   1851: aload 12
      //   1853: invokevirtual 479	c/t/m/g/eq:getVerifyKey	()Ljava/lang/String;
      //   1856: ifnull +235 -> 2091
      //   1859: aload 12
      //   1861: invokevirtual 479	c/t/m/g/eq:getVerifyKey	()Ljava/lang/String;
      //   1864: ldc_w 481
      //   1867: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   1870: ifne +221 -> 2091
      //   1873: aload 14
      //   1875: ifnull +116 -> 1991
      //   1878: new 483	org/json/JSONObject
      //   1881: dup
      //   1882: aload 14
      //   1884: invokespecial 484	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   1887: astore_1
      //   1888: aload_1
      //   1889: ldc_w 486
      //   1892: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1895: pop
      //   1896: aload_1
      //   1897: ldc_w 492
      //   1900: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1903: pop
      //   1904: aload_1
      //   1905: ldc_w 494
      //   1908: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1911: pop
      //   1912: aload_1
      //   1913: ldc_w 496
      //   1916: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1919: pop
      //   1920: aload_1
      //   1921: ldc_w 498
      //   1924: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1927: pop
      //   1928: aload_1
      //   1929: ldc_w 500
      //   1932: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1935: pop
      //   1936: aload_1
      //   1937: ldc_w 502
      //   1940: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1943: pop
      //   1944: aload_1
      //   1945: ldc_w 504
      //   1948: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1951: pop
      //   1952: aload_1
      //   1953: ldc_w 506
      //   1956: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1959: pop
      //   1960: aload_1
      //   1961: ldc_w 508
      //   1964: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1967: pop
      //   1968: aload_1
      //   1969: ldc_w 510
      //   1972: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1975: pop
      //   1976: aload 12
      //   1978: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   1981: ldc_w 512
      //   1984: aload_1
      //   1985: invokevirtual 513	org/json/JSONObject:toString	()Ljava/lang/String;
      //   1988: invokevirtual 445	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   1991: aload 12
      //   1993: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   1996: ldc_w 515
      //   1999: aload_0
      //   2000: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2003: invokestatic 519	c/t/m/g/ds:y	(Lc/t/m/g/ds;)Lc/t/m/g/dt;
      //   2006: invokevirtual 523	c/t/m/g/dt:e	()Ljava/lang/String;
      //   2009: invokevirtual 445	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2012: aload 12
      //   2014: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2017: aload_0
      //   2018: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2021: invokestatic 48	c/t/m/g/ds:c	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   2024: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   2027: invokevirtual 527	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
      //   2030: aload 12
      //   2032: invokevirtual 327	c/t/m/g/eq:getAccuracy	()F
      //   2035: f2d
      //   2036: ldc2_w 528
      //   2039: dcmpl
      //   2040: ifne +290 -> 2330
      //   2043: aload_0
      //   2044: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2047: invokestatic 532	c/t/m/g/ds:z	(Lc/t/m/g/ds;)Z
      //   2050: ifeq +280 -> 2330
      //   2053: iconst_1
      //   2054: istore 9
      //   2056: aload 12
      //   2058: aload_0
      //   2059: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2062: invokestatic 452	c/t/m/g/ds:x	(Lc/t/m/g/ds;)Lc/t/m/g/ee;
      //   2065: iload 9
      //   2067: invokestatic 455	c/t/m/g/eq:a	(Lc/t/m/g/eq;Lc/t/m/g/ee;Z)Lc/t/m/g/eq;
      //   2070: pop
      //   2071: aload 11
      //   2073: aload 12
      //   2075: iconst_0
      //   2076: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   2079: iconst_0
      //   2080: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2083: checkcast 95	java/lang/String
      //   2086: invokeinterface 156 4 0
      //   2091: aload_0
      //   2092: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2095: iconst_1
      //   2096: invokestatic 420	c/t/m/g/ds:a	(Lc/t/m/g/ds;Z)Z
      //   2099: pop
      //   2100: aload_0
      //   2101: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2104: invokestatic 186	c/t/m/g/ds:j	(Lc/t/m/g/ds;)Z
      //   2107: ifne +61 -> 2168
      //   2110: aload 12
      //   2112: aconst_null
      //   2113: putfield 534	c/t/m/g/eq:c	Ljava/lang/String;
      //   2116: aload 12
      //   2118: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2121: ldc_w 512
      //   2124: ldc_w 384
      //   2127: invokevirtual 445	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2130: aload_0
      //   2131: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2134: iconst_0
      //   2135: aload 12
      //   2137: invokestatic 275	c/t/m/g/ds:a	(Lc/t/m/g/ds;ILc/t/m/g/eq;)V
      //   2140: ldc 103
      //   2142: new 105	java/lang/StringBuilder
      //   2145: dup
      //   2146: ldc_w 422
      //   2149: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2152: invokestatic 212	java/lang/System:currentTimeMillis	()J
      //   2155: invokestatic 214	c/t/m/g/ds:f	()J
      //   2158: lsub
      //   2159: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2162: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2165: invokestatic 205	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   2168: aload_0
      //   2169: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2172: invokestatic 255	c/t/m/g/ds:t	(Lc/t/m/g/ds;)Z
      //   2175: ifeq +76 -> 2251
      //   2178: aload 12
      //   2180: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2183: astore_1
      //   2184: aload_1
      //   2185: ifnull +58 -> 2243
      //   2188: aload_1
      //   2189: ldc_w 536
      //   2192: iconst_m1
      //   2193: invokevirtual 540	android/os/Bundle:getInt	(Ljava/lang/String;I)I
      //   2196: istore_2
      //   2197: aload_0
      //   2198: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2201: invokestatic 252	c/t/m/g/ds:s	(Lc/t/m/g/ds;)Lc/t/m/g/de;
      //   2204: getfield 545	c/t/m/g/de:c	Landroid/content/SharedPreferences;
      //   2207: astore_1
      //   2208: ldc 103
      //   2210: ldc_w 547
      //   2213: iload_2
      //   2214: invokestatic 550	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   2217: invokevirtual 397	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   2220: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2223: aload_1
      //   2224: invokeinterface 556 1 0
      //   2229: ldc_w 498
      //   2232: iload_2
      //   2233: invokeinterface 562 3 0
      //   2238: invokeinterface 565 1 0
      //   2243: aload_0
      //   2244: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2247: invokestatic 568	c/t/m/g/ds:A	(Lc/t/m/g/ds;)Z
      //   2250: pop
      //   2251: aload_0
      //   2252: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2255: aload 12
      //   2257: invokestatic 571	c/t/m/g/ds:b	(Lc/t/m/g/ds;Lc/t/m/g/eq;)Lc/t/m/g/eq;
      //   2260: pop
      //   2261: aload_0
      //   2262: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2265: invokestatic 574	c/t/m/g/ds:B	(Lc/t/m/g/ds;)Z
      //   2268: ifne +623 -> 2891
      //   2271: invokestatic 579	c/t/m/g/db:a	()Lc/t/m/g/db;
      //   2274: invokevirtual 581	c/t/m/g/db:b	()V
      //   2277: aload_0
      //   2278: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2281: invokestatic 584	c/t/m/g/ds:C	(Lc/t/m/g/ds;)Z
      //   2284: pop
      //   2285: return
      //   2286: astore_1
      //   2287: ldc 103
      //   2289: ldc_w 586
      //   2292: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2295: aload_0
      //   2296: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2299: invokestatic 201	c/t/m/g/ds:l	(Lc/t/m/g/ds;)Z
      //   2302: ifeq +589 -> 2891
      //   2305: aload_0
      //   2306: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2309: iconst_2
      //   2310: getstatic 272	c/t/m/g/eq:a	Lc/t/m/g/eq;
      //   2313: invokestatic 275	c/t/m/g/ds:a	(Lc/t/m/g/ds;ILc/t/m/g/eq;)V
      //   2316: return
      //   2317: astore_1
      //   2318: ldc 103
      //   2320: aload_1
      //   2321: invokevirtual 587	java/lang/Exception:toString	()Ljava/lang/String;
      //   2324: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2327: goto -336 -> 1991
      //   2330: iconst_0
      //   2331: istore 9
      //   2333: goto -277 -> 2056
      //   2336: astore_1
      //   2337: ldc 103
      //   2339: ldc_w 589
      //   2342: aload_1
      //   2343: invokestatic 393	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   2346: invokevirtual 397	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   2349: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2352: goto -109 -> 2243
      //   2355: aload_1
      //   2356: getfield 233	android/os/Message:obj	Ljava/lang/Object;
      //   2359: checkcast 424	android/util/Pair
      //   2362: astore 12
      //   2364: aload 12
      //   2366: getfield 427	android/util/Pair:first	Ljava/lang/Object;
      //   2369: invokevirtual 238	java/lang/Object:toString	()Ljava/lang/String;
      //   2372: astore_1
      //   2373: aload 12
      //   2375: getfield 430	android/util/Pair:second	Ljava/lang/Object;
      //   2378: checkcast 353	c/t/m/g/dy$a
      //   2381: astore 12
      //   2383: aload 12
      //   2385: getfield 432	c/t/m/g/dy$a:a	Ljava/lang/Object;
      //   2388: checkcast 257	c/t/m/g/eg
      //   2391: astore 13
      //   2393: aload 12
      //   2395: getfield 364	c/t/m/g/dy$a:b	Ljava/lang/String;
      //   2398: astore 14
      //   2400: aload_0
      //   2401: iconst_0
      //   2402: putfield 21	c/t/m/g/ds$a:a	I
      //   2405: new 290	c/t/m/g/eq$a
      //   2408: dup
      //   2409: invokespecial 292	c/t/m/g/eq$a:<init>	()V
      //   2412: astore 12
      //   2414: aload 12
      //   2416: aload_1
      //   2417: putfield 437	c/t/m/g/eq$a:a	Ljava/lang/String;
      //   2420: aload 12
      //   2422: iload 4
      //   2424: putfield 296	c/t/m/g/eq$a:c	I
      //   2427: aload 12
      //   2429: invokevirtual 299	c/t/m/g/eq$a:a	()Lc/t/m/g/eq;
      //   2432: astore 12
      //   2434: aload 12
      //   2436: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2439: ldc_w 442
      //   2442: aload_1
      //   2443: invokevirtual 445	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2446: aload 12
      //   2448: invokestatic 448	c/t/m/g/eq:a	(Lc/t/m/g/eq;)V
      //   2451: aload 12
      //   2453: invokevirtual 327	c/t/m/g/eq:getAccuracy	()F
      //   2456: f2d
      //   2457: ldc2_w 528
      //   2460: dcmpl
      //   2461: ifne +328 -> 2789
      //   2464: aload_0
      //   2465: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2468: invokestatic 532	c/t/m/g/ds:z	(Lc/t/m/g/ds;)Z
      //   2471: ifeq +318 -> 2789
      //   2474: iconst_1
      //   2475: istore 9
      //   2477: aload 12
      //   2479: aload_0
      //   2480: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2483: invokestatic 452	c/t/m/g/ds:x	(Lc/t/m/g/ds;)Lc/t/m/g/ee;
      //   2486: iload 9
      //   2488: invokestatic 455	c/t/m/g/eq:a	(Lc/t/m/g/eq;Lc/t/m/g/ee;Z)Lc/t/m/g/eq;
      //   2491: pop
      //   2492: aload 12
      //   2494: aload 14
      //   2496: invokestatic 459	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
      //   2499: iconst_0
      //   2500: istore_2
      //   2501: aload 13
      //   2503: getfield 592	c/t/m/g/eg:d	Lc/t/m/g/ef;
      //   2506: ifnull +12 -> 2518
      //   2509: aload 13
      //   2511: getfield 592	c/t/m/g/eg:d	Lc/t/m/g/ef;
      //   2514: getfield 595	c/t/m/g/ef:c	I
      //   2517: istore_2
      //   2518: aload 12
      //   2520: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2523: ldc_w 597
      //   2526: iload_2
      //   2527: invokevirtual 600	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   2530: aload 12
      //   2532: invokevirtual 479	c/t/m/g/eq:getVerifyKey	()Ljava/lang/String;
      //   2535: ifnull +356 -> 2891
      //   2538: aload 12
      //   2540: invokevirtual 479	c/t/m/g/eq:getVerifyKey	()Ljava/lang/String;
      //   2543: ldc_w 481
      //   2546: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   2549: ifne +342 -> 2891
      //   2552: aload 14
      //   2554: ifnull +134 -> 2688
      //   2557: new 483	org/json/JSONObject
      //   2560: dup
      //   2561: aload 14
      //   2563: invokespecial 484	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   2566: astore_1
      //   2567: aload_1
      //   2568: ldc_w 486
      //   2571: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2574: pop
      //   2575: aload_1
      //   2576: ldc_w 492
      //   2579: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2582: pop
      //   2583: aload_1
      //   2584: ldc_w 494
      //   2587: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2590: pop
      //   2591: aload_1
      //   2592: ldc_w 496
      //   2595: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2598: pop
      //   2599: aload_1
      //   2600: ldc_w 498
      //   2603: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2606: pop
      //   2607: aload_1
      //   2608: ldc_w 500
      //   2611: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2614: pop
      //   2615: aload_1
      //   2616: ldc_w 502
      //   2619: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2622: pop
      //   2623: aload_1
      //   2624: ldc_w 504
      //   2627: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2630: pop
      //   2631: aload_1
      //   2632: ldc_w 506
      //   2635: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2638: pop
      //   2639: aload_1
      //   2640: ldc_w 508
      //   2643: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2646: pop
      //   2647: aload_1
      //   2648: ldc_w 510
      //   2651: invokevirtual 490	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2654: pop
      //   2655: aload_1
      //   2656: ldc_w 515
      //   2659: aload_0
      //   2660: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2663: invokestatic 519	c/t/m/g/ds:y	(Lc/t/m/g/ds;)Lc/t/m/g/dt;
      //   2666: invokevirtual 523	c/t/m/g/dt:e	()Ljava/lang/String;
      //   2669: invokevirtual 604	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   2672: pop
      //   2673: aload 12
      //   2675: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2678: ldc_w 512
      //   2681: aload_1
      //   2682: invokevirtual 513	org/json/JSONObject:toString	()Ljava/lang/String;
      //   2685: invokevirtual 445	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2688: aload 12
      //   2690: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2693: ldc_w 515
      //   2696: aload_0
      //   2697: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2700: invokestatic 519	c/t/m/g/ds:y	(Lc/t/m/g/ds;)Lc/t/m/g/dt;
      //   2703: invokevirtual 523	c/t/m/g/dt:e	()Ljava/lang/String;
      //   2706: invokevirtual 445	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2709: aload 12
      //   2711: invokevirtual 440	c/t/m/g/eq:getExtra	()Landroid/os/Bundle;
      //   2714: aload_0
      //   2715: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2718: invokestatic 48	c/t/m/g/ds:c	(Lc/t/m/g/ds;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   2721: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   2724: invokevirtual 527	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
      //   2727: aload_0
      //   2728: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2731: aload 12
      //   2733: invokestatic 571	c/t/m/g/ds:b	(Lc/t/m/g/ds;Lc/t/m/g/eq;)Lc/t/m/g/eq;
      //   2736: pop
      //   2737: aload 11
      //   2739: aload 12
      //   2741: iconst_0
      //   2742: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   2745: iconst_0
      //   2746: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2749: checkcast 95	java/lang/String
      //   2752: invokeinterface 156 4 0
      //   2757: return
      //   2758: astore_1
      //   2759: ldc 103
      //   2761: ldc_w 586
      //   2764: invokestatic 137	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   2767: aload_0
      //   2768: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2771: invokestatic 201	c/t/m/g/ds:l	(Lc/t/m/g/ds;)Z
      //   2774: ifeq +117 -> 2891
      //   2777: aload_0
      //   2778: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2781: iconst_2
      //   2782: getstatic 272	c/t/m/g/eq:a	Lc/t/m/g/eq;
      //   2785: invokestatic 275	c/t/m/g/ds:a	(Lc/t/m/g/ds;ILc/t/m/g/eq;)V
      //   2788: return
      //   2789: iconst_0
      //   2790: istore 9
      //   2792: goto -315 -> 2477
      //   2795: astore_1
      //   2796: aload_1
      //   2797: invokevirtual 607	java/lang/Exception:printStackTrace	()V
      //   2800: goto -112 -> 2688
      //   2803: aload_0
      //   2804: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2807: iconst_0
      //   2808: invokestatic 420	c/t/m/g/ds:a	(Lc/t/m/g/ds;Z)Z
      //   2811: pop
      //   2812: aload_0
      //   2813: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2816: invokestatic 186	c/t/m/g/ds:j	(Lc/t/m/g/ds;)Z
      //   2819: ifne +72 -> 2891
      //   2822: aload_0
      //   2823: getfield 16	c/t/m/g/ds$a:c	Lc/t/m/g/ds;
      //   2826: iconst_1
      //   2827: getstatic 272	c/t/m/g/eq:a	Lc/t/m/g/eq;
      //   2830: invokestatic 275	c/t/m/g/ds:a	(Lc/t/m/g/ds;ILc/t/m/g/eq;)V
      //   2833: return
      //   2834: aload_0
      //   2835: aload_0
      //   2836: getfield 21	c/t/m/g/ds$a:a	I
      //   2839: iconst_1
      //   2840: iadd
      //   2841: putfield 21	c/t/m/g/ds$a:a	I
      //   2844: aload_0
      //   2845: getfield 21	c/t/m/g/ds$a:a	I
      //   2848: iconst_3
      //   2849: if_icmpne +42 -> 2891
      //   2852: aload 11
      //   2854: getstatic 272	c/t/m/g/eq:a	Lc/t/m/g/eq;
      //   2857: iconst_5
      //   2858: invokestatic 144	c/t/m/g/ds:e	()Landroid/util/SparseArray;
      //   2861: iconst_5
      //   2862: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2865: checkcast 95	java/lang/String
      //   2868: invokeinterface 156 4 0
      //   2873: aload_0
      //   2874: iconst_0
      //   2875: putfield 21	c/t/m/g/ds$a:a	I
      //   2878: return
      //   2879: astore_1
      //   2880: goto -153 -> 2727
      //   2883: astore_1
      //   2884: goto -641 -> 2243
      //   2887: astore_1
      //   2888: goto -858 -> 2030
      //   2891: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2892	0	this	a
      //   0	2892	1	paramMessage	Message
      //   872	1655	2	i	int
      //   800	545	3	j	int
      //   52	2371	4	k	int
      //   59	1524	5	l1	long
      //   974	27	7	l2	long
      //   442	2349	9	bool1	boolean
      //   71	959	10	bool2	boolean
      //   33	2820	11	localObject1	Object
      //   7	2733	12	localObject2	Object
      //   45	2465	13	localObject3	Object
      //   825	1737	14	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   12	25	186	finally
      //   26	38	186	finally
      //   187	190	186	finally
      //   1323	1380	1393	java/io/UnsupportedEncodingException
      //   1497	1535	1606	java/io/UnsupportedEncodingException
      //   1538	1575	1606	java/io/UnsupportedEncodingException
      //   1580	1587	1606	java/io/UnsupportedEncodingException
      //   1739	1787	2286	org/json/JSONException
      //   1878	1991	2317	java/lang/Exception
      //   2178	2184	2336	java/lang/Exception
      //   2188	2243	2336	java/lang/Exception
      //   2405	2451	2758	org/json/JSONException
      //   2557	2688	2795	java/lang/Exception
      //   2688	2727	2879	java/lang/Exception
      //   2178	2184	2883	java/lang/Error
      //   2188	2243	2883	java/lang/Error
      //   1991	2030	2887	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ds
 * JD-Core Version:    0.7.0.1
 */