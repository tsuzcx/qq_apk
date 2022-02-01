package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class MoreVideoInfoWidget$7
  implements DialogInterface.OnClickListener
{
  MoreVideoInfoWidget$7(MoreVideoInfoWidget paramMoreVideoInfoWidget, VideoViewVideoHolder paramVideoViewVideoHolder, StoryVideoItem paramStoryVideoItem) {}
  
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
      StoryVideoUploadManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      StoryReportor.a("play_video", "suc_del", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.7
 * JD-Core Version:    0.7.0.1
 */