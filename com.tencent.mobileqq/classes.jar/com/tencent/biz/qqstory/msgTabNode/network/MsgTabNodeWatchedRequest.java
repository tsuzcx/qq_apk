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
  extends NetworkRequest<MsgTabNodeWatchedRequest.MsgTabNodeWatchedResponse>
{
  static final String e = StoryApi.a("StorySvc.msgtab_node_watched");
  public String f;
  public int g;
  public int h;
  public long i;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspMsgTabNodeWatched();
    try
    {
      ((qqstory_service.RspMsgTabNodeWatched)localObject).mergeFrom(paramArrayOfByte);
      return new MsgTabNodeWatchedRequest.MsgTabNodeWatchedResponse((qqstory_service.RspMsgTabNodeWatched)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory.msgTab:ReqMsgTabNodeWatched", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqMsgTabNodeWatched localReqMsgTabNodeWatched = new qqstory_service.ReqMsgTabNodeWatched();
    localReqMsgTabNodeWatched.unionID.set(ByteStringMicro.copyFromUtf8(this.f));
    localReqMsgTabNodeWatched.node_type.set(this.g);
    localReqMsgTabNodeWatched.operation.set(this.h);
    localReqMsgTabNodeWatched.recommend_id.set(this.i);
    return localReqMsgTabNodeWatched.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest
 * JD-Core Version:    0.7.0.1
 */