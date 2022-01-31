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
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith(">>>"))) {}
    int i;
    String str1;
    String str2;
    do
    {
      int k;
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              i = paramString.indexOf('(');
            } while (i == -1);
            j = paramString.indexOf(')', i);
          } while (j == -1);
          str1 = paramString.substring(i + 1, j);
          k = paramString.indexOf("} ", j);
        } while (k == -1);
        int j = paramString.indexOf('@', k + 2);
        i = j;
        if (j != -1) {
          break;
        }
        j = paramString.indexOf(':', k + 2);
        i = j;
        if (j != -1) {
          break;
        }
        i = paramString.indexOf(' ', k + 2);
      } while (i == -1);
      str2 = paramString.substring(k + 2, i);
      i = paramString.indexOf(": ", i);
    } while (i == -1);
    return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.startTime = SystemClock.uptimeMillis();
      this.lastLog = paramString;
    }
    long l;
    do
    {
      do
      {
        return;
      } while ((this.startTime == 0L) || (!paramString.startsWith("<<")));
      this.msgCount += 1L;
      l = SystemClock.uptimeMillis() - this.startTime;
      this.startTime = 0L;
      this.totalCost += l;
      if (ThreadSetting.logcatBgTaskMonitor)
      {
        paramString = format(this.lastLog);
        ThreadLog.printQLog("AutoMonitor", this.mLooperName + ", cost=" + l + ", " + paramString);
        return;
      }
    } while (l < sLogThreshold);
    paramString = format(this.lastLog);
    ThreadLog.printQLog("AutoMonitor", this.mLooperName + " OOT cost=" + l + ", " + paramString);
  }
  
  void setDebugSettings(int paramInt, boolean paramBoolean)
  {
    ThreadLog.printQLog("TM.global.LooperPrinter", "setting threshold, threshold=" + paramInt);
    sLogThreshold = paramInt;
  }
  
  public String toString()
  {
    return super.toString() + "(msgCount = " + this.msgCount + ", totalCost = " + this.totalCost + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadLooperPrinter2
 * JD-Core Version:    0.7.0.1
 */