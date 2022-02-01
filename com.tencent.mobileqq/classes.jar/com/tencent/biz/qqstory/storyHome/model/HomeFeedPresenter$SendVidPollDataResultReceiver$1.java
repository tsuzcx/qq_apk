package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import wse;
import wth;
import yme;
import ymx;
import ynk;

public class HomeFeedPresenter$SendVidPollDataResultReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$SendVidPollDataResultReceiver$1(ynk paramynk, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry) {}
  
  public void run()
  {
    wse localwse = (wse)wth.a(17);
    if (ymx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.type = 3;
      localwse.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
    for (;;)
    {
      ((yme)wth.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      localwse.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidPollDataResultReceiver.1
 * JD-Core Version:    0.7.0.1
 */