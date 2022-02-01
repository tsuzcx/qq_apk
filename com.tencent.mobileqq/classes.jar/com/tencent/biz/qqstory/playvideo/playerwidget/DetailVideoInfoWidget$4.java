package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.widget.ActionSheet.OnDismissListener;
import java.util.concurrent.atomic.AtomicBoolean;

class DetailVideoInfoWidget$4
  implements ActionSheet.OnDismissListener
{
  DetailVideoInfoWidget$4(DetailVideoInfoWidget paramDetailVideoInfoWidget, AtomicBoolean paramAtomicBoolean, VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onDismiss()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.4
 * JD-Core Version:    0.7.0.1
 */