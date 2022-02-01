package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IPanelBizReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.troop.widget.RedDotImageView;

public class AudioPanelBizReporter
  implements IPanelBizReporter
{
  public void a(IChatPanelBarData paramIChatPanelBarData, View paramView)
  {
    ((IRedTouchManager)paramIChatPanelBarData.a().getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103300");
    if ((paramView instanceof RedDotImageView)) {
      ((RedDotImageView)paramView).a(false);
    }
    ReportController.b(paramIChatPanelBarData.a(), "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.AudioPanelBizReporter
 * JD-Core Version:    0.7.0.1
 */