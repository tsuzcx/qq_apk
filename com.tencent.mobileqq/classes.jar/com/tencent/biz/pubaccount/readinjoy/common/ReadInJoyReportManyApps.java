package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.w3c.dom.Node;

public class ReadInJoyReportManyApps
{
  private static long jdField_a_of_type_Long;
  public static String a;
  private static List jdField_a_of_type_JavaUtilList;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static String b;
  private static List b;
  public static String c = "ReadInJoyReportManyApps";
  public static String d = "actKandianReportManyApps";
  public static String e = "actKandianReportInstalledApps";
  public static String f;
  private static String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "read_in_joy_report_many_apps_key";
    jdField_b_of_type_JavaLangString = "read_in_joy_report_many_apps_last_scan_date_key";
  }
  
  public static ReadInJoyReportManyApps.AppConfigInfoList a(AppRuntime paramAppRuntime)
  {
    if (ReadInJoyHelper.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(c, 1, "getReadInJoySP failed, can not get config.");
      return null;
    }
    Object localObject = ReadInJoyUtils.a(paramAppRuntime, jdField_a_of_type_JavaLangString, true);
    String str;
    if (QLog.isColorLevel())
    {
      str = c;
      if (localObject == null) {
        break label71;
      }
    }
    label71:
    for (paramAppRuntime = localObject.toString();; paramAppRuntime = "null")
    {
      QLog.d(str, 2, new Object[] { "config: \n", paramAppRuntime });
      return (ReadInJoyReportManyApps.AppConfigInfoList)localObject;
    }
  }
  
  private static ReadInJoyReportManyApps.AppReportData a(ReadInJoyReportManyApps.AppConfigInfo paramAppConfigInfo)
  {
    ReadInJoyReportManyApps.AppReportData localAppReportData = new ReadInJoyReportManyApps.AppReportData();
    if (paramAppConfigInfo == null)
    {
      QLog.d(c, 1, "getReportData configInfo is null.");
      return localAppReportData;
    }
    localAppReportData.jdField_a_of_type_JavaLangString = paramAppConfigInfo.appCode;
    localAppReportData.jdField_b_of_type_JavaLangString = a(paramAppConfigInfo.appPackageName);
    return localAppReportData;
  }
  
  private static String a()
  {
    Object localObject = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, true);
    if (localObject == null)
    {
      QLog.d(c, 1, "getLastScanDate failed, can not get config.");
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((SharedPreferences)localObject).getString(jdField_b_of_type_JavaLangString, "");
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d(c, 2, new Object[] { "lastScanDate = ", str });
    return str;
  }
  
  private static String a(ReadInJoyReportManyApps.AppConfigInfo paramAppConfigInfo)
  {
    Object localObject;
    if (paramAppConfigInfo == null)
    {
      QLog.d(c, 1, "configInfo is null.");
      localObject = "";
      return localObject;
    }
    if (paramAppConfigInfo.isAbsolutePath) {}
    for (paramAppConfigInfo = paramAppConfigInfo.appPath;; paramAppConfigInfo = Environment.getExternalStorageDirectory().getPath() + "/Android" + Environment.getDataDirectory() + "/" + paramAppConfigInfo.appPackageName + paramAppConfigInfo.appPath)
    {
      localObject = paramAppConfigInfo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(c, 2, new Object[] { "path = ", paramAppConfigInfo });
      return paramAppConfigInfo;
    }
  }
  
  private static String a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    String str = (String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    Object localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = str;
    }
    try
    {
      if (jdField_b_of_type_JavaUtilList != null)
      {
        localObject2 = str;
        if (jdField_b_of_type_JavaUtilList.size() > 0) {}
      }
      else
      {
        localObject2 = str;
        jdField_b_of_type_JavaUtilList = ReadInJoyUtils.a().getApplication().getPackageManager().getInstalledPackages(0);
      }
      localObject2 = str;
      Iterator localIterator = jdField_b_of_type_JavaUtilList.iterator();
      do
      {
        localObject1 = str;
        localObject2 = str;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = str;
        localObject1 = (PackageInfo)localIterator.next();
        localObject2 = str;
      } while (!TextUtils.equals(((PackageInfo)localObject1).packageName, paramString));
      localObject2 = str;
      Object localObject1 = ((PackageInfo)localObject1).versionName;
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        localObject2 = localObject1;
      }
      return localObject2;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.d(c, 1, "getAppVersion throwable.");
    }
    return localObject2;
  }
  
  private static List a(ReadInJoyReportManyApps.AppConfigInfo paramAppConfigInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramAppConfigInfo == null) {
      QLog.d(c, 2, "getReportDataList configInfo is null.");
    }
    do
    {
      String str;
      do
      {
        return localArrayList;
        str = a(paramAppConfigInfo);
      } while (TextUtils.isEmpty(str));
      jdField_a_of_type_Long = System.currentTimeMillis();
      a(str, localArrayList, paramAppConfigInfo);
    } while (!QLog.isColorLevel());
    QLog.d(c, 2, new Object[] { "getReportDataList, totalScanTime = ", Long.valueOf(System.currentTimeMillis() - jdField_a_of_type_Long), " ms." });
    return localArrayList;
  }
  
  public static void a()
  {
    try
    {
      Object localObject = a(ReadInJoyUtils.a());
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(c, 2, "config is null, no need to report.");
        return;
      }
      g = a();
      jdField_a_of_type_JavaUtilList = ((ReadInJoyReportManyApps.AppConfigInfoList)localObject).list;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReadInJoyReportManyApps.AppConfigInfo localAppConfigInfo = (ReadInJoyReportManyApps.AppConfigInfo)((Iterator)localObject).next();
        a(localAppConfigInfo);
        a(a(localAppConfigInfo));
      }
      c();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d(c, 1, "reportManyAppsData throwable, so sad.");
      return;
    }
    b();
  }
  
  private static void a(ReadInJoyReportManyApps.AppConfigInfo paramAppConfigInfo)
  {
    paramAppConfigInfo = a(paramAppConfigInfo);
    if ((paramAppConfigInfo == null) || (TextUtils.isEmpty(paramAppConfigInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        localObject = c;
        if (paramAppConfigInfo == null) {
          break label58;
        }
      }
      label58:
      for (paramAppConfigInfo = paramAppConfigInfo.toString();; paramAppConfigInfo = "null")
      {
        QLog.d((String)localObject, 2, new Object[] { "user do not install this app or reportData is null, reportData = ", paramAppConfigInfo });
        return;
      }
    }
    if (TextUtils.isEmpty(f))
    {
      localObject = new Date();
      f = new SimpleDateFormat("yyyy.MM.dd").format((Date)localObject);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("appCode", paramAppConfigInfo.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("appVersion", paramAppConfigInfo.jdField_b_of_type_JavaLangString);
    ((HashMap)localObject).put("appScanDate", f);
    ((HashMap)localObject).put("uin", ReadInJoyUtils.a());
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, new Object[] { "tagName = ", e, "\n", "reportData = \n", paramAppConfigInfo.toString(), "uin = ", ReadInJoyUtils.a(), "\n", "appScanDate = ", f, "\n" });
    }
    StatisticCollector.a(ReadInJoyUtils.a().getApplication()).a(ReadInJoyUtils.a(), e, true, 1L, 0L, (HashMap)localObject, null, false);
  }
  
  private static void a(String paramString, List paramList, ReadInJoyReportManyApps.AppConfigInfo paramAppConfigInfo)
  {
    int j = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramList == null))
    {
      QLog.d(c, 1, "path or list is null, no need to scan.");
      return;
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long > 10000L)
    {
      QLog.d(c, 1, "scan one path more than one minute, it is time to stop");
      return;
    }
    if (a(paramList))
    {
      QLog.d(c, 1, "report data is enough, no need to scan any more.");
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        paramString = new File(paramString).listFiles();
        if (QLog.isColorLevel())
        {
          str = c;
          if (paramString != null)
          {
            i = paramString.length;
            QLog.d(str, 2, new Object[] { "files number = ", Integer.valueOf(i) });
          }
        }
        else
        {
          if (paramString == null) {
            break;
          }
          int k = paramString.length;
          i = j;
          if (i >= k) {
            break;
          }
          str = paramString[i];
          if (System.currentTimeMillis() - jdField_a_of_type_Long <= 10000L) {
            break label189;
          }
          QLog.d(c, 1, "scan one path more than one minute, it is time to stop");
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.d(c, 1, "scanPath throw Throwable.");
        return;
      }
      int i = 0;
      continue;
      label189:
      Object localObject = new Date(str.lastModified());
      localObject = new SimpleDateFormat("yyyy.MM.dd").format((Date)localObject);
      if (((TextUtils.isEmpty(g)) || (((String)localObject).compareTo(g) >= 0)) && (!a((String)localObject, paramList)))
      {
        ReadInJoyReportManyApps.AppReportData localAppReportData = a(paramAppConfigInfo);
        localAppReportData.c = ((String)localObject);
        paramList.add(localAppReportData);
        if (a(paramList))
        {
          QLog.d(c, 1, "report data is enough, no need to scan any more.");
          return;
        }
      }
      if (str.isDirectory()) {
        a(str.getPath(), paramList, paramAppConfigInfo);
      }
      i += 1;
    }
  }
  
  private static void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.d(c, 1, "reportData but list is null or empty.");
    }
    for (;;)
    {
      return;
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < paramList.size())
      {
        ReadInJoyReportManyApps.AppReportData localAppReportData = (ReadInJoyReportManyApps.AppReportData)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, new Object[] { "tagName = ", d, ", reportDataList [ ", Integer.valueOf(i), " ] : \n", localAppReportData.toString(), "uin = ", ReadInJoyUtils.a(), "\n" });
        }
        localHashMap.clear();
        localHashMap.put("appCode", localAppReportData.jdField_a_of_type_JavaLangString);
        localHashMap.put("appVersion", localAppReportData.jdField_b_of_type_JavaLangString);
        localHashMap.put("appUsedDate", localAppReportData.c);
        localHashMap.put("uin", ReadInJoyUtils.a());
        StatisticCollector.a(ReadInJoyUtils.a().getApplication()).a(ReadInJoyUtils.a(), d, true, 1L, 0L, localHashMap, null, false);
        i += 1;
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, ReadInJoyReportManyApps.AppConfigInfoList paramAppConfigInfoList)
  {
    if (ReadInJoyHelper.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(c, 1, "getReadInJoySP failed, can not update config.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, new Object[] { "updateConfig, appConfigInfoList = ", paramAppConfigInfoList.toString() });
    }
    ReadInJoyUtils.a(jdField_a_of_type_JavaLangString, paramAppConfigInfoList, true);
  }
  
  public static void a(Node paramNode)
  {
    if (paramNode == null)
    {
      QLog.d(c, 1, "config node is null or empty, no need to parse.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "parseConfigToSP.");
    }
    ReadInJoyReportManyApps.AppConfigInfoList localAppConfigInfoList;
    label280:
    for (;;)
    {
      Node localNode1;
      ReadInJoyReportManyApps.AppConfigInfo localAppConfigInfo;
      String str1;
      String str2;
      try
      {
        localAppConfigInfoList = new ReadInJoyReportManyApps.AppConfigInfoList();
        paramNode = paramNode.getFirstChild();
        if (paramNode == null) {
          break;
        }
        if (!paramNode.getNodeName().equals("appLists")) {
          break label344;
        }
        localNode1 = paramNode.getFirstChild();
        if (localNode1 == null) {
          break label344;
        }
        localAppConfigInfo = new ReadInJoyReportManyApps.AppConfigInfo();
        Node localNode2 = localNode1.getFirstChild();
        if (localNode2 == null) {
          break label280;
        }
        if (localNode2.getNodeType() == 1)
        {
          str1 = localNode2.getNodeName();
          str2 = localNode2.getFirstChild().getNodeValue();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {}
        }
        else
        {
          localNode2 = localNode2.getNextSibling();
          continue;
        }
        if (str1.equals("appCode"))
        {
          localAppConfigInfo.appCode = str2;
          continue;
        }
        if (!str1.equals("appName")) {
          break label211;
        }
      }
      catch (Throwable paramNode)
      {
        paramNode.printStackTrace();
        QLog.d(c, 1, "parseConfigToSP failed, throw a throwable.");
        return;
      }
      localAppConfigInfo.appName = str2;
      continue;
      label211:
      if (str1.equals("appPackageName"))
      {
        localAppConfigInfo.appPackageName = str2;
      }
      else if (str1.equals("appPath"))
      {
        localAppConfigInfo.appPath = str2;
      }
      else if (str1.equals("isAbsolutePath"))
      {
        localAppConfigInfo.isAbsolutePath = str2.equals("1");
        continue;
        if (!TextUtils.isEmpty(localAppConfigInfo.appCode))
        {
          localAppConfigInfoList.list.add(localAppConfigInfo);
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, new Object[] { "appConfigInfo = ", localAppConfigInfo.toString() });
          }
        }
        localNode1 = localNode1.getNextSibling();
        continue;
        label344:
        paramNode = paramNode.getNextSibling();
      }
    }
    a(ReadInJoyUtils.a(), localAppConfigInfoList);
  }
  
  private static boolean a(String paramString, List paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (paramString.equals(((ReadInJoyReportManyApps.AppReportData)paramList.next()).c)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(List paramList)
  {
    boolean bool = true;
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(g))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        Object localObject = new SimpleDateFormat("yyyy.MM.dd");
        Date localDate = new Date();
        localObject = ((DateFormat)localObject).parse(g);
        long l1 = localDate.getTime();
        long l2 = ((Date)localObject).getTime();
        l1 = TimeUnit.DAYS.convert(l1 - l2, TimeUnit.MILLISECONDS);
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, new Object[] { "list size = ", Integer.valueOf(paramList.size()), ", day = ", Long.valueOf(l1 + 1L) });
        }
        int i = paramList.size();
        if (i >= l1 + 1L) {}
      }
      catch (Throwable paramList)
      {
        for (;;)
        {
          paramList.printStackTrace();
          QLog.d(c, 1, "checkIsReportDataIsEnough throw a throwable.");
        }
      }
    }
    return false;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilList != null) {
      jdField_a_of_type_JavaUtilList.clear();
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (jdField_b_of_type_JavaUtilList != null) {
      jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  private static void c()
  {
    Object localObject = ReadInJoyHelper.a(ReadInJoyUtils.a(), true, true);
    if (localObject == null)
    {
      QLog.d(c, 1, "setLastScanDate failed, can not get config.");
      return;
    }
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(jdField_b_of_type_JavaLangString, localSimpleDateFormat.format(localDate));
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyReportManyApps
 * JD-Core Version:    0.7.0.1
 */