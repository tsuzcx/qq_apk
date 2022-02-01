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
    String str = SessionTypeUtil.a(paramIChatPanelBarData.h());
    ReportController.b(paramIChatPanelBarData.e(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", str, 0, 0, "", "", "", "");
    ((IReportApi)QRoute.api(IReportApi.class)).reportHongbaoTo644(paramIChatPanelBarData.e(), "aio.luckyquick.click", paramIChatPanelBarData.h());
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).clickAIOHongBaoRedPoint(paramView, paramIChatPanelBarData.g());
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.HongbaoPanelBizReporter
 * JD-Core Version:    0.7.0.1
 */