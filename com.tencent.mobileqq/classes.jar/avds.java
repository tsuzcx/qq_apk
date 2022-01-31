import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.s2c.msgtype0x210.submsgtype0x113.SubMsgType0x113.MsgBody;

public class avds
{
  public static avdt a;
  public static final String a;
  public static HashMap<String, avdt> a;
  public static boolean a;
  public static final String b;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsf.aW + "qbosssplahAD/";
    b = ajsf.aW + "qbdownres";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.parseInt(paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "StringToInt exception" + paramString.toString());
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.parseLong(paramString);
      }
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "StringToLong exception" + paramString.toString());
    }
    return 0L;
  }
  
  public static SharedPreferences a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("qboss_banner_refresh_sp_" + str, 0);
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qboss_splash_ad_pref_" + paramString, 0);
  }
  
  public static String a(String paramString, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        Object localObject2 = ((SharedPreferences)localObject1).getString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong, "");
        StringBuffer localStringBuffer = new StringBuffer();
        String str = "";
        localObject1 = str;
        int i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = str;
          i = j;
          if (!TextUtils.isEmpty(paramString))
          {
            localObject2 = ((String)localObject2).split(",");
            j = 0;
            i = k;
            localObject1 = str;
            if (j + 2 < localObject2.length)
            {
              str = localObject2[j];
              if ((i == 0) && (paramString.equals(str)))
              {
                i = 1;
                localObject1 = str;
                break label390;
              }
              localStringBuffer.append(localObject2[j]).append(",").append(localObject2[(j + 1)]).append(",").append(localObject2[(j + 2)]).append(",");
              break label390;
            }
            str = "";
            if (localStringBuffer.length() != 0) {
              str = localStringBuffer.substring(0, localStringBuffer.length() - 1);
            }
            QLog.i("QSplash@QbossSplashUtil", 1, "removeHasShowAdIDs result=" + str + "removeid = " + paramString);
            localEditor.putString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong, str);
            localEditor.apply();
          }
        }
        str = "";
        paramString = str;
        if (paramBoolean)
        {
          paramString = str;
          if (i != 0) {
            paramString = a(BaseApplicationImpl.getContext(), paramLong + "").getString("qboss_splash_info_report_" + (String)localObject1, "");
          }
        }
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.i("QSplash@QbossSplashUtil", 1, "removeHasShowAdIDs exception");
        return null;
      }
      label390:
      j += 3;
    }
  }
  
  public static String a(Set<String> paramSet)
  {
    String str = "";
    Object localObject = str;
    if (paramSet != null)
    {
      localObject = str;
      if (paramSet.size() > 0)
      {
        localObject = new StringBuffer();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
          ((StringBuffer)localObject).append((String)paramSet.next()).append(",");
        }
        localObject = ((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1);
      }
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "getLocalAdIds  adids =" + (String)localObject);
    return localObject;
  }
  
  public static HashMap<String, avdt> a(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = a(paramContext, paramString);
      paramContext = a(paramContext, paramString).iterator();
      while (paramContext.hasNext())
      {
        String str1 = (String)paramContext.next();
        String str2 = localSharedPreferences.getString("qboss_splash_ad_begin_time_" + str1, "");
        String str3 = localSharedPreferences.getString("qboss_splash_ad_end_time_" + str1, "");
        int i = localSharedPreferences.getInt("qbosss_plash_ad_content_type_" + str1, -1);
        String str4 = localSharedPreferences.getString("qbosss_splash_ad_download_url_" + str1, "");
        int j = localSharedPreferences.getInt("qbosss_splash_ad_jumptype_" + str1, -1);
        String str5 = localSharedPreferences.getString("qbosss_splash_ad_jump_h5_url_" + str1, "");
        int k = localSharedPreferences.getInt("qboss_splash_ad_exposure_platform_" + str1, 0);
        String str6 = localSharedPreferences.getString("qboss_exposure_url_" + str1, "");
        boolean bool1 = localSharedPreferences.getBoolean("qboss_exposure_is_low_device_limit_" + str1, false);
        boolean bool2 = localSharedPreferences.getBoolean("qboss_splash_ad_is_limited_" + str1, false);
        int m = localSharedPreferences.getInt("qboss_splash_ad_showpriority_" + str1, 0);
        String str7 = localSharedPreferences.getString("qboss_splash_info_report_" + str1, "");
        String str8 = localSharedPreferences.getString("qboss_splash_resource_md5_" + str1, "");
        int n = localSharedPreferences.getInt("qboss_splash_should_show_ad_mark_" + str1, 0);
        avdu localavdu = new avdu();
        localavdu.g(paramString).a(str1).b(str2).c(str3).c(i).d(str4).e(k).f(str6).e(str5).d(j).b(bool1).a(bool2).b(m).h(str7).i(str8).a(n);
        QLog.i("QSplash@QbossSplashUtil", 1, "buildADEntryFromSP  adid =" + str1);
        jdField_a_of_type_JavaUtilHashMap.put(str1, localavdu.a());
      }
      return jdField_a_of_type_JavaUtilHashMap;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "buildADEntryFromSP exception" + paramContext.toString());
    }
  }
  
  public static List<String> a(Context paramContext, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    try
    {
      Object localObject = paramContext.getString("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong, "");
      QLog.i("QSplash@QbossSplashUtil", 1, "idsWithTime = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = new ArrayList();
      }
      String[] arrayOfString;
      int i;
      label171:
      Context localContext;
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        arrayOfString = ((String)localObject).split(",");
        i = 0;
        for (;;)
        {
          localObject = paramContext;
          if (i + 2 >= arrayOfString.length) {
            break;
          }
          localObject = arrayOfString[i];
          if (a(arrayOfString[(i + 1)], arrayOfString[(i + 2)]))
          {
            paramContext.add(localObject);
            QLog.i("QSplash@QbossSplashUtil", 1, "permittedAdIDs = " + (String)localObject);
          }
          i += 3;
        }
        localException1 = localException1;
        paramContext = null;
      }
      catch (Exception localException2)
      {
        break label171;
      }
      QLog.e("QSplash@QbossSplashUtil", 1, "getPermittedAdIDs exception" + localException1.toString());
      localContext = paramContext;
      return localContext;
    }
  }
  
  public static Set<String> a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString).getString("splash_ad_ids", "");
    paramString = new HashSet();
    if (!TextUtils.isEmpty(paramContext)) {
      paramString.addAll(Arrays.asList(paramContext.split(",")));
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "getLocalAdIds frosm sp  adids =" + paramString);
    return paramString;
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("qboss_banner_refresh_sp_" + paramLong, 0).edit();
      paramContext.putLong("qbossNextRequestTime_2742", 0L);
      paramContext.apply();
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanRefreshSp ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanRefreshSp exception" + paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      localEditor.remove("qboss_splash_ad_ids_with_showdate_with_priority_" + paramLong);
      localEditor.remove("qboss_splash_ad_ids_with_showdate_with_priority_0");
      localEditor.apply();
      if (paramBoolean) {
        a(paramContext, paramLong);
      }
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanAllConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanAllConfig exception" + paramContext.toString());
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanOldSplashResDir sub" + paramString);
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanOldSplashResDir exception" + paramString.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      QLog.i("QSplash@QbossSplashUtil", 4, " sendQbossSplashReportExpose sQBosstrace:" + paramString1);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), axco.class);
      try
      {
        localNewIntent.putExtra("uin", Long.parseLong(localAppRuntime.getAccount()));
        localNewIntent.putExtra("qua", bgxr.a());
        localNewIntent.putExtra("sQBosstrace", paramString1);
        localNewIntent.putExtra("iOperType", paramInt);
        localNewIntent.putExtra("sUserID", paramString2);
        localAppRuntime.startServlet(localNewIntent);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "sendQbossSplashReportExpose exception" + paramString1.toString());
    }
  }
  
  public static void a(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      Object localObject = new SubMsgType0x113.MsgBody();
      ((SubMsgType0x113.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      int i = ((SubMsgType0x113.MsgBody)localObject).int32_app_id.get();
      int j = ((SubMsgType0x113.MsgBody)localObject).int32_task_id.get();
      int k = ((SubMsgType0x113.MsgBody)localObject).enum_task_op.get();
      if (i == 2742)
      {
        if (k == 1)
        {
          localObject = a(j + "", paramLong, true);
          paramArrayOfByte = (byte[])localObject;
          if (localObject == null) {
            paramArrayOfByte = "";
          }
          a(paramArrayOfByte, null, 10);
          QLog.i("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 removeid " + j + paramArrayOfByte);
        }
      }
      else if ((i == 2783) && (k == 1))
      {
        b(String.valueOf(paramLong));
        QLog.i("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 cleanConfigAndResDir");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "decodePush0x210_0x113 exception" + paramArrayOfByte.toString());
    }
  }
  
  /* Error */
  public static boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: invokestatic 113	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: lload_0
    //   10: invokestatic 473	avds:a	(Landroid/content/Context;J)Ljava/util/List;
    //   13: astore 7
    //   15: iload 4
    //   17: istore_3
    //   18: aload 7
    //   20: ifnull +208 -> 228
    //   23: aload 7
    //   25: invokeinterface 474 1 0
    //   30: istore_2
    //   31: iload 4
    //   33: istore_3
    //   34: iload_2
    //   35: ifle +193 -> 228
    //   38: ldc 61
    //   40: iconst_1
    //   41: new 15	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 476
    //   51: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: lload_0
    //   55: ldc2_w 477
    //   58: lrem
    //   59: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: invokestatic 85	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   71: new 15	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   78: lload_0
    //   79: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc 91
    //   84: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 480	avds:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/HashMap;
    //   93: astore 9
    //   95: aconst_null
    //   96: astore 6
    //   98: aload 7
    //   100: invokeinterface 481 1 0
    //   105: astore 10
    //   107: aload 10
    //   109: invokeinterface 198 1 0
    //   114: ifeq +107 -> 221
    //   117: aload 10
    //   119: invokeinterface 202 1 0
    //   124: checkcast 141	java/lang/String
    //   127: astore 7
    //   129: aload 9
    //   131: aload 7
    //   133: invokevirtual 484	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   136: ifeq +145 -> 281
    //   139: aload 9
    //   141: aload 7
    //   143: invokevirtual 487	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: checkcast 489	avdt
    //   149: astore 8
    //   151: ldc 61
    //   153: iconst_1
    //   154: new 15	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 491
    //   164: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 8
    //   169: invokevirtual 492	avdt:toString	()Ljava/lang/String;
    //   172: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 167	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload 8
    //   183: invokevirtual 494	avdt:a	()Z
    //   186: ifeq +95 -> 281
    //   189: aload 6
    //   191: ifnonnull +10 -> 201
    //   194: aload 8
    //   196: astore 7
    //   198: goto +76 -> 274
    //   201: aload 8
    //   203: astore 7
    //   205: aload 8
    //   207: getfield 497	avdt:d	I
    //   210: aload 6
    //   212: getfield 497	avdt:d	I
    //   215: if_icmpgt +59 -> 274
    //   218: goto +63 -> 281
    //   221: aload 6
    //   223: putstatic 499	avds:jdField_a_of_type_Avdt	Lavdt;
    //   226: iconst_1
    //   227: istore_3
    //   228: iload_3
    //   229: ireturn
    //   230: astore 6
    //   232: iload 5
    //   234: istore_3
    //   235: ldc 61
    //   237: iconst_1
    //   238: new 15	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 501
    //   248: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 6
    //   253: invokevirtual 64	java/lang/Exception:toString	()Ljava/lang/String;
    //   256: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: iload_3
    //   266: ireturn
    //   267: astore 6
    //   269: iconst_1
    //   270: istore_3
    //   271: goto -36 -> 235
    //   274: aload 7
    //   276: astore 6
    //   278: goto -171 -> 107
    //   281: aload 6
    //   283: astore 7
    //   285: goto -11 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramLong	long
    //   30	5	2	i	int
    //   17	254	3	bool1	boolean
    //   4	28	4	bool2	boolean
    //   1	232	5	bool3	boolean
    //   96	126	6	localObject1	Object
    //   230	22	6	localException1	Exception
    //   267	1	6	localException2	Exception
    //   276	6	6	localObject2	Object
    //   13	271	7	localObject3	Object
    //   149	57	8	localavdt	avdt
    //   93	47	9	localHashMap	HashMap
    //   105	13	10	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   6	15	230	java/lang/Exception
    //   23	31	230	java/lang/Exception
    //   38	95	267	java/lang/Exception
    //   98	107	267	java/lang/Exception
    //   107	189	267	java/lang/Exception
    //   205	218	267	java/lang/Exception
    //   221	226	267	java/lang/Exception
  }
  
  public static boolean a(File paramFile)
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
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(String paramString)
  {
    long l = a(paramString);
    return NetConnInfoCenter.getServerTime() > l;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    long l1 = a(paramString2);
    long l2 = a(paramString1);
    long l3 = NetConnInfoCenter.getServerTime();
    return (l2 < l3) && (l3 < l1);
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    try
    {
      a(paramContext, paramLong + "").edit().clear().apply();
      QLog.i("QSplash@QbossSplashUtil", 1, "cleanQbossSPConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "cleanQbossSPConfig exception" + paramContext.toString());
    }
  }
  
  public static void b(String paramString)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("qboss_pre_download_pref_" + paramString, 0).edit().clear().apply();
    a(new File(b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     avds
 * JD-Core Version:    0.7.0.1
 */