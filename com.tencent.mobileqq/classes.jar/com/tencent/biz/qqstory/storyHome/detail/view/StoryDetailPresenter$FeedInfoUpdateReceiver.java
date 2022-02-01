package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class StoryDetailPresenter$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver<StoryDetailPresenter, FeedInfoChangeEvent>
{
  public StoryDetailPresenter$FeedInfoUpdateReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramFeedInfoChangeEvent.a != 2) && (paramFeedInfoChangeEvent.b.equals(StoryDetailPresenter.f(paramStoryDetailPresenter))) && (StoryDetailPresenter.a(paramStoryDetailPresenter) != null))
    {
      SLog.a(this.TAG, "receive feed info change event. %s.", paramFeedInfoChangeEvent.toString());
      int i = paramFeedInfoChangeEvent.d;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (paramFeedInfoChangeEvent.c != null)
          {
            StoryDetailPresenter.a(paramStoryDetailPresenter).a.mHadLike = paramFeedInfoChangeEvent.c.mHadLike;
            StoryDetailPresenter.a(paramStoryDetailPresenter).a.mLikeCount = paramFeedInfoChangeEvent.c.mLikeCount;
            StoryDetailPresenter.a(paramStoryDetailPresenter).a.mFriendLikeCount = paramFeedInfoChangeEvent.c.mFriendLikeCount;
            StoryDetailPresenter.a(paramStoryDetailPresenter).a.mFanLikeCount = paramFeedInfoChangeEvent.c.mFanLikeCount;
          }
          localObject = (LikeManager)SuperManager.a(15);
          localList = ((LikeManager)localObject).a(paramFeedInfoChangeEvent.b, true);
          StoryDetailPresenter.a(paramStoryDetailPresenter).b(localList, true, true);
          if (StoryDetailPresenter.a(paramStoryDetailPresenter).b())
          {
            paramFeedInfoChangeEvent = ((LikeManager)localObject).a(paramFeedInfoChangeEvent.b, false);
            StoryDetailPresenter.a(paramStoryDetailPresenter).b(paramFeedInfoChangeEvent, true, false);
          }
          paramStoryDetailPresenter.a();
          return;
        }
        if (paramFeedInfoChangeEvent.c != null)
        {
          StoryDetailPresenter.a(paramStoryDetailPresenter).a.mCommentCount = paramFeedInfoChangeEvent.c.mCommentCount;
          StoryDetailPresenter.a(paramStoryDetailPresenter).a.mFriendCommentCount = paramFeedInfoChangeEvent.c.mFriendCommentCount;
          StoryDetailPresenter.a(paramStoryDetailPresenter).a.mFanCommentCount = paramFeedInfoChangeEvent.c.mFanCommentCount;
        }
        StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramFeedInfoChangeEvent.e);
        paramStoryDetailPresenter.a();
        return;
      }
      if (paramFeedInfoChangeEvent.c != null)
      {
        StoryDetailPresenter.a(paramStoryDetailPresenter).a.mCommentCount = paramFeedInfoChangeEvent.c.mCommentCount;
        StoryDetailPresenter.a(paramStoryDetailPresenter).a.mFriendCommentCount = paramFeedInfoChangeEvent.c.mFriendCommentCount;
        StoryDetailPresenter.a(paramStoryDetailPresenter).a.mFanCommentCount = paramFeedInfoChangeEvent.c.mFanCommentCount;
      }
      Object localObject = (CommentManager)SuperManager.a(17);
      List localList = ((CommentManager)localObject).a(paramFeedInfoChangeEvent.b, true);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(localList, true, true);
      if (StoryDetailPresenter.a(paramStoryDetailPresenter).b())
      {
        paramFeedInfoChangeEvent = ((CommentManager)localObject).a(paramFeedInfoChangeEvent.b, false);
        StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramFeedInfoChangeEvent, true, false);
      }
      paramStoryDetailPresenter.a();
      return;
    }
    SLog.b(this.TAG, "ignore this feed info change event. %s.", paramFeedInfoChangeEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */