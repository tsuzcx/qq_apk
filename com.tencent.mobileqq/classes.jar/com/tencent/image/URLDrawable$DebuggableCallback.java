package com.tencent.image;

import java.util.HashMap;

public abstract interface URLDrawable$DebuggableCallback
{
  public static final int TYPE_CALLBACK_AIO_THUMB_DISPATCH_WAIT_TIME = 4;
  public static final int TYPE_CALLBACK_AIO_THUMB_DOWNLOAD_WAIT_TIME = 3;
  public static final int TYPE_CALLBACK_HTTP_ERROR = 2;
  public static final int TYPE_CALLBACK_OVERSIZE = 1;
  
  public abstract boolean isNeedSample();
  
  public abstract void onDebug(int paramInt, Object paramObject);
  
  public abstract void onReport(ReportBean paramReportBean);
  
  public abstract void onReportLoadingDrawableError();
  
  public abstract void onReportThread(HashMap<String, String> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawable.DebuggableCallback
 * JD-Core Version:    0.7.0.1
 */