package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqQQStoryGuide;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspQQStoryGuide;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class QQStoryGuideRequest
  extends NetworkRequest
{
  public static String a = StoryApi.a("StorySvc.new_user_guide");
  public String b;
  public String c;
  
  public QQStoryGuideRequest(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspQQStoryGuide localRspQQStoryGuide = new qqstory_service.RspQQStoryGuide();
    try
    {
      localRspQQStoryGuide.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new QQStoryGuideRequest.QQStoryGuideResponse(localRspQQStoryGuide);
  }
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqQQStoryGuide localReqQQStoryGuide = new qqstory_service.ReqQQStoryGuide();
    try
    {
      localReqQQStoryGuide.to_uid.set(Long.valueOf(this.b).longValue());
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label28:
      break label28;
    }
    localReqQQStoryGuide.to_uid.set(0L);
    localReqQQStoryGuide.version.set(this.c);
    return localReqQQStoryGuide.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQStoryGuideRequest{toUid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append("version='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest
 * JD-Core Version:    0.7.0.1
 */