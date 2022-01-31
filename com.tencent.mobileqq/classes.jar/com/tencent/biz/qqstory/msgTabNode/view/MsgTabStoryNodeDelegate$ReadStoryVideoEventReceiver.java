package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tribe.async.dispatch.QQUIEventReceiver;
import nja;

public final class MsgTabStoryNodeDelegate$ReadStoryVideoEventReceiver
  extends QQUIEventReceiver
{
  public MsgTabStoryNodeDelegate$ReadStoryVideoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull ReadStoryVideoEvent paramReadStoryVideoEvent)
  {
    SLog.a(this.TAG, "onEvent, %s", String.valueOf(paramReadStoryVideoEvent));
    MsgTabNodeInfo localMsgTabNodeInfo = paramMsgTabStoryNodeDelegate.a.a(3, "");
    if ((localMsgTabNodeInfo != null) && (paramReadStoryVideoEvent.b.equals(localMsgTabNodeInfo.e)))
    {
      SLog.b(this.TAG, "onEvent, guideInfoNode read");
      paramMsgTabStoryNodeDelegate = new MsgTabNodeWatchedRequest();
      paramMsgTabStoryNodeDelegate.b = localMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
      paramMsgTabStoryNodeDelegate.c = localMsgTabNodeInfo.jdField_a_of_type_Int;
      paramMsgTabStoryNodeDelegate.d = 0;
      CmdTaskManger.a().a(paramMsgTabStoryNodeDelegate, null);
      return;
    }
    ThreadManagerV2.excute(new nja(this, paramMsgTabStoryNodeDelegate, paramReadStoryVideoEvent), 16, null, true);
  }
  
  public Class acceptEventClass()
  {
    return ReadStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.ReadStoryVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */