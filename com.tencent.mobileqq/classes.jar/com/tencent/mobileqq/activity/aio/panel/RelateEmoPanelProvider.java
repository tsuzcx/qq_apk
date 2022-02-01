package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper;
import com.tencent.widget.XPanelContainer;

public class RelateEmoPanelProvider
  implements PanelProvider<View>
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  RelateEmoPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public View createPanel(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((AIORelatedEmotionHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(72)).a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public View getPanel()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public int getPanelId()
  {
    return 37;
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.RelateEmoPanelProvider
 * JD-Core Version:    0.7.0.1
 */