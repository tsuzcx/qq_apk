package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IPanelBizReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.RedDotImageView;

public class AudioPanelBizReporter
  implements IPanelBizReporter
{
  public void a(IChatPanelBarData paramIChatPanelBarData, View paramView)
  {
    ((RedTouchManager)paramIChatPanelBarData.a().getManager(QQManagerFactory.MGR_RED_TOUCH)).b("103100.103300");
    if ((paramView instanceof RedDotImageView)) {
      ((RedDotImageView)paramView).a(false);
    }
    ReportController.b(paramIChatPanelBarData.a(), "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.AudioPanelBizReporter
 * JD-Core Version:    0.7.0.1
 */