package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XPanelContainer;

public class QQAssistantProvider
  implements PanelProvider<View>
{
  private boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 2)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "chatPie change";
      }
      return "chatPie change EXT_PANEL_AUDIO";
    }
    return "chatPie change SOFT_INPUT_PANEL";
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
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).stopRecord(b(paramInt2));
    }
    if ((bool1) && (!bool2)) {
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).startRecord(b(paramInt1));
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.QQAssistantProvider
 * JD-Core Version:    0.7.0.1
 */