package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import androidx.annotation.CallSuper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class ITroopNotificationController
{
  protected QQAppInterface a;
  protected final String a;
  
  public ITroopNotificationController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public abstract void a();
  
  @CallSuper
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clearAllMsgCache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.ITroopNotificationController
 * JD-Core Version:    0.7.0.1
 */