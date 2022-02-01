import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfig;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class aqsc
{
  private static NativeMonitorConfig jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig = new NativeMonitorConfig();
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  
  private static NativeMonitorConfig a(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = paramSharedPreferences.getString(paramString + "_" + "native_monitor_config_content", "");
    if (!TextUtils.isEmpty(paramSharedPreferences)) {
      try
      {
        paramSharedPreferences = new JSONObject(paramSharedPreferences);
        return (NativeMonitorConfig)ausy.a(paramSharedPreferences, NativeMonitorConfig.class);
      }
      catch (JSONException paramSharedPreferences)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramSharedPreferences.printStackTrace();
          }
          paramSharedPreferences = null;
        }
      }
    }
    return null;
  }
  
  public static NativeMonitorConfig a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      String str = paramAppRuntime.getAccount();
      if ((!jdField_a_of_type_Boolean) || (!jdField_a_of_type_JavaLangString.equals(str)))
      {
        paramAppRuntime = PreferenceManager.getDefaultSharedPreferences(paramAppRuntime.getApplication());
        if (paramAppRuntime.contains(str + "_" + "native_monitor_config_version"))
        {
          paramAppRuntime = a(paramAppRuntime, str);
          if (paramAppRuntime != null) {
            a(paramAppRuntime);
          }
        }
        jdField_a_of_type_JavaLangString = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 2, "NativeMonitorConfig:" + jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.toString());
    }
    jdField_a_of_type_Boolean = true;
    return jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 125	aqsc:c	Z
    //   6: ifne +13 -> 19
    //   9: getstatic 131	android/os/Build$VERSION:SDK_INT	I
    //   12: istore_0
    //   13: iload_0
    //   14: bipush 21
    //   16: if_icmpge +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_1
    //   24: putstatic 125	aqsc:c	Z
    //   27: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +11 -> 41
    //   33: ldc 114
    //   35: iconst_2
    //   36: ldc 133
    //   38: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: invokestatic 142	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: invokestatic 148	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   47: ldc 150
    //   49: invokevirtual 153	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:initThreadHook	(Ljava/lang/String;)V
    //   52: goto -33 -> 19
    //   55: astore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	5	0	i	int
    //   55	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	55	finally
    //   23	41	55	finally
    //   41	52	55	finally
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 156	aqsc:b	Z
    //   6: istore 10
    //   8: iload 10
    //   10: ifeq +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: iconst_1
    //   18: putstatic 156	aqsc:b	Z
    //   21: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +11 -> 35
    //   27: ldc 114
    //   29: iconst_2
    //   30: ldc 158
    //   32: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: invokestatic 148	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   39: lload_1
    //   40: aload_3
    //   41: lload 4
    //   43: lload 6
    //   45: lload 8
    //   47: invokevirtual 162	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:init	(J[Ljava/lang/String;JJJ)V
    //   50: goto -37 -> 13
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramContext	android.content.Context
    //   0	59	1	paramLong1	long
    //   0	59	3	paramArrayOfString	String[]
    //   0	59	4	paramLong2	long
    //   0	59	6	paramLong3	long
    //   0	59	8	paramLong4	long
    //   6	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	53	finally
    //   17	35	53	finally
    //   35	50	53	finally
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int j = paramConfig.version.get();
    int i = bfyz.aG(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int k = bfyz.aH(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    int m = AppSetting.a();
    if (QLog.isColorLevel()) {
      QLog.d("NativeMonitorConfig", 1, String.format("received nativeMonitorConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    if (k != m)
    {
      bfyz.Y(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), m);
      i = 0;
    }
    String str;
    if (j != i)
    {
      str = aqlw.b(paramConfig, i, paramInt);
      if (!TextUtils.isEmpty(str)) {
        QLog.d("NativeMonitorConfig", 1, "receiveAllConfigs|type: " + paramInt + ",content: " + str + ",version: " + j);
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject(str);
        paramConfig = (NativeMonitorConfig)ausy.a(paramConfig, NativeMonitorConfig.class);
        if (paramConfig == null)
        {
          a(new NativeMonitorConfig());
          bfyz.e(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
          bfyz.s(paramQQAppInterface.getApp(), 0);
          QLog.d("NativeMonitorConfig", 1, "Resolve Config failure, use default config");
          a(true);
          return;
        }
      }
      catch (JSONException paramConfig)
      {
        if (QLog.isDevelopLevel()) {
          paramConfig.printStackTrace();
        }
        paramConfig = null;
        continue;
        QLog.d("NativeMonitorConfig", 1, "start to update config:" + paramConfig.toString());
        if (paramConfig.getTimeLimited() <= 0L)
        {
          paramConfig.setTimeLimitedDefault();
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "time limited is too small, setToDefault");
          }
        }
        if (paramConfig.getMemoryLimited() <= 0L)
        {
          paramConfig.setMemoryLimitedDefault();
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "memory limited is too small, setToDefault");
          }
        }
        if (paramConfig.getCountLimted() <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeMonitorConfig", 2, "count limited is too small, setToDefault");
          }
          paramConfig.setCountLimitedDefault();
        }
        if (QLog.isColorLevel()) {
          QLog.d("NativeMonitorConfig", 2, "soHook = " + paramConfig.soHook);
        }
        a(paramConfig);
        bfyz.e(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, str);
        bfyz.s(paramQQAppInterface.getApp(), paramConfig.soHook);
        continue;
      }
      a(new NativeMonitorConfig());
      bfyz.e(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), j, "");
      bfyz.s(paramQQAppInterface.getApp(), 0);
      QLog.d("NativeMonitorConfig", 1, "config is null, use default config");
      continue;
      QLog.d("NativeMonitorConfig", 1, "config version not updated, nothing to do");
    }
  }
  
  public static void a(NativeMonitorConfig paramNativeMonitorConfig)
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.update(paramNativeMonitorConfig);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (AppSetting.g) {
      NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).setupASanCallback();
    }
    NativeMonitorConfig localNativeMonitorConfig;
    do
    {
      do
      {
        return;
        paramBoolean = bcfn.b();
        if ((paramBoolean) && (Build.VERSION.SDK_INT <= 27) && (Build.VERSION.SDK_INT > 15) && (!AppSetting.g)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("NativeMonitorConfig", 2, "arm: " + paramBoolean + ", useASan: " + AppSetting.g);
      return;
      if (Build.VERSION.SDK_INT < 21)
      {
        QLog.i("NativeMonitorConfig", 1, "skip in release");
        return;
      }
      localNativeMonitorConfig = a(BaseApplicationImpl.getApplication().getRuntime());
      if (localNativeMonitorConfig != null)
      {
        BaseApplicationImpl.sNativeMonitorEscapedMsg = "open: " + localNativeMonitorConfig.getNativeMonitorOpened() + ", flag: " + localNativeMonitorConfig.getSwitchFlag();
        ThreadManagerInitialler.initShotChanceForPublicVersion(jdField_a_of_type_ComTencentMobileqqDataNativemonitorNativeMonitorConfig.getTmChance());
      }
    } while ((localNativeMonitorConfig == null) || (localNativeMonitorConfig.getNativeMonitorOpened() != 1));
    Object localObject = localNativeMonitorConfig.getAndroidVersionBlackList();
    long l2 = localNativeMonitorConfig.getSwitchFlag();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject != null)
      {
        str = Build.VERSION.SDK_INT + "";
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label279;
          }
          if (str.equals(localObject[i])) {
            break;
          }
          i += 1;
        }
      }
    }
    label279:
    if (a(localNativeMonitorConfig))
    {
      QLog.i("NativeMonitorConfig", 1, "process id:" + BaseApplicationImpl.sProcessId + "  is in black list");
      return;
    }
    QLog.i("NativeMonitorConfig", 1, "process id:" + BaseApplicationImpl.sProcessId + "  not in black list");
    long l1 = l2;
    if (Build.VERSION.SDK_INT >= 21) {
      l1 = l2 & 0xFFFFFFFB;
    }
    l2 = l1;
    if (Build.VERSION.SDK_INT != 21)
    {
      l2 = l1;
      if (Build.VERSION.SDK_INT != 22) {
        l2 = l1 & 0xFFFFFFBF;
      }
    }
    String str = localNativeMonitorConfig.getSoWhiteList();
    localObject = str;
    if (str != null) {
      localObject = str.trim();
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      a(BaseApplicationImpl.getContext(), l2 & 0xFFFFFFFF & 0x7FFFFFFF & 0xFFFFFFFD, null, localNativeMonitorConfig.getTimeLimited(), localNativeMonitorConfig.getCountLimted(), localNativeMonitorConfig.getMemoryLimited());
      return;
      ((String)localObject).split("\\|");
    }
  }
  
  private static boolean a(@NonNull NativeMonitorConfig paramNativeMonitorConfig)
  {
    boolean bool2 = false;
    paramNativeMonitorConfig = paramNativeMonitorConfig.getProcessBlackList();
    boolean bool1;
    int j;
    int i;
    if (TextUtils.isEmpty(paramNativeMonitorConfig))
    {
      paramNativeMonitorConfig = null;
      bool1 = bool2;
      if (paramNativeMonitorConfig != null)
      {
        j = paramNativeMonitorConfig.length;
        i = 0;
      }
    }
    label97:
    for (;;)
    {
      bool1 = bool2;
      String str;
      if (i < j) {
        str = paramNativeMonitorConfig[i];
      }
      try
      {
        int k = Integer.valueOf(str).intValue();
        if (k != BaseApplicationImpl.sProcessId) {
          break label97;
        }
        bool1 = true;
        return bool1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (!QLog.isColorLevel()) {
          break label97;
        }
        QLog.d("NativeMonitorConfig", 2, localNumberFormatException, new Object[0]);
        i += 1;
      }
      paramNativeMonitorConfig = paramNativeMonitorConfig.split("\\|");
      break;
    }
  }
  
  /* Error */
  private static String b(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 393	java/io/File:isFile	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: sipush 4096
    //   12: newarray byte
    //   14: astore 4
    //   16: ldc_w 395
    //   19: invokestatic 400	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   22: astore_3
    //   23: new 402	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 405	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_0
    //   34: aload_2
    //   35: aload 4
    //   37: iconst_0
    //   38: aload 4
    //   40: arraylength
    //   41: invokevirtual 409	java/io/FileInputStream:read	([BII)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +43 -> 90
    //   50: aload_2
    //   51: astore_0
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_1
    //   57: invokevirtual 412	java/security/MessageDigest:update	([BII)V
    //   60: goto -28 -> 32
    //   63: astore_3
    //   64: aload_2
    //   65: astore_0
    //   66: ldc 114
    //   68: iconst_1
    //   69: aload_3
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 383	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   77: aload_2
    //   78: ifnull -71 -> 7
    //   81: aload_2
    //   82: invokevirtual 415	java/io/FileInputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: areturn
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 415	java/io/FileInputStream:close	()V
    //   98: new 417	java/math/BigInteger
    //   101: dup
    //   102: iconst_1
    //   103: aload_3
    //   104: invokevirtual 421	java/security/MessageDigest:digest	()[B
    //   107: invokespecial 424	java/math/BigInteger:<init>	(I[B)V
    //   110: bipush 16
    //   112: invokevirtual 427	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   115: areturn
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 415	java/io/FileInputStream:close	()V
    //   127: aload_2
    //   128: athrow
    //   129: astore_0
    //   130: goto -32 -> 98
    //   133: astore_0
    //   134: goto -7 -> 127
    //   137: astore_2
    //   138: goto -19 -> 119
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_2
    //   144: goto -80 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramFile	java.io.File
    //   44	13	1	i	int
    //   31	64	2	localFileInputStream	java.io.FileInputStream
    //   116	12	2	localObject1	Object
    //   137	1	2	localObject2	Object
    //   143	1	2	localObject3	Object
    //   22	31	3	localMessageDigest	java.security.MessageDigest
    //   63	41	3	localException1	java.lang.Exception
    //   141	1	3	localException2	java.lang.Exception
    //   14	40	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   34	45	63	java/lang/Exception
    //   52	60	63	java/lang/Exception
    //   81	85	87	java/io/IOException
    //   16	32	116	finally
    //   94	98	129	java/io/IOException
    //   123	127	133	java/io/IOException
    //   34	45	137	finally
    //   52	60	137	finally
    //   66	77	137	finally
    //   16	32	141	java/lang/Exception
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 429	aqsc:d	Z
    //   6: ifne +21 -> 27
    //   9: getstatic 131	android/os/Build$VERSION:SDK_INT	I
    //   12: bipush 24
    //   14: if_icmplt +13 -> 27
    //   17: getstatic 131	android/os/Build$VERSION:SDK_INT	I
    //   20: istore_0
    //   21: iload_0
    //   22: bipush 29
    //   24: if_icmple +7 -> 31
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: iconst_1
    //   32: putstatic 429	aqsc:d	Z
    //   35: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +12 -> 50
    //   41: ldc 114
    //   43: iconst_2
    //   44: ldc_w 431
    //   47: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: invokestatic 142	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   53: invokestatic 148	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor;
    //   56: invokestatic 142	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   59: new 433	aqsd
    //   62: dup
    //   63: invokespecial 434	aqsd:<init>	()V
    //   66: invokevirtual 437	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:setupSoLoadHook	(Landroid/content/Context;Lcom/tencent/mobileqq/nativememorymonitor/library/ExternalProvider;)V
    //   69: goto -42 -> 27
    //   72: astore_1
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	5	0	i	int
    //   72	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	72	finally
    //   31	50	72	finally
    //   50	69	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsc
 * JD-Core Version:    0.7.0.1
 */