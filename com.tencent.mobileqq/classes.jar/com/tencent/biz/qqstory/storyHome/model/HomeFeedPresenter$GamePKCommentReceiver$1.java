package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import wqu;
import wse;
import wth;
import yme;
import ymx;
import ynf;

public class HomeFeedPresenter$GamePKCommentReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$GamePKCommentReceiver$1(ynf paramynf, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, wqu paramwqu) {}
  
  public void run()
  {
    wse localwse = (wse)wth.a(17);
    int i;
    if (ymx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      CommentEntry localCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
      if (this.jdField_a_of_type_Wqu.b == 0)
      {
        i = 3;
        localCommentEntry.type = i;
        localwse.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
    for (;;)
    {
      ((yme)wth.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      i = 4;
      break;
      localwse.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1
 * JD-Core Version:    0.7.0.1
 */