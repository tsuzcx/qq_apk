package c.t.m.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentPedestrianData;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      this.r = bool;
      if (this.r)
      {
        this.p = null;
        this.t = h();
        if (!this.F.b()) {}
        for (paramea = null;; paramea = new en(this.F))
        {
          this.q = paramea;
          this.s = g();
          this.N = false;
          this.F.a(this);
          try
          {
            cz.a(this.F.a, "txsdk", this.F.b.d());
            return;
          }
          catch (Throwable paramea)
          {
            return;
          }
        }
      }
      else
      {
        this.q = null;
        this.t = h();
        if (!this.F.b()) {}
        for (paramea = localObject;; paramea = new ef(this.F))
        {
          this.p = paramea;
          this.s = g();
          this.N = false;
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
    if (this.o != null) {
      this.o.sendEmptyMessage(paramInt);
    }
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
    synchronized (this.I)
    {
      for (;;)
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
          }
          break;
        }
      }
      ??? = "cell";
      if (paramInt2 == 1) {
        localObject1 = "cell enabled";
      }
      for (;;)
      {
        localObject3 = ???;
        paramInt1 = paramInt2;
        if (!fj.a) {
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
          if (!fq.a) {
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
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.o != null)
    {
      this.o.removeMessages(paramInt);
      this.o.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, fi paramfi)
  {
    int i3 = 1;
    if (paramfi == null) {
      return;
    }
    if ((paramInt == 0) && (paramfi.getLatitude() != 0.0D) && (paramfi.getLongitude() != 0.0D)) {
      if ((this.a != 1) || (!fk.a(paramfi.getLatitude(), paramfi.getLongitude()))) {
        break label767;
      }
    }
    label246:
    label761:
    label767:
    for (int i1 = 1;; i1 = 0)
    {
      fi.a(paramfi, i1);
      if (m()) {
        if ((this.m == 0) || (paramInt != 0)) {
          break label761;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
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
        int i2;
        if (this.d != null)
        {
          i2 = 1;
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
          if ((this.m == 0) || (paramInt != 0)) {
            break label755;
          }
        }
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
          new StringBuilder("updateLast").append(paramfi.getLatitude()).append(",").append(paramfi.getLongitude());
          if (this.J.getInterval() == 0L)
          {
            if (this.d == null) {
              break label745;
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
              break label753;
            }
            a(11998);
            return;
            i2 = 0;
            break;
            if ((paramInt != 0) || (paramfi.getLatitude() == 0.0D) || (paramfi.getLongitude() == 0.0D) || (Math.abs(paramfi.getLatitude() - this.K) < 1.0E-007D) || (Math.abs(paramfi.getLongitude() - this.L) < 1.0E-007D)) {
              break label246;
            }
            if (!this.A.a(paramfi, this.F))
            {
              new StringBuilder("discard ").append(paramfi);
              return;
            }
            this.K = paramfi.getLatitude();
            this.L = paramfi.getLongitude();
            if ((paramfi.getAccuracy() >= 500.0F) || (paramfi.getAccuracy() <= 0.0F)) {
              break label246;
            }
            this.A.a(paramfi);
            this.A.a(paramfi);
            if (!this.e) {
              break label246;
            }
            if (this.j != null)
            {
              double d1 = fp.a(this.j.getLatitude(), this.j.getLongitude(), paramfi.getLatitude(), paramfi.getLongitude());
              if (((!paramfi.getProvider().equalsIgnoreCase("network")) || (d1 <= 10.0D)) && ((!paramfi.getProvider().equalsIgnoreCase("gps")) || (d1 <= 3.0D))) {
                break label246;
              }
              this.f = (d1 + this.f);
              if (paramfi.getProvider().equalsIgnoreCase("network")) {
                this.h += 1;
              }
              for (;;)
              {
                this.i += 1;
                this.j = paramfi;
                break;
                this.g += 1;
              }
            }
            this.j = paramfi;
            break label246;
            paramInt = 0;
            break label400;
          }
          break;
        }
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
    catch (Throwable localThrowable) {}
    return new dt("unknown", "unknown", "unknown");
  }
  
  private void j()
  {
    if ((this.z != 0) || (!da.a().d("start_daemon"))) {}
    for (;;)
    {
      return;
      this.P = da.a().c("up_daemon_delay");
      if (this.P < 120000L) {
        this.P = 120000L;
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
          return;
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private void k()
  {
    int i2 = 1;
    fj.a = false;
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
      if ((this.J.isAllowDirection()) && (!this.b.a)) {
        this.b.a();
      }
      if (!this.J.getExtras().getBoolean("daemon")) {
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
        cz.a().c();
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
    if (this.s != null)
    {
      int i1;
      if (this.s.b())
      {
        ej localej = this.s;
        if ((localej.c & 0x2) != 2) {
          break label65;
        }
        if (System.currentTimeMillis() - localej.a < ei.a().b()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          return true;
          i1 = 0;
        }
        else
        {
          return false;
          label65:
          i1 = 0;
        }
      }
    }
    return false;
  }
  
  /* Error */
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, android.os.Looper arg3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 149	c/t/m/g/ek:z	I
    //   4: iconst_1
    //   5: if_icmpne +32 -> 37
    //   8: aload_0
    //   9: invokevirtual 715	c/t/m/g/ek:d	()V
    //   12: aload_0
    //   13: getfield 570	c/t/m/g/ek:y	Landroid/os/HandlerThread;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: getfield 570	c/t/m/g/ek:y	Landroid/os/HandlerThread;
    //   23: invokevirtual 718	android/os/HandlerThread:quit	()Z
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 570	c/t/m/g/ek:y	Landroid/os/HandlerThread;
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 149	c/t/m/g/ek:z	I
    //   37: invokestatic 723	com/tencent/map/geolocation/TencentLocationManagerOptions:isLoadLibraryEnabled	()Z
    //   40: ifeq +15 -> 55
    //   43: ldc_w 725
    //   46: invokestatic 728	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   49: ldc_w 730
    //   52: invokestatic 728	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 179	c/t/m/g/ek:F	Lc/t/m/g/ea;
    //   59: astore 10
    //   61: aload 10
    //   63: getfield 248	c/t/m/g/ea:b	Lc/t/m/g/du;
    //   66: astore 9
    //   68: ldc_w 732
    //   71: aload 9
    //   73: invokevirtual 734	c/t/m/g/du:a	()Ljava/lang/String;
    //   76: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +22 -> 101
    //   82: ldc_w 732
    //   85: aload 9
    //   87: invokevirtual 736	c/t/m/g/du:b	()Ljava/lang/String;
    //   90: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +8 -> 101
    //   96: aload 10
    //   98: invokevirtual 737	c/t/m/g/ea:a	()V
    //   101: aload 9
    //   103: getfield 739	c/t/m/g/du:g	Ljava/lang/String;
    //   106: invokestatic 741	c/t/m/g/co:e	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 10
    //   111: aload_0
    //   112: aload 10
    //   114: invokestatic 743	c/t/m/g/ek:a	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 703	c/t/m/g/ek:S	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 703	c/t/m/g/ek:S	Ljava/lang/String;
    //   124: invokestatic 748	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +30 -> 157
    //   130: new 437	java/lang/StringBuilder
    //   133: dup
    //   134: ldc_w 750
    //   137: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload 10
    //   142: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 752
    //   148: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: iconst_2
    //   153: ireturn
    //   154: astore_1
    //   155: iconst_3
    //   156: ireturn
    //   157: aload_0
    //   158: invokespecial 754	c/t/m/g/ek:l	()V
    //   161: aload_0
    //   162: getfield 167	c/t/m/g/ek:I	Ljava/lang/Object;
    //   165: astore 10
    //   167: aload 10
    //   169: monitorenter
    //   170: aload_0
    //   171: aload_2
    //   172: putfield 316	c/t/m/g/ek:d	Lcom/tencent/map/geolocation/TencentLocationListener;
    //   175: aload 10
    //   177: monitorexit
    //   178: aload_0
    //   179: getfield 175	c/t/m/g/ek:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   182: aload_1
    //   183: invokestatic 758	com/tencent/map/geolocation/TencentLocationRequest:copy	(Lcom/tencent/map/geolocation/TencentLocationRequest;Lcom/tencent/map/geolocation/TencentLocationRequest;)V
    //   186: aload 9
    //   188: aload_1
    //   189: invokevirtual 761	com/tencent/map/geolocation/TencentLocationRequest:getQQ	()Ljava/lang/String;
    //   192: putfield 763	c/t/m/g/du:f	Ljava/lang/String;
    //   195: aload 9
    //   197: getfield 765	c/t/m/g/du:d	Ljava/lang/String;
    //   200: invokestatic 741	c/t/m/g/co:e	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 748	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifeq +12 -> 218
    //   209: aload 9
    //   211: aload_1
    //   212: invokevirtual 768	com/tencent/map/geolocation/TencentLocationRequest:getPhoneNumber	()Ljava/lang/String;
    //   215: putfield 765	c/t/m/g/du:d	Ljava/lang/String;
    //   218: aload_1
    //   219: invokevirtual 407	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   222: lconst_0
    //   223: lcmp
    //   224: ifne +1276 -> 1500
    //   227: ldc2_w 769
    //   230: lstore 5
    //   232: aload 9
    //   234: invokestatic 532	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   237: ldc 124
    //   239: invokevirtual 537	c/t/m/g/da:c	(Ljava/lang/String;)J
    //   242: lload 5
    //   244: invokestatic 774	java/lang/Math:max	(JJ)J
    //   247: putfield 776	c/t/m/g/du:k	J
    //   250: invokestatic 781	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   253: ifnonnull +6 -> 259
    //   256: invokestatic 784	android/os/Looper:prepare	()V
    //   259: aload_0
    //   260: getfield 307	c/t/m/g/ek:o	Lc/t/m/g/ek$a;
    //   263: ifnonnull +1246 -> 1509
    //   266: iconst_1
    //   267: istore 4
    //   269: iload 4
    //   271: ifeq +1244 -> 1515
    //   274: aload_0
    //   275: new 309	c/t/m/g/ek$a
    //   278: dup
    //   279: aload_0
    //   280: aload_3
    //   281: invokespecial 787	c/t/m/g/ek$a:<init>	(Lc/t/m/g/ek;Landroid/os/Looper;)V
    //   284: putfield 307	c/t/m/g/ek:o	Lc/t/m/g/ek$a;
    //   287: aload_0
    //   288: invokespecial 789	c/t/m/g/ek:k	()V
    //   291: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   294: lstore 5
    //   296: new 437	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 791
    //   303: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   309: lload 5
    //   311: lsub
    //   312: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: getfield 175	c/t/m/g/ek:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   320: invokevirtual 411	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   323: ldc_w 796
    //   326: iconst_1
    //   327: invokevirtual 799	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   330: istore 7
    //   332: aload_0
    //   333: getfield 175	c/t/m/g/ek:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   336: invokevirtual 411	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   339: ldc_w 413
    //   342: invokevirtual 419	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   345: istore 8
    //   347: aload_0
    //   348: getfield 307	c/t/m/g/ek:o	Lc/t/m/g/ek$a;
    //   351: astore_1
    //   352: aload_0
    //   353: getfield 185	c/t/m/g/ek:u	Lc/t/m/g/em;
    //   356: astore_2
    //   357: aload_2
    //   358: getfield 801	c/t/m/g/em:b	Z
    //   361: ifne +34 -> 395
    //   364: aload_2
    //   365: iconst_1
    //   366: putfield 801	c/t/m/g/em:b	Z
    //   369: new 803	android/content/IntentFilter
    //   372: dup
    //   373: ldc_w 805
    //   376: invokespecial 806	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   379: astore_3
    //   380: aload_2
    //   381: getfield 808	c/t/m/g/em:a	Lc/t/m/g/ea;
    //   384: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   387: aload_2
    //   388: aload_3
    //   389: aconst_null
    //   390: aload_1
    //   391: invokevirtual 814	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   394: pop
    //   395: aload_0
    //   396: getfield 190	c/t/m/g/ek:v	Lc/t/m/g/ep;
    //   399: astore_2
    //   400: aload_2
    //   401: getfield 816	c/t/m/g/ep:g	Z
    //   404: ifne +36 -> 440
    //   407: aload_2
    //   408: iconst_1
    //   409: putfield 816	c/t/m/g/ep:g	Z
    //   412: aload_2
    //   413: getfield 818	c/t/m/g/ep:b	Lc/t/m/g/ea;
    //   416: getfield 821	c/t/m/g/ea:d	Ljava/util/concurrent/ExecutorService;
    //   419: new 823	c/t/m/g/ep$1
    //   422: dup
    //   423: aload_2
    //   424: aload_1
    //   425: invokespecial 826	c/t/m/g/ep$1:<init>	(Lc/t/m/g/ep;Landroid/os/Handler;)V
    //   428: invokeinterface 832 2 0
    //   433: aload_2
    //   434: invokestatic 837	android/os/SystemClock:elapsedRealtime	()J
    //   437: putfield 839	c/t/m/g/ep:f	J
    //   440: new 437	java/lang/StringBuilder
    //   443: dup
    //   444: ldc_w 841
    //   447: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   450: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   453: lload 5
    //   455: lsub
    //   456: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: iload 8
    //   462: ifeq +18 -> 480
    //   465: aload_0
    //   466: getfield 190	c/t/m/g/ek:v	Lc/t/m/g/ep;
    //   469: aload_0
    //   470: getfield 179	c/t/m/g/ek:F	Lc/t/m/g/ea;
    //   473: iconst_1
    //   474: invokevirtual 844	c/t/m/g/ea:a	(Z)Ljava/lang/String;
    //   477: invokevirtual 846	c/t/m/g/ep:a	(Ljava/lang/String;)V
    //   480: new 437	java/lang/StringBuilder
    //   483: dup
    //   484: ldc_w 848
    //   487: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   490: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   493: lload 5
    //   495: lsub
    //   496: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_0
    //   501: getfield 221	c/t/m/g/ek:r	Z
    //   504: ifeq +1076 -> 1580
    //   507: iload 7
    //   509: ifeq +129 -> 638
    //   512: aload_0
    //   513: getfield 233	c/t/m/g/ek:q	Lc/t/m/g/en;
    //   516: ifnull +1034 -> 1550
    //   519: iconst_1
    //   520: istore 4
    //   522: iload 4
    //   524: ifeq +114 -> 638
    //   527: aload_0
    //   528: getfield 233	c/t/m/g/ek:q	Lc/t/m/g/en;
    //   531: astore_2
    //   532: aload_2
    //   533: getfield 849	c/t/m/g/en:a	Z
    //   536: ifne +102 -> 638
    //   539: aload_2
    //   540: aload_1
    //   541: putfield 852	c/t/m/g/en:i	Landroid/os/Handler;
    //   544: aload_2
    //   545: new 565	android/os/HandlerThread
    //   548: dup
    //   549: ldc_w 854
    //   552: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   555: putfield 856	c/t/m/g/en:f	Landroid/os/HandlerThread;
    //   558: aload_2
    //   559: getfield 856	c/t/m/g/en:f	Landroid/os/HandlerThread;
    //   562: ifnull +76 -> 638
    //   565: aload_2
    //   566: getfield 852	c/t/m/g/en:i	Landroid/os/Handler;
    //   569: ifnull +69 -> 638
    //   572: aload_2
    //   573: getfield 856	c/t/m/g/en:f	Landroid/os/HandlerThread;
    //   576: invokevirtual 573	android/os/HandlerThread:start	()V
    //   579: aload_2
    //   580: new 858	c/t/m/g/en$a
    //   583: dup
    //   584: aload_2
    //   585: aload_2
    //   586: getfield 856	c/t/m/g/en:f	Landroid/os/HandlerThread;
    //   589: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   592: iconst_0
    //   593: invokespecial 861	c/t/m/g/en$a:<init>	(Lc/t/m/g/en;Landroid/os/Looper;B)V
    //   596: putfield 864	c/t/m/g/en:g	Lc/t/m/g/en$a;
    //   599: aload_2
    //   600: iconst_1
    //   601: putfield 849	c/t/m/g/en:a	Z
    //   604: iload 8
    //   606: ifne +13 -> 619
    //   609: aload_2
    //   610: getfield 864	c/t/m/g/en:g	Lc/t/m/g/en$a;
    //   613: iconst_0
    //   614: lconst_0
    //   615: invokestatic 867	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   618: pop
    //   619: aload_2
    //   620: getfield 864	c/t/m/g/en:g	Lc/t/m/g/en$a;
    //   623: new 869	c/t/m/g/en$1
    //   626: dup
    //   627: aload_2
    //   628: invokespecial 872	c/t/m/g/en$1:<init>	(Lc/t/m/g/en;)V
    //   631: ldc2_w 873
    //   634: invokevirtual 878	c/t/m/g/en$a:postDelayed	(Ljava/lang/Runnable;J)Z
    //   637: pop
    //   638: new 437	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 880
    //   645: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   651: lload 5
    //   653: lsub
    //   654: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: iload 7
    //   660: ifeq +99 -> 759
    //   663: aload_0
    //   664: getfield 228	c/t/m/g/ek:t	Lc/t/m/g/er;
    //   667: ifnull +1065 -> 1732
    //   670: iconst_1
    //   671: istore 4
    //   673: iload 4
    //   675: ifeq +84 -> 759
    //   678: aload_0
    //   679: getfield 228	c/t/m/g/ek:t	Lc/t/m/g/er;
    //   682: astore_2
    //   683: aload_2
    //   684: getfield 881	c/t/m/g/er:a	Z
    //   687: ifne +72 -> 759
    //   690: aload_2
    //   691: iconst_1
    //   692: putfield 881	c/t/m/g/er:a	Z
    //   695: aload_2
    //   696: iconst_0
    //   697: putfield 883	c/t/m/g/er:d	Z
    //   700: aload_2
    //   701: iload 8
    //   703: putfield 885	c/t/m/g/er:c	Z
    //   706: aload_1
    //   707: putstatic 887	c/t/m/g/er:e	Landroid/os/Handler;
    //   710: new 803	android/content/IntentFilter
    //   713: dup
    //   714: invokespecial 888	android/content/IntentFilter:<init>	()V
    //   717: astore_3
    //   718: aload_3
    //   719: ldc_w 890
    //   722: invokevirtual 893	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   725: aload_3
    //   726: ldc_w 895
    //   729: invokevirtual 893	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   732: aload_2
    //   733: getfield 896	c/t/m/g/er:b	Lc/t/m/g/ea;
    //   736: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   739: aload_2
    //   740: aload_3
    //   741: aconst_null
    //   742: aload_1
    //   743: invokevirtual 814	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   746: pop
    //   747: aload_2
    //   748: getfield 885	c/t/m/g/er:c	Z
    //   751: ifne +8 -> 759
    //   754: aload_2
    //   755: lconst_0
    //   756: invokevirtual 899	c/t/m/g/er:a	(J)V
    //   759: new 437	java/lang/StringBuilder
    //   762: dup
    //   763: ldc_w 901
    //   766: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   769: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   772: lload 5
    //   774: lsub
    //   775: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: iload 8
    //   781: ifne +8 -> 789
    //   784: aload_0
    //   785: iconst_1
    //   786: putfield 706	c/t/m/g/ek:O	Z
    //   789: aload_0
    //   790: getfield 238	c/t/m/g/ek:s	Lc/t/m/g/ej;
    //   793: ifnull +945 -> 1738
    //   796: iconst_1
    //   797: istore 4
    //   799: iload 4
    //   801: ifeq +175 -> 976
    //   804: aload_0
    //   805: getfield 175	c/t/m/g/ek:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   808: invokevirtual 904	com/tencent/map/geolocation/TencentLocationRequest:isAllowGPS	()Z
    //   811: ifeq +165 -> 976
    //   814: aload_0
    //   815: getfield 238	c/t/m/g/ek:s	Lc/t/m/g/ej;
    //   818: astore_2
    //   819: aload_0
    //   820: getfield 145	c/t/m/g/ek:a	I
    //   823: iconst_1
    //   824: if_icmpne +920 -> 1744
    //   827: iconst_1
    //   828: istore 7
    //   830: aload_2
    //   831: iload 7
    //   833: putfield 906	c/t/m/g/ej:f	Z
    //   836: aload_0
    //   837: getfield 238	c/t/m/g/ek:s	Lc/t/m/g/ej;
    //   840: astore_2
    //   841: aload_0
    //   842: getfield 175	c/t/m/g/ek:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   845: invokevirtual 407	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   848: pop2
    //   849: aload_2
    //   850: getfield 907	c/t/m/g/ej:d	Z
    //   853: ifne +123 -> 976
    //   856: aload_2
    //   857: iconst_1
    //   858: putfield 907	c/t/m/g/ej:d	Z
    //   861: aload_2
    //   862: new 565	android/os/HandlerThread
    //   865: dup
    //   866: ldc_w 909
    //   869: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   872: putfield 911	c/t/m/g/ej:g	Landroid/os/HandlerThread;
    //   875: aload_2
    //   876: getfield 912	c/t/m/g/ej:b	Lc/t/m/g/ea;
    //   879: getfield 915	c/t/m/g/ea:h	Landroid/location/LocationManager;
    //   882: astore_3
    //   883: aload_2
    //   884: getfield 911	c/t/m/g/ej:g	Landroid/os/HandlerThread;
    //   887: invokevirtual 573	android/os/HandlerThread:start	()V
    //   890: aload_2
    //   891: new 917	android/os/Handler
    //   894: dup
    //   895: aload_2
    //   896: getfield 911	c/t/m/g/ej:g	Landroid/os/HandlerThread;
    //   899: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   902: invokespecial 920	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   905: putfield 921	c/t/m/g/ej:i	Landroid/os/Handler;
    //   908: iload 8
    //   910: ifne +840 -> 1750
    //   913: aload_2
    //   914: getfield 912	c/t/m/g/ej:b	Lc/t/m/g/ea;
    //   917: getfield 915	c/t/m/g/ea:h	Landroid/location/LocationManager;
    //   920: ldc_w 324
    //   923: ldc2_w 873
    //   926: fconst_0
    //   927: aload_2
    //   928: getfield 923	c/t/m/g/ej:j	Lc/t/m/g/ej;
    //   931: aload_2
    //   932: getfield 911	c/t/m/g/ej:g	Landroid/os/HandlerThread;
    //   935: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   938: invokevirtual 929	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   941: aload_2
    //   942: getfield 921	c/t/m/g/ej:i	Landroid/os/Handler;
    //   945: aload_2
    //   946: getfield 932	c/t/m/g/ej:h	Ljava/lang/Runnable;
    //   949: invokevirtual 936	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   952: pop
    //   953: aload_2
    //   954: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   957: putfield 938	c/t/m/g/ej:e	J
    //   960: aload_2
    //   961: invokevirtual 629	c/t/m/g/ej:b	()Z
    //   964: ifeq +12 -> 976
    //   967: aload_2
    //   968: iconst_4
    //   969: putfield 631	c/t/m/g/ej:c	I
    //   972: aload_2
    //   973: invokevirtual 939	c/t/m/g/ej:c	()V
    //   976: new 437	java/lang/StringBuilder
    //   979: dup
    //   980: ldc_w 941
    //   983: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   986: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   989: lload 5
    //   991: lsub
    //   992: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload_0
    //   997: getfield 175	c/t/m/g/ek:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1000: invokevirtual 598	com/tencent/map/geolocation/TencentLocationRequest:isAllowDirection	()Z
    //   1003: ifeq +23 -> 1026
    //   1006: aload_0
    //   1007: getfield 207	c/t/m/g/ek:b	Lc/t/m/g/eh;
    //   1010: getfield 599	c/t/m/g/eh:a	Z
    //   1013: ifne +13 -> 1026
    //   1016: aload_0
    //   1017: getfield 207	c/t/m/g/ek:b	Lc/t/m/g/eh;
    //   1020: aload_1
    //   1021: aconst_null
    //   1022: invokevirtual 944	c/t/m/g/eh:a	(Landroid/os/Handler;Lcom/tencent/map/geolocation/TencentDirectionListener;)I
    //   1025: pop
    //   1026: iload 8
    //   1028: ifne +139 -> 1167
    //   1031: aload_0
    //   1032: getfield 175	c/t/m/g/ek:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1035: invokevirtual 947	com/tencent/map/geolocation/TencentLocationRequest:isAllowPedometer	()Z
    //   1038: ifeq +129 -> 1167
    //   1041: aload_0
    //   1042: getfield 214	c/t/m/g/ek:c	Lc/t/m/g/el;
    //   1045: astore_2
    //   1046: aload_0
    //   1047: getfield 179	c/t/m/g/ek:F	Lc/t/m/g/ea;
    //   1050: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   1053: putstatic 949	c/t/m/g/el:f	Landroid/content/Context;
    //   1056: ldc_w 951
    //   1059: invokestatic 956	c/t/m/g/dy:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   1062: putstatic 959	c/t/m/g/el:i	Landroid/content/SharedPreferences;
    //   1065: aload_2
    //   1066: new 565	android/os/HandlerThread
    //   1069: dup
    //   1070: ldc_w 961
    //   1073: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1076: putfield 962	c/t/m/g/el:g	Landroid/os/HandlerThread;
    //   1079: aload_2
    //   1080: getfield 962	c/t/m/g/el:g	Landroid/os/HandlerThread;
    //   1083: invokevirtual 573	android/os/HandlerThread:start	()V
    //   1086: aload_2
    //   1087: getfield 965	c/t/m/g/el:a	Lc/t/m/g/dv;
    //   1090: aload_2
    //   1091: putfield 970	c/t/m/g/dv:i	Lc/t/m/g/ee;
    //   1094: aload_2
    //   1095: getstatic 949	c/t/m/g/el:f	Landroid/content/Context;
    //   1098: ldc_w 972
    //   1101: invokevirtual 976	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1104: checkcast 978	android/hardware/SensorManager
    //   1107: putfield 981	c/t/m/g/el:b	Landroid/hardware/SensorManager;
    //   1110: aload_2
    //   1111: getfield 981	c/t/m/g/el:b	Landroid/hardware/SensorManager;
    //   1114: ifnull +49 -> 1163
    //   1117: aload_2
    //   1118: aload_2
    //   1119: getfield 981	c/t/m/g/el:b	Landroid/hardware/SensorManager;
    //   1122: iconst_1
    //   1123: invokevirtual 985	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1126: putfield 988	c/t/m/g/el:c	Landroid/hardware/Sensor;
    //   1129: aload_2
    //   1130: aload_2
    //   1131: getfield 981	c/t/m/g/el:b	Landroid/hardware/SensorManager;
    //   1134: bipush 10
    //   1136: invokevirtual 985	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1139: putfield 990	c/t/m/g/el:d	Landroid/hardware/Sensor;
    //   1142: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   1145: bipush 19
    //   1147: if_icmplt +16 -> 1163
    //   1150: aload_2
    //   1151: aload_2
    //   1152: getfield 981	c/t/m/g/el:b	Landroid/hardware/SensorManager;
    //   1155: bipush 19
    //   1157: invokevirtual 985	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1160: putfield 992	c/t/m/g/el:e	Landroid/hardware/Sensor;
    //   1163: aload_2
    //   1164: invokevirtual 993	c/t/m/g/el:d	()V
    //   1167: invokestatic 532	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   1170: ldc 128
    //   1172: invokevirtual 995	c/t/m/g/da:b	(Ljava/lang/String;)I
    //   1175: istore 4
    //   1177: iload 4
    //   1179: iconst_1
    //   1180: if_icmpeq +9 -> 1189
    //   1183: iload 4
    //   1185: iconst_2
    //   1186: if_icmpne +28 -> 1214
    //   1189: aload_0
    //   1190: getfield 608	c/t/m/g/ek:w	Lc/t/m/g/co;
    //   1193: ifnonnull +21 -> 1214
    //   1196: aload_0
    //   1197: new 610	c/t/m/g/co
    //   1200: dup
    //   1201: aload_0
    //   1202: getfield 179	c/t/m/g/ek:F	Lc/t/m/g/ea;
    //   1205: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   1208: invokespecial 998	c/t/m/g/co:<init>	(Landroid/content/Context;)V
    //   1211: putfield 608	c/t/m/g/ek:w	Lc/t/m/g/co;
    //   1214: aload_0
    //   1215: getfield 608	c/t/m/g/ek:w	Lc/t/m/g/co;
    //   1218: ifnull +260 -> 1478
    //   1221: aload_1
    //   1222: ifnull +256 -> 1478
    //   1225: new 437	java/lang/StringBuilder
    //   1228: dup
    //   1229: ldc_w 1000
    //   1232: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1235: iload 4
    //   1237: invokevirtual 696	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: ldc_w 1002
    //   1243: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: iload 8
    //   1248: invokevirtual 1005	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1251: ldc_w 1007
    //   1254: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: iload 4
    //   1260: iconst_2
    //   1261: if_icmpeq +14 -> 1275
    //   1264: iload 4
    //   1266: iconst_1
    //   1267: if_icmpne +211 -> 1478
    //   1270: iload 8
    //   1272: ifne +206 -> 1478
    //   1275: aload_0
    //   1276: getfield 608	c/t/m/g/ek:w	Lc/t/m/g/co;
    //   1279: astore_3
    //   1280: aload_0
    //   1281: invokespecial 1009	c/t/m/g/ek:i	()Lc/t/m/g/dt;
    //   1284: astore_2
    //   1285: aload_3
    //   1286: getfield 1012	c/t/m/g/co:a	[B
    //   1289: astore_3
    //   1290: aload_3
    //   1291: monitorenter
    //   1292: aload_2
    //   1293: putstatic 1017	c/t/m/g/cu:i	Lc/t/m/g/dt;
    //   1296: invokestatic 1019	c/t/m/g/co:e	()Z
    //   1299: ifeq +75 -> 1374
    //   1302: new 437	java/lang/StringBuilder
    //   1305: dup
    //   1306: ldc_w 1021
    //   1309: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1312: aload_2
    //   1313: getfield 1023	c/t/m/g/dt:b	Ljava/lang/String;
    //   1316: invokestatic 1024	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1319: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: ldc_w 1026
    //   1325: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload_2
    //   1329: getfield 1028	c/t/m/g/dt:a	Ljava/lang/String;
    //   1332: invokestatic 1024	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1335: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: ldc_w 278
    //   1341: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: getstatic 1033	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1347: invokestatic 1024	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1350: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: ldc_w 278
    //   1356: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: getstatic 1036	android/os/Build:MODEL	Ljava/lang/String;
    //   1362: invokestatic 1024	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1365: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 1038	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokestatic 1039	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   1374: aload_3
    //   1375: monitorexit
    //   1376: aload_0
    //   1377: getfield 608	c/t/m/g/ek:w	Lc/t/m/g/co;
    //   1380: ldc_w 1041
    //   1383: invokestatic 532	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   1386: ldc 132
    //   1388: invokevirtual 1042	c/t/m/g/da:e	(Ljava/lang/String;)Ljava/lang/String;
    //   1391: invokevirtual 1045	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1394: aload_0
    //   1395: getfield 608	c/t/m/g/ek:w	Lc/t/m/g/co;
    //   1398: ldc_w 1047
    //   1401: ldc 116
    //   1403: invokevirtual 1045	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1406: aload_0
    //   1407: getfield 608	c/t/m/g/ek:w	Lc/t/m/g/co;
    //   1410: astore_3
    //   1411: aload_1
    //   1412: invokevirtual 1048	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1415: astore_2
    //   1416: aload_3
    //   1417: getfield 1012	c/t/m/g/co:a	[B
    //   1420: astore 9
    //   1422: aload 9
    //   1424: monitorenter
    //   1425: ldc_w 1050
    //   1428: invokestatic 1039	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   1431: aload_3
    //   1432: invokevirtual 1051	c/t/m/g/co:d	()V
    //   1435: aload_3
    //   1436: getfield 1054	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   1439: ifnull +36 -> 1475
    //   1442: aload_2
    //   1443: astore_1
    //   1444: aload_2
    //   1445: ifnonnull +21 -> 1466
    //   1448: aload_3
    //   1449: ldc_w 1056
    //   1452: invokestatic 1061	c/t/m/g/ds:a	(Ljava/lang/String;)Landroid/os/HandlerThread;
    //   1455: putfield 1063	c/t/m/g/co:c	Landroid/os/HandlerThread;
    //   1458: aload_3
    //   1459: getfield 1063	c/t/m/g/co:c	Landroid/os/HandlerThread;
    //   1462: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1465: astore_1
    //   1466: aload_3
    //   1467: getfield 1054	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   1470: aload_1
    //   1471: invokevirtual 1068	c/t/m/g/cq:b	(Landroid/os/Looper;)I
    //   1474: pop
    //   1475: aload 9
    //   1477: monitorexit
    //   1478: aload_0
    //   1479: ldc_w 1069
    //   1482: putfield 153	c/t/m/g/ek:G	Ljava/lang/String;
    //   1485: aload_0
    //   1486: getfield 703	c/t/m/g/ek:S	Ljava/lang/String;
    //   1489: invokestatic 1070	c/t/m/g/cz:a	(Ljava/lang/String;)V
    //   1492: iconst_0
    //   1493: ireturn
    //   1494: astore_1
    //   1495: aload 10
    //   1497: monitorexit
    //   1498: aload_1
    //   1499: athrow
    //   1500: aload_1
    //   1501: invokevirtual 407	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   1504: lstore 5
    //   1506: goto -1274 -> 232
    //   1509: iconst_0
    //   1510: istore 4
    //   1512: goto -1243 -> 269
    //   1515: aload_0
    //   1516: getfield 307	c/t/m/g/ek:o	Lc/t/m/g/ek$a;
    //   1519: aconst_null
    //   1520: invokevirtual 1073	c/t/m/g/ek$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1523: aload_0
    //   1524: getfield 307	c/t/m/g/ek:o	Lc/t/m/g/ek$a;
    //   1527: invokevirtual 1074	c/t/m/g/ek$a:getLooper	()Landroid/os/Looper;
    //   1530: aload_3
    //   1531: if_acmpeq -1244 -> 287
    //   1534: aload_0
    //   1535: new 309	c/t/m/g/ek$a
    //   1538: dup
    //   1539: aload_0
    //   1540: aload_3
    //   1541: invokespecial 787	c/t/m/g/ek$a:<init>	(Lc/t/m/g/ek;Landroid/os/Looper;)V
    //   1544: putfield 307	c/t/m/g/ek:o	Lc/t/m/g/ek$a;
    //   1547: goto -1260 -> 287
    //   1550: iconst_0
    //   1551: istore 4
    //   1553: goto -1031 -> 522
    //   1556: astore_3
    //   1557: aload_2
    //   1558: new 858	c/t/m/g/en$a
    //   1561: dup
    //   1562: aload_2
    //   1563: aload_2
    //   1564: getfield 852	c/t/m/g/en:i	Landroid/os/Handler;
    //   1567: invokevirtual 1048	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1570: iconst_0
    //   1571: invokespecial 861	c/t/m/g/en$a:<init>	(Lc/t/m/g/en;Landroid/os/Looper;B)V
    //   1574: putfield 864	c/t/m/g/en:g	Lc/t/m/g/en$a;
    //   1577: goto -978 -> 599
    //   1580: iload 7
    //   1582: ifeq -944 -> 638
    //   1585: aload_0
    //   1586: getfield 223	c/t/m/g/ek:p	Lc/t/m/g/ef;
    //   1589: ifnull +137 -> 1726
    //   1592: iconst_1
    //   1593: istore 4
    //   1595: iload 4
    //   1597: ifeq -959 -> 638
    //   1600: aload_0
    //   1601: getfield 223	c/t/m/g/ek:p	Lc/t/m/g/ef;
    //   1604: astore_2
    //   1605: aload_2
    //   1606: getfield 1075	c/t/m/g/ef:a	Z
    //   1609: ifne -971 -> 638
    //   1612: aload_2
    //   1613: iconst_1
    //   1614: putfield 1075	c/t/m/g/ef:a	Z
    //   1617: aload_2
    //   1618: new 565	android/os/HandlerThread
    //   1621: dup
    //   1622: ldc_w 1077
    //   1625: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1628: putfield 1079	c/t/m/g/ef:d	Landroid/os/HandlerThread;
    //   1631: aload_2
    //   1632: getfield 1079	c/t/m/g/ef:d	Landroid/os/HandlerThread;
    //   1635: invokevirtual 573	android/os/HandlerThread:start	()V
    //   1638: aload_2
    //   1639: new 1081	c/t/m/g/ef$a
    //   1642: dup
    //   1643: aload_2
    //   1644: aload_2
    //   1645: getfield 1079	c/t/m/g/ef:d	Landroid/os/HandlerThread;
    //   1648: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1651: iconst_0
    //   1652: invokespecial 1084	c/t/m/g/ef$a:<init>	(Lc/t/m/g/ef;Landroid/os/Looper;B)V
    //   1655: putfield 1085	c/t/m/g/ef:e	Landroid/os/Handler;
    //   1658: aload_2
    //   1659: getfield 1085	c/t/m/g/ef:e	Landroid/os/Handler;
    //   1662: iconst_0
    //   1663: ldc2_w 1086
    //   1666: invokevirtual 1088	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   1669: pop
    //   1670: aload_2
    //   1671: getfield 1089	c/t/m/g/ef:b	Lc/t/m/g/ea;
    //   1674: invokestatic 654	c/t/m/g/fj:a	(Lc/t/m/g/ea;)Landroid/telephony/CellLocation;
    //   1677: astore_3
    //   1678: aload_2
    //   1679: aload_3
    //   1680: invokevirtual 1092	c/t/m/g/ef:a	(Landroid/telephony/CellLocation;)Z
    //   1683: ifeq +33 -> 1716
    //   1686: aload_2
    //   1687: getfield 1089	c/t/m/g/ef:b	Lc/t/m/g/ea;
    //   1690: aload_3
    //   1691: aconst_null
    //   1692: invokestatic 657	c/t/m/g/et:a	(Lc/t/m/g/ea;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/m/g/et;
    //   1695: astore 9
    //   1697: aload 9
    //   1699: ifnull +17 -> 1716
    //   1702: aload_2
    //   1703: aload_3
    //   1704: putfield 1095	c/t/m/g/ef:c	Landroid/telephony/CellLocation;
    //   1707: aload_2
    //   1708: getfield 1089	c/t/m/g/ef:b	Lc/t/m/g/ea;
    //   1711: aload 9
    //   1713: invokevirtual 1097	c/t/m/g/ea:b	(Ljava/lang/Object;)V
    //   1716: aload_2
    //   1717: sipush 273
    //   1720: invokevirtual 1098	c/t/m/g/ef:a	(I)V
    //   1723: goto -1085 -> 638
    //   1726: iconst_0
    //   1727: istore 4
    //   1729: goto -134 -> 1595
    //   1732: iconst_0
    //   1733: istore 4
    //   1735: goto -1062 -> 673
    //   1738: iconst_0
    //   1739: istore 4
    //   1741: goto -942 -> 799
    //   1744: iconst_0
    //   1745: istore 7
    //   1747: goto -917 -> 830
    //   1750: aload_3
    //   1751: ldc_w 1100
    //   1754: ldc2_w 1101
    //   1757: fconst_0
    //   1758: aload_2
    //   1759: aload_2
    //   1760: getfield 911	c/t/m/g/ej:g	Landroid/os/HandlerThread;
    //   1763: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1766: invokevirtual 929	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   1769: goto -809 -> 960
    //   1772: astore_3
    //   1773: iconst_1
    //   1774: putstatic 346	c/t/m/g/fj:a	Z
    //   1777: goto -817 -> 960
    //   1780: astore_1
    //   1781: aload_3
    //   1782: monitorexit
    //   1783: aload_1
    //   1784: athrow
    //   1785: astore_1
    //   1786: aload 9
    //   1788: monitorexit
    //   1789: aload_1
    //   1790: athrow
    //   1791: astore_3
    //   1792: goto -851 -> 941
    //   1795: astore_3
    //   1796: goto -1049 -> 747
    //   1799: astore_2
    //   1800: goto -1405 -> 395
    //   1803: astore 9
    //   1805: goto -1756 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1808	0	this	ek
    //   0	1808	1	paramTencentLocationRequest	TencentLocationRequest
    //   0	1808	2	paramTencentLocationListener	TencentLocationListener
    //   267	1473	4	i1	int
    //   230	1275	5	l1	long
    //   330	1416	7	bool1	boolean
    //   345	926	8	bool2	boolean
    //   1803	1	9	localError	java.lang.Error
    //   59	1437	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	154	java/lang/Error
    //   170	178	1494	finally
    //   1495	1498	1494	finally
    //   572	599	1556	java/lang/Throwable
    //   913	941	1772	java/lang/Exception
    //   941	960	1772	java/lang/Exception
    //   1750	1769	1772	java/lang/Exception
    //   1292	1374	1780	finally
    //   1374	1376	1780	finally
    //   1781	1783	1780	finally
    //   1425	1442	1785	finally
    //   1448	1466	1785	finally
    //   1466	1475	1785	finally
    //   1475	1478	1785	finally
    //   1786	1789	1785	finally
    //   913	941	1791	java/lang/Throwable
    //   732	747	1795	java/lang/Exception
    //   369	395	1799	java/lang/Exception
    //   43	49	1803	java/lang/Error
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
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        Sensor localSensor = ((SensorManager)this.F.a.getSystemService("sensor")).getDefaultSensor(19);
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
      SharedPreferences localSharedPreferences = this.F.c;
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
    Object localObject1 = this.F.c;
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
        localObject1 = new ek.1(this, f2, l1);
      }
      catch (Throwable localThrowable)
      {
        long l1;
        float f2;
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
      synchronized (this.I)
      {
        this.d = null;
        l();
        this.G = "stop";
        j();
        return;
        i1 = 0;
      }
    }
  }
  
  public final void onCellInfoEvent(et paramet)
  {
    new StringBuilder("cellCallback:").append(System.currentTimeMillis());
    int i4 = paramet.e;
    int i5 = paramet.f;
    Object localObject = this.B;
    int i2;
    if (localObject != null) {
      i2 = ((et)localObject).f;
    }
    for (int i3 = ((et)localObject).e;; i3 = 0)
    {
      this.B = paramet;
      int i1;
      if (this.t != null) {
        if (this.t.b()) {
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 != 0) {
          this.C = null;
        }
        if ((i1 == 0) && ((this.C == null) || (this.C.a(System.currentTimeMillis(), 30000L))))
        {
          if (this.o != null)
          {
            localObject = this.o.obtainMessage(3999, "wifi_not_received");
            this.o.sendMessageDelayed((Message)localObject, 2000L);
          }
          label148:
          if (i1 != 0) {
            break label370;
          }
        }
        ArrayList localArrayList;
        label370:
        for (localObject = "scan wifi";; localObject = "prepare json. wifi is not scannable?")
        {
          String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i1), localObject });
          if (this.w == null) {
            break label389;
          }
          localObject = new cp(paramet.b, paramet.c, paramet.d, paramet.e, paramet.f, paramet.a.ordinal());
          localArrayList = new ArrayList();
          localArrayList.add(localObject);
          paramet = paramet.b().iterator();
          while (paramet.hasNext())
          {
            et localet = (et)paramet.next();
            localArrayList.add(new cp(localet.b, localet.c, localet.d, localet.e, localet.f, localet.a.ordinal()));
          }
          i1 = 1;
          break;
          a(3999);
          break label148;
        }
        this.w.a((cp)localObject, localArrayList);
        label389:
        return;
        i1 = 1;
      }
      i2 = 0;
    }
  }
  
  public final void onGpsInfoEvent(eu arg1)
  {
    int i4;
    int i3;
    Object localObject1;
    Location localLocation;
    Object localObject3;
    double d2;
    double d1;
    int i2;
    int i1;
    if (???.a != eg.a)
    {
      this.D = ???;
      if (!this.J.getExtras().getBoolean("daemon"))
      {
        int i5 = ei.a().a(???);
        i4 = this.a;
        i3 = this.J.getRequestLevel();
        localObject1 = this.M;
        localLocation = new Location(???.a);
        localObject3 = localLocation.getExtras();
        d2 = 0.0D;
        d1 = 0.0D;
        i2 = 0;
        i1 = 0;
        if (localObject3 != null)
        {
          d2 = ((Bundle)localObject3).getDouble("lat");
          d1 = ((Bundle)localObject3).getDouble("lng");
          i2 = ((Bundle)localObject3).getInt("fakeCode");
        }
        if (i2 != 0)
        {
          this.T = true;
          i1 = (int)(Math.pow(2.0D, i2 + 3) + 4.0D);
        }
        if (i5 != -1) {
          break label655;
        }
        this.T = true;
        i1 += 2;
      }
    }
    label652:
    label655:
    for (;;)
    {
      if (i4 == 0) {
        i2 = 1;
      }
      for (;;)
      {
        if (i2 != 0)
        {
          localObject3 = new fi.a();
          ((fi.a)localObject3).b = ((fi)localObject1);
          ((fi.a)localObject3).d = "gps";
          if (this.T)
          {
            localObject1 = "fake";
            label220:
            ((fi.a)localObject3).e = ((String)localObject1);
            ((fi.a)localObject3).c = i3;
            localObject1 = ((fi.a)localObject3).a(new Location(???.a)).a();
            localLocation.setLatitude(d2);
            localLocation.setLongitude(d1);
            ((fi)localObject1).a(localLocation);
            ((fi)localObject1).a(i1);
            a(0, (fi)localObject1);
            if (this.w != null)
            {
              localObject1 = this.w;
              localLocation = ???.a;
            }
          }
        }
        synchronized (((co)localObject1).a)
        {
          if (!((co)localObject1).c())
          {
            return;
            i2 = 0;
            continue;
            localObject1 = "gps";
            break label220;
            if (m()) {
              a(3999);
            }
            localObject3 = new fi.a();
            ((fi.a)localObject3).b = ((fi)localObject1);
            ((fi.a)localObject3).d = "gps";
            if (this.T) {}
            for (localObject1 = "fake";; localObject1 = "gps")
            {
              ((fi.a)localObject3).e = ((String)localObject1);
              ((fi.a)localObject3).c = i3;
              localObject1 = ((fi.a)localObject3).a(new Location(???.a)).a();
              localLocation.setLatitude(d2);
              localLocation.setLongitude(d1);
              ((fi)localObject1).a(localLocation);
              ((fi)localObject1).a(i1);
              a(0, (fi)localObject1);
              a(12004, 3);
              break;
            }
          }
          else
          {
            co.a("setGpsLocation");
            if (((co)localObject1).b != null)
            {
              localObject3 = ((co)localObject1).b;
              if (((cq)localObject3).l != null) {
                ((cq)localObject3).l.a(localLocation);
              }
            }
            if ((localLocation == null) || (!"gps".equals(localLocation.getProvider())) || (localLocation.getAltitude() == 0.0D)) {
              break label652;
            }
            boolean bool = cu.h;
            if ((Build.VERSION.SDK_INT >= 18) && (localLocation.isFromMockProvider())) {
              return;
            }
          }
        }
      }
      localObject2.d = co.a(localObject2.d, localLocation);
      if ((localObject2.e == null) || ((localObject2.d != null) && (localObject2.d.distanceTo(localObject2.e) >= 50.0F) && (System.currentTimeMillis() - localObject2.k >= 5000L))) {
        localObject2.b();
      }
      return;
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    int i1 = fn.a(this.F.a);
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
      case -1: 
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
    new StringBuilder("onNetworkEvent: ").append(str).append(" disconnected");
    return;
    new StringBuilder("onNetworkEvent: ").append(str).append(" connected");
    a(7999, 1000L);
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(ex paramex)
  {
    new StringBuilder("wifiCallback:").append(System.currentTimeMillis());
    if (this.o != null) {
      this.o.removeMessages(3999, "wifi_not_received");
    }
    if (paramex == ex.a) {
      a(555, 1500L);
    }
    co localco;
    List localList;
    for (;;)
    {
      if (this.w != null)
      {
        localco = this.w;
        localList = Collections.unmodifiableList(paramex.b);
      }
      synchronized (localco.a)
      {
        if (!localco.c())
        {
          return;
          if ((this.C == null) || (!this.H) || (Collections.unmodifiableList(paramex.b).size() < 3) || (!this.C.a(paramex))) {
            a(3999);
          }
          this.C = paramex;
        }
      }
    }
    long l1;
    boolean bool1;
    long l2;
    boolean bool2;
    try
    {
      l1 = System.currentTimeMillis();
      bool1 = cy.a(localco.g, localList);
      co.a("setWifiResults, same pre:".concat(String.valueOf(bool1)));
      if (bool1)
      {
        l2 = localco.j;
        if (l1 - l2 > 30000L)
        {
          return;
          paramex = finally;
          throw paramex;
        }
      }
      if (localco.b != null)
      {
        paramex = localco.b;
        if (paramex.k != null)
        {
          paramex = paramex.k;
          if ((paramex.f()) && (!co.a(localList))) {
            break label327;
          }
        }
      }
      while ((localco.b != null) && (localco.d != null) && (!co.a(localList)))
      {
        if (localList.size() != 1) {
          break label367;
        }
        bool2 = "123456789abc".equals(((ScanResult)localList.get(0)).BSSID.toLowerCase());
        if (!bool2) {
          break label394;
        }
        return;
        label327:
        Message localMessage = paramex.e().obtainMessage(102);
        localMessage.obj = localList;
        paramex.b(localMessage);
      }
    }
    catch (Throwable paramex)
    {
      co.a("setWifiResults error.", paramex);
    }
    return;
    label367:
    if (localList.size() > 1)
    {
      bool2 = cy.a(localList);
      if (bool2) {
        return;
      }
    }
    label394:
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
    if (l1 - localco.i < localco.h) {}
    for (paramex = localco.f;; paramex = null)
    {
      localco.b.a(localco.d, localList, paramex);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.ek
 * JD-Core Version:    0.7.0.1
 */