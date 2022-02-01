package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import spp;
import sps;
import stu;

public class VideoPluginInstall$2
  implements Runnable
{
  public VideoPluginInstall$2(spp paramspp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "start install video sdk in subThread");
    }
    if (!spp.b()) {
      spp.a(this.this$0);
    }
    try
    {
      spp.a(this.this$0).a(new sps(spp.a(this.this$0)));
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