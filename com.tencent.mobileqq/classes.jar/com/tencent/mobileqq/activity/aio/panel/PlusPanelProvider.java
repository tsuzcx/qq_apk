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
  private BaseChatPie a;
  private PlusPanel b;
  
  public PlusPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public PlusPanel a()
  {
    return this.b;
  }
  
  public PlusPanel a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.b = ((PlusPanel)View.inflate(paramContext, 2131624122, null));
    paramContext = this.b;
    BaseChatPie localBaseChatPie = this.a;
    paramContext.a(localBaseChatPie, localBaseChatPie.ah);
    AIODtReportHelper.a(this.a, this.b);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("OpenIconPanel:");
      paramContext.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, paramContext.toString());
    }
    return this.b;
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    if (!paramTroopChatPie.bF()) {
      ReportController.b(paramTroopChatPie.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, paramTroopChatPie.ah.b, "", "", "");
    }
    Object localObject = (GiftPanelHelper)this.a.q(136);
    if (((GiftPanelHelper)localObject).e == null) {
      ((GiftPanelHelper)localObject).e = new AIOGiftPanelContainer(paramTroopChatPie);
    }
    localObject = ((GiftPanelHelper)localObject).e;
    int j = TroopGiftPanel.e;
    int i;
    if (AnonymousChatHelper.a().a(paramTroopChatPie.ah.b)) {
      i = 4;
    } else {
      i = 1;
    }
    ((AIOGiftPanelContainer)localObject).a(j, i);
    ((ITroopAioAppService)paramTroopChatPie.d.getRuntimeService(ITroopAioAppService.class, "")).getAppsInObserver(GroupUtil.a(paramTroopChatPie.ag()));
    paramTroopChatPie = (IRedTouchManager)this.a.d.getRuntimeService(IRedTouchManager.class, "");
    if ((this.a.ah != null) && (paramTroopChatPie.getRedTouchInfoByAppSet(11, this.a.ah.c, ((PlusRedPointHelper)this.a.q(89)).a()) != null)) {
      paramTroopChatPie.reportLevelZeroRedInfo(11, 31);
    }
  }
  
  public void a(XPanelContainer paramXPanelContainer)
  {
    ((FastImageHelper)this.a.q(83)).c();
    paramXPanelContainer.a(8);
    this.a.m(0);
    AIOPanelUtiles.a(this.a.d, "0X8004078", this.a.ah.a);
    paramXPanelContainer = (IEarlyDownloadService)this.a.d.getRuntimeService(IEarlyDownloadService.class, "");
    if (paramXPanelContainer != null)
    {
      paramXPanelContainer = (PokeResHandler)paramXPanelContainer.getEarlyHandler("qq.android.poke.res_0625");
      if ((paramXPanelContainer != null) && (!paramXPanelContainer.r())) {
        paramXPanelContainer.a(false);
      }
    }
  }
  
  public void b()
  {
    Object localObject = ((SingTogetherConfigBean)QConfigManager.b().b(551)).a(4);
    if ((localObject != null) && (((SingTogetherConfigBean.GeneralTogetherItem)localObject).f > 0))
    {
      int i;
      if (((SingTogetherConfigBean.GeneralTogetherItem)localObject).e == 1) {
        i = 1109995692;
      } else {
        i = ((SingTogetherConfigBean.GeneralTogetherItem)localObject).f;
      }
      ((FetchOpenIdManager)this.a.d.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.a.ah.b), i, true);
    }
    localObject = this.b;
    if (localObject != null) {
      ((PlusPanel)localObject).a();
    }
    localObject = (IRedTouchManager)this.a.d.getRuntimeService(IRedTouchManager.class, "");
    if ((this.a.ah != null) && (((IRedTouchManager)localObject).getRedTouchInfoByAppSet(10, this.a.ah.c, ((PlusRedPointHelper)this.a.q(89)).a()) != null)) {
      ((IRedTouchManager)localObject).reportLevelZeroRedInfo(10, 31);
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
    if (this.a.W != null) {
      this.a.W.getPlusRedTouchAndUpdate();
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie instanceof TroopChatPie)) {
      a((TroopChatPie)localBaseChatPie);
    }
    a(paramXPanelContainer);
    if ((this.a instanceof FriendChatPie)) {
      b();
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PlusPanelProvider
 * JD-Core Version:    0.7.0.1
 */