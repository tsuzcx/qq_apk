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
    double d1 = Double.parseDouble(paramString);
    double d2 = (int)Math.floor(d1 / 100.0D);
    return (d1 - 100.0D * d2) / 60.0D + d2;
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
          break label115;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label34:
      break label34;
    }
    if (b(paramLocation))
    {
      if ((!this.v) && (this.b.b.o > 0) && (System.currentTimeMillis() - this.e > 120000L)) {
        return 2;
      }
      if ((this.n != null) && (paramLocation.distanceTo(this.n) > 100.0F) && (!this.v)) {
        return 3;
      }
      return 0;
    }
    label115:
    return 1;
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
    if (Build.VERSION.SDK_INT >= 17) {}
    while ((this.b.b.o > 0) && (paramLocation.getSpeed() == 0.0F) && (paramLocation.getBearing() == 0.0F)) {
      try
      {
        long l1 = paramLocation.getElapsedRealtimeNanos();
        if (l1 == 0L) {
          return false;
        }
      }
      catch (Throwable localThrowable) {}
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
    //   3: ifnull +46 -> 49
    //   6: ldc 88
    //   8: aload_1
    //   9: invokevirtual 234	android/location/Location:getProvider	()Ljava/lang/String;
    //   12: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +34 -> 49
    //   18: aload_1
    //   19: invokevirtual 243	android/location/Location:getAccuracy	()F
    //   22: ldc 244
    //   24: fcmpl
    //   25: ifgt +16 -> 41
    //   28: aload_1
    //   29: invokevirtual 243	android/location/Location:getAccuracy	()F
    //   32: fstore 6
    //   34: fload 6
    //   36: fconst_0
    //   37: fcmpg
    //   38: ifge +14 -> 52
    //   41: iconst_0
    //   42: istore 7
    //   44: iload 7
    //   46: ifne +181 -> 227
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_1
    //   53: invokevirtual 248	android/location/Location:getLatitude	()D
    //   56: bipush 6
    //   58: invokestatic 253	c/t/m/g/fp:a	(DI)D
    //   61: dstore_2
    //   62: aload_1
    //   63: invokevirtual 256	android/location/Location:getLongitude	()D
    //   66: bipush 6
    //   68: invokestatic 253	c/t/m/g/fp:a	(DI)D
    //   71: dstore 4
    //   73: new 258	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 260
    //   80: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: dload_2
    //   84: invokevirtual 265	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   87: ldc_w 267
    //   90: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: dload 4
    //   95: invokevirtual 265	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: dload_2
    //   100: invokestatic 272	c/t/m/g/ej:a	(D)Z
    //   103: ifeq +336 -> 439
    //   106: dload 4
    //   108: invokestatic 272	c/t/m/g/ej:a	(D)Z
    //   111: ifeq +328 -> 439
    //   114: iconst_0
    //   115: istore 7
    //   117: goto -73 -> 44
    //   120: dload_2
    //   121: invokestatic 216	java/lang/Math:abs	(D)D
    //   124: ldc2_w 273
    //   127: dcmpg
    //   128: iflt +346 -> 474
    //   131: dload 4
    //   133: invokestatic 216	java/lang/Math:abs	(D)D
    //   136: ldc2_w 273
    //   139: dcmpg
    //   140: ifge +6 -> 146
    //   143: goto +331 -> 474
    //   146: dload_2
    //   147: dconst_1
    //   148: dsub
    //   149: invokestatic 216	java/lang/Math:abs	(D)D
    //   152: ldc2_w 273
    //   155: dcmpg
    //   156: iflt +324 -> 480
    //   159: dload 4
    //   161: dconst_1
    //   162: dsub
    //   163: invokestatic 216	java/lang/Math:abs	(D)D
    //   166: ldc2_w 273
    //   169: dcmpg
    //   170: ifge +316 -> 486
    //   173: goto +307 -> 480
    //   176: aload_1
    //   177: invokevirtual 277	android/location/Location:getTime	()J
    //   180: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   183: lsub
    //   184: invokestatic 280	java/lang/Math:abs	(J)J
    //   187: ldc2_w 281
    //   190: lcmp
    //   191: ifle +335 -> 526
    //   194: new 258	java/lang/StringBuilder
    //   197: dup
    //   198: ldc_w 284
    //   201: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload_1
    //   205: invokevirtual 277	android/location/Location:getTime	()J
    //   208: invokevirtual 287	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: ldc_w 289
    //   214: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   220: invokevirtual 287	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: goto +302 -> 526
    //   227: aload_0
    //   228: invokespecial 291	c/t/m/g/ej:d	()V
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 61	c/t/m/g/ej:c	I
    //   236: iconst_2
    //   237: ior
    //   238: putfield 61	c/t/m/g/ej:c	I
    //   241: aload_0
    //   242: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   245: putfield 55	c/t/m/g/ej:a	J
    //   248: aload_0
    //   249: aload_1
    //   250: invokespecial 293	c/t/m/g/ej:a	(Landroid/location/Location;)I
    //   253: istore 9
    //   255: iconst_0
    //   256: istore 7
    //   258: aload_0
    //   259: getfield 69	c/t/m/g/ej:s	I
    //   262: iconst_3
    //   263: if_icmpne +115 -> 378
    //   266: iconst_1
    //   267: istore 7
    //   269: aload_0
    //   270: getfield 295	c/t/m/g/ej:f	Z
    //   273: ifeq +259 -> 532
    //   276: aload_1
    //   277: invokevirtual 248	android/location/Location:getLatitude	()D
    //   280: aload_1
    //   281: invokevirtual 256	android/location/Location:getLongitude	()D
    //   284: invokestatic 300	c/t/m/g/fk:a	(DD)Z
    //   287: ifeq +245 -> 532
    //   290: iconst_1
    //   291: istore 8
    //   293: iload 8
    //   295: ifeq +121 -> 416
    //   298: aload_1
    //   299: aload_0
    //   300: getfield 82	c/t/m/g/ej:x	[D
    //   303: invokestatic 303	c/t/m/g/fp:a	(Landroid/location/Location;[D)Z
    //   306: pop
    //   307: aload_1
    //   308: aload_0
    //   309: getfield 82	c/t/m/g/ej:x	[D
    //   312: iconst_0
    //   313: daload
    //   314: aload_0
    //   315: getfield 82	c/t/m/g/ej:x	[D
    //   318: iconst_1
    //   319: daload
    //   320: iload 7
    //   322: iload 9
    //   324: invokestatic 305	c/t/m/g/ej:a	(Landroid/location/Location;DDII)V
    //   327: new 307	c/t/m/g/eu
    //   330: dup
    //   331: aload_1
    //   332: aload_0
    //   333: getfield 55	c/t/m/g/ej:a	J
    //   336: aload_0
    //   337: getfield 67	c/t/m/g/ej:r	I
    //   340: aload_0
    //   341: getfield 69	c/t/m/g/ej:s	I
    //   344: aload_0
    //   345: getfield 61	c/t/m/g/ej:c	I
    //   348: invokespecial 310	c/t/m/g/eu:<init>	(Landroid/location/Location;JIII)V
    //   351: astore_1
    //   352: aload_0
    //   353: getfield 84	c/t/m/g/ej:b	Lc/t/m/g/ea;
    //   356: aload_1
    //   357: invokevirtual 313	c/t/m/g/ea:b	(Ljava/lang/Object;)V
    //   360: aload_0
    //   361: iconst_0
    //   362: putfield 59	c/t/m/g/ej:l	Z
    //   365: aload_0
    //   366: aconst_null
    //   367: putfield 315	c/t/m/g/ej:m	Landroid/location/Location;
    //   370: goto -321 -> 49
    //   373: astore_1
    //   374: aload_0
    //   375: monitorexit
    //   376: aload_1
    //   377: athrow
    //   378: aload_0
    //   379: getfield 69	c/t/m/g/ej:s	I
    //   382: iconst_4
    //   383: if_icmplt +18 -> 401
    //   386: aload_0
    //   387: getfield 69	c/t/m/g/ej:s	I
    //   390: bipush 6
    //   392: if_icmpgt +9 -> 401
    //   395: iconst_2
    //   396: istore 7
    //   398: goto -129 -> 269
    //   401: aload_0
    //   402: getfield 69	c/t/m/g/ej:s	I
    //   405: bipush 7
    //   407: if_icmplt -138 -> 269
    //   410: iconst_3
    //   411: istore 7
    //   413: goto -144 -> 269
    //   416: aload_1
    //   417: aload_1
    //   418: invokevirtual 248	android/location/Location:getLatitude	()D
    //   421: aload_1
    //   422: invokevirtual 256	android/location/Location:getLongitude	()D
    //   425: iload 7
    //   427: iload 9
    //   429: invokestatic 305	c/t/m/g/ej:a	(Landroid/location/Location;DDII)V
    //   432: goto -105 -> 327
    //   435: astore_1
    //   436: goto -76 -> 360
    //   439: ldc2_w 316
    //   442: dload_2
    //   443: dmul
    //   444: ldc2_w 318
    //   447: drem
    //   448: dconst_0
    //   449: dcmpl
    //   450: ifne -330 -> 120
    //   453: ldc2_w 316
    //   456: dload 4
    //   458: dmul
    //   459: ldc2_w 318
    //   462: drem
    //   463: dconst_0
    //   464: dcmpl
    //   465: ifne -345 -> 120
    //   468: iconst_0
    //   469: istore 7
    //   471: goto -427 -> 44
    //   474: iconst_0
    //   475: istore 7
    //   477: goto -433 -> 44
    //   480: iconst_0
    //   481: istore 7
    //   483: goto -439 -> 44
    //   486: dload_2
    //   487: ldc2_w 320
    //   490: dcmpg
    //   491: iflt +29 -> 520
    //   494: dload_2
    //   495: ldc2_w 322
    //   498: dcmpl
    //   499: ifgt +21 -> 520
    //   502: dload 4
    //   504: ldc2_w 324
    //   507: dcmpg
    //   508: iflt +12 -> 520
    //   511: dload 4
    //   513: ldc2_w 326
    //   516: dcmpl
    //   517: ifle -341 -> 176
    //   520: iconst_0
    //   521: istore 7
    //   523: goto -479 -> 44
    //   526: iconst_1
    //   527: istore 7
    //   529: goto -485 -> 44
    //   532: iconst_0
    //   533: istore 8
    //   535: goto -242 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	ej
    //   0	538	1	paramLocation	Location
    //   61	434	2	d1	double
    //   71	441	4	d2	double
    //   32	3	6	f1	float
    //   42	486	7	i1	int
    //   291	243	8	i2	int
    //   253	175	9	i3	int
    // Exception table:
    //   from	to	target	type
    //   6	34	373	finally
    //   52	114	373	finally
    //   120	143	373	finally
    //   146	173	373	finally
    //   176	224	373	finally
    //   227	255	373	finally
    //   258	266	373	finally
    //   269	290	373	finally
    //   298	327	373	finally
    //   327	360	373	finally
    //   360	370	373	finally
    //   378	395	373	finally
    //   401	410	373	finally
    //   416	432	373	finally
    //   6	34	435	java/lang/Throwable
    //   52	114	435	java/lang/Throwable
    //   120	143	435	java/lang/Throwable
    //   146	173	435	java/lang/Throwable
    //   176	224	435	java/lang/Throwable
    //   227	255	435	java/lang/Throwable
    //   258	266	435	java/lang/Throwable
    //   269	290	435	java/lang/Throwable
    //   298	327	435	java/lang/Throwable
    //   327	360	435	java/lang/Throwable
    //   378	395	435	java/lang/Throwable
    //   401	410	435	java/lang/Throwable
    //   416	432	435	java/lang/Throwable
  }
  
  private void d()
  {
    this.t = 0;
    this.s = 0;
    this.r = 0;
    Object localObject = this.q;
    if (localObject == null) {}
    for (;;)
    {
      return;
      this.u.clear();
      this.t = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
      if (localObject != null) {
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
        for (;;)
        {
          new StringBuilder("system gps provider remove update,thread name:").append(Thread.currentThread().getName());
          localLocationManager.removeUpdates(this);
          try
          {
            label108:
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
                break;
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
      catch (Throwable localThrowable4)
      {
        break label108;
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
    catch (Throwable localThrowable) {}
    return false;
  }
  
  final void c()
  {
    int i1;
    if (this.c == 4) {
      i1 = 1;
    }
    for (;;)
    {
      if (fj.a) {
        i1 = 5;
      }
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12002;
      localMessage.arg2 = i1;
      this.b.b(localMessage);
      return;
      if (this.c == 0) {
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
    //   35: getfield 61	c/t/m/g/ej:c	I
    //   38: iconst_1
    //   39: ior
    //   40: putfield 61	c/t/m/g/ej:c	I
    //   43: return
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 61	c/t/m/g/ej:c	I
    //   49: return
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 61	c/t/m/g/ej:c	I
    //   55: iconst_2
    //   56: ior
    //   57: putfield 61	c/t/m/g/ej:c	I
    //   60: return
    //   61: aload_0
    //   62: getfield 84	c/t/m/g/ej:b	Lc/t/m/g/ea;
    //   65: getfield 137	c/t/m/g/ea:h	Landroid/location/LocationManager;
    //   68: astore 4
    //   70: aload_0
    //   71: getfield 331	c/t/m/g/ej:q	Landroid/location/GpsStatus;
    //   74: ifnonnull +184 -> 258
    //   77: aload_0
    //   78: aload 4
    //   80: aconst_null
    //   81: invokevirtual 444	android/location/LocationManager:getGpsStatus	(Landroid/location/GpsStatus;)Landroid/location/GpsStatus;
    //   84: putfield 331	c/t/m/g/ej:q	Landroid/location/GpsStatus;
    //   87: aload_0
    //   88: invokespecial 291	c/t/m/g/ej:d	()V
    //   91: aload_0
    //   92: getfield 67	c/t/m/g/ej:r	I
    //   95: istore_1
    //   96: aload_0
    //   97: getfield 69	c/t/m/g/ej:s	I
    //   100: istore_3
    //   101: iload_1
    //   102: ifle +8 -> 110
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield 65	c/t/m/g/ej:p	Z
    //   110: iload_3
    //   111: ifle +8 -> 119
    //   114: aload_0
    //   115: iconst_1
    //   116: putfield 63	c/t/m/g/ej:o	Z
    //   119: aload_0
    //   120: getfield 331	c/t/m/g/ej:q	Landroid/location/GpsStatus;
    //   123: ifnull +636 -> 759
    //   126: aload_0
    //   127: getfield 76	c/t/m/g/ej:u	Ljava/util/ArrayList;
    //   130: ifnull +629 -> 759
    //   133: aload_0
    //   134: getfield 76	c/t/m/g/ej:u	Ljava/util/ArrayList;
    //   137: invokevirtual 447	java/util/ArrayList:size	()I
    //   140: ifle +619 -> 759
    //   143: aload_0
    //   144: getfield 100	c/t/m/g/ej:w	Lc/t/m/g/ed;
    //   147: astore 4
    //   149: aload_0
    //   150: getfield 76	c/t/m/g/ej:u	Ljava/util/ArrayList;
    //   153: astore 7
    //   155: aload_0
    //   156: getfield 67	c/t/m/g/ej:r	I
    //   159: istore_1
    //   160: new 258	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   167: astore 5
    //   169: aload 5
    //   171: new 258	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 448	java/lang/StringBuilder:<init>	()V
    //   178: iload_1
    //   179: invokevirtual 451	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc_w 453
    //   185: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 7
    //   197: invokeinterface 459 1 0
    //   202: iconst_5
    //   203: if_icmplt +523 -> 726
    //   206: aload 7
    //   208: invokeinterface 459 1 0
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
    //   229: invokeinterface 463 2 0
    //   234: checkcast 366	java/lang/Float
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
    //   261: getfield 331	c/t/m/g/ej:q	Landroid/location/GpsStatus;
    //   264: invokevirtual 444	android/location/LocationManager:getGpsStatus	(Landroid/location/GpsStatus;)Landroid/location/GpsStatus;
    //   267: pop
    //   268: goto -181 -> 87
    //   271: astore 4
    //   273: goto -186 -> 87
    //   276: aload 8
    //   278: invokevirtual 466	java/lang/Float:floatValue	()F
    //   281: fstore_2
    //   282: goto -36 -> 246
    //   285: aload 6
    //   287: invokestatic 470	java/util/Arrays:sort	([F)V
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
    //   333: ldc_w 471
    //   336: fdiv
    //   337: fstore_2
    //   338: aload 5
    //   340: ldc_w 473
    //   343: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 5
    //   349: ldc_w 475
    //   352: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 7
    //   358: iconst_0
    //   359: faload
    //   360: ldc_w 476
    //   363: fcmpl
    //   364: ifle +445 -> 809
    //   367: aload 4
    //   369: iconst_1
    //   370: putfield 477	c/t/m/g/ed:d	Z
    //   373: aload 5
    //   375: ldc_w 479
    //   378: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: fload_2
    //   383: ldc_w 480
    //   386: fcmpg
    //   387: ifge +18 -> 405
    //   390: aload 5
    //   392: ldc_w 482
    //   395: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 4
    //   401: iconst_0
    //   402: putfield 477	c/t/m/g/ed:d	Z
    //   405: aload 5
    //   407: ldc_w 484
    //   410: fload_2
    //   411: invokestatic 487	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   414: invokevirtual 491	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   417: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 5
    //   423: new 258	java/lang/StringBuilder
    //   426: dup
    //   427: ldc_w 493
    //   430: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   433: fload_2
    //   434: aload 4
    //   436: getfield 496	c/t/m/g/ed:a	F
    //   439: fsub
    //   440: invokevirtual 499	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   443: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 5
    //   452: new 258	java/lang/StringBuilder
    //   455: dup
    //   456: ldc_w 501
    //   459: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   462: aload 4
    //   464: getfield 503	c/t/m/g/ed:b	F
    //   467: invokevirtual 499	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   470: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 5
    //   479: new 258	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 505
    //   486: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload 4
    //   491: getfield 507	c/t/m/g/ed:c	F
    //   494: invokevirtual 499	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   497: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 5
    //   506: aload 4
    //   508: getfield 477	c/t/m/g/ed:d	Z
    //   511: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 5
    //   517: ldc_w 473
    //   520: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 4
    //   526: getfield 503	c/t/m/g/ed:b	F
    //   529: fload_2
    //   530: fcmpg
    //   531: ifge +9 -> 540
    //   534: aload 4
    //   536: fload_2
    //   537: putfield 503	c/t/m/g/ed:b	F
    //   540: aload 4
    //   542: getfield 507	c/t/m/g/ed:c	F
    //   545: fload_2
    //   546: fcmpl
    //   547: ifle +9 -> 556
    //   550: aload 4
    //   552: fload_2
    //   553: putfield 507	c/t/m/g/ed:c	F
    //   556: aload 4
    //   558: fload_2
    //   559: putfield 496	c/t/m/g/ed:a	F
    //   562: aload 5
    //   564: ldc_w 512
    //   567: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: fload_2
    //   572: aload 4
    //   574: getfield 496	c/t/m/g/ed:a	F
    //   577: fsub
    //   578: ldc_w 513
    //   581: fcmpl
    //   582: ifle +12 -> 594
    //   585: aload 5
    //   587: ldc_w 515
    //   590: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 4
    //   596: getfield 496	c/t/m/g/ed:a	F
    //   599: fload_2
    //   600: fsub
    //   601: fconst_2
    //   602: fcmpl
    //   603: ifle +18 -> 621
    //   606: aload 5
    //   608: ldc_w 517
    //   611: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 4
    //   617: iconst_0
    //   618: putfield 519	c/t/m/g/ed:e	Z
    //   621: fload_2
    //   622: aload 4
    //   624: getfield 503	c/t/m/g/ed:b	F
    //   627: aload 4
    //   629: getfield 507	c/t/m/g/ed:c	F
    //   632: fadd
    //   633: fconst_2
    //   634: fdiv
    //   635: fcmpl
    //   636: ifle +199 -> 835
    //   639: aload 4
    //   641: iconst_1
    //   642: putfield 519	c/t/m/g/ed:e	Z
    //   645: aload 4
    //   647: getfield 477	c/t/m/g/ed:d	Z
    //   650: aload 4
    //   652: getfield 519	c/t/m/g/ed:e	Z
    //   655: if_icmpeq +44 -> 699
    //   658: aload 5
    //   660: new 258	java/lang/StringBuilder
    //   663: dup
    //   664: ldc_w 521
    //   667: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   670: aload 4
    //   672: getfield 477	c/t/m/g/ed:d	Z
    //   675: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: ldc_w 523
    //   681: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload 4
    //   686: getfield 519	c/t/m/g/ed:e	Z
    //   689: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   692: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 5
    //   701: new 258	java/lang/StringBuilder
    //   704: dup
    //   705: ldc_w 525
    //   708: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   711: aload 4
    //   713: getfield 519	c/t/m/g/ed:e	Z
    //   716: invokevirtual 510	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   719: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 4
    //   728: aload 5
    //   730: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: putfield 528	c/t/m/g/ed:f	Ljava/lang/String;
    //   736: aload_0
    //   737: aload 4
    //   739: getfield 519	c/t/m/g/ed:e	Z
    //   742: putfield 78	c/t/m/g/ej:v	Z
    //   745: aload_0
    //   746: getfield 78	c/t/m/g/ej:v	Z
    //   749: ifeq +10 -> 759
    //   752: aload_0
    //   753: invokestatic 168	java/lang/System:currentTimeMillis	()J
    //   756: putfield 80	c/t/m/g/ej:e	J
    //   759: aload_0
    //   760: getfield 78	c/t/m/g/ej:v	Z
    //   763: ifeq +89 -> 852
    //   766: iconst_3
    //   767: istore_1
    //   768: new 426	android/os/Message
    //   771: dup
    //   772: invokespecial 427	android/os/Message:<init>	()V
    //   775: astore 4
    //   777: aload 4
    //   779: sipush 12999
    //   782: putfield 430	android/os/Message:what	I
    //   785: aload 4
    //   787: sipush 12004
    //   790: putfield 433	android/os/Message:arg1	I
    //   793: aload 4
    //   795: iload_1
    //   796: putfield 436	android/os/Message:arg2	I
    //   799: aload_0
    //   800: getfield 84	c/t/m/g/ej:b	Lc/t/m/g/ea;
    //   803: aload 4
    //   805: invokevirtual 313	c/t/m/g/ea:b	(Ljava/lang/Object;)V
    //   808: return
    //   809: fload_2
    //   810: ldc_w 529
    //   813: fcmpl
    //   814: ifle -432 -> 382
    //   817: aload 4
    //   819: iconst_1
    //   820: putfield 477	c/t/m/g/ed:d	Z
    //   823: aload 5
    //   825: ldc_w 479
    //   828: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: goto -450 -> 382
    //   835: fload_2
    //   836: ldc_w 480
    //   839: fcmpg
    //   840: ifge -195 -> 645
    //   843: aload 4
    //   845: iconst_0
    //   846: putfield 519	c/t/m/g/ed:e	Z
    //   849: goto -204 -> 645
    //   852: iconst_4
    //   853: istore_1
    //   854: goto -86 -> 768
    //   857: astore 4
    //   859: goto -100 -> 759
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	this	ej
    //   0	862	1	paramInt	int
    //   245	591	2	f1	float
    //   100	11	3	i1	int
    //   68	191	4	localObject1	Object
    //   271	467	4	localException	java.lang.Exception
    //   775	69	4	localMessage	Message
    //   857	1	4	localThrowable	Throwable
    //   167	657	5	localStringBuilder	StringBuilder
    //   215	95	6	arrayOfFloat	float[]
    //   153	204	7	localObject2	Object
    //   237	40	8	localFloat	Float
    // Exception table:
    //   from	to	target	type
    //   70	87	271	java/lang/Exception
    //   258	268	271	java/lang/Exception
    //   143	217	857	java/lang/Throwable
    //   219	239	857	java/lang/Throwable
    //   276	282	857	java/lang/Throwable
    //   285	295	857	java/lang/Throwable
    //   304	318	857	java/lang/Throwable
    //   332	356	857	java/lang/Throwable
    //   367	382	857	java/lang/Throwable
    //   390	405	857	java/lang/Throwable
    //   405	540	857	java/lang/Throwable
    //   540	556	857	java/lang/Throwable
    //   556	594	857	java/lang/Throwable
    //   594	621	857	java/lang/Throwable
    //   621	645	857	java/lang/Throwable
    //   645	699	857	java/lang/Throwable
    //   699	726	857	java/lang/Throwable
    //   726	759	857	java/lang/Throwable
    //   817	832	857	java/lang/Throwable
    //   843	849	857	java/lang/Throwable
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    this.l = true;
    this.m = paramLocation;
    new StringBuilder().append(paramLocation.toString()).append(",speed:").append(paramLocation.getSpeed()).append(",bearing:").append(paramLocation.getBearing()).append(Thread.currentThread().getName());
    c(this.m);
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
        if ((localObject == null) || (((String)localObject).length() <= 5) || (((String)localObject).charAt(3) != 'R') || (!((String)localObject).contains("RMC"))) {
          continue;
        }
        localObject = paramString.split(",");
        if (!"A".equals(localObject[2])) {
          continue;
        }
      }
      try
      {
        this.n.setLatitude(a(localObject[3]));
        this.n.setLongitude(a(localObject[5]));
        boolean bool = this.k;
        this.k = true;
        if (bool) {
          continue;
        }
        c(this.m);
        return;
        localObject = paramString.substring(0, i1).trim();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          new StringBuilder("<").append(paramString).append(">");
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ej
 * JD-Core Version:    0.7.0.1
 */