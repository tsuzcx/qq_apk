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
    int k = VasUtil.b(this.b.app).getVipStatus().getPrivilegeFlags(null);
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
      if (16 <= this.b.a.size())
      {
        localObject = new QQToast(this.b);
        ((QQToast)localObject).setDuration(2000);
        ((QQToast)localObject).setToastMsg(2131917309);
        ((QQToast)localObject).show();
        break label217;
      }
    }
    else if (30 <= this.b.a.size())
    {
      localObject = new QQToast(this.b);
      ((QQToast)localObject).setDuration(2000);
      ((QQToast)localObject).setToastMsg(2131917310);
      ((QQToast)localObject).show();
      break label217;
    }
    Object localObject = this.b;
    GroupManagerActivity.a((GroupManagerActivity)localObject, DialogUtils.a((Context)localObject, 2131890201, 2131890207, null, this.a, GroupManagerActivity.b((GroupManagerActivity)localObject), GroupManagerActivity.c(this.b)));
    GroupManagerActivity.a(this.b, 0);
    label217:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.4
 * JD-Core Version:    0.7.0.1
 */