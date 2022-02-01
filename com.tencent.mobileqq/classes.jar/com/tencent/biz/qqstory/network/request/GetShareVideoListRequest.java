package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetShareVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareVideoList;
import com.tencent.biz.qqstory.network.response.GetShareVideoListResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetShareVideoListRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.new_get_shared_video_list");
  public String f;
  public long g = -1L;
  public String h = "";
  public int i;
  public int j = -1;
  
  public GetShareVideoListRequest(String paramString, long paramLong, int paramInt)
  {
    this.f = paramString;
    this.g = paramLong;
    this.i = 50;
    this.j = paramInt;
  }
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetShareVideoList localRspGetShareVideoList = new qqstory_service.RspGetShareVideoList();
    try
    {
      localRspGetShareVideoList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetShareVideoListResponse(this.f, localRspGetShareVideoList);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetShareVideoList localReqGetShareVideoList = new qqstory_service.ReqGetShareVideoList();
    if (this.g != -1L) {
      localReqGetShareVideoList.share_time.set(this.g);
    }
    localReqGetShareVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.h));
    localReqGetShareVideoList.count.set(this.i);
    if (this.j != -1) {
      localReqGetShareVideoList.time_zone.set(this.j);
    }
    localReqGetShareVideoList.union_id.set(ByteStringMicro.copyFromUtf8(this.f));
    return localReqGetShareVideoList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareVideoListRequest{, uid=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("count=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("timeZoneOffset=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", startCookie='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareVideoListRequest
 * JD-Core Version:    0.7.0.1
 */