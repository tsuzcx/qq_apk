package com.tencent.ilivesdk.avplayerservice;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreDownloadCallback;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpImpl;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpResponse;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreUploadCallback;
import java.util.Map;

public class SimpleHttpInterfaceTransfer
  extends SimpleCoreHttpImpl
{
  private HttpInterface a;
  private LogInterface b = new SimpleHttpInterfaceTransfer.8(this);
  
  public SimpleHttpInterfaceTransfer(HttpInterface paramHttpInterface)
  {
    this.a = paramHttpInterface;
    paramHttpInterface = this.a;
    if (paramHttpInterface != null) {
      paramHttpInterface.init(new SimpleHttpInterfaceTransfer.1(this));
    }
  }
  
  public void download(String paramString1, Map<String, String> paramMap, String paramString2, SimpleCoreDownloadCallback paramSimpleCoreDownloadCallback)
  {
    HttpInterface localHttpInterface = this.a;
    if (localHttpInterface != null) {
      localHttpInterface.download(paramString1, paramMap, paramString2, new SimpleHttpInterfaceTransfer.6(this, paramSimpleCoreDownloadCallback));
    }
  }
  
  public void get(String paramString, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    HttpInterface localHttpInterface = this.a;
    if (localHttpInterface != null) {
      localHttpInterface.get(paramString, new SimpleHttpInterfaceTransfer.2(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void get(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    HttpInterface localHttpInterface = this.a;
    if (localHttpInterface != null) {
      localHttpInterface.get(paramString, paramMap, new SimpleHttpInterfaceTransfer.3(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void post(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    HttpInterface localHttpInterface = this.a;
    if (localHttpInterface != null) {
      localHttpInterface.post(paramString, paramMap, new SimpleHttpInterfaceTransfer.4(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void post(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    HttpInterface localHttpInterface = this.a;
    if (localHttpInterface != null) {
      localHttpInterface.post(paramString, paramMap1, paramMap2, new SimpleHttpInterfaceTransfer.5(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void upload(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreUploadCallback paramSimpleCoreUploadCallback)
  {
    HttpInterface localHttpInterface = this.a;
    if (localHttpInterface != null) {
      localHttpInterface.upload(paramString, paramMap1, paramMap2, new SimpleHttpInterfaceTransfer.7(this, paramSimpleCoreUploadCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.SimpleHttpInterfaceTransfer
 * JD-Core Version:    0.7.0.1
 */