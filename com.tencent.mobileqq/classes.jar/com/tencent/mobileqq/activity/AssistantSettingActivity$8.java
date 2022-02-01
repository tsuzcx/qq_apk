package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.IVipStatusManager;
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
    if (!AssistantSettingActivity.a(this.a)) {
      if (!NetworkUtil.isNetworkAvailable(this.a))
      {
        QQToast.a(BaseApplication.getContext(), 1, 2131694476, 0).b(this.a.getTitleBarHeight());
        this.a.e.setChecked(paramBoolean ^ true);
      }
      else
      {
        Object localObject = QVipAutoPttProcessor.c();
        if ((paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1))
        {
          if (!QVipConfigManager.a(this.a.app, "have_show_ptt_tip", false))
          {
            QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box and tip to user");
            AssistantSettingActivity.b(this.a);
          }
        }
        else if ((paramBoolean) && (!VasUtil.a(this.a.app).getVipStatus().isSVip()))
        {
          QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box but u r not svip");
          AssistantSettingActivity.c(this.a);
          this.a.e.setChecked(false);
          break label387;
        }
        if ((!paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1)) {
          QVipConfigManager.b(this.a.app, "have_add_ptt_gray_msg", false);
        }
        AssistantSettingActivity.a(this.a, paramBoolean);
        ((CardHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p(paramBoolean);
        if (paramBoolean) {
          ReportController.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 1, 0, "", "", "", "");
        } else {
          ReportController.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 2, 0, "", "", "", "");
        }
        if (VasUtil.a(this.a.app).getVipStatus().isVip()) {
          localObject = "vip";
        } else if (VasUtil.a(this.a.app).getVipStatus().isSVip()) {
          localObject = "svip";
        } else {
          localObject = "normal";
        }
        QQAppInterface localQQAppInterface = this.a.app;
        int i;
        if (paramBoolean) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", (String)localObject);
      }
    }
    label387:
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */