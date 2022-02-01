package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeWatched;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class MsgTabNodeClickRequest
  extends NetworkRequest<MsgTabNodeClickRequest.MsgTabNodeWatchedResponse>
{
  static final String a = StoryApi.a("StorySvc.msgtab_node_click");
  public long b;
  public String b;
  public int c;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeWatched localRspMsgTabNodeWatched = new qqstory_service.RspMsgTabNodeWatched();
    try
    {
      localRspMsgTabNodeWatched.mergeFrom(paramArrayOfByte);
      return new MsgTabNodeClickRequest.MsgTabNodeWatchedResponse(localRspMsgTabNodeWatched);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory.msgTab:ReqMsgTabNodeClick", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return a;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqMsgTabNodeWatched localReqMsgTabNodeWatched = new qqstory_service.ReqMsgTabNodeWatched();
    localReqMsgTabNodeWatched.unionID.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    localReqMsgTabNodeWatched.node_type.set(this.c);
    localReqMsgTabNodeWatched.operation.set(3);
    localReqMsgTabNodeWatched.recommend_id.set(this.jdField_b_of_type_Long);
    return localReqMsgTabNodeWatched.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeClickRequest
 * JD-Core Version:    0.7.0.1
 */