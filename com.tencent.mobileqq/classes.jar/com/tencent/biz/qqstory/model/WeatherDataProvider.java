package com.tencent.biz.qqstory.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.network.request.GetWeatherRequest;
import com.tencent.biz.qqstory.support.logging.SLog;

public class WeatherDataProvider
  extends DataProvider<WeatherDataProvider.WeatherInfo>
{
  private long jdField_a_of_type_Long;
  private LbsManager.LbsUpdateListener jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener = new WeatherDataProvider.1(this);
  protected boolean a;
  
  public WeatherDataProvider()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    this.jdField_a_of_type_Long = ((Long)((StoryConfigManager)localObject).b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (this.jdField_a_of_type_Long >= System.currentTimeMillis())
    {
      int i = ((Integer)((StoryConfigManager)localObject).b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      localObject = (String)((StoryConfigManager)localObject).b("edit_video_weather_desc", "");
      if ((i != -999) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        SLog.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new WeatherDataProvider.WeatherInfo(i, (String)localObject);
        return;
      }
    }
    SLog.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  public WeatherDataProvider.WeatherInfo a()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long >= System.currentTimeMillis())) {
      return null;
    }
    return (WeatherDataProvider.WeatherInfo)this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    SLog.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    GetWeatherRequest localGetWeatherRequest = new GetWeatherRequest(1, paramInt1, paramInt2);
    CmdTaskManger.a().a(localGetWeatherRequest, new WeatherDataProvider.2(this));
  }
  
  protected void a(BasicLocation paramBasicLocation)
  {
    SLog.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = paramBasicLocation;
    if (paramBasicLocation == null) {
      localBasicLocation = localLbsManager.b();
    }
    if (localBasicLocation != null)
    {
      a(localBasicLocation.b, localBasicLocation.a);
      return;
    }
    localLbsManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener);
    localLbsManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.WeatherDataProvider
 * JD-Core Version:    0.7.0.1
 */