package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import org.apache.http.HttpRequest;

public abstract interface KeepAliveStrategy
{
  public abstract KeepAliveStrategy.KeepAlive keepAlive(String paramString, HttpRequest paramHttpRequest, HttpUtil.RequestOptions paramRequestOptions);
  
  public abstract boolean supportKeepAlive(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.KeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */