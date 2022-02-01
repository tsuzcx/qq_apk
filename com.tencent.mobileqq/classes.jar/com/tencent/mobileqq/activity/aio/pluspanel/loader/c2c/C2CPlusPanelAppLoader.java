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
  protected boolean a;
  
  protected C2CPlusPanelAppLoader()
  {
    this.jdField_a_of_type_Boolean = false;
    a(new C2CCommonAppInfoOrderFilter());
    a(new QavWTFilter());
  }
  
  private PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    PluginData localPluginData = new PluginData();
    localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPlusPanelAppInfo);
    localPluginData.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.c = String.valueOf(paramPlusPanelAppInfo.getRedDotID());
    localPluginData.e = paramPlusPanelAppInfo.actionType;
    localPluginData.d = paramPlusPanelAppInfo.action;
    localPluginData.jdField_a_of_type_JavaLangString = a(paramPlusPanelAppInfo);
    localPluginData.jdField_b_of_type_JavaLangString = (localPluginData.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131708286));
    return localPluginData;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a();
    if (localQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
    }
    do
    {
      return;
      if (paramSessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
    return;
    b(paramBaseChatPie);
    ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
  }
  
  private PluginData b(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    PluginData localPluginData = new PluginData();
    localPluginData.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.e = paramPlusPanelAppInfo.actionType;
    localPluginData.d = paramPlusPanelAppInfo.action;
    localPluginData.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getTitle();
    localPluginData.jdField_b_of_type_JavaLangString = (localPluginData.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131708286));
    if (paramPlusPanelAppInfo.getAppID() == 209)
    {
      localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = AioPanelMiniAppManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      localPluginData.jdField_a_of_type_JavaLangString = MiniAppConfProcessor.a().g();
      if (paramPlusPanelAppInfo.getAppID() != 204) {
        break label182;
      }
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localPluginData.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getTitle() + HardCodeUtil.a(2131708294));
      return localPluginData;
      localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(paramPlusPanelAppInfo.defaultDrawableID());
      break;
      label182:
      if (paramPlusPanelAppInfo.getAppID() == 209) {
        localPluginData.jdField_a_of_type_Boolean = AioPanelMiniAppManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      } else {
        localPluginData.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return a(paramBaseChatPie, paramPlusPanelAppInfo);
    }
    return b(paramBaseChatPie, paramPlusPanelAppInfo);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a(paramBaseChatPie, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected abstract void b(BaseChatPie paramBaseChatPie);
  
  protected void c(int paramInt)
  {
    if (SimpleUIUtil.a())
    {
      a(paramInt, 217);
      a(paramInt, 218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.C2CPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */