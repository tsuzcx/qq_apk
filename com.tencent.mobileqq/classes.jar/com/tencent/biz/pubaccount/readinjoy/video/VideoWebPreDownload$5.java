package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import rxp;

public class VideoWebPreDownload$5
  implements Runnable
{
  public VideoWebPreDownload$5(rxp paramrxp) {}
  
  public void run()
  {
    if (rxp.a(this.this$0) != null)
    {
      rxp.a(this.this$0).stopCacheData(20160519);
      rxp.a(this.this$0).removePreloadCallback();
      rxp.a(this.this$0).releasePreload(20160519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.5
 * JD-Core Version:    0.7.0.1
 */