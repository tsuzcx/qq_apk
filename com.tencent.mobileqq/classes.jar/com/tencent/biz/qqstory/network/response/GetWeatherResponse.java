package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWeather;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class GetWeatherResponse
  extends BaseResponse
{
  public final String a;
  public final int b;
  
  public GetWeatherResponse(qqstory_service.RspGetWeather paramRspGetWeather)
  {
    this.b = paramRspGetWeather.temperature.get();
    this.a = paramRspGetWeather.wea_desc.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetWeatherResponse
 * JD-Core Version:    0.7.0.1
 */