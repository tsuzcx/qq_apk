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
  extends NetworkRequest
{
  private final String a;
  public List a;
  
  public GetShareGroupVideoInfoRequest()
  {
    this.jdField_a_of_type_JavaLangString = StoryApi.a("StoryGroupSvc.datacard_batch_get_video_info");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
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
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqBatchGetVideoInfo localReqBatchGetVideoInfo = new qqstory_service.ReqBatchGetVideoInfo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqBatchGetVideoInfo.story_id_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    return localReqBatchGetVideoInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupVideoInfoRequest
 * JD-Core Version:    0.7.0.1
 */