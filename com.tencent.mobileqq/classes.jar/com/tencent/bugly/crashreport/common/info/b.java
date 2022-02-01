package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
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
  
  public static String a(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!x.a(paramContext)) {
        x.a("Failed to get Android ID.", new Object[0]);
      }
    }
    return localObject;
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
        if (((String)localObject2).equals("fail"))
        {
          localObject1 = localObject3;
        }
        else
        {
          paramContext = new StringBuilder("ABI list: ");
          paramContext.append((String)localObject2);
          x.b(b.class, paramContext.toString(), new Object[0]);
          localObject1 = localObject2.split(",")[0];
        }
      }
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = System.getProperty("os.arch");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      paramContext = ((StringBuilder)localObject1).toString();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label144:
      break label144;
    }
    if (!x.a(paramContext)) {
      paramContext.printStackTrace();
    }
    return "fail";
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
  
  public static String b(Context paramContext)
  {
    String str = "fail";
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = str;
      if (localObject == null) {
        break label54;
      }
      localObject = ((TelephonyManager)localObject).getSimSerialNumber();
      paramContext = (Context)localObject;
      if (localObject != null) {
        break label54;
      }
      return "null";
    }
    catch (Throwable paramContext)
    {
      label41:
      label54:
      break label41;
    }
    x.a("Failed to get SIM serial number.", new Object[0]);
    paramContext = str;
    return paramContext;
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
  
  public static String c(Context paramContext)
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
        if (localNetworkInfo.getType() == 0)
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            int i = paramContext.getNetworkType();
            switch (i)
            {
            default: 
              paramContext = new StringBuilder("MOBILE(");
              paramContext.append(i);
              paramContext.append(")");
              paramContext = paramContext.toString();
              return paramContext;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        if (!x.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
      return "unknown";
    }
    return "HSPA+";
    return "eHRPD";
    return "LTE";
    return "EVDO_B";
    return "iDen";
    return "HSPA";
    return "HSUPA";
    return "HSDPA";
    return "1xRTT";
    return "EVDO_A";
    return "EVDO_0";
    return "CDMA";
    return "UMTS";
    return "EDGE";
    return "GPRS";
  }
  
  public static String d()
  {
    return "null";
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = z.a(paramContext, "ro.miui.ui.version.name");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("XiaoMi/MIUI/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.build.version.emui");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("HuaWei/EMOTION/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.lenovo.series");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = z.a(paramContext, "ro.build.version.incremental");
      localObject = new StringBuilder("Lenovo/VIBE/");
      ((StringBuilder)localObject).append(paramContext);
      return ((StringBuilder)localObject).toString();
    }
    localObject = z.a(paramContext, "ro.build.nubia.rom.name");
    StringBuilder localStringBuilder;
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("Zte/NUBIA/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append(z.a(paramContext, "ro.build.nubia.rom.code"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.meizu.product.model");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localObject = new StringBuilder("Meizu/FLYME/");
      ((StringBuilder)localObject).append(z.a(paramContext, "ro.build.display.id"));
      return ((StringBuilder)localObject).toString();
    }
    localObject = z.a(paramContext, "ro.build.version.opporom");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("Oppo/COLOROS/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.vivo.os.build.display.id");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("vivo/FUNTOUCH/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = z.a(paramContext, "ro.aa.romver");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("htc/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(z.a(paramContext, "ro.build.description"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.lewa.version");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("tcl/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(z.a(paramContext, "ro.build.display.id"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.gn.gnromvernumber");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder("amigo/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(z.a(paramContext, "ro.build.display.id"));
      return localStringBuilder.toString();
    }
    localObject = z.a(paramContext, "ro.build.tyd.kbstyle_version");
    if ((!z.a((String)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder("dido/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(z.a(paramContext, "ro.build.fingerprint"));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(z.a(paramContext, "ro.build.rom.id"));
    return ((StringBuilder)localObject).toString();
  }
  
  public static String e()
  {
    return "null";
  }
  
  public static String e(Context paramContext)
  {
    return z.a(paramContext, "ro.board.platform");
  }
  
  public static String f()
  {
    return "null";
  }
  
  public static String f(Context paramContext)
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
  
  public static String g()
  {
    try
    {
      String str = Build.SERIAL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    x.a("Failed to get hardware serial number.", new Object[0]);
    return "fail";
  }
  
  /* Error */
  public static String g(Context paramContext)
  {
    // Byte code:
    //   0: new 245	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: getstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   11: ifnonnull +13 -> 24
    //   14: aload_0
    //   15: ldc_w 441
    //   18: invokestatic 234	com/tencent/bugly/proguard/z:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   24: getstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   27: ifnull +35 -> 62
    //   30: aload_3
    //   31: ldc_w 441
    //   34: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: ldc_w 425
    //   42: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: getstatic 177	com/tencent/bugly/crashreport/common/info/b:d	Ljava/lang/String;
    //   50: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc_w 427
    //   58: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: getstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   65: ifnonnull +13 -> 78
    //   68: aload_0
    //   69: ldc_w 443
    //   72: invokestatic 234	com/tencent/bugly/proguard/z:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   75: putstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   78: getstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   81: ifnull +35 -> 116
    //   84: aload_3
    //   85: ldc_w 443
    //   88: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: ldc_w 425
    //   96: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: getstatic 179	com/tencent/bugly/crashreport/common/info/b:e	Ljava/lang/String;
    //   104: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_3
    //   109: ldc_w 427
    //   112: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: new 445	java/io/BufferedReader
    //   119: dup
    //   120: new 447	java/io/FileReader
    //   123: dup
    //   124: ldc_w 449
    //   127: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   130: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_1
    //   137: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +15 -> 157
    //   145: aload_1
    //   146: astore_0
    //   147: aload_2
    //   148: ldc_w 458
    //   151: invokevirtual 461	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   154: ifeq -20 -> 134
    //   157: aload_2
    //   158: ifnull +43 -> 201
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: bipush 10
    //   166: invokevirtual 465	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   172: astore_2
    //   173: aload_1
    //   174: astore_0
    //   175: aload_3
    //   176: ldc_w 470
    //   179: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: astore_0
    //   185: aload_3
    //   186: ldc_w 425
    //   189: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: astore_0
    //   195: aload_3
    //   196: aload_2
    //   197: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: astore_0
    //   203: aload_3
    //   204: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_2
    //   208: aload_1
    //   209: invokevirtual 473	java/io/BufferedReader:close	()V
    //   212: aload_2
    //   213: areturn
    //   214: astore_0
    //   215: aload_0
    //   216: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   219: pop
    //   220: aload_2
    //   221: areturn
    //   222: astore_2
    //   223: goto +12 -> 235
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_0
    //   229: goto +36 -> 265
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: astore_0
    //   237: aload_2
    //   238: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   241: pop
    //   242: aload_1
    //   243: ifnull +16 -> 259
    //   246: aload_1
    //   247: invokevirtual 473	java/io/BufferedReader:close	()V
    //   250: goto +9 -> 259
    //   253: astore_0
    //   254: aload_0
    //   255: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   258: pop
    //   259: aload_3
    //   260: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: areturn
    //   264: astore_1
    //   265: aload_0
    //   266: ifnull +16 -> 282
    //   269: aload_0
    //   270: invokevirtual 473	java/io/BufferedReader:close	()V
    //   273: goto +9 -> 282
    //   276: astore_0
    //   277: aload_0
    //   278: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   281: pop
    //   282: goto +5 -> 287
    //   285: aload_1
    //   286: athrow
    //   287: goto -2 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramContext	Context
    //   133	76	1	localBufferedReader	BufferedReader
    //   226	1	1	localObject1	Object
    //   234	13	1	localObject2	Object
    //   264	22	1	localObject3	Object
    //   140	81	2	str	String
    //   222	1	2	localThrowable1	Throwable
    //   232	6	2	localThrowable2	Throwable
    //   7	253	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   208	212	214	java/io/IOException
    //   136	141	222	java/lang/Throwable
    //   147	157	222	java/lang/Throwable
    //   163	173	222	java/lang/Throwable
    //   175	183	222	java/lang/Throwable
    //   185	193	222	java/lang/Throwable
    //   195	201	222	java/lang/Throwable
    //   203	208	222	java/lang/Throwable
    //   116	134	226	finally
    //   116	134	232	java/lang/Throwable
    //   246	250	253	java/io/IOException
    //   136	141	264	finally
    //   147	157	264	finally
    //   163	173	264	finally
    //   175	183	264	finally
    //   185	193	264	finally
    //   195	201	264	finally
    //   203	208	264	finally
    //   237	242	264	finally
    //   269	273	276	java/io/IOException
  }
  
  public static long h()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static String h(Context paramContext)
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
  
  public static long i()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static boolean i(Context paramContext)
  {
    if (k(paramContext) == null)
    {
      paramContext = new ArrayList();
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = c;
        if (i >= arrayOfString.length) {
          break;
        }
        if (i == 0 ? !new File(arrayOfString[i]).exists() : new File(arrayOfString[i]).exists()) {
          paramContext.add(Integer.valueOf(i));
        }
        i += 1;
      }
      if (paramContext.isEmpty()) {
        paramContext = null;
      } else {
        paramContext = paramContext.toString();
      }
      if (paramContext == null) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static long j()
  {
    // Byte code:
    //   0: new 447	java/io/FileReader
    //   3: dup
    //   4: ldc_w 533
    //   7: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 445	java/io/BufferedReader
    //   14: dup
    //   15: aload_3
    //   16: sipush 2048
    //   19: invokespecial 536	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore 4
    //   26: aload_3
    //   27: astore 5
    //   29: aload_2
    //   30: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnonnull +45 -> 82
    //   40: aload_2
    //   41: invokevirtual 473	java/io/BufferedReader:close	()V
    //   44: goto +15 -> 59
    //   47: astore_2
    //   48: aload_2
    //   49: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   52: ifne +7 -> 59
    //   55: aload_2
    //   56: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   59: aload_3
    //   60: invokevirtual 538	java/io/FileReader:close	()V
    //   63: goto +15 -> 78
    //   66: astore_2
    //   67: aload_2
    //   68: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   71: ifne +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   78: ldc2_w 496
    //   81: lreturn
    //   82: aload_2
    //   83: astore 4
    //   85: aload_3
    //   86: astore 5
    //   88: aload 6
    //   90: ldc_w 540
    //   93: iconst_2
    //   94: invokevirtual 543	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   97: iconst_1
    //   98: aaload
    //   99: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   102: ldc_w 545
    //   105: ldc_w 547
    //   108: invokevirtual 551	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   111: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   114: invokestatic 557	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   117: lstore_0
    //   118: lload_0
    //   119: bipush 10
    //   121: lshl
    //   122: lstore_0
    //   123: aload_2
    //   124: invokevirtual 473	java/io/BufferedReader:close	()V
    //   127: goto +15 -> 142
    //   130: astore_2
    //   131: aload_2
    //   132: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   135: ifne +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   142: aload_3
    //   143: invokevirtual 538	java/io/FileReader:close	()V
    //   146: lload_0
    //   147: lreturn
    //   148: astore_2
    //   149: aload_2
    //   150: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   153: ifne +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   160: lload_0
    //   161: lreturn
    //   162: astore 6
    //   164: goto +32 -> 196
    //   167: astore_2
    //   168: aconst_null
    //   169: astore 4
    //   171: goto +104 -> 275
    //   174: astore 6
    //   176: aconst_null
    //   177: astore_2
    //   178: goto +18 -> 196
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_3
    //   184: aload_3
    //   185: astore 4
    //   187: goto +88 -> 275
    //   190: astore 6
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_2
    //   196: aload_2
    //   197: astore 4
    //   199: aload_3
    //   200: astore 5
    //   202: aload 6
    //   204: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   207: ifne +14 -> 221
    //   210: aload_2
    //   211: astore 4
    //   213: aload_3
    //   214: astore 5
    //   216: aload 6
    //   218: invokevirtual 199	java/lang/Throwable:printStackTrace	()V
    //   221: aload_2
    //   222: ifnull +22 -> 244
    //   225: aload_2
    //   226: invokevirtual 473	java/io/BufferedReader:close	()V
    //   229: goto +15 -> 244
    //   232: astore_2
    //   233: aload_2
    //   234: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   237: ifne +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   244: aload_3
    //   245: ifnull +22 -> 267
    //   248: aload_3
    //   249: invokevirtual 538	java/io/FileReader:close	()V
    //   252: goto +15 -> 267
    //   255: astore_2
    //   256: aload_2
    //   257: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   260: ifne +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   267: ldc2_w 558
    //   270: lreturn
    //   271: astore_2
    //   272: aload 5
    //   274: astore_3
    //   275: aload 4
    //   277: ifnull +26 -> 303
    //   280: aload 4
    //   282: invokevirtual 473	java/io/BufferedReader:close	()V
    //   285: goto +18 -> 303
    //   288: astore 4
    //   290: aload 4
    //   292: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   295: ifne +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   303: aload_3
    //   304: ifnull +22 -> 326
    //   307: aload_3
    //   308: invokevirtual 538	java/io/FileReader:close	()V
    //   311: goto +15 -> 326
    //   314: astore_3
    //   315: aload_3
    //   316: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   319: ifne +7 -> 326
    //   322: aload_3
    //   323: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   326: aload_2
    //   327: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   117	44	0	l	long
    //   22	19	2	localBufferedReader	BufferedReader
    //   47	9	2	localIOException1	IOException
    //   66	58	2	localIOException2	IOException
    //   130	9	2	localIOException3	IOException
    //   148	9	2	localIOException4	IOException
    //   167	1	2	localObject1	Object
    //   177	1	2	localObject2	Object
    //   181	1	2	localObject3	Object
    //   195	31	2	localObject4	Object
    //   232	9	2	localIOException5	IOException
    //   255	9	2	localIOException6	IOException
    //   271	56	2	localObject5	Object
    //   10	298	3	localObject6	Object
    //   314	9	3	localIOException7	IOException
    //   24	257	4	localObject7	Object
    //   288	11	4	localIOException8	IOException
    //   27	246	5	localObject8	Object
    //   33	56	6	str	String
    //   162	1	6	localThrowable1	Throwable
    //   174	1	6	localThrowable2	Throwable
    //   190	27	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   40	44	47	java/io/IOException
    //   59	63	66	java/io/IOException
    //   123	127	130	java/io/IOException
    //   142	146	148	java/io/IOException
    //   29	35	162	java/lang/Throwable
    //   88	118	162	java/lang/Throwable
    //   11	23	167	finally
    //   11	23	174	java/lang/Throwable
    //   0	11	181	finally
    //   0	11	190	java/lang/Throwable
    //   225	229	232	java/io/IOException
    //   248	252	255	java/io/IOException
    //   29	35	271	finally
    //   88	118	271	finally
    //   202	210	271	finally
    //   216	221	271	finally
    //   280	285	288	java/io/IOException
    //   307	311	314	java/io/IOException
  }
  
  public static boolean j(Context paramContext)
  {
    return (l(paramContext) | w() | x() | v()) > 0;
  }
  
  /* Error */
  public static long k()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 10
    //   6: new 447	java/io/FileReader
    //   9: dup
    //   10: ldc_w 533
    //   13: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   16: astore 6
    //   18: aload 6
    //   20: astore 7
    //   22: new 445	java/io/BufferedReader
    //   25: dup
    //   26: aload 6
    //   28: sipush 2048
    //   31: invokespecial 536	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   34: astore 9
    //   36: aload 9
    //   38: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: pop
    //   42: aload 9
    //   44: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 7
    //   49: aload 7
    //   51: ifnonnull +54 -> 105
    //   54: aload 9
    //   56: invokevirtual 473	java/io/BufferedReader:close	()V
    //   59: goto +18 -> 77
    //   62: astore 7
    //   64: aload 7
    //   66: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   69: ifne +8 -> 77
    //   72: aload 7
    //   74: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   77: aload 6
    //   79: invokevirtual 538	java/io/FileReader:close	()V
    //   82: ldc2_w 496
    //   85: lreturn
    //   86: astore 6
    //   88: aload 6
    //   90: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   93: ifne +8 -> 101
    //   96: aload 6
    //   98: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   101: ldc2_w 496
    //   104: lreturn
    //   105: aload 7
    //   107: ldc_w 540
    //   110: iconst_2
    //   111: invokevirtual 543	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   114: iconst_1
    //   115: aaload
    //   116: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   119: ldc_w 545
    //   122: ldc_w 547
    //   125: invokevirtual 551	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   128: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   131: invokestatic 557	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   134: lstore_0
    //   135: aload 9
    //   137: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore 7
    //   142: aload 7
    //   144: ifnonnull +54 -> 198
    //   147: aload 9
    //   149: invokevirtual 473	java/io/BufferedReader:close	()V
    //   152: goto +18 -> 170
    //   155: astore 7
    //   157: aload 7
    //   159: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   162: ifne +8 -> 170
    //   165: aload 7
    //   167: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   170: aload 6
    //   172: invokevirtual 538	java/io/FileReader:close	()V
    //   175: ldc2_w 496
    //   178: lreturn
    //   179: astore 6
    //   181: aload 6
    //   183: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   186: ifne +8 -> 194
    //   189: aload 6
    //   191: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   194: ldc2_w 496
    //   197: lreturn
    //   198: aload 7
    //   200: ldc_w 540
    //   203: iconst_2
    //   204: invokevirtual 543	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   207: iconst_1
    //   208: aaload
    //   209: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   212: ldc_w 545
    //   215: ldc_w 547
    //   218: invokevirtual 551	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   221: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   224: invokestatic 557	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   227: lstore_2
    //   228: aload 9
    //   230: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   233: astore 7
    //   235: aload 7
    //   237: ifnonnull +54 -> 291
    //   240: aload 9
    //   242: invokevirtual 473	java/io/BufferedReader:close	()V
    //   245: goto +18 -> 263
    //   248: astore 7
    //   250: aload 7
    //   252: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   255: ifne +8 -> 263
    //   258: aload 7
    //   260: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   263: aload 6
    //   265: invokevirtual 538	java/io/FileReader:close	()V
    //   268: ldc2_w 496
    //   271: lreturn
    //   272: astore 6
    //   274: aload 6
    //   276: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   279: ifne +8 -> 287
    //   282: aload 6
    //   284: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   287: ldc2_w 496
    //   290: lreturn
    //   291: aload 7
    //   293: ldc_w 540
    //   296: iconst_2
    //   297: invokevirtual 543	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   300: iconst_1
    //   301: aaload
    //   302: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   305: ldc_w 545
    //   308: ldc_w 547
    //   311: invokevirtual 551	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   314: invokevirtual 468	java/lang/String:trim	()Ljava/lang/String;
    //   317: invokestatic 557	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   320: lstore 4
    //   322: lload_0
    //   323: bipush 10
    //   325: lshl
    //   326: lconst_0
    //   327: ladd
    //   328: lload_2
    //   329: bipush 10
    //   331: lshl
    //   332: ladd
    //   333: lload 4
    //   335: bipush 10
    //   337: lshl
    //   338: ladd
    //   339: lstore_0
    //   340: aload 9
    //   342: invokevirtual 473	java/io/BufferedReader:close	()V
    //   345: goto +18 -> 363
    //   348: astore 7
    //   350: aload 7
    //   352: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   355: ifne +8 -> 363
    //   358: aload 7
    //   360: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   363: aload 6
    //   365: invokevirtual 538	java/io/FileReader:close	()V
    //   368: lload_0
    //   369: lreturn
    //   370: astore 6
    //   372: aload 6
    //   374: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   377: ifne +8 -> 385
    //   380: aload 6
    //   382: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   385: lload_0
    //   386: lreturn
    //   387: astore 7
    //   389: aload 9
    //   391: astore 8
    //   393: goto +137 -> 530
    //   396: astore 7
    //   398: aload 9
    //   400: astore 10
    //   402: aload 7
    //   404: astore 9
    //   406: goto +25 -> 431
    //   409: astore 9
    //   411: goto +20 -> 431
    //   414: astore 7
    //   416: aconst_null
    //   417: astore 8
    //   419: aload 8
    //   421: astore 6
    //   423: goto +107 -> 530
    //   426: astore 9
    //   428: aconst_null
    //   429: astore 6
    //   431: aload 10
    //   433: astore 8
    //   435: aload 6
    //   437: astore 7
    //   439: aload 9
    //   441: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   444: ifne +16 -> 460
    //   447: aload 10
    //   449: astore 8
    //   451: aload 6
    //   453: astore 7
    //   455: aload 9
    //   457: invokevirtual 199	java/lang/Throwable:printStackTrace	()V
    //   460: aload 10
    //   462: ifnull +26 -> 488
    //   465: aload 10
    //   467: invokevirtual 473	java/io/BufferedReader:close	()V
    //   470: goto +18 -> 488
    //   473: astore 7
    //   475: aload 7
    //   477: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   480: ifne +8 -> 488
    //   483: aload 7
    //   485: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   488: aload 6
    //   490: ifnull +26 -> 516
    //   493: aload 6
    //   495: invokevirtual 538	java/io/FileReader:close	()V
    //   498: goto +18 -> 516
    //   501: astore 6
    //   503: aload 6
    //   505: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   508: ifne +8 -> 516
    //   511: aload 6
    //   513: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   516: ldc2_w 558
    //   519: lreturn
    //   520: astore 9
    //   522: aload 7
    //   524: astore 6
    //   526: aload 9
    //   528: astore 7
    //   530: aload 8
    //   532: ifnull +26 -> 558
    //   535: aload 8
    //   537: invokevirtual 473	java/io/BufferedReader:close	()V
    //   540: goto +18 -> 558
    //   543: astore 8
    //   545: aload 8
    //   547: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   550: ifne +8 -> 558
    //   553: aload 8
    //   555: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   558: aload 6
    //   560: ifnull +26 -> 586
    //   563: aload 6
    //   565: invokevirtual 538	java/io/FileReader:close	()V
    //   568: goto +18 -> 586
    //   571: astore 6
    //   573: aload 6
    //   575: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   578: ifne +8 -> 586
    //   581: aload 6
    //   583: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   586: aload 7
    //   588: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   134	252	0	l1	long
    //   227	102	2	l2	long
    //   320	14	4	l3	long
    //   16	62	6	localFileReader	FileReader
    //   86	85	6	localIOException1	IOException
    //   179	85	6	localIOException2	IOException
    //   272	92	6	localIOException3	IOException
    //   370	11	6	localIOException4	IOException
    //   421	73	6	localObject1	Object
    //   501	11	6	localIOException5	IOException
    //   524	40	6	localObject2	Object
    //   571	11	6	localIOException6	IOException
    //   20	30	7	localObject3	Object
    //   62	44	7	localIOException7	IOException
    //   140	3	7	str1	String
    //   155	44	7	localIOException8	IOException
    //   233	3	7	str2	String
    //   248	44	7	localIOException9	IOException
    //   348	11	7	localIOException10	IOException
    //   387	1	7	localObject4	Object
    //   396	7	7	localThrowable1	Throwable
    //   414	1	7	localObject5	Object
    //   437	17	7	localObject6	Object
    //   473	50	7	localIOException11	IOException
    //   528	59	7	localObject7	Object
    //   1	535	8	localObject8	Object
    //   543	11	8	localIOException12	IOException
    //   34	371	9	localObject9	Object
    //   409	1	9	localThrowable2	Throwable
    //   426	30	9	localThrowable3	Throwable
    //   520	7	9	localObject10	Object
    //   4	462	10	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	62	java/io/IOException
    //   77	82	86	java/io/IOException
    //   147	152	155	java/io/IOException
    //   170	175	179	java/io/IOException
    //   240	245	248	java/io/IOException
    //   263	268	272	java/io/IOException
    //   340	345	348	java/io/IOException
    //   363	368	370	java/io/IOException
    //   36	49	387	finally
    //   105	142	387	finally
    //   198	235	387	finally
    //   291	322	387	finally
    //   36	49	396	java/lang/Throwable
    //   105	142	396	java/lang/Throwable
    //   198	235	396	java/lang/Throwable
    //   291	322	396	java/lang/Throwable
    //   22	36	409	java/lang/Throwable
    //   6	18	414	finally
    //   6	18	426	java/lang/Throwable
    //   465	470	473	java/io/IOException
    //   493	498	501	java/io/IOException
    //   22	36	520	finally
    //   439	447	520	finally
    //   455	460	520	finally
    //   535	540	543	java/io/IOException
    //   563	568	571	java/io/IOException
  }
  
  private static String k(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = b;
      if (i < arrayOfString.length) {}
      try
      {
        paramContext.getPackageInfo(arrayOfString[i], 1);
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
  
  private static int l(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getInstallerPackageName("de.robv.android.xposed.installer");
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramContext.getInstallerPackageName("com.saurik.substrate");
          return i | 0x2;
        }
        catch (Exception paramContext) {}
        localException = localException;
      }
    }
    int i = 0;
    return i;
  }
  
  public static long l()
  {
    if (!u()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getBlockCount();
      return j * i;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static long m()
  {
    if (!u()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      return j * i;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static String n()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
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
  
  public static String o()
  {
    try
    {
      String str = Build.BRAND;
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
  
  public static boolean p()
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (new File(arrayOfString[i]).exists())
      {
        i = 1;
        break label44;
      }
      i += 1;
    }
    i = 0;
    label44:
    if ((Build.TAGS != null) && (Build.TAGS.contains("test-keys"))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      return i != 0;
    }
    return true;
  }
  
  /* Error */
  public static String q()
  {
    // Byte code:
    //   0: new 245	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 485	java/io/File
    //   12: dup
    //   13: ldc_w 625
    //   16: invokespecial 513	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 517	java/io/File:exists	()Z
    //   22: ifeq +348 -> 370
    //   25: new 445	java/io/BufferedReader
    //   28: dup
    //   29: new 447	java/io/FileReader
    //   32: dup
    //   33: ldc_w 625
    //   36: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload_0
    //   46: astore_2
    //   47: aload_0
    //   48: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +14 -> 67
    //   56: aload_0
    //   57: astore_1
    //   58: aload_0
    //   59: astore_2
    //   60: aload 4
    //   62: aload_3
    //   63: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_0
    //   68: astore_1
    //   69: aload_0
    //   70: astore_2
    //   71: aload_0
    //   72: invokevirtual 473	java/io/BufferedReader:close	()V
    //   75: goto +3 -> 78
    //   78: aload_0
    //   79: astore_1
    //   80: aload_0
    //   81: astore_2
    //   82: aload 4
    //   84: ldc_w 262
    //   87: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_0
    //   92: astore_1
    //   93: aload_0
    //   94: astore_2
    //   95: new 485	java/io/File
    //   98: dup
    //   99: ldc_w 627
    //   102: invokespecial 513	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 517	java/io/File:exists	()Z
    //   108: ifeq +267 -> 375
    //   111: aload_0
    //   112: astore_1
    //   113: aload_0
    //   114: astore_2
    //   115: new 445	java/io/BufferedReader
    //   118: dup
    //   119: new 447	java/io/FileReader
    //   122: dup
    //   123: ldc_w 627
    //   126: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   129: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   132: astore_0
    //   133: aload_0
    //   134: astore_1
    //   135: aload_0
    //   136: astore_3
    //   137: aload_0
    //   138: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +14 -> 157
    //   146: aload_0
    //   147: astore_1
    //   148: aload_0
    //   149: astore_3
    //   150: aload 4
    //   152: aload_2
    //   153: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_0
    //   158: astore_1
    //   159: aload_0
    //   160: astore_3
    //   161: aload_0
    //   162: invokevirtual 473	java/io/BufferedReader:close	()V
    //   165: goto +3 -> 168
    //   168: aload_0
    //   169: astore_1
    //   170: aload_0
    //   171: astore_3
    //   172: aload 4
    //   174: ldc_w 262
    //   177: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_0
    //   182: astore_1
    //   183: aload_0
    //   184: astore_3
    //   185: new 485	java/io/File
    //   188: dup
    //   189: ldc_w 629
    //   192: invokespecial 513	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: invokevirtual 517	java/io/File:exists	()Z
    //   198: ifeq +180 -> 378
    //   201: aload_0
    //   202: astore_1
    //   203: aload_0
    //   204: astore_3
    //   205: new 445	java/io/BufferedReader
    //   208: dup
    //   209: new 447	java/io/FileReader
    //   212: dup
    //   213: ldc_w 629
    //   216: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   219: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   222: astore_2
    //   223: aload_2
    //   224: astore_1
    //   225: aload_2
    //   226: astore_3
    //   227: aload_2
    //   228: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   231: astore 5
    //   233: aload_2
    //   234: astore_0
    //   235: aload 5
    //   237: ifnull +20 -> 257
    //   240: aload_2
    //   241: astore_1
    //   242: aload_2
    //   243: astore_3
    //   244: aload 4
    //   246: aload 5
    //   248: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_2
    //   253: astore_0
    //   254: goto +3 -> 257
    //   257: aload_0
    //   258: astore_1
    //   259: aload_0
    //   260: astore_3
    //   261: aload 4
    //   263: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: astore_2
    //   267: aload_0
    //   268: ifnull +15 -> 283
    //   271: aload_0
    //   272: invokevirtual 473	java/io/BufferedReader:close	()V
    //   275: aload_2
    //   276: areturn
    //   277: astore_0
    //   278: aload_0
    //   279: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   282: pop
    //   283: aload_2
    //   284: areturn
    //   285: astore_0
    //   286: goto +29 -> 315
    //   289: aload_3
    //   290: astore_0
    //   291: goto +45 -> 336
    //   294: astore_0
    //   295: goto +20 -> 315
    //   298: aload_3
    //   299: astore_0
    //   300: goto +36 -> 336
    //   303: astore_0
    //   304: goto +11 -> 315
    //   307: aload_2
    //   308: astore_0
    //   309: goto +27 -> 336
    //   312: astore_0
    //   313: aconst_null
    //   314: astore_1
    //   315: aload_1
    //   316: ifnull +16 -> 332
    //   319: aload_1
    //   320: invokevirtual 473	java/io/BufferedReader:close	()V
    //   323: goto +9 -> 332
    //   326: astore_1
    //   327: aload_1
    //   328: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   331: pop
    //   332: aload_0
    //   333: athrow
    //   334: aconst_null
    //   335: astore_0
    //   336: aload_0
    //   337: ifnull +15 -> 352
    //   340: aload_0
    //   341: invokevirtual 473	java/io/BufferedReader:close	()V
    //   344: aconst_null
    //   345: areturn
    //   346: astore_0
    //   347: aload_0
    //   348: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   351: pop
    //   352: aconst_null
    //   353: areturn
    //   354: astore_0
    //   355: goto -21 -> 334
    //   358: astore_0
    //   359: goto -52 -> 307
    //   362: astore_0
    //   363: goto -65 -> 298
    //   366: astore_0
    //   367: goto -78 -> 289
    //   370: aconst_null
    //   371: astore_0
    //   372: goto -294 -> 78
    //   375: goto -207 -> 168
    //   378: goto -121 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	230	0	localObject1	Object
    //   277	2	0	localIOException1	IOException
    //   285	1	0	localObject2	Object
    //   290	1	0	localObject3	Object
    //   294	1	0	localObject4	Object
    //   299	1	0	localObject5	Object
    //   303	1	0	localObject6	Object
    //   308	1	0	localObject7	Object
    //   312	21	0	localObject8	Object
    //   335	6	0	localObject9	Object
    //   346	2	0	localIOException2	IOException
    //   354	1	0	localThrowable1	Throwable
    //   358	1	0	localThrowable2	Throwable
    //   362	1	0	localThrowable3	Throwable
    //   366	1	0	localThrowable4	Throwable
    //   371	1	0	localObject10	Object
    //   44	276	1	localObject11	Object
    //   326	2	1	localIOException3	IOException
    //   46	262	2	localObject12	Object
    //   51	248	3	localObject13	Object
    //   7	255	4	localStringBuilder	StringBuilder
    //   231	16	5	str	String
    // Exception table:
    //   from	to	target	type
    //   271	275	277	java/io/IOException
    //   227	233	285	finally
    //   244	252	285	finally
    //   261	267	285	finally
    //   137	142	294	finally
    //   150	157	294	finally
    //   161	165	294	finally
    //   172	181	294	finally
    //   185	201	294	finally
    //   205	223	294	finally
    //   47	52	303	finally
    //   60	67	303	finally
    //   71	75	303	finally
    //   82	91	303	finally
    //   95	111	303	finally
    //   115	133	303	finally
    //   0	43	312	finally
    //   319	323	326	java/io/IOException
    //   340	344	346	java/io/IOException
    //   0	43	354	java/lang/Throwable
    //   47	52	358	java/lang/Throwable
    //   60	67	358	java/lang/Throwable
    //   71	75	358	java/lang/Throwable
    //   82	91	358	java/lang/Throwable
    //   95	111	358	java/lang/Throwable
    //   115	133	358	java/lang/Throwable
    //   137	142	362	java/lang/Throwable
    //   150	157	362	java/lang/Throwable
    //   161	165	362	java/lang/Throwable
    //   172	181	362	java/lang/Throwable
    //   185	201	362	java/lang/Throwable
    //   205	223	362	java/lang/Throwable
    //   227	233	366	java/lang/Throwable
    //   244	252	366	java/lang/Throwable
    //   261	267	366	java/lang/Throwable
  }
  
  /* Error */
  public static String r()
  {
    // Byte code:
    //   0: new 245	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore_1
    //   16: aload_2
    //   17: astore_3
    //   18: aload 5
    //   20: astore 4
    //   22: new 485	java/io/File
    //   25: dup
    //   26: ldc_w 632
    //   29: invokespecial 513	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 517	java/io/File:exists	()Z
    //   35: istore_0
    //   36: iload_0
    //   37: ifeq +82 -> 119
    //   40: aload_2
    //   41: astore_3
    //   42: aload 5
    //   44: astore 4
    //   46: new 445	java/io/BufferedReader
    //   49: dup
    //   50: new 447	java/io/FileReader
    //   53: dup
    //   54: ldc_w 632
    //   57: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   60: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_2
    //   69: aload_2
    //   70: ifnull +28 -> 98
    //   73: aload 6
    //   75: ldc_w 634
    //   78: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: ldc_w 425
    //   87: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 6
    //   93: aload_2
    //   94: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_1
    //   99: invokevirtual 473	java/io/BufferedReader:close	()V
    //   102: goto +17 -> 119
    //   105: astore_2
    //   106: aload_1
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: goto +256 -> 366
    //   113: aload_1
    //   114: astore 4
    //   116: goto +269 -> 385
    //   119: aload_1
    //   120: astore_3
    //   121: aload_1
    //   122: astore 4
    //   124: aload 6
    //   126: ldc_w 427
    //   129: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: astore_2
    //   135: aload_1
    //   136: astore_3
    //   137: aload_1
    //   138: astore 4
    //   140: new 485	java/io/File
    //   143: dup
    //   144: ldc_w 636
    //   147: invokespecial 513	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: invokevirtual 517	java/io/File:exists	()Z
    //   153: ifeq +83 -> 236
    //   156: aload_1
    //   157: astore_3
    //   158: aload_1
    //   159: astore 4
    //   161: new 445	java/io/BufferedReader
    //   164: dup
    //   165: new 447	java/io/FileReader
    //   168: dup
    //   169: ldc_w 636
    //   172: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   175: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   183: astore_2
    //   184: aload_2
    //   185: ifnull +28 -> 213
    //   188: aload 6
    //   190: ldc_w 638
    //   193: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: ldc_w 425
    //   202: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: aload_2
    //   209: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_1
    //   214: invokevirtual 473	java/io/BufferedReader:close	()V
    //   217: aload_1
    //   218: astore_2
    //   219: goto +17 -> 236
    //   222: astore_2
    //   223: aload_1
    //   224: astore_3
    //   225: aload_2
    //   226: astore_1
    //   227: goto +139 -> 366
    //   230: aload_1
    //   231: astore 4
    //   233: goto +152 -> 385
    //   236: aload_2
    //   237: astore_3
    //   238: aload_2
    //   239: astore 4
    //   241: aload 6
    //   243: ldc_w 427
    //   246: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: astore_3
    //   252: aload_2
    //   253: astore 4
    //   255: new 485	java/io/File
    //   258: dup
    //   259: ldc_w 640
    //   262: invokespecial 513	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: invokevirtual 517	java/io/File:exists	()Z
    //   268: ifeq +81 -> 349
    //   271: aload_2
    //   272: astore_3
    //   273: aload_2
    //   274: astore 4
    //   276: new 445	java/io/BufferedReader
    //   279: dup
    //   280: new 447	java/io/FileReader
    //   283: dup
    //   284: ldc_w 640
    //   287: invokespecial 450	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   290: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   298: astore_2
    //   299: aload_2
    //   300: ifnull +28 -> 328
    //   303: aload 6
    //   305: ldc_w 642
    //   308: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 6
    //   314: ldc_w 425
    //   317: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 6
    //   323: aload_2
    //   324: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: invokevirtual 473	java/io/BufferedReader:close	()V
    //   332: goto +19 -> 351
    //   335: astore_2
    //   336: aload_1
    //   337: astore_3
    //   338: aload_2
    //   339: astore_1
    //   340: goto +26 -> 366
    //   343: aload_1
    //   344: astore 4
    //   346: goto +39 -> 385
    //   349: aload_2
    //   350: astore_1
    //   351: aload_1
    //   352: ifnull +52 -> 404
    //   355: aload_1
    //   356: invokevirtual 473	java/io/BufferedReader:close	()V
    //   359: goto +45 -> 404
    //   362: goto +23 -> 385
    //   365: astore_1
    //   366: aload_3
    //   367: ifnull +16 -> 383
    //   370: aload_3
    //   371: invokevirtual 473	java/io/BufferedReader:close	()V
    //   374: goto +9 -> 383
    //   377: astore_2
    //   378: aload_2
    //   379: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   382: pop
    //   383: aload_1
    //   384: athrow
    //   385: aload 4
    //   387: ifnull +17 -> 404
    //   390: aload 4
    //   392: invokevirtual 473	java/io/BufferedReader:close	()V
    //   395: goto +9 -> 404
    //   398: astore_1
    //   399: aload_1
    //   400: invokestatic 196	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   403: pop
    //   404: aload 6
    //   406: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: areturn
    //   410: astore_1
    //   411: goto -49 -> 362
    //   414: astore_2
    //   415: goto -302 -> 113
    //   418: astore_2
    //   419: goto -189 -> 230
    //   422: astore_2
    //   423: goto -80 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	2	0	bool	boolean
    //   15	341	1	localObject1	Object
    //   365	19	1	localObject2	Object
    //   398	2	1	localIOException1	IOException
    //   410	1	1	localThrowable1	Throwable
    //   10	84	2	str1	String
    //   105	4	2	localObject3	Object
    //   134	85	2	localObject4	Object
    //   222	52	2	localObject5	Object
    //   298	26	2	str2	String
    //   335	15	2	localObject6	Object
    //   377	2	2	localIOException2	IOException
    //   414	1	2	localThrowable2	Throwable
    //   418	1	2	localThrowable3	Throwable
    //   422	1	2	localThrowable4	Throwable
    //   17	354	3	localObject7	Object
    //   20	371	4	localObject8	Object
    //   12	31	5	localObject9	Object
    //   7	398	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	69	105	finally
    //   73	98	105	finally
    //   98	102	105	finally
    //   179	184	222	finally
    //   188	213	222	finally
    //   213	217	222	finally
    //   294	299	335	finally
    //   303	328	335	finally
    //   328	332	335	finally
    //   22	36	365	finally
    //   46	64	365	finally
    //   124	133	365	finally
    //   140	156	365	finally
    //   161	179	365	finally
    //   241	250	365	finally
    //   255	271	365	finally
    //   276	294	365	finally
    //   370	374	377	java/io/IOException
    //   355	359	398	java/io/IOException
    //   390	395	398	java/io/IOException
    //   22	36	410	java/lang/Throwable
    //   46	64	410	java/lang/Throwable
    //   124	133	410	java/lang/Throwable
    //   140	156	410	java/lang/Throwable
    //   161	179	410	java/lang/Throwable
    //   241	250	410	java/lang/Throwable
    //   255	271	410	java/lang/Throwable
    //   276	294	410	java/lang/Throwable
    //   64	69	414	java/lang/Throwable
    //   73	98	414	java/lang/Throwable
    //   98	102	414	java/lang/Throwable
    //   179	184	418	java/lang/Throwable
    //   188	213	418	java/lang/Throwable
    //   213	217	418	java/lang/Throwable
    //   294	299	422	java/lang/Throwable
    //   303	328	422	java/lang/Throwable
    //   328	332	422	java/lang/Throwable
  }
  
  public static long s()
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f1 = 0.0F;
    Object localObject5 = null;
    String str = null;
    try
    {
      try
      {
        Object localObject2 = new BufferedReader(new FileReader("/proc/uptime"));
        float f4;
        label110:
        localObject1 = localObject3;
      }
      finally
      {
        try
        {
          try
          {
            str = ((BufferedReader)localObject2).readLine();
            if (str != null)
            {
              str = str.split(" ")[0];
              f1 = (float)(System.currentTimeMillis() / 1000L);
              f4 = Float.parseFloat(str);
              f1 -= f4;
            }
            f2 = f1;
            try
            {
              ((BufferedReader)localObject2).close();
            }
            catch (IOException localIOException1)
            {
              x.a(localIOException1);
              f1 = f2;
            }
          }
          finally
          {
            localObject1 = localObject2;
            localObject2 = localObject6;
            break label150;
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          Object localObject4;
          break label110;
        }
        localObject3 = finally;
        break label150;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        label150:
        localObject4 = localObject6;
      }
    }
    x.a("Failed to get boot time of device.", new Object[0]);
    f1 = f3;
    if (localObject3 != null)
    {
      localObject3.close();
      f1 = f3;
    }
    return f1;
    if (localObject1 != null) {
      try
      {
        localObject1.close();
      }
      catch (IOException localIOException2)
      {
        x.a(localIOException2);
      }
    }
    throw localObject3;
  }
  
  public static boolean t()
  {
    double d1 = Runtime.getRuntime().maxMemory();
    Double.isNaN(d1);
    float f1 = (float)(d1 / 1048576.0D);
    d1 = Runtime.getRuntime().totalMemory();
    Double.isNaN(d1);
    float f2 = (float)(d1 / 1048576.0D);
    float f3 = f1 - f2;
    x.c("maxMemory : %f", new Object[] { Float.valueOf(f1) });
    x.c("totalMemory : %f", new Object[] { Float.valueOf(f2) });
    x.c("freeMemory : %f", new Object[] { Float.valueOf(f3) });
    return f3 < 10.0F;
  }
  
  private static boolean u()
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
  
  private static int v()
  {
    try
    {
      Method localMethod = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = localMethod.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy");
      if (bool) {
        return 256;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 256;
  }
  
  private static int w()
  {
    try
    {
      throw new Exception("detect hook");
    }
    catch (Exception localException)
    {
      StackTraceElement[] arrayOfStackTraceElement = localException.getStackTrace();
      int i1 = arrayOfStackTraceElement.length;
      int k = 0;
      int j = 0;
      int n;
      for (int m = 0; k < i1; m = n)
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
        n = m;
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
      }
      return j;
    }
  }
  
  /* Error */
  private static int x()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 6
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore 4
    //   15: iconst_0
    //   16: istore_0
    //   17: new 763	java/util/HashSet
    //   20: dup
    //   21: invokespecial 764	java/util/HashSet:<init>	()V
    //   24: astore 10
    //   26: new 245	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 766
    //   33: invokespecial 250	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: astore 8
    //   38: aload 8
    //   40: invokestatic 771	android/os/Process:myPid	()I
    //   43: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 8
    //   49: ldc_w 773
    //   52: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: new 445	java/io/BufferedReader
    //   59: dup
    //   60: new 775	java/io/InputStreamReader
    //   63: dup
    //   64: new 777	java/io/FileInputStream
    //   67: dup
    //   68: aload 8
    //   70: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 778	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   76: ldc_w 780
    //   79: invokespecial 783	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   82: invokespecial 453	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 9
    //   87: iload_1
    //   88: istore_2
    //   89: iload 5
    //   91: istore_3
    //   92: iload 6
    //   94: istore 4
    //   96: aload 9
    //   98: astore 8
    //   100: aload 9
    //   102: invokevirtual 456	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 11
    //   107: aload 11
    //   109: ifnull +88 -> 197
    //   112: iload_1
    //   113: istore_2
    //   114: iload 5
    //   116: istore_3
    //   117: iload 6
    //   119: istore 4
    //   121: aload 9
    //   123: astore 8
    //   125: aload 11
    //   127: ldc_w 785
    //   130: invokevirtual 788	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   133: ifne +27 -> 160
    //   136: iload_1
    //   137: istore_2
    //   138: iload 5
    //   140: istore_3
    //   141: iload 6
    //   143: istore 4
    //   145: aload 9
    //   147: astore 8
    //   149: aload 11
    //   151: ldc_w 790
    //   154: invokevirtual 788	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   157: ifeq -70 -> 87
    //   160: iload_1
    //   161: istore_2
    //   162: iload 5
    //   164: istore_3
    //   165: iload 6
    //   167: istore 4
    //   169: aload 9
    //   171: astore 8
    //   173: aload 10
    //   175: aload 11
    //   177: aload 11
    //   179: ldc_w 647
    //   182: invokevirtual 794	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   185: iconst_1
    //   186: iadd
    //   187: invokevirtual 465	java/lang/String:substring	(I)Ljava/lang/String;
    //   190: invokevirtual 795	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   193: pop
    //   194: goto -107 -> 87
    //   197: iload_1
    //   198: istore_2
    //   199: iload 5
    //   201: istore_3
    //   202: iload 6
    //   204: istore 4
    //   206: aload 9
    //   208: astore 8
    //   210: aload 10
    //   212: invokevirtual 799	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   215: astore 10
    //   217: iload_0
    //   218: istore_2
    //   219: iload_0
    //   220: istore_3
    //   221: iload_0
    //   222: istore 4
    //   224: aload 9
    //   226: astore 8
    //   228: aload 10
    //   230: invokeinterface 804 1 0
    //   235: ifeq +98 -> 333
    //   238: iload_0
    //   239: istore_2
    //   240: iload_0
    //   241: istore_3
    //   242: iload_0
    //   243: istore 4
    //   245: aload 9
    //   247: astore 8
    //   249: aload 10
    //   251: invokeinterface 808 1 0
    //   256: astore 11
    //   258: iload_0
    //   259: istore_1
    //   260: iload_0
    //   261: istore_2
    //   262: iload_0
    //   263: istore_3
    //   264: iload_0
    //   265: istore 4
    //   267: aload 9
    //   269: astore 8
    //   271: aload 11
    //   273: checkcast 15	java/lang/String
    //   276: invokevirtual 221	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   279: ldc_w 810
    //   282: invokevirtual 622	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   285: ifeq +8 -> 293
    //   288: iload_0
    //   289: bipush 64
    //   291: ior
    //   292: istore_1
    //   293: iload_1
    //   294: istore_2
    //   295: iload_1
    //   296: istore_3
    //   297: iload_1
    //   298: istore 4
    //   300: aload 9
    //   302: astore 8
    //   304: aload 11
    //   306: checkcast 15	java/lang/String
    //   309: ldc_w 591
    //   312: invokevirtual 622	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   315: istore 7
    //   317: iload_1
    //   318: istore_0
    //   319: iload 7
    //   321: ifeq -104 -> 217
    //   324: iload_1
    //   325: sipush 128
    //   328: ior
    //   329: istore_0
    //   330: goto -113 -> 217
    //   333: iload_0
    //   334: istore_1
    //   335: aload 9
    //   337: invokevirtual 473	java/io/BufferedReader:close	()V
    //   340: iload_0
    //   341: ireturn
    //   342: astore 8
    //   344: aload 8
    //   346: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   349: iload_1
    //   350: ireturn
    //   351: astore 10
    //   353: goto +26 -> 379
    //   356: astore 10
    //   358: goto +51 -> 409
    //   361: astore 10
    //   363: goto +76 -> 439
    //   366: astore 8
    //   368: aconst_null
    //   369: astore 9
    //   371: goto +108 -> 479
    //   374: astore 10
    //   376: aconst_null
    //   377: astore 9
    //   379: aload 9
    //   381: astore 8
    //   383: aload 10
    //   385: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   388: iload_2
    //   389: istore_0
    //   390: aload 9
    //   392: ifnull +75 -> 467
    //   395: iload_2
    //   396: istore_1
    //   397: aload 9
    //   399: invokevirtual 473	java/io/BufferedReader:close	()V
    //   402: iload_2
    //   403: ireturn
    //   404: astore 10
    //   406: aconst_null
    //   407: astore 9
    //   409: aload 9
    //   411: astore 8
    //   413: aload 10
    //   415: invokevirtual 811	java/io/FileNotFoundException:printStackTrace	()V
    //   418: iload_3
    //   419: istore_0
    //   420: aload 9
    //   422: ifnull +45 -> 467
    //   425: iload_3
    //   426: istore_1
    //   427: aload 9
    //   429: invokevirtual 473	java/io/BufferedReader:close	()V
    //   432: iload_3
    //   433: ireturn
    //   434: astore 10
    //   436: aconst_null
    //   437: astore 9
    //   439: aload 9
    //   441: astore 8
    //   443: aload 10
    //   445: invokevirtual 812	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   448: iload 4
    //   450: istore_0
    //   451: aload 9
    //   453: ifnull +14 -> 467
    //   456: iload 4
    //   458: istore_1
    //   459: aload 9
    //   461: invokevirtual 473	java/io/BufferedReader:close	()V
    //   464: iload 4
    //   466: istore_0
    //   467: iload_0
    //   468: ireturn
    //   469: astore 10
    //   471: aload 8
    //   473: astore 9
    //   475: aload 10
    //   477: astore 8
    //   479: aload 9
    //   481: ifnull +18 -> 499
    //   484: aload 9
    //   486: invokevirtual 473	java/io/BufferedReader:close	()V
    //   489: goto +10 -> 499
    //   492: astore 9
    //   494: aload 9
    //   496: invokevirtual 537	java/io/IOException:printStackTrace	()V
    //   499: goto +6 -> 505
    //   502: aload 8
    //   504: athrow
    //   505: goto -3 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	452	0	i	int
    //   1	458	1	j	int
    //   9	394	2	k	int
    //   11	422	3	m	int
    //   13	452	4	n	int
    //   3	197	5	i1	int
    //   6	197	6	i2	int
    //   315	5	7	bool	boolean
    //   36	267	8	localObject1	Object
    //   342	3	8	localIOException1	IOException
    //   366	1	8	localObject2	Object
    //   381	122	8	localObject3	Object
    //   85	400	9	localObject4	Object
    //   492	3	9	localIOException2	IOException
    //   24	226	10	localObject5	Object
    //   351	1	10	localIOException3	IOException
    //   356	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   361	1	10	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   374	10	10	localIOException4	IOException
    //   404	10	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   434	10	10	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   469	7	10	localObject6	Object
    //   105	200	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   335	340	342	java/io/IOException
    //   397	402	342	java/io/IOException
    //   427	432	342	java/io/IOException
    //   459	464	342	java/io/IOException
    //   100	107	351	java/io/IOException
    //   125	136	351	java/io/IOException
    //   149	160	351	java/io/IOException
    //   173	194	351	java/io/IOException
    //   210	217	351	java/io/IOException
    //   228	238	351	java/io/IOException
    //   249	258	351	java/io/IOException
    //   271	288	351	java/io/IOException
    //   304	317	351	java/io/IOException
    //   100	107	356	java/io/FileNotFoundException
    //   125	136	356	java/io/FileNotFoundException
    //   149	160	356	java/io/FileNotFoundException
    //   173	194	356	java/io/FileNotFoundException
    //   210	217	356	java/io/FileNotFoundException
    //   228	238	356	java/io/FileNotFoundException
    //   249	258	356	java/io/FileNotFoundException
    //   271	288	356	java/io/FileNotFoundException
    //   304	317	356	java/io/FileNotFoundException
    //   100	107	361	java/io/UnsupportedEncodingException
    //   125	136	361	java/io/UnsupportedEncodingException
    //   149	160	361	java/io/UnsupportedEncodingException
    //   173	194	361	java/io/UnsupportedEncodingException
    //   210	217	361	java/io/UnsupportedEncodingException
    //   228	238	361	java/io/UnsupportedEncodingException
    //   249	258	361	java/io/UnsupportedEncodingException
    //   271	288	361	java/io/UnsupportedEncodingException
    //   304	317	361	java/io/UnsupportedEncodingException
    //   17	87	366	finally
    //   17	87	374	java/io/IOException
    //   17	87	404	java/io/FileNotFoundException
    //   17	87	434	java/io/UnsupportedEncodingException
    //   100	107	469	finally
    //   125	136	469	finally
    //   149	160	469	finally
    //   173	194	469	finally
    //   210	217	469	finally
    //   228	238	469	finally
    //   249	258	469	finally
    //   271	288	469	finally
    //   304	317	469	finally
    //   383	388	469	finally
    //   413	418	469	finally
    //   443	448	469	finally
    //   484	489	492	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.info.b
 * JD-Core Version:    0.7.0.1
 */