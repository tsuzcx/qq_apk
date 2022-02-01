package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqProfileYearNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileYearNodeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetProfileYearNodeListRequest
  extends NetworkRequest
{
  public String e;
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_profile_year_node_info");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspProfileYearNodeList localRspProfileYearNodeList = new qqstory_service.RspProfileYearNodeList();
    try
    {
      localRspProfileYearNodeList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetProfileYearNodeListRequest.GetProfileYearNodeListResponse(localRspProfileYearNodeList);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqProfileYearNodeList localReqProfileYearNodeList = new qqstory_service.ReqProfileYearNodeList();
    localReqProfileYearNodeList.union_id.set(ByteStringMicro.copyFromUtf8(this.e));
    return localReqProfileYearNodeList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest
 * JD-Core Version:    0.7.0.1
 */