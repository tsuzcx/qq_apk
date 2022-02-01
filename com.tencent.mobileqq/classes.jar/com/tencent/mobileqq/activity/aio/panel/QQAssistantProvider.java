package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.widget.XPanelContainer;

class QQAssistantProvider
  implements PanelProvider<View>
{
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "chatPie change";
    case 2: 
      return "chatPie change EXT_PANEL_AUDIO";
    }
    return "chatPie change SOFT_INPUT_PANEL";
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  public View createPanel(Context paramContext)
  {
    return null;
  }
  
  public View getPanel()
  {
    return null;
  }
  
  public int getPanelId()
  {
    return 39;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    boolean bool1 = a(paramInt1);
    boolean bool2 = a(paramInt2);
    if (bool2) {
      WakeManager.a().b(a(paramInt2));
    }
    if ((bool1) && (!bool2)) {
      WakeManager.a().a(a(paramInt1));
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.QQAssistantProvider
 * JD-Core Version:    0.7.0.1
 */