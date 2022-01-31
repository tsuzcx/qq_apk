package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPhotographyGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class GetPhotographyGuideInfoStep$GetPhotographyGuideRequest
  extends NetworkRequest
{
  public static final String a = StoryApi.a("StorySvc.get_photography_guide");
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPhotographyGuide localRspGetPhotographyGuide = new qqstory_service.RspGetPhotographyGuide();
    try
    {
      localRspGetPhotographyGuide.mergeFrom(paramArrayOfByte);
      return new GetPhotographyGuideInfoStep.GetPhotographyGuideResponse(localRspGetPhotographyGuide);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetPhotographyGuideRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetPhotographyGuide().toByteArray();
  }
  
  public String toString()
  {
    return "GetPhotographyGuideRequest{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPhotographyGuideInfoStep.GetPhotographyGuideRequest
 * JD-Core Version:    0.7.0.1
 */