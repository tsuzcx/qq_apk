package com.tencent.biz.pubaccount.NativeAd.view;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ReadInJoyNativeAdAppVideoView$4
  implements Runnable
{
  ReadInJoyNativeAdAppVideoView$4(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void run()
  {
    if ((ReadInJoyNativeAdAppVideoView.f(this.this$0) != null) && (ReadInJoyNativeAdAppVideoView.f(this.this$0).isPlaying()))
    {
      long l = ReadInJoyNativeAdAppVideoView.f(this.this$0).getCurrentPostion();
      ReadInJoyNativeAdAppVideoView localReadInJoyNativeAdAppVideoView = this.this$0;
      ReadInJoyNativeAdAppVideoView.a(localReadInJoyNativeAdAppVideoView, ReadInJoyNativeAdAppVideoView.f(localReadInJoyNativeAdAppVideoView).getDuration());
      double d = (float)l * 1.0F * ReadInJoyNativeAdAppVideoView.g(this.this$0) / (float)ReadInJoyNativeAdAppVideoView.h(this.this$0);
      Double.isNaN(d);
      int i = (int)(d + 0.5D);
      ReadInJoyNativeAdAppVideoView.i(this.this$0).setProgress(i);
      ReadInJoyNativeAdAppVideoView.j(this.this$0).setText(GdtUIUtils.a(l));
      ReadInJoyNativeAdAppVideoView.k(this.this$0).setText(GdtUIUtils.a(ReadInJoyNativeAdAppVideoView.h(this.this$0)));
      if (ReadInJoyNativeAdAppVideoView.h(this.this$0) - l < 50L)
      {
        if (!ReadInJoyNativeAdAppVideoView.l(this.this$0))
        {
          localReadInJoyNativeAdAppVideoView = this.this$0;
          ReadInJoyNativeAdAppVideoView.a(localReadInJoyNativeAdAppVideoView, (int)ReadInJoyNativeAdAppVideoView.h(localReadInJoyNativeAdAppVideoView));
          ReadInJoyNativeAdAppVideoView.b(this.this$0, 1);
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(ReadInJoyNativeAdAppVideoView.u(this.this$0)).a(this.this$0.getContext()).a(6).b(7).a(ReadInJoyNativeAdAppVideoView.t(this.this$0)).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(ReadInJoyNativeAdAppVideoView.m(this.this$0), ReadInJoyNativeAdAppVideoView.n(this.this$0), ReadInJoyNativeAdAppVideoView.o(this.this$0), ReadInJoyNativeAdAppVideoView.p(this.this$0), ReadInJoyNativeAdAppVideoView.q(this.this$0), ReadInJoyNativeAdAppVideoView.r(this.this$0), (int)ReadInJoyNativeAdAppVideoView.h(this.this$0), 10, 0, ReadInJoyNativeAdAppVideoView.s(this.this$0), ReportConstants.VideoEndType.NORMAL_COMPLETE)));
          ReadInJoyNativeAdAppVideoView.c(this.this$0, 0);
          ReadInJoyNativeAdAppVideoView.d(this.this$0, 1);
          ReadInJoyNativeAdAppVideoView.b(this.this$0, 0);
          ReadInJoyNativeAdAppVideoView.a(this.this$0, true);
        }
      }
      else {
        ReadInJoyNativeAdAppVideoView.a(this.this$0, false);
      }
    }
    ReadInJoyNativeAdAppVideoView.d(this.this$0).postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.4
 * JD-Core Version:    0.7.0.1
 */