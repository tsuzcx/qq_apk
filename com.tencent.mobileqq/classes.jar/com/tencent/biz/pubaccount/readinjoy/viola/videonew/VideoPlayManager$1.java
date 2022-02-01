package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import rwf;
import tik;
import til;

public class VideoPlayManager$1
  implements Runnable
{
  VideoPlayManager$1(VideoPlayManager paramVideoPlayManager, til paramtil) {}
  
  public void run()
  {
    til.a(this.a, VideoPlayManager.a(this.this$0, this.a));
    if ((til.a(this.a) != null) && (VideoPlayManager.a(this.this$0) != null))
    {
      til.a(this.a).a(this.a.a);
      VideoPlayManager.a(this.this$0).add(til.a(this.a));
      VideoPlayManager.a(this.this$0).post(new VideoPlayManager.1.1(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Viola.VideoPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + til.a(this.a) + ", mUIHandler = " + VideoPlayManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.1
 * JD-Core Version:    0.7.0.1
 */