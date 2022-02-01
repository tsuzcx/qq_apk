package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreDownloadCallback;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpResponse;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreUploadCallback;
import java.util.Map;

public class SimpleHttpInterfaceTransfer
  extends SimpleCoreHttpImpl
{
  private final HttpInterface a;
  
  public SimpleHttpInterfaceTransfer(HttpInterface paramHttpInterface)
  {
    this.a = paramHttpInterface;
  }
  
  public void download(String paramString1, Map<String, String> paramMap, String paramString2, SimpleCoreDownloadCallback paramSimpleCoreDownloadCallback)
  {
    this.a.download(paramString1, paramMap, paramString2, new SimpleHttpInterfaceTransfer.5(this, paramSimpleCoreDownloadCallback));
  }
  
  public void get(String paramString, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    this.a.get(paramString, new SimpleHttpInterfaceTransfer.1(this, paramSimpleCoreHttpResponse));
  }
  
  public void get(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    this.a.get(paramString, paramMap, new SimpleHttpInterfaceTransfer.2(this, paramSimpleCoreHttpResponse));
  }
  
  public void post(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    this.a.post(paramString, paramMap, new SimpleHttpInterfaceTransfer.3(this, paramSimpleCoreHttpResponse));
  }
  
  public void post(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    this.a.post(paramString, paramMap1, paramMap2, new SimpleHttpInterfaceTransfer.4(this, paramSimpleCoreHttpResponse));
  }
  
  public void upload(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreUploadCallback paramSimpleCoreUploadCallback)
  {
    this.a.upload(paramString, paramMap1, paramMap2, new SimpleHttpInterfaceTransfer.6(this, paramSimpleCoreUploadCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.SimpleHttpInterfaceTransfer
 * JD-Core Version:    0.7.0.1
 */