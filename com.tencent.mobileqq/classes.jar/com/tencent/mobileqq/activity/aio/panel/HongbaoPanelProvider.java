package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XPanelContainer;

public class HongbaoPanelProvider
  implements PanelProvider<HongBaoPanel>
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private HongBaoPanel jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public HongbaoPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public HongBaoPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  }
  
  public HongBaoPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel = ((HongBaoPanel)View.inflate(paramContext, 2131560645, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
  }
  
  public int getPanelId()
  {
    return 10;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 10) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel.reportIconListClick();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.HongbaoPanelProvider
 * JD-Core Version:    0.7.0.1
 */