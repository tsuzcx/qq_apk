package com.tencent.mobileqq.app;

import android.app.Application.ActivityLifecycleCallbacks;
import android.text.TextUtils;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

public class PeakAppCrashReporter
{
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new PeakAppCrashReporter.1(this);
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  public String a()
  {
    QRouteApi localQRouteApi = QRoute.api(IAECameraPrefsUtil.class);
    String str = "";
    if (localQRouteApi != null) {
      str = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_peak_activity_crash_pathinfo", "", 4);
    }
    return str;
  }
  
  public void a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      b(str);
      a("");
    }
    if (BaseApplicationImpl.getApplication() != null)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      QLog.d("PeakAppCrashReporter", 2, "onPeakAppCreated, registerActivityLifecycleCallBacks");
    }
  }
  
  public void a(String paramString)
  {
    if (QRoute.api(IAECameraPrefsUtil.class) != null) {
      ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_peak_activity_crash_pathinfo", paramString, 4);
    }
  }
  
  public void b()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      QLog.d("PeakAppCrashReporter", 2, "onPeakAppDestroyed, unregisterActivityLifecycleCallBacks");
    }
    a("");
  }
  
  public void b(String paramString)
  {
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PEAK_CRASH_PATHINFO, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ext1", paramString) }));
  }
  
  public void c()
  {
    a("");
    StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.delete(0, localStringBuilder.length());
  }
  
  public void d()
  {
    a(this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppCrashReporter
 * JD-Core Version:    0.7.0.1
 */