package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.content.Intent;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class AuthDevActivity$4
  implements ActionSheet.OnButtonClickListener
{
  AuthDevActivity$4(AuthDevActivity paramAuthDevActivity, String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        break label368;
      }
      if (!AuthDevActivity.access$1000(this.i)) {}
    }
    for (;;)
    {
      try
      {
        if (!this.e) {
          break label431;
        }
        paramView = "0X800AC56";
        ReportController.b(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        AuthDevActivity.access$1100(this.i, this.c, this.f, this.a, this.d, this.g, this.h, this.b);
      }
      catch (Throwable paramView)
      {
        QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "showDelDevActionSheet error : ", paramView.getMessage() });
      }
      if (!NetworkUtil.isNetSupport(this.i))
      {
        paramView = this.i;
        QQToast.makeText(paramView, paramView.getString(2131889169), 0).show(this.i.getTitleBarHeight());
      }
      else
      {
        QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick.begin to del recent dev");
        if (AuthDevActivity.access$1300(this.i).delHistoryDev(AuthDevActivity.access$1200(this.i), this.a, this.f, this.d))
        {
          AuthDevActivity.access$1400(this.i);
        }
        else
        {
          QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick del recent dev fail");
          break label368;
          paramView = new Intent();
          paramView.putExtra("appname", this.a);
          paramView.putExtra("appid", this.b);
          paramView.putExtra("sub_appid", AppSetting.d());
          paramView.putExtra("device_guid", NetConnInfoCenter.GUID);
          paramView.putExtra("target_name", this.c);
          paramView.putExtra("target_type_info", ((SvcDevLoginInfo)AuthDevActivity.access$900(this.i).get(this.d)).strDeviceTypeInfo);
          paramView.putExtra("target_desc", ((SvcDevLoginInfo)AuthDevActivity.access$900(this.i).get(this.d)).stDeviceItemDes.vecItemDes);
          paramView.putExtra("index", this.d);
          RouteUtils.a(this.i, paramView, "/base/safe/devRenameActivity");
        }
      }
      label368:
      if ((AuthDevActivity.access$1500(this.i) != null) && (AuthDevActivity.access$1500(this.i).isShowing()) && (!this.i.isFinishing()))
      {
        AuthDevActivity.access$1500(this.i).dismiss();
        AuthDevActivity.access$1500(this.i).cancel();
        AuthDevActivity.access$1502(this.i, null);
      }
      return;
      label431:
      paramView = "0X800AC58";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.4
 * JD-Core Version:    0.7.0.1
 */