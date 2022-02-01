package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.INearbyRelevantHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class LikeSettingActivity$3
  implements CompoundButton.OnCheckedChangeListener
{
  LikeSettingActivity$3(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      ((INearbyRelevantHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).a(paramBoolean);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006729", "0X8006729", 0, 0, "", "", "", "");
    }
    else if (paramCompoundButton == this.a.c.a())
    {
      this.a.app.setZanAllowed(true, paramBoolean);
    }
    else
    {
      Object localObject = this.a.b.a();
      String str = "1";
      if (paramCompoundButton == localObject)
      {
        localObject = this.a.app;
        if (!paramBoolean) {
          str = "0";
        }
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8007614", "0X8007614", 0, 0, str, "", "", "");
        this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.h(paramBoolean);
      }
      else if (paramCompoundButton == this.a.d.a())
      {
        localObject = this.a.app;
        if (!paramBoolean) {
          str = "2";
        }
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800791B", "0X800791B", 0, 0, str, "", "", "");
        this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.f(paramBoolean);
        if (!paramBoolean) {
          this.a.b.setVisibility(8);
        } else {
          this.a.b.setVisibility(0);
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */