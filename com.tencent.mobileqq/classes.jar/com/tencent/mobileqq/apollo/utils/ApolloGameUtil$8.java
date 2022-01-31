package com.tencent.mobileqq.apollo.utils;

import aleh;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameRankData;
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
      ((aleh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager(), localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.8
 * JD-Core Version:    0.7.0.1
 */