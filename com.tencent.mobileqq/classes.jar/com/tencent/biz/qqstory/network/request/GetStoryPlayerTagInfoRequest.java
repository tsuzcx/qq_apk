package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryPlayerTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryPlayerTagInfo;
import com.tencent.biz.qqstory.network.response.GetStoryPlayerTagInfoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;

public class GetStoryPlayerTagInfoRequest
  extends NetworkRequest<GetStoryPlayerTagInfoResponse>
{
  public final List<String> e;
  
  public GetStoryPlayerTagInfoRequest(List<String> paramList)
  {
    this.e = paramList;
  }
  
  public String a()
  {
    return "StorySvc.get_video_tag_778";
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryPlayerTagInfo localRspStoryPlayerTagInfo = new qqstory_service.RspStoryPlayerTagInfo();
    try
    {
      localRspStoryPlayerTagInfo.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.e("Q.qqstory.net:GetStoryPlayerTagInfoRequest", paramArrayOfByte.toString());
    }
    return new GetStoryPlayerTagInfoResponse(localRspStoryPlayerTagInfo);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqStoryPlayerTagInfo localReqStoryPlayerTagInfo = new qqstory_service.ReqStoryPlayerTagInfo();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqStoryPlayerTagInfo.vid_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    localReqStoryPlayerTagInfo.client.set(2);
    localReqStoryPlayerTagInfo.version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    return localReqStoryPlayerTagInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest
 * JD-Core Version:    0.7.0.1
 */