package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;

public class PlusPanelHelper
  implements ILifeCycleHelper
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PanelManager jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager;
  
  public PlusPanelHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private PlusPanel a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    }
    return (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
  }
  
  public String getTag()
  {
    return "PlusPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 9, 10, 11, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    PlusPanel localPlusPanel = a();
    if (localPlusPanel != null) {
      localPlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusPanelHelper
 * JD-Core Version:    0.7.0.1
 */