package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$UpdateMsgTabShotViewEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent>
{
  public MsgTabStoryNodeDelegate$UpdateMsgTabShotViewEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent paramUpdateTakeVideoConfigEvent)
  {
    paramMsgTabStoryNodeDelegate.b.F.d();
  }
  
  public Class acceptEventClass()
  {
    return MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.UpdateMsgTabShotViewEventReceiver
 * JD-Core Version:    0.7.0.1
 */