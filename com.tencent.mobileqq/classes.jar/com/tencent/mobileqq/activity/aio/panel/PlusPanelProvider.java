package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager;
import com.tencent.mobileqq.troop.aioapp.GroupUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class PlusPanelProvider
  implements PanelProvider<PlusPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PlusPanel jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
  
  PlusPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public PlusPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
  }
  
  public PlusPanel a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel = ((PlusPanel)View.inflate(paramContext, 2131558667, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
  }
  
  public void a()
  {
    Object localObject = ((SingTogetherConfigBean)QConfigManager.a().a(551)).a(4);
    if ((localObject != null) && (((SingTogetherConfigBean.GeneralTogetherItem)localObject).d > 0)) {
      if (((SingTogetherConfigBean.GeneralTogetherItem)localObject).c != 1) {
        break label159;
      }
    }
    label159:
    for (int i = 1109995692;; i = ((SingTogetherConfigBean.GeneralTogetherItem)localObject).d)
    {
      ((FetchOpenIdManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel.a();
      }
      localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (((RedTouchManager)localObject).a(10, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ((PlusRedPointHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(89)).a()) != null)) {
        ((RedTouchManager)localObject).b(10, 31);
      }
      return;
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    if (!paramTroopChatPie.F()) {
      ReportController.b(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = new AIOGiftPanelContainer(paramTroopChatPie);
    }
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer;
    int j = TroopGiftPanel.e;
    if (AnonymousChatHelper.a().a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    for (int i = 4;; i = 1)
    {
      localAIOGiftPanelContainer.a(j, i);
      AioGroupAppsManager.a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(GroupUtil.a(paramTroopChatPie.d()));
      paramTroopChatPie = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramTroopChatPie.a(11, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ((PlusRedPointHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(89)).a()) != null)) {
        paramTroopChatPie.b(11, 31);
      }
      return;
    }
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    ((FastImageHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(83)).b();
    paramXPanelContainer.a(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.n(0);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004078", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramXPanelContainer = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    if (paramXPanelContainer != null)
    {
      paramXPanelContainer = (PokeResHandler)paramXPanelContainer.a("qq.android.poke.res_0625");
      if ((paramXPanelContainer != null) && (!paramXPanelContainer.g())) {
        paramXPanelContainer.a(false);
      }
    }
  }
  
  public int getPanelId()
  {
    return 8;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a();
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
      a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    a(paramXPanelContainer);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PlusPanelProvider
 * JD-Core Version:    0.7.0.1
 */