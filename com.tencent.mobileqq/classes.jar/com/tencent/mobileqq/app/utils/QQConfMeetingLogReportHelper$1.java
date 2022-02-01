package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.qphone.base.util.QLog;

class QQConfMeetingLogReportHelper$1
  implements ShareAppLogHelper.OnGetLocalLogListener
{
  QQConfMeetingLogReportHelper$1(QQConfMeetingLogReportHelper paramQQConfMeetingLogReportHelper) {}
  
  public void a(int paramInt)
  {
    QLog.e("QQConfMeetingLogReportHelper", 1, "doReportLocalLog OnGetLocalLogListener onError, code=" + paramInt);
  }
  
  public void a(String paramString)
  {
    QQConfMeetingLogReportHelper.a(this.a, paramString);
  }
  
  public void b(int paramInt)
  {
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper.1
 * JD-Core Version:    0.7.0.1
 */