package com.tencent.av.report;

public class AVReportLog
{
  private static AVReportLogInterface sLog;
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AVReportLogInterface localAVReportLogInterface = sLog;
    if (localAVReportLogInterface != null) {
      localAVReportLogInterface.d(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AVReportLogInterface localAVReportLogInterface = sLog;
    if (localAVReportLogInterface != null) {
      localAVReportLogInterface.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AVReportLogInterface localAVReportLogInterface = sLog;
    if (localAVReportLogInterface != null) {
      localAVReportLogInterface.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void setLog(AVReportLogInterface paramAVReportLogInterface)
  {
    sLog = paramAVReportLogInterface;
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AVReportLogInterface localAVReportLogInterface = sLog;
    if (localAVReportLogInterface != null) {
      localAVReportLogInterface.v(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AVReportLogInterface localAVReportLogInterface = sLog;
    if (localAVReportLogInterface != null) {
      localAVReportLogInterface.w(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.AVReportLog
 * JD-Core Version:    0.7.0.1
 */