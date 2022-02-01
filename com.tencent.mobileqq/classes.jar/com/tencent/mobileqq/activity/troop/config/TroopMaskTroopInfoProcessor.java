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
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoHandlerProcessor;
import com.tencent.mobileqq.utils.DBUtils;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class TroopMaskTroopInfoProcessor
  extends AbsTroopInfoHandlerProcessor
{
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = new ArrayList();
    Setting localSetting = new Setting();
    localSetting.Path = ("message.group.policy." + paramString);
    localSetting.Value = String.valueOf(paramInt);
    ((ArrayList)localObject).add(localSetting);
    DBUtils.a().a((ArrayList)localObject, paramQQAppInterface);
    localObject = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
    if (localObject != null)
    {
      localObject = ((ProxyManager)localObject).a();
      paramInt = paramQQAppInterface.getTroopMask(paramString);
      if (paramInt != 2) {
        break label135;
      }
      TroopAssistantManager.a().a(paramString, paramQQAppInterface);
    }
    for (;;)
    {
      paramString = paramQQAppInterface.getHandler(Conversation.class);
      if (paramString != null)
      {
        paramString.sendEmptyMessage(1009);
        paramQQAppInterface.refreshAppBadge();
      }
      return;
      label135:
      TroopAssistantManager.a().c(paramString, paramQQAppInterface);
      if ((paramInt == 3) && (localObject != null))
      {
        paramString = ((RecentUserProxy)localObject).b(paramString, 1);
        if (paramString != null)
        {
          ((RecentUserProxy)localObject).a(paramString);
          RecentDataListManager.a().a(paramString.uin + "-" + paramString.getType());
          ((RecentUserProxy)localObject).a(paramString);
          RecentUtil.b(paramQQAppInterface, paramString.uin, 1);
          paramQQAppInterface.getMessageFacade().c(paramString.uin, paramString.getType());
        }
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