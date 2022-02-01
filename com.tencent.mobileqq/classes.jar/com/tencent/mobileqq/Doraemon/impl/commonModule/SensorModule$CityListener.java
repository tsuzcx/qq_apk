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
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.sensor.location", 2, "onLocationFinish: errCode=" + paramInt + ", info=" + paramSosoLbsInfo + ", isActive=" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramInt == 0)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("nation", paramSosoLbsInfo.mLocation.nation);
        localJSONObject.put("province", paramSosoLbsInfo.mLocation.province);
        localJSONObject.put("city", paramSosoLbsInfo.mLocation.city);
        localJSONObject.put("district", paramSosoLbsInfo.mLocation.district);
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, localJSONObject);
        return;
      }
      catch (JSONException paramSosoLbsInfo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("DoraemonOpenAPI.sensor", 2, paramSosoLbsInfo.getMessage(), paramSosoLbsInfo);
          }
        }
      }
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "error " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule.CityListener
 * JD-Core Version:    0.7.0.1
 */