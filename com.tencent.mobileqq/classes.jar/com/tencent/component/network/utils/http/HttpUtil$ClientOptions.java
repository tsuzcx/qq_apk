package com.tencent.component.network.utils.http;

import com.tencent.component.network.downloader.impl.DownloaderImpl;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class HttpUtil$ClientOptions
{
  public int connManagerTimeout = 30000;
  public int connTimeout = 30000;
  public int maxConnection = -1;
  public int maxConnectionPerRoute = -1;
  public boolean multiConnection = false;
  public Proxy proxy = Proxy.NO_PROXY;
  public int soTimeout = 55000;
  public long timeToLive = -1L;
  public TimeUnit timeToLiveUnit = TimeUnit.SECONDS;
  
  public HttpUtil$ClientOptions() {}
  
  public HttpUtil$ClientOptions(boolean paramBoolean)
  {
    this.multiConnection = paramBoolean;
    if (this.multiConnection)
    {
      this.maxConnection = DownloaderImpl.MAX_CONNECTION;
      this.maxConnectionPerRoute = DownloaderImpl.MAX_CONNECTION_PER_ROUTE;
      this.timeToLive = DownloaderImpl.TIME_TO_LIVE_HTTP;
      this.timeToLiveUnit = DownloaderImpl.TIME_TO_LIVE_UNIT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.HttpUtil.ClientOptions
 * JD-Core Version:    0.7.0.1
 */