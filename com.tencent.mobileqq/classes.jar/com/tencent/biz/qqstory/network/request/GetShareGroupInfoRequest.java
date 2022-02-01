package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareGroupInfo;
import com.tencent.biz.qqstory.network.response.GetShareGroupInfoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupInfoRequest
  extends NetworkRequest<GetShareGroupInfoResponse>
{
  public List<String> e;
  private final String f = StoryApi.a("StorySvc.get_share_group_info");
  
  public String a()
  {
    return this.f;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetShareGroupInfo localRspGetShareGroupInfo = new qqstory_service.RspGetShareGroupInfo();
    try
    {
      localRspGetShareGroupInfo.mergeFrom(paramArrayOfByte);
      return new GetShareGroupInfoResponse(localRspGetShareGroupInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.shareGroup:GetShareGroupInfoRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetShareGroupInfo localReqGetShareGroupInfo = new qqstory_service.ReqGetShareGroupInfo();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqGetShareGroupInfo.share_group_id_list.add(str);
    }
    return localReqGetShareGroupInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupInfoRequest
 * JD-Core Version:    0.7.0.1
 */