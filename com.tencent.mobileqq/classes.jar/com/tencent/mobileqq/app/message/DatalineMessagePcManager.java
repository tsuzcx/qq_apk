package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;

public class DatalineMessagePcManager
  extends DatalineMessageManager
{
  public DatalineMessagePcManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.jdField_a_of_type_JavaLangString = AppConstants.y;
    this.jdField_a_of_type_Int = 6000;
  }
  
  protected DataLineMsgProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
  }
  
  protected void a()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessagePcManager
 * JD-Core Version:    0.7.0.1
 */