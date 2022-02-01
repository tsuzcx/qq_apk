package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.widget.ActionSheet.OnDismissListener;
import java.util.concurrent.atomic.AtomicBoolean;

class MoreVideoInfoWidget$3
  implements ActionSheet.OnDismissListener
{
  MoreVideoInfoWidget$3(MoreVideoInfoWidget paramMoreVideoInfoWidget, AtomicBoolean paramAtomicBoolean, VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onDismiss()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */