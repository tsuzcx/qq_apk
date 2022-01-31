package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import oet;
import qaq;
import qzk;

public class VideoFeedsAdapter$VideoItemHolder$3
  implements Runnable
{
  public VideoFeedsAdapter$VideoItemHolder$3(qaq paramqaq) {}
  
  public void run()
  {
    if (qzk.a().b()) {}
    try
    {
      this.this$0.a = oet.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
      if ((this.this$0.j != null) && (this.this$0.a != null)) {
        this.this$0.j.setImageDrawable(this.this$0.a);
      }
      if (this.this$0.i != null) {
        this.this$0.i.setVisibility(8);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder.3
 * JD-Core Version:    0.7.0.1
 */