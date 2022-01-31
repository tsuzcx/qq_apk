package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBannerVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBannerVideoList;
import com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetDiscoverBannerVideoRequest
  extends NetworkRequest
{
  public static final String a = StoryApi.a("StorySvc.square_720_banner_vid_list");
  public String b;
  public String c;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBannerVideoList localRspBannerVideoList = new qqstory_service.RspBannerVideoList();
    try
    {
      localRspBannerVideoList.mergeFrom(paramArrayOfByte);
      return new GetDiscoverBannerVideoResponse(localRspBannerVideoList);
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
  
  protected byte[] a()
  {
    qqstory_service.ReqBannerVideoList localReqBannerVideoList = new qqstory_service.ReqBannerVideoList();
    localReqBannerVideoList.banner_id.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqBannerVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.c));
    return localReqBannerVideoList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetDiscoverBannerVideoRequest
 * JD-Core Version:    0.7.0.1
 */