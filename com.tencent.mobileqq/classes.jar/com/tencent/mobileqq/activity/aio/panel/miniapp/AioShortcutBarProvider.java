package com.tencent.mobileqq.activity.aio.panel.miniapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.widget.XPanelContainer;

public class AioShortcutBarProvider
  implements PanelProvider<View>
{
  private BaseChatPie a;
  
  public AioShortcutBarProvider(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
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
    return 38;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.a.q(52);
    if (localAIOShortcutBarHelper != null)
    {
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent();
      if (paramInt2 == 0)
      {
        localAIOShortcutBarEvent.a = 12;
        localAIOShortcutBarEvent.a().putBoolean("InputJump", false);
        localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
        return;
      }
      localAIOShortcutBarEvent.a = 11;
      localAIOShortcutBarEvent.a().putBoolean("InputJump", true);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.miniapp.AioShortcutBarProvider
 * JD-Core Version:    0.7.0.1
 */