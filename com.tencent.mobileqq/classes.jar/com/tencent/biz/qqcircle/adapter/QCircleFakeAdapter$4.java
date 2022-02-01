package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QCircleFakeAdapter$4
  implements Runnable
{
  QCircleFakeAdapter$4(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent) {}
  
  public void run()
  {
    if ((this.this$0.getBlockContainer() != null) && ((this.this$0.getBlockContainer() instanceof QCircleBlockContainer)) && (this.this$0.getBlockContainer().a() != null) && (this.this$0.getBlockContainer().a().getVisibility() == 0))
    {
      this.this$0.getBlockContainer().a().setVisibility(8);
      QLog.i("QCircleFakeAdapter", 1, "onPublishFeedCreate   StatusView == gone");
    }
    if ((this.this$0.getDataList() != null) && (this.this$0.a(this.a.mSingleFakeFeed)))
    {
      QCircleFakeAdapter.a(this.this$0).add(this.a.mSingleFakeFeed);
      this.this$0.getDataList().add(0, this.a.mSingleFakeFeed);
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.4
 * JD-Core Version:    0.7.0.1
 */