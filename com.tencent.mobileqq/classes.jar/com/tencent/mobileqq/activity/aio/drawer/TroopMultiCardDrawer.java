package com.tencent.mobileqq.activity.aio.drawer;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopMultiCardHelper;
import com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.multicard.MultiCardContainer;
import com.tencent.qphone.base.util.QLog;

public class TroopMultiCardDrawer
  extends BaseChatDrawer
{
  private MultiCardContainer jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer;
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopMultiCardDrawer(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void a(String paramString)
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).m(paramString)) {
      c(false);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    TroopMultiCardHelper localTroopMultiCardHelper = (TroopMultiCardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(31);
    if (localTroopMultiCardHelper != null) {
      localTroopMultiCardHelper.e();
    }
    TroopDNANavBar.e();
  }
  
  protected View a()
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer = new TroopMultiCardDrawer.1(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer.a();
    return this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer.a();
  }
  
  public void b()
  {
    MultiCardContainer localMultiCardContainer = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer;
    if (localMultiCardContainer != null) {
      localMultiCardContainer.b();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer != null) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer.a();
      return true;
    }
    return false;
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerStartOpen", new Object[0]));
    }
    MultiCardContainer localMultiCardContainer = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer;
    if (localMultiCardContainer != null) {
      localMultiCardContainer.a();
    }
    m();
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    MultiCardContainer localMultiCardContainer = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer;
    if (localMultiCardContainer != null) {
      localMultiCardContainer.c();
    }
  }
  
  public void k()
  {
    MultiCardContainer localMultiCardContainer = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer;
    if (localMultiCardContainer != null)
    {
      localMultiCardContainer.d();
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContainer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.TroopMultiCardDrawer
 * JD-Core Version:    0.7.0.1
 */