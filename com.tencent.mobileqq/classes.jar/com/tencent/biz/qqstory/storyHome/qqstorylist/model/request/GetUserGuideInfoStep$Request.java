package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserGuide;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class GetUserGuideInfoStep$Request
  extends NetworkRequest<GetUserGuideInfoStep.Response>
{
  public static final String a = StoryApi.a("StorySvc.get_user_guide");
  
  public GetUserGuideInfoStep.Response a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserGuide localRspGetUserGuide = new qqstory_service.RspGetUserGuide();
    try
    {
      localRspGetUserGuide.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      SLog.c("Q.qqstory.home.GetUserGuideInfoStep", "decodeResponse error=%s", paramArrayOfByte);
    }
    return new GetUserGuideInfoStep.Response(localRspGetUserGuide);
  }
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetUserGuide().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.Request
 * JD-Core Version:    0.7.0.1
 */