package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
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
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Locale;

public class b
{
  private static final String[] a = { "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  private static final String[] b = { "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  private static final String[] c = { "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd" };
  private static String d = null;
  private static String e = null;
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: ldc 204
    //   9: invokestatic 209	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   12: ifne +15 -> 27
    //   15: ldc 211
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 214	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: aconst_null
    //   26: areturn
    //   27: aload_0
    //   28: ldc 216
    //   30: invokevirtual 222	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 224	android/telephony/TelephonyManager
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +43 -> 81
    //   41: aload_0
    //   42: invokevirtual 227	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: ifnull +8 -> 57
    //   52: aload_1
    //   53: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   56: astore_0
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: ldc 232
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 234	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   71: pop
    //   72: goto -15 -> 57
    //   75: astore_0
    //   76: aload_1
    //   77: astore_0
    //   78: goto -16 -> 62
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -26 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramContext	Context
    //   45	32	1	str	String
    // Exception table:
    //   from	to	target	type
    //   27	37	59	java/lang/Throwable
    //   41	46	59	java/lang/Throwable
    //   52	57	75	java/lang/Throwable
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramBoolean) {}
    try
    {
      localObject1 = z.a(paramContext, "ro.product.cpu.abilist");
      Object localObject2;
      if (!z.a((String)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals("fail")) {}
      }
      else
      {
        localObject2 = z.a(paramContext, "ro.product.cpu.abi");
      }
      localObject1 = localObject3;
      if (!z.a((String)localObject2)) {
        if (!((String)localObject2).equals("fail")) {
          break label91;
        }
      }
      for (localObject1 = localObject3;; localObject1 = localObject2.split(",")[0])
      {
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = System.getProperty("os.arch");
        }
        return paramContext;
        label91:
        x.b(b.class, "ABI list: " + (String)localObject2, new Object[0]);
      }
      return "fail";
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: ldc 204
    //   9: invokestatic 209	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   12: ifne +16 -> 28
    //   15: ldc_w 290
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 214	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: ldc 216
    //   31: invokevirtual 222	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   34: checkcast 224	android/telephony/TelephonyManager
    //   37: astore_0
    //   38: aload_0
    //   39: ifnull +44 -> 83
    //   42: aload_0
    //   43: invokevirtual 293	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: astore_0
    //   49: aload_1
    //   50: ifnull +8 -> 58
    //   53: aload_1
    //   54: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   57: astore_0
    //   58: aload_0
    //   59: areturn
    //   60: astore_0
    //   61: aconst_null
    //   62: astore_0
    //   63: ldc_w 295
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 234	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -16 -> 58
    //   77: astore_0
    //   78: aload_1
    //   79: astore_0
    //   80: goto -17 -> 63
    //   83: aconst_null
    //   84: astore_0
    //   85: goto -27 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramContext	Context
    //   46	33	1	str	String
    // Exception table:
    //   from	to	target	type
    //   28	38	60	java/lang/Throwable
    //   42	47	60	java/lang/Throwable
    //   53	58	77	java/lang/Throwable
  }
  
  public static int c()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 201
    //   2: astore_1
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 304	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: ldc_w 306
    //   16: invokestatic 312	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnonnull +7 -> 28
    //   24: ldc_w 314
    //   27: areturn
    //   28: aload_0
    //   29: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_2
    //   36: aload_1
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_2
    //   41: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   44: ifne -37 -> 7
    //   47: ldc_w 316
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 234	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: areturn
    //   60: astore_2
    //   61: goto -23 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    //   2	38	1	localObject	Object
    //   35	6	2	localThrowable1	Throwable
    //   60	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	20	35	java/lang/Throwable
    //   28	33	60	java/lang/Throwable
  }
  
  public static String d()
  {
    try
    {
      String str = Build.SERIAL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      x.a("Failed to get hardware serial number.", new Object[0]);
    }
    return "fail";
  }
  
  public static String d(Context paramContext)
  {
    localObject2 = "fail";
    if (paramContext == null) {
      return "fail";
    }
    label179:
    for (;;)
    {
      try
      {
        Object localObject3 = (WifiManager)paramContext.getSystemService("wifi");
        Object localObject1 = localObject2;
        if (localObject3 == null) {
          break label179;
        }
        localObject3 = ((WifiManager)localObject3).getConnectionInfo();
        localObject1 = localObject2;
        if (localObject3 == null) {
          break label179;
        }
        localObject1 = ((WifiInfo)localObject3).getMacAddress();
        localObject2 = localObject1;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        localContext = paramContext;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (((String)localObject2).equals("02:00:00:00:00:00"))
          {
            paramContext = z.a(paramContext, "wifi.interface");
            x.c("MAC interface: %s", new Object[] { paramContext });
            localObject1 = NetworkInterface.getByName(paramContext);
            paramContext = (Context)localObject1;
            if (localObject1 == null) {
              paramContext = NetworkInterface.getByName("wlan0");
            }
            localObject3 = paramContext;
            if (paramContext == null) {
              localObject3 = NetworkInterface.getByName("eth0");
            }
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = z.d(((NetworkInterface)localObject3).getHardwareAddress());
            }
          }
          paramContext = (Context)localObject1;
          if (localObject1 == null) {
            paramContext = "null";
          }
          x.c("MAC address: %s", new Object[] { paramContext });
          return paramContext.toLowerCase();
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            Context localContext;
            paramContext = (Context)localObject2;
            localObject2 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
        paramContext = (Context)localObject2;
        localObject2 = localThrowable1;
      }
      if (!x.a((Throwable)localObject2))
      {
        ((Throwable)localObject2).printStackTrace();
        localContext = paramContext;
      }
    }
  }
  
  public static long e()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      while (x.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label56;
      }
      String str = paramContext.getSimSerialNumber();
      paramContext = str;
      if (str == null) {
        paramContext = "null";
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = "fail";
        x.a("Failed to get SIM serial number.", new Object[0]);
        continue;
        paramContext = "fail";
      }
    }
    return paramContext;
  }
  
  public static long f()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      while (x.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static String f(Context paramContext)
  {
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return null;
        }
        if (localNetworkInfo.getType() == 1) {
          return "WIFI";
        }
        if (localNetworkInfo.getType() != 0) {
          continue;
        }
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          continue;
        }
        int i = paramContext.getNetworkType();
        switch (i)
        {
        case 15: 
          paramContext = "MOBILE(" + i + ")";
        }
      }
      catch (Exception paramContext)
      {
        if (x.a(paramContext)) {
          continue;
        }
        paramContext.printStackTrace();
        return "unknown";
        paramContext = "unknown";
        break;
        return "unknown";
      }
      return "HSPA+";
    }
    return paramContext;
    return "GPRS";
    return "EDGE";
    return "UMTS";
    return "HSDPA";
    return "HSUPA";
    return "HSPA";
    return "CDMA";
    return "EVDO_0";
    return "EVDO_A";
    return "1xRTT";
    return "iDen";
    return "EVDO_B";
    return "LTE";
    return "eHRPD";
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 458	java/io/FileReader
    //   6: dup
    //   7: ldc_w 460
    //   10: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 6
    //   15: new 463	java/io/BufferedReader
    //   18: dup
    //   19: aload 6
    //   21: sipush 2048
    //   24: invokespecial 466	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +55 -> 93
    //   41: aload 5
    //   43: invokevirtual 472	java/io/BufferedReader:close	()V
    //   46: aload 6
    //   48: invokevirtual 473	java/io/FileReader:close	()V
    //   51: ldc2_w 363
    //   54: lstore_0
    //   55: lload_0
    //   56: lreturn
    //   57: astore 4
    //   59: aload 4
    //   61: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   64: ifne -18 -> 46
    //   67: aload 4
    //   69: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   72: goto -26 -> 46
    //   75: astore 4
    //   77: aload 4
    //   79: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   82: ifne -31 -> 51
    //   85: aload 4
    //   87: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   90: goto -39 -> 51
    //   93: aload 4
    //   95: ldc_w 476
    //   98: iconst_2
    //   99: invokevirtual 479	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   102: iconst_1
    //   103: aaload
    //   104: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   107: ldc_w 481
    //   110: ldc_w 483
    //   113: invokevirtual 487	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   116: invokevirtual 490	java/lang/String:trim	()Ljava/lang/String;
    //   119: invokestatic 496	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   122: lstore_0
    //   123: lload_0
    //   124: bipush 10
    //   126: lshl
    //   127: lstore_2
    //   128: aload 5
    //   130: invokevirtual 472	java/io/BufferedReader:close	()V
    //   133: aload 6
    //   135: invokevirtual 473	java/io/FileReader:close	()V
    //   138: lload_2
    //   139: lreturn
    //   140: astore 4
    //   142: lload_2
    //   143: lstore_0
    //   144: aload 4
    //   146: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   149: ifne -94 -> 55
    //   152: aload 4
    //   154: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   157: lload_2
    //   158: lreturn
    //   159: astore 4
    //   161: aload 4
    //   163: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   166: ifne -33 -> 133
    //   169: aload 4
    //   171: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   174: goto -41 -> 133
    //   177: astore 6
    //   179: aconst_null
    //   180: astore 4
    //   182: aload 7
    //   184: astore 5
    //   186: aload 6
    //   188: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   191: ifne +8 -> 199
    //   194: aload 6
    //   196: invokevirtual 199	java/lang/Throwable:printStackTrace	()V
    //   199: aload 5
    //   201: ifnull +8 -> 209
    //   204: aload 5
    //   206: invokevirtual 472	java/io/BufferedReader:close	()V
    //   209: aload 4
    //   211: ifnull +8 -> 219
    //   214: aload 4
    //   216: invokevirtual 473	java/io/FileReader:close	()V
    //   219: ldc2_w 497
    //   222: lreturn
    //   223: astore 5
    //   225: aload 5
    //   227: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   230: ifne -21 -> 209
    //   233: aload 5
    //   235: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   238: goto -29 -> 209
    //   241: astore 4
    //   243: aload 4
    //   245: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   248: ifne -29 -> 219
    //   251: aload 4
    //   253: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   256: goto -37 -> 219
    //   259: astore 4
    //   261: aconst_null
    //   262: astore 5
    //   264: aconst_null
    //   265: astore 6
    //   267: aload 5
    //   269: ifnull +8 -> 277
    //   272: aload 5
    //   274: invokevirtual 472	java/io/BufferedReader:close	()V
    //   277: aload 6
    //   279: ifnull +8 -> 287
    //   282: aload 6
    //   284: invokevirtual 473	java/io/FileReader:close	()V
    //   287: aload 4
    //   289: athrow
    //   290: astore 5
    //   292: aload 5
    //   294: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   297: ifne -20 -> 277
    //   300: aload 5
    //   302: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   305: goto -28 -> 277
    //   308: astore 5
    //   310: aload 5
    //   312: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   315: ifne -28 -> 287
    //   318: aload 5
    //   320: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   323: goto -36 -> 287
    //   326: astore 4
    //   328: aconst_null
    //   329: astore 5
    //   331: goto -64 -> 267
    //   334: astore 4
    //   336: goto -69 -> 267
    //   339: astore 7
    //   341: aload 4
    //   343: astore 6
    //   345: aload 7
    //   347: astore 4
    //   349: goto -82 -> 267
    //   352: astore 5
    //   354: aload 6
    //   356: astore 4
    //   358: aload 5
    //   360: astore 6
    //   362: aload 7
    //   364: astore 5
    //   366: goto -180 -> 186
    //   369: astore 7
    //   371: aload 6
    //   373: astore 4
    //   375: aload 7
    //   377: astore 6
    //   379: goto -193 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   54	90	0	l1	long
    //   127	31	2	l2	long
    //   34	3	4	str	String
    //   57	11	4	localIOException1	java.io.IOException
    //   75	19	4	localIOException2	java.io.IOException
    //   140	13	4	localIOException3	java.io.IOException
    //   159	11	4	localIOException4	java.io.IOException
    //   180	35	4	localObject1	Object
    //   241	11	4	localIOException5	java.io.IOException
    //   259	29	4	localObject2	Object
    //   326	1	4	localObject3	Object
    //   334	8	4	localObject4	Object
    //   347	27	4	localObject5	Object
    //   27	178	5	localObject6	Object
    //   223	11	5	localIOException6	java.io.IOException
    //   262	11	5	localObject7	Object
    //   290	11	5	localIOException7	java.io.IOException
    //   308	11	5	localIOException8	java.io.IOException
    //   329	1	5	localObject8	Object
    //   352	7	5	localThrowable1	Throwable
    //   364	1	5	localObject9	Object
    //   13	121	6	localFileReader	java.io.FileReader
    //   177	18	6	localThrowable2	Throwable
    //   265	113	6	localObject10	Object
    //   1	182	7	localObject11	Object
    //   339	24	7	localObject12	Object
    //   369	7	7	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   41	46	57	java/io/IOException
    //   46	51	75	java/io/IOException
    //   133	138	140	java/io/IOException
    //   128	133	159	java/io/IOException
    //   3	15	177	java/lang/Throwable
    //   204	209	223	java/io/IOException
    //   214	219	241	java/io/IOException
    //   3	15	259	finally
    //   272	277	290	java/io/IOException
    //   282	287	308	java/io/IOException
    //   15	29	326	finally
    //   29	36	334	finally
    //   93	123	334	finally
    //   186	199	339	finally
    //   15	29	352	java/lang/Throwable
    //   29	36	369	java/lang/Throwable
    //   93	123	369	java/lang/Throwable
  }
  
  public static String g(Context paramContext)
  {
    String str = z.a(paramContext, "ro.miui.ui.version.name");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "XiaoMi/MIUI/" + str;
    }
    str = z.a(paramContext, "ro.build.version.emui");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "HuaWei/EMOTION/" + str;
    }
    str = z.a(paramContext, "ro.lenovo.series");
    if ((!z.a(str)) && (!str.equals("fail")))
    {
      paramContext = z.a(paramContext, "ro.build.version.incremental");
      return "Lenovo/VIBE/" + paramContext;
    }
    str = z.a(paramContext, "ro.build.nubia.rom.name");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "Zte/NUBIA/" + str + "_" + z.a(paramContext, "ro.build.nubia.rom.code");
    }
    str = z.a(paramContext, "ro.meizu.product.model");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "Meizu/FLYME/" + z.a(paramContext, "ro.build.display.id");
    }
    str = z.a(paramContext, "ro.build.version.opporom");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "Oppo/COLOROS/" + str;
    }
    str = z.a(paramContext, "ro.vivo.os.build.display.id");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "vivo/FUNTOUCH/" + str;
    }
    str = z.a(paramContext, "ro.aa.romver");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "htc/" + str + "/" + z.a(paramContext, "ro.build.description");
    }
    str = z.a(paramContext, "ro.lewa.version");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "tcl/" + str + "/" + z.a(paramContext, "ro.build.display.id");
    }
    str = z.a(paramContext, "ro.gn.gnromvernumber");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "amigo/" + str + "/" + z.a(paramContext, "ro.build.display.id");
    }
    str = z.a(paramContext, "ro.build.tyd.kbstyle_version");
    if ((!z.a(str)) && (!str.equals("fail"))) {
      return "dido/" + str;
    }
    return z.a(paramContext, "ro.build.fingerprint") + "/" + z.a(paramContext, "ro.build.rom.id");
  }
  
  /* Error */
  public static long h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc2_w 363
    //   6: lstore_0
    //   7: new 458	java/io/FileReader
    //   10: dup
    //   11: ldc_w 460
    //   14: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   17: astore 8
    //   19: new 463	java/io/BufferedReader
    //   22: dup
    //   23: aload 8
    //   25: sipush 2048
    //   28: invokespecial 466	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 7
    //   33: aload 7
    //   35: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: pop
    //   39: aload 7
    //   41: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +52 -> 100
    //   51: aload 7
    //   53: invokevirtual 472	java/io/BufferedReader:close	()V
    //   56: aload 8
    //   58: invokevirtual 473	java/io/FileReader:close	()V
    //   61: lload_0
    //   62: lreturn
    //   63: astore 6
    //   65: aload 6
    //   67: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   70: ifne -14 -> 56
    //   73: aload 6
    //   75: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   78: goto -22 -> 56
    //   81: astore 6
    //   83: aload 6
    //   85: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   88: ifne -27 -> 61
    //   91: aload 6
    //   93: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   96: ldc2_w 363
    //   99: lreturn
    //   100: aload 6
    //   102: ldc_w 476
    //   105: iconst_2
    //   106: invokevirtual 479	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   109: iconst_1
    //   110: aaload
    //   111: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   114: ldc_w 481
    //   117: ldc_w 483
    //   120: invokevirtual 487	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   123: invokevirtual 490	java/lang/String:trim	()Ljava/lang/String;
    //   126: invokestatic 496	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   129: lstore_2
    //   130: aload 7
    //   132: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnonnull +54 -> 193
    //   142: aload 7
    //   144: invokevirtual 472	java/io/BufferedReader:close	()V
    //   147: aload 8
    //   149: invokevirtual 473	java/io/FileReader:close	()V
    //   152: ldc2_w 363
    //   155: lreturn
    //   156: astore 6
    //   158: aload 6
    //   160: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   163: ifne -102 -> 61
    //   166: aload 6
    //   168: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   171: ldc2_w 363
    //   174: lreturn
    //   175: astore 6
    //   177: aload 6
    //   179: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   182: ifne -35 -> 147
    //   185: aload 6
    //   187: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   190: goto -43 -> 147
    //   193: aload 6
    //   195: ldc_w 476
    //   198: iconst_2
    //   199: invokevirtual 479	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   202: iconst_1
    //   203: aaload
    //   204: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   207: ldc_w 481
    //   210: ldc_w 483
    //   213: invokevirtual 487	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   216: invokevirtual 490	java/lang/String:trim	()Ljava/lang/String;
    //   219: invokestatic 496	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   222: lstore 4
    //   224: aload 7
    //   226: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   229: astore 6
    //   231: aload 6
    //   233: ifnonnull +54 -> 287
    //   236: aload 7
    //   238: invokevirtual 472	java/io/BufferedReader:close	()V
    //   241: aload 8
    //   243: invokevirtual 473	java/io/FileReader:close	()V
    //   246: ldc2_w 363
    //   249: lreturn
    //   250: astore 6
    //   252: aload 6
    //   254: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   257: ifne -196 -> 61
    //   260: aload 6
    //   262: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   265: ldc2_w 363
    //   268: lreturn
    //   269: astore 6
    //   271: aload 6
    //   273: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   276: ifne -35 -> 241
    //   279: aload 6
    //   281: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   284: goto -43 -> 241
    //   287: aload 6
    //   289: ldc_w 476
    //   292: iconst_2
    //   293: invokevirtual 479	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   296: iconst_1
    //   297: aaload
    //   298: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   301: ldc_w 481
    //   304: ldc_w 483
    //   307: invokevirtual 487	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   310: invokevirtual 490	java/lang/String:trim	()Ljava/lang/String;
    //   313: invokestatic 496	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   316: lstore_0
    //   317: lload_0
    //   318: bipush 10
    //   320: lshl
    //   321: lconst_0
    //   322: lload_2
    //   323: bipush 10
    //   325: lshl
    //   326: ladd
    //   327: lload 4
    //   329: bipush 10
    //   331: lshl
    //   332: ladd
    //   333: ladd
    //   334: lstore_2
    //   335: aload 7
    //   337: invokevirtual 472	java/io/BufferedReader:close	()V
    //   340: aload 8
    //   342: invokevirtual 473	java/io/FileReader:close	()V
    //   345: lload_2
    //   346: lreturn
    //   347: astore 6
    //   349: lload_2
    //   350: lstore_0
    //   351: aload 6
    //   353: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   356: ifne -295 -> 61
    //   359: aload 6
    //   361: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   364: lload_2
    //   365: lreturn
    //   366: astore 6
    //   368: aload 6
    //   370: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   373: ifne -33 -> 340
    //   376: aload 6
    //   378: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   381: goto -41 -> 340
    //   384: astore 8
    //   386: aconst_null
    //   387: astore 7
    //   389: aload 8
    //   391: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   394: ifne +8 -> 402
    //   397: aload 8
    //   399: invokevirtual 199	java/lang/Throwable:printStackTrace	()V
    //   402: aload 7
    //   404: ifnull +8 -> 412
    //   407: aload 7
    //   409: invokevirtual 472	java/io/BufferedReader:close	()V
    //   412: aload 6
    //   414: ifnull +8 -> 422
    //   417: aload 6
    //   419: invokevirtual 473	java/io/FileReader:close	()V
    //   422: ldc2_w 497
    //   425: lreturn
    //   426: astore 7
    //   428: aload 7
    //   430: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   433: ifne -21 -> 412
    //   436: aload 7
    //   438: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   441: goto -29 -> 412
    //   444: astore 6
    //   446: aload 6
    //   448: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   451: ifne -29 -> 422
    //   454: aload 6
    //   456: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   459: goto -37 -> 422
    //   462: astore 6
    //   464: aconst_null
    //   465: astore 7
    //   467: aconst_null
    //   468: astore 8
    //   470: aload 7
    //   472: ifnull +8 -> 480
    //   475: aload 7
    //   477: invokevirtual 472	java/io/BufferedReader:close	()V
    //   480: aload 8
    //   482: ifnull +8 -> 490
    //   485: aload 8
    //   487: invokevirtual 473	java/io/FileReader:close	()V
    //   490: aload 6
    //   492: athrow
    //   493: astore 7
    //   495: aload 7
    //   497: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   500: ifne -20 -> 480
    //   503: aload 7
    //   505: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   508: goto -28 -> 480
    //   511: astore 7
    //   513: aload 7
    //   515: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   518: ifne -28 -> 490
    //   521: aload 7
    //   523: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   526: goto -36 -> 490
    //   529: astore 6
    //   531: aconst_null
    //   532: astore 7
    //   534: goto -64 -> 470
    //   537: astore 6
    //   539: goto -69 -> 470
    //   542: astore 9
    //   544: aload 6
    //   546: astore 8
    //   548: aload 9
    //   550: astore 6
    //   552: goto -82 -> 470
    //   555: astore 9
    //   557: aconst_null
    //   558: astore 7
    //   560: aload 8
    //   562: astore 6
    //   564: aload 9
    //   566: astore 8
    //   568: goto -179 -> 389
    //   571: astore 9
    //   573: aload 8
    //   575: astore 6
    //   577: aload 9
    //   579: astore 8
    //   581: goto -192 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	345	0	l1	long
    //   129	236	2	l2	long
    //   222	106	4	l3	long
    //   1	46	6	str1	String
    //   63	11	6	localIOException1	java.io.IOException
    //   81	20	6	localIOException2	java.io.IOException
    //   135	3	6	str2	String
    //   156	11	6	localIOException3	java.io.IOException
    //   175	19	6	localIOException4	java.io.IOException
    //   229	3	6	str3	String
    //   250	11	6	localIOException5	java.io.IOException
    //   269	19	6	localIOException6	java.io.IOException
    //   347	13	6	localIOException7	java.io.IOException
    //   366	52	6	localIOException8	java.io.IOException
    //   444	11	6	localIOException9	java.io.IOException
    //   462	29	6	localObject1	Object
    //   529	1	6	localObject2	Object
    //   537	8	6	localObject3	Object
    //   550	26	6	localObject4	Object
    //   31	377	7	localBufferedReader	java.io.BufferedReader
    //   426	11	7	localIOException10	java.io.IOException
    //   465	11	7	localObject5	Object
    //   493	11	7	localIOException11	java.io.IOException
    //   511	11	7	localIOException12	java.io.IOException
    //   532	27	7	localObject6	Object
    //   17	324	8	localFileReader	java.io.FileReader
    //   384	14	8	localThrowable1	Throwable
    //   468	112	8	localObject7	Object
    //   542	7	9	localObject8	Object
    //   555	10	9	localThrowable2	Throwable
    //   571	7	9	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   51	56	63	java/io/IOException
    //   56	61	81	java/io/IOException
    //   147	152	156	java/io/IOException
    //   142	147	175	java/io/IOException
    //   241	246	250	java/io/IOException
    //   236	241	269	java/io/IOException
    //   340	345	347	java/io/IOException
    //   335	340	366	java/io/IOException
    //   7	19	384	java/lang/Throwable
    //   407	412	426	java/io/IOException
    //   417	422	444	java/io/IOException
    //   7	19	462	finally
    //   475	480	493	java/io/IOException
    //   485	490	511	java/io/IOException
    //   19	33	529	finally
    //   33	46	537	finally
    //   100	137	537	finally
    //   193	231	537	finally
    //   287	317	537	finally
    //   389	402	542	finally
    //   19	33	555	java/lang/Throwable
    //   33	46	571	java/lang/Throwable
    //   100	137	571	java/lang/Throwable
    //   193	231	571	java/lang/Throwable
    //   287	317	571	java/lang/Throwable
  }
  
  public static String h(Context paramContext)
  {
    return z.a(paramContext, "ro.board.platform");
  }
  
  public static long i()
  {
    if (!q()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getBlockCount();
      long l = j;
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static String i(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = z.a(paramContext, "ro.genymotion.version");
    if (str != null)
    {
      localStringBuilder.append("ro.genymotion.version");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
    }
    str = z.a(paramContext, "androVM.vbox_dpi");
    if (str != null)
    {
      localStringBuilder.append("androVM.vbox_dpi");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
    }
    paramContext = z.a(paramContext, "qemu.sf.fake_camera");
    if (paramContext != null)
    {
      localStringBuilder.append("qemu.sf.fake_camera");
      localStringBuilder.append("|");
      localStringBuilder.append(paramContext);
    }
    return localStringBuilder.toString();
  }
  
  public static long j()
  {
    if (!q()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      long l = j;
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  /* Error */
  public static String j(Context paramContext)
  {
    // Byte code:
    //   0: new 261	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: getstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   11: ifnonnull +13 -> 24
    //   14: aload_0
    //   15: ldc_w 582
    //   18: invokestatic 242	com/tencent/bugly/proguard/z:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   24: getstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   27: ifnull +35 -> 62
    //   30: aload_3
    //   31: ldc_w 582
    //   34: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: ldc_w 573
    //   42: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: getstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   50: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc_w 575
    //   58: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: getstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   65: ifnonnull +13 -> 78
    //   68: aload_0
    //   69: ldc_w 584
    //   72: invokestatic 242	com/tencent/bugly/proguard/z:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   75: putstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   78: getstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   81: ifnull +35 -> 116
    //   84: aload_3
    //   85: ldc_w 584
    //   88: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: ldc_w 573
    //   96: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: getstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   104: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_3
    //   109: ldc_w 575
    //   112: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: new 463	java/io/BufferedReader
    //   119: dup
    //   120: new 458	java/io/FileReader
    //   123: dup
    //   124: ldc_w 586
    //   127: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   130: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_1
    //   137: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +15 -> 157
    //   145: aload_1
    //   146: astore_0
    //   147: aload_2
    //   148: ldc_w 591
    //   151: invokevirtual 594	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   154: ifeq -20 -> 134
    //   157: aload_2
    //   158: ifnull +43 -> 201
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: bipush 10
    //   166: invokevirtual 598	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokevirtual 490	java/lang/String:trim	()Ljava/lang/String;
    //   172: astore_2
    //   173: aload_1
    //   174: astore_0
    //   175: aload_3
    //   176: ldc_w 600
    //   179: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: astore_0
    //   185: aload_3
    //   186: ldc_w 573
    //   189: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: astore_0
    //   195: aload_3
    //   196: aload_2
    //   197: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: astore_0
    //   203: aload_3
    //   204: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_2
    //   208: aload_1
    //   209: invokevirtual 472	java/io/BufferedReader:close	()V
    //   212: aload_2
    //   213: areturn
    //   214: astore_0
    //   215: aload_0
    //   216: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   219: pop
    //   220: aload_2
    //   221: areturn
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_1
    //   225: aload_1
    //   226: astore_0
    //   227: aload_2
    //   228: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   231: pop
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 472	java/io/BufferedReader:close	()V
    //   240: aload_3
    //   241: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: areturn
    //   245: astore_0
    //   246: aload_0
    //   247: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   250: pop
    //   251: goto -11 -> 240
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_0
    //   258: ifnull +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 472	java/io/BufferedReader:close	()V
    //   265: aload_1
    //   266: athrow
    //   267: astore_0
    //   268: aload_0
    //   269: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   272: pop
    //   273: goto -8 -> 265
    //   276: astore_1
    //   277: goto -20 -> 257
    //   280: astore_2
    //   281: goto -56 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramContext	Context
    //   133	104	1	localBufferedReader	java.io.BufferedReader
    //   254	12	1	localObject1	Object
    //   276	1	1	localObject2	Object
    //   140	81	2	str	String
    //   222	6	2	localThrowable1	Throwable
    //   280	1	2	localThrowable2	Throwable
    //   7	234	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   208	212	214	java/io/IOException
    //   116	134	222	java/lang/Throwable
    //   236	240	245	java/io/IOException
    //   116	134	254	finally
    //   261	265	267	java/io/IOException
    //   136	141	276	finally
    //   147	157	276	finally
    //   163	173	276	finally
    //   175	183	276	finally
    //   185	193	276	finally
    //   195	201	276	finally
    //   203	208	276	finally
    //   227	232	276	finally
    //   136	141	280	java/lang/Throwable
    //   147	157	280	java/lang/Throwable
    //   163	173	280	java/lang/Throwable
    //   175	183	280	java/lang/Throwable
    //   185	193	280	java/lang/Throwable
    //   195	201	280	java/lang/Throwable
    //   203	208	280	java/lang/Throwable
  }
  
  public static String k()
  {
    Object localObject = "fail";
    try
    {
      String str = Locale.getDefault().getCountry();
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      while (x.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return localObject;
    return "fail";
  }
  
  public static String k(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = z.a(paramContext, "gsm.sim.state");
    if (str != null)
    {
      localStringBuilder.append("gsm.sim.state");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
    }
    localStringBuilder.append("\n");
    paramContext = z.a(paramContext, "gsm.sim.state2");
    if (paramContext != null)
    {
      localStringBuilder.append("gsm.sim.state2");
      localStringBuilder.append("|");
      localStringBuilder.append(paramContext);
    }
    return localStringBuilder.toString();
  }
  
  public static String l()
  {
    Object localObject = "fail";
    try
    {
      String str = Build.BRAND;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      while (x.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return localObject;
    return "fail";
  }
  
  public static boolean l(Context paramContext)
  {
    boolean bool = false;
    if (n(paramContext) == null)
    {
      paramContext = new ArrayList();
      int i = 0;
      if (i < c.length)
      {
        if (i == 0) {
          if (!new File(c[i]).exists()) {
            paramContext.add(Integer.valueOf(i));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (new File(c[i]).exists()) {
            paramContext.add(Integer.valueOf(i));
          }
        }
      }
      if (!paramContext.isEmpty()) {
        break label112;
      }
    }
    label112:
    for (paramContext = null;; paramContext = paramContext.toString())
    {
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static boolean m()
  {
    boolean bool = false;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!new File(arrayOfString[i]).exists()) {}
    }
    for (i = 1;; i = 0)
    {
      if ((Build.TAGS != null) && (Build.TAGS.contains("test-keys"))) {}
      for (j = 1;; j = 0)
      {
        if ((j != 0) || (i != 0)) {
          bool = true;
        }
        return bool;
        i += 1;
        break;
      }
    }
  }
  
  public static boolean m(Context paramContext)
  {
    return (o(paramContext) | s() | t() | r()) > 0;
  }
  
  /* Error */
  public static String n()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 261	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   10: astore 5
    //   12: new 374	java/io/File
    //   15: dup
    //   16: ldc_w 667
    //   19: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 629	java/io/File:exists	()Z
    //   25: ifeq +318 -> 343
    //   28: new 463	java/io/BufferedReader
    //   31: dup
    //   32: new 458	java/io/FileReader
    //   35: dup
    //   36: ldc_w 667
    //   39: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: astore_0
    //   59: aload 5
    //   61: aload_2
    //   62: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 472	java/io/BufferedReader:close	()V
    //   72: aload_1
    //   73: astore_0
    //   74: aload_0
    //   75: astore_3
    //   76: aload 5
    //   78: ldc_w 279
    //   81: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: astore_1
    //   87: aload_0
    //   88: astore_3
    //   89: new 374	java/io/File
    //   92: dup
    //   93: ldc_w 669
    //   96: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 629	java/io/File:exists	()Z
    //   102: ifeq +49 -> 151
    //   105: aload_0
    //   106: astore_3
    //   107: new 463	java/io/BufferedReader
    //   110: dup
    //   111: new 458	java/io/FileReader
    //   114: dup
    //   115: ldc_w 669
    //   118: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   121: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore_1
    //   125: aload_1
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +12 -> 145
    //   136: aload_1
    //   137: astore_0
    //   138: aload 5
    //   140: aload_2
    //   141: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: astore_0
    //   147: aload_1
    //   148: invokevirtual 472	java/io/BufferedReader:close	()V
    //   151: aload_1
    //   152: astore_3
    //   153: aload 5
    //   155: ldc_w 279
    //   158: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: astore_3
    //   164: new 374	java/io/File
    //   167: dup
    //   168: ldc_w 671
    //   171: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: invokevirtual 629	java/io/File:exists	()Z
    //   177: ifeq +163 -> 340
    //   180: aload_1
    //   181: astore_3
    //   182: new 463	java/io/BufferedReader
    //   185: dup
    //   186: new 458	java/io/FileReader
    //   189: dup
    //   190: ldc_w 671
    //   193: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   196: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   199: astore_2
    //   200: aload_2
    //   201: astore_0
    //   202: aload_2
    //   203: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   206: astore_3
    //   207: aload_2
    //   208: astore_1
    //   209: aload_3
    //   210: ifnull +14 -> 224
    //   213: aload_2
    //   214: astore_0
    //   215: aload 5
    //   217: aload_3
    //   218: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: astore_1
    //   224: aload_1
    //   225: astore_0
    //   226: aload 5
    //   228: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore_2
    //   232: aload_2
    //   233: astore_0
    //   234: aload_0
    //   235: astore_2
    //   236: aload_1
    //   237: ifnull +9 -> 246
    //   240: aload_1
    //   241: invokevirtual 472	java/io/BufferedReader:close	()V
    //   244: aload_0
    //   245: astore_2
    //   246: aload_2
    //   247: areturn
    //   248: astore_1
    //   249: aload_1
    //   250: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   253: pop
    //   254: aload_0
    //   255: areturn
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_0
    //   259: aload 4
    //   261: astore_2
    //   262: aload_0
    //   263: ifnull -17 -> 246
    //   266: aload_0
    //   267: invokevirtual 472	java/io/BufferedReader:close	()V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_0
    //   273: aload_0
    //   274: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   277: pop
    //   278: aconst_null
    //   279: areturn
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull +7 -> 291
    //   287: aload_1
    //   288: invokevirtual 472	java/io/BufferedReader:close	()V
    //   291: aload_0
    //   292: athrow
    //   293: astore_1
    //   294: aload_1
    //   295: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   298: pop
    //   299: goto -8 -> 291
    //   302: astore_0
    //   303: goto -20 -> 283
    //   306: astore_0
    //   307: aload_3
    //   308: astore_1
    //   309: goto -26 -> 283
    //   312: astore_0
    //   313: goto -30 -> 283
    //   316: astore_0
    //   317: aload_2
    //   318: astore_1
    //   319: goto -36 -> 283
    //   322: astore_0
    //   323: goto -40 -> 283
    //   326: astore_1
    //   327: goto -68 -> 259
    //   330: astore_1
    //   331: goto -72 -> 259
    //   334: astore_0
    //   335: aload_1
    //   336: astore_0
    //   337: goto -78 -> 259
    //   340: goto -116 -> 224
    //   343: aconst_null
    //   344: astore_0
    //   345: goto -271 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	208	0	localObject1	Object
    //   256	1	0	localThrowable1	Throwable
    //   258	9	0	localObject2	Object
    //   272	2	0	localIOException1	java.io.IOException
    //   280	12	0	localObject3	Object
    //   302	1	0	localObject4	Object
    //   306	1	0	localObject5	Object
    //   312	1	0	localObject6	Object
    //   316	1	0	localObject7	Object
    //   322	1	0	localObject8	Object
    //   334	1	0	localThrowable2	Throwable
    //   336	9	0	localThrowable3	Throwable
    //   45	196	1	localObject9	Object
    //   248	2	1	localIOException2	java.io.IOException
    //   282	6	1	localObject10	Object
    //   293	2	1	localIOException3	java.io.IOException
    //   308	11	1	localObject11	Object
    //   326	1	1	localThrowable4	Throwable
    //   330	6	1	localThrowable5	Throwable
    //   52	266	2	localObject12	Object
    //   75	233	3	localObject13	Object
    //   1	259	4	localObject14	Object
    //   10	217	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   240	244	248	java/io/IOException
    //   3	46	256	java/lang/Throwable
    //   266	270	272	java/io/IOException
    //   3	46	280	finally
    //   287	291	293	java/io/IOException
    //   48	53	302	finally
    //   59	66	302	finally
    //   68	72	302	finally
    //   76	85	306	finally
    //   89	105	306	finally
    //   107	125	306	finally
    //   153	162	306	finally
    //   164	180	306	finally
    //   182	200	306	finally
    //   127	132	312	finally
    //   138	145	312	finally
    //   147	151	312	finally
    //   202	207	316	finally
    //   215	222	316	finally
    //   226	232	322	finally
    //   48	53	326	java/lang/Throwable
    //   59	66	326	java/lang/Throwable
    //   68	72	326	java/lang/Throwable
    //   127	132	326	java/lang/Throwable
    //   138	145	326	java/lang/Throwable
    //   147	151	326	java/lang/Throwable
    //   202	207	326	java/lang/Throwable
    //   215	222	326	java/lang/Throwable
    //   226	232	326	java/lang/Throwable
    //   76	85	330	java/lang/Throwable
    //   89	105	330	java/lang/Throwable
    //   107	125	330	java/lang/Throwable
    //   153	162	334	java/lang/Throwable
    //   164	180	334	java/lang/Throwable
    //   182	200	334	java/lang/Throwable
  }
  
  private static String n(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < b.length) {}
      try
      {
        paramContext.getPackageInfo(b[i], 1);
        localArrayList.add(Integer.valueOf(i));
        label43:
        i += 1;
        continue;
        if (localArrayList.isEmpty()) {
          return null;
        }
        return localArrayList.toString();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        break label43;
      }
    }
  }
  
  private static int o(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        paramContext.getInstallerPackageName("de.robv.android.xposed.installer");
        i = 1;
      }
      catch (Exception localException)
      {
        continue;
      }
      try
      {
        paramContext.getInstallerPackageName("com.saurik.substrate");
        return i | 0x2;
      }
      catch (Exception paramContext)
      {
        return i;
      }
    }
  }
  
  /* Error */
  public static String o()
  {
    // Byte code:
    //   0: new 261	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_1
    //   14: astore_2
    //   15: new 374	java/io/File
    //   18: dup
    //   19: ldc_w 692
    //   22: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 629	java/io/File:exists	()Z
    //   28: ifeq +73 -> 101
    //   31: aload_1
    //   32: astore_2
    //   33: new 463	java/io/BufferedReader
    //   36: dup
    //   37: new 458	java/io/FileReader
    //   40: dup
    //   41: ldc_w 692
    //   44: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +34 -> 93
    //   62: aload_1
    //   63: astore_0
    //   64: aload 4
    //   66: ldc_w 694
    //   69: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_1
    //   74: astore_0
    //   75: aload 4
    //   77: ldc_w 573
    //   80: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: astore_0
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: astore_0
    //   95: aload_1
    //   96: invokevirtual 472	java/io/BufferedReader:close	()V
    //   99: aload_1
    //   100: astore_0
    //   101: aload_0
    //   102: astore_2
    //   103: aload 4
    //   105: ldc_w 575
    //   108: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: astore_1
    //   114: aload_0
    //   115: astore_2
    //   116: new 374	java/io/File
    //   119: dup
    //   120: ldc_w 696
    //   123: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   126: invokevirtual 629	java/io/File:exists	()Z
    //   129: ifeq +71 -> 200
    //   132: aload_0
    //   133: astore_2
    //   134: new 463	java/io/BufferedReader
    //   137: dup
    //   138: new 458	java/io/FileReader
    //   141: dup
    //   142: ldc_w 696
    //   145: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   148: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   151: astore_1
    //   152: aload_1
    //   153: astore_0
    //   154: aload_1
    //   155: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +34 -> 194
    //   163: aload_1
    //   164: astore_0
    //   165: aload 4
    //   167: ldc_w 698
    //   170: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_1
    //   175: astore_0
    //   176: aload 4
    //   178: ldc_w 573
    //   181: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: astore_0
    //   187: aload 4
    //   189: aload_2
    //   190: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_1
    //   195: astore_0
    //   196: aload_1
    //   197: invokevirtual 472	java/io/BufferedReader:close	()V
    //   200: aload_1
    //   201: astore_2
    //   202: aload 4
    //   204: ldc_w 575
    //   207: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: astore_2
    //   213: new 374	java/io/File
    //   216: dup
    //   217: ldc_w 700
    //   220: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   223: invokevirtual 629	java/io/File:exists	()Z
    //   226: ifeq +169 -> 395
    //   229: aload_1
    //   230: astore_2
    //   231: new 463	java/io/BufferedReader
    //   234: dup
    //   235: new 458	java/io/FileReader
    //   238: dup
    //   239: ldc_w 700
    //   242: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   245: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   248: astore_3
    //   249: aload_3
    //   250: astore_0
    //   251: aload_3
    //   252: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +34 -> 291
    //   260: aload_3
    //   261: astore_0
    //   262: aload 4
    //   264: ldc_w 702
    //   267: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_3
    //   272: astore_0
    //   273: aload 4
    //   275: ldc_w 573
    //   278: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_3
    //   283: astore_0
    //   284: aload 4
    //   286: aload_1
    //   287: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_3
    //   292: astore_0
    //   293: aload_3
    //   294: invokevirtual 472	java/io/BufferedReader:close	()V
    //   297: aload_3
    //   298: ifnull +7 -> 305
    //   301: aload_3
    //   302: invokevirtual 472	java/io/BufferedReader:close	()V
    //   305: aload 4
    //   307: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: areturn
    //   311: astore_0
    //   312: aload_0
    //   313: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   316: pop
    //   317: goto -12 -> 305
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_0
    //   323: aload_0
    //   324: ifnull -19 -> 305
    //   327: aload_0
    //   328: invokevirtual 472	java/io/BufferedReader:close	()V
    //   331: goto -26 -> 305
    //   334: astore_0
    //   335: aload_0
    //   336: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   339: pop
    //   340: goto -35 -> 305
    //   343: astore_0
    //   344: aload_2
    //   345: ifnull +7 -> 352
    //   348: aload_2
    //   349: invokevirtual 472	java/io/BufferedReader:close	()V
    //   352: aload_0
    //   353: athrow
    //   354: astore_1
    //   355: aload_1
    //   356: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   359: pop
    //   360: goto -8 -> 352
    //   363: astore_0
    //   364: aload_1
    //   365: astore_2
    //   366: goto -22 -> 344
    //   369: astore_0
    //   370: aload_1
    //   371: astore_2
    //   372: goto -28 -> 344
    //   375: astore_0
    //   376: aload_3
    //   377: astore_2
    //   378: goto -34 -> 344
    //   381: astore_1
    //   382: goto -59 -> 323
    //   385: astore_1
    //   386: goto -63 -> 323
    //   389: astore_0
    //   390: aload_1
    //   391: astore_0
    //   392: goto -69 -> 323
    //   395: aload_1
    //   396: astore_3
    //   397: goto -100 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	281	0	localObject1	Object
    //   311	2	0	localIOException1	java.io.IOException
    //   320	1	0	localThrowable1	Throwable
    //   322	6	0	localObject2	Object
    //   334	2	0	localIOException2	java.io.IOException
    //   343	10	0	localObject3	Object
    //   363	1	0	localObject4	Object
    //   369	1	0	localObject5	Object
    //   375	1	0	localObject6	Object
    //   389	1	0	localThrowable2	Throwable
    //   391	1	0	localThrowable3	Throwable
    //   10	277	1	localObject7	Object
    //   354	17	1	localIOException3	java.io.IOException
    //   381	1	1	localThrowable4	Throwable
    //   385	11	1	localThrowable5	Throwable
    //   14	364	2	localObject8	Object
    //   248	149	3	localObject9	Object
    //   7	299	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   301	305	311	java/io/IOException
    //   15	31	320	java/lang/Throwable
    //   33	51	320	java/lang/Throwable
    //   327	331	334	java/io/IOException
    //   15	31	343	finally
    //   33	51	343	finally
    //   103	112	343	finally
    //   116	132	343	finally
    //   134	152	343	finally
    //   202	211	343	finally
    //   213	229	343	finally
    //   231	249	343	finally
    //   348	352	354	java/io/IOException
    //   53	58	363	finally
    //   64	73	363	finally
    //   75	84	363	finally
    //   86	93	363	finally
    //   95	99	363	finally
    //   154	159	369	finally
    //   165	174	369	finally
    //   176	185	369	finally
    //   187	194	369	finally
    //   196	200	369	finally
    //   251	256	375	finally
    //   262	271	375	finally
    //   273	282	375	finally
    //   284	291	375	finally
    //   293	297	375	finally
    //   53	58	381	java/lang/Throwable
    //   64	73	381	java/lang/Throwable
    //   75	84	381	java/lang/Throwable
    //   86	93	381	java/lang/Throwable
    //   95	99	381	java/lang/Throwable
    //   154	159	381	java/lang/Throwable
    //   165	174	381	java/lang/Throwable
    //   176	185	381	java/lang/Throwable
    //   187	194	381	java/lang/Throwable
    //   196	200	381	java/lang/Throwable
    //   251	256	381	java/lang/Throwable
    //   262	271	381	java/lang/Throwable
    //   273	282	381	java/lang/Throwable
    //   284	291	381	java/lang/Throwable
    //   293	297	381	java/lang/Throwable
    //   103	112	385	java/lang/Throwable
    //   116	132	385	java/lang/Throwable
    //   134	152	385	java/lang/Throwable
    //   202	211	389	java/lang/Throwable
    //   213	229	389	java/lang/Throwable
    //   231	249	389	java/lang/Throwable
  }
  
  /* Error */
  public static long p()
  {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_1
    //   2: fconst_0
    //   3: fstore_0
    //   4: new 463	java/io/BufferedReader
    //   7: dup
    //   8: new 458	java/io/FileReader
    //   11: dup
    //   12: ldc_w 705
    //   15: invokespecial 461	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull +43 -> 78
    //   38: aload 4
    //   40: astore_3
    //   41: aload 5
    //   43: ldc_w 707
    //   46: invokevirtual 283	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_0
    //   50: aaload
    //   51: astore 5
    //   53: aload 4
    //   55: astore_3
    //   56: invokestatic 710	java/lang/System:currentTimeMillis	()J
    //   59: ldc2_w 711
    //   62: ldiv
    //   63: l2f
    //   64: fstore_0
    //   65: aload 4
    //   67: astore_3
    //   68: aload 5
    //   70: invokestatic 718	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   73: fstore_2
    //   74: fload_0
    //   75: fload_2
    //   76: fsub
    //   77: fstore_0
    //   78: aload 4
    //   80: invokevirtual 472	java/io/BufferedReader:close	()V
    //   83: fload_0
    //   84: f2l
    //   85: lreturn
    //   86: astore_3
    //   87: aload_3
    //   88: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   91: pop
    //   92: goto -9 -> 83
    //   95: astore_3
    //   96: aconst_null
    //   97: astore 4
    //   99: aload 4
    //   101: astore_3
    //   102: ldc_w 720
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 234	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   112: pop
    //   113: fload_1
    //   114: fstore_0
    //   115: aload 4
    //   117: ifnull -34 -> 83
    //   120: aload 4
    //   122: invokevirtual 472	java/io/BufferedReader:close	()V
    //   125: fload_1
    //   126: fstore_0
    //   127: goto -44 -> 83
    //   130: astore_3
    //   131: aload_3
    //   132: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   135: pop
    //   136: fload_1
    //   137: fstore_0
    //   138: goto -55 -> 83
    //   141: astore 4
    //   143: aconst_null
    //   144: astore_3
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 472	java/io/BufferedReader:close	()V
    //   153: aload 4
    //   155: athrow
    //   156: astore_3
    //   157: aload_3
    //   158: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   161: pop
    //   162: goto -9 -> 153
    //   165: astore 4
    //   167: goto -22 -> 145
    //   170: astore_3
    //   171: goto -72 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	135	0	f1	float
    //   1	136	1	f2	float
    //   73	3	2	f3	float
    //   25	43	3	localBufferedReader1	java.io.BufferedReader
    //   86	2	3	localIOException1	java.io.IOException
    //   95	1	3	localThrowable1	Throwable
    //   101	1	3	localBufferedReader2	java.io.BufferedReader
    //   130	2	3	localIOException2	java.io.IOException
    //   144	6	3	localObject1	Object
    //   156	2	3	localIOException3	java.io.IOException
    //   170	1	3	localThrowable2	Throwable
    //   21	100	4	localBufferedReader3	java.io.BufferedReader
    //   141	13	4	localObject2	Object
    //   165	1	4	localObject3	Object
    //   31	38	5	str	String
    // Exception table:
    //   from	to	target	type
    //   78	83	86	java/io/IOException
    //   4	23	95	java/lang/Throwable
    //   120	125	130	java/io/IOException
    //   4	23	141	finally
    //   149	153	156	java/io/IOException
    //   26	33	165	finally
    //   41	53	165	finally
    //   56	65	165	finally
    //   68	74	165	finally
    //   102	113	165	finally
    //   26	33	170	java/lang/Throwable
    //   41	53	170	java/lang/Throwable
    //   56	65	170	java/lang/Throwable
    //   68	74	170	java/lang/Throwable
  }
  
  private static boolean q()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
  
  private static int r()
  {
    try
    {
      Method localMethod = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = localMethod.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy");
      if (bool) {
        return 256;
      }
    }
    catch (Exception localException)
    {
      return 256;
    }
    return 0;
  }
  
  private static int s()
  {
    int m = 0;
    try
    {
      throw new Exception("detect hook");
    }
    catch (Exception localException)
    {
      StackTraceElement[] arrayOfStackTraceElement = localException.getStackTrace();
      int i1 = arrayOfStackTraceElement.length;
      int j = 0;
      int k = 0;
      while (k < i1)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[k];
        int i = j;
        if (localStackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge"))
        {
          i = j;
          if (localStackTraceElement.getMethodName().equals("main")) {
            i = j | 0x4;
          }
        }
        j = i;
        if (localStackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge"))
        {
          j = i;
          if (localStackTraceElement.getMethodName().equals("handleHookedMethod")) {
            j = i | 0x8;
          }
        }
        i = j;
        if (localStackTraceElement.getClassName().equals("com.saurik.substrate.MS$2"))
        {
          i = j;
          if (localStackTraceElement.getMethodName().equals("invoked")) {
            i = j | 0x10;
          }
        }
        j = i;
        int n = m;
        if (localStackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit"))
        {
          m += 1;
          j = i;
          n = m;
          if (m == 2)
          {
            j = i | 0x20;
            n = m;
          }
        }
        k += 1;
        m = n;
      }
      return j;
    }
  }
  
  /* Error */
  private static int t()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore_0
    //   11: new 790	java/util/HashSet
    //   14: dup
    //   15: invokespecial 791	java/util/HashSet:<init>	()V
    //   18: astore 10
    //   20: new 463	java/io/BufferedReader
    //   23: dup
    //   24: new 793	java/io/InputStreamReader
    //   27: dup
    //   28: new 795	java/io/FileInputStream
    //   31: dup
    //   32: new 261	java/lang/StringBuilder
    //   35: dup
    //   36: ldc_w 797
    //   39: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: invokestatic 802	android/os/Process:myPid	()I
    //   45: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 804
    //   51: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 805	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   60: ldc_w 807
    //   63: invokespecial 810	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   66: invokespecial 589	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   69: astore 8
    //   71: iload_0
    //   72: istore_1
    //   73: aload 8
    //   75: astore 9
    //   77: iload 5
    //   79: istore_2
    //   80: iload 6
    //   82: istore_3
    //   83: aload 8
    //   85: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   88: astore 11
    //   90: aload 11
    //   92: ifnull +110 -> 202
    //   95: iload_0
    //   96: istore_1
    //   97: aload 8
    //   99: astore 9
    //   101: iload 5
    //   103: istore_2
    //   104: iload 6
    //   106: istore_3
    //   107: aload 11
    //   109: ldc_w 812
    //   112: invokevirtual 815	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   115: ifne +26 -> 141
    //   118: iload_0
    //   119: istore_1
    //   120: aload 8
    //   122: astore 9
    //   124: iload 5
    //   126: istore_2
    //   127: iload 6
    //   129: istore_3
    //   130: aload 11
    //   132: ldc_w 817
    //   135: invokevirtual 815	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   138: ifeq -67 -> 71
    //   141: iload_0
    //   142: istore_1
    //   143: aload 8
    //   145: astore 9
    //   147: iload 5
    //   149: istore_2
    //   150: iload 6
    //   152: istore_3
    //   153: aload 10
    //   155: aload 11
    //   157: aload 11
    //   159: ldc_w 707
    //   162: invokevirtual 821	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: iconst_1
    //   166: iadd
    //   167: invokevirtual 598	java/lang/String:substring	(I)Ljava/lang/String;
    //   170: invokevirtual 822	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto -103 -> 71
    //   177: astore 9
    //   179: iload_1
    //   180: istore_0
    //   181: aload 9
    //   183: invokevirtual 823	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   186: iload_0
    //   187: istore_1
    //   188: aload 8
    //   190: ifnull +10 -> 200
    //   193: aload 8
    //   195: invokevirtual 472	java/io/BufferedReader:close	()V
    //   198: iload_0
    //   199: istore_1
    //   200: iload_1
    //   201: ireturn
    //   202: iload_0
    //   203: istore_1
    //   204: aload 8
    //   206: astore 9
    //   208: iload 5
    //   210: istore_2
    //   211: iload 6
    //   213: istore_3
    //   214: aload 10
    //   216: invokevirtual 827	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   219: astore 10
    //   221: iload 4
    //   223: istore_0
    //   224: iload_0
    //   225: istore_1
    //   226: aload 8
    //   228: astore 9
    //   230: iload_0
    //   231: istore_2
    //   232: iload_0
    //   233: istore_3
    //   234: aload 10
    //   236: invokeinterface 832 1 0
    //   241: ifeq +89 -> 330
    //   244: iload_0
    //   245: istore_1
    //   246: aload 8
    //   248: astore 9
    //   250: iload_0
    //   251: istore_2
    //   252: iload_0
    //   253: istore_3
    //   254: aload 10
    //   256: invokeinterface 836 1 0
    //   261: astore 11
    //   263: iload_0
    //   264: istore_1
    //   265: aload 8
    //   267: astore 9
    //   269: iload_0
    //   270: istore_2
    //   271: iload_0
    //   272: istore_3
    //   273: aload 11
    //   275: checkcast 15	java/lang/String
    //   278: invokevirtual 230	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   281: ldc_w 838
    //   284: invokevirtual 652	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   287: istore 7
    //   289: iload 7
    //   291: ifeq +230 -> 521
    //   294: iload_0
    //   295: bipush 64
    //   297: ior
    //   298: istore_0
    //   299: aload 8
    //   301: astore 9
    //   303: aload 11
    //   305: checkcast 15	java/lang/String
    //   308: ldc_w 690
    //   311: invokevirtual 652	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   314: istore 7
    //   316: iload 7
    //   318: ifeq +200 -> 518
    //   321: iload_0
    //   322: sipush 128
    //   325: ior
    //   326: istore_0
    //   327: goto -103 -> 224
    //   330: aload 8
    //   332: invokevirtual 472	java/io/BufferedReader:close	()V
    //   335: iload_0
    //   336: ireturn
    //   337: astore 8
    //   339: aload 8
    //   341: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   344: iload_0
    //   345: ireturn
    //   346: astore 8
    //   348: aload 8
    //   350: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   353: iload_0
    //   354: ireturn
    //   355: astore 10
    //   357: aconst_null
    //   358: astore 8
    //   360: iconst_0
    //   361: istore_0
    //   362: aload 8
    //   364: astore 9
    //   366: aload 10
    //   368: invokevirtual 839	java/io/FileNotFoundException:printStackTrace	()V
    //   371: iload_0
    //   372: istore_1
    //   373: aload 8
    //   375: ifnull -175 -> 200
    //   378: aload 8
    //   380: invokevirtual 472	java/io/BufferedReader:close	()V
    //   383: iload_0
    //   384: ireturn
    //   385: astore 8
    //   387: aload 8
    //   389: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   392: iload_0
    //   393: ireturn
    //   394: astore 10
    //   396: aconst_null
    //   397: astore 8
    //   399: iconst_0
    //   400: istore_0
    //   401: aload 8
    //   403: astore 9
    //   405: aload 10
    //   407: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   410: iload_0
    //   411: istore_1
    //   412: aload 8
    //   414: ifnull -214 -> 200
    //   417: aload 8
    //   419: invokevirtual 472	java/io/BufferedReader:close	()V
    //   422: iload_0
    //   423: ireturn
    //   424: astore 8
    //   426: aload 8
    //   428: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   431: iload_0
    //   432: ireturn
    //   433: astore 8
    //   435: aconst_null
    //   436: astore 9
    //   438: aload 9
    //   440: ifnull +8 -> 448
    //   443: aload 9
    //   445: invokevirtual 472	java/io/BufferedReader:close	()V
    //   448: aload 8
    //   450: athrow
    //   451: astore 9
    //   453: aload 9
    //   455: invokevirtual 474	java/io/IOException:printStackTrace	()V
    //   458: goto -10 -> 448
    //   461: astore 8
    //   463: goto -25 -> 438
    //   466: astore 10
    //   468: aload 8
    //   470: astore 9
    //   472: aload 10
    //   474: astore 8
    //   476: goto -38 -> 438
    //   479: astore 10
    //   481: iload_2
    //   482: istore_0
    //   483: goto -82 -> 401
    //   486: astore 10
    //   488: goto -87 -> 401
    //   491: astore 10
    //   493: iload_3
    //   494: istore_0
    //   495: goto -133 -> 362
    //   498: astore 10
    //   500: goto -138 -> 362
    //   503: astore 9
    //   505: iconst_0
    //   506: istore_0
    //   507: aconst_null
    //   508: astore 8
    //   510: goto -329 -> 181
    //   513: astore 9
    //   515: goto -334 -> 181
    //   518: goto -191 -> 327
    //   521: goto -222 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	497	0	i	int
    //   72	340	1	j	int
    //   79	403	2	k	int
    //   82	412	3	m	int
    //   1	221	4	n	int
    //   4	205	5	i1	int
    //   7	205	6	i2	int
    //   287	30	7	bool	boolean
    //   69	262	8	localBufferedReader1	java.io.BufferedReader
    //   337	3	8	localIOException1	java.io.IOException
    //   346	3	8	localIOException2	java.io.IOException
    //   358	21	8	localObject1	Object
    //   385	3	8	localIOException3	java.io.IOException
    //   397	21	8	localObject2	Object
    //   424	3	8	localIOException4	java.io.IOException
    //   433	16	8	localObject3	Object
    //   461	8	8	localObject4	Object
    //   474	35	8	localObject5	Object
    //   75	71	9	localBufferedReader2	java.io.BufferedReader
    //   177	5	9	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   206	238	9	localObject6	Object
    //   451	3	9	localIOException5	java.io.IOException
    //   470	1	9	localObject7	Object
    //   503	1	9	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   513	1	9	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   18	237	10	localObject8	Object
    //   355	12	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   394	12	10	localIOException6	java.io.IOException
    //   466	7	10	localObject9	Object
    //   479	1	10	localIOException7	java.io.IOException
    //   486	1	10	localIOException8	java.io.IOException
    //   491	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   498	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   88	216	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   83	90	177	java/io/UnsupportedEncodingException
    //   107	118	177	java/io/UnsupportedEncodingException
    //   130	141	177	java/io/UnsupportedEncodingException
    //   153	174	177	java/io/UnsupportedEncodingException
    //   214	221	177	java/io/UnsupportedEncodingException
    //   234	244	177	java/io/UnsupportedEncodingException
    //   254	263	177	java/io/UnsupportedEncodingException
    //   273	289	177	java/io/UnsupportedEncodingException
    //   330	335	337	java/io/IOException
    //   193	198	346	java/io/IOException
    //   11	71	355	java/io/FileNotFoundException
    //   378	383	385	java/io/IOException
    //   11	71	394	java/io/IOException
    //   417	422	424	java/io/IOException
    //   11	71	433	finally
    //   443	448	451	java/io/IOException
    //   83	90	461	finally
    //   107	118	461	finally
    //   130	141	461	finally
    //   153	174	461	finally
    //   214	221	461	finally
    //   234	244	461	finally
    //   254	263	461	finally
    //   273	289	461	finally
    //   303	316	461	finally
    //   366	371	461	finally
    //   405	410	461	finally
    //   181	186	466	finally
    //   83	90	479	java/io/IOException
    //   107	118	479	java/io/IOException
    //   130	141	479	java/io/IOException
    //   153	174	479	java/io/IOException
    //   214	221	479	java/io/IOException
    //   234	244	479	java/io/IOException
    //   254	263	479	java/io/IOException
    //   273	289	479	java/io/IOException
    //   303	316	486	java/io/IOException
    //   83	90	491	java/io/FileNotFoundException
    //   107	118	491	java/io/FileNotFoundException
    //   130	141	491	java/io/FileNotFoundException
    //   153	174	491	java/io/FileNotFoundException
    //   214	221	491	java/io/FileNotFoundException
    //   234	244	491	java/io/FileNotFoundException
    //   254	263	491	java/io/FileNotFoundException
    //   273	289	491	java/io/FileNotFoundException
    //   303	316	498	java/io/FileNotFoundException
    //   11	71	503	java/io/UnsupportedEncodingException
    //   303	316	513	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.b
 * JD-Core Version:    0.7.0.1
 */