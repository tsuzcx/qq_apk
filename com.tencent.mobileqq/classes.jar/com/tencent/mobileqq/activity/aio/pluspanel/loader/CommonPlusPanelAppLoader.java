package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class CommonPlusPanelAppLoader
  extends PlusPanelAppLoader
{
  public PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    PluginData localPluginData = new PluginData();
    if (paramPlusPanelAppInfo.getAppID() == 213) {
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    localPluginData.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getAppName();
    localPluginData.e = paramPlusPanelAppInfo.actionType;
    localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPlusPanelAppInfo);
    if (localPluginData.jdField_b_of_type_Int == 204) {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localPluginData.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getAppName() + HardCodeUtil.a(2131708294));
      return localPluginData;
      if (localPluginData.jdField_b_of_type_Int == 209) {
        localPluginData.jdField_a_of_type_Boolean = AioPanelMiniAppManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      } else if (paramPlusPanelAppInfo.getAppID() == 101761547) {
        localPluginData.jdField_a_of_type_Boolean = ListenTogetherUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false);
      } else {
        localPluginData.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    b(paramBaseChatPie);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void b(BaseChatPie paramBaseChatPie) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.CommonPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */