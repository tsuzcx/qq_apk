package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c;

import android.content.res.Resources;
import com.tencent.av.wtogether.util.QavWTFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.filter.C2CCommonAppInfoOrderFilter;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class C2CPlusPanelAppLoader
  extends PlusPanelAppLoader
{
  protected boolean f = false;
  
  protected C2CPlusPanelAppLoader()
  {
    a(new C2CCommonAppInfoOrderFilter());
    a(new QavWTFilter());
  }
  
  private PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    PluginData localPluginData = new PluginData();
    localPluginData.k = a(paramBaseChatPie.d, paramPlusPanelAppInfo);
    localPluginData.a = paramPlusPanelAppInfo.getAppID();
    localPluginData.b = paramPlusPanelAppInfo.getAppID();
    localPluginData.f = String.valueOf(paramPlusPanelAppInfo.getRedDotID());
    localPluginData.h = paramPlusPanelAppInfo.actionType;
    localPluginData.g = paramPlusPanelAppInfo.action;
    localPluginData.d = a(paramPlusPanelAppInfo);
    paramBaseChatPie = new StringBuilder();
    paramBaseChatPie.append(localPluginData.d);
    paramBaseChatPie.append(HardCodeUtil.a(2131906085));
    localPluginData.e = paramBaseChatPie.toString();
    return localPluginData;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.i();
    if (localQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
      return;
    }
    if (paramSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
      }
      return;
    }
    b(paramBaseChatPie);
    ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
  }
  
  private PluginData b(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    PluginData localPluginData = new PluginData();
    localPluginData.a = paramPlusPanelAppInfo.getAppID();
    localPluginData.b = paramPlusPanelAppInfo.getAppID();
    localPluginData.h = paramPlusPanelAppInfo.actionType;
    localPluginData.g = paramPlusPanelAppInfo.action;
    localPluginData.d = paramPlusPanelAppInfo.getTitle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localPluginData.d);
    localStringBuilder.append(HardCodeUtil.a(2131906085));
    localPluginData.e = localStringBuilder.toString();
    if (paramPlusPanelAppInfo.getAppID() == 209)
    {
      localPluginData.k = AioPanelMiniAppManager.a(paramBaseChatPie.d).c();
      localPluginData.d = MiniAppConfProcessor.a().o();
    }
    else
    {
      localPluginData.k = BaseApplicationImpl.getContext().getResources().getDrawable(paramPlusPanelAppInfo.defaultDrawableID());
    }
    if (paramPlusPanelAppInfo.getAppID() == 204)
    {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    else if (paramPlusPanelAppInfo.getAppID() == 209) {
      localPluginData.c = AioPanelMiniAppManager.a(paramBaseChatPie.d).d();
    } else {
      localPluginData.c = false;
    }
    paramBaseChatPie = new StringBuilder();
    paramBaseChatPie.append(paramPlusPanelAppInfo.getTitle());
    paramBaseChatPie.append(HardCodeUtil.a(2131906093));
    localPluginData.e = paramBaseChatPie.toString();
    return localPluginData;
  }
  
  public PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    if (this.f) {
      return a(paramBaseChatPie, paramPlusPanelAppInfo);
    }
    return b(paramBaseChatPie, paramPlusPanelAppInfo);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a(paramBaseChatPie, paramBaseChatPie.ah);
    a(paramBaseChatPie.d, paramBaseChatPie.ah.a, paramBaseChatPie.ah.b);
  }
  
  protected abstract void b(BaseChatPie paramBaseChatPie);
  
  protected void d(int paramInt)
  {
    if (SimpleUIUtil.e())
    {
      a(paramInt, 217);
      a(paramInt, 218);
    }
  }
  
  public boolean d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.C2CPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */