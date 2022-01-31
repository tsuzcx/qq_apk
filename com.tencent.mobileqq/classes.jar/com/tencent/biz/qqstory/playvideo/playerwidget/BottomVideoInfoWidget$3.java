package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import stb;
import tae;
import tcl;
import ugk;
import uvx;

public class BottomVideoInfoWidget$3
  implements Runnable
{
  public BottomVideoInfoWidget$3(ugk paramugk, boolean paramBoolean, LikeEntry paramLikeEntry, VideoListFeedItem paramVideoListFeedItem) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      ugk.a(this.this$0).b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
    for (;;)
    {
      ugk.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      tae localtae = new tae(1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      stb.a().dispatch(localtae);
      return;
      ugk.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */