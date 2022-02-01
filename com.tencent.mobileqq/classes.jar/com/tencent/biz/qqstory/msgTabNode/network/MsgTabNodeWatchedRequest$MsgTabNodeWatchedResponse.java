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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabNodeWatchedResponse{errorCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest.MsgTabNodeWatchedResponse
 * JD-Core Version:    0.7.0.1
 */