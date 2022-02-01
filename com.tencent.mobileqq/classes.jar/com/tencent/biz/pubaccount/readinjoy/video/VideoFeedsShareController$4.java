package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;

class VideoFeedsShareController$4
  implements DialogInterface.OnCancelListener
{
  VideoFeedsShareController$4(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    VideoFeedsShareController.a(this.a, "mShareActionSheet cancle button OnClick");
    if (VideoFeedsShareController.a(this.a) != null) {
      VideoFeedsShareController.a(this.a).c();
    }
    paramDialogInterface = VideoFeedsShareController.a(this.a);
    VideoFeedsShareController.a(this.a, paramDialogInterface, String.valueOf(ReadInJoyUtils.a()), paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.4
 * JD-Core Version:    0.7.0.1
 */