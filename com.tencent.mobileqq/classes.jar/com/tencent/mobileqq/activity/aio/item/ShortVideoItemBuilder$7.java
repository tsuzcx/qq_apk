package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShortVideoItemBuilder$7
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoItemBuilder$7(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (this.a.uiOperatorFlag == 2)
      {
        this.d.a(this.b, 10, false);
        this.d.c(this.a, this.b);
      }
      else if (this.a.uiOperatorFlag == 1)
      {
        if (this.a.videoFileStatus == 1004) {
          ShortVideoUtils.reportCancelSendVideo("0X800A375", this.d.f.a);
        }
        paramView = this.d;
        ShortVideoItemBuilder.a(paramView, this.b, true, paramView);
        paramView = this.a;
        paramView.isPause = false;
        if ((!TextUtils.isEmpty(paramView.md5)) && (this.a.videoFileStatus == 1004) && (AioVideoTransFileController.c(this.d.d, this.a.frienduin, this.a.uniseq)))
        {
          this.a.videoFileStatus = 1002;
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
          }
        }
        else if ((this.a.md5 == null) && ((this.a.videoFileStatus == 1005) || (this.a.videoFileStatus == 1004)))
        {
          this.b.s.setVisibility(8);
          this.b.t.setVisibility(8);
          this.b.g.setVisibility(8);
          paramView = new VideoCompressProcessor.CompressTask(this.d.d, this.d.e, this.a, ShortVideoItemBuilder.a(this.d));
          VideoCompressProcessor.a().a(this.a.uniseq, paramView);
        }
        else
        {
          this.d.a(this.b, 10, false);
          this.d.b(this.a, this.b);
        }
        ShortVideoItemBuilder.b(this.d);
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */