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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tips onYes mVideoState ");
    localStringBuilder.append(ReadInJoyNativeAdAppVideoView.a(this.a));
    GdtLog.a("ReadInJoyNativeAdAppVideoView", localStringBuilder.toString());
    if (ReadInJoyNativeAdAppVideoView.a(this.a) == 6)
    {
      ReadInJoyNativeAdAppVideoView.f(this.a).start();
      ReadInJoyNativeAdAppVideoView.e(this.a, 5);
      ReadInJoyNativeAdAppVideoView.e(this.a);
      ReadInJoyNativeAdAppVideoView.f(this.a, 2);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.7
 * JD-Core Version:    0.7.0.1
 */