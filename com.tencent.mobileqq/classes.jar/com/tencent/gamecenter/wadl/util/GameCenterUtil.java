package com.tencent.gamecenter.wadl.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector;
import com.tencent.gamecenter.wadl.config.WadlConfigUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterUtil
{
  private static String a;
  public static HashSet<String> a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    d = true;
    e = false;
    jdField_a_of_type_JavaUtilHashSet.add("13169");
    jdField_a_of_type_JavaUtilHashSet.add("13032");
    jdField_a_of_type_JavaUtilHashSet.add("12820");
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 6) {
      return 4;
    }
    if (paramInt == 4) {
      return 2;
    }
    if (paramInt == 5) {
      return 3;
    }
    if ((paramInt != 7) && (paramInt != 14))
    {
      if (paramInt == 0) {
        return 1;
      }
      if (paramInt == 9) {
        return 6;
      }
      if (paramInt == 11) {
        return 9;
      }
      if (paramInt == 12) {
        return 10;
      }
      if ((paramInt != 2) && (paramInt != 13))
      {
        if (paramInt == 10) {
          return 13;
        }
        return 0;
      }
      return 20;
    }
    return -2;
  }
  
  public static int a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppVersionCode packageName=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_GameCenterUtil", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    for (;;)
    {
      try
      {
        localObject = MobileQQ.getContext().getPackageManager();
        if (localObject == null) {
          break label79;
        }
        paramString = ((PackageManager)localObject).getPackageInfo(paramString, 0);
        if (paramString != null)
        {
          int i = paramString.versionCode;
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
      return -1;
      label79:
      paramString = null;
    }
  }
  
  public static long a()
  {
    long l = MobileQQ.sMobileQQ.getSharedPreferences("gamecenter_res", 4).getLong("gamecenter_res", 0L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getResAvilTime ts");
    localStringBuilder.append(l);
    QLog.i("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
    return l;
  }
  
  public static PackageInfo a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPackageInfo packageName=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_GameCenterUtil", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localObject = MobileQQ.sMobileQQ.getPackageManager();
      if (localObject != null)
      {
        paramString = ((PackageManager)localObject).getPackageInfo(paramString, 0);
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Pair<Integer, String> a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new Pair(Integer.valueOf(-1), "");
    }
    int j = paramIntent.getIntExtra("uinType", -1);
    int i = j;
    if (j == -1) {
      i = paramIntent.getIntExtra("curtype", -1);
    }
    if (i != 0) {
      if (i != 1)
      {
        if ((i != 1000) && (i != 1001) && (i != 1004) && (i != 1005))
        {
          if (i != 3000)
          {
            paramIntent = null;
            break label117;
          }
          paramIntent = paramIntent.getStringExtra("dicussgroup_uin");
          break label117;
        }
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("groupUin");
        break label117;
      }
    }
    paramIntent = paramIntent.getStringExtra("friend_uin");
    label117:
    Object localObject = paramIntent;
    if (TextUtils.isEmpty(paramIntent)) {
      localObject = "";
    }
    return new Pair(Integer.valueOf(i), localObject);
  }
  
  public static String a()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      return ((AppRuntime)localObject).getAccount();
    }
    WadlQIPCConnector.a().a();
    localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getUin", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getString("uin");
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonDataAdapter.a().a().getString(2131694616);
    case 6: 
      return CommonDataAdapter.a().a().getString(2131694616);
    case 5: 
      return CommonDataAdapter.a().a().getString(2131694616);
    case 4: 
      return CommonDataAdapter.a().a().getString(2131694619);
    case 3: 
      return CommonDataAdapter.a().a().getString(2131694623);
    case 2: 
      return CommonDataAdapter.a().a().getString(2131694625);
    case 1: 
      return CommonDataAdapter.a().a().getString(2131694621);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    for (;;)
    {
      try
      {
        PackageManager localPackageManager = MobileQQ.sMobileQQ.getPackageManager();
        if (localPackageManager == null) {
          break label39;
        }
        paramString = localPackageManager.getApplicationInfo(paramString, 0);
        if (paramString != null)
        {
          paramString = paramString.sourceDir;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return null;
      label39:
      paramString = null;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 4)) {
      localObject = "res";
    } else {
      localObject = "pkg";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.gamecenter.wadl/");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    paramString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDownloadResDir realPath=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("Wadl_GameCenterUtil", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        ((File)localObject).mkdirs();
        return paramString;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Wadl_GameCenterUtil", 1, "getDownloadApkDir make dir error", localThrowable);
    }
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wadl_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static JSONObject a(WadlResult paramWadlResult)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramWadlResult != null) {}
    try
    {
      if (paramWadlResult.a != null)
      {
        WadlParams localWadlParams = paramWadlResult.a;
        localJSONObject.put("appid", localWadlParams.jdField_a_of_type_JavaLangString);
        localJSONObject.put("state", a(paramWadlResult.b));
        localJSONObject.put("pro", paramWadlResult.d);
        localJSONObject.put("packagename", localWadlParams.f);
        localJSONObject.put("via", localWadlParams.l);
        localJSONObject.put("isAutoInstallBySDK", localWadlParams.a(1));
        localJSONObject.put("isRes", localWadlParams.jdField_a_of_type_Boolean);
        localJSONObject.put("writecodestate", 0);
        localJSONObject.put("extraInfo", localWadlParams.o);
        localJSONObject.put("versionCode", localWadlParams.e);
        int i = b(paramWadlResult.c);
        localJSONObject.put("errorCode", i);
        localJSONObject.put("errorMsg", a(i));
      }
      return localJSONObject;
    }
    catch (Exception paramWadlResult) {}
    return localJSONObject;
  }
  
  public static void a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.gameCfg.name(), "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseDPC config = ");
    ((StringBuilder)localObject).append(str);
    QLog.d("Wadl_GameCenterUtil", 1, ((StringBuilder)localObject).toString());
    boolean bool1 = TextUtils.isEmpty(str);
    int j = 0;
    int i = 0;
    boolean bool2 = false;
    if (!bool1) {}
    for (;;)
    {
      try
      {
        localObject = new Integer[5];
        Arrays.fill((Object[])localObject, Integer.valueOf(0));
        i = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, (Integer[])localObject);
        try
        {
          if (localObject[0].intValue() != 1) {
            break label354;
          }
          bool1 = true;
          jdField_a_of_type_Boolean = bool1;
          if (localObject[1].intValue() != 1) {
            break label359;
          }
          bool1 = true;
          b = bool1;
          if (localObject[2].intValue() != 1) {
            break label364;
          }
          bool1 = true;
          c = bool1;
          if (localObject[3].intValue() != 1) {
            break label369;
          }
          bool1 = true;
          d = bool1;
          bool1 = bool2;
          if (localObject[4].intValue() == 1) {
            bool1 = true;
          }
          e = bool1;
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2)
      {
        i = j;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseDPC size=");
      localStringBuilder.append(i);
      localStringBuilder.append(",isDelayDownload = ");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      localStringBuilder.append(" , isAppointDownload = ");
      localStringBuilder.append(b);
      localStringBuilder.append(" , isUpdateDownload = ");
      localStringBuilder.append(c);
      localStringBuilder.append(" , isResApkDownload = ");
      localStringBuilder.append(d);
      localStringBuilder.append(" , isResDefDownload = ");
      localStringBuilder.append(e);
      QLog.d("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
      return;
      label354:
      bool1 = false;
      continue;
      label359:
      bool1 = false;
      continue;
      label364:
      bool1 = false;
      continue;
      label369:
      bool1 = false;
    }
  }
  
  public static void a(WadlResult paramWadlResult)
  {
    try
    {
      if ((MobileQQ.sMobileQQ.getPackageManager().getPackageInfo(paramWadlResult.a.f.trim(), 0) != null) && (paramWadlResult.b != 9))
      {
        paramWadlResult.b = 9;
        return;
      }
    }
    catch (Exception paramWadlResult)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleQueryResult e=");
      localStringBuilder.append(paramWadlResult.toString());
      QLog.e("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i <= 28)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramString = new StringBuilder();
        paramString.append("sdk version lower android10,version is ");
        paramString.append(Build.VERSION.SDK_INT);
        QLog.e("Wadl_GameCenterUtil", 1, paramString.toString());
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Wadl_GameCenterUtil", 1, "requestFloatingScreenPermission dataJson is null");
        return;
      }
      paramString = new JSONObject(paramString).optString("appid");
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Wadl_GameCenterUtil", 1, "requestFloatingScreenPermission appid is null");
        return;
      }
      if (WadlConfigUtils.a() == 1)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestFloatingScreenPermission appid =");
          localStringBuilder.append(paramString);
          QLog.d("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
        }
        if (WadlConfigUtils.a(paramString))
        {
          b(paramString);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Appid ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" is not in config");
        QLog.e("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
        return;
      }
      if (WadlConfigUtils.a() == 2)
      {
        b(paramString);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("Wadl_GameCenterUtil", 1, "isNeedFloatingPermission is 0");
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return;
  }
  
  public static void a(ArrayList<WadlResult> paramArrayList)
  {
    try
    {
      Object localObject = MobileQQ.sMobileQQ.getPackageManager();
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((((PackageManager)localObject).getPackageInfo(((WadlResult)paramArrayList.get(i)).a.f.trim(), 0) != null) && (((WadlResult)paramArrayList.get(i)).b != 9)) {
          ((WadlResult)paramArrayList.get(i)).b = 9;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleQueryResult e=");
      ((StringBuilder)localObject).append(paramArrayList.toString());
      QLog.e("Wadl_GameCenterUtil", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        boolean bool = MobileQQ.getContext().getPackageManager().canRequestPackageInstalls();
        return bool;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Wadl_GameCenterUtil", 1, "checkInstallPermission exception", localThrowable);
      }
    }
    return true;
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    return a(localStringBuilder.toString());
  }
  
  public static boolean a(long paramLong)
  {
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("gamecenter_res", 4).edit();
    ((SharedPreferences.Editor)localObject).putLong("gamecenter_res", paramLong);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveResAvilTime: ts=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(",flag:");
    ((StringBuilder)localObject).append(bool);
    QLog.i("Wadl_GameCenterUtil", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    int i = a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkVersion packageName=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",versionCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",localVersion=");
    localStringBuilder.append(i);
    QLog.i("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
    return (i != -1) && (i < paramInt);
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    int i = a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkVersion packageName=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",updateVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",qgameMinVersion=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",localVersion=");
    localStringBuilder.append(i);
    QLog.i("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
    return (paramInt2 > -1) && (i != -1) && (i < paramInt2) && (i < paramInt1);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      String str = GameCenterSpUtils.a(paramString2);
      if (str == null) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yuyue:addAppidToList,appid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",key:");
      localStringBuilder.append(paramString2);
      QLog.i("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      str = str.replace(localStringBuilder.toString(), "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      return GameCenterSpUtils.a(paramString2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yuyue:saveAppDetail,appid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",detail:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",keyPre:");
      localStringBuilder.append(paramString3);
      QLog.i("Wadl_GameCenterUtil", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append(paramString1);
      return GameCenterSpUtils.a(localStringBuilder.toString(), paramString2);
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != -71)
    {
      if (paramInt != -60) {
        if (paramInt != -51) {
          if (paramInt != -40)
          {
            if (paramInt == -30) {
              break label138;
            }
            if (paramInt == 100) {
              break label136;
            }
            if (paramInt != 999)
            {
              if ((paramInt == -16) || (paramInt == -15) || (paramInt == -1)) {
                break label138;
              }
              if (paramInt == 0) {}
            }
          }
        }
      }
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return 6;
          return 0;
          return 7;
        case -12: 
          return 3;
        case -11: 
          return 2;
        }
        label136:
        return 5;
      }
    }
    label138:
    return 1;
  }
  
  public static String b()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      return ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(((AppRuntime)localObject).getAccount());
    }
    WadlQIPCConnector.a().a();
    localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getSkey", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getString("skey");
    }
    return "";
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 50	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc_w 557
    //   14: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 4
    //   20: aload_0
    //   21: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: ldc 59
    //   27: iconst_1
    //   28: aload 4
    //   30: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: istore_1
    //   41: ldc 141
    //   43: astore 4
    //   45: iload_1
    //   46: ifeq +6 -> 52
    //   49: ldc 141
    //   51: areturn
    //   52: new 270	java/io/File
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 276	java/io/File:exists	()Z
    //   65: ifeq +386 -> 451
    //   68: aload_0
    //   69: invokevirtual 560	java/io/File:length	()J
    //   72: lconst_0
    //   73: lcmp
    //   74: ifle +377 -> 451
    //   77: aload_0
    //   78: invokevirtual 560	java/io/File:length	()J
    //   81: lstore_2
    //   82: new 562	java/io/BufferedInputStream
    //   85: dup
    //   86: new 564	java/io/FileInputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 567	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 570	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: astore_0
    //   98: aload 4
    //   100: astore 6
    //   102: aload_0
    //   103: astore 5
    //   105: aload_0
    //   106: lload_2
    //   107: ldc2_w 571
    //   110: lsub
    //   111: invokevirtual 576	java/io/BufferedInputStream:skip	(J)J
    //   114: pop2
    //   115: aload 4
    //   117: astore 6
    //   119: aload_0
    //   120: astore 5
    //   122: bipush 50
    //   124: newarray byte
    //   126: astore 7
    //   128: aload 4
    //   130: astore 6
    //   132: aload_0
    //   133: astore 5
    //   135: aload_0
    //   136: aload 7
    //   138: iconst_0
    //   139: bipush 50
    //   141: invokevirtual 580	java/io/BufferedInputStream:read	([BII)I
    //   144: pop
    //   145: aload 4
    //   147: astore 6
    //   149: aload_0
    //   150: astore 5
    //   152: new 420	java/lang/String
    //   155: dup
    //   156: aload 7
    //   158: invokespecial 583	java/lang/String:<init>	([B)V
    //   161: astore 9
    //   163: aload 4
    //   165: astore 6
    //   167: aload_0
    //   168: astore 5
    //   170: new 50	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   177: astore 8
    //   179: aload 4
    //   181: astore 6
    //   183: aload_0
    //   184: astore 5
    //   186: aload 8
    //   188: ldc_w 585
    //   191: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 4
    //   197: astore 6
    //   199: aload_0
    //   200: astore 5
    //   202: aload 8
    //   204: aload 7
    //   206: invokestatic 590	com/tencent/qqprotect/singleupdate/MD5FileUtil:b	([B)Ljava/lang/String;
    //   209: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: astore 6
    //   217: aload_0
    //   218: astore 5
    //   220: ldc 59
    //   222: iconst_1
    //   223: aload 8
    //   225: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload 4
    //   233: astore 6
    //   235: aload 4
    //   237: astore 7
    //   239: aload_0
    //   240: astore 8
    //   242: aload_0
    //   243: astore 5
    //   245: aload 9
    //   247: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifne +208 -> 458
    //   253: aload 4
    //   255: astore 6
    //   257: aload 4
    //   259: astore 7
    //   261: aload_0
    //   262: astore 8
    //   264: aload_0
    //   265: astore 5
    //   267: aload 9
    //   269: ldc_w 592
    //   272: invokevirtual 595	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   275: ifeq +183 -> 458
    //   278: aload 4
    //   280: astore 6
    //   282: aload_0
    //   283: astore 5
    //   285: aload 9
    //   287: aload 9
    //   289: ldc_w 592
    //   292: invokevirtual 598	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   295: bipush 10
    //   297: iadd
    //   298: invokevirtual 601	java/lang/String:substring	(I)Ljava/lang/String;
    //   301: astore 7
    //   303: aload_0
    //   304: astore 5
    //   306: aload 7
    //   308: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifne +13 -> 324
    //   314: aload_0
    //   315: astore 5
    //   317: aload 7
    //   319: invokevirtual 423	java/lang/String:trim	()Ljava/lang/String;
    //   322: astore 4
    //   324: aload 4
    //   326: astore 6
    //   328: aload_0
    //   329: astore 5
    //   331: new 50	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   338: astore 7
    //   340: aload 4
    //   342: astore 6
    //   344: aload_0
    //   345: astore 5
    //   347: aload 7
    //   349: ldc_w 603
    //   352: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 4
    //   358: astore 6
    //   360: aload_0
    //   361: astore 5
    //   363: aload 7
    //   365: aload 4
    //   367: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 4
    //   373: astore 6
    //   375: aload_0
    //   376: astore 5
    //   378: aload 7
    //   380: ldc_w 605
    //   383: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 4
    //   389: astore 6
    //   391: aload_0
    //   392: astore 5
    //   394: aload 7
    //   396: lload_2
    //   397: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 4
    //   403: astore 6
    //   405: aload_0
    //   406: astore 5
    //   408: ldc 59
    //   410: iconst_1
    //   411: aload 7
    //   413: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 126	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload 4
    //   421: astore 7
    //   423: aload_0
    //   424: astore 8
    //   426: goto +32 -> 458
    //   429: astore 5
    //   431: aload 7
    //   433: astore 4
    //   435: aload 5
    //   437: astore 7
    //   439: goto +38 -> 477
    //   442: astore 7
    //   444: aload 6
    //   446: astore 4
    //   448: goto +29 -> 477
    //   451: aconst_null
    //   452: astore 8
    //   454: aload 4
    //   456: astore 7
    //   458: aload 8
    //   460: invokestatic 611	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   463: aload 7
    //   465: areturn
    //   466: astore_0
    //   467: aconst_null
    //   468: astore 5
    //   470: goto +70 -> 540
    //   473: astore 7
    //   475: aconst_null
    //   476: astore_0
    //   477: aload_0
    //   478: astore 5
    //   480: new 50	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   487: astore 6
    //   489: aload_0
    //   490: astore 5
    //   492: aload 6
    //   494: ldc_w 613
    //   497: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_0
    //   502: astore 5
    //   504: aload 6
    //   506: aload 7
    //   508: invokevirtual 616	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   511: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_0
    //   516: astore 5
    //   518: ldc 59
    //   520: iconst_1
    //   521: aload 6
    //   523: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 428	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload 4
    //   531: astore 7
    //   533: aload_0
    //   534: astore 8
    //   536: goto -78 -> 458
    //   539: astore_0
    //   540: aload 5
    //   542: invokestatic 611	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   545: goto +5 -> 550
    //   548: aload_0
    //   549: athrow
    //   550: goto -2 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	paramString	String
    //   40	6	1	bool	boolean
    //   81	316	2	l	long
    //   7	523	4	localObject1	Object
    //   103	304	5	str1	String
    //   429	7	5	localException1	Exception
    //   468	73	5	str2	String
    //   100	422	6	localObject2	Object
    //   126	312	7	localObject3	Object
    //   442	1	7	localException2	Exception
    //   456	8	7	localObject4	Object
    //   473	34	7	localException3	Exception
    //   531	1	7	localObject5	Object
    //   177	358	8	localObject6	Object
    //   161	127	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   306	314	429	java/lang/Exception
    //   317	324	429	java/lang/Exception
    //   105	115	442	java/lang/Exception
    //   122	128	442	java/lang/Exception
    //   135	145	442	java/lang/Exception
    //   152	163	442	java/lang/Exception
    //   170	179	442	java/lang/Exception
    //   186	195	442	java/lang/Exception
    //   202	213	442	java/lang/Exception
    //   220	231	442	java/lang/Exception
    //   245	253	442	java/lang/Exception
    //   267	278	442	java/lang/Exception
    //   285	303	442	java/lang/Exception
    //   331	340	442	java/lang/Exception
    //   347	356	442	java/lang/Exception
    //   363	371	442	java/lang/Exception
    //   378	387	442	java/lang/Exception
    //   394	401	442	java/lang/Exception
    //   408	419	442	java/lang/Exception
    //   52	98	466	finally
    //   52	98	473	java/lang/Exception
    //   105	115	539	finally
    //   122	128	539	finally
    //   135	145	539	finally
    //   152	163	539	finally
    //   170	179	539	finally
    //   186	195	539	finally
    //   202	213	539	finally
    //   220	231	539	finally
    //   245	253	539	finally
    //   267	278	539	finally
    //   285	303	539	finally
    //   306	314	539	finally
    //   317	324	539	finally
    //   331	340	539	finally
    //   347	356	539	finally
    //   363	371	539	finally
    //   378	387	539	finally
    //   394	401	539	finally
    //   408	419	539	finally
    //   480	489	539	finally
    //   492	501	539	finally
    //   504	515	539	finally
    //   518	529	539	finally
  }
  
  public static String b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt, ".apk");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (a(paramString)) {
      return paramString;
    }
    return null;
  }
  
  public static JSONObject b(WadlResult paramWadlResult)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramWadlResult != null) {}
    try
    {
      if (paramWadlResult.a != null)
      {
        WadlParams localWadlParams = paramWadlResult.a;
        localJSONObject.put("appid", localWadlParams.jdField_a_of_type_JavaLangString);
        localJSONObject.put("packagename", localWadlParams.f);
        localJSONObject.put("state", a(paramWadlResult.b));
        localJSONObject.put("pro", paramWadlResult.d);
        localJSONObject.put("via", localWadlParams.l);
        localJSONObject.put("versionCode", localWadlParams.e);
        localJSONObject.put("resMD5", localWadlParams.i);
        localJSONObject.put("resVersionName", localWadlParams.g);
        localJSONObject.put("resName", localWadlParams.h);
        int i = b(paramWadlResult.c);
        localJSONObject.put("errorCode", i);
        localJSONObject.put("errorMsg", a(i));
      }
      return localJSONObject;
    }
    catch (Exception paramWadlResult) {}
    return localJSONObject;
  }
  
  public static void b(String paramString)
  {
    if (!((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.getContext()))
    {
      new WadlReportBuilder().a("dc00087").h("559").b(paramString).c("202473").a(0).a();
      Activity localActivity = Foreground.getTopActivity();
      if (localActivity != null) {
        DialogUtil.a(localActivity, 230, localActivity.getString(2131705872), localActivity.getString(2131705868), localActivity.getString(2131699790), localActivity.getString(2131699791), new GameCenterUtil.1(paramString, localActivity), new GameCenterUtil.2()).show();
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      String str = GameCenterSpUtils.a(paramString2);
      if (str == null) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      return GameCenterSpUtils.a(paramString2, str.replace(localStringBuilder.toString(), ""));
    }
    return false;
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      DisplayMetrics localDisplayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localDisplayMetrics.widthPixels);
      localStringBuilder.append("*");
      localStringBuilder.append(localDisplayMetrics.heightPixels);
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      return GameCenterSpUtils.a(new String[] { localStringBuilder.toString() });
    }
    return false;
  }
  
  public static String d()
  {
    String str = VFSAssistantUtils.getSDKPrivatePath("com.tencent.gamecenter.wadl/dlapks");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDownloadApkDir realPath=");
    ((StringBuilder)localObject).append(str);
    QLog.d("Wadl_GameCenterUtil", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new File(str);
      if (!((File)localObject).exists())
      {
        ((File)localObject).mkdirs();
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Wadl_GameCenterUtil", 1, "getDownloadApkDir make dir error", localThrowable);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.GameCenterUtil
 * JD-Core Version:    0.7.0.1
 */