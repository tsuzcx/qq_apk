package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeedTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedTagInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetFeedTagInfoListRequest
  extends NetworkRequest<GetFeedTagInfoListRequest.GetFeedTagInfoListResponse>
{
  public List<String> e = new ArrayList();
  
  public String a()
  {
    return "StorySvc.homepage_batch_feeds_label";
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeedTagInfo localRspStoryFeedTagInfo = new qqstory_service.RspStoryFeedTagInfo();
    try
    {
      localRspStoryFeedTagInfo.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetFeedTagInfoListRequest.GetFeedTagInfoListResponse(localRspStoryFeedTagInfo);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqStoryFeedTagInfo localReqStoryFeedTagInfo = new qqstory_service.ReqStoryFeedTagInfo();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqStoryFeedTagInfo.feed_id_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    return localReqStoryFeedTagInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest
 * JD-Core Version:    0.7.0.1
 */