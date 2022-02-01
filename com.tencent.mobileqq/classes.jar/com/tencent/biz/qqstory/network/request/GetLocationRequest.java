package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLocation;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.response.GetLocationResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetLocationRequest
  extends NetworkRequest<GetLocationResponse>
{
  private static final String h = StoryApi.a("StorySvc.get_location");
  public final int e;
  public final int f;
  public final int g;
  
  public GetLocationRequest(int paramInt1, int paramInt2, int paramInt3)
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
    qqstory_service.RspGetLocation localRspGetLocation = new qqstory_service.RspGetLocation();
    try
    {
      localRspGetLocation.mergeFrom(paramArrayOfByte);
      return new GetLocationResponse(localRspGetLocation);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetLocation localReqGetLocation = new qqstory_service.ReqGetLocation();
    localReqGetLocation.coordinate.set(this.e);
    localReqGetLocation.gps.lng.set(this.f);
    localReqGetLocation.gps.lat.set(this.g);
    localReqGetLocation.gps.setHasFlag(true);
    return localReqGetLocation.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLocationRequest{mCoordinate=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mLng=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mLat=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetLocationRequest
 * JD-Core Version:    0.7.0.1
 */