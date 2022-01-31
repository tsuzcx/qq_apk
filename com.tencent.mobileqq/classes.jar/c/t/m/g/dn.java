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

final class dn
  implements GpsStatus.Listener, GpsStatus.NmeaListener, LocationListener
{
  private long a = 0L;
  private final da b;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile Location e;
  private Location f;
  private int g = 1024;
  private boolean h = false;
  private boolean i = false;
  private GpsStatus j;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private ArrayList<Float> n = new ArrayList();
  private volatile boolean o;
  private volatile boolean p = true;
  private volatile long q = 0L;
  private boolean r;
  private HandlerThread s;
  private Runnable t;
  private dg u;
  private Handler v;
  private dn w;
  private final double[] x = new double[2];
  
  public dn(da paramda)
  {
    this.b = paramda;
    this.f = new Location("gps");
    this.u = dg.a();
    this.t = new Runnable()
    {
      public final void run()
      {
        try
        {
          Bundle localBundle = new Bundle();
          dn.a(dn.this).e().sendExtraCommand("gps", "force_xtra_injection", localBundle);
          dn.a(dn.this).e().sendExtraCommand("gps", "force_time_injection", localBundle);
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            for (;;)
            {
              dn.a(dn.this).e().addNmeaListener(dn.b(dn.this));
              try
              {
                dn.a(dn.this).e().addGpsStatusListener(dn.b(dn.this));
                dn.a(dn.this).e().requestLocationUpdates("gps", 1000L, 0.0F, dn.b(dn.this), dn.c(dn.this).getLooper());
                return;
              }
              catch (Throwable localThrowable3)
              {
                f.a.b("TxGpsProvider", localThrowable3.toString());
              }
              localThrowable1 = localThrowable1;
              f.a.b("TxGpsProvider", localThrowable1.toString());
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              f.a.b("TxGpsProvider", localThrowable2.toString());
            }
          }
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
      if (!this.b.e().isProviderEnabled("gps")) {
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
        f.a.b("TxGpsProvider", localThrowable.toString());
      }
      if (this.f == null) {
        break label165;
      }
      float f1 = paramLocation.distanceTo(this.f);
      if ((f1 <= 100.0F) || (this.p)) {
        break label165;
      }
      f.a.b("TxGpsProvider", "Distance:" + f1);
      return 3;
      i1 = 0;
    }
    int i1 = i2;
    if (b(paramLocation)) {
      if ((!this.p) && (this.b.i().n > 0) && (System.currentTimeMillis() - this.q > 120000L))
      {
        f.a.b("TxGpsProvider", "indoor,but has location,mock!!");
        return 2;
      }
    }
    label165:
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
        f.a.a("TxGpsProvider", "isComplete: ", localThrowable);
      }
    }
    if ((this.b.i().n > 0) && (paramLocation.getSpeed() == 0.0F) && (paramLocation.getBearing() == 0.0F))
    {
      f.a.b("TxGpsProvider", "txy fake");
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
    //   9: invokevirtual 266	android/location/Location:getProvider	()Ljava/lang/String;
    //   12: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +35 -> 50
    //   18: aload_1
    //   19: invokevirtual 275	android/location/Location:getAccuracy	()F
    //   22: ldc_w 276
    //   25: fcmpl
    //   26: ifgt +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 275	android/location/Location:getAccuracy	()F
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
    //   54: invokevirtual 280	android/location/Location:getLatitude	()D
    //   57: bipush 6
    //   59: invokestatic 283	c/t/m/g/f$a:a	(DI)D
    //   62: dstore_2
    //   63: aload_1
    //   64: invokevirtual 286	android/location/Location:getLongitude	()D
    //   67: bipush 6
    //   69: invokestatic 283	c/t/m/g/f$a:a	(DI)D
    //   72: dstore 4
    //   74: ldc 172
    //   76: new 190	java/lang/StringBuilder
    //   79: dup
    //   80: ldc_w 288
    //   83: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: dload_2
    //   87: invokevirtual 291	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   90: ldc_w 293
    //   93: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: dload 4
    //   98: invokevirtual 291	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   101: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 179	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: dload_2
    //   108: invokestatic 298	c/t/m/g/dn:a	(D)Z
    //   111: ifeq +360 -> 471
    //   114: dload 4
    //   116: invokestatic 298	c/t/m/g/dn:a	(D)Z
    //   119: ifeq +352 -> 471
    //   122: iconst_0
    //   123: istore 7
    //   125: goto -80 -> 45
    //   128: dload_2
    //   129: invokestatic 239	java/lang/Math:abs	(D)D
    //   132: ldc2_w 299
    //   135: dcmpg
    //   136: iflt +370 -> 506
    //   139: dload 4
    //   141: invokestatic 239	java/lang/Math:abs	(D)D
    //   144: ldc2_w 299
    //   147: dcmpg
    //   148: ifge +6 -> 154
    //   151: goto +355 -> 506
    //   154: dload_2
    //   155: dconst_1
    //   156: dsub
    //   157: invokestatic 239	java/lang/Math:abs	(D)D
    //   160: ldc2_w 299
    //   163: dcmpg
    //   164: iflt +348 -> 512
    //   167: dload 4
    //   169: dconst_1
    //   170: dsub
    //   171: invokestatic 239	java/lang/Math:abs	(D)D
    //   174: ldc2_w 299
    //   177: dcmpg
    //   178: ifge +340 -> 518
    //   181: goto +331 -> 512
    //   184: aload_1
    //   185: invokevirtual 303	android/location/Location:getTime	()J
    //   188: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   191: lsub
    //   192: invokestatic 306	java/lang/Math:abs	(J)J
    //   195: ldc2_w 307
    //   198: lcmp
    //   199: ifle +359 -> 558
    //   202: ldc 172
    //   204: new 190	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 310
    //   211: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: invokevirtual 303	android/location/Location:getTime	()J
    //   218: invokevirtual 313	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: ldc_w 315
    //   224: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   230: invokevirtual 313	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 179	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto +319 -> 558
    //   242: aload_0
    //   243: invokespecial 317	c/t/m/g/dn:e	()V
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 63	c/t/m/g/dn:g	I
    //   251: iconst_2
    //   252: ior
    //   253: putfield 63	c/t/m/g/dn:g	I
    //   256: aload_0
    //   257: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   260: putfield 57	c/t/m/g/dn:a	J
    //   263: aload_0
    //   264: getfield 86	c/t/m/g/dn:b	Lc/t/m/g/da;
    //   267: getfield 320	c/t/m/g/da:a	Landroid/content/Context;
    //   270: astore 10
    //   272: aload_0
    //   273: aload_1
    //   274: invokespecial 322	c/t/m/g/dn:a	(Landroid/location/Location;)I
    //   277: istore 9
    //   279: iconst_0
    //   280: istore 7
    //   282: aload_0
    //   283: getfield 71	c/t/m/g/dn:l	I
    //   286: iconst_3
    //   287: if_icmpne +123 -> 410
    //   290: iconst_1
    //   291: istore 7
    //   293: aload_0
    //   294: getfield 324	c/t/m/g/dn:r	Z
    //   297: ifeq +267 -> 564
    //   300: aload_1
    //   301: invokevirtual 280	android/location/Location:getLatitude	()D
    //   304: aload_1
    //   305: invokevirtual 286	android/location/Location:getLongitude	()D
    //   308: invokestatic 329	c/t/m/g/eo:a	(DD)Z
    //   311: ifeq +253 -> 564
    //   314: iconst_1
    //   315: istore 8
    //   317: iload 8
    //   319: ifeq +129 -> 448
    //   322: ldc 172
    //   324: ldc_w 331
    //   327: invokestatic 333	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_1
    //   331: aload_0
    //   332: getfield 84	c/t/m/g/dn:x	[D
    //   335: invokestatic 336	c/t/m/g/f$a:a	(Landroid/location/Location;[D)Z
    //   338: pop
    //   339: aload_1
    //   340: aload_0
    //   341: getfield 84	c/t/m/g/dn:x	[D
    //   344: iconst_0
    //   345: daload
    //   346: aload_0
    //   347: getfield 84	c/t/m/g/dn:x	[D
    //   350: iconst_1
    //   351: daload
    //   352: iload 7
    //   354: iload 9
    //   356: invokestatic 338	c/t/m/g/dn:a	(Landroid/location/Location;DDII)V
    //   359: new 340	c/t/m/g/eb
    //   362: dup
    //   363: aload_1
    //   364: aload_0
    //   365: getfield 57	c/t/m/g/dn:a	J
    //   368: aload_0
    //   369: getfield 69	c/t/m/g/dn:k	I
    //   372: aload_0
    //   373: getfield 71	c/t/m/g/dn:l	I
    //   376: aload_0
    //   377: getfield 63	c/t/m/g/dn:g	I
    //   380: invokespecial 343	c/t/m/g/eb:<init>	(Landroid/location/Location;JIII)V
    //   383: astore_1
    //   384: aload_0
    //   385: getfield 86	c/t/m/g/dn:b	Lc/t/m/g/da;
    //   388: aload_1
    //   389: invokevirtual 346	c/t/m/g/da:b	(Ljava/lang/Object;)V
    //   392: aload_0
    //   393: iconst_0
    //   394: putfield 61	c/t/m/g/dn:d	Z
    //   397: aload_0
    //   398: aconst_null
    //   399: putfield 348	c/t/m/g/dn:e	Landroid/location/Location;
    //   402: goto -352 -> 50
    //   405: astore_1
    //   406: aload_0
    //   407: monitorexit
    //   408: aload_1
    //   409: athrow
    //   410: aload_0
    //   411: getfield 71	c/t/m/g/dn:l	I
    //   414: iconst_4
    //   415: if_icmplt +18 -> 433
    //   418: aload_0
    //   419: getfield 71	c/t/m/g/dn:l	I
    //   422: bipush 6
    //   424: if_icmpgt +9 -> 433
    //   427: iconst_2
    //   428: istore 7
    //   430: goto -137 -> 293
    //   433: aload_0
    //   434: getfield 71	c/t/m/g/dn:l	I
    //   437: bipush 7
    //   439: if_icmplt -146 -> 293
    //   442: iconst_3
    //   443: istore 7
    //   445: goto -152 -> 293
    //   448: aload_1
    //   449: aload_1
    //   450: invokevirtual 280	android/location/Location:getLatitude	()D
    //   453: aload_1
    //   454: invokevirtual 286	android/location/Location:getLongitude	()D
    //   457: iload 7
    //   459: iload 9
    //   461: invokestatic 338	c/t/m/g/dn:a	(Landroid/location/Location;DDII)V
    //   464: goto -105 -> 359
    //   467: astore_1
    //   468: goto -76 -> 392
    //   471: ldc2_w 349
    //   474: dload_2
    //   475: dmul
    //   476: ldc2_w 351
    //   479: drem
    //   480: dconst_0
    //   481: dcmpl
    //   482: ifne -354 -> 128
    //   485: ldc2_w 349
    //   488: dload 4
    //   490: dmul
    //   491: ldc2_w 351
    //   494: drem
    //   495: dconst_0
    //   496: dcmpl
    //   497: ifne -369 -> 128
    //   500: iconst_0
    //   501: istore 7
    //   503: goto -458 -> 45
    //   506: iconst_0
    //   507: istore 7
    //   509: goto -464 -> 45
    //   512: iconst_0
    //   513: istore 7
    //   515: goto -470 -> 45
    //   518: dload_2
    //   519: ldc2_w 353
    //   522: dcmpg
    //   523: iflt +29 -> 552
    //   526: dload_2
    //   527: ldc2_w 355
    //   530: dcmpl
    //   531: ifgt +21 -> 552
    //   534: dload 4
    //   536: ldc2_w 357
    //   539: dcmpg
    //   540: iflt +12 -> 552
    //   543: dload 4
    //   545: ldc2_w 359
    //   548: dcmpl
    //   549: ifle -365 -> 184
    //   552: iconst_0
    //   553: istore 7
    //   555: goto -510 -> 45
    //   558: iconst_1
    //   559: istore 7
    //   561: goto -516 -> 45
    //   564: iconst_0
    //   565: istore 8
    //   567: goto -250 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	dn
    //   0	570	1	paramLocation	Location
    //   62	465	2	d1	double
    //   72	472	4	d2	double
    //   33	3	6	f1	float
    //   43	517	7	i1	int
    //   315	251	8	i2	int
    //   277	183	9	i3	int
    //   270	1	10	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   6	35	405	finally
    //   53	122	405	finally
    //   128	151	405	finally
    //   154	181	405	finally
    //   184	239	405	finally
    //   242	279	405	finally
    //   282	290	405	finally
    //   293	314	405	finally
    //   322	359	405	finally
    //   359	392	405	finally
    //   392	402	405	finally
    //   410	427	405	finally
    //   433	442	405	finally
    //   448	464	405	finally
    //   6	35	467	java/lang/Throwable
    //   53	122	467	java/lang/Throwable
    //   128	151	467	java/lang/Throwable
    //   154	181	467	java/lang/Throwable
    //   184	239	467	java/lang/Throwable
    //   242	279	467	java/lang/Throwable
    //   282	290	467	java/lang/Throwable
    //   293	314	467	java/lang/Throwable
    //   322	359	467	java/lang/Throwable
    //   359	392	467	java/lang/Throwable
    //   410	427	467	java/lang/Throwable
    //   433	442	467	java/lang/Throwable
    //   448	464	467	java/lang/Throwable
  }
  
  private void d()
  {
    int i1;
    if (this.g == 4) {
      i1 = 1;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12002;
      localMessage.arg2 = i1;
      this.b.b(localMessage);
      return;
      if (this.g == 0) {
        i1 = 0;
      } else {
        i1 = -1;
      }
    }
  }
  
  private void e()
  {
    this.m = 0;
    this.l = 0;
    this.k = 0;
    Object localObject = this.j;
    if (localObject == null) {}
    for (;;)
    {
      return;
      this.n.clear();
      this.m = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
      if (localObject != null) {
        while ((((Iterator)localObject).hasNext()) && (this.k <= this.m))
        {
          GpsSatellite localGpsSatellite = (GpsSatellite)((Iterator)localObject).next();
          this.k += 1;
          this.n.add(Float.valueOf(localGpsSatellite.getSnr()));
          if (localGpsSatellite.usedInFix()) {
            this.l += 1;
          }
        }
      }
    }
  }
  
  public final void a()
  {
    if (!this.o) {
      return;
    }
    this.o = false;
    this.a = 0L;
    this.g = 1024;
    this.h = false;
    this.i = false;
    this.m = 0;
    this.l = 0;
    this.k = 0;
    this.n.clear();
    this.r = false;
    Arrays.fill(this.x, 0.0D);
    LocationManager localLocationManager = this.b.e();
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
              this.v.removeCallbacksAndMessages(null);
              this.s.quit();
              this.c = false;
              this.d = false;
              f.a.a("TxGpsProvider", "shutdown: state=[shutdown]");
              return;
              localThrowable3 = localThrowable3;
              f.a.b("TxGpsProvider", localThrowable3.toString());
              continue;
              localThrowable4 = localThrowable4;
              f.a.b("TxGpsProvider", localThrowable4.toString());
              continue;
              localThrowable1 = localThrowable1;
              f.a.b("TxGpsProvider", localThrowable1.toString());
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              f.a.b("TxGpsProvider", localThrowable2.toString());
            }
          }
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.o) {
      return;
    }
    this.o = true;
    this.s = new HandlerThread("gps_provider");
    LocationManager localLocationManager = this.b.e();
    this.s.start();
    this.v = new Handler(this.s.getLooper());
    if (!paramBoolean) {}
    try
    {
      this.v.post(this.t);
      this.q = System.currentTimeMillis();
      for (;;)
      {
        if (c())
        {
          this.g = 4;
          d();
        }
        f.a.a("TxGpsProvider", "startup: state=[start]");
        return;
        localLocationManager.requestLocationUpdates("passive", 5000L, 0.0F, this, this.s.getLooper());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        en.a = true;
        f.a.a("TxGpsProvider", "startup: can not add location listener", localException);
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public final boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.g & 0x2) == 2)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - this.a < dm.a().b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean c()
  {
    LocationManager localLocationManager = this.b.e();
    try
    {
      boolean bool = localLocationManager.isProviderEnabled("gps");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      f.a.b("TxGpsProvider", localThrowable.toString());
    }
    return false;
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.g |= 0x1;
      return;
    case 2: 
      this.g = 0;
      return;
    case 3: 
      this.g |= 0x2;
      return;
    }
    Object localObject = this.b.e();
    try
    {
      if (this.j == null)
      {
        this.j = ((LocationManager)localObject).getGpsStatus(null);
        e();
        paramInt = this.k;
        int i1 = this.l;
        if (paramInt > 0) {
          this.i = true;
        }
        if (i1 > 0) {
          this.h = true;
        }
        if ((!this.i) || (paramInt > 2)) {
          boolean bool = this.h;
        }
        if ((this.j == null) || (this.n == null) || (this.n.size() <= 0)) {}
      }
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          this.p = this.u.a(this.n, this.k);
          if (this.p) {
            this.q = System.currentTimeMillis();
          }
          if (!this.p) {
            break;
          }
          paramInt = 3;
          localObject = new Message();
          ((Message)localObject).what = 12999;
          ((Message)localObject).arg1 = 12004;
          ((Message)localObject).arg2 = paramInt;
          this.b.b(localObject);
          return;
          ((LocationManager)localObject).getGpsStatus(this.j);
        }
        localException = localException;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          f.a.a("TxGpsProvider", "judgeIO Error!", localThrowable);
          continue;
          paramInt = 4;
        }
      }
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    this.d = true;
    this.e = paramLocation;
    f.a.b("TxGpsProvider", paramLocation.toString() + ",speed:" + paramLocation.getSpeed() + ",bearing:" + paramLocation.getBearing() + Thread.currentThread().getName());
    c(this.e);
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
        this.f.setLatitude(a(localObject[3]));
        this.f.setLongitude(a(localObject[5]));
        boolean bool = this.c;
        this.c = true;
        if (bool) {
          continue;
        }
        c(this.e);
        return;
        localObject = paramString.substring(0, i1).trim();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          f.a.a("TxGpsProvider", "<" + paramString + ">", localNumberFormatException);
        }
      }
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      f.a.a("TxGpsProvider", "onProviderDisabled: gps is disabled");
      this.l = 0;
      this.k = 0;
      this.g = 0;
      this.h = false;
      this.a = 0L;
      d();
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      f.a.a("TxGpsProvider", "onProviderEnabled: gps is enabled");
      this.g = 4;
      d();
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dn
 * JD-Core Version:    0.7.0.1
 */