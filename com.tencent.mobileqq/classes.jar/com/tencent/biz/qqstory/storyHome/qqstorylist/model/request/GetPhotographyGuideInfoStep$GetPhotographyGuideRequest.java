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
  public static final String e = StoryApi.a("StorySvc.get_photography_guide");
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspGetPhotographyGuide();
    try
    {
      ((qqstory_service.RspGetPhotographyGuide)localObject).mergeFrom(paramArrayOfByte);
      return new GetPhotographyGuideInfoStep.GetPhotographyGuideResponse((qqstory_service.RspGetPhotographyGuide)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetPhotographyGuideRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    return new qqstory_service.ReqGetPhotographyGuide().toByteArray();
  }
  
  public String toString()
  {
    return "GetPhotographyGuideRequest{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPhotographyGuideInfoStep.GetPhotographyGuideRequest
 * JD-Core Version:    0.7.0.1
 */