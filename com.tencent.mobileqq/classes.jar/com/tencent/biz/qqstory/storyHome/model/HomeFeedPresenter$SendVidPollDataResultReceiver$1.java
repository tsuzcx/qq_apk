package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import tbw;
import tcz;
import uvx;
import uwq;
import uxd;

public class HomeFeedPresenter$SendVidPollDataResultReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$SendVidPollDataResultReceiver$1(uxd paramuxd, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry) {}
  
  public void run()
  {
    tbw localtbw = (tbw)tcz.a(17);
    if (uwq.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.type = 3;
      localtbw.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
    for (;;)
    {
      ((uvx)tcz.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      localtbw.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidPollDataResultReceiver.1
 * JD-Core Version:    0.7.0.1
 */