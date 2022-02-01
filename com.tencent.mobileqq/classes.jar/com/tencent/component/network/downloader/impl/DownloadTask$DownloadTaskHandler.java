package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public abstract interface DownloadTask$DownloadTaskHandler
{
  public abstract String findCacheEntryPath(String paramString);
  
  public abstract String generateStorageFileName(String paramString);
  
  public abstract Proxy getCustomProxy();
  
  public abstract int getHttp2TaskConcurrentCount();
  
  public abstract int getHttpTaskConcurrentCount();
  
  public abstract boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse);
  
  public abstract void handleDownloadProgress(String paramString, long paramLong, float paramFloat);
  
  public abstract void handleKeepAliveStrategy(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpUtil.RequestOptions paramRequestOptions);
  
  public abstract void handlePrepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, int paramInt);
  
  public abstract void handleRequestHeader(String paramString, int paramInt, Map<String, List<String>> paramMap);
  
  public abstract void handleStreamDownloadProgress(String paramString1, String paramString2);
  
  public abstract String prepareRequestUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloadTask.DownloadTaskHandler
 * JD-Core Version:    0.7.0.1
 */