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

class MoveToGroupActivity$3
  implements View.OnClickListener
{
  MoveToGroupActivity$3(MoveToGroupActivity paramMoveToGroupActivity, GroupManagerInputTextWatcher paramGroupManagerInputTextWatcher) {}
  
  public void onClick(View paramView)
  {
    Object localObject = MoveToGroupActivity.c(this.b);
    int k = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = MoveToGroupActivity.c(this.b).size();
    }
    int m = VasUtil.b(this.b.app).getVipStatus().getPrivilegeFlags(null);
    int j;
    if ((m & 0x2) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((m & 0x4) != 0) {
      k = 1;
    }
    if ((j == 0) && (k == 0))
    {
      if (16 == i)
      {
        localObject = new QQToast(this.b);
        ((QQToast)localObject).setDuration(2000);
        ((QQToast)localObject).setToastMsg(2131917309);
        ((QQToast)localObject).show();
        break label212;
      }
    }
    else if (30 == i)
    {
      localObject = new QQToast(this.b);
      ((QQToast)localObject).setDuration(2000);
      ((QQToast)localObject).setToastMsg(2131917310);
      ((QQToast)localObject).show();
      break label212;
    }
    localObject = this.b;
    MoveToGroupActivity.a((MoveToGroupActivity)localObject, DialogUtils.a((Context)localObject, 2131890201, 2131890207, null, this.a, MoveToGroupActivity.d((MoveToGroupActivity)localObject), null));
    label212:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.3
 * JD-Core Version:    0.7.0.1
 */