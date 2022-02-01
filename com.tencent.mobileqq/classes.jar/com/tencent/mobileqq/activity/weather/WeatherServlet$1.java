package com.tencent.mobileqq.activity.weather;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

final class WeatherServlet$1
  extends LbsManagerServiceOnLocationChangeListener
{
  WeatherServlet$1(String paramString, boolean paramBoolean, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "startLocation onLocationFinish");
    }
    StringBuilder localStringBuilder;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("errCode ：").append(paramInt).append(" info is null ---> ");
      if (paramSosoLbsInfo != null) {
        break label158;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.d("weatherManager", 2, bool);
      int i = j;
      if (paramInt == 0)
      {
        i = j;
        if (paramSosoLbsInfo != null)
        {
          i = j;
          if (paramSosoLbsInfo.mLocation == null) {}
        }
      }
      try
      {
        i = Integer.parseInt(paramSosoLbsInfo.mLocation.cityCode);
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "LocalInfo" + i);
        }
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("adcode", i);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        return;
        label158:
        bool = false;
      }
      catch (Throwable paramSosoLbsInfo)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("weatherManager", 2, paramSosoLbsInfo, new Object[0]);
            i = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.WeatherServlet.1
 * JD-Core Version:    0.7.0.1
 */