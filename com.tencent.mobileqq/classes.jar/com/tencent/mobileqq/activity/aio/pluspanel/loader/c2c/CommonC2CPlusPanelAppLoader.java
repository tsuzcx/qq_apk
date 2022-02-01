package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader.ScribbleResMgrShowConfig;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkMsgAIDisableConfBean;
import com.tencent.mobileqq.ark.config.config.ArkMsgAIDisableConfig;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CommonC2CPlusPanelAppLoader
  extends C2CPlusPanelAppLoader
{
  private void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    b(paramBaseChatPie, paramQQAppInterface);
    c(paramBaseChatPie, paramQQAppInterface);
    c(paramBaseChatPie);
    d(paramBaseChatPie, paramQQAppInterface);
    QLog.d("CommonC2CPlusPanelAppLoader", 1, new Object[] { "fillDefaultAppInfo appInfo size: ", Integer.valueOf(b()) });
  }
  
  private void a(BaseChatPie paramBaseChatPie, List<PlusPanelAppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)paramList.next();
        if (localPlusPanelAppInfo.getAppID() == 215)
        {
          IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all");
          if ((localIApolloManagerService.isApolloSupport(paramBaseChatPie.f, Boolean.valueOf(false))) && (localIApolloManagerService.queryStatusInConfig("aio", null) > 0)) {
            b(localPlusPanelAppInfo);
          }
        }
        else
        {
          b(localPlusPanelAppInfo);
        }
      }
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    d(paramBaseChatPie.ah.a);
    a(paramBaseChatPie.ah.a, 201);
    a(paramBaseChatPie.ah.a, 202);
    a(paramBaseChatPie.ah.a, 203);
    if (HotPicManager.a(paramQQAppInterface).j()) {
      a(paramBaseChatPie.ah.a, 204);
    }
    a(paramBaseChatPie.ah.a, 219);
    if ((AioPanelMiniAppManager.a(paramQQAppInterface).b()) && (SimpleUIUtil.e())) {
      a(paramBaseChatPie.ah.a, 209);
    }
    a(paramBaseChatPie.ah.a, 205);
    a(paramBaseChatPie.ah.a, 206);
    a(paramBaseChatPie.ah.a, 207);
    if ((AioPanelMiniAppManager.a(paramQQAppInterface).b()) && (!SimpleUIUtil.e())) {
      a(paramBaseChatPie.ah.a, 209);
    }
    a(paramBaseChatPie.ah.a, 208);
  }
  
  private void c(BaseChatPie paramBaseChatPie)
  {
    ArkMsgAIDisableConfBean localArkMsgAIDisableConfBean = (ArkMsgAIDisableConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkMsgAIDisableConfBean.class);
    if ((localArkMsgAIDisableConfBean != null) && (localArkMsgAIDisableConfBean.b() != null) && (!localArkMsgAIDisableConfBean.b().a)) {
      a(paramBaseChatPie.ah.a, 1000000001);
    }
  }
  
  private void c(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if (this.e.a(paramBaseChatPie.aX(), paramQQAppInterface.getCurrentAccountUin())) {
      a(paramBaseChatPie.ah.a, 210);
    }
    a(paramBaseChatPie.ah.a, 1000000006);
    a(paramBaseChatPie.ah.a, 211);
    a(paramBaseChatPie.ah.a, 212);
    a(paramBaseChatPie.ah.a, 213);
    if (ReceiptUtil.a()) {
      a(paramBaseChatPie.ah.a, 216);
    }
    if (((TeamWorkManager)paramQQAppInterface.getManager(QQManagerFactory.TEAMWORK_MANAGER)).a().booleanValue())
    {
      a(paramBaseChatPie.ah.a, 214);
      AIOPanelUtiles.a(paramQQAppInterface, "0X80093F3", paramBaseChatPie.ah.a);
    }
    try
    {
      paramQQAppInterface = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if ((paramQQAppInterface.isApolloSupport(paramBaseChatPie.e, Boolean.valueOf(false))) && (paramQQAppInterface.queryStatusInConfig("aio", null) > 0))
      {
        a(paramBaseChatPie.ah.a, 215);
        return;
      }
    }
    catch (Exception paramBaseChatPie)
    {
      QLog.e("CommonC2CPlusPanelAppLoader", 2, "[addSecondScreenApp] apollo error! ", paramBaseChatPie);
    }
  }
  
  private void d(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface.getAccount() != null) && (paramQQAppInterface.getAccount().equals(paramBaseChatPie.ah.b)))
    {
      a(paramBaseChatPie.ah.a, 211);
      a(paramBaseChatPie.ah.a, 203);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.f)
    {
      PlusPanelAppInfo localPlusPanelAppInfo = C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(paramInt2);
      if (localPlusPanelAppInfo != null)
      {
        b(localPlusPanelAppInfo);
        return;
      }
    }
    super.a(paramInt1, paramInt2);
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
    this.f = false;
    List localList = C2CPlusPanelAppConfigHelper.INSTANCE.getC2CAppInfo();
    if (!localList.isEmpty())
    {
      this.f = true;
      a(paramBaseChatPie, localList);
      QLog.d("CommonC2CPlusPanelAppLoader", 1, new Object[] { "fillAppList appear manage config, appInfoList size: ", Integer.valueOf(localList.size()), ", after adapt size: ", Integer.valueOf(b()) });
      return;
    }
    a(paramBaseChatPie, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.CommonC2CPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */