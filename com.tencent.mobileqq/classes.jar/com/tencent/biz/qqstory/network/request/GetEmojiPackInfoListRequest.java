package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetEmojiPackInfoListRequest
  extends NetworkRequest<GetEmojiPackInfoListResponse>
{
  public final String e;
  public final int f;
  public final int g;
  public final int h;
  
  public String a()
  {
    return StoryApi.a("StorySvc.video_emoticon_get");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspGetEmoticonPackList();
    try
    {
      ((qqstory_service.RspGetEmoticonPackList)localObject).mergeFrom(paramArrayOfByte);
      return new GetEmojiPackInfoListResponse((qqstory_service.RspGetEmoticonPackList)localObject, paramArrayOfByte, System.currentTimeMillis());
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetEmojiPackInfoListRequest error : ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.e("GetEmojiPackInfoListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetEmoticonPackList localReqGetEmoticonPackList = new qqstory_service.ReqGetEmoticonPackList();
    localReqGetEmoticonPackList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.e));
    localReqGetEmoticonPackList.count.set(this.f);
    return localReqGetEmoticonPackList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetEmojiPackInfoListRequest{mCookie='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", latitude=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetEmojiPackInfoListRequest
 * JD-Core Version:    0.7.0.1
 */