package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.PayRuleCfg;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSuperMemberPayButtonBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

class QQSettingMeSuperMemberProcessor$7
  implements View.OnClickListener
{
  QQSettingMeSuperMemberProcessor$7(QQSettingMeSuperMemberProcessor paramQQSettingMeSuperMemberProcessor, QQSettingMeSuperMemberPayButtonBean paramQQSettingMeSuperMemberPayButtonBean) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d != null)
    {
      if (this.a.d.clickHide == 1)
      {
        this.a.d.enable = 0;
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler click clear enable");
        VipInfoHandler.a(this.b.c.getCurrentUin(), this.a.d);
      }
      ReportController.b(null, "dc00898", "", "", "", "0X800A633", VipInfoHandler.b(this.a.d), 1, 0, "1", this.a.d.advId, "", "");
      VipInfoHandler.a(102, this.a.d.advId);
      Object localObject;
      if (!TextUtils.isEmpty(this.a.d.iconJumpUrl))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VipInfoHandler click iconJumpUrl: ");
        ((StringBuilder)localObject).append(this.a.d.iconJumpUrl);
        QLog.e("QQSettingRedesign", 1, ((StringBuilder)localObject).toString());
        localObject = new Intent(this.b.d, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("url", this.a.d.iconJumpUrl);
        ((Intent)localObject).putExtra("isShowAd", false);
        this.b.d.startActivity((Intent)localObject);
      }
      else
      {
        int i = this.a.d.clubType;
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("VipInfoHandler unknown clubType=");
            ((StringBuilder)localObject).append(this.a.d.clubType);
            QLog.e("QQSettingRedesign", 1, ((StringBuilder)localObject).toString());
            break label429;
          }
          i = 12;
        }
        else
        {
          i = 11;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VipInfoHandler click type: ");
        ((StringBuilder)localObject).append(this.a.d.clubType);
        QLog.e("QQSettingRedesign", 1, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jsbridge://vipclub/paySuccess?p={\"type\":");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("}");
        localObject = URLEncoder.encode(((StringBuilder)localObject).toString());
        VasH5PayUtil.a(this.b.d, this.a.d.aid, "CJCLUBT", 3, false, false, "", (String)localObject, true, true);
      }
    }
    label429:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.7
 * JD-Core Version:    0.7.0.1
 */