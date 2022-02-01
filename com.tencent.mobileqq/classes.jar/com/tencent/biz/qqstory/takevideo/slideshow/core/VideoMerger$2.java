package com.tencent.biz.qqstory.takevideo.slideshow.core;

import anzj;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import yup;
import zky;
import zkz;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(zky paramzky, zkz paramzkz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    yup.a("actAlbumResult", new String[] { "99" });
    QQToast.a(this.a.a, anzj.a(2131715090), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */