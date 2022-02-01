package com.tencent.ad.tangram.views.canvas.framework;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.halfScreen.AdHalfScreen;
import com.tencent.ad.tangram.statistics.c;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class AdCanvasView$3$1
  implements View.OnClickListener
{
  AdCanvasView$3$1(AdCanvasView.3 param3) {}
  
  public void onClick(View paramView)
  {
    AdHalfScreen.showWithoutAd(new WeakReference(AdCanvasView.access$100(this.this$1.this$0)), this.this$1.val$appInfoRightUrl);
    c.reportAsync(new WeakReference(this.this$1.this$0.getContext()), this.this$1.this$0.getData().ad, 322);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.3.1
 * JD-Core Version:    0.7.0.1
 */