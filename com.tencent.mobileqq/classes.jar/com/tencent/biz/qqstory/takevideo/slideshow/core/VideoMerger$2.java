package com.tencent.biz.qqstory.takevideo.slideshow.core;

import anvx;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import ykv;
import zar;
import zas;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(zar paramzar, zas paramzas) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    ykv.a("actAlbumResult", new String[] { "99" });
    QQToast.a(this.a.a, anvx.a(2131715672), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */