package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class CommonPlusPanelAppLoader
  extends PlusPanelAppLoader
{
  private void a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildLiveChannelChatPie(paramBaseChatPie)) {
      paramPlusPanelAppInfo.guildLiveChannel = true;
    }
  }
  
  public PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    PluginData localPluginData = new PluginData();
    if (paramPlusPanelAppInfo.getAppID() == 213) {
      this.a = (paramInt / 8);
    }
    localPluginData.b = paramPlusPanelAppInfo.getAppID();
    localPluginData.a = paramPlusPanelAppInfo.getAppID();
    localPluginData.d = paramPlusPanelAppInfo.getAppName();
    localPluginData.h = paramPlusPanelAppInfo.actionType;
    a(paramBaseChatPie, paramPlusPanelAppInfo);
    localPluginData.k = a(paramBaseChatPie.d, paramPlusPanelAppInfo);
    localPluginData.j = paramPlusPanelAppInfo.getDTElementId();
    if (localPluginData.b == 204)
    {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    else if (localPluginData.b == 209) {
      localPluginData.c = AioPanelMiniAppManager.a(paramBaseChatPie.d).d();
    } else if (paramPlusPanelAppInfo.getAppID() == 101761547) {
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
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    b(paramBaseChatPie);
    a(paramBaseChatPie.d, paramBaseChatPie.ah.a, paramBaseChatPie.ah.b);
  }
  
  protected void b(BaseChatPie paramBaseChatPie) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.CommonPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */