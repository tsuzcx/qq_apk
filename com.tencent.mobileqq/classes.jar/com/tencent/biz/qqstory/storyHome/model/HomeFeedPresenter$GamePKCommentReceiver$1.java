package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.database.CommentEntry;
import snt;
import spd;
import sqg;
import uje;
import ujx;
import ukf;

public class HomeFeedPresenter$GamePKCommentReceiver$1
  implements Runnable
{
  public HomeFeedPresenter$GamePKCommentReceiver$1(ukf paramukf, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, snt paramsnt) {}
  
  public void run()
  {
    spd localspd = (spd)sqg.a(17);
    int i;
    if (ujx.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      CommentEntry localCommentEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
      if (this.jdField_a_of_type_Snt.b == 0)
      {
        i = 3;
        localCommentEntry.type = i;
        localspd.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      }
    }
    for (;;)
    {
      ((uje)sqg.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      i = 4;
      break;
      localspd.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1
 * JD-Core Version:    0.7.0.1
 */