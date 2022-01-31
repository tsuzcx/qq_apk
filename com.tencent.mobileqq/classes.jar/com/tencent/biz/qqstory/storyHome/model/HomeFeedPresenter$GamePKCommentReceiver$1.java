package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import tam;
import tbw;
import tcz;
import uvx;
import uwq;
import uwy;

public class HomeFeedPresenter$GamePKCommentReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$GamePKCommentReceiver$1(uwy paramuwy, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, tam paramtam) {}
  
  public void run()
  {
    tbw localtbw = (tbw)tcz.a(17);
    int i;
    if (uwq.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      CommentEntry localCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
      if (this.jdField_a_of_type_Tam.b == 0)
      {
        i = 3;
        localCommentEntry.type = i;
        localtbw.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
    for (;;)
    {
      ((uvx)tcz.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      i = 4;
      break;
      localtbw.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1
 * JD-Core Version:    0.7.0.1
 */