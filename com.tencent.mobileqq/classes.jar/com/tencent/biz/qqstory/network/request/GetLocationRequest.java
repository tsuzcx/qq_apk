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
  private static final String a = StoryApi.a("StorySvc.get_location");
  public final int c;
  public final int d;
  public final int e;
  
  public GetLocationRequest(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
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
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetLocation localReqGetLocation = new qqstory_service.ReqGetLocation();
    localReqGetLocation.coordinate.set(this.c);
    localReqGetLocation.gps.lng.set(this.d);
    localReqGetLocation.gps.lat.set(this.e);
    localReqGetLocation.gps.setHasFlag(true);
    return localReqGetLocation.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLocationRequest{mCoordinate=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mLng=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mLat=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetLocationRequest
 * JD-Core Version:    0.7.0.1
 */