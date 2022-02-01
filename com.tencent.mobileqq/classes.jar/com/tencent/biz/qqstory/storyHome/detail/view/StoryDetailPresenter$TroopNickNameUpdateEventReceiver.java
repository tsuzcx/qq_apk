package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.TroopNickNameManager.TroopNickNameUpdateEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class StoryDetailPresenter$TroopNickNameUpdateEventReceiver
  extends QQUIEventReceiver<StoryDetailPresenter, TroopNickNameManager.TroopNickNameUpdateEvent>
{
  public StoryDetailPresenter$TroopNickNameUpdateEventReceiver(@NonNull StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull TroopNickNameManager.TroopNickNameUpdateEvent paramTroopNickNameUpdateEvent)
  {
    if (StoryDetailPresenter.a(paramStoryDetailPresenter) == null)
    {
      SLog.b(this.TAG, "ignore this troop nick name change event. %s.", paramTroopNickNameUpdateEvent.toString());
      return;
    }
    SLog.a(this.TAG, "receive troop nick name change event. %s.", paramTroopNickNameUpdateEvent.toString());
    StoryDetailPresenter.a(paramStoryDetailPresenter).c();
  }
  
  public Class acceptEventClass()
  {
    return TroopNickNameManager.TroopNickNameUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.TroopNickNameUpdateEventReceiver
 * JD-Core Version:    0.7.0.1
 */