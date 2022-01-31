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
  public static final String a = StoryApi.a("StorySvc.get_group_node_vid_list");
  public String b;
  public int c;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetGroupVidList localRspGetGroupVidList = new qqstory_service.RspGetGroupVidList();
    try
    {
      localRspGetGroupVidList.mergeFrom(paramArrayOfByte);
      return new GetGroupVidListResponse(localRspGetGroupVidList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetGroupVidList localReqGetGroupVidList = new qqstory_service.ReqGetGroupVidList();
    localReqGetGroupVidList.pull_type.set(this.c);
    localReqGetGroupVidList.union_id.set(this.b);
    return localReqGetGroupVidList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetGroupVidListRequest
 * JD-Core Version:    0.7.0.1
 */