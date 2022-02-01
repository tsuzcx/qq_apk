package com.tencent.biz.qqstory.utils;

import android.os.SystemClock;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.net.URL;
import ykq;
import ykv;

class UIUtils$DrawableListenerHolder
  implements URLDrawable.DownloadListener, URLDrawable.URLDrawableListener
{
  public static int DOWNLOAD_FAIL;
  public static int DOWNLOAD_SUCCESS = 1;
  public static int LOAD_CANCEL = 16;
  public static int LOAD_FAIL;
  public static int LOAD_SUCCESS;
  public static String OP_TYPE = "story_url_drawable";
  URLDrawable drawable;
  int errorCode = 0;
  long fileSize = 0L;
  int loadCancelTime = 0;
  int loadFailTime = 0;
  int loadSuccessTime = 0;
  UIUtils.URLDrawableMonitor monitor;
  String op_name = "";
  int result = 0;
  long startTime = 0L;
  String url;
  
  static
  {
    DOWNLOAD_FAIL = 2;
    LOAD_SUCCESS = 4;
    LOAD_FAIL = 8;
  }
  
  public UIUtils$DrawableListenerHolder(UIUtils.URLDrawableMonitor paramURLDrawableMonitor, URLDrawable paramURLDrawable, String paramString)
  {
    this.drawable = paramURLDrawable;
    this.monitor = paramURLDrawableMonitor;
    this.url = paramURLDrawable.getURL().toString();
    this.startTime = SystemClock.uptimeMillis();
    this.op_name = paramString;
  }
  
  void doReport()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.startTime;
    ykv.b(OP_TYPE, this.op_name, 0, this.result, new String[] { String.valueOf(this.fileSize), String.valueOf(l1 - l2), String.valueOf(this.errorCode), this.url });
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.result |= DOWNLOAD_FAIL;
    this.errorCode = paramInt;
    ykq.a("Q.qqstory.UIUtils", "onFileDownloadFailed() %s, error(%d), %s, %d", this.url, Integer.valueOf(paramInt), this.drawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onFileDownloadStarted()
  {
    this.startTime = SystemClock.uptimeMillis();
    ykq.a("Q.qqstory.UIUtils", "onFileDownloadStarted() %s, %s, %d", this.url, this.drawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.result |= DOWNLOAD_SUCCESS;
    this.fileSize = paramLong;
    ykq.a("Q.qqstory.UIUtils", "onFileDownloadSucceed() %s, %d, %s, %d", this.url, Long.valueOf(paramLong), this.drawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.result |= LOAD_CANCEL;
    ykq.a("Q.qqstory.UIUtils", "onLoadCanceled() %s, %s, %d", this.url, this.drawable, Integer.valueOf(System.identityHashCode(this)));
    doReport();
    this.loadCancelTime += 1;
    this.monitor.remove(this);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.result |= LOAD_FAIL;
    ykq.a("Q.qqstory.UIUtils", "onLoadFialed() %s, %s, %d", this.url, this.drawable, Integer.valueOf(System.identityHashCode(this)));
    doReport();
    this.loadFailTime += 1;
    this.monitor.remove(this);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    ykq.a("Q.qqstory.UIUtils", "onLoadProgressed(%d/10000%%) %s, %s, %d", Integer.valueOf(paramInt), this.url, this.drawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.result |= LOAD_SUCCESS;
    ykq.a("Q.qqstory.UIUtils", "onLoadSuccessed() %s, %s, %d", this.url, this.drawable, Integer.valueOf(System.identityHashCode(this)));
    doReport();
    this.loadSuccessTime += 1;
    this.monitor.remove(this);
  }
  
  public String toString()
  {
    return "DrawableListenerHolder{url='" + this.url + '\'' + ", fileSize=" + this.fileSize + ", startTime=" + this.startTime + ", errorCode=" + this.errorCode + ", result=" + this.result + ", loadFailTime=" + this.loadFailTime + ", loadSuccessTime=" + this.loadSuccessTime + ", loadCancelTime=" + this.loadCancelTime + ", op_name='" + this.op_name + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.DrawableListenerHolder
 * JD-Core Version:    0.7.0.1
 */