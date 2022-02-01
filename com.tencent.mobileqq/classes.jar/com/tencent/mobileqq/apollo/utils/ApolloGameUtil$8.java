package com.tencent.mobileqq.apollo.utils;

import amir;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import java.util.ArrayList;

final class ApolloGameUtil$8
  implements Runnable
{
  ApolloGameUtil$8(QQAppInterface paramQQAppInterface, ApolloGameRankData paramApolloGameRankData) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloGameRankData != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameRankData);
      ((amir)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager(), localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.8
 * JD-Core Version:    0.7.0.1
 */