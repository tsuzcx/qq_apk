package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetGroupVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetGroupVidList;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;

public class GetGroupVidListRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.get_group_node_vid_list");
  public String f;
  public int g;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetGroupVidList localRspGetGroupVidList = new qqstory_service.RspGetGroupVidList();
    try
    {
      localRspGetGroupVidList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetGroupVidListResponse(localRspGetGroupVidList);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetGroupVidList localReqGetGroupVidList = new qqstory_service.ReqGetGroupVidList();
    localReqGetGroupVidList.pull_type.set(this.g);
    localReqGetGroupVidList.union_id.set(this.f);
    return localReqGetGroupVidList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetGroupVidListRequest
 * JD-Core Version:    0.7.0.1
 */