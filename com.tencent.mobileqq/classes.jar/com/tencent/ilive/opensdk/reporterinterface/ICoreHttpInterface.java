package com.tencent.ilive.opensdk.reporterinterface;

import java.util.Map;

public abstract interface ICoreHttpInterface
{
  public abstract void download(String paramString1, Map<String, String> paramMap, String paramString2, SimpleCoreDownloadCallback paramSimpleCoreDownloadCallback);
  
  public abstract void get(String paramString, SimpleCoreHttpResponse paramSimpleCoreHttpResponse);
  
  public abstract void get(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse);
  
  public abstract void post(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse);
  
  public abstract void post(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreHttpResponse paramSimpleCoreHttpResponse);
  
  public abstract void upload(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreUploadCallback paramSimpleCoreUploadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.reporterinterface.ICoreHttpInterface
 * JD-Core Version:    0.7.0.1
 */