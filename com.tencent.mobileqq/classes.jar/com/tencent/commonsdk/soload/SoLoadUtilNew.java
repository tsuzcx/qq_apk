package com.tencent.commonsdk.soload;

import android.content.Context;
import android.os.SystemClock;

public class SoLoadUtilNew
{
  static SoLoadReport sReport;
  
  private static boolean getLoadResult(int paramInt)
  {
    if ((paramInt & 0x2) == 2) {}
    while ((paramInt & 0x40000) == 262144) {
      return true;
    }
    return false;
  }
  
  public static boolean loadSoByName(Context paramContext, String paramString)
  {
    long l1 = SystemClock.uptimeMillis();
    int i = SoLoadCore.loadSo(paramContext, paramString);
    long l2 = SystemClock.uptimeMillis();
    if (sReport != null) {
      sReport.report(i, paramString, l2 - l1);
    }
    return getLoadResult(i);
  }
  
  public static void setReport(SoLoadReport paramSoLoadReport)
  {
    sReport = paramSoLoadReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.SoLoadUtilNew
 * JD-Core Version:    0.7.0.1
 */