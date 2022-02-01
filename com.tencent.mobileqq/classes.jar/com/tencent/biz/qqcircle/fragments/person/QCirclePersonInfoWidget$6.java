package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener;
import feedcloud.FeedCloudMeta.StFollowUser;

class QCirclePersonInfoWidget$6
  implements BoldClickableSpan.OnClickBoldTextListener
{
  QCirclePersonInfoWidget$6(QCirclePersonInfoWidget paramQCirclePersonInfoWidget, FeedCloudMeta.StFollowUser paramStFollowUser) {}
  
  public void a(Object paramObject)
  {
    paramObject = new QCircleInitBean();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.uid.get());
    localStringBuilder.append("");
    paramObject.setUin(localStringBuilder.toString());
    QCircleLauncher.b(QCirclePersonInfoWidget.k(this.b), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget.6
 * JD-Core Version:    0.7.0.1
 */