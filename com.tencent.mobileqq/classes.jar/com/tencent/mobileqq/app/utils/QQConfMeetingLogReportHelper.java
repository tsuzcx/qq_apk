package com.tencent.mobileqq.app.utils;

import android.text.format.Time;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class QQConfMeetingLogReportHelper
{
  static QQConfMeetingLogReportHelper jdField_a_of_type_ComTencentMobileqqAppUtilsQQConfMeetingLogReportHelper;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener = new QQConfMeetingLogReportHelper.1(this);
  ShareAppLogHelper jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference = null;
  
  QQConfMeetingLogReportHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static QQConfMeetingLogReportHelper a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqAppUtilsQQConfMeetingLogReportHelper = new QQConfMeetingLogReportHelper(paramQQAppInterface);
    return jdField_a_of_type_ComTencentMobileqqAppUtilsQQConfMeetingLogReportHelper;
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendFile begin, path[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], Thread[");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("]");
    QLog.w("QQConfMeetingLogReportHelper", 1, localStringBuilder.toString());
    ThreadManager.post(new QQConfMeetingLogReportHelper.2(this, paramString), 2, null, true);
  }
  
  protected int a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.hour;
  }
  
  protected String a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localTime.year);
    localStringBuilder.append("-");
    localStringBuilder.append(localTime.month + 1);
    localStringBuilder.append("-");
    localStringBuilder.append(localTime.monthDay);
    return localStringBuilder.toString();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    long l2 = System.currentTimeMillis();
    long l1 = paramLong1;
    if (paramLong2 - paramLong1 < 1800000L) {
      l1 = paramLong2 - 1800000L;
    }
    Object localObject3 = String.format("%02d", new Object[] { Integer.valueOf(a(l1)) });
    Object localObject1 = String.format("%02d", new Object[] { Integer.valueOf(a(paramLong2)) });
    Object localObject4 = a(l1);
    Object localObject2 = a(paramLong2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject4);
    localStringBuilder.append("-");
    localStringBuilder.append((String)localObject3);
    localObject3 = ShareAppLogHelper.a(localStringBuilder.toString(), "-");
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append("-");
    ((StringBuilder)localObject4).append((String)localObject1);
    localObject1 = ShareAppLogHelper.a(((StringBuilder)localObject4).toString(), "-");
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper = new ShareAppLogHelper(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplication().getBaseContext());
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a((Time)localObject3, (Time)localObject1, true);
    paramLong1 = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doReportLocalLog, ret[");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("], startTime[");
    ((StringBuilder)localObject2).append(localObject3);
    ((StringBuilder)localObject2).append("], endTime[");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("], cost[");
    ((StringBuilder)localObject2).append(paramLong1 - l2);
    ((StringBuilder)localObject2).append("]");
    QLog.w("QQConfMeetingLogReportHelper", 1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper
 * JD-Core Version:    0.7.0.1
 */