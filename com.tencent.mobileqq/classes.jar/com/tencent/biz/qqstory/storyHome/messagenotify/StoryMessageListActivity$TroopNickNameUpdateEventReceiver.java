package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.TroopNickNameManager.TroopNickNameUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class StoryMessageListActivity$TroopNickNameUpdateEventReceiver
  extends QQUIEventReceiver<StoryMessageListActivity, TroopNickNameManager.TroopNickNameUpdateEvent>
{
  public StoryMessageListActivity$TroopNickNameUpdateEventReceiver(@NonNull StoryMessageListActivity paramStoryMessageListActivity)
  {
    super(paramStoryMessageListActivity);
  }
  
  public void a(@NonNull StoryMessageListActivity paramStoryMessageListActivity, @NonNull TroopNickNameManager.TroopNickNameUpdateEvent paramTroopNickNameUpdateEvent)
  {
    if (paramTroopNickNameUpdateEvent.a.isSuccess())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 2, "TroopNickNameUpdateEvent");
      }
      paramStoryMessageListActivity.g();
    }
  }
  
  public Class acceptEventClass()
  {
    return TroopNickNameManager.TroopNickNameUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.TroopNickNameUpdateEventReceiver
 * JD-Core Version:    0.7.0.1
 */