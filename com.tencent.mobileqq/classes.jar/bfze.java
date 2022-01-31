import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.patch.QZonePatchService.1;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bfze
{
  private static int jdField_a_of_type_Int;
  private static bfze jdField_a_of_type_Bfze;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static int a(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramString == null) {
      i = paramInt + jdField_a_of_type_Int * 10000;
    }
    return i;
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0;
        paramString = Uri.parse(paramString).getLastPathSegment();
      } while (TextUtils.isEmpty(paramString));
      paramString = Pattern.compile("_r(\\d+)").matcher(paramString);
    } while (!paramString.find());
    paramString = paramString.group(1);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private static long a()
  {
    return LocalMultiProcConfig.getLong(bfpk.a() + "p_len", 0L);
  }
  
  private static long a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.length();
    }
    return 0L;
  }
  
  public static bfze a()
  {
    if (jdField_a_of_type_Bfze == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bfze == null) {
        jdField_a_of_type_Bfze = new bfze();
      }
      return jdField_a_of_type_Bfze;
    }
  }
  
  private static DexClassLoader a(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramContext = new DexClassLoader(paramString, paramContext.getDir("dex", 0).getAbsolutePath(), paramString, paramClassLoader);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      b("preCompileMergePatch failed :" + paramContext.getMessage() + "  stacktrace: " + Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  private static String a()
  {
    File localFile = PluginUtils.getInstalledPluginPath(BaseApplicationImpl.sApplication, "qzone_plugin.apk");
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt(AppSetting.a() + "p_ver", paramInt);
  }
  
  private static void a(long paramLong)
  {
    LocalMultiProcConfig.putLong(bfpk.a() + "p_qzone_len", paramLong);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      b("start to merge...");
      if ((a() == 0L) || (b() == 0L)) {
        e();
      }
      if (c() == 0L) {
        d();
      }
      String str2 = a();
      String str1;
      if (str2 != null)
      {
        if ((a() != 0L) && (a() != a(paramString1)))
        {
          e();
          a(a(paramString1));
        }
        str1 = b(paramString2);
        if ((b() != 0L) && (b() == a(str1))) {
          break label263;
        }
        e();
        b("---> merge :" + str1);
        if (!bfzc.a(str2, paramString1, str1)) {
          break label259;
        }
        b(a(str1));
        paramString1 = c(paramString2);
        if ((c() != 0L) && (c() == a(paramString1))) {
          break label302;
        }
        d();
        b("---> compile :" + paramString1);
        if (a(paramContext, str1, paramContext.getClassLoader()) != null)
        {
          c(a(paramString1));
          b("---> succeed to merge and compile, merge len:" + a(str1) + "   odex len:" + a(paramString1));
        }
      }
      for (;;)
      {
        b("end to merge...");
        return;
        label259:
        e();
        return;
        label263:
        b("---> merge : not merge share_pref len:" + b() + "  file len:" + a(str1));
        break;
        label302:
        b("---> merge : not compile share_pref len:" + c() + " file len:" + a(paramString1));
      }
    }
    b("not need to merge...");
  }
  
  public static void a(String paramString)
  {
    int i = a(paramString);
    jdField_a_of_type_Int = i;
    a(i);
  }
  
  private static long b()
  {
    return LocalMultiProcConfig.getLong(bfpk.a() + "p_merge_len", 0L);
  }
  
  private static String b(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void b()
  {
    b(ajjy.a(2131646281));
    jdField_a_of_type_JavaLangString = null;
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
    long l;
    int i;
    Object localObject3;
    if (((File)localObject1).exists())
    {
      Object localObject2 = bfpk.a() + "p_len";
      l = LocalMultiProcConfig.getLong((String)localObject2, 0L);
      b((String)localObject2 + " = " + l);
      b(ajjy.a(2131646276) + l);
      localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int j = localObject2.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (localObject3 != null) {}
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (!localObject3.isDirectory()) {
        if (l != localObject3.length()) {
          localObject3.delete();
        } else {
          try
          {
            localObject1 = PluginStatic.encodeFile(localObject3.getAbsolutePath()).toLowerCase();
            String str2 = localObject3.getName();
            str3 = str2.substring(0, str2.length() - ".jar".length());
            if (((String)localObject1 + ".jar").endsWith(str2.toLowerCase()))
            {
              jdField_a_of_type_JavaLangString = str3;
              if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
                break label412;
              }
              b(ajjy.a(2131646275));
              return;
            }
          }
          catch (Exception localException)
          {
            String str3;
            String str1;
            for (;;)
            {
              QLog.w("qz_patch", 1, QLog.getStackTraceString(localException));
              str1 = null;
            }
            localObject3.delete();
            e();
            bfpr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 12, "patch verify failed: file md5: " + str1 + " but expected md5: " + str3, 1, System.currentTimeMillis());
            QLog.d("qz_patch", 1, "report [qz_patch] patch verify failed: file md5: " + str1 + " but expected md5: " + str3);
            jdField_a_of_type_JavaLangString = null;
          }
        }
      }
    }
    label412:
    b("当前补丁包的md5是" + jdField_a_of_type_JavaLangString);
  }
  
  private static void b(long paramLong)
  {
    LocalMultiProcConfig.putLong(bfpk.a() + "p_merge_len", paramLong);
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qz_patch", 2, paramString);
    }
  }
  
  private static long c()
  {
    return LocalMultiProcConfig.getLong(bfpk.a() + "p_merge_odex_len", 0L);
  }
  
  private static String c(String paramString)
  {
    paramString = paramString + ".dex";
    File localFile = BaseApplicationImpl.getContext().getDir("dex", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static void c()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    b(0L);
  }
  
  private static void c(long paramLong)
  {
    LocalMultiProcConfig.putLong(bfpk.a() + "p_merge_odex_len", paramLong);
  }
  
  private static void c(String paramString1, String paramString2)
  {
    b(ajjy.a(2131646279));
    if (TextUtils.isEmpty(paramString1)) {
      b(ajjy.a(2131646284));
    }
    while (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    if (jdField_a_of_type_JavaLangString == null)
    {
      QLog.d("qz_patch", 1, "本地没有补丁包");
      if (!"del".equals(paramString1)) {}
    }
    for (;;)
    {
      jdField_a_of_type_Boolean = false;
      return;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        d(paramString1, paramString2);
        jdField_a_of_type_JavaLangString = paramString1;
        continue;
        QLog.d("qz_patch", 1, "本地有补丁包");
        if (!jdField_a_of_type_JavaLangString.equals(paramString1)) {
          break;
        }
        b(ajjy.a(2131646280));
        a(BaseApplicationImpl.getContext(), a(paramString1), paramString1);
      }
    }
    if ((paramString1.equals("del")) || (paramString1.equals("delete"))) {
      QLog.d("qz_patch", 1, "md5是del，直接删除旧的Patch");
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
        if (paramString1.exists())
        {
          paramString1 = paramString1.listFiles();
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            paramString2 = paramString1[i];
            if (paramString2.isDirectory()) {
              break label374;
            }
            paramString2.delete();
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.w("qz_patch", 1, QLog.getStackTraceString(paramString1));
      }
      for (;;)
      {
        bfpr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 11, "clear patch:" + jdField_a_of_type_JavaLangString, 1, System.currentTimeMillis());
        QLog.d("qz_patch", 1, "report [qz_patch] clear patch:" + jdField_a_of_type_JavaLangString);
        break;
        LocalMultiProcConfig.putLong(bfpk.a() + "p_len", 0L);
        jdField_a_of_type_JavaLangString = null;
        e();
      }
      b(ajjy.a(2131646277));
      e();
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break;
      }
      d(paramString1, paramString2);
      jdField_a_of_type_JavaLangString = paramString1;
      break;
      label374:
      i += 1;
    }
  }
  
  private static void d()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("dex", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    c(0L);
  }
  
  /* Error */
  private static void d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 378	bfze:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 7
    //   6: invokestatic 321	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 325	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   12: checkcast 392	com/tencent/common/app/AppInterface
    //   15: aload_1
    //   16: new 93	java/io/File
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokestatic 397	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   28: ifeq +390 -> 418
    //   31: new 70	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 398
    //   41: invokestatic 268	ajjy:a	(I)Ljava/lang/String;
    //   44: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 7
    //   49: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 139	bfze:b	(Ljava/lang/String;)V
    //   58: invokestatic 160	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: ldc 162
    //   63: iconst_0
    //   64: invokevirtual 165	com/tencent/qphone/base/util/BaseApplication:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   67: astore 7
    //   69: aload 7
    //   71: invokevirtual 99	java/io/File:exists	()Z
    //   74: ifeq +344 -> 418
    //   77: aload 7
    //   79: invokevirtual 277	java/io/File:listFiles	()[Ljava/io/File;
    //   82: astore 9
    //   84: aload 9
    //   86: arraylength
    //   87: istore_3
    //   88: iconst_0
    //   89: istore_2
    //   90: iload_2
    //   91: iload_3
    //   92: if_icmpge +326 -> 418
    //   95: aload 9
    //   97: iload_2
    //   98: aaload
    //   99: astore 10
    //   101: aload 10
    //   103: invokevirtual 280	java/io/File:isDirectory	()Z
    //   106: ifeq +6 -> 112
    //   109: goto +403 -> 512
    //   112: new 70	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   119: aload_0
    //   120: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 156
    //   125: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aload 10
    //   133: invokevirtual 296	java/io/File:getName	()Ljava/lang/String;
    //   136: invokevirtual 307	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   139: istore 4
    //   141: iload 4
    //   143: ifeq +355 -> 498
    //   146: aload 10
    //   148: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   151: invokestatic 288	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 7
    //   156: new 70	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 400
    //   166: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 7
    //   171: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 139	bfze:b	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: aload 7
    //   183: invokevirtual 403	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   186: ifeq +253 -> 439
    //   189: ldc_w 405
    //   192: invokestatic 139	bfze:b	(Ljava/lang/String;)V
    //   195: new 70	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   202: invokestatic 75	bfpk:a	()Ljava/lang/String;
    //   205: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 81
    //   210: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore 7
    //   218: aload 10
    //   220: invokevirtual 102	java/io/File:length	()J
    //   223: lstore 5
    //   225: new 70	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   232: aload 7
    //   234: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 272
    //   240: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: lload 5
    //   245: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 139	bfze:b	(Ljava/lang/String;)V
    //   254: aload 7
    //   256: lload 5
    //   258: invokestatic 187	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   261: ldc_w 310
    //   264: iconst_2
    //   265: new 70	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 407
    //   275: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 409
    //   285: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: lload 5
    //   290: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_1
    //   300: invokestatic 411	bfze:a	(Ljava/lang/String;)V
    //   303: invokestatic 321	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   306: invokevirtual 325	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   309: checkcast 327	com/tencent/mobileqq/app/QQAppInterface
    //   312: ldc_w 310
    //   315: bipush 10
    //   317: aconst_null
    //   318: invokestatic 413	bfze:a	(ILjava/lang/String;)I
    //   321: new 70	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 415
    //   331: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 409
    //   341: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: lload 5
    //   346: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   349: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: iconst_1
    //   353: invokestatic 336	java/lang/System:currentTimeMillis	()J
    //   356: invokestatic 341	bfpr:a	(Lmqq/app/AppRuntime;Ljava/lang/String;ILjava/lang/String;IJ)V
    //   359: ldc_w 310
    //   362: iconst_1
    //   363: new 70	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 417
    //   373: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: bipush 10
    //   378: aconst_null
    //   379: invokestatic 413	bfze:a	(ILjava/lang/String;)I
    //   382: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: invokestatic 160	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   394: aload 10
    //   396: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   399: aload_0
    //   400: invokestatic 380	bfze:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   403: goto +109 -> 512
    //   406: astore_0
    //   407: ldc_w 310
    //   410: iconst_1
    //   411: aload_0
    //   412: invokestatic 313	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   415: invokestatic 317	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: return
    //   419: astore 8
    //   421: aconst_null
    //   422: astore 7
    //   424: ldc_w 310
    //   427: iconst_1
    //   428: aload 8
    //   430: invokestatic 313	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   433: invokestatic 317	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: goto -256 -> 180
    //   439: ldc_w 422
    //   442: invokestatic 139	bfze:b	(Ljava/lang/String;)V
    //   445: ldc_w 310
    //   448: iconst_1
    //   449: new 70	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 424
    //   459: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 7
    //   464: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 426
    //   470: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_0
    //   474: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc_w 428
    //   480: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: aload 10
    //   491: invokevirtual 283	java/io/File:delete	()Z
    //   494: pop
    //   495: goto +17 -> 512
    //   498: aload 10
    //   500: invokevirtual 283	java/io/File:delete	()Z
    //   503: pop
    //   504: goto +8 -> 512
    //   507: astore 8
    //   509: goto -85 -> 424
    //   512: iload_2
    //   513: iconst_1
    //   514: iadd
    //   515: istore_2
    //   516: goto -426 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	paramString1	String
    //   0	519	1	paramString2	String
    //   89	427	2	i	int
    //   87	6	3	j	int
    //   139	3	4	bool	boolean
    //   223	122	5	l	long
    //   4	459	7	localObject	Object
    //   419	10	8	localException1	Exception
    //   507	1	8	localException2	Exception
    //   82	14	9	arrayOfFile	File[]
    //   99	400	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   31	88	406	java/lang/Error
    //   101	109	406	java/lang/Error
    //   112	141	406	java/lang/Error
    //   146	156	406	java/lang/Error
    //   156	180	406	java/lang/Error
    //   180	403	406	java/lang/Error
    //   424	436	406	java/lang/Error
    //   439	495	406	java/lang/Error
    //   498	504	406	java/lang/Error
    //   146	156	419	java/lang/Exception
    //   156	180	507	java/lang/Exception
  }
  
  private static void e()
  {
    c();
    d();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "isPatchEnable", 1) == 0) {
      return;
    }
    ThreadManager.postDownLoadTask(new QZonePatchService.1(this, paramString1, paramString2), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfze
 * JD-Core Version:    0.7.0.1
 */