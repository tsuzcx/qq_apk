package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;

class FrameAnimationView$2
  implements RFWDownloader.RFWDownloadListener
{
  FrameAnimationView$2(FrameAnimationView paramFrameAnimationView, int paramInt, boolean paramBoolean) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (FrameAnimationView.a(this.c))) {
      this.c.setAnimationFile(paramString, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.FrameAnimationView.2
 * JD-Core Version:    0.7.0.1
 */