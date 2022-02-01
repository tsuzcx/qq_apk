package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.events.RequireUserItemEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class MsgTabStoryNodeDelegate$RequireUserItemEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, RequireUserItemEvent>
{
  public MsgTabStoryNodeDelegate$RequireUserItemEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull RequireUserItemEvent paramRequireUserItemEvent)
  {
    paramMsgTabStoryNodeDelegate.a.a(paramRequireUserItemEvent.a);
  }
  
  public Class acceptEventClass()
  {
    return RequireUserItemEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.RequireUserItemEventReceiver
 * JD-Core Version:    0.7.0.1
 */