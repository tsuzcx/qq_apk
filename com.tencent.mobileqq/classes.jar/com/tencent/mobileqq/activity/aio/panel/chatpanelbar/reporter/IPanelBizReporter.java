package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;

public abstract interface IPanelBizReporter
{
  public abstract void a(IChatPanelBarData paramIChatPanelBarData, View paramView);
  
  public abstract void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IPanelBizReporter
 * JD-Core Version:    0.7.0.1
 */