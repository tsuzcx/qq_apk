package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class BottomVideoInfoWidget$2
  implements DialogInterface.OnDismissListener
{
  BottomVideoInfoWidget$2(BottomVideoInfoWidget paramBottomVideoInfoWidget, VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
    BottomVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget).a = BottomVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.2
 * JD-Core Version:    0.7.0.1
 */