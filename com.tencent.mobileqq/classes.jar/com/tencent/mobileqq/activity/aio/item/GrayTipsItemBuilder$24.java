package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;

class GrayTipsItemBuilder$24
  extends ClickableSpan
{
  GrayTipsItemBuilder$24(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Bundle paramBundle, String paramString4, int paramInt3, long paramLong, String paramString5, int paramInt4, String paramString6) {}
  
  public void onClick(View paramView)
  {
    if (this.a.compareToIgnoreCase("makePhoneCall") == 0)
    {
      ReportController.b(this.m.a, "P_CliOper", "Safe_SensMsg", this.b, "Tips_Click", "makePhoneCall", this.c, this.d, "", "", "", "");
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.e);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      this.m.c.startActivity(paramView);
      return;
    }
    if (this.a.compareToIgnoreCase("showAlert") == 0)
    {
      paramView = this.f.getString("AlertTitle");
      String str1 = this.f.getString("AlertText");
      String str2 = this.f.getString("AlertOtherBtnText");
      String str3 = this.f.getString("AlertCancelBtnText");
      MQPSensitiveMsgUtil.a(this.g, this.h, this.i, paramView, str1, str2, str3);
      return;
    }
    if (this.a.compareToIgnoreCase("openURL") == 0)
    {
      ReportController.b(this.m.a, "P_CliOper", "Safe_SensMsg", this.b, "Tips_Click", "openURL", this.c, this.d, "", "", "", "");
      GrayTipsItemBuilder.a(this.m, this.f);
      return;
    }
    if (this.a.compareToIgnoreCase("transfer") == 0)
    {
      ReportController.b(this.m.a, "P_CliOper", "Safe_SensMsg", this.b, "Tips_Click", "transfer", this.c, this.d, "", "", "", "");
      GrayTipsItemBuilder.a(this.m, this.j, this.k, this.b, this.g);
      return;
    }
    if (this.a.compareToIgnoreCase("openDeviceLock") == 0)
    {
      ReportController.b(this.m.a, "P_CliOper", "Safe_SensMsg", this.b, "Tips_Click", "openDeviceLock", this.c, this.d, "", "", "", "");
      paramView = new Intent();
      paramView.setFlags(268435456);
      paramView.setAction("android.intent.action.VIEW");
      paramView.putExtra("devlock_open_source", "Graytips");
      paramView.putExtra("enable_open_allowset_dev", true);
      paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
      this.m.c.startActivity(paramView);
      return;
    }
    if (this.a.compareToIgnoreCase("tipOff") == 0)
    {
      ReportController.b(this.m.a, "P_CliOper", "Safe_SensMsg", this.b, "Tips_Click", "tipOff", this.c, this.d, "", "", "", "");
      NewReportPlugin.a((BaseActivity)this.m.c, this.m.d.a, this.m.d.b, this.m.a.getCurrentAccountUin());
      return;
    }
    if ((this.a.compareToIgnoreCase("QQCall") != 0) && (this.a.compareToIgnoreCase("videoCall") != 0))
    {
      if (this.a.compareToIgnoreCase("luckyMoney") == 0)
      {
        ReportController.b(this.m.a, "P_CliOper", "Safe_SensMsg", this.b, "Tips_Click", "luckyMoney", this.c, this.d, "", "", "", "");
        GrayTipsItemBuilder.a(this.m, this.k);
      }
    }
    else
    {
      ReportController.b(this.m.a, "P_CliOper", "Safe_SensMsg", this.b, "Tips_Click", this.a, this.c, this.d, "", "", "", "");
      GrayTipsItemBuilder.a(this.m, this.j, this.k, this.b, this.g, this.l, this.a);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.24
 * JD-Core Version:    0.7.0.1
 */