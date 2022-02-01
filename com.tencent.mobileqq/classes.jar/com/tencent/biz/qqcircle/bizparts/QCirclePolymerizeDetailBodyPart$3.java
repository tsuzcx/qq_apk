package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StHomeButtonBubbleData;

class QCirclePolymerizeDetailBodyPart$3
  implements Observer<UIStateData<QQCircleFeedBase.StFeedListBusiRspData>>
{
  QCirclePolymerizeDetailBodyPart$3(QCirclePolymerizeDetailBodyPart paramQCirclePolymerizeDetailBodyPart) {}
  
  public void a(@Nullable UIStateData<QQCircleFeedBase.StFeedListBusiRspData> paramUIStateData)
  {
    if (paramUIStateData == null) {
      return;
    }
    paramUIStateData = (QQCircleFeedBase.StFeedListBusiRspData)paramUIStateData.e();
    if ((paramUIStateData != null) && (paramUIStateData.homeButtonBubbleData != null) && (paramUIStateData.homeButtonBubbleData.has()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("homeButtonBubble triggerIndex: ");
      localStringBuilder.append(paramUIStateData.homeButtonBubbleData.triggerFeedIndex.get());
      QLog.d("QCirclePolymerizeDetailBodyPart", 4, localStringBuilder.toString());
      QCirclePolymerizeDetailBodyPart.a(this.a, paramUIStateData.homeButtonBubbleData.triggerFeedIndex.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailBodyPart.3
 * JD-Core Version:    0.7.0.1
 */