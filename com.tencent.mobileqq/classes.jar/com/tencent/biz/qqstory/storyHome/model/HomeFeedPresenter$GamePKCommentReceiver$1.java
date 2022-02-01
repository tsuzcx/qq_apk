package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.comment.GamePKCommentEvent;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;

class HomeFeedPresenter$GamePKCommentReceiver$1
  implements Runnable
{
  HomeFeedPresenter$GamePKCommentReceiver$1(HomeFeedPresenter.GamePKCommentReceiver paramGamePKCommentReceiver, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, GamePKCommentEvent paramGamePKCommentEvent) {}
  
  public void run()
  {
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    if (HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      CommentEntry localCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
      int i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryCommentGamePKCommentEvent.b == 0) {
        i = 3;
      } else {
        i = 4;
      }
      localCommentEntry.type = i;
      localCommentManager.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
    else
    {
      localCommentManager.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
    ((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1
 * JD-Core Version:    0.7.0.1
 */