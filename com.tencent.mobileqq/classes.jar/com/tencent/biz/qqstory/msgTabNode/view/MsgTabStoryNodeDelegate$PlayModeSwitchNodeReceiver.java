package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode.PlayModeSwitchNodeEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$PlayModeSwitchNodeReceiver
  extends QQUIEventReceiver
{
  public MsgTabStoryNodeDelegate$PlayModeSwitchNodeReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull MsgTabPlayMode.PlayModeSwitchNodeEvent paramPlayModeSwitchNodeEvent)
  {
    paramMsgTabStoryNodeDelegate.a(paramPlayModeSwitchNodeEvent.a);
  }
  
  public Class acceptEventClass()
  {
    return MsgTabPlayMode.PlayModeSwitchNodeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.PlayModeSwitchNodeReceiver
 * JD-Core Version:    0.7.0.1
 */