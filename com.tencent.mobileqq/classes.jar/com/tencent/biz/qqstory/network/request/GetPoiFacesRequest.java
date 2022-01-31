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
  extends NetworkRequest
{
  public final int c;
  public final int d;
  public final int e;
  
  public GetPoiFacesRequest(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = 1;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPOIPosters localRspGetPOIPosters = new qqstory_service.RspGetPOIPosters();
    try
    {
      localRspGetPOIPosters.mergeFrom(paramArrayOfByte);
      return new GetPoiFacesResponse(localRspGetPOIPosters);
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
    return StoryApi.a("StorySvc.video_poi_posters_get");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetPOIPosters localReqGetPOIPosters = new qqstory_service.ReqGetPOIPosters();
    qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
    localGpsMsg.lng.set(this.c);
    localGpsMsg.lat.set(this.d);
    localReqGetPOIPosters.coordinate.set(this.e);
    localReqGetPOIPosters.gps.set(localGpsMsg);
    return localReqGetPOIPosters.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetPoiFacesRequest
 * JD-Core Version:    0.7.0.1
 */