package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqForbidVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspForbidVideo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;

public class ReportNoInterestingVideoHandler$ReportIgnoreVideoRequest
  extends NetworkRequest<ReportNoInterestingVideoHandler.ReportIgnoreVideoResponse>
{
  public final String a;
  public String b = "";
  
  public ReportNoInterestingVideoHandler$ReportIgnoreVideoRequest(ReportNoInterestingVideoHandler paramReportNoInterestingVideoHandler, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.forbid_video");
    this.b = paramString;
  }
  
  public ReportNoInterestingVideoHandler.ReportIgnoreVideoResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspForbidVideo localRspForbidVideo = new qqstory_service.RspForbidVideo();
    try
    {
      localRspForbidVideo.mergeFrom(paramArrayOfByte);
      return new ReportNoInterestingVideoHandler.ReportIgnoreVideoResponse(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerReportNoInterestingVideoHandler, localRspForbidVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqForbidVideo localReqForbidVideo = new qqstory_service.ReqForbidVideo();
    localReqForbidVideo.vid.set(this.b);
    return localReqForbidVideo.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportIgnoreVideoRequest{, vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportIgnoreVideoRequest
 * JD-Core Version:    0.7.0.1
 */