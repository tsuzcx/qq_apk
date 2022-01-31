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
  public static final String a;
  public long a;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.video_apply_upload");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspUploadStoryVideo localRspUploadStoryVideo = new qqstory_service.RspUploadStoryVideo();
    try
    {
      localRspUploadStoryVideo.mergeFrom(paramArrayOfByte);
      return new GetVideoUploadAddrResponse(localRspUploadStoryVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqUploadStoryVideo localReqUploadStoryVideo = new qqstory_service.ReqUploadStoryVideo();
    if (this.b != null)
    {
      localReqUploadStoryVideo.md5.set(ByteStringMicro.copyFromUtf8(this.b));
      if (this.c != null)
      {
        localReqUploadStoryVideo.sha.set(ByteStringMicro.copyFromUtf8(this.c));
        localReqUploadStoryVideo.size.set(this.jdField_a_of_type_Long);
        return localReqUploadStoryVideo.toByteArray();
      }
    }
    else
    {
      SLog.d("Q.qqstory:GetVideoUploadAddrRequest", "without md5");
      throw new IllegalArgumentException("without md5");
    }
    SLog.d("Q.qqstory:GetVideoUploadAddrRequest", "without sha");
    throw new IllegalArgumentException("without sha");
  }
  
  public String toString()
  {
    return "GetStoryVideoUploadAddressRequest{md5='" + this.b + '\'' + ", sha='" + this.c + '\'' + ", size=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVideoUploadAddrRequest
 * JD-Core Version:    0.7.0.1
 */