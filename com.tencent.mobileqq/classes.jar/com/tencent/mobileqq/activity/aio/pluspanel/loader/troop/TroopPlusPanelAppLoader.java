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
    localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPlusPanelAppInfo);
    localPluginData.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localPluginData.c = String.valueOf(localPluginData.jdField_b_of_type_Int);
    localPluginData.e = paramPlusPanelAppInfo.actionType;
    localPluginData.d = paramPlusPanelAppInfo.action;
    localPluginData.jdField_a_of_type_JavaLangString = a(paramPlusPanelAppInfo);
    localPluginData.jdField_b_of_type_JavaLangString = (localPluginData.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131708286));
    localPluginData.f = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    int i = paramPlusPanelAppInfo.getAppID();
    if ((i == 1104864062) || (i == 101761547) || (i == 101793773) || (i == 101817424)) {
      localPluginData.jdField_a_of_type_Boolean = paramPlusPanelAppInfo.redPoint;
    }
    if (i == 1104874204) {
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    return localPluginData;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    b(paramBaseChatPie);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected abstract void b(BaseChatPie paramBaseChatPie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.TroopPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */