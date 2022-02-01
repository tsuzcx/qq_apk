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
  private Context e;
  private List<String> f;
  private String g;
  private long h = 0L;
  private long i = 0L;
  private volatile Runnable j;
  private final MsgCountChecker k = new MsgCountChecker();
  
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
    if (this.mAutomator.k != null) {
      this.e = this.mAutomator.k.getApp();
    }
    this.f = new ArrayList();
    this.g = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).checkLastScanTTDate();
    long l1 = System.currentTimeMillis();
    Object localObject1 = c(a);
    Object localObject4 = c(b);
    Object localObject3 = c(c);
    String str = c(d);
    this.h = (System.currentTimeMillis() - l1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Scan Package Time: ");
      ((StringBuilder)localObject2).append(this.h);
      QLog.d("Q.readinjoy.tt_report", 2, ((StringBuilder)localObject2).toString());
    }
    l1 = System.currentTimeMillis();
    long l2 = l1;
    Object localObject5;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      a(new File(a(a)));
      l2 = l1;
      if (!this.f.isEmpty())
      {
        localObject2 = this.f.iterator();
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
            localHashMap.put("uin", this.mAutomator.k.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { a, " dateString: ", localObject5 });
            }
            StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(this.mAutomator.k.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, localHashMap, null, false);
          }
        }
      }
    }
    this.f.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      a(new File(a(b)));
      if (!this.f.isEmpty())
      {
        localObject1 = this.f.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject5 = new HashMap();
            ((HashMap)localObject5).put("tt_product_no", "0");
            ((HashMap)localObject5).put("tt_version_code", localObject4);
            ((HashMap)localObject5).put("tt_report_time", localObject2);
            ((HashMap)localObject5).put("uin", this.mAutomator.k.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { b, " dateString: ", localObject2 });
            }
            StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(this.mAutomator.k.getCurrentAccountUin(), "actReadInJoyReportTT", true, 1L, 0L, (HashMap)localObject5, null, false);
          }
        }
      }
    }
    this.f.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      a(new File(b(c)));
      if (!this.f.isEmpty())
      {
        localObject1 = this.f.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("kb_product_no", "1");
            ((HashMap)localObject4).put("kb_version_code", localObject3);
            ((HashMap)localObject4).put("kb_report_time", localObject2);
            ((HashMap)localObject4).put("uin", this.mAutomator.k.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { c, " dateString: ", localObject2 });
            }
            StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(this.mAutomator.k.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject4, null, false);
          }
        }
      }
    }
    this.f.clear();
    if (!TextUtils.isEmpty(str))
    {
      a(new File(b(d)));
      if (!this.f.isEmpty())
      {
        localObject1 = this.f.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("kb_product_no", "0");
            ((HashMap)localObject3).put("kb_version_code", str);
            ((HashMap)localObject3).put("kb_report_time", localObject2);
            ((HashMap)localObject3).put("uin", this.mAutomator.k.getCurrentAccountUin());
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.tt_report", 2, new Object[] { d, " dateString: ", localObject2 });
            }
            StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(this.mAutomator.k.getCurrentAccountUin(), "actReadInJoyReportKB", true, 1L, 0L, (HashMap)localObject3, null, false);
          }
        }
      }
    }
    this.i = (System.currentTimeMillis() - l2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Scan Directory Time: ");
      ((StringBuilder)localObject1).append(this.i);
      QLog.d("Q.readinjoy.tt_report", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new Date();
    Object localObject2 = new SimpleDateFormat("yyyy.MM.dd");
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).setLastScanTTDate(((DateFormat)localObject2).format((Date)localObject1));
    localObject1 = ((DateFormat)localObject2).format((Date)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("uin", this.mAutomator.k.getCurrentAccountUin());
    ((HashMap)localObject2).put("report_time", localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.tt_report", 2, new Object[] { "uin: ", this.mAutomator.k.getCurrentAccountUin(), ", report_time: ", localObject1 });
    }
    StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(this.mAutomator.k.getCurrentAccountUin(), "actReadInJoyReportTTKB", true, 1L, 0L, (HashMap)localObject2, null, false);
  }
  
  private void a(File paramFile)
  {
    try
    {
      paramFile = paramFile.listFiles();
      int n = paramFile.length;
      int m = 0;
      while (m < n)
      {
        File localFile = paramFile[m];
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
          if (((TextUtils.isEmpty(this.g)) || (((String)localObject).compareTo(this.g) >= 0)) && (!this.f.contains(localObject))) {
            this.f.add(localObject);
          }
        }
        m += 1;
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
      paramString = PackageUtil.b(BaseApplicationImpl.getContext(), paramString);
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
    if (this.j != null)
    {
      QLog.i("QQInitHandler", 1, "TimerCheckMsgCount doStep: last task was running");
      return 7;
    }
    TimerCheckMsgCount.1 local1 = new TimerCheckMsgCount.1(this);
    this.j = local1;
    ThreadManager.executeOnNetWorkThread(local1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount
 * JD-Core Version:    0.7.0.1
 */