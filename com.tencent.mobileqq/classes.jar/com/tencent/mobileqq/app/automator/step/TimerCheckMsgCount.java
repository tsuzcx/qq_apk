package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import azri;
import bhtl;
import bkbq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TimerCheckMsgCount
  extends AsyncStep
{
  public static String b = "com.ss.android.article.news";
  public static String c;
  public static String d = "com.tencent.reading";
  public static String e = "com.tencent.readingplus";
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList;
  private long c;
  private String f;
  
  static
  {
    jdField_c_of_type_JavaLangString = "com.ss.android.article.lite";
  }
  
  private String a(String paramString)
  {
    return Environment.getExternalStorageDirectory().getPath() + "/Android" + Environment.getDataDirectory() + "/" + paramString + "/cache/hashedimages";
  }
  
  private void a(File paramFile)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramFile = paramFile.listFiles();
        int j = paramFile.length;
        if (i < j)
        {
          File localFile = paramFile[i];
          if (localFile.isDirectory())
          {
            a(localFile);
          }
          else if (localFile.isFile())
          {
            Object localObject = new Date(localFile.lastModified());
            localObject = new SimpleDateFormat("yyyy.MM.dd").format((Date)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { "filePath: ", localFile.getPath(), ", time: ", localObject });
            }
            if (((TextUtils.isEmpty(this.f)) || (((String)localObject).compareTo(this.f) >= 0)) && (!this.jdField_a_of_type_JavaUtilList.contains(localObject))) {
              this.jdField_a_of_type_JavaUtilList.add(localObject);
            }
          }
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        QLog.d("Q.readinjoy.tt_report", 1, paramFile.toString());
      }
      return;
      i += 1;
    }
  }
  
  private String b(String paramString)
  {
    return Environment.getExternalStorageDirectory().getPath() + "/Android" + Environment.getDataDirectory() + "/" + paramString + "/files/data/news_image";
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app != null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp();
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.f = bkbq.b(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
    long l = System.currentTimeMillis();
    Object localObject4 = c(b);
    Object localObject3 = c(jdField_c_of_type_JavaLangString);
    Object localObject2 = c(d);
    Object localObject1 = c(e);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, "Scan Package Time: " + this.jdField_a_of_type_Long);
    }
    l = System.currentTimeMillis();
    Object localObject5;
    Object localObject6;
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      a(new File(a(b)));
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject5 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (String)((Iterator)localObject5).next();
          if (!TextUtils.isEmpty((CharSequence)localObject6))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("tt_product_no", "1");
            localHashMap.put("tt_version_code", localObject4);
            localHashMap.put("tt_report_time", localObject6);
            localHashMap.put("uin", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { b, " dateString: ", localObject6 });
            }
            azri.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, localHashMap, null, false);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      a(new File(a(jdField_c_of_type_JavaLangString)));
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            localObject6 = new HashMap();
            ((HashMap)localObject6).put("tt_product_no", "0");
            ((HashMap)localObject6).put("tt_version_code", localObject3);
            ((HashMap)localObject6).put("tt_report_time", localObject5);
            ((HashMap)localObject6).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { jdField_c_of_type_JavaLangString, " dateString: ", localObject5 });
            }
            azri.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, (HashMap)localObject6, null, false);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      a(new File(b(d)));
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject5 = new HashMap();
            ((HashMap)localObject5).put("kb_product_no", "1");
            ((HashMap)localObject5).put("kb_version_code", localObject2);
            ((HashMap)localObject5).put("kb_report_time", localObject4);
            ((HashMap)localObject5).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { d, " dateString: ", localObject4 });
            }
            azri.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject5, null, false);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      a(new File(b(e)));
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("kb_product_no", "0");
            ((HashMap)localObject4).put("kb_version_code", localObject1);
            ((HashMap)localObject4).put("kb_report_time", localObject3);
            ((HashMap)localObject4).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { e, " dateString: ", localObject3 });
            }
            azri.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject4, null, false);
          }
        }
      }
    }
    this.jdField_c_of_type_Long = (System.currentTimeMillis() - l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, "Scan Directory Time: " + this.jdField_c_of_type_Long);
    }
    localObject1 = new Date();
    localObject2 = new SimpleDateFormat("yyyy.MM.dd");
    bkbq.c(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, ((DateFormat)localObject2).format((Date)localObject1));
    localObject1 = ((DateFormat)localObject2).format((Date)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin());
    ((HashMap)localObject2).put("report_time", localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, new Object[] { "uin: ", this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin(), ", report_time: ", localObject1 });
    }
    azri.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin(), "actReadInJoyReportTTKB", true, 1L, 0L, (HashMap)localObject2, null, false);
  }
  
  private String c(String paramString)
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
      QLog.i("QQInitHandler", 1, "[getAppVersion], e = " + paramString);
    }
    return "null";
  }
  
  public int a()
  {
    ThreadManager.executeOnNetWorkThread(new TimerCheckMsgCount.1(this));
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount
 * JD-Core Version:    0.7.0.1
 */