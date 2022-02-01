package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IPanelBizReporter;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.utils.ReportUtils;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.statistics.ReportController;

public class HongbaoPanelBizReporter
  implements IPanelBizReporter
{
  public void a(IChatPanelBarData paramIChatPanelBarData, View paramView)
  {
    PlusPanelUtils.a(1);
    String str = SessionTypeUtil.a(paramIChatPanelBarData.a());
    ReportController.b(paramIChatPanelBarData.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", str, 0, 0, "", "", "", "");
    ReportUtils.a(paramIChatPanelBarData.a(), "aio.luckyquick.click", paramIChatPanelBarData.a());
    QWalletTools.a(paramIChatPanelBarData.a(), paramView, paramIChatPanelBarData.a());
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.HongbaoPanelBizReporter
 * JD-Core Version:    0.7.0.1
 */