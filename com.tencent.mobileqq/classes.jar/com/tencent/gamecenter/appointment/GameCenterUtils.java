package com.tencent.gamecenter.appointment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PoolingByteArrayOutputStream;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import qnz;

public class GameCenterUtils
{
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GameCenterUtils";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getLong(paramString, 0L);
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 65	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +9 -> 15
    //   9: getstatic 65	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aconst_null
    //   16: astore_3
    //   17: new 67	java/io/BufferedReader
    //   20: dup
    //   21: new 69	java/io/InputStreamReader
    //   24: dup
    //   25: new 71	java/io/FileInputStream
    //   28: dup
    //   29: new 73	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   36: ldc 76
    //   38: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokestatic 86	android/os/Process:myPid	()I
    //   44: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 91
    //   49: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: ldc 99
    //   60: invokespecial 102	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   63: invokespecial 105	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_2
    //   67: new 73	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   74: astore_3
    //   75: aload_2
    //   76: invokevirtual 108	java/io/BufferedReader:read	()I
    //   79: istore_1
    //   80: iload_1
    //   81: ifle +108 -> 189
    //   84: aload_3
    //   85: iload_1
    //   86: i2c
    //   87: invokevirtual 111	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: goto -16 -> 75
    //   94: astore_3
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 114	java/io/BufferedReader:close	()V
    //   103: invokestatic 86	android/os/Process:myPid	()I
    //   106: istore_1
    //   107: aload_0
    //   108: ifnull +150 -> 258
    //   111: aload_0
    //   112: ldc 116
    //   114: invokevirtual 122	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   117: checkcast 124	android/app/ActivityManager
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 128	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +131 -> 258
    //   130: aload_2
    //   131: invokeinterface 133 1 0
    //   136: ifle +122 -> 258
    //   139: aload_0
    //   140: invokevirtual 128	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   143: invokeinterface 137 1 0
    //   148: astore_0
    //   149: aload_0
    //   150: invokeinterface 143 1 0
    //   155: ifeq +103 -> 258
    //   158: aload_0
    //   159: invokeinterface 147 1 0
    //   164: checkcast 149	android/app/ActivityManager$RunningAppProcessInfo
    //   167: astore_2
    //   168: aload_2
    //   169: getfield 153	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   172: iload_1
    //   173: if_icmpne -24 -> 149
    //   176: aload_2
    //   177: getfield 156	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   180: astore_0
    //   181: aload_0
    //   182: putstatic 65	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   185: getstatic 65	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   188: areturn
    //   189: aload_3
    //   190: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: putstatic 65	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   196: getstatic 65	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   199: astore_3
    //   200: aload_3
    //   201: astore_0
    //   202: aload_2
    //   203: ifnull -190 -> 13
    //   206: aload_2
    //   207: invokevirtual 114	java/io/BufferedReader:close	()V
    //   210: aload_3
    //   211: areturn
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   217: aload_3
    //   218: areturn
    //   219: astore_2
    //   220: aload_2
    //   221: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   224: goto -121 -> 103
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 114	java/io/BufferedReader:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore_2
    //   241: aload_2
    //   242: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   245: goto -7 -> 238
    //   248: astore_0
    //   249: goto -19 -> 230
    //   252: astore_2
    //   253: aload_3
    //   254: astore_2
    //   255: goto -160 -> 95
    //   258: ldc 161
    //   260: astore_0
    //   261: goto -80 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   79	95	1	i	int
    //   66	141	2	localObject1	Object
    //   219	2	2	localIOException1	java.io.IOException
    //   229	6	2	localObject2	Object
    //   240	2	2	localIOException2	java.io.IOException
    //   252	1	2	localException1	Exception
    //   254	1	2	str1	String
    //   16	69	3	localStringBuilder	java.lang.StringBuilder
    //   94	96	3	localException2	Exception
    //   199	55	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   67	75	94	java/lang/Exception
    //   75	80	94	java/lang/Exception
    //   84	91	94	java/lang/Exception
    //   189	200	94	java/lang/Exception
    //   206	210	212	java/io/IOException
    //   99	103	219	java/io/IOException
    //   17	67	227	finally
    //   234	238	240	java/io/IOException
    //   67	75	248	finally
    //   75	80	248	finally
    //   84	91	248	finally
    //   189	200	248	finally
    //   17	67	252	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getString(paramString, "");
  }
  
  public static List a(String[] paramArrayOfString, String paramString, boolean paramBoolean)
  {
    int j = paramArrayOfString.length;
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    int i = 0;
    if (i < j)
    {
      if (TextUtils.isEmpty(paramArrayOfString[i])) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = a(paramString + paramArrayOfString[i]);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        try
        {
          localObject = new JSONObject((String)localObject);
          localDownloadInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("appid");
          localDownloadInfo.i = ((JSONObject)localObject).optString("myAppId");
          localDownloadInfo.j = ((JSONObject)localObject).optString("apkId");
          localDownloadInfo.d = ((JSONObject)localObject).optString("packageName");
          localDownloadInfo.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("versionCode");
          if (paramBoolean) {
            break label219;
          }
          localArrayList.add(localDownloadInfo);
        }
        catch (Exception localException)
        {
          localArrayList.add(localDownloadInfo);
        }
        if (QLog.isColorLevel())
        {
          WLog.b(jdField_a_of_type_JavaLangString, localDownloadInfo.jdField_b_of_type_JavaLangString + "exception and no installed", localException);
          continue;
          label219:
          if (localPackageManager.getPackageInfo(localDownloadInfo.d.trim(), 0) == null)
          {
            localArrayList.add(localDownloadInfo);
            if (QLog.isColorLevel()) {
              WLog.b(jdField_a_of_type_JavaLangString, localDownloadInfo.jdField_b_of_type_JavaLangString + "no installed");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              WLog.b(jdField_a_of_type_JavaLangString, localDownloadInfo.jdField_b_of_type_JavaLangString + "installed");
            }
            a(null, "426", "202142", localDownloadInfo.jdField_b_of_type_JavaLangString, "42601", "1", "116");
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    boolean bool2 = true;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.gameCfg.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseDPC config = " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[2];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser()) >= arrayOfInteger.length)
        {
          if (arrayOfInteger[0].intValue() != 1) {
            continue;
          }
          bool1 = true;
          jdField_a_of_type_Boolean = bool1;
          if (arrayOfInteger[1].intValue() != 1) {
            continue;
          }
          bool1 = bool2;
          jdField_b_of_type_Boolean = bool1;
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseDPC isDelayDownload = " + jdField_a_of_type_Boolean + " , isAppointDownload = " + jdField_b_of_type_Boolean);
      }
      return;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, INetEngine.INetEngineListener paramINetEngineListener)
  {
    if (paramAppInterface == null) {
      return;
    }
    long l2 = 0L;
    Object localObject2 = "";
    String str2 = "";
    try
    {
      String str3 = new URL(paramString).getHost();
      String str1 = str2;
      Object localObject1 = localObject2;
      long l1 = l2;
      if (!TextUtils.isEmpty(str3))
      {
        str1 = str2;
        localObject1 = localObject2;
        l1 = l2;
        if (str3.endsWith(".qq.com"))
        {
          localObject1 = (TicketManager)paramAppInterface.getManager(2);
          str1 = paramAppInterface.getAccount();
          localObject1 = ((TicketManager)localObject1).getSkey(str1);
          l1 = TroopBarShortVideoUploadUtil.a((String)localObject1);
        }
      }
      paramString = MsfSdkUtils.insertMtype("VIP_GameCenter", paramString);
      localObject2 = new HttpNetReq();
      ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = paramINetEngineListener;
      ((HttpNetReq)localObject2).jdField_a_of_type_Int = 0;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaIoOutputStream = new PoolingByteArrayOutputStream(ByteArrayPool.getMaxBufInstance(), 153600);
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = (paramString + "&g_tk=" + l1);
      if (QLog.isColorLevel()) {
        WLog.b(jdField_a_of_type_JavaLangString, "yuyue: send http request for yuyue information, req.mReqUrl=" + ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString);
      }
      ((HttpNetReq)localObject2).o = true;
      ((HttpNetReq)localObject2).c = 30000L;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Connection", "Keep-Alive");
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Cookie", String.format("uin=o%s; skey=%s;", new Object[] { str1, localObject1 }));
      paramAppInterface.getNetEngine(0).a((NetReq)localObject2);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        WLog.b(jdField_a_of_type_JavaLangString, "yuyue download sendHttpReq:", paramAppInterface);
      }
      paramAppInterface.printStackTrace();
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramAppInterface != null) {}
    for (;;)
    {
      try
      {
        paramAppInterface.getCurrentAccountUin();
        int j = HttpUtil.a();
        if (j < 0) {
          break label456;
        }
        i = j;
        if (j >= AppConstants.c.length) {
          break label456;
        }
        String str2 = AppConstants.c[i];
        String str1 = "";
        Object localObject = str1;
        if (paramAppInterface != null)
        {
          BaseApplication localBaseApplication = paramAppInterface.getApp();
          localObject = str1;
          if (localBaseApplication != null)
          {
            localObject = localBaseApplication.getResources().getDisplayMetrics();
            localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
          }
        }
        paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "7.6.8", "gamecenter_ver", "2", Build.BRAND, str2, localObject, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break label451;
        }
        paramAppInterface = (QQAppInterface)paramAppInterface;
        VipComicReportUtils.a(paramAppInterface, "dc00087", paramString1);
        return;
      }
      catch (Exception paramAppInterface)
      {
        return;
      }
      BaseApplicationImpl.sApplication.getRuntime().getAccount();
      continue;
      label451:
      paramAppInterface = null;
      continue;
      label456:
      int i = 0;
    }
  }
  
  public static void a(String paramString)
  {
    WLog.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadDelayApp start");
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      WLog.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadDelayApp " + "DELAY_LIST" + ":" + paramString);
      paramString = paramString.split("\\|");
      a("DELAY_LIST", "");
      paramString = a(paramString, "DELAY_APPID_DETAIL_", true);
      if (paramString.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    WLog.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadDelayApp params.size=0:");
    return;
    int i = 0;
    while (i < paramString.size())
    {
      String str = a("DELAY_APPID_DETAIL_" + ((DownloadInfo)paramString.get(i)).jdField_b_of_type_JavaLangString);
      try
      {
        a(str, true, 2);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    WLog.b(jdField_a_of_type_JavaLangString, "startDownload delay task pParamsJson=" + paramString + ",autoInstallBySdk=" + paramBoolean + ",from=" + paramInt + ",isWifi=" + AppNetConnInfo.isWifiConn());
    try
    {
      WadlJsBridge.startDownload(paramString, paramBoolean, paramInt);
      paramString = new JSONObject(paramString).optString("appid");
      if (2 == paramInt)
      {
        a(null, "427", "202139", paramString, "42701", "1", "117");
        return;
      }
      if (1 == paramInt)
      {
        a(null, "426", "202140", paramString, "42601", "1", "116");
        return;
      }
    }
    catch (Exception paramString)
    {
      WLog.a(jdField_a_of_type_JavaLangString, "startDownload exception", paramString);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (NetworkUtil.h(paramContext))
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if ((paramContext != null) && (!paramContext.isScreenOn()) && (GameCenterBroadcastReceiver.jdField_a_of_type_Int >= 20)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit().remove(paramString).commit();
    }
    return false;
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putLong(paramString, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString + " :" + paramLong);
    }
    return localEditor.commit();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putString(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString1 + " :" + paramString2);
    }
    return localEditor.commit();
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      WLog.b(jdField_a_of_type_JavaLangString, "yuyue:saveAppDetail,appid:" + paramString1 + ",detail:" + paramString2 + ",keyPre:" + paramString3);
    }
    return a(paramString3 + paramString1, paramString2);
  }
  
  public static String b(String paramString)
  {
    return paramString + "_appoint";
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      WLog.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadAppointApp start");
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    WLog.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadAppointApp " + "APPOINTMENT_LIST" + ":" + paramString);
    String[] arrayOfString = paramString.split("\\|");
    int j = 0;
    paramString = "";
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      Object localObject2;
      if (i < arrayOfString.length) {
        localObject2 = a("APPOINT_APPID_DETAIL_" + arrayOfString[i]);
      }
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        long l1 = ((JSONObject)localObject2).optLong("downloadStartTime", 0L);
        long l2 = ((JSONObject)localObject2).optLong("downloadEndTime", 0L);
        long l3 = NetConnInfoCenter.getServerTime();
        if ((l1 <= l3) && (l3 <= l2))
        {
          localObject2 = paramString + arrayOfString[i] + "|";
          j = 1;
          paramString = (String)localObject2;
        }
        else
        {
          localObject2 = (String)localObject1 + arrayOfString[i] + "|";
          localObject1 = localObject2;
        }
      }
      catch (Exception localException2)
      {
        AppRuntime localAppRuntime;
        i += 1;
      }
      if (j != 0) {
        a("APPOINTMENT_LIST", (String)localObject1);
      }
      paramString = paramString.split("\\|");
      if (paramString.length == 0) {
        break;
      }
      i = 0;
      if (i < paramString.length)
      {
        if (TextUtils.isEmpty(paramString[i])) {}
        for (;;)
        {
          i += 1;
          break;
          c(paramString[i], "APPOINTMENT_CHECKLIST");
        }
      }
      localObject1 = a(paramString, "APPOINT_APPID_DETAIL_", true);
      if (((List)localObject1).size() == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        WLog.b(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadAppointApp params.size=0:");
        return;
      }
      paramString = "";
      i = 0;
      for (;;)
      {
        if (i < ((List)localObject1).size())
        {
          paramString = paramString + "\"" + ((DownloadInfo)((List)localObject1).get(i)).jdField_b_of_type_JavaLangString + "\",";
          localObject2 = a("APPOINT_APPID_DETAIL_" + ((DownloadInfo)((List)localObject1).get(i)).jdField_b_of_type_JavaLangString);
          try
          {
            a((String)localObject2, true, 1);
            c(((DownloadInfo)((List)localObject1).get(i)).jdField_b_of_type_JavaLangString, "APPOINTMENT_HAS_DOWNLOAD_LIST");
            i += 1;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
      }
      localObject1 = paramString;
      if (paramString.length() > 0) {
        localObject1 = paramString.substring(0, paramString.length() - 1);
      }
      paramString = "http://info.gamecenter.qq.com/cgi-bin/gc_pre_download_async_fcgi?param={\"key\":{\"param\":{\"appid_list\":[" + (String)localObject1 + "]},\"module\":\"gc_pre_download\",\"method\":\"report_start_download\"}}";
      localObject1 = new qnz();
      localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      if ((localAppRuntime == null) || (!(localAppRuntime instanceof AppInterface))) {
        break;
      }
      a((AppInterface)localAppRuntime, paramString, (INetEngine.INetEngineListener)localObject1);
      return;
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String str;
    do
    {
      return false;
      str = a(paramString2);
    } while (str == null);
    return a(paramString2, str.replace(paramString1 + "|", ""));
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      str = a(paramString2);
    } while (str == null);
    if (QLog.isColorLevel()) {
      WLog.b(jdField_a_of_type_JavaLangString, "yuyue:addAppidToList,appid:" + paramString1 + ",key:" + paramString2);
    }
    String str = str.replace(paramString1 + "|", "");
    return a(paramString2, str + paramString1 + "|");
  }
  
  public static boolean d(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return a(paramString2 + paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterUtils
 * JD-Core Version:    0.7.0.1
 */