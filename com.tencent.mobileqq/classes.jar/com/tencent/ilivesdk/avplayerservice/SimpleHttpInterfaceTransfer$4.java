package com.tencent.ilivesdk.avplayerservice;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpResponse;
import org.json.JSONObject;

class SimpleHttpInterfaceTransfer$4
  implements HttpResponse
{
  SimpleHttpInterfaceTransfer$4(SimpleHttpInterfaceTransfer paramSimpleHttpInterfaceTransfer, SimpleCoreHttpResponse paramSimpleCoreHttpResponse) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    SimpleCoreHttpResponse localSimpleCoreHttpResponse = this.jdField_a_of_type_ComTencentIliveOpensdkReporterinterfaceSimpleCoreHttpResponse;
    if (localSimpleCoreHttpResponse != null) {
      localSimpleCoreHttpResponse.onResponse(paramInt, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.SimpleHttpInterfaceTransfer.4
 * JD-Core Version:    0.7.0.1
 */