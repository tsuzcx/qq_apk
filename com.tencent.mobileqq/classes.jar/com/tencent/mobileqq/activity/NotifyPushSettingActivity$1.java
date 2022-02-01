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

class NotifyPushSettingActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$1(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = HttpUtil.getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    Object localObject;
    if (i == 0)
    {
      QQToast.a(this.a.getActivity(), 1, 2131696097, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
      localObject = this.a;
      if (!paramBoolean) {
        NotifyPushSettingActivity.a((NotifyPushSettingActivity)localObject, bool1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool1 = false;
      break;
      if (NotifyPushSettingActivity.a(this.a).compareAndSet(true, true))
      {
        QQToast.a(this.a.getActivity(), 1, 2131698311, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
        localObject = this.a;
        if (!paramBoolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          NotifyPushSettingActivity.a((NotifyPushSettingActivity)localObject, bool1);
          break;
        }
      }
      NotifyPushSettingActivity.a(this.a, paramBoolean);
      if (paramBoolean)
      {
        localObject = HardCodeUtil.a(2131707627) + NotifyPushSettingActivity.TimePickDialog.a(3600000L);
        NotifyPushSettingActivity.a(this.a).setRightText((CharSequence)localObject);
        NotifyPushSettingActivity.a(this.a).set(true);
        long l = NetConnInfoCenter.getServerTime();
        ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((int)(3600L + l), "", "not_disturb_from_notify_push_setting_activity");
        ReportController.b(this.a.app, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, 60L + "", "0", "", "");
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */