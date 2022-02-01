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
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  BaseDoodlePanel jdField_a_of_type_ComTencentMobileqqActivityAioDoodleBaseDoodlePanel;
  
  public DoodlePanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public BaseDoodlePanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleBaseDoodlePanel;
  }
  
  public BaseDoodlePanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleBaseDoodlePanel = b(paramContext);
    paramContext = new DoodlePanelProvider.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleBaseDoodlePanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), paramContext);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleBaseDoodlePanel;
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleBaseDoodlePanel.a(bool);
      localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
      if (localAIOShortcutBarHelper != null) {
        localAIOShortcutBarHelper.c(12);
      }
    }
    if (paramInt2 == 18)
    {
      localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
      if (localAIOShortcutBarHelper != null) {
        localAIOShortcutBarHelper.c(11);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleBaseDoodlePanel.a();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 18) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.setSelected(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.DoodlePanelProvider
 * JD-Core Version:    0.7.0.1
 */