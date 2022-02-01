package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView.ItemPreClickListener;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;

class QCircleChatIceBreakItemBuilder$2
  implements QCircleFollowView.ItemPreClickListener
{
  QCircleChatIceBreakItemBuilder$2(QCircleChatIceBreakItemBuilder paramQCircleChatIceBreakItemBuilder) {}
  
  public void a()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.a.d.b).setActionType(45).setSubActionType(2).setThrActionType(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleChatIceBreakItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */