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

public class MsgTabNodeWatchedRequest
  extends NetworkRequest
{
  static final String a;
  public long a;
  public String b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.msgtab_node_watched");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgTabNodeWatched localRspMsgTabNodeWatched = new qqstory_service.RspMsgTabNodeWatched();
    try
    {
      localRspMsgTabNodeWatched.mergeFrom(paramArrayOfByte);
      return new MsgTabNodeWatchedRequest.MsgTabNodeWatchedResponse(localRspMsgTabNodeWatched);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory.msgTab:ReqMsgTabNodeWatched", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgTabNodeWatched localReqMsgTabNodeWatched = new qqstory_service.ReqMsgTabNodeWatched();
    localReqMsgTabNodeWatched.unionID.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqMsgTabNodeWatched.node_type.set(this.c);
    localReqMsgTabNodeWatched.operation.set(this.d);
    if (this.d == 1) {
      localReqMsgTabNodeWatched.recommend_id.set(this.jdField_a_of_type_Long);
    }
    return localReqMsgTabNodeWatched.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest
 * JD-Core Version:    0.7.0.1
 */