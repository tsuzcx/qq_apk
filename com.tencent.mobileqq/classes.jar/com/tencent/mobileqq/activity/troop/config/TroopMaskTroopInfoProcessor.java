package com.tencent.mobileqq.activity.troop.config;

import GeneralSettings.Setting;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoHandlerProcessor;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class TroopMaskTroopInfoProcessor
  extends AbsTroopInfoHandlerProcessor
{
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new Setting();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message.group.policy.");
    localStringBuilder.append(paramString);
    ((Setting)localObject2).Path = localStringBuilder.toString();
    ((Setting)localObject2).Value = String.valueOf(paramInt);
    ((ArrayList)localObject1).add(localObject2);
    ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettings((ArrayList)localObject1, paramQQAppInterface);
    localObject1 = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
    if (localObject1 != null)
    {
      localObject1 = ((ProxyManager)localObject1).g();
      paramInt = paramQQAppInterface.getTroopMask(paramString);
      if (paramInt == 2)
      {
        TroopAssistantManager.a().a(paramString, paramQQAppInterface);
      }
      else
      {
        TroopAssistantManager.a().c(paramString, paramQQAppInterface);
        if ((paramInt == 3) && (localObject1 != null))
        {
          paramString = ((RecentUserProxy)localObject1).c(paramString, 1);
          if (paramString != null)
          {
            ((RecentUserProxy)localObject1).a(paramString);
            localObject2 = RecentDataListManager.a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString.uin);
            localStringBuilder.append("-");
            localStringBuilder.append(paramString.getType());
            ((RecentDataListManager)localObject2).b(localStringBuilder.toString());
            ((RecentUserProxy)localObject1).a(paramString);
            RecentUtil.b(paramQQAppInterface, paramString.uin, 1);
            paramQQAppInterface.getMessageFacade().a(paramString.uin, paramString.getType());
          }
        }
      }
    }
    paramString = paramQQAppInterface.getHandler(Conversation.class);
    if (paramString != null)
    {
      paramString.sendEmptyMessage(1009);
      if (paramQQAppInterface.isLogin()) {
        ((IAppBadgeService)paramQQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (paramGroupInfo.uint32_cmduin_new_mobile_flag.has())) {
      a((QQAppInterface)paramAppInterface, paramTroopInfo.troopuin, paramGroupInfo.uint32_cmduin_new_mobile_flag.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMaskTroopInfoProcessor
 * JD-Core Version:    0.7.0.1
 */