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
import androidx.annotation.Nullable;
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

public class ea
{
  private static volatile ea n;
  public final Context a;
  public final du b;
  public final SharedPreferences c;
  public final ExecutorService d;
  final PackageManager e;
  public final TelephonyManager f;
  public final WifiManager g;
  public final LocationManager h;
  public final ey i;
  public final ey j;
  String k;
  private final HashMap<String, eb> l;
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
    new ez.1();
    this.i = new eo(paramContext, ((Bundle)localObject).getString("channelId"));
    new ez.1();
    this.j = new dy();
    localObject = new ea.1(this);
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.d = ((ExecutorService)localObject);
    this.l = new HashMap();
    this.l.put("cell", new ec("cell"));
    this.b = new du(this);
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
    if (n == null) {
      try
      {
        if (n == null) {
          n = new ea(paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return n;
  }
  
  static int b(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        break label34;
      }
      paramContext = paramContext.getPackageInfo("com.txy.anywhere", 4);
      if (paramContext == null) {
        break label34;
      }
      int i1 = paramContext.versionCode;
      return i1;
    }
    catch (Throwable paramContext)
    {
      label32:
      label34:
      break label32;
    }
    return -1;
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
      }
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private String g()
  {
    Object localObject1 = this.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", ((du)localObject1).d());
    localHashMap.put("app_name", b(((du)localObject1).h));
    localHashMap.put("app_label", b(((du)localObject1).j));
    if (!TextUtils.isEmpty(null)) {
      localHashMap.put("l", null);
    }
    try
    {
      localObject1 = new JSONObject(localHashMap);
      Object localObject2 = this.b;
      localHashMap = new HashMap();
      localHashMap.put("imei", b(((du)localObject2).a()));
      localHashMap.put("imsi", b(((du)localObject2).b()));
      localHashMap.put("mac", b(((du)localObject2).c().toLowerCase(Locale.ENGLISH)));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(Build.MANUFACTURER);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(Build.MODEL);
      localHashMap.put("model", b(((StringBuilder)localObject2).toString()));
      localObject1 = ((JSONObject)localObject1).put("attribute", new JSONObject(localHashMap)).toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public final eb a(String paramString)
  {
    return (eb)this.l.get(paramString);
  }
  
  /* Error */
  public final String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: lconst_0
    //   5: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   8: astore 4
    //   10: iload_1
    //   11: ifeq +146 -> 157
    //   14: invokestatic 355	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   17: ldc_w 357
    //   20: invokevirtual 359	c/t/m/g/da:d	(Ljava/lang/String;)Z
    //   23: ifne +6 -> 29
    //   26: ldc 238
    //   28: areturn
    //   29: lload_2
    //   30: aload_0
    //   31: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   34: ldc_w 361
    //   37: aload 4
    //   39: invokestatic 364	c/t/m/g/dy:b	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 346	java/lang/Long
    //   45: invokevirtual 367	java/lang/Long:longValue	()J
    //   48: lsub
    //   49: ldc2_w 368
    //   52: lcmp
    //   53: ifle +221 -> 274
    //   56: aload_0
    //   57: invokespecial 371	c/t/m/g/ea:g	()Ljava/lang/String;
    //   60: astore 4
    //   62: aload_0
    //   63: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   66: ldc_w 361
    //   69: lload_2
    //   70: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   76: aload_0
    //   77: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   80: ldc_w 376
    //   83: lload_2
    //   84: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   90: aload 4
    //   92: areturn
    //   93: astore 4
    //   95: aload_0
    //   96: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   99: ldc_w 361
    //   102: lload_2
    //   103: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   113: ldc_w 376
    //   116: lload_2
    //   117: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   123: aload 4
    //   125: athrow
    //   126: aload_0
    //   127: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   130: ldc_w 361
    //   133: lload_2
    //   134: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   140: aload_0
    //   141: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   144: ldc_w 376
    //   147: lload_2
    //   148: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   154: ldc 238
    //   156: areturn
    //   157: new 198	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   164: astore 5
    //   166: aload 5
    //   168: invokestatic 380	c/t/m/g/dp:a	()Landroid/content/Context;
    //   171: invokevirtual 92	android/content/Context:getPackageName	()Ljava/lang/String;
    //   174: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 5
    //   180: ldc_w 382
    //   183: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: lload_2
    //   188: aload 5
    //   190: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 81	c/t/m/g/dy:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   196: ldc_w 376
    //   199: aload 4
    //   201: invokestatic 364	c/t/m/g/dy:b	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: checkcast 346	java/lang/Long
    //   207: invokevirtual 367	java/lang/Long:longValue	()J
    //   210: lsub
    //   211: ldc2_w 383
    //   214: lcmp
    //   215: ifle +59 -> 274
    //   218: aload_0
    //   219: invokespecial 371	c/t/m/g/ea:g	()Ljava/lang/String;
    //   222: astore 4
    //   224: aload_0
    //   225: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   228: ldc_w 376
    //   231: lload_2
    //   232: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   235: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   238: aload 4
    //   240: areturn
    //   241: astore 4
    //   243: aload_0
    //   244: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   247: ldc_w 376
    //   250: lload_2
    //   251: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   254: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   257: aload 4
    //   259: athrow
    //   260: aload_0
    //   261: getfield 83	c/t/m/g/ea:c	Landroid/content/SharedPreferences;
    //   264: ldc_w 376
    //   267: lload_2
    //   268: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   271: invokestatic 374	c/t/m/g/dy:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   274: ldc 238
    //   276: areturn
    //   277: astore 4
    //   279: goto -153 -> 126
    //   282: astore 4
    //   284: goto -24 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	ea
    //   0	287	1	paramBoolean	boolean
    //   3	265	2	l1	long
    //   8	83	4	localObject1	Object
    //   93	107	4	localObject2	Object
    //   222	17	4	str	String
    //   241	17	4	localObject3	Object
    //   277	1	4	localException	Exception
    //   282	1	4	localThrowable	Throwable
    //   164	25	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   56	62	93	finally
    //   218	224	241	finally
    //   56	62	277	java/lang/Exception
    //   218	224	282	java/lang/Throwable
  }
  
  public final void a()
  {
    this.m = new CountDownLatch(1);
    new Thread(new ea.2(this), "locationsdk_initStatus").start();
  }
  
  public final void a(Object paramObject)
  {
    try
    {
      if (this.o == null) {
        this.o = new ArrayList();
      }
      Object localObject1 = this.o.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((fr)((Iterator)localObject1).next()).c;
        if (paramObject == localObject2)
        {
          i1 = 1;
          break label69;
        }
      }
      int i1 = 0;
      label69:
      if (i1 != 0) {
        return;
      }
      localObject1 = paramObject.getClass().getDeclaredMethods();
      int i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = localObject1[i1];
        Object localObject3 = ((Method)localObject2).getName();
        if ((((String)localObject3).startsWith("on")) && (((String)localObject3).endsWith("Event")))
        {
          localObject3 = ((Method)localObject2).getParameterTypes();
          if (localObject3.length == 1)
          {
            localObject2 = new fr(localObject3[0], (Method)localObject2, paramObject);
            this.o.add(localObject2);
          }
          else
          {
            throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
          }
        }
        i1 += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public final void b(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.o;
        if (localObject == null) {
          continue;
        }
        localObject = ((List)localObject).iterator();
      }
      finally
      {
        Object localObject;
        fr localfr;
        boolean bool;
        continue;
        throw paramObject;
        continue;
        continue;
      }
      if (((Iterator)localObject).hasNext())
      {
        localfr = (fr)((Iterator)localObject).next();
        bool = paramObject.getClass().equals(localfr.a);
        if (!bool) {
          continue;
        }
      }
      try
      {
        localfr.b.invoke(localfr.c, new Object[] { paramObject });
      }
      catch (Exception localException) {}
    }
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
  
  public final du e()
  {
    try
    {
      this.m.await();
      return this.b;
    }
    catch (InterruptedException localInterruptedException)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  final PackageInfo f()
  {
    try
    {
      PackageInfo localPackageInfo = this.e.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label18:
      break label18;
    }
    return new PackageInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ea
 * JD-Core Version:    0.7.0.1
 */