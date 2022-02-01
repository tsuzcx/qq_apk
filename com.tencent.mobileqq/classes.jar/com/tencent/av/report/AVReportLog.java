package com.tencent.av.report;

public class AVReportLog
{
  private static AVReportLogInterface sLog;
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sLog != null) {
      sLog.d(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sLog != null) {
      sLog.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sLog != null) {
      sLog.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void setLog(AVReportLogInterface paramAVReportLogInterface)
  {
    sLog = paramAVReportLogInterface;
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sLog != null) {
      sLog.v(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (sLog != null) {
      sLog.w(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.report.AVReportLog
 * JD-Core Version:    0.7.0.1
 */