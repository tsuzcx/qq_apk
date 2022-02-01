package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.GroupManagerInputTextWatcher;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GroupManagerActivity$4
  implements View.OnClickListener
{
  GroupManagerActivity$4(GroupManagerActivity paramGroupManagerActivity, GroupManagerInputTextWatcher paramGroupManagerInputTextWatcher) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.app, null);
    int i;
    label31:
    QQToast localQQToast;
    if ((k & 0x2) != 0)
    {
      i = 1;
      if ((k & 0x4) == 0) {
        break label103;
      }
      if ((i == 0) && (j == 0)) {
        break label108;
      }
      if (30 > this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a.size()) {
        break label162;
      }
      localQQToast = new QQToast(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity);
      localQQToast.d(2000);
      localQQToast.c(2131719975);
      localQQToast.a();
    }
    label162:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label103:
      j = 0;
      break label31;
      label108:
      if (16 <= this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a.size())
      {
        localQQToast = new QQToast(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity);
        localQQToast.d(2000);
        localQQToast.c(2131719974);
        localQQToast.a();
      }
      else
      {
        GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, DialogUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, 2131693127, 2131693133, null, this.jdField_a_of_type_ComTencentMobileqqUtilsGroupManagerInputTextWatcher, GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity), GroupManagerActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity)));
        GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.4
 * JD-Core Version:    0.7.0.1
 */