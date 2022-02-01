package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutHelper;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutDrawer
  extends BaseChatDrawer
{
  private TroopAppShortcutContainer jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer;
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopAppShortcutDrawer(BaseChatPie paramBaseChatPie)
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
    TroopAppShortcutHelper localTroopAppShortcutHelper = (TroopAppShortcutHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(55);
    if (localTroopAppShortcutHelper != null) {
      localTroopAppShortcutHelper.e();
    }
    TroopAppShortcutNavBar.e();
  }
  
  protected View a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer = new TroopAppShortcutDrawer.1(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), 1);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
    return this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) && (a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer != null) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer.a();
      return true;
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer;
    if (localTroopAppShortcutContainer != null) {
      localTroopAppShortcutContainer.a(paramInt);
    }
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerStartOpen", new Object[0]));
    }
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer;
    if (localTroopAppShortcutContainer != null) {
      localTroopAppShortcutContainer.a();
    }
    m();
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened", new Object[0]));
    }
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer;
    if (localTroopAppShortcutContainer != null) {
      localTroopAppShortcutContainer.b();
    }
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer;
    if (localObject1 != null) {
      ((TroopAppShortcutContainer)localObject1).c();
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a == null) || (!TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.a)))) {
        break label180;
      }
      localObject1 = (TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
      Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((TroopManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.a);
      if (localObject2 == null) {
        return;
      }
      if (localObject1 == null) {
        break label180;
      }
      ((TroopShortcutBarHandler)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.a), (int)((TroopInfo)localObject2).dwGroupClassExt, null);
      return;
    }
    catch (Exception localException)
    {
      label159:
      break label159;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("parseLong Exception", new Object[0]));
    }
    label180:
  }
  
  public void k()
  {
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer;
    if (localTroopAppShortcutContainer != null)
    {
      localTroopAppShortcutContainer.g();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer
 * JD-Core Version:    0.7.0.1
 */