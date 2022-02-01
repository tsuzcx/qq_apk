package com.tencent.av.report;

import com.tencent.av.utils.HttpUtil.SimpleHttpPostTask;
import com.tencent.qphone.base.util.QLog;

final class AVPushReport$1
  extends HttpUtil.SimpleHttpPostTask
{
  AVPushReport$1(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  protected void a(String paramString)
  {
    AVPushReport.a(null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAvReportPush SimpleHttpPostTask rsp = ");
      localStringBuilder.append(paramString);
      QLog.d("AVPushReport", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.AVPushReport.1
 * JD-Core Version:    0.7.0.1
 */