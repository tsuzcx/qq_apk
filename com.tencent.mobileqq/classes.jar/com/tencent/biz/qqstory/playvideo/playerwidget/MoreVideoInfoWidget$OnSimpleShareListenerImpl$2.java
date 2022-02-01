package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class MoreVideoInfoWidget$OnSimpleShareListenerImpl$2
  implements DialogInterface.OnDismissListener
{
  MoreVideoInfoWidget$OnSimpleShareListenerImpl$2(MoreVideoInfoWidget.OnSimpleShareListenerImpl paramOnSimpleShareListenerImpl) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (MoreVideoInfoWidget.OnSimpleShareListenerImpl.b(this.a) != null) {
      MoreVideoInfoWidget.OnSimpleShareListenerImpl.b(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.OnSimpleShareListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */