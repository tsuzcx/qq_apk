package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqUploadStoryVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspUploadStoryVideo;
import com.tencent.biz.qqstory.network.response.GetVideoUploadAddrResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetVideoUploadAddrRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.video_apply_upload");
  public String f;
  public String g;
  public long h;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspUploadStoryVideo localRspUploadStoryVideo = new qqstory_service.RspUploadStoryVideo();
    try
    {
      localRspUploadStoryVideo.mergeFrom(paramArrayOfByte);
      return new GetVideoUploadAddrResponse(localRspUploadStoryVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label23:
      break label23;
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqUploadStoryVideo localReqUploadStoryVideo = new qqstory_service.ReqUploadStoryVideo();
    if (this.f != null)
    {
      localReqUploadStoryVideo.md5.set(ByteStringMicro.copyFromUtf8(this.f));
      if (this.g != null)
      {
        localReqUploadStoryVideo.sha.set(ByteStringMicro.copyFromUtf8(this.g));
        localReqUploadStoryVideo.size.set(this.h);
        return localReqUploadStoryVideo.toByteArray();
      }
      SLog.d("Q.qqstory:GetVideoUploadAddrRequest", "without sha");
      throw new IllegalArgumentException("without sha");
    }
    SLog.d("Q.qqstory:GetVideoUploadAddrRequest", "without md5");
    throw new IllegalArgumentException("without md5");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetStoryVideoUploadAddressRequest{md5='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sha='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVideoUploadAddrRequest
 * JD-Core Version:    0.7.0.1
 */