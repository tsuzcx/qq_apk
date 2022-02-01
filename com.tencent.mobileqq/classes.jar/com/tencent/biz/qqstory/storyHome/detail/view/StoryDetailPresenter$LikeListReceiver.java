package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryDetailPresenter$LikeListReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, DetailLikeListLoader.GetLikeListEvent>
{
  StoryDetailPresenter$LikeListReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent)
  {
    if ((paramGetLikeListEvent.b) && (paramGetLikeListEvent.a.equals(StoryDetailPresenter.f(paramStoryDetailPresenter))) && (!paramGetLikeListEvent.g.isFail()) && (StoryDetailPresenter.a(paramStoryDetailPresenter) != null))
    {
      SLog.a(this.TAG, "receive like list event. %s.", paramGetLikeListEvent.toString());
      boolean bool2 = StoryDetailPresenter.g(paramStoryDetailPresenter);
      boolean bool1;
      if (paramGetLikeListEvent.c == 0) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      StoryDetailPresenter.a(paramStoryDetailPresenter).b(bool1, paramGetLikeListEvent.d);
      StoryDetailPresenter.a(paramStoryDetailPresenter).b(paramGetLikeListEvent.f, true, bool1);
      if (bool2 == bool1) {
        paramStoryDetailPresenter.a();
      }
      return;
    }
    SLog.b(this.TAG, "ignore this like list event. %s.", paramGetLikeListEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return DetailLikeListLoader.GetLikeListEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.LikeListReceiver
 * JD-Core Version:    0.7.0.1
 */