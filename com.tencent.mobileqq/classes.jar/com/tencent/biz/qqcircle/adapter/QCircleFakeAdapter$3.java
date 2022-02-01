package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.BlockContainer;
import java.util.ArrayList;

class QCircleFakeAdapter$3
  implements Runnable
{
  QCircleFakeAdapter$3(QCircleFakeAdapter paramQCircleFakeAdapter, int paramInt) {}
  
  public void run()
  {
    this.this$0.c(this.a);
    if ((this.this$0.getDataList() != null) && (this.this$0.getDataList().size() == 0) && (this.this$0.getBlockContainer() != null) && ((this.this$0.getBlockContainer() instanceof QCircleBlockContainer)) && (this.this$0.getBlockContainer().getStatusInterface() != null) && (this.this$0.getBlockContainer().getStatusInterface().getStatusView() != null) && (this.this$0.getBlockContainer().getStatusInterface().getStatusView().getVisibility() == 8)) {
      this.this$0.getBlockContainer().getStatusInterface().getStatusView().setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.3
 * JD-Core Version:    0.7.0.1
 */