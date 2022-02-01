package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class MsgTabStoryNodeDelegate$ReadStoryVideoEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, ReadStoryVideoEvent>
{
  public MsgTabStoryNodeDelegate$ReadStoryVideoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull ReadStoryVideoEvent paramReadStoryVideoEvent)
  {
    SLog.a(this.TAG, "onEvent, %s", String.valueOf(paramReadStoryVideoEvent));
    MsgTabNodeInfo localMsgTabNodeInfo = paramMsgTabStoryNodeDelegate.a.a(3, "");
    if ((localMsgTabNodeInfo != null) && (paramReadStoryVideoEvent.c.equals(localMsgTabNodeInfo.n)))
    {
      SLog.b(this.TAG, "onEvent, guideInfoNode read");
      paramMsgTabStoryNodeDelegate = new MsgTabNodeWatchedRequest();
      paramMsgTabStoryNodeDelegate.f = localMsgTabNodeInfo.d;
      paramMsgTabStoryNodeDelegate.g = localMsgTabNodeInfo.b;
      paramMsgTabStoryNodeDelegate.h = 5;
      paramMsgTabStoryNodeDelegate.i = localMsgTabNodeInfo.j;
      CmdTaskManger.a().a(paramMsgTabStoryNodeDelegate, null);
      return;
    }
    paramMsgTabStoryNodeDelegate.a.b(paramReadStoryVideoEvent.a, paramReadStoryVideoEvent.b);
  }
  
  public Class acceptEventClass()
  {
    return ReadStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.ReadStoryVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */