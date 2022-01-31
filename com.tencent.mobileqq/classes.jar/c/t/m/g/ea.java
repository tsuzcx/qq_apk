package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class ea
{
  private static volatile ea n;
  public final Context a;
  public final eb b;
  public final SharedPreferences c;
  public final ExecutorService d;
  final PackageManager e;
  public final TelephonyManager f;
  public final WifiManager g;
  public final LocationManager h;
  public final ez i;
  public final ez j;
  String k;
  private final HashMap<String, ec> l;
  private CountDownLatch m;
  private List<fr> o;
  
  private ea(Context paramContext)
  {
    this.a = paramContext;
    this.e = paramContext.getPackageManager();
    this.f = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.g = ((WifiManager)paramContext.getSystemService("wifi"));
    this.h = ((LocationManager)paramContext.getSystemService("location"));
    this.c = dy.a("LocationSDK");
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("channelId", co.d(paramContext.getPackageName()));
    new fa.1();
    this.i = new ep(paramContext, ((Bundle)localObject).getString("channelId"));
    new fa.1();
    this.j = new dw();
    localObject = new ea.1(this);
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.d = ((ExecutorService)localObject);
    this.l = new HashMap();
    this.l.put("cell", new ed("cell"));
    this.b = new eb(this);
    try
    {
      this.b.g = c(paramContext);
      label235:
      a();
      return;
    }
    catch (Throwable paramContext)
    {
      break label235;
    }
  }
  
  public static ea a(Context paramContext)
  {
    if (n == null) {}
    try
    {
      if (n == null) {
        n = new ea(paramContext.getApplicationContext());
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
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
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
  
  private String g()
  {
    Object localObject1 = this.b;
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("version", ((eb)localObject1).d());
    ((HashMap)localObject2).put("app_name", b(((eb)localObject1).h));
    ((HashMap)localObject2).put("app_label", b(((eb)localObject1).j));
    if (!TextUtils.isEmpty(null)) {
      ((HashMap)localObject2).put("l", null);
    }
    try
    {
      localObject1 = new JSONObject((Map)localObject2);
      localObject2 = this.b;
      HashMap localHashMap = new HashMap();
      localHashMap.put("imei", b(((eb)localObject2).a()));
      localHashMap.put("imsi", b(((eb)localObject2).b()));
      localHashMap.put("mac", b(((eb)localObject2).c().toLowerCase(Locale.ENGLISH)));
      localHashMap.put("model", b(Build.MANUFACTURER + "_" + Build.MODEL));
      localObject1 = ((JSONObject)localObject1).put("attribute", new JSONObject(localHashMap)).toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public final ec a(String paramString)
  {
    return (ec)this.l.get(paramString);
  }
  
  /* Error */
  public final String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 346	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: iload_1
    //   5: ifeq +150 -> 155
    //   8: invokestatic 351	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   11: ldc_w 353
    //   14: invokevirtual 355	c/t/m/g/da:d	(Ljava/lang/String;)Z
    //   17: ifne +6 -> 23
    //   20: ldc 240
    //   22: areturn
    //   23: lload_2
    //   24: aload_0
    //   25: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   28: ldc_w 357
    //   31: lconst_0
    //   32: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: invokestatic 366	c/t/m/g/dy:b	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 359	java/lang/Long
    //   41: invokevirtual 369	java/lang/Long:longValue	()J
    //   44: lsub
    //   45: ldc2_w 370
    //   48: lcmp
    //   49: ifle +70 -> 119
    //   52: aload_0
    //   53: invokespecial 373	c/t/m/g/ea:g	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   62: ldc_w 357
    //   65: lload_2
    //   66: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   72: aload_0
    //   73: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   76: ldc_w 378
    //   79: lload_2
    //   80: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   83: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   86: aload 4
    //   88: areturn
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   95: ldc_w 357
    //   98: lload_2
    //   99: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   105: aload_0
    //   106: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   109: ldc_w 378
    //   112: lload_2
    //   113: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   119: ldc 240
    //   121: areturn
    //   122: astore 4
    //   124: aload_0
    //   125: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   128: ldc_w 357
    //   131: lload_2
    //   132: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   138: aload_0
    //   139: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   142: ldc_w 378
    //   145: lload_2
    //   146: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   152: aload 4
    //   154: athrow
    //   155: lload_2
    //   156: new 202	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   163: invokestatic 382	c/t/m/g/dp:a	()Landroid/content/Context;
    //   166: invokevirtual 92	android/content/Context:getPackageName	()Ljava/lang/String;
    //   169: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 384
    //   175: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 81	c/t/m/g/dy:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   184: ldc_w 378
    //   187: lconst_0
    //   188: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: invokestatic 366	c/t/m/g/dy:b	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: checkcast 359	java/lang/Long
    //   197: invokevirtual 369	java/lang/Long:longValue	()J
    //   200: lsub
    //   201: ldc2_w 385
    //   204: lcmp
    //   205: ifle -86 -> 119
    //   208: aload_0
    //   209: invokespecial 373	c/t/m/g/ea:g	()Ljava/lang/String;
    //   212: astore 4
    //   214: aload_0
    //   215: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   218: ldc_w 378
    //   221: lload_2
    //   222: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   225: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   228: aload 4
    //   230: areturn
    //   231: astore 4
    //   233: aload_0
    //   234: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   237: ldc_w 378
    //   240: lload_2
    //   241: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   247: goto -128 -> 119
    //   250: astore 4
    //   252: aload_0
    //   253: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   256: ldc_w 378
    //   259: lload_2
    //   260: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   263: invokestatic 376	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   266: aload 4
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	ea
    //   0	269	1	paramBoolean	boolean
    //   3	257	2	l1	long
    //   56	31	4	str1	String
    //   89	1	4	localException	Exception
    //   122	31	4	localObject1	Object
    //   212	17	4	str2	String
    //   231	1	4	localThrowable	Throwable
    //   250	17	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   52	58	89	java/lang/Exception
    //   52	58	122	finally
    //   208	214	231	java/lang/Throwable
    //   208	214	250	finally
  }
  
  public final void a()
  {
    this.m = new CountDownLatch(1);
    new Thread(new ea.2(this), "locationsdk_initStatus").start();
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
        localObject2 = ((fr)((Iterator)localObject1).next()).c;
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
      Object localObject2 = new fr(localObject3[0], (Method)localObject2, paramObject);
      this.o.add(localObject2);
      label184:
      i1 += 1;
      continue;
      label191:
      int i1 = 0;
    }
  }
  
  /* Error */
  public final void b(@androidx.annotation.Nullable Object paramObject)
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
    //   10: getfield 407	c/t/m/g/ea:o	Ljava/util/List;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -9 -> 6
    //   18: aload_3
    //   19: invokeinterface 416 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 422 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_3
    //   35: invokeinterface 426 1 0
    //   40: checkcast 428	c/t/m/g/fr
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 435	java/lang/Object:getClass	()Ljava/lang/Class;
    //   49: aload 4
    //   51: getfield 476	c/t/m/g/fr:a	Ljava/lang/Class;
    //   54: invokevirtual 479	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: getfield 482	c/t/m/g/fr:b	Ljava/lang/reflect/Method;
    //   67: aload 4
    //   69: getfield 431	c/t/m/g/fr:c	Ljava/lang/Object;
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokevirtual 486	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -59 -> 25
    //   87: astore 4
    //   89: goto -64 -> 25
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	ea
    //   0	97	1	paramObject	Object
    //   57	2	2	bool	boolean
    //   13	22	3	localObject	Object
    //   43	25	4	localfr	fr
    //   87	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	84	87	java/lang/Exception
    //   9	14	92	finally
    //   18	25	92	finally
    //   25	58	92	finally
    //   62	84	92	finally
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
  
  public final eb e()
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
  
  final PackageInfo f()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ea
 * JD-Core Version:    0.7.0.1
 */