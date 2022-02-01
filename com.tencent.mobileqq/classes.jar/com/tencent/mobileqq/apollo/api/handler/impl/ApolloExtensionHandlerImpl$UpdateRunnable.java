package com.tencent.mobileqq.apollo.api.handler.impl;

import com.tencent.mobileqq.app.BusinessObserver;

class ApolloExtensionHandlerImpl$UpdateRunnable
  implements Runnable
{
  BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  Object jdField_a_of_type_JavaLangObject;
  boolean jdField_a_of_type_Boolean;
  
  public ApolloExtensionHandlerImpl$UpdateRunnable(BusinessObserver paramBusinessObserver, boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = paramBusinessObserver;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl.UpdateRunnable
 * JD-Core Version:    0.7.0.1
 */