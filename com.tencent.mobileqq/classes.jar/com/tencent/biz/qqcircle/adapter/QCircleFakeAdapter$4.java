package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QCircleFakeAdapter$4
  implements Runnable
{
  QCircleFakeAdapter$4(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent) {}
  
  public void run()
  {
    if ((this.this$0.getBlockContainer() != null) && ((this.this$0.getBlockContainer() instanceof QCircleBlockContainer)) && (this.this$0.getBlockContainer().getStatusInterface().getStatusView() != null) && (this.this$0.getBlockContainer().getStatusInterface().getStatusView().getVisibility() == 0))
    {
      this.this$0.getBlockContainer().getStatusInterface().getStatusView().setVisibility(8);
      QLog.i("QCircleFakeAdapter", 1, "onPublishFeedCreate   StatusView == gone");
    }
    if (this.a.mSingleFakeFeed != null)
    {
      FeedBlockData localFeedBlockData = QCircleProtoUtil.a(this.a.mSingleFakeFeed);
      if ((this.this$0.getDataList() != null) && (localFeedBlockData != null) && (this.this$0.a(localFeedBlockData.b())))
      {
        QCircleFakeAdapter.a(this.this$0).add(localFeedBlockData);
        this.this$0.getDataList().add(0, localFeedBlockData);
        this.this$0.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.4
 * JD-Core Version:    0.7.0.1
 */