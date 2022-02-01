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
    if (paramInt != 6)
    {
      if (paramInt != 7) {
        return false;
      }
      l = paramJSONObject.optInt("allowCacheTime", 10);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new SensorModule.GeoListener(paramAPICallback, l * 1000L));
    }
    else
    {
      l = paramJSONObject.optInt("allowCacheTime", 10);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new SensorModule.CityListener(paramAPICallback, l * 1000L));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule
 * JD-Core Version:    0.7.0.1
 */