package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.GroupManagerInputTextWatcher;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GroupManagerActivity$4
  implements View.OnClickListener
{
  GroupManagerActivity$4(GroupManagerActivity paramGroupManagerActivity, GroupManagerInputTextWatcher paramGroupManagerInputTextWatcher) {}
  
  public void onClick(View paramView)
  {
    int k = VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.app).getVipStatus().getPrivilegeFlags(null);
    int j = 1;
    int i;
    if ((k & 0x2) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((k & 0x4) == 0) {
      j = 0;
    }
    if ((i == 0) && (j == 0))
    {
      if (16 <= this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a.size())
      {
        localObject = new QQToast(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity);
        ((QQToast)localObject).d(2000);
        ((QQToast)localObject).c(2131719706);
        ((QQToast)localObject).a();
        break label217;
      }
    }
    else if (30 <= this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a.size())
    {
      localObject = new QQToast(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity);
      ((QQToast)localObject).d(2000);
      ((QQToast)localObject).c(2131719707);
      ((QQToast)localObject).a();
      break label217;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity;
    GroupManagerActivity.a((GroupManagerActivity)localObject, DialogUtils.a((Context)localObject, 2131693087, 2131693093, null, this.jdField_a_of_type_ComTencentMobileqqUtilsGroupManagerInputTextWatcher, GroupManagerActivity.a((GroupManagerActivity)localObject), GroupManagerActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity)));
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, 0);
    label217:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.4
 * JD-Core Version:    0.7.0.1
 */