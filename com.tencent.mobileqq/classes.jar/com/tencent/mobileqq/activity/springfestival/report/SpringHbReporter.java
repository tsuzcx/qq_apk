package com.tencent.mobileqq.activity.springfestival.report;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class SpringHbReporter
{
  public static void a(String paramString1, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString2)
  {
    a(paramString1, paramInt1, paramInt2, paramMap, paramString2, false);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString2, boolean paramBoolean)
  {
    paramString1 = SpringHbReportManager.ReportInfo.create(paramString1, paramInt1, paramInt2, paramMap, paramString2, paramBoolean);
    if ((paramString1 != null) && (paramString1.isValid()))
    {
      paramMap = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramMap instanceof QQAppInterface))
      {
        ((SpringHbReportManager)((QQAppInterface)paramMap).getManager(QQManagerFactory.SPRING_HB_REPORT_MANAGER)).a(paramString1);
        return;
      }
      paramMap = new Bundle();
      paramMap.putSerializable("key1", paramString1);
      QIPCClientHelper.getInstance().callServer("SpringHbIPCModule", "ReportData", paramMap, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("[report] reportInfo is invalid");
      paramMap.append(paramString1);
      QLog.i("shua2021report_SpringHbReporter", 2, paramMap.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter
 * JD-Core Version:    0.7.0.1
 */