package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.IntimateInfoView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoChatDrawer
  extends BaseChatDrawer
{
  private IntimateInfoView jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public IntimateInfoChatDrawer(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void m() {}
  
  protected View a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView = new IntimateInfoChatDrawer.1(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a() == null) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(1);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.d();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.m();
      }
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.b = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.f();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.e();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null)
    {
      if (a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.m();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.h();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.i();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer
 * JD-Core Version:    0.7.0.1
 */