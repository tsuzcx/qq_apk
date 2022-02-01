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
  public final String a;
  public final int c;
  public final int d;
  public final int e;
  
  public BaseResponse a(byte[] paramArrayOfByte)
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
  
  public String a()
  {
    return StoryApi.a("StorySvc.video_emoticon_get");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetEmoticonPackList localReqGetEmoticonPackList = new qqstory_service.ReqGetEmoticonPackList();
    localReqGetEmoticonPackList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqGetEmoticonPackList.count.set(this.c);
    return localReqGetEmoticonPackList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetEmojiPackInfoListRequest{mCookie='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", latitude=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetEmojiPackInfoListRequest
 * JD-Core Version:    0.7.0.1
 */