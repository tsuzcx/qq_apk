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
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class da
{
  private static volatile da n;
  public final Context a;
  private final db b;
  private final SharedPreferences c;
  private final ExecutorService d;
  private final HashMap<String, de> e;
  private final PackageManager f;
  private final TelephonyManager g;
  private final WifiManager h;
  private final LocationManager i;
  private final TencentHttpClient j;
  private final TencentHttpClient k;
  private CountDownLatch l;
  private String m;
  private List<et> o;
  
  private da(Context paramContext)
  {
    this.a = paramContext;
    this.f = paramContext.getPackageManager();
    this.g = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.h = ((WifiManager)paramContext.getSystemService("wifi"));
    this.i = ((LocationManager)paramContext.getSystemService("location"));
    this.c = paramContext.getSharedPreferences("LocationSDK", 0);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("channelId", f.a.e(paramContext.getPackageName()));
    this.j = TencentHttpClientFactory.getInstance().getTencentHttpClient(paramContext, (Bundle)localObject);
    this.k = TencentHttpClientFactory.getInstance().getTencentHttpURLConnection();
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.d = ((ExecutorService)localObject);
    this.e = new HashMap();
    this.e.put("cell", new df("cell"));
    this.b = new db(this);
    try
    {
      this.b.h = b(paramContext);
      a();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        f.a.b("AppContext", "transactionTooLarge");
      }
    }
  }
  
  public static da a(Context paramContext)
  {
    if (n == null) {}
    try
    {
      if (n == null) {
        n = new da(paramContext.getApplicationContext());
      }
      return n;
    }
    finally {}
  }
  
  private static String b(Context paramContext)
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
  
  private String b(String paramString)
  {
    db localdb = this.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", localdb.d());
    localHashMap.put("app_name", c(localdb.i));
    localHashMap.put("app_label", c(localdb.j));
    localHashMap.put("l", paramString);
    try
    {
      paramString = new JSONObject(localHashMap);
      localdb = this.b;
      localHashMap = new HashMap();
      localHashMap.put("imei", c(localdb.a()));
      localHashMap.put("imsi", c(localdb.b()));
      localHashMap.put("n", c(f.a.c(localdb.e)));
      localHashMap.put("qq", c(f.a.c(localdb.g)));
      localHashMap.put("mac", c(localdb.c().toLowerCase(Locale.ENGLISH)));
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
  
  private static int c(Context paramContext)
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
  
  private static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private PackageInfo o()
  {
    try
    {
      PackageInfo localPackageInfo = this.f.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return new PackageInfo();
  }
  
  public final de a(String paramString)
  {
    paramString = (de)this.e.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return dd.a;
  }
  
  public final String a(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    long l1 = System.currentTimeMillis();
    paramString = this.j.postSync(paramString, paramArrayOfByte);
    long l2 = System.currentTimeMillis();
    f.a.b("HalleyTimeCost:" + (l2 - l1));
    paramArrayOfByte = f.a.d((byte[])paramString.first);
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte, (String)paramString.second);
    }
    f.a.a("AppContext", "postSync: inflate failed");
    return "{}";
  }
  
  public final void a()
  {
    this.l = new CountDownLatch(1);
    new Thread(new Runnable()
    {
      public final void run()
      {
        da.a(da.this);
        da.this.n();
        da.b(da.this).countDown();
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
        localObject2 = ((et)((Iterator)localObject1).next()).c;
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
      Object localObject2 = new et(localObject3[0], (Method)localObject2, paramObject);
      this.o.add(localObject2);
      label184:
      i1 += 1;
      continue;
      label191:
      int i1 = 0;
    }
  }
  
  @Nullable
  public final SharedPreferences b()
  {
    return this.c;
  }
  
  public final String b(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    long l1 = System.currentTimeMillis();
    paramString = this.k.postSync(paramString, paramArrayOfByte);
    long l2 = System.currentTimeMillis();
    f.a.b("HttpUrlConnectionTimeCost:" + (l2 - l1));
    paramArrayOfByte = f.a.d((byte[])paramString.first);
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte, (String)paramString.second);
    }
    f.a.a("AppContext", "HttpUrlConnection postSync: inflate failed");
    return "{}";
  }
  
  /* Error */
  public final void b(@Nullable Object paramObject)
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
    //   10: getfield 421	c/t/m/g/da:o	Ljava/util/List;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -9 -> 6
    //   18: aload_3
    //   19: invokeinterface 430 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 436 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_3
    //   35: invokeinterface 440 1 0
    //   40: checkcast 442	c/t/m/g/et
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 448	java/lang/Object:getClass	()Ljava/lang/Class;
    //   49: aload 4
    //   51: getfield 495	c/t/m/g/et:a	Ljava/lang/Class;
    //   54: invokevirtual 498	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: getfield 501	c/t/m/g/et:b	Ljava/lang/reflect/Method;
    //   67: aload 4
    //   69: getfield 444	c/t/m/g/et:c	Ljava/lang/Object;
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokevirtual 505	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -59 -> 25
    //   87: astore 4
    //   89: ldc 180
    //   91: ldc 255
    //   93: aload 4
    //   95: invokestatic 508	c/t/m/g/f$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: goto -73 -> 25
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	da
    //   0	106	1	paramObject	Object
    //   57	2	2	bool	boolean
    //   13	22	3	localObject	Object
    //   43	25	4	localet	et
    //   87	7	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	84	87	java/lang/Exception
    //   9	14	101	finally
    //   18	25	101	finally
    //   25	58	101	finally
    //   62	84	101	finally
    //   89	98	101	finally
  }
  
  @Nullable
  public final TelephonyManager c()
  {
    return this.g;
  }
  
  @Nullable
  public final WifiManager d()
  {
    return this.h;
  }
  
  @Nullable
  public final LocationManager e()
  {
    return this.i;
  }
  
  public final boolean f()
  {
    return this.g != null;
  }
  
  public final boolean g()
  {
    return this.h != null;
  }
  
  public final boolean h()
  {
    return this.i != null;
  }
  
  public final db i()
  {
    return this.b;
  }
  
  public final db j()
  {
    if (-1L > 0L) {}
    try
    {
      if (!this.l.await(-1L, TimeUnit.MILLISECONDS))
      {
        return null;
        this.l.await();
      }
      return this.b;
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  public final ExecutorService k()
  {
    return this.d;
  }
  
  public final String l()
  {
    if (!cy.a().d("up_apps")) {
      return null;
    }
    int i2 = (int)(System.currentTimeMillis() / 86400000L % 5L);
    int i1;
    try
    {
      long l1 = Long.parseLong(this.m.substring(1));
      i1 = (int)(l1 % 5L);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        SharedPreferences localSharedPreferences;
        i1 = 0;
        continue;
        label288:
        i1 = 0;
      }
      label293:
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
        Object localObject1 = this.f.getInstalledPackages(8192);
        localStringBuilder = new StringBuilder();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label293;
        }
        localPackageInfo = (PackageInfo)((Iterator)localObject1).next();
        i1 = localPackageInfo.applicationInfo.flags;
        localObject2 = localPackageInfo.applicationInfo;
        if ((i1 & 0x1) > 0) {
          continue;
        }
        localObject2 = localPackageInfo.applicationInfo.loadLabel(this.f).toString();
        if ((((String)localObject2).length() > 30) || (((String)localObject2).startsWith("com.")) || (((String)localObject2).contains("theme"))) {
          break label352;
        }
        if (!((String)localObject2).contains("CheilPengtai")) {
          break label288;
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
        label352:
        i1 = 1;
      }
    }
  }
  
  public final TencentHttpClient m()
  {
    return this.j;
  }
  
  final void n()
  {
    try
    {
      f.a.a("AppContext", "doInBg: app status init start");
      db localdb = this.b;
      PackageInfo localPackageInfo = o();
      int i1 = localPackageInfo.versionCode;
      localdb.i = localPackageInfo.versionName;
      Object localObject1 = this.a.getApplicationInfo().loadLabel(this.f);
      if (localObject1 != null) {}
      for (localObject1 = localObject1.toString();; localObject1 = "unknown")
      {
        localdb.j = ((String)localObject1);
        localObject1 = this.g;
        if (localObject1 != null)
        {
          Object localObject2 = new int[2];
          en.a((TelephonyManager)localObject1, (int[])localObject2);
          localdb.k = localObject2[0];
          localdb.l = localObject2[1];
          localdb.b = ((TelephonyManager)localObject1).getPhoneType();
          localObject2 = er.a(((TelephonyManager)localObject1).getDeviceId(), er.a);
          String str = er.a(((TelephonyManager)localObject1).getSubscriberId(), er.b);
          localObject1 = er.a(((TelephonyManager)localObject1).getLine1Number(), er.c);
          this.m = ((String)localObject2);
          localdb.c = ((String)localObject2);
          localdb.d = str;
          localdb.e = ((String)localObject1);
        }
        localdb.f = er.a(es.a(this.a).replaceAll(":", "").toUpperCase(Locale.ENGLISH), er.d);
        localObject1 = this.f;
        boolean bool1 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.location.gps");
        boolean bool2 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.wifi");
        boolean bool3 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.telephony");
        f.a.a("AppContext", "doInBg: hasGps=" + bool1 + ",hasWifi=" + bool2 + ",hasCell=" + bool3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("os:").append(Build.MODEL).append(" ").append(Build.VERSION.RELEASE).append(" ").append(localdb.a()).append(" net:").append(localdb.k).append(" ").append(localdb.l).append(" app:").append(localPackageInfo.versionCode).append(" ").append(localPackageInfo.versionName).append(" sdk: ").append(localdb.d()).append(" ").append(localdb.e());
        f.a.a("AppContext", ((StringBuilder)localObject1).toString());
        localdb.n = c(this.a);
        f.a.a("AppContext", "doInBg: app status init done");
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      f.a.a("AppContext", "doInBg: app status init error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.da
 * JD-Core Version:    0.7.0.1
 */