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
    if (paramUpdateUserInfoEvent.g.isSuccess())
    {
      if (QLog.isDevelopLevel())
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get userinfo come back. >>>>>> ");
        localStringBuilder.append(paramUpdateUserInfoEvent.b);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      paramStoryMessageListActivity.f();
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.UpdateUserInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */