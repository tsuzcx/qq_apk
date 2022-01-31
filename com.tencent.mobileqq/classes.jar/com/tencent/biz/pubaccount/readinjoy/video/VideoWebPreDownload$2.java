package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import qvw;

public class VideoWebPreDownload$2
  implements Runnable
{
  public VideoWebPreDownload$2(qvw paramqvw) {}
  
  public void run()
  {
    if (qvw.a(this.this$0) != null) {
      qvw.a(this.this$0).stopCacheData(20160519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.2
 * JD-Core Version:    0.7.0.1
 */