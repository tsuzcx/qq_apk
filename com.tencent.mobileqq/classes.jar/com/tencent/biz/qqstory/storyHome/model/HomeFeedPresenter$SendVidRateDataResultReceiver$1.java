package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;

class HomeFeedPresenter$SendVidRateDataResultReceiver$1
  implements Runnable
{
  HomeFeedPresenter$SendVidRateDataResultReceiver$1(HomeFeedPresenter.SendVidRateDataResultReceiver paramSendVidRateDataResultReceiver, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry) {}
  
  public void run()
  {
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    if (HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.type = 3;
      localCommentManager.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
    for (;;)
    {
      ((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      localCommentManager.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1
 * JD-Core Version:    0.7.0.1
 */