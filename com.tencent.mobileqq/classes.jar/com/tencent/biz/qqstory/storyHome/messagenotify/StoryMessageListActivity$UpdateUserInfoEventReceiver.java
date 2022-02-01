package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class StoryMessageListActivity$UpdateUserInfoEventReceiver
  extends QQUIEventReceiver<StoryMessageListActivity, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public StoryMessageListActivity$UpdateUserInfoEventReceiver(@NonNull StoryMessageListActivity paramStoryMessageListActivity)
  {
    super(paramStoryMessageListActivity);
  }
  
  public void a(@NonNull StoryMessageListActivity paramStoryMessageListActivity, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 2, "get userinfo come back. >>>>>> " + paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList);
      }
      paramStoryMessageListActivity.g();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */