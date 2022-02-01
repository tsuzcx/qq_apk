package com.tencent.comic.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.data.ExtraParams;
import com.tencent.comic.data.VipComicDC01327ReportData;
import com.tencent.comic.data.VipComicDataHelper;
import com.tencent.comic.utils.AppHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

public class QQDcReporterImpl
  implements IQQDcReporter
{
  private static final String FILE_SYSTEM_INFO_ = "fileSystemInfo_";
  private static final String IMEI_INTERFACE_BIZ_ID = "7aa880";
  private static final String KEY_SYSTEM_IMEI = "systemImei";
  public static final String QQ_DEVICE_INFO_COMIC = "2240ca";
  private static final String TAG = "VipComicReportUtils";
  private static String imei = "";
  private static Boolean needGetField = Boolean.valueOf(true);
  private static String qimei = "";
  public static String res = "";
  private static ThreadLocal<char[]> stringBuilderCharBuffer = new QQDcReporterImpl.1();
  private static Field stringBuilderValueField;
  private static String systemImei = "";
  
  private static String getNetType()
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
  
  private static String getSystemImei(Context paramContext)
  {
    try
    {
      QLog.d("VipComicReportUtils", 1, "get system imei from QQDeviceInfo");
      systemImei = QQDeviceInfo.getIMEI("7aa880");
    }
    catch (SecurityException paramContext)
    {
      break label27;
    }
    catch (Throwable paramContext)
    {
      label19:
      label27:
      label32:
      break label19;
    }
    systemImei = "";
    break label32;
    systemImei = "";
    return systemImei;
  }
  
  private static String getSystemImeiFromSP()
  {
    AppRuntime localAppRuntime = AppHelper.b();
    if (localAppRuntime != null)
    {
      Application localApplication = AppHelper.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fileSystemInfo_");
      localStringBuilder.append(localAppRuntime.getAccount());
      return localApplication.getSharedPreferences(localStringBuilder.toString(), 4).getString("systemImei", "");
    }
    return "";
  }
  
  private static void initQimeiAsync()
  {
    UserAction.getQimei(new QQDcReporterImpl.2());
  }
  
  private static List<String> mergeParams(String paramString, List<String> paramList)
  {
    if ("3025".equals(paramString))
    {
      paramString = VipComicDataHelper.l.b();
      paramString.a("is_new", 22, "302598765432001");
    }
    else
    {
      paramString = VipComicDataHelper.l;
    }
    return paramString.a(paramList);
  }
  
  public static StringBuilder obtainStringBuilder()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (needGetField.booleanValue())
      {
        stringBuilderValueField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        stringBuilderValueField.setAccessible(true);
        needGetField = Boolean.valueOf(false);
      }
      if (stringBuilderValueField != null) {
        stringBuilderValueField.set(localStringBuilder, stringBuilderCharBuffer.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  private void reportDC00145_2(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    if ((paramString1 != null) && (paramContext != null))
    {
      String str = getNetType();
      updateRes(paramContext);
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
      paramContext[5] = getQimei();
      paramContext = Arrays.asList(new String[] { "1", paramString1, getQimei(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", VipComicDataHelper.e, "", "", paramString2, VipComicDataHelper.a, paramString3, paramString4, paramString5, paramString6, "", "", "8.8.17", "", "", "", "", "", "android", str, res, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8], "", VipComicDataHelper.f, "", "", "" });
      paramString1 = null;
      if ((paramAppInterface instanceof BaseQQAppInterface)) {
        paramString1 = (BaseQQAppInterface)paramAppInterface;
      }
      reportDCEvent(paramString1, "dc00145", paramContext);
      return;
    }
  }
  
  private void reportDCEvent(AppInterface paramAppInterface, String paramString, List<String> paramList)
  {
    if ((paramAppInterface instanceof BaseQQAppInterface))
    {
      reportDCEvent((BaseQQAppInterface)paramAppInterface, "dc00145", paramList);
      return;
    }
    reportDCEvent(null, "dc00145", paramList);
  }
  
  private static void saveSystemImei(String paramString)
  {
    AppRuntime localAppRuntime = AppHelper.b();
    if (localAppRuntime != null)
    {
      Application localApplication = AppHelper.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fileSystemInfo_");
      localStringBuilder.append(localAppRuntime.getAccount());
      localApplication.getSharedPreferences(localStringBuilder.toString(), 4).edit().putString("systemImei", paramString).apply();
      if (QLog.isColorLevel()) {
        QLog.d("VipComicReportUtils", 2, "save system imei success ");
      }
    }
  }
  
  private static void updateRes(Context paramContext)
  {
    if (TextUtils.isEmpty(res))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.widthPixels);
      localStringBuilder.append("*");
      localStringBuilder.append(paramContext.heightPixels);
      res = localStringBuilder.toString();
    }
  }
  
  public String getColdStartImei(Context paramContext)
  {
    if (!StringUtil.isEmpty(systemImei)) {
      return systemImei;
    }
    if ((Build.VERSION.SDK_INT <= 28) && ((Build.VERSION.SDK_INT < 23) || (AppHelper.a().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0))) {
      return getSystemImei(paramContext);
    }
    return getQimei();
  }
  
  @Deprecated
  public String getImei(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    if (TextUtils.isEmpty(imei))
    {
      try
      {
        imei = QQDeviceInfo.getIMEI("2240ca");
      }
      catch (Throwable paramContext)
      {
        QLog.e("VipComicReportUtils", 1, "telephonyManager.getDeviceId encounter error", paramContext);
      }
      if (TextUtils.isEmpty(imei)) {
        imei = getQimei();
      }
      if (imei == null)
      {
        QLog.e("VipComicReportUtils", 1, "getImei finally encounter error and return empty");
        imei = "";
      }
    }
    return imei;
  }
  
  public String getQimei()
  {
    if (TextUtils.isEmpty(qimei)) {
      try
      {
        qimei = AppHelper.a().getSharedPreferences("fileSystemInfo_", 4).getString("qimei_new", "");
        if (TextUtils.isEmpty(qimei)) {
          initQimeiAsync();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VipComicReportUtils", 1, "getQimei error", localThrowable);
      }
    }
    return qimei;
  }
  
  public void reportDC00145(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 != null) && (paramContext != null))
    {
      String str = getNetType();
      updateRes(paramContext);
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
      paramContext[5] = getQimei();
      paramContext = Arrays.asList(new String[] { "1", paramString1, getQimei(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", VipComicDataHelper.e, "", "", paramString2, VipComicDataHelper.a, "", paramString3, paramString4, paramString5, "", "", "8.8.17", "", "", "", "", "", "android", str, res, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8], "", VipComicDataHelper.f, "", "", "" });
      paramString1 = null;
      if ((paramAppInterface instanceof BaseQQAppInterface)) {
        paramString1 = (BaseQQAppInterface)paramAppInterface;
      }
      reportDCEvent(paramString1, "dc00145", paramContext);
      return;
    }
  }
  
  public void reportDC00145(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    reportDC00145(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApplicationContext(), paramString1, paramString2, paramString3, paramString4, paramVarArgs);
  }
  
  public void reportDC00145_2(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    reportDC00145_2(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramAppInterface.getApplicationContext(), paramString1, paramString2, paramString3, paramString4, paramString5, paramVarArgs);
  }
  
  public void reportDC00145_3(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String... paramVarArgs)
  {
    if ((paramAppInterface != null) && (paramAppInterface.getApplicationContext() != null) && (paramAppInterface.getCurrentAccountUin() != null))
    {
      String str = paramAppInterface.getCurrentAccountUin();
      Object localObject1 = paramAppInterface.getApplicationContext();
      Object localObject2 = getNetType();
      updateRes((Context)localObject1);
      localObject1 = new String[10];
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
      localObject1[5] = getQimei();
      if ((TextUtils.isEmpty(localObject1[7])) && (!TextUtils.isEmpty(VipComicDataHelper.j))) {
        localObject1[7] = VipComicDataHelper.j;
      }
      if (TextUtils.isEmpty(VipComicDataHelper.b)) {
        paramVarArgs = "";
      } else {
        paramVarArgs = VipComicDataHelper.b;
      }
      paramString5 = Arrays.asList(new String[] { "1", str, getQimei(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", paramVarArgs, paramString9, "", "", paramString1, paramString5, "", paramString2, paramString3, paramString4, "", "", "8.8.17", "", "", paramString10, "", "", "android", localObject2, res, "", localObject1[0], localObject1[1], localObject1[2], localObject1[3], localObject1[4], localObject1[5], localObject1[6], localObject1[7], localObject1[8], paramString7, paramString8, paramString6, "", "" });
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uin:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("imei:");
        ((StringBuilder)localObject2).append(getQimei());
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("domain:android,");
        ((StringBuilder)localObject2).append("domain_id:201,");
        ((StringBuilder)localObject2).append("biz_id:8001,");
        ((StringBuilder)localObject2).append("biz_subid:8001001,");
        ((StringBuilder)localObject2).append("obj_ownerid:");
        ((StringBuilder)localObject2).append(paramVarArgs);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("objPos:");
        ((StringBuilder)localObject2).append(paramString9);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("pageId:");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("operObjType:");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("operObjId:");
        ((StringBuilder)localObject2).append(paramString3);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("retId:");
        ((StringBuilder)localObject2).append(paramString4);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("sesId:");
        ((StringBuilder)localObject2).append(paramString10);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext1: ,");
        ((StringBuilder)localObject2).append("ext2:");
        ((StringBuilder)localObject2).append(localObject1[0]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext3:");
        ((StringBuilder)localObject2).append(localObject1[1]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext4:");
        ((StringBuilder)localObject2).append(localObject1[2]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext5:");
        ((StringBuilder)localObject2).append(localObject1[3]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext6:");
        ((StringBuilder)localObject2).append(localObject1[4]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext7:");
        ((StringBuilder)localObject2).append(localObject1[5]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext8:");
        ((StringBuilder)localObject2).append(localObject1[6]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext9:");
        ((StringBuilder)localObject2).append(localObject1[7]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("ext10:");
        ((StringBuilder)localObject2).append(localObject1[8]);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("land_page_id:");
        ((StringBuilder)localObject2).append(paramString7);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("detailpage_from:");
        ((StringBuilder)localObject2).append(paramString8);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("algo_id:");
        ((StringBuilder)localObject2).append(paramString6);
        paramString2 = new StringBuilder();
        paramString2.append("dc DC00145_3 detail : ");
        paramString2.append(((StringBuilder)localObject2).toString());
        QLog.d("VipComicReportUtils", 2, paramString2.toString());
      }
      reportDCEvent(paramAppInterface, "dc00145", mergeParams(paramString1, paramString5));
      return;
    }
  }
  
  public void reportDC01327(AppInterface paramAppInterface, VipComicDC01327ReportData paramVipComicDC01327ReportData)
  {
    if (paramAppInterface == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause app == null");
      return;
    }
    Object localObject = paramAppInterface.getApplicationContext();
    if (localObject == null)
    {
      QLog.e("VipComicReportUtils", 2, "reportDC01327 error cause context == null");
      return;
    }
    paramAppInterface = getNetType();
    updateRes((Context)localObject);
    localObject = paramVipComicDC01327ReportData.m();
    localObject[6] = ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).getQimei();
    reportDCEvent(null, "dc01327", Arrays.asList(new String[] { "", "android", "201", Build.VERSION.RELEASE, "", "8.8.17", "android", paramAppInterface, res, paramVipComicDC01327ReportData.p(), paramVipComicDC01327ReportData.s(), paramVipComicDC01327ReportData.a(), "", paramVipComicDC01327ReportData.b(), paramVipComicDC01327ReportData.c(), "", paramVipComicDC01327ReportData.e(), localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8], "", "", VipComicDataHelper.k, paramVipComicDC01327ReportData.j(), "", paramVipComicDC01327ReportData.n(), paramVipComicDC01327ReportData.d(), paramVipComicDC01327ReportData.f(), paramVipComicDC01327ReportData.g(), paramVipComicDC01327ReportData.k(), paramVipComicDC01327ReportData.h(), paramVipComicDC01327ReportData.l(), paramVipComicDC01327ReportData.i(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", localObject[0], localObject[9], paramVipComicDC01327ReportData.o(), "", "", paramVipComicDC01327ReportData.q(), paramVipComicDC01327ReportData.r() }));
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("report dc01327: mod=");
      paramAppInterface.append(VipComicDataHelper.k);
      QLog.i("VipComicReportUtils", 2, paramAppInterface.toString());
    }
  }
  
  public void reportDC01767(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs)
  {
    if ((paramString1 != null) && (paramContext != null))
    {
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
      String str = AppConstants.NET_TYPE_NAME[i];
      if (TextUtils.isEmpty(res))
      {
        paramContext = paramContext.getResources().getDisplayMetrics();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.widthPixels);
        localStringBuilder.append("*");
        localStringBuilder.append(paramContext.heightPixels);
        res = localStringBuilder.toString();
      }
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
      paramContext = Arrays.asList(new String[] { "1", paramString1, getQimei(), "", "android", "201", Build.VERSION.RELEASE, "8001", "8001001", "", "", "", "", "", "", paramString2, "", "", paramString3, paramString4, paramString5, "", "", "8.8.17", "", "", "", "", "", "android", str, res, "", paramContext[0], paramContext[1], paramContext[2], paramContext[3], paramContext[4], paramContext[5], paramContext[6], paramContext[7], paramContext[8], paramContext[9] });
      paramString1 = null;
      if ((paramAppInterface instanceof BaseQQAppInterface)) {
        paramString1 = (BaseQQAppInterface)paramAppInterface;
      }
      reportDCEvent(paramString1, "dc01767", paramContext);
      return;
    }
  }
  
  public void reportDCEvent(BaseQQAppInterface paramBaseQQAppInterface, String paramString, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      StringBuilder localStringBuilder = obtainStringBuilder();
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i));
        if (i < j - 1) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
      paramList = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dcId=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(";detail=");
        localStringBuilder.append(paramList);
        QLog.d("VipComicReportUtils", 2, localStringBuilder.toString());
      }
      DcReportUtil.a(paramBaseQQAppInterface, paramString, paramList);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("params is null, dcId=");
      paramBaseQQAppInterface.append(paramString);
      paramBaseQQAppInterface.append(";detail=");
      paramBaseQQAppInterface.append("");
      QLog.d("VipComicReportUtils", 2, paramBaseQQAppInterface.toString());
    }
  }
  
  public void reportDCSqliteProfile(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    String[] arrayOfString = new String[10];
    System.arraycopy(paramVarArgs, 0, arrayOfString, 0, Math.min(10, paramVarArgs.length));
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i] == null) {
        arrayOfString[i] = "";
      }
      i += 1;
    }
    paramString2 = Arrays.asList(new String[] { "1", String.valueOf(System.currentTimeMillis() / 1000L), "ANDROID", Build.VERSION.RELEASE, paramString1, "8.8.17", paramString2, paramString3, paramString4, paramString5, paramString6, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3], arrayOfString[4], arrayOfString[5], arrayOfString[6], arrayOfString[7], arrayOfString[8], arrayOfString[9] });
    paramString1 = null;
    if ((paramAppInterface instanceof BaseQQAppInterface)) {
      paramString1 = (BaseQQAppInterface)paramAppInterface;
    }
    reportDCEvent(paramString1, "b_sng_qqvip_sqlite_profile_report|sqlite_profile_monitor_report", paramString2);
  }
  
  public void reportTechReport2021(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_sng_qq_comic|qqcomic_tech_report_2021", paramString, true);
    }
  }
  
  public void reportVasStatus(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQDcReporterImpl
 * JD-Core Version:    0.7.0.1
 */