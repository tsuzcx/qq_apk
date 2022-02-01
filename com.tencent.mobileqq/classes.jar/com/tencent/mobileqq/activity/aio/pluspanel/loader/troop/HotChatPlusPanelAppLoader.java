package com.tencent.mobileqq.activity.aio.pluspanel.loader.troop;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class HotChatPlusPanelAppLoader
  extends TroopPlusPanelAppLoader
{
  public PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    PluginData localPluginData = new PluginData();
    if (paramPlusPanelAppInfo.getAppID() == 1104874204) {
      this.a = (paramInt / 8);
    }
    localPluginData.b = paramPlusPanelAppInfo.getAppID();
    localPluginData.a = paramPlusPanelAppInfo.getAppID();
    localPluginData.d = paramPlusPanelAppInfo.getAppName();
    localPluginData.h = paramPlusPanelAppInfo.actionType;
    localPluginData.k = a(paramBaseChatPie.d, paramPlusPanelAppInfo);
    if (localPluginData.b == 1107930043)
    {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    else if (paramPlusPanelAppInfo.getAppID() == 101761547) {
      localPluginData.c = ListenTogetherUtils.a(paramBaseChatPie.d, "listen_together_c2c_aio_red_dot_show", true, false);
    } else {
      localPluginData.c = false;
    }
    paramBaseChatPie = new StringBuilder();
    paramBaseChatPie.append(paramPlusPanelAppInfo.getAppName());
    paramBaseChatPie.append(HardCodeUtil.a(2131906093));
    localPluginData.e = paramBaseChatPie.toString();
    return localPluginData;
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    if (((HotChatManager)paramBaseChatPie.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).h(paramBaseChatPie.ah.b)) {
      a(paramBaseChatPie.ah.a, 1200000000);
    }
    a(paramBaseChatPie.ah.a, 1104864068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.HotChatPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */