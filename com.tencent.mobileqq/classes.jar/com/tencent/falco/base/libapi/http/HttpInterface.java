package com.tencent.falco.base.libapi.http;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.util.Map;
import org.json.JSONObject;

public abstract interface HttpInterface
  extends ServiceBaseInterface
{
  public abstract void download(String paramString1, Map<String, String> paramMap, String paramString2, DownloadCallback paramDownloadCallback);
  
  public abstract void get(String paramString, HttpResponse paramHttpResponse);
  
  public abstract void get(String paramString, Map<String, String> paramMap, HttpResponse paramHttpResponse);
  
  public abstract void init(HttpInterface.HttpComponentAdapter paramHttpComponentAdapter);
  
  public abstract void post(String paramString, Map<String, String> paramMap, HttpResponse paramHttpResponse);
  
  public abstract void post(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, HttpResponse paramHttpResponse);
  
  public abstract void post(String paramString, JSONObject paramJSONObject, HttpResponse paramHttpResponse);
  
  public abstract void upload(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, UploadCallback paramUploadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.http.HttpInterface
 * JD-Core Version:    0.7.0.1
 */