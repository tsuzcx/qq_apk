package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import qvw;

public class VideoWebPreDownload$5
  implements Runnable
{
  public VideoWebPreDownload$5(qvw paramqvw) {}
  
  public void run()
  {
    if (qvw.a(this.this$0) != null)
    {
      qvw.a(this.this$0).stopCacheData(20160519);
      qvw.a(this.this$0).removePreloadCallback();
      qvw.a(this.this$0).releasePreload(20160519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.5
 * JD-Core Version:    0.7.0.1
 */