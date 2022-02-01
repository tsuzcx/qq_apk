package com.tencent.mobileqq.app;

import android.os.SystemClock;
import android.util.Printer;

class ThreadLooperPrinter2
  implements Printer
{
  public static final int DEFAULT_THRESHOLD_TIME = 200;
  public static final int FAMILY_DISPATCHER_TASK = 2;
  public static final int FAMILY_FILW_TASK = 3;
  public static final int FAMILY_SUB_TASK = 1;
  public static final String START_PREFIX = ">>";
  public static final String STOP_PREFIX = "<<";
  private static final String TAG = "TM.global.LooperPrinter";
  public static int sLogThreshold = 200;
  private String lastLog;
  private int mFamily = 0;
  private String mLooperName;
  private long msgCount;
  private int notReortedLoopCount = 0;
  private long startTime;
  private long totalCost;
  
  ThreadLooperPrinter2(int paramInt, String paramString)
  {
    this.mFamily = paramInt;
    this.mLooperName = paramString;
  }
  
  private static String format(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (!paramString.startsWith(">>>")) {
        return null;
      }
      int i = paramString.indexOf('(');
      if (i == -1) {
        return null;
      }
      int j = paramString.indexOf(')', i);
      if (j == -1) {
        return null;
      }
      String str1 = paramString.substring(i + 1, j);
      i = paramString.indexOf("} ", j);
      if (i == -1) {
        return null;
      }
      int k = i + 2;
      j = paramString.indexOf('@', k);
      i = j;
      if (j == -1)
      {
        j = paramString.indexOf(':', k);
        i = j;
        if (j == -1)
        {
          i = paramString.indexOf(' ', k);
          if (i == -1) {
            return null;
          }
        }
      }
      String str2 = paramString.substring(k, i);
      i = paramString.indexOf(": ", i);
      if (i == -1) {
        return null;
      }
      return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
    }
    return null;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.startTime = SystemClock.uptimeMillis();
      this.lastLog = paramString;
      return;
    }
    if ((this.startTime != 0L) && (paramString.startsWith("<<")))
    {
      this.msgCount += 1L;
      long l = SystemClock.uptimeMillis() - this.startTime;
      this.startTime = 0L;
      this.totalCost += l;
      StringBuilder localStringBuilder;
      if (ThreadSetting.logcatBgTaskMonitor)
      {
        paramString = format(this.lastLog);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mLooperName);
        localStringBuilder.append(", cost=");
        localStringBuilder.append(l);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
        ThreadLog.printQLog("AutoMonitor", localStringBuilder.toString());
        return;
      }
      if (l >= sLogThreshold)
      {
        paramString = format(this.lastLog);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mLooperName);
        localStringBuilder.append(" OOT cost=");
        localStringBuilder.append(l);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
        ThreadLog.printQLog("AutoMonitor", localStringBuilder.toString());
      }
    }
  }
  
  void setDebugSettings(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setting threshold, threshold=");
    localStringBuilder.append(paramInt);
    ThreadLog.printQLog("TM.global.LooperPrinter", localStringBuilder.toString());
    sLogThreshold = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(msgCount = ");
    localStringBuilder.append(this.msgCount);
    localStringBuilder.append(", totalCost = ");
    localStringBuilder.append(this.totalCost);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadLooperPrinter2
 * JD-Core Version:    0.7.0.1
 */