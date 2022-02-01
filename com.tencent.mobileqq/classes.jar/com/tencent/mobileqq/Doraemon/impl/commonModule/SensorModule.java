package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import org.json.JSONObject;

public class SensorModule
  extends DoraemonAPIModule
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    long l;
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      l = paramJSONObject.optInt("allowCacheTime", 10);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new SensorModule.GeoListener(paramAPICallback, 1000L * l));
    }
    for (;;)
    {
      return true;
      l = paramJSONObject.optInt("allowCacheTime", 10);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new SensorModule.CityListener(paramAPICallback, 1000L * l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule
 * JD-Core Version:    0.7.0.1
 */