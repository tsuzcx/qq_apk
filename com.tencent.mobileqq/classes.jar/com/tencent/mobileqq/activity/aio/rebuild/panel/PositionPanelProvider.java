package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.widget.XPanelContainer;

public class PositionPanelProvider
  implements PanelProvider<View>
{
  private AIOContext a;
  
  public PositionPanelProvider(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
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
    return 9;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    AIOPanelUtiles.a(this.a.a(), this.a.b());
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.PositionPanelProvider
 * JD-Core Version:    0.7.0.1
 */