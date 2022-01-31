package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class HomeFeedPresenter$FeedCommentRec
  extends UIBaseEventReceiver
{
  public HomeFeedPresenter$FeedCommentRec(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    int i = 1;
    if (paramGetFeedCommentEvent.errorInfo.isSuccess())
    {
      localObject = paramHomeFeedPresenter.a(paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof CommentLikeHomeFeed))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (CommentLikeHomeFeed)localObject;
    ((CommentLikeHomeFeed)localObject).a(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList, paramGetFeedCommentEvent.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).a;
    if (paramGetFeedCommentEvent.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).a).mCommentLastCookie = paramGetFeedCommentEvent.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).a).mCommentCount = paramGetFeedCommentEvent.jdField_b_of_type_Int;
      ((FeedManager)SuperManager.a(11)).a(((CommentLikeHomeFeed)localObject).a);
      HomeFeedPresenter.a(paramHomeFeedPresenter).b(paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString);
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString, Integer.valueOf(((CommentLikeHomeFeed)localObject).b().size()), Boolean.valueOf(paramGetFeedCommentEvent.jdField_a_of_type_Boolean), paramGetFeedCommentEvent.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return CommentListPageLoader.GetFeedCommentEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.FeedCommentRec
 * JD-Core Version:    0.7.0.1
 */