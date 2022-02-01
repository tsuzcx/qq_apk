package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

class AVPreloadDispatcher$DispatcherResponse
  implements HttpResponse
{
  private AVPreloadDispatcher.Result jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Result = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      AVPreloadLog.b("StreamDispatcher", "dispatcher onResponse is null!", new Object[0]);
      this.jdField_a_of_type_Boolean = true;
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
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      paramJSONObject = paramJSONObject.getJSONObject("data");
      int i = paramJSONObject.getInt("ttl");
      paramJSONObject = paramJSONObject.getJSONArray("ips");
      paramInt = 0;
      while (paramInt < paramJSONObject.length())
      {
        localObject = paramJSONObject.getJSONObject(paramInt);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Result = new AVPreloadDispatcher.Result();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Result.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("stream");
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Result.b = ((JSONObject)localObject).getJSONArray("sug").getString(0);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Result.c = ((JSONObject)localObject).getJSONArray("bak").getString(0);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Result.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher$Result.jdField_a_of_type_Long = System.currentTimeMillis();
        paramInt += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadDispatcher.DispatcherResponse
 * JD-Core Version:    0.7.0.1
 */