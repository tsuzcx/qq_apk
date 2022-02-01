package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.ark.ArkAppManagerPanel;
import com.tencent.widget.XPanelContainer;

public class ArkAppManagerPanelProvider
  implements PanelProvider<ArkAppManagerPanel>
{
  private final BaseChatPie a;
  private ArkAppManagerPanel b;
  
  public ArkAppManagerPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public ArkAppManagerPanel a()
  {
    return this.b;
  }
  
  public ArkAppManagerPanel a(Context paramContext)
  {
    this.b = ((ArkAppManagerPanel)View.inflate(paramContext, 2131624251, null));
    paramContext = this.b;
    BaseChatPie localBaseChatPie = this.a;
    paramContext.a(localBaseChatPie, localBaseChatPie.ah);
    return this.b;
  }
  
  public int getPanelId()
  {
    return 30;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.ArkAppManagerPanelProvider
 * JD-Core Version:    0.7.0.1
 */