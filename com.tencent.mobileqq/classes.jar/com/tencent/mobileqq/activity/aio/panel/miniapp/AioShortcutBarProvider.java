package com.tencent.mobileqq.activity.aio.panel.miniapp;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
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
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)this.a.a(52);
    if (paramInt2 == 0)
    {
      localShortcutBarAIOHelper.c(false);
      localShortcutBarAIOHelper.h();
      return;
    }
    localShortcutBarAIOHelper.c(true);
    localShortcutBarAIOHelper.i();
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.miniapp.AioShortcutBarProvider
 * JD-Core Version:    0.7.0.1
 */