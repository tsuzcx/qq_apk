package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import wjj;
import wqm;
import wst;
import xwr;
import yme;

public class BottomVideoInfoWidget$3
  implements Runnable
{
  public BottomVideoInfoWidget$3(xwr paramxwr, boolean paramBoolean, LikeEntry paramLikeEntry, VideoListFeedItem paramVideoListFeedItem) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      xwr.a(this.this$0).b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
    for (;;)
    {
      xwr.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      wqm localwqm = new wqm(1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      wjj.a().dispatch(localwqm);
      return;
      xwr.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */