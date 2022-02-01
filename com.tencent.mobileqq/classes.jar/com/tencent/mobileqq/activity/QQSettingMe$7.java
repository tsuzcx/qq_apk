package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.weather.WeatherServlet;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$7
  extends SosoInterfaceOnLocationListener
{
  QQSettingMe$7(QQSettingMe paramQQSettingMe, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "onLocationFinish errCode:" + paramInt + ",info:" + paramSosoLbsInfo);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramInt = (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onLocationFinish latitude:" + paramInt + ",longtitude:" + i);
      }
      WeatherServlet.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, i, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.7
 * JD-Core Version:    0.7.0.1
 */