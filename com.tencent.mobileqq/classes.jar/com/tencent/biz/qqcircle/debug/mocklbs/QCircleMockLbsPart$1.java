package com.tencent.biz.qqcircle.debug.mocklbs;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleMockLbsPart$1
  implements RadioGroup.OnCheckedChangeListener
{
  QCircleMockLbsPart$1(QCircleMockLbsPart paramQCircleMockLbsPart) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    MockLbsInfo localMockLbsInfo = QCircleMockLbsPart.a(this.a, paramInt);
    if (localMockLbsInfo != null) {
      QCirclePluginGlobalInfo.a(localMockLbsInfo);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.debug.mocklbs.QCircleMockLbsPart.1
 * JD-Core Version:    0.7.0.1
 */