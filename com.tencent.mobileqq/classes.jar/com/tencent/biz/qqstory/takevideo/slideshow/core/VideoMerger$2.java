package com.tencent.biz.qqstory.takevideo.slideshow.core;

import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class VideoMerger$2
  implements Runnable
{
  VideoMerger$2(VideoMerger paramVideoMerger, VideoMerger.MergeContext paramMergeContext) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    StoryReportor.a("actAlbumResult", new String[] { "99" });
    QQToast.makeText(this.a.c, HardCodeUtil.a(2131913512), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */