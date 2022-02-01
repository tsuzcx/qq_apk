package com.tencent.gamecenter.appointment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterUtils
{
  public static LruCache<String, List<String>> a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    d = true;
    e = false;
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  }
  
  public static int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUtils", 2, "getAppVersionCode packageName=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1;
      try
      {
        PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
        if (localPackageManager != null) {}
        for (paramString = localPackageManager.getPackageInfo(paramString, 0); paramString != null; paramString = null)
        {
          int i = paramString.versionCode;
          return i;
        }
        return -1;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static long a()
  {
    long l = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).getLong("gamecenter_res", 0L);
    WLog.c("GameCenterUtils", "getResAvilTime ts" + l);
    return l;
  }
  
  public static PackageInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUtils", 2, "getPackageInfo packageName=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
        if (localPackageManager != null)
        {
          paramString = localPackageManager.getPackageInfo(paramString, 0);
          return paramString;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static Pair<Integer, String> a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new Pair(Integer.valueOf(-1), "");
    }
    int i = paramIntent.getIntExtra("uinType", -1);
    Object localObject = null;
    if (i == -1) {
      i = paramIntent.getIntExtra("curtype", -1);
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramIntent = (Intent)localObject;
      }
      for (;;)
      {
        localObject = paramIntent;
        if (TextUtils.isEmpty(paramIntent)) {
          localObject = "";
        }
        return new Pair(Integer.valueOf(i), localObject);
        paramIntent = paramIntent.getStringExtra("friend_uin");
        continue;
        paramIntent = paramIntent.getStringExtra("groupUin");
        continue;
        paramIntent = paramIntent.getStringExtra("dicussgroup_uin");
      }
    }
  }
  
  public static String a()
  {
    String str = VFSAssistantUtils.getSDKPrivatePath("com.tencent.gamecenter.wadl/dlapks");
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUtils", 4, "getDownloadApkDir realPath=" + str);
    }
    try
    {
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GameCenterUtils", 4, "getDownloadApkDir make dir error", localThrowable);
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    String str = null;
    try
    {
      PackageManager localPackageManager = BaseApplicationImpl.getApplication().getPackageManager();
      if (localPackageManager != null) {}
      for (paramString = localPackageManager.getApplicationInfo(paramString, 0);; paramString = null)
      {
        if (paramString != null) {
          str = paramString.sourceDir;
        }
        return str;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject;
    if ((paramInt == 1) || (paramInt == 4)) {
      localObject = "pkg";
    }
    for (;;)
    {
      paramString = VFSAssistantUtils.getSDKPrivatePath("com.tencent.gamecenter.wadl/" + (String)localObject + "/" + paramString);
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterUtils", 4, "getDownloadResDir realPath=" + paramString);
      }
      try
      {
        localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        return paramString;
        localObject = "res";
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("GameCenterUtils", 4, "getDownloadApkDir make dir error", localThrowable);
      }
    }
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return "wadl_" + paramString1 + "_" + paramInt + paramString2;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 225
    //   4: invokestatic 231	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   7: checkcast 225	com/tencent/mobileqq/dpc/api/IDPCApi
    //   10: getstatic 237	com/tencent/mobileqq/dpc/enumname/DPCNames:gameCfg	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   13: invokevirtual 240	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   16: ldc 134
    //   18: invokeinterface 244 3 0
    //   23: astore_3
    //   24: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +28 -> 55
    //   30: ldc 46
    //   32: iconst_2
    //   33: new 48	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   40: ldc 246
    //   42: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_3
    //   56: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +249 -> 308
    //   62: iconst_5
    //   63: anewarray 128	java/lang/Integer
    //   66: astore 4
    //   68: aload 4
    //   70: iconst_0
    //   71: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokestatic 252	java/util/Arrays:fill	([Ljava/lang/Object;Ljava/lang/Object;)V
    //   77: ldc 225
    //   79: invokestatic 231	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   82: checkcast 225	com/tencent/mobileqq/dpc/api/IDPCApi
    //   85: aload_3
    //   86: aload 4
    //   88: invokeinterface 256 3 0
    //   93: istore_0
    //   94: aload 4
    //   96: iconst_0
    //   97: aaload
    //   98: invokevirtual 260	java/lang/Integer:intValue	()I
    //   101: iconst_1
    //   102: if_icmpne +172 -> 274
    //   105: iconst_1
    //   106: istore_1
    //   107: iload_1
    //   108: putstatic 16	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_a_of_type_Boolean	Z
    //   111: aload 4
    //   113: iconst_1
    //   114: aaload
    //   115: invokevirtual 260	java/lang/Integer:intValue	()I
    //   118: iconst_1
    //   119: if_icmpne +160 -> 279
    //   122: iconst_1
    //   123: istore_1
    //   124: iload_1
    //   125: putstatic 18	com/tencent/gamecenter/appointment/GameCenterUtils:b	Z
    //   128: aload 4
    //   130: iconst_2
    //   131: aaload
    //   132: invokevirtual 260	java/lang/Integer:intValue	()I
    //   135: iconst_1
    //   136: if_icmpne +148 -> 284
    //   139: iconst_1
    //   140: istore_1
    //   141: iload_1
    //   142: putstatic 20	com/tencent/gamecenter/appointment/GameCenterUtils:c	Z
    //   145: aload 4
    //   147: iconst_3
    //   148: aaload
    //   149: invokevirtual 260	java/lang/Integer:intValue	()I
    //   152: iconst_1
    //   153: if_icmpne +136 -> 289
    //   156: iconst_1
    //   157: istore_1
    //   158: iload_1
    //   159: putstatic 22	com/tencent/gamecenter/appointment/GameCenterUtils:d	Z
    //   162: iload_2
    //   163: istore_1
    //   164: aload 4
    //   166: iconst_4
    //   167: aaload
    //   168: invokevirtual 260	java/lang/Integer:intValue	()I
    //   171: iconst_1
    //   172: if_icmpne +5 -> 177
    //   175: iconst_1
    //   176: istore_1
    //   177: iload_1
    //   178: putstatic 24	com/tencent/gamecenter/appointment/GameCenterUtils:e	Z
    //   181: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +89 -> 273
    //   187: ldc 46
    //   189: iconst_2
    //   190: new 48	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 262
    //   200: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload_0
    //   204: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: ldc_w 264
    //   210: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: getstatic 16	com/tencent/gamecenter/appointment/GameCenterUtils:jdField_a_of_type_Boolean	Z
    //   216: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   219: ldc_w 269
    //   222: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: getstatic 18	com/tencent/gamecenter/appointment/GameCenterUtils:b	Z
    //   228: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   231: ldc_w 271
    //   234: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: getstatic 20	com/tencent/gamecenter/appointment/GameCenterUtils:c	Z
    //   240: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   243: ldc_w 273
    //   246: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: getstatic 22	com/tencent/gamecenter/appointment/GameCenterUtils:d	Z
    //   252: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   255: ldc_w 275
    //   258: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: getstatic 24	com/tencent/gamecenter/appointment/GameCenterUtils:e	Z
    //   264: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   267: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: return
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -169 -> 107
    //   279: iconst_0
    //   280: istore_1
    //   281: goto -157 -> 124
    //   284: iconst_0
    //   285: istore_1
    //   286: goto -145 -> 141
    //   289: iconst_0
    //   290: istore_1
    //   291: goto -133 -> 158
    //   294: astore_3
    //   295: iconst_0
    //   296: istore_0
    //   297: aload_3
    //   298: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   301: goto -120 -> 181
    //   304: astore_3
    //   305: goto -8 -> 297
    //   308: iconst_0
    //   309: istore_0
    //   310: goto -129 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   93	217	0	i	int
    //   106	185	1	bool1	boolean
    //   1	162	2	bool2	boolean
    //   23	63	3	str	String
    //   294	4	3	localException1	Exception
    //   304	1	3	localException2	Exception
    //   66	99	4	arrayOfInteger	Integer[]
    // Exception table:
    //   from	to	target	type
    //   62	94	294	java/lang/Exception
    //   94	105	304	java/lang/Exception
    //   107	122	304	java/lang/Exception
    //   124	139	304	java/lang/Exception
    //   141	156	304	java/lang/Exception
    //   158	162	304	java/lang/Exception
    //   164	175	304	java/lang/Exception
    //   177	181	304	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<Integer, String> paramMap)
  {
    paramAppInterface = new WadlReportBuilder();
    paramAppInterface.a("dc00087").g(paramString1).c(paramString2).b(paramString3).a(1, paramString4).a(11, paramString5).a(12, paramString6);
    if ((paramMap != null) && (paramMap.keySet().size() > 0))
    {
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Map.Entry)paramString1.next();
        paramAppInterface.a(((Integer)paramString2.getKey()).intValue(), (String)paramString2.getValue());
      }
    }
    paramAppInterface.a();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    paramAppInterface = new WadlReportBuilder();
    paramAppInterface.a("dc00087").g(paramString1).c(paramString2).b(paramString3).a(1, paramString4).a(11, paramString5).a(12, paramString6);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        paramAppInterface.a(i + 2, paramVarArgs[i]);
        i += 1;
      }
    }
    paramAppInterface.a();
  }
  
  public static void a(WadlResult paramWadlResult)
  {
    try
    {
      if ((BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(paramWadlResult.a.f.trim(), 0) != null) && (paramWadlResult.b != 9)) {
        paramWadlResult.b = 9;
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      QLog.e("GameCenterUtils", 1, "handleQueryResult e=" + paramWadlResult.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUtils", 2, "launchInstall localAPKPath=" + paramString1 + ",sourceId=" + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (Build.VERSION.SDK_INT > 28)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
      localIntent.addFlags(268435456);
      localIntent.addFlags(536870912);
      localIntent.addFlags(67108864);
      localIntent.addFlags(131072);
      localIntent.setData(Uri.parse("mqqapi://gamecenter/install"));
      localIntent.putExtra("localAPKPath", paramString1);
      localIntent.putExtra("sourceId", paramString2);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    paramString1 = FileProvider7Helper.openApkIntent(BaseApplicationImpl.getContext(), paramString1);
    paramString1.putExtra("big_brother_source_key", paramString2);
    BaseApplicationImpl.getContext().startActivity(paramString1);
  }
  
  public static void a(ArrayList<WadlResult> paramArrayList)
  {
    try
    {
      PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((localPackageManager.getPackageInfo(((WadlResult)paramArrayList.get(i)).a.f.trim(), 0) != null) && (((WadlResult)paramArrayList.get(i)).b != 9)) {
          ((WadlResult)paramArrayList.get(i)).b = 9;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("GameCenterUtils", 1, "handleQueryResult e=" + paramArrayList.toString());
    }
  }
  
  public static void a(Map<Integer, String> paramMap, String paramString)
  {
    int i = 0;
    int j = 0;
    if (paramMap == null) {
      return;
    }
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (QQGameConstant.a == null)) {
          break;
        }
        Object localObject = (List)jdField_a_of_type_AndroidUtilLruCache.get(paramString);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("GameCenterUtils", 1, "get _orted_configs from cache");
            i = j;
          }
          if (i >= ((List)localObject).size()) {
            break;
          }
          paramMap.put(Integer.valueOf(15 + i), ((List)localObject).get(i));
          i += 1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterUtils", 1, "get _orted_configs from msg decode");
        }
        localObject = (String)QQGameConstant.a.get(paramString + "_orted_configs");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterUtils", 1, "get _orted_configs from msg decode orted_configs = " + (String)localObject);
        }
        localObject = new JSONArray((String)localObject);
        localArrayList = new ArrayList();
        if (i >= ((JSONArray)localObject).length()) {
          break label345;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        Iterator localIterator = localJSONObject.keys();
        if (localIterator.hasNext())
        {
          String str = localJSONObject.optString((String)localIterator.next());
          paramMap.put(Integer.valueOf(15 + i), str);
          localArrayList.add(i, str);
        }
        else
        {
          i += 1;
        }
      }
      catch (Throwable paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterUtils", 1, "get _orted_configs err=" + paramMap.toString());
        }
        paramMap.printStackTrace();
        return;
      }
    }
    label345:
    jdField_a_of_type_AndroidUtilLruCache.put(paramString, localArrayList);
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramInt);
    return FileUtil.a(paramString1 + "/" + paramString2);
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).edit();
    localEditor.putLong("gamecenter_res", paramLong);
    boolean bool = localEditor.commit();
    WLog.c("GameCenterUtils", "saveResAvilTime: ts=" + paramLong + ",flag:" + bool);
    return bool;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    int i = a(paramString);
    WLog.c("GameCenterUtils", "checkVersion packageName=" + paramString + ",versionCode=" + paramInt + ",localVersion=" + i);
    return (i != -1) && (i < paramInt);
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    int i = a(paramString);
    WLog.c("GameCenterUtils", "checkVersion packageName=" + paramString + ",updateVersion=" + paramInt1 + ",qgameMinVersion=" + paramInt2 + ",localVersion=" + i);
    return (paramInt2 > -1) && (i != -1) && (i < paramInt2) && (i < paramInt1);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String str;
    do
    {
      return false;
      str = GameCenterSpUtils.a(paramString2);
    } while (str == null);
    return GameCenterSpUtils.a(paramString2, str.replace(paramString1 + "|", ""));
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    WLog.c("GameCenterUtils", "yuyue:saveAppDetail,appid:" + paramString1 + ",detail:" + paramString2 + ",keyPre:" + paramString3);
    return GameCenterSpUtils.a(paramString3 + paramString1, paramString2);
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: ldc 46
    //   2: new 48	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 539
    //   12: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 120	com/tencent/gamecenter/wadl/util/WLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifeq +6 -> 35
    //   32: ldc 134
    //   34: areturn
    //   35: ldc 134
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: new 172	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 178	java/io/File:exists	()Z
    //   54: ifeq +316 -> 370
    //   57: aload_0
    //   58: invokevirtual 541	java/io/File:length	()J
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +307 -> 370
    //   66: aload_0
    //   67: invokevirtual 541	java/io/File:length	()J
    //   70: lstore_1
    //   71: new 543	java/io/BufferedInputStream
    //   74: dup
    //   75: new 545	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 548	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 551	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_0
    //   87: aload 4
    //   89: astore_3
    //   90: aload_0
    //   91: lload_1
    //   92: ldc2_w 552
    //   95: lsub
    //   96: invokevirtual 557	java/io/BufferedInputStream:skip	(J)J
    //   99: pop2
    //   100: aload 4
    //   102: astore_3
    //   103: bipush 50
    //   105: newarray byte
    //   107: astore 5
    //   109: aload 4
    //   111: astore_3
    //   112: aload_0
    //   113: aload 5
    //   115: iconst_0
    //   116: bipush 50
    //   118: invokevirtual 561	java/io/BufferedInputStream:read	([BII)I
    //   121: pop
    //   122: aload 4
    //   124: astore_3
    //   125: new 335	java/lang/String
    //   128: dup
    //   129: aload 5
    //   131: invokespecial 564	java/lang/String:<init>	([B)V
    //   134: astore 6
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 46
    //   141: new 48	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 566
    //   151: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 5
    //   156: invokestatic 571	com/tencent/qqprotect/singleupdate/MD5FileUtil:b	([B)Ljava/lang/String;
    //   159: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 120	com/tencent/gamecenter/wadl/util/WLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 4
    //   170: astore_3
    //   171: aload 6
    //   173: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +188 -> 364
    //   179: aload 4
    //   181: astore_3
    //   182: aload 6
    //   184: ldc_w 573
    //   187: invokevirtual 576	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   190: ifeq +174 -> 364
    //   193: aload 4
    //   195: astore_3
    //   196: aload 6
    //   198: aload 6
    //   200: ldc_w 573
    //   203: invokevirtual 579	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   206: bipush 10
    //   208: iadd
    //   209: invokevirtual 583	java/lang/String:substring	(I)Ljava/lang/String;
    //   212: astore 4
    //   214: aload 4
    //   216: astore_3
    //   217: aload 4
    //   219: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne +57 -> 279
    //   225: aload 4
    //   227: astore_3
    //   228: aload 4
    //   230: invokevirtual 352	java/lang/String:trim	()Ljava/lang/String;
    //   233: astore 4
    //   235: aload 4
    //   237: astore_3
    //   238: ldc 46
    //   240: new 48	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 585
    //   250: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_3
    //   254: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 587
    //   260: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: lload_1
    //   264: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 120	com/tencent/gamecenter/wadl/util/WLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_0
    //   274: invokestatic 593	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   277: aload_3
    //   278: areturn
    //   279: ldc 134
    //   281: astore_3
    //   282: goto -44 -> 238
    //   285: astore 4
    //   287: ldc 134
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_0
    //   292: ldc 46
    //   294: new 48	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 595
    //   304: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 4
    //   309: invokevirtual 598	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 600	com/tencent/gamecenter/wadl/util/WLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_0
    //   322: invokestatic 593	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   325: aload_3
    //   326: areturn
    //   327: astore_0
    //   328: aload_3
    //   329: invokestatic 593	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   332: aload_0
    //   333: athrow
    //   334: astore 4
    //   336: aload_0
    //   337: astore_3
    //   338: aload 4
    //   340: astore_0
    //   341: goto -13 -> 328
    //   344: astore 4
    //   346: aload_0
    //   347: astore_3
    //   348: aload 4
    //   350: astore_0
    //   351: goto -23 -> 328
    //   354: astore 4
    //   356: goto -64 -> 292
    //   359: astore 4
    //   361: goto -69 -> 292
    //   364: ldc 134
    //   366: astore_3
    //   367: goto -94 -> 273
    //   370: aconst_null
    //   371: astore_0
    //   372: ldc 134
    //   374: astore_3
    //   375: goto -102 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramString	String
    //   70	194	1	l	long
    //   40	335	3	str1	String
    //   37	199	4	str2	String
    //   285	23	4	localException1	Exception
    //   334	5	4	localObject1	Object
    //   344	5	4	localObject2	Object
    //   354	1	4	localException2	Exception
    //   359	1	4	localException3	Exception
    //   107	48	5	arrayOfByte	byte[]
    //   134	65	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   41	87	285	java/lang/Exception
    //   41	87	327	finally
    //   90	100	334	finally
    //   103	109	334	finally
    //   112	122	334	finally
    //   125	136	334	finally
    //   139	168	334	finally
    //   171	179	334	finally
    //   182	193	334	finally
    //   196	214	334	finally
    //   217	225	334	finally
    //   228	235	334	finally
    //   238	273	334	finally
    //   292	321	344	finally
    //   90	100	354	java/lang/Exception
    //   103	109	354	java/lang/Exception
    //   112	122	354	java/lang/Exception
    //   125	136	354	java/lang/Exception
    //   139	168	354	java/lang/Exception
    //   171	179	354	java/lang/Exception
    //   182	193	354	java/lang/Exception
    //   196	214	354	java/lang/Exception
    //   217	225	354	java/lang/Exception
    //   228	235	354	java/lang/Exception
    //   238	273	359	java/lang/Exception
  }
  
  public static String b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt, ".apk");
    paramString = a() + "/" + paramString;
    if (FileUtil.a(paramString)) {
      return paramString;
    }
    return null;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      str = GameCenterSpUtils.a(paramString2);
    } while (str == null);
    WLog.c("GameCenterUtils", "yuyue:addAppidToList,appid:" + paramString1 + ",key:" + paramString2);
    String str = str.replace(paramString1 + "|", "");
    return GameCenterSpUtils.a(paramString2, str + paramString1 + "|");
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2)) {
        bool1 = GameCenterSpUtils.a(new String[] { paramString2 + paramString1 });
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterUtils
 * JD-Core Version:    0.7.0.1
 */