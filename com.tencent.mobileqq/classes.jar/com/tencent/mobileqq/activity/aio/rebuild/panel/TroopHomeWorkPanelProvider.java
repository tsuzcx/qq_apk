package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.widget.XPanelContainer;

public class TroopHomeWorkPanelProvider
  implements PanelProvider<View>
{
  private AIOContext a;
  
  public TroopHomeWorkPanelProvider(AIOContext paramAIOContext)
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
    return 32;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer = this.a.a().a;
    QQAppInterface localQQAppInterface = this.a.a();
    HWTroopUtils.a(localQQAppInterface, this.a.a(), paramXPanelContainer);
    TroopReportor.a(localQQAppInterface, paramXPanelContainer, "homework", "AioAssign_Clk", 0, 0, new String[] { paramXPanelContainer, "", "", TroopReportor.a(localQQAppInterface, paramXPanelContainer) });
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.TroopHomeWorkPanelProvider
 * JD-Core Version:    0.7.0.1
 */