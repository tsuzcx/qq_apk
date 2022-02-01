package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpResponse;
import org.json.JSONObject;

class SimpleHttpInterfaceTransfer$1
  implements HttpResponse
{
  SimpleHttpInterfaceTransfer$1(SimpleHttpInterfaceTransfer paramSimpleHttpInterfaceTransfer, SimpleCoreHttpResponse paramSimpleCoreHttpResponse) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    this.a.onResponse(paramInt, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.SimpleHttpInterfaceTransfer.1
 * JD-Core Version:    0.7.0.1
 */