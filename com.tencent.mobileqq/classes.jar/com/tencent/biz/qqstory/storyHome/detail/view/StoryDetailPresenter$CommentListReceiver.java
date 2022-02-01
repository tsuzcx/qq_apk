package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryDetailPresenter$CommentListReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, CommentListPageLoader.GetFeedCommentEvent>
{
  StoryDetailPresenter$CommentListReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if ((paramGetFeedCommentEvent.e.equals(StoryDetailPresenter.f(paramStoryDetailPresenter))) && (!paramGetFeedCommentEvent.g.isFail()) && (StoryDetailPresenter.a(paramStoryDetailPresenter) != null))
    {
      SLog.a(this.TAG, "receive comment list event. %s.", paramGetFeedCommentEvent.toString());
      boolean bool2 = StoryDetailPresenter.g(paramStoryDetailPresenter);
      boolean bool1 = true;
      if (paramGetFeedCommentEvent.f == 0) {
        bool1 = false;
      }
      StoryDetailPresenter.a(paramStoryDetailPresenter).g(bool1);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(bool1, paramGetFeedCommentEvent.i);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(bool1, paramGetFeedCommentEvent.a);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramGetFeedCommentEvent.k, paramGetFeedCommentEvent.c, bool1);
      if (bool2 == bool1) {
        paramStoryDetailPresenter.b(paramGetFeedCommentEvent.g.isSuccess());
      }
      return;
    }
    SLog.b(this.TAG, "ignore this comment list event. %s.", paramGetFeedCommentEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return CommentListPageLoader.GetFeedCommentEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.CommentListReceiver
 * JD-Core Version:    0.7.0.1
 */