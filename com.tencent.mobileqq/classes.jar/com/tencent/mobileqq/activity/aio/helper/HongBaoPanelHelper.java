package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;

public class HongBaoPanelHelper
  implements ILifeCycleHelper
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PanelManager jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager;
  
  public HongBaoPanelHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private HongBaoPanel a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    }
    return (HongBaoPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(10);
  }
  
  private void a()
  {
    HongBaoPanel localHongBaoPanel = a();
    if (localHongBaoPanel != null) {
      localHongBaoPanel.onDestory();
    }
  }
  
  public String getTag()
  {
    return "HongbaoPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HongBaoPanelHelper
 * JD-Core Version:    0.7.0.1
 */