package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest.MsgTabNodeListResponse;

class MsgTabNodeListLoader$2
  implements CmdTaskManger.CommandCallback<MsgTabNodeListRequest, MsgTabNodeListRequest.MsgTabNodeListResponse>
{
  MsgTabNodeListLoader$2(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(@NonNull MsgTabNodeListRequest paramMsgTabNodeListRequest, @Nullable MsgTabNodeListRequest.MsgTabNodeListResponse paramMsgTabNodeListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    this.a.b.post(new MsgTabNodeListLoader.2.1(this, paramMsgTabNodeListRequest, paramMsgTabNodeListResponse, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.2
 * JD-Core Version:    0.7.0.1
 */