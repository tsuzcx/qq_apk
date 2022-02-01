package com.tencent.biz.qqcircle.bizparts;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;

class QCircleCommentPanelPart$2
  extends RecyclerView.OnScrollListener
{
  QCircleCommentPanelPart$2(QCircleCommentPanelPart paramQCircleCommentPanelPart) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      QCircleHostDropFrameMonitorHelper.stopMonitorScene(QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_COMMENT_PAGE(), false);
      return;
    }
    QCircleHostDropFrameMonitorHelper.startMonitorScene(QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_COMMENT_PAGE());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.2
 * JD-Core Version:    0.7.0.1
 */