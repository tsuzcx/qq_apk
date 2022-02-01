package com.tencent.mobileqq.activity.aio.voicetextpanel.utils;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;

public class BaseChatPieCompatibleUtils
{
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) {
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.c(false);
    }
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
    }
    paramBaseChatPie.as();
  }
  
  public static void b(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) {
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.c(true);
    }
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
    }
    paramBaseChatPie.ar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.utils.BaseChatPieCompatibleUtils
 * JD-Core Version:    0.7.0.1
 */