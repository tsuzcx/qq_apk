import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils.2;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;

public class bmbt
{
  private static TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  private static Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public static String a;
  private static ThreadLocal<char[]> jdField_a_of_type_JavaLangThreadLocal = new bmbu();
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static AtomicInteger a;
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private static String b;
  public static AtomicInteger b;
  private static String c;
  private static String d;
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
    c = "";
    d = "";
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(d)) {}
    try
    {
      QLog.d("VipComicReportUtils", 1, "getQimei: try get QIMei from UserAction.getQIMEI!");
      d = UserAction.getQIMEI();
      if (d == null) {
        d = "";
      }
      return d;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("VipComicReportUtils", 1, "getQimei error", localThrowable);
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      if (jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
        jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      }
    }
    try
    {
      jdField_b_of_type_JavaLangString = blhc.a("2240ca");
      if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
        jdField_b_of_type_JavaLangString = a();
      }
      if (jdField_b_of_type_JavaLangString == null)
      {
        QLog.e("VipComicReportUtils", 1, "getImei finally encounter error and return empty");
        jdField_b_of_type_JavaLangString = "";
      }
      return jdField_b_of_type_JavaLangString;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e("VipComicReportUtils", 1, "telephonyManager.getDeviceId encounter error", paramContext);
      }
    }
  }
  
  public static StringBuilder a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        jdField_a_of_type_JavaLangReflectField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        jdField_a_of_type_JavaLangReflectField.setAccessible(true);
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if (jdField_a_of_type_JavaLangReflectField != null) {
        jdField_a_of_type_JavaLangReflectField.set(localStringBuilder, jdField_a_of_type_JavaLangThreadLocal.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  private static void a(Context paramContext)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      jdField_a_of_type_JavaLangString = paramContext.widthPixels + "*" + paramContext.heightPixels;
    }
  }
  
  public static void a(Intent paramIntent, binb parambinb)
  {
    if ((paramIntent == null) || (parambinb == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "Invalid parameters in reportStartSpeed.");
      }
    }
    long l1;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("isFromJumpActivity", false));
      l1 = paramIntent.getLongExtra("reportLebaClick", 0L);
    } while (l1 == jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l1);
    int j = paramIntent.getIntExtra("reportSourceFrom", 0);
    int i = paramIntent.getIntExtra("reportProcessExistFlag", 0);
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
      i = 2;
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      long l2 = paramIntent.getLongExtra("reportJumpActivityOnCreate", 0L);
      long l3 = paramIntent.getLongExtra("reportDownloadTime", 0L);
      long l4 = paramIntent.getLongExtra("reportInstallTime", 0L);
      long l5 = paramIntent.getLongExtra("reportStartPluginTime", 0L);
      long l6 = paramIntent.getLongExtra("reportBrowserOnCreateStart", 0L);
      long l7 = paramIntent.getLongExtra("reportBrowserOnCreateEnd", 0L);
      if (QLog.isColorLevel())
      {
        paramIntent = "" + "totalTime:" + (l7 - l1);
        paramIntent = paramIntent + "&jumpActivityCreateTime:" + (l2 - l1);
        paramIntent = paramIntent + "&installTime:" + l4;
        paramIntent = paramIntent + "&downloadTime:" + l3;
        paramIntent = paramIntent + "&startPluginTime:" + (l5 - l2);
        paramIntent = paramIntent + "&startLaunchBrowser" + (l6 - l5);
        paramIntent = paramIntent + "&launchBrowser:" + (l7 - l6);
        paramIntent = paramIntent + "&processExistFlag:" + i;
        QLog.d("VipComicReportUtils", 2, paramIntent + "&sourceFrom:" + j);
      }
      bisj.a(l7 - l1, l2 - l1, l3, l4, l5 - l2, 0L, parambinb.b, parambinb.e, parambinb.c, parambinb.a, parambinb.d, parambinb.f, 2L, 0L, i, 0L, l6 - l5, l7 - l6 + "", Build.VERSION.RELEASE, j + "");
      return;
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        i = 1;
      } else if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
        i = 3;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, bmbg parambmbg)
  {
    if (paramAppInterface == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause app == null");
      return;
    }
    Object localObject = paramAppInterface.getApp();
    if (localObject == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause context == null");
      return;
    }
    paramAppInterface = b();
    a((Context)localObject);
    localObject = parambmbg.a();
    a(null, "dc01327", Arrays.asList(new String[] { "", "android", "201", Build.VERSION.RELEASE, "8.4.5", "", "android", paramAppInterface, jdField_a_of_type_JavaLangString, parambmbg.o(), "", parambmbg.a(), "", parambmbg.b(), parambmbg.c(), "", parambmbg.e(), localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8], "", "", "", parambmbg.j(), "", parambmbg.m(), parambmbg.d(), parambmbg.f(), parambmbg.g(), parambmbg.k(), parambmbg.h(), parambmbg.l(), parambmbg.i(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", localObject[0], localObject[9], parambmbg.n() }));
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    String str = b();
    a(paramContext);
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    arrayOfString[4] = "";
    arrayOfString[5] = "";
    arrayOfString[6] = "";
    arrayOfString[7] = "";
    arrayOfString[8] = "";
    arrayOfString[9] = "";
    int i = 0;
    while ((i < arrayOfString.length) && (i < paramVarArgs.length))
    {
      arrayOfString[i] = paramVarArgs[i];
      i += 1;
    }
    arrayOfString[5] = a();
    paramString1 = Arrays.asList(new String[] { "1", paramString1, a(paramContext), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", bmbh.e, "", "", paramString2, bmbh.jdField_a_of_type_JavaLangString, "", paramString3, paramString4, paramString5, "", "", "8.4.5", "", "", "", "", "", "android", str, jdField_a_of_type_JavaLangString, "", arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4], arrayOfString[5], arrayOfString[6], arrayOfString[7], arrayOfString[8], "", bmbh.f, "", "", "" });
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "dc00145", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String... paramVarArgs)
  {
    if (paramAppInterface == null) {}
    String str;
    BaseApplication localBaseApplication;
    do
    {
      return;
      str = paramAppInterface.getCurrentAccountUin();
      localBaseApplication = paramAppInterface.getApp();
    } while ((str == null) || (localBaseApplication == null));
    int j = nnr.a();
    if (j >= 0)
    {
      i = j;
      if (j < antf.c.length) {}
    }
    else
    {
      i = 0;
    }
    Object localObject2 = antf.c[i];
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      localObject1 = localBaseApplication.getResources().getDisplayMetrics();
      jdField_a_of_type_JavaLangString = ((DisplayMetrics)localObject1).widthPixels + "*" + ((DisplayMetrics)localObject1).heightPixels;
    }
    Object localObject1 = new String[10];
    localObject1[0] = "";
    localObject1[1] = "";
    localObject1[2] = "";
    localObject1[3] = "";
    localObject1[4] = "";
    localObject1[5] = "";
    localObject1[6] = "";
    localObject1[7] = "";
    localObject1[8] = "";
    localObject1[9] = "";
    int i = 0;
    while ((i < localObject1.length) && (i < paramVarArgs.length))
    {
      localObject1[i] = paramVarArgs[i];
      i += 1;
    }
    localObject1[5] = a();
    if ((TextUtils.isEmpty(localObject1[7])) && (!TextUtils.isEmpty(bmbh.i))) {
      localObject1[7] = bmbh.i;
    }
    if (TextUtils.isEmpty(bmbh.jdField_b_of_type_JavaLangString))
    {
      paramVarArgs = "";
      paramString5 = Arrays.asList(new String[] { "1", str, a(localBaseApplication), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", paramVarArgs, paramString9, "", "", paramString1, paramString5, "", paramString2, paramString3, paramString4, "", "", "8.4.5", "", "", paramString10, "", "", "android", localObject2, jdField_a_of_type_JavaLangString, "", localObject1[0], localObject1[1], localObject1[2], localObject1[3], localObject1[4], localObject1[5], localObject1[6], localObject1[7], localObject1[8], paramString7, paramString8, paramString6, "", "" });
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uin:").append(str).append(",").append("imei:").append(a(localBaseApplication)).append(",").append("domain:android,").append("domain_id:201,").append("biz_id:8001,").append("biz_subid:8001001,").append("obj_ownerid:").append(paramVarArgs).append(",").append("objPos:").append(paramString9).append(",").append("pageId:").append(paramString1).append(",").append("operObjType:").append(paramString2).append(",").append("operObjId:").append(paramString3).append(",").append("retId:").append(paramString4).append(",").append("sesId:").append(paramString10).append(",").append("ext1: ,").append("ext2:").append(localObject1[0]).append(",").append("ext3:").append(localObject1[1]).append(",").append("ext4:").append(localObject1[2]).append(",").append("ext5:").append(localObject1[3]).append(",").append("ext6:").append(localObject1[4]).append(",").append("ext7:").append(localObject1[5]).append(",").append("ext8:").append(localObject1[6]).append(",").append("ext9:").append(localObject1[7]).append(",").append("ext10:").append(localObject1[8]).append(",").append("land_page_id:").append(paramString7).append(",").append("detailpage_from:").append(paramString8).append(",").append("algo_id:").append(paramString6);
        QLog.d("VipComicReportUtils", 2, "dc DC00145_3 detail : " + ((StringBuilder)localObject2).toString());
      }
      if (!"3025".equals(paramString1)) {
        break label1102;
      }
      paramString1 = bmbh.jdField_a_of_type_Bmbl.a();
      paramString1.a("is_new", 22, "302598765432001");
      label1066:
      paramString1 = paramString1.a(paramString5);
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label1109;
      }
    }
    label1102:
    label1109:
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "dc00145", paramString1);
      return;
      paramVarArgs = bmbh.jdField_b_of_type_JavaLangString;
      break;
      paramString1 = bmbh.jdField_a_of_type_Bmbl;
      break label1066;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    a(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp(), paramString1, paramString2, paramString3, paramString4, paramVarArgs);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      localStringBuilder = a();
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i));
        if (i < j - 1) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
      paramList = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "dcId=" + paramString + ";detail=" + paramList);
      }
      bdkl.a(paramQQAppInterface, paramString, paramList);
    }
    while (!QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      int j;
      int i;
      return;
    }
    QLog.d("VipComicReportUtils", 2, "params is null, dcId=" + paramString + ";detail=" + "");
  }
  
  private static void a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      BaseApplicationImpl.getContext().getSharedPreferences("fileSystemInfo_" + localAppRuntime.getAccount(), 4).edit().putString("systemImei", paramString).apply();
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "save system imei success ");
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ThreadManager.executeOnNetWorkThread(new VipComicReportUtils.2(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, paramString6, paramString7));
  }
  
  private static String b()
  {
    int j = nnr.a();
    int i;
    if (j >= 0)
    {
      i = j;
      if (j < antf.c.length) {}
    }
    else
    {
      i = 0;
    }
    return antf.c[i];
  }
  
  public static String b(Context paramContext)
  {
    if (!bhsr.a(c)) {
      return c;
    }
    if ((Build.VERSION.SDK_INT > 28) || ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))) {
      return a();
    }
    return c(paramContext);
  }
  
  private static String c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return BaseApplicationImpl.getContext().getSharedPreferences("fileSystemInfo_" + localAppRuntime.getAccount(), 4).getString("systemImei", "");
    }
    return "";
  }
  
  private static String c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        String str = c();
        if (!str.isEmpty())
        {
          c = str;
          if (QLog.isColorLevel()) {
            QLog.d("VipComicReportUtils", 2, "getting system imei from sp is success ");
          }
          return c;
        }
        QLog.d("VipComicReportUtils", 1, "get system imei from TelephonyManager");
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 26) {
          continue;
        }
        c = paramContext.getDeviceId();
        if (!c.isEmpty()) {
          a(c);
        }
      }
      catch (SecurityException paramContext)
      {
        c = "";
        continue;
      }
      catch (Throwable paramContext)
      {
        c = "";
        continue;
      }
      return c;
      c = paramContext.getImei();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbt
 * JD-Core Version:    0.7.0.1
 */