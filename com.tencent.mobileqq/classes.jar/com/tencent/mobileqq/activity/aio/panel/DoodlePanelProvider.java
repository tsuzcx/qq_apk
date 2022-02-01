package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodlePanel;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.doodle.IDoodlePanelHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XPanelContainer;

public class DoodlePanelProvider
  implements PanelProvider<BaseDoodlePanel>
{
  BaseDoodlePanel a;
  BaseChatPie b;
  
  public DoodlePanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  public BaseDoodlePanel a()
  {
    return this.a;
  }
  
  public BaseDoodlePanel a(Context paramContext)
  {
    this.a = b(paramContext);
    paramContext = new DoodlePanelProvider.1(this);
    this.a.a(this.b.bv(), paramContext);
    return this.a;
  }
  
  BaseDoodlePanel b(Context paramContext)
  {
    return ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getDoodlePanel(paramContext);
  }
  
  public int getPanelId()
  {
    return 18;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper;
    if (paramInt1 == 18)
    {
      boolean bool = true;
      if (paramInt2 != 1) {
        bool = false;
      }
      this.a.b(bool);
      localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.b.q(52);
      if (localAIOShortcutBarHelper != null) {
        localAIOShortcutBarHelper.d(12);
      }
    }
    if (paramInt2 == 18)
    {
      localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.b.q(52);
      if (localAIOShortcutBarHelper != null) {
        localAIOShortcutBarHelper.d(11);
      }
      this.a.b();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 18) && (this.b.W != null)) {
      this.b.W.setSelected(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.DoodlePanelProvider
 * JD-Core Version:    0.7.0.1
 */