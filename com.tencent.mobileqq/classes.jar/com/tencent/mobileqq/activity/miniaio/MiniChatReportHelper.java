package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class MiniChatReportHelper
{
  public static void a(String paramString)
  {
    a(paramString, "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(MiniPieHelper.a);
      ((StringBuilder)localObject).append(".report");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tag=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",extra1=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",extra2=");
      localStringBuilder.append(paramString3);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatReportHelper
 * JD-Core Version:    0.7.0.1
 */