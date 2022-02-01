package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

class ForwardRecentActivity$25
  implements View.OnClickListener
{
  ForwardRecentActivity$25(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a.getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("key_forward_business_id");
    if (!this.a.mForwardOption.f())
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        boolean bool = ((Intent)localObject1).hasExtra("file_send_path");
        ForwardToQzoneUtils.a(this.a.app, this.a, (Intent)localObject1, (String)localObject2, bool);
      }
      else
      {
        int i = 0;
        int j = ((Intent)localObject1).getIntExtra("req_type", 0);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("-->addQZoneEntry--onClick--req_type = ");
          ((StringBuilder)localObject2).append(j);
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject3 = ((Intent)localObject1).getExtras();
        localObject2 = ((Bundle)localObject3).getString("image_url_remote");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((Bundle)localObject3).getString("image_url");
        }
        localObject2 = new ArrayList();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).split(";");
          while (i < localObject1.length)
          {
            ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[i]));
            i += 1;
          }
        }
        ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject2);
        ((Bundle)localObject3).putString("share_action", "shareToQQ");
        ((Bundle)localObject3).putString("jfrom", "login");
        ((Bundle)localObject3).putBoolean("thirdPartShare", true);
        com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = true;
        QZoneShareManager.jumpToQzoneShare(this.a.app, this.a, (Bundle)localObject3, null);
        localObject1 = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject1).actionType = "1";
        ((QZoneClickReport.ReportInfo)localObject1).subactionType = "0";
        ((QZoneClickReport.ReportInfo)localObject1).tabletype = 4;
        ((QZoneClickReport.ReportInfo)localObject1).sourceType = "5";
        ((QZoneClickReport.ReportInfo)localObject1).sourceFrom = "thirdApp";
        ((QZoneClickReport.ReportInfo)localObject1).sourceTo = "activefeed";
        QZoneClickReport.startReportImediately(this.a.app.getAccount(), (QZoneClickReport.ReportInfo)localObject1);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("source_type", "5");
        ((HashMap)localObject1).put("source_from", "thirdApp");
        ((HashMap)localObject1).put("source_to", "activefeed");
        StatisticCollector.getInstance(this.a.getApplicationContext()).collectPerformance(this.a.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
        if (this.a.isSdkShare)
        {
          ReportCenter.a().a(this.a.app.getAccount(), "", this.a.appid, "1000", "33", "0", false, this.a.isSdkShare);
          if ((this.a.mForwardOption instanceof ForwardSdkBaseOption))
          {
            localObject2 = (ForwardSdkBaseOption)this.a.mForwardOption;
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("report_type", "102");
            ((Bundle)localObject1).putString("act_type", "81");
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(ReportDef.RepUtil.a(((ForwardSdkBaseOption)localObject2).e));
            ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject3).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(ReportDef.RepUtil.a(-1, AppConstants.QZONE_UIN));
            ((Bundle)localObject1).putString("intext_2", ((StringBuilder)localObject2).toString());
            ((Bundle)localObject1).putString("intext_3", "0");
            ReportCenter.a().a((Bundle)localObject1, "", this.a.app.getCurrentAccountUin(), false, this.a.isSdkShare);
          }
        }
        if ((this.a.isSdkShare) && (j == 5)) {
          ForwardRecentActivity.access$3000(this.a);
        } else {
          this.a.finish();
        }
      }
      this.a.mForwardOption.a().putString("uin", "-1010");
      this.a.mForwardOption.E();
      ReportController.b(this.a.app, "CliOper", "", "", "friendchoose", "0X800A2D7", ForwardRecentActivity.access$800(this.a), 0, "", "", "", ForwardRecentActivity.access$1300(this.a));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_receiver_type", 3L);
      if ("caller_aecamera".equals(this.a.mCallActivity)) {
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", (Bundle)localObject1, null);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.25
 * JD-Core Version:    0.7.0.1
 */