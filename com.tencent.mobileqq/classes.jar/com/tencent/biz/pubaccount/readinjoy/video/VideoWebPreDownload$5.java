package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import qvt;

public class VideoWebPreDownload$5
  implements Runnable
{
  public VideoWebPreDownload$5(qvt paramqvt) {}
  
  public void run()
  {
    if (qvt.a(this.this$0) != null)
    {
      qvt.a(this.this$0).stopCacheData(20160519);
      qvt.a(this.this$0).removePreloadCallback();
      qvt.a(this.this$0).releasePreload(20160519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.5
 * JD-Core Version:    0.7.0.1
 */