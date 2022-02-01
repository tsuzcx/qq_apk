package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.hotpic.HotPicManager;

public class SelfPlusPanelAppLoader
  extends C2CPlusPanelAppLoader
{
  protected void b(BaseChatPie paramBaseChatPie)
  {
    c(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 203);
    if (HotPicManager.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 204);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 219);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 205);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 206);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.SelfPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */