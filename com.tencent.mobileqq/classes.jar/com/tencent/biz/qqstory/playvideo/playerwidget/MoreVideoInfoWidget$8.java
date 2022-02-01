package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tribe.async.dispatch.Dispatcher;

class MoreVideoInfoWidget$8
  implements DialogInterface.OnClickListener
{
  MoreVideoInfoWidget$8(MoreVideoInfoWidget paramMoreVideoInfoWidget, VideoViewVideoHolder paramVideoViewVideoHolder, StoryVideoItem paramStoryVideoItem, FeedVideoManager paramFeedVideoManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
    if (paramDialogInterface != null) {
      paramDialogInterface.c(false);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget.a("");
      if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
      {
        ((StoryVideoUploadManager)SuperManager.a(3)).c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
        paramDialogInterface = new DeleteStoryVideoEvent(new ErrorMessage(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, false);
        paramDialogInterface.b = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid;
        paramDialogInterface.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoIndex;
        if (paramDialogInterface.a == 0L) {
          paramDialogInterface.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime;
        }
        StoryDispatcher.a().dispatch(paramDialogInterface);
      }
      else if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mStoryType == 2)
      {
        ((TroopStoryManager)PlayModeUtils.a().getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, false, new MoreVideoInfoWidget.8.1(this));
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget.a.b, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget.a.b, 1, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        new DeleteStoryVideoHandler().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      }
      StoryReportor.a("play_video", "suc_del", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.8
 * JD-Core Version:    0.7.0.1
 */