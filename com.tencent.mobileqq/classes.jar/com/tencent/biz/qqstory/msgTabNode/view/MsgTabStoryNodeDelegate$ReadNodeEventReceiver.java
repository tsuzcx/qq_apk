package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$ReadNodeEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, MsgTabStoryNodeDelegate.ReadNodeEvent>
{
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull MsgTabStoryNodeDelegate.ReadNodeEvent paramReadNodeEvent)
  {
    paramMsgTabStoryNodeDelegate = paramMsgTabStoryNodeDelegate.b;
    if ((paramMsgTabStoryNodeDelegate.r) && (paramMsgTabStoryNodeDelegate.i != null))
    {
      SLog.a(this.TAG, "ReadNodeEventReceiver onEvent, updateItem : %s", paramReadNodeEvent.a);
      paramMsgTabStoryNodeDelegate.i.a(paramReadNodeEvent.a);
    }
  }
  
  public Class acceptEventClass()
  {
    return MsgTabStoryNodeDelegate.ReadNodeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.ReadNodeEventReceiver
 * JD-Core Version:    0.7.0.1
 */