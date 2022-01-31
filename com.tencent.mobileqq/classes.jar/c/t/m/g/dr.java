package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

final class dr
  implements GpsStatus.Listener, GpsStatus.NmeaListener, LocationListener
{
  final de a;
  int b = 1024;
  volatile boolean c;
  volatile long d = 0L;
  boolean e;
  HandlerThread f;
  Runnable g;
  Handler h;
  private long i = 0L;
  private volatile boolean j = false;
  private volatile boolean k = false;
  private volatile Location l;
  private Location m;
  private boolean n = false;
  private boolean o = false;
  private GpsStatus p;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private ArrayList<Float> t = new ArrayList();
  private volatile boolean u = true;
  private dj v;
  private dr w;
  private final double[] x = new double[2];
  
  public dr(de paramde)
  {
    this.a = paramde;
    this.m = new Location("gps");
    this.v = dj.a();
    this.g = new Runnable()
    {
      public final void run()
      {
        for (;;)
        {
          try
          {
            Bundle localBundle = new Bundle();
            dr.a(dr.this).h.sendExtraCommand("gps", "force_xtra_injection", localBundle);
            dr.a(dr.this).h.sendExtraCommand("gps", "force_time_injection", localBundle);
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              bool2 = dr.a(dr.this).h.addNmeaListener(dr.b(dr.this));
              try
              {
                bool1 = dr.a(dr.this).h.addGpsStatusListener(dr.b(dr.this));
              }
              catch (Throwable localThrowable3)
              {
                boolean bool1 = true;
              }
              try
              {
                dr.a(dr.this).h.requestLocationUpdates("gps", 1000L, 0.0F, dr.b(dr.this), dr.c(dr.this).getLooper());
                if ((!bool2) && (!bool1))
                {
                  er.a = true;
                  dr.d(dr.this);
                }
                return;
              }
              catch (Throwable localThrowable4)
              {
                break label175;
              }
              localThrowable1 = localThrowable1;
              ev.b("TxGpsProvider", localThrowable1.toString());
              continue;
            }
            catch (Throwable localThrowable2)
            {
              ev.b("TxGpsProvider", localThrowable2.toString());
              boolean bool2 = true;
              continue;
            }
          }
          label175:
          ev.b("TxGpsProvider", localThrowable3.toString());
        }
      }
    };
    this.w = this;
  }
  
  private static double a(String paramString)
  {
    double d1 = Double.parseDouble(paramString);
    double d2 = (int)Math.floor(d1 / 100.0D);
    return (d1 - 100.0D * d2) / 60.0D + d2;
  }
  
  @SuppressLint({"NewApi"})
  private int a(Location paramLocation)
  {
    int i2 = 1;
    try
    {
      if (!this.a.h.isProviderEnabled("gps")) {
        return 1;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        boolean bool = paramLocation.isFromMockProvider();
        i1 = i2;
        if (bool) {
          return i1;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ev.a("TxGpsProvider", 6, localThrowable.toString());
      }
      if (this.m == null) {
        break label164;
      }
      float f1 = paramLocation.distanceTo(this.m);
      if ((f1 <= 100.0F) || (this.u)) {
        break label164;
      }
      ev.a("TxGpsProvider", 6, "Distance:".concat(String.valueOf(f1)));
      return 3;
      i1 = 0;
    }
    int i1 = i2;
    if (b(paramLocation)) {
      if ((!this.u) && (this.a.b.q > 0) && (System.currentTimeMillis() - this.d > 120000L))
      {
        ev.a("TxGpsProvider", 6, "indoor,but has location,mock!!");
        return 2;
      }
    }
    label164:
    return i1;
  }
  
  private static void a(Location paramLocation, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    Bundle localBundle2 = paramLocation.getExtras();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putDouble("lat", paramDouble1);
    localBundle1.putDouble("lng", paramDouble2);
    localBundle1.putInt("rssi", paramInt1);
    localBundle1.putInt("fakeCode", paramInt2);
    paramLocation.setExtras(localBundle1);
  }
  
  private void a(Location paramLocation, int paramInt)
  {
    int i1 = 3;
    int i2;
    if (this.r == 3)
    {
      i1 = 1;
      if ((!this.e) || (!es.a(paramLocation.getLatitude(), paramLocation.getLongitude()))) {
        break label146;
      }
      i2 = 1;
      label36:
      if (i2 == 0) {
        break label152;
      }
      ev.a("TxGpsProvider", 4, "notifyListeners: local deflect");
      ev.a(paramLocation, this.x);
      a(paramLocation, this.x[0], this.x[1], i1, paramInt);
    }
    for (;;)
    {
      paramLocation = new ef(paramLocation, this.i, this.q, this.r, this.b);
      this.a.b(paramLocation);
      return;
      if ((this.r >= 4) && (this.r <= 6))
      {
        i1 = 2;
        break;
      }
      if (this.r >= 7) {
        break;
      }
      i1 = 0;
      break;
      label146:
      i2 = 0;
      break label36;
      label152:
      a(paramLocation, paramLocation.getLatitude(), paramLocation.getLongitude(), i1, paramInt);
    }
  }
  
  private static boolean a(double paramDouble)
  {
    return Math.abs(Double.valueOf(paramDouble).longValue() - paramDouble) < 4.9E-324D;
  }
  
  @SuppressLint({"NewApi"})
  private boolean b(Location paramLocation)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      try
      {
        long l1 = paramLocation.getElapsedRealtimeNanos();
        if (l1 == 0L) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        ev.a("TxGpsProvider", "isComplete: ", localThrowable);
      }
    }
    if ((this.a.b.q > 0) && (paramLocation.getSpeed() == 0.0F) && (paramLocation.getBearing() == 0.0F))
    {
      ev.a("TxGpsProvider", 6, "txy fake");
      return false;
    }
    return true;
  }
  
  /* Error */
  private void c(Location paramLocation)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +47 -> 50
    //   6: ldc 90
    //   8: aload_1
    //   9: invokevirtual 294	android/location/Location:getProvider	()Ljava/lang/String;
    //   12: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +35 -> 50
    //   18: aload_1
    //   19: invokevirtual 301	android/location/Location:getAccuracy	()F
    //   22: ldc_w 302
    //   25: fcmpl
    //   26: ifgt +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 301	android/location/Location:getAccuracy	()F
    //   33: fstore 6
    //   35: fload 6
    //   37: fconst_0
    //   38: fcmpg
    //   39: ifge +14 -> 53
    //   42: iconst_0
    //   43: istore 7
    //   45: iload 7
    //   47: ifne +195 -> 242
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_1
    //   54: invokevirtual 234	android/location/Location:getLatitude	()D
    //   57: bipush 6
    //   59: invokestatic 305	c/t/m/g/ev:a	(DI)D
    //   62: dstore_2
    //   63: aload_1
    //   64: invokevirtual 237	android/location/Location:getLongitude	()D
    //   67: bipush 6
    //   69: invokestatic 305	c/t/m/g/ev:a	(DI)D
    //   72: dstore 4
    //   74: ldc 171
    //   76: new 307	java/lang/StringBuilder
    //   79: dup
    //   80: ldc_w 309
    //   83: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: dload_2
    //   87: invokevirtual 314	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   90: ldc_w 316
    //   93: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: dload 4
    //   98: invokevirtual 314	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   101: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 323	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: dload_2
    //   108: invokestatic 325	c/t/m/g/dr:a	(D)Z
    //   111: ifeq +184 -> 295
    //   114: dload 4
    //   116: invokestatic 325	c/t/m/g/dr:a	(D)Z
    //   119: ifeq +176 -> 295
    //   122: iconst_0
    //   123: istore 7
    //   125: goto -80 -> 45
    //   128: dload_2
    //   129: invokestatic 267	java/lang/Math:abs	(D)D
    //   132: ldc2_w 326
    //   135: dcmpg
    //   136: iflt +194 -> 330
    //   139: dload 4
    //   141: invokestatic 267	java/lang/Math:abs	(D)D
    //   144: ldc2_w 326
    //   147: dcmpg
    //   148: ifge +6 -> 154
    //   151: goto +179 -> 330
    //   154: dload_2
    //   155: dconst_1
    //   156: dsub
    //   157: invokestatic 267	java/lang/Math:abs	(D)D
    //   160: ldc2_w 326
    //   163: dcmpg
    //   164: iflt +172 -> 336
    //   167: dload 4
    //   169: dconst_1
    //   170: dsub
    //   171: invokestatic 267	java/lang/Math:abs	(D)D
    //   174: ldc2_w 326
    //   177: dcmpg
    //   178: ifge +164 -> 342
    //   181: goto +155 -> 336
    //   184: aload_1
    //   185: invokevirtual 330	android/location/Location:getTime	()J
    //   188: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   191: lsub
    //   192: invokestatic 333	java/lang/Math:abs	(J)J
    //   195: ldc2_w 334
    //   198: lcmp
    //   199: ifle +183 -> 382
    //   202: ldc 171
    //   204: new 307	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 337
    //   211: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: invokevirtual 330	android/location/Location:getTime	()J
    //   218: invokevirtual 340	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: ldc_w 342
    //   224: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   230: invokevirtual 340	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 323	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto +143 -> 382
    //   242: aload_0
    //   243: invokespecial 344	c/t/m/g/dr:e	()V
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 63	c/t/m/g/dr:b	I
    //   251: iconst_2
    //   252: ior
    //   253: putfield 63	c/t/m/g/dr:b	I
    //   256: aload_0
    //   257: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   260: putfield 57	c/t/m/g/dr:i	J
    //   263: aload_0
    //   264: aload_1
    //   265: aload_0
    //   266: aload_1
    //   267: invokespecial 346	c/t/m/g/dr:a	(Landroid/location/Location;)I
    //   270: invokespecial 348	c/t/m/g/dr:a	(Landroid/location/Location;I)V
    //   273: aload_0
    //   274: iconst_0
    //   275: putfield 61	c/t/m/g/dr:k	Z
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 350	c/t/m/g/dr:l	Landroid/location/Location;
    //   283: goto -233 -> 50
    //   286: astore_1
    //   287: aload_0
    //   288: monitorexit
    //   289: aload_1
    //   290: athrow
    //   291: astore_1
    //   292: goto -19 -> 273
    //   295: ldc2_w 351
    //   298: dload_2
    //   299: dmul
    //   300: ldc2_w 353
    //   303: drem
    //   304: dconst_0
    //   305: dcmpl
    //   306: ifne -178 -> 128
    //   309: ldc2_w 351
    //   312: dload 4
    //   314: dmul
    //   315: ldc2_w 353
    //   318: drem
    //   319: dconst_0
    //   320: dcmpl
    //   321: ifne -193 -> 128
    //   324: iconst_0
    //   325: istore 7
    //   327: goto -282 -> 45
    //   330: iconst_0
    //   331: istore 7
    //   333: goto -288 -> 45
    //   336: iconst_0
    //   337: istore 7
    //   339: goto -294 -> 45
    //   342: dload_2
    //   343: ldc2_w 355
    //   346: dcmpg
    //   347: iflt +29 -> 376
    //   350: dload_2
    //   351: ldc2_w 357
    //   354: dcmpl
    //   355: ifgt +21 -> 376
    //   358: dload 4
    //   360: ldc2_w 359
    //   363: dcmpg
    //   364: iflt +12 -> 376
    //   367: dload 4
    //   369: ldc2_w 361
    //   372: dcmpl
    //   373: ifle -189 -> 184
    //   376: iconst_0
    //   377: istore 7
    //   379: goto -334 -> 45
    //   382: iconst_1
    //   383: istore 7
    //   385: goto -340 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	dr
    //   0	388	1	paramLocation	Location
    //   62	289	2	d1	double
    //   72	296	4	d2	double
    //   33	3	6	f1	float
    //   43	341	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   6	35	286	finally
    //   53	122	286	finally
    //   128	151	286	finally
    //   154	181	286	finally
    //   184	239	286	finally
    //   242	273	286	finally
    //   273	283	286	finally
    //   6	35	291	java/lang/Throwable
    //   53	122	291	java/lang/Throwable
    //   128	151	291	java/lang/Throwable
    //   154	181	291	java/lang/Throwable
    //   184	239	291	java/lang/Throwable
    //   242	273	291	java/lang/Throwable
  }
  
  private void e()
  {
    this.s = 0;
    this.r = 0;
    this.q = 0;
    Object localObject = this.p;
    if (localObject == null) {}
    for (;;)
    {
      return;
      this.t.clear();
      this.s = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
      if (localObject != null) {
        while ((((Iterator)localObject).hasNext()) && (this.q <= this.s))
        {
          GpsSatellite localGpsSatellite = (GpsSatellite)((Iterator)localObject).next();
          this.q += 1;
          this.t.add(Float.valueOf(localGpsSatellite.getSnr()));
          if (localGpsSatellite.usedInFix()) {
            this.r += 1;
          }
        }
      }
    }
  }
  
  public final void a()
  {
    if (!this.c) {
      return;
    }
    this.c = false;
    this.i = 0L;
    this.b = 1024;
    this.n = false;
    this.o = false;
    this.s = 0;
    this.r = 0;
    this.q = 0;
    this.t.clear();
    this.e = false;
    Arrays.fill(this.x, 0.0D);
    LocationManager localLocationManager = this.a.h;
    try
    {
      localLocationManager.removeGpsStatusListener(this);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localLocationManager.removeUpdates(this);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localLocationManager.removeNmeaListener(this);
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            for (;;)
            {
              this.h.removeCallbacksAndMessages(null);
              this.f.quit();
              this.j = false;
              this.k = false;
              ev.a("TxGpsProvider", 4, "shutdown: state=[shutdown]");
              return;
              localThrowable3 = localThrowable3;
              ev.a("TxGpsProvider", 6, localThrowable3.toString());
              continue;
              localThrowable4 = localThrowable4;
              ev.a("TxGpsProvider", 6, localThrowable4.toString());
              continue;
              localThrowable1 = localThrowable1;
              ev.a("TxGpsProvider", 6, localThrowable1.toString());
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              ev.a("TxGpsProvider", 6, localThrowable2.toString());
            }
          }
        }
      }
    }
  }
  
  public final boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.b & 0x2) == 2)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - this.i < dq.a().b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean c()
  {
    LocationManager localLocationManager = this.a.h;
    try
    {
      boolean bool = localLocationManager.isProviderEnabled("gps");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ev.a("TxGpsProvider", 6, localThrowable.toString());
    }
    return false;
  }
  
  final void d()
  {
    int i1;
    if (this.b == 4) {
      i1 = 1;
    }
    for (;;)
    {
      if (er.a) {
        i1 = 5;
      }
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12002;
      localMessage.arg2 = i1;
      this.a.b(localMessage);
      return;
      if (this.b == 0) {
        i1 = 0;
      } else {
        i1 = -1;
      }
    }
  }
  
  /* Error */
  public final void onGpsStatusChanged(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+31 -> 32, 1:+32->33, 2:+43->44, 3:+49->50, 4:+60->61
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 63	c/t/m/g/dr:b	I
    //   38: iconst_1
    //   39: ior
    //   40: putfield 63	c/t/m/g/dr:b	I
    //   43: return
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 63	c/t/m/g/dr:b	I
    //   49: return
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 63	c/t/m/g/dr:b	I
    //   55: iconst_2
    //   56: ior
    //   57: putfield 63	c/t/m/g/dr:b	I
    //   60: return
    //   61: aload_0
    //   62: getfield 86	c/t/m/g/dr:a	Lc/t/m/g/de;
    //   65: getfield 137	c/t/m/g/de:h	Landroid/location/LocationManager;
    //   68: astore 4
    //   70: aload_0
    //   71: getfield 366	c/t/m/g/dr:p	Landroid/location/GpsStatus;
    //   74: ifnonnull +184 -> 258
    //   77: aload_0
    //   78: aload 4
    //   80: aconst_null
    //   81: invokevirtual 475	android/location/LocationManager:getGpsStatus	(Landroid/location/GpsStatus;)Landroid/location/GpsStatus;
    //   84: putfield 366	c/t/m/g/dr:p	Landroid/location/GpsStatus;
    //   87: aload_0
    //   88: invokespecial 344	c/t/m/g/dr:e	()V
    //   91: aload_0
    //   92: getfield 69	c/t/m/g/dr:q	I
    //   95: istore_1
    //   96: aload_0
    //   97: getfield 71	c/t/m/g/dr:r	I
    //   100: istore_3
    //   101: iload_1
    //   102: ifle +8 -> 110
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield 67	c/t/m/g/dr:o	Z
    //   110: iload_3
    //   111: ifle +8 -> 119
    //   114: aload_0
    //   115: iconst_1
    //   116: putfield 65	c/t/m/g/dr:n	Z
    //   119: aload_0
    //   120: getfield 366	c/t/m/g/dr:p	Landroid/location/GpsStatus;
    //   123: ifnull +636 -> 759
    //   126: aload_0
    //   127: getfield 78	c/t/m/g/dr:t	Ljava/util/ArrayList;
    //   130: ifnull +629 -> 759
    //   133: aload_0
    //   134: getfield 78	c/t/m/g/dr:t	Ljava/util/ArrayList;
    //   137: invokevirtual 478	java/util/ArrayList:size	()I
    //   140: ifle +619 -> 759
    //   143: aload_0
    //   144: getfield 102	c/t/m/g/dr:v	Lc/t/m/g/dj;
    //   147: astore 4
    //   149: aload_0
    //   150: getfield 78	c/t/m/g/dr:t	Ljava/util/ArrayList;
    //   153: astore 7
    //   155: aload_0
    //   156: getfield 69	c/t/m/g/dr:q	I
    //   159: istore_1
    //   160: new 307	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 479	java/lang/StringBuilder:<init>	()V
    //   167: astore 5
    //   169: aload 5
    //   171: new 307	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 479	java/lang/StringBuilder:<init>	()V
    //   178: iload_1
    //   179: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc_w 484
    //   185: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 7
    //   197: invokeinterface 487 1 0
    //   202: iconst_5
    //   203: if_icmplt +523 -> 726
    //   206: aload 7
    //   208: invokeinterface 487 1 0
    //   213: newarray float
    //   215: astore 6
    //   217: iconst_0
    //   218: istore_1
    //   219: iload_1
    //   220: aload 6
    //   222: arraylength
    //   223: if_icmpge +62 -> 285
    //   226: aload 7
    //   228: iload_1
    //   229: invokeinterface 491 2 0
    //   234: checkcast 401	java/lang/Float
    //   237: astore 8
    //   239: aload 8
    //   241: ifnonnull +35 -> 276
    //   244: fconst_0
    //   245: fstore_2
    //   246: aload 6
    //   248: iload_1
    //   249: fload_2
    //   250: fastore
    //   251: iload_1
    //   252: iconst_1
    //   253: iadd
    //   254: istore_1
    //   255: goto -36 -> 219
    //   258: aload 4
    //   260: aload_0
    //   261: getfield 366	c/t/m/g/dr:p	Landroid/location/GpsStatus;
    //   264: invokevirtual 475	android/location/LocationManager:getGpsStatus	(Landroid/location/GpsStatus;)Landroid/location/GpsStatus;
    //   267: pop
    //   268: goto -181 -> 87
    //   271: astore 4
    //   273: goto -186 -> 87
    //   276: aload 8
    //   278: invokevirtual 494	java/lang/Float:floatValue	()F
    //   281: fstore_2
    //   282: goto -36 -> 246
    //   285: aload 6
    //   287: invokestatic 498	java/util/Arrays:sort	([F)V
    //   290: iconst_5
    //   291: newarray float
    //   293: astore 7
    //   295: fconst_0
    //   296: fstore_2
    //   297: iconst_0
    //   298: istore_1
    //   299: iload_1
    //   300: iconst_5
    //   301: if_icmpge +31 -> 332
    //   304: aload 7
    //   306: iload_1
    //   307: aload 6
    //   309: aload 6
    //   311: arraylength
    //   312: iconst_1
    //   313: isub
    //   314: iload_1
    //   315: isub
    //   316: faload
    //   317: fastore
    //   318: fload_2
    //   319: aload 7
    //   321: iload_1
    //   322: faload
    //   323: fadd
    //   324: fstore_2
    //   325: iload_1
    //   326: iconst_1
    //   327: iadd
    //   328: istore_1
    //   329: goto -30 -> 299
    //   332: fload_2
    //   333: ldc_w 499
    //   336: fdiv
    //   337: fstore_2
    //   338: aload 5
    //   340: ldc_w 501
    //   343: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 5
    //   349: ldc_w 503
    //   352: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 7
    //   358: iconst_0
    //   359: faload
    //   360: ldc_w 504
    //   363: fcmpl
    //   364: ifle +445 -> 809
    //   367: aload 4
    //   369: iconst_1
    //   370: putfield 506	c/t/m/g/dj:d	Z
    //   373: aload 5
    //   375: ldc_w 508
    //   378: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: fload_2
    //   383: ldc_w 509
    //   386: fcmpg
    //   387: ifge +18 -> 405
    //   390: aload 5
    //   392: ldc_w 511
    //   395: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 4
    //   401: iconst_0
    //   402: putfield 506	c/t/m/g/dj:d	Z
    //   405: aload 5
    //   407: ldc_w 513
    //   410: fload_2
    //   411: invokestatic 193	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   414: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   417: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 5
    //   423: new 307	java/lang/StringBuilder
    //   426: dup
    //   427: ldc_w 515
    //   430: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   433: fload_2
    //   434: aload 4
    //   436: getfield 518	c/t/m/g/dj:a	F
    //   439: fsub
    //   440: invokevirtual 521	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   443: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 5
    //   452: new 307	java/lang/StringBuilder
    //   455: dup
    //   456: ldc_w 523
    //   459: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   462: aload 4
    //   464: getfield 525	c/t/m/g/dj:b	F
    //   467: invokevirtual 521	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   470: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 5
    //   479: new 307	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 527
    //   486: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload 4
    //   491: getfield 529	c/t/m/g/dj:c	F
    //   494: invokevirtual 521	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   497: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 5
    //   506: aload 4
    //   508: getfield 506	c/t/m/g/dj:d	Z
    //   511: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 5
    //   517: ldc_w 501
    //   520: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 4
    //   526: getfield 525	c/t/m/g/dj:b	F
    //   529: fload_2
    //   530: fcmpg
    //   531: ifge +9 -> 540
    //   534: aload 4
    //   536: fload_2
    //   537: putfield 525	c/t/m/g/dj:b	F
    //   540: aload 4
    //   542: getfield 529	c/t/m/g/dj:c	F
    //   545: fload_2
    //   546: fcmpl
    //   547: ifle +9 -> 556
    //   550: aload 4
    //   552: fload_2
    //   553: putfield 529	c/t/m/g/dj:c	F
    //   556: aload 4
    //   558: fload_2
    //   559: putfield 518	c/t/m/g/dj:a	F
    //   562: aload 5
    //   564: ldc_w 534
    //   567: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: fload_2
    //   572: aload 4
    //   574: getfield 518	c/t/m/g/dj:a	F
    //   577: fsub
    //   578: ldc_w 535
    //   581: fcmpl
    //   582: ifle +12 -> 594
    //   585: aload 5
    //   587: ldc_w 537
    //   590: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 4
    //   596: getfield 518	c/t/m/g/dj:a	F
    //   599: fload_2
    //   600: fsub
    //   601: fconst_2
    //   602: fcmpl
    //   603: ifle +18 -> 621
    //   606: aload 5
    //   608: ldc_w 539
    //   611: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 4
    //   617: iconst_0
    //   618: putfield 540	c/t/m/g/dj:e	Z
    //   621: fload_2
    //   622: aload 4
    //   624: getfield 525	c/t/m/g/dj:b	F
    //   627: aload 4
    //   629: getfield 529	c/t/m/g/dj:c	F
    //   632: fadd
    //   633: fconst_2
    //   634: fdiv
    //   635: fcmpl
    //   636: ifle +214 -> 850
    //   639: aload 4
    //   641: iconst_1
    //   642: putfield 540	c/t/m/g/dj:e	Z
    //   645: aload 4
    //   647: getfield 506	c/t/m/g/dj:d	Z
    //   650: aload 4
    //   652: getfield 540	c/t/m/g/dj:e	Z
    //   655: if_icmpeq +44 -> 699
    //   658: aload 5
    //   660: new 307	java/lang/StringBuilder
    //   663: dup
    //   664: ldc_w 542
    //   667: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   670: aload 4
    //   672: getfield 506	c/t/m/g/dj:d	Z
    //   675: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: ldc_w 544
    //   681: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload 4
    //   686: getfield 540	c/t/m/g/dj:e	Z
    //   689: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   692: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 5
    //   701: new 307	java/lang/StringBuilder
    //   704: dup
    //   705: ldc_w 546
    //   708: invokespecial 310	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   711: aload 4
    //   713: getfield 540	c/t/m/g/dj:e	Z
    //   716: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   719: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 4
    //   728: aload 5
    //   730: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: putfield 549	c/t/m/g/dj:f	Ljava/lang/String;
    //   736: aload_0
    //   737: aload 4
    //   739: getfield 540	c/t/m/g/dj:e	Z
    //   742: putfield 80	c/t/m/g/dr:u	Z
    //   745: aload_0
    //   746: getfield 80	c/t/m/g/dr:u	Z
    //   749: ifeq +10 -> 759
    //   752: aload_0
    //   753: invokestatic 167	java/lang/System:currentTimeMillis	()J
    //   756: putfield 82	c/t/m/g/dr:d	J
    //   759: aload_0
    //   760: getfield 80	c/t/m/g/dr:u	Z
    //   763: ifeq +104 -> 867
    //   766: iconst_3
    //   767: istore_1
    //   768: new 457	android/os/Message
    //   771: dup
    //   772: invokespecial 458	android/os/Message:<init>	()V
    //   775: astore 4
    //   777: aload 4
    //   779: sipush 12999
    //   782: putfield 461	android/os/Message:what	I
    //   785: aload 4
    //   787: sipush 12004
    //   790: putfield 464	android/os/Message:arg1	I
    //   793: aload 4
    //   795: iload_1
    //   796: putfield 467	android/os/Message:arg2	I
    //   799: aload_0
    //   800: getfield 86	c/t/m/g/dr:a	Lc/t/m/g/de;
    //   803: aload 4
    //   805: invokevirtual 257	c/t/m/g/de:b	(Ljava/lang/Object;)V
    //   808: return
    //   809: fload_2
    //   810: ldc_w 550
    //   813: fcmpl
    //   814: ifle -432 -> 382
    //   817: aload 4
    //   819: iconst_1
    //   820: putfield 506	c/t/m/g/dj:d	Z
    //   823: aload 5
    //   825: ldc_w 508
    //   828: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: goto -450 -> 382
    //   835: astore 4
    //   837: ldc 171
    //   839: ldc_w 552
    //   842: aload 4
    //   844: invokestatic 278	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   847: goto -88 -> 759
    //   850: fload_2
    //   851: ldc_w 509
    //   854: fcmpg
    //   855: ifge -210 -> 645
    //   858: aload 4
    //   860: iconst_0
    //   861: putfield 540	c/t/m/g/dj:e	Z
    //   864: goto -219 -> 645
    //   867: iconst_4
    //   868: istore_1
    //   869: goto -101 -> 768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	872	0	this	dr
    //   0	872	1	paramInt	int
    //   245	606	2	f1	float
    //   100	11	3	i1	int
    //   68	191	4	localObject1	Object
    //   271	467	4	localException	java.lang.Exception
    //   775	43	4	localMessage	Message
    //   835	24	4	localThrowable	Throwable
    //   167	657	5	localStringBuilder	java.lang.StringBuilder
    //   215	95	6	arrayOfFloat	float[]
    //   153	204	7	localObject2	Object
    //   237	40	8	localFloat	Float
    // Exception table:
    //   from	to	target	type
    //   70	87	271	java/lang/Exception
    //   258	268	271	java/lang/Exception
    //   143	217	835	java/lang/Throwable
    //   219	239	835	java/lang/Throwable
    //   276	282	835	java/lang/Throwable
    //   285	295	835	java/lang/Throwable
    //   304	318	835	java/lang/Throwable
    //   332	356	835	java/lang/Throwable
    //   367	382	835	java/lang/Throwable
    //   390	405	835	java/lang/Throwable
    //   405	540	835	java/lang/Throwable
    //   540	556	835	java/lang/Throwable
    //   556	594	835	java/lang/Throwable
    //   594	621	835	java/lang/Throwable
    //   621	645	835	java/lang/Throwable
    //   645	699	835	java/lang/Throwable
    //   699	726	835	java/lang/Throwable
    //   726	759	835	java/lang/Throwable
    //   817	832	835	java/lang/Throwable
    //   858	864	835	java/lang/Throwable
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    this.k = true;
    this.l = paramLocation;
    ev.b("TxGpsProvider", paramLocation.toString() + ",speed:" + paramLocation.getSpeed() + ",bearing:" + paramLocation.getBearing() + Thread.currentThread().getName());
    c(this.l);
  }
  
  public final void onNmeaReceived(long paramLong, String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 5)) {}
    for (;;)
    {
      return;
      int i1 = paramString.indexOf(",");
      Object localObject;
      if (i1 <= 0)
      {
        localObject = null;
        if ((localObject == null) || (((String)localObject).length() <= 5) || (((String)localObject).charAt(3) != 'R') || ((!"$GPRMC".equals(localObject)) && (!"$GNRMC".equals(localObject)) && (!"$BDRMC".equals(localObject)) && (!"$GLRMC".equals(localObject)))) {
          continue;
        }
        localObject = paramString.split(",");
        if (!"A".equals(localObject[2])) {
          continue;
        }
      }
      try
      {
        this.m.setLatitude(a(localObject[3]));
        this.m.setLongitude(a(localObject[5]));
        boolean bool = this.j;
        this.j = true;
        if (bool) {
          continue;
        }
        c(this.l);
        return;
        localObject = paramString.substring(0, i1).trim();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          ev.a("TxGpsProvider", "<" + paramString + ">", localNumberFormatException);
        }
      }
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      ev.a("TxGpsProvider", 4, "onProviderDisabled: gps is disabled");
      this.r = 0;
      this.q = 0;
      this.b = 0;
      this.n = false;
      this.i = 0L;
      d();
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      ev.a("TxGpsProvider", 4, "onProviderEnabled: gps is enabled");
      this.b = 4;
      d();
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dr
 * JD-Core Version:    0.7.0.1
 */