package com.tencent.mobileqq.apollo.handler;

import com.tencent.mobileqq.app.BusinessObserver;

class ApolloExtensionHandler$UpdateRunnable
  implements Runnable
{
  BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  Object jdField_a_of_type_JavaLangObject;
  boolean jdField_a_of_type_Boolean;
  
  public ApolloExtensionHandler$UpdateRunnable(BusinessObserver paramBusinessObserver, boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = paramBusinessObserver;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void run()
  {
    BusinessObserver localBusinessObserver = this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
    if (localBusinessObserver != null) {
      localBusinessObserver.onUpdate(0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler.UpdateRunnable
 * JD-Core Version:    0.7.0.1
 */