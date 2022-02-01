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
  public final String e = StoryApi.a("StorySvc.forbid_video");
  public String f = "";
  
  public ReportNoInterestingVideoHandler$ReportIgnoreVideoRequest(ReportNoInterestingVideoHandler paramReportNoInterestingVideoHandler, String paramString)
  {
    this.f = paramString;
  }
  
  public ReportNoInterestingVideoHandler.ReportIgnoreVideoResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspForbidVideo localRspForbidVideo = new qqstory_service.RspForbidVideo();
    try
    {
      localRspForbidVideo.mergeFrom(paramArrayOfByte);
      return new ReportNoInterestingVideoHandler.ReportIgnoreVideoResponse(this.g, localRspForbidVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.e;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqForbidVideo localReqForbidVideo = new qqstory_service.ReqForbidVideo();
    localReqForbidVideo.vid.set(this.f);
    return localReqForbidVideo.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportIgnoreVideoRequest{, vid='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportIgnoreVideoRequest
 * JD-Core Version:    0.7.0.1
 */