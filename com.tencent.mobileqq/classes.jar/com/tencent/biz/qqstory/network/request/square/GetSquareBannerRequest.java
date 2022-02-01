package com.tencent.biz.qqstory.network.request.square;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetSquareBannerItemList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetSquareBannerItemList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class GetSquareBannerRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.square_720_banner_list");
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetSquareBannerItemList localRspGetSquareBannerItemList = new qqstory_service.RspGetSquareBannerItemList();
    try
    {
      localRspGetSquareBannerItemList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetSquareBannerRequest.GetSquareBannerResponse(localRspGetSquareBannerItemList);
  }
  
  protected byte[] c()
  {
    return new qqstory_service.ReqGetSquareBannerItemList().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.square.GetSquareBannerRequest
 * JD-Core Version:    0.7.0.1
 */