package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationViewModel;
import com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;

class QFSAggregationBottomWidget$1
  implements MultiViewBlock.OnLoadDataDelegate
{
  QFSAggregationBottomWidget$1(QFSAggregationBottomWidget paramQFSAggregationBottomWidget) {}
  
  public void a(LoadInfo paramLoadInfo, Object paramObject)
  {
    if ((paramLoadInfo.e()) && (QFSAggregationBottomWidget.a(this.a) != null))
    {
      QLog.i("QFSAggregationBottomWidget", 1, "onLoadData loadMore");
      QFSAggregationBottomWidget.a(this.a).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomWidget.1
 * JD-Core Version:    0.7.0.1
 */