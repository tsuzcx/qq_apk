package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$UpdateMsgTabCoverEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, MsgTabStoryNodeDelegate.UpdateMsgTabCoverEvent>
{
  public MsgTabStoryNodeDelegate$UpdateMsgTabCoverEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull MsgTabStoryNodeDelegate.UpdateMsgTabCoverEvent paramUpdateMsgTabCoverEvent)
  {
    MsgTabStoryNodeDelegate.a(paramMsgTabStoryNodeDelegate, paramUpdateMsgTabCoverEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, paramUpdateMsgTabCoverEvent.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return MsgTabStoryNodeDelegate.UpdateMsgTabCoverEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.UpdateMsgTabCoverEventReceiver
 * JD-Core Version:    0.7.0.1
 */