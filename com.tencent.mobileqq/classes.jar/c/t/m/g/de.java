package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class de
{
  private static volatile de n;
  public final Context a;
  public final ev b;
  public final SharedPreferences c;
  public final ExecutorService d;
  final PackageManager e;
  public final TelephonyManager f;
  public final WifiManager g;
  public final LocationManager h;
  public final TencentHttpClient i;
  public final TencentHttpClient j;
  String k;
  private final HashMap<String, dh> l;
  private CountDownLatch m;
  private List<ey> o;
  
  private de(Context paramContext)
  {
    this.a = paramContext;
    this.e = paramContext.getPackageManager();
    this.f = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.g = ((WifiManager)paramContext.getSystemService("wifi"));
    this.h = ((LocationManager)paramContext.getSystemService("location"));
    this.c = paramContext.getSharedPreferences("LocationSDK", 0);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("channelId", dk.a(paramContext.getPackageName()));
    this.i = TencentHttpClientFactory.getInstance().getTencentHttpClient(paramContext, (Bundle)localObject);
    this.j = TencentHttpClientFactory.getInstance().getTencentHttpURLConnection();
    localObject = new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "locationsdk_network_request_pool");
      }
    };
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.d = ((ExecutorService)localObject);
    this.l = new HashMap();
    this.l.put("cell", new di("cell"));
    this.b = new ev(this);
    try
    {
      this.b.g = c(paramContext);
      a();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        ev.b("AppContext", "transactionTooLarge");
      }
    }
  }
  
  public static de a(Context paramContext)
  {
    if (n == null) {}
    try
    {
      if (n == null) {
        n = new de(paramContext.getApplicationContext());
      }
      return n;
    }
    finally {}
  }
  
  static int b(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext != null)
        {
          paramContext = paramContext.getPackageInfo("com.txy.anywhere", 4);
          if (paramContext != null)
          {
            int i1 = paramContext.versionCode;
            return i1;
          }
        }
      }
      catch (Throwable paramContext)
      {
        return -1;
      }
    }
    return -2;
  }
  
  private String b(String paramString)
  {
    ev localev = this.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", localev.d());
    localHashMap.put("app_name", c(localev.h));
    localHashMap.put("app_label", c(localev.j));
    localHashMap.put("l", paramString);
    try
    {
      paramString = new JSONObject(localHashMap);
      localev = this.b;
      localHashMap = new HashMap();
      localHashMap.put("imei", c(localev.a()));
      localHashMap.put("imsi", c(localev.b()));
      localHashMap.put("n", c(ev.c(localev.d)));
      localHashMap.put("qq", c(ev.c(localev.f)));
      localHashMap.put("mac", c(localev.c().toLowerCase(Locale.ENGLISH)));
      localHashMap.put("model", c(Build.MANUFACTURER + "_" + Build.MODEL));
      paramString = paramString.put("attribute", new JSONObject(localHashMap)).toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentGeoLocationSDK")) {
          return paramContext.getString("TencentGeoLocationSDK");
        }
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          return paramContext;
        }
        return "";
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public final dh a(String paramString)
  {
    paramString = (dh)this.l.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return dg.a;
  }
  
  public final void a()
  {
    this.m = new CountDownLatch(1);
    new Thread(new Runnable()
    {
      public final void run()
      {
        de.a(de.this);
        de localde = de.this;
        for (;;)
        {
          try
          {
            ev.a("AppContext", 4, "doInBg: app status init start");
            ev localev = localde.b;
            PackageInfo localPackageInfo = localde.g();
            localev.i = localPackageInfo.versionCode;
            localev.h = localPackageInfo.versionName;
            localObject1 = localde.a.getApplicationInfo().loadLabel(localde.e);
            if (localObject1 == null) {
              continue;
            }
            localObject1 = localObject1.toString();
            localev.j = ((String)localObject1);
            localObject1 = localde.f;
            if (localObject1 != null)
            {
              Object localObject2 = new int[2];
              er.a((TelephonyManager)localObject1, (int[])localObject2);
              localev.k = localObject2[0];
              localev.l = localObject2[1];
              localev.a = ((TelephonyManager)localObject1).getPhoneType();
              localObject2 = ew.a(((TelephonyManager)localObject1).getDeviceId(), ew.a);
              String str = ew.a(((TelephonyManager)localObject1).getSubscriberId(), ew.b);
              localObject1 = ew.a(((TelephonyManager)localObject1).getLine1Number(), ew.c);
              localde.k = ((String)localObject2);
              localev.b = ((String)localObject2);
              localev.c = str;
              localev.d = ((String)localObject1);
            }
            localev.e = ew.a(ex.a(localde.a).replaceAll(":", "").toUpperCase(Locale.ENGLISH), ew.d);
            localObject1 = localde.e;
            boolean bool1 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.location.gps");
            boolean bool2 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.wifi");
            boolean bool3 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.telephony");
            localev.p = bool1;
            localev.o = bool2;
            localev.n = bool3;
            ev.a("AppContext", "doInBg: hasGps=" + bool1 + ",hasWifi=" + bool2 + ",hasCell=" + bool3);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("os:").append(Build.MODEL).append(" ").append(Build.VERSION.RELEASE).append(" ").append(localev.a()).append(" net:").append(localev.k).append(" ").append(localev.l).append(" app:").append(localPackageInfo.versionCode).append(" ").append(localPackageInfo.versionName).append(" sdk: ").append(localev.d()).append(" ").append(localev.e());
            ev.a("AppContext", ((StringBuilder)localObject1).toString());
            localev.q = de.b(localde.a);
            ev.a("AppContext", "doInBg: app status init done");
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            ev.a("AppContext", "doInBg: app status init error", localThrowable);
            continue;
          }
          de.b(de.this).countDown();
          return;
          localObject1 = "unknown";
        }
      }
    }).start();
  }
  
  public final void a(Object paramObject)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (this.o == null) {
          this.o = new ArrayList();
        }
        Object localObject1 = this.o.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label191;
        }
        localObject2 = ((ey)((Iterator)localObject1).next()).c;
        if (paramObject != localObject2) {
          continue;
        }
        i1 = 1;
        if (i1 != 0) {
          return;
        }
        localObject1 = paramObject.getClass().getDeclaredMethods();
        int i2 = localObject1.length;
        i1 = 0;
        if (i1 >= i2) {
          continue;
        }
        localObject2 = localObject1[i1];
        localObject3 = ((Method)localObject2).getName();
        if ((!((String)localObject3).startsWith("on")) || (!((String)localObject3).endsWith("Event"))) {
          break label184;
        }
        localObject3 = ((Method)localObject2).getParameterTypes();
        if (localObject3.length != 1) {
          throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
        }
      }
      finally {}
      Object localObject2 = new ey(localObject3[0], (Method)localObject2, paramObject);
      this.o.add(localObject2);
      label184:
      i1 += 1;
      continue;
      label191:
      int i1 = 0;
    }
  }
  
  /* Error */
  public final void b(@org.eclipse.jdt.annotation.Nullable Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 373	c/t/m/g/de:o	Ljava/util/List;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -9 -> 6
    //   18: aload_3
    //   19: invokeinterface 382 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 388 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_3
    //   35: invokeinterface 392 1 0
    //   40: checkcast 394	c/t/m/g/ey
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 401	java/lang/Object:getClass	()Ljava/lang/Class;
    //   49: aload 4
    //   51: getfield 442	c/t/m/g/ey:a	Ljava/lang/Class;
    //   54: invokevirtual 445	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: getfield 448	c/t/m/g/ey:b	Ljava/lang/reflect/Method;
    //   67: aload 4
    //   69: getfield 397	c/t/m/g/ey:c	Ljava/lang/Object;
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokevirtual 452	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -59 -> 25
    //   87: astore 4
    //   89: ldc 183
    //   91: ldc_w 344
    //   94: aload 4
    //   96: invokestatic 455	c/t/m/g/ev:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: goto -74 -> 25
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	de
    //   0	107	1	paramObject	Object
    //   57	2	2	bool	boolean
    //   13	22	3	localObject	Object
    //   43	25	4	localey	ey
    //   87	8	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	84	87	java/lang/Exception
    //   9	14	102	finally
    //   18	25	102	finally
    //   25	58	102	finally
    //   62	84	102	finally
    //   89	99	102	finally
  }
  
  public final boolean b()
  {
    return this.f != null;
  }
  
  public final boolean c()
  {
    return this.g != null;
  }
  
  public final boolean d()
  {
    return this.h != null;
  }
  
  public final ev e()
  {
    if (-1L > 0L) {}
    try
    {
      if (!this.m.await(-1L, TimeUnit.MILLISECONDS))
      {
        return null;
        this.m.await();
      }
      return this.b;
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  public final String f()
  {
    if (!dc.a().d("up_apps")) {
      return null;
    }
    int i2 = (int)(System.currentTimeMillis() / 86400000L % 5L);
    int i1;
    try
    {
      long l1 = Long.parseLong(this.k.substring(1));
      i1 = (int)(l1 % 5L);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        SharedPreferences localSharedPreferences;
        i1 = 0;
        continue;
        label310:
        i1 = 0;
      }
      label315:
      localException1.edit().putBoolean("flag", true).apply();
      str = b(localException2.toString());
      return str;
    }
    localSharedPreferences = this.a.getSharedPreferences("LocationSDK", 0);
    if (i2 == i1) {
      if (localSharedPreferences.getBoolean("flag", false)) {}
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.e.getInstalledPackages(8192);
        localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label315;
        }
        localPackageInfo = (PackageInfo)((Iterator)localObject1).next();
        i1 = localPackageInfo.applicationInfo.flags;
        localObject2 = localPackageInfo.applicationInfo;
        if ((i1 & 0x1) > 0) {
          continue;
        }
        localObject2 = localPackageInfo.applicationInfo.loadLabel(this.e).toString();
        if ((((String)localObject2).length() > 30) || (((String)localObject2).startsWith("com.")) || (((String)localObject2).contains("theme"))) {
          break label374;
        }
        if (!((String)localObject2).contains("CheilPengtai")) {
          break label310;
        }
      }
      catch (Exception localException2)
      {
        StringBuilder localStringBuilder;
        PackageInfo localPackageInfo;
        Object localObject2;
        localSharedPreferences.edit().putBoolean("flag", true).apply();
      }
      if (i1 == 0)
      {
        localStringBuilder.append(localPackageInfo.applicationInfo.packageName);
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append('_');
        localStringBuilder.append(localPackageInfo.versionName);
        localStringBuilder.append('|');
        continue;
        for (;;)
        {
          return null;
          String str;
          localException1.edit().putBoolean("flag", false).apply();
        }
        label374:
        i1 = 1;
      }
    }
  }
  
  final PackageInfo g()
  {
    try
    {
      PackageInfo localPackageInfo = this.e.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return new PackageInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.de
 * JD-Core Version:    0.7.0.1
 */