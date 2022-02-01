package com.tencent.mobileqq.Doraemon.impl.commonModule;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class SensorModule$CityListener
  extends SensorModule.BaseOnLocationListener
{
  public SensorModule$CityListener(APICallback paramAPICallback, long paramLong)
  {
    super(paramAPICallback, 3, paramLong);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLocationFinish: errCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", info=");
      ((StringBuilder)localObject).append(paramSosoLbsInfo);
      ((StringBuilder)localObject).append(", isActive=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("DoraemonOpenAPI.sensor.location", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.a) {
      return;
    }
    this.a = false;
    if (paramInt == 0)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("nation", paramSosoLbsInfo.mLocation.nation);
        ((JSONObject)localObject).put("province", paramSosoLbsInfo.mLocation.province);
        ((JSONObject)localObject).put("city", paramSosoLbsInfo.mLocation.city);
        ((JSONObject)localObject).put("district", paramSosoLbsInfo.mLocation.district);
      }
      catch (JSONException paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DoraemonOpenAPI.sensor", 2, paramSosoLbsInfo.getMessage(), paramSosoLbsInfo);
        }
      }
      DoraemonUtil.a(this.b, (JSONObject)localObject);
      return;
    }
    paramSosoLbsInfo = this.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error ");
    ((StringBuilder)localObject).append(paramInt);
    DoraemonUtil.a(paramSosoLbsInfo, paramInt, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule.CityListener
 * JD-Core Version:    0.7.0.1
 */