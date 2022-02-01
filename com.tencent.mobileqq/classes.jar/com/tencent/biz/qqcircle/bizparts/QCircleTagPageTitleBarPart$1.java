package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StTagInfo;

class QCircleTagPageTitleBarPart$1
  implements Observer<UIStateData<FeedCloudMeta.StTagInfo>>
{
  QCircleTagPageTitleBarPart$1(QCircleTagPageTitleBarPart paramQCircleTagPageTitleBarPart) {}
  
  public void a(@Nullable UIStateData<FeedCloudMeta.StTagInfo> paramUIStateData)
  {
    if (paramUIStateData != null) {
      QCircleTagPageTitleBarPart.a(this.a, (FeedCloudMeta.StTagInfo)paramUIStateData.e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagPageTitleBarPart.1
 * JD-Core Version:    0.7.0.1
 */