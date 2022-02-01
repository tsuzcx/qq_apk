package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$StoryVideoPublishStatusEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, StoryVideoUploadManager.StoryVideoPublishStatusEvent>
{
  public MsgTabStoryNodeDelegate$StoryVideoPublishStatusEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    paramMsgTabStoryNodeDelegate.a.b(paramStoryVideoPublishStatusEvent);
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.StoryVideoPublishStatusEventReceiver
 * JD-Core Version:    0.7.0.1
 */