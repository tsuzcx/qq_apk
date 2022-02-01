package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

class QCirclePolymerizeDetailTitlePart$1
  implements Observer<UIStateData<QQCircleFeedBase.StFeedListBusiRspData>>
{
  QCirclePolymerizeDetailTitlePart$1(QCirclePolymerizeDetailTitlePart paramQCirclePolymerizeDetailTitlePart) {}
  
  public void a(@Nullable UIStateData<QQCircleFeedBase.StFeedListBusiRspData> paramUIStateData)
  {
    if (paramUIStateData != null) {
      QCirclePolymerizeDetailTitlePart.a(this.a, (QQCircleFeedBase.StFeedListBusiRspData)paramUIStateData.e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailTitlePart.1
 * JD-Core Version:    0.7.0.1
 */