package com.tencent.biz.pubaccount.NativeAd.view;

import aciv;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import ois;
import ufy;

class ReadInJoyNativeAdAppVideoView$4
  implements Runnable
{
  ReadInJoyNativeAdAppVideoView$4(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void run()
  {
    if ((ReadInJoyNativeAdAppVideoView.a(this.this$0) != null) && (ReadInJoyNativeAdAppVideoView.a(this.this$0).isPlaying()))
    {
      long l = ReadInJoyNativeAdAppVideoView.a(this.this$0).getCurrentPostion();
      ReadInJoyNativeAdAppVideoView.a(this.this$0, ReadInJoyNativeAdAppVideoView.a(this.this$0).getDuration());
      int i = (int)((float)l * 1.0F * ReadInJoyNativeAdAppVideoView.b(this.this$0) / (float)ReadInJoyNativeAdAppVideoView.a(this.this$0) + 0.5D);
      ReadInJoyNativeAdAppVideoView.a(this.this$0).setProgress(i);
      ReadInJoyNativeAdAppVideoView.a(this.this$0).setText(aciv.a(l));
      ReadInJoyNativeAdAppVideoView.b(this.this$0).setText(aciv.a(ReadInJoyNativeAdAppVideoView.a(this.this$0)));
      if (ReadInJoyNativeAdAppVideoView.a(this.this$0) - l >= 50L) {
        break label357;
      }
      if (!ReadInJoyNativeAdAppVideoView.a(this.this$0))
      {
        ReadInJoyNativeAdAppVideoView.a(this.this$0, (int)ReadInJoyNativeAdAppVideoView.a(this.this$0));
        ReadInJoyNativeAdAppVideoView.b(this.this$0, 1);
        ois.a(new ufy().a(ReadInJoyNativeAdAppVideoView.a(this.this$0)).a(this.this$0.getContext()).a(6).b(7).a(ReadInJoyNativeAdAppVideoView.a(this.this$0)).a(ois.a(ReadInJoyNativeAdAppVideoView.c(this.this$0), ReadInJoyNativeAdAppVideoView.d(this.this$0), ReadInJoyNativeAdAppVideoView.e(this.this$0), ReadInJoyNativeAdAppVideoView.f(this.this$0), ReadInJoyNativeAdAppVideoView.g(this.this$0), ReadInJoyNativeAdAppVideoView.h(this.this$0), (int)ReadInJoyNativeAdAppVideoView.a(this.this$0), 10, 0, ReadInJoyNativeAdAppVideoView.i(this.this$0), ReportConstants.VideoEndType.NORMAL_COMPLETE)).a());
        ReadInJoyNativeAdAppVideoView.c(this.this$0, 0);
        ReadInJoyNativeAdAppVideoView.d(this.this$0, 1);
        ReadInJoyNativeAdAppVideoView.b(this.this$0, 0);
        ReadInJoyNativeAdAppVideoView.a(this.this$0, true);
      }
    }
    for (;;)
    {
      ReadInJoyNativeAdAppVideoView.a(this.this$0).postDelayed(this, 50L);
      return;
      label357:
      ReadInJoyNativeAdAppVideoView.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.4
 * JD-Core Version:    0.7.0.1
 */