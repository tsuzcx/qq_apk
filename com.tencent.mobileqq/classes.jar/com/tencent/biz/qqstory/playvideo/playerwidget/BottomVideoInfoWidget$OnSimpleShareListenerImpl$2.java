package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class BottomVideoInfoWidget$OnSimpleShareListenerImpl$2
  implements DialogInterface.OnDismissListener
{
  BottomVideoInfoWidget$OnSimpleShareListenerImpl$2(BottomVideoInfoWidget.OnSimpleShareListenerImpl paramOnSimpleShareListenerImpl) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a) != null) {
      BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.OnSimpleShareListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */