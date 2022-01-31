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

public final class el
{
  private static SparseArray<String> n;
  private er A;
  private eu B;
  private ey C;
  private ev D;
  private ew E;
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
  public final ei b;
  public final em c;
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
  private el.a o;
  private final eg p;
  private final eo q;
  private final boolean r;
  private final ek s;
  private final es t;
  private final en u;
  private final eq v;
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
  
  public el(ea paramea)
  {
    this.F = paramea;
    this.u = new en(this.F);
    this.v = new eq(this.F);
    this.A = new er();
    this.b = ei.a(paramea.a);
    this.c = em.b();
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      this.r = bool;
      if (this.r)
      {
        this.p = null;
        this.t = h();
        if (!this.F.b()) {}
        for (paramea = null;; paramea = new eo(this.F))
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
        for (paramea = localObject;; paramea = new eg(this.F))
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
  private ek g()
  {
    if (!this.F.d()) {
      return null;
    }
    return new ek(this.F);
  }
  
  @Nullable
  private es h()
  {
    if (!this.F.c()) {
      return null;
    }
    return new es(this.F);
  }
  
  private dt i()
  {
    try
    {
      Object localObject = this.F.b;
      localObject = new dt(((eb)localObject).j, ((eb)localObject).d(), ((eb)localObject).f());
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
          el.2 local2 = new el.2(this);
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
    ew.a = 0;
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
        ek localek = this.s;
        if ((localek.c & 0x2) != 2) {
          break label65;
        }
        if (System.currentTimeMillis() - localek.a < ej.a().b()) {
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
    //   1: getfield 149	c/t/m/g/el:z	I
    //   4: iconst_1
    //   5: if_icmpne +32 -> 37
    //   8: aload_0
    //   9: invokevirtual 685	c/t/m/g/el:d	()V
    //   12: aload_0
    //   13: getfield 534	c/t/m/g/el:y	Landroid/os/HandlerThread;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: getfield 534	c/t/m/g/el:y	Landroid/os/HandlerThread;
    //   23: invokevirtual 688	android/os/HandlerThread:quit	()Z
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 534	c/t/m/g/el:y	Landroid/os/HandlerThread;
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 149	c/t/m/g/el:z	I
    //   37: invokestatic 693	com/tencent/map/geolocation/TencentLocationManagerOptions:isLoadLibraryEnabled	()Z
    //   40: ifeq +15 -> 55
    //   43: ldc_w 695
    //   46: invokestatic 698	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   49: ldc_w 700
    //   52: invokestatic 698	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 179	c/t/m/g/el:F	Lc/t/m/g/ea;
    //   59: astore 10
    //   61: aload 10
    //   63: getfield 248	c/t/m/g/ea:b	Lc/t/m/g/eb;
    //   66: astore 9
    //   68: ldc_w 702
    //   71: aload 9
    //   73: invokevirtual 704	c/t/m/g/eb:a	()Ljava/lang/String;
    //   76: invokevirtual 393	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +22 -> 101
    //   82: ldc_w 702
    //   85: aload 9
    //   87: invokevirtual 706	c/t/m/g/eb:b	()Ljava/lang/String;
    //   90: invokevirtual 393	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +8 -> 101
    //   96: aload 10
    //   98: invokevirtual 707	c/t/m/g/ea:a	()V
    //   101: aload 9
    //   103: getfield 709	c/t/m/g/eb:g	Ljava/lang/String;
    //   106: invokestatic 711	c/t/m/g/co:e	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 10
    //   111: aload_0
    //   112: aload 10
    //   114: invokestatic 713	c/t/m/g/el:a	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 673	c/t/m/g/el:S	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 673	c/t/m/g/el:S	Ljava/lang/String;
    //   124: invokestatic 718	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +30 -> 157
    //   130: new 397	java/lang/StringBuilder
    //   133: dup
    //   134: ldc_w 720
    //   137: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload 10
    //   142: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 722
    //   148: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: iconst_2
    //   153: ireturn
    //   154: astore_1
    //   155: iconst_3
    //   156: ireturn
    //   157: aload_0
    //   158: invokespecial 724	c/t/m/g/el:l	()V
    //   161: aload_0
    //   162: getfield 167	c/t/m/g/el:I	Ljava/lang/Object;
    //   165: astore 10
    //   167: aload 10
    //   169: monitorenter
    //   170: aload_0
    //   171: aload_2
    //   172: putfield 359	c/t/m/g/el:d	Lcom/tencent/map/geolocation/TencentLocationListener;
    //   175: aload 10
    //   177: monitorexit
    //   178: aload_0
    //   179: getfield 175	c/t/m/g/el:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   182: aload_1
    //   183: invokestatic 728	com/tencent/map/geolocation/TencentLocationRequest:copy	(Lcom/tencent/map/geolocation/TencentLocationRequest;Lcom/tencent/map/geolocation/TencentLocationRequest;)V
    //   186: aload 9
    //   188: aload_1
    //   189: invokevirtual 731	com/tencent/map/geolocation/TencentLocationRequest:getQQ	()Ljava/lang/String;
    //   192: putfield 733	c/t/m/g/eb:f	Ljava/lang/String;
    //   195: aload 9
    //   197: getfield 735	c/t/m/g/eb:d	Ljava/lang/String;
    //   200: invokestatic 711	c/t/m/g/co:e	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 718	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifeq +12 -> 218
    //   209: aload 9
    //   211: aload_1
    //   212: invokevirtual 738	com/tencent/map/geolocation/TencentLocationRequest:getPhoneNumber	()Ljava/lang/String;
    //   215: putfield 735	c/t/m/g/eb:d	Ljava/lang/String;
    //   218: aload_1
    //   219: invokevirtual 363	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   222: lconst_0
    //   223: lcmp
    //   224: ifne +1290 -> 1514
    //   227: ldc2_w 739
    //   230: lstore 5
    //   232: aload 9
    //   234: invokestatic 494	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   237: ldc 124
    //   239: invokevirtual 499	c/t/m/g/da:c	(Ljava/lang/String;)J
    //   242: lload 5
    //   244: invokestatic 744	java/lang/Math:max	(JJ)J
    //   247: putfield 746	c/t/m/g/eb:k	J
    //   250: invokestatic 751	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   253: ifnonnull +6 -> 259
    //   256: invokestatic 754	android/os/Looper:prepare	()V
    //   259: aload_0
    //   260: getfield 307	c/t/m/g/el:o	Lc/t/m/g/el$a;
    //   263: ifnonnull +1260 -> 1523
    //   266: iconst_1
    //   267: istore 4
    //   269: iload 4
    //   271: ifeq +1258 -> 1529
    //   274: aload_0
    //   275: new 309	c/t/m/g/el$a
    //   278: dup
    //   279: aload_0
    //   280: aload_3
    //   281: invokespecial 757	c/t/m/g/el$a:<init>	(Lc/t/m/g/el;Landroid/os/Looper;)V
    //   284: putfield 307	c/t/m/g/el:o	Lc/t/m/g/el$a;
    //   287: aload_0
    //   288: invokespecial 759	c/t/m/g/el:k	()V
    //   291: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   294: lstore 5
    //   296: new 397	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 761
    //   303: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   309: lload 5
    //   311: lsub
    //   312: invokevirtual 764	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: getfield 175	c/t/m/g/el:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   320: invokevirtual 367	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   323: ldc_w 766
    //   326: iconst_1
    //   327: invokevirtual 769	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   330: istore 7
    //   332: aload_0
    //   333: getfield 175	c/t/m/g/el:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   336: invokevirtual 367	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   339: ldc_w 369
    //   342: invokevirtual 375	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   345: istore 8
    //   347: aload_0
    //   348: getfield 307	c/t/m/g/el:o	Lc/t/m/g/el$a;
    //   351: astore_1
    //   352: aload_0
    //   353: getfield 185	c/t/m/g/el:u	Lc/t/m/g/en;
    //   356: astore_2
    //   357: aload_2
    //   358: getfield 771	c/t/m/g/en:b	Z
    //   361: ifne +34 -> 395
    //   364: aload_2
    //   365: iconst_1
    //   366: putfield 771	c/t/m/g/en:b	Z
    //   369: new 773	android/content/IntentFilter
    //   372: dup
    //   373: ldc_w 775
    //   376: invokespecial 776	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   379: astore_3
    //   380: aload_2
    //   381: getfield 778	c/t/m/g/en:a	Lc/t/m/g/ea;
    //   384: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   387: aload_2
    //   388: aload_3
    //   389: aconst_null
    //   390: aload_1
    //   391: invokevirtual 784	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   394: pop
    //   395: aload_0
    //   396: getfield 190	c/t/m/g/el:v	Lc/t/m/g/eq;
    //   399: astore_2
    //   400: aload_2
    //   401: getfield 786	c/t/m/g/eq:g	Z
    //   404: ifne +36 -> 440
    //   407: aload_2
    //   408: iconst_1
    //   409: putfield 786	c/t/m/g/eq:g	Z
    //   412: aload_2
    //   413: getfield 788	c/t/m/g/eq:b	Lc/t/m/g/ea;
    //   416: getfield 791	c/t/m/g/ea:d	Ljava/util/concurrent/ExecutorService;
    //   419: new 793	c/t/m/g/eq$1
    //   422: dup
    //   423: aload_2
    //   424: aload_1
    //   425: invokespecial 796	c/t/m/g/eq$1:<init>	(Lc/t/m/g/eq;Landroid/os/Handler;)V
    //   428: invokeinterface 802 2 0
    //   433: aload_2
    //   434: invokestatic 807	android/os/SystemClock:elapsedRealtime	()J
    //   437: putfield 809	c/t/m/g/eq:f	J
    //   440: new 397	java/lang/StringBuilder
    //   443: dup
    //   444: ldc_w 811
    //   447: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   450: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   453: lload 5
    //   455: lsub
    //   456: invokevirtual 764	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: iload 8
    //   462: ifeq +18 -> 480
    //   465: aload_0
    //   466: getfield 190	c/t/m/g/el:v	Lc/t/m/g/eq;
    //   469: aload_0
    //   470: getfield 179	c/t/m/g/el:F	Lc/t/m/g/ea;
    //   473: iconst_1
    //   474: invokevirtual 814	c/t/m/g/ea:a	(Z)Ljava/lang/String;
    //   477: invokevirtual 816	c/t/m/g/eq:a	(Ljava/lang/String;)V
    //   480: new 397	java/lang/StringBuilder
    //   483: dup
    //   484: ldc_w 818
    //   487: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   490: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   493: lload 5
    //   495: lsub
    //   496: invokevirtual 764	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_0
    //   501: getfield 221	c/t/m/g/el:r	Z
    //   504: ifeq +1090 -> 1594
    //   507: iload 7
    //   509: ifeq +129 -> 638
    //   512: aload_0
    //   513: getfield 233	c/t/m/g/el:q	Lc/t/m/g/eo;
    //   516: ifnull +1048 -> 1564
    //   519: iconst_1
    //   520: istore 4
    //   522: iload 4
    //   524: ifeq +114 -> 638
    //   527: aload_0
    //   528: getfield 233	c/t/m/g/el:q	Lc/t/m/g/eo;
    //   531: astore_2
    //   532: aload_2
    //   533: getfield 819	c/t/m/g/eo:a	Z
    //   536: ifne +102 -> 638
    //   539: aload_2
    //   540: aload_1
    //   541: putfield 822	c/t/m/g/eo:i	Landroid/os/Handler;
    //   544: aload_2
    //   545: new 529	android/os/HandlerThread
    //   548: dup
    //   549: ldc_w 824
    //   552: invokespecial 532	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   555: putfield 826	c/t/m/g/eo:f	Landroid/os/HandlerThread;
    //   558: aload_2
    //   559: getfield 826	c/t/m/g/eo:f	Landroid/os/HandlerThread;
    //   562: ifnull +76 -> 638
    //   565: aload_2
    //   566: getfield 822	c/t/m/g/eo:i	Landroid/os/Handler;
    //   569: ifnull +69 -> 638
    //   572: aload_2
    //   573: getfield 826	c/t/m/g/eo:f	Landroid/os/HandlerThread;
    //   576: invokevirtual 537	android/os/HandlerThread:start	()V
    //   579: aload_2
    //   580: new 828	c/t/m/g/eo$a
    //   583: dup
    //   584: aload_2
    //   585: aload_2
    //   586: getfield 826	c/t/m/g/eo:f	Landroid/os/HandlerThread;
    //   589: invokevirtual 541	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   592: iconst_0
    //   593: invokespecial 831	c/t/m/g/eo$a:<init>	(Lc/t/m/g/eo;Landroid/os/Looper;B)V
    //   596: putfield 834	c/t/m/g/eo:g	Lc/t/m/g/eo$a;
    //   599: aload_2
    //   600: iconst_1
    //   601: putfield 819	c/t/m/g/eo:a	Z
    //   604: iload 8
    //   606: ifne +13 -> 619
    //   609: aload_2
    //   610: getfield 834	c/t/m/g/eo:g	Lc/t/m/g/eo$a;
    //   613: iconst_0
    //   614: lconst_0
    //   615: invokestatic 837	c/t/m/g/co:a	(Landroid/os/Handler;IJ)Z
    //   618: pop
    //   619: aload_2
    //   620: getfield 834	c/t/m/g/eo:g	Lc/t/m/g/eo$a;
    //   623: new 839	c/t/m/g/eo$1
    //   626: dup
    //   627: aload_2
    //   628: invokespecial 842	c/t/m/g/eo$1:<init>	(Lc/t/m/g/eo;)V
    //   631: ldc2_w 843
    //   634: invokevirtual 848	c/t/m/g/eo$a:postDelayed	(Ljava/lang/Runnable;J)Z
    //   637: pop
    //   638: new 397	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 850
    //   645: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   651: lload 5
    //   653: lsub
    //   654: invokevirtual 764	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: iload 7
    //   660: ifeq +99 -> 759
    //   663: aload_0
    //   664: getfield 228	c/t/m/g/el:t	Lc/t/m/g/es;
    //   667: ifnull +1079 -> 1746
    //   670: iconst_1
    //   671: istore 4
    //   673: iload 4
    //   675: ifeq +84 -> 759
    //   678: aload_0
    //   679: getfield 228	c/t/m/g/el:t	Lc/t/m/g/es;
    //   682: astore_2
    //   683: aload_2
    //   684: getfield 851	c/t/m/g/es:a	Z
    //   687: ifne +72 -> 759
    //   690: aload_2
    //   691: iconst_1
    //   692: putfield 851	c/t/m/g/es:a	Z
    //   695: aload_2
    //   696: iconst_0
    //   697: putfield 853	c/t/m/g/es:d	Z
    //   700: aload_2
    //   701: iload 8
    //   703: putfield 855	c/t/m/g/es:c	Z
    //   706: aload_1
    //   707: putstatic 857	c/t/m/g/es:e	Landroid/os/Handler;
    //   710: new 773	android/content/IntentFilter
    //   713: dup
    //   714: invokespecial 858	android/content/IntentFilter:<init>	()V
    //   717: astore_3
    //   718: aload_3
    //   719: ldc_w 860
    //   722: invokevirtual 863	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   725: aload_3
    //   726: ldc_w 865
    //   729: invokevirtual 863	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   732: aload_2
    //   733: getfield 866	c/t/m/g/es:b	Lc/t/m/g/ea;
    //   736: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   739: aload_2
    //   740: aload_3
    //   741: aconst_null
    //   742: aload_1
    //   743: invokevirtual 784	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   746: pop
    //   747: aload_2
    //   748: getfield 855	c/t/m/g/es:c	Z
    //   751: ifne +8 -> 759
    //   754: aload_2
    //   755: lconst_0
    //   756: invokevirtual 869	c/t/m/g/es:a	(J)V
    //   759: new 397	java/lang/StringBuilder
    //   762: dup
    //   763: ldc_w 871
    //   766: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   769: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   772: lload 5
    //   774: lsub
    //   775: invokevirtual 764	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: iload 8
    //   781: ifne +8 -> 789
    //   784: aload_0
    //   785: iconst_1
    //   786: putfield 676	c/t/m/g/el:O	Z
    //   789: aload_0
    //   790: getfield 238	c/t/m/g/el:s	Lc/t/m/g/ek;
    //   793: ifnull +959 -> 1752
    //   796: iconst_1
    //   797: istore 4
    //   799: iload 4
    //   801: ifeq +175 -> 976
    //   804: aload_0
    //   805: getfield 175	c/t/m/g/el:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   808: invokevirtual 874	com/tencent/map/geolocation/TencentLocationRequest:isAllowGPS	()Z
    //   811: ifeq +165 -> 976
    //   814: aload_0
    //   815: getfield 238	c/t/m/g/el:s	Lc/t/m/g/ek;
    //   818: astore_2
    //   819: aload_0
    //   820: getfield 145	c/t/m/g/el:a	I
    //   823: iconst_1
    //   824: if_icmpne +934 -> 1758
    //   827: iconst_1
    //   828: istore 7
    //   830: aload_2
    //   831: iload 7
    //   833: putfield 876	c/t/m/g/ek:f	Z
    //   836: aload_0
    //   837: getfield 238	c/t/m/g/el:s	Lc/t/m/g/ek;
    //   840: astore_2
    //   841: aload_0
    //   842: getfield 175	c/t/m/g/el:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   845: invokevirtual 363	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   848: pop2
    //   849: aload_2
    //   850: getfield 877	c/t/m/g/ek:d	Z
    //   853: ifne +123 -> 976
    //   856: aload_2
    //   857: iconst_1
    //   858: putfield 877	c/t/m/g/ek:d	Z
    //   861: aload_2
    //   862: new 529	android/os/HandlerThread
    //   865: dup
    //   866: ldc_w 879
    //   869: invokespecial 532	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   872: putfield 881	c/t/m/g/ek:g	Landroid/os/HandlerThread;
    //   875: aload_2
    //   876: getfield 882	c/t/m/g/ek:b	Lc/t/m/g/ea;
    //   879: getfield 885	c/t/m/g/ea:h	Landroid/location/LocationManager;
    //   882: astore_3
    //   883: aload_2
    //   884: getfield 881	c/t/m/g/ek:g	Landroid/os/HandlerThread;
    //   887: invokevirtual 537	android/os/HandlerThread:start	()V
    //   890: aload_2
    //   891: new 887	android/os/Handler
    //   894: dup
    //   895: aload_2
    //   896: getfield 881	c/t/m/g/ek:g	Landroid/os/HandlerThread;
    //   899: invokevirtual 541	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   902: invokespecial 890	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   905: putfield 891	c/t/m/g/ek:i	Landroid/os/Handler;
    //   908: iload 8
    //   910: ifne +854 -> 1764
    //   913: aload_2
    //   914: getfield 882	c/t/m/g/ek:b	Lc/t/m/g/ea;
    //   917: getfield 885	c/t/m/g/ea:h	Landroid/location/LocationManager;
    //   920: ldc_w 395
    //   923: ldc2_w 843
    //   926: fconst_0
    //   927: aload_2
    //   928: getfield 893	c/t/m/g/ek:j	Lc/t/m/g/ek;
    //   931: aload_2
    //   932: getfield 881	c/t/m/g/ek:g	Landroid/os/HandlerThread;
    //   935: invokevirtual 541	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   938: invokevirtual 899	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   941: aload_2
    //   942: getfield 891	c/t/m/g/ek:i	Landroid/os/Handler;
    //   945: aload_2
    //   946: getfield 902	c/t/m/g/ek:h	Ljava/lang/Runnable;
    //   949: invokevirtual 906	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   952: pop
    //   953: aload_2
    //   954: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   957: putfield 908	c/t/m/g/ek:e	J
    //   960: aload_2
    //   961: invokevirtual 599	c/t/m/g/ek:b	()Z
    //   964: ifeq +12 -> 976
    //   967: aload_2
    //   968: iconst_4
    //   969: putfield 601	c/t/m/g/ek:c	I
    //   972: aload_2
    //   973: invokevirtual 909	c/t/m/g/ek:c	()V
    //   976: new 397	java/lang/StringBuilder
    //   979: dup
    //   980: ldc_w 911
    //   983: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   986: invokestatic 549	java/lang/System:currentTimeMillis	()J
    //   989: lload 5
    //   991: lsub
    //   992: invokevirtual 764	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload_0
    //   997: getfield 175	c/t/m/g/el:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1000: invokevirtual 566	com/tencent/map/geolocation/TencentLocationRequest:isAllowDirection	()Z
    //   1003: ifeq +23 -> 1026
    //   1006: aload_0
    //   1007: getfield 207	c/t/m/g/el:b	Lc/t/m/g/ei;
    //   1010: getfield 567	c/t/m/g/ei:a	Z
    //   1013: ifne +13 -> 1026
    //   1016: aload_0
    //   1017: getfield 207	c/t/m/g/el:b	Lc/t/m/g/ei;
    //   1020: aload_1
    //   1021: aconst_null
    //   1022: invokevirtual 914	c/t/m/g/ei:a	(Landroid/os/Handler;Lcom/tencent/map/geolocation/TencentDirectionListener;)I
    //   1025: pop
    //   1026: iload 8
    //   1028: ifne +139 -> 1167
    //   1031: aload_0
    //   1032: getfield 175	c/t/m/g/el:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1035: invokevirtual 917	com/tencent/map/geolocation/TencentLocationRequest:isAllowPedometer	()Z
    //   1038: ifeq +129 -> 1167
    //   1041: aload_0
    //   1042: getfield 214	c/t/m/g/el:c	Lc/t/m/g/em;
    //   1045: astore_2
    //   1046: aload_0
    //   1047: getfield 179	c/t/m/g/el:F	Lc/t/m/g/ea;
    //   1050: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   1053: putstatic 919	c/t/m/g/em:f	Landroid/content/Context;
    //   1056: ldc_w 921
    //   1059: invokestatic 926	c/t/m/g/dy:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   1062: putstatic 929	c/t/m/g/em:i	Landroid/content/SharedPreferences;
    //   1065: aload_2
    //   1066: new 529	android/os/HandlerThread
    //   1069: dup
    //   1070: ldc_w 931
    //   1073: invokespecial 532	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1076: putfield 932	c/t/m/g/em:g	Landroid/os/HandlerThread;
    //   1079: aload_2
    //   1080: getfield 932	c/t/m/g/em:g	Landroid/os/HandlerThread;
    //   1083: invokevirtual 537	android/os/HandlerThread:start	()V
    //   1086: aload_2
    //   1087: getfield 935	c/t/m/g/em:a	Lc/t/m/g/du;
    //   1090: aload_2
    //   1091: putfield 940	c/t/m/g/du:i	Lc/t/m/g/ef;
    //   1094: aload_2
    //   1095: getstatic 919	c/t/m/g/em:f	Landroid/content/Context;
    //   1098: ldc_w 942
    //   1101: invokevirtual 946	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1104: checkcast 948	android/hardware/SensorManager
    //   1107: putfield 951	c/t/m/g/em:b	Landroid/hardware/SensorManager;
    //   1110: aload_2
    //   1111: getfield 951	c/t/m/g/em:b	Landroid/hardware/SensorManager;
    //   1114: ifnull +49 -> 1163
    //   1117: aload_2
    //   1118: aload_2
    //   1119: getfield 951	c/t/m/g/em:b	Landroid/hardware/SensorManager;
    //   1122: iconst_1
    //   1123: invokevirtual 955	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1126: putfield 958	c/t/m/g/em:c	Landroid/hardware/Sensor;
    //   1129: aload_2
    //   1130: aload_2
    //   1131: getfield 951	c/t/m/g/em:b	Landroid/hardware/SensorManager;
    //   1134: bipush 10
    //   1136: invokevirtual 955	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1139: putfield 960	c/t/m/g/em:d	Landroid/hardware/Sensor;
    //   1142: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   1145: bipush 19
    //   1147: if_icmplt +16 -> 1163
    //   1150: aload_2
    //   1151: aload_2
    //   1152: getfield 951	c/t/m/g/em:b	Landroid/hardware/SensorManager;
    //   1155: bipush 19
    //   1157: invokevirtual 955	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1160: putfield 962	c/t/m/g/em:e	Landroid/hardware/Sensor;
    //   1163: aload_2
    //   1164: invokevirtual 963	c/t/m/g/em:d	()V
    //   1167: invokestatic 494	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   1170: ldc 128
    //   1172: invokevirtual 965	c/t/m/g/da:b	(Ljava/lang/String;)I
    //   1175: istore 4
    //   1177: iload 4
    //   1179: iconst_1
    //   1180: if_icmpeq +9 -> 1189
    //   1183: iload 4
    //   1185: iconst_2
    //   1186: if_icmpne +28 -> 1214
    //   1189: aload_0
    //   1190: getfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1193: ifnonnull +21 -> 1214
    //   1196: aload_0
    //   1197: new 578	c/t/m/g/co
    //   1200: dup
    //   1201: aload_0
    //   1202: getfield 179	c/t/m/g/el:F	Lc/t/m/g/ea;
    //   1205: getfield 200	c/t/m/g/ea:a	Landroid/content/Context;
    //   1208: invokespecial 968	c/t/m/g/co:<init>	(Landroid/content/Context;)V
    //   1211: putfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1214: aload_0
    //   1215: getfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1218: ifnull +274 -> 1492
    //   1221: aload_1
    //   1222: ifnull +270 -> 1492
    //   1225: new 397	java/lang/StringBuilder
    //   1228: dup
    //   1229: ldc_w 970
    //   1232: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1235: iload 4
    //   1237: invokevirtual 666	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: ldc_w 972
    //   1243: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: iload 8
    //   1248: invokevirtual 975	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1251: ldc_w 977
    //   1254: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: iload 4
    //   1260: iconst_2
    //   1261: if_icmpeq +14 -> 1275
    //   1264: iload 4
    //   1266: iconst_1
    //   1267: if_icmpne +225 -> 1492
    //   1270: iload 8
    //   1272: ifne +220 -> 1492
    //   1275: aload_0
    //   1276: getfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1279: astore_3
    //   1280: aload_0
    //   1281: invokespecial 979	c/t/m/g/el:i	()Lc/t/m/g/dt;
    //   1284: astore_2
    //   1285: aload_3
    //   1286: getfield 982	c/t/m/g/co:a	[B
    //   1289: astore_3
    //   1290: aload_3
    //   1291: monitorenter
    //   1292: aload_2
    //   1293: putstatic 987	c/t/m/g/cu:i	Lc/t/m/g/dt;
    //   1296: invokestatic 989	c/t/m/g/co:e	()Z
    //   1299: ifeq +75 -> 1374
    //   1302: new 397	java/lang/StringBuilder
    //   1305: dup
    //   1306: ldc_w 991
    //   1309: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1312: aload_2
    //   1313: getfield 993	c/t/m/g/dt:b	Ljava/lang/String;
    //   1316: invokestatic 994	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1319: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: ldc_w 996
    //   1325: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload_2
    //   1329: getfield 998	c/t/m/g/dt:a	Ljava/lang/String;
    //   1332: invokestatic 994	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1335: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: ldc_w 278
    //   1341: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: getstatic 1003	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1347: invokestatic 994	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1350: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: ldc_w 278
    //   1356: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: getstatic 1006	android/os/Build:MODEL	Ljava/lang/String;
    //   1362: invokestatic 994	c/t/m/g/dt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1365: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 1008	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokestatic 1009	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   1374: aload_3
    //   1375: monitorexit
    //   1376: aload_0
    //   1377: getfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1380: ldc_w 1011
    //   1383: invokestatic 494	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   1386: ldc 132
    //   1388: invokevirtual 1012	c/t/m/g/da:e	(Ljava/lang/String;)Ljava/lang/String;
    //   1391: invokevirtual 1015	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1394: aload_0
    //   1395: getfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1398: ldc_w 1017
    //   1401: iconst_1
    //   1402: invokestatic 1021	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1405: invokevirtual 1015	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1408: aload_0
    //   1409: getfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1412: ldc_w 1023
    //   1415: ldc 116
    //   1417: invokevirtual 1015	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1420: aload_0
    //   1421: getfield 576	c/t/m/g/el:w	Lc/t/m/g/co;
    //   1424: astore_3
    //   1425: aload_1
    //   1426: invokevirtual 1024	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1429: astore_2
    //   1430: aload_3
    //   1431: getfield 982	c/t/m/g/co:a	[B
    //   1434: astore 9
    //   1436: aload 9
    //   1438: monitorenter
    //   1439: ldc_w 1026
    //   1442: invokestatic 1009	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   1445: aload_3
    //   1446: invokevirtual 1027	c/t/m/g/co:d	()V
    //   1449: aload_3
    //   1450: getfield 1030	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   1453: ifnull +36 -> 1489
    //   1456: aload_2
    //   1457: astore_1
    //   1458: aload_2
    //   1459: ifnonnull +21 -> 1480
    //   1462: aload_3
    //   1463: ldc_w 1032
    //   1466: invokestatic 1037	c/t/m/g/ds:a	(Ljava/lang/String;)Landroid/os/HandlerThread;
    //   1469: putfield 1039	c/t/m/g/co:c	Landroid/os/HandlerThread;
    //   1472: aload_3
    //   1473: getfield 1039	c/t/m/g/co:c	Landroid/os/HandlerThread;
    //   1476: invokevirtual 541	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1479: astore_1
    //   1480: aload_3
    //   1481: getfield 1030	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   1484: aload_1
    //   1485: invokevirtual 1044	c/t/m/g/cq:b	(Landroid/os/Looper;)I
    //   1488: pop
    //   1489: aload 9
    //   1491: monitorexit
    //   1492: aload_0
    //   1493: ldc_w 1045
    //   1496: putfield 153	c/t/m/g/el:G	Ljava/lang/String;
    //   1499: aload_0
    //   1500: getfield 673	c/t/m/g/el:S	Ljava/lang/String;
    //   1503: invokestatic 1046	c/t/m/g/cz:a	(Ljava/lang/String;)V
    //   1506: iconst_0
    //   1507: ireturn
    //   1508: astore_1
    //   1509: aload 10
    //   1511: monitorexit
    //   1512: aload_1
    //   1513: athrow
    //   1514: aload_1
    //   1515: invokevirtual 363	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   1518: lstore 5
    //   1520: goto -1288 -> 232
    //   1523: iconst_0
    //   1524: istore 4
    //   1526: goto -1257 -> 269
    //   1529: aload_0
    //   1530: getfield 307	c/t/m/g/el:o	Lc/t/m/g/el$a;
    //   1533: aconst_null
    //   1534: invokevirtual 1049	c/t/m/g/el$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1537: aload_0
    //   1538: getfield 307	c/t/m/g/el:o	Lc/t/m/g/el$a;
    //   1541: invokevirtual 1050	c/t/m/g/el$a:getLooper	()Landroid/os/Looper;
    //   1544: aload_3
    //   1545: if_acmpeq -1258 -> 287
    //   1548: aload_0
    //   1549: new 309	c/t/m/g/el$a
    //   1552: dup
    //   1553: aload_0
    //   1554: aload_3
    //   1555: invokespecial 757	c/t/m/g/el$a:<init>	(Lc/t/m/g/el;Landroid/os/Looper;)V
    //   1558: putfield 307	c/t/m/g/el:o	Lc/t/m/g/el$a;
    //   1561: goto -1274 -> 287
    //   1564: iconst_0
    //   1565: istore 4
    //   1567: goto -1045 -> 522
    //   1570: astore_3
    //   1571: aload_2
    //   1572: new 828	c/t/m/g/eo$a
    //   1575: dup
    //   1576: aload_2
    //   1577: aload_2
    //   1578: getfield 822	c/t/m/g/eo:i	Landroid/os/Handler;
    //   1581: invokevirtual 1024	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1584: iconst_0
    //   1585: invokespecial 831	c/t/m/g/eo$a:<init>	(Lc/t/m/g/eo;Landroid/os/Looper;B)V
    //   1588: putfield 834	c/t/m/g/eo:g	Lc/t/m/g/eo$a;
    //   1591: goto -992 -> 599
    //   1594: iload 7
    //   1596: ifeq -958 -> 638
    //   1599: aload_0
    //   1600: getfield 223	c/t/m/g/el:p	Lc/t/m/g/eg;
    //   1603: ifnull +137 -> 1740
    //   1606: iconst_1
    //   1607: istore 4
    //   1609: iload 4
    //   1611: ifeq -973 -> 638
    //   1614: aload_0
    //   1615: getfield 223	c/t/m/g/el:p	Lc/t/m/g/eg;
    //   1618: astore_2
    //   1619: aload_2
    //   1620: getfield 1051	c/t/m/g/eg:a	Z
    //   1623: ifne -985 -> 638
    //   1626: aload_2
    //   1627: iconst_1
    //   1628: putfield 1051	c/t/m/g/eg:a	Z
    //   1631: aload_2
    //   1632: new 529	android/os/HandlerThread
    //   1635: dup
    //   1636: ldc_w 1053
    //   1639: invokespecial 532	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1642: putfield 1055	c/t/m/g/eg:d	Landroid/os/HandlerThread;
    //   1645: aload_2
    //   1646: getfield 1055	c/t/m/g/eg:d	Landroid/os/HandlerThread;
    //   1649: invokevirtual 537	android/os/HandlerThread:start	()V
    //   1652: aload_2
    //   1653: new 1057	c/t/m/g/eg$a
    //   1656: dup
    //   1657: aload_2
    //   1658: aload_2
    //   1659: getfield 1055	c/t/m/g/eg:d	Landroid/os/HandlerThread;
    //   1662: invokevirtual 541	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1665: iconst_0
    //   1666: invokespecial 1060	c/t/m/g/eg$a:<init>	(Lc/t/m/g/eg;Landroid/os/Looper;B)V
    //   1669: putfield 1061	c/t/m/g/eg:e	Landroid/os/Handler;
    //   1672: aload_2
    //   1673: getfield 1061	c/t/m/g/eg:e	Landroid/os/Handler;
    //   1676: iconst_0
    //   1677: ldc2_w 1062
    //   1680: invokevirtual 1064	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   1683: pop
    //   1684: aload_2
    //   1685: getfield 1065	c/t/m/g/eg:b	Lc/t/m/g/ea;
    //   1688: invokestatic 624	c/t/m/g/fj:a	(Lc/t/m/g/ea;)Landroid/telephony/CellLocation;
    //   1691: astore_3
    //   1692: aload_2
    //   1693: aload_3
    //   1694: invokevirtual 1068	c/t/m/g/eg:a	(Landroid/telephony/CellLocation;)Z
    //   1697: ifeq +33 -> 1730
    //   1700: aload_2
    //   1701: getfield 1065	c/t/m/g/eg:b	Lc/t/m/g/ea;
    //   1704: aload_3
    //   1705: aconst_null
    //   1706: invokestatic 627	c/t/m/g/eu:a	(Lc/t/m/g/ea;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/m/g/eu;
    //   1709: astore 9
    //   1711: aload 9
    //   1713: ifnull +17 -> 1730
    //   1716: aload_2
    //   1717: aload_3
    //   1718: putfield 1071	c/t/m/g/eg:c	Landroid/telephony/CellLocation;
    //   1721: aload_2
    //   1722: getfield 1065	c/t/m/g/eg:b	Lc/t/m/g/ea;
    //   1725: aload 9
    //   1727: invokevirtual 1073	c/t/m/g/ea:b	(Ljava/lang/Object;)V
    //   1730: aload_2
    //   1731: sipush 273
    //   1734: invokevirtual 1074	c/t/m/g/eg:a	(I)V
    //   1737: goto -1099 -> 638
    //   1740: iconst_0
    //   1741: istore 4
    //   1743: goto -134 -> 1609
    //   1746: iconst_0
    //   1747: istore 4
    //   1749: goto -1076 -> 673
    //   1752: iconst_0
    //   1753: istore 4
    //   1755: goto -956 -> 799
    //   1758: iconst_0
    //   1759: istore 7
    //   1761: goto -931 -> 830
    //   1764: aload_3
    //   1765: ldc_w 1076
    //   1768: ldc2_w 1077
    //   1771: fconst_0
    //   1772: aload_2
    //   1773: aload_2
    //   1774: getfield 881	c/t/m/g/ek:g	Landroid/os/HandlerThread;
    //   1777: invokevirtual 541	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1780: invokevirtual 899	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   1783: goto -823 -> 960
    //   1786: astore_3
    //   1787: iconst_1
    //   1788: putstatic 556	c/t/m/g/fj:a	Z
    //   1791: goto -831 -> 960
    //   1794: astore_1
    //   1795: aload_3
    //   1796: monitorexit
    //   1797: aload_1
    //   1798: athrow
    //   1799: astore_1
    //   1800: aload 9
    //   1802: monitorexit
    //   1803: aload_1
    //   1804: athrow
    //   1805: astore_3
    //   1806: goto -865 -> 941
    //   1809: astore_3
    //   1810: goto -1063 -> 747
    //   1813: astore_2
    //   1814: goto -1419 -> 395
    //   1817: astore 9
    //   1819: goto -1770 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1822	0	this	el
    //   0	1822	1	paramTencentLocationRequest	TencentLocationRequest
    //   0	1822	2	paramTencentLocationListener	TencentLocationListener
    //   267	1487	4	i1	int
    //   230	1289	5	l1	long
    //   330	1430	7	bool1	boolean
    //   345	926	8	bool2	boolean
    //   1817	1	9	localError	java.lang.Error
    //   59	1451	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	154	java/lang/Error
    //   170	178	1508	finally
    //   1509	1512	1508	finally
    //   572	599	1570	java/lang/Throwable
    //   913	941	1786	java/lang/Exception
    //   941	960	1786	java/lang/Exception
    //   1764	1783	1786	java/lang/Exception
    //   1292	1374	1794	finally
    //   1374	1376	1794	finally
    //   1795	1797	1794	finally
    //   1439	1456	1799	finally
    //   1462	1480	1799	finally
    //   1480	1489	1799	finally
    //   1489	1492	1799	finally
    //   1800	1803	1799	finally
    //   913	941	1805	java/lang/Throwable
    //   732	747	1809	java/lang/Exception
    //   369	395	1813	java/lang/Exception
    //   43	49	1817	java/lang/Error
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
        localObject1 = new el.1(this, f2, l1);
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
  
  public final void onCellInfoEvent(eu parameu)
  {
    new StringBuilder("cellCallback:").append(System.currentTimeMillis());
    int i4 = parameu.e;
    int i5 = parameu.f;
    Object localObject = this.B;
    int i2;
    if (localObject != null) {
      i2 = ((eu)localObject).f;
    }
    for (int i3 = ((eu)localObject).e;; i3 = 0)
    {
      this.B = parameu;
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
          localObject = new cp(parameu.b, parameu.c, parameu.d, parameu.e, parameu.f, parameu.a.ordinal());
          localArrayList = new ArrayList();
          localArrayList.add(localObject);
          parameu = parameu.b().iterator();
          while (parameu.hasNext())
          {
            eu localeu = (eu)parameu.next();
            localArrayList.add(new cp(localeu.b, localeu.c, localeu.d, localeu.e, localeu.f, localeu.a.ordinal()));
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
  
  public final void onGpsInfoEvent(ev arg1)
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
    if (???.a != eh.a)
    {
      this.D = ???;
      if (!this.J.getExtras().getBoolean("daemon"))
      {
        int i5 = ej.a().a(???);
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
          break label647;
        }
        this.T = true;
        i1 += 2;
      }
    }
    label644:
    label647:
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
              break label644;
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
    ??? = null;
    int i1 = paramMessage.what;
    i1 = paramMessage.arg1;
    int i2 = paramMessage.arg2;
    Object localObject1;
    switch (i1)
    {
    default: 
      localObject1 = null;
      i1 = i2;
      paramMessage = (Message)???;
    }
    synchronized (this.I)
    {
      for (;;)
      {
        if (this.d != null) {
          this.d.onStatusUpdate((String)localObject1, i1, paramMessage);
        }
        return;
        localObject1 = "gps";
        switch (i2)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          paramMessage = "unknown";
          i1 = i2;
          break;
        case 1: 
          paramMessage = "gps enabled";
          i1 = i2;
          break;
        case 0: 
          paramMessage = "gps disabled";
          i1 = i2;
          break;
        case 5: 
          paramMessage = "location permission denied";
          a(3999);
          i1 = i2;
          continue;
          localObject1 = "gps";
          switch (i2)
          {
          default: 
            paramMessage = "unknown";
            i1 = i2;
            break;
          case 3: 
            paramMessage = "gps available";
            i1 = i2;
            break;
          case 4: 
            paramMessage = "gps unavailable";
            i1 = i2;
          }
          break;
        }
      }
      ??? = "cell";
      if (i2 == 1) {
        paramMessage = "cell enabled";
      }
      for (;;)
      {
        localObject1 = ???;
        i1 = i2;
        if (!fj.a) {
          break;
        }
        paramMessage = "location permission denied";
        a(3999);
        i1 = 2;
        localObject1 = ???;
        break;
        if (i2 == 0) {
          paramMessage = "cell disabled";
        } else {
          paramMessage = "unknown";
        }
      }
      String str = "wifi";
      switch (i2)
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
          paramMessage = (Message)???;
          localObject1 = str;
          i1 = i2;
          if (i2 == 5) {
            break;
          }
          paramMessage = (Message)???;
          localObject1 = str;
          i1 = i2;
          if (!fq.a) {
            break;
          }
          paramMessage = "location permission denied";
          i1 = 2;
          localObject1 = str;
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
  
  public final void onWifiInfoEvent(ey paramey)
  {
    new StringBuilder("wifiCallback:").append(System.currentTimeMillis());
    if (this.o != null) {
      this.o.removeMessages(3999, "wifi_not_received");
    }
    if (paramey == ey.a) {
      a(555, 1500L);
    }
    co localco;
    List localList;
    for (;;)
    {
      if (this.w != null)
      {
        localco = this.w;
        localList = Collections.unmodifiableList(paramey.b);
      }
      synchronized (localco.a)
      {
        if (!localco.c())
        {
          return;
          if ((this.C == null) || (!this.H) || (Collections.unmodifiableList(paramey.b).size() < 3) || (!this.C.a(paramey))) {
            a(3999);
          }
          this.C = paramey;
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
          paramey = finally;
          throw paramey;
        }
      }
      if (localco.b != null)
      {
        paramey = localco.b;
        if (paramey.k != null)
        {
          paramey = paramey.k;
          if ((paramey.f()) && (!co.a(localList))) {
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
        Message localMessage = paramey.e().obtainMessage(102);
        localMessage.obj = localList;
        paramey.b(localMessage);
      }
    }
    catch (Throwable paramey)
    {
      co.a("setWifiResults error.", paramey);
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
    for (paramey = localco.f;; paramey = null)
    {
      localco.b.a(localco.d, localList, paramey);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.el
 * JD-Core Version:    0.7.0.1
 */