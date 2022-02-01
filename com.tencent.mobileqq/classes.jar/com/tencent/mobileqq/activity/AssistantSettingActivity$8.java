package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$8
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$8(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AssistantSettingActivity.a(this.a))
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (!NetworkUtil.g(this.a))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131694511, 0).b(this.a.getTitleBarHeight());
      localObject = this.a.e;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        ((FormMultiLineSwitchItem)localObject).setChecked(bool);
        break;
      }
    }
    Object localObject = QVipAutoPttProcessor.c();
    label131:
    label214:
    label235:
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1))
    {
      if (!QVipConfigManager.a(this.a.app, "have_show_ptt_tip", false))
      {
        QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box and tip to user");
        AssistantSettingActivity.b(this.a);
      }
      if ((!paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1)) {
        QVipConfigManager.b(this.a.app, "have_add_ptt_gray_msg", false);
      }
      AssistantSettingActivity.a(this.a, paramBoolean);
      ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p(paramBoolean);
      if (!paramBoolean) {
        break label324;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 1, 0, "", "", "", "");
      localObject = "normal";
      if (!VipUtils.c(this.a.app)) {
        break label351;
      }
      localObject = "vip";
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label371;
      }
    }
    label324:
    label351:
    label371:
    for (int i = 1;; i = 2)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", (String)localObject);
      break;
      if ((!paramBoolean) || (VipUtils.b(this.a.app))) {
        break label131;
      }
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box but u r not svip");
      AssistantSettingActivity.c(this.a);
      this.a.e.setChecked(false);
      break;
      ReportController.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 2, 0, "", "", "", "");
      break label214;
      if (!VipUtils.b(this.a.app)) {
        break label235;
      }
      localObject = "svip";
      break label235;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */