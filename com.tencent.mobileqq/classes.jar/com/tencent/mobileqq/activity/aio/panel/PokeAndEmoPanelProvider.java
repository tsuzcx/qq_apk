package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.widget.XPanelContainer;

public class PokeAndEmoPanelProvider
  implements PanelProvider<PokeAndEmoPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PokeAndEmoPanel jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  
  public PokeAndEmoPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public PokeAndEmoPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public PokeAndEmoPanel a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel = ((PokeAndEmoPanel)View.inflate(paramContext, 2131558563, null));
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    paramContext.a(localBaseChatPie, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    if (a(localQQAppInterface, localSessionInfo, PokeItemHelper.a(localQQAppInterface)))
    {
      ChatActivityFacade.b(localQQAppInterface, BaseApplicationImpl.getContext(), localSessionInfo);
      return;
    }
    PokeItemHelper.d(localQQAppInterface);
    if (PokePanel.c)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(23);
      }
    }
    else
    {
      a(localQQAppInterface);
      ChatActivityFacade.b(localQQAppInterface, BaseApplicationImpl.getContext(), localSessionInfo);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    PokePanel.a(paramQQAppInterface);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if ((bool2) || ((PokeItemHelper.b(paramQQAppInterface, 1) == 0) && (PokeItemHelper.b(paramQQAppInterface, 0) == 0)) || (QidianManager.b(paramQQAppInterface, paramSessionInfo.a))) {
      bool1 = true;
    }
    return bool1;
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
    PokeAndEmoPanel localPokeAndEmoPanel;
    if (paramInt2 == 23)
    {
      localPokeAndEmoPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
      if (localPokeAndEmoPanel != null) {
        localPokeAndEmoPanel.a();
      }
    }
    if (paramInt1 == 23)
    {
      localPokeAndEmoPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
      if (localPokeAndEmoPanel != null) {
        localPokeAndEmoPanel.c();
      }
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(23, false);
    PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "0X8007F20", "0X8007F20", 0, 0, "", "", "", "");
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanelProvider
 * JD-Core Version:    0.7.0.1
 */