package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.gameparty.GamePartyObserver;

class TroopChatPie$27
  extends GamePartyObserver
{
  TroopChatPie$27(TroopChatPie paramTroopChatPie) {}
  
  public void a()
  {
    if (((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar, new Object[0]);
    }
  }
  
  public void b()
  {
    if (((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar.a();
    }
  }
  
  public void c()
  {
    if ((((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == 14)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.27
 * JD-Core Version:    0.7.0.1
 */