package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoInfo;
import com.tencent.biz.qqstory.network.response.GetShareGroupVideoInfoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupVideoInfoRequest
  extends NetworkRequest<GetShareGroupVideoInfoResponse>
{
  public List<String> e;
  private final String f = StoryApi.a("StoryGroupSvc.datacard_batch_get_video_info");
  
  public String a()
  {
    return this.f;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchGetVideoInfo localRspBatchGetVideoInfo = new qqstory_service.RspBatchGetVideoInfo();
    try
    {
      localRspBatchGetVideoInfo.mergeFrom(paramArrayOfByte);
      return new GetShareGroupVideoInfoResponse(localRspBatchGetVideoInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.shareGroup:GetShareGroupVideoInfoRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqBatchGetVideoInfo localReqBatchGetVideoInfo = new qqstory_service.ReqBatchGetVideoInfo();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqBatchGetVideoInfo.story_id_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    return localReqBatchGetVideoInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupVideoInfoRequest
 * JD-Core Version:    0.7.0.1
 */