package com.tencent.biz.richframework.part.block.base;

import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnFlingListener;

class QCirclePagerSnapHelper$TouchEventProcessor$TouchFlingListener
  extends RecyclerView.OnFlingListener
{
  private QCirclePagerSnapHelper$TouchEventProcessor$TouchFlingListener(QCirclePagerSnapHelper.TouchEventProcessor paramTouchEventProcessor) {}
  
  public boolean onFling(int paramInt1, int paramInt2)
  {
    if (QCirclePagerSnapHelper.c(this.a.a) == null) {
      return false;
    }
    if (QCirclePagerSnapHelper.i(this.a.a).getAdapter() == null) {
      return false;
    }
    if (!QCirclePagerSnapHelper.d(this.a.a)) {
      return false;
    }
    int i = QCirclePagerSnapHelper.i(this.a.a).getMinFlingVelocity();
    int j = QCirclePagerSnapHelper.TouchEventProcessor.a(this.a);
    if ((Math.abs(paramInt2) <= i) && (Math.abs(paramInt1) <= i)) {
      return false;
    }
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = QCirclePagerSnapHelper.a(this.a.a, QCirclePagerSnapHelper.c(this.a.a), QCirclePagerSnapHelper.TouchEventProcessor.b(this.a), QCirclePagerSnapHelper.TouchEventProcessor.c(this.a), paramInt1, paramInt2, j);
      return bool;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper.TouchEventProcessor.TouchFlingListener
 * JD-Core Version:    0.7.0.1
 */