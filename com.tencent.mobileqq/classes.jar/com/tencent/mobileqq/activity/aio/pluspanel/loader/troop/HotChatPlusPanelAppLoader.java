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
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    localPluginData.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getAppName();
    localPluginData.e = paramPlusPanelAppInfo.actionType;
    localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPlusPanelAppInfo);
    if (localPluginData.jdField_b_of_type_Int == 1107930043) {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localPluginData.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getAppName() + HardCodeUtil.a(2131708294));
      return localPluginData;
      if (paramPlusPanelAppInfo.getAppID() == 101761547) {
        localPluginData.jdField_a_of_type_Boolean = ListenTogetherUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "listen_together_c2c_aio_red_dot_show", true, false);
      } else {
        localPluginData.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    if (((HotChatManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1200000000);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1104864068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.HotChatPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */