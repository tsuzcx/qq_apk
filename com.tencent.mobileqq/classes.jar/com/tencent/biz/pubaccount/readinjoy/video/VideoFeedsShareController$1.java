package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class VideoFeedsShareController$1
  implements DialogInterface.OnDismissListener
{
  VideoFeedsShareController$1(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!VideoFeedsShareController.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      VideoFeedsShareController.a(paramDialogInterface, bool);
      if ((VideoFeedsShareController.a(this.a) != null) && (VideoFeedsShareController.a(this.a).b()) && (VideoFeedsShareController.b(this.a)) && (VideoFeedsShareController.a(this.a))) {
        VideoFeedsShareController.a(this.a).c();
      }
      if (VideoFeedsShareController.a(this.a) != null) {
        VideoFeedsShareController.a(this.a).g();
      }
      VideoFeedsShareController.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.1
 * JD-Core Version:    0.7.0.1
 */