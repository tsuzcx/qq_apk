package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.PublishButtonEventInfo;
import com.tencent.qphone.base.util.QLog;

class QCirclePublishFeedPart$1
  implements Observer<QCirclePublishButtonViewModel.PublishButtonEventInfo>
{
  QCirclePublishFeedPart$1(QCirclePublishFeedPart paramQCirclePublishFeedPart) {}
  
  public void a(@Nullable QCirclePublishButtonViewModel.PublishButtonEventInfo paramPublishButtonEventInfo)
  {
    if (paramPublishButtonEventInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("publishButtonEvent: ");
    localStringBuilder.append(paramPublishButtonEventInfo);
    QLog.i("QCirclePublishButtonViewModel", 1, localStringBuilder.toString());
    if (paramPublishButtonEventInfo.a)
    {
      QCirclePublishFeedPart.a(this.a, paramPublishButtonEventInfo);
      QCirclePublishFeedPart.b(this.a, paramPublishButtonEventInfo);
      return;
    }
    if (paramPublishButtonEventInfo.a() != -1) {
      QCirclePublishFeedPart.c(this.a, paramPublishButtonEventInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart.1
 * JD-Core Version:    0.7.0.1
 */