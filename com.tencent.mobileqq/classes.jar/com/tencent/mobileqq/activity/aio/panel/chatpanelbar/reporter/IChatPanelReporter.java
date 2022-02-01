package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import java.util.List;

public abstract interface IChatPanelReporter
{
  public abstract void a(IChatPanelBarData paramIChatPanelBarData);
  
  public abstract void a(List<AIOPanelIconItem> paramList);
  
  public abstract boolean a(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IChatPanelReporter
 * JD-Core Version:    0.7.0.1
 */