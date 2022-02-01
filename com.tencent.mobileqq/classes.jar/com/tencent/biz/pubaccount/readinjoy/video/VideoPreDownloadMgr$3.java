package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.mobileqq.app.ThreadManager;

class VideoPreDownloadMgr$3
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoPreDownloadMgr$3(VideoPreDownloadMgr paramVideoPreDownloadMgr, int paramInt) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (TextUtils.isEmpty(paramVideoUrlInfo.a)) {
      return;
    }
    ThreadManager.post(new VideoPreDownloadMgr.3.1(this, paramVideoUrlInfo), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.3
 * JD-Core Version:    0.7.0.1
 */