package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerSDKMgr;
import com.tencent.qphone.base.util.QLog;

class VideoPluginInstall$2
  implements Runnable
{
  VideoPluginInstall$2(VideoPluginInstall paramVideoPluginInstall) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "start install video sdk in subThread");
    }
    if (!VideoPluginInstall.b()) {
      VideoPluginInstall.a(this.this$0);
    }
    try
    {
      VideoPluginInstall.a(this.this$0).a(new VideoPluginInstall.SDKInstallListener(VideoPluginInstall.a(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "VideoSDKMgr.installPlugin ERROR e=" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */