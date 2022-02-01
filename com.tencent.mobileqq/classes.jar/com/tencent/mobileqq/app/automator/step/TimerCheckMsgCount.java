package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgCountChecker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
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
  public static String a = "com.ss.android.article.news";
  public static String b = "com.ss.android.article.lite";
  public static String c = "com.tencent.reading";
  public static String d = "com.tencent.readingplus";
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private final MsgCountChecker jdField_a_of_type_ComTencentImcoreMessageMsgCountChecker = new MsgCountChecker();
  private volatile Runnable jdField_a_of_type_JavaLangRunnable;
  private List<String> jdField_a_of_type_JavaUtilList;
  private long b;
  private String e;
  
  public TimerCheckMsgCount()
  {
    this.jdField_b_of_type_Long = 0L;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/Android");
    localStringBuilder.append(Environment.getDataDirectory());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/cache/hashedimages");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.mAutomator.a != null) {
      this.jdField_a_of_type_AndroidContentContext = this.mAutomator.a.getApp();
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.e = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).checkLastScanTTDate();
    long l1 = System.currentTimeMillis();
    Object localObject1 = c(jdField_a_of_type_JavaLangString);
    Object localObject4 = c(jdField_b_of_type_JavaLangString);
    Object localObject3 = c(c);
    String str = c(d);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Scan Package Time: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      QLog.d("Q.readinjoy.tt_report", 2, ((StringBuilder)localObject2).toString());
    }
    l1 = System.currentTimeMillis();
    long l2 = l1;
    Object localObject5;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      a(new File(a(jdField_a_of_type_JavaLangString)));
      l2 = l1;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty((CharSequence)localObject5))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("tt_product_no", "1");
            localHashMap.put("tt_version_code", localObject1);
            localHashMap.put("tt_report_time", localObject5);
            localHashMap.put("uin", this.mAutomator.a.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { jdField_a_of_type_JavaLangString, " dateString: ", localObject5 });
            }
            StatisticCollector.getInstance(this.mAutomator.a.getApp()).collectPerformance(this.mAutomator.a.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, localHashMap, null, false);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      a(new File(a(jdField_b_of_type_JavaLangString)));
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject5 = new HashMap();
            ((HashMap)localObject5).put("tt_product_no", "0");
            ((HashMap)localObject5).put("tt_version_code", localObject4);
            ((HashMap)localObject5).put("tt_report_time", localObject2);
            ((HashMap)localObject5).put("uin", this.mAutomator.a.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { jdField_b_of_type_JavaLangString, " dateString: ", localObject2 });
            }
            StatisticCollector.getInstance(this.mAutomator.a.getApp()).collectPerformance(this.mAutomator.a.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, (HashMap)localObject5, null, false);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      a(new File(b(c)));
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("kb_product_no", "1");
            ((HashMap)localObject4).put("kb_version_code", localObject3);
            ((HashMap)localObject4).put("kb_report_time", localObject2);
            ((HashMap)localObject4).put("uin", this.mAutomator.a.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { c, " dateString: ", localObject2 });
            }
            StatisticCollector.getInstance(this.mAutomator.a.getApp()).collectPerformance(this.mAutomator.a.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject4, null, false);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(str))
    {
      a(new File(b(d)));
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("kb_product_no", "0");
            ((HashMap)localObject3).put("kb_version_code", str);
            ((HashMap)localObject3).put("kb_report_time", localObject2);
            ((HashMap)localObject3).put("uin", this.mAutomator.a.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { d, " dateString: ", localObject2 });
            }
            StatisticCollector.getInstance(this.mAutomator.a.getApp()).collectPerformance(this.mAutomator.a.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject3, null, false);
          }
        }
      }
    }
    this.jdField_b_of_type_Long = (System.currentTimeMillis() - l2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Scan Directory Time: ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Long);
      QLog.d("Q.readinjoy.tt_report", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new Date();
    Object localObject2 = new SimpleDateFormat("yyyy.MM.dd");
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).setLastScanTTDate(((DateFormat)localObject2).format((Date)localObject1));
    localObject1 = ((DateFormat)localObject2).format((Date)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("uin", this.mAutomator.a.getCurrentAccountUin());
    ((HashMap)localObject2).put("report_time", localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, new Object[] { "uin: ", this.mAutomator.a.getCurrentAccountUin(), ", report_time: ", localObject1 });
    }
    StatisticCollector.getInstance(this.mAutomator.a.getApp()).collectPerformance(this.mAutomator.a.getCurrentAccountUin(), "actReadInJoyReportTTKB", true, 1L, 0L, (HashMap)localObject2, null, false);
  }
  
  private void a(File paramFile)
  {
    try
    {
      paramFile = paramFile.listFiles();
      int j = paramFile.length;
      int i = 0;
      while (i < j)
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
          if (((TextUtils.isEmpty(this.e)) || (((String)localObject).compareTo(this.e) >= 0)) && (!this.jdField_a_of_type_JavaUtilList.contains(localObject))) {
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      QLog.d("Q.readinjoy.tt_report", 1, paramFile.toString());
    }
  }
  
  private String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/Android");
    localStringBuilder.append(Environment.getDataDirectory());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/files/data/news_image");
    return localStringBuilder.toString();
  }
  
  private String c(String paramString)
  {
    try
    {
      paramString = PackageUtil.a(BaseApplicationImpl.getContext(), paramString);
      if (paramString != null)
      {
        paramString = paramString.versionName;
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getAppVersion], e = ");
      localStringBuilder.append(paramString);
      QLog.i("QQInitHandler", 1, localStringBuilder.toString());
    }
    return "null";
  }
  
  protected int doStep()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.i("QQInitHandler", 1, "TimerCheckMsgCount doStep: last task was running");
      return 7;
    }
    TimerCheckMsgCount.1 local1 = new TimerCheckMsgCount.1(this);
    this.jdField_a_of_type_JavaLangRunnable = local1;
    ThreadManager.executeOnNetWorkThread(local1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount
 * JD-Core Version:    0.7.0.1
 */