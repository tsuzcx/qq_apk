package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter;

import android.view.View;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IPanelBizReporter;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mobileqq.statistics.ReportController;

public class HongbaoPanelBizReporter
  implements IPanelBizReporter
{
  public void a(IChatPanelBarData paramIChatPanelBarData, View paramView)
  {
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).setPanelFrom(1);
    String str = SessionTypeUtil.a(paramIChatPanelBarData.a());
    ReportController.b(paramIChatPanelBarData.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", str, 0, 0, "", "", "", "");
    ((IReportApi)QRoute.api(IReportApi.class)).reportHongbaoTo644(paramIChatPanelBarData.a(), "aio.luckyquick.click", paramIChatPanelBarData.a());
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).clickAIOHongBaoRedPoint(paramView, paramIChatPanelBarData.a());
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.HongbaoPanelBizReporter
 * JD-Core Version:    0.7.0.1
 */