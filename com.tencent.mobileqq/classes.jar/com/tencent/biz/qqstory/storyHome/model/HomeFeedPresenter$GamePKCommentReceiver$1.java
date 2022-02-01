package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import whg;
import wip;
import wjs;
import yck;
import ydd;
import ydl;

public class HomeFeedPresenter$GamePKCommentReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$GamePKCommentReceiver$1(ydl paramydl, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, whg paramwhg) {}
  
  public void run()
  {
    wip localwip = (wip)wjs.a(17);
    int i;
    if (ydd.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      CommentEntry localCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
      if (this.jdField_a_of_type_Whg.b == 0)
      {
        i = 3;
        localCommentEntry.type = i;
        localwip.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
    for (;;)
    {
      ((yck)wjs.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      i = 4;
      break;
      localwip.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1
 * JD-Core Version:    0.7.0.1
 */