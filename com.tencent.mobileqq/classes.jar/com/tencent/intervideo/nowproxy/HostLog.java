package com.tencent.intervideo.nowproxy;

import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;

public class HostLog
{
  public static HostLog sInstance = new HostLog();
  private CustomizedLog mCustomizedLog;
  
  public void flushLogs()
  {
    if (this.mCustomizedLog != null) {
      this.mCustomizedLog.onFlushLogs();
    }
  }
  
  public HostLog getInstance()
  {
    return sInstance;
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    if (this.mCustomizedLog != null) {
      this.mCustomizedLog.onLog(paramInt, paramString1, paramString2);
    }
  }
  
  public void setCustomizedLog(CustomizedLog paramCustomizedLog)
  {
    this.mCustomizedLog = paramCustomizedLog;
  }
  
  public void uploadLogs()
  {
    if (this.mCustomizedLog != null) {
      this.mCustomizedLog.onUploadLogs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.HostLog
 * JD-Core Version:    0.7.0.1
 */