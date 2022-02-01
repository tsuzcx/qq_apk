package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.gameparty.GamePartyObserver;

class FriendTipsHelper$2
  extends GamePartyObserver
{
  FriendTipsHelper$2(FriendTipsHelper paramFriendTipsHelper) {}
  
  protected void a()
  {
    if (((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar, new Object[0]);
    }
  }
  
  protected void b()
  {
    if (((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar.a();
    }
  }
  
  protected void c()
  {
    if ((((GamePartyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() == 14)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendTipsHelper.2
 * JD-Core Version:    0.7.0.1
 */