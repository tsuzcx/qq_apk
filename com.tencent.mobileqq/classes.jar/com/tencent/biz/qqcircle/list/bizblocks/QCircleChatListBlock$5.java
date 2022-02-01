package com.tencent.biz.qqcircle.list.bizblocks;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleChatListBlock$5
  implements View.OnClickListener
{
  QCircleChatListBlock$5(QCircleChatListBlock paramQCircleChatListBlock, QCircleRecentDataInterface paramQCircleRecentDataInterface) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.getRecentUserUin();
    if (!TextUtils.isEmpty(str)) {
      QCircleChatListBlock.access$300(this.b, str, this.a.getTitleName(), this.a.getGiftInfo());
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(this.a.getRecentUserUin()).setActionType(80).setSubActionType(3).setThrActionType(0).setExtras(QCircleChatListBlock.access$400(this.b, this.a)));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.5
 * JD-Core Version:    0.7.0.1
 */