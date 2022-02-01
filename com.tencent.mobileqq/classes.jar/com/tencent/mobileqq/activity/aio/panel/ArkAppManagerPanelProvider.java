package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.ark.ArkAppManagerPanel;
import com.tencent.widget.XPanelContainer;

public class ArkAppManagerPanelProvider
  implements PanelProvider<ArkAppManagerPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ArkAppManagerPanel jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  
  public ArkAppManagerPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public ArkAppManagerPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
  }
  
  public ArkAppManagerPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel = ((ArkAppManagerPanel)View.inflate(paramContext, 2131558737, null));
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a);
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.ArkAppManagerPanelProvider
 * JD-Core Version:    0.7.0.1
 */