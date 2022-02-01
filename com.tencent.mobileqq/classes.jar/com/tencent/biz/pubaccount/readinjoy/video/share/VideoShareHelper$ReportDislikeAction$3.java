package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class VideoShareHelper$ReportDislikeAction$3
  implements DialogInterface.OnShowListener
{
  VideoShareHelper$ReportDislikeAction$3(VideoShareHelper.ReportDislikeAction paramReportDislikeAction) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "mDisLikeActionSheet onShow() on VideoChannel");
    }
    VideoShareHelper.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.ReportDislikeAction.3
 * JD-Core Version:    0.7.0.1
 */