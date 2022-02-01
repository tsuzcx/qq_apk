package com.tencent.mobileqq.activity.aio.pluspanel.loader.troop;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.app.HardCodeUtil;

public abstract class TroopPlusPanelAppLoader
  extends PlusPanelAppLoader
{
  public PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    PluginData localPluginData = new PluginData();
    localPluginData.k = a(paramBaseChatPie.d, paramPlusPanelAppInfo);
    localPluginData.a = paramPlusPanelAppInfo.getAppID();
    localPluginData.b = paramPlusPanelAppInfo.getAppID();
    localPluginData.f = String.valueOf(localPluginData.b);
    localPluginData.h = paramPlusPanelAppInfo.actionType;
    localPluginData.g = paramPlusPanelAppInfo.action;
    localPluginData.d = a(paramPlusPanelAppInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localPluginData.d);
    localStringBuilder.append(HardCodeUtil.a(2131906085));
    localPluginData.e = localStringBuilder.toString();
    localPluginData.i = paramBaseChatPie.ah.c;
    int i = paramPlusPanelAppInfo.getAppID();
    if ((i == 1104864062) || (i == 101761547) || (i == 101793773) || (i == 101817424)) {
      localPluginData.c = paramPlusPanelAppInfo.redPoint;
    }
    if (i == 1104874204) {
      this.a = (paramInt / 8);
    }
    return localPluginData;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    b(paramBaseChatPie);
    a(paramBaseChatPie.d, paramBaseChatPie.ah.a, paramBaseChatPie.ah.b);
  }
  
  protected abstract void b(BaseChatPie paramBaseChatPie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.TroopPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */