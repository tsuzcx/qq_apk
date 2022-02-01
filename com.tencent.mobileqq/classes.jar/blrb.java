import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.comic.VipComicReportUtils.2;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class blrb
{
  private static Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public static String a;
  private static ThreadLocal<char[]> jdField_a_of_type_JavaLangThreadLocal = new blrc();
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
      d = BaseApplicationImpl.getContext().getSharedPreferences("fileSystemInfo_", 4).getString("qimei_new", "");
      if (TextUtils.isEmpty(d)) {
        a();
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
  
  @Deprecated
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {}
    try
    {
      jdField_b_of_type_JavaLangString = QQDeviceInfo.getIMEI("2240ca");
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
  
  private static void a()
  {
    UserAction.getQimei(new blrd());
  }
  
  private static void a(Context paramContext)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      jdField_a_of_type_JavaLangString = paramContext.widthPixels + "*" + paramContext.heightPixels;
    }
  }
  
  public static void a(Intent paramIntent, bieb parambieb)
  {
    if ((paramIntent == null) || (parambieb == null)) {
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
      bijd.a(l7 - l1, l2 - l1, l3, l4, l5 - l2, 0L, parambieb.b, parambieb.e, parambieb.c, parambieb.a, parambieb.d, parambieb.f, 2L, 0L, i, 0L, l6 - l5, l7 - l6 + "", Build.VERSION.RELEASE, j + "");
      return;
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        i = 1;
      } else if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
        i = 3;
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, blqo paramblqo)
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
    paramAppInterface = c();
    a((Context)localObject);
    localObject = paramblqo.a();
    a(null, "dc01327", Arrays.asList(new String[] { "", "android", "201", Build.VERSION.RELEASE, "8.4.10", "", "android", paramAppInterface, jdField_a_of_type_JavaLangString, paramblqo.o(), "", paramblqo.a(), "", paramblqo.b(), paramblqo.c(), "", paramblqo.e(), localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8], "", "", "", paramblqo.j(), "", paramblqo.m(), paramblqo.d(), paramblqo.f(), paramblqo.g(), paramblqo.k(), paramblqo.h(), paramblqo.l(), paramblqo.i(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", localObject[0], localObject[9], paramblqo.n() }));
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    String str = c();
    a(paramContext);
    paramContext = new String[10];
    paramContext[0] = "";
    paramContext[1] = "";
    paramContext[2] = "";
    paramContext[3] = "";
    paramContext[4] = "";
    paramContext[5] = "";
    paramContext[6] = "";
    paramContext[7] = "";
    paramContext[8] = "";
    paramContext[9] = "";
    int i = 0;
    while ((i < paramContext.length) && (i < paramVarArgs.length))
    {
      paramContext[i] = paramVarArgs[i];
      i += 1;
    }
    paramContext[5] = a();
    paramString1 = Arrays.asList(new String[] { "1", paramString1, a(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", blqp.e, "", "", paramString2, blqp.jdField_a_of_type_JavaLangString, paramString3, paramString4, paramString5, paramString6, "", "", "8.4.10", "", "", "", "", "", "android", str, jdField_a_of_type_JavaLangString, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8], "", blqp.f, "", "", "" });
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "dc00145", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 == null) || (paramContext == null)) {
      return;
    }
    String str = c();
    a(paramContext);
    paramContext = new String[10];
    paramContext[0] = "";
    paramContext[1] = "";
    paramContext[2] = "";
    paramContext[3] = "";
    paramContext[4] = "";
    paramContext[5] = "";
    paramContext[6] = "";
    paramContext[7] = "";
    paramContext[8] = "";
    paramContext[9] = "";
    int i = 0;
    while ((i < paramContext.length) && (i < paramVarArgs.length))
    {
      paramContext[i] = paramVarArgs[i];
      i += 1;
    }
    paramContext[5] = a();
    paramString1 = Arrays.asList(new String[] { "1", paramString1, a(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", blqp.e, "", "", paramString2, blqp.jdField_a_of_type_JavaLangString, "", paramString3, paramString4, paramString5, "", "", "8.4.10", "", "", "", "", "", "android", str, jdField_a_of_type_JavaLangString, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8], "", blqp.f, "", "", "" });
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
    do
    {
      return;
      str = paramAppInterface.getCurrentAccountUin();
      localObject2 = paramAppInterface.getApp();
    } while ((str == null) || (localObject2 == null));
    int j = HttpUtil.getNetWorkType();
    if (j >= 0)
    {
      i = j;
      if (j < AppConstants.NET_TYPE_NAME.length) {}
    }
    else
    {
      i = 0;
    }
    Object localObject1 = AppConstants.NET_TYPE_NAME[i];
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      localObject2 = ((Context)localObject2).getResources().getDisplayMetrics();
      jdField_a_of_type_JavaLangString = ((DisplayMetrics)localObject2).widthPixels + "*" + ((DisplayMetrics)localObject2).heightPixels;
    }
    Object localObject2 = new String[10];
    localObject2[0] = "";
    localObject2[1] = "";
    localObject2[2] = "";
    localObject2[3] = "";
    localObject2[4] = "";
    localObject2[5] = "";
    localObject2[6] = "";
    localObject2[7] = "";
    localObject2[8] = "";
    localObject2[9] = "";
    int i = 0;
    while ((i < localObject2.length) && (i < paramVarArgs.length))
    {
      localObject2[i] = paramVarArgs[i];
      i += 1;
    }
    localObject2[5] = a();
    if ((TextUtils.isEmpty(localObject2[7])) && (!TextUtils.isEmpty(blqp.i))) {
      localObject2[7] = blqp.i;
    }
    if (TextUtils.isEmpty(blqp.jdField_b_of_type_JavaLangString))
    {
      paramVarArgs = "";
      paramString5 = Arrays.asList(new String[] { "1", str, a(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", paramVarArgs, paramString9, "", "", paramString1, paramString5, "", paramString2, paramString3, paramString4, "", "", "8.4.10", "", "", paramString10, "", "", "android", localObject1, jdField_a_of_type_JavaLangString, "", localObject2[0], localObject2[1], localObject2[2], localObject2[3], localObject2[4], localObject2[5], localObject2[6], localObject2[7], localObject2[8], paramString7, paramString8, paramString6, "", "" });
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("uin:").append(str).append(",").append("imei:").append(a()).append(",").append("domain:android,").append("domain_id:201,").append("biz_id:8001,").append("biz_subid:8001001,").append("obj_ownerid:").append(paramVarArgs).append(",").append("objPos:").append(paramString9).append(",").append("pageId:").append(paramString1).append(",").append("operObjType:").append(paramString2).append(",").append("operObjId:").append(paramString3).append(",").append("retId:").append(paramString4).append(",").append("sesId:").append(paramString10).append(",").append("ext1: ,").append("ext2:").append(localObject2[0]).append(",").append("ext3:").append(localObject2[1]).append(",").append("ext4:").append(localObject2[2]).append(",").append("ext5:").append(localObject2[3]).append(",").append("ext6:").append(localObject2[4]).append(",").append("ext7:").append(localObject2[5]).append(",").append("ext8:").append(localObject2[6]).append(",").append("ext9:").append(localObject2[7]).append(",").append("ext10:").append(localObject2[8]).append(",").append("land_page_id:").append(paramString7).append(",").append("detailpage_from:").append(paramString8).append(",").append("algo_id:").append(paramString6);
        QLog.d("VipComicReportUtils", 2, "dc DC00145_3 detail : " + ((StringBuilder)localObject1).toString());
      }
      if (!"3025".equals(paramString1)) {
        break label1098;
      }
      paramString1 = blqp.jdField_a_of_type_Blqt.a();
      paramString1.a("is_new", 22, "302598765432001");
      label1062:
      paramString1 = paramString1.a(paramString5);
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label1105;
      }
    }
    label1098:
    label1105:
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      a(paramAppInterface, "dc00145", paramString1);
      return;
      paramVarArgs = blqp.jdField_b_of_type_JavaLangString;
      break;
      paramString1 = blqp.jdField_a_of_type_Blqt;
      break label1062;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    a(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApp(), paramString1, paramString2, paramString3, paramString4, paramString5, paramVarArgs);
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
      bdka.a(paramQQAppInterface, paramString, paramList);
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
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ThreadManager.executeOnNetWorkThread(new VipComicReportUtils.2(paramString1, paramString2, paramString3, paramInt, paramString4, paramString5, paramString6, paramString7));
  }
  
  public static String b(Context paramContext)
  {
    if (!StringUtil.isEmpty(c)) {
      return c;
    }
    if ((Build.VERSION.SDK_INT > 28) || ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))) {
      return a();
    }
    return c(paramContext);
  }
  
  private static String c()
  {
    int j = HttpUtil.getNetWorkType();
    int i;
    if (j >= 0)
    {
      i = j;
      if (j < AppConstants.NET_TYPE_NAME.length) {}
    }
    else
    {
      i = 0;
    }
    return AppConstants.NET_TYPE_NAME[i];
  }
  
  private static String c(Context paramContext)
  {
    try
    {
      QLog.d("VipComicReportUtils", 1, "get system imei from QQDeviceInfo");
      c = QQDeviceInfo.getIMEI("7aa880");
      return c;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        c = "";
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        c = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrb
 * JD-Core Version:    0.7.0.1
 */