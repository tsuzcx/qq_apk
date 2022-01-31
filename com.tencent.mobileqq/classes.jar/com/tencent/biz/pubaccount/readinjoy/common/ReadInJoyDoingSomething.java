package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import awrn;
import bgmq;
import com.tencent.qphone.base.util.QLog;
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
import obk;
import obz;
import org.w3c.dom.Node;

public class ReadInJoyDoingSomething
{
  private static long jdField_a_of_type_Long;
  public static String a;
  private static List<ReadInJoyDoingSomething.AppConfigInfo> jdField_a_of_type_JavaUtilList;
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "cache", "databases", "files", "lib", "shared_prefs" };
  public static String b;
  private static List<PackageInfo> b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  private static String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "read_in_joy_report_many_apps_key";
    jdField_b_of_type_JavaLangString = "read_in_joy_report_many_apps_last_scan_date_key";
    c = "ReadInJoyDoingSomething";
    d = "actKandianReportManyApps";
    e = "actKandianReportInstalledApps";
    f = "actKandianReportUsedApps";
  }
  
  public static ReadInJoyDoingSomething.AppConfigInfoList a(AppRuntime paramAppRuntime)
  {
    if (bgmq.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(c, 1, "getReadInJoySP failed, can not get config.");
      return null;
    }
    Object localObject = obz.a(paramAppRuntime, jdField_a_of_type_JavaLangString, true);
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
      return (ReadInJoyDoingSomething.AppConfigInfoList)localObject;
    }
  }
  
  private static String a()
  {
    Object localObject = bgmq.a(obz.a(), true, true);
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
  
  private static String a(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
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
        jdField_b_of_type_JavaUtilList = obz.a().getApplication().getPackageManager().getInstalledPackages(0);
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
  
  private static List<obk> a(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
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
  
  private static obk a(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
  {
    obk localobk = new obk();
    if (paramAppConfigInfo == null)
    {
      QLog.d(c, 1, "getReportData configInfo is null.");
      return localobk;
    }
    localobk.jdField_a_of_type_JavaLangString = paramAppConfigInfo.appCode;
    localobk.jdField_b_of_type_JavaLangString = a(paramAppConfigInfo.appPackageName);
    return localobk;
  }
  
  public static void a()
  {
    try
    {
      Object localObject = a(obz.a());
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(c, 2, "config is null, no need to report.");
        return;
      }
      h = a();
      jdField_a_of_type_JavaUtilList = ((ReadInJoyDoingSomething.AppConfigInfoList)localObject).list;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ReadInJoyDoingSomething.AppConfigInfo localAppConfigInfo = (ReadInJoyDoingSomething.AppConfigInfo)((Iterator)localObject).next();
        a(localAppConfigInfo);
        a(a(localAppConfigInfo), d);
        b(localAppConfigInfo);
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
  
  private static void a(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
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
    if (TextUtils.isEmpty(g))
    {
      localObject = new Date();
      g = new SimpleDateFormat("yyyy.MM.dd").format((Date)localObject);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("appCode", paramAppConfigInfo.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("appVersion", paramAppConfigInfo.jdField_b_of_type_JavaLangString);
    ((HashMap)localObject).put("appScanDate", g);
    ((HashMap)localObject).put("uin", obz.a());
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, new Object[] { "tagName = ", e, "\n", "reportData = \n", paramAppConfigInfo.toString(), "uin = ", obz.a(), "\n", "appScanDate = ", g, "\n" });
    }
    awrn.a(obz.a().getApplication()).a(obz.a(), e, true, 1L, 0L, (HashMap)localObject, null, false);
  }
  
  private static void a(String paramString, List<obk> paramList, ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
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
      if (((TextUtils.isEmpty(h)) || (((String)localObject).compareTo(h) >= 0)) && (!a((String)localObject, paramList)))
      {
        obk localobk = a(paramAppConfigInfo);
        localobk.c = ((String)localObject);
        paramList.add(localobk);
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
  
  private static void a(List<obk> paramList, String paramString)
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
        obk localobk = (obk)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, new Object[] { "tagName = ", paramString, ", reportDataList [ ", Integer.valueOf(i), " ] : \n", localobk.toString(), "uin = ", obz.a(), "\n" });
        }
        localHashMap.clear();
        localHashMap.put("appCode", localobk.jdField_a_of_type_JavaLangString);
        localHashMap.put("appVersion", localobk.jdField_b_of_type_JavaLangString);
        localHashMap.put("appUsedDate", localobk.c);
        localHashMap.put("uin", obz.a());
        awrn.a(obz.a().getApplication()).a(obz.a(), paramString, true, 1L, 0L, localHashMap, null, false);
        i += 1;
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, ReadInJoyDoingSomething.AppConfigInfoList paramAppConfigInfoList)
  {
    if (bgmq.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(c, 1, "getReadInJoySP failed, can not update config.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, new Object[] { "updateConfig, appConfigInfoList = ", paramAppConfigInfoList.toString() });
    }
    obz.a(jdField_a_of_type_JavaLangString, paramAppConfigInfoList, true);
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
    ReadInJoyDoingSomething.AppConfigInfoList localAppConfigInfoList;
    label280:
    for (;;)
    {
      Node localNode1;
      ReadInJoyDoingSomething.AppConfigInfo localAppConfigInfo;
      String str1;
      String str2;
      try
      {
        localAppConfigInfoList = new ReadInJoyDoingSomething.AppConfigInfoList();
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
        localAppConfigInfo = new ReadInJoyDoingSomething.AppConfigInfo();
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
    a(obz.a(), localAppConfigInfoList);
  }
  
  private static boolean a(String paramString, List<obk> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (paramString.equals(((obk)paramList.next()).c)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(List<obk> paramList)
  {
    boolean bool = true;
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(h))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        Object localObject = new SimpleDateFormat("yyyy.MM.dd");
        Date localDate = new Date();
        localObject = ((DateFormat)localObject).parse(h);
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
  
  private static void b(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
  {
    int i = 0;
    Object localObject2 = a(paramAppConfigInfo);
    if ((localObject2 == null) || (TextUtils.isEmpty(((obk)localObject2).jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = c;
        if (localObject2 == null) {
          break label60;
        }
      }
      label60:
      for (paramAppConfigInfo = ((obk)localObject2).toString();; paramAppConfigInfo = "null")
      {
        QLog.d((String)localObject1, 2, new Object[] { "user do not install this app or reportData is null, reportData = ", paramAppConfigInfo });
        return;
      }
    }
    Object localObject1 = new ArrayList();
    localObject2 = new SimpleDateFormat("yyyy.MM.dd");
    for (;;)
    {
      if (i >= jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label307;
      }
      Object localObject3 = new StringBuilder("/data/data/");
      ((StringBuilder)localObject3).append(paramAppConfigInfo.appPackageName).append("/").append(jdField_a_of_type_ArrayOfJavaLangString[i]);
      try
      {
        Object localObject4 = new File(((StringBuilder)localObject3).toString());
        if (((File)localObject4).exists())
        {
          localObject4 = ((DateFormat)localObject2).format(new Date(((File)localObject4).lastModified()));
          QLog.d(c, 2, new Object[] { "reportUsedApps path = ", localObject3, ", app = ", paramAppConfigInfo.appPackageName, ", lastModifiedDate = ", localObject4, ", lastScan = ", h });
          if (((TextUtils.isEmpty(h)) || (((String)localObject4).compareTo(h) >= 0)) && (!a((String)localObject4, (List)localObject1)))
          {
            localObject3 = a(paramAppConfigInfo);
            ((obk)localObject3).c = ((String)localObject4);
            ((List)localObject1).add(localObject3);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          QLog.d(c, 1, "reportUsedApps throw Throwable.");
        }
      }
      i += 1;
    }
    label307:
    a((List)localObject1, f);
  }
  
  private static void c()
  {
    Object localObject = bgmq.a(obz.a(), true, true);
    if (localObject == null)
    {
      QLog.d(c, 1, "setLastScanDate failed, can not get config.");
      return;
    }
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(jdField_b_of_type_JavaLangString, localSimpleDateFormat.format(localDate));
    bgmq.a((SharedPreferences.Editor)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething
 * JD-Core Version:    0.7.0.1
 */