package com.tencent.mobileqq.activity.aio.drawer;

import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.gamecenter.message.GameMsgAppContainer;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAppDrawer
  extends BaseChatDrawer
{
  private GameMsgAppContainer a;
  
  public GameMsgAppDrawer(GameMsgChatPie paramGameMsgChatPie)
  {
    super(paramGameMsgChatPie);
  }
  
  protected View a()
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer = new GameMsgAppDrawer.1(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, (GameMsgChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer.a() == null) {}
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer.a();
  }
  
  public void b() {}
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer != null) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer.a();
      return true;
    }
    return false;
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDrawerStartOpen");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer.a();
    }
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDrawerOpened");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer.b();
    }
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDrawerClosed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer.c();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer.d();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgAppContainer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.GameMsgAppDrawer
 * JD-Core Version:    0.7.0.1
 */