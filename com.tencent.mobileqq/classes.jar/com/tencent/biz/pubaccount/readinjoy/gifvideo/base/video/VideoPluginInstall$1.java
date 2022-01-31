package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import owv;
import owy;

public final class VideoPluginInstall$1
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("gifvideo.VideoPluginInstall", 2, "start install video sdk in subThread");
    }
    if (!owv.b()) {
      owv.b();
    }
    try
    {
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.getContext(), new owy(owv.a()));
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPluginInstall.1
 * JD-Core Version:    0.7.0.1
 */