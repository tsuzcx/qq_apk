package com.tencent.beacon.core.info;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.core.e.b;
import com.tencent.beacon.core.e.g;
import com.tencent.beacon.upload.UploadStrategy;
import java.io.File;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public class e
{
  protected static e a;
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.toLowerCase();
  }
  
  private StringBuilder a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder;
  }
  
  public static e d(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new e();
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String l(Context paramContext)
  {
    String str = "unknown";
    e locale = a;
    if (locale != null) {
      str = locale.k(paramContext);
    }
    com.tencent.beacon.core.e.d.a("[core] NetWork Types:" + str, new Object[0]);
    return str;
  }
  
  private DisplayMetrics r(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.core.e.d.b("[model] getDisplayMetrics error!", new Object[0]);
      com.tencent.beacon.core.e.d.a(paramContext);
    }
    return null;
  }
  
  public String a(Context paramContext)
  {
    if (!UploadStrategy.IS_COLLECT_MAC)
    {
      com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return "";
    }
    if (paramContext == null)
    {
      com.tencent.beacon.core.e.d.b("[core] getMacAddress but context is null!", new Object[0]);
      return "";
    }
    StringBuilder localStringBuilder;
    try
    {
      paramContext = NetworkInterface.getNetworkInterfaces();
      if (paramContext != null)
      {
        localStringBuilder = new StringBuilder();
        while (paramContext.hasMoreElements())
        {
          Object localObject2 = (NetworkInterface)paramContext.nextElement();
          Object localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if ((localObject1 != null) && (localObject1.length != 0))
          {
            localObject2 = localStringBuilder.append(((NetworkInterface)localObject2).getName());
            localObject1 = ((StringBuilder)localObject2).append(":").append(a((byte[])localObject1));
            ((StringBuilder)localObject1).append(",");
            continue;
            com.tencent.beacon.core.e.d.a("[core] Mac Address:" + paramContext, new Object[0]);
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.core.e.d.a(paramContext);
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      paramContext = localStringBuilder.toString();
      continue;
      paramContext = "";
    }
  }
  
  public boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public String b()
  {
    Object localObject = "";
    try
    {
      String str = Build.VERSION.SDK;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.b("[core] getApiLevel error", new Object[0]);
        com.tencent.beacon.core.e.d.a(localThrowable);
      }
    }
    com.tencent.beacon.core.e.d.a("[core] apiLevel: %s", new Object[] { localObject });
    return localObject;
  }
  
  public String b(Context paramContext)
  {
    str2 = "";
    if (paramContext == null)
    {
      com.tencent.beacon.core.e.d.b("[core] getAndroidId but context is null!", new Object[0]);
      return "";
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getContentResolver();
        paramContext = Settings.Secure.getString(paramContext, "android_id");
        if (paramContext == null)
        {
          paramContext = "";
          com.tencent.beacon.core.e.d.d("[core] Android ID:" + paramContext, new Object[0]);
          return paramContext;
        }
        try
        {
          String str1 = paramContext.toLowerCase();
          paramContext = str1;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        paramContext = str2;
        continue;
      }
      com.tencent.beacon.core.e.d.b("[core] getAndroidId error!", new Object[0]);
      com.tencent.beacon.core.e.d.a(localThrowable1);
    }
  }
  
  public int c()
  {
    return Integer.parseInt(b());
  }
  
  public String c(Context paramContext)
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      if (i < 9)
      {
        com.tencent.beacon.core.e.d.b("[audit] Api level < 9;return null!", new Object[0]);
        return "";
      }
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.beacon.core.e.d.a("[audit] get app_last_updated_time:" + String.valueOf(paramContext.lastUpdateTime), new Object[0]);
      long l = paramContext.lastUpdateTime;
      return String.valueOf(l);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      com.tencent.beacon.core.e.d.a(paramContext);
      com.tencent.beacon.core.e.d.b("[audit] get app_last_updated_time failed!", new Object[0]);
    }
    return "";
  }
  
  public String d()
  {
    Object localObject = "";
    try
    {
      String str = Build.BRAND;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.b("getBrand error!", new Object[0]);
        com.tencent.beacon.core.e.d.a(localThrowable);
      }
    }
    com.tencent.beacon.core.e.d.a("[core] Brand:" + (String)localObject, new Object[0]);
    return localObject;
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: invokestatic 252	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   7: iconst_2
    //   8: anewarray 16	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc 254
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: ldc_w 256
    //   21: aastore
    //   22: invokevirtual 260	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   25: invokevirtual 266	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   28: astore_3
    //   29: new 268	java/io/BufferedReader
    //   32: dup
    //   33: new 270	java/io/InputStreamReader
    //   36: dup
    //   37: aload_3
    //   38: ldc_w 272
    //   41: invokestatic 278	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   44: invokespecial 281	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   47: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_3
    //   51: aload_3
    //   52: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +16 -> 75
    //   62: aload 4
    //   64: invokevirtual 290	java/lang/String:trim	()Ljava/lang/String;
    //   67: invokestatic 204	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   70: sipush 1000
    //   73: idiv
    //   74: istore_1
    //   75: aload_3
    //   76: invokevirtual 293	java/io/BufferedReader:close	()V
    //   79: iload_1
    //   80: ireturn
    //   81: astore_3
    //   82: aload_3
    //   83: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   86: iload_1
    //   87: ireturn
    //   88: astore 4
    //   90: aload 4
    //   92: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   95: iload_2
    //   96: istore_1
    //   97: aload_3
    //   98: ifnull -19 -> 79
    //   101: aload_3
    //   102: invokevirtual 293	java/io/BufferedReader:close	()V
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_3
    //   108: aload_3
    //   109: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 293	java/io/BufferedReader:close	()V
    //   126: aload 4
    //   128: athrow
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_3
    //   133: goto -43 -> 90
    //   136: astore_3
    //   137: aload_3
    //   138: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   141: goto -15 -> 126
    //   144: astore 4
    //   146: goto -28 -> 118
    //   149: astore 4
    //   151: goto -33 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	e
    //   3	94	1	i	int
    //   1	95	2	j	int
    //   28	48	3	localObject1	Object
    //   81	21	3	localIOException1	java.io.IOException
    //   107	2	3	localIOException2	java.io.IOException
    //   117	16	3	localObject2	Object
    //   136	2	3	localIOException3	java.io.IOException
    //   55	8	4	str	String
    //   88	3	4	localThrowable1	Throwable
    //   114	13	4	localObject3	Object
    //   129	1	4	localThrowable2	Throwable
    //   144	1	4	localObject4	Object
    //   149	1	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   75	79	81	java/io/IOException
    //   51	57	88	java/lang/Throwable
    //   62	75	88	java/lang/Throwable
    //   101	105	107	java/io/IOException
    //   4	29	114	finally
    //   29	51	114	finally
    //   4	29	129	java/lang/Throwable
    //   29	51	129	java/lang/Throwable
    //   122	126	136	java/io/IOException
    //   51	57	144	finally
    //   62	75	144	finally
    //   90	95	149	finally
  }
  
  public String e(Context paramContext)
  {
    if (!UploadStrategy.IS_COLLECT_MAC)
    {
      com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return "";
    }
    paramContext = b.e("/sys/class/net/eth0/address");
    if ((paramContext.trim().equals("")) || (paramContext.length() < 17)) {}
    for (paramContext = "";; paramContext = paramContext.toLowerCase().substring(0, 17))
    {
      com.tencent.beacon.core.e.d.a("[core] Ethernet Mac Address:" + paramContext, new Object[0]);
      return paramContext;
    }
  }
  
  /* Error */
  public String f()
  {
    // Byte code:
    //   0: ldc 14
    //   2: astore_3
    //   3: invokestatic 252	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: iconst_2
    //   7: anewarray 16	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 254
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: ldc_w 309
    //   20: aastore
    //   21: invokevirtual 260	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   24: invokevirtual 266	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   27: astore_2
    //   28: new 268	java/io/BufferedReader
    //   31: dup
    //   32: new 270	java/io/InputStreamReader
    //   35: dup
    //   36: aload_2
    //   37: ldc_w 272
    //   40: invokestatic 278	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   43: invokespecial 281	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   46: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 4
    //   51: aload 4
    //   53: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 5
    //   58: aload_3
    //   59: astore_2
    //   60: aload 5
    //   62: ifnull +34 -> 96
    //   65: aload 5
    //   67: ldc_w 311
    //   70: invokevirtual 315	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: istore_1
    //   74: iload_1
    //   75: ifeq -24 -> 51
    //   78: aload 5
    //   80: aload 5
    //   82: ldc 145
    //   84: invokevirtual 318	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   87: iconst_1
    //   88: iadd
    //   89: invokevirtual 321	java/lang/String:substring	(I)Ljava/lang/String;
    //   92: invokevirtual 290	java/lang/String:trim	()Ljava/lang/String;
    //   95: astore_2
    //   96: aload 4
    //   98: invokevirtual 293	java/io/BufferedReader:close	()V
    //   101: aload_2
    //   102: astore_3
    //   103: aload_3
    //   104: areturn
    //   105: astore_3
    //   106: aload_3
    //   107: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   110: aload_2
    //   111: areturn
    //   112: astore 5
    //   114: aload 4
    //   116: astore_2
    //   117: aload 5
    //   119: astore 4
    //   121: aload 4
    //   123: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   126: aload_2
    //   127: ifnull -24 -> 103
    //   130: aload_2
    //   131: invokevirtual 293	java/io/BufferedReader:close	()V
    //   134: ldc 14
    //   136: areturn
    //   137: astore_2
    //   138: aload_2
    //   139: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   142: ldc 14
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 293	java/io/BufferedReader:close	()V
    //   156: aload_3
    //   157: athrow
    //   158: astore 4
    //   160: aconst_null
    //   161: astore_2
    //   162: goto -41 -> 121
    //   165: astore_2
    //   166: aload_2
    //   167: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   170: goto -14 -> 156
    //   173: astore_3
    //   174: aload 4
    //   176: astore_2
    //   177: goto -29 -> 148
    //   180: astore_3
    //   181: goto -33 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	e
    //   73	2	1	bool	boolean
    //   27	104	2	localObject1	Object
    //   137	2	2	localIOException1	java.io.IOException
    //   147	15	2	localObject2	Object
    //   165	2	2	localIOException2	java.io.IOException
    //   176	1	2	localObject3	Object
    //   2	102	3	localObject4	Object
    //   105	2	3	localIOException3	java.io.IOException
    //   145	12	3	localObject5	Object
    //   173	1	3	localObject6	Object
    //   180	1	3	localObject7	Object
    //   49	73	4	localObject8	Object
    //   158	17	4	localThrowable1	Throwable
    //   56	25	5	str	String
    //   112	6	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   96	101	105	java/io/IOException
    //   51	58	112	java/lang/Throwable
    //   65	74	112	java/lang/Throwable
    //   78	96	112	java/lang/Throwable
    //   130	134	137	java/io/IOException
    //   3	28	145	finally
    //   28	51	145	finally
    //   3	28	158	java/lang/Throwable
    //   28	51	158	java/lang/Throwable
    //   152	156	165	java/io/IOException
    //   51	58	173	finally
    //   65	74	173	finally
    //   78	96	173	finally
    //   121	126	180	finally
  }
  
  /* Error */
  public String f(Context paramContext)
  {
    // Byte code:
    //   0: ldc 14
    //   2: astore_3
    //   3: getstatic 324	com/tencent/beacon/upload/UploadStrategy:IS_COLLECT_IMEI	Z
    //   6: ifne +23 -> 29
    //   9: ldc_w 326
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iconst_0
    //   19: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   22: aastore
    //   23: invokestatic 70	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: ldc 14
    //   28: areturn
    //   29: aload_1
    //   30: ifnonnull +16 -> 46
    //   33: ldc_w 328
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc 14
    //   45: areturn
    //   46: aload_1
    //   47: invokestatic 334	com/tencent/beacon/core/info/a:h	(Landroid/content/Context;)Z
    //   50: istore_2
    //   51: iload_2
    //   52: ifeq +24 -> 76
    //   55: aload_1
    //   56: ldc_w 336
    //   59: invokevirtual 85	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 338	android/telephony/TelephonyManager
    //   65: invokevirtual 341	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnonnull +35 -> 105
    //   73: ldc 14
    //   75: astore_3
    //   76: new 23	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 343
    //   86: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 193	com/tencent/beacon/core/e/d:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_3
    //   104: areturn
    //   105: aload_1
    //   106: invokevirtual 20	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   109: astore_3
    //   110: goto -34 -> 76
    //   113: astore_1
    //   114: ldc 14
    //   116: astore_1
    //   117: ldc_w 345
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_1
    //   128: astore_3
    //   129: goto -53 -> 76
    //   132: astore_3
    //   133: goto -16 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	e
    //   0	136	1	paramContext	Context
    //   50	2	2	bool	boolean
    //   2	127	3	localObject	Object
    //   132	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	51	113	java/lang/Throwable
    //   55	69	113	java/lang/Throwable
    //   105	110	132	java/lang/Throwable
  }
  
  public String g()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.e.d.b("[model] getCountry error!", new Object[0]);
      com.tencent.beacon.core.e.d.a(localThrowable);
    }
    return null;
  }
  
  public String g(Context paramContext)
  {
    if (!UploadStrategy.IS_COLLECT_IMEI) {
      com.tencent.beacon.core.e.d.a("[core] current collect imei2 be refused! isCollectImei2: %s", new Object[] { Boolean.valueOf(false) });
    }
    for (;;)
    {
      paramContext = null;
      return a(paramContext);
      if (Build.VERSION.SDK_INT < 26) {
        f(paramContext);
      } else {
        try
        {
          boolean bool = a.h(paramContext);
          if (bool) {
            paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getImei(1);
          }
        }
        catch (Throwable paramContext)
        {
          com.tencent.beacon.core.e.d.b("[core] getImei error!", new Object[0]);
        }
      }
    }
  }
  
  public String h()
  {
    Object localObject = "";
    try
    {
      String str = Build.MODEL;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.b("[core] getDeviceName error", new Object[0]);
        com.tencent.beacon.core.e.d.a(localThrowable);
      }
    }
    com.tencent.beacon.core.e.d.a("[core] model name: %s", new Object[] { localObject });
    return localObject;
  }
  
  /* Error */
  public String h(Context paramContext)
  {
    // Byte code:
    //   0: ldc 14
    //   2: astore_3
    //   3: getstatic 324	com/tencent/beacon/upload/UploadStrategy:IS_COLLECT_IMEI	Z
    //   6: ifne +23 -> 29
    //   9: ldc_w 326
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iconst_0
    //   19: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   22: aastore
    //   23: invokestatic 70	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: ldc 14
    //   28: areturn
    //   29: aload_1
    //   30: ifnonnull +16 -> 46
    //   33: ldc_w 379
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc 14
    //   45: areturn
    //   46: aload_1
    //   47: invokestatic 334	com/tencent/beacon/core/info/a:h	(Landroid/content/Context;)Z
    //   50: istore_2
    //   51: iload_2
    //   52: ifeq +24 -> 76
    //   55: aload_1
    //   56: ldc_w 336
    //   59: invokevirtual 85	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 338	android/telephony/TelephonyManager
    //   65: invokevirtual 382	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnonnull +35 -> 105
    //   73: ldc 14
    //   75: astore_3
    //   76: new 23	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 384
    //   86: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 70	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_3
    //   104: areturn
    //   105: aload_1
    //   106: invokevirtual 20	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   109: astore_3
    //   110: goto -34 -> 76
    //   113: astore_1
    //   114: ldc 14
    //   116: astore_1
    //   117: ldc_w 386
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_1
    //   128: astore_3
    //   129: goto -53 -> 76
    //   132: astore_3
    //   133: goto -16 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	e
    //   0	136	1	paramContext	Context
    //   50	2	2	bool	boolean
    //   2	127	3	localObject	Object
    //   132	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   46	51	113	java/lang/Throwable
    //   55	69	113	java/lang/Throwable
    //   105	110	132	java/lang/Throwable
  }
  
  public String i(Context paramContext)
  {
    Object localObject1 = "";
    if (!UploadStrategy.IS_COLLECT_MAC)
    {
      com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return "";
    }
    if (paramContext == null)
    {
      com.tencent.beacon.core.e.d.b("[core] getMacAddress but context is null!", new Object[0]);
      return "";
    }
    localObject2 = localObject1;
    for (;;)
    {
      try
      {
        i = Integer.valueOf(Build.VERSION.SDK).intValue();
        if (i < 23)
        {
          localObject2 = localObject1;
          paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
          if (paramContext == null)
          {
            paramContext = "";
            localObject1 = paramContext;
            com.tencent.beacon.core.e.d.a("[core] Mac Address:" + (String)localObject1, new Object[0]);
            return localObject1;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        int i;
        Object localObject3;
        int j;
        Context localContext;
        paramContext = (Context)localObject2;
        continue;
        continue;
      }
      try
      {
        localObject1 = paramContext.toLowerCase();
        paramContext = (Context)localObject1;
        continue;
        localObject2 = localObject1;
        localObject3 = new String[2];
        localObject3[0] = "/sys/class/net/wlan0/address";
        localObject3[1] = "/sys/devices/virtual/net/wlan0/address";
        localObject2 = localObject1;
        j = localObject3.length;
        i = 0;
        paramContext = "";
        if (i >= j) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject1 = b.e(localObject3[i]).toString().trim();
          paramContext = (Context)localObject1;
          if (paramContext == null) {}
        }
        catch (Throwable localThrowable3)
        {
          continue;
        }
        try
        {
          if (paramContext.length() > 0)
          {
            localObject1 = paramContext.toLowerCase();
            paramContext = (Context)localObject1;
            localObject1 = paramContext;
            localObject2 = paramContext;
            if (!"".equals(paramContext)) {
              continue;
            }
            localObject2 = paramContext;
            localObject3 = NetworkInterface.getNetworkInterfaces();
            localObject1 = paramContext;
            if (localObject3 == null) {
              continue;
            }
            localObject1 = paramContext;
            localObject2 = paramContext;
            if (!((Enumeration)localObject3).hasMoreElements()) {
              continue;
            }
            localObject2 = paramContext;
            localObject1 = (NetworkInterface)((Enumeration)localObject3).nextElement();
            localObject2 = paramContext;
            byte[] arrayOfByte = ((NetworkInterface)localObject1).getHardwareAddress();
            localObject2 = paramContext;
            if ((!"wlan0".equals(((NetworkInterface)localObject1).getName())) || (arrayOfByte == null)) {
              continue;
            }
            localObject2 = paramContext;
            if (arrayOfByte.length == 0) {
              continue;
            }
            localObject2 = paramContext;
            localObject1 = a(arrayOfByte).toString();
            continue;
          }
          i += 1;
        }
        catch (Throwable localThrowable4)
        {
          continue;
        }
        localThrowable1 = localThrowable1;
        com.tencent.beacon.core.e.d.a(localThrowable1);
        localContext = paramContext;
      }
    }
  }
  
  public boolean i()
  {
    return g.d().e();
  }
  
  public String j()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.e.d.b("[model] getLanguage error!", new Object[0]);
      com.tencent.beacon.core.e.d.a(localThrowable);
    }
    return null;
  }
  
  /* Error */
  public String j(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 324	com/tencent/beacon/upload/UploadStrategy:IS_COLLECT_IMEI	Z
    //   5: ifne +26 -> 31
    //   8: ldc_w 428
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iconst_0
    //   18: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic 70	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: aload_3
    //   27: invokespecial 361	com/tencent/beacon/core/info/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   30: areturn
    //   31: getstatic 365	android/os/Build$VERSION:SDK_INT	I
    //   34: bipush 26
    //   36: if_icmpge +12 -> 48
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 367	com/tencent/beacon/core/info/e:f	(Landroid/content/Context;)Ljava/lang/String;
    //   44: astore_3
    //   45: goto -20 -> 25
    //   48: aload_1
    //   49: invokestatic 334	com/tencent/beacon/core/info/a:h	(Landroid/content/Context;)Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifeq -29 -> 25
    //   57: aload_1
    //   58: ldc_w 336
    //   61: invokevirtual 85	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   64: checkcast 338	android/telephony/TelephonyManager
    //   67: invokevirtual 431	android/telephony/TelephonyManager:getMeid	()Ljava/lang/String;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnonnull +9 -> 81
    //   75: ldc 14
    //   77: astore_3
    //   78: goto -53 -> 25
    //   81: aload_1
    //   82: invokevirtual 20	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   85: astore_3
    //   86: goto -61 -> 25
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_1
    //   92: ldc_w 345
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_1
    //   103: astore_3
    //   104: goto -79 -> 25
    //   107: astore_3
    //   108: goto -16 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	e
    //   0	111	1	paramContext	Context
    //   52	2	2	bool	boolean
    //   1	103	3	localObject	Object
    //   107	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   48	53	89	java/lang/Throwable
    //   57	71	89	java/lang/Throwable
    //   81	86	107	java/lang/Throwable
  }
  
  public String k()
  {
    return Build.MANUFACTURER;
  }
  
  public String k(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return "unknown";
        }
        i = localNetworkInfo.getType();
        if (i != 1) {
          continue;
        }
        paramContext = "wifi";
      }
      catch (Exception paramContext)
      {
        NetworkInfo localNetworkInfo;
        int i;
        com.tencent.beacon.core.e.d.a(paramContext);
        paramContext = "unknown";
        continue;
      }
      com.tencent.beacon.core.e.d.a("[core] NetWork Type:" + paramContext, new Object[0]);
      return paramContext;
      i = localNetworkInfo.getType();
      if (i != 0) {
        continue;
      }
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        continue;
      }
      i = paramContext.getNetworkType();
      switch (i)
      {
      default: 
        paramContext = "unknown";
        break;
      case 15: 
        paramContext = "HSPA+";
        break;
      case 14: 
        paramContext = "eHRPD";
        break;
      case 13: 
        paramContext = "LTE";
        break;
      case 12: 
        paramContext = "EVDO_B";
        break;
      case 11: 
        paramContext = "iDen";
        break;
      case 10: 
        paramContext = "HSPA";
        break;
      case 9: 
        paramContext = "HSUPA";
        break;
      case 8: 
        paramContext = "HSDPA";
        break;
      case 7: 
        paramContext = "1xRTT";
        break;
      case 6: 
        paramContext = "EVDO_A";
        break;
      case 5: 
        paramContext = "EVDO_0";
        break;
      case 4: 
        paramContext = "CDMA";
        break;
      case 3: 
        paramContext = "UMTS";
        break;
      case 2: 
        paramContext = "EDGE";
        break;
      case 1: 
        paramContext = "GPRS";
      }
    }
  }
  
  /* Error */
  public String l()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 23	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: new 268	java/io/BufferedReader
    //   16: dup
    //   17: new 486	java/io/FileReader
    //   20: dup
    //   21: new 488	java/io/File
    //   24: dup
    //   25: ldc_w 490
    //   28: invokespecial 493	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 496	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   34: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload 4
    //   40: aload_1
    //   41: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   52: aload 4
    //   54: ldc 152
    //   56: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: new 268	java/io/BufferedReader
    //   63: dup
    //   64: new 486	java/io/FileReader
    //   67: dup
    //   68: new 488	java/io/File
    //   71: dup
    //   72: ldc_w 501
    //   75: invokespecial 493	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: invokespecial 496	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   81: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   84: astore_1
    //   85: aload 4
    //   87: aload_1
    //   88: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   91: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   99: aload 4
    //   101: ldc 152
    //   103: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: new 268	java/io/BufferedReader
    //   110: dup
    //   111: new 486	java/io/FileReader
    //   114: dup
    //   115: new 488	java/io/File
    //   118: dup
    //   119: ldc_w 503
    //   122: invokespecial 493	java/io/File:<init>	(Ljava/lang/String;)V
    //   125: invokespecial 496	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   128: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   131: astore_1
    //   132: aload 4
    //   134: aload_1
    //   135: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   138: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   146: aload 4
    //   148: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_1
    //   152: new 23	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 505
    //   162: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_1
    //   166: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 70	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_1
    //   180: areturn
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_1
    //   185: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_1
    //   194: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   197: goto -145 -> 52
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: aload_3
    //   204: astore_1
    //   205: aload_2
    //   206: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_1
    //   215: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   218: goto -119 -> 99
    //   221: astore_3
    //   222: aload_1
    //   223: astore_2
    //   224: aload_3
    //   225: astore_1
    //   226: aload_2
    //   227: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: invokestatic 499	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   239: goto -93 -> 146
    //   242: astore_1
    //   243: goto -17 -> 226
    //   246: astore_2
    //   247: goto -12 -> 235
    //   250: astore_1
    //   251: aload_3
    //   252: astore_2
    //   253: goto -48 -> 205
    //   256: astore_3
    //   257: goto -43 -> 214
    //   260: astore 5
    //   262: goto -69 -> 193
    //   265: astore_2
    //   266: goto -82 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	e
    //   37	148	1	localObject1	Object
    //   190	1	1	localException1	Exception
    //   192	18	1	localObject2	Object
    //   211	1	1	localException2	Exception
    //   213	18	1	localObject3	Object
    //   232	1	1	localException3	Exception
    //   234	2	1	localCloseable	java.io.Closeable
    //   242	1	1	localObject4	Object
    //   250	1	1	localObject5	Object
    //   1	1	2	localObject6	Object
    //   181	8	2	localObject7	Object
    //   202	25	2	localObject8	Object
    //   246	1	2	localException4	Exception
    //   252	1	2	localObject9	Object
    //   265	1	2	localObject10	Object
    //   3	1	3	localObject11	Object
    //   200	4	3	localObject12	Object
    //   221	31	3	localObject13	Object
    //   256	1	3	localException5	Exception
    //   11	136	4	localStringBuilder	StringBuilder
    //   260	1	5	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   13	38	181	finally
    //   13	38	190	java/lang/Exception
    //   85	95	200	finally
    //   60	85	211	java/lang/Exception
    //   132	142	221	finally
    //   107	132	232	java/lang/Exception
    //   107	132	242	finally
    //   132	142	246	java/lang/Exception
    //   60	85	250	finally
    //   85	95	256	java/lang/Exception
    //   38	48	260	java/lang/Exception
    //   38	48	265	finally
  }
  
  public int m()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new d(this));
      if (arrayOfFile == null) {
        return 1;
      }
      int i = arrayOfFile.length;
      return i;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.e.d.b("[model] CPU Count: Failed.", new Object[0]);
      com.tencent.beacon.core.e.d.a(localException);
    }
    return 1;
  }
  
  public String m(Context paramContext)
  {
    paramContext = r(paramContext);
    if (paramContext == null) {
      return "";
    }
    return paramContext.widthPixels + "*" + paramContext.heightPixels;
  }
  
  public int n(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext != null)
      {
        paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (localDisplayMetrics.density - 1.0F <= 1.0E-006D) {
          return 160;
        }
        if (localDisplayMetrics.density - 0.75D <= 1.0E-006D) {
          return 120;
        }
        if (localDisplayMetrics.density - 1.5D <= 1.0E-006D) {
          return 240;
        }
        if (localDisplayMetrics.density - 2.0D <= 1.0E-006D) {
          return 320;
        }
        float f = localDisplayMetrics.density;
        if (f - 3.0D <= 1.0E-006D) {
          return 480;
        }
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.core.e.d.a(paramContext);
    }
    return 160;
  }
  
  public String n()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Android ");
    ((StringBuffer)localObject).append(r());
    ((StringBuffer)localObject).append(",level ");
    ((StringBuffer)localObject).append(b());
    localObject = ((StringBuffer)localObject).toString();
    com.tencent.beacon.core.e.d.a("[core] os version: %s", new Object[] { localObject });
    return localObject;
  }
  
  /* Error */
  public String o()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 486	java/io/FileReader
    //   6: dup
    //   7: ldc_w 565
    //   10: invokespecial 566	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 6
    //   15: new 268	java/io/BufferedReader
    //   18: dup
    //   19: aload 6
    //   21: sipush 8192
    //   24: invokespecial 569	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +97 -> 133
    //   39: aload 4
    //   41: ldc_w 571
    //   44: iconst_2
    //   45: invokevirtual 575	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   48: iconst_1
    //   49: aaload
    //   50: invokevirtual 20	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   53: astore 4
    //   55: aload 4
    //   57: ldc_w 577
    //   60: ldc 14
    //   62: invokevirtual 581	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: invokevirtual 290	java/lang/String:trim	()Ljava/lang/String;
    //   68: invokestatic 587	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   71: ldc2_w 588
    //   74: ldiv
    //   75: lstore_1
    //   76: new 23	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   83: lload_1
    //   84: invokevirtual 592	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: astore 4
    //   89: aload 4
    //   91: ldc 14
    //   93: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload_3
    //   102: invokevirtual 293	java/io/BufferedReader:close	()V
    //   105: aload 6
    //   107: invokevirtual 593	java/io/FileReader:close	()V
    //   110: aload 4
    //   112: astore_3
    //   113: aload_3
    //   114: areturn
    //   115: astore_3
    //   116: ldc_w 595
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_3
    //   127: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   130: aload 4
    //   132: areturn
    //   133: aload_3
    //   134: invokevirtual 293	java/io/BufferedReader:close	()V
    //   137: aload 6
    //   139: invokevirtual 593	java/io/FileReader:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: ldc_w 595
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   159: aconst_null
    //   160: areturn
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_3
    //   165: aload 6
    //   167: astore 5
    //   169: aload_3
    //   170: ifnull +7 -> 177
    //   173: aload_3
    //   174: invokevirtual 293	java/io/BufferedReader:close	()V
    //   177: aload 5
    //   179: ifnull +8 -> 187
    //   182: aload 5
    //   184: invokevirtual 593	java/io/FileReader:close	()V
    //   187: aload 4
    //   189: athrow
    //   190: astore 5
    //   192: aconst_null
    //   193: astore_3
    //   194: aload 6
    //   196: astore 4
    //   198: ldc_w 597
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 5
    //   210: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 293	java/io/BufferedReader:close	()V
    //   221: aload 7
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull -113 -> 113
    //   229: aload 4
    //   231: invokevirtual 593	java/io/FileReader:close	()V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_3
    //   237: ldc_w 595
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload_3
    //   248: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   251: aconst_null
    //   252: areturn
    //   253: astore 4
    //   255: aconst_null
    //   256: astore_3
    //   257: aconst_null
    //   258: astore 5
    //   260: goto -91 -> 169
    //   263: astore 5
    //   265: aconst_null
    //   266: astore_3
    //   267: aconst_null
    //   268: astore 4
    //   270: goto -72 -> 198
    //   273: astore_3
    //   274: ldc_w 595
    //   277: iconst_0
    //   278: anewarray 4	java/lang/Object
    //   281: invokestatic 102	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: aload_3
    //   285: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   288: goto -101 -> 187
    //   291: astore 6
    //   293: aload 4
    //   295: astore 5
    //   297: aload 6
    //   299: astore 4
    //   301: goto -132 -> 169
    //   304: astore 5
    //   306: aload 6
    //   308: astore 4
    //   310: goto -112 -> 198
    //   313: astore 4
    //   315: aload 6
    //   317: astore 5
    //   319: goto -150 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	e
    //   75	9	1	l	long
    //   27	87	3	localObject1	Object
    //   115	19	3	localThrowable1	Throwable
    //   144	12	3	localThrowable2	Throwable
    //   164	60	3	localObject2	Object
    //   236	12	3	localThrowable3	Throwable
    //   256	11	3	localObject3	Object
    //   273	12	3	localThrowable4	Throwable
    //   32	99	4	localObject4	Object
    //   161	27	4	localObject5	Object
    //   196	34	4	localFileReader1	java.io.FileReader
    //   253	1	4	localObject6	Object
    //   268	41	4	localObject7	Object
    //   313	1	4	localObject8	Object
    //   167	16	5	localFileReader2	java.io.FileReader
    //   190	19	5	localThrowable5	Throwable
    //   258	1	5	localObject9	Object
    //   263	1	5	localThrowable6	Throwable
    //   295	1	5	localObject10	Object
    //   304	1	5	localThrowable7	Throwable
    //   317	1	5	localObject11	Object
    //   13	182	6	localFileReader3	java.io.FileReader
    //   291	25	6	localObject12	Object
    //   1	221	7	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   101	110	115	java/lang/Throwable
    //   133	142	144	java/lang/Throwable
    //   15	28	161	finally
    //   15	28	190	java/lang/Throwable
    //   217	221	236	java/lang/Throwable
    //   229	234	236	java/lang/Throwable
    //   3	15	253	finally
    //   3	15	263	java/lang/Throwable
    //   173	177	273	java/lang/Throwable
    //   182	187	273	java/lang/Throwable
    //   198	213	291	finally
    //   28	34	304	java/lang/Throwable
    //   39	55	304	java/lang/Throwable
    //   55	89	304	java/lang/Throwable
    //   89	101	304	java/lang/Throwable
    //   28	34	313	finally
    //   39	55	313	finally
    //   55	89	313	finally
    //   89	101	313	finally
  }
  
  public String o(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.core.e.d.b("[core] getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null) {}
      for (paramContext = paramContext.getBSSID();; paramContext = "")
      {
        com.tencent.beacon.core.e.d.a("[core] Wifi SSID:" + paramContext, new Object[0]);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.a(paramContext);
        com.tencent.beacon.core.e.d.b("getWifiSSID error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public String p()
  {
    ArrayList localArrayList = b.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public String p(Context paramContext)
  {
    if (!UploadStrategy.IS_COLLECT_MAC)
    {
      com.tencent.beacon.core.e.d.a("[core] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return "";
    }
    if (paramContext == null)
    {
      com.tencent.beacon.core.e.d.b("[core] getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      com.tencent.beacon.core.e.d.a("[core] Wifi BSSID:" + paramContext, new Object[0]);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.a(paramContext);
        com.tencent.beacon.core.e.d.b("getMacAddress error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public String q()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject2).getBlockSize();
      long l2 = ((StatFs)localObject2).getBlockCount();
      localObject2 = new StringBuilder().append(l2 * l1 / 1024L / 1024L);
      localObject2 = "";
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.b("getDisplayMetrics error!", new Object[0]);
        com.tencent.beacon.core.e.d.a(localThrowable);
      }
    }
    com.tencent.beacon.core.e.d.a("[core] Rom Size:" + localObject1, new Object[0]);
    return localObject1;
  }
  
  public String q(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.core.e.d.b("[core] getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getSSID() != null) {}
      for (paramContext = paramContext.getSSID();; paramContext = "")
      {
        com.tencent.beacon.core.e.d.a("[core] Wifi SSID:" + paramContext, new Object[0]);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.a(paramContext);
        com.tencent.beacon.core.e.d.b("getWifiSSID error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public String r()
  {
    Object localObject = "";
    try
    {
      String str = Build.VERSION.RELEASE;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.b("[core] getVersion error", new Object[0]);
        com.tencent.beacon.core.e.d.a(localThrowable);
      }
    }
    com.tencent.beacon.core.e.d.a("[core] version: %s", new Object[] { localObject });
    return localObject;
  }
  
  /* Error */
  public boolean s()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: new 268	java/io/BufferedReader
    //   10: dup
    //   11: new 270	java/io/InputStreamReader
    //   14: dup
    //   15: invokestatic 252	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: iconst_2
    //   19: anewarray 16	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 254
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc_w 309
    //   32: aastore
    //   33: invokevirtual 260	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   36: invokevirtual 266	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokestatic 667	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   42: invokespecial 281	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   45: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 6
    //   57: iload_3
    //   58: istore_1
    //   59: aload 6
    //   61: ifnull +25 -> 86
    //   64: aload 6
    //   66: invokevirtual 20	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   69: astore 6
    //   71: aload 6
    //   73: ldc_w 669
    //   76: invokevirtual 315	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   79: istore_1
    //   80: iload_1
    //   81: ifeq -31 -> 50
    //   84: iconst_1
    //   85: istore_1
    //   86: iload_1
    //   87: istore_2
    //   88: aload 5
    //   90: invokevirtual 293	java/io/BufferedReader:close	()V
    //   93: iload_1
    //   94: ireturn
    //   95: astore 5
    //   97: aload 5
    //   99: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   102: iload_2
    //   103: ireturn
    //   104: astore 6
    //   106: aload 6
    //   108: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   111: iload 4
    //   113: istore_1
    //   114: aload 5
    //   116: ifnull -23 -> 93
    //   119: aload 5
    //   121: invokevirtual 293	java/io/BufferedReader:close	()V
    //   124: iconst_0
    //   125: ireturn
    //   126: astore 6
    //   128: aconst_null
    //   129: astore 5
    //   131: aload 5
    //   133: ifnull +8 -> 141
    //   136: aload 5
    //   138: invokevirtual 293	java/io/BufferedReader:close	()V
    //   141: aload 6
    //   143: athrow
    //   144: astore 6
    //   146: aconst_null
    //   147: astore 5
    //   149: goto -43 -> 106
    //   152: astore 5
    //   154: aload 5
    //   156: invokestatic 105	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   159: goto -18 -> 141
    //   162: astore 6
    //   164: goto -33 -> 131
    //   167: astore 6
    //   169: goto -38 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	e
    //   58	56	1	bool1	boolean
    //   4	99	2	bool2	boolean
    //   6	52	3	bool3	boolean
    //   1	111	4	bool4	boolean
    //   48	41	5	localBufferedReader	java.io.BufferedReader
    //   95	25	5	localIOException1	java.io.IOException
    //   129	19	5	localObject1	Object
    //   152	3	5	localIOException2	java.io.IOException
    //   55	17	6	str	String
    //   104	3	6	localThrowable1	Throwable
    //   126	16	6	localObject2	Object
    //   144	1	6	localThrowable2	Throwable
    //   162	1	6	localObject3	Object
    //   167	1	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   119	124	95	java/io/IOException
    //   50	57	104	java/lang/Throwable
    //   64	71	104	java/lang/Throwable
    //   71	80	104	java/lang/Throwable
    //   7	50	126	finally
    //   7	50	144	java/lang/Throwable
    //   136	141	152	java/io/IOException
    //   50	57	162	finally
    //   64	71	162	finally
    //   71	80	162	finally
    //   106	111	167	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.info.e
 * JD-Core Version:    0.7.0.1
 */