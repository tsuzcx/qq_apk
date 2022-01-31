package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import qhy;
import qib;

public class VideoPluginInstall$2
  implements Runnable
{
  public VideoPluginInstall$2(qhy paramqhy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "start install video sdk in subThread");
    }
    if (!qhy.b()) {
      qhy.a(this.this$0);
    }
    try
    {
      if (qhy.a(this.this$0) != null) {
        TVK_SDKMgr.installPlugin(qhy.a(this.this$0), new qib(qhy.a(this.this$0)));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "TVK_SDKMgr.installPlugin ERROR e=" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */