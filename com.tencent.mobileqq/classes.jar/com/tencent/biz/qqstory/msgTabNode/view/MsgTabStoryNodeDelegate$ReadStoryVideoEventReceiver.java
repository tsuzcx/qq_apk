package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class MsgTabStoryNodeDelegate$ReadStoryVideoEventReceiver
  extends QQUIEventReceiver
{
  public MsgTabStoryNodeDelegate$ReadStoryVideoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull ReadStoryVideoEvent paramReadStoryVideoEvent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "Read Event: " + paramReadStoryVideoEvent);
    }
    MsgTabNodeInfo localMsgTabNodeInfo = paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(3, "");
    if ((localMsgTabNodeInfo != null) && (paramReadStoryVideoEvent.b.equals(localMsgTabNodeInfo.e)))
    {
      paramMsgTabStoryNodeDelegate = new MsgTabNodeWatchedRequest();
      paramMsgTabStoryNodeDelegate.b = localMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
      paramMsgTabStoryNodeDelegate.c = localMsgTabNodeInfo.jdField_a_of_type_Int;
      paramMsgTabStoryNodeDelegate.d = 0;
      CmdTaskManger.a().a(paramMsgTabStoryNodeDelegate, null);
    }
    while (!paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(paramReadStoryVideoEvent.jdField_a_of_type_JavaLangString, paramReadStoryVideoEvent.jdField_a_of_type_Long)) {
      return;
    }
    paramMsgTabStoryNodeDelegate.jdField_a_of_type_Boolean = true;
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