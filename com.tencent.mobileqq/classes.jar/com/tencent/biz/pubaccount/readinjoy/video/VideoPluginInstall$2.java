package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import rwh;
import rwk;
import saa;

public class VideoPluginInstall$2
  implements Runnable
{
  public VideoPluginInstall$2(rwh paramrwh) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "start install video sdk in subThread");
    }
    if (!rwh.b()) {
      rwh.a(this.this$0);
    }
    try
    {
      rwh.a(this.this$0).a(new rwk(rwh.a(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "VideoSDKMgr.installPlugin ERROR e=" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */