package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetWeather;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWeather;
import com.tencent.biz.qqstory.network.response.GetWeatherResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetWeatherRequest
  extends NetworkRequest<GetWeatherResponse>
{
  private static final String a = StoryApi.a("StorySvc.get_weather");
  public final int c;
  public final int d;
  public final int e;
  
  public GetWeatherRequest(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetWeather localRspGetWeather = new qqstory_service.RspGetWeather();
    try
    {
      localRspGetWeather.mergeFrom(paramArrayOfByte);
      return new GetWeatherResponse(localRspGetWeather);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return a;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqGetWeather localReqGetWeather = new qqstory_service.ReqGetWeather();
    localReqGetWeather.coordinate.set(this.c);
    localReqGetWeather.longitude.set(this.d);
    localReqGetWeather.latitude.set(this.e);
    return localReqGetWeather.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetWeatherRequest
 * JD-Core Version:    0.7.0.1
 */