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
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.c(false);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.d.a("");
      if (StoryVideoItem.isFakeVid(this.b.mVid))
      {
        ((StoryVideoUploadManager)SuperManager.a(3)).d(this.b.mVid);
        paramDialogInterface = new DeleteStoryVideoEvent(new ErrorMessage(), this.b.mVid, false);
        paramDialogInterface.b = this.b.mOwnerUid;
        paramDialogInterface.e = this.b.mVideoIndex;
        if (paramDialogInterface.e == 0L) {
          paramDialogInterface.e = this.b.mCreateTime;
        }
        StoryDispatcher.a().dispatch(paramDialogInterface);
      }
      else if (this.b.mStoryType == 2)
      {
        ((TroopStoryManager)PlayModeUtils.b().getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a(this.b.mVid, 0, false, new MoreVideoInfoWidget.8.1(this));
      }
      else
      {
        this.c.a(this.d.p.c, 0, this.b);
        this.c.a(this.d.p.c, 1, this.b);
        new DeleteStoryVideoHandler().a(this.b.mVid);
      }
      StoryReportor.a("play_video", "suc_del", 0, 0, new String[] { "", "", "", this.b.mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.8
 * JD-Core Version:    0.7.0.1
 */