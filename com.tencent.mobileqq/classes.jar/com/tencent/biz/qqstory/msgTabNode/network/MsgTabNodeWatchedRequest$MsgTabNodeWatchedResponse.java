package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;

public class MsgTabNodeWatchedRequest$MsgTabNodeWatchedResponse
  extends BaseResponse
{
  public MsgTabNodeWatchedRequest$MsgTabNodeWatchedResponse(qqstory_service.RspMsgTabNodeWatched paramRspMsgTabNodeWatched)
  {
    super(paramRspMsgTabNodeWatched.result);
  }
  
  public String toString()
  {
    return "MsgTabNodeWatchedResponse{errorCode=" + this.a + ", errorMsg='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest.MsgTabNodeWatchedResponse
 * JD-Core Version:    0.7.0.1
 */