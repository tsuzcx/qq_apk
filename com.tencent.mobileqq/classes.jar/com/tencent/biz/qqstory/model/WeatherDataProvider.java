package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.network.request.GetWeatherRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import ndr;
import nds;

public class WeatherDataProvider
  extends DataProvider
{
  private LbsManager.LbsUpdateListener a;
  public boolean a;
  
  public WeatherDataProvider()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener = new ndr(this);
    e();
  }
  
  private void e()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    long l = ((Long)localStoryConfigManager.b("edit_video_weather_expiry_time", Long.valueOf(0L))).longValue();
    if (l >= System.currentTimeMillis())
    {
      int i = ((Integer)localStoryConfigManager.b("edit_video_weather_filter_data", Integer.valueOf(-999))).intValue();
      if (i != -999)
      {
        SLog.b("WeatherDataProvider", "get local weather data. temperature = %d. expiryTime = %d. currentTime=%d.", Integer.valueOf(i), Long.valueOf(l), Long.valueOf(System.currentTimeMillis()));
        this.jdField_a_of_type_JavaLangObject = new WeatherDataProvider.WeatherInfo(i);
        return;
      }
    }
    SLog.d("WeatherDataProvider", "no valid local weather data.");
  }
  
  protected void a()
  {
    SLog.b("WeatherDataProvider", "requestWeather.");
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("WeatherDataProvider", "is request ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = localLbsManager.b();
    if (localBasicLocation != null)
    {
      a(localBasicLocation.b, localBasicLocation.a);
      return;
    }
    localLbsManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener);
    localLbsManager.c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SLog.a("WeatherDataProvider", "requestWeather[longitude=%s,latitude=%s]", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    GetWeatherRequest localGetWeatherRequest = new GetWeatherRequest(1, paramInt1, paramInt2);
    CmdTaskManger.a().a(localGetWeatherRequest, new nds(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.WeatherDataProvider
 * JD-Core Version:    0.7.0.1
 */