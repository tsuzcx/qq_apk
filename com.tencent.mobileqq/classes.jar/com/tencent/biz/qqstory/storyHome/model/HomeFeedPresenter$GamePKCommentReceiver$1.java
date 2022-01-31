package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import upe;
import uqo;
import urr;
import wkp;
import wli;
import wlq;

public class HomeFeedPresenter$GamePKCommentReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$GamePKCommentReceiver$1(wlq paramwlq, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, upe paramupe) {}
  
  public void run()
  {
    uqo localuqo = (uqo)urr.a(17);
    int i;
    if (wli.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      CommentEntry localCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
      if (this.jdField_a_of_type_Upe.b == 0)
      {
        i = 3;
        localCommentEntry.type = i;
        localuqo.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
    for (;;)
    {
      ((wkp)urr.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      i = 4;
      break;
      localuqo.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1
 * JD-Core Version:    0.7.0.1
 */