package com.tencent.biz.qqstory.takevideo.slideshow.core;

import anni;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import yqu;
import zhd;
import zhe;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(zhd paramzhd, zhe paramzhe) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    yqu.a("actAlbumResult", new String[] { "99" });
    QQToast.a(this.a.a, anni.a(2131714981), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */