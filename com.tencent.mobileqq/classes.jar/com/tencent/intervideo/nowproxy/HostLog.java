package com.tencent.intervideo.nowproxy;

import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;

public class HostLog
{
  public static HostLog sInstance = new HostLog();
  private CustomizedLog mCustomizedLog;
  
  public void flushLogs()
  {
    CustomizedLog localCustomizedLog = this.mCustomizedLog;
    if (localCustomizedLog != null) {
      localCustomizedLog.onFlushLogs();
    }
  }
  
  public HostLog getInstance()
  {
    return sInstance;
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    CustomizedLog localCustomizedLog = this.mCustomizedLog;
    if (localCustomizedLog != null) {
      localCustomizedLog.onLog(paramInt, paramString1, paramString2);
    }
  }
  
  public void setCustomizedLog(CustomizedLog paramCustomizedLog)
  {
    this.mCustomizedLog = paramCustomizedLog;
  }
  
  public void uploadLogs()
  {
    CustomizedLog localCustomizedLog = this.mCustomizedLog;
    if (localCustomizedLog != null) {
      localCustomizedLog.onUploadLogs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.HostLog
 * JD-Core Version:    0.7.0.1
 */