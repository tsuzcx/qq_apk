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
  private HttpInterface jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface;
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = new SimpleHttpInterfaceTransfer.8(this);
  
  public SimpleHttpInterfaceTransfer(HttpInterface paramHttpInterface)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface = paramHttpInterface;
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.init(new SimpleHttpInterfaceTransfer.1(this));
    }
  }
  
  public void download(String paramString1, Map<String, String> paramMap, String paramString2, SimpleCoreDownloadCallback paramSimpleCoreDownloadCallback)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.download(paramString1, paramMap, paramString2, new SimpleHttpInterfaceTransfer.6(this, paramSimpleCoreDownloadCallback));
    }
  }
  
  public void get(String paramString, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.get(paramString, new SimpleHttpInterfaceTransfer.2(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void get(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.get(paramString, paramMap, new SimpleHttpInterfaceTransfer.3(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void post(String paramString, Map<String, String> paramMap, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.post(paramString, paramMap, new SimpleHttpInterfaceTransfer.4(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void post(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreHttpResponse paramSimpleCoreHttpResponse)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.post(paramString, paramMap1, paramMap2, new SimpleHttpInterfaceTransfer.5(this, paramSimpleCoreHttpResponse));
    }
  }
  
  public void upload(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, SimpleCoreUploadCallback paramSimpleCoreUploadCallback)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface.upload(paramString, paramMap1, paramMap2, new SimpleHttpInterfaceTransfer.7(this, paramSimpleCoreUploadCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.SimpleHttpInterfaceTransfer
 * JD-Core Version:    0.7.0.1
 */