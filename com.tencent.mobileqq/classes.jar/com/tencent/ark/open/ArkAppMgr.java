package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArkAppMgr
  implements Handler.Callback
{
  private static final int APP_UPDATE_INTERVAL_BY_MINUTES = 1380;
  private static final int CHECK_APP_UPDATE_INTERVAL;
  private static final int CHECK_APP_UPDATE_TIMER_INTERVAL;
  private static final boolean DEBUG;
  private static final ArkEnvironmentManager ENV;
  private static final String KEY_CHECK_APP_UPDATE_INTERVAL = "KEY_CHECK_APP_UPDATE_INTERVAL";
  private static final int MINUTE_TO_MICROSECOND = 60000;
  private static final int MIN_APP_UPDATE_INTERVAL = 60;
  private static final int MSG_CheckAppUpdate = 1917;
  private static final int MSG_NotifyGetAppPathByName = 1916;
  private static final String PREF_APP_DESC = "ArkAppDescCache";
  private static final String PREF_APP_LAST_USE_TIME = "ArkAppLastUsedTime";
  private static final String PREF_APP_UPDATE_PERIOD = "ArkAppUpdatePeriod";
  private static final String PREF_APP_UPDATE_RECORD = "ArkAppUpdateRecord";
  private static final String PREF_UPDATE_TIME_RECORD = "ArkLocalAppUpdateTime";
  private static final String PredownloadAppUpdateTime = "PredownloadAppUpdateTime";
  private static final String TAG = "ArkApp.ArkAppMgr";
  private static final int UPDATE_PREDOWNLOAD_APPLIST_INTERVAL;
  private static boolean mAppUpdateDebugMode;
  static Pattern s_reIsValidAppName;
  private final WeakReference<ArkAppMgr> _weakThis = new WeakReference(this);
  private final HashMap<String, ArkAppMgr.AppPathInfo> mAppPathCache = new HashMap();
  private final HashMap<String, ArkAppMgr.AppPathInfo> mDebugAppPathCache = new HashMap();
  private final WeakReferenceHandler mHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private final ArrayList<String> mPredownloadAppList = new ArrayList();
  private final HashMap<String, ArkAppInfo.AppDownloadInfo> mTempAppCache = new HashMap();
  private final ArrayList<ArkAppMgr.UpdateAppByNameTask> mUpdateAppTaskList = new ArrayList();
  private long mlastTimeCheckAppUpdate = 0L;
  
  static
  {
    boolean bool;
    if (!ArkAppMgr.class.desiredAssertionStatus())
    {
      bool = true;
      $assertionsDisabled = bool;
      ENV = ArkEnvironmentManager.getInstance();
      DEBUG = ArkEnvironmentManager.getInstance().getDebugFlag();
      if (!DEBUG) {
        break label84;
      }
      i = 4;
      label37:
      CHECK_APP_UPDATE_INTERVAL = i;
      if (!DEBUG) {
        break label91;
      }
      i = 300000;
      label50:
      CHECK_APP_UPDATE_TIMER_INTERVAL = i;
      if (!DEBUG) {
        break label97;
      }
    }
    label84:
    label91:
    label97:
    for (int i = 3;; i = 1020)
    {
      UPDATE_PREDOWNLOAD_APPLIST_INTERVAL = i;
      mAppUpdateDebugMode = false;
      s_reIsValidAppName = Pattern.compile("^[\\w\\d]+(\\.[\\w\\d]+)+$");
      return;
      bool = false;
      break;
      i = 300;
      break label37;
      i = 600000;
      break label50;
    }
  }
  
  public ArkAppMgr()
  {
    scheduleUpdateApps(10000);
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.1(this));
  }
  
  private static String QueryAppRetCodeToString(int paramInt)
  {
    switch (paramInt)
    {
    case -5: 
    case -4: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      if (paramInt > 0) {
        return "服务端其他错误";
      }
      break;
    case 0: 
      return "成功";
    case 5: 
      return "应用未上架";
    case 6: 
      return "请将QQ升级到最新版本后查看";
    case 7: 
      return "应用更新失败";
    case -1: 
      return "客户端其他错误";
    case -2: 
      return "网络异常，点击重试";
    case -3: 
      return "应用组件更新失败";
    case -6: 
      return "应用组件加载中。";
    case -7: 
      return "加载超时";
    case -8: 
      return "无效的视图";
    }
    return "未知错误";
  }
  
  private void beginCheckNetwork(ArkAppMgr.ICheckNetworkCallback paramICheckNetworkCallback)
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.11(this, paramICheckNetworkCallback));
  }
  
  private void beginEnumInstalledAppName(ArkAppMgr.IEnumInstalledAppCallback paramIEnumInstalledAppCallback)
  {
    ArkAppMgr.EnumInstalledAppTask localEnumInstalledAppTask = new ArkAppMgr.EnumInstalledAppTask(null);
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.18(this, localEnumInstalledAppTask, paramIEnumInstalledAppCallback));
  }
  
  private boolean checkSignAfterAppPathCache(String paramString)
  {
    byte[] arrayOfByte;
    do
    {
      synchronized (this.mAppPathCache)
      {
        if (this.mAppPathCache.get(paramString) != null)
        {
          if (((ArkAppMgr.AppPathInfo)this.mAppPathCache.get(paramString)).path == null)
          {
            this.mAppPathCache.remove(paramString);
            ENV.logI("ArkApp.ArkAppMgr", "ArkTemp.checkSignAfterAppPathCache, cachePath is error and checkCache is failed");
          }
        }
        else {
          return true;
        }
        localObject = new File(((ArkAppMgr.AppPathInfo)this.mAppPathCache.get(paramString)).path);
        if ((!((File)localObject).exists()) || (!((File)localObject).isFile()))
        {
          this.mAppPathCache.remove(paramString);
          ENV.logI("ArkApp.ArkAppMgr", "ArkTemp.checkSignAfterAppPathCache, cacheFile is error and checkCache is failed");
        }
      }
      arrayOfByte = Base64.decode(ArkEnvironmentManager.getSharedPreferences("ArkLocalAppUpdateTime").getString(paramString + "_sign", "bad"), 0);
      if (arrayOfByte == null)
      {
        ENV.logI("ArkApp.ArkAppMgr", "ArkTemp.checkSignAfterAppPathCache, checksign is null");
        return false;
      }
    } while ((((File)localObject).length() <= 0L) || (arrayOfByte.length <= 0));
    boolean bool = ArkAppCGIMgr.getInstance().verifyAppPackage((File)localObject, arrayOfByte);
    if (bool) {}
    for (Object localObject = "success";; localObject = "failed")
    {
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.checkSignAfterAppPathCache, checksign=%s,appName=%s", new Object[] { localObject, paramString }));
      return bool;
    }
  }
  
  private static int compareVersionString(String paramString1, String paramString2)
  {
    int m = 0;
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    ENV.logI("ArkApp.ArkAppMgr", new Object[] { "compareVersionString: ver1=", paramString1, ",ver2=", paramString2 });
    int i = 0;
    int j = m;
    if (i < 4) {}
    for (;;)
    {
      try
      {
        if (arrayOfString1.length <= i) {
          break label157;
        }
        j = Integer.parseInt(arrayOfString1[i]);
        if (arrayOfString2.length <= i) {
          break label151;
        }
        k = Integer.parseInt(arrayOfString2[i]);
        if (j > k)
        {
          j = 1;
          return j;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        ENV.logI("ArkApp.ArkAppMgr", new Object[] { "compareVersionString: Exception:", paramString1.getMessage() });
        return 0;
      }
      if (j < k) {
        return -1;
      }
      i += 1;
      break;
      label151:
      int k = 0;
      continue;
      label157:
      j = 0;
    }
  }
  
  /* Error */
  private String copyAppPackageToAppInstallDir(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +32 -> 36
    //   7: aload_1
    //   8: invokevirtual 425	java/lang/String:length	()I
    //   11: ifeq +25 -> 36
    //   14: aload_2
    //   15: ifnull +21 -> 36
    //   18: aload_2
    //   19: invokevirtual 425	java/lang/String:length	()I
    //   22: ifeq +14 -> 36
    //   25: aload 4
    //   27: ifnull +9 -> 36
    //   30: aload 4
    //   32: arraylength
    //   33: ifne +7 -> 40
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: new 323	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokestatic 429	com/tencent/ark/open/ArkAppMgr:getAppDirByNameAndVersion	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 6
    //   53: aload 6
    //   55: invokevirtual 329	java/io/File:exists	()Z
    //   58: ifne +79 -> 137
    //   61: aload 6
    //   63: invokevirtual 432	java/io/File:delete	()Z
    //   66: pop
    //   67: aload 6
    //   69: invokevirtual 435	java/io/File:mkdirs	()Z
    //   72: pop
    //   73: aload_1
    //   74: aload_2
    //   75: aload_3
    //   76: invokestatic 439	com/tencent/ark/open/ArkAppMgr:getAppPathByNameAndVersion	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_3
    //   80: new 441	java/io/FileOutputStream
    //   83: dup
    //   84: aload_3
    //   85: invokespecial 442	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: aload 4
    //   94: invokevirtual 446	java/io/FileOutputStream:write	([B)V
    //   97: aload_3
    //   98: astore_1
    //   99: aload_2
    //   100: ifnull -62 -> 38
    //   103: aload_2
    //   104: invokevirtual 449	java/io/FileOutputStream:close	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: getstatic 87	com/tencent/ark/open/ArkAppMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   113: ldc 47
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: ldc_w 451
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: aload_1
    //   128: invokevirtual 421	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   131: aastore
    //   132: invokevirtual 407	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_3
    //   136: areturn
    //   137: aload 6
    //   139: invokevirtual 332	java/io/File:isFile	()Z
    //   142: ifeq -69 -> 73
    //   145: aload 6
    //   147: invokevirtual 432	java/io/File:delete	()Z
    //   150: pop
    //   151: aload 6
    //   153: invokevirtual 435	java/io/File:mkdirs	()Z
    //   156: pop
    //   157: goto -84 -> 73
    //   160: astore_3
    //   161: aconst_null
    //   162: astore_2
    //   163: aload_2
    //   164: astore_1
    //   165: aload_3
    //   166: invokevirtual 416	java/lang/Exception:printStackTrace	()V
    //   169: aload_2
    //   170: astore_1
    //   171: getstatic 87	com/tencent/ark/open/ArkAppMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   174: ldc 47
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: ldc_w 451
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: aload_3
    //   189: invokevirtual 421	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: aastore
    //   193: invokevirtual 407	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 449	java/io/FileOutputStream:close	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: getstatic 87	com/tencent/ark/open/ArkAppMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   210: ldc 47
    //   212: iconst_2
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: ldc_w 451
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: aload_1
    //   225: invokevirtual 421	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   228: aastore
    //   229: invokevirtual 407	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: goto -28 -> 204
    //   235: astore_1
    //   236: aload 5
    //   238: astore_2
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 449	java/io/FileOutputStream:close	()V
    //   247: aload_1
    //   248: athrow
    //   249: astore_2
    //   250: getstatic 87	com/tencent/ark/open/ArkAppMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   253: ldc 47
    //   255: iconst_2
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: ldc_w 451
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: aload_2
    //   268: invokevirtual 421	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   271: aastore
    //   272: invokevirtual 407	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -28 -> 247
    //   278: astore_3
    //   279: aload_1
    //   280: astore_2
    //   281: aload_3
    //   282: astore_1
    //   283: goto -44 -> 239
    //   286: astore_3
    //   287: goto -124 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	ArkAppMgr
    //   0	290	1	paramString1	String
    //   0	290	2	paramString2	String
    //   0	290	3	paramString3	String
    //   0	290	4	paramArrayOfByte	byte[]
    //   1	236	5	localObject	Object
    //   51	101	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	107	109	java/lang/Exception
    //   40	73	160	java/lang/Exception
    //   73	89	160	java/lang/Exception
    //   137	157	160	java/lang/Exception
    //   200	204	206	java/lang/Exception
    //   40	73	235	finally
    //   73	89	235	finally
    //   137	157	235	finally
    //   243	247	249	java/lang/Exception
    //   91	97	278	finally
    //   165	169	278	finally
    //   171	196	278	finally
    //   91	97	286	java/lang/Exception
  }
  
  public static void deleteAllLocalApps()
  {
    String[] arrayOfString = enumInstalledAppName();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        deleteAppByName(arrayOfString[i], true);
        i += 1;
      }
    }
  }
  
  public static void deleteAppByName(String paramString, boolean paramBoolean)
  {
    int i = 0;
    paramString = getAppDirByNameAndVersion(paramString);
    if (paramBoolean)
    {
      File localFile1 = new File(String.format("%s_%d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) }));
      File localFile2 = new File(paramString);
      if (!localFile2.renameTo(localFile1)) {
        ENV.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, failed to rename, %s->%s", new Object[] { paramString, localFile1 }));
      }
      if (!deleteFile(localFile1)) {
        ENV.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, failed to delete dir, %s->%s", new Object[] { paramString, localFile1 }));
      }
      if (localFile2.exists()) {
        ENV.logI("ArkApp.ArkAppMgr", String.format("deleteAppByName, dir still exists, %s->%s", new Object[] { paramString, localFile1 }));
      }
    }
    for (;;)
    {
      return;
      paramString = new File(paramString);
      if (paramString.isFile())
      {
        deleteFile(paramString);
        return;
      }
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int j = paramString.length;
        while (i < j)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public static boolean deleteFile(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        deleteFile(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  private static void deleteNotUsedApps()
  {
    String[] arrayOfString = enumInstalledAppName();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (isAppNotRecentUse(str))
        {
          ENV.logI("ArkApp.ArkAppMgr", String.format("delete not used app, %s", new Object[] { str }));
          deleteAppByName(str, true);
          updateAppLastUseTime(str);
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private static void deleteOldAppWhenUpdateSuccess(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +23 -> 27
    //   7: aload_0
    //   8: invokevirtual 425	java/lang/String:length	()I
    //   11: ifeq +16 -> 27
    //   14: aload_1
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: invokevirtual 425	java/lang/String:length	()I
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +7 -> 31
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: invokestatic 429	com/tencent/ark/open/ArkAppMgr:getAppDirByNameAndVersion	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull -10 -> 27
    //   40: aload_0
    //   41: invokevirtual 425	java/lang/String:length	()I
    //   44: ifeq -17 -> 27
    //   47: new 323	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 492	java/io/File:isDirectory	()Z
    //   60: ifeq -33 -> 27
    //   63: aload_0
    //   64: invokevirtual 329	java/io/File:exists	()Z
    //   67: ifeq -40 -> 27
    //   70: aload_0
    //   71: new 505	com/tencent/ark/open/ArkAppMgr$6
    //   74: dup
    //   75: aload_1
    //   76: iload_2
    //   77: invokespecial 507	com/tencent/ark/open/ArkAppMgr$6:<init>	(Ljava/lang/String;Z)V
    //   80: invokevirtual 510	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   83: pop
    //   84: goto -57 -> 27
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString1	String
    //   0	93	1	paramString2	String
    //   0	93	2	paramBoolean	boolean
    //   22	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   7	14	87	finally
    //   18	23	87	finally
    //   31	36	87	finally
    //   40	84	87	finally
  }
  
  private static String[] enumInstalledAppName()
  {
    int j = 0;
    File[] arrayOfFile = new File(ArkEnvironmentManager.getInstance().getAppInstallDirectory()).listFiles(new ArkAppMgr.19());
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      localObject = null;
      return localObject;
    }
    Object localObject = ArkAppConfigMgr.getInstance().getTemplateAppNameList();
    String[] arrayOfString;
    int i;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int k = ((ArrayList)localObject).size();
      arrayOfString = new String[arrayOfFile.length + k];
      i = 0;
      while (i < k)
      {
        arrayOfString[i] = ((String)((ArrayList)localObject).get(i));
        i += 1;
      }
      i = k;
    }
    for (;;)
    {
      localObject = arrayOfString;
      if (j >= arrayOfFile.length) {
        break;
      }
      arrayOfString[(i + j)] = arrayOfFile[j].getName();
      j += 1;
      continue;
      arrayOfString = new String[arrayOfFile.length];
      i = 0;
    }
  }
  
  public static String getAppDirByNameAndVersion(String paramString)
  {
    return String.format("%s/%s", new Object[] { ArkEnvironmentManager.getInstance().getAppInstallDirectory(), paramString });
  }
  
  private static long getAppLastUseTime(String paramString)
  {
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = System.currentTimeMillis();
    }
    long l1;
    do
    {
      do
      {
        return l2;
        l2 = ArkEnvironmentManager.getSharedPreferences("ArkAppLastUsedTime").getLong(paramString, 0L);
        l1 = l2;
        if (l2 == 0L)
        {
          updateAppLastUseTime(paramString);
          l1 = System.currentTimeMillis();
        }
        l2 = l1;
      } while ($assertionsDisabled);
      l2 = l1;
    } while (l1 > 0L);
    throw new AssertionError();
  }
  
  public static String getAppPathByNameAndVersion(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s/%s.%s", new Object[] { getAppDirByNameAndVersion(paramString1), paramString2, paramString3 });
  }
  
  private void getAppPathByNameReal(String paramString1, String paramString2, String paramString3, Object paramObject, ArkAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback, Looper paramLooper)
  {
    Object localObject = getAppPathInfoByNameFromLocal(paramString1, paramString2, paramString3, false);
    if ((localObject != null) && ((paramString3 == null) || (compareVersionString(((ArkAppMgr.AppPathInfo)localObject).desc.version, paramString3) >= 0)))
    {
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.getAppPathByName, app found at local, update app, app-name=%s,app-appView=%s, min-ver=%s,info.desc.version=%s", new Object[] { paramString1, paramString2, paramString3, ((ArkAppMgr.AppPathInfo)localObject).desc.version }));
      paramString3 = new ArkAppMgr.GetAppPathByNameTask();
      paramString3.appName = paramString1;
      paramString3.appView = paramString2;
      paramString3.retCode = 0;
      paramString3.appPathInfo = ((ArkAppMgr.AppPathInfo)localObject);
      paramString3.userdata = paramObject;
      paramString3.callback = paramIGetAppPathByNameCallback;
      paramString3.handler = new WeakReferenceHandler(paramLooper, this);
      paramString3.handler.obtainMessage(1916, paramString3).sendToTarget();
      return;
    }
    ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.getAppPathByName, app not found at local, update app, app-name=%s,app-appView=%s min-ver=%s", new Object[] { paramString1, paramString2, paramString3 }));
    localObject = new ArkAppMgr.GetAppPathByNameTask();
    ((ArkAppMgr.GetAppPathByNameTask)localObject).retCode = -1;
    ((ArkAppMgr.GetAppPathByNameTask)localObject).appName = paramString1;
    ((ArkAppMgr.GetAppPathByNameTask)localObject).appView = paramString2;
    ((ArkAppMgr.GetAppPathByNameTask)localObject).minAppVersion = paramString3;
    ((ArkAppMgr.GetAppPathByNameTask)localObject).userdata = paramObject;
    ((ArkAppMgr.GetAppPathByNameTask)localObject).callback = paramIGetAppPathByNameCallback;
    ((ArkAppMgr.GetAppPathByNameTask)localObject).appPathInfo = null;
    ((ArkAppMgr.GetAppPathByNameTask)localObject).handler = new WeakReferenceHandler(paramLooper, this);
    paramString2 = new ArrayList();
    paramObject = new ArkAppCGIMgr.AppNameVersion();
    paramObject.appName = paramString1;
    paramObject.expectAppVersion = paramString3;
    paramString2.add(paramObject);
    updateAppByNameBatch(paramString2, localObject, new ArkAppMgr.3(this));
  }
  
  private ArkAppMgr.AppPathInfo getAppPathInfoByNameFromLocalCache(String arg1, String paramString2, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mTempAppCache)
      {
        ??? = (ArkAppInfo.AppDownloadInfo)this.mTempAppCache.get(???);
        if ((??? == null) || (TextUtils.isEmpty(paramString2))) {
          break label540;
        }
        arrayOfString = ArkAppConfigMgr.getAppTemplateAndView(((ArkAppInfo.AppDownloadInfo)???).config, paramString2);
        if ((arrayOfString == null) || (arrayOfString.length < 2)) {
          break label534;
        }
        str = arrayOfString[0];
        synchronized (this.mDebugAppPathCache)
        {
          ??? = (ArkAppMgr.AppPathInfo)this.mDebugAppPathCache.get(str);
          if ((??? == null) || (((ArkAppMgr.AppPathInfo)???).path == null)) {
            break label528;
          }
          ??? = new File(((ArkAppMgr.AppPathInfo)???).path);
          if ((!((File)???).exists()) || (!((File)???).isFile())) {
            break label528;
          }
          ??? = ???;
          if (??? != null) {}
        }
      }
      label302:
      label358:
      do
      {
        synchronized (this.mAppPathCache)
        {
          ??? = (ArkAppMgr.AppPathInfo)this.mAppPathCache.get(str);
          ??? = ???;
          if (??? != null)
          {
            if (((ArkAppMgr.AppPathInfo)???).path != null) {
              break label302;
            }
            this.mAppPathCache.remove(str);
            ??? = null;
          }
          File localFile;
          do
          {
            ??? = ???;
            if (??? == null) {
              break label358;
            }
            ??? = ???;
            if (arrayOfString != null)
            {
              ??? = ???;
              if (arrayOfString.length >= 2)
              {
                ((ArkAppMgr.AppPathInfo)???).desc.name = ???;
                ((ArkAppMgr.AppPathInfo)???).appTempInfo = new ArkAppInfo.AppTemplateView();
                ((ArkAppMgr.AppPathInfo)???).appTempInfo.view = paramString2;
                ((ArkAppMgr.AppPathInfo)???).appTempInfo.template = arrayOfString[0];
                ((ArkAppMgr.AppPathInfo)???).appTempInfo.templateView = arrayOfString[1];
                ??? = ???;
              }
            }
            return ???;
            ??? = finally;
            throw ???;
            ??? = finally;
            throw ???;
            localFile = new File(((ArkAppMgr.AppPathInfo)???).path);
            if (!localFile.exists()) {
              break;
            }
            ??? = ???;
          } while (localFile.isFile());
          this.mAppPathCache.remove(str);
          ??? = null;
        }
        if (paramBoolean) {
          return null;
        }
        paramString2 = getLocalAppPathByAppName(str, paramString2);
        if (paramString2 == null) {
          return null;
        }
        int i = ArkAppCacheMgr.checkAppVersion(paramString2.path);
        if (i != 1)
        {
          ENV.logI("ArkApp.ArkAppMgr", String.format("getAppPathByNameFromLocal, arkCheckAppVersion fail, ret=%d, app-name=%s, tempapp=%s, app-ver=%s", new Object[] { Integer.valueOf(i), str, ???, paramString2.desc.version }));
          deleteAppByName(str, false);
          return null;
        }
        assert (paramString2 != null);
        ??? = paramString2;
      } while (paramString2.appTempInfo != null);
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.getAppPathInfoByNameFromLocalCache init put to cache app=%s", new Object[] { str }));
      synchronized (this.mAppPathCache)
      {
        this.mAppPathCache.put(paramString2.desc.name, paramString2);
        return paramString2;
      }
      label528:
      ??? = null;
      continue;
      label534:
      String str = ???;
      continue;
      label540:
      String[] arrayOfString = null;
    }
  }
  
  private static Looper getCallbackLooper()
  {
    if (Looper.myLooper() != null) {
      return Looper.myLooper();
    }
    return Looper.getMainLooper();
  }
  
  public static ArkAppMgr getInstance()
  {
    return ArkAppMgr.Holder.gInstance;
  }
  
  private static ArkAppMgr.AppPathInfo getLocalAppPathByAppName(String paramString1, String paramString2)
  {
    ArkAppInfo.AppConfig localAppConfig = ArkAppConfigMgr.getInstance().getAppConfig(paramString1);
    if ((localAppConfig != null) && (ArkAppConfigMgr.isTemplateApp(localAppConfig)) && (!TextUtils.isEmpty(paramString2))) {}
    for (String[] arrayOfString = ArkAppConfigMgr.getAppTemplateAndView(localAppConfig, paramString2);; arrayOfString = null)
    {
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
      for (Object localObject1 = arrayOfString[0];; localObject1 = paramString1)
      {
        Object localObject2 = getAppDirByNameAndVersion((String)localObject1);
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("/")) {
          localObject1 = ((String)localObject2).concat("/");
        }
        File[] arrayOfFile = new File((String)localObject1).listFiles(new ArkAppMgr.17());
        if (arrayOfFile == null) {
          localObject2 = null;
        }
        int j;
        int i;
        do
        {
          return localObject2;
          j = arrayOfFile.length;
          i = 0;
          localObject1 = null;
          localObject2 = localObject1;
        } while (i >= j);
        Object localObject3 = arrayOfFile[i];
        localObject2 = ((File)localObject3).getName();
        int k = ((String)localObject2).lastIndexOf('.');
        if (k < 0) {
          localObject2 = localObject1;
        }
        String str2;
        do
        {
          String str1;
          do
          {
            i += 1;
            localObject1 = localObject2;
            break;
            str1 = ((String)localObject2).substring(k);
            str2 = ((String)localObject2).substring(0, k);
            localObject2 = localObject1;
          } while (TextUtils.isEmpty(str1));
          localObject2 = localObject1;
        } while (!isValidAppVersion(str2));
        if (localObject1 == null)
        {
          localObject1 = new ArkAppMgr.AppPathInfo();
          ((ArkAppMgr.AppPathInfo)localObject1).desc.name = paramString1;
          ((ArkAppMgr.AppPathInfo)localObject1).desc.version = str2;
          ((ArkAppMgr.AppPathInfo)localObject1).path = ((File)localObject3).getAbsolutePath();
        }
        for (;;)
        {
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            ((ArkAppMgr.AppPathInfo)localObject1).appTempInfo = new ArkAppInfo.AppTemplateView();
            ((ArkAppMgr.AppPathInfo)localObject1).appTempInfo.view = paramString2;
            ((ArkAppMgr.AppPathInfo)localObject1).appTempInfo.template = arrayOfString[0];
            ((ArkAppMgr.AppPathInfo)localObject1).appTempInfo.templateView = arrayOfString[1];
            localObject3 = ArkAppCacheMgr.getDescIconInfo(paramString1);
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = new ArkAppCacheMgr.ArkDescIconInfo();
            }
            ((ArkAppCacheMgr.ArkDescIconInfo)localObject2).name = localAppConfig.name;
            ArkAppCacheMgr.saveDescIconInfo(paramString1, (ArkAppCacheMgr.ArkDescIconInfo)localObject2);
          }
          ArkAppCacheMgr.cacheManifestInfo(((ArkAppMgr.AppPathInfo)localObject1).path, paramString1);
          localObject2 = localObject1;
          break;
          if (compareVersionString(str2, ((ArkAppMgr.AppPathInfo)localObject1).desc.version) > 0)
          {
            ((ArkAppMgr.AppPathInfo)localObject1).desc.name = paramString1;
            ((ArkAppMgr.AppPathInfo)localObject1).desc.version = str2;
            ((ArkAppMgr.AppPathInfo)localObject1).path = ((File)localObject3).getAbsolutePath();
          }
        }
      }
    }
  }
  
  private boolean isAppNeedUpdate(String paramString)
  {
    long l1 = ArkEnvironmentManager.getSharedPreferences("ArkAppUpdateRecord").getLong(paramString, 0L);
    int i = ArkEnvironmentManager.getSharedPreferences("ArkAppUpdatePeriod").getInt(paramString, 1380);
    long l2 = getAppLastUseTime(paramString);
    long l3 = Math.abs(System.currentTimeMillis() - l1) / 60000L;
    if (l3 > i)
    {
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkSafe.isAppNeedUpdate, need-update=true, app=%s, last-update=%d, delta=%d, update-period=%d, last-use-time=%d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l2) }));
      return true;
    }
    ENV.logI("ArkApp.ArkAppMgr", String.format("ArkSafe.isAppNeedUpdate, need-update=false, app=%s, last-update=%d, delta=%d, update-period=%d, last-use-time=%d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l2) }));
    return false;
  }
  
  private static boolean isAppNotRecentUse(String paramString)
  {
    return System.currentTimeMillis() - getAppLastUseTime(paramString) >= 2592000000L;
  }
  
  public static boolean isAppUpdateBefore(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (ArkEnvironmentManager.getSharedPreferences("ArkAppUpdateRecord").getLong(paramString, -1L) == -1L) {
      return false;
    }
    return true;
  }
  
  public static boolean isValidAppName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!s_reIsValidAppName.matcher(paramString).find()) {
      return false;
    }
    return true;
  }
  
  private static boolean isValidAppVersion(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.matches("^\\d+(\\.\\d+){0,3}$")) {
      return false;
    }
    return true;
  }
  
  public static String loadAppDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return null;
      localSharedPreferences = ArkEnvironmentManager.getSharedPreferences("ArkAppDescCache");
    } while (localSharedPreferences == null);
    return localSharedPreferences.getString(paramString, null);
  }
  
  private void notifyGetAppPathByNameTaskResult(ArkAppMgr.GetAppPathByNameTask paramGetAppPathByNameTask)
  {
    if (paramGetAppPathByNameTask.retCode != 0) {
      paramGetAppPathByNameTask.appPathInfo = null;
    }
    if ((paramGetAppPathByNameTask.retCode == 0) && ((paramGetAppPathByNameTask.appPathInfo == null) || (paramGetAppPathByNameTask.appPathInfo.path == null)))
    {
      paramGetAppPathByNameTask.retCode = -1;
      ENV.logI("ArkApp.ArkAppMgr", String.format("notifyGetAppPathByNameTaskResult, retCode is success but task.appPathInfo.path==NULL, retCode=%d, app-name=%s", new Object[] { Integer.valueOf(paramGetAppPathByNameTask.retCode), paramGetAppPathByNameTask.appName }));
    }
    Object localObject = ArkDelegateManager.getInstance().getNetDelegate();
    if (localObject != null) {
      ArkAppReport.AQQNetTypeToArkReportNetType(((IArkDelegateNet)localObject).getNetworkType());
    }
    localObject = paramGetAppPathByNameTask.callback;
    if (localObject != null)
    {
      if ((paramGetAppPathByNameTask.errMsg == null) || (paramGetAppPathByNameTask.errMsg.length() == 0)) {
        paramGetAppPathByNameTask.errMsg = QueryAppRetCodeToString(paramGetAppPathByNameTask.retCode);
      }
      ((ArkAppMgr.IGetAppPathByNameCallback)localObject).onGetAppPathByName(paramGetAppPathByNameTask.retCode, paramGetAppPathByNameTask.errMsg, paramGetAppPathByNameTask.appPathInfo, paramGetAppPathByNameTask.userdata);
    }
  }
  
  private void notifyUpdateAppByNameResult(int paramInt1, int paramInt2, String paramString, ArkAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = 0;
    for (;;)
    {
      synchronized (this.mUpdateAppTaskList)
      {
        this.mUpdateAppTaskList.remove(paramUpdateAppByNameTask);
        int j = (int)(System.currentTimeMillis() - paramUpdateAppByNameTask.startTime);
        if ((paramUpdateAppByNameTask.appPathInfo != null) && (paramUpdateAppByNameTask.appPathInfo.desc != null) && (!TextUtils.isEmpty(paramUpdateAppByNameTask.appPathInfo.desc.version))) {
          ??? = paramUpdateAppByNameTask.appPathInfo.desc.version;
        }
        ??? = ArkDelegateManager.getInstance().getNetDelegate();
        if (??? != null) {
          ArkAppReport.AQQNetTypeToArkReportNetType(((IArkDelegateNet)???).getNetworkType());
        }
        paramUpdateAppByNameTask.result = paramInt1;
        paramUpdateAppByNameTask.retCode = paramInt2;
        paramUpdateAppByNameTask.errMsg = paramString;
        if (paramUpdateAppByNameTask.retCode == 0) {
          break;
        }
        if (paramUpdateAppByNameTask.retCode != 0)
        {
          ArkUtil.assertTrue(bool1);
          paramUpdateAppByNameTask.appPathInfo = null;
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppMgr.10(this, paramUpdateAppByNameTask));
          return;
        }
      }
      bool1 = false;
    }
    if (paramUpdateAppByNameTask.retCode == 0)
    {
      bool1 = true;
      label199:
      ArkUtil.assertTrue(bool1);
      if ((paramUpdateAppByNameTask.appPathInfo == null) || (paramUpdateAppByNameTask.appPathInfo.path == null)) {
        break label287;
      }
    }
    label287:
    for (bool1 = bool2;; bool1 = false)
    {
      ArkUtil.assertTrue(bool1);
      paramInt1 = i;
      if (paramUpdateAppByNameTask.downloadInfo != null) {
        paramInt1 = (int)(paramUpdateAppByNameTask.downloadInfo.updatePeriodByMinutes * (1.0D + 0.4D * Math.random() - 0.2D));
      }
      updateAppUpdateTime(paramUpdateAppByNameTask.appName, paramInt1);
      break;
      bool1 = false;
      break label199;
    }
  }
  
  private void onUpdateApp_DownloadAppPackageResult(boolean paramBoolean, byte[] paramArrayOfByte, ArkAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask)
  {
    if ((!paramBoolean) || (paramArrayOfByte.length == 0))
    {
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_DownloadAppPackageResult fail, app-name=%s", new Object[] { paramUpdateAppByNameTask.appName }));
      notifyUpdateAppByNameResult(0, -2, null, paramUpdateAppByNameTask);
      return;
    }
    String str2 = "ark";
    String str1 = str2;
    if (paramUpdateAppByNameTask.downloadInfo.downloadUrl != null)
    {
      i = paramUpdateAppByNameTask.downloadInfo.downloadUrl.lastIndexOf('.');
      str1 = str2;
      if (i > 0) {
        str1 = paramUpdateAppByNameTask.downloadInfo.downloadUrl.substring(i + 1);
      }
    }
    paramArrayOfByte = copyAppPackageToAppInstallDir(paramUpdateAppByNameTask.appPathInfo.desc.name, paramUpdateAppByNameTask.appPathInfo.desc.version, str1, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_DownloadAppPackageResult, copyAppPackageToAppInstallDir fail, app-name=%s, app-version=%s", new Object[] { paramUpdateAppByNameTask.appPathInfo.desc.name, paramUpdateAppByNameTask.appPathInfo.desc.version }));
      notifyUpdateAppByNameResult(0, -3, null, paramUpdateAppByNameTask);
      return;
    }
    ArkAppCacheMgr.cacheManifestInfo(paramArrayOfByte, paramUpdateAppByNameTask.appName);
    int i = ArkAppCacheMgr.checkAppVersion(paramArrayOfByte);
    if (i != 1)
    {
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_DownloadAppPackageResult, arkCheckAppVersion fail, ret=%d, app-name=%s, app-path=%s", new Object[] { Integer.valueOf(i), paramUpdateAppByNameTask.appName, paramArrayOfByte }));
      deleteAppByName(paramUpdateAppByNameTask.appName, false);
      notifyUpdateAppByNameResult(0, 7, null, paramUpdateAppByNameTask);
      return;
    }
    str1 = ArkAppCacheMgr.getApplicationDesc(paramUpdateAppByNameTask.appName);
    saveAppDesc(paramUpdateAppByNameTask.appPathInfo.desc.name, str1);
    ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_DownloadAppPackageResult, success, app-name=%s, app-version=%s, app-path=%s", new Object[] { paramUpdateAppByNameTask.appPathInfo.desc.name, paramUpdateAppByNameTask.appPathInfo.desc.version, paramArrayOfByte }));
    paramUpdateAppByNameTask.appPathInfo.path = paramArrayOfByte;
    deleteOldAppWhenUpdateSuccess(paramUpdateAppByNameTask.appName, paramUpdateAppByNameTask.appPathInfo.desc.version, true);
    notifyUpdateAppByNameResult(1, 0, null, paramUpdateAppByNameTask);
  }
  
  private void onUpdateApp_QueryAppInfoByAppNameResult(ArkAppCGIMgr.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, ArrayList<ArkAppMgr.UpdateAppByNameTask> paramArrayList)
  {
    if (paramQueryAppInfoByAppNameBatchResult.updateInterval > 0) {
      putGlobalUpdatePeriod(paramQueryAppInfoByAppNameBatchResult.updateInterval);
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      ArkAppMgr.UpdateAppByNameTask localUpdateAppByNameTask = (ArkAppMgr.UpdateAppByNameTask)localIterator.next();
      String str = localUpdateAppByNameTask.appName;
      ArkAppCGIMgr.QueryAppInfoResult localQueryAppInfoResult = (ArkAppCGIMgr.QueryAppInfoResult)paramQueryAppInfoByAppNameBatchResult.resultList.get(str);
      if (localQueryAppInfoResult == null)
      {
        ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, info is null, app-name=%s", new Object[] { str }));
        notifyUpdateAppByNameResult(0, -2, null, localUpdateAppByNameTask);
      }
      else
      {
        if ((localQueryAppInfoResult.info != null) && (localQueryAppInfoResult.info.config != null))
        {
          paramArrayList = localQueryAppInfoResult.info.config;
          ArkAppConfigMgr.getInstance().saveAppConfig(str, paramArrayList);
        }
        for (;;)
        {
          if ((paramArrayList == null) || (!ArkAppConfigMgr.isTemplateApp(paramArrayList)) || ((paramArrayList.views != null) && (paramArrayList.views.size() > 0))) {
            break label268;
          }
          localQueryAppInfoResult.retCode = 5;
          ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult,template app but view list is empty, app-name=%s, ret-code=%d, orgmsg=%s", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.retCode), localQueryAppInfoResult.msg }));
          notifyUpdateAppByNameResult(0, localQueryAppInfoResult.retCode, null, localUpdateAppByNameTask);
          break;
          ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.config need not update,get local config, app=%s", new Object[] { str }));
          paramArrayList = ArkAppConfigMgr.getInstance().getAppConfig(str);
        }
        label268:
        if ((paramArrayList != null) && (paramArrayList.views != null) && (paramArrayList.views.size() > 0))
        {
          Object localObject2 = ArkAppCacheMgr.getDescIconInfo(str);
          ??? = localObject2;
          if (localObject2 == null) {
            ??? = new ArkAppCacheMgr.ArkDescIconInfo();
          }
          ((ArkAppCacheMgr.ArkDescIconInfo)???).name = paramArrayList.name;
          ArkAppCacheMgr.saveDescIconInfo(str, (ArkAppCacheMgr.ArkDescIconInfo)???);
          for (;;)
          {
            synchronized (this.mTempAppCache)
            {
              this.mTempAppCache.put(str, localQueryAppInfoResult.info);
              ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult,template app find ,app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.retCode) }));
              if (localUpdateAppByNameTask.userdata.size() <= 0) {
                break;
              }
              int i = 0;
              if (i >= localUpdateAppByNameTask.userdata.size()) {
                break;
              }
              if ((localUpdateAppByNameTask.userdata.get(i) instanceof ArkAppMgr.GetAppPathByNameTask))
              {
                ??? = (ArkAppMgr.GetAppPathByNameTask)localUpdateAppByNameTask.userdata.get(i);
                ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.begin to find template app, app=%s, appView=%s", new Object[] { ((ArkAppMgr.GetAppPathByNameTask)???).appName, ((ArkAppMgr.GetAppPathByNameTask)???).appView }));
                localObject2 = ArkAppConfigMgr.getAppTemplateAndView(paramArrayList, ((ArkAppMgr.GetAppPathByNameTask)???).appView);
                if ((localObject2 != null) && (localObject2.length >= 2))
                {
                  ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.find template app, template=%s, templateView=%s", new Object[] { localObject2[0], localObject2[1] }));
                  getAppPathByName(localObject2[0], localObject2[1], "0.0.0.1", "", new ArkAppMgr.8(this, (String[])localObject2, localUpdateAppByNameTask, localQueryAppInfoResult, (ArkAppMgr.GetAppPathByNameTask)???));
                }
              }
              else
              {
                i += 1;
              }
            }
            localQueryAppInfoResult.retCode = -8;
            ENV.logI("ArkApp.ArkAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult,template app find and find template error ,app-name=%s, ret-code=%d, orgmsg=%s", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.retCode), localQueryAppInfoResult.msg }));
            notifyUpdateAppByNameResult(0, localQueryAppInfoResult.retCode, null, localUpdateAppByNameTask);
          }
          ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult save cace temp sucess app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.retCode) }));
        }
        else if (localQueryAppInfoResult.retCode != 0)
        {
          ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, retCode is not SUCCESS, app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.retCode) }));
          notifyUpdateAppByNameResult(0, localQueryAppInfoResult.retCode, localQueryAppInfoResult.msg, localUpdateAppByNameTask);
        }
        else if (localQueryAppInfoResult.state == 3)
        {
          ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, app offline, app=%s", new Object[] { str }));
          deleteAppByName(str, true);
          notifyUpdateAppByNameResult(0, -5, localQueryAppInfoResult.msg, localUpdateAppByNameTask);
        }
        else if (localQueryAppInfoResult.state == 2)
        {
          ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, app no update, app=%s", new Object[] { str }));
          if (localUpdateAppByNameTask.localAppPathInfo != null)
          {
            ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, no update, app-name=%s, local-ver=%s", new Object[] { str, localUpdateAppByNameTask.localAppPathInfo.desc.version }));
            localUpdateAppByNameTask.appPathInfo = localUpdateAppByNameTask.localAppPathInfo;
            notifyUpdateAppByNameResult(2, 0, null, localUpdateAppByNameTask);
          }
          else
          {
            ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, no update, no invalid local info, app=%s", new Object[] { str }));
            notifyUpdateAppByNameResult(0, -1, null, localUpdateAppByNameTask);
          }
        }
        else if (localQueryAppInfoResult.state == 1)
        {
          if (localQueryAppInfoResult.info == null)
          {
            ENV.logI("ArkApp.ArkAppMgr", String.format(Locale.CHINA, "ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, appResult.info is NULL, app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.retCode) }));
            notifyUpdateAppByNameResult(0, -1, null, localUpdateAppByNameTask);
          }
          else
          {
            localUpdateAppByNameTask.downloadInfo = localQueryAppInfoResult.info;
            localUpdateAppByNameTask.appPathInfo = new ArkAppMgr.AppPathInfo();
            localUpdateAppByNameTask.appPathInfo.desc = localQueryAppInfoResult.info.desc;
            paramArrayList = ArkEnvironmentManager.getSharedPreferences("ArkLocalAppUpdateTime").edit();
            paramArrayList.putString(str + "_sign", Base64.encodeToString(localQueryAppInfoResult.info.sign, 0));
            paramArrayList.commit();
            ArkAppCGIMgr.getInstance().downloadAppPackage(localQueryAppInfoResult.info.downloadUrl, localQueryAppInfoResult.info.sign, localUpdateAppByNameTask, new ArkAppMgr.9(this));
          }
        }
        else
        {
          ENV.logI("ArkApp.ArkAppMgr", String.format(Locale.CHINA, "ArkTemp.onUpdateApp_QueryAppInfoByAppNameResult, invalid app state, app=%s, state=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.state) }));
          notifyUpdateAppByNameResult(0, -1, null, localUpdateAppByNameTask);
        }
      }
    }
  }
  
  private void preloadLocalApps()
  {
    String[] arrayOfString = enumInstalledAppName();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.preloadLocalApp app=%s", new Object[] { str }));
        getAppPathInfoByNameFromLocal(str, "", "", false);
        i += 1;
      }
    }
  }
  
  private static void putAppUpdatePeriod(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt == 0)) {
      return;
    }
    paramInt = Math.max(60, paramInt);
    SharedPreferences.Editor localEditor = ArkEnvironmentManager.getSharedPreferences("ArkAppUpdatePeriod").edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
    ENV.logI("ArkApp.ArkAppMgr", new Object[] { "ArkSafe.putAppUpdatePeriod app=", paramString, ", updatePeriodByMinutes=", Integer.valueOf(paramInt) });
  }
  
  public static void putAppUpdateTime(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SharedPreferences.Editor localEditor = ArkEnvironmentManager.getSharedPreferences("ArkAppUpdateRecord").edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
    ENV.logI("ArkApp.ArkAppMgr", new Object[] { "ArkSafe.putAppUpdateTime app=", paramString, ", timeMillis=", Long.valueOf(paramLong) });
  }
  
  public static void putGlobalUpdatePeriod(int paramInt)
  {
    SharedPreferences.Editor localEditor = ArkEnvironmentManager.getSharedPreferences("ArkLocalAppUpdateTime").edit();
    localEditor.putInt("KEY_CHECK_APP_UPDATE_INTERVAL", paramInt);
    localEditor.apply();
    ENV.logI("ArkApp.ArkAppMgr", new Object[] { "ArkSafe.putGlobalUpdatePeriod updateInterval=", Integer.valueOf(paramInt) });
  }
  
  private void runUpdateLocalAppTask(ArkAppMgr.UpdateLocalAppTask paramUpdateLocalAppTask)
  {
    if ((paramUpdateLocalAppTask == null) || (paramUpdateLocalAppTask.appNameList == null) || (paramUpdateLocalAppTask.appNameList.size() == 0) || (!ArkUtil.isDeviceSupportArkMsg())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramUpdateLocalAppTask.appNameList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ArkAppCGIMgr.AppNameVersion localAppNameVersion = new ArkAppCGIMgr.AppNameVersion();
      localAppNameVersion.appName = str;
      localArrayList.add(localAppNameVersion);
    }
    updateAppByNameBatch(localArrayList, paramUpdateLocalAppTask, new ArkAppMgr.16(this));
  }
  
  public static void saveAppDesc(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      localObject = ArkEnvironmentManager.getSharedPreferences("ArkAppDescCache");
    } while (localObject == null);
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private void updateAppByNameBatch(ArrayList<ArkAppCGIMgr.AppNameVersion> paramArrayList, Object paramObject, ArkAppMgr.IUpdateAppByNameCallback paramIUpdateAppByNameCallback)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ENV.logI("ArkApp.ArkAppMgr", "updateAppByNameBatch, appNameList=null");
      return;
    }
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.7(this, paramObject, paramArrayList, paramIUpdateAppByNameCallback));
  }
  
  public static void updateAppLastUseTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.20(paramString));
  }
  
  private void updateAppUpdateTime(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      putAppUpdateTime(paramString, System.currentTimeMillis());
    } while (paramInt == 0);
    putAppUpdatePeriod(paramString, paramInt);
  }
  
  private void updateInstalledAppsReal()
  {
    int i = ArkEnvironmentManager.getSharedPreferences("ArkLocalAppUpdateTime").getInt("KEY_CHECK_APP_UPDATE_INTERVAL", CHECK_APP_UPDATE_INTERVAL);
    long l = Math.abs(System.currentTimeMillis() - this.mlastTimeCheckAppUpdate) / 1000L / 60L;
    if ((this.mlastTimeCheckAppUpdate != 0L) && (l <= i) && (!mAppUpdateDebugMode))
    {
      ENV.logI("ArkApp.ArkAppMgr", String.format("updateInstalledAppsReal, not update time, delta=%d, interval=%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }));
      return;
    }
    this.mlastTimeCheckAppUpdate = System.currentTimeMillis();
    deleteNotUsedApps();
    beginEnumInstalledAppName(new ArkAppMgr.14(this));
  }
  
  public void clearAppPathCache()
  {
    synchronized (this.mAppPathCache)
    {
      this.mAppPathCache.clear();
    }
    synchronized (this.mTempAppCache)
    {
      this.mTempAppCache.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void clearDebugAppPathCache()
  {
    this.mDebugAppPathCache.clear();
  }
  
  public void clearGlobalUpdateTime()
  {
    this.mlastTimeCheckAppUpdate = 0L;
    ENV.logI("ArkApp.ArkAppMgr", "ArkSafe.clearGlobalUpdateTime");
  }
  
  public void getAppPathByName(String paramString1, String paramString2, String paramString3, Object paramObject, ArkAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback)
  {
    int i = 0;
    if ((paramString1 == null) || (paramString1.length() == 0) || (!ArkUtil.isDeviceSupportArkMsg())) {
      i = -1;
    }
    ArkAppCacheMgr.setupArkEnvironment(true);
    if (!ArkEnvironmentManager.getInstance().isLibraryLoad()) {
      i = -6;
    }
    if (i != 0)
    {
      if (!$assertionsDisabled) {
        throw new AssertionError();
      }
      paramString1 = new ArkAppMgr.GetAppPathByNameTask();
      paramString1.retCode = i;
      paramString1.appPathInfo = null;
      paramString1.userdata = paramObject;
      paramString1.callback = paramIGetAppPathByNameCallback;
      paramString1.handler = new WeakReferenceHandler(getCallbackLooper(), this);
      paramString1.handler.obtainMessage(1916, paramString1).sendToTarget();
      return;
    }
    Looper localLooper = getCallbackLooper();
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.2(this, paramString1, paramString2, paramString3, paramObject, paramIGetAppPathByNameCallback, localLooper));
  }
  
  public String getAppPathByNameFromLocal(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString1 = getAppPathInfoByNameFromLocal(paramString1, paramString2, paramString3, paramBoolean);
    if (paramString1 != null) {
      return paramString1.path;
    }
    return null;
  }
  
  public void getAppPathByNameFromLocalAsync(String paramString1, String paramString2, String paramString3, ArkAppMgr.IGetLocalAppPath paramIGetLocalAppPath)
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.GetAppPathTask(this, paramString1, paramString2, paramString3, paramIGetLocalAppPath));
  }
  
  public void getAppPathByNameTimeout(long paramLong, String paramString1, String paramString2, String paramString3, Object paramObject, ArkAppMgr.IGetAppPathByNameCallbackTimeOut paramIGetAppPathByNameCallbackTimeOut)
  {
    ArkAppMgr.GetCallBackResult localGetCallBackResult = new ArkAppMgr.GetCallBackResult(null);
    localGetCallBackResult.hascalled = false;
    ENV.logI("ArkApp.ArkAppMgr", "getAppPathByNameTimeout result =" + localGetCallBackResult);
    getAppPathByName(paramString1, paramString2, paramString3, paramObject, new ArkAppMgr.4(this, localGetCallBackResult, paramIGetAppPathByNameCallbackTimeOut));
    ArkDispatchTask.getInstance().postToArkThreadDelay(new ArkAppMgr.5(this, localGetCallBackResult, paramIGetAppPathByNameCallbackTimeOut), paramLong);
  }
  
  public ArkAppMgr.AppPathInfo getAppPathInfoByNameFromLocal(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (!ArkUtil.isDeviceSupportArkMsg())) {}
    do
    {
      return null;
      updateAppLastUseTime(paramString1);
      paramString2 = getAppPathInfoByNameFromLocalCache(paramString1, paramString2, paramBoolean);
    } while ((paramString2 == null) || ((paramString3 != null) && (compareVersionString(paramString2.desc.version, paramString3) < 0)));
    if (ArkEnvironmentManager.getInstance().isTestEnv())
    {
      long l = System.currentTimeMillis();
      if (checkSignAfterAppPathCache(paramString1))
      {
        float f = (float)(System.currentTimeMillis() - l) / 1000.0F;
        paramString3 = new StringBuilder("checkSignAfterAppPathCache,appName, time, app-name=");
        paramString3.append(paramString1).append(", time=").append(f);
        ENV.logI("ArkApp.ArkAppMgr", paramString3.toString());
        return paramString2;
      }
      deleteAppByName(paramString1, true);
      ENV.logI("ArkApp.ArkAppMgr", "checkSignAfterAppPathCache, checkSignAfterAppPathCache is failed");
      return null;
    }
    ENV.logI("ArkApp.ArkAppMgr", "checkSignAfterAppPathCache,not checkSign and current arkEnvironment is Test");
    return paramString2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1916)
    {
      paramMessage = (ArkAppMgr.GetAppPathByNameTask)paramMessage.obj;
      ENV.logI("ArkApp.ArkAppMgr", String.format("ArkTemp.onUpdateAppByName.handleMessage app=%s", new Object[] { paramMessage.appName }));
      notifyGetAppPathByNameTaskResult(paramMessage);
      return true;
    }
    if (paramMessage.what == 1917)
    {
      updateInstalledApps();
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    ENV.logI("ArkApp.ArkAppMgr", "onDestroy");
    clearAppPathCache();
    clearDebugAppPathCache();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void scheduleUpdateApps(int paramInt)
  {
    ArkDispatchTask.getInstance().postToMainThreadDelayed(new ArkAppMgr.15(this), paramInt);
  }
  
  public void setDebugAppPathCache(String paramString1, String paramString2)
  {
    ArkAppMgr.AppPathInfo localAppPathInfo = new ArkAppMgr.AppPathInfo();
    localAppPathInfo.path = paramString2;
    localAppPathInfo.desc.name = paramString1;
    localAppPathInfo.desc.version = ArkAppCacheMgr.getApplicationVersion(paramString2);
    this.mDebugAppPathCache.put(paramString1, localAppPathInfo);
  }
  
  public void updateInstalledApps()
  {
    beginCheckNetwork(new ArkAppMgr.12(this));
  }
  
  public void updatePredownloadAppList()
  {
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppMgr.13(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr
 * JD-Core Version:    0.7.0.1
 */