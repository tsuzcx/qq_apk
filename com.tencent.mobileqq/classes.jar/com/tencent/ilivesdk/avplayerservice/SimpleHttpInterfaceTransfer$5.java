package com.tencent.ilivesdk.avplayerservice;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpResponse;
import org.json.JSONObject;

class SimpleHttpInterfaceTransfer$5
  implements HttpResponse
{
  SimpleHttpInterfaceTransfer$5(SimpleHttpInterfaceTransfer paramSimpleHttpInterfaceTransfer, SimpleCoreHttpResponse paramSimpleCoreHttpResponse) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreHttpResponse != null) {
      this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreHttpResponse.onResponse(paramInt, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.SimpleHttpInterfaceTransfer.5
 * JD-Core Version:    0.7.0.1
 */