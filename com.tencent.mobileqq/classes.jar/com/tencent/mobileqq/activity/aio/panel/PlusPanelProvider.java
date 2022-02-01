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
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class PlusPanelProvider
  implements PanelProvider<PlusPanel>
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PlusPanel jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
  
  public PlusPanelProvider(BaseChatPie paramBaseChatPie)
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel = ((PlusPanel)View.inflate(paramContext, 2131558565, null));
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    paramContext.a(localBaseChatPie, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("OpenIconPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, paramContext.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
  }
  
  public void a()
  {
    Object localObject = ((SingTogetherConfigBean)QConfigManager.a().a(551)).a(4);
    if ((localObject != null) && (((SingTogetherConfigBean.GeneralTogetherItem)localObject).d > 0))
    {
      int i;
      if (((SingTogetherConfigBean.GeneralTogetherItem)localObject).c == 1) {
        i = 1109995692;
      } else {
        i = ((SingTogetherConfigBean.GeneralTogetherItem)localObject).d;
      }
      ((FetchOpenIdManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, true);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPlusPanel;
    if (localObject != null) {
      ((PlusPanel)localObject).a();
    }
    localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (((IRedTouchManager)localObject).getRedTouchInfoByAppSet(10, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ((PlusRedPointHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(89)).a()) != null)) {
      ((IRedTouchManager)localObject).reportLevelZeroRedInfo(10, 31);
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    if (!paramTroopChatPie.u()) {
      ReportController.b(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    Object localObject = (GiftPanelHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(136);
    if (((GiftPanelHelper)localObject).a == null) {
      ((GiftPanelHelper)localObject).a = new AIOGiftPanelContainer(paramTroopChatPie);
    }
    localObject = ((GiftPanelHelper)localObject).a;
    int j = TroopGiftPanel.e;
    int i;
    if (AnonymousChatHelper.a().a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      i = 4;
    } else {
      i = 1;
    }
    ((AIOGiftPanelContainer)localObject).a(j, i);
    ((ITroopAioAppService)paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopAioAppService.class, "")).getAppsInObserver(GroupUtil.a(paramTroopChatPie.d()));
    paramTroopChatPie = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramTroopChatPie.getRedTouchInfoByAppSet(11, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ((PlusRedPointHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(89)).a()) != null)) {
      paramTroopChatPie.reportLevelZeroRedInfo(11, 31);
    }
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    ((FastImageHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(83)).b();
    paramXPanelContainer.a(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.h(0);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004078", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramXPanelContainer = (IEarlyDownloadService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    if (paramXPanelContainer != null)
    {
      paramXPanelContainer = (PokeResHandler)paramXPanelContainer.getEarlyHandler("qq.android.poke.res_0625");
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
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie instanceof TroopChatPie)) {
      a((TroopChatPie)localBaseChatPie);
    }
    a(paramXPanelContainer);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie)) {
      a();
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PlusPanelProvider
 * JD-Core Version:    0.7.0.1
 */