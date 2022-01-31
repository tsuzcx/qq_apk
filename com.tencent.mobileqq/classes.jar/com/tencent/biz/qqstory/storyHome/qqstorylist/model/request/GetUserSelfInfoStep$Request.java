package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserSelfInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserSelfInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class GetUserSelfInfoStep$Request
  extends NetworkRequest
{
  public static final String a = StoryApi.a("StorySvc.get_user_base_info");
  
  public GetUserSelfInfoStep.Response a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserSelfInfo localRspGetUserSelfInfo = new qqstory_service.RspGetUserSelfInfo();
    try
    {
      localRspGetUserSelfInfo.mergeFrom(paramArrayOfByte);
      return new GetUserSelfInfoStep.Response(localRspGetUserSelfInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        SLog.c("Q.qqstory.home.GetUserSelfInfoStep", "decodeResponse error=%s", paramArrayOfByte);
      }
    }
  }
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetUserSelfInfo().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.Request
 * JD-Core Version:    0.7.0.1
 */