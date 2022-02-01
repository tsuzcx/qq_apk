package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class MsgTabStoryNodeDelegate$UpdateUserInfoEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public MsgTabStoryNodeDelegate$UpdateUserInfoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList != null) && (!paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramMsgTabStoryNodeDelegate.a.b(paramUpdateUserInfoEvent);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMsgTabStoryNodeDelegate = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: ");
      localStringBuilder.append(paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
      localStringBuilder.append(", userUIItems = ");
      localStringBuilder.append(paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList);
      QLog.i(paramMsgTabStoryNodeDelegate, 2, localStringBuilder.toString());
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */