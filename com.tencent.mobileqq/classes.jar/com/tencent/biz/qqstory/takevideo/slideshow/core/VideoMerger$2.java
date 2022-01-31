package com.tencent.biz.qqstory.takevideo.slideshow.core;

import alud;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import wxj;
import xns;
import xnt;

public class VideoMerger$2
  implements Runnable
{
  public VideoMerger$2(xns paramxns, xnt paramxnt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge video failed");
    }
    wxj.a("actAlbumResult", new String[] { "99" });
    QQToast.a(this.a.a, alud.a(2131716704), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2
 * JD-Core Version:    0.7.0.1
 */