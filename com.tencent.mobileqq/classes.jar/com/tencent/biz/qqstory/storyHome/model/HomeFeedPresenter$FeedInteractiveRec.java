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
    if (((HomeFeedPresenter.a(paramHomeFeedPresenter) == 12) && (paramFeedInfoChangeEvent.jdField_a_of_type_Int == 3)) || ((HomeFeedPresenter.a(paramHomeFeedPresenter) == 10) && (paramFeedInfoChangeEvent.jdField_a_of_type_Int == 0) && (paramFeedInfoChangeEvent.b != 1))) {
      return;
    }
    Object localObject = paramHomeFeedPresenter.a(paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof CommentLikeHomeFeed))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (CommentLikeHomeFeed)localObject;
    if ((paramFeedInfoChangeEvent.b != 1) && (paramFeedInfoChangeEvent.b != 2))
    {
      if (paramFeedInfoChangeEvent.b == 3)
      {
        if (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).a).mHadLike = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).a).mLikeCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((CommentLikeHomeFeed)localObject).b(((LikeManager)SuperManager.a(15)).a(paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString, false), true);
      }
    }
    else
    {
      if (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).a).mCommentCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((CommentLikeHomeFeed)localObject).a(((CommentManager)SuperManager.a(17)).a(paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString, false), true);
      SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString, Integer.valueOf(((CommentLikeHomeFeed)localObject).b().size()));
    }
    HomeFeedPresenter.a(paramHomeFeedPresenter).b(paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString);
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