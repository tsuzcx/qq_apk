package com.tencent.TMG.logger;

import com.tencent.TIMLogLevel;
import com.tencent.TIMManager;
import com.tencent.timint.TIMIntManager;

public class IMLogger
  implements Logger
{
  public static final String LOGTAG = "IMChannel";
  public static final String buglyAPPID = "900011370";
  
  public String getLogDir()
  {
    try
    {
      String str = TIMManager.getInstance().getLogPath();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public int getWriteLogLevel()
  {
    return 1;
  }
  
  public void init(String paramString)
  {
    try
    {
      TIMIntManager.getInstance().setAvSDKVersionToBugly("900011370", paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean isEnablePrintLog()
  {
    try
    {
      boolean bool = TIMManager.getInstance().getIsLogPrintEnabled();
      return bool;
    }
    catch (Exception localException) {}
    return true;
  }
  
  public boolean reportKeyLog(String paramString1, int paramInt, String paramString2)
  {
    if (6 == paramInt) {}
    try
    {
      TIMIntManager.getInstance().logBugly(TIMLogLevel.INFO, paramString1, paramString2);
      break label50;
      if (5 == paramInt) {
        TIMIntManager.getInstance().logBugly(TIMLogLevel.ERROR, paramString1, paramString2);
      } else {
        TIMIntManager.getInstance().logBugly(TIMLogLevel.DEBUG, paramString1, paramString2);
      }
      label50:
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.logger.IMLogger
 * JD-Core Version:    0.7.0.1
 */