package com.tencent.component.network.utils.http;

import java.net.Proxy;
import org.apache.http.HttpHost;

public final class HttpUtil$RequestOptions
{
  static final boolean DEFAULT_ALLOW_PROXY = true;
  static final boolean DEFAULT_APN_PROXY = false;
  public boolean allowProxy = true;
  public boolean apnProxy = false;
  public Proxy mobileProxy = null;
  public HttpHost mobileProxyHost = null;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.utils.http.HttpUtil.RequestOptions
 * JD-Core Version:    0.7.0.1
 */