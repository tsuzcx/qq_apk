package com.tencent.av.business.manager.voiceRecog;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class VoiceRecogReport
{
  public static void a()
  {
    a("0X8009850");
  }
  
  static void a(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report, key[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w("VoiceRecogReport", 1, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", null, null);
  }
  
  public static void b()
  {
    a("0X8009851");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogReport
 * JD-Core Version:    0.7.0.1
 */