package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Handler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;

class MsgTabNodeListLoader$1
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  MsgTabNodeListLoader$1(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "Update UserItems %s", paramUpdateUserInfoEvent);
    this.a.a.post(new MsgTabNodeListLoader.1.1(this, paramUpdateUserInfoEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.1
 * JD-Core Version:    0.7.0.1
 */