package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;

class HomeFeedPresenter$LikeListReceiver
  extends UIBaseEventReceiver<HomeFeedPresenter, DetailLikeListLoader.GetLikeListEvent>
{
  HomeFeedPresenter$LikeListReceiver(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent)
  {
    Object localObject = paramHomeFeedPresenter.a(paramGetLikeListEvent.a);
    if ((localObject != null) && (!paramGetLikeListEvent.b))
    {
      if (!(localObject instanceof CommentLikeHomeFeed))
      {
        SLog.e(this.TAG, "that is error type!");
        return;
      }
      localObject = (CommentLikeHomeFeed)localObject;
      ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).f).mLikeCount = paramGetLikeListEvent.d;
      ((CommentLikeHomeFeed)localObject).b(paramGetLikeListEvent.f, true);
      HomeFeedPresenter.c(paramHomeFeedPresenter).b(paramGetLikeListEvent.a);
      return;
    }
    SLog.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramGetLikeListEvent.a, Boolean.valueOf(paramGetLikeListEvent.b) });
  }
  
  public Class acceptEventClass()
  {
    return DetailLikeListLoader.GetLikeListEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.LikeListReceiver
 * JD-Core Version:    0.7.0.1
 */