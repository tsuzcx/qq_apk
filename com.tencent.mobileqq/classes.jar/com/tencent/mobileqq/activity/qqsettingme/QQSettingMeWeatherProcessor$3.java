package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;

class QQSettingMeWeatherProcessor$3
  extends SosoInterfaceOnLocationListener
{
  QQSettingMeWeatherProcessor$3(QQSettingMeWeatherProcessor paramQQSettingMeWeatherProcessor, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",info:");
      localStringBuilder.append(paramSosoLbsInfo);
      QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramInt = (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
      if (QLog.isColorLevel())
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("onLocationFinish latitude:");
        paramSosoLbsInfo.append(paramInt);
        paramSosoLbsInfo.append(",longtitude:");
        paramSosoLbsInfo.append(i);
        QLog.d("QQSettingRedesign", 2, paramSosoLbsInfo.toString());
      }
      ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).translate((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime, paramInt, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWeatherProcessor.3
 * JD-Core Version:    0.7.0.1
 */