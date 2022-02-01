package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$PlayModeSwitchNodeReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, PlayVideoChangeEvent>
{
  public MsgTabStoryNodeDelegate$PlayModeSwitchNodeReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull PlayVideoChangeEvent paramPlayVideoChangeEvent)
  {
    if ((paramMsgTabStoryNodeDelegate.a.a().equals(paramPlayVideoChangeEvent.jdField_a_of_type_JavaLangString)) && ((paramPlayVideoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId instanceof MsgTabPlayPageLoader.MsgTabGroupId))) {
      paramMsgTabStoryNodeDelegate.a(((MsgTabPlayPageLoader.MsgTabGroupId)paramPlayVideoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId).a(), paramPlayVideoChangeEvent.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayVideoChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.PlayModeSwitchNodeReceiver
 * JD-Core Version:    0.7.0.1
 */