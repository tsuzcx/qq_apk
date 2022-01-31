package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import oqb;
import qmj;
import qmo;
import rlz;

public class VideoFeedsAdapter$ShortVideoItemDelegate$5
  implements Runnable
{
  public VideoFeedsAdapter$ShortVideoItemDelegate$5(qmj paramqmj) {}
  
  public void run()
  {
    if (rlz.a().b()) {}
    try
    {
      qmj.a(this.a).a = oqb.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
      if ((qmj.a(this.a).m != null) && (qmj.a(this.a).a != null)) {
        qmj.a(this.a).m.setImageDrawable(qmj.a(this.a).a);
      }
      if (qmj.a(this.a).l != null) {
        qmj.a(this.a).l.setVisibility(8);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 1, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.5
 * JD-Core Version:    0.7.0.1
 */