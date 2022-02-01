package com.tencent.common.config.provider;

import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class QZConfigProviderUtil
{
  private static final Set<String> a;
  public static boolean a;
  private static final Set<String> b;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add("miniappshowreddot".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("miniappshowmessagereddot".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("miniappfullscreenshownotificationbtn".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("miniappfullscreenshownotificationreddot".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("miniapptriggerfullscreenheight".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("miniappgetpskeydomain".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("miniappsustempermissionconfig".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("MiniAppMsfTimeoutValue".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("miniappsendrequestbyhttps".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("newsdkenable".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("MiniAppEcShopNumMsgEnable".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("newappsdkenable".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("mini_sdk_prelaunch_enable".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("sdk_dex_config".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("mini_sdk_prelaunch_all_enable".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("mini_sdk_prelaunch_all_delay_time".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("pulldownRefreshMinDistance".toLowerCase());
    jdField_a_of_type_JavaUtilSet.add("ark_scene_white_list".toLowerCase());
    b = new HashSet();
    b.add("qqcircle_enable_eevee_polling");
    b.add("qqcircle_use_eevee_red_point");
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 89	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 95	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +39 -> 57
    //   21: aload_2
    //   22: invokeinterface 107 1 0
    //   27: ifeq +30 -> 57
    //   30: aload_2
    //   31: aload_2
    //   32: ldc 109
    //   34: invokeinterface 113 2 0
    //   39: invokeinterface 117 2 0
    //   44: lstore_0
    //   45: aload_2
    //   46: ifnull +9 -> 55
    //   49: aload_2
    //   50: invokeinterface 120 1 0
    //   55: lload_0
    //   56: lreturn
    //   57: aload_2
    //   58: ifnull +9 -> 67
    //   61: aload_2
    //   62: invokeinterface 120 1 0
    //   67: lconst_0
    //   68: lreturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: ldc 127
    //   80: iconst_2
    //   81: new 129	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   88: ldc 132
    //   90: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_3
    //   104: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: ifnull -41 -> 67
    //   111: aload_2
    //   112: invokeinterface 120 1 0
    //   117: goto -50 -> 67
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 120 1 0
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -13 -> 123
    //   139: astore_3
    //   140: goto -17 -> 123
    //   143: astore_3
    //   144: goto -72 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	12	0	l	long
    //   16	112	2	localCursor	android.database.Cursor
    //   69	35	3	localException1	Exception
    //   120	14	3	localObject1	Object
    //   135	1	3	localObject2	Object
    //   139	1	3	localObject3	Object
    //   143	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	69	java/lang/Exception
    //   0	17	120	finally
    //   21	45	135	finally
    //   72	107	139	finally
    //   21	45	143	java/lang/Exception
  }
  
  public static ContentValues a(String paramString, entrance_cfg paramentrance_cfg)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return null;
      } while ((paramentrance_cfg == null) || (paramentrance_cfg.iEntranceId < 0) || (paramentrance_cfg.iEntranceId > 999));
      paramString = paramString.replace(" ", "");
      QZLog.e("QZConfigProviderUtil", 2, new Object[] { "********* insertNavigatorConfigItem ******** rsp return navigator item id:", Integer.valueOf(paramentrance_cfg.iEntranceId), " item name: ", paramentrance_cfg.sEntranceName, " item icon: ", paramentrance_cfg.sEntranceIcon, " item action: ", paramentrance_cfg.sEntranceAction, " item qbossicon: ", paramentrance_cfg.sQbossEntranceIcon });
    } while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramentrance_cfg.sEntranceName)));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uin", paramString + "&" + paramentrance_cfg.iEntranceId);
    localContentValues.put("entraceid", Integer.valueOf(paramentrance_cfg.iEntranceId));
    localContentValues.put("entracename", paramentrance_cfg.sEntranceName);
    localContentValues.put("entraceicon", paramentrance_cfg.sEntranceIcon);
    localContentValues.put("entraceaction", paramentrance_cfg.sEntranceAction);
    localContentValues.put("isDefault", Integer.valueOf(paramentrance_cfg.isDefualt));
    localContentValues.put("tabid", Integer.valueOf(paramentrance_cfg.tabid));
    localContentValues.put("qbossentraceicon", paramentrance_cfg.sQbossEntranceIcon);
    localContentValues.put("qbosstraceinfo", paramentrance_cfg.sQbossTraceInfo);
    return localContentValues;
  }
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 89	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 257	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +57 -> 75
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 107 1 0
    //   29: ifeq +46 -> 75
    //   32: aload_1
    //   33: astore_0
    //   34: new 24	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc_w 259
    //   43: invokeinterface 113 2 0
    //   48: invokeinterface 263 2 0
    //   53: invokevirtual 267	java/lang/String:getBytes	()[B
    //   56: ldc_w 269
    //   59: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   62: astore_2
    //   63: aload_1
    //   64: ifnull +9 -> 73
    //   67: aload_1
    //   68: invokeinterface 120 1 0
    //   73: aload_2
    //   74: areturn
    //   75: aload_1
    //   76: ifnull +9 -> 85
    //   79: aload_1
    //   80: invokeinterface 120 1 0
    //   85: ldc 163
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_0
    //   93: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +35 -> 131
    //   99: aload_1
    //   100: astore_0
    //   101: ldc 127
    //   103: iconst_2
    //   104: new 129	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 274
    //   114: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aload_2
    //   128: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload_1
    //   132: ifnull -47 -> 85
    //   135: aload_1
    //   136: invokeinterface 120 1 0
    //   141: goto -56 -> 85
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +9 -> 157
    //   151: aload_0
    //   152: invokeinterface 120 1 0
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: goto -13 -> 147
    //   163: astore_2
    //   164: goto -73 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	130	0	localCursor1	android.database.Cursor
    //   16	120	1	localCursor2	android.database.Cursor
    //   144	14	1	localObject1	Object
    //   159	1	1	localObject2	Object
    //   62	12	2	str	String
    //   88	40	2	localException1	Exception
    //   163	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	88	java/lang/Exception
    //   0	17	144	finally
    //   23	32	159	finally
    //   34	63	159	finally
    //   93	99	159	finally
    //   101	131	159	finally
    //   23	32	163	java/lang/Exception
    //   34	63	163	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str).append("_").append(paramString1).append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = a().getString(a(paramString1, paramString2), paramString3);
      if (paramString1 != null) {}
      label67:
      for (;;) {}
    }
    catch (Exception paramString3)
    {
      try
      {
        paramString3 = paramString1.trim();
        paramString1 = paramString3;
      }
      catch (Exception paramString3)
      {
        break label67;
      }
      try
      {
        QZLog.d("QZConfigProviderUtil", 1, "getHighPriorityConfig. , secondKey: " + paramString2 + ", result: " + paramString1);
        return paramString1;
      }
      catch (Exception paramString3)
      {
        break label67;
      }
      paramString3 = paramString3;
      paramString1 = null;
      QZLog.e("QZConfigProviderUtil", 1, new Object[] { "getHighPriorityConfig exception. secondKey: " + paramString2, paramString3 });
      return paramString1;
    }
  }
  
  /* Error */
  public static Map<String, String> a()
  {
    // Byte code:
    //   0: new 313	java/util/HashMap
    //   3: dup
    //   4: invokespecial 314	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 89	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 316	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +92 -> 118
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 107 1 0
    //   37: ifeq +81 -> 118
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: new 24	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: aload_2
    //   49: ldc_w 318
    //   52: invokeinterface 113 2 0
    //   57: invokeinterface 263 2 0
    //   62: invokevirtual 267	java/lang/String:getBytes	()[B
    //   65: ldc_w 269
    //   68: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   71: new 24	java/lang/String
    //   74: dup
    //   75: aload_2
    //   76: aload_2
    //   77: ldc_w 320
    //   80: invokeinterface 113 2 0
    //   85: invokeinterface 263 2 0
    //   90: invokevirtual 267	java/lang/String:getBytes	()[B
    //   93: ldc_w 269
    //   96: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   99: invokeinterface 325 3 0
    //   104: pop
    //   105: aload_2
    //   106: astore_1
    //   107: aload_2
    //   108: invokeinterface 328 1 0
    //   113: istore_0
    //   114: iload_0
    //   115: ifne -75 -> 40
    //   118: aload_2
    //   119: ifnull +9 -> 128
    //   122: aload_2
    //   123: invokeinterface 120 1 0
    //   128: aload_3
    //   129: areturn
    //   130: astore_3
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: astore_1
    //   135: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +35 -> 173
    //   141: aload_2
    //   142: astore_1
    //   143: ldc 127
    //   145: iconst_2
    //   146: new 129	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 330
    //   156: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_3
    //   160: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: aload_3
    //   170: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_2
    //   174: ifnull +9 -> 183
    //   177: aload_2
    //   178: invokeinterface 120 1 0
    //   183: aconst_null
    //   184: areturn
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +9 -> 198
    //   192: aload_1
    //   193: invokeinterface 120 1 0
    //   198: aload_2
    //   199: athrow
    //   200: astore_2
    //   201: goto -13 -> 188
    //   204: astore_3
    //   205: goto -72 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   113	2	0	bool	boolean
    //   30	163	1	localCursor1	android.database.Cursor
    //   24	154	2	localCursor2	android.database.Cursor
    //   185	14	2	localObject1	Object
    //   200	1	2	localObject2	Object
    //   7	122	3	localHashMap	java.util.HashMap
    //   130	40	3	localException1	Exception
    //   204	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	25	130	java/lang/Exception
    //   8	25	185	finally
    //   31	40	200	finally
    //   42	105	200	finally
    //   107	114	200	finally
    //   135	141	200	finally
    //   143	173	200	finally
    //   31	40	204	java/lang/Exception
    //   42	105	204	java/lang/Exception
    //   107	114	204	java/lang/Exception
  }
  
  public static void a()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.d, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "database clear error" + localException.getMessage(), localException);
    }
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("check_time", Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("QZConfigProviderUtil", 2, "saveIspCheckTime time:" + paramLong);
    }
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.f, localContentValues);
      localContentValues.clear();
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localSQLException.getMessage(), localSQLException);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    String str;
    if (paramString == null)
    {
      str = "";
      localContentValues.put("cookie", str);
      QLog.i("ConfigProvider", 1, "saveConfigCookie cookie" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.b, localContentValues);
        if (paramString == null) {
          continue;
        }
        QLog.i("QZConfigProviderUtil", 1, paramString.toString() + " saveConfigCookie done.");
      }
      catch (SQLException paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      catch (Exception paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      localContentValues.clear();
      return;
      str = paramString;
      break;
      QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error!");
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    if (("qqminiapp".equals(paramString1)) && ("miniappshowfullscreen".equals(paramString2))) {}
    for (;;)
    {
      int i;
      String str;
      try
      {
        i = Integer.valueOf(paramString3).intValue();
        paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        paramString1.edit().putInt(str + "_" + "miniappshowfullscreen", i).apply();
        QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], full screen config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
        return;
      }
      catch (Exception paramString1)
      {
        QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], full screen config exception. key: " + paramString2 + ", value: " + paramString3 });
        return;
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsetting".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowsetting", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], setting config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], setting config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowclose".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowclose", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], close config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], close config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsearch".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowsearch", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], search config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], search config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreentitle".equals(paramString2))) {
        try
        {
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putString(str + "_" + "miniappfullscreentitle", paramString3).apply();
          QZLog.d("QZConfigProviderUtil", 1, "saveConfig miniapp, search config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveConfig miniapp, search config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && (jdField_a_of_type_JavaUtilSet.contains(paramString2))) {
        try
        {
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putString(str + "_" + paramString2, paramString3).apply();
          QZLog.d("QZConfigProviderUtil", 1, "saveConfig miniapp high priority config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          if ("sdk_dex_config".equals(paramString2))
          {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).onDexConfigUpdate(paramString3);
            return;
          }
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveConfig miniapp high priority config exception. key: " + paramString2 + ", value: " + paramString3 });
        }
      }
    }
  }
  
  public static void a(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    if (paramArrayList == null) {}
    while (paramArrayList.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ContentValues localContentValues = a(paramString, (entrance_cfg)paramArrayList.next());
      if (localContentValues != null) {
        localArrayList.add(localContentValues);
      }
    }
    a((ContentValues[])localArrayList.toArray(new ContentValues[0]));
  }
  
  public static void a(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      if (!paramMap.isEmpty())
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          a(str, (String)paramMap.get(str));
        }
      }
    }
  }
  
  public static void a(Map<String, byte[]> paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    boolean bool = a(paramMap, paramString2);
    if ((b("PhotoUpload")) && (b("PhotoSvrList"))) {
      if (bool) {
        a(paramString1);
      }
    }
    for (;;)
    {
      a(paramString2);
      if (paramAppRuntime != null) {}
      try
      {
        if (((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.getLongAccountUin() != 0L))
        {
          paramMap = QzoneConfig.getInstance().getConfig("QZoneSetting", "Qzone_clearCacheVersion", "");
          if ((!TextUtils.isEmpty(paramMap)) && (!LocalMultiProcConfig.getString4Uin("Qzone_clearCacheVersion", "", paramAppRuntime.getLongAccountUin()).equals(paramMap)))
          {
            QZoneHelper.clearCache(paramAppRuntime, true);
            LocalMultiProcConfig.putString4Uin("Qzone_clearCacheVersion", paramMap, paramAppRuntime.getLongAccountUin());
          }
        }
        return;
      }
      catch (Exception paramMap)
      {
        QLog.e("QZConfigProviderUtil", 1, paramMap.getMessage());
      }
      a("");
    }
  }
  
  public static boolean a()
  {
    return "1".equals(a("qqcircle", "qqcircle_use_eevee_red_point", "1"));
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("updatelog", paramString);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.c, localContentValues);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.getTrimmedLength(paramString1) <= 0)) {}
    while ((paramString2 == null) || (TextUtils.getTrimmedLength(paramString2) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.e, localContentValues);
      return true;
    }
    catch (SQLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  /* Error */
  public static boolean a(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 577	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokevirtual 588	java/util/ArrayList:clear	()V
    //   21: aload_0
    //   22: ldc 161
    //   24: ldc 163
    //   26: invokevirtual 167	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   29: astore_0
    //   30: new 129	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 590
    //   40: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 592
    //   50: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore_0
    //   57: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: invokevirtual 89	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   63: getstatic 595	com/tencent/common/config/provider/QZoneConfigProvider:g	Landroid/net/Uri;
    //   66: aconst_null
    //   67: aload_0
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore_0
    //   74: aload_0
    //   75: ifnull +214 -> 289
    //   78: aload_0
    //   79: invokeinterface 107 1 0
    //   84: ifeq +205 -> 289
    //   87: aload_1
    //   88: new 155	NS_UNDEAL_COUNT/entrance_cfg
    //   91: dup
    //   92: aload_0
    //   93: aload_0
    //   94: ldc 217
    //   96: invokeinterface 113 2 0
    //   101: invokeinterface 599 2 0
    //   106: new 24	java/lang/String
    //   109: dup
    //   110: aload_0
    //   111: aload_0
    //   112: ldc 222
    //   114: invokeinterface 113 2 0
    //   119: invokeinterface 263 2 0
    //   124: invokevirtual 267	java/lang/String:getBytes	()[B
    //   127: ldc_w 269
    //   130: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   133: new 24	java/lang/String
    //   136: dup
    //   137: aload_0
    //   138: aload_0
    //   139: ldc 224
    //   141: invokeinterface 113 2 0
    //   146: invokeinterface 263 2 0
    //   151: invokevirtual 267	java/lang/String:getBytes	()[B
    //   154: ldc_w 269
    //   157: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   160: new 24	java/lang/String
    //   163: dup
    //   164: aload_0
    //   165: aload_0
    //   166: ldc 226
    //   168: invokeinterface 113 2 0
    //   173: invokeinterface 263 2 0
    //   178: invokevirtual 267	java/lang/String:getBytes	()[B
    //   181: ldc_w 269
    //   184: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   187: aload_0
    //   188: aload_0
    //   189: ldc 228
    //   191: invokeinterface 113 2 0
    //   196: invokeinterface 599 2 0
    //   201: aload_0
    //   202: aload_0
    //   203: ldc 233
    //   205: invokeinterface 113 2 0
    //   210: invokeinterface 599 2 0
    //   215: new 24	java/lang/String
    //   218: dup
    //   219: aload_0
    //   220: aload_0
    //   221: ldc 237
    //   223: invokeinterface 113 2 0
    //   228: invokeinterface 263 2 0
    //   233: invokevirtual 267	java/lang/String:getBytes	()[B
    //   236: ldc_w 269
    //   239: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   242: new 24	java/lang/String
    //   245: dup
    //   246: aload_0
    //   247: aload_0
    //   248: ldc 239
    //   250: invokeinterface 113 2 0
    //   255: invokeinterface 263 2 0
    //   260: invokevirtual 267	java/lang/String:getBytes	()[B
    //   263: ldc_w 269
    //   266: invokespecial 272	java/lang/String:<init>	([BLjava/lang/String;)V
    //   269: iconst_0
    //   270: aconst_null
    //   271: invokespecial 602	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILNS_UNDEAL_COUNT/st_report_info;)V
    //   274: invokevirtual 491	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   277: pop
    //   278: aload_0
    //   279: invokeinterface 328 1 0
    //   284: istore_2
    //   285: iload_2
    //   286: ifne -199 -> 87
    //   289: aload_0
    //   290: ifnull -279 -> 11
    //   293: aload_0
    //   294: invokeinterface 120 1 0
    //   299: iconst_0
    //   300: ireturn
    //   301: astore_1
    //   302: aconst_null
    //   303: astore_0
    //   304: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +33 -> 340
    //   310: ldc 127
    //   312: iconst_2
    //   313: new 129	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 604
    //   323: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: aload_1
    //   337: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_0
    //   341: ifnull -330 -> 11
    //   344: aload_0
    //   345: invokeinterface 120 1 0
    //   350: iconst_0
    //   351: ireturn
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_0
    //   355: aload_0
    //   356: ifnull +9 -> 365
    //   359: aload_0
    //   360: invokeinterface 120 1 0
    //   365: aload_1
    //   366: athrow
    //   367: astore_1
    //   368: goto -13 -> 355
    //   371: astore_1
    //   372: goto -17 -> 355
    //   375: astore_1
    //   376: goto -72 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramString	String
    //   0	379	1	paramArrayList	ArrayList<entrance_cfg>
    //   284	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   57	74	301	java/lang/Exception
    //   57	74	352	finally
    //   78	87	367	finally
    //   87	285	367	finally
    //   304	340	371	finally
    //   78	87	375	java/lang/Exception
    //   87	285	375	java/lang/Exception
  }
  
  private static boolean a(Map<String, byte[]> paramMap, String paramString)
  {
    if (paramMap == null) {}
    while (paramMap.isEmpty()) {
      return false;
    }
    paramString = paramMap.keySet();
    QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainkey count:", Integer.valueOf(paramString.size()) });
    localArrayList = new ArrayList();
    Iterator localIterator1 = paramString.iterator();
    while (localIterator1.hasNext())
    {
      paramString = (String)localIterator1.next();
      Object localObject1 = (byte[])paramMap.get(paramString);
      if ((paramString != null) && (localObject1 != null) && (localObject1.length > 0))
      {
        QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainKey:", paramString });
        QzoneConfig.getInstance().deleteConfigs(paramString);
        UniAttribute localUniAttribute = new UniAttribute();
        localUniAttribute.setEncodeName("utf-8");
        localUniAttribute.decode((byte[])localObject1);
        Iterator localIterator2 = localUniAttribute.getKeySet().iterator();
        while (localIterator2.hasNext())
        {
          Object localObject2 = (String)localIterator2.next();
          String str = (String)localUniAttribute.get((String)localObject2);
          localObject1 = paramString;
          if (localObject2 != null)
          {
            if (QLog.isColorLevel()) {
              QZLog.i("QZConfigProviderUtil", 2, new Object[] { " main key:", paramString, " second key:", localObject2, " value:", str });
            }
            localObject1 = paramString.toLowerCase();
            paramString = ((String)localObject2).toLowerCase();
            localObject2 = new ContentValues();
            ((ContentValues)localObject2).put("main_key", (String)localObject1);
            ((ContentValues)localObject2).put("second_key", paramString);
            ((ContentValues)localObject2).put("value", str);
            QzoneConfig.getInstance().updateOneConfig((String)localObject1, paramString, str, false);
            localArrayList.add(localObject2);
            a((String)localObject1, paramString, str);
            b((String)localObject1, paramString, str);
          }
          paramString = (String)localObject1;
        }
        try
        {
          BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, "main_key=?", new String[] { paramString });
          if (QLog.isColorLevel()) {
            QZLog.i("QZConfigProviderUtil", 4, new Object[] { "deleteConfig: ", paramString });
          }
        }
        catch (Exception paramString)
        {
          QZLog.e("QZConfigProviderUtil", 1, paramString, new Object[] { "deleteConfig error:" });
        }
      }
    }
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.a, (ContentValues[])localArrayList.toArray(new ContentValues[localArrayList.size()]));
      localArrayList.clear();
      bool = true;
    }
    catch (SQLException paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        bool = false;
      }
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        boolean bool = false;
      }
    }
    finally
    {
      localArrayList.clear();
    }
    return bool;
  }
  
  private static boolean a(ContentValues[] paramArrayOfContentValues)
  {
    boolean bool = false;
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.g, paramArrayOfContentValues);
      bool = true;
    }
    catch (SQLException paramArrayOfContentValues)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramArrayOfContentValues.getMessage(), paramArrayOfContentValues);
      return false;
    }
    catch (Exception paramArrayOfContentValues)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramArrayOfContentValues.getMessage(), paramArrayOfContentValues);
    }
    return bool;
    return false;
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    if ("qqcircle".equals(paramString1)) {}
    try
    {
      if (b.contains(paramString2))
      {
        SharedPreferences localSharedPreferences = a();
        paramString1 = a(paramString1, paramString2);
        localSharedPreferences.edit().putString(paramString1, paramString3).apply();
        QZLog.d("QZConfigProviderUtil", 1, "saveHighPriorityConfig.  secondKey: " + paramString2 + ", value: " + paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveHighPriorityConfig. exception. secondKey: " + paramString2 + ", value: " + paramString3, paramString1 });
    }
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 85	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 89	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 653	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 24	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 677
    //   18: aastore
    //   19: ldc_w 679
    //   22: iconst_1
    //   23: anewarray 24	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: aconst_null
    //   31: invokevirtual 101	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +175 -> 213
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokeinterface 682 1 0
    //   51: istore_1
    //   52: iload_1
    //   53: ifne +27 -> 80
    //   56: iconst_0
    //   57: istore_1
    //   58: iload_1
    //   59: istore_2
    //   60: aload 4
    //   62: ifnull +12 -> 74
    //   65: aload 4
    //   67: invokeinterface 120 1 0
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +122 -> 197
    //   78: iconst_1
    //   79: ireturn
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: invokeinterface 107 1 0
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: iconst_0
    //   97: invokeinterface 599 2 0
    //   102: istore_1
    //   103: goto -45 -> 58
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +48 -> 165
    //   120: aload 4
    //   122: astore_3
    //   123: ldc 127
    //   125: iconst_2
    //   126: new 129	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 684
    //   136: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 686
    //   146: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload 5
    //   162: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload 4
    //   167: ifnull +41 -> 208
    //   170: aload 4
    //   172: invokeinterface 120 1 0
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -105 -> 74
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 120 1 0
    //   195: aload_0
    //   196: athrow
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_0
    //   200: goto -15 -> 185
    //   203: astore 5
    //   205: goto -94 -> 111
    //   208: iconst_0
    //   209: istore_2
    //   210: goto -136 -> 74
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -157 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   51	164	1	i	int
    //   59	151	2	j	int
    //   43	147	3	localCursor1	android.database.Cursor
    //   34	137	4	localCursor2	android.database.Cursor
    //   106	55	5	localException1	Exception
    //   203	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	36	106	java/lang/Exception
    //   0	36	182	finally
    //   44	52	199	finally
    //   83	91	199	finally
    //   94	103	199	finally
    //   114	120	199	finally
    //   123	165	199	finally
    //   44	52	203	java/lang/Exception
    //   83	91	203	java/lang/Exception
    //   94	103	203	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigProviderUtil
 * JD-Core Version:    0.7.0.1
 */