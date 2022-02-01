package com.tencent.biz.qqstory.takevideo.slideshow.core;

import amtj;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import xwa;
import yly;
import ylz;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(yly paramyly, ylz paramylz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    xwa.a("actAlbumResult", new String[] { "99" });
    QQToast.a(this.a.a, amtj.a(2131715324), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */