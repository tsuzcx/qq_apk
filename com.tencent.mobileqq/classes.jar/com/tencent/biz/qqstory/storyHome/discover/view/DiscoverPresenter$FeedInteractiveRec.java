package com.tencent.biz.qqstory.storyHome.discover.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class DiscoverPresenter$FeedInteractiveRec
  extends UIBaseEventReceiver
{
  public DiscoverPresenter$FeedInteractiveRec(DiscoverPresenter paramDiscoverPresenter)
  {
    super(paramDiscoverPresenter);
  }
  
  public void a(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)) {
      DiscoverPresenter.a(paramDiscoverPresenter, paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString, paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount);
    }
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter.FeedInteractiveRec
 * JD-Core Version:    0.7.0.1
 */