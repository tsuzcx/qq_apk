package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import azri;
import bhtl;
import bkbq;
import com.tencent.common.app.BaseApplicationImpl;
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
import ord;
import org.w3c.dom.Node;
import ors;

public class ReadInJoyDoingSomething
{
  private static long jdField_a_of_type_Long;
  public static String a;
  private static List<ReadInJoyDoingSomething.AppConfigInfo> jdField_a_of_type_JavaUtilList;
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "cache", "databases", "files", "lib", "shared_prefs" };
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  private static String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "read_in_joy_report_many_apps_key";
    b = "read_in_joy_report_many_apps_last_scan_date_key";
    c = "ReadInJoyDoingSomething";
    d = "actKandianReportManyApps";
    e = "actKandianReportInstalledApps";
    f = "actKandianReportUsedApps";
  }
  
  public static ReadInJoyDoingSomething.AppConfigInfoList a(AppRuntime paramAppRuntime)
  {
    if (bkbq.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(c, 1, "getReadInJoySP failed, can not get config.");
      return null;
    }
    Object localObject = ors.a(paramAppRuntime, jdField_a_of_type_JavaLangString, true);
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
    Object localObject = bkbq.a(ors.a(), true, true);
    if (localObject == null)
    {
      QLog.d(c, 1, "getLastScanDate failed, can not get config.");
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((SharedPreferences)localObject).getString(b, "");
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
    try
    {
      paramString = bhtl.a(BaseApplicationImpl.getContext(), paramString);
      if (paramString != null)
      {
        paramString = paramString.versionName;
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      QLog.i(c, 1, "[getAppVersion], e = " + paramString);
    }
    return "null";
  }
  
  private static List<ord> a(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
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
  
  private static ord a(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
  {
    ord localord = new ord();
    if (paramAppConfigInfo == null)
    {
      QLog.d(c, 1, "getReportData configInfo is null.");
      return localord;
    }
    localord.jdField_a_of_type_JavaLangString = paramAppConfigInfo.appCode;
    localord.b = a(paramAppConfigInfo.appPackageName);
    return localord;
  }
  
  public static void a()
  {
    try
    {
      Object localObject = a(ors.a());
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
    ord localord = a(paramAppConfigInfo);
    if ((paramAppConfigInfo == null) || (TextUtils.isEmpty(paramAppConfigInfo.appPackageName)) || (!bhtl.a(BaseApplicationImpl.getContext(), paramAppConfigInfo.appPackageName)))
    {
      String str;
      if (QLog.isColorLevel())
      {
        str = c;
        if (localord == null) {
          break label71;
        }
      }
      label71:
      for (paramAppConfigInfo = localord.toString();; paramAppConfigInfo = "null")
      {
        QLog.d(str, 2, new Object[] { "user do not install this app or reportData is null, reportData = ", paramAppConfigInfo });
        return;
      }
    }
    if (TextUtils.isEmpty(g))
    {
      paramAppConfigInfo = new Date();
      g = new SimpleDateFormat("yyyy.MM.dd").format(paramAppConfigInfo);
    }
    paramAppConfigInfo = new HashMap();
    paramAppConfigInfo.put("appCode", localord.jdField_a_of_type_JavaLangString);
    paramAppConfigInfo.put("appVersion", localord.b);
    paramAppConfigInfo.put("appScanDate", g);
    paramAppConfigInfo.put("uin", ors.a());
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, new Object[] { "tagName = ", e, "\n", "reportData = \n", localord.toString(), "uin = ", ors.a(), "\n", "appScanDate = ", g, "\n" });
    }
    azri.a(ors.a().getApplication()).a(ors.a(), e, true, 1L, 0L, paramAppConfigInfo, null, false);
  }
  
  private static void a(String paramString, List<ord> paramList, ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
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
        ord localord = a(paramAppConfigInfo);
        localord.c = ((String)localObject);
        paramList.add(localord);
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
  
  private static void a(List<ord> paramList, String paramString)
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
        ord localord = (ord)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, new Object[] { "tagName = ", paramString, ", reportDataList [ ", Integer.valueOf(i), " ] : \n", localord.toString(), "uin = ", ors.a(), "\n" });
        }
        localHashMap.clear();
        localHashMap.put("appCode", localord.jdField_a_of_type_JavaLangString);
        localHashMap.put("appVersion", localord.b);
        localHashMap.put("appUsedDate", localord.c);
        localHashMap.put("uin", ors.a());
        azri.a(ors.a().getApplication()).a(ors.a(), paramString, true, 1L, 0L, localHashMap, null, false);
        i += 1;
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, ReadInJoyDoingSomething.AppConfigInfoList paramAppConfigInfoList)
  {
    if (bkbq.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(c, 1, "getReadInJoySP failed, can not update config.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, new Object[] { "updateConfig, appConfigInfoList = ", paramAppConfigInfoList.toString() });
    }
    ors.a(jdField_a_of_type_JavaLangString, paramAppConfigInfoList, true);
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
    a(ors.a(), localAppConfigInfoList);
  }
  
  private static boolean a(String paramString, List<ord> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (paramString.equals(((ord)paramList.next()).c)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(List<ord> paramList)
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
  }
  
  private static void b(ReadInJoyDoingSomething.AppConfigInfo paramAppConfigInfo)
  {
    int i = 0;
    Object localObject2 = a(paramAppConfigInfo);
    if ((localObject2 == null) || (TextUtils.isEmpty(((ord)localObject2).b)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = c;
        if (localObject2 == null) {
          break label60;
        }
      }
      label60:
      for (paramAppConfigInfo = ((ord)localObject2).toString();; paramAppConfigInfo = "null")
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
            ((ord)localObject3).c = ((String)localObject4);
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
    Object localObject = bkbq.a(ors.a(), true, true);
    if (localObject == null)
    {
      QLog.d(c, 1, "setLastScanDate failed, can not get config.");
      return;
    }
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(b, localSimpleDateFormat.format(localDate));
    bkbq.a((SharedPreferences.Editor)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething
 * JD-Core Version:    0.7.0.1
 */