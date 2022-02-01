package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

class NotifyPushSettingActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$1(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = HttpUtil.getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    if (i == 0)
    {
      QQToast.a(this.a.getActivity(), 1, 2131696114, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      NotifyPushSettingActivity.a(this.a, paramBoolean ^ true);
    }
    else if (NotifyPushSettingActivity.a(this.a).compareAndSet(true, true))
    {
      QQToast.a(this.a.getActivity(), 1, 2131698376, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      NotifyPushSettingActivity.a(this.a, paramBoolean ^ true);
    }
    else
    {
      NotifyPushSettingActivity.a(this.a, paramBoolean);
      Object localObject;
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131707652));
        ((StringBuilder)localObject).append(NotifyPushSettingActivity.TimePickDialog.a(3600000L));
        localObject = ((StringBuilder)localObject).toString();
        NotifyPushSettingActivity.a(this.a).setRightText((CharSequence)localObject);
        NotifyPushSettingActivity.a(this.a).set(true);
        long l = NetConnInfoCenter.getServerTime();
        ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((int)(l + 3600L), "", "not_disturb_from_notify_push_setting_activity");
        localObject = this.a.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(60L);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, localStringBuilder.toString(), "0", "", "");
      }
      else
      {
        localObject = NotifyPushSettingActivity.a(this.a).a().getText().toString();
        NotifyPushSettingActivity.a(this.a).a().setText("");
        NotifyPushSettingActivity.a(this.a).set(true);
        ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(0, (String)localObject, "not_disturb_from_notify_push_setting_activity");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 2, "0", "0", "", "");
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */