package com.tencent.component.network.downloader.strategy;

import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public abstract interface ResumeTransfer
{
  public abstract void addCacheTmpFile(String paramString1, String paramString2, HttpResponse paramHttpResponse, Response paramResponse);
  
  public abstract void cleanCache();
  
  public abstract void cleanCache(String paramString);
  
  public abstract String getResumeTmpFile(String paramString);
  
  public abstract boolean handleResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse, Response paramResponse);
  
  public abstract void onDownloadResult(String paramString, boolean paramBoolean);
  
  public abstract void prepareRequest(HttpGet paramHttpGet, Request.Builder paramBuilder, String paramString1, String paramString2);
  
  public abstract void setSupportDomains(String[] paramArrayOfString, boolean paramBoolean);
  
  public abstract void setUrlKeyGenerator(UrlKeyGenerator paramUrlKeyGenerator);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ResumeTransfer
 * JD-Core Version:    0.7.0.1
 */