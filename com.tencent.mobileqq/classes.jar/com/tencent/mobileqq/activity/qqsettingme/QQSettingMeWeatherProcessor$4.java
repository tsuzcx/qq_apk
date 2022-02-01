package com.tencent.mobileqq.activity.qqsettingme;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class QQSettingMeWeatherProcessor$4
  extends LbsManagerServiceOnLocationChangeListener
{
  QQSettingMeWeatherProcessor$4(QQSettingMeWeatherProcessor paramQQSettingMeWeatherProcessor, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
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
      int j = (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D);
      int k = (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
      int i;
      try
      {
        paramInt = Integer.parseInt(paramSosoLbsInfo.mLocation.cityCode);
        try
        {
          paramSosoLbsInfo = MobileQQ.getContext().getSharedPreferences("public_account_weather", 0).edit();
          paramSosoLbsInfo.putInt("cur_adcode", paramInt);
          paramSosoLbsInfo.apply();
          i = paramInt;
        }
        catch (Throwable paramSosoLbsInfo) {}
        i = paramInt;
      }
      catch (Throwable paramSosoLbsInfo)
      {
        paramInt = 0;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("QQSettingRedesign", 2, paramSosoLbsInfo, new Object[0]);
        i = paramInt;
      }
      if (QLog.isColorLevel())
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("onLocationFinish latitude:");
        paramSosoLbsInfo.append(j);
        paramSosoLbsInfo.append(",longtitude:");
        paramSosoLbsInfo.append(k);
        paramSosoLbsInfo.append(",adcode:");
        paramSosoLbsInfo.append(i);
        QLog.d("QQSettingRedesign", 2, paramSosoLbsInfo.toString());
      }
      ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).translate((QQAppInterface)this.a.c, j, k, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWeatherProcessor.4
 * JD-Core Version:    0.7.0.1
 */