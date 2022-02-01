package com.tencent.component.network.downloader.impl;

import android.os.SystemClock;
import java.net.InetAddress;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;

class OkHttpDownloadTask$1
  extends EventListener
{
  OkHttpDownloadTask$1(OkHttpDownloadTask paramOkHttpDownloadTask) {}
  
  public void dnsEnd(Call paramCall, String paramString, List<InetAddress> paramList)
  {
    super.dnsEnd(paramCall, paramString, paramList);
    OkHttpDownloadTask.access$102(this.this$0, SystemClock.uptimeMillis());
  }
  
  public void dnsStart(Call paramCall, String paramString)
  {
    super.dnsStart(paramCall, paramString);
    OkHttpDownloadTask.access$002(this.this$0, SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.OkHttpDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */