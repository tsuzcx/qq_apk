package com.tencent.biz.qqcircle.fragments;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel;

class QCircleBaseTabFragment$1
  extends RecyclerView.OnScrollListener
{
  QCircleBaseTabFragment$1(QCircleBaseTabFragment paramQCircleBaseTabFragment, QCirclePublishButtonViewModel paramQCirclePublishButtonViewModel) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      QCircleHostDropFrameMonitorHelper.stopMonitorScene(QCircleBaseTabFragment.a(this.b), false);
      return;
    }
    if (paramInt == 1)
    {
      this.a.e();
      QCircleHostDropFrameMonitorHelper.startMonitorScene(QCircleBaseTabFragment.a(this.b));
      return;
    }
    QCircleHostDropFrameMonitorHelper.startMonitorScene(QCircleBaseTabFragment.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment.1
 * JD-Core Version:    0.7.0.1
 */