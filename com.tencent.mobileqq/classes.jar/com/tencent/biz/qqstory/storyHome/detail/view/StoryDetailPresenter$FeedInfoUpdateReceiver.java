package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class StoryDetailPresenter$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver
{
  public StoryDetailPresenter$FeedInfoUpdateReceiver(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramFeedInfoChangeEvent.jdField_a_of_type_Int == 2) || (!paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString.equals(StoryDetailPresenter.a(paramStoryDetailPresenter))) || (StoryDetailPresenter.a(paramStoryDetailPresenter) == null))
    {
      SLog.b(this.TAG, "ignore this feed info change event. %s.", paramFeedInfoChangeEvent.toString());
      return;
    }
    SLog.a(this.TAG, "receive feed info change event. %s.", paramFeedInfoChangeEvent.toString());
    switch (paramFeedInfoChangeEvent.b)
    {
    default: 
      return;
    case 2: 
      if (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        StoryDetailPresenter.a(paramStoryDetailPresenter).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        StoryDetailPresenter.a(paramStoryDetailPresenter).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        StoryDetailPresenter.a(paramStoryDetailPresenter).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramFeedInfoChangeEvent.c);
      paramStoryDetailPresenter.a();
      return;
    }
    if (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      StoryDetailPresenter.a(paramStoryDetailPresenter).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
      StoryDetailPresenter.a(paramStoryDetailPresenter).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
      StoryDetailPresenter.a(paramStoryDetailPresenter).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendLikeCount;
      StoryDetailPresenter.a(paramStoryDetailPresenter).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanLikeCount;
    }
    LikeManager localLikeManager = (LikeManager)SuperManager.a(15);
    List localList = localLikeManager.a(paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString, true);
    StoryDetailPresenter.a(paramStoryDetailPresenter).b(localList, true, true);
    if (StoryDetailPresenter.a(paramStoryDetailPresenter).a())
    {
      paramFeedInfoChangeEvent = localLikeManager.a(paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString, false);
      StoryDetailPresenter.a(paramStoryDetailPresenter).b(paramFeedInfoChangeEvent, true, false);
    }
    paramStoryDetailPresenter.a();
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */