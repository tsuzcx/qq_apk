package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarController;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus.RedBagShowData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IPanelBizReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class PtvPanelBizReporter
  implements IPanelBizReporter
{
  private IChatPanelBarController a;
  
  public PtvPanelBizReporter(IChatPanelBarController paramIChatPanelBarController)
  {
    this.a = paramIChatPanelBarController;
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, View paramView)
  {
    if ((ShortVideoUtils.supportShortVideoMergePhoto()) && (CameraUtils.a())) {
      ReportController.b(paramIChatPanelBarData.a(), "dc00898", "", "", "0X80072C0", "0X80072C0", 0, 0, "", "", "", "");
    }
    if (paramIChatPanelBarData.a().a())
    {
      this.a.a(6, false);
      ShortVideoUtils.setPtvRedDotStatus(paramIChatPanelBarData.a().getCurrentUin(), false);
      ReportController.b(paramIChatPanelBarData.a(), "dc00898", "", "", "0X8009367", "0X8009367", 1, 0, "", "", "", "");
      paramIChatPanelBarData.a().a(false);
    }
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.PtvPanelBizReporter
 * JD-Core Version:    0.7.0.1
 */