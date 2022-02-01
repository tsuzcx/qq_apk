package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qphone.base.util.QLog;

class MoreVideoInfoWidget$6
  implements DialogInterface.OnDismissListener
{
  MoreVideoInfoWidget$6(MoreVideoInfoWidget paramMoreVideoInfoWidget, Boolean[] paramArrayOfBoolean, VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget.b, 2, "[az]isResumeVideoPlaySelf === >" + this.jdField_a_of_type_ArrayOfJavaLangBoolean);
    }
    if ((!this.jdField_a_of_type_ArrayOfJavaLangBoolean[0].booleanValue()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.6
 * JD-Core Version:    0.7.0.1
 */