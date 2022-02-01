package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;

class QQSettingMe$24
  implements View.OnClickListener
{
  QQSettingMe$24(QQSettingMe paramQQSettingMe) {}
  
  public void onClick(View paramView)
  {
    if (QQSettingMe.a(this.a) == null) {}
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QQSettingMe.a(this.a).clickHide == 1)
      {
        QQSettingMe.a(this.a).enable = 0;
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler click clear enable");
        VipInfoHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), QQSettingMe.a(this.a));
      }
      ReportController.b(null, "dc00898", "", "", "", "0X800A633", VipInfoHandler.a(QQSettingMe.a(this.a)), 1, 0, "1", QQSettingMe.a(this.a).advId, "", "");
      VipInfoHandler.a(102, QQSettingMe.a(this.a).advId);
      if (!TextUtils.isEmpty(QQSettingMe.a(this.a).iconJumpUrl))
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler click iconJumpUrl: " + QQSettingMe.a(this.a).iconJumpUrl);
        localObject = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("url", QQSettingMe.a(this.a).iconJumpUrl);
        ((Intent)localObject).putExtra("isShowAd", false);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      }
      else
      {
        switch (QQSettingMe.a(this.a).clubType)
        {
        default: 
          QLog.e("QQSettingRedesign", 1, "VipInfoHandler unknown clubType=" + QQSettingMe.a(this.a).clubType);
        }
      }
    }
    for (int i = 11;; i = 12)
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler click type: " + QQSettingMe.a(this.a).clubType);
      localObject = URLEncoder.encode("jsbridge://vipclub/paySuccess?p={\"type\":" + i + "}");
      VasH5PayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingMe.a(this.a).aid, "CJCLUBT", 3, false, false, "", (String)localObject, true, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.24
 * JD-Core Version:    0.7.0.1
 */