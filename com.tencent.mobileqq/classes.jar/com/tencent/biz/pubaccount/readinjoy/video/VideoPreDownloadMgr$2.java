package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerPreloader.Listener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class VideoPreDownloadMgr$2
  implements IPlayerPreloader.Listener
{
  VideoPreDownloadMgr$2(VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a) + " SUCCESS");
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a));
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.2
 * JD-Core Version:    0.7.0.1
 */