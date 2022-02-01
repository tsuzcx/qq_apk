package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.response.GetPoiFacesResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetPoiFacesRequest
  extends NetworkRequest<GetPoiFacesResponse>
{
  public final int e;
  public final int f;
  public final int g;
  
  public GetPoiFacesRequest(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = 1;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.video_poi_posters_get");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPOIPosters localRspGetPOIPosters = new qqstory_service.RspGetPOIPosters();
    try
    {
      localRspGetPOIPosters.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetPoiFacesResponse(localRspGetPOIPosters);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetPOIPosters localReqGetPOIPosters = new qqstory_service.ReqGetPOIPosters();
    qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
    localGpsMsg.lng.set(this.e);
    localGpsMsg.lat.set(this.f);
    localReqGetPOIPosters.coordinate.set(this.g);
    localReqGetPOIPosters.gps.set(localGpsMsg);
    return localReqGetPOIPosters.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetPoiFacesRequest
 * JD-Core Version:    0.7.0.1
 */