package com.tencent.mobileqq.app;

import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import mqq.manager.Manager;

public class ContactFacade
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FetchBuddyAndTroopNameHelper jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper;
  public Object a;
  
  public ContactFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public FetchBuddyAndTroopNameHelper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper = new FetchBuddyAndTroopNameHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchBuddyAndTroopNameHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactFacade
 * JD-Core Version:    0.7.0.1
 */