package com.tencent.component.network.downloader.strategy;

import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public abstract interface ResumeTransfer
{
  public abstract String a(String paramString);
  
  public abstract void a();
  
  public abstract void a(UrlKeyGenerator paramUrlKeyGenerator);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, HttpResponse paramHttpResponse, Response paramResponse);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(HttpGet paramHttpGet, Request.Builder paramBuilder, String paramString1, String paramString2);
  
  public abstract boolean a(String paramString1, String paramString2, HttpResponse paramHttpResponse, Response paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ResumeTransfer
 * JD-Core Version:    0.7.0.1
 */