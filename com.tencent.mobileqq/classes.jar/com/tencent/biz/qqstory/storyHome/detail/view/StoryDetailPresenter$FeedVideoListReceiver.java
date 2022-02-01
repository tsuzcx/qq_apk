package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class StoryDetailPresenter$FeedVideoListReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, VideoListPageLoader.GetVideoListEvent>
{
  StoryDetailPresenter$FeedVideoListReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if ((paramGetVideoListEvent.e.equals(StoryDetailPresenter.f(paramStoryDetailPresenter))) && (!paramGetVideoListEvent.g.isFail()) && (StoryDetailPresenter.a(paramStoryDetailPresenter) != null))
    {
      if (!StoryDetailPresenter.a(paramStoryDetailPresenter).e())
      {
        SLog.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramGetVideoListEvent.toString() });
        return;
      }
      SLog.a(this.TAG, "receive comment list event. %s.", paramGetVideoListEvent.toString());
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramGetVideoListEvent.h, paramGetVideoListEvent.c);
      StoryDetailPresenter.a(paramStoryDetailPresenter).f().updateVideoInfo(paramGetVideoListEvent.i);
      if (StoryDetailPresenter.a(paramStoryDetailPresenter).a().size() < 1)
      {
        StoryDetailPresenter.e(paramStoryDetailPresenter).b();
        return;
      }
      paramStoryDetailPresenter.a();
      return;
    }
    SLog.b(this.TAG, "ignore this comment list event. %s.", paramGetVideoListEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return VideoListPageLoader.GetVideoListEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.FeedVideoListReceiver
 * JD-Core Version:    0.7.0.1
 */