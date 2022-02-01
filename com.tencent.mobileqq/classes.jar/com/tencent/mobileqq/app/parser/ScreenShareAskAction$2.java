package com.tencent.mobileqq.app.parser;

import com.tencent.av.ui.ScreenShareAskArkBottomUpDialog.OnConfirmListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

class ScreenShareAskAction$2
  implements ScreenShareAskArkBottomUpDialog.OnConfirmListener
{
  ScreenShareAskAction$2(ScreenShareAskAction paramScreenShareAskAction, BaseActivity paramBaseActivity, BaseChatPie paramBaseChatPie, String paramString) {}
  
  public void a()
  {
    PlusPanelUtils.a(ScreenShareAskAction.a(this.d), this.a, this.b.ah, true, "AIOShareScreen", null);
    ReportController.b(null, "dc00898", "", "", "0X800B8A6", "0X800B8A6", 0, 0, this.c, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskAction.2
 * JD-Core Version:    0.7.0.1
 */