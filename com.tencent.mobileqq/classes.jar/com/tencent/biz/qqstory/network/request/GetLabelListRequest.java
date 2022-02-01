package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetLabelList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLabelList;
import com.tencent.biz.qqstory.network.response.GetLabelListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetLabelListRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.video_tag_search");
  public String f;
  public String g = "";
  public int h;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspGetLabelList();
    try
    {
      ((qqstory_service.RspGetLabelList)localObject).mergeFrom(paramArrayOfByte);
      return new GetLabelListResponse((qqstory_service.RspGetLabelList)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetLabelListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetLabelList localReqGetLabelList = new qqstory_service.ReqGetLabelList();
    localReqGetLabelList.keyword.set(ByteStringMicro.copyFromUtf8(this.f));
    localReqGetLabelList.count.set(this.h);
    localReqGetLabelList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.g));
    return localReqGetLabelList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLabelListRequest{count=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", keyword='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startCookie='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetLabelListRequest
 * JD-Core Version:    0.7.0.1
 */