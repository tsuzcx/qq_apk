package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XPanelContainer;

public class PokeAndEmoPanelProvider
  implements PanelProvider<PokeAndEmoPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PokeAndEmoPanel jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  
  PokeAndEmoPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public PokeAndEmoPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public PokeAndEmoPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel = ((PokeAndEmoPanel)View.inflate(paramContext, 2131558665, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public int getPanelId()
  {
    return 23;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a();
    }
    if ((paramInt1 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.c();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(23, false);
    PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.az();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "0X8007F20", "0X8007F20", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanelProvider
 * JD-Core Version:    0.7.0.1
 */