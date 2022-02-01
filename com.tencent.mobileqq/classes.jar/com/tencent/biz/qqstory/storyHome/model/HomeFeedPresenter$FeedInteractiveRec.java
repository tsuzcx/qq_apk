package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class HomeFeedPresenter$FeedInteractiveRec
  extends UIBaseEventReceiver<HomeFeedPresenter, FeedInfoChangeEvent>
{
  public HomeFeedPresenter$FeedInteractiveRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if (((HomeFeedPresenter.d(paramHomeFeedPresenter) == 12) && (paramFeedInfoChangeEvent.a == 3)) || ((HomeFeedPresenter.d(paramHomeFeedPresenter) == 10) && (paramFeedInfoChangeEvent.a == 0) && (paramFeedInfoChangeEvent.d != 1))) {
      return;
    }
    Object localObject = paramHomeFeedPresenter.a(paramFeedInfoChangeEvent.b);
    if (localObject == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramFeedInfoChangeEvent.b });
      return;
    }
    if (!(localObject instanceof CommentLikeHomeFeed))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramFeedInfoChangeEvent.b });
      return;
    }
    localObject = (CommentLikeHomeFeed)localObject;
    if ((paramFeedInfoChangeEvent.d != 1) && (paramFeedInfoChangeEvent.d != 2))
    {
      if (paramFeedInfoChangeEvent.d == 3)
      {
        if (paramFeedInfoChangeEvent.c != null)
        {
          ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).f).mHadLike = paramFeedInfoChangeEvent.c.mHadLike;
          ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).f).mLikeCount = paramFeedInfoChangeEvent.c.mLikeCount;
        }
        ((CommentLikeHomeFeed)localObject).b(((LikeManager)SuperManager.a(15)).a(paramFeedInfoChangeEvent.b, false), true);
      }
    }
    else
    {
      if (paramFeedInfoChangeEvent.c != null) {
        ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).f).mCommentCount = paramFeedInfoChangeEvent.c.mCommentCount;
      }
      ((CommentLikeHomeFeed)localObject).a(((CommentManager)SuperManager.a(17)).a(paramFeedInfoChangeEvent.b, false), true);
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramFeedInfoChangeEvent.b, Integer.valueOf(((CommentLikeHomeFeed)localObject).d().size()));
    }
    HomeFeedPresenter.c(paramHomeFeedPresenter).b(paramFeedInfoChangeEvent.b);
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.FeedInteractiveRec
 * JD-Core Version:    0.7.0.1
 */