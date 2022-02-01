package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class QCirclePersonalTitleBarPart$4
  implements Observer<UIStateData<FeedCloudRead.StGetMainPageRsp>>
{
  QCirclePersonalTitleBarPart$4(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart) {}
  
  public void a(@Nullable UIStateData<FeedCloudRead.StGetMainPageRsp> paramUIStateData)
  {
    if (paramUIStateData != null) {}
    try
    {
      if ((paramUIStateData.c() != 2) && (paramUIStateData.c() != 3)) {
        break label89;
      }
      QCirclePersonalTitleBarPart.a(this.a, (FeedCloudRead.StGetMainPageRsp)paramUIStateData.e());
      QCirclePersonalTitleBarPart.a(this.a, (FeedCloudMeta.StUser)QCirclePersonalTitleBarPart.d(this.a).user.get());
      QCirclePersonalTitleBarPart.e(this.a);
      QCirclePersonalTitleBarPart.f(this.a);
      QCirclePersonalTitleBarPart.g(this.a);
      return;
    }
    catch (Exception paramUIStateData)
    {
      label81:
      label89:
      break label81;
    }
    QLog.e("QCirclePersonalTitleBar", 1, "getShareInfo error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.4
 * JD-Core Version:    0.7.0.1
 */