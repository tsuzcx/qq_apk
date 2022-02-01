package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$DeleteStoryVideoEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, DeleteStoryVideoEvent>
{
  public MsgTabStoryNodeDelegate$DeleteStoryVideoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    paramMsgTabStoryNodeDelegate.a.b(paramDeleteStoryVideoEvent);
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.DeleteStoryVideoEventReceiver
 * JD-Core Version:    0.7.0.1
 */