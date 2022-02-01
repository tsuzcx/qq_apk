package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

class AVPreloadDispatcher$DispatcherResponse
  implements HttpResponse
{
  private boolean a = false;
  private AVPreloadDispatcher.Result b = null;
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      AVPreloadLog.b("StreamDispatcher", "dispatcher onResponse is null!", new Object[0]);
      this.a = true;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResponse: ");
    ((StringBuilder)localObject).append(paramJSONObject);
    AVPreloadLog.b("StreamDispatcher", ((StringBuilder)localObject).toString(), new Object[0]);
    try
    {
      if (paramJSONObject.getInt("error") != 0)
      {
        this.a = true;
        return;
      }
      paramJSONObject = paramJSONObject.getJSONObject("data");
      int i = paramJSONObject.getInt("ttl");
      paramJSONObject = paramJSONObject.getJSONArray("ips");
      paramInt = 0;
      while (paramInt < paramJSONObject.length())
      {
        localObject = paramJSONObject.getJSONObject(paramInt);
        this.b = new AVPreloadDispatcher.Result();
        this.b.a = ((JSONObject)localObject).getString("stream");
        this.b.b = ((JSONObject)localObject).getJSONArray("sug").getString(0);
        this.b.c = ((JSONObject)localObject).getJSONArray("bak").getString(0);
        this.b.e = i;
        this.b.d = System.currentTimeMillis();
        paramInt += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      this.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadDispatcher.DispatcherResponse
 * JD-Core Version:    0.7.0.1
 */