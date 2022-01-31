package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class MsgTabStoryNodeDelegate$UpdateUserInfoEventReceiver
  extends QQUIEventReceiver
{
  public MsgTabStoryNodeDelegate$UpdateUserInfoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    int j;
    int i;
    if ((paramUpdateUserInfoEvent.errorInfo.isSuccess()) && (paramUpdateUserInfoEvent.a != null) && (!paramUpdateUserInfoEvent.a.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver isSuccess userUIItems: " + paramUpdateUserInfoEvent.a);
      }
      j = paramUpdateUserInfoEvent.a.size();
      i = 0;
    }
    while (i < j)
    {
      QQUserUIItem localQQUserUIItem = (QQUserUIItem)paramUpdateUserInfoEvent.a.get(i);
      paramMsgTabStoryNodeDelegate.a(paramMsgTabStoryNodeDelegate.a.a(localQQUserUIItem.uid));
      i += 1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramUpdateUserInfoEvent.errorInfo + ", userUIItems = " + paramUpdateUserInfoEvent.a);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */