package com.tencent.biz.qqcircle.bizparts;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCirclePrivacySettingContentPart$1
  implements CompoundButton.OnCheckedChangeListener
{
  QCirclePrivacySettingContentPart$1(QCirclePrivacySettingContentPart paramQCirclePrivacySettingContentPart) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QCircleSetUserSwitchRequest localQCircleSetUserSwitchRequest = new QCircleSetUserSwitchRequest(0, paramBoolean ^ true);
    VSNetworkHelper.getInstance().sendRequest(localQCircleSetUserSwitchRequest, new QCirclePrivacySettingContentPart.1.1(this, paramBoolean));
    if (paramBoolean) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(23).setThrActionType(3));
    } else {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(23).setThrActionType(2));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart.1
 * JD-Core Version:    0.7.0.1
 */