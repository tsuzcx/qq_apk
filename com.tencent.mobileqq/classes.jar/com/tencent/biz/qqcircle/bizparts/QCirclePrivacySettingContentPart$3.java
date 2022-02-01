package com.tencent.biz.qqcircle.bizparts;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePrivacySettingContentPart$3
  implements CompoundButton.OnCheckedChangeListener
{
  QCirclePrivacySettingContentPart$3(QCirclePrivacySettingContentPart paramQCirclePrivacySettingContentPart) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.isPressed()) {
      QCirclePrivacySettingContentPart.a(paramBoolean, new QCirclePrivacySettingContentPart.3.1(this, paramBoolean));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart.3
 * JD-Core Version:    0.7.0.1
 */