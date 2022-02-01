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
  private static final String h = StoryApi.a("StorySvc.get_weather");
  public final int e;
  public final int f;
  public final int g;
  
  public GetWeatherRequest(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public String a()
  {
    return h;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetWeather localRspGetWeather = new qqstory_service.RspGetWeather();
    try
    {
      localRspGetWeather.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetWeatherResponse(localRspGetWeather);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetWeather localReqGetWeather = new qqstory_service.ReqGetWeather();
    localReqGetWeather.coordinate.set(this.e);
    localReqGetWeather.longitude.set(this.f);
    localReqGetWeather.latitude.set(this.g);
    return localReqGetWeather.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetWeatherRequest
 * JD-Core Version:    0.7.0.1
 */