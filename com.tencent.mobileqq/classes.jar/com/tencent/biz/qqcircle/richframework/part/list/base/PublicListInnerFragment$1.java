package com.tencent.biz.qqcircle.richframework.part.list.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;

class PublicListInnerFragment$1
  extends RecyclerView.OnScrollListener
{
  PublicListInnerFragment$1(PublicListInnerFragment paramPublicListInnerFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((this.a.d != null) && (this.a.d.getDropFrameMonitorTag() != null))
    {
      if (paramInt == 0)
      {
        QCircleHostDropFrameMonitorHelper.stopMonitorScene(this.a.d.getDropFrameMonitorTag(), false);
        return;
      }
      QCircleHostDropFrameMonitorHelper.startMonitorScene(this.a.d.getDropFrameMonitorTag());
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment.1
 * JD-Core Version:    0.7.0.1
 */