package com.tencent.gdtad.views.videoimax;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter.GdtVideoReportInfo;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoListener;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;

class GdtVideoImaxFragment$1
  implements GdtVideoCommonView.VideoListener
{
  GdtVideoImaxFragment$1(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void a(View paramView)
  {
    GdtVideoImaxFragment.d(this.a).getVideoReportInfo().b(2);
    if (GdtVideoImaxFragment.f(this.a).getVideoSplicePageStyle() == 1)
    {
      boolean bool = this.a.a(paramView);
      GdtVideoImaxFragment.b(this.a, bool);
      GdtVideoImaxFragment.g(this.a);
      return;
    }
    if (GdtVideoImaxFragment.f(this.a).getVideoSplicePageStyle() == 0)
    {
      GdtVideoImaxFragment.d(this.a).e();
      paramView = GdtUIUtils.a(this.a.getBaseActivity());
      GdtVideoImaxFragment localGdtVideoImaxFragment = this.a;
      GdtVideoImaxFragment.a(localGdtVideoImaxFragment, paramView[1], GdtVideoImaxFragment.h(localGdtVideoImaxFragment).getLayoutParams().height, paramView[1]);
    }
  }
  
  public void a(GdtVideoCommonView paramGdtVideoCommonView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepared() called with: v = [");
    localStringBuilder.append(paramGdtVideoCommonView);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
  }
  
  public void b(GdtVideoCommonView paramGdtVideoCommonView)
  {
    GdtLog.a("GdtVideoImaxFragment", "onStart() called with: ");
    if (GdtVideoImaxFragment.a(this.a))
    {
      GdtVideoImaxFragment.c(this.a).removeCallbacks(GdtVideoImaxFragment.b(this.a));
      GdtVideoImaxFragment.c(this.a).postDelayed(new GdtVideoImaxFragment.1.1(this), 75L);
      GdtVideoImaxFragment.a(this.a, false);
    }
  }
  
  public void c(GdtVideoCommonView paramGdtVideoCommonView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop() called with: v = [");
    localStringBuilder.append(paramGdtVideoCommonView);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
  }
  
  public void d(GdtVideoCommonView paramGdtVideoCommonView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete() called with: v = [");
    localStringBuilder.append(paramGdtVideoCommonView);
    localStringBuilder.append("]");
    GdtLog.a("GdtVideoImaxFragment", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1
 * JD-Core Version:    0.7.0.1
 */