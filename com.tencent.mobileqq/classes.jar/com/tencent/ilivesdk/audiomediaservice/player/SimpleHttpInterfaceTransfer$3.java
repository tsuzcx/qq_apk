package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpResponse;
import org.json.JSONObject;

class SimpleHttpInterfaceTransfer$3
  implements HttpResponse
{
  SimpleHttpInterfaceTransfer$3(SimpleHttpInterfaceTransfer paramSimpleHttpInterfaceTransfer, SimpleCoreHttpResponse paramSimpleCoreHttpResponse) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    this.a.onResponse(paramInt, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.SimpleHttpInterfaceTransfer.3
 * JD-Core Version:    0.7.0.1
 */