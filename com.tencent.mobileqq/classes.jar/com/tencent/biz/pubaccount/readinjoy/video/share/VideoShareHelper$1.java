package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;
import com.tencent.qphone.base.util.QLog;

class VideoShareHelper$1
  implements DialogInterface.OnDismissListener
{
  VideoShareHelper$1(VideoShareHelper paramVideoShareHelper) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (VideoShareHelper.a(this.a) != null) {
      VideoShareHelper.a(this.a).a(VideoShareHelper.a(this.a), VideoShareHelper.b(this.a), false, false);
    }
    VideoShareHelper.a(this.a, true);
    VideoShareHelper.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.1
 * JD-Core Version:    0.7.0.1
 */