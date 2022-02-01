package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;

class VideoViewVideoHolder$OnNewGuideDialogDismissListener
  implements DialogInterface.OnDismissListener
{
  private final WeakReference<VideoViewVideoHolder> a;
  private final boolean b;
  
  public VideoViewVideoHolder$OnNewGuideDialogDismissListener(VideoViewVideoHolder paramVideoViewVideoHolder, boolean paramBoolean)
  {
    this.a = new WeakReference(paramVideoViewVideoHolder);
    this.b = paramBoolean;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (VideoViewVideoHolder)this.a.get();
    if (paramDialogInterface != null) {
      if ((paramDialogInterface.b()) && (!paramDialogInterface.a().isFinishing()))
      {
        if (!paramDialogInterface.t())
        {
          paramDialogInterface.c(this.b);
          paramDialogInterface.h();
          paramDialogInterface.w = null;
        }
      }
      else {
        SLog.b("OnNewGuideDialogDismissListener", "activity token invalid, preventing from showing dialog");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.OnNewGuideDialogDismissListener
 * JD-Core Version:    0.7.0.1
 */