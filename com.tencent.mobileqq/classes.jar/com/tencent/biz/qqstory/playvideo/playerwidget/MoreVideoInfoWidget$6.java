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
    if (QLog.isDevelopLevel())
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[az]isResumeVideoPlaySelf === >");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangBoolean);
      QLog.i(paramDialogInterface, 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ArrayOfJavaLangBoolean[0].booleanValue())
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder;
      if (paramDialogInterface != null) {
        paramDialogInterface.c(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.6
 * JD-Core Version:    0.7.0.1
 */