package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;

public class PokeAndEmoPanelHelper
  implements ILifeCycleHelper
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PanelManager jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public PokeAndEmoPanelHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  private PokeAndEmoPanel a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    }
    return (PokeAndEmoPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(23);
  }
  
  private void a()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.a();
    }
  }
  
  private void b()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.c();
    }
  }
  
  private void c()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null)
    {
      localPokeAndEmoPanel.b();
      PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), PokeItemHelper.a);
    }
  }
  
  public String getTag()
  {
    return "PokeAndEmoPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 11, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    case 12: 
    case 13: 
    default: 
      return;
    case 9: 
      a();
      return;
    case 11: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PokeAndEmoPanelHelper
 * JD-Core Version:    0.7.0.1
 */