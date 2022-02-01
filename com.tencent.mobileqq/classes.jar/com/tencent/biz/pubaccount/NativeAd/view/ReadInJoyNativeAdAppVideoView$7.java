package com.tencent.biz.pubaccount.NativeAd.view;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ReadInJoyNativeAdAppVideoView$7
  implements FMDialogUtil.FMDialogInterface
{
  ReadInJoyNativeAdAppVideoView$7(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void a()
  {
    GdtLog.a("ReadInJoyNativeAdAppVideoView", "tips onYes mVideoState " + ReadInJoyNativeAdAppVideoView.a(this.a));
    if (ReadInJoyNativeAdAppVideoView.a(this.a) == 6)
    {
      ReadInJoyNativeAdAppVideoView.a(this.a).start();
      ReadInJoyNativeAdAppVideoView.e(this.a, 5);
      ReadInJoyNativeAdAppVideoView.a(this.a);
      ReadInJoyNativeAdAppVideoView.f(this.a, 2);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.7
 * JD-Core Version:    0.7.0.1
 */