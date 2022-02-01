package com.tencent.mobileqq.apollo;

import amme;
import amog;
import amoh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;

public class ApolloResponseManager$1$1
  implements Runnable
{
  public ApolloResponseManager$1$1(amoh paramamoh, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Amoh.a.a == null) {
      return;
    }
    ((amme)this.jdField_a_of_type_Amoh.a.a.getManager(QQManagerFactory.APOLLO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloResponseManager.1.1
 * JD-Core Version:    0.7.0.1
 */