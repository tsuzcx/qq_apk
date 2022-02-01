package com.tencent.image.api;

import com.tencent.image.ReportBean;

public abstract interface IReport
{
  public static final int TYPE_CALLBACK_AIO_THUMB_DISPATCH_WAIT_TIME = 4;
  public static final int TYPE_CALLBACK_AIO_THUMB_DOWNLOAD_WAIT_TIME = 3;
  public static final int TYPE_CALLBACK_HTTP_ERROR = 2;
  public static final int TYPE_CALLBACK_OVERSIZE = 1;
  
  public abstract void debug(int paramInt, Object paramObject);
  
  public abstract void report(ReportBean paramReportBean);
  
  public abstract void reportEvent(ReportEventBean paramReportEventBean);
  
  public abstract void reportException(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.api.IReport
 * JD-Core Version:    0.7.0.1
 */