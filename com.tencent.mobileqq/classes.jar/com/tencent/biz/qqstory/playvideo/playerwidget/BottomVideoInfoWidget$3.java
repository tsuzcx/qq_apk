package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import umc;
import utf;
import uvm;
import vzl;
import woy;

public class BottomVideoInfoWidget$3
  implements Runnable
{
  public BottomVideoInfoWidget$3(vzl paramvzl, boolean paramBoolean, LikeEntry paramLikeEntry, VideoListFeedItem paramVideoListFeedItem) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      vzl.a(this.this$0).b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
    for (;;)
    {
      vzl.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      utf localutf = new utf(1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      umc.a().dispatch(localutf);
      return;
      vzl.a(this.this$0).a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */