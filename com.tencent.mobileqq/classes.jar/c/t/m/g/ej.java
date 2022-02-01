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
import java.util.List;

final class ej
  implements GpsStatus.Listener, GpsStatus.NmeaListener, LocationListener
{
  long a = 0L;
  final ea b;
  int c = 1024;
  volatile boolean d;
  volatile long e = 0L;
  boolean f;
  HandlerThread g;
  Runnable h;
  Handler i;
  ej j;
  private volatile boolean k = false;
  private volatile boolean l = false;
  private volatile Location m;
  private Location n;
  private boolean o = false;
  private boolean p = false;
  private GpsStatus q;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private ArrayList<Float> u = new ArrayList();
  private volatile boolean v = true;
  private ed w;
  private final double[] x = new double[2];
  
  public ej(ea paramea)
  {
    this.b = paramea;
    this.n = new Location("gps");
    this.w = ed.a();
    this.h = new ej.1(this);
    this.j = this;
  }
  
  private static double a(String paramString)
  {
    double d2 = Double.parseDouble(paramString);
    double d1 = (int)Math.floor(d2 / 100.0D);
    Double.isNaN(d1);
    d2 = (d2 - 100.0D * d1) / 60.0D;
    Double.isNaN(d1);
    return d1 + d2;
  }
  
  @SuppressLint({"NewApi"})
  private int a(Location paramLocation)
  {
    try
    {
      if (!this.b.h.isProviderEnabled("gps")) {
        return 1;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        boolean bool = paramLocation.isFromMockProvider();
        if (bool) {
          return 1;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label36:
      Location localLocation;
      break label36;
    }
    if (!b(paramLocation)) {
      return 1;
    }
    if ((!this.v) && (this.b.b.o > 0) && (System.currentTimeMillis() - this.e > 120000L)) {
      return 2;
    }
    localLocation = this.n;
    if ((localLocation != null) && (paramLocation.distanceTo(localLocation) > 100.0F) && (!this.v)) {
      return 3;
    }
    return 0;
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
    double d1 = Double.valueOf(paramDouble).longValue();
    Double.isNaN(d1);
    return Math.abs(d1 - paramDouble) < 4.9E-324D;
  }
  
  @SuppressLint({"NewApi"})
  private boolean b(Location paramLocation)
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    try
    {
      long l1 = paramLocation.getElapsedRealtimeNanos();
      if (l1 == 0L) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      label21:
      break label21;
    }
    return (this.b.b.o <= 0) || (paramLocation.getSpeed() != 0.0F) || (paramLocation.getBearing() != 0.0F);
  }
  
  /* Error */
  private void c(Location paramLocation)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +446 -> 449
    //   6: ldc 88
    //   8: aload_1
    //   9: invokevirtual 237	android/location/Location:getProvider	()Ljava/lang/String;
    //   12: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +434 -> 449
    //   18: aload_1
    //   19: invokevirtual 246	android/location/Location:getAccuracy	()F
    //   22: ldc 247
    //   24: fcmpl
    //   25: ifgt +506 -> 531
    //   28: aload_1
    //   29: invokevirtual 246	android/location/Location:getAccuracy	()F
    //   32: fconst_0
    //   33: fcmpg
    //   34: ifge +6 -> 40
    //   37: goto +494 -> 531
    //   40: aload_1
    //   41: invokevirtual 251	android/location/Location:getLatitude	()D
    //   44: bipush 6
    //   46: invokestatic 256	c/t/m/g/fp:a	(DI)D
    //   49: dstore_2
    //   50: aload_1
    //   51: invokevirtual 259	android/location/Location:getLongitude	()D
    //   54: bipush 6
    //   56: invokestatic 256	c/t/m/g/fp:a	(DI)D
    //   59: dstore 4
    //   61: new 261	java/lang/StringBuilder
    //   64: dup
    //   65: ldc_w 263
    //   68: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: astore 9
    //   73: aload 9
    //   75: dload_2
    //   76: invokevirtual 268	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 9
    //   82: ldc_w 270
    //   85: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 9
    //   91: dload 4
    //   93: invokevirtual 268	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: dload_2
    //   98: invokestatic 275	c/t/m/g/ej:a	(D)Z
    //   101: ifeq +355 -> 456
    //   104: dload 4
    //   106: invokestatic 275	c/t/m/g/ej:a	(D)Z
    //   109: ifeq +347 -> 456
    //   112: goto +419 -> 531
    //   115: dload_2
    //   116: invokestatic 219	java/lang/Math:abs	(D)D
    //   119: ldc2_w 276
    //   122: dcmpg
    //   123: iflt +408 -> 531
    //   126: dload 4
    //   128: invokestatic 219	java/lang/Math:abs	(D)D
    //   131: ldc2_w 276
    //   134: dcmpg
    //   135: ifge +6 -> 141
    //   138: goto +393 -> 531
    //   141: dload_2
    //   142: dconst_1
    //   143: dsub
    //   144: invokestatic 219	java/lang/Math:abs	(D)D
    //   147: ldc2_w 276
    //   150: dcmpg
    //   151: iflt +380 -> 531
    //   154: dload 4
    //   156: dconst_1
    //   157: dsub
    //   158: invokestatic 219	java/lang/Math:abs	(D)D
    //   161: ldc2_w 276
    //   164: dcmpg
    //   165: ifge +323 -> 488
    //   168: goto +363 -> 531
    //   171: aload_1
    //   172: invokevirtual 280	android/location/Location:getTime	()J
    //   175: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   178: lsub
    //   179: invokestatic 283	java/lang/Math:abs	(J)J
    //   182: ldc2_w 284
    //   185: lcmp
    //   186: ifle +339 -> 525
    //   189: new 261	java/lang/StringBuilder
    //   192: dup
    //   193: ldc_w 287
    //   196: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: astore 9
    //   201: aload 9
    //   203: aload_1
    //   204: invokevirtual 280	android/location/Location:getTime	()J
    //   207: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 9
    //   213: ldc_w 292
    //   216: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 9
    //   222: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   225: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: goto +296 -> 525
    //   232: aload_0
    //   233: invokespecial 294	c/t/m/g/ej:d	()V
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 61	c/t/m/g/ej:c	I
    //   241: iconst_2
    //   242: ior
    //   243: putfield 61	c/t/m/g/ej:c	I
    //   246: aload_0
    //   247: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   250: putfield 55	c/t/m/g/ej:a	J
    //   253: aload_0
    //   254: aload_1
    //   255: invokespecial 296	c/t/m/g/ej:a	(Landroid/location/Location;)I
    //   258: istore 8
    //   260: aload_0
    //   261: getfield 69	c/t/m/g/ej:s	I
    //   264: iconst_3
    //   265: if_icmpne +9 -> 274
    //   268: iconst_1
    //   269: istore 6
    //   271: goto +41 -> 312
    //   274: aload_0
    //   275: getfield 69	c/t/m/g/ej:s	I
    //   278: iconst_4
    //   279: if_icmplt +18 -> 297
    //   282: aload_0
    //   283: getfield 69	c/t/m/g/ej:s	I
    //   286: bipush 6
    //   288: if_icmpgt +9 -> 297
    //   291: iconst_2
    //   292: istore 6
    //   294: goto +18 -> 312
    //   297: aload_0
    //   298: getfield 69	c/t/m/g/ej:s	I
    //   301: bipush 7
    //   303: if_icmplt +239 -> 542
    //   306: iconst_3
    //   307: istore 6
    //   309: goto +3 -> 312
    //   312: aload_0
    //   313: getfield 298	c/t/m/g/ej:f	Z
    //   316: ifeq +232 -> 548
    //   319: aload_1
    //   320: invokevirtual 251	android/location/Location:getLatitude	()D
    //   323: aload_1
    //   324: invokevirtual 259	android/location/Location:getLongitude	()D
    //   327: invokestatic 303	c/t/m/g/fk:a	(DD)Z
    //   330: ifeq +218 -> 548
    //   333: iconst_1
    //   334: istore 7
    //   336: goto +3 -> 339
    //   339: iload 7
    //   341: ifeq +35 -> 376
    //   344: aload_1
    //   345: aload_0
    //   346: getfield 82	c/t/m/g/ej:x	[D
    //   349: invokestatic 306	c/t/m/g/fp:a	(Landroid/location/Location;[D)Z
    //   352: pop
    //   353: aload_1
    //   354: aload_0
    //   355: getfield 82	c/t/m/g/ej:x	[D
    //   358: iconst_0
    //   359: daload
    //   360: aload_0
    //   361: getfield 82	c/t/m/g/ej:x	[D
    //   364: iconst_1
    //   365: daload
    //   366: iload 6
    //   368: iload 8
    //   370: invokestatic 308	c/t/m/g/ej:a	(Landroid/location/Location;DDII)V
    //   373: goto +19 -> 392
    //   376: aload_1
    //   377: aload_1
    //   378: invokevirtual 251	android/location/Location:getLatitude	()D
    //   381: aload_1
    //   382: invokevirtual 259	android/location/Location:getLongitude	()D
    //   385: iload 6
    //   387: iload 8
    //   389: invokestatic 308	c/t/m/g/ej:a	(Landroid/location/Location;DDII)V
    //   392: new 310	c/t/m/g/eu
    //   395: dup
    //   396: aload_1
    //   397: aload_0
    //   398: getfield 55	c/t/m/g/ej:a	J
    //   401: aload_0
    //   402: getfield 67	c/t/m/g/ej:r	I
    //   405: aload_0
    //   406: getfield 69	c/t/m/g/ej:s	I
    //   409: aload_0
    //   410: getfield 61	c/t/m/g/ej:c	I
    //   413: invokespecial 313	c/t/m/g/eu:<init>	(Landroid/location/Location;JIII)V
    //   416: astore_1
    //   417: aload_0
    //   418: getfield 84	c/t/m/g/ej:b	Lc/t/m/g/ea;
    //   421: aload_1
    //   422: invokevirtual 316	c/t/m/g/ea:b	(Ljava/lang/Object;)V
    //   425: goto +7 -> 432
    //   428: astore_1
    //   429: goto +16 -> 445
    //   432: aload_0
    //   433: iconst_0
    //   434: putfield 59	c/t/m/g/ej:l	Z
    //   437: aload_0
    //   438: aconst_null
    //   439: putfield 318	c/t/m/g/ej:m	Landroid/location/Location;
    //   442: aload_0
    //   443: monitorexit
    //   444: return
    //   445: aload_0
    //   446: monitorexit
    //   447: aload_1
    //   448: athrow
    //   449: aload_0
    //   450: monitorexit
    //   451: return
    //   452: astore_1
    //   453: goto -21 -> 432
    //   456: dload_2
    //   457: ldc2_w 319
    //   460: dmul
    //   461: ldc2_w 321
    //   464: drem
    //   465: dconst_0
    //   466: dcmpl
    //   467: ifne -352 -> 115
    //   470: ldc2_w 319
    //   473: dload 4
    //   475: dmul
    //   476: ldc2_w 321
    //   479: drem
    //   480: dconst_0
    //   481: dcmpl
    //   482: ifne -367 -> 115
    //   485: goto +46 -> 531
    //   488: dload_2
    //   489: ldc2_w 323
    //   492: dcmpg
    //   493: iflt +38 -> 531
    //   496: dload_2
    //   497: ldc2_w 325
    //   500: dcmpl
    //   501: ifgt +30 -> 531
    //   504: dload 4
    //   506: ldc2_w 327
    //   509: dcmpg
    //   510: iflt +21 -> 531
    //   513: dload 4
    //   515: ldc2_w 329
    //   518: dcmpl
    //   519: ifle -348 -> 171
    //   522: goto +9 -> 531
    //   525: iconst_1
    //   526: istore 6
    //   528: goto +6 -> 534
    //   531: iconst_0
    //   532: istore 6
    //   534: iload 6
    //   536: ifne -304 -> 232
    //   539: goto -90 -> 449
    //   542: iconst_0
    //   543: istore 6
    //   545: goto -233 -> 312
    //   548: iconst_0
    //   549: istore 7
    //   551: goto -212 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	ej
    //   0	554	1	paramLocation	Location
    //   49	448	2	d1	double
    //   59	455	4	d2	double
    //   269	275	6	i1	int
    //   334	216	7	i2	int
    //   258	130	8	i3	int
    //   71	150	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	37	428	finally
    //   40	112	428	finally
    //   115	138	428	finally
    //   141	168	428	finally
    //   171	229	428	finally
    //   232	268	428	finally
    //   274	291	428	finally
    //   297	306	428	finally
    //   312	333	428	finally
    //   344	373	428	finally
    //   376	392	428	finally
    //   392	425	428	finally
    //   432	442	428	finally
    //   6	37	452	java/lang/Throwable
    //   40	112	452	java/lang/Throwable
    //   115	138	452	java/lang/Throwable
    //   141	168	452	java/lang/Throwable
    //   171	229	452	java/lang/Throwable
    //   232	268	452	java/lang/Throwable
    //   274	291	452	java/lang/Throwable
    //   297	306	452	java/lang/Throwable
    //   312	333	452	java/lang/Throwable
    //   344	373	452	java/lang/Throwable
    //   376	392	452	java/lang/Throwable
    //   392	425	452	java/lang/Throwable
  }
  
  private void d()
  {
    this.t = 0;
    this.s = 0;
    this.r = 0;
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    this.u.clear();
    this.t = ((GpsStatus)localObject).getMaxSatellites();
    localObject = ((GpsStatus)localObject).getSatellites().iterator();
    if (localObject == null) {
      return;
    }
    while ((((Iterator)localObject).hasNext()) && (this.r <= this.t))
    {
      GpsSatellite localGpsSatellite = (GpsSatellite)((Iterator)localObject).next();
      this.r += 1;
      this.u.add(Float.valueOf(localGpsSatellite.getSnr()));
      if (localGpsSatellite.usedInFix()) {
        this.s += 1;
      }
    }
  }
  
  public final void a()
  {
    if (!this.d) {
      return;
    }
    this.d = false;
    this.a = 0L;
    this.c = 1024;
    this.o = false;
    this.p = false;
    this.t = 0;
    this.s = 0;
    this.r = 0;
    this.u.clear();
    this.f = false;
    Arrays.fill(this.x, 0.0D);
    LocationManager localLocationManager = this.b.h;
    try
    {
      localLocationManager.removeGpsStatusListener(this);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        new StringBuilder("system gps provider remove update,thread name:").append(Thread.currentThread().getName());
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
              this.i.removeCallbacksAndMessages(null);
              this.g.quit();
              label129:
              this.k = false;
              this.l = false;
              return;
              localThrowable3 = localThrowable3;
              continue;
              localThrowable4 = localThrowable4;
              continue;
              localThrowable1 = localThrowable1;
            }
          }
          catch (Throwable localThrowable2)
          {
            break label129;
          }
        }
      }
    }
  }
  
  public final boolean b()
  {
    LocationManager localLocationManager = this.b.h;
    try
    {
      boolean bool = localLocationManager.isProviderEnabled("gps");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label17:
      break label17;
    }
    return false;
  }
  
  final void c()
  {
    int i1 = this.c;
    if (i1 == 4) {
      i1 = 1;
    } else if (i1 == 0) {
      i1 = 0;
    } else {
      i1 = -1;
    }
    if (fj.a) {
      i1 = 5;
    }
    Message localMessage = new Message();
    localMessage.what = 12999;
    localMessage.arg1 = 12002;
    localMessage.arg2 = i1;
    this.b.b(localMessage);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    int i1;
    Object localObject1;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3)
        {
          i1 = 4;
          if (paramInt != 4) {
            return;
          }
          localObject1 = this.b.h;
        }
      }
    }
    try
    {
      if (this.q == null) {
        this.q = ((LocationManager)localObject1).getGpsStatus(null);
      } else {
        ((LocationManager)localObject1).getGpsStatus(this.q);
      }
    }
    catch (Exception localException)
    {
      label66:
      int i2;
      break label66;
    }
    d();
    paramInt = this.r;
    i2 = this.s;
    if (paramInt > 0) {
      this.p = true;
    }
    if (i2 > 0) {
      this.o = true;
    }
    if (this.q != null)
    {
      localObject1 = this.u;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {}
    }
    try
    {
      localObject1 = this.w;
      localObject2 = this.u;
      paramInt = this.r;
      localStringBuilder = new StringBuilder();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append("颗卫星,");
      localStringBuilder.append(((StringBuilder)localObject3).toString());
      if (((List)localObject2).size() < 5) {
        break label784;
      }
      localObject3 = new float[((List)localObject2).size()];
      paramInt = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        Object localObject3;
        float f2;
        float f1;
        Float localFloat;
        continue;
        localObject3[paramInt] = f1;
        paramInt += 1;
      }
    }
    i2 = localObject3.length;
    f2 = 0.0F;
    f1 = 0.0F;
    if (paramInt < i2)
    {
      localFloat = (Float)((List)localObject2).get(paramInt);
      if (localFloat == null) {
        f1 = f2;
      } else {
        f1 = localFloat.floatValue();
      }
    }
    else
    {
      Arrays.sort((float[])localObject3);
      localObject2 = new float[5];
      paramInt = 0;
      while (paramInt < 5)
      {
        localObject2[paramInt] = localObject3[(localObject3.length - 1 - paramInt)];
        f1 += localObject2[paramInt];
        paramInt += 1;
      }
      f1 /= 5.0F;
      localStringBuilder.append("\n");
      localStringBuilder.append("绝对判断：");
      f2 = localObject2[0];
      if (f2 > 35.0F)
      {
        ((ed)localObject1).d = true;
        localStringBuilder.append("室外|");
      }
      else if (f1 > 30.0F)
      {
        ((ed)localObject1).d = true;
        localStringBuilder.append("室外|");
      }
      if (f1 < 22.0F)
      {
        localStringBuilder.append("室内|");
        ((ed)localObject1).d = false;
      }
      localStringBuilder.append("avg".concat(String.valueOf(f1)));
      localObject2 = new StringBuilder("avg'");
      ((StringBuilder)localObject2).append(f1 - ((ed)localObject1).a);
      localStringBuilder.append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("avgMax");
      ((StringBuilder)localObject2).append(((ed)localObject1).b);
      localStringBuilder.append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("avgMin");
      ((StringBuilder)localObject2).append(((ed)localObject1).c);
      localStringBuilder.append(((StringBuilder)localObject2).toString());
      localStringBuilder.append(((ed)localObject1).d);
      localStringBuilder.append("\n");
      if (((ed)localObject1).b < f1) {
        ((ed)localObject1).b = f1;
      }
      if (((ed)localObject1).c > f1) {
        ((ed)localObject1).c = f1;
      }
      ((ed)localObject1).a = f1;
      localStringBuilder.append("相对判断：");
      if (f1 - ((ed)localObject1).a > 3.0F) {
        localStringBuilder.append("信号增强");
      }
      if (((ed)localObject1).a - f1 > 2.0F)
      {
        localStringBuilder.append("信号衰弱");
        ((ed)localObject1).e = false;
      }
      if (f1 > (((ed)localObject1).b + ((ed)localObject1).c) / 2.0F) {
        ((ed)localObject1).e = true;
      } else if (f1 < 22.0F) {
        ((ed)localObject1).e = false;
      }
      if (((ed)localObject1).d != ((ed)localObject1).e)
      {
        localObject2 = new StringBuilder("\n冲突");
        ((StringBuilder)localObject2).append(((ed)localObject1).d);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(((ed)localObject1).e);
        localStringBuilder.append(((StringBuilder)localObject2).toString());
      }
      localObject2 = new StringBuilder("\n最终结果");
      ((StringBuilder)localObject2).append(((ed)localObject1).e);
      localStringBuilder.append(((StringBuilder)localObject2).toString());
      label784:
      ((ed)localObject1).f = localStringBuilder.toString();
      this.v = ((ed)localObject1).e;
      if (this.v) {
        this.e = System.currentTimeMillis();
      }
      paramInt = i1;
      if (this.v) {
        paramInt = 3;
      }
      localObject1 = new Message();
      ((Message)localObject1).what = 12999;
      ((Message)localObject1).arg1 = 12004;
      ((Message)localObject1).arg2 = paramInt;
      this.b.b(localObject1);
      return;
      this.c |= 0x2;
      return;
      this.c = 0;
      return;
      this.c |= 0x1;
      return;
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    this.l = true;
    this.m = paramLocation;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocation.toString());
    localStringBuilder.append(",speed:");
    localStringBuilder.append(paramLocation.getSpeed());
    localStringBuilder.append(",bearing:");
    localStringBuilder.append(paramLocation.getBearing());
    localStringBuilder.append(Thread.currentThread().getName());
    c(this.m);
  }
  
  public final void onNmeaReceived(long paramLong, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 5) {
        return;
      }
      int i1 = paramString.indexOf(",");
      if (i1 <= 0) {
        localObject = null;
      } else {
        localObject = paramString.substring(0, i1).trim();
      }
      if ((localObject != null) && (((String)localObject).length() > 5))
      {
        if (((String)localObject).charAt(3) != 'R') {
          return;
        }
        if (((String)localObject).contains("RMC"))
        {
          localObject = paramString.split(",");
          if (!"A".equals(localObject[2])) {}
        }
      }
    }
    try
    {
      this.n.setLatitude(a(localObject[3]));
      this.n.setLongitude(a(localObject[5]));
    }
    catch (Throwable localThrowable)
    {
      label135:
      boolean bool;
      break label135;
    }
    Object localObject = new StringBuilder("<");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(">");
    bool = this.k;
    this.k = true;
    if (!bool) {
      c(this.m);
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      this.s = 0;
      this.r = 0;
      this.c = 0;
      this.o = false;
      this.a = 0L;
      c();
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      this.c = 4;
      c();
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ej
 * JD-Core Version:    0.7.0.1
 */