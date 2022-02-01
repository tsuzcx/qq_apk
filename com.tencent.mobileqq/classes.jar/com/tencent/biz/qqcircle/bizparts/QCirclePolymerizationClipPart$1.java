package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

class QCirclePolymerizationClipPart$1
  implements Observer<UIStateData<QQCircleFeedBase.StFeedListBusiRspData>>
{
  QCirclePolymerizationClipPart$1(QCirclePolymerizationClipPart paramQCirclePolymerizationClipPart) {}
  
  public void a(@Nullable UIStateData<QQCircleFeedBase.StFeedListBusiRspData> paramUIStateData)
  {
    if (paramUIStateData != null) {
      QCirclePolymerizationClipPart.a(this.a, (QQCircleFeedBase.StFeedListBusiRspData)paramUIStateData.e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationClipPart.1
 * JD-Core Version:    0.7.0.1
 */