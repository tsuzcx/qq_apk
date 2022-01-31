package com.tencent.biz.qqstory.takevideo.slideshow.core;

import alpo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import wta;
import xjj;
import xjk;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(xjj paramxjj, xjk paramxjk) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    wta.a("actAlbumResult", new String[] { "99" });
    QQToast.a(this.a.a, alpo.a(2131716692), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */