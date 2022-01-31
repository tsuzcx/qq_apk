package com.tencent.biz.qqstory.takevideo.slideshow.core;

import ajya;
import bcql;
import com.tencent.qphone.base.util.QLog;
import vei;
import vur;
import vus;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(vur paramvur, vus paramvus) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    vei.a("actAlbumResult", new String[] { "99" });
    bcql.a(this.a.a, ajya.a(2131716320), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */