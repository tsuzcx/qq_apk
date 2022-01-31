package com.tencent.component.network.downloader.strategy;

import com.squareup.okhttp.Request.Builder;
import org.apache.http.HttpRequest;

public abstract interface DownloadPreprocessStrategy
{
  public abstract DownloadPreprocessStrategy.DownloadPool downloadPool(String paramString1, String paramString2);
  
  public abstract void prepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, int paramInt);
  
  public abstract String prepareUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy
 * JD-Core Version:    0.7.0.1
 */