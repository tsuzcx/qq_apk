package com.tencent.mobileqq.Doraemon.impl.commonModule;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class SensorModule$GeoListener
  extends SensorModule.BaseOnLocationListener
{
  public SensorModule$GeoListener(APICallback paramAPICallback, long paramLong)
  {
    super(paramAPICallback, 0, paramLong);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onLocationFinish: errCode=");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(", info=");
      localStringBuilder1.append(paramSosoLbsInfo);
      localStringBuilder1.append(", isActive=");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      QLog.d("DoraemonOpenAPI.sensor.location", 2, localStringBuilder1.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramInt == 0)
    {
      double d1 = paramSosoLbsInfo.mLocation.mLat02;
      double d2 = paramSosoLbsInfo.mLocation.mLon02;
      double d3 = paramSosoLbsInfo.mLocation.speed;
      double d4 = paramSosoLbsInfo.mLocation.accuracy;
      double d5 = paramSosoLbsInfo.mLocation.altitude;
      paramSosoLbsInfo = new JSONObject();
      try
      {
        paramSosoLbsInfo.put("latitude", d1);
        paramSosoLbsInfo.put("longitude", d2);
        paramSosoLbsInfo.put("speed", d3);
        paramSosoLbsInfo.put("accuracy", d4);
        paramSosoLbsInfo.put("altitude", d5);
        paramSosoLbsInfo.put("verticalAccuracy", 0.0D);
        paramSosoLbsInfo.put("horizontalAccuracy", d4);
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DoraemonOpenAPI.sensor", 2, localJSONException.getMessage(), localJSONException);
        }
      }
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramSosoLbsInfo);
      return;
    }
    paramSosoLbsInfo = this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("error ");
    localStringBuilder2.append(paramInt);
    DoraemonUtil.a(paramSosoLbsInfo, paramInt, localStringBuilder2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule.GeoListener
 * JD-Core Version:    0.7.0.1
 */