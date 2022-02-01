package com.tencent.ilivesdk.avplayerservice;

import com.tencent.falco.base.libapi.http.UploadCallback;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreUploadCallback;
import org.json.JSONObject;

class SimpleHttpInterfaceTransfer$7
  implements UploadCallback
{
  SimpleHttpInterfaceTransfer$7(SimpleHttpInterfaceTransfer paramSimpleHttpInterfaceTransfer, SimpleCoreUploadCallback paramSimpleCoreUploadCallback) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreUploadCallback != null) {
      this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreUploadCallback.onResponse(paramInt, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.SimpleHttpInterfaceTransfer.7
 * JD-Core Version:    0.7.0.1
 */