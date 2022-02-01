package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.widget.TextView;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.UpdateProgressListener;
import com.tencent.mobileqq.app.HardCodeUtil;

class UploadStatusVideoInfoWidget$1
  implements StoryVideoUploadProgressManager.UpdateProgressListener
{
  UploadStatusVideoInfoWidget$1(UploadStatusVideoInfoWidget paramUploadStatusVideoInfoWidget) {}
  
  public void a(String paramString, int paramInt)
  {
    UploadStatusVideoInfoWidget.a(this.a).setText(HardCodeUtil.a(2131715771) + paramInt + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.UploadStatusVideoInfoWidget.1
 * JD-Core Version:    0.7.0.1
 */