package com.tencent.component.network.utils.http;

import com.tencent.component.network.downloader.impl.DownloaderImpl;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class HttpUtil$ClientOptions
{
  public int a;
  public long a;
  public Proxy a;
  public TimeUnit a;
  public boolean a;
  public int b = -1;
  public int c = 20000;
  public int d = 20000;
  public int e = 45000;
  
  public HttpUtil$ClientOptions()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentTimeUnit = TimeUnit.SECONDS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaNetProxy = Proxy.NO_PROXY;
  }
  
  public HttpUtil$ClientOptions(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentTimeUnit = TimeUnit.SECONDS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaNetProxy = Proxy.NO_PROXY;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = DownloaderImpl.MAX_CONNECTION;
      this.b = DownloaderImpl.MAX_CONNECTION_PER_ROUTE;
      this.jdField_a_of_type_Long = DownloaderImpl.TIME_TO_LIVE_HTTP;
      this.jdField_a_of_type_JavaUtilConcurrentTimeUnit = DownloaderImpl.TIME_TO_LIVE_UNIT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.HttpUtil.ClientOptions
 * JD-Core Version:    0.7.0.1
 */